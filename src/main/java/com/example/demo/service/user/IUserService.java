package com.example.demo.service.user;

import com.example.demo.bean.User;

import java.util.List;

//IUserService接口中定义对改User实体进行的操作方法
public interface IUserService {
    //查詢所有用戶
    List<User> getAllUser();

    //增加
    int addUser(User user);

    //刪除
    int delUser(int id);

    //更改
    int upDataUser(User user);

    //查询
    User queryUser(int id);

}
