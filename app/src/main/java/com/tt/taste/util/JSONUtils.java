package com.tt.taste.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;



public class JSONUtils {

	
	private static Gson gson = new Gson();  
	/**
	 * ����json���ݵ�ʵ��
	 * @param typeOfT
	 * @param jsonString
	 * @return
	 */
	 public static <T> T jsonToBean(Type typeOfT, String jsonString) {  
	        T t = null;  
	        try {  
	            t = gson.fromJson(jsonString, typeOfT);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return t;  
	    }  
	
}
