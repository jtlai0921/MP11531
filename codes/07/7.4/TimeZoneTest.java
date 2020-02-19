
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
public class TimeZoneTest
{
	public static void main(String[] args)
	{
		// 取得Java所支援的所有時區ID
		String[] ids = TimeZone.getAvailableIDs();
		System.out.println(Arrays.toString(ids));
		TimeZone my = TimeZone.getDefault();
		// 獲取系統預設時區的ID:Asia/Shanghai
		System.out.println(my.getID());
		// 獲取系統預設時區的名稱：中國標準時間
		System.out.println(my.getDisplayName());
		// 獲取指定ID的時區的名稱：紐芬蘭標準時間
		System.out.println(TimeZone
			.getTimeZone("CNT").getDisplayName());
	}
}
