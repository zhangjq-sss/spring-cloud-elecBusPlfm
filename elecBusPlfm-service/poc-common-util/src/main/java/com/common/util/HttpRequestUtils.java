package com.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HttpRequestUtils {
	
	/**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求Map参数，请求参数应该是 {"name1":"value1","name2":"value2"}的形式。
     * @param charset         
     *             发送和接收的格式
     * @return URL 所代表远程资源的响应结果
     */
    @SuppressWarnings("rawtypes")
	public static String sendGet(String url, Map<String,Object> map,String charset){
          StringBuffer sb=new StringBuffer();
          //构建请求参数
          if(map!=null&&map.size()>0){
              Iterator it=map.entrySet().iterator(); //定义迭代器
              while(it.hasNext()){
                 Map.Entry  er= (Entry) it.next();
                 sb.append(er.getKey());
                 sb.append("=");
                 sb.append(er.getValue());
                 sb.append("&");
             }
          }
       return sendGet(url,sb.toString(), charset);
    }


    /**
     * 向指定URL发送POST方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求Map参数，请求参数应该是 {"name1":"value1","name2":"value2"}的形式。
     * @param charset         
     *             发送和接收的格式
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendPost(String url, Map<String,Object> map,String charset){
          StringBuffer sb=new StringBuffer();
          //构建请求参数
          if(map!=null&&map.size()>0){
                for (Entry<String, Object> e : map.entrySet()) {  
                    sb.append(e.getKey());  
                    sb.append("=");  
                    sb.append(e.getValue());  
                    sb.append("&");  
                }  
          }
       return  sendPost(url,sb.toString(),charset);
    }


    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param charset         
     *             发送和接收的格式
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param,String charset) {
        String result = "";
        String line;
        StringBuffer sb=new StringBuffer();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性 设置请求格式
            conn.setRequestProperty("contentType", charset); 
            conn.setRequestProperty("content-type", "application/json");
            //设置超时时间
            conn.setConnectTimeout(60);
            conn.setReadTimeout(60);
            // 建立实际的连接
            conn.connect();
            // 定义 BufferedReader输入流来读取URL的响应,设置接收格式
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(),charset));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result=sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @param charset         
     *             发送和接收的格式       
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param,String charset) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        String line;
        StringBuffer sb=new StringBuffer();
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接 
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性 设置请求格式
            conn.setRequestProperty("contentType", charset);  
            conn.setRequestProperty("content-type", "application/json");
            //设置超时时间
            conn.setConnectTimeout(2000);
            conn.setReadTimeout(1000);
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应    设置接收格式
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),charset));
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            result=sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }  

   /**
    * 
   * @Method: sendPostJsonByHttpURLConnection   
   * @Description: 通过HttpURLConnection实现
   * @param url
   * @param Params json字符串
   * @return
   * @throws IOException   
   * @throws
    */
	public static String sendPostJsonByHttpURLConnection(String url, String Params, String charset) throws IOException {
		OutputStreamWriter out = null;
		BufferedReader reader = null;
		String response = "";

		URL httpUrl = null; // HTTP URL类 用这个类来创建连接
		// 创建URL
		httpUrl = new URL(url);
		// 建立连接
		HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("connection", "keep-alive");
		conn.setUseCaches(false);// 设置不要缓存
		conn.setInstanceFollowRedirects(true);
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.connect();
		// POST请求
		out = new OutputStreamWriter(conn.getOutputStream());
		out.write(Params);
		out.flush();
		// 读取响应
		reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String lines;
		while ((lines = reader.readLine()) != null) {
			lines = new String(lines.getBytes(), charset);
			response += lines;
		}
		reader.close();
		// 断开连接
		conn.disconnect();

//		log.info(response.toString());
		try {
			if (out != null) {
				out.close();
			}
			if (reader != null) {
				reader.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return response;
	}
	
	public static void main(String[] args) {
		Map<String,Object> map = new HashMap<>();
		map.put("mcc", 460);
		map.put("mnc", 1);
		map.put("lac", 4301);
		map.put("ci", 20986);
		map.put("output", "json");
		System.out.println(sendGet("http://api.cellocation.com:81/cell/", map, "utf-8"));
		System.out.println(JsonMapUtils.jsonToMap(sendGet("http://api.cellocation.com:81/cell/", map, "utf-8")));
	}
}
