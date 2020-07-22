package com.szqy08.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.szqy08.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author szqy08
 * @since 2020-07-17
 */
public interface MenuDao extends BaseMapper<Menu> {

    /**
     *
     * @param loginName
     * @return
     */
    List<Menu> findMenusByLoginName(@Param("loginName") String loginName);
}
