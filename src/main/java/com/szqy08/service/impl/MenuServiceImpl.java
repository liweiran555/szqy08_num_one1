package com.szqy08.service.impl;


import com.szqy08.entity.LayUiTree;
import com.szqy08.entity.Menu;
import com.szqy08.dao.MenuDao;
import com.szqy08.service.MenuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import com.szqy08.util.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author szqy08
 * @since 2020-07-17
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuDao, Menu> implements MenuService {

    @Autowired
    private MenuDao menuDao;

    /**
     * 根据登录名字查询树状菜单
     * @param loginName
     * @return
     */
    @Override
    public List<LayUiTree> findMenus(String loginName) {
        // 查询出所有的menu
        List<Menu> menuList = menuDao.findMenusByLoginName(loginName);
        // 将List<Menu>换成 List<LayUiTree>
        List<LayUiTree> treeList = TreeUtil.fromMenuListToTreeList(menuList);
        return treeList;
    }


    /**
     * 根据登录用户名放回此用户关联的所有权限关键字
     * @param LoginName
     * @return
     */
    @Override
    public Set<String> findAllMenusByLoginName(String LoginName) {
        // 查询出所有的Menu
        List<Menu>  menuList = menuDao.findMenusByLoginName(LoginName);
        //过滤重复关键字
        Set<String> perms = new HashSet<String>();
        for (Menu menu : menuList) {
            if(menu.getPerms() != null&&menu.getPerms().length()>0){
                perms.add(menu.getPerms());
            }
        }
        return perms;
    }
}
