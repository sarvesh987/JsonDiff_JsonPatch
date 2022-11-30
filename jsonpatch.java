package com.example.JsonPatch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


public class jsonpatch {



public static ObjectMapper objectMapper = new ObjectMapper();
static String patchString = "{ \"color\" : \"white\" }" ;
   static String json = "{ \"color\" : \"Black\"," +
           " \"type\" : \"BMW\" }";

   public static void main(String[] args) {


      JsonNode patchNode;

      {
         try {
            System.out.println("PatchString is :-  "+patchString);
            patchNode = objectMapper.readTree(patchString);
            System.out.println("PatchNode now is :- "+patchNode);

            final InputStream in = new ByteArrayInputStream(patchString.getBytes());
            objectMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);

            JsonPatch patch = JsonPatch.fromJson(objectMapper.readTree(patchString));

            System.out.println("patch after object Mapper expect it contains color and white :- "+patch);
            JsonNode originalObjNode = objectMapper.readTree(json);
            System.out.println("originalObjNode is :- "+originalObjNode);

            JsonNode patchedObjNode = patch.apply(objectMapper.readTree(json));

            System.out.println("patchedObjNode is :- "+patchedObjNode);

            final JsonNode patchNode2 = JsonDiff.asJson(originalObjNode, patchedObjNode);
            System.out.println(patchNode2);

         } catch (IOException | JsonPatchException e) {
            throw new RuntimeException(e);
         }
      }
   }

}
