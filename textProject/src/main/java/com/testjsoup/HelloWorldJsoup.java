package com.testjsoup;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class HelloWorldJsoup {
	@Test
	public void helloWorldJsoup01() throws ClientProtocolException, IOException {
		// 创建httpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建httpGet实例
		HttpGet httpGet = new HttpGet("https://www.cnblogs.com/");
		// 设置头信息（模拟浏览器请求）
		httpGet.addHeader("user-agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
		// 执行httpClient请求
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// 获取返回实体
		HttpEntity entity = response.getEntity();
		// 获取响应类型
		System.out.println("响应类型：" + entity.getContentType().getValue());
		// 返回状态信息 (getStatusCode() 之返回状态信息 不返回版本信息)
		System.out.println("Status:" + response.getStatusLine().getStatusCode());
		String content=EntityUtils.toString(entity,"utf-8");
		response.close();
		httpClient.close();
		//将获取到的页面内容放入jsoup,并解析得到文档对象
		Document doc=Jsoup.parse(content);
		//获取tag是title的所有Dom元素
		Elements elements=doc.getElementsByTag("title");
		//获取第一个元素
		Element element=elements.get(0);
		//返回元素的文本
		String title=element.text();
		System.out.println("网页标题是："+title);
		Element elements2=doc.getElementById("site_nav_top");
		String site_nav_top=elements2.text();
		System.out.println("site_nav_top:"+site_nav_top);
        //根据样式名称来查询DOM
		Elements elements3=doc.getElementsByClass("post_item");
		System.out.println("====================");
		for (Element e : elements3) {
			System.out.println(e.html());
			System.out.println("----------------------------------------");
		}
	}
	
	@Test
	public void helloWorldJsoup02() throws ClientProtocolException, IOException {
		// 创建httpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建httpGet实例
		HttpGet httpGet = new HttpGet("https://www.cnblogs.com/");
		// 设置头信息（模拟浏览器请求）
		httpGet.addHeader("user-agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
		// 执行httpClient请求
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// 获取返回实体
		HttpEntity entity = response.getEntity();
		// 获取响应类型
		System.out.println("响应类型：" + entity.getContentType().getValue());
		// 返回状态信息 (getStatusCode() 之返回状态信息 不返回版本信息)
		System.out.println("Status:" + response.getStatusLine().getStatusCode());
		String content=EntityUtils.toString(entity,"utf-8");
		response.close();
		httpClient.close();
		//将获取到的页面内容放入jsoup,并解析得到文档对象
		Document doc=Jsoup.parse(content);
		//通过选择器查找查找所有博客链接
		Elements linkElements= doc.select(".post_item .post_item_body h3 a");
		for (Element e : linkElements) {
			System.out.println("博客标题:"+e.text());
			System.out.println("----------------------------------------");
		}
		/*
		 * 查找扩展名为。png的图片dom节点
		 * $ 表示以什么结尾
		 */
		Elements imgElements =doc.select("img[src$=.png]");
		for (Element e : imgElements) {
			System.out.println("图片:"+e.toString());
			System.out.println("----------------------------------------");
		}
	}
	
	
	@Test
	public void helloWorldJsoup03() throws ClientProtocolException, IOException {
		// 创建httpClient实例
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// 创建httpGet实例
		HttpGet httpGet = new HttpGet("https://www.cnblogs.com/");
		// 设置头信息（模拟浏览器请求）
		httpGet.addHeader("user-agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
		// 执行httpClient请求
		CloseableHttpResponse response = httpClient.execute(httpGet);
		// 获取返回实体
		HttpEntity entity = response.getEntity();
		// 获取响应类型
		System.out.println("响应类型：" + entity.getContentType().getValue());
		// 返回状态信息 (getStatusCode() 之返回状态信息 不返回版本信息)
		System.out.println("Status:" + response.getStatusLine().getStatusCode());
		String content=EntityUtils.toString(entity,"utf-8");
		response.close();
		httpClient.close();
		//将获取到的页面内容放入jsoup,并解析得到文档对象
		Document doc=Jsoup.parse(content);
		//通过选择器查找查找所有博客链接
		Elements linkElements= doc.select("#post_list .post_item .post_item_body h3 a");
		for (Element e : linkElements) {
			System.out.println("博客标题:"+e.text());
			System.out.println("链接地址："+e.attr("href"));
			System.out.println("跳转方式："+e.attr("target"));
			System.out.println("----------------------------------------");
		}
	}
}
