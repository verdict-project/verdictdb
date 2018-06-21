package org.verdictdb.core.sql;

import org.verdictdb.core.query.DropTableQuery;
import org.verdictdb.exception.VerdictDbException;
import org.verdictdb.sql.syntax.SyntaxAbstract;

public class DropTableToSql {
  
  SyntaxAbstract syntax;

  public DropTableToSql(SyntaxAbstract syntax) {
    this.syntax = syntax;
  }

  public String toSql(DropTableQuery query) throws VerdictDbException {
    StringBuilder sql = new StringBuilder();

    String schemaName = query.getSchemaName();
    String tableName = query.getTableName();

    // table
    sql.append("drop table ");
    sql.append(quoteName(schemaName));
    sql.append(".");
    sql.append(quoteName(tableName));
    
    return sql.toString();
  }
  
  String quoteName(String name) {
    String quoteString = syntax.getQuoteString();
    return quoteString + name + quoteString;
  }

}
