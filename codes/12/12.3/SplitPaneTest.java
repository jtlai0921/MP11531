
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
class Book
{
	private String name;
	private Icon ico;
	private String desc;

	public Book(){}

	public Book(String name , Icon ico , String desc)
	{
		this.name = name;
		this.ico = ico;
		this.desc = desc;
	}
	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}

	// ico的setter和getter方法
	public void setIco(Icon ico)
	{
		this.ico = ico;
	}
	public Icon getIco()
	{
		 return this.ico;
	}

	// desc的setter和getter方法
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		 return this.desc;
	}
	public String toString()
	{
		return name;
	}
}
public class SplitPaneTest
{
	Book[] books = new Book[]{
		new Book("瘋狂Java講義" , new ImageIcon("ico/java.png")
			, "國內關於Java程式設計最全面的圖書\n看得懂，學得會")
		, new Book("輕量級Java EE企業應用實戰" , new ImageIcon("ico/ee.png")
			, "SSH整合開發的經典圖書，值得擁有")
		, new Book("瘋狂Android講義" , new ImageIcon("ico/android.png")
			, "全面介紹Android平台應用程式\n開發的各方面知識")
	};
	JFrame jf = new JFrame("測試JSplitPane");
	JList<Book> bookList = new JList<>(books);
	JLabel bookCover = new JLabel();
	JTextArea bookDesc = new JTextArea();
	public void init()
	{
		// 為三個元件設置最佳大小
		bookList.setPreferredSize(new Dimension(150, 300));
		bookCover.setPreferredSize(new Dimension(300, 150));
		bookDesc.setPreferredSize(new Dimension(300, 150));
		// 為下拉列表添加事件監聽器
		bookList.addListSelectionListener(event ->{
			Book book = (Book)bookList.getSelectedValue();
			bookCover.setIcon(book.getIco());
			bookDesc.setText(book.getDesc());
		});
		// 建立一個垂直的分割窗格，
		// 將bookCover放在上面，將bookDesc放在下面, 支援連續佈局
		JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT
			, true , bookCover, new JScrollPane(bookDesc));
		// 啟用「一觸即展」的特性
		left.setOneTouchExpandable(true);
		// 下面程式碼設置分割軸的大小。
		// left.setDividerSize(50);
		// 設置該分割窗格根據所包含元件的最佳大小來調整佈局
		left.resetToPreferredSizes();
		// 建立一個水平的分割窗格
		// 將left元件放在左邊，將bookList元件放在右邊
		JSplitPane content = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT
			, left, bookList);
		jf.add(content);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SplitPaneTest().init();
	}
}
