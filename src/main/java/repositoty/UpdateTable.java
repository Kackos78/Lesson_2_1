package repositoty;

import dto.builders.UpdateSqlBuilder;
import service.cache.Cache;
import entity.repository.database.DbAccess;
import mapper.UserInstructions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTable {
    public static void updateTable (UpdateSqlBuilder sql, UserInstructions userInstructions){
    try (Connection connection = DbAccess.getConnection();
         Statement statement = connection.createStatement()){
        statement.executeUpdate(sql.buildSql().toString());
        Cache.doCache(userInstructions);

    }catch (SQLException e) {throw new RuntimeException(e);}
}
}

