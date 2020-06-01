package main.scs.controller;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import main.scs.actions.AllowenceAction;
import main.scs.actions.AssetAction;
import main.scs.actions.DeductionAction;
import main.scs.actions.Employee;
import main.scs.actions.HolidayAction;
import main.scs.actions.LeaveAction;
import main.scs.actions.LoginUser;
import main.scs.actions.SalaryAction;
import main.scs.actions.VerifySalary;

public class MainController extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(MainController.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		logger.info(" In Servlet - MainController, method - doGet ");
		response.setContentType("text/html;charset=UTF-8");
		String action = null;
		try
		{
			action = request.getParameter("action");

			switch (action)
			{
				case "addHolidaysForm":
					request.getRequestDispatcher("/WEB-INF/pages/holiday/addHoliday.jsp").forward(request, response);
					break;

				case "listEmployee":
					Employee listEmployee = new Employee();
					listEmployee.listAllEmployee(request, response);
					break;

				case "Deduction":
					request.getRequestDispatcher("/WEB-INF/pages/deduction/addDeduction.jsp").forward(request, response);
					break;

				case "listAsset":
					AssetAction list = new AssetAction();
					list.getAssetList(request, response);
					break;

				case "viewEmployee":
					Employee view = new Employee();
					view.viewEmployee(request, response);
					break;
			}
		}
		catch (Exception e)
		{
			logger.error(" Error in doGet of MainController class - " + e.getLocalizedMessage(), e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		ServletContext context = getServletContext();
		response.setContentType("text/html;charset=UTF-8");
		String action = null;

		try
		{
			action = request.getParameter("action");
			logger.info(" In Servlet - MainController, method - doPost, action - " + action);

			switch (action)
			{
				case "loginUser":
					LoginUser login = new LoginUser();
					login.checkUser(request, response);
					break;

				/* **** EMPLOYEE *****/
				case "designation":
					Employee emp = new Employee();
					emp.designationData(request, response);
					break;
				case "listEmployee":
					Employee listEmployee = new Employee();
					listEmployee.listAllEmployee(request, response);
					break;
				case "viewEmployee":
					Employee view = new Employee();
					view.viewEmployee(request, response);
					break;
				case "deleteEmployee":
					Employee delete = new Employee();
					delete.deleteEmployee(request, response);
					break;
				case "ProofDownload":
					Employee pan = new Employee();
					pan.empProofDownload(request, response, context);
					break;
				case "getEmpListJSON":
					Employee listEmployeeJSON = new Employee();
					listEmployeeJSON.listAllEmployeeJSON(request, response);
					break;

				/* ******** ASSET *****/
				case "asset":
					request.getRequestDispatcher("/WEB-INF/pages/asset/addAsset.jsp").forward(request, response);
					break;
				case "viewAsset":
					AssetAction viewAsset = new AssetAction();
					viewAsset.viewAsset(request, response);
					break;
				case "getAssetListJSON":
					AssetAction assetListJSON = new AssetAction();
					assetListJSON.getAssetListJSON(request, response);
					break;
				case "listAsset":
					AssetAction list = new AssetAction();
					list.getAssetList(request, response);
					break;
				case "deleteAsset":
					AssetAction deleteAsset = new AssetAction();
					deleteAsset.deleteAsset(request, response);
					break;

				/* ******** LEAVES *****/

				case "listLeave":
					LeaveAction listLeave = new LeaveAction();
					listLeave.listLeave(request, response);
					break;
				case "addLeave":
					LeaveAction addLeave = new LeaveAction();
					addLeave.addLeave(request, response);
					break;
				case "viewLeave":
					LeaveAction viewLeave = new LeaveAction();
					viewLeave.viewLeave(request, response);
					break;
				case "getLeaveListJSON":
					LeaveAction leaveListJSON = new LeaveAction();
					leaveListJSON.listLeaveJSON(request, response);
					break;
				case "editLeave":
					LeaveAction editLeave = new LeaveAction();
					editLeave.editLeave(request, response);
					break;
				case "attendence":
					request.getRequestDispatcher("/WEB-INF/pages/attendance/listAttendance.jsp").forward(request, response);
					break;

				/* ******** HOLIDAYS *****/

				case "listHolidays":
					HolidayAction listHoliday = new HolidayAction();
					listHoliday.listHoliDays(request, response);
					break;
				case "getHolidayListJSON":
					HolidayAction listHolidayJSON = new HolidayAction();
					listHolidayJSON.listHoliDayJSON(request, response);
					break;
				case "addHolidays":
					HolidayAction addHoliday = new HolidayAction();
					addHoliday.addHoliDays(request, response);
					break;
				case "viewHoliDays":
					HolidayAction viewHoliday = new HolidayAction();
					viewHoliday.viewHoliDays(request, response);
					break;
				case "editHolidays":
					HolidayAction editHoliday = new HolidayAction();
					editHoliday.editHoliDays(request, response);
					break;
				case "deleteHoliday":
					HolidayAction deleteHoliday = new HolidayAction();
					deleteHoliday.deleteHoliDays(request, response);
					break;
				case "listSalary":
					SalaryAction listSalary = new SalaryAction();
					listSalary.listSalary(request, response);
					break;
				case "listSalaryJSON":
					SalaryAction listSalaryJ = new SalaryAction();
					listSalaryJ.listSalaryJSON(request, response);
					break;

				/***** Salary *****/
				case "verifyall":
					VerifySalary verifyAll = new VerifySalary();
					verifyAll.verifyAllRecord(request, response);
					break;

				case "singleVerify":
					VerifySalary singleVerify = new VerifySalary();
					singleVerify.singleRecordVerification(request, response);
					break;

				/***** Deduction *****/

				case "addDeduction":
					DeductionAction deduction = new DeductionAction();
					deduction.addDeduction(request, response);
					break;

				case "listDeduction":
					DeductionAction listDeduct = new DeductionAction();
					listDeduct.listDeduction(request, response);
					break;

				case "listDeductionJSON":
					DeductionAction listJson = new DeductionAction();
					listJson.listDeductionJSON(request, response);
					break;
				case "viewDeduct":
					DeductionAction viewDeduct = new DeductionAction();
					viewDeduct.viewDeduct(request, response);
					break;
				case "editDeduct":
					DeductionAction editDeduct = new DeductionAction();
					editDeduct.editDeduction(request, response);
					break;
				case "deleteDeduct":
					DeductionAction deleteDeduct = new DeductionAction();
					deleteDeduct.deleteDeducttion(request, response);
					break;

				/***** Allowence *****/

				case "listAllow":
					AllowenceAction listAllow = new AllowenceAction();
					listAllow.listAllowence(request, response);
					break;

				case "listAllowenceJson":
					AllowenceAction listAllowJson = new AllowenceAction();
					listAllowJson.listAllowenceJson(request, response);
					break;
				case "addAllowence":
					AllowenceAction addAllowence = new AllowenceAction();
					addAllowence.addAllowence(request, response);
					break;

				case "viewAllowence":
					AllowenceAction viewAllow = new AllowenceAction();
					viewAllow.viewAllowence(request, response);
					break;

				case "editAllowence":
					AllowenceAction editAllow = new AllowenceAction();
					editAllow.editAllowence(request, response);
					break;

				case "deleteAllowence":
					AllowenceAction deleteAllow = new AllowenceAction();
					deleteAllow.deleteAllowence(request, response);
					break;

				default:
					break;
			}
		}
		catch (Exception e)
		{
			logger.error(" Error in doPost of MainController class - " + e.getLocalizedMessage(), e);
		}
	}

}
