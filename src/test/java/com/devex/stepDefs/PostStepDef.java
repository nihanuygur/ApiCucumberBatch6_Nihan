package com.devex.stepDefs;

import com.devex.pages.PostPage;
import com.devex.request.DevExRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class PostStepDef {
    Response response;

    int id;


    @Given("User send a POST request and creates a post with title {string} and text {string}")
    public void user_send_a_post_request_and_creates_a_post_with_title_and_text(String title, String text) {
        response = DevExRequest.postNewPostRequest(title, text);
    }



    @Then("Verify that status code is {int} - post feature")
    public void verifyThatStatusCodeIsPostFeature(int statusCode) {
        assertEquals(statusCode, response.statusCode());
    }

    @And("Compiler gets the post id")
    public void compilerGetsThePostId() {
        id = response.path("id");
    }

    @And("User creates a GET request to get post with id")
    public void userCreatesAGETRequestToGetPostWithId() {
        response = DevExRequest.getPostWithID(id);

    }

    @And("User is on the Post page")
    public void userIsOnThePostPage() {

        new PostPage().navigatePostPage();

    }

    @Then("Verify that UI post and API post for title should match")
    public void verifyThatUIPostAndAPIPostForTheShouldMatch() {
        // from API
        String actualApiText = response.path("text");

        // from UI
        String actualUIText = new PostPage().getTextField();

        // Verify
        Assert.assertEquals(actualUIText,actualApiText);
    }
}
