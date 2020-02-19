
import java.awt.*;
import static java.awt.BorderLayout.*;
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
public class GridLayoutTest
{
	public static void main(String[] args)
	{
		Frame f = new Frame("計算器");
		Panel p1 = new Panel();
		p1.add(new TextField(30));
		f.add(p1 , NORTH);
		Panel p2 = new Panel();
		// 設置Panel使用GridLayout佈局管理器
		p2.setLayout(new GridLayout(3, 5 , 4, 4));
		String[] name = {"0" , "1" , "2" , "3"
			, "4" , "5" , "6" , "7" , "8" , "9"
			, "+" , "-" , "*" , "/" , "."};
		// 向Panel中依次添加15個按鈕
		for (int i = 0 ; i < name.length; i++ )
		{
			p2.add(new Button(name[i]));
		}
		// 預設將Panel物件添加Frame視窗的中間
		f.add(p2);
		// 設置視窗為最佳大小
		f.pack();
		// 將視窗顯示出來（Frame物件預設處於隱藏狀態）
		f.setVisible(true);
	}
}

