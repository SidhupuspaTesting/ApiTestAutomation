import io.restassured.RestAssured .*;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured .*;



public class OAuthTest {
	public static void main(String[] args) {
		String response=given()
		//last time it was query parameter , 
		//but this time we are sending as form parameter
		//if there is query parameter you can write queryparams
		//here give credential id and credential secret in key value pair
		//first 3 are mandatory, other formparameter are optional
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust").
		//there is no body so, just log it to see what it is sending as rqst
		when().log().all().
		post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
	
	System.out.println(response);
	JsonPath js = new JsonPath(response);
	String accessToken=js.getString("access_token");
	
	//get course detail using the token from the response
	String respose2=given().
	queryParam("access_token", accessToken).
	when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();
	System.out.println(respose2);
	}

}
