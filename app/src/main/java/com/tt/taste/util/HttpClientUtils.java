package com.tt.taste.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.util.Log;

public class HttpClientUtils {

	private final static String REQUEST_MOTHOD = "POST";
	private final static String ENCODE_TYPE = "UTF-8";
	private final static int TIME_OUT = 4000;
	static HttpClient httpClient = new DefaultHttpClient();
	static String responseString = "";
	static Map<String, String> paramsMap;

	/**
	 * Get请求
	 * 
	 * @param
	 * @param url
	 *            网址
	 * @param mQueue
	 *            请求队列
	 * @return 响应的json数据
	 */
	public static String httpGetRequest(String url, Map<String, String> params) {
		setTimeOut();
		String result = null;
		// 先将参数放入List，再对参数进行URL编码
		List<BasicNameValuePair> paramsList = new LinkedList<BasicNameValuePair>();
		for (String key : params.keySet()) {
			paramsList.add(new BasicNameValuePair(key, params.get(key)));
		}
		// 对参数编�?
		String param = URLEncodedUtils.format(paramsList, ENCODE_TYPE);
		// 将URL与参数拼�?
		HttpGet getMethod = new HttpGet(url + "?" + param);
		try {
			HttpResponse response = httpClient.execute(getMethod); // 发起GET请求
			result = EntityUtils.toString(response.getEntity(), ENCODE_TYPE);
			Log.i("GETCODE", "resCode = " + response.getStatusLine().getStatusCode()); // 获取响应�?
			Log.i("GETRESULT", "result = " + result);// 获取服务器响应内�?
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String httpPostRequest(String url, Map<String, String> params) {
		setTimeOut();
		String result = null;
		// 和GET方式�?样，先将参数放入List
		List<BasicNameValuePair> paramsList = new LinkedList<BasicNameValuePair>();
		for (String key : params.keySet()) {
			paramsList.add(new BasicNameValuePair(key, params.get(key)));
		}
		try {
			HttpPost postMethod = new HttpPost(url);
			postMethod.setEntity(new UrlEncodedFormEntity(paramsList, ENCODE_TYPE)); // 将参数填入POST
																						// Entity�?
			HttpResponse response = httpClient.execute(postMethod); // 执行POST方法
			result = EntityUtils.toString(response.getEntity(), ENCODE_TYPE);
			Log.i("POSTCODE", "resCode = " + response.getStatusLine().getStatusCode()); // 获取响应�?
			Log.i("POSTRESULT", "result = " + result); // 获取响应内容
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	
	private static void setTimeOut(){
		HttpParams params=httpClient.getParams();
		HttpConnectionParams.setConnectionTimeout(params, TIME_OUT);  
        HttpConnectionParams.setSoTimeout(params, TIME_OUT);
	}
	
	
}
