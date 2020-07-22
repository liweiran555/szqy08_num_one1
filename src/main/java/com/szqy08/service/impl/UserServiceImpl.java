package com.szqy08.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.szqy08.entity.User;
import com.szqy08.dao.UserDao;
import com.szqy08.entity.UserVo;
import com.szqy08.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author szqy08
 * @since 2020-07-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 用户分页菜单多条件查询
     * @param pageInfo
     * @param condition
     * @return
     */
    @Override
    public List<UserVo> selectUserVoList(Page<UserVo> pageInfo, Map<String, Object> condition) {
        return userDao.selectUserVoList(pageInfo,condition);
    }
}
