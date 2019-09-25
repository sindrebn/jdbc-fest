package com.github.sindrebn;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public class DB {

    private static DataSource dataSource;

    public static DataSource getInstance() {
        if (dataSource == null) {
            dataSource = new EmbeddedDatabaseBuilder()
                    .setType(EmbeddedDatabaseType.HSQL)
                    .addScript("classpath:/schema.sql")
                    .build();
        }
        return dataSource;
    }
}
