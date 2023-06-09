package com.devex.stepDefs;

import com.devex.common.DataForApi;
import com.devex.request.DevExRequest;
import com.devex.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProfileStepDef {
    Response response;

    @Given("User sends a GET request and able to see all profiles")
    public void user_sends_a_get_request_and_able_to_see_all_profiles() {
//        response = given().accept(ContentType.JSON)
//                .when()
//                .get(ConfigurationReader.get("getAllProfiles"));
//        response.prettyPrint();

        response = DevExRequest.getAllProfile();
    }

    @Then("Verify that status code is {int}")
    public void verify_that_status_code_is(int expectedStatusCode) {

        assertEquals(expectedStatusCode, response.statusCode());

    }

    @Given("User sends a GET request with id {int}")
    public void userSendsAGETRequestWithId(int userID) {
        response = DevExRequest.getOneUserWithPathParam(userID);
        response.prettyPrint();
    }

    @Then("Verify that user's information, name is {string} and company is{string} and location is {string}")
    public void verifyThatUserSInformationNameIsAndCompanyIsAndLocationIs(String expectedName, String expectedCompany, String expectedLocation) {

        String actualName = response.path("user.name");
        String actualCompany = response.path("company");
        String actualLocation = response.path("location");

        assertEquals(expectedName, actualName);
        assertEquals(expectedCompany, actualCompany);
        assertEquals(expectedLocation, actualLocation);
    }


    @Given("User sends a POST request with {string} and {string} and {string} and {string} and {string} and {string}")
    public void userSendsAPOSTRequestWithAndAndAndAndAnd(String email, String password, String name, String google, String facebook, String github) {
        response= DevExRequest.postRegisterUser(email,password,name,google,facebook,github);
    }

    @Then("Verify that body contains {string}")
    public void verifyThatBodyContains(String token) {
        ConfigurationReader.set("userNewToken",response.path("token"));
        assertTrue(response.body().asString().contains(token));
    }


    @And("User sends a POST request with {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string} and {string}")
    public void userSendsAPOSTRequestWithAndAndAndAndAndAndAndAndAndAnd(String company, String website, String location, String status, String skills,
                                                                        String githubusername, String youtube, String twitter,
                                                                        String facebook, String linkedin, String instagram) {

        response = DevExRequest.postSaveProfile(company,website,location,status,skills,githubusername,youtube,twitter,facebook,linkedin,instagram);
    }

    @Then("Verify that user's information, name is {string} and company is {string}")
    public void verifyThatUserSInformationNameIsAndCompanyIs(String expectedName, String expectedCompany) {

        assertEquals(expectedName,response.path("user.name"));
        assertEquals(expectedCompany,response.path("company"));
    }
//    @Given("User send A POST request and logins with {string} and {string}")
//    public void userSendAPOSTRequestAndLoginsWithAnd(String email, String password) {
//        response = DevExRequest.login(email, password);
//
//    }

    @Given("User sends a POST request and creates new experience with {string} , {string} , {string} , {string} , {string} , {string}")
    public void userSendsAPOSTRequestAndCreatesNewExperienceWith(String title, String company, String location, String from, String to, String current) {
        response = DevExRequest.postExperience(title,company,location,from,to,current);
    }

}