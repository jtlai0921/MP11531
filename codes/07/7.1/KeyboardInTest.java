
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
public class KeyboardInTest
{
	public static void main(String[] args)
		throws Exception
	{
		// 以System.in節點串流為基礎，建立一個BufferedReader物件
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		String line = null;
		// 逐行讀取鍵盤輸入
		while ((line = br.readLine()) != null)
		{
			System.out.println("使用者鍵盤輸入是:" + line);
		}
	}
}
