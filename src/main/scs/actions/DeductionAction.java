package main.scs.actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import main.scs.common.ListDesignation;
import main.scs.common.QuartzJob;
import main.scs.dao.DBConnection;
import main.scs.dto.DeductionDTO;

/**
 * Servlet implementation class Deduction
 */
public class DeductionAction
{
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(QuartzJob.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeductionAction()
	{
		super();

	}

	public void addDeduction(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException
	{
		int empCode = Integer.parseInt(request.getParameter("empCode"));
		float pf;
		if (request.getParameter("pf") == null || request.getParameter("pf").equals(""))
		{
			pf = 0;
		}
		else
		{
			pf = Float.parseFloat(request.getParameter("pf"));
		}
		float tds;
		if (request.getParameter("tds") == null || request.getParameter("tds").equals(""))
		{
			tds = 0;
		}
		else
		{
			tds = Float.parseFloat(request.getParameter("tds"));
		}

		float leaveDeduct;
		if (request.getParameter("leaveDeduct") == null || request.getParameter("leaveDeduct").equals(""))
		{
			leaveDeduct = 0;
		}
		else
		{
			leaveDeduct = Float.parseFloat(request.getParameter("leaveDeduct"));
		}

		float assetDeduct;
		if (request.getParameter("assetDeduct") == null || request.getParameter("assetDeduct").equals(""))
		{
			assetDeduct = 0;
		}
		else
		{
			assetDeduct = Float.parseFloat(request.getParameter("assetDeduct"));
		}
		float other;
		if (request.getParameter("other") == null || request.getParameter("other").equals(""))
		{
			other = 0;
		}
		else
		{
			other = Float.parseFloat(request.getParameter("other"));
		}
		String date = request.getParameter("date");
		if (date == null || date.equals(""))
		{
			SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
			Date date1 = new Date();
			date = formatter.format(date1);
		}

		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstadd = connection.prepareStatement("INSERT INTO Deduction(EmpCode, PF, TDS, Leaves, Asset, Other,Month)VALUES(?,?,?,?,?,?,?)");)
		{
			pstadd.setInt(1, empCode);
			pstadd.setFloat(2, pf);
			pstadd.setFloat(3, tds);
			pstadd.setFloat(4, leaveDeduct);
			pstadd.setFloat(5, assetDeduct);
			pstadd.setFloat(6, other);
			pstadd.setString(7, date);
			pstadd.executeUpdate();

		}
		catch (Exception e)
		{
			e.printStackTrace();
			logger.error(" Error in addDeduction of Deduction - " + e.getMessage(), e);
		}
		request.getRequestDispatcher("/WEB-INF/pages/deduction/listDeduction.jsp").forward(request, response);
	}

	public void listDeduction(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException
	{
		request.setAttribute("deductlist", ListDesignation.listDeduction());
		request.getRequestDispatcher("/WEB-INF/pages/deduction/listDeduction.jsp").forward(request, response);

	}

	public void listDeductionJSON(HttpServletRequest request, HttpServletResponse response)
	{

		JSONObject json = new JSONObject();

		JSONArray array = new JSONArray();

		List<DeductionDTO> deductList = ListDesignation.listDeduction();

		int i = 1;
		for (DeductionDTO deduct : deductList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			String row_id = "row_" + i;
			map.put("DT_RowId", row_id);
			map.put("EmpCode", deduct.getEmpCode());
			map.put("ID", deduct.getId());
			map.put("FirstName", deduct.getName());
			map.put("Leave", deduct.getLeaveDeduct());
			map.put("Asset", deduct.getAssetDeduct());
			map.put("EmpCode", deduct.getEmpCode());

			array.add(map);
			i = i + 1;
		}

		json.put("data", array);

		System.out.println(" JSON -  " + json.toJSONString());

		Gson gson = new Gson();
		response.setContentType("application/json");
		try
		{
			response.getWriter().write(gson.toJson(json));
		}
		catch (Exception e)
		{
			logger.error(" Error while parsing JSON Format - " + e.getMessage(), e);
		}
	}

	public void viewDeduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String view = request.getParameter("view");
		int id = Integer.parseInt(request.getParameter("id"));
		List<DeductionDTO> deductList = new ArrayList<>();
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT d.ID,e.EmpCode, e.FirstName, d.PF, d.TDS, d.Leaves, d.Asset, d.Other,d.Month, d.year FROM Deduction as d join Employee as e where e.EmpCode = d.EmpCode and d.ID= ?");)
		{
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				DeductionDTO list = new DeductionDTO();
				list.setId(rs.getInt("ID"));
				list.setEmpCode(rs.getInt("EmpCode"));
				list.setName(rs.getString("FirstName"));
				list.setPf(rs.getFloat("PF"));
				list.setTds(rs.getFloat("TDS"));
				list.setLeaveDeduct(rs.getFloat("Leaves"));
				list.setAssetDeduct(rs.getFloat("Asset"));
				list.setOther(rs.getFloat("Other"));
				list.setMonth(rs.getString("Month"));
				list.setYear(rs.getInt("year"));
				deductList.add(list);
			}

			// request.getRequestDispatcher("/WEB-INF/pages/deduction/viewDeduction.jsp").forward(request, response);
		}
		catch (Exception e)
		{
			logger.error(" Error while parsing JSON Format - " + e.getMessage(), e);
		}
		request.setAttribute("deductlist", deductList);
		if (view.equalsIgnoreCase("view"))
		{
			request.getRequestDispatcher("/WEB-INF/pages/deduction/viewDeduction.jsp").forward(request, response);
		}
		else if (view.equalsIgnoreCase("edit"))
		{
			request.getRequestDispatcher("/WEB-INF/pages/deduction/editDeduction.jsp").forward(request, response);
		}

	}

	public void editDeduction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		float pf = Float.parseFloat(request.getParameter("pf"));
		float tds;
		if (request.getParameter("tds") == null || request.getParameter("tds").equals(""))
		{
			tds = 0;
		}
		else
		{
			tds = Float.parseFloat(request.getParameter("tds"));
		}

		float leaveDeduct;
		if (request.getParameter("leaveDeduct") == null || request.getParameter("leaveDeduct").equals(""))
		{
			leaveDeduct = 0;
		}
		else
		{
			leaveDeduct = Float.parseFloat(request.getParameter("leaveDeduct"));
		}

		float assetDeduct;
		if (request.getParameter("assetDeduct") == null || request.getParameter("assetDeduct").equals(""))
		{
			assetDeduct = 0;
		}
		else
		{
			assetDeduct = Float.parseFloat(request.getParameter("assetDeduct"));
		}
		float other;
		if (request.getParameter("other") == null || request.getParameter("other").equals(""))
		{
			other = 0;
		}
		else
		{
			other = Float.parseFloat(request.getParameter("other"));
		}
		String date = request.getParameter("date");
		if (date == null || date.equals(""))
		{
			SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
			Date date1 = new Date();
			date = formatter.format(date1);
		}
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstEdit = connection.prepareStatement("UPDATE Deduction SET PF = ?, TDS = ?, Leaves= ?, Asset = ?, Other = ?, Month = ? , WHERE ID =?"))
		{
			pstEdit.setFloat(1, pf);
			pstEdit.setFloat(2, tds);
			pstEdit.setFloat(3, leaveDeduct);
			pstEdit.setFloat(4, assetDeduct);
			pstEdit.setFloat(5, other);
			pstEdit.setString(6, date);
			// pstEdit.setInt(7, year);
			pstEdit.setInt(8, id);
			pstEdit.executeUpdate();

		}
		catch (Exception e)
		{
			logger.error(" MainController - editDeduction - " + e.getMessage(), e);
		}
		request.setAttribute("deductlist", ListDesignation.listDeduction());
		request.getRequestDispatcher("/WEB-INF/pages/deduction/listDeduction.jsp").forward(request, response);
	}

	public void deleteDeducttion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstDelete = connection.prepareStatement("DELETE FROM Deduction WHERE ID = ?");)
		{
			pstDelete.setInt(1, id);
			pstDelete.executeUpdate();

		}
		catch (Exception e)
		{
			logger.error(" MainController - editDeduction - " + e.getMessage(), e);
		}
		request.setAttribute("deductlist", ListDesignation.listDeduction());
		request.getRequestDispatcher("/WEB-INF/pages/deduction/listDeduction.jsp").forward(request, response);
	}
}
