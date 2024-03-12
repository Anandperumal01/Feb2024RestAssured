package DataParameterisation;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.XLutils;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Addrecord {
	
	
	@Test(dataProvider="getData")
	public void addcustomer(String CustomerName,String CustomerAddress,String CustomerMobileNumber,String Customerid) {
		
		
		//Request url
				//http://localhost:3000/customers
				//form the baseuri
				RestAssured.baseURI="http://localhost:3000";
				RequestSpecification httprequest=RestAssured.given();
				
				// Formation of Request
				//we have to create JSON object
				JSONObject requestparameters=new JSONObject();
				requestparameters.put("Customerid", Customerid);
				requestparameters.put("CustomerName", CustomerName);
				requestparameters.put("CustomerAddress", CustomerAddress);
				requestparameters.put("CustomerMobileNumber", CustomerMobileNumber);
				
				httprequest.header("Content-Type","application/json");
				httprequest.body(requestparameters.toJSONString());
				
				
				
				
				Response response=httprequest.request(Method.POST,"/customers");
				
			     String responseBody=response.getBody().asString();
			     
			     System.out.println("the response value is"+responseBody);
			     
			     // validation
			     Assert.assertEquals(response.statusCode(), 201);
			     
			     //to retrive header values
			     
			     Headers allheaders=response.headers();
			     
			     for(Header header:allheaders) {
			    	 
			    	 System.out.println(header.getName()+" ====>"+header.getValue());
			    	 
			     }
		
	}
	@DataProvider
	public String[][] getData() throws IOException {
		int rowcount=XLutils.getRowCount("C:\\Users\\Anand\\Desktop\\API\\TestData.xlsx", "Sheet1");
		
		int colcount=XLutils.getColCount("C:\\Users\\Anand\\Desktop\\API\\TestData.xlsx", "Sheet1",1);
		
		
		String[][] data=new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				data[i-1][j]=XLutils.getCellData("C:\\Users\\Anand\\Desktop\\API\\TestData.xlsx", "Sheet1", i, j);
				
			}
		}
		
		
		return data;
		
	}

}
