
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
public class Canvas
{
//	// 同時在畫布上繪製多個形狀
//	public void drawAll(List<Shape> shapes)
//	{
//		for (Shape s : shapes)
//		{
//			s.draw(this);
//		}
//	}
//	public void drawAll(List<?> shapes)
//	{
//		for (Object obj : shapes)
//		{
//			Shape s = (Shape)obj;
//			s.draw(this);
//		}
//	}
	// 同時在畫布上繪製多個形狀，使用被限制的泛型萬用字元
	public void drawAll(List<? extends Shape> shapes)
	{
		for (Shape s : shapes)
		{
			s.draw(this);
		}
	}

	public static void main(String[] args)
	{
		List<Circle> circleList = new ArrayList<Circle>();
		Canvas c = new Canvas();
		// 由於List<Circle>並不是List<Shape>的子類型,
		// 所以下面程式碼引發編譯錯誤
		c.drawAll(circleList);
	}
}
