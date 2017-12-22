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
import com.elite.vo.KeyWord;
/**
 * 录入关键字的方法
 * @author rd
 *
 */
public class ReadExcelKW {
	
	public List<KeyWord> ReadKey(String filePath) throws Exception{
		
		//创建输入流对象
		InputStream is = new FileInputStream(filePath);
		//创建工作簿对象	
		HSSFWorkbook workbook = new HSSFWorkbook(is); 
		//创建实体类对象
		KeyWord key = null;
		//创建list集合
		List<KeyWord> list = new ArrayList<KeyWord>();
		
		//遍历工作簿有多少个工作表
		for(int numSheet = 0;numSheet < workbook.getNumberOfSheets();numSheet ++){
			//创建工作表对象
			HSSFSheet sheet = workbook.getSheetAt(numSheet);
			if(sheet == null){
				continue;
			}
			//遍历工作表总行数,小于最后一行的行数
			for(int rowNum = 1;rowNum < sheet.getLastRowNum(); rowNum ++){
				key = new KeyWord();
				//获取工作表的行数
				HSSFRow hssfRow = sheet.getRow(rowNum);
				if(hssfRow != null){
					
					//读取每一行数据
					HSSFCell keyword1 = hssfRow.getCell(0);
					HSSFCell keyword2 = hssfRow.getCell(1);
					HSSFCell keyword3 = hssfRow.getCell(2);
					HSSFCell keyword4 = hssfRow.getCell(3);
					HSSFCell keyword5 = hssfRow.getCell(4);
					HSSFCell keyword6 = hssfRow.getCell(5);
					HSSFCell keyword7 = hssfRow.getCell(6);
					HSSFCell id = hssfRow.getCell(7);
					//将数据保存到实体类对象中
					/*if(keyword1 != null){
						key.setKeyword1(getValue(keyword1));
					}
					if(keyword2 != null){
						key.setKeyword2(getValue(keyword2));
					}
					if(keyword3 != null){
						key.setKeyword3(getValue(keyword3));
					}
					if(keyword4 != null){
						key.setKeyword4(getValue(keyword4));
					}
					if(keyword5 != null){
						key.setKeyword5(getValue(keyword5));
					}
					if(keyword6 != null){
						key.setKeyword6(getValue(keyword6));
					}
					if(keyword7 != null){
						key.setKeyword7(getValue(keyword7));
					}
					double a = Double.parseDouble(getValue(id));	//将数据转成double类型
					key.setId((int)a);*/
					list.add(key);
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
