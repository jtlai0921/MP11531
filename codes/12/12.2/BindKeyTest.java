
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
public class BindKeyTest
{
	JFrame jf = new JFrame("測試鍵盤綁定");
	JTextArea jta = new JTextArea(5, 30);
	JButton jb = new JButton("發送");
	JTextField jtf = new JTextField(15);
	public void init()
	{
		jf.add(jta);
		JPanel jp = new JPanel();
		jp.add(jtf);
		jp.add(jb);
		jf.add(jp , BorderLayout.SOUTH);
		// 發送訊息的Action,Action是ActionListener的子介面
		Action sendMsg = new AbstractAction()
		{
			public void actionPerformed(ActionEvent e)
			{
				jta.append(jtf.getText() + "\n");
				jtf.setText("");
			}
		};
		// 添加事件監聽器
		jb.addActionListener(sendMsg);
		// 將Ctrl+Enter鍵和"send"關聯
		jtf.getInputMap().put(KeyStroke.getKeyStroke('\n'
			, java.awt.event.InputEvent.CTRL_MASK) , "send");
		// 將"send"和sendMsg Action關聯
		jtf.getActionMap().put("send", sendMsg);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new BindKeyTest().init();
	}
}
