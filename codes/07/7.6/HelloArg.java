
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
public class HelloArg
{
	public static void main(String[] args)
	{
		// 定義一個Locale變數
		Locale currentLocale = null;
		// 如果運行程式的指定了兩個參數
		if (args.length == 2)
		{
			// 使用運行程式的兩個參數構造Locale實例
			currentLocale = new Locale(args[0] , args[1]);
		}
		else
		{
			// 否則直接使用系統預設的Locale
			currentLocale = Locale.getDefault(Locale.Category.FORMAT);
		}
		// 根據Locale載入語言資源
		ResourceBundle bundle = ResourceBundle
			.getBundle("myMess" , currentLocale);
		// 取得已載入的語言資源檔中msg對應訊息
		String msg = bundle.getString("msg");
		// 使用MessageFormat為帶佔位符的字串傳入參數
		System.out.println(MessageFormat.format(msg
			, "yeeku" , new Date()));
	}
}
