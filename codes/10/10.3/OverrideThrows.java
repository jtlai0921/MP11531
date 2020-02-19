
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
public class OverrideThrows
{
	public void test()throws IOException
	{
		FileInputStream fis = new FileInputStream("a.txt");
	}
}
class Sub extends OverrideThrows
{
	// 子類別方法宣告拋出了比父類別方法更大的異常
	// 所以下面方法出錯
	public void test()throws Exception
	{
	}
}

