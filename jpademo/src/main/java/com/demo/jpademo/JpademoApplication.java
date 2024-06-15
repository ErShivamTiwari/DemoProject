package com.demo.jpademo;

import com.demo.jpademo.dao.StudentDAO;
import com.demo.jpademo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JpademoApplication {


	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return (runner) -> {

//			createStudent(studentDAO);
//			getStudent(studentDAO);
//			getAllStudent(studentDAO);
//			doUpdateStudent(studentDAO);
//			doUpdateAllStudent(studentDAO);
//			deleteById(studentDAO);
//			deleteAllData(studentDAO);
		};
	}

	private void deleteAllData(StudentDAO studentDAO) {
		studentDAO.deleteAllStudents();
		System.out.println("All data deleted.");
	}

	private void deleteById(StudentDAO studentDAO) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter id which you want to delete");
		int id = scanner.nextInt();
		studentDAO.deleteStudentById(id);
		System.out.println("Student deleted successfully");

	}


///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	//below mentioned code is for entering data in db

	public void createStudent(StudentDAO studentDAO) {
		//create student object

		Student tempStudent = new Student("satyam","tiwari","satyam.tiwari@outlook.com");

		//save student object

		studentDAO.saveIntoDB(tempStudent);

		//display the id of student for db
		System.out.println("student id" + tempStudent.toString());
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	//below mentioned code is for grting single record from db

	public void getStudent(StudentDAO studentDAO) {
		Student stName=studentDAO.getStudentById(1);
		System.out.println(stName.getFirstName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	//below mentioned code is for getting all data from db

	public void getAllStudent(StudentDAO studentDAO) {
		List<Student> allStudents = studentDAO.getAllStudents();
		for (Student student : allStudents) {
			System.out.println(student.toString());
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	//below mentioned code is for getting all data from db by quering the data with where clause i.e last name

	public void getAllStudentsByName(StudentDAO studentDAO) {
		List<Student> gettAllData=studentDAO.getStudentsByName("Shivam");
		for (Student student : gettAllData) {
			System.out.println(student.toString());
		}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	//below mentioned code is for updating the data from db only for single row.

	private void doUpdateStudent(StudentDAO studentDAO) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("enter id = ");
		int stId=scanner.nextInt();

		Student st=studentDAO.getStudentById(stId);
		System.out.println("enter first name = ");
		st.setFirstName(scanner.next());
		studentDAO.updateStudent(st);

	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	//below mentioned code is for updating the data from db only for all row.


	private void doUpdateAllStudent(StudentDAO studentDAO) {

		studentDAO.updateAllStudents("Hanumanji ramji");

	}



}
