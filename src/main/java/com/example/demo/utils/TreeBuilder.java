package com.example.demo.utils;


import com.example.demo.entities.output.SysMenuTreeNode;
import com.example.demo.entities.vo.MenuVO;
import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TreeBuilder {

    public static Set<MenuVO> buildTree(Set<MenuVO> allNodes) {
        // 根节点
        Set<MenuVO> root = new HashSet<>();
        allNodes.forEach(node -> {
            if (Long.valueOf(node.getParentId()) == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findChildren(node, allNodes);
        });
        return root;
    }


    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static MenuVO findChildren(MenuVO treeNode, Set<MenuVO> treeNodes) {
        for (MenuVO it : treeNodes) {
            if (String.valueOf(treeNode.getId()).equals(it.getParentId())) {
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

    public static List<SysMenuTreeNode> buildMenuTree(List<SysMenuTreeNode> allNodes) {
        // 根节点
        List<SysMenuTreeNode> root = Lists.newArrayList();
        allNodes.forEach(node -> {
            if (Long.valueOf(node.getParentId()) == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findMenuChildren(node, allNodes);
        });

        //对根节点排序
        List<SysMenuTreeNode> sortedList = root.stream().sorted(Comparator.comparing(SysMenuTreeNode::getSortNo)).collect(Collectors.toList());
        //先清空，在添加
        root.clear();
        root.addAll(sortedList);
        return root;
    }


    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static SysMenuTreeNode findMenuChildren(SysMenuTreeNode treeNode, List<SysMenuTreeNode> treeNodes) {
        for (SysMenuTreeNode it : treeNodes) {
            if (String.valueOf(treeNode.getId()).equals(it.getParentId())) {
                treeNode.getChildren().add(findMenuChildren(it, treeNodes));
            }
        }
        //对子节点排序
        List<SysMenuTreeNode> childrenSorted = treeNode.getChildren().stream().sorted(Comparator.comparing(SysMenuTreeNode::getSortNo)).collect(Collectors.toList());
        //先清空，在添加
        treeNode.getChildren().clear();
        treeNode.getChildren().addAll(childrenSorted);
        return treeNode;
    }


}
