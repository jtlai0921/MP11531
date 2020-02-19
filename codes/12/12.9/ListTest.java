
import java.util.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
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
public class ListTest
{
	private JFrame mainWin = new JFrame("測試列表方塊");
	String[] books = new String[]
	{
		"瘋狂Java講義"
		, "輕量級Java EE企業應用實戰"
		, "瘋狂Android講義"
		, "瘋狂Ajax講義"
		, "經典Java EE企業應用實戰"
	};
	// 用一個字串陣列來建立一個JList物件
	JList<String> bookList = new JList<>(books);
	JComboBox<String> bookSelector;
	// 定義佈局選擇按鈕所在的面板
	JPanel layoutPanel = new JPanel();
	ButtonGroup layoutGroup = new ButtonGroup();
	// 定義選擇模式按鈕所在的面板
	JPanel selectModePanel = new JPanel();
	ButtonGroup selectModeGroup = new ButtonGroup();
	JTextArea favoriate = new JTextArea(4 , 40);
	public void init()
	{
		// 設置JList的可視高度可同時顯示三個列表項
		bookList.setVisibleRowCount(3);
		// 預設選取第三項到第五項（第一項的索引是0）
		bookList.setSelectionInterval(2, 4);
		addLayoutButton("縱向捲動", JList.VERTICAL);
		addLayoutButton("縱向換行", JList.VERTICAL_WRAP);
		addLayoutButton("橫向換行", JList.HORIZONTAL_WRAP);
		addSelectModelButton("無限制", ListSelectionModel
			.MULTIPLE_INTERVAL_SELECTION);
		addSelectModelButton("單選", ListSelectionModel
			.SINGLE_SELECTION);
		addSelectModelButton("單範圍", ListSelectionModel
			.SINGLE_INTERVAL_SELECTION);
		Box listBox = new Box(BoxLayout.Y_AXIS);
		// 將JList元件放在JScrollPane中，再將該JScrollPane添加到listBox容器中
		listBox.add(new JScrollPane(bookList));
		// 添加佈局選擇按鈕面板、選擇模式按鈕面板
		listBox.add(layoutPanel);
		listBox.add(selectModePanel);
		// 為JList添加事件監聽器
		bookList.addListSelectionListener(e -> {  // ①
			// 獲取使用者所選擇的所有圖書
			List<String> books = bookList.getSelectedValuesList();
			favoriate.setText("");
			for (String book : books )
			{
				favoriate.append(book + "\n");
			}
		});
		Vector<String> bookCollection = new Vector<>();
		bookCollection.add("瘋狂Java講義");
		bookCollection.add("輕量級Java EE企業應用實戰");
		bookCollection.add("瘋狂Android講義");
		bookCollection.add("瘋狂Ajax講義");
		bookCollection.add("經典Java EE企業應用實戰");
		// 用一個Vector物件來建立一個JComboBox物件
		bookSelector = new JComboBox<>(bookCollection);
		// 為JComboBox添加事件監聽器
		bookSelector.addItemListener(e -> {  // ②
			// 獲取JComboBox所選取的項目
			Object book = bookSelector.getSelectedItem();
			favoriate.setText(book.toString());
		});
		// 設置可以直接編輯
		bookSelector.setEditable(true);
		// 設置下拉列表方塊的可視高度可同時顯示4個列表項
		bookSelector.setMaximumRowCount(4);
		JPanel p = new JPanel();
		p.add(bookSelector);
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(listBox);
		box.add(p);
		mainWin.add(box);
		JPanel favoriatePanel = new JPanel();
		favoriatePanel.setLayout(new BorderLayout());
		favoriatePanel.add(new JScrollPane(favoriate));
		favoriatePanel.add(new JLabel("您喜歡的圖書：")
			, BorderLayout.NORTH);
		mainWin.add(favoriatePanel , BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	private void addLayoutButton(String label, final int orientation)
	{
		layoutPanel.setBorder(new TitledBorder(new EtchedBorder()
			, "確定選項佈局"));
		JRadioButton button = new JRadioButton(label);
		// 把該單選按鈕添加到layoutPanel面板中
		layoutPanel.add(button);
		// 預設選取第一個按鈕
		if (layoutGroup.getButtonCount() == 0)
		button.setSelected(true);
		layoutGroup.add(button);
		button.addActionListener(event ->
			// 改變列表方塊裡列表項的佈局方向
			bookList.setLayoutOrientation(orientation));
	}
	private void addSelectModelButton(String label, final int selectModel)
	{
		selectModePanel.setBorder(new TitledBorder(new EtchedBorder()
			, "確定選擇模式"));
		JRadioButton button = new JRadioButton(label);
		// 把該單選按鈕添加到selectModePanel面板中
		selectModePanel.add(button);
		// 預設選取第一個按鈕
		if(selectModeGroup.getButtonCount() == 0)
			button.setSelected(true);
		selectModeGroup.add(button);
		button.addActionListener(event ->
			// 改變列表方塊裡的選擇模式
			bookList.setSelectionMode(selectModel));
	}
	public static void main(String[] args)
	{
		new ListTest().init();
	}
}
