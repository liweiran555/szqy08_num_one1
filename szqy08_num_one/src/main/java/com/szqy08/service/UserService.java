package com.szqy08.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.szqy08.entity.User;
import com.baomidou.mybatisplus.service.IService;
import com.szqy08.entity.UserVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author szqy08
 * @since 2020-07-17
 */
public interface UserService extends IService<User> {

    /**
     * 用户分页多条件查询
     * @param pageInfo
     * @param condition
     * @return
     */
    List<UserVo> selectUserVoList(Page<UserVo> pageInfo, Map<String,Object> condition);
}
