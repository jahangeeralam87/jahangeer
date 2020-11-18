package TestCase;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Pet_Get {
	@Test
	public static void postPet() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		Map<String, Object> header =headers();
		Response response = given().when().headers(header).get("pet/420");

		String allresponse = response.asString();
		int responseCode = response.getStatusCode();
		Assert.assertEquals(responseCode, 200);
		System.out.println(allresponse);
		System.out.println(responseCode);

	}
	public static Map<String, Object> headers() {
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("accept", "application/json");
		headerMap.put("Content-Type", "application/json");
		return headerMap;
	}

}
