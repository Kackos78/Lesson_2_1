package dto.builders;

import entity.mapper.UserInstructions;

public class DeleteSqlBuilder extends SqlBuilder{
    public DeleteSqlBuilder(UserInstructions userInstructions) {
        super(userInstructions);
    }

    @Override
    public StringBuilder buildSql() {
        sql.append(startedString).append(" ");
        sql.append(nameTable).append(" ");

        return sql;
    }
}
