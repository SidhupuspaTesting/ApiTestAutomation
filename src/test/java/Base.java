import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

import files.payload;

import static io.restassured.RestAssured.*;

public class Base {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Now we will validate if in response we are getting APP or not . We will validate the output 
RestAssured.baseURI="https://rahulshettyacademy.com";
given().log().all().queryParam("key","qaclick123").header("Content-Type", "application/json")
.body(payload.AddPlace()).when().log().all().post("maps/api/place/add/json").then().log().all().assertThat()
.statusCode(200).body("scope",equalTo( "APP")).header("server", "Apache/2.4.52 (Ubuntu)");
//we are validating the response where scope = app coming or not ,
//and validating one header response let ex: Servername in header server is apache or not
//and equals to is a static method so need to import manually
//isequals to can imported from org.hamcrest.Matchers.*;	
// now add a place using update place api : i.e put method:



	} 	

}
