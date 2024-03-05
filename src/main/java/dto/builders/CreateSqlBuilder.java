package dto.builders;


import mapper.UserInstructions;

public class CreateSqlBuilder extends SqlBuilder {

    public CreateSqlBuilder(UserInstructions userInstructions) {
        super(userInstructions);
    }

    @Override
    public StringBuilder buildSql(){
        sql.append(startedString).append(" ");
        sql.append(nameTable).append(" (");
        columnsAndAttributes.remove("nameTable");
        for(String column: columnsAndAttributes.keySet()){
            sql.append(column).append(" ");
            sql.append(columnsAndAttributes.get(column)).append(", ");
        }
        sql.deleteCharAt(sql.length()-2);
        sql.append(")");
        System.out.println(sql);
        return sql;
    }

}
