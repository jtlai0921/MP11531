
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
public class EventQs
{
	private Frame f = new Frame("測試事件");
	private Button ok = new Button("確定");
	private TextField tf = new TextField(30);
	public void init()
	{
		// 註冊事件監聽器
		ok.addActionListener(new OkListener());   //①
		f.add(tf);
		f.add(ok , BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	// 定義事件監聽器類別
	class OkListener implements ActionListener   //②
	{
		// 下面定義的方法就是事件處理器，用於回應特定的事件
		public void actionPerformed(ActionEvent e)      //③
		{
			System.out.println("使用者單擊了ok按鈕");
			tf.setText("Hello World");
		}
	}
	public static void main(String[] args)
	{
		new EventQs().init();
	}
}
