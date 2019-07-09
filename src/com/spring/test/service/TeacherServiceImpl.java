package com.spring.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.test.pojo.Student;

@Service("studentService")
public class TeacherServiceImpl implements StudentService {
	@Autowired
    private Student student = null;
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public void printStudentInfo() {
		// TODO Auto-generated method stub
		System.out.println("学生的 name 为：" + student.getName());
	}

}
