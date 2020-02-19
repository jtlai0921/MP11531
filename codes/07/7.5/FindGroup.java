
import java.util.regex.*;
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
public class FindGroup
{
	public static void main(String[] args)
	{
		// 使用字串模擬從網路上得到的網頁原始碼
		String str = "我想求購一本《瘋狂Java講義》，儘快聯繫我13500006666"
			+ "交朋友，電話號碼是13611125565"
			+ "出售二手電腦，聯繫方式15899903312";
		// 建立一個Pattern物件，並用它建立一個Matcher物件
		// 該正規運算式只抓取13X和15X段的手機號，
		// 實際要抓取哪些電話號碼，只要修改正規運算式即可。
		Matcher m = Pattern.compile("((13\\d)|(15\\d))\\d{8}")
			.matcher(str);
		// 將所有符合正規運算式的子串（電話號碼）全部輸出
		while(m.find())
		{
			System.out.println(m.group());
		}
	}
}

