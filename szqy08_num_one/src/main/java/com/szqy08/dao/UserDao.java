package com.szqy08.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.szqy08.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.szqy08.entity.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author szqy08
 * @since 2020-07-17
 */
public interface UserDao extends BaseMapper<User> {

    /**
     * 用户分页多条件查询
     * @param pageInfo
     * @param condition
     * @return
     */
    List<UserVo> selectUserVoList(Page<UserVo> pageInfo, @Param("condition") Map<String,Object> condition);
}
