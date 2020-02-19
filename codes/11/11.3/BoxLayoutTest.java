
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
public class BoxLayoutTest
{
	private Frame f = new Frame("測試");
	public void init()
	{
		f.setLayout(new BoxLayout(f , BoxLayout.Y_AXIS));
		// 下面按鈕將會垂直排列
		f.add(new Button("第一個按鈕"));
		f.add(new Button("按鈕二"));
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new BoxLayoutTest().init();
	}
}
