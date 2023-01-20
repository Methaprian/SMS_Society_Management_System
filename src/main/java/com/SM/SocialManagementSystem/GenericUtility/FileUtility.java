package com.SM.SocialManagementSystem.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * @author METHAPRIAN S.K
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDatafromPropertyFile(String key) throws Throwable {
		FileInputStream fisProperties = new FileInputStream(IPathConstants.filePATH);
		Properties pObj = new Properties();
		pObj.load(fisProperties);
		String value = pObj.getProperty(key);
		return value;
	}
}
