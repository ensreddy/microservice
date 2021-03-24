package com.netflixfilms;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class SpringbootpostgressqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootpostgressqlApplication.class, args);
	}

	@Bean
	public DataSourceInitializer dataSourceInitializer(@Qualifier("dataSource") final DataSource dataSource) {
		ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
		resourceDatabasePopulator.addScript(new ClassPathResource("/Films.sql"));
		DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
		dataSourceInitializer.setDataSource(dataSource);
		dataSourceInitializer.setDatabasePopulator(resourceDatabasePopulator);
		return dataSourceInitializer;
	}

	@Configuration
	public class SpringFoxConfig {
		@Bean
		public Docket api() {
			return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
					.paths(PathSelectors.any()).build();
		}
	}
}
