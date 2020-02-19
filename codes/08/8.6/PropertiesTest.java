
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
public class PropertiesTest
{
	public static void main(String[] args)
		throws Exception
	{
		Properties props = new Properties();
		// 向Properties中增加屬性
		props.setProperty("username" , "yeeku");
		props.setProperty("password" , "123456");
		// 將Properties中的key-value對存放到a.ini檔案中
		props.store(new FileOutputStream("a.ini")
			, "comment line");   //①
		// 新增一個Properties物件
		Properties props2 = new Properties();
		// 向Properties中增加屬性
		props2.setProperty("gender" , "male");
		// 將a.ini檔案中的key-value對附加到props2中
		props2.load(new FileInputStream("a.ini") );   //②
		System.out.println(props2);
	}
}
