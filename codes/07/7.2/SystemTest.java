
import java.io.*;
import java.util.*;
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
public class SystemTest
{
	public static void main(String[] args) throws Exception
	{
		// 獲取系統所有的環境變數
		Map<String,String> env = System.getenv();
		for (String name : env.keySet())
		{
			System.out.println(name + " ---> " + env.get(name));
		}
		// 獲取指定環境變數的值
		System.out.println(System.getenv("JAVA_HOME"));
		// 獲取所有的系統屬性
		Properties props = System.getProperties();
		// 將所有系統屬性存放到props.txt檔案中
		props.store(new FileOutputStream("props.txt")
			, "System Properties");
		// 輸出特定的系統屬性
		System.out.println(System.getProperty("os.name"));
	}
}
