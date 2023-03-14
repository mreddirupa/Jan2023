package com.restapi;


import static org.hamcrest.Matchers.is;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class EmployeeDetails {
	String token;
	@BeforeClass
	public void init() {
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
	}
	
	
	@Test
	public void listofrecords() {
		RequestSpecBuilder spec = new RequestSpecBuilder();
		spec.addCookie("XSRF-TOKEN=eyJpdiI6IjZUR0JXK2dlTEFiQWlxK1VmU0V2TEE9PSIsInZhbHVlIjoiVnZYTkJGRUgzbFM1RTZXK3VCTEF2cmJWdG5vbFZsOGpaRzVFdWZIdU9abmFLM05aS2dvU29DWEM1NkJJdFlhdyIsIm1hYyI6ImIwOWExNGZmYWQxMWUxNzhmMzBlMGFmZWM1MzZlOWQyZTk4MTA0OGY1YWU4ZTNkNjBhNTYxNmY2MzhhNjMwZmMifQ%3D%3D; laravel_session=eyJpdiI6InU4ZG1WU3drV0dXZm1SWXc4V25lUUE9PSIsInZhbHVlIjoiL0ZGVEEzWjZteGY4bFg1OUp6OEs1eGlUMFpCN3VJeWgzdFZQWXdCUlNRcGx5YmF0RHl0d0RRNm5TU2g2UTNGTCIsIm1hYyI6ImQxMzM0M2FhMmUyZjI2YjYyNmQxNWU2MDczNTMzYjkxMTYzNjBhMzg3MDdjMGU5YjJiNjM5ZTc0NTAyMWZhYjcifQ%3D%3D");
		spec.setContentType("application/json");
		RequestSpecification request=RestAssured.given();
		Response res= request.when().get("/employees");
		int statuscode = res.statusCode();
		System.out.println("Status code="+statuscode);
		res.prettyPrint();
		
		
		res.then()
	//	.statusCode(200)
		.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("src/test/resources/Employeeschema.json"));
		
	 	EmployerDataResponsePOJO[] data=res.as(EmployerDataResponsePOJO[].class);//de serialization
	  //  System.out.println("number of records="+data.length);
	    System.out.println("total records="+res.body().jsonPath().get("size()"));
		
		//System.out.println("2nd record account no="+data[1].getAccountno());
	
		
	}

	
	@Test (dependsOnMethods = "listofrecords")
	public void CreateEmployee() {
		RequestSpecBuilder spec = new RequestSpecBuilder();
		spec.addCookie("XSRF-TOKEN=eyJpdiI6IjZUR0JXK2dlTEFiQWlxK1VmU0V2TEE9PSIsInZhbHVlIjoiVnZYTkJGRUgzbFM1RTZXK3VCTEF2cmJWdG5vbFZsOGpaRzVFdWZIdU9abmFLM05aS2dvU29DWEM1NkJJdFlhdyIsIm1hYyI6ImIwOWExNGZmYWQxMWUxNzhmMzBlMGFmZWM1MzZlOWQyZTk4MTA0OGY1YWU4ZTNkNjBhNTYxNmY2MzhhNjMwZmMifQ%3D%3D; laravel_session=eyJpdiI6InU4ZG1WU3drV0dXZm1SWXc4V25lUUE9PSIsInZhbHVlIjoiL0ZGVEEzWjZteGY4bFg1OUp6OEs1eGlUMFpCN3VJeWgzdFZQWXdCUlNRcGx5YmF0RHl0d0RRNm5TU2g2UTNGTCIsIm1hYyI6ImQxMzM0M2FhMmUyZjI2YjYyNmQxNWU2MDczNTMzYjkxMTYzNjBhMzg3MDdjMGU5YjJiNjM5ZTc0NTAyMWZhYjcifQ%3D%3D");
		spec.setContentType("application/json");
		RequestSpecification request=RestAssured.given().body("{\"name\":\"RM\",\"salary\":\"123\",\"age\":\"23\",\"id\":\"50\"}");
		Response res= request.when().post("/create");
		int statuscode = res.statusCode();
		System.out.println("Status code="+statuscode);
		res.prettyPrint();
		res.then().body("status",is("success"));
		

		
	//	res.then()
	//	.statusCode(200)
	//	.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("src/test/resources/Employeeschema.json"));
		
		EmployerDataResponsePOJO[] data=res.as(EmployerDataResponsePOJO[].class);//de serialization	
		
}
}
