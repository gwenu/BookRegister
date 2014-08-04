package br.common.db;

public class QueryBuilder {
    private String createArg;
    private String selectArg;
    private String deleteArgs;
    private String insertArgs;
    private String updateArgs;
    private String tableArg;
    private String whereArg;

    public String getQueryString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("SELECT " + selectArg);
        strBuilder.append("FROM " + tableArg);
//        strBuilder.append("");
        return strBuilder.toString();
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

        public Builder table(String arg) {
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
