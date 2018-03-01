package com.javen.testwebservice;

public class WeatherServiceImpl implements WeatherService{

	public String getWeather(String weatherName) {
		if (weatherName.equals("北京")) {
			return "雾霾";
		}
		return "暂时为提供该城市的服务";
	}

}
