package com.httpclient;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HelloWorld {
  
	
	/**
	 * httpClient访问
	 */
	@Test
	public void helloworld() {
		CloseableHttpClient httpClient = HttpClients.createDefault();// 创建httpClient实例
		HttpGet httpGet = new HttpGet("http://www.baidu.com");// 创建httpget实例
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(httpGet);// 执行httpclient请求
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		HttpEntity entity = response.getEntity();// 获取返回实体
		if(entity!=null){
			try {
				System.out.println("网页的源码：" + EntityUtils.toString(entity, "utf-8"));// 获取网页内容并指定编码
			} catch (ParseException e) {// 解析异常
				e.printStackTrace();
			} catch (IOException e) { // IO异常
				e.printStackTrace();
			}
		}
		try {
			response.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    /**
     * 1.设置头信息（模拟浏览器请求）
     * 2.获取响应类型
     * 3.返回状态信息 (getStatusCode() 之返回状态信息 不返回版本信息)
     * @throws ClientProtocolException
     * @throws IOException
     */
	@Test
	public void helloworld02() throws ClientProtocolException, IOException {
		// 创建httpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建httpGet实例
		HttpGet httpGet = new HttpGet("http://www.tuicool.com");
		//设置头信息（模拟浏览器请求）
		httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
		// 执行httpClient请求
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// 获取返回实体
		HttpEntity entity = response.getEntity();
		//获取响应类型
		System.out.println("响应类型："+entity.getContentType().getValue());
		//返回状态信息 (getStatusCode() 之返回状态信息 不返回版本信息)
		System.out.println("Status:"+response.getStatusLine().getStatusCode());
		//System.out.println("网页的源码：" + EntityUtils.toString(entity, "utf-8"));// 获取网页内容并指定编码
		response.close();
		httpClient.close();
	}
	
	/**
	 * 爬图片
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void helloworld03() throws ClientProtocolException, IOException {
		// 创建httpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建httpGet实例
		HttpGet httpGet = new HttpGet("http://blog.java1234.com/static/images/logo.png");
		//设置头信息（模拟浏览器请求）
		httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
		// 执行httpClient请求
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// 获取返回实体
		HttpEntity entity = response.getEntity();
		if(entity!=null){
			//获取响应类型
			System.out.println("响应类型："+entity.getContentType().getValue());
			InputStream inputStream=entity.getContent();
			FileUtils.copyToFile(inputStream, new File("G://123.jpg"));
		}
		//返回状态信息 (getStatusCode() 之返回状态信息 不返回版本信息)
		System.out.println("Status:"+response.getStatusLine().getStatusCode());
		//System.out.println("网页的源码：" + EntityUtils.toString(entity, "utf-8"));// 获取网页内容并指定编码
		response.close();
		httpClient.close();
	}
	
	/**
	 * 设置代理
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void helloworld04() throws ClientProtocolException, IOException {
		// 创建httpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建httpGet实例
		HttpGet httpGet = new HttpGet("http://www.tuicool.com");
		
		HttpHost proxy=new HttpHost("61.135.217.7", 80);
		RequestConfig config=RequestConfig.custom().setProxy(proxy).build();
		httpGet.setConfig(config);
		//设置头信息（模拟浏览器请求）
		httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
		// 执行httpClient请求
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// 获取返回实体
		HttpEntity entity = response.getEntity();
		/*
		if(entity!=null){
			//获取响应类型
			System.out.println("响应类型："+entity.getContentType().getValue());
			InputStream inputStream=entity.getContent();
			FileUtils.copyToFile(inputStream, new File("G://123.jpg"));
		}*/
		
		//返回状态信息 (getStatusCode() 之返回状态信息 不返回版本信息)
		System.out.println("Status:"+response.getStatusLine().getStatusCode());
		// 获取网页内容并指定编码
		System.out.println("网页的源码：" + EntityUtils.toString(entity, "utf-8"));
		response.close();
		httpClient.close();
	}
	
	/**
	 * 设置连接超时以及读取超时
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	@Test
	public void helloworld05() throws ClientProtocolException, IOException {
		// 创建httpClient实例
				CloseableHttpClient httpClient = HttpClients.createDefault();
				// 创建httpGet实例
				HttpGet httpGet = new HttpGet("http://central.maven.org/maven2/com/");
				
				RequestConfig config=RequestConfig.custom()
						.setConnectTimeout(10000) //设置连接超时
						.setSocketTimeout(10000)//设置读取超时
						.build();
				httpGet.setConfig(config);
				//设置头信息（模拟浏览器请求）
				httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
				// 执行httpClient请求
				CloseableHttpResponse response = httpClient.execute(httpGet);
				// 获取返回实体
				HttpEntity entity = response.getEntity();
				/*
				if(entity!=null){
					//获取响应类型
					System.out.println("响应类型："+entity.getContentType().getValue());
					InputStream inputStream=entity.getContent();
					FileUtils.copyToFile(inputStream, new File("G://123.jpg"));
				}*/
				
				//返回状态信息 (getStatusCode() 之返回状态信息 不返回版本信息)
				System.out.println("Status:"+response.getStatusLine().getStatusCode());
				// 获取网页内容并指定编码
				System.out.println("网页的源码：" + EntityUtils.toString(entity, "utf-8"));
				response.close();
				httpClient.close();
	}
	
}
