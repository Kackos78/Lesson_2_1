package dto.cache;

import entity.mapper.UserInstructions;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    
    public static void doCache(UserInstructions userInstructions){
        String fileName = "cache.json";
        String[] listOfColumns =
                userInstructions.getColumnsAndAttributes().keySet().toArray(new String[0]);
        Map<String, String[]> cacheMap = JsonWorker.loadJson(fileName);
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
    public static Map<String, String[]> getCache(){
        String fileName = "cache.json";
        return JsonWorker.loadJson(fileName);
    }
}
