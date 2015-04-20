BookRegister
============

Plain JDBC for db interaction, log4j, xml api.

For using connection pool you need to configure your application server. For example in Tomcat context.xml should be specified:

<Resource
        name="jdbc/BookRegister"
        auth="Container"
        type="javax.sql.DataSource"
        factory="org.apache.tomcat.jdbc.pool.DataSourceFactory"
        driverClassName="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost/BookRegister?allowMultiQueries=true"
        initialSize="5"
        maxActive="55"
        maxIdle="21"
        minIdle="13"
        timeBetweenEvictionRunsMillis="34000"
        minEvictableIdleTimeMillis="55000"
        validationQuery="SELECT 1"
        validationInterval="34"
        testOnBorrow="true"
        removeAbandoned="true"
        removeAbandonedTimeout="233"
        username="dev_r"
        password="dev_r"
        />
