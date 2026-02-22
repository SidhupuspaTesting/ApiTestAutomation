package files;

public class payload {

	public static String AddPlace() {
		// TODO Auto-generated method stub
		
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "\r\n"
				+ "";
	}
public static String  CoursePrice() {
	return "{\r\n"
			+ "\"dashboard\": {\r\n"
			+ "\"purchaseAmount\": 910,\r\n"
			+ "\"website\": \"rahulshettyacademy.com\"\r\n"
			+ "},\r\n"
			+ "\"courses\": [\r\n"
			+ "{\r\n"
			+ "\"title\": \"Selenium Python\",\r\n"
			+ "\"price\": 50,\r\n"
			+ "\"copies\": 6\r\n"
			+ "},\r\n"
			+ "{\r\n"
			+ "\"title\": \"Cypress\",\r\n"
			+ "\"price\": 40,\r\n"
			+ "\"copies\": 4\r\n"
			+ "},\r\n"
			+ "{\r\n"
			+ "\"title\": \"RPA\",	\r\n"
			+ "\"price\": 45,\r\n"
			+ "\"copies\": 10\r\n"
			+ "}\r\n"
			+ "]\r\n"
			+ "}\r\n"
			+ "";
}

public static String AddBook(String isbn,String aisle )
{
//how to concat string inside string
//So first point, put a double quote to end this existing string like this you put, and thereafter
//if you want to add variable immediately after string .you have to put plus concatenation operator
//So if you want to continue again, put again plus operator to say that writing variable is done,
//If you want to start variable, you have to start with plus icon and if your variable part is done, again
//you have to give plus operator to say you are done.And if you want to continue with the new string again,
//So you have terminated that string there, right?To open your new string again, put a single
//I mean put a double quote again and that's it.
return "{\r\n"
		+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
		+ "\"isbn\":\""+isbn+"\",\r\n"
		+ "\"aisle\":\""+aisle+"\",\r\n"
		+ "\"author\":\"John foe\"\r\n"
		+ "}";	

//So what we have done now, so these two variables ,we are sending the road test
//and based upon these two variables this Addbook method dynamically creating a new JSON and it's sending back.
}
	
}

