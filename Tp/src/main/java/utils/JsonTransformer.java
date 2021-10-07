package utils;

import com.google.gson.Gson;

public class JsonTransformer {

    public static String transformar(Object model){
        return new Gson().toJson(model);
    }


}
