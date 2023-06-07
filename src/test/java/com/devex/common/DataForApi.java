package com.devex.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DataForApi {
    public static Map<String,Object> registerUserBody(String email, String password, String name, String google, String facebook, String github){

        Map<String,Object> registerUser = new HashMap<>();
        registerUser.put("email",email);
        registerUser.put("password",password);
        registerUser.put("name",name);
        registerUser.put("google",google);
        registerUser.put("facebook",facebook);
        registerUser.put("github",github);

        return registerUser;
    }

    public static Map<String ,Object> saveProfileBody(String company,String website,String location,String status,String skills,
                                                      String githubusername, String youtube,String twitter,
                                                      String facebook,String linkedin,String instagram){

        Map<String ,Object> saveProfileBody = new HashMap<>();
        saveProfileBody.put("company",company);
        saveProfileBody.put("website",website);
        saveProfileBody.put("location",location);
        saveProfileBody.put("status",status);
        saveProfileBody.put("skills",skills);
        saveProfileBody.put("githubusername",githubusername);
        saveProfileBody.put("youtube",youtube);
        saveProfileBody.put("twitter",twitter);
        saveProfileBody.put("facebook",facebook);
        saveProfileBody.put("linkedin",linkedin);
        saveProfileBody.put("instagram",instagram);

        return saveProfileBody;
    }

}
