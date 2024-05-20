package com.springjdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entities.Student;

public class StudentDaoImpl implements StudentDao{
	private JdbcTemplate jdbcTemplate;	
	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub
		String query="insert into student(id,name,city) values(?,?,?)";
		int r=this.jdbcTemplate.update(query,student.getId(),student.getName(),student.getCity());
		return r;
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int change(Student student) {
		// update query
		String query="update student set name=?,city=? where id=?";
		int r=this.jdbcTemplate.update(query, student.getName(),student.getCity(),student.getId());   
		return r;
	}
	@Override
	public int delete(int studentId) {
		// delete operation
		String query="delete from student where id=?";
		int r=this.jdbcTemplate.update(query, studentId);   
		return r;
	}
	@Override
	public Student getStudent(int studentId) {
		// select single  student
		String query="Select * from student where id=?";
		RowMapper<Student> rowMapper=new RowMapperImpl();
		Student st=this.jdbcTemplate.queryForObject(query, rowMapper,studentId);
		return st;
	}
	@Override
	public List<Student> getAllStudent() {
		// select all student
		String query="select * from student";
		List<Student> st=this.jdbcTemplate.query(query,new RowMapperImpl());
		return st;
	}

}
