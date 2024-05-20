package com.springjdbc;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.springjdbc.dao.StudentDao;
import com.springjdbc.dao.StudentDaoImpl;
import com.springjdbc.entities.Student;
/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Program started");
	//	ApplicationContext con=new ClassPathXmlApplicationContext("com/springjdbc/config.xml");//this is xml configuration
		ApplicationContext con= new AnnotationConfigApplicationContext(JdbcConfig.class);//this is based on annotation
		StudentDao st=con.getBean("studentDao", StudentDaoImpl.class);
		/*  Student stu=new Student();
        stu.setId(345);
        stu.setName("Ram");
        stu.setCity("Delhi");
        int result =st.insert(stu);
       System.out.println("Student added : "+result);
       Student stu=new Student();
       stu.setId(345);
       stu.setName("anuj");
       stu.setCity("Mumbai");
       int result=st.change(stu);
       System.out.println("Student updated : "+result);*/
		//  int result=st.delete(456);
		// System.out.println("Student deleted : "+result);
		//select student
	//	Student stud=st.getStudent(457);
	//	System.out.println(stud);
		//Select all student
		List<Student> allStud=st.getAllStudent();
		for(Student s:allStud) {
		System.out.println(s);
		}
	}
}
