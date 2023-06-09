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
    public static Map<String ,Object> postLoginBody(String email,String password){
        Map<String,Object> loginBody=new HashMap<>();
        loginBody.put("email",email);
        loginBody.put("password",password);

        return loginBody;
    }

    public static String postNewExperience(String title, String company, String location, String from, String to, String current){

                if(current.equals("true")){
                    to="YYYY-MM-DD";
                }

        String experienceBody ="{\n" +
                "  \"title\": \""+title+"\",\n" +
                "  \"company\": \""+company+"\",\n" +
                "  \"location\": \""+location+"\",\n" +
                "  \"from\": \""+from+"\",\n" +
                "  \"to\": \""+to+"\",\n" +
                "  \"current\": "+current+",\n" +
                "  \"description\": \"string\"\n" +
                "}";

        return experienceBody;
    }

    public static Map<String,Object> addExperienceBody(String title, String company, String location, String from, String to, String current, String description){
        Map<String,Object> addNewExperience = new HashMap<>();
        addNewExperience.put("title",title);
        addNewExperience.put("company",company);
        addNewExperience.put("location",location);
        addNewExperience.put("from",from);
        addNewExperience.put("to",to);
        addNewExperience.put("current",current);
        addNewExperience.put("description",description);

        return addNewExperience;
    }
}
