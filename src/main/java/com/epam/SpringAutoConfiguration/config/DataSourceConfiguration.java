package com.epam.SpringAutoConfiguration.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource defaultDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:firstDb");
        dataSource.setUsername("user1");
        dataSource.setPassword("pass1");
        return dataSource;
    }

    @Bean
    @ConditionalOnMissingBean
    public DataSource conditionalDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:secondDb");
        dataSource.setUsername("user2");
        dataSource.setPassword("pass2");
        return dataSource;
    }
}
