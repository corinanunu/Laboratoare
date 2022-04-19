package lab1;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class JsonCreate {
    public static void main(String[] args) {
        JSONObject tag0 = new JSONObject();
        JSONArray tag0List = new JSONArray();
        JSONObject tag1 = new JSONObject();
        JSONObject tag12 = new JSONObject();
        JSONArray tag1WithId = new JSONArray();
        JSONArray tag1WithId2 = new JSONArray();
        JSONObject tag2_1 = new JSONObject();
        JSONObject tag2_2 = new JSONObject();
        JSONObject tag2_3 = new JSONObject();
        JSONObject tag2_4 = new JSONObject();

        JSONObject tag1WithValue = new JSONObject();
        JSONObject tag1WithValue2 = new JSONObject();

        ////////////////////////////////////////////////

        Map<Object, Object> map21 = new LinkedHashMap<>();
        map21.put("id", "001");
        map21.put("t1", "string 1");
        map21.put("t2", "string 1");
        map21.put("t3", "date or int 1");

        Map<Integer, String> array = new LinkedHashMap<>();
        array.put(1, "list1 string a");
        array.put(2, "list1 string b");
        array.put(3, "list1 string c");
        array.put(4, "list1 string d");
        map21.put("list of elements", array);
        map21.put("t5", "string 1");

        tag2_1.put("tag2", map21);
        tag1WithValue.put("tag1", tag2_1);


        ////////////////////////////////////////////////////

        Map<Object, Object> map22 = new LinkedHashMap<>();
        map22.put("id", "002");
        map22.put("t1", "string 2");
        map22.put("t2", "string 2");
        map22.put("t3", "date or int 2");

        Map<Integer, String> array2 = new LinkedHashMap<>();
        array2.put(1, "list2 string a");
        array2.put(2, "list2 string b");
        array2.put(3, "list2 string c");
        array2.put(4, "list2 string d");
        map22.put("list of elements", array2);
        map22.put("t5", "string 2");

        tag2_2.put("tag2", map22);

        ////////////////////////////////////////////////////////
        Map<Object, Object> map23 = new LinkedHashMap<>();
        map23.put("id", "003");
        map23.put("t1", "string 3");
        map23.put("t2", "string 3");
        map23.put("t3", "date or int 3");

        Map<Integer, String> array3 = new LinkedHashMap<>();
        array3.put(1, "list3 string a");
        array3.put(2, "list3 string b");
        array3.put(3, "list3 string c");
        array3.put(4, "list3 string d");
        map23.put("list of elements", array3);
        map23.put("t5", "string 3");

        tag2_3.put("tag2", map23);
        tag1WithValue2.put("tag1", tag2_3);

        //////////////////////////////////////////////////////////////////

        Map<Object, Object> map24 = new LinkedHashMap<>();
        map24.put("id", "004");
        map24.put("t1", "string 4");
        map24.put("t2", "string 4");
        map24.put("t3", "date or int 4");

        Map<Integer, String> array4 = new LinkedHashMap<>();
        array4.put(1, "list4 string a");
        array4.put(2, "list4 string b");
        array4.put(3, "list4 string c");
        array4.put(4, "list4 string d");
        map24.put("list of elements", array4);
        map24.put("t5", "string 4");

        tag2_4.put("tag2", map24);

        ////////////////////////////////////////////////

        Map<Object, Object> map1 = new LinkedHashMap<>();
        map1.put("tag1name", "t1Name1");
        map1.put("tagId", "1");
        tag1WithId.add(map1);
        tag1WithId.add(tag2_1);
        tag1WithId.add(tag2_2);

        Map<Object, Object> map12 = new LinkedHashMap<>();
        map12.put("tag1name", "t1Name2");
        map12.put("tagId", "2");
        tag1WithId2.add(map12);
        tag1WithId2.add(tag2_3);
        tag1WithId2.add(tag2_4);

        tag1.put("tag1",tag1WithId);
        tag12.put("tag1",tag1WithId2);

        tag0List.add(tag1);
        tag0List.add(tag12);

        tag0.put("tag0", tag0List);


        try(FileWriter file = new FileWriter("lab1.json")){
            file.write(tag0.toJSONString());
            file.flush();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
