package main.scs.dto;

public class SalaryDTO
{
	private int id;
	private int empCode;
	private String name;
	private String designation;
	private String paymentType;
	private float noofWorkingDays;
	private String month;
	private float noofLeaveDays;
	private float salary;
	private boolean status;
	private float leaveDeduction;
	private float netSalary;

	private String pfNo;
	private String esicNO;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getEmpCode()
	{
		return empCode;
	}

	public void setEmpCode(int empCode)
	{
		this.empCode = empCode;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	public String getPaymentType()
	{
		return paymentType;
	}

	public void setPaymentType(String paymentType)
	{
		this.paymentType = paymentType;
	}

	public float getNoofWorkingDays()
	{
		return noofWorkingDays;
	}

	public void setNoofWorkingDays(float noofWorkingDays)
	{
		this.noofWorkingDays = noofWorkingDays;
	}

	public String getMonth()
	{
		return month;
	}

	public void setMonth(String month)
	{
		this.month = month;
	}

	public float getNoofLeaveDays()
	{
		return noofLeaveDays;
	}

	public void setNoofLeaveDays(float noofLeaveDays)
	{
		this.noofLeaveDays = noofLeaveDays;
	}

	public float getSalary()
	{
		return salary;
	}

	public void setSalary(float salary)
	{
		this.salary = salary;
	}

	public float getLeaveDeduction()
	{
		return leaveDeduction;
	}

	public void setLeaveDeduction(float leaveDeduction)
	{
		this.leaveDeduction = leaveDeduction;
	}

	public boolean isStatus()
	{
		return status;
	}

	public float getNetSalary()
	{
		return netSalary;
	}

	public void setNetSalary(float netSalary)
	{
		this.netSalary = netSalary;
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}

	public String getPfNo()
	{
		return pfNo;
	}

	public void setPfNo(String pfNo)
	{
		this.pfNo = pfNo;
	}

	public String getEsicNO()
	{
		return esicNO;
	}

	public void setEsicNO(String esicNO)
	{
		this.esicNO = esicNO;
	}

}
