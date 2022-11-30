package com.example.JsonPatch;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;


import javax.json.*;
import java.io.FileReader;

public class ExampleOfJsonPatch {
    public static void main(String[] args) throws Exception {

        JsonPatchBuilder jsonPatchBuilder = Json.createPatchBuilder();
        JsonPatch jsonPatch = jsonPatchBuilder.add("/firstName", "sarvesh").remove("/age").build();
        JsonReader reader = Json.createReader(new FileReader("src/main/resources/jsondata.txt"));
        JsonStructure jsonStructure1 = reader.read();
        JsonStructure jsonStructure2 = jsonPatch.apply(jsonStructure1);
        System.out.println(jsonStructure2);
        System.out.println("-----------------------------------------------");
        System.out.println("print patchNode :- " + jsonPatch);

    }
}



/*  System.out.println("_____________________________________________________________________________");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonObject json1 = Json.createObjectBuilder()
                .add("Name", "abc")
                .add("Age", "50").build();
        JsonObject json2 = Json.createObjectBuilder()
                .add("Name", "pqr")
                .add("Age", "50").build();

        JsonNode jsonNode3 = null;
        JsonNode jsonNode4 = null;
        try {
            jsonNode3 = (JsonNode) reader.read();
            jsonNode4 = (JsonNode) reader.read();
        } catch (Exception e) {
            System.out.println("" + e);
        }
        JsonNode patchNode = JsonDiff.asJson(jsonNode3, jsonNode4);*/