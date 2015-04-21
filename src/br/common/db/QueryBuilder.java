package br.common.db;

import org.apache.log4j.Logger;

public class QueryBuilder {
	
	private static Logger logger = Logger.getLogger(QueryBuilder.class);
	
    private String selectArg;
    private String tableArg;
    private String whereArg;
//    private String createArg;
//    private String deleteArgs;
//    private String insertArgs;
//    private String updateArgs;

    public String getQueryString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(selectArg != null ? ("SELECT " + selectArg) : "");
        strBuilder.append(tableArg != null ? (" FROM " + tableArg) : "");
        strBuilder.append(whereArg != null ? (" WHERE " + whereArg) : "");
        
        logger.info("[QueryBuilder.getQueryString()] SQL query: " + strBuilder.toString());
        return strBuilder.toString().trim();
    }

    public static class Builder {
        private String selectArg;
        private String tableArg;
        private String whereArg;

        public Builder() {

        }

        public Builder select(String arg) {
            selectArg = arg;
            return this;
        }

        public Builder inTable(String arg) {
            tableArg = arg;
            return this;
        }

        public Builder where(String arg) {
            whereArg = arg;
            return this;
        }

        public QueryBuilder build() {
            return new QueryBuilder(this);
        }
    }

    private QueryBuilder(Builder builder) {
        this.selectArg = builder.selectArg;
        this.tableArg = builder.tableArg;
        this.whereArg = builder.whereArg;
    }
}
