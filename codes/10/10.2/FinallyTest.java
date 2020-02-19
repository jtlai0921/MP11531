
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
public class FinallyTest
{
	public static void main(String[] args)
	{
		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream("a.txt");
		}
		catch (IOException ioe)
		{
			System.out.println(ioe.getMessage());
			// return語句強制方法返回
			return ;       // ①
			// 使用exit來結束虛擬機器
			// System.exit(1);     // ②
		}
		finally
		{
			// 關閉磁碟檔案，回收資源
			if (fis != null)
			{
				try
				{
					fis.close();
				}
				catch (IOException ioe)
				{
					ioe.printStackTrace();
				}
			}
			System.out.println("執行finally區塊裡的資源回收!");
		}
	}
}
