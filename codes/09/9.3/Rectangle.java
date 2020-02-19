
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
// 定義Shape的子類別Rectangle
public class Rectangle extends Shape
{
	// 實作繪圖方法，以列印字串來模擬繪圖方法實作
	public void draw(Canvas c)
	{
		System.out.println("把一個矩形畫在畫布" + c + "上");
	}
}
