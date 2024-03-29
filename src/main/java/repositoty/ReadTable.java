
package repositoty;

import dto.builders.ReadSqlBuilder;
import service.cache.Cache;
import entity.repository.database.DbAccess;
import mapper.UserInstructions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReadTable {
    public static Map<String, String> readTable (ReadSqlBuilder sql, UserInstructions userInstructions){
        Map<String, String> result = new HashMap<>();
        try (Connection connection = DbAccess.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(sql.buildSql().toString());
            HashMap<String, ArrayList<String>> allTablesColumns = new HashMap<>(Cache.getCache());


            ArrayList<String> columns = allTablesColumns.get(userInstructions.getNameTable());

            while (resultSet.next()){
                for (String column : columns) {
                    result.put(column, resultSet.getString(column));
                }

            }
        }catch (SQLException e) {throw new RuntimeException(e);}
        return result;
    }

}
