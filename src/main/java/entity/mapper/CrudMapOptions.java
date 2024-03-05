package entity.mapper;
import java.util.HashMap;
import java.util.Map;
public class CrudMapOptions {
    private Map<String, String> crudMap= new HashMap<>(4);
    public CrudMapOptions() {
        crudMap.put("CREATE", "CREATE TABLE");
        crudMap.put("READ", "SELECT");
        crudMap.put("UPDATE", "INSERT INTO");
        crudMap.put("DELETE", "DROP TABLE");
    }

    public Map<String, String> getCrudMap() {
        return crudMap;
    }
}
