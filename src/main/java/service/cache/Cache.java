package service.cache;

import mapper.UserInstructions;

import java.util.*;

public class Cache {
    
    public static void doCache(UserInstructions userInstructions){
        String fileName = "cache.json";
        Set<String> setOfColumns = userInstructions.getColumnsAndAttributes().keySet();

        ArrayList<String> listOfColumns = new ArrayList<>(setOfColumns);
        Map<String, ArrayList<String>> cacheMap = JsonWorker.loadJson(fileName);
        if(!cacheMap.isEmpty()){
            cacheMap.put(userInstructions.getNameTable(), listOfColumns);
        }else {
            cacheMap = new HashMap<>(Map.of(userInstructions.getNameTable(), listOfColumns));
        }
        try {
            JsonWorker.saveJson(cacheMap, fileName);
        } catch (RuntimeException e){
            e.printStackTrace();
        }

    }
    public static Map<String, ArrayList<String>> getCache(){
        String fileName = "cache.json";
        return JsonWorker.loadJson(fileName);
    }
}
