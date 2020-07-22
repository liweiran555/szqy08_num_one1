package com.szqy08.util;

import com.szqy08.entity.LayUiTree;
import com.szqy08.entity.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @fileName:TreeUtil
 * @description:树形工具类
 * @author:cxj
 * @createTime:2020/7/20 0020 上午 9:42
 * @version:1.0.0
 */
public class TreeUtil {

    /**
     * 将List<Menu>换成 List<LayUiTree>
     * @param menuList
     * @return
     */
    public static List<LayUiTree> fromMenuListToTreeList(List<Menu> menuList){
        List<LayUiTree> treeList = new ArrayList();
        //遍历所有的menu对象，然后发现menu对象有孩子，就继续便利孩子，递归操作
        for (Menu menu : menuList) {
            //如果父亲的id为0，就说明是一级目录
            if(menu.getParentId() == 0){
                //将menu转成tree对象
                LayUiTree tree = fromMenuToTree(menu);
                LayUiTree treeChilren = setTreeChilren(tree,menuList);
                treeList.add(treeChilren);
            }
        }
        return treeList;
    }

    /**
     * 找自己的孩子,给tree对象设置孩子children
     * @param tree
     * @param menuList
     * @return
     */
    public static LayUiTree setTreeChilren(LayUiTree tree, List<Menu> menuList){
        //此集合封装所有的孩子
        List<LayUiTree> chilren = new ArrayList();
        for (Menu menu : menuList) {
            if(menu.getParentId() == tree.getId()){
                //将menu转成tree对象
                LayUiTree layUiTree = fromMenuToTree(menu);
                chilren.add(setTreeChilren(layUiTree, menuList));
            }
        }
        tree.setChildren(chilren);
        return tree;
    }

    /**
     * 将menu对象转换成tree对象
     * @param menu
     * @return
     */
    public static LayUiTree fromMenuToTree(Menu menu){
        LayUiTree layUiTree = new LayUiTree();
        layUiTree.setId(menu.getMenuId());
        layUiTree.setTitle(menu.getMenuName());
        layUiTree.setUrl(menu.getUrl());
        return layUiTree;
    }
}
