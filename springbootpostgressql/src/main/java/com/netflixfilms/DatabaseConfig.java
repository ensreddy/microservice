package com.netflixfilms;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class DatabaseConfig extends HikariConfig {
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(this);
    }
}