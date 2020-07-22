package com.szqy08.controller;



import com.szqy08.entity.LayUiTree;
import com.szqy08.entity.LayuiTable;
import com.szqy08.entity.Menu;
import com.szqy08.entity.Result;
import com.szqy08.service.MenuService;

import com.szqy08.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author szqy08
 * @since 2020-07-17
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController{
    @Autowired
    private MenuService menuService;

    /**
     * 跳转到菜单页面
     * @return
     */
    @RequestMapping("toShowMenu")
    public String toShowUser(){
        return "/html/menu/showMenu";
    }

    /**
     * 查询所有的权限菜单
     * @return
     */
    @RequestMapping("findAllMenus")
    @ResponseBody
    public List<LayUiTree> findAllMenus(){
        List<LayUiTree> layUiTreeList = menuService.findMenus(null);
        return layUiTreeList;
    }

    /**
     * 查询所有权限表格
     * @return
     */
    @RequestMapping("findAllMenusTreeTable")
    @ResponseBody
    public LayuiTable findAllMenusTreeTable(){
        List<Menu> menuList = menuService.selectList(null);
        LayuiTable table = new LayuiTable();
        table.setCode(MyConstants.OPERATION_SUCCESS_CODE);
        table.setMsg(MyConstants.OPERATION_SUCCESS_MESSAGE);
        table.setData(menuList);
        table.setCount(menuList.size());
        return table;
    }

    /**
     * 批量禁用
     * @param menuList
     * @return
     */
    @RequestMapping("deleteBachMenu")
    @ResponseBody
    public Result deleteBachMenu(@RequestBody List<Menu> menuList){
        List<Menu> menuListNew = new ArrayList<>();
        // 禁用,修改visible
        for (Menu menu : menuList) {
            Menu menuNew = new Menu();
            menuNew.setVisible("1");
            menuNew.setMenuId(menu.getMenuId());
            menuListNew.add(menuNew);
        }
        boolean update = menuService.updateBatchById(menuListNew);
        if(update){
            return super.success();
        }else{
            return super.error();
        }
    }

    /**
     * 批量显示
     * @param menuList
     * @return
     */
    @RequestMapping("showBachMenu")
    @ResponseBody
    public Result showBachMenu(@RequestBody List<Menu> menuList){
        List<Menu> menuListNew = new ArrayList<>();
        // 可用,修改visible
        for (Menu menu : menuList) {
            Menu menuNew = new Menu();
            menuNew.setVisible("0");
            menuNew.setMenuId(menu.getMenuId());
            menuListNew.add(menuNew);
        }
        boolean update = menuService.updateBatchById(menuListNew);
        if(update){
            return super.success();
        }else{
            return super.error();
        }
    }
}

