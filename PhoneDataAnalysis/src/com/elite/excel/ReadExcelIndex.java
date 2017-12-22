package com.elite.excel;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.elite.vo.Indextable;

public class ReadExcelIndex {
	
	public List<Indextable> ReadIndex(String filePath) throws Exception{
		
		//创建输入流对象
		InputStream is = new FileInputStream(filePath);
		//创建工作簿对象	
		HSSFWorkbook workbook = new HSSFWorkbook(is); 
		//创建实体类对象
		Indextable index =null;
		//创建list集合
		List<Indextable> list = new ArrayList<Indextable>();
		
		//遍历工作簿有多少个工作表
		for(int numSheet = 0;numSheet < workbook.getNumberOfSheets();numSheet ++){
			//创建工作表对象
			HSSFSheet sheet = workbook.getSheetAt(numSheet);
			if(sheet == null){
				continue;
			}
			//遍历工作表总行数,小于最后一行的行数
			for(int rowNum = 1;rowNum < sheet.getLastRowNum(); rowNum ++){
				index = new Indextable();
				//获取工作表的行数
				HSSFRow hssfRow = sheet.getRow(rowNum);
				if(hssfRow != null){
					//读取每一行数据
					HSSFCell parentID = hssfRow.getCell(0);
					HSSFCell text = hssfRow.getCell(1);
					//将数据保存到实体类对象中
					double parent = Double.parseDouble(getValue(parentID));	//将数据转成double类型
					index.setParentID((int)(parent));	//将数据强制转成int型
					index.setText(getValue(text));
					list.add(index);
				}
			}
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
