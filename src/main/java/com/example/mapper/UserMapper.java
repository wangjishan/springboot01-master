package com.example.mapper;

import com.example.entity.OrdersExt;
import com.example.entity.QueryVo;
import com.example.entity.User;
import com.example.entity.Users;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

/**
 * 练习
 * <p>
 * Created by user on 2017/4/17.
 */

@Component
public interface UserMapper {

    /*根据用户的id进行查询*/
    public User findUserById(int id);

    public User findUserByIdRstMap(int id);

    /*插入一条数据*/
    public void insertUser(User user);

    public Integer insertUser2(User user);

    /*获取整张表的数据*/
    public List<User> findUserAll();

    /*多条件查询(模糊查询)*/
    public List<User> findUserList(QueryVo queryvo);


    /*foreach标签的练习*/
    public List<User> findUserListForeach(QueryVo queryvo);


    /*获取查询结果的三数量*/
    public Integer findUserListCount(QueryVo queryvo);

    /*分页查询的练习*/
    public List<Users> usersPagingQuery(HashMap<String, String> map);

    /*一对一映射练习*/
    public List<OrdersExt> findOrderAndUser();

    /*一对一映射练习*/
    public List<OrdersExt> findOrderAndUser2();

    /*一对多映射练习*/
    public List<OrdersExt> findOrderAndUser3();

    /*多对多映射练习*/
    public List<OrdersExt> findOrderAndUser4();
}
