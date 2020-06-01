package main.scs.common;

import java.io.IOException;
import java.util.Properties;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.apache.log4j.Logger;

public class CommonConstants
{

	static Logger logger = Logger.getLogger(CommonConstants.class);
	public static String salt;
	public static int strength = 8;

	public static String getPasswordHash(String userPassword) throws IOException
	{
		String passwordHash = null;
		Properties p = new Properties();
		p.load(CommonConstants.class.getClassLoader().getResourceAsStream("main/resources/project.properties"));
		salt = p.getProperty("SALT");
		try
		{
			PBEKeySpec spec = new PBEKeySpec(userPassword.toCharArray(), CommonConstants.salt.getBytes("UTF-8"), CommonConstants.strength, 32 * 8);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] hash = skf.generateSecret(spec).getEncoded();
			passwordHash = Hex.encodeHexString(hash);
		}
		catch (Exception e)
		{
			logger.error(" Error while PasswordHash in CommonConstants - " + e.getMessage(), e);
		}

		return passwordHash;
	}

	public static boolean checkForNullAndBlank(String string)
	{
		if (string == null || string.isEmpty())
		{
			return true;
		}
		return false;
	}
}
