package org.challenge.coding.subscriptionservice.config;

import org.h2.jdbcx.JdbcDataSource;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	@Bean
	public DataSource createDataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL("jdbc:h2:~/subDB");
		return dataSource;
	}
	
}
