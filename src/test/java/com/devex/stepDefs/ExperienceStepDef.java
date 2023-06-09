package com.devex.stepDefs;

import com.devex.pages.LoginPage;
import com.devex.request.DevExRequest;
import com.devex.utilities.ApiUtils;
import com.devex.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ExperienceStepDef {
    Response response;

    Map<String, Object> token;
    int id;

    @Given("User send A POST request and logins with {string} and {string}")
    public void userSendAPOSTRequestAndLoginsWithAnd(String email, String password) {
        ConfigurationReader.set("token", ApiUtils.getAccessToken(email, password));
    }

    @And("User sends a POST request and creates new experience with {string} {string} {string} {string} {string} {string} {string}")
    public void userSendsAPOSTRequestAndCreatesNewExperienceWith(String title, String company, String location, String from, String to, String current, String description) {

        response = DevExRequest.postAddExperience(title, company, location, from, to, current, description);
    }

    @Then("Verify status code is {int}")
    public void verifyStatusCodeIsStatusCode(int statusCode) {

        assertEquals(statusCode, response.statusCode());

    }

    @And("Compiler gets the experience id")
    public void compilerGetsTheExperienceId() {
        id = response.path("experience.id[0]");
    }

    @And("User creates a GET request to get experience with id")
    public void userCreatesAGETRequestToGetExperienceWithId() {
        response = DevExRequest.getExperienceWithId(id);
    }

    @And("User is on the Dashboard page")
    public void userIsOnTheDashboardPage() throws InterruptedException {
        new LoginPage().setup();
    }

    @Then("Verify that UI experience and API experience fot the {string} should match")
    public void verifyThatUIExperienceAndAPIExperienceFotTheShouldMatch(String company) {
        // from UI

        String actualCompanyFromUi=new LoginPage().getNewCompanyName(company);

        // from API
           String actualCompanyFromAPi = response.path("company");

        // compare
        assertEquals(actualCompanyFromAPi,actualCompanyFromUi);
    }
}
