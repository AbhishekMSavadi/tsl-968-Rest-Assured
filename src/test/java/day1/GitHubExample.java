package day1;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class GitHubExample {
  @Test(enabled = true, description = "Getting all Repositories")
  public void getAllRepo() {
	  given()
	  .auth()
	  .oauth2("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")
	  .when()
	  .get("https://api.github.com/user/repos")
      .then()
      .log()
      .body()
      .statusCode(200)
      .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);  
  }
  @Test(enabled = true, description = "Adding Repositories")
  public void addRepository() {
	  JSONObject js = new JSONObject();
	  js.put("name","tsl968-2-restAssured3");
	  js.put("description", "I am created by RestAssured");
	  js.put("homepage","https://github.com/AbhishekMSavadi");
	  
	  given()
	  .auth()
	  .oauth2("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")
	  .header("Content-Type","application/json")
	  .body(js.toJSONString())
	  .when()
	  .post("https://api.github.com/user/repos")
      .then()
      .log()
      .body()
      .statusCode(422)
      .time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);  
  }
}
