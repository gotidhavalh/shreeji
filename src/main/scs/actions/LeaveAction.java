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
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import main.scs.common.ListDesignation;
import main.scs.dao.DBConnection;
import main.scs.dto.LeaveDTO;

/**
 * Servlet implementation class LeaveAction
 */
public class LeaveAction
{
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(AssetAction.class);
	ServletContext context;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LeaveAction()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public void listLeave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// List<LeaveDTO> leavelist = new ArrayList<>();
		// List<EmployeeDTO> emplist = new ArrayList<>();
		// try (Connection connection = DBConnection.getDBConnection();
		// PreparedStatement pstlist = connection.prepareStatement("select Leaves.ID,Employee.FirstName, Leaves.EmpCode, Leaves.FromDate, Leaves.ToDate, Leaves.Approvername, Leaves.status from Leaves join Employee on Leaves.EmpCode= Employee.EmpCode order by currDate desc"))
		// {
		// ResultSet rslist = pstlist.executeQuery();
		// while (rslist.next())
		// {
		// LeaveDTO list = new LeaveDTO();
		// list.setID(rslist.getInt("ID"));
		// list.setEmpName(rslist.getString("FirstName"));
		// list.setEmpCode(rslist.getInt("EmpCode"));
		// list.setFromDate(rslist.getDate("FromDate"));
		// list.setToDate(rslist.getDate("ToDate"));
		// list.setApproverName(rslist.getString("Approvername"));
		// list.setStatus(rslist.getString("status"));
		// leavelist.add(list);
		// }
		//
		// }
		// catch (Exception e)
		// {
		// logger.error(" Exception in listLeave of MainController - " + e.getLocalizedMessage(), e);
		// }
		// request.setAttribute("leavelist", leavelist);
		// request.setAttribute("emplist", emplist);
		// request.setAttribute("leavelist", ListDesignation.listLeave());
		request.getRequestDispatcher("/WEB-INF/pages/leave/datatableForLeave.jsp").forward(request, response);
	}

	public void listLeaveJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		JSONObject json = new JSONObject();

		JSONArray array = new JSONArray();

		List<LeaveDTO> leaveList = ListDesignation.listLeave();

		int i = 1;
		for (LeaveDTO leave : leaveList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			String row_id = "row_" + i;
			map.put("DT_RowId", row_id);
			map.put("ID", leave.getID());
			map.put("EmpName", leave.getEmpName());
			map.put("EmpCode", leave.getEmpCode());
			map.put("FromDate", leave.getFromDate());
			map.put("ToDate", leave.getToDate());
			map.put("ApproverName", leave.getApproverName());
			map.put("Status", leave.getStatus());

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
			logger.error(" Error while parsing JSON Format in getAssetListJSON - " + e.getMessage(), e);

			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Something wrong occured while parsing leave list JSON. Error - " + e.getLocalizedMessage());
		}

	}

	public void addLeave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException
	{
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstAdd = connection.prepareStatement("INSERT INTO Leaves(EmpCode, ToDate,FromDate, NoofDays, Days,Reason,status)VALUES(?,?,?,?,?,?,?)");)
		{
			LeaveDTO leave = new LeaveDTO();
			leave.setEmpCode(Integer.parseInt(request.getParameter("empcode")));
			String fromDate = request.getParameter("fromDate");
			String toDate = request.getParameter("toDate");
			String day = request.getParameter("Day");
			leave.setReason(request.getParameter("reason"));

			java.util.Date fromDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("fromDate"));
			leave.setFromDate(new java.sql.Date(fromDate1.getTime()));

			java.util.Date toDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("toDate"));
			leave.setToDate(new java.sql.Date(toDate1.getTime()));

			String f = fromDate.replace("/", " ");
			String t = toDate.replace("/", " ");
			SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
			Date from = myFormat.parse(f);
			Date to = myFormat.parse(t);
			long diff = to.getTime() - from.getTime();
			float noOfDays = (diff / (1000 * 60 * 60 * 24));
			leave.setNoofDays(noOfDays + 1);
			if (noOfDays < 0)
			{
				request.getSession().setAttribute("responseType", "fail");
				request.getSession().setAttribute("responseMessage", "Please Enter Valuble Date");
				request.getRequestDispatcher("/WEB-INF/pages/leave/addLeave.jsp").forward(request, response);
			}
			else
			{
				if (day.equalsIgnoreCase("halfDay") && fromDate.equals(toDate))
				{
					leave.setDay(day);
					leave.setNoofDays((float) 0.5);
				}
				else
				{
					leave.setDay(day);
				}
				String status = "Pending";

				pstAdd.setInt(1, leave.getEmpCode());
				pstAdd.setDate(3, leave.getFromDate());
				pstAdd.setDate(2, leave.getToDate());
				pstAdd.setDouble(4, leave.getNoofDays());
				pstAdd.setString(5, leave.getDay());
				pstAdd.setString(6, leave.getReason());
				pstAdd.setString(7, status);
				pstAdd.executeUpdate();

				request.getSession().setAttribute("responseType", "success");
				request.getSession().setAttribute("responseMessage", " Leave record has added successfully.");
				request.getRequestDispatcher("/WEB-INF/pages/leave/datatableForLeave.jsp").forward(request, response);
			}
		}
		catch (Exception e)
		{
			logger.error(" Exception in addLeave of LeaveAction - " + e.getLocalizedMessage(), e);
			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Something wrong occured while adding leave record. Error - " + e.getLocalizedMessage());
			request.getRequestDispatcher("/WEB-INF/pages/leave/datatableForLeave.jsp").forward(request, response);
		}

	}

	public void viewLeave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		List<LeaveDTO> list = new ArrayList<>();
		int id = Integer.parseInt(request.getParameter("id").trim());
		int empCode = Integer.parseInt(request.getParameter("empcode").trim());
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstList = connection.prepareStatement("SELECT Leaves.ID, Leaves.EmpCode, Employee.FirstName, Leaves.ToDate, Leaves.FromDate, Leaves.noofDays, Leaves.Days, Leaves.reason, Leaves.status FROM Employee join Leaves on Leaves.ID = ? and Employee.EmpCode = ?");)
		{
			pstList.setInt(1, id);
			pstList.setInt(2, empCode);
			ResultSet rsList = pstList.executeQuery();
			while (rsList.next())
			{
				LeaveDTO leaveList = new LeaveDTO();
				leaveList.setID(rsList.getInt("ID"));
				leaveList.setEmpCode(rsList.getInt("EmpCode"));
				leaveList.setEmpName(rsList.getString("FirstName"));
				leaveList.setToDate(rsList.getDate("ToDate"));
				leaveList.setFromDate(rsList.getDate("FromDate"));
				leaveList.setNoofDays(rsList.getFloat("noofDays"));
				leaveList.setDay(rsList.getString("Days"));
				leaveList.setReason(rsList.getString("Reason"));
				leaveList.setStatus(rsList.getString("status"));
				list.add(leaveList);
			}

			request.setAttribute("leaveview", list);
			request.getRequestDispatcher("/WEB-INF/pages/leave/viewLeave.jsp").forward(request, response);
		}
		catch (Exception e)
		{
			logger.error(" Exception in viewLeave of LeaveAction - " + e.getLocalizedMessage(), e);
			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", " Something wrong occured while viewing Leave record. Error - " + e.getLocalizedMessage());
		}

	}

	public void editLeave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstUpdate = connection.prepareStatement("UPDATE Leaves set status = ?, Approvername = ?  WHERE id = ?");)
		{
			HttpSession session = request.getSession();
			String name = session.getAttribute("User").toString();
			// String name = (String) request.getSession().getAttribute("User");
			// String name = "test";

			int id = Integer.parseInt(request.getParameter("id"));
			String status = request.getParameter("status");

			pstUpdate.setString(1, status);
			pstUpdate.setString(2, name);
			pstUpdate.setInt(3, id);
			pstUpdate.executeUpdate();

			request.getSession().setAttribute("responseType", "success");
			request.getSession().setAttribute("responseMessage", " View record has updated successfully. ");
		}
		catch (Exception e)
		{
			logger.error(" Exception in editLeave of LeaveAction - " + e.getLocalizedMessage(), e);

			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", " Something wring occured while editing leave record. Error - " + e.getLocalizedMessage());
		}
		// request.setAttribute("leavelist", ListDesignation.listLeave());
		request.getRequestDispatcher("/WEB-INF/pages/leave/datatableForLeave.jsp").forward(request, response);

	}

	public void autoAddLeave(int empCode, String day, Date date, HttpServletRequest request)
	{
		String reason = "Punch";
		String status = "Approved";
		float noofDays = 0;
		String approverName = "System";
		if (day.equalsIgnoreCase("FullDay"))
		{

			noofDays = 1;
		}
		else if (day.equalsIgnoreCase("HalfDay"))
		{
			noofDays = 0.5f;
		}
		java.sql.Date date1 = new java.sql.Date(date.getTime());
		System.out.println(date1);
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstAdd = connection.prepareStatement("INSERT INTO Leaves(EmpCode, ToDate, FromDate, NoofDays, Days, Reason, status, Approvername)VALUES(?,?,?,?,?,?,?,?)");)
		{
			pstAdd.setInt(1, empCode);
			pstAdd.setDate(2, date1);
			pstAdd.setDate(3, date1);
			pstAdd.setFloat(4, noofDays);
			pstAdd.setString(5, day);
			pstAdd.setString(6, reason);
			pstAdd.setString(7, status);
			pstAdd.setString(8, approverName);
			pstAdd.executeUpdate();

			// request.getSession().setAttribute("responseType", "success");
			// request.getSession().setAttribute("responseMessage", " Auto Leave calculation success. ");

		}
		catch (Exception e)
		{
			logger.error(" Exception in autoaddLeave of LeaveAction - " + e.getLocalizedMessage(), e);

			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", " Something wring occured while autoAdd Leave. Error - " + e.getLocalizedMessage());
		}

	}
}
