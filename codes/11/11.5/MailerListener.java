
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
public class MailerListener implements ActionListener
{
	// 該TextField文字方塊用於輸入發送郵件的位址
	private TextField mailAddress;
	public MailerListener(){}
	public MailerListener(TextField mailAddress)
	{
		this.mailAddress = mailAddress;
	}
	public void setMailAddress(TextField mailAddress)
	{
		this.mailAddress = mailAddress;
	}
	// 實作發送郵件
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("程式向「"
			+ mailAddress.getText() + "」發送郵件...");
		// 發送郵件的真實實作
	}
}

