package neau.cekong.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JsonTranstor {

    static Gson gson = new Gson();

    public static List<Map<String, String>> transToMapList(String json) {


        ArrayList list = gson.fromJson(json, new ArrayList<HashMap<String, String>>().getClass());

        return list;
    }

    public static Map<String, String> transToMap(String json) {


        Type type = new TypeToken<Map<String, String>>() {}.getType();
        Map<String, String> list = gson.fromJson(json, type);

        return list;
    }

}