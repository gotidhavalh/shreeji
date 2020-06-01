package main.scs.actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import main.scs.dao.DBConnection;

/**
 * Servlet implementation class CheckUserName
 */
@WebServlet("/CheckUserName")
public class CheckUserName extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(CheckUserName.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckUserName()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Map<String, Object> map = new HashMap<>();
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstcheck = connection.prepareStatement("SELECT EmpCode FROM Employee where EmpCode = ?"))
		{
			int userCode = Integer.parseInt(request.getParameter("userCode").trim());
			pstcheck.setInt(1, userCode);
			ResultSet rs = pstcheck.executeQuery();
			if (rs.next())
			{
				userCode = rs.getInt("EmpCode");
				map.put("userCode", userCode);
			}
		}
		catch (Exception e)
		{
			logger.error(" Error in doGet of CheckUserName " + e.getMessage(), e);
		}
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.getWriter().write(gson.toJson(map));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Map<String, Object> map = new HashMap<>();
		String user = request.getParameter("username");
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstcheck = connection.prepareStatement("SELECT username FROM Employee where username = ?");)
		{
			pstcheck.setString(1, user);
			ResultSet rs = pstcheck.executeQuery();
			if (rs.next())
			{
				user = rs.getString("username");
				map.put("usernm", user);
			}
			else
			{
				user = null;
				map.put("usernm", user);
			}
		}
		catch (Exception e)
		{
			logger.error(" Error in doPost of CheckUserName " + e.getMessage(), e);
		}
		Gson gson = new Gson();
		response.setContentType("application/json");
		response.getWriter().write(gson.toJson(map));
	}

}
