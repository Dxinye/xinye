package com.elite.util;

import java.util.ArrayList;
import java.util.List;
/**
 * 提取中括号中的字符串
 * @author rd
 *
 */
public class ExtractMessage {
	/** 
     * 提取中括号中内容，忽略中括号中的中括号，返回list集合，将中括号中的内容以list集合对象形式返回；
     * @param msg 
     * @return 
     */  
    public static List<String> extractMessage(String msg) {  
        List<String> list = new ArrayList<String>();  
        int start = 0;  	//保存第几个中括号
        int startFlag = 0;  	//记录中括号左边的位置
        int endFlag = 0;  	//记录中括号，右边的位置
        for (int i = 0; i < msg.length(); i++) { 
        	//System.out.println(msg.charAt(i));
        	//使用charAt()方法找出[的位置；
            if (msg.charAt(i) == '[') {  
                startFlag++;  
                if (startFlag == endFlag + 1) {  
                    start = i;  
                }  
            } else if (msg.charAt(i) == ']') {  
                endFlag++;  
                if (endFlag == startFlag) {  
                    list.add(msg.substring(start + 1, i));  
                }  
            }  
        }  
        return list;  
    }  
}
