
import java.awt.*;
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
public class NullLayoutTest
{
	Frame f = new Frame("測試視窗");
	Button b1 = new Button("第一個按鈕");
	Button b2 = new Button("第二個按鈕");
	public void init()
	{
		// 設置使用null佈局管理器
		f.setLayout(null);
		// 下面強制設置每個按鈕的大小、位置
		b1.setBounds(20, 30, 90, 28);
		f.add(b1);
		b2.setBounds(50, 45, 120, 35);
		f.add(b2);
		f.setBounds(50, 50, 200, 100);
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new NullLayoutTest().init();
	}
}

