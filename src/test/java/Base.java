import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;

import static io.restassured.RestAssured.*;

public class Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Now we will validate if in response we are getting APP or not . We will validate the output 
RestAssured.baseURI="https://rahulshettyacademy.com";
String respone=given().log().all().queryParam("key","qaclick123").header("Content-Type", "application/json")
.body(payload.AddPlace()).when().log().all().post("maps/api/place/add/json").then().log().all().assertThat()
.statusCode(200).body("scope",equalTo("APP")).header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

System.out.println(respone);
//get the responsr and extract place id

JsonPath js = new JsonPath(respone);
String placeid=js.getString("place_id");
System.out.println(placeid);
//update place using put method
//now validate the response msg if updated or not  from the response 
given().log().all().queryParam("key","qaclick123").header("Content-Type", "application/json").body("{\r\n"
		+ "\"place_id\":\""+placeid+"\",\r\n"
		+ "\"address\":\"70 Summer walk, USA\",\r\n"
		+ "\"key\":\"qaclick123\"\r\n"
		+ "}\r\n"
		+ "").when().put("maps/api/place/update/json").then().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated"));
//now verify address also, updated or not according to place id, using get
String getplaceResponse=given().log().all().queryParam("key","qaclick123").queryParam("place_id", placeid).log().all().when().get("/maps/api/place/get/json").then()
.log().all().assertThat().statusCode(200).extract().response().asString();

JsonPath js1= new JsonPath(getplaceResponse);
String actualAddress=js1.getString("address");
String expected_address="70 Summer walk, USA";

if(actualAddress.equals(expected_address))
{
	System.out.println("address updated");
}	
//or validate using testng
Assert.assertEquals(expected_address, actualAddress);
}

		
}

