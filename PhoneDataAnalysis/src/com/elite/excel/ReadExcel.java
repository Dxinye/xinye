package com.elite.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.elite.vo.OriginalData;

public class ReadExcel {
	
	public List<OriginalData> readXls(String file) throws IOException{
		//创建输入流对象
		InputStream is = new FileInputStream(file);
		//创建工作簿对象	
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is); 
		//日期格式化   
        DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        //声明实体类对象	
        OriginalData content =null;
		//创建list集合
		List<OriginalData> list = new ArrayList<OriginalData>();
		//遍历工作表
		System.out.println("已执行遍历所有工作表");
		
		//String str = "";
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++){
			//创建工作表对象
			HSSFSheet sheet = hssfWorkbook.getSheetAt(numSheet);
			if(sheet==null){
				System.out.println("120");
				continue;
			}
			//遍历工作表的所有行
			for(int rowNum=3;rowNum<=sheet.getLastRowNum();rowNum++){
				System.out.println("已执行遍历工作表中所有行");
				//获取工作表行数
				HSSFRow hssfRow = sheet.getRow(rowNum);
				if(hssfRow != null){
					content = new OriginalData();
					//读取excel表的每一列的数据
					HSSFCell serviceRdnumber = hssfRow.getCell(0);
					HSSFCell acceptNumber = hssfRow.getCell(1);
					HSSFCell skillQueue = hssfRow.getCell(2);
					HSSFCell workGroup = hssfRow.getCell(3);
					HSSFCell zuoxiNumber = hssfRow.getCell(4);
					HSSFCell serviceName = hssfRow.getCell(5);
					HSSFCell serviceNickname = hssfRow.getCell(6);
					HSSFCell visitWay = hssfRow.getCell(7);
					HSSFCell visitIP  = hssfRow.getCell(8);
					HSSFCell IPProvice = hssfRow.getCell(9);
					HSSFCell businessType = hssfRow.getCell(10);
					HSSFCell clientRank = hssfRow.getCell(11);
					HSSFCell clientBrand = hssfRow.getCell(12);
					HSSFCell clientProvice = hssfRow.getCell(13);
					HSSFCell clientCity = hssfRow.getCell(14);
					HSSFCell conversationStartTime = hssfRow.getCell(15);
					HSSFCell conversationEndTime = hssfRow.getCell(16);
					HSSFCell conversationAssess = hssfRow.getCell(17);
					HSSFCell conversationTime = hssfRow.getCell(18);
					HSSFCell replyIntervalTime = hssfRow.getCell(19);
					HSSFCell satisfactionType = hssfRow.getCell(20);
					HSSFCell solveType = hssfRow.getCell(21);
					HSSFCell endPerson = hssfRow.getCell(22);
					HSSFCell endSeason = hssfRow.getCell(23);
					HSSFCell clientSpeakFrequency = hssfRow.getCell(24);
					HSSFCell serviceSpeakFrequency = hssfRow.getCell(25);
					HSSFCell interactionFrequency = hssfRow.getCell(26);
					HSSFCell isvalidConversation = hssfRow.getCell(27);
					HSSFCell comment = hssfRow.getCell(28);
					HSSFCell conversationContent = hssfRow.getCell(29);
					HSSFCell robotConversationContent = hssfRow.getCell(30);
					//将数据保存到列表中
					content.setSerRdNumber(getValue(serviceRdnumber));
					content.setAcceptNumber(getValue(acceptNumber));
					content.setSkillQueue(getValue(skillQueue));
					content.setWorkGroup(getValue(workGroup));
					content.setZuoxiNumber(getValue(zuoxiNumber));
					content.setSerName(getValue(serviceName));
					content.setSerNickname(getValue(serviceNickname));
					content.setVisitWay(getValue(visitWay));
					content.setVisitIp(getValue(visitIP));
					content.setIpProvice(getValue(IPProvice));
					content.setBusinessType(getValue(businessType));
					content.setClientRank(getValue(clientRank));
					content.setClientBrand(getValue(clientBrand));
					content.setClientProvice(getValue(clientProvice));
					content.setClientCity(getValue(clientCity));
					content.setConversationStartTime(getValue(conversationStartTime));
					content.setConversationEndTime(getValue(conversationEndTime));
					content.setConversationAssess(getValue(conversationAssess));
					
					/*int cs = (int)(conversationTime.getNumericCellValue());
					String str = String.valueOf(cs);
					content.setConversationTime(str);*/
					content.setConversationTime(getValue(conversationTime));
					content.setReplyIntervalTime(getValue(replyIntervalTime));
					content.setSatisfactionType(getValue(satisfactionType));
					content.setSolveType(getValue(solveType));
					content.setEndPerson(getValue(endPerson));
					content.setEndReason(getValue(endSeason));
					content.setClientSpeakFrequency(getValue(clientSpeakFrequency));
					content.setSerSpeakFrequency(getValue(serviceSpeakFrequency));
					content.setInteractionFrequency(getValue(interactionFrequency));
					
					content.setIsvalidConversation(getValue(isvalidConversation));
					content.setComment(getValue(comment));
					content.setConversationContent(getValue(conversationContent));
					content.setRobotConversationContent(getValue(robotConversationContent));
					list.add(content);
				}
				
			}
			System.out.println(list.size());
		}
		return list;
	}
	//将HSSFCell 类型转换为String
	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
        	return String.valueOf(hssfCell.getNumericCellValue());
        }else {
        	return String.valueOf(hssfCell.getStringCellValue());
        }
    }
	
}
