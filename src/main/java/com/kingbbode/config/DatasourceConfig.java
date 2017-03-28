package com.kingbbode.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by YG-MAC on 2017. 3. 26..
 */
@Configuration
public class DatasourceConfig {

    @Bean
    public DataSource dataSource(){
        DataSource dataSource = new DataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/kingbbode");
		dataSource.setUsername("root");
		dataSource.setPassword("kingbbode");

        return dataSource;
    }
}
