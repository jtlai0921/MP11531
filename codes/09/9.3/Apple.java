

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
public class Apple<T extends Number>
{
	T col;
	public static void main(String[] args)
	{
		Apple<Integer> ai = new Apple<>();
		Apple<Double> ad = new Apple<>();
		// 下面程式碼將引起編譯異常，下面程式碼試圖把String類型傳給T形式參數
		// 但String不是Number的子類型，所以引發編譯錯誤
		Apple<String> as = new Apple<>();		// ①
	}
}
