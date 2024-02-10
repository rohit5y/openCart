package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProv {
	@DataProvider(name="dp")
	public String[][] getData() throws IOException{
		String path=".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtils xlutil=new ExcelUtils();
		int row=ExcelUtils.getRowCount(path, "sheet1");
		int col=ExcelUtils.getCellCount(path, "sheet1", 1);
		String loginData[][]=new String[row][col];
		
		for(int i=1;i<=row;i++) {
			for(int j=0;j<col;j++) {
				loginData[i-1][j]=ExcelUtils.getCellData(path, "sheet1", row, col);
			}
		}
		return loginData;
		
	}

}
