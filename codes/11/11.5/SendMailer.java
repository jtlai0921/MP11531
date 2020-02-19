
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
public class SendMailer
{
	private Frame f = new Frame("測試");
	private TextField tf = new TextField(40);
	private Button send = new Button("發送");
	public void init()
	{
		// 使用MailerListener物件作為事件監聽器
		send.addActionListener(new MailerListener(tf));
		f.add(tf);
		f.add(send , BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SendMailer().init();
	}
}
