package test;


import com.bjpowernode.pojo.User;
import com.bjpowernode.service.UserService;
import com.sun.org.apache.xerces.internal.xs.LSInputList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.ls.LSException;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext_mapper.xml","classpath:applicationContext_service.xml"})
public class Mytest {

    @Autowired
    UserService userService;

    @Test
    public void testSelectUserPage(){
        List<User> list = userService.selectUserPage(null, null, 1, 3);
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetRowCount(){
        int num = userService.getRowCount(null, null);
        System.out.println(num);
    }

    @Test
    public void testDeleteUserById(){
        int num = userService.deleteUserById("12345");
        System.out.println(num);
    }

    @Test
    public void testCreateUser(){
        int num = userService.createUser(new User("12345", "身份证", "453674839834", "ooll", "男", 24, "军人"));
        System.out.println(num);
    }

    @Test
    public void testUpdateUserById(){
        User user = new User();
        user.setUserId("12345");
        user.setUserName("ppll");
        user.setUserSex("nv");
        int num = userService.updateUserById(user);
        System.out.println(num);
    }

    @Test
    public void testDeleteUserByIdList(){
        List list = new ArrayList();
        list.add("12345");
        list.add("123456");
        int num = userService.deleteUserByIdList(list);
        System.out.println(num);
    }
}
