package main.scs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import org.apache.log4j.Logger;

public class DBConnection
{
	static Logger logger = Logger.getLogger(DBConnection.class);

	public static Connection getDBConnection()
	{
		Connection con = null;
		try
		{
			Properties dbProperty = new Properties();

			dbProperty.load(DBConnection.class.getClassLoader().getResourceAsStream("main/resources/project.properties"));

			String fullURL = dbProperty.getProperty("DRIVER") + "://" + dbProperty.getProperty("HOST") + "/" + dbProperty.getProperty("DBNAME");

			String user = dbProperty.getProperty("USER");
			String password = dbProperty.getProperty("PASS");
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection(fullURL, user, password);
		}
		catch (Exception e)
		{
			logger.error(" Error while creating DBConnection in getDBConnection " + e.getMessage(), e);
		}

		return con;
	}

}
