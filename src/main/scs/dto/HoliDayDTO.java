package main.scs.dto;

import java.sql.Date;

public class HoliDayDTO
{
	private int id;
	private String day;
	private Date date;
	private String holiDayName;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getDay()
	{
		return day;
	}

	public void setDay(String day)
	{
		this.day = day;
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public String getHoliDayName()
	{
		return holiDayName;
	}

	public void setHoliDayName(String holiDayName)
	{
		this.holiDayName = holiDayName;
	}

}
