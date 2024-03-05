package repositoty;

import dto.builders.SqlBuilder;
import dto.cache.Cache;
import entity.database.DbAccess;
import entity.mapper.UserInstructions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {
    public static void updateTable (SqlBuilder sql, UserInstructions userInstructions){
    try (Connection connection = DbAccess.getConnection();
         Statement statement = connection.createStatement()){
        statement.executeUpdate(sql.toString());
        Cache.doCache(userInstructions);

    }catch (SQLException e) {throw new RuntimeException(e);}
}
}

