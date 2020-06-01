package main.scs.actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import main.scs.common.ListDesignation;

/**
 * Servlet implementation class AttendenceAction
 */

public class AttendenceAction extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	static XSSFRow row;
	boolean flag = true;

	public void addattendence(HttpServletRequest request, HttpServletResponse response, HashMap<String, Object> map) throws IOException, ParseException, ServletException
	{
		ServletContext context = request.getSession().getServletContext();
		String realPath = context.getRealPath("/file/ELIST.xlsx");

		FileInputStream fis = new FileInputStream(new File(realPath));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet spreadsheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = spreadsheet.iterator();
		int empCode = 0;
		Date date = null;
		Date inTime;
		Date outTime;
		String gender = null;

		String officeTimeMale = "11:00:00";
		String officeTimeFemale = "11:30:00";
		String invalidTime = "17:00:00";
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		Date officeTimeMaleparse = df.parse(officeTimeMale);
		System.out.println(officeTimeMaleparse);

		Date officeTimeFemaleparse = df.parse(officeTimeFemale);
		System.out.println(officeTimeFemaleparse);

		Date invalidTimeparse = df.parse(invalidTime);
		System.out.println(invalidTimeparse);

		String day;

		while (rowIterator.hasNext())
		{
			row = (XSSFRow) rowIterator.next();
			if (row.getRowNum() == 0)
			{
				row = (XSSFRow) rowIterator.next();
			}
			System.out.println(row.getRowNum());
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext())
			{
				Cell cell = cellIterator.next();

				switch (cell.getCellType())
				{
					case Cell.CELL_TYPE_NUMERIC:

						if (cell.getColumnIndex() == 0)
						{
							try
							{
								empCode = (int) cell.getNumericCellValue();
								gender = ListDesignation.isMaleFemale(empCode);
								if (null == gender || gender.equals(""))
								{
									failAction(request, response);
								}
							}
							catch (NullPointerException e)
							{
								failAction(request, response);
								// request.getSession().setAttribute("responseType", "fail");
								// request.getSession().setAttribute("responseMessage", "Please Enter valid data in row :" + row.getRowNum());
								// request.getRequestDispatcher("/WEB-INF/pages/attendance/listAttendance.jsp").forward(request, response);
							}
						}
						if (cell.getColumnIndex() == 2)
						{
							date = cell.getDateCellValue();
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
							String strDate = formatter.format(date);
							System.out.println(strDate);

							SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy/MM");
							String strDate1 = formatter1.format(date);
							System.out.println(strDate1);

							Calendar originalDate = Calendar.getInstance();
							Calendar previousMonthDay = (Calendar) originalDate.clone();
							previousMonthDay.add(Calendar.MONTH, -1);
							String formattedDate = formatter1.format(previousMonthDay.getTime());
							System.out.println(formattedDate);
							try
							{
								if (formattedDate.contains(strDate1))
								{
								}
								else
								{
									failAction(request, response);
								}
							}
							catch (Exception e)
							{
								failAction(request, response);
							}
						}

						if (cell.getColumnIndex() == 3)
						{
							inTime = cell.getDateCellValue();
							String a1 = new SimpleDateFormat("HH:mm:ss").format(inTime);
							Date d = df.parse(a1);
							System.out.println(d);
							if (d.after(invalidTimeparse))
							{
								System.out.println("InValid" + invalidTimeparse);
								failAction(request, response);
								flag = false;

							}
						}

				}
				System.out.println();
			}
		}

		if (flag)

		{
			FileInputStream fis1 = new FileInputStream(new File(realPath));
			XSSFWorkbook workbook1 = new XSSFWorkbook(fis1);
			XSSFSheet spreadsheet1 = workbook1.getSheetAt(0);
			Iterator<Row> rowIterator1 = spreadsheet1.iterator();
			while (rowIterator1.hasNext())
			{
				row = (XSSFRow) rowIterator1.next();
				if (row.getRowNum() == 0)
				{
					row = (XSSFRow) rowIterator1.next();
				}
				System.out.println(row.getRowNum());
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext())
				{
					Cell cell = cellIterator.next();

					switch (cell.getCellType())
					{
						case Cell.CELL_TYPE_NUMERIC:
							if (cell.getColumnIndex() == 0)
							{
								empCode = (int) cell.getNumericCellValue();
								gender = ListDesignation.isMaleFemale(empCode);
							}
							if (cell.getColumnIndex() == 2)
							{
								date = cell.getDateCellValue();
								SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
								String strDate = formatter.format(date);
								System.out.println(strDate);
								String[] split = strDate.split("/");
								int yearOfSplit = Integer.parseInt(split[0]);
								int monthOfSplit = Integer.parseInt(split[1]);
								int dayofSplit = Integer.parseInt(split[2]);
								LocalDate dt = LocalDate.of(yearOfSplit, monthOfSplit, dayofSplit);
								String isSunDay = dt.getDayOfWeek().toString();

								System.out.println("Sunday" + isSunDay);
								if (isSunDay.equalsIgnoreCase("sunday"))
								{
									cell = cellIterator.next();
									cell = cellIterator.next();
								}
								else
								{

									SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy/MM");
									String strDate1 = formatter1.format(date);
									System.out.println(strDate1);

									Calendar originalDate = Calendar.getInstance();
									Calendar previousMonthDay = (Calendar) originalDate.clone();
									previousMonthDay.add(Calendar.MONTH, -1);

									String formattedDate = formatter1.format(previousMonthDay.getTime());
									System.out.println(formattedDate);
									try
									{
										if (formattedDate.contains(strDate1))
										{

										}
										else
										{
											failAction(request, response);
										}
									}
									catch (Exception e)
									{
										failAction(request, response);
									}
								}

							}
							if (cell.getColumnIndex() == 3)
							{
								inTime = cell.getDateCellValue();
								String a1 = new SimpleDateFormat("HH:mm:ss").format(inTime);
								Date d = df.parse(a1);
								System.out.println(d);
								if (d.after(invalidTimeparse))
								{
									System.out.println("InValid" + invalidTimeparse);
								}
								else if (d == null || new SimpleDateFormat("HH:mm:ss").format(d).equals("00:00:00"))
								{
									day = "FullDay";
									new LeaveAction().autoAddLeave(empCode, day, date, request);
								}
								else if ((gender.equalsIgnoreCase("male")) && (d.after(officeTimeMaleparse)))
								{
									day = "HalfDay";
									new LeaveAction().autoAddLeave(empCode, day, date, request);
								}
								else if ((gender.equalsIgnoreCase("female")) && (d.after(officeTimeFemaleparse)))
								{
									day = "HalfDay";
									new LeaveAction().autoAddLeave(empCode, day, date, request);
								}
							}
							if (cell.getColumnIndex() == 4)
							{
								System.out.print(cell.getNumericCellValue() + " \t");
							}
							break;

						case Cell.CELL_TYPE_STRING:
							cell.getStringCellValue();
							break;

					}
				}
				System.out.println();
			}
			fis1.close();
			request.getSession().setAttribute("responseType", "success");
			request.getSession().setAttribute("responseMessage", "Report Added Successfully");
			request.getRequestDispatcher("/WEB-INF/pages/attendance/listAttendance.jsp").forward(request, response);
		}
	}

	public void failAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.getSession().setAttribute("responseType", "fail");
			request.getSession().setAttribute("responseMessage", "Please Enter valid data in row :" + row.getRowNum());
			request.getRequestDispatcher("/WEB-INF/pages/attendance/listAttendance.jsp").forward(request, response);
		}
		catch (ServletException | IOException e)
		{
			request.getRequestDispatcher("/WEB-INF/pages/attendance/listAttendance.jsp").forward(request, response);
		}
		finally
		{
			request.getRequestDispatcher("/WEB-INF/pages/attendance/listAttendance.jsp").forward(request, response);
		}

	}

}
