package com.example.JsonPatch;


import org.json.CDL;
import org.json.Cookie;
import org.json.JSONArray;
import org.json.JSONObject;


import java.util.HashMap;
import java.util.Map;

public class JsonDataTypes {
    Integer id;
    String name;

    public JsonDataTypes(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {

        Map<String, String> mapObj = new HashMap<>();
        mapObj.put("name","abc");
        mapObj.put("id","01");
        mapObj.put("contact","456");
        mapObj.put("city","pune");
        JSONObject jsonObject1 = new JSONObject(mapObj);
        System.out.println(jsonObject1);

        System.out.println("----------------------------------------------------------------------------------------------------");

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name","confluxsys");
        jsonObject2.put("id","confluxsys");
        jsonObject2.put("address","confluxsys");
        jsonObject2.put("city","confluxsys");

        System.out.println(jsonObject2);

        System.out.println("----------------------------------------------------------------------------------------------------");

        JSONArray jsonArray = new JSONArray();
        jsonArray.put("Car");

        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("id","09");
        jsonObject3.put("name","fifa");
        jsonObject3.put("city","qatar");
        jsonObject3.put("country","dubai");

        jsonArray.put(jsonObject3);
        System.out.println(jsonArray);

        System.out.println("----------------------------------------------------------------------------------------------------");

        String cdt = CDL.rowToString(jsonArray);
        System.out.println(cdt);

        System.out.println("----------------------------------------------------------------------------------------------------");

        String string = "name, city, age \n" +
                "john, chicago, 22 \n" +
                "gary, florida, 35 \n" +
                "sal, vegas, 18";

        JSONArray jsonArray2 = CDL.toJSONArray(string);
        System.out.println(jsonArray2);

        System.out.println("----------------------------------------------------------------------------------------------------");

        String cookie = "username=John Doe; expires=Thu, 18 Dec 2013 12:00:00 UTC; path=/";
        JSONObject jsonObject = Cookie.toJSONObject(cookie);
        System.out.println(jsonObject);

        System.out.println("----------------------------------------------------------------------------------------------------");

    }


}
