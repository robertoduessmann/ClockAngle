package com.math.clockangle.util;

import org.json.simple.JSONObject;

public class JsonUtil {
	
	private static JSONObject obj;
	
	public static String generateAngleJson (double angle){
		
		obj = new JSONObject();
		obj.put("angle", angle);
		
		return obj.toJSONString();
	}
	
	public static String generateErrorJson (String message){
		
		obj = new JSONObject();
		obj.put("error", message);
		
		return obj.toJSONString();
	}
	
}
