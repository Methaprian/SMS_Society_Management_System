package com.SM.SocialManagementSystem.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * @author METHAPRIAN S.K
	 * @param ranNo
	 * @return
	 */
	public int getRandomNo(){
		Random rn = new Random();
		int randomNo = rn.nextInt(500);
		return randomNo;
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * @return
	 */
	public String getSystemDate() {
		SimpleDateFormat dateFormat=new SimpleDateFormat("DD-MM-yyyy HH:mm:ss");
		Date sysDate=new Date();
		String systemDateAndTime=dateFormat.format(sysDate);
		return systemDateAndTime.replaceAll(":", "-");
	}
}
