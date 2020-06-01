package main.scs.dto;

import java.sql.Date;

public class LeaveDTO
{
	private int ID;
	private int empCode;
	private String empName;
	private Date fromDate;
	private Date toDate;
	private float noofDays;
	private String day;
	private String reason;
	private String status;
	private String approverName;

	public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public int getEmpCode()
	{
		return empCode;
	}

	public void setEmpCode(int empCode)
	{
		this.empCode = empCode;
	}

	public Date getFromDate()
	{
		return fromDate;
	}

	public void setFromDate(Date fromDate)
	{
		this.fromDate = fromDate;
	}

	public Date getToDate()
	{
		return toDate;
	}

	public void setToDate(Date toDate)
	{
		this.toDate = toDate;
	}

	public float getNoofDays()
	{
		return noofDays;
	}

	public void setNoofDays(float noofDays)
	{
		this.noofDays = noofDays;
	}

	public String getDay()
	{
		return day;
	}

	public void setDay(String day)
	{
		this.day = day;
	}

	public String getReason()
	{
		return reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getApproverName()
	{
		return approverName;
	}

	public void setApproverName(String approverName)
	{
		this.approverName = approverName;
	}

	public String getEmpName()
	{
		return empName;
	}

	public void setEmpName(String empName)
	{
		this.empName = empName;
	}

}
