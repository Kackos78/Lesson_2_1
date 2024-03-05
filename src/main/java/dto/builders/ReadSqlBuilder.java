package dto.builders;

import entity.mapper.UserInstructions;

public class ReadSqlBuilder extends SqlBuilder{

    public ReadSqlBuilder(UserInstructions userInstructions) {super(userInstructions);}

    @Override
    public StringBuilder buildSql(){
        sql.append(startedString).append(" ");
        sql.append("*").append(" ");
        sql.append("FROM");
        sql.append(columnsAndAttributes.get("nameTable"));
        columnsAndAttributes.remove("nameTable");
        return sql;
    }
}
