
package repositoty;
import dto.cache.Cache;
import entity.database.DbAccess;
import dto.builders.SqlBuilder;
import entity.mapper.UserInstructions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadTable {
    public static Map<String, String> readTable (SqlBuilder sql, UserInstructions userInstructions){
        Map<String, String> result = new HashMap<>();
        try (Connection connection = DbAccess.getConnection();
             Statement statement = connection.createStatement()){

            ResultSet resultSet = statement.executeQuery(sql.toString());
            Map<String, String[]> allTablesColumns = Cache.getCache();
            ArrayList<String> columns = new ArrayList<>(List.of(allTablesColumns.get(userInstructions.getNameTable())));

            while (resultSet.next()){
                for (String column : columns) {
                    result.put(column, resultSet.getString(column));
                }

            }
        }catch (SQLException e) {throw new RuntimeException(e);}
        return result;
    }

}
