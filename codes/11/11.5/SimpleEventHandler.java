
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
// GUI介面類別繼承WindowAdapter作為事件監聽器類別
public class SimpleEventHandler extends WindowAdapter
{
	private Frame f = new Frame("測試");
	private TextArea ta = new TextArea(6 , 40);
	public void init()
	{
		// 將該類別的預設物件作為事件監聽器物件
		f.addWindowListener(this);
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	// GUI介面類別直接包含事件處理器方法
	public void windowClosing(WindowEvent e)
	{
		System.out.println("使用者關閉視窗！\n");
		System.exit(0);
	}
	public static void main(String[] args)
	{
		new SimpleEventHandler().init();
	}
}
