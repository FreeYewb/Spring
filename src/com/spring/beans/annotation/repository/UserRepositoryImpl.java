package com.spring.beans.annotation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.beans.annotation.TestObject;

@Repository("userRepository1")
public class UserRepositoryImpl implements UserRepository {
    @Autowired(required = false)
    private TestObject testObject;
    @Override
    public void save() {
        // TODO Auto-generated method stub
        System.out.println("UserRepository save");
        System.out.println(testObject);
    }

}
