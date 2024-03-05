package dto.builders;

import mapper.UserInstructions;

import java.util.Map;

public abstract class SqlBuilder {
    protected StringBuilder sql = new StringBuilder("");
    protected String startedString;
    protected String nameTable;
    protected Map<String, String> columnsAndAttributes;

    public SqlBuilder(UserInstructions userInstructions) {
        this.startedString = userInstructions.getStartedString();
        this.columnsAndAttributes = userInstructions.getColumnsAndAttributes();
        this.nameTable = userInstructions.getNameTable();
    }

    public StringBuilder buildSql() {
        return null;
    }

    public StringBuilder getSql() {
        return sql;
    }
}
