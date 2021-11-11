package day1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*; 
public class PositiveTest {
	String id;
  @Test(enabled = false, description = "For getting all contact list")
  public void getAllContactList() {
	  given().when()
	  .get("http://3.13.86.142:3000/contacts")
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
  }
  @Test(enabled = true, description = "For getting all contact list")
  public void addContact() {
	  
	  JSONObject loc = new JSONObject();
	  loc.put("city", "Dharwad");
	  loc.put("country" , "India");
	  
	  JSONObject emp = new JSONObject();
	  emp.put("JobTitle", "Automation");
	  emp.put("company", "LTI");
	  
	  
	  JSONObject ob = new JSONObject();
	  ob.put("firstName", "Amruta");
	  ob.put("lastName", "Savadi");
	  ob.put("email", "asmith@thinkingtester.com");
	  ob.put("location", loc);
	  ob.put("empolyer", emp);
	  
	       id =given()
			  .header("Content-Type","application/json")
			  .body(ob.toJSONString())
			  .when()
			  .post("http://3.13.86.142:3000/contacts")
			  .then()
			  .log()
			  .body()
			  .statusCode(200)
			  .extract()
			  .jsonPath()
			  .get("_id");
	  System.out.println("ID is " +id);
}
  @Test(enabled = true, dependsOnMethods="addContact", description = "Getting Specific Contact")
  public void getSpecficContact() {
	  
	  given()
	  .when()
	  .get("http://3.13.86.142:3000/contacts/" +id)
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
  }
  @Test(enabled = true, dependsOnMethods = "addContact",description = "For Updating all contact list")
  public void UpdateContact() {
	  
	  JSONObject loc = new JSONObject();
	  loc.put("city", "Pune");
	  loc.put("country" , "India");
	  JSONObject emp = new JSONObject();
	  emp.put("JobTitle", "Automation");
	  emp.put("company", "LTI");
	  JSONObject ob = new JSONObject();
	  ob.put("firstName", "Abhishek");
	  ob.put("lastName", "savadi");
	  ob.put("email", "abhi@thinkingtester.com");
	  ob.put("location", loc);
	  ob.put("empolyer", emp);
	  
	        given()
			  .header("Content-Type","application/json")
			  .body(ob.toJSONString())
			  .when()
			  .put("http://3.13.86.142:3000/contacts/" +id)
			  .then()
			  .log()
			  .body()
			  .statusCode(204);		 
   }
  
  @Test(enabled = true, dependsOnMethods="UpdateContact", description = "Deleting Specific Contact")
  public void DeleteSpecficContact() {
	  
	  given()
	  .when()
	  .delete("http://3.13.86.142:3000/contacts/" +id)
	  .then()
	  .log()
	  .body()
	  .statusCode(204);
  }
  
}
