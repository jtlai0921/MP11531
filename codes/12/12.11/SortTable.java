
import java.awt.event.*;

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
public class SortTable
{
	JFrame jf = new JFrame("可按欄排序的表格");
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
	// 以二維陣列和一維陣列來建立一個JTable物件
	JTable table = new JTable(tableData , columnTitle);
	// 將原表格里的model包裝成新的SortableTableModel物件
	SortableTableModel sorterModel = new SortableTableModel(
		table.getModel());
	public void init()
	{
		// 使用包裝後SortableTableModel物件作為JTable的model物件
		table.setModel(sorterModel);
		// 為每欄的欄標題增加滑鼠監聽器
		table.getTableHeader().addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent event)    // ①
			{
				//  如果單擊次數小於2，即不是雙擊，直接返回
				if (event.getClickCount() < 2)
				{
					return;
				}
				// 找出滑鼠雙擊事件所在的欄索引
				int tableColumn = table.columnAtPoint(event.getPoint());
				// 將JTable中的欄索引轉換成對應TableModel中的欄索引
				int modelColumn = table.convertColumnIndexToModel(tableColumn);
				// 根據指定欄進行排序
				sorterModel.sort(modelColumn);
			}
		});
		// 將JTable物件放在JScrollPane中，並將該JScrollPane顯示出來
		jf.add(new JScrollPane(table));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SortTable().init();
	}
}
class SortableTableModel extends AbstractTableModel
{
	private TableModel model;
	private int sortColumn;
	private Row[] rows;
	// 將一個已經存在TableModel物件包裝成SortableTableModel物件
	public SortableTableModel(TableModel m)
	{
		// 將被封裝的TableModel傳入
		model = m;
		rows = new Row[model.getRowCount()];
		// 將原TableModel中的每列記錄的索引使用Row陣列存放起來
		for (int i = 0; i < rows.length; i++)
		{
			rows[i] = new Row(i);
		}
	}
	// 實作根據指定欄進行排序
	public void sort(int c)
	{
		sortColumn = c;
		java.util.Arrays.sort(rows);
		fireTableDataChanged();
	}
	// 下面三個方法需要存取model中的資料，所以涉及本model中資料
	// 和被包裝model資料中的索引轉換，程式使用rows陣列完成這種轉換。
	public Object getValueAt(int r, int c)
	{
		return model.getValueAt(rows[r].index, c);
	}
	public boolean isCellEditable(int r, int c)
	{
		return model.isCellEditable(rows[r].index, c);
	}
	public void setValueAt(Object aValue, int r, int c)
	{
		model.setValueAt(aValue, rows[r].index, c);
	}
	// 下面方法的實作把該model的方法委託為原封裝的model來實作
	public int getRowCount()
	{
		return model.getRowCount();
	}
	public int getColumnCount()
	{
		return model.getColumnCount();
	}
	public String getColumnName(int c)
	{
		return model.getColumnName(c);
	}
	public Class getColumnClass(int c)
	{
		return model.getColumnClass(c);
	}
	// 定義一個Row類別，該類別用於封裝JTable中的一行
	// 實際上它並不封裝列資料，它只封裝列索引
	private class Row implements Comparable<Row>
	{
		// 該index存放著被封裝Model裡每列記錄的列索引
		public int index;
		public Row(int index)
		{
			this.index = index;
		}
		// 實作兩列之間的大小比較
		public int compareTo(Row other)
		{
			Object a = model.getValueAt(index, sortColumn);
			Object b = model.getValueAt(other.index, sortColumn);
			if (a instanceof Comparable)
			{
				return ((Comparable)a).compareTo(b);
			}
			else
			{
				return a.toString().compareTo(b.toString());
			}
		}
	}
}
