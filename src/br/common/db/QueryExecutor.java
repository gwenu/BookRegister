package br.common.db;

import br.common.models.Model;

public class QueryExecutor{
    private static Database database = Database.getInstance();

    public QueryExecutor() {

    }

    public Model execute(QueryBuilder query) {
        return database.executeQuery(query);
    }
}
