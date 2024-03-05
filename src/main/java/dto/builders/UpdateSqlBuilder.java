package dto.builders;

import entity.mapper.UserInstructions;

public class UpdateSqlBuilder extends SqlBuilder {

    public UpdateSqlBuilder(UserInstructions userInstructions) {
        super(userInstructions);
    }

    @Override
    public StringBuilder buildSql(){
        sql.append(startedString).append(" ");
        sql.append(nameTable).append(" ");
        columnsAndAttributes.remove("nameTable");
        sql.append("( ");
        for (String key: columnsAndAttributes.keySet()){
            sql.append(key).append(", ");
        }
        sql.deleteCharAt(sql.length()-2);
        sql.append(") ");
        sql.append("VALUES").append(" (");
        for (String key: columnsAndAttributes.keySet()){
            sql.append("'");
            sql.append(columnsAndAttributes.get(key));
            sql.append("'");
            sql.append(", ");
        }
        sql.deleteCharAt(sql.length()-2);
        sql.append(") ");
        System.out.println(sql);
        return sql;
    }

}
