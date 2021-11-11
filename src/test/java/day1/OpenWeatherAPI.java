package day1;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OpenWeatherAPI {
	@Test
	public void getWeatherInfo() {
		/*
		  Given > Pre-Condition 
		  When > user perform Something Then >excepted outcome
		  from the system
		 */  
		RestAssured.given()
		.when()
		.get("https://api.openweathermap.org/data/2.5/weather?q=Bangalore&appid=8c94a22f753affbb629af546224dc878")
		.then()
		.log()
		.body()
		.statusCode(200);	
	}
	@Test (enabled = false, description ="Getting weather API information Generally")
	public void getWeatherInfo2() {
		Response res = RestAssured.given().when().get("https://api.openweathermap.org/data/2.5/weather?q=Bangalore&appid=8c94a22f753affbb629af546224dc878");
		
		System.out.println(res.prettyPrint());
		System.out.println(res.getTime());
		System.out.println(res.getStatusCode());
		System.out.println(res.getContentType());
	}
		
		@Test (enabled = true, description ="Getting weather API information Generally")
		public void getWeatherInfo3() {
			Map<String, String> param = new HashMap<String,String>();
			 RestAssured.given()
			        .queryParam("q", "Bangalore")
					.queryParam("appid", "8c94a22f753affbb629af546224dc878")
					.when().get("https://home.openweathermap.org/data/2.5/weather")
					.then()
					.log()
					.body()
					.statusCode(200);	
	}
	
	
}
