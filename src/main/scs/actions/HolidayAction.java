package main.scs.actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import main.scs.dao.DBConnection;
import main.scs.dto.HoliDayDTO;

/**
 * Servlet implementation class Holiday
 */

public class HolidayAction
{
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(AssetAction.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HolidayAction()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void listHoliDays(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/pages/holiday/datatableForHoliday.jsp").forward(request, response);
	}

	public void listHoliDayJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		JSONObject json = new JSONObject();

		JSONArray array = new JSONArray();

		List<HoliDayDTO> holidayList = ListDesignation.listHoliDay();

		int i = 1;
		for (HoliDayDTO holiday : holidayList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			String row_id = "row_" + i;
			map.put("DT_RowId", row_id);
			map.put("ID", holiday.getId());
			map.put("HolidayName", holiday.getHoliDayName());
			map.put("Day", holiday.getDay());
			map.put("Date", holiday.getDate());

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
			logger.error(" Error while parsing JSON Format in listHoliDay JSON - " + e.getMessage(), e);

			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Something wrong occured while parsing holiday JSON. Error - " + e.getLocalizedMessage());
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws ParseException
	 * @throws ServletException
	 * @throws IOException
	 */
	public void addHoliDays(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException
	{
		String days = request.getParameter("days");

		java.util.Date next = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("date"));
		// emp.setNextIncrement(new java.sql.Date(next.getTime()));

		String holiDayName = request.getParameter("holiName");
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstInsertholiDay = connection.prepareStatement("INSERT INTO Holidays (Days, Holidate, Holiname) VALUES(?,?,?)");)
		{
			pstInsertholiDay.setString(1, days);
			pstInsertholiDay.setDate(2, new java.sql.Date(next.getTime()));

			pstInsertholiDay.setString(3, holiDayName);
			pstInsertholiDay.executeUpdate();

			request.getSession().setAttribute("responseType", "success");
			request.getSession().setAttribute("responseMessage", "Holiday added successfully.");

		}
		catch (Exception e)
		{
			logger.error(" Exception in addHoliDays of MainController - " + e.getLocalizedMessage(), e);
			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Something wrong occured while adding holiday. Error - " + e.getLocalizedMessage());
		}
		request.getRequestDispatcher("/WEB-INF/pages/holiday/datatableForHoliday.jsp").forward(request, response);
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void viewHoliDays(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<HoliDayDTO> list = new ArrayList<>();

		int id = Integer.parseInt(request.getParameter("id").trim());
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstView = connection.prepareStatement("SELECT ID, Days, Holidate, Holiname FROM Holidays WHERE id = ?");)
		{
			pstView.setInt(1, id);
			ResultSet rsView = pstView.executeQuery();
			while (rsView.next())
			{
				HoliDayDTO hDay = new HoliDayDTO();
				hDay.setId(rsView.getInt("ID"));
				hDay.setDay(rsView.getString("Days"));
				hDay.setDate(rsView.getDate("Holidate"));
				hDay.setHoliDayName(rsView.getString("Holiname"));
				list.add(hDay);
			}

		}
		catch (Exception e)
		{
			logger.error(" Exception in viewHoliDays of MainController - " + e.getLocalizedMessage(), e);
		}
		request.setAttribute("listdays", list);
		request.getRequestDispatcher("/WEB-INF/pages/holiday/editHoliday.jsp").include(request, response);
	}

	/**
	 * @param request
	 * @param response
	 * @throws ParseException
	 * @throws ServletException
	 * @throws IOException
	 */
	public void editHoliDays(HttpServletRequest request, HttpServletResponse response) throws ParseException, ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String days = request.getParameter("days");
		String date = request.getParameter("date");
		// java.util.Date next = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("date"));

		String dateReplace = date.replace("-", "/");
		java.util.Date dateParse;
		dateParse = new SimpleDateFormat("dd/MM/yyyy").parse(dateReplace);

		String holiDayName = request.getParameter("holiName");
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstEdit = connection.prepareStatement("UPDATE Holidays SET Days = ?, Holidate = ?, Holiname = ? WHERE ID =?");)
		{
			pstEdit.setString(1, days);
			pstEdit.setDate(2, new java.sql.Date(dateParse.getTime()));
			pstEdit.setString(3, holiDayName);
			pstEdit.setInt(4, id);
			pstEdit.executeUpdate();

			request.getSession().setAttribute("responseType", "success");
			request.getSession().setAttribute("responseMessage", "Holiday edited successfully.");
		}
		catch (Exception e)
		{
			logger.error(" Exception in editHoliDays of MainController - " + e.getLocalizedMessage(), e);

			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Something wrong occured while editing holiday. Error - " + e.getLocalizedMessage());
		}
		request.getRequestDispatcher("/WEB-INF/pages/holiday/datatableForHoliday.jsp").forward(request, response);

	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteHoliDays(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstDelete = connection.prepareStatement("DELETE FROM Holidays WHERE ID = ?"))
		{
			pstDelete.setInt(1, id);
			pstDelete.executeUpdate();

			request.getSession().setAttribute("responseType", "success");
			request.getSession().setAttribute("responseMessage", "Holiday deleted successfully.");
		}
		catch (Exception e)
		{
			logger.error(" Exception in deleteHoliDays of MainController - " + e.getLocalizedMessage(), e);

			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Something wrong occured while deleting holiday. Error - " + e.getLocalizedMessage());
		}
		request.getRequestDispatcher("/WEB-INF/pages/holiday/datatableForHoliday.jsp").forward(request, response);
	}

}
