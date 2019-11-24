package com.example.demo.controller;
/**
 * create api
 * 1.create bean class
 * 2.create iparepository繼承類
 * 3.create definition errocode resultModel class
 * 4.fengzhuang resultModelTool back result accoording to definition errocode mode class
 * 5.provide service interface
 * 6.create class achieve provive service interface definition class type;
 * 7.definition cottroller class to deal with result
 */

import com.example.demo.bean.User;
import com.example.demo.result.ResultModel;
import com.example.demo.result.ResultModelTool;
import com.example.demo.service.ErrorCode;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResultModel getAllUser() {
        List<User> userList = iUserService.getAllUser();
        Map<String, List<User>> userMap = new HashMap();
        if (userList != null) {
            userMap.put("users", userList);
        }
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(0);
        resultModel.setData(userMap);
        return ResultModelTool.handlerResultMode(resultModel);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public ResultModel addUser(@RequestParam int id, @RequestParam String name) {
        User user = new User(id, name);
        int errocode = iUserService.addUser(user);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(errocode);
        switch (errocode) {
            case ErrorCode.ADDSUCCESS:
                resultModel.setMsg("添加成功");
                break;
            case ErrorCode.ADDFAIL:
                resultModel.setMsg("添加失敗");
                break;
        }
        resultModel.setData(user);
        return ResultModelTool.handlerResultMode(resultModel);
    }

    @RequestMapping(value = "/del", method = RequestMethod.GET)
    private ResultModel delUser(@RequestParam int id) {
        int erroCode = iUserService.delUser(id);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(erroCode);
        List<User> users = iUserService.getAllUser();
        Map<String, List<User>> listMap = new HashMap<>();
        if (users != null) {
            listMap.put("users", users);
        }
        resultModel.setData(listMap);
        resultModel.setCode(erroCode);
        switch (erroCode) {
            case ErrorCode.DELETESUCCESS:
                resultModel.setMsg("删除成功");
                break;
            case ErrorCode.DELETEFAIL:
                resultModel.setMsg("删除失败");
                break;
        }
        return ResultModelTool.handlerResultMode(resultModel);
    }

    @RequestMapping(value = "/updata", method = RequestMethod.GET)
    public ResultModel upDataUser(@RequestParam int id, @RequestParam String name) {
        User user = new User(id, name);
        int erroCode = iUserService.upDataUser(user);
        ResultModel resultModel = new ResultModel();
        resultModel.setCode(erroCode);
        resultModel.setData(user);
        return ResultModelTool.handlerResultMode(resultModel);
    }

}
