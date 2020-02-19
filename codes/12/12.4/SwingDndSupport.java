
import java.awt.*;
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
public class SwingDndSupport
{
	JFrame jf = new JFrame("Swing的拖放支援");
	JTextArea srcTxt = new JTextArea(8 , 30);
	JTextField jtf = new JTextField(34);
	public void init()
	{
		srcTxt.append("Swing的拖放支援.\n");
		srcTxt.append("將該文字區域的內容拖入其他程式.\n");
		// 啟動文字區域和單行文字方塊的拖放支援
		srcTxt.setDragEnabled(true);
		jtf.setDragEnabled(true);
		jf.add(new JScrollPane(srcTxt));
		jf.add(jtf , BorderLayout.SOUTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SwingDndSupport().init();
	}
}

