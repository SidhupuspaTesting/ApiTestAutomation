import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// declare the body in generic  class so that body can be reusable
		
//create jsonpath object and pass the generic class method here CoursePrice() initialized in payload.java
				

JsonPath js =new JsonPath(payload.CoursePrice());
//Q1: print no of cources returned by api:
//size will return no of iteam 
int count =js.getInt("courses.size()");
System.out.println(count);

//Print Purchase Amount which is present in api response inside dashboard 
//since o/p is int value , so we will use getInt()
int totalAmount=js.getInt("dashboard.purchaseAmount");
System.out.println(totalAmount);
//3. Print Title of the first course
String titleFirstCourse=js.getString("courses[0].title");
System.out.println(titleFirstCourse);
//Print All course titles and their respective Prices.So today there are three courses,
//but everyday when you hit that API,you might get 10 courses, 12 courses, or 15 courses because we don't know
//how many courses are purchased on daily basis.So this array is dynamic.Okay, now if you are asked to get
//all the course titles and their prices and if this array is dynamic,how would you write code?
//Ans: we can use simple for loop to solve this.
//int count =js.getInt("courses.size()"); earlier we got size of array
for(int i=0;i<count;i++)
{
	String course_title=js.get("courses["+i+"].title");
	int cource_price=js.getInt("courses["+i+"].price");
	System.out.println(course_title);
	System.out.println(cource_price);
}



	}

}
