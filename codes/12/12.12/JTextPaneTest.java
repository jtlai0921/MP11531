
import java.awt.*;

import javax.swing.*;
import javax.swing.text.*;
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
public class JTextPaneTest
{
	JFrame mainWin = new JFrame("測試JTextPane");
	JTextPane txt = new JTextPane();
	StyledDocument doc = txt.getStyledDocument();
	// 定義三個SimpleAttributeSet物件
	SimpleAttributeSet android = new SimpleAttributeSet();
	SimpleAttributeSet java = new SimpleAttributeSet();
	SimpleAttributeSet javaee = new SimpleAttributeSet();
	public void init()
	{
		// 為android屬性集設置顏色、字型大小、字型和底線
		StyleConstants.setForeground(android, Color.RED);
		StyleConstants.setFontSize(android, 24);
		StyleConstants.setFontFamily(android, "Dialog");
		StyleConstants.setUnderline(android, true);
		// 為java屬性集設置顏色、字型大小、字型和粗體字
		StyleConstants.setForeground(java, Color.BLUE);
		StyleConstants.setFontSize(java, 30);
		StyleConstants.setFontFamily(java, "Arial Black");
		StyleConstants.setBold(java, true);
		// 為javaee屬性集設置顏色、字型大小、斜體字
		StyleConstants.setForeground(javaee, Color.GREEN);
		StyleConstants.setFontSize(javaee, 32);
		StyleConstants.setItalic(javaee, true);
		// 設置不允許編輯
		txt.setEditable(false);
		txt.setText("瘋狂Android講義\n"
			+ "瘋狂Java講義\n" + "輕量級Java EE企業應用實戰\n");
		// 分別為文件中三段文字設置不同的外觀樣式
		doc.setCharacterAttributes(0 , 12 , android, true);
		doc.setCharacterAttributes(12 , 12 , java, true);
		doc.setCharacterAttributes(24 , 30 , javaee, true);
		mainWin.add(new JScrollPane(txt), BorderLayout.CENTER);
		// 獲取螢幕尺寸
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int inset = 100;
		// 設置主視窗的大小
		mainWin.setBounds(inset, inset, screenSize.width - inset * 2
			, screenSize.height - inset * 2);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
	}
	public static void main(String[] args)
	{
		new JTextPaneTest().init();
	}
}

