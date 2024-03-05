package mapper;

import entity.mapper.CrudMapOptions;
import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

public class UserInstructions {
    private Map<String, String> columnsAndAttributes = new HashMap<>();
    private final String nameOperation;
    private final String nameTable;
    private final String startedString;

    public UserInstructions(HttpServletRequest request) {
        Map<String, String[]> allMap = request.getParameterMap();
        for (String key : allMap.keySet()) {
            String[] strArr =  allMap.get(key);
            for (String val : strArr) {
                this.columnsAndAttributes.put(key, val);
            }
        }
        this.nameOperation = request.getParameter("nameOperation");
        this.nameTable = request.getParameter("nameTable");
        this.startedString = makeStartedString();
        this.columnsAndAttributes.remove("nameOperation");
        this.columnsAndAttributes.remove("nameTable");
    }

    public Map<String, String> getColumnsAndAttributes() {
        return columnsAndAttributes;
    }
    public String getNameOperation() {
        return nameOperation;
    }
    public String getStartedString() {return startedString;}
    public String getNameTable() {return nameTable;}

    private String makeStartedString() {
        try {
            Map<String, String> crudMap = new CrudMapOptions().getCrudMap();
            String nameOperation = this.getNameOperation();
            for (String key : crudMap.keySet()) {
                if (nameOperation.toUpperCase().equals(key)) {
                    return crudMap.get(key);
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("Неверная операция");
    }
}