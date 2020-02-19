
import java.util.*;
import java.io.*;
/**
 * Description:
 * <br/>網站: <a href="http://www.crazyit.org">瘋狂Java聯盟</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ScannerFileTest
{
	public static void main(String[] args)
		throws Exception
	{
		// 將一個File物件作為Scanner的建構子參數，Scanner讀取檔案內容
		Scanner sc = new Scanner(new File("ScannerFileTest.java"));
		System.out.println("ScannerFileTest.java檔案內容如下：");
		// 判斷是否還有下一行
		while(sc.hasNextLine())
		{
			// 輸出檔案中的下一行
			System.out.println(sc.nextLine());
		}
	}
}

