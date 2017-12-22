package com.elite.index;

import java.util.ArrayList;
import java.util.List;

import com.elite.vo.Indextable;

public class TreeHelper {
	public static List<Indextable> getSortedNodes(List<Indextable> datas) {
        List<Indextable> result = new ArrayList<>();
        // 设置Node间父子关系
        List<Indextable> nodes = convertData2Node(datas);
        // 拿到根节点
        List<Indextable> rootNodes = getRootNodes(nodes);
        // 排序以及设置Node间关系
        for (Indextable node : rootNodes) {
            addNode(result, node, 0);
        }
        return result;
    }
	//设置node间的父子关系
    private static List<Indextable> convertData2Node(List<Indextable> nodes) {

        for (int i = 0; i < nodes.size(); i++) {
        	Indextable n = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
            	Indextable m = nodes.get(j);
                if (m.getParentID() == n.getId()) {
                    n.getChildren().add(m);
                    m.setParent(n);
                } else if (m.getId() == n.getParentID()) {
                    m.getChildren().add(n);
                    n.setParent(m);
                }
            }
        }
        return nodes;
    }
    //获得根节点
    private static List<Indextable> getRootNodes(List<Indextable> nodes) {
        List<Indextable> root = new ArrayList<>();
        for (Indextable node : nodes) {
            if (node.isRoot())
                root.add(node);
        }
        return root;
    }
    //设置节点关系
    private static void addNode(List<Indextable> nodes, Indextable node, int currentLevel) {
        node.setLevel(currentLevel);
        nodes.add(node);
        if (node.isLeaf())
            return;
        for (int i = 0; i < node.getChildren().size(); i++) {
            addNode(nodes, node.getChildren().get(i), currentLevel + 1);
        }
    }

}
