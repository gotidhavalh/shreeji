package main.scs.controller;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import main.scs.actions.AssetAction;
import main.scs.actions.AttendenceAction;
import main.scs.actions.Employee;

/**
 * Servlet implementation class MultipartController
 */
@MultipartConfig
public class MultipartController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	Logger logger = Logger.getLogger(MultipartController.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MultipartController()
	{
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HashMap<String, Object> map = new HashMap<>();
		try
		{
			List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			for (FileItem item : items)
			{
				if (item.isFormField())
				{
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();
					map.put(fieldName, fieldValue);
				}
				else
				{

					// Process form file field (input type="file").
					String fieldName = item.getFieldName();
					String fileName = FilenameUtils.getName(item.getName());
					// File file = File.
					InputStream fileContent = item.getInputStream();

					map.put(fieldName, fileName);
					map.put(fieldName, fileContent);
					if (!(fileName.equals("")))
					{
						if (fieldName.contains("Image") || fieldName.contains("Div"))
						{

							String path = getServletContext().getRealPath("/images");
							map.put("path", path);
							File dir = new File(path);
							dir.mkdirs();
							File file = new File(dir, "filename1.jpg");
							FileOutputStream outputStream = new FileOutputStream(file);

							int read = 0;
							byte[] bytes = new byte[1024];

							while ((read = fileContent.read(bytes)) != -1)
							{
								outputStream.write(bytes, 0, read);
							}
							outputStream.close();

							fileContent = item.getInputStream();
							BufferedImage img = ImageIO.read(fileContent);
							int w = img.getWidth();
							int h = img.getHeight();
							BufferedImage dimg = new BufferedImage(100, 100, img.getType());
							Graphics2D g = dimg.createGraphics();
							g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
							g.drawImage(img, 0, 0, 100, 100, 0, 0, w, h, null);

							g.dispose();
							ImageIO.write(img, "jpg", new File(path + "/filename123.jpg"));
						}
						else if (fieldName.contains("csv"))
						{

							String path = getServletContext().getRealPath("/file");
							File f = new File(path + "/ELIST.xlsx");
							f.exists();
							f.delete();
							map.put("path", path);
							File dir = new File(path);
							dir.mkdirs();
							File file = new File(dir, "ELIST.xlsx");
							FileOutputStream outputStream = new FileOutputStream(file);

							int read = 0;
							byte[] bytes = new byte[1024];

							while ((read = fileContent.read(bytes)) != -1)
							{
								outputStream.write(bytes, 0, read);
							}
							outputStream.close();
						}
					}
				}
			}
			switch ((String) map.get("action"))
			{
				case "addAsset":
					AssetAction aAction = new AssetAction();
					aAction.storeAssetForm(request, response, map);
					break;

				case "addEmployee":
					Employee add = new Employee();
					add.addEmployee(request, response, map);
					break;
				case "editEmployee":
					Employee edit = new Employee();
					edit.editEmployee(request, response, map);
					break;
				case "editAsset":
					AssetAction editAsset = new AssetAction();
					editAsset.editAsset(request, response, map);
					break;
				case "addattendence":
					AttendenceAction addatt = new AttendenceAction();
					addatt.addattendence(request, response, map);
					break;
				default:
					break;
			}
		}
		catch (Exception e)
		{
			logger.error(" Exception in doPost of MultiPartController - " + e.getLocalizedMessage(), e);
		}
	}

}
