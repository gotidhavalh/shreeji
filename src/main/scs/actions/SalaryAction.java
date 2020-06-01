package main.scs.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.google.gson.Gson;
import main.scs.common.ListDesignation;
import main.scs.dto.SalaryDTO;

/**
 * Servlet implementation class SalaryAction
 */

public class SalaryAction extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	Logger logger = Logger.getLogger(AssetAction.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalaryAction()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public void listSalary(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setAttribute("salaryList", ListDesignation.listSalary());
		request.getRequestDispatcher("/WEB-INF/pages/salary/listSalary.jsp").forward(request, response);

	}

	public void listSalaryJSON(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		JSONObject json = new JSONObject();

		JSONArray array = new JSONArray();

		List<SalaryDTO> salaryList = ListDesignation.listSalary();

		int i = 1;
		for (SalaryDTO salary : salaryList)
		{
			HashMap<String, Object> map = new HashMap<String, Object>();
			String row_id = "row_" + i;
			map.put("DT_RowId", row_id);
			map.put("ID", salary.getId());
			map.put("EmpCode", salary.getEmpCode());
			map.put("FirstName", salary.getName());
			// map.put("Designation", salary.getDesignation());
			map.put("paymentType", salary.getPaymentType());
			// map.put("workingDays", salary.getNoofWorkingDays());
			map.put("month", salary.getMonth());
			// map.put("leaves", salary.getNoofLeaveDays());
			map.put("salary", salary.getSalary());
			map.put("status", salary.isStatus());
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
		}

	}

}
