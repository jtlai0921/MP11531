
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
public class TransferHandlerTest
{
	private JFrame jf = new JFrame("測試TransferHandler");
	JColorChooser chooser = new JColorChooser();
	JTextArea txt = new JTextArea("測試TransferHandler\n"
		+ "直接將上面顏色拖入以改變文字顏色");
	public void init()
	{
		// 啟動顏色選擇器面板和文字區域的拖放功能
		chooser.setDragEnabled(true);
		txt.setDragEnabled(true);
		jf.add(chooser, BorderLayout.SOUTH);
		// 允許直接將一個Color物件拖入該JTextArea物件
		// 並賦給它的foreground屬性
		txt.setTransferHandler(new TransferHandler("foreground"));
		jf.add(new JScrollPane(txt));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new TransferHandlerTest().init();
	}
}
