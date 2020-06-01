package main.scs.dto;

import java.sql.Date;

public class DeductionDTO
{
	private int id;
	private int empCode;
	private String name;
	private float pf;
	private float tds;

	private float leaveDeduct;
	private float assetDeduct;
	private float other;
	private String month;
	private int year;
	Date date;

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

	public float getPf()
	{
		return pf;
	}

	public void setPf(float pf)
	{
		this.pf = pf;
	}

	public float getTds()
	{
		return tds;
	}

	public void setTds(float tds)
	{
		this.tds = tds;
	}

	public float getLeaveDeduct()
	{
		return leaveDeduct;
	}

	public void setLeaveDeduct(float leaveDeduct)
	{
		this.leaveDeduct = leaveDeduct;
	}

	public float getAssetDeduct()
	{
		return assetDeduct;
	}

	public void setAssetDeduct(float assetDeduct)
	{
		this.assetDeduct = assetDeduct;
	}

	public float getOther()
	{
		return other;
	}

	public void setOther(float other)
	{
		this.other = other;
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

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

}
