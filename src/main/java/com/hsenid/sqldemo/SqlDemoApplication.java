package com.hsenid.sqldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SqlDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqlDemoApplication.class, args);
	}

}
