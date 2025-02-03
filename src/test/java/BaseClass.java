import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static org.hamcrest.Matchers.*;



public class BaseClass {
	
	
	public static void main(String[] args) {
		RestAssured.baseURI= "https://api.coindesk.com";
		
		
		
		String response= given().log().all()
		.when().get("v1/bpi/currentprice.json")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		  String firstbpicode=js.get("bpi.USD.code");
		  System.out.println(firstbpicode);
		  String expected = "USD";
		  Assert.assertEquals(firstbpicode, expected);
		  
		  String secondbpicode=js.get("bpi.GBP.code");
		  System.out.println(secondbpicode);
		  String expected1 = "GBP";
		  Assert.assertEquals(secondbpicode, expected1);
		  
		  String thirdbpicode=js.get("bpi.EUR.code");
		  System.out.println(thirdbpicode);
		  String expected2 = "EUR";
		  Assert.assertEquals(thirdbpicode, expected2);
		  
		  String secondbpidescription=js.get("bpi.GBP.description");
		  System.out.println(secondbpidescription);
		  String expected3 = "British Pound Sterlin";
		  Assert.assertEquals(secondbpidescription, expected3);
	}	
	
}
