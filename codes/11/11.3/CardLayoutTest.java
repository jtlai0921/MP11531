
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
public class CardLayoutTest
{
	Frame f = new Frame("測試視窗");
	String[] names = {"第一張" , "第二張" , "第三張"
		, "第四張" , "第五張"};
	Panel pl = new Panel();
	public void init()
	{
		final CardLayout c = new CardLayout();
		pl.setLayout(c);
		for (int i = 0 ; i < names.length ; i++)
		{
			pl.add(names[i] , new Button(names[i]));
		}
		Panel p = new Panel();
		ActionListener listener = e ->
		{
			switch(e.getActionCommand())
			{
				case "上一張":
					c.previous(pl);
					break;
				case "下一張":
					c.next(pl);
					break;
				case "第一張":
					c.first(pl);
					break;
				case "最後一張":
					c.last(pl);
					break;
				case "第三張":
					c.show(pl , "第三張");
					break;
			}
		};
		// 控制顯示上一張的按鈕
		Button previous = new Button("上一張");
		previous.addActionListener(listener);
		// 控制顯示下一張的按鈕
		Button next = new Button("下一張");
		next.addActionListener(listener);
		// 控制顯示第一張的按鈕
		Button first = new Button("第一張");
		first.addActionListener(listener);
		// 控制顯示最後一張的按鈕
		Button last = new Button("最後一張");
		last.addActionListener(listener);
		// 控制根據Card名顯示的按鈕
		Button third = new Button("第三張");
		third.addActionListener(listener);
		p.add(previous);
		p.add(next);
		p.add(first);
		p.add(last);
		p.add(third);
		f.add(pl);
		f.add(p , BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new CardLayoutTest().init();
	}
}
