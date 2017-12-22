package com.elite.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.elite.index.Sort;
import com.elite.service.IndexDataService;
import com.elite.vo.OriginalData;
import com.oracle.jrockit.jfr.DataType;

public class OutPutExcel{
	//注入sort
	private Sort sort; 
	//注入IndexData
	//private IndexDataService indexDataService;
	
	
	public void createExel(List<OriginalData> list){
		
		//List<OriginalData> list = new ArrayList<OriginalData>(); 
		//list = originalDataService.select();
		//OriginalData originalData = new OriginalData();
		
		//创建一个工作簿
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		//创建一个工作表对象
		HSSFSheet sheet = hssfWorkbook.createSheet("对话数据");
		// 设置表格默认列宽度为15个字节  
        sheet.setDefaultColumnWidth((short) 15);
		
		//创建行
		HSSFRow row = sheet.createRow(0);
		//创建单元格样式
		HSSFCellStyle hssfCellStyle = hssfWorkbook.createCellStyle();
		//创建一个居中样式
		hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		//创建单元格
		HSSFCell cell = row.createCell(0);
		//设置单元格内容
		cell.setCellValue("客服流水号");
		//设置样式
		cell.setCellStyle(hssfCellStyle);
		
		cell = row.createCell(1);
		cell.setCellValue("受理号码");
		cell.setCellStyle(hssfCellStyle);
		
		cell = row.createCell(2);
		cell.setCellValue("技能队列");
		cell.setCellStyle(hssfCellStyle);
		
		cell = row.createCell(3);
		cell.setCellValue("工作组");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(4);
		cell.setCellValue("坐席工号");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(5);
		cell.setCellValue("客服姓名");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(6);
		cell.setCellValue("客服昵称");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(7);
		cell.setCellValue("来访渠道");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(8);
		cell.setCellValue("来访IP");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(9);
		cell.setCellValue("IP所在省分");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(10);
		cell.setCellValue("业务类型");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(11);
		cell.setCellValue("客户级别");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(12);
		cell.setCellValue("客户品牌");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(13);
		cell.setCellValue("客户省份");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(14);
		cell.setCellValue("客户地市");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(15);
		cell.setCellValue("人工对话开始时间");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(16);
		cell.setCellValue("人工对话结束时间");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(17);
		cell.setCellValue("对话评估");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(18);
		cell.setCellValue("人工通话时长");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(19);
		cell.setCellValue("平均回复间隔时长");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(20);
		cell.setCellValue("满意度类型");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(21);
		cell.setCellValue("解决情况类型");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(22);
		cell.setCellValue("挂机方");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(23);
		cell.setCellValue("挂机原因");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(24);
		cell.setCellValue("用户发言次数");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(25);
		cell.setCellValue("客服发言次数");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(26);
		cell.setCellValue("互动次数");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(27);
		cell.setCellValue("是否有效对话");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(28);
		cell.setCellValue("备注");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(29);
		cell.setCellValue("人工对话内容");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(30);
		cell.setCellValue("机器人对话内容");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(31);
		cell.setCellValue("客服回复内容");
		cell.setCellStyle(hssfCellStyle);
		cell = row.createCell(32);
		cell.setCellValue("客户咨询问题");
		cell.setCellStyle(hssfCellStyle);
		
		//读取数据库数据并赋值给赋值给对应字段
		System.out.println(list.size());
		System.out.println(list.get(1).getAcceptNumber());
		for(int rowNum=0;rowNum<list.size();rowNum++){
			HSSFRow nextrow = sheet.createRow(rowNum+1);
			OriginalData originalData_1 = new OriginalData();
			originalData_1 = list.get(rowNum);
			if(originalData_1!=null){
				
				//if(originalData_1.getSerRdNumber()!=null&&!"".equals(originalData_1.getSerRdNumber())){
					nextrow.createCell(0).setCellValue(originalData_1.getSerRdNumber());
				//}
				//System.out.println(originalData_1.getSerRdNumber());
				//if(originalData_1.getAcceptNumber()!=null&&!"".equals(originalData_1.getAcceptNumber())){
					nextrow.createCell(1).setCellValue(originalData_1.getAcceptNumber());
				//}
				//if(originalData_1.getSkillQueue()!=null&&!"".equals(originalData_1.getSkillQueue())){
					nextrow.createCell(2).setCellValue(originalData_1.getSkillQueue());
				//}
				//if(originalData_1.getWorkGroup()!=null&&!"".equals(originalData_1.getWorkGroup())){
					nextrow.createCell(3).setCellValue(originalData_1.getWorkGroup());
				//}
				//System.out.println(originalData_1.getWorkGroup());
				//if(originalData_1.getZuoxiNumber()!=null&&!"".equals(originalData_1.getZuoxiNumber())){
					nextrow.createCell(4).setCellValue(originalData_1.getZuoxiNumber());
				//}
				//if(originalData_1.getSerName()!=null&&!"".equals(originalData_1.getSerName())){
					nextrow.createCell(5).setCellValue(originalData_1.getSerName());
				//}
				//if(originalData_1.getSerNickname()!=null&&!"".equals(originalData_1.getSerNickname())){
					nextrow.createCell(6).setCellValue(originalData_1.getSerNickname());
				//}
				//if(originalData_1.getVisitWay()!=null&&!"".equals(originalData_1.getVisitWay())){
					nextrow.createCell(7).setCellValue(originalData_1.getVisitWay());
				//}
				//if(originalData_1.getVisitIp()!=null&&!"".equals(originalData_1.getVisitIp())){
					nextrow.createCell(8).setCellValue(originalData_1.getVisitIp());
				//}
				//if(originalData_1.getIpProvice()!=null&&!"".equals(originalData_1.getIpProvice())){
					nextrow.createCell(9).setCellValue(originalData_1.getIpProvice());
				//}
				//if(originalData_1.getBusinessType()!=null&&!"".equals(originalData_1.getBusinessType())){
					nextrow.createCell(10).setCellValue(originalData_1.getBusinessType());
				//}
				//if(originalData_1.getClientRank()!=null&&!"".equals(originalData_1.getClientRank())){
					nextrow.createCell(11).setCellValue(originalData_1.getClientRank());
				//}
				//if(originalData_1.getClientBrand()!=null&&!"".equals(originalData_1.getClientBrand())){
					nextrow.createCell(12).setCellValue(originalData_1.getClientBrand());
				//}
				//if(originalData_1.getClientProvice()!=null&&!"".equals(originalData_1.getClientProvice())){
					nextrow.createCell(13).setCellValue(originalData_1.getClientProvice());
				//}
				//if(originalData_1.getClientCity()!=null&&!"".equals(originalData_1.getClientCity())){
					nextrow.createCell(14).setCellValue(originalData_1.getClientCity());
				//}
				//if(originalData_1.getConversationStartTime()!=null&&!"".equals(originalData_1.getConversationStartTime())){
					nextrow.createCell(15).setCellValue(originalData_1.getConversationStartTime());
				//}
				//if(originalData_1.getConversationEndTime()!=null&&!"".equals(originalData_1.getConversationEndTime())){
					nextrow.createCell(16).setCellValue(originalData_1.getConversationEndTime());
				//}
				//if(originalData_1.getConversationAssess()!=null&&!"".equals(originalData_1.getConversationAssess())){
					nextrow.createCell(17).setCellValue(originalData_1.getConversationAssess());
				//}
				//if(originalData_1.getConversationTime()!=null&&!"".equals(originalData_1.getConversationTime())){
					nextrow.createCell(18).setCellValue(originalData_1.getConversationTime());
				//}
				//if(originalData_1.getReplyIntervalTime()!=null&&!"".equals(originalData_1.getReplyIntervalTime())){
					nextrow.createCell(19).setCellValue(originalData_1.getReplyIntervalTime());
				//}
				//if(originalData_1.getSatisfactionType()!=null&&!"".equals(originalData_1.getSatisfactionType())){
					nextrow.createCell(20).setCellValue(originalData_1.getSatisfactionType());
				//}
				//if(originalData_1.getSolveType()!=null&&!"".equals(originalData_1.getSolveType())){
					nextrow.createCell(21).setCellValue(originalData_1.getSolveType());
				//}
				//if(originalData_1.getEndPerson()!=null&&!"".equals(originalData_1.getEndPerson())){
					nextrow.createCell(22).setCellValue(originalData_1.getEndPerson());
				//}
				//if(originalData_1.getEndReason()!=null&&!"".equals(originalData_1.getEndReason())){
					nextrow.createCell(23).setCellValue(originalData_1.getEndReason());
				//}
				//if(originalData_1.getClientSpeakFrequency()!=null&&!"".equals(originalData_1.getClientSpeakFrequency())){
					nextrow.createCell(24).setCellValue(originalData_1.getClientSpeakFrequency());
				//}
				//if(originalData_1.getSerSpeakFrequency()!=null&&!"".equals(originalData_1.getSerSpeakFrequency())){
					nextrow.createCell(25).setCellValue(originalData_1.getSerSpeakFrequency());
				//}
				//if(originalData_1.getInteractionFrequency()!=null&&!"".equals(originalData_1.getInteractionFrequency())){
					nextrow.createCell(26).setCellValue(originalData_1.getInteractionFrequency());
				//}
				//if(originalData_1.getIsvalidConversation()!=null&&!"".equals(originalData_1.getIsvalidConversation())){
					nextrow.createCell(27).setCellValue(originalData_1.getIsvalidConversation());
				//}
				//if(originalData_1.getComment()!=null&&!"".equals(originalData_1.getComment())){
					nextrow.createCell(28).setCellValue(originalData_1.getComment());
				//}
				//if(originalData_1.getConversationContent()!=null&&!"".equals(originalData_1.getConversationContent())){
					nextrow.createCell(29).setCellValue(originalData_1.getConversationContent());
				//}
				//if(originalData_1.getRobotConversationContent()!=null&&!"".equals(originalData_1.getRobotConversationContent())){
					nextrow.createCell(30).setCellValue(originalData_1.getRobotConversationContent());
				//}
					nextrow.createCell(31).setCellValue(originalData_1.getService());
					nextrow.createCell(32).setCellValue(originalData_1.getClient());
			
			}
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm");//设置日期格式
		//生成文件
		File file = new File("F:/原数据"+df.format(new Date())+".xls");
		try{
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			hssfWorkbook.write(stream);
			stream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public Sort getSort() {
		return sort;
	}


	public void setSort(Sort sort) {
		this.sort = sort;
	}
	
	
}
