
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
public class LenientTest
{
	public static void main(String[] args)
	{
		Calendar cal = Calendar.getInstance();
		// 結果是YEAR欄位加1，MONTH欄位為1（二月）
		cal.set(MONTH , 13);   //①
		System.out.println(cal.getTime());
		// 關閉容錯性
		cal.setLenient(false);
		// 導致運行時異常
		cal.set(MONTH , 13);   //②
		System.out.println(cal.getTime());
	}
}
