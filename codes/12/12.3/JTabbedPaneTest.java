
import java.util.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
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
public class JTabbedPaneTest
{
	JFrame jf = new JFrame("測試Tab頁面");
	// 建立一個Tab頁面的分頁放在左邊，採用換行佈局策略的JTabbedPane
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT
		, JTabbedPane.WRAP_TAB_LAYOUT);
	ImageIcon icon = new ImageIcon("ico/close.gif");
	String[] layouts = {"換行佈局" , "捲軸佈局"};
	String[] positions = {"左邊" , "頂部" , "右邊" , "底部"};
	Map<String , String> books = new LinkedHashMap<>();
	public void init()
	{
		books.put("瘋狂Java講義" , "java.png");
		books.put("輕量級Java EE企業應用實戰" , "ee.png");
		books.put("瘋狂Ajax講義" , "ajax.png");
		books.put("瘋狂Android講義" , "android.png");
		books.put("經典Java EE企業應用實戰" , "classic.png");
		String tip = "可看到本書的封面照片";
		// 向JTabbedPane中添加5個分頁，指定了標題、圖示和提示
		// 但該分頁的元件為null
		for (String bookName : books.keySet())
		{
			tabbedPane.addTab(bookName, icon, null , tip);
		}
		jf.add(tabbedPane, BorderLayout.CENTER);
		// 為JTabbedPane添加事件監聽器
		tabbedPane.addChangeListener(event -> {
			// 如果被選擇的元件依然是空
			if (tabbedPane.getSelectedComponent() == null)
			{
				// 獲取所選分頁
				int n = tabbedPane.getSelectedIndex();
				// 為指定分頁載入內容
				loadTab(n);
			}
		});
		// 系統預設選擇第一頁，載入第一頁內容
		loadTab(0);
		tabbedPane.setPreferredSize(new Dimension(500 , 300));
		// 增加控制分頁佈局、分頁位置的單選按鈕
		JPanel buttonPanel = new JPanel();
		ChangeAction action = new ChangeAction();
		buttonPanel.add(new ButtonPanel(action
			, "選擇分頁佈局策略" , layouts));
		buttonPanel.add (new ButtonPanel(action
			, "選擇分頁位置" , positions));
		jf.add(buttonPanel, BorderLayout.SOUTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	// 為指定分頁載入內容
	private void loadTab(int n)
	{
		String title = tabbedPane.getTitleAt(n);
		// 根據分頁的標題獲取對應圖書封面
		ImageIcon bookImage = new ImageIcon("ico/"
			+ books.get(title));
		tabbedPane.setComponentAt(n , new JLabel(bookImage));
		// 改變分頁的圖示
		tabbedPane.setIconAt(n, new ImageIcon("ico/open.gif"));
	}
	// 定義改變分頁的佈局策略，放置位置的監聽器
	class ChangeAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JRadioButton source = (JRadioButton)event.getSource();
			String selection = source.getActionCommand();
			// 設置分頁的標題的佈局策略
			if (selection.equals(layouts[0]))
			{
				tabbedPane.setTabLayoutPolicy(
					JTabbedPane.WRAP_TAB_LAYOUT);
			}
			else if (selection.equals(layouts[1]))
			{
				tabbedPane.setTabLayoutPolicy(
					JTabbedPane.SCROLL_TAB_LAYOUT);
			}
			// 設置分頁上的標題的放置位置
			else if (selection.equals(positions[0]))
			{
				tabbedPane.setTabPlacement(JTabbedPane.LEFT);
			}
			else if (selection.equals(positions[1]))
			{
				tabbedPane.setTabPlacement(JTabbedPane.TOP);
			}
			else if (selection.equals(positions[2]))
			{
				tabbedPane.setTabPlacement(JTabbedPane.RIGHT);
			}
			else if (selection.equals(positions[3]))
			{
				tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);
			}
		}
	}
	public static void main(String[] args)
	{
		new JTabbedPaneTest().init();
	}
}
// 定義一個JPanel類別擴展類別，該類別的物件包含多個縱向排列的JRadioButton控制項
// 且JPanel擴展類別可以指定一個字串作為TitledBorder
class ButtonPanel extends JPanel
{
	private ButtonGroup group;
	public ButtonPanel(JTabbedPaneTest.ChangeAction action
		, String title, String[] labels)
	{
		setBorder(BorderFactory.createTitledBorder(BorderFactory
			.createEtchedBorder(), title));
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		group = new ButtonGroup();
		for (int i = 0; labels!= null && i < labels.length; i++)
		{
			JRadioButton b = new JRadioButton(labels[i]);
			b.setActionCommand(labels[i]);
			add(b);
			// 添加事件監聽器
			b.addActionListener(action);
			group.add(b);
			b.setSelected(i == 0);
		}
	}
}
