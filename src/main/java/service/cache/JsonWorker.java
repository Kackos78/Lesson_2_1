package service.cache;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonWorker {
    public static boolean saveJson (Map<String, ArrayList<String>> data, String fileName){
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileName);
        try {
            if(file.exists()) {
                mapper.writeValue(file, data);
            } else {
                mapper.writeValue(new File(fileName), data);
            }
            return true;
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static Map<String, ArrayList<String>>  loadJson (String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileName);
        Map<String, ArrayList<String>> data = new HashMap<>();
            try {
                if (!file.exists()) {
                    mapper.writeValue(new File(fileName), data);
                }
                data = mapper.readValue(file, Map.class);
                return data;
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

