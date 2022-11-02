package com.sogeti.pages;

import com.sogeti.utilities.ConfigurationReader;
import com.sogeti.utilities.Driver;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

public class ApiPage extends BasePage {

    static Response response;
    String url = ConfigurationReader.get("apiUrl");

    public  void userIsOnTheApiPage() {

        response = given().accept(ContentType.JSON)
                .when()
                .get(url);
        Driver.get().get(url);

    }

    public  void verifyStatusCode(int statusCode ) {

        Assert.assertEquals(statusCode, response.statusCode());

    }

    public  void verifyContentType(String contentType) {

        Assert.assertEquals(contentType, response.contentType());

    }

    public void responseTimeBelowOneSecond(int ms){

        long responseTime = response.getTime();
        System.out.println("responseTime = " + responseTime);
        Assert.assertTrue(responseTime < ms);

    }

    public void verifyStateAndCountry(String country, String state) {

        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getString("country"), country);
        Assert.assertEquals(jsonPath.getString("state"), state);
        System.out.println("jsonPath = " + jsonPath);

    }

    public void verifyPostCodeAndPlaceName(String postCode, String placeName) {

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("post code", postCode)
                .and().queryParam("place name", placeName)
                .when().get(url);

        Assert.assertTrue(response.body().asString().contains(postCode));
        Assert.assertTrue(response.body().asString().contains(placeName));

    }

    public void verifyInResposePlaceNameForInputAndPostalCode(String placeName, String country, String postalCode) {

        given().accept(ContentType.JSON)
                .and().pathParam("postal-code", postalCode)
                .and().pathParam("country", country)
                .when().get("http://api.zippopotam.us/{country}/{postal-code}")
                .then().assertThat().statusCode(200).contentType("application/json").time(lessThanOrEqualTo(1000L))
                .body("places.'place name'[0]", equalTo(placeName));

    }
}



