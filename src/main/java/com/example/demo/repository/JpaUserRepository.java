package com.example.demo.repository;

import com.example.demo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
//JpaRepository 对数据的增删改查
public interface JpaUserRepository extends JpaRepository<User,Integer> {

}
