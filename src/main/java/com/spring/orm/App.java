package com.spring.orm;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
//        Student student = new Student("Sheetal ORM", "Mumbai ORM");
//        int result = studentDao.insert(student);
//        System.out.println("Student values inserted with rows affected:"+result);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        boolean go = true;
        while(go){
            System.out.println("PRESS 1 for add new student");
            System.out.println("PRESS 2 for display all students");
            System.out.println("PRESS 3 for get details of single student");
            System.out.println("PRESS 4 for delete student");
            System.out.println("PRESS 5 for update student details");
            System.out.println("PRESS 6 for exit");
            try {
                int input = Integer.parseInt(bf.readLine());
                switch (input){
                    case 1:
                        //add a student
                        Student student = new Student("Sheetal Press", "Mumbai Press");
                        int result = studentDao.insert(student);
                        System.out.println("Student values inserted with rows affected:"+result);
                        break;
                    case 2:
                        //display all students
                        List<Student> students =  studentDao.getAllStudent();
                        for(Student s:students){
                            System.out.println(s.getId()+", "+s.getName()+", "+s.getCity());
                        }
                        break;
                    case 3:
                        //get details of single student
                        Student studentDetails = studentDao.getStudent(15);
                        System.out.println(studentDetails.getId()+", "+studentDetails.getName()+", "+studentDetails.getCity());
                        break;
                    case 4:
                        //delete student
                        studentDao.deleteStudent(14);
                        System.out.println("Student has been deleted with id: 14");
                        break;
                    case 5:
                        //update student
                        Student updateStudent = new Student(13,"Sheetal Presssss", "Mumbai Presssss");
                        studentDao.updateStudent(updateStudent);
                        break;
                    case 6:
                        //exit
                        go = false;
                        break;
                }
            }catch (Exception e){
                System.out.println("Invalid input. Please try with another one!!");
                System.out.println(e.getMessage());

            }
        }



    }
}
