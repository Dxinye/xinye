package com.elite.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.elite.service.IndexDataService;
import com.elite.service.IndextableService;
import com.elite.service.KeyWordService;
import com.elite.vo.OriginalData;

public class OutPutExcelFiltrate {
	//注入业务层对象
	private IndextableService indextableService;
	//注入keyWordService
	private KeyWordService keyWordService;
	//注入IndexData
	//private IndexDataService indexDataService;
	
	

	/*public IndexDataService getIndexDataService() {
		return indexDataService;
	}

	public void setIndexDataService(IndexDataService indexDataService) {
		this.indexDataService = indexDataService;
	}*/

	public IndextableService getIndextableService() {
		return indextableService;
	}

	public void setIndextableService(IndextableService indextableService) {
		this.indextableService = indextableService;
	}

	public KeyWordService getKeyWordService() {
		return keyWordService;
	}

	public void setKeyWordService(KeyWordService keyWordService) {
		this.keyWordService = keyWordService;
	}



	public void outExelFiltrate(List<OriginalData> list){
		
		//创建一个工作簿
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
		//创建一个工作表对象
		HSSFSheet sheet = hssfWorkbook.createSheet("分类后数据");
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
		cell.setCellValue("客服回答内容");
		cell.setCellStyle(hssfCellStyle);
		
		cell = row.createCell(32);
		cell.setCellValue("客户咨询问题");
		cell.setCellStyle(hssfCellStyle);
		
		cell = row.createCell(33);
		cell.setCellValue("数据所属类别");
		cell.setCellStyle(hssfCellStyle);
		
		
		
		OriginalData filtrate = new OriginalData();
		//读取数据库数据并赋值给赋值给对应字段
		System.out.println(list.size());
		System.out.println(list.get(1).getAcceptNumber());
		for(int rowNum=0;rowNum<list.size();rowNum++){
			HSSFRow nextrow = sheet.createRow(rowNum+1);
			
			filtrate = list.get(rowNum);
			if(filtrate!=null){
				
				//if(filtrate.getSerRdNumber()!=null&&!"".equals(filtrate.getSerRdNumber())){
					nextrow.createCell(0).setCellValue(filtrate.getSerRdNumber());
				//}
				System.out.println(filtrate.getSerRdNumber());
				//if(filtrate.getAcceptNumber()!=null&&!"".equals(filtrate.getAcceptNumber())){
					nextrow.createCell(1).setCellValue(filtrate.getAcceptNumber());
				//}
				//if(filtrate.getSkillQueue()!=null&&!"".equals(filtrate.getSkillQueue())){
					nextrow.createCell(2).setCellValue(filtrate.getSkillQueue());
				//}
				//if(filtrate.getWorkGroup()!=null&&!"".equals(filtrate.getWorkGroup())){
					nextrow.createCell(3).setCellValue(filtrate.getWorkGroup());
				//}
				//System.out.println(filtrate.getWorkGroup());
				//if(filtrate.getZuoxiNumber()!=null&&!"".equals(filtrate.getZuoxiNumber())){
					nextrow.createCell(4).setCellValue(filtrate.getZuoxiNumber());
				//}
				//if(filtrate.getSerName()!=null&&!"".equals(filtrate.getSerName())){
					nextrow.createCell(5).setCellValue(filtrate.getSerName());
				//}
				//if(filtrate.getSerNickname()!=null&&!"".equals(filtrate.getSerNickname())){
					nextrow.createCell(6).setCellValue(filtrate.getSerNickname());
				//}
				//if(filtrate.getVisitWay()!=null&&!"".equals(filtrate.getVisitWay())){
					nextrow.createCell(7).setCellValue(filtrate.getVisitWay());
				//}
				//if(filtrate.getVisitIp()!=null&&!"".equals(filtrate.getVisitIp())){
					nextrow.createCell(8).setCellValue(filtrate.getVisitIp());
				//}
				//if(filtrate.getIpProvice()!=null&&!"".equals(filtrate.getIpProvice())){
					nextrow.createCell(9).setCellValue(filtrate.getIpProvice());
				//}
				//if(filtrate.getBusinessType()!=null&&!"".equals(filtrate.getBusinessType())){
					nextrow.createCell(10).setCellValue(filtrate.getBusinessType());
				//}
				//if(filtrate.getClientRank()!=null&&!"".equals(filtrate.getClientRank())){
					nextrow.createCell(11).setCellValue(filtrate.getClientRank());
				//}
				//if(filtrate.getClientBrand()!=null&&!"".equals(filtrate.getClientBrand())){
					nextrow.createCell(12).setCellValue(filtrate.getClientBrand());
				//}
				//if(filtrate.getClientProvice()!=null&&!"".equals(filtrate.getClientProvice())){
					nextrow.createCell(13).setCellValue(filtrate.getClientProvice());
				//}
				//if(filtrate.getClientCity()!=null&&!"".equals(filtrate.getClientCity())){
					nextrow.createCell(14).setCellValue(filtrate.getClientCity());
				//}
				//if(filtrate.getConversationStartTime()!=null&&!"".equals(filtrate.getConversationStartTime())){
					nextrow.createCell(15).setCellValue(filtrate.getConversationStartTime());
				//}
				//if(filtrate.getConversationEndTime()!=null&&!"".equals(filtrate.getConversationEndTime())){
					nextrow.createCell(16).setCellValue(filtrate.getConversationEndTime());
				//}
				//if(filtrate.getConversationAssess()!=null&&!"".equals(filtrate.getConversationAssess())){
					nextrow.createCell(17).setCellValue(filtrate.getConversationAssess());
				//}
				//if(filtrate.getConversationTime()!=null&&!"".equals(filtrate.getConversationTime())){
					nextrow.createCell(18).setCellValue(filtrate.getConversationTime());
				//}
				//if(filtrate.getReplyIntervalTime()!=null&&!"".equals(filtrate.getReplyIntervalTime())){
					nextrow.createCell(19).setCellValue(filtrate.getReplyIntervalTime());
				//}
				//if(filtrate.getSatisfactionType()!=null&&!"".equals(filtrate.getSatisfactionType())){
					nextrow.createCell(20).setCellValue(filtrate.getSatisfactionType());
				//}
				//if(filtrate.getSolveType()!=null&&!"".equals(filtrate.getSolveType())){
					nextrow.createCell(21).setCellValue(filtrate.getSolveType());
				//}
				//if(filtrate.getEndPerson()!=null&&!"".equals(filtrate.getEndPerson())){
					nextrow.createCell(22).setCellValue(filtrate.getEndPerson());
				//}
				//if(filtrate.getEndReason()!=null&&!"".equals(filtrate.getEndReason())){
					nextrow.createCell(23).setCellValue(filtrate.getEndReason());
				//}
				//if(filtrate.getClientSpeakFrequency()!=null&&!"".equals(filtrate.getClientSpeakFrequency())){
					nextrow.createCell(24).setCellValue(filtrate.getClientSpeakFrequency());
				//}
				//if(filtrate.getSerSpeakFrequency()!=null&&!"".equals(filtrate.getSerSpeakFrequency())){
					nextrow.createCell(25).setCellValue(filtrate.getSerSpeakFrequency());
				//}
				//if(filtrate.getInteractionFrequency()!=null&&!"".equals(filtrate.getInteractionFrequency())){
					nextrow.createCell(26).setCellValue(filtrate.getInteractionFrequency());
				//}
				//if(filtrate.getIsvalidConversation()!=null&&!"".equals(filtrate.getIsvalidConversation())){
					nextrow.createCell(27).setCellValue(filtrate.getIsvalidConversation());
				//}
				//if(filtrate.getComment()!=null&&!"".equals(filtrate.getComment())){
					nextrow.createCell(28).setCellValue(filtrate.getComment());
				//}
				//if(filtrate.getConversationContent()!=null&&!"".equals(filtrate.getConversationContent())){
					nextrow.createCell(29).setCellValue(filtrate.getConversationContent());
				//}
				//if(filtrate.getRobotConversationContent()!=null&&!"".equals(filtrate.getRobotConversationContent())){
					nextrow.createCell(30).setCellValue(filtrate.getRobotConversationContent());
					
					nextrow.createCell(31).setCellValue(filtrate.getService());
					nextrow.createCell(32).setCellValue(filtrate.getClient());
					nextrow.createCell(33).setCellValue(filtrate.getDatatype());
				//}
					
					
					
					
			}
		}
		//生成文件
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm");//设置日期格式
		File file = new File("F:/分类"+df.format(new Date())+".xls");
		try{
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			hssfWorkbook.write(stream);
			stream.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
}
