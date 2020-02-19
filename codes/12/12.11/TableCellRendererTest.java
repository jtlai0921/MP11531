
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
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
public class TableCellRendererTest
{
	JFrame jf = new JFrame("使用儲存格繪製器");
	JTable table;
	// 定義二維陣列作為表格資料
	Object[][] tableData =
	{
		new Object[]{"李清照" , 29 , "女"
			, new ImageIcon("icon/3.gif") , true},
		new Object[]{"蘇格拉底", 56 , "男"
			, new ImageIcon("icon/1.gif") , false},
		new Object[]{"李白", 35 , "男"
			, new ImageIcon("icon/4.gif") , true},
		new Object[]{"弄玉", 18 , "女"
			, new ImageIcon("icon/2.gif") , true},
		new Object[]{"虎頭" , 2 , "男"
			, new ImageIcon("icon/5.gif") , false}
	};
	// 定義一維資料作為欄標題
	String[] columnTitle = {"姓名" , "年齡" , "性別"
		, "主頭像" , "是否中國人"};
	public void init()
	{
		// 以二維陣列和一維陣列來建立一個ExtendedTableModel物件
		ExtendedTableModel model = new ExtendedTableModel(columnTitle
			, tableData);
		// 以ExtendedTableModel來建立JTable
		table = new JTable( model);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(40);
		// 獲取第三欄
		TableColumn lastColumn = table.getColumnModel().getColumn(2);
		// 對第三欄採用自訂的儲存格繪製器
		lastColumn.setCellRenderer(new GenderTableCellRenderer());
		// 將JTable物件放在JScrollPane中，並將該JScrollPane顯示出來
		jf.add(new JScrollPane(table));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new TableCellRendererTest().init();
	}
}
class ExtendedTableModel extends DefaultTableModel
{
	// 重新提供一個建構子，該建構子的實作委託給DefaultTableModel父類別
	public ExtendedTableModel(String[] columnNames , Object[][] cells)
	{
		super(cells , columnNames);
	}
	// 覆寫getColumnClass方法，根據每列的第一個值來返回其真實的資料類型
	public Class getColumnClass(int c)
	{
		return getValueAt(0 , c).getClass();
	}
}
// 定義自訂的儲存格繪製器
class GenderTableCellRenderer extends JPanel
	implements TableCellRenderer
{
	private String cellValue;
	// 定義圖示的寬度和高度
	final int ICON_WIDTH = 23;
	final int ICON_HEIGHT = 21;
	public Component getTableCellRendererComponent(JTable table
		, Object value , boolean isSelected , boolean hasFocus
		, int row , int column)
	{
		cellValue = (String)value;
		// 設置選取狀態下繪製邊框
		if (hasFocus)
		{
			setBorder(UIManager.getBorder("Table.focusCellHighlightBorder"));
		}
		else
		{
			setBorder(null);
		}
		return this;
	}
	// 覆寫paint()方法，負責繪製該儲存格內容
	public void paint(Graphics g)
	{
		// 如果表格值為"男"或"male"，則繪製一個男性圖示
		if (cellValue.equalsIgnoreCase("男")
			|| cellValue.equalsIgnoreCase("male"))
		{
			drawImage(g , new ImageIcon("icon/male.gif").getImage());
		}
		// 如果表格值為"女"或"female"，則繪製一個女性圖示
		if (cellValue.equalsIgnoreCase("女")
			|| cellValue.equalsIgnoreCase("female"))
		{
			drawImage(g , new ImageIcon("icon/female.gif").getImage());
		}
	}
	// 繪製圖示的方法
	private void drawImage(Graphics g , Image image)
	{
		g.drawImage(image, (getWidth() - ICON_WIDTH ) / 2
			, (getHeight() - ICON_HEIGHT) / 2 , null);
	}
}
