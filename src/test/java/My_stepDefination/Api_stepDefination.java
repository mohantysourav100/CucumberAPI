package My_stepDefination;

import org.junit.runner.RunWith;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@RunWith(Cucumber.class)
public class Api_stepDefination {
	RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
			                   .setContentType("application/json").build();
	RequestSpecification preDetails,updateDetails,getDetails;
	Response response;
	ValidatableResponse final_response;
	ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200).build();
	static String placeId;
	
	 @Given("^User provide all the pre-requiste details of Add api$")
	    public void user_provide_all_the_prerequiste_details_of_add_api() throws Throwable {
		 
		preDetails = given().log().all().spec(req).body("{\r\n" + 
		 		"\"location\": {\r\n" + 
		 		"\"lat\": -38.383494,\r\n" + 
		 		"\"lng\": 33.427362\r\n" + 
		 		"},\r\n" + 
		 		"\"accuracy\": 50,\r\n" + 
		 		"\"name\":\"Sourav Mohanty\",\r\n" + 
		 		"\"phone_number\":\"8792118967\",\r\n" + 
		 		"\"address\":\"29, side layout, cohen 09\",\r\n" + 
		 		"\"types\": [\r\n" + 
		 		"\r\n" + 
		 		"\"shoe park\",\r\n" + 
		 		"\"shop\"\r\n" + 
		 		"],\r\n" + 
		 		"\"website\": \"http://google.com\",\r\n" + 
		 		"\"language\": \"French-IN\"\r\n" + 
		 		"}");
	      
	    }

	    @Given("^User provide place Id with other pre-requiste details$")
	    public void user_provide_place_id_with_other_prerequiste_details() throws Throwable {
	    	updateDetails = given().log().all().spec(req).queryParam("place_id",placeId).body("{\r\n" + 
	    			"\"place_id\":\""+ placeId +"\",\r\n" + 
	    			"\"address\":\"JCR layout,Panathur\",\r\n" + 
	    			"\r\n" + 
	    			"\"key\":\"qaclick123\"\r\n" + 
	    			"}");
	        
	    }

	    @Given("^User provide place id to retrive place details$")
	    public void user_provide_place_id_to_retrive_place_details() throws Throwable {
	      
	    	getDetails = given().log().all().spec(req).queryParam("place_id", placeId);
	    }

	    @When("^User trigger the endpoints of Add api via Post request$")
	    public void user_trigger_the_endpoints_of_add_api_via_post_request() throws Throwable {
	       
	    	response = preDetails.when().post("/maps/api/place/add/json");
	    	
	    }

	    @When("^User trigger the endpoints of Update api via Put request$")
	    public void user_trigger_the_endpoints_of_update_api_via_put_request() throws Throwable {
	    	
	    	response = updateDetails.when().put("/maps/api/place/update/json");
	        
	    }

	    @When("^User trigger the endpoints of get place api via Get request$")
	    public void user_trigger_the_endpoints_of_get_place_api_via_get_request() throws Throwable {
	        
	    	response = getDetails.when().get("/maps/api/place/get/json");
	    }

	    @Then("^User should get the valid response as status code 200$")
	    public void user_should_get_the_valid_response_as_status_code_200() throws Throwable {
	    	
	          final_response = response.then().log().all().spec(res);
	    }

	    @And("^User should see the place id as part of response$")
	    public void user_should_see_the_place_id_as_part_of_response() throws Throwable {
	        
	    	String rawResponsetoString = final_response.extract().response().asString();
	    	JsonPath js = new JsonPath(rawResponsetoString);
	    	placeId = js.getString("place_id");
	    	System.out.println(placeId);
	    }

	    @And("^User should see the updated message$")
	    public void user_should_see_the_updated_message() throws Throwable {
	        
	    	final_response.body("msg",equalTo("Address successfully updated"));
	    	System.out.println("Successfully updated");
	    }

	    @And("^User should see the updated addreess as part of response$")
	    public void user_should_see_the_updated_addreess_as_part_of_response() throws Throwable {
	       
	    	String actual_response = final_response.extract().response().asString();
	    	JsonPath jsGet = new JsonPath(actual_response);
	    	String newAddress = jsGet.getString("address");
	    	System.out.println(newAddress);	
	    }

}
