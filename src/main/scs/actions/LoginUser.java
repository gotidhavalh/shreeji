package main.scs.actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import main.scs.common.CommonConstants;
import main.scs.dao.DBConnection;

/**
 * Servlet implementation class LoginUser
 */
public class LoginUser
{
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(LoginUser.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUser()
	{

	}

	public void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int empcode;
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		if (password.equals("") || userName.equals(""))
		{
			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Please enter username and password.");
			request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
		}
		else
		{
			try (Connection connection = DBConnection.getDBConnection();
					PreparedStatement pstcheck = connection.prepareStatement("SELECT EmpCode, username, password FROM Employee where username = ?");)
			{
				pstcheck.setString(1, userName);
				ResultSet rs = pstcheck.executeQuery();
				if (rs.next())
				{
					empcode = rs.getInt("EmpCode");
					// session.setAttribute("SesionuserID", empcode);
					String passwordHash = CommonConstants.getPasswordHash(password);
					String dbpassword = rs.getString("password");
					if (!(dbpassword.equals(passwordHash)))
					{
						request.getSession().setAttribute("responseType", "fail");
						request.getSession().setAttribute("responseMessage", "Please enter correct password for this username.");
						request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
					}
					else
					{
						request.getSession().setAttribute("User", userName);
						request.getSession().setAttribute("EmpCode", empcode);
						request.getSession().setAttribute("SessionUser", userName);
						request.setAttribute("pageTitle", "DashBoard");
						request.getRequestDispatcher("/WEB-INF/pages/sidebarTemplate.jsp").forward(request, response);
					}
				}
				else
				{
					request.getSession().setAttribute("responseType", "fail");
					request.getSession().setAttribute("responseMessage", "Please enter correct username.");
					request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
				}

			}
			catch (Exception e)
			{
				logger.error(" Error while checkUser in LoginUser " + e.getMessage(), e);
			}
		}

	}

}
