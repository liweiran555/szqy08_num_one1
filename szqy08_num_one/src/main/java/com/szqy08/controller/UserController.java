package com.szqy08.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.szqy08.entity.LayuiTable;
import com.szqy08.entity.User;
import com.szqy08.entity.UserVo;
import com.szqy08.service.UserService;
import com.szqy08.util.MyConstants;
import com.szqy08.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author szqy08
 * @since 2020-07-17
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
    @Autowired
    /**
     * 依赖注入
     */
    private UserService userService;

    @RequestMapping("toShowUser")
    public String toShowUser(){
        return "/html/user/showUser";
    }

    /**
     * 多条件查询
     * @param page
     * @param limit
     * @param searchLoginName
     * @param searchUserName
     * @param searchPhoneNumber
     * @return
     */
    @RequestMapping("selectAllUser")
    @ResponseBody
    public LayuiTable selectAllUser(Integer page, Integer limit,
    String searchLoginName, String searchUserName, String searchPhoneNumber){

        LayuiTable table = new LayuiTable();
        // 多条件查询所需要的集合
        Map<String, Object> condition = new HashMap(16);
condition.get("con");
        Wrapper wrapper = new EntityWrapper();
        // 添加模糊查询条件
        if(null != searchLoginName && !"".equals(searchLoginName)){
            wrapper.like("login_name",searchLoginName);
            condition.put("login_name",searchLoginName);
        }
        if(null != searchUserName && !"".equals(searchUserName)){
            wrapper.like("user_name",searchUserName);
            condition.put("user_name",searchUserName);
        }
        if(null != searchPhoneNumber && !"".equals(searchPhoneNumber)){
            wrapper.like("phonenumber",searchPhoneNumber);
            condition.put("phonenumber",searchPhoneNumber);
        }
        wrapper.eq("del_flag",0);
        condition.put("del_flag",0);
        int userListCount = userService.selectCount(wrapper);
        // 如果表中没有数据,则不进行分页查询
        if(userListCount>0){
            // 获取当前的系统毫秒数
            long start = System.currentTimeMillis();
            Page<UserVo> pageInfo = new Page(page,limit);
            List<UserVo> userVoList = userService.selectUserVoList(pageInfo, condition);
            // 从分页结果中提取list集合
            table.setMsg(MyConstants.OPERATION_SUCCESS_MESSAGE);
            table.setCode(MyConstants.OPERATION_SUCCESS_CODE);
            table.setData(userVoList);
            table.setCount(userListCount);
            long end = System.currentTimeMillis();
            System.out.println("==========查询花费时间:"+(end-start)+"===========");
            return table;
        }else {
            return table;
        }
    }

    /**
     * 批量删除
     * @param userList
     * @return
     */
    @RequestMapping("deleteBatchDept")
    @ResponseBody
    public Result deleteBatchDept(@RequestBody List<User> userList){
        List<User> userListNew = new ArrayList<>();
        // 逻辑删除,修改del_flag
        for (User user : userList) {
            User userNew = new User();
            userNew.setDelFlag("1");
            userNew.setUserId(user.getUserId());
            userListNew.add(userNew);
        }
        boolean update = userService.updateBatchById(userListNew);
        if(update){
            return super.success();
        }else {
            return super.error();
        }
    }
}

