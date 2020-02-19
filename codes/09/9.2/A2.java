

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
public class A2 extends Apple
{
	// 覆寫父類別的方法
	public String getInfo()
	{
		// super.getInfo()方法返回值是Object類型，
		// 所以加toString()才返回String類型
		return super.getInfo().toString();
	}
}

