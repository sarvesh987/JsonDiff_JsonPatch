package com.example.JsonPatch;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class JsonDiffEx {
    String name;
    String id;
    String mobile_no;

    public JsonDiffEx(String name, String id, String mobile_no) {
        super();
        this.name = name;
        this.id = id;
        this.mobile_no = mobile_no;
    }

    public static void main(String[] args) {

        JsonDiffEx jsonDiffObj = new JsonDiffEx("confluxsys","01","123456789");
        JsonDiffEx jsonDiffObj2 = new JsonDiffEx("confluxsys","01","123456");
        JsonNode returnObj = jsonDiffObj.compareUsers(jsonDiffObj,jsonDiffObj2);
        System.out.println(returnObj);
    }
    JsonNode compareUsers(JsonDiffEx user1, JsonDiffEx user2) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        JsonNode node1 = mapper.valueToTree(user1);
        JsonNode node2 = mapper.valueToTree(user2);
        return com.flipkart.zjsonpatch.JsonDiff.asJson(node1, node2);
    }
}
