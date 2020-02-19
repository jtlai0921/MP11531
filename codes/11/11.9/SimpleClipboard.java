
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.datatransfer.*;
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
public class SimpleClipboard
{
	private Frame f = new Frame("簡單的剪貼簿程式");
	// 獲取系統剪貼簿
	private Clipboard clipboard = Toolkit
		.getDefaultToolkit().getSystemClipboard();
	// 下面是建立本地剪貼簿的程式碼
	// Clipboard clipboard = new Clipboard("cb");   // ①
	// 用於複製文字的文字方塊
	private TextArea jtaCopyTo = new TextArea(5,20);
	// 用於貼上文字的文字方塊
	private TextArea jtaPaste = new TextArea(5,20);
	private Button btCopy = new Button("複製"); // 複製按鈕
	private Button btPaste = new Button("貼上"); // 貼上按鈕
	public void init()
	{
		Panel p = new Panel();
		p.add(btCopy);
		p.add(btPaste);
		btCopy.addActionListener(event ->
		{
			// 將一個多行文字區域裡的字串封裝成StringSelection物件
			StringSelection contents = new
				StringSelection(jtaCopyTo.getText());
			// 將StringSelection物件放入剪貼簿
			clipboard.setContents(contents, null);
		});
		btPaste.addActionListener(event ->
		{
			// 如果剪貼簿中包含stringFlavor內容
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor))
			{
				try
				{
					// 取出剪貼簿中stringFlavor內容
					String content = (String)clipboard
						.getData(DataFlavor.stringFlavor);
					jtaPaste.append(content);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		// 建立一個水平排列的Box容器
		Box box = new Box(BoxLayout.X_AXIS);
		// 將兩個多行文字區域放在Box容器中
		box.add(jtaCopyTo);
		box.add(jtaPaste);
		// 將按鈕所在Panel、Box容器添加到Frame視窗中
		f.add(p,BorderLayout.SOUTH);
		f.add(box,BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SimpleClipboard().init();
	}
}
