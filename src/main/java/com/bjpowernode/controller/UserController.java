package com.bjpowernode.controller;


import com.bjpowernode.pojo.User;
import com.bjpowernode.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;
    public static final Integer PAGE_SIZE = 5;

    @RequestMapping("/selectUserPage")
    public List<User> selectUserPage(String userName, String userSex,Integer page){
        if(page == null){
            page=1;
        }
        return userService.selectUserPage(userName, userSex, page, PAGE_SIZE);
    }

    @RequestMapping("/getRowCount")
    public int getRowCount(String userName,String userSex){
        return userService.getRowCount(userName, userSex);
    }

    @RequestMapping("/deleteUserById")
    public int deleteUserById(String userId){
        return userService.deleteUserById(userId);
    }

    @RequestMapping("/createUser")
    public int createUser(User user){
        String userId = System.currentTimeMillis() + "";
        Random random = new Random();
        int num = random.nextInt(8999) + 1000;
        userId = userId + num;
        user.setUserId(userId);
        return userService.createUser(user);
    }

    @RequestMapping("/updateUserById")
    public int updateUserById(User user){
        return  userService.updateUserById(user);
    }

    @RequestMapping("/deleteUserByIdList")
    public int deleteUserByIdList( @RequestParam List userIds){
        return  userService.deleteUserByIdList(userIds);
    }
}
