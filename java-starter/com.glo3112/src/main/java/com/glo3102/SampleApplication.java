package com.glo3102;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

// NOTE: For including the database configuration, you need to setup the proper urls in your config file.
// See application.properties file at https://github.com/netgloo/spring-boot-samples/tree/master/spring-boot-mysql-springdatajpa-hibernate for a very good example.
@ComponentScan
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class SampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}
}
