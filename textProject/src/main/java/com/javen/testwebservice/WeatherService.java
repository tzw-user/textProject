package com.javen.testwebservice;

import javax.jws.WebService;

@WebService
public interface WeatherService {
    
	public String getWeather(String weatherName);
	
}
