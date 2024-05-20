package com.springjdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.springjdbc.dao.StudentDao;
import com.springjdbc.dao.StudentDaoImpl;

@Configuration
public class JdbcConfig {

	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds=new  DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("Vs@739083");
		return ds;
	}
	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate template= new JdbcTemplate();
		template.setDataSource(getDataSource());
		return template;	
	}
	@Bean("studentDao")
	public StudentDao getStudentDao() {
		StudentDaoImpl std=new StudentDaoImpl();
		std.setJdbcTemplate(getTemplate());
		return std;	
	}
}
