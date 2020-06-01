package main.scs.actions;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import main.scs.dao.DBConnection;

/**
 * Servlet implementation class test
 */
public class VerifySalary
{
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(VerifySalary.class);
	boolean status = true;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerifySalary()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public void test1(HttpServletRequest request, HttpServletResponse response)
	{
		String id = request.getParameter("empcode");
		String[] q = request.getParameterValues("test");
		for (String s : q)
		{
			System.out.println(s);
		}

	}

	public void verifyAllRecord(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
	{
		String[] salaryID = null;
		try
		{
			salaryID = request.getParameterValues("test");

		}
		catch (NullPointerException e)
		{
			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Salary record All Ready Verfired.");
			request.getRequestDispatcher("/WEB-INF/pages/salary/listSalary.jsp").forward(request, response);
		}
		try
		{
			if (!(salaryID == null || salaryID.equals("")))
			{

				String query = "UPDATE Salary SET Status = ? WHERE ID IN (";
				for (int i = 0; i < salaryID.length - 1; i++)
				{
					query += salaryID[i] + ",";
				}
				query += salaryID[salaryID.length - 1] + ")";
				try (Connection connection = DBConnection.getDBConnection();
						PreparedStatement pstUpdateAll = connection.prepareStatement(query);)
				{
					pstUpdateAll.setBoolean(1, status);
					pstUpdateAll.executeUpdate();

					request.getSession().setAttribute("responseType", "success");
					request.getSession().setAttribute("responseMessage", "Salary record All Ready Verfired.");

					request.getRequestDispatcher("/WEB-INF/pages/salary/listSalary.jsp").forward(request, response);
				}
				catch (NullPointerException e)
				{
					request.getRequestDispatcher("/WEB-INF/pages/salary/listSalary.jsp").forward(request, response);
					logger.error(" Error while parsing JSON Format - " + e.getMessage(), e);

				}
			}
			else
			{
				request.getSession().setAttribute("responseType", "fail");
				request.getSession().setAttribute("responseMessage", "Salary record All Ready Verfired.");
				request.getRequestDispatcher("/WEB-INF/pages/salary/listSalary.jsp").forward(request, response);

			}

		}
		catch (Exception e)
		{
			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Salary record All Ready Verfired.");
			request.getRequestDispatcher("/WEB-INF/pages/salary/listSalary.jsp").forward(request, response);
		}
	}

	public void singleRecordVerification(HttpServletRequest request, HttpServletResponse response)
	{
		int id = Integer.parseInt(request.getParameter("ID").trim());
		float salary = Float.parseFloat(request.getParameter("salary"));
		float deduct = Float.parseFloat(request.getParameter("deduct"));
		float netSalary = Float.parseFloat(request.getParameter("netSalary"));
		String paymentType = request.getParameter("paymentType");
		String chequeNo = request.getParameter("Cheque").trim();
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstUpdate = connection.prepareStatement("UPDATE Salary set SalaryType = ?, Currentsalary = ?, SalaryDeduction = ?, Netsalary= ?, Status = ? , ChequeNo = ? WHERE ID = ?");)
		{
			pstUpdate.setString(1, paymentType);
			pstUpdate.setFloat(2, salary);
			pstUpdate.setFloat(3, deduct);
			pstUpdate.setFloat(4, netSalary);
			pstUpdate.setBoolean(5, status);
			pstUpdate.setString(6, chequeNo);
			pstUpdate.setInt(7, id);
			pstUpdate.executeUpdate();

			request.getSession().setAttribute("responseType", "success");
			request.getSession().setAttribute("responseMessage", "Salary record has been verified successfully.");

		}
		catch (Exception e)
		{
			logger.error(" Salary record verification is un-successful - " + e.getMessage(), e);
			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Salary record verification is un-successful.");
		}

	}

}
