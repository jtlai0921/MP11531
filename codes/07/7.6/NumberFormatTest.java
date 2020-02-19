
import java.util.*;
import java.text.*;
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
public class NumberFormatTest
{
	public static void main(String[] args)
	{
		// 需要被格式化的數字
		double db = 1234000.567;
		// 建立四個Locale，分別代表中國、日本、德國、美國
		Locale[] locales = {Locale.CHINA, Locale.JAPAN
			, Locale.GERMAN,  Locale.US};
		NumberFormat[] nf = new NumberFormat[12];
		// 為上面四個Locale建立12個NumberFormat物件
		// 每個Locale分別有通用數值格式器、百分比格式器、貨幣格式器
		for (int i = 0 ; i < locales.length ; i++)
		{
			nf[i * 3] = NumberFormat.getNumberInstance(locales[i]);
			nf[i * 3 + 1] = NumberFormat.getPercentInstance(locales[i]);
			nf[i * 3 + 2] = NumberFormat.getCurrencyInstance(locales[i]);
		}
		for (int i = 0 ; i < locales.length ; i++)
		{
			String tip = i == 0 ? "----中國的格式----" :
				i == 1 ? "----日本的格式----" :
				i == 2 ? "----德國的格式----" :"----美國的格式----";
			System.out.println(tip);
			System.out.println("通用數值格式："
				+ nf[i * 3].format(db));
			System.out.println("百分比數值格式："
				+ nf[i * 3 + 1].format(db));
			System.out.println("貨幣數值格式："
				+ nf[i * 3 + 2].format(db));
		}
	}
}

