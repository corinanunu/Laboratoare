package lab1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonDecode {
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(new FileReader("lab1.json"));

            JSONObject obj1 = (JSONObject) obj;
            System.out.println(obj);

            System.out.println();
            JSONArray tag0 = (JSONArray) obj1.get("tag0");
            System.out.println(tag0);
            System.out.println();

            int tag0Length = tag0.size();


            for (int i = 0; i < tag0Length; i++){
                JSONObject listTag1 = (JSONObject) tag0.get(i);
                System.out.println((i+1)+".  "+listTag1);
                JSONArray tag1 = (JSONArray) listTag1.get("tag1");
                System.out.println(tag1);

                System.out.println();
                JSONObject tag1Inf = (JSONObject) tag1.get(0);
                System.out.println(" tag1name "+tag1Inf.get("tag1name"));
                System.out.println(" tagId "+tag1Inf.get("tagId"));

                getIngTag2(tag1, 1);
                getIngTag2(tag1, 2);

                System.out.println();
            }

        }catch (ParseException | FileNotFoundException pe){
            pe.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getIngTag2(JSONArray tag1, int index){
        JSONObject tag2List = (JSONObject) tag1.get(index);
        JSONObject tag2 = (JSONObject) tag2List.get("tag2");
        System.out.println(" id "+tag2.get("id"));
        System.out.println(" t1 "+tag2.get("t1"));
        System.out.println(" t2 "+tag2.get("t2"));
        System.out.println(" t3 "+tag2.get("t3"));
        System.out.println(" List ");
        JSONObject listOfElements2 = (JSONObject) tag2.get("list of elements");
        System.out.println(" 1 : "+listOfElements2.get("1"));
        System.out.println(" 2 : "+listOfElements2.get("2"));
        System.out.println(" 3 : "+listOfElements2.get("3"));
        System.out.println(" 4 : "+listOfElements2.get("4"));
        System.out.println(" t5 "+tag2.get("t5"));
        System.out.println();
    }
}
