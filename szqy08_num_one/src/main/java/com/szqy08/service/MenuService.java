package com.szqy08.service;

import com.szqy08.entity.LayUiTree;
import com.szqy08.entity.Menu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Set;


/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author szqy08
 * @since 2020-07-17
 */
public interface MenuService extends IService<Menu> {

    List<LayUiTree> findMenus(String loginName);
    Set<String> findAllMenusByLoginName(String LoginName);

}
