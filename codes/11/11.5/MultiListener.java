
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
public class MultiListener
{
	private Frame f = new Frame("測試");
	private TextArea ta = new TextArea(6 , 40);
	private Button b1 = new Button("按鈕一");
	private Button b2 = new Button("按鈕二");
	public void init()
	{
		// 建立FirstListener監聽器的實例
		FirstListener fl = new FirstListener();
		// 給b1按鈕註冊兩個事件監聽器
		b1.addActionListener(fl);
		b1.addActionListener(new SecondListener());
		// 將f1事件監聽器註冊給b2按鈕
		b2.addActionListener(fl);
		f.add(ta);
		Panel p = new Panel();
		p.add(b1);
		p.add(b2);
		f.add(p, BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	class FirstListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			ta.append("第一個事件監聽器被觸發,事件源是："
				+ e.getActionCommand() + "\n");
		}
	}
	class SecondListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			ta.append("單擊了「"
				+ e.getActionCommand() + "」按鈕\n");
		}
	}
	public static void main(String[] args)
	{
		new MultiListener().init();
	}
}
