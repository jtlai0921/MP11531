

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
public class A1 extends Apple<String>
{
	// 正確覆寫了父類別的方法，返回值
	// 與父類別Apple<String>的返回值完全相同
	public String getInfo()
	{
		return "子類別" + super.getInfo();
	}
	/*
	// 下面方法是錯誤的，覆寫父類別方法時返回值類型不一致
	public Object getInfo()
	{
		return "子類別";
	}
	*/
}

