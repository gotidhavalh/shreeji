package main.scs.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import main.scs.dao.DBConnection;

public class QuartzJob extends HttpServlet implements Job
{
	Logger logger = Logger.getLogger(QuartzJob.class);
	HttpServletRequest request;

	public float totalDays = 26;

	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		Date now = new Date();
		int totalHoliDays = 0;
		SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy-MM");
		System.out.println("Calculation Start of Salary : " + simpleDateformat.format(now));

		Calendar originalDate = Calendar.getInstance();
		Calendar previousMonthDay = (Calendar) originalDate.clone();
		previousMonthDay.add(Calendar.MONTH, -1);

		String formattedDate = simpleDateformat.format(previousMonthDay.getTime());
		System.out.println(formattedDate);

		Calendar aCalendar = Calendar.getInstance();
		aCalendar.add(Calendar.MONTH, -1);
		aCalendar.set(Calendar.DATE, 1);

		SimpleDateFormat simpleDateformat1 = new SimpleDateFormat("yyyy-MM-dd");
		String firstDateOfPreviousMonth = simpleDateformat1.format(aCalendar.getTime());
		System.out.println(firstDateOfPreviousMonth);

		aCalendar.set(Calendar.DATE, aCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));

		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstUpdateStatus = connection.prepareStatement("SELECT ID FROM Salary WHERE Status = 'false'"))
		{
			ResultSet rsUpdateStatus = pstUpdateStatus.executeQuery();
			while (rsUpdateStatus.next())
			{
				int id = rsUpdateStatus.getInt("ID");
				boolean status = true;
				try (Connection conUpdate = DBConnection.getDBConnection();
						PreparedStatement pstUpdate = conUpdate.prepareStatement("UPDATE Salary SET Status= ? WHERE ID = ?"))
				{
					pstUpdate.setBoolean(1, status);
					pstUpdate.setInt(2, id);
					pstUpdate.executeUpdate();

				}
				catch (Exception e)
				{
					logger.error(" Exception in Updating salary status - QuartzJob class  - " + e.getLocalizedMessage(), e);
				}
			}

		}
		catch (Exception e)
		{
			logger.error(" Exception in Selecting salary status - QuartzJob class  - " + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}

		String lastDateOfPreviousMonth = simpleDateformat1.format(aCalendar.getTime());
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstHoliday = connection.prepareStatement("SELECT count(ID)as Total from Holidays where Holidate like ?");)
		{
			pstHoliday.setString(1, formattedDate + "%");
			ResultSet rsHoliday = pstHoliday.executeQuery();
			while (rsHoliday.next())
			{
				totalHoliDays = rsHoliday.getInt("Total");
			}

		}
		catch (Exception e)
		{
			logger.error(" Exception in Holiday calculations - QuartzJob() - " + e.getLocalizedMessage(), e);
		}

		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT e.EmpCode, e.FirstName, e.Designation, b.paymentType, e.CurrentSalary FROM Employee as e JOIN Designation as d on e.Designation= d.ID join Bank as b on e.EmpCode = b.EmpCode and e.isActive");)
		{
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				int empCode = rs.getInt("EmpCode");
				String name = rs.getString("FirstName");
				String designation = ListDesignation.listAllDesignationByID(Integer.parseInt(rs.getString("Designation")));
				String paymentType = rs.getString("paymentType");
				float currentSalary = rs.getInt("CurrentSalary");

				float paidDays = totalDays - totalHoliDays;
				float leavesDays = 0;
				float oneDaySalary;
				int salaryDeduction = 0;
				float netSalary = 0;
				try (Connection conLeaves = DBConnection.getDBConnection();
						PreparedStatement pstLeaves = conLeaves.prepareStatement("select noofDays from Leaves where ID and ToDate between '" + firstDateOfPreviousMonth + "' and '" + lastDateOfPreviousMonth + "' and FromDate between '" + firstDateOfPreviousMonth + "' and '" + lastDateOfPreviousMonth + "' and EmpCode = ?"))
				{
					pstLeaves.setInt(1, empCode);
					ResultSet rsLeaves = pstLeaves.executeQuery();

					while (rsLeaves.next())
					{
						if (rsLeaves.equals(null))
						{
							leavesDays = 0;

						}
						else
						{
							leavesDays += rsLeaves.getFloat("noofDays");
						}
					}
					oneDaySalary = currentSalary / (paidDays - totalHoliDays);
					salaryDeduction = (int) (oneDaySalary * leavesDays);
					netSalary = currentSalary - salaryDeduction;
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				boolean status = false;
				try (Connection conn = DBConnection.getDBConnection();
						PreparedStatement pstSalary = conn.prepareStatement("INSERT INTO Salary (EmpCode, Name, Designation, SalaryType, NoofworkingDays, Month, NoofleaveDays, Currentsalary,SalaryDeduction, Netsalary, Status) VALUES (?,?,?,?,?,?,?,?,?,?,?)"))
				{
					pstSalary.setInt(1, empCode);
					pstSalary.setString(2, name);
					pstSalary.setString(3, designation);
					pstSalary.setString(4, paymentType);
					pstSalary.setFloat(5, paidDays);
					pstSalary.setString(6, formattedDate);
					pstSalary.setFloat(7, leavesDays);
					pstSalary.setFloat(8, currentSalary);
					pstSalary.setFloat(9, salaryDeduction);
					pstSalary.setFloat(10, netSalary);
					pstSalary.setBoolean(11, status);
					pstSalary.executeUpdate();

				}
				catch (Exception e)
				{
					logger.error(" Exception in Generating salary - QuartzJob class  - " + e.getLocalizedMessage(), e);
				}
			}
		}
		catch (Exception e)
		{
			logger.error(" Error in execute of QuartzJob - " + e.getMessage(), e);
		}

	}
}
