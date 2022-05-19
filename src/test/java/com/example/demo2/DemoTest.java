package com.example.demo2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class DemoTest {
	
	public static void main(String[] args) {
		RequestSpecification request;
		Response response;
		
		RestAssured.baseURI = "http://localhost:3001/teste";
		String body = "{\r\n"
				+ "    \"nome\": \"Pessoa de Testes 1\",\r\n"
				+ "    \"pergunta\": \"Que dia é hoje?\"\r\n"
				+ "}";
		
		request =   given().contentType(ContentType.JSON).body(body).when();
		
		response = request.post();
		
		System.out.println(response.getTime());
		System.out.println(response.getStatusCode());
		System.out.println(response.jsonPath().get("resposta").toString());
		
		
		
	}

}
