package com.common.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapUtils {
	
	 /** 
     * 将对象转换为json字符串 
     * @param obj 
     * @return 
     * @throws Exception 
     */  
    public static String obj2string(Object obj) {  
        StringWriter sw = new StringWriter();  
        ObjectMapper mapper = new ObjectMapper();  
        try {  
            mapper.writeValue(sw, obj);  
        } catch (Exception e) {  
        }  
        return sw.toString();  
    }  
  
    /** 
     * 将字符串转list对象 
     * @param <T> 
     * @param jsonStr 
     * @param cls 
     * @return 
     */  
    public static <T> List<T> str2list(String jsonStr, Class<T> cls) {  
        ObjectMapper mapper = new ObjectMapper();  
        List<T> objList = null;  
        try {  
            JavaType t = mapper.getTypeFactory().constructParametricType(  
                    List.class, cls);  
            objList = mapper.readValue(jsonStr, t);  
        } catch (Exception e) {  
        }  
        return objList;  
    }  
  
    /** 
     * 将字符串转为对象 
     * @param <T> 
     * @param jsonStr 
     * @param cls 
     * @return 
     */  
    public static <T> T str2obj(String jsonStr, Class<T> cls) {  
        ObjectMapper mapper = new ObjectMapper();  
        T obj = null;  
        try {  
            obj = mapper.readValue(jsonStr, cls);  
        } catch (Exception e) {  
        }  
        return obj;  
    }  
      
      
    /** 
     * 将字符串转为json节点 
     * @param jsonStr 
     * @return 
     */  
    public static JsonNode str2node(String jsonStr) {  
        ObjectMapper mapper = new ObjectMapper();  
        try {  
            return mapper.readTree(jsonStr);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
    public static Map<String, Object> jsonToMap(String json){
    	return JSONObject.parseObject(json,Map.class); 
    }
    
    /**  
     * 字节数组转对象  
     * @param bytes  
     * @return  
     */  
    public static Object toObject (byte[] bytes) {      
        Object obj = null;      
        try {        
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);        
            ObjectInputStream ois = new ObjectInputStream (bis);        
            obj = ois.readObject();      
            ois.close();   
            bis.close();   
        } catch (IOException ex) {        
            ex.printStackTrace();   
        } catch (ClassNotFoundException ex) {        
            ex.printStackTrace();   
        }      
        return obj;    
    }   
    
}
