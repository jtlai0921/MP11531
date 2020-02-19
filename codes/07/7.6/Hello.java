
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
public class Hello
{
	public static void main(String[] args)
	{
		// 取得系統預設的國家/語言環境
		Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
		// 根據指定國家/語言環境載入資源檔
		ResourceBundle bundle = ResourceBundle
			.getBundle("mess" , myLocale);
		// 列印從資源檔中取得的訊息
		System.out.println(bundle.getString("hello"));
	}
}
