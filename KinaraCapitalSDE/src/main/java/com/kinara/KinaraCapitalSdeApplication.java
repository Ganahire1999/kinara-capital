package com.kinara;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import Repository.StudentRepository;
import Repository.bean;
import model.Student;

@SpringBootApplication
@ComponentScan("com.kinara")
@bean
@Configuration
public class KinaraCapitalSdeApplication implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(KinaraCapitalSdeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Call the method to add data to the database
        initData();
    }

    private void initData() {
        // Create and save student objects
        Student student1 = new Student(1, "Ganesh hire", 90);
        Student student2 = new Student(2, "Yash patil", 85);
        Student student3 = new Student(3, "ashwin hire", 95);
        Student student4 = new Student(4, "ram krishna", 85);
        Student student5 = new Student(5, "shree  ram", 74);
        Student student6 = new Student(6, "krishna yadav", 95);
        Student student7 = new Student(7, "sita  ram", 4);
        Student student8 = new Student(8, "jay  ram", 19);
        Student student9 = new Student(9, "jiya  ram", 17);
        Student student10 = new Student(10, "om  ram", 12);
        

        StudentRepository.save(student1);
        StudentRepository.save(student2);
        StudentRepository.save(student3);
        StudentRepository.save(student4);
        StudentRepository.save(student5);
        StudentRepository.save(student6);
        StudentRepository.save(student7);
        StudentRepository.save(student8);
        StudentRepository.save(student9);
        StudentRepository.save(student10);

        System.out.println("Data initialization completed.");
    }
}


