package com.example.demo.service.user;

import com.example.demo.bean.User;
import com.example.demo.repository.JpaUserRepository;
import com.example.demo.service.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//实现User的增删改查
@Service
public class UserService implements IUserService {
    @Autowired
    JpaUserRepository jpaUserRepository;

    @Override
    public List<User> getAllUser() {
        List<User> users = jpaUserRepository.findAll();
        System.out.print(users.toString());
        return users;
    }

    @Override
    public int addUser(User user) {
        if (jpaUserRepository.existsById(user.getId())) {
            System.out.print(ErrorCode.EXISTUSER);
            return ErrorCode.EXISTUSER;
        }

        User addUser = jpaUserRepository.save(user);
        if (addUser != null && addUser.getId() == user.getId()) {
            System.out.print(ErrorCode.ADDSUCCESS);
            return ErrorCode.ADDSUCCESS;
        } else {
            System.out.print(ErrorCode.ADDFAIL);
            return ErrorCode.ADDFAIL;
        }
    }

    @Override
    public int delUser(int id) {
        if (jpaUserRepository.existsById(id)) {
            jpaUserRepository.deleteById(id);
            System.out.print(ErrorCode.DELETESUCCESS);
            return ErrorCode.DELETESUCCESS;
        }
        System.out.print(ErrorCode.DELETEFAIL);
        return ErrorCode.DELETEFAIL;
    }

    @Override
    public int upDataUser(User user) {
        if (jpaUserRepository.existsById(user.getId())) {
            jpaUserRepository.save(user);
            System.out.print(ErrorCode.UPDATESUCCESS);
            return ErrorCode.UPDATESUCCESS;
        }
        System.out.print(ErrorCode.UPDATEFAIL);
        return ErrorCode.UPDATEFAIL;
    }

    @Override
    public User queryUser(int id) {
        User queryUser = null;
        if (jpaUserRepository.existsById(id)) {
            System.out.print(ErrorCode.REQUESTSUCCESS);
            queryUser = jpaUserRepository.findById(id).get();
        }
        return queryUser;
    }
}
