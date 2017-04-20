package com.example.web;

import com.example.entity.*;
import com.example.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * swagger2：
 * 我们通过@ApiOperation注解来给API增加说明
 * 通过@ApiImplicitParams、@ApiImplicitParam注解来给参数增加说明
 * <p>
 * 练习
 * <p>
 * Created by user on 2017/4/17.
 */

@RestController
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentProperties studentProperties;


    /**
     * 这是第一种接口的传参的形式
     *
     * @param id 传入的id
     * @GetMapping 组合注解 还有类似的putMapping等等
     * @return　user
     */
//    @RequestMapping(value = "findUserById", method = RequestMethod.GET)
    @GetMapping(value = "findUserById")
    public User findUserById(@RequestParam(value = "userId") int id) {
        User user = userMapper.findUserById(id);
        return user;
    }

    /**
     * 这是第二种接口的传参的形式
     *
     * @param id 传入的id
     * @return　user
     */
    @RequestMapping(value = "findUserById/{id}", method = RequestMethod.GET)
    public User findUserById２(@PathVariable("id") int id) {
        User user = userMapper.findUserById(id);
        return user;
    }


    @RequestMapping(value = "findUserByIdRstMap", method = RequestMethod.GET)
    public User findUserByIdRstMap(@RequestParam(value = "userId") int id) {
        User user = userMapper.findUserByIdRstMap(id);
        return user;
    }

    @PutMapping("insertUser")
    public void insertUser(
            @RequestParam(value = "username", defaultValue = "") String username,
            @RequestParam(value = "sex", defaultValue = "") String sex,
            @RequestParam(value = "address", defaultValue = "") String address) {
        User user = new User();
        user.setUsername(username);
        user.setSex(sex);
        user.setBirthday(new Date());
        user.setAddress(address);
        userMapper.insertUser(user);
    }

    @GetMapping("insertUser2")
    public Integer insertUser2(
            @RequestParam(value = "username", defaultValue = "") String username,
            @RequestParam(value = "sex", defaultValue = "") String sex,
            @RequestParam(value = "address", defaultValue = "") String address) {
        User user = new User();
        user.setUsername(username);
        user.setSex(sex);
        user.setBirthday(new Date());
        user.setAddress(address);
        return userMapper.insertUser2(user);
    }

    @RequestMapping("findAll")
    public List<User> findUserById() {
        List<User> userAll = userMapper.findUserAll();
        return userAll;
    }

    @RequestMapping("findUserList")
    public List<User> findUserList(
            @RequestParam(value = "username", defaultValue = "", required = true) String username
            , @RequestParam(value = "sex", defaultValue = "", required = true) String sex) {
        QueryVo queryVo = new QueryVo();
        User user = new User();
        queryVo.setUser(user);
        user.setUsername(username);
        user.setSex(sex);
        return userMapper.findUserList(queryVo);
    }

    @RequestMapping("findUserListCount")
    public Integer findUserListCount(@RequestParam(value = "username", defaultValue = "", required = true) String username
            , @RequestParam(value = "sex", defaultValue = "", required = true) String sex) {
        QueryVo queryVo = new QueryVo();
        User user = new User();
        queryVo.setUser(user);
        user.setUsername(username);
        user.setSex(sex);
        return userMapper.findUserListCount(queryVo);
    }

    @RequestMapping("usersPagingQuery")
    public List<Users> usersPagingQuery(
            @RequestParam(value = "page", defaultValue = "", required = true) String page
            , @RequestParam(value = "pagesize", defaultValue = "20", required = true) String pageSize) {
        HashMap<String, String> map = new HashMap<>();
        map.put("page", (Integer.parseInt(page) - 1) * Integer.parseInt(pageSize) + "");
        map.put("pagesize", pageSize);
        return userMapper.usersPagingQuery(map);
    }

    @RequestMapping("findUserListForeach")
    public List<User> findUserListForeach() {
        QueryVo queryVo = new QueryVo();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(10);
        queryVo.setIds(integers);
        return userMapper.findUserListForeach(queryVo);
    }

    @ApiOperation(value = "获取用户列表", notes = "")
    @RequestMapping("findOrderAndUser")
    public List<OrdersExt> findOrderAndUser() {
        return userMapper.findOrderAndUser();
    }

    @RequestMapping("findOrderAndUser2")
    public List<OrdersExt> findOrderAndUser2() {
        return userMapper.findOrderAndUser2();
    }

    @RequestMapping("findOrderAndUser3")
    public List<OrdersExt> findOrderAndUser3() {
        return userMapper.findOrderAndUser3();
    }

    @RequestMapping("findOrderAndUser4")
    public List<OrdersExt> findOrderAndUser4() {
        return userMapper.findOrderAndUser4();
    }

    @RequestMapping("getStudentProperties")
    public StudentProperties getStudentProperties() {
        return studentProperties;
    }

    /**
     * 测试全局异常的捕捉
     *
     * @return
     */
    @RequestMapping("/zeroException")
    public int zeroException() {
        return 100 / 0;
    }
}
