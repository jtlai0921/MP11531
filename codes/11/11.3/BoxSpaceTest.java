
import java.awt.*;
import javax.swing.*;
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
public class BoxSpaceTest
{
	private Frame f = new Frame("測試");
	// 定義水平擺放元件的Box物件
	private Box horizontal = Box.createHorizontalBox();
	// 定義垂直擺放元件的Box物件
	private Box vertical = Box.createVerticalBox();
	public void init()
	{
		horizontal.add(new Button("水平按鈕一"));
		horizontal.add(Box.createHorizontalGlue());
		horizontal.add(new Button("水平按鈕二"));
		// 水平方向不可拉伸的間距，其寬度為10px
		horizontal.add(Box.createHorizontalStrut(10));
		horizontal.add(new Button("水平按鈕三"));
		vertical.add(new Button("垂直按鈕一"));
		vertical.add(Box.createVerticalGlue());
		vertical.add(new Button("垂直按鈕二"));
		// 垂直方向不可拉伸的間距，其高度為10px
		vertical.add(Box.createVerticalStrut(10));
		vertical.add(new Button("垂直按鈕三"));
		f.add(horizontal , BorderLayout.NORTH);
		f.add(vertical);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new BoxSpaceTest().init();
	}
}
