
import java.awt.BorderLayout;
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
public class DefaultListModelTest
{
	private JFrame mainWin = new JFrame("測試DefaultListModel");
	// 定義一個JList物件
	private JList<String> bookList;
	// 定義一個DefaultListModel物件
	private DefaultListModel<String> bookModel
		= new DefaultListModel<>();
	private JTextField bookName = new JTextField(20);
	private JButton removeBn = new JButton("刪除選取圖書") ;
	private JButton addBn = new JButton("添加指定圖書");
	public void init()
	{
		// 向bookModel中添加元素
		bookModel.addElement("瘋狂Java講義");
		bookModel.addElement("輕量級Java EE企業應用實戰");
		bookModel.addElement("瘋狂Android講義");
		bookModel.addElement("瘋狂Ajax講義");
		bookModel.addElement("經典Java EE企業應用實戰");
		// 根據DefaultListModel物件建立一個JList物件
		bookList = new JList<>(bookModel);
		// 設置最大可視高度
		bookList.setVisibleRowCount(4);
		// 只能單選
		bookList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// 為添加按鈕添加事件監聽器
		addBn.addActionListener(evt -> {
			// 當bookName文字方塊的內容不為空。
			if (!bookName.getText().trim().equals(""))
			{
				// 向bookModel中添加一個元素，
				// 系統自動會向JList中添加對應的列表項目
				bookModel.addElement(bookName.getText());
			}
		});
		// 為刪除按鈕添加事件監聽器
		removeBn.addActionListener(evt -> {
			// 如果使用者已經選取的一項
			if (bookList.getSelectedIndex() >= 0)
			{
				// 從bookModel中刪除指定索引處的元素，
				// 系統自動會刪除JList對應的列表項目
				bookModel.removeElementAt(bookList.getSelectedIndex());
			}
		});
		JPanel p = new JPanel();
		p.add(bookName);
		p.add(addBn);
		p.add(removeBn);
		// 添加bookList元件
		mainWin.add(new JScrollPane(bookList));
		// 將p面板添加到視窗中
		mainWin.add(p , BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public static void main(String[] args)
	{
		new DefaultListModelTest().init();
	}
}
