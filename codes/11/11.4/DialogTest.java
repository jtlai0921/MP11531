
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
public class DialogTest
{
	Frame f = new Frame("測試");
	Dialog d1 = new Dialog(f, "強制回應對話方塊" , true);
	Dialog d2 = new Dialog(f, "非強制回應對話方塊" , false);
	Button b1 = new Button("開啟強制回應對話方塊");
	Button b2 = new Button("開啟非強制回應對話方塊");
	public void init()
	{
		d1.setBounds(20 , 30 , 300, 400);
		d2.setBounds(20 , 30 , 300, 400);
		b1.addActionListener(e -> d1.setVisible(true));
		b2.addActionListener(e -> d2.setVisible(true));
		f.add(b1);
		f.add(b2 , BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new DialogTest().init();
	}
}
