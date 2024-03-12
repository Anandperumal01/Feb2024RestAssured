package tescases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class updaterecord {
	
	
	@Test
	public void updatecustomer() {
		
		
		//Request url
				//http://localhost:3000/customers
				//form the baseuri
				RestAssured.baseURI="http://localhost:3000";
				RequestSpecification httprequest=RestAssured.given();
				
				// Formation of Request
				//we have to create JSON object
				JSONObject requestparameters=new JSONObject();
				requestparameters.put("Customerid", 3000);
				
				requestparameters.put("CustomerAddress", "Delhi");
				requestparameters.put("CustomerMobileNumber", "3723872389578375");
				
				httprequest.header("Content-Type","application/json");
				httprequest.body(requestparameters.toJSONString());
				
				
				
				
				Response response=httprequest.request(Method.PATCH,"/customers/54ee");
				
			     String responseBody=response.getBody().asString();
			     
			     System.out.println("the response value is"+responseBody);
			     
			     // validation
			     Assert.assertEquals(response.statusCode(), 200);
			     
			     //to retrive header values
			     
			     Headers allheaders=response.headers();
			     
			     for(Header header:allheaders) {
			    	 
			    	 System.out.println(header.getName()+" ====>"+header.getValue());
			    	 
			     }
		
	}

}
