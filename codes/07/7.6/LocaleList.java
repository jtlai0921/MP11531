
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
public class LocaleList
{
	public static void main(String[] args)
	{
		// 返回Java所支援的全部國家和語言的陣列
		Locale[] localeList = Locale.getAvailableLocales();
		// 遍歷陣列的每個元素，依次獲取所支援的國家和語言
		for (int i = 0; i < localeList.length ; i++ )
		{
			// 輸出出所支援的國家和語言
			System.out.println(localeList[i].getDisplayCountry()
				+ "=" + localeList[i].getCountry()+ " "
				+ localeList[i].getDisplayLanguage()
				+ "=" + localeList[i].getLanguage());
		}
	}
}

