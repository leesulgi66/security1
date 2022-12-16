package com.example.security1.repository;

import com.example.security1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

//CRUD 함수를 JpaRepository가 들고있음
//JpaRepository을 상속 받았기 때문에 자동으로 Bean등록이 됨.
public interface UserRepository extends JpaRepository<User, Integer> {
    //findBy규칙 -> Username 문법
    //select * from user where username = 1?
    User findByUsername(String username);
}
