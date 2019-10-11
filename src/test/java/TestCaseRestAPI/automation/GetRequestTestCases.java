package TestCaseRestAPI.automation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetRequestTestCases {

	
	public static void GetAllListOfCities()
	{
		RestAssured.baseURI="https://developers.zomato.com";
		
		Response resp = 
		given().header("user-key", "9f844bc4514ea0afe096b15efddd2700").and().
				param("q","New York").
		when().
				get("/api/v2.1/cities").
		then().
				assertThat().statusCode(200).and().
				header("content-type",equalTo("application/json")).and().
				log().everything().and().
		extract().response();
		JsonPath jsonPath = new JsonPath(resp.asString());
		int totalSuggestions = jsonPath.get("location_suggestions.size()");
		String[] names = new String[totalSuggestions];
		int[] cityID = new int[totalSuggestions];
		System.out.println("Suggested Locations are below: ");
		for(int i=0; i<totalSuggestions;i++)
		{
			names[i]= jsonPath.get("location_suggestions[" + i + "].name");
			cityID[i]= jsonPath.getInt("location_suggestions[" + i + "].id");
			System.out.println(names[i] + "      City_id: "+ cityID[i]);
		}
	}
	
	
	
	public static void GetAllCollectionsForCityID()
	{
		RestAssured.baseURI="https://developers.zomato.com";
		
		Response resp = 
		given().header("user-key", "9f844bc4514ea0afe096b15efddd2700").and().
				param("city_id","1000").
		when().
				get("/api/v2.1/collections").
		then().
				assertThat().statusCode(200).and().
				header("content-type",equalTo("application/json")).and().
				log().everything().and().
		extract().response();
		JsonPath jsonPath = new JsonPath(resp.asString());
		int totalCollections = jsonPath.get("collections.size()");
		String[] title = new String[totalCollections];
		int[] collectionID = new int[totalCollections];
		System.out.println("Suggested Locations are below: ");
		for(int i=0; i<totalCollections;i++)
		{
			title[i]= jsonPath.get("collections[" + i + "].collection.title");
			collectionID[i]= jsonPath.getInt("collections[" + i + "].collection.collection_id");
			System.out.println(title[i] + "      Collection ID: "+ collectionID[i]);
		}
	}
	
	
	public static void GetAllCuisinesForCityID()
	{
		RestAssured.baseURI="https://developers.zomato.com";
		
		Response resp = 
		given().header("user-key", "9f844bc4514ea0afe096b15efddd2700").and().
				param("city_id","1000").
		when().get("/api/v2.1/cuisines").
		then().assertThat().statusCode(200).and().contentType("application/json").and().
		log().everything().and().extract().response();

		JsonPath jsonpath = new JsonPath(resp.asString());
		int size = jsonpath.get("cuisines.size()");
		System.out.println("No. Of Cuisines: " + size);
		int[] cuisineID = new int[size];
		String[] cuisineName = new String[size];
		for(int i=0; i<size; i++)
		{
			cuisineID[i]=jsonpath.getInt("cuisines[" + i + "].cuisine.cuisine_id");
			cuisineName[i]=jsonpath.get("cuisines[" + i +"].cuisine.cuisine_name");
			System.out.println("CuisineID: "+ cuisineID[i]);
			System.out.println("CuisineName: "+ cuisineName[i]);
		}
	}
	
	@Test
	public static void GetCollectionsForParticularCity()
	{
		RestAssured.baseURI="https://developers.zomato.com";
		
		Response cityResp = 
		given().header("user-key", "9f844bc4514ea0afe096b15efddd2700").and().
				param("q","New York").
		when().
				get("/api/v2.1/cities").
		then().
				assertThat().statusCode(200).and().
				header("content-type",equalTo("application/json")).and().
				log().everything().and().
		extract().response();
		JsonPath cityJsonPath = new JsonPath(cityResp.asString());
		int totalSuggestions = cityJsonPath.get("location_suggestions.size()");
		String[] names = new String[totalSuggestions];
		int cityID=0;
		System.out.println("Suggested Locations are below: ");
		for(int i=0; i<totalSuggestions;i++)
		{
			names[i]= cityJsonPath.get("location_suggestions[" + i + "].name");
			if (names[i].equals("Buffalo, NY"))
			{
				cityID= cityJsonPath.getInt("location_suggestions[" + i + "].id");
			}
		}
		System.out.println("City ID: " + cityID);
		//------------------------append code for getting collections and cuisines for city ID above
		
		Response collectionResp = 
				given().header("user-key", "9f844bc4514ea0afe096b15efddd2700").and().
						param("city_id", cityID).
				when().
						get("/api/v2.1/collections").
				then().
						assertThat().statusCode(200).and().
						header("content-type",equalTo("application/json")).and().
						log().everything().and().
				extract().response();
				JsonPath jsonPath = new JsonPath(collectionResp.asString());
				int totalCollections = jsonPath.get("collections.size()");
				String[] title = new String[totalCollections];
				int[] collectionID = new int[totalCollections];
				System.out.println("Suggested Locations are below: ");
				for(int i=0; i<totalCollections;i++)
				{
					title[i]= jsonPath.get("collections[" + i + "].collection.title");
					collectionID[i]= jsonPath.getInt("collections[" + i + "].collection.collection_id");
					System.out.println(title[i] + "      Collection ID: "+ collectionID[i]);
				}
	}
}
