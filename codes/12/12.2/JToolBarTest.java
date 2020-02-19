
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
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
public class JToolBarTest
{
	JFrame jf = new JFrame("測試工具列");
	JTextArea jta = new JTextArea(6, 35);
	JToolBar jtb = new JToolBar();
	JMenuBar jmb = new JMenuBar();
	JMenu edit = new JMenu("編輯");
	// 獲取系統剪貼簿
	Clipboard clipboard = Toolkit.getDefaultToolkit()
		.getSystemClipboard();
	// 建立"貼上"Action，該Action用於建立選單項目、工具按鈕和普通按鈕
	Action pasteAction = new AbstractAction("貼上"
		, new ImageIcon("ico/paste.png"))
	{
		public void actionPerformed(ActionEvent e)
		{
			// 如果剪貼簿中包含stringFlavor內容
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor))
			{
				try
				{
					// 取出剪貼簿中stringFlavor內容
					String content = (String)clipboard.getData
					(DataFlavor.stringFlavor);
					// 將選取內容替換成剪貼簿中的內容
					jta.replaceRange(content , jta.getSelectionStart()
						, jta.getSelectionEnd());
				}
				catch (Exception ee)
				{
					ee.printStackTrace();
				}
			}
		}
	};
	// 建立"複製"Action
	Action copyAction = new AbstractAction("複製"
		, new ImageIcon("ico/copy.png"))
	{
		public void actionPerformed(ActionEvent e)
		{
			StringSelection contents = new StringSelection(
				jta.getSelectedText());
			// 將StringSelection物件放入剪貼簿
			clipboard.setContents(contents, null);
			// 如果剪貼簿中包含stringFlavor內容
			if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor))
			{
				// 將pasteAction啟動
				pasteAction.setEnabled(true);
			}
		}
	};
	public void init()
	{
		// pasteAction預設處於不啟動狀態
		pasteAction.setEnabled(false);   // ①
		jf.add(new JScrollPane(jta));
		// 以Action建立按鈕，並將該按鈕添加到Panel中
		JButton copyBn = new JButton(copyAction);
		JButton pasteBn = new JButton(pasteAction);
		JPanel jp = new JPanel();
		jp.add(copyBn);
		jp.add(pasteBn);
		jf.add(jp , BorderLayout.SOUTH);
		// 向工具列中添加Action物件，該物件將會轉換成工具按鈕
		jtb.add(copyAction);
		jtb.addSeparator();
		jtb.add(pasteAction);
		// 向選單中添加Action物件，該物件將會轉換成選單項目
		edit.add(copyAction);
		edit.add(pasteAction);
		// 將edit選單添加到選單列中
		jmb.add(edit);
		jf.setJMenuBar(jmb);
		// 設置工具列和工具按鈕之間的頁邊距。
		jtb.setMargin(new Insets(20 ,10 , 5 , 30));    // ②
		// 向視窗中添加工具列
		jf.add(jtb , BorderLayout.NORTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new JToolBarTest().init();
	}
}
