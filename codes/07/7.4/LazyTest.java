
import java.util.*;
import static java.util.Calendar.*;
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
public class LazyTest
{
	public static void main(String[] args)
	{
		Calendar cal = Calendar.getInstance();
		cal.set(2003 , 7 , 31);  //2003-8-31
		// 將月份設為9，但9月31日不存在。
		// 如果立即修改，系統將會把cal自動調整到10月1日。
		cal.set(MONTH , 8);
		// 下面程式碼輸出10月1日
		//System.out.println(cal.getTime());    //①
		// 設置DATE欄位為5
		cal.set(DATE , 5);    //②
		System.out.println(cal.getTime());    //③
	}
}
