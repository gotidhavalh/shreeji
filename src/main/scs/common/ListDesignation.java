package main.scs.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import main.scs.dao.DBConnection;
import main.scs.dto.AllowenceDTO;
import main.scs.dto.AssetDTO;
import main.scs.dto.DeductionDTO;
import main.scs.dto.DesignationDTO;
import main.scs.dto.EmployeeDTO;
import main.scs.dto.HoliDayDTO;
import main.scs.dto.LeaveDTO;
import main.scs.dto.SalaryDTO;

public class ListDesignation
{
	static Logger logger = Logger.getLogger(ListDesignation.class);

	public static List<DesignationDTO> listAllDesignation()
	{

		List<DesignationDTO> listDesignation = new ArrayList<>();
		try (Connection conn = DBConnection.getDBConnection();
				PreparedStatement pst = conn.prepareStatement("SELECT ID, designation FROM Designation");
				ResultSet rs = pst.executeQuery();)
		{
			while (rs.next())
			{
				DesignationDTO designation = new DesignationDTO();
				designation.setID(rs.getInt("ID"));
				designation.setDesignation(rs.getString("designation"));
				listDesignation.add(designation);
			}

		}
		catch (Exception e)
		{
			logger.error(" Error while listing Designation in ListDesignation -" + e.getMessage(), e);
		}

		return listDesignation;
	}

	public static String listAllDesignationByID(int id)
	{

		// List<DesignationDTO> listDesignation = new ArrayList<>();
		int desID;
		String desc = null;
		try (Connection conn = DBConnection.getDBConnection();
				PreparedStatement pst = conn.prepareStatement("SELECT ID, designation FROM Designation WHERE ID = ?");)
		{
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				// DesignationDTO designation = new DesignationDTO();
				// designation.setID(rs.getInt("ID"));
				// designation.setDesignation(rs.getString("description"));
				// listDesignation.add(designation);
				desID = rs.getInt("ID");
				desc = rs.getString("designation");
			}

		}
		catch (Exception e)
		{
			logger.error(" Error while listing Designation in ListDesignation -" + e.getMessage(), e);
		}

		return desc;
	}

	public static List<EmployeeDTO> listEmployee()
	{

		List<EmployeeDTO> listEmployee = new ArrayList<>();
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstlistEmployee = connection.prepareStatement("SELECT EmpCode, FirstName, LastName, PhoneNum, Designation FROM Employee WHERE isActive=true");
				ResultSet rslistEmployee = pstlistEmployee.executeQuery();)
		{
			while (rslistEmployee.next())
			{
				EmployeeDTO list = new EmployeeDTO();
				list.setEmpCode(rslistEmployee.getInt("EmpCode"));
				list.setFirstName(rslistEmployee.getString("FirstName"));
				list.setLastName(rslistEmployee.getString("LastName"));
				list.setPhoneNumber(rslistEmployee.getString("PhoneNum"));
				list.setDesignation(rslistEmployee.getInt("Designation"));
				listEmployee.add(list);
			}

		}
		catch (Exception e)
		{
			logger.error(" Error while listing Employee in ListDesignation -" + e.getMessage(), e);
		}
		return listEmployee;
	}

	public static List<AssetDTO> listAsset()
	{
		List<AssetDTO> listAsset = new ArrayList<>();

		try (Connection con = DBConnection.getDBConnection();
				PreparedStatement pStmt = con.prepareStatement("SELECT AssetID, AssetName, HolderName, SKU, AssetDetail, AssetImage from Asset ");
				ResultSet rSet = pStmt.executeQuery())
		{
			AssetDTO asset = null;
			while (rSet.next())
			{
				asset = new AssetDTO();

				asset.setId(rSet.getInt("AssetID"));
				asset.setName(rSet.getString("AssetName"));
				asset.setHolderName(rSet.getString("HolderName"));
				asset.setSku(rSet.getString("SKU"));

				listAsset.add(asset);
			}
		}
		catch (Exception e)
		{
			logger.error(" Error while listing Asset in ListDesignation -" + e.getMessage(), e);
		}

		return listAsset;
	}

	public static List<LeaveDTO> listLeave()
	{
		List<LeaveDTO> leavelist = new ArrayList<>();
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstlist = connection.prepareStatement("select Leaves.ID, Employee.FirstName, Leaves.EmpCode, Leaves.FromDate, Leaves.ToDate, Leaves.Approvername, Leaves.status from Leaves join Employee on Leaves.EmpCode = Employee.EmpCode order by currDate desc"))
		{
			ResultSet rslist = pstlist.executeQuery();
			while (rslist.next())
			{
				LeaveDTO list = new LeaveDTO();
				list.setID(rslist.getInt("ID"));
				list.setEmpName(rslist.getString("FirstName"));
				list.setEmpCode(rslist.getInt("EmpCode"));
				list.setFromDate(rslist.getDate("FromDate"));
				list.setToDate(rslist.getDate("ToDate"));
				list.setApproverName(rslist.getString("Approvername"));
				list.setStatus(rslist.getString("status"));
				leavelist.add(list);
			}

		}
		catch (Exception e)
		{
			logger.error(" Error while listing Leave in ListDesignation -" + e.getMessage(), e);
		}
		return leavelist;
	}

	public static List<HoliDayDTO> listHoliDay()
	{
		List<HoliDayDTO> holiDayList = new ArrayList<>();
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstlist = connection.prepareStatement("SELECT ID, Days, Holidate, Holiname FROM Holidays"))
		{
			ResultSet rslist = pstlist.executeQuery();
			while (rslist.next())
			{
				HoliDayDTO list = new HoliDayDTO();
				list.setId(Integer.parseInt(rslist.getString("ID")));
				list.setDay(rslist.getString("Days"));
				list.setDate(rslist.getDate("Holidate"));
				list.setHoliDayName(rslist.getString("Holiname"));
				holiDayList.add(list);
			}

		}
		catch (Exception e)
		{
			logger.error(" Error while listing HoliDay in ListDesignation -" + e.getMessage(), e);
		}
		return holiDayList;
	}

	public static List<SalaryDTO> listSalary()
	{

		List<SalaryDTO> salaryList = new ArrayList<>();
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstlist = connection.prepareStatement("select ID, EmpCode, Name, Designation, SalaryType, NoofworkingDays, Month, NoofleaveDays, Currentsalary, SalaryDeduction, Netsalary, Status from Salary order by  Status asc"))
		{
			ResultSet rslist = pstlist.executeQuery();
			while (rslist.next())
			{
				SalaryDTO list = new SalaryDTO();
				list.setId(rslist.getInt("ID"));
				list.setEmpCode(rslist.getInt("EmpCode"));
				list.setName(rslist.getString("Name"));
				list.setDesignation(rslist.getString("Designation"));
				list.setPaymentType(rslist.getString("SalaryType"));
				list.setNoofWorkingDays(rslist.getFloat("NoofworkingDays"));
				list.setMonth(rslist.getString("Month"));
				list.setNoofLeaveDays(rslist.getFloat("NoofleaveDays"));
				list.setSalary(rslist.getFloat("Currentsalary"));
				list.setLeaveDeduction(rslist.getFloat("SalaryDeduction"));
				list.setNetSalary(rslist.getFloat("Netsalary"));
				list.setStatus(rslist.getBoolean("Status"));
				salaryList.add(list);
			}
		}
		catch (Exception e)
		{
			logger.error(" Error while listing Salary in ListDesignation -" + e.getMessage(), e);
		}
		return salaryList;
	}

	public static List<DeductionDTO> listDeduction()
	{
		List<DeductionDTO> deductList = new ArrayList<>();
		try (java.sql.Connection connection = DBConnection.getDBConnection();
				PreparedStatement pst = connection.prepareStatement("SELECT d.ID, e.EmpCode, e.FirstName, d.PF, d.TDS, d.Leaves, d.Asset, d.Other, d.Month, d.year FROM Deduction as d join Employee as e where e.EmpCode = d.EmpCode AND e.isActive= true");)
		{
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
		}
		catch (Exception e)
		{
			logger.error(" Error while listing Salary in ListDesignation -" + e.getMessage(), e);
		}
		return deductList;

	}

	public static List<AllowenceDTO> listAllowence()
	{
		List<AllowenceDTO> allowList = new ArrayList<>();
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pst = connection.prepareStatement("select a.ID, a.EmpCode, e.FirstName, a.Fual, a.OverTime, a.month, a.year from Allowence as a join Employee as e on e.EmpCode = a.EmpCode and e.isActive= true");)
		{
			ResultSet rs = pst.executeQuery();
			while (rs.next())
			{
				AllowenceDTO list = new AllowenceDTO();
				list.setId(rs.getInt("ID"));
				list.setEmpCode(rs.getInt("EmpCode"));
				list.setName(rs.getString("FirstName"));
				list.setFual(rs.getFloat("Fual"));
				list.setOverTime(rs.getFloat("OverTime"));
				list.setMonth(rs.getString("month"));
				list.setYear(rs.getInt("year"));
				allowList.add(list);
			}
		}
		catch (Exception e)
		{
			logger.error(" Error while listing Allowence in listAllowence -" + e.getMessage(), e);
		}
		return allowList;
	}

	public static String isMaleFemale(int empCode)
	{
		String gender = null;
		try (Connection connection = DBConnection.getDBConnection();
				PreparedStatement pstMale = connection.prepareStatement("SELECT Gender from Employee WHERE EmpCode = ?");)
		{
			pstMale.setInt(1, empCode);
			ResultSet rsMale = pstMale.executeQuery();
			if (rsMale.next())
			{
				gender = rsMale.getString("Gender");
			}
		}
		catch (Exception e)
		{
			logger.error(" Error while listing Allowence in listAllowence -" + e.getMessage(), e);
		}
		return gender;
	}

}
