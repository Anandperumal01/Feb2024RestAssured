package tescases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deleterecord {
	
	
	
	@Test
	public void getalltheuser() {
		//Request url
		//http://localhost:3000/customers
		//form the baseuri
		RestAssured.baseURI="http://localhost:3000";
		
		// Formation of Request
		
		RequestSpecification httprequest=RestAssured.given();
		Response response=httprequest.request(Method.DELETE,"/customers/8495");
		
	     String responseBody=response.getBody().asString();
	     
	     System.out.println("the response value is"+responseBody);
	     
	     // validation
	     Assert.assertEquals(response.statusCode(), 200);
	     
	     //to retrive header values
	     
	     Headers allheaders=response.headers();
	     
	     for(Header header:allheaders) {
	    	 
	    	 System.out.println(header.getName()+" ====>"+header.getValue());
	    	 
	     }
	     
	     // responsebody validation
	     
	   //  Assert.assertEquals(responseBody.contains("customer6"), true);
	     
	     
		
		
		
		
		
		
		
		
	}

}
