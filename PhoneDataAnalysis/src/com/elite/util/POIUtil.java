package com.elite.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.ArrayList;  
import java.util.List;  
  
import org.apache.log4j.Logger;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;  
import org.apache.poi.ss.usermodel.Workbook;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.elite.excel.ReadFilePath;  


public class POIUtil {
	
	private String path;// 文件路径

    private static Logger logger  = Logger.getLogger(POIUtil.class);  
    private final static String xls = "xls";  
    private final static String xlsx = "xlsx";  
      
    
    
    public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	/** 
     * 读入excel文件，解析后返回 
     * @param file 
     * @throws IOException  
     */  
    public List<String[]> readExcel(String file) throws IOException{  
        //检查文件  
        checkFile(file);  
        //获得Workbook工作薄对象  
        Workbook workbook = getWorkBook(file);
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回  
        List<String[]> list = new ArrayList<String[]>();  
        if(workbook != null){  
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){  
                //获得当前sheet工作表  
                Sheet sheet = workbook.getSheetAt(sheetNum);  
                if(sheet == null){  
                    continue;  
                }  
                //获得当前sheet的开始行  
                int firstRowNum  = sheet.getFirstRowNum();  
                //获得当前sheet的结束行  
                int lastRowNum = sheet.getLastRowNum();  
                //循环除了第一行的所有行  
                for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){  
                    //获得当前行  
                    Row row = sheet.getRow(rowNum);  
                    if(row == null){  
                        continue;  
                    }  
                    //获得当前行的开始列  
                    int firstCellNum = row.getFirstCellNum();  
                    //获得当前行的列数  
                    int lastCellNum = row.getPhysicalNumberOfCells();  
                    String[] cells = new String[row.getPhysicalNumberOfCells()];  
                    //循环当前行  
                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){  
                        Cell cell = row.getCell(cellNum);  
                        cells[cellNum] = getCellValue(cell);  
                    }  
                    list.add(cells);  
                }  
            }  
            //workbook.close();  
        }  
        return list;  
    }  
    //检查文件是否存在
    public void checkFile(String file) throws IOException{  
    	
    	// 获取文件的保存路径
    	//String p = ServletActionContext.getServletContext().getRealPath(path);
    	
        //判断文件是否存在  
        if(null == file){  
            logger.error("文件不存在！");  
            throw new FileNotFoundException("文件不存在！");  
        }  
        //获得文件名  
        //String fileName = file.getOriginalFilename();
        String str[] = ReadFilePath.getFileName(file);
        for(String name : str){
        	//判断文件是否是excel文件  
            if(!name.endsWith(xls) && !name.endsWith(xlsx)){  
                logger.error(name + "不是excel文件");  
                throw new IOException(name + "不是excel文件");  
            } 
        }
         
    }  
    @SuppressWarnings("resource")
	public Workbook getWorkBook(String file) { 
    	//获得文件名  
        //String fileName = file.getOriginalFilename();
    	String fileName[] = ReadFilePath.getFileName(file);
    	//创建Workbook工作薄对象，表示整个excel  
        Workbook workbook = null;
        try {  
            //获取excel文件的io流  
            //InputStream is = file.getInputStream();
        	String filePath = "";
    		// 循环遍历数组，获取文件夹下的文件名，并将文件名拼接到p路径上
    		for (String name : fileName) {
    			
    			System.out.println(name);
    			filePath = file + "\\" + name;
    			filePath = filePath.replace("\\", "/");
    			
    			//创建输入流对象
        		InputStream is = new FileInputStream(filePath);
        		
                //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象  
                if(name.endsWith(xls)){  
                    //2003  
                    workbook = new HSSFWorkbook(is);  
                   // return workbook;
                }else if(name.endsWith(xlsx)){  
                    //2007  
                    workbook = new XSSFWorkbook(is); 
                    //return workbook;
                } 
    		}
    		//return workbook;
        } catch (Exception e) {  
            logger.info(e.getMessage());  
            e.printStackTrace();
        }  
        return workbook;  
    }  
    public static String getCellValue(Cell cell){  
        String cellValue = "";  
        if(cell == null){  
            return cellValue;  
        }  
        //把数字当成String来读，避免出现1读成1.0的情况  
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){  
            cell.setCellType(Cell.CELL_TYPE_STRING);  
        }  
        //判断数据的类型  
        switch (cell.getCellType()){  
            case Cell.CELL_TYPE_NUMERIC: //数字  
                cellValue = String.valueOf(cell.getNumericCellValue());  
                break;  
            case Cell.CELL_TYPE_STRING: //字符串  
                cellValue = String.valueOf(cell.getStringCellValue());  
                break;  
            case Cell.CELL_TYPE_BOOLEAN: //Boolean  
                cellValue = String.valueOf(cell.getBooleanCellValue());  
                break;  
            case Cell.CELL_TYPE_FORMULA: //公式  
                cellValue = String.valueOf(cell.getCellFormula());  
                break;  
            case Cell.CELL_TYPE_BLANK: //空值   
                cellValue = "";  
                break;  
            case Cell.CELL_TYPE_ERROR: //故障  
                cellValue = "非法字符";  
                break;  
            default:  
                cellValue = "未知类型";  
                break;  
        }  
        return cellValue;  
    } 
	
}
