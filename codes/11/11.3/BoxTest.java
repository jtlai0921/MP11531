
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
public class BoxTest
{
	private Frame f = new Frame("測試");
	// 定義水平擺放元件的Box物件
	private Box horizontal = Box.createHorizontalBox();
	// 定義垂直擺放元件的Box物件
	private Box vertical = Box.createVerticalBox();
	public void init()
	{
		horizontal.add(new Button("水平按鈕一"));
		horizontal.add(new Button("水平按鈕二"));
		vertical.add(new Button("垂直按鈕一"));
		vertical.add(new Button("垂直按鈕二"));
		f.add(horizontal , BorderLayout.NORTH);
		f.add(vertical);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new BoxTest().init();
	}
}

