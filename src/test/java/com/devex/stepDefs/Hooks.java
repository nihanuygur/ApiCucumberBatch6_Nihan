package com.devex.stepDefs;

import com.devex.utilities.ConfigurationReader;
import com.devex.utilities.Driver;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class Hooks {

    @Before
    public void setup() {
        baseURI = ConfigurationReader.get("baseUrl");
    }

    @After
    public void tearDown(){
        reset();
        Driver.closeDriver();

    }
}
