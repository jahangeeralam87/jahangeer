package TestCase;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Pet_sold {
	@Test
	public static void postPet() {

		RestAssured.baseURI = "https://petstore.swagger.io/v2/";
		String body = "{\n" + "  \"id\": 420,\n" + "  \"category\": {\n" + "    \"id\": 420,\n"
				+ "    \"name\": \"newPet\"\n" + "  },\n" + "  \"name\": \"doggie\",\n" + "  \"photoUrls\": [\n"
				+ "    \"string\"\n" + "  ],\n" + "  \"tags\": [\n" + "    {\n" + "      \"id\": 420,\n"
				+ "      \"name\": \"newPet\"\n" + "    }\n" + "  ],\n" + "  \"status\": \"sold\"\n" + "}";
		Map<String, Object> header =headers();
		Response response = null;
		try {
			response = given().body(body).headers(header).put("pet");
		} catch (Exception e) {
			e.printStackTrace();
		}

		String allresponse = response.asString();
		int responseCode = response.getStatusCode();
		System.out.println(allresponse);
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, 200);
	}

	public static Map<String, Object> headers() {
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("accept", "application/json");
		headerMap.put("Content-Type", "application/json");
		return headerMap;
	}

}
