package main.scs.dto;

public class AllowenceDTO
{

	private int id;
	private int EmpCode;
	private String name;
	private float fual;
	private float overTime;
	private String month;
	private int year;

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
		return EmpCode;
	}

	public void setEmpCode(int empCode)
	{
		EmpCode = empCode;
	}

	public float getFual()
	{
		return fual;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setFual(float fual)
	{
		this.fual = fual;
	}

	public float getOverTime()
	{
		return overTime;
	}

	public void setOverTime(float overTime)
	{
		this.overTime = overTime;
	}

	public String getMonth()
	{
		return month;
	}

	public void setMonth(String month)
	{
		this.month = month;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

}
