
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
public class WindowListenerTest
{
	private Frame f = new Frame("測試");
	private TextArea ta = new TextArea(6 , 40);
	public void init()
	{
		// 為視窗添加視窗事件監聽器
		f.addWindowListener(new MyListener());
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	// 實作一個視窗監聽器類別
	class MyListener implements WindowListener
	{
		public void windowActivated(WindowEvent e)
		{
			ta.append("視窗被啟動！\n");
		}
		public void windowClosed(WindowEvent e)
		{
			ta.append("視窗被成功關閉！\n");
		}
		public void windowClosing(WindowEvent e)
		{
			ta.append("使用者關閉視窗！\n");
			System.exit(0);
		}
		public void windowDeactivated(WindowEvent e)
		{
			ta.append("視窗失去焦點！\n");
		}
		public void windowDeiconified(WindowEvent e)
		{
			ta.append("視窗被恢復！\n");
		}
		public void windowIconified(WindowEvent e)
		{
			ta.append("視窗被最小化！\n");
		}
		public void windowOpened(WindowEvent e)
		{
			ta.append("視窗初次被開啟！\n");
		}
	}
	public static void main(String[] args)
	{
		new WindowListenerTest().init();
	}
}
