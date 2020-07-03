package com.ricci.almacen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication
@EnableAutoConfiguration(exclude = {HibernateJpaAutoConfiguration.class})
//@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)

@SpringBootApplication (exclude = {DataSourceAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
	HibernateJpaAutoConfiguration.class})
public class AlmacenMoniyPepeApplication  extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AlmacenMoniyPepeApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AlmacenMoniyPepeApplication.class, args);
	}

}
