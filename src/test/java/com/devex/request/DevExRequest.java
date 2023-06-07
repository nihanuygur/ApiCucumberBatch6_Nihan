package com.devex.request;

import com.devex.common.DataForApi;
import com.devex.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class DevExRequest {

    static Response response;

    public static Response getAllProfile(){
        response = given().accept(ContentType.JSON)
                .when().log().all()
                .get(ConfigurationReader.get("getAllProfiles"));

        return response;
    }

    public static Response getOneUserWithPathParam(int id){
        response = given().accept(ContentType.JSON)
                .pathParam("userID",id)
                .when()
                .get(ConfigurationReader.get("getOneUserWithPathParam"));

        return response;
    }
    public static Response postSaveProfile(String company,String website,String location,String status,String skills,String githubusername,String youtube,String twitter,String facebook,String linkedin,String instagram){

        response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .header("x-auth-token",ConfigurationReader.get("userNewToken"))
                .and()
                .body(DataForApi.saveProfileBody(company, website, location, status, skills, githubusername, youtube, twitter, facebook, linkedin, instagram))
                .when()
                .post(ConfigurationReader.get("saveRegisterUser"));

        return response;
    }
    public static Response postRegisterUser(String email, String password, String name, String google, String facebook, String github){
        response = given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .body(DataForApi.registerUserBody(email, password, name, google, facebook, github))
                .when()
                .post(ConfigurationReader.get("postRegisterUser"));
        return response;
    }
}
