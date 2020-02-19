
import java.awt.*;
import java.awt.event.*;
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
public class AnonymousEventHandler
{
	private Frame f = new Frame("測試");
	private TextArea ta = new TextArea(6 , 40);
	public void init()
	{
		// 以匿名內部類別的形式來建立事件監聽器物件
		f.addWindowListener(new WindowAdapter()
		{
			// 實作事件處理方法
			public void windowClosing(WindowEvent e)
			{
				System.out.println("使用者試圖關閉視窗！\n");
				System.exit(0);
			}
		});
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new AnonymousEventHandler().init();
	}
}
