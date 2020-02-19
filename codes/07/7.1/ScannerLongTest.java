
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
public class ScannerLongTest
{
	public static void main(String[] args)
	{
		// System.in代表標準輸入，就是鍵盤輸入
		Scanner sc = new Scanner(System.in);
		// 判斷是否還有下一個long型整數
		while(sc.hasNextLong())
		{
			// 輸出輸入項
			System.out.println("鍵盤輸入的內容是："
				+ sc.nextLong());
		}
	}
}
