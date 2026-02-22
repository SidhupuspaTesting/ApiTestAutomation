import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.ReusableMethod;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	//here give the data provider name from where you will get data
@Test(dataProvider = "BooksData")
public void addBook(String isbn,String aisle)

{
	//i want to send parameter for isbn, and aisle
	RestAssured.baseURI="http://216.10.245.166";
	String response=given().header("Content-Type","application/json")
			.body(payload.AddBook("adsfs","6464")).
	when().post("/Library/Addbook.php").
	then().assertThat().statusCode(200).extract().response().asString();
   JsonPath js = ReusableMethod.rawToJson(response)	;
   //This is the sample response :
//
//   {
//       "Msg": "successfully added",
//       "ID": "bcd237"
//   }
//
//   Now our goal is to extract the id from response

  String id=  js.getString("ID");
  System.out.println(id);
  //Here inplace of payload.Addbook(), I want to paas some dynamic value , 
  //that will replace value in payload file, where Add book body exist
}
  @DataProvider(name= "BooksData")
  public Object[][] getData()
  
  {
	  //multi dimension array
	  //we return object , so return type should be Object[][]
	  //give a name to data provider
	   return new Object [][] {{"Book001","1111"},{"Book002","1112"},{"Book003","1113"}};
  }
}

