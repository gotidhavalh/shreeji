package main.scs.actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import main.scs.common.ListDesignation;
import main.scs.dao.DBConnection;
import main.scs.dto.AllowenceDTO;

/**
 * Servlet implementation class AllowenceAction
 */

public class AllowenceAction
{
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(AllowenceAction.class);

	public AllowenceAction()
	{
		super();
	}

	public void listAllowence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/pages/allowence/listAllowence.jsp").forward(request, response);

	}

	public void listAllowenceJson(HttpServletRequest request, HttpServletResponse response)
	{
		JSONObject json = new JSONObject();

		JSONArray array = new JSONArray();

		List<AllowenceDTO> allowList = ListDesignation.listAllowence();

		int i = 1;
		for (AllowenceDTO allow : allowList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			String row_id = "row_" + i;
			map.put("DT_RowId", row_id);
			map.put("ID", allow.getId());
			map.put("EmpCode", allow.getEmpCode());
			map.put("Name", allow.getName());
			map.put("Fual", allow.getFual());
			map.put("OverTime", allow.getOverTime());
			map.put("Month", allow.getMonth());
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

	public void addAllowence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int empCode = Integer.parseInt(request.getParameter("empCode"));
		float fual;
		if (request.getParameter("fual") == null || request.getParameter("fual").equals(""))
		{
			fual = 0;
		}
		else
		{
			fual = Float.parseFloat(request.getParameter("fual"));
		}
		float overTime;
		if (request.getParameter("overtime") == null || request.getParameter("overtime").equals(""))
		{
			overTime = 0;
		}
		else
		{
			overTime = Float.parseFloat(request.getParameter("fual"));
		}
		String date = request.getParameter("date");
		if (date == null || date.equals(""))
		{
			SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
			Date date1 = new Date();
			date = formatter.format(date1);
		}

		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstAdd = connection.prepareStatement("INSERT INTO Allowence(EmpCode, Fual, OverTime, month) VALUES (?,?,?,?)");)
		{

			pstAdd.setInt(1, empCode);
			pstAdd.setFloat(2, fual);
			pstAdd.setFloat(3, overTime);
			pstAdd.setString(4, date);
			pstAdd.executeUpdate();

		}
		catch (Exception e)
		{
			logger.error(" Error while parsing JSON Format - " + e.getMessage(), e);

		}
		request.getRequestDispatcher("/WEB-INF/pages/allowence/listAllowence.jsp").forward(request, response);

	}

	public void viewAllowence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String view = request.getParameter("view");
		int id = Integer.parseInt(request.getParameter("id"));
		List<AllowenceDTO> allowList = new ArrayList<>();

		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstView = connection.prepareStatement("SELECT a.ID, a.EmpCode, e.FirstName, a.Fual, a.OverTime, a.month, a.year FROM Allowence a join Employee as e on a.EmpCode = e.EmpCode and a.ID= ?"))
		{
			pstView.setInt(1, id);
			ResultSet rsView = pstView.executeQuery();
			while (rsView.next())
			{
				AllowenceDTO list = new AllowenceDTO();
				list.setId(rsView.getInt("ID"));
				list.setEmpCode(rsView.getInt("EmpCode"));
				list.setName(rsView.getString("FirstName"));
				list.setFual(rsView.getFloat("Fual"));
				list.setOverTime(rsView.getFloat("OverTime"));
				list.setMonth(rsView.getString("month"));
				list.setYear(rsView.getInt("year"));
				allowList.add(list);
			}
		}
		catch (Exception e)
		{
			logger.error(" Error In MainController ,viewAllowence method - " + e.getMessage(), e);
		}
		if (view.equalsIgnoreCase("view"))
		{

			request.setAttribute("allowlist", allowList);
			request.getRequestDispatcher("/WEB-INF/pages/allowence/viewAllowence.jsp").forward(request, response);
		}
		else if (view.equalsIgnoreCase("edit"))
		{
			request.setAttribute("allowlist", allowList);
			request.getRequestDispatcher("/WEB-INF/pages/allowence/editAllowence.jsp").forward(request, response);

		}
	}

	public void editAllowence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		float fual;
		if (request.getParameter("fual") == null || request.getParameter("fual").equals(""))
		{
			fual = 0;
		}
		else
		{
			fual = Float.parseFloat(request.getParameter("fual"));
		}
		float overTime;
		if (request.getParameter("overtime") == null || request.getParameter("overtime").equals(""))
		{
			overTime = 0;
		}
		else
		{
			overTime = Float.parseFloat(request.getParameter("fual"));
		}
		String date = request.getParameter("date");
		if (date == null || date.equals(""))
		{
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			Date date1 = new Date();
			date = formatter.format(date1);
		}
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstEdit = connection.prepareStatement("UPDATE Allowence SET Fual = ?, OverTime = ?, month = ?, year = ? WHERE ID = ?"))
		{
			pstEdit.setFloat(1, fual);
			pstEdit.setFloat(2, overTime);
			pstEdit.setString(3, date);
			pstEdit.setInt(5, id);
			pstEdit.executeUpdate();
		}
		catch (Exception e)
		{
			logger.error(" Error In MainController ,editAllowence method - " + e.getMessage(), e);

		}
		request.getRequestDispatcher("/WEB-INF/pages/allowence/listAllowence.jsp").forward(request, response);
	}

	public void deleteAllowence(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		int id = Integer.parseInt(request.getParameter("id"));
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstDelete = connection.prepareStatement("DELETE FROM Allowence WHERE ID = ?"))
		{
			pstDelete.setInt(1, id);
			pstDelete.executeUpdate();

		}
		catch (Exception e)
		{
			logger.error(" Error In MainController ,editAllowence method - " + e.getMessage(), e);
		}
		request.getRequestDispatcher("/WEB-INF/pages/allowence/listAllowence.jsp").forward(request, response);
	}

}
