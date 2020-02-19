
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
public class SimpleTable
{
	JFrame jf = new JFrame("簡單表格");
	JTable table;
	// 定義二維陣列作為表格資料
	Object[][] tableData =
	{
		new Object[]{"李清照" , 29 , "女"},
		new Object[]{"蘇格拉底", 56 , "男"},
		new Object[]{"李白", 35 , "男"},
		new Object[]{"弄玉", 18 , "女"},
		new Object[]{"虎頭" , 2 , "男"}
	};
	// 定義一維資料作為欄標題
	Object[] columnTitle = {"姓名" , "年齡" , "性別"};
	public void init()
	{
		// 以二維陣列和一維陣列來建立一個JTable物件
		table = new JTable(tableData , columnTitle);
		// 將JTable物件放在JScrollPane中，
		// 並將該JScrollPane放在視窗中顯示出來
		jf.add(new JScrollPane(table));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SimpleTable().init();
	}
}

