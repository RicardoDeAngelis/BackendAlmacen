package com.ricci.almacen.configuration;



import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration {

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		// TODO Auto-generated constructor stub
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("com.ricci.almacen.model");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		return sessionFactoryBean;
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://us-cdbr-east-02.cleardb.com/heroku_3c1505408428a6f?serverTimezone=UTC");
		dataSource.setUsername("b473a9d1e0f25d");
		dataSource.setPassword("5ed20b94");
		
		return dataSource;
	}
	
	public Properties hibernateProperties() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.put("show_sql", "true");
		
		
		return properties;
	}
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager () {
		
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
		return hibernateTransactionManager;
		
	}
	
	

}
