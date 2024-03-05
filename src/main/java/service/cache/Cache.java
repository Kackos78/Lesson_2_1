package service.cache;

import mapper.UserInstructions;

import java.util.*;

public class Cache {
    
    public static void doCache(UserInstructions userInstructions){
        String fileName = "cache.json";
        Set<String> setOfColumns = userInstructions.getColumnsAndAttributes().keySet();

        int n = setOfColumns.size();
        ArrayList<String> arr = new ArrayList<>(n);
        int i = 0;
        for (String x : setOfColumns)
            arr.set(i++, x);

        ArrayList<String> listOfColumns = arr;
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
