package com.elite.test;

import java.util.ArrayList;
import java.util.List;

import com.elite.index.TreeHelper;
import com.elite.vo.Indextable;


public class TestTree {
	public static void main(String args[]){
		
		List<Indextable> nodes = new ArrayList<>();
        //Node node = new Node();
        
        nodes.add(new Indextable(1, 0, "组织架构"));
        nodes.add(new Indextable(2, 1, "党委a"));
        nodes.add(new Indextable(3, 1, "党委b"));
        nodes.add(new Indextable(4, 2, "a支部1"));
        nodes.add(new Indextable(5, 2, "a支部2"));
        nodes.add(new Indextable(6, 2, "a支部3"));
        nodes.add(new Indextable(7, 3, "b支部1"));
        nodes.add(new Indextable(8, 3, "b支部2"));
        nodes.add(new Indextable(9, 4, "b支部3"));
        nodes.add(new Indextable(10,0,"小强"));

        List<Indextable> list = TreeHelper.getSortedNodes(nodes);

        for (Indextable node : list) {
            for (int i = 0; i < node.getLevel(); i++){
            	System.out.print("  ");
            }
                
            System.out.println(node.getId() + " " + node.getText());
        }
		
	}
}
