

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
public class R<T>
{
	// 下面程式碼錯誤，不能在靜態變數宣告中使用類型形式參數
//	static T info;
	T age;
	public void foo(T msg){}
	// 下面程式碼錯誤，不能在靜態方法宣告中使用類型形式參數
//	public static void bar(T msg){}

}

