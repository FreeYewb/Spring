package com.spring.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.test.pojo.Student;
@Service("studentService1")
public class StudentServiceImpl implements StudentService{
	@Autowired
    private Student student = null;

     // getter and setter

    public Student getStudent() {
		return student;
	}

	

	public void printStudentInfo() {
        System.out.println("学生的 id 为：" + student.getId());
        System.out.println("学生的 name 为：" + student.getName());
    }
}
