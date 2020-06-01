package main.scs.actions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import com.mysql.jdbc.Blob;
import main.scs.common.CommonConstants;
import main.scs.common.ListDesignation;
import main.scs.dao.DBConnection;
import main.scs.dto.EmployeeDTO;

/**
 * Servlet implementation class AddEmployee
 */
public class Employee
{
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(AssetAction.class);

	public Employee()
	{

	}

	/**
	 * @param request
	 * @param response
	 * @param map
	 * @throws IOException
	 * @throws ServletException
	 * @throws ParseException
	 */
	public void addEmployee(HttpServletRequest request, HttpServletResponse response, HashMap<String, Object> map) throws IOException, ServletException, ParseException
	{
		// HttpSession session = request.getSession();
		// String name = session.getAttribute("SessionUser").toString();
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstInsert = connection.prepareStatement("INSERT INTO Employee (EmpCode,FirstName,LastName,PhoneNum,AlternatePhoneNum,Email,CompanyEmail,Education,PermanentAddress,"
						+ "CurrentAddress,ResidentProof,EmpImage,PAN,Aadhar,DrivingLicense,PANProof,AadharProof,DrivingLicenseProof,JoiningDate,Designation,CurrentSalary,NextIncrementDate,Username,Password,gender)"
						+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

				PreparedStatement pstBank = connection.prepareStatement("INSERT INTO Bank (EmpCode, HolderName, AccountNumber, BankName, IFSC, AccountType, paymentType) VALUES(?,?,?,?,?,?,?)"))
		{
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmpCode(Integer.parseInt((String) map.get("empCode")));
			emp.setFirstName((String) map.get("firstName"));
			emp.setLastName((String) map.get("lastName"));
			emp.setPhoneNumber((String) map.get("phoneNumber"));
			emp.setAlternativePhoneNumber((String) map.get("alternativeNumber"));
			emp.setEmail((String) map.get("Email"));
			emp.setCompanyEmail((String) map.get("companyEmail"));
			emp.setEducation((String) map.get("education"));
			emp.setcAddress((String) map.get("currentAddress"));
			emp.setpAddress((String) map.get("permanentAddress"));

			InputStream empImage = (InputStream) map.get("empImage");

			InputStream residentPdf = (InputStream) map.get("residentPdf");
			// InputStream residentPdf = (InputStream) map.get("fileContent");

			emp.setPanCard((String) map.get("panNumber"));
			InputStream panPDF = (InputStream) map.get("panPdf");

			String adharNumber = (String) map.get("adharNumber");
			if (adharNumber.equals(""))
			{
				emp.setAdharCard(0);
			}
			else
			{
				emp.setAdharCard(Long.parseLong((String) map.get("adharNumber")));
			}

			InputStream adharPDF = (InputStream) map.get("adharPdf");

			emp.setLicence((String) map.get("licenceNumber"));
			InputStream licencePDF = (InputStream) map.get("licencePdf");

			if (!(map.get("joinDate").equals("")))
			{
				java.util.Date join = new SimpleDateFormat("dd/MM/yyyy").parse(map.get("joinDate").toString());
				emp.setJoinDate(new java.sql.Date(join.getTime()));
			}

			String currentSalary = map.get("currSalary").toString();
			if (!(currentSalary.equals("")))
			{
				emp.setCurrentSalary(Integer.parseInt(map.get("currSalary").toString()));
			}

			if (!(map.get("nextIncrement").equals("")))
			{
				java.util.Date next = new SimpleDateFormat("dd/MM/yyyy").parse(map.get("nextIncrement").toString());
				emp.setNextIncrement(new java.sql.Date(next.getTime()));
			}
			emp.setDesignation(Integer.parseInt(map.get("designation").toString()));
			emp.setUsername(map.get("username").toString());
			emp.setPassword(map.get("password").toString());
			emp.setPassword(CommonConstants.getPasswordHash(map.get("password").toString()));
			emp.setGender(map.get("gender").toString());

			emp.setEmpCode(Integer.parseInt((String) map.get("empCode")));
			emp.setHolderName(map.get("holderName").toString());
			emp.setAccountNumber(map.get("accountNumber").toString());
			emp.setBankName(map.get("bankName").toString());
			emp.setIFSC(map.get("ifsc").toString());
			emp.setAccountType(map.get("accountType").toString());
			emp.setPaymentType(map.get("paymentType").toString());

			connection.setAutoCommit(false);
			pstInsert.setInt(1, emp.getEmpCode());
			pstInsert.setString(2, emp.getFirstName());
			pstInsert.setString(3, emp.getLastName());
			pstInsert.setString(4, emp.getPhoneNumber());
			pstInsert.setString(5, emp.getAlternativePhoneNumber());
			pstInsert.setString(6, emp.getEmail());
			pstInsert.setString(7, emp.getCompanyEmail());
			pstInsert.setString(8, emp.getEducation());
			pstInsert.setString(9, emp.getpAddress());
			pstInsert.setString(10, emp.getcAddress());
			pstInsert.setBinaryStream(11, residentPdf);
			pstInsert.setBinaryStream(12, empImage);

			pstInsert.setString(13, emp.getPanCard());
			pstInsert.setLong(14, emp.getAdharCard());
			pstInsert.setString(15, emp.getLicence());
			pstInsert.setBinaryStream(16, panPDF);
			pstInsert.setBinaryStream(17, adharPDF);
			pstInsert.setBinaryStream(18, licencePDF);
			pstInsert.setDate(19, emp.getJoinDate());
			pstInsert.setInt(20, emp.getDesignation());
			pstInsert.setInt(21, emp.getCurrentSalary());
			pstInsert.setDate(22, emp.getNextIncrement());
			pstInsert.setString(23, emp.getUsername());
			pstInsert.setString(24, emp.getPassword());
			pstInsert.setString(25, emp.getGender());
			pstInsert.executeUpdate();

			ResultSet tableKeys = pstInsert.getGeneratedKeys();
			tableKeys.next();

			String path = (String) map.get("path");
			if (path != null)
			{
				File dir = new File(path);
				dir.mkdirs();
				File newFile = new File(dir, "emp" + emp.getEmpCode() + ".jpg");
				File oldFile = new File(path + "/filename123.jpg");

				if (oldFile.renameTo(newFile))
				{
					logger.info("File move success for EmpCode - " + emp.getEmpCode());
				}
				else
				{
					logger.info("File move fail for EmpCode - " + emp.getEmpCode());
				}
			}
			tableKeys.close();

			pstBank.setInt(1, emp.getEmpCode());
			pstBank.setString(2, emp.getHolderName());
			pstBank.setString(3, emp.getAccountNumber());
			pstBank.setString(4, emp.getBankName());
			pstBank.setString(5, emp.getIFSC());
			pstBank.setString(6, emp.getAccountType());
			pstBank.setString(7, emp.getPaymentType());
			pstBank.executeUpdate();
			// request.setAttribute("Employeelist", ListDesignation.ListEmployee());

			request.getSession().setAttribute("responseType", "success");
			request.getSession().setAttribute("responseMessage", " Employee added successfully.");

			connection.commit();

			request.getRequestDispatcher("/WEB-INF/pages/employee/datatableForEmployee.jsp").include(request, response);

		}
		catch (Exception e)
		{
			logger.error(" Error in addEmployee of Employee - " + e.getMessage(), e);
			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Something wrong occured while adding Employee record. Error - " + e.getLocalizedMessage());
			request.getRequestDispatcher("/WEB-INF/pages/employee/datatableForEmployee.jsp").include(request, response);
		}
	}

	public void designationData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String view = request.getParameter("designation");
		if (view.equalsIgnoreCase("Designation"))
		{
			request.setAttribute("listDesignation", ListDesignation.listAllDesignation());
			request.getRequestDispatcher("/WEB-INF/pages/employee/addEmployee.jsp").forward(request, response);

		}
		else if (view.equalsIgnoreCase("deduction"))
		{
			request.setAttribute("listEmployee", ListDesignation.listEmployee());
			request.getRequestDispatcher("/WEB-INF/pages/deduction/addDeduction.jsp").forward(request, response);
		}
		else if (view.equalsIgnoreCase("allowence"))
		{

			request.setAttribute("listEmployee", ListDesignation.listEmployee());
			request.getRequestDispatcher("/WEB-INF/pages/allowence/addAllowence.jsp").forward(request, response);
		}
		else
		{
			request.setAttribute("listEmployee", ListDesignation.listEmployee());
			request.getRequestDispatcher("/WEB-INF/pages/leave/addLeave.jsp").forward(request, response);
		}
	}

	public void listAllEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.getRequestDispatcher("/WEB-INF/pages/employee/datatableForEmployee.jsp").forward(request, response);
	}

	public void listAllEmployeeJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		JSONObject json = new JSONObject();

		JSONArray array = new JSONArray();

		List<EmployeeDTO> empList = ListDesignation.listEmployee();

		int i = 1;
		for (EmployeeDTO emp : empList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			String row_id = "row_" + i;
			map.put("DT_RowId", row_id);
			map.put("EmpCode", emp.getEmpCode());
			map.put("FirstName", emp.getFirstName() + " " + emp.getLastName());
			map.put("PhoneNum", emp.getPhoneNumber());
			map.put("DesignationID", emp.getDesignation());
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

			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Something wrong occured while parsing Employee JSON. Error - " + e.getLocalizedMessage());
		}

	}

	public void viewEmployee(HttpServletRequest request, HttpServletResponse response)
	{
		List<EmployeeDTO> list = new ArrayList<>();
		List<EmployeeDTO> listDesingation = new ArrayList<>();
		int empcode = (Integer.parseInt(request.getParameter("empcode").trim()));
		// int designationID = Integer.parseInt(request.getParameter("designationID").trim());
		String view = request.getParameter("view").trim();

		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstView = connection.prepareStatement("SELECT e.EmpCode, e.FirstName, e.LastName, e.PhoneNum, e.AlternatePhoneNum, e.Email, e.CompanyEmail, e.Education, e.PermanentAddress,e.CurrentAddress, e.ResidentProof, e.EmpImage, e.PAN, e.Aadhar," +
						"e.DrivingLicense, e.PANProof, e.AadharProof, e.DrivingLicenseProof,e.JoiningDate, e.Designation, e.CurrentSalary, e.NextIncrementDate, e.Username,e.Gender, b.HolderName , b.AccountNumber, b.BankName," +
						"b.IFSC, b.AccountType, b.paymentType FROM Employee as e join Bank as b where e.EmpCode = b.Empcode and e.EmpCode = ?");
				PreparedStatement pstDesignation = connection.prepareStatement("SELECT designation from Designation WHERE ID = ?");)
		{
			{
				pstView.setInt(1, empcode);
				ResultSet rsView = pstView.executeQuery();
				while (rsView.next())
				{
					EmployeeDTO emp = new EmployeeDTO();
					emp.setEmpCode(rsView.getInt("EmpCode"));
					emp.setFirstName(rsView.getString("FirstName"));
					emp.setLastName(rsView.getString("LastName"));
					emp.setPhoneNumber(rsView.getString("PhoneNum"));
					emp.setAlternativePhoneNumber(rsView.getString("AlternatePhoneNum"));
					emp.setEmail(rsView.getString("Email"));
					emp.setCompanyEmail(rsView.getString("CompanyEmail"));
					emp.setEducation(rsView.getString("Education"));
					emp.setpAddress(rsView.getString("PermanentAddress"));
					emp.setcAddress(rsView.getString("CurrentAddress"));
					// emp.setResidentImage(rsView.getBlob("ResidentProof"));
					// emp.setEmpImage(rsView.getBlob("EmpImage"));
					emp.setPanCard(rsView.getString("PAN"));
					emp.setAdharCard(rsView.getLong("Aadhar"));
					emp.setLicence(rsView.getString("DrivingLicense"));
					emp.setPanImage(rsView.getBlob("PANProof"));
					emp.setAdharImage(rsView.getBlob("DrivingLicenseProof"));
					emp.setJoinDate(rsView.getDate("JoiningDate"));
					emp.setDesignation(rsView.getInt("Designation"));
					emp.setCurrentSalary(rsView.getInt("CurrentSalary"));
					emp.setNextIncrement(rsView.getDate("NextIncrementDate"));
					emp.setUsername(rsView.getString("Username"));
					emp.setGender(rsView.getString("Gender"));
					emp.setHolderName(rsView.getString("HolderName"));
					emp.setAccountNumber(rsView.getString("AccountNumber"));
					emp.setBankName(rsView.getString("BankName"));
					emp.setIFSC(rsView.getString("IFSC"));
					emp.setAccountType(rsView.getString("AccountType"));
					emp.setPaymentType(rsView.getString("paymentType"));
					list.add(emp);
				}
				if (view.equalsIgnoreCase("view"))
				{
					pstDesignation.setInt(1, rsView.getInt("Designation"));
					ResultSet rsDesignation = pstDesignation.executeQuery();
					while (rsDesignation.next())
					{
						EmployeeDTO empDesignation = new EmployeeDTO();
						empDesignation.setDesignationDesc(rsDesignation.getString("designation"));
						listDesingation.add(empDesignation);

					}
				}
			}
			request.setAttribute("list", list);
			request.setAttribute("listDesingation", listDesingation);
			request.setAttribute("listDesignation", ListDesignation.listAllDesignation());

			if (view.equalsIgnoreCase("view"))
			{
				request.getRequestDispatcher("/WEB-INF/pages/employee/viewEmployee.jsp").forward(request, response);
			}
			if (view.equalsIgnoreCase("edit"))
			{
				request.getRequestDispatcher("/WEB-INF/pages/employee/editEmployee.jsp").forward(request, response);
			}

		}
		catch (Exception e)
		{
			logger.error(" Error in viewEmployee of Employee - " + e.getMessage());
		}

	}

	public void editEmployee(HttpServletRequest request, HttpServletResponse response, HashMap<String, Object> map) throws ParseException, ServletException, IOException
	{
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstUpdate = connection.prepareStatement("update Employee set FirstName=? ,LastName=?,PhoneNum=?, AlternatePhoneNum=?, Email=?, CompanyEmail=?, Education=?, PermanentAddress=?, CurrentAddress=?, ResidentProof=?,EmpImage=?,PAN=?, Aadhar=?,DrivingLicense=?, " +
						"PANProof=?,AadharProof=?, DrivingLicenseProof=?, JoiningDate=?, Designation=?,CurrentSalary=?,NextIncrementDate=?,Password= ? where EmpCode=?");
				PreparedStatement pstupdateBank = connection.prepareStatement("UPDATE Bank set HolderName = ?, AccountNumber = ?, BankName = ?, IFSC = ?, AccountType = ?, paymentType = ? WHERE EmpCode = ?");
				PreparedStatement pstpassword = connection.prepareStatement("SELECT password from Employee where EmpCode = ?"))
		{
			EmployeeDTO emp = new EmployeeDTO();
			int empCode = Integer.parseInt((String) map.get("empcode"));
			emp.setEmpCode(Integer.parseInt((String) map.get("empcode")));
			emp.setFirstName((String) map.get("firstName"));
			emp.setLastName((String) map.get("lastName"));
			emp.setPhoneNumber((String) map.get("phoneNumber"));
			emp.setAlternativePhoneNumber((String) map.get("alternativeNumber"));
			emp.setEmail((String) map.get("Email"));
			emp.setCompanyEmail((String) map.get("companyEmail"));
			emp.setEducation((String) map.get("education"));
			emp.setcAddress((String) map.get("currentAddress"));
			emp.setpAddress((String) map.get("permanentAddress"));

			InputStream empImage = (InputStream) map.get("empImage");

			InputStream residentPdf = (InputStream) map.get("residentPdf");

			emp.setPanCard((String) map.get("panNumber"));
			InputStream panPDF = (InputStream) map.get("panPdf");

			String adharNumber = (String) map.get("adharNumber");
			if (adharNumber.equals(""))
			{
				emp.setAdharCard(0);
			}
			else
			{
				emp.setAdharCard(Long.parseLong((String) map.get("adharNumber")));
			}

			String path = (String) map.get("path");
			if (path != null)
			{
				File dir = new File(path);
				dir.mkdirs();
				File newFile = new File(dir, "emp" + emp.getEmpCode() + ".jpg");
				File oldFile = new File(path + "/filename123.jpg");

				if (newFile.exists() && !newFile.isDirectory())
				{
					newFile.delete();
				}
				newFile = new File(dir, "emp" + emp.getEmpCode() + ".jpg");
				if (oldFile.renameTo(newFile))
				{
					logger.info("File move success for EmpCode - " + emp.getEmpCode());
				}
				else
				{
					logger.info("File move fail for EmpCode - " + emp.getEmpCode());
				}
			}
			InputStream adharPDF = (InputStream) map.get("adharPdf");

			emp.setLicence((String) map.get("licenceNumber"));
			InputStream licencePDF = (InputStream) map.get("licencePdf");

			String join = (String) map.get("joinDate");
			String joinReplace = join.replace("-", "/");
			if (!(map.get("joinDate").equals("")))
			{
				java.util.Date joinParse = new SimpleDateFormat("dd/MM/yyyy").parse(joinReplace);
				emp.setJoinDate(new java.sql.Date(joinParse.getTime()));

			}

			String currentSalary = map.get("currSalary").toString();
			if (!(currentSalary.equals("")))
			{
				emp.setCurrentSalary(Integer.parseInt(map.get("currSalary").toString()));
			}

			String next = (String) map.get("nextIncrement");
			String nextReplace = next.replace("-", "/");
			if (!(map.get("nextIncrement").equals("")))
			{
				java.util.Date nextParse = new SimpleDateFormat("dd/MM/yyyy").parse(nextReplace);
				emp.setNextIncrement(new java.sql.Date(nextParse.getTime()));
			}
			emp.setDesignation(Integer.parseInt(map.get("designation").toString()));
			if (map.get("password").toString() != null && map.get("password").toString().equals(""))
			{
				pstpassword.setInt(1, empCode);
				ResultSet rs = pstpassword.executeQuery();
				if (rs.next())
				{
					emp.setPassword(rs.getString("password"));
				}
			}
			else
			{
				emp.setPassword(map.get("password").toString());
				emp.setPassword(CommonConstants.getPasswordHash(map.get("password").toString()));
			}

			// emp.setEmpCode(Integer.parseInt((String) map.get("empCode")));
			emp.setHolderName(map.get("holderName").toString());
			emp.setAccountNumber(map.get("accountNumber").toString());
			emp.setBankName(map.get("bankName").toString());
			emp.setIFSC(map.get("ifsc").toString());
			emp.setAccountType(map.get("accountType").toString());
			emp.setPaymentType(map.get("paymentType").toString());

			pstUpdate.setString(1, emp.getFirstName());
			pstUpdate.setString(2, emp.getLastName());
			pstUpdate.setString(3, emp.getPhoneNumber());
			pstUpdate.setString(4, emp.getAlternativePhoneNumber());
			pstUpdate.setString(5, emp.getEmail());
			pstUpdate.setString(6, emp.getCompanyEmail());
			pstUpdate.setString(7, emp.getEducation());
			pstUpdate.setString(8, emp.getpAddress());
			pstUpdate.setString(9, emp.getcAddress());
			pstUpdate.setBinaryStream(10, residentPdf);
			pstUpdate.setBinaryStream(11, empImage);
			pstUpdate.setString(12, emp.getPanCard());
			pstUpdate.setLong(13, emp.getAdharCard());
			pstUpdate.setString(14, emp.getLicence());
			pstUpdate.setBinaryStream(15, panPDF);
			pstUpdate.setBinaryStream(16, adharPDF);
			pstUpdate.setBinaryStream(17, licencePDF);
			pstUpdate.setDate(18, emp.getJoinDate());
			pstUpdate.setInt(19, emp.getDesignation());
			pstUpdate.setInt(20, emp.getCurrentSalary());
			pstUpdate.setDate(21, emp.getNextIncrement());
			pstUpdate.setString(22, emp.getPassword());
			pstUpdate.setInt(23, emp.getEmpCode());
			pstUpdate.executeUpdate();
			pstupdateBank.setString(1, emp.getHolderName());
			pstupdateBank.setString(2, emp.getAccountNumber());
			pstupdateBank.setString(3, emp.getBankName());
			pstupdateBank.setString(4, emp.getIFSC());
			pstupdateBank.setString(5, emp.getAccountType());
			pstupdateBank.setString(6, emp.getPaymentType());
			pstupdateBank.setInt(7, emp.getEmpCode());

			request.getSession().setAttribute("responseType", "success");
			request.getSession().setAttribute("responseMessage", "Employee edited successfully.");

			logger.info(" Employee edited successfully. EmpCode - " + empCode);
			request.getRequestDispatcher("/WEB-INF/pages/employee/datatableForEmployee.jsp").forward(request, response);
		}
		catch (Exception e)
		{
			logger.error(" Error in editEmployee of Employee while updating Employee - " + e.getMessage(), e);
			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Something wrong occured while edit employee. Error - " + e.getLocalizedMessage());
		}

	}

	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int empcode = Integer.parseInt(request.getParameter("empcode").trim());
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstDelete = connection.prepareStatement("UPDATE Employee set isActive=false WHERE EmpCode=?");)
		{
			pstDelete.setInt(1, empcode);
			pstDelete.executeUpdate();

			request.getSession().setAttribute("responseType", "success");
			request.getSession().setAttribute("responseMessage", "Employee deleted successfully.");
		}
		catch (Exception e)
		{
			logger.error(" Error in deleteEmployee of Employee", e);

			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Something wrong occured while deleting employee. Error - " + e.getLocalizedMessage());
		}
		// request.setAttribute("Employeelist", ListDesignation.listEmployee());
		request.getRequestDispatcher("/WEB-INF/pages/employee/datatableForEmployee.jsp").forward(request, response);

	}

	public void empProofDownload(HttpServletRequest request, HttpServletResponse response, ServletContext context) throws ServletException, IOException
	{
		int empcode = Integer.parseInt(request.getParameter("EmpCode").trim());
		String proofType = request.getParameter("proofType");
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstSelect = connection.prepareStatement("SELECT " + proofType + " from Employee WHERE EmpCode = " + empcode + " ");
				ResultSet rSet = pstSelect.executeQuery())
		{
			Blob blob = null;

			if (rSet.next())
			{
				blob = (Blob) rSet.getBlob(proofType);
				InputStream is = blob.getBinaryStream();
				String mimeType = "application/octet-stream";

				// modifies response
				response.setContentType(mimeType);
				response.setContentLength((int) is.available());

				// forces download
				String headerKey = "Content-Disposition";
				String filename = proofType + "_" + empcode + ".pdf";
				String headerValue = String.format("attachment; filename=\"%s\"", filename);
				response.setHeader(headerKey, headerValue);

				// obtains response's output stream
				OutputStream outStream = response.getOutputStream();

				byte[] buffer = new byte[4096];
				int bytesRead = -1;

				while ((bytesRead = is.read(buffer)) != -1)
				{
					outStream.write(buffer, 0, bytesRead);
				}
				is.close();
				outStream.close();

			}
		}
		catch (Exception e)
		{
			logger.error("Error while empProofDownload download file " + e.getMessage(), e);
		}

	}
}
