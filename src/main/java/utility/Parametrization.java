package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Parametrization {
	public void excel(String name,int row,int cell) throws EncryptedDocumentException, IOException  {
    	FileInputStream file=new FileInputStream("C:\\Users\\LA PC MASTER\\eclipse-workspace\\src\\test\\resources\\data.xlsx");
    	RichTextString value1=WorkbookFactory.create(file).getSheet(name).getRow(row).getCell(cell).getRichStringCellValue();
    }

}
