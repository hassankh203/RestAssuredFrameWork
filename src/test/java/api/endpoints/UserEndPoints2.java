package api.endpoints;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndPints.java
//Created for perform Create, Read, Update, Delete requests t the user API.

public class UserEndPoints2 {
	
	static ResourceBundle getUrl(){
		
		ResourceBundle routes =  ResourceBundle.getBundle("routes");
		return routes;
	}

		public static Response createUser(User payload)
		{
			String post =getUrl().getString("post_url");
			Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(post);
				
			return response;
		}
		
		
		public static Response readUser(String userName)
		{
			String get =getUrl().getString("get_url");
			
			Response response=given()
							.pathParam("username",userName)
			.when()
				.get(get);
				
			return response;
		}
		
		
		public static Response updateUser(String userName, User payload)
		{
			String update =getUrl().getString("update_url");
			Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)
			.when()
				.put(update);
				
			return response;
		}
		
		
		public static Response deleteUser(String userName)
		{
			String delete =getUrl().getString("delete_url");
			Response response=given()
							.pathParam("username",userName)
			.when()
				.delete(delete);
				
			return response;
		}	
				
		
}