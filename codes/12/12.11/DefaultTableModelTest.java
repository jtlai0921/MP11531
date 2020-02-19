
import java.util.ArrayList;

import java.awt.event.*;
import java.awt.BorderLayout;
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
public class DefaultTableModelTest
{
	JFrame mainWin = new JFrame("管理資料列、資料欄");
	final int COLUMN_COUNT = 5;
	DefaultTableModel model;
	JTable table;
	// 用於存放被隱藏欄的List集合
	ArrayList<TableColumn> hiddenColumns = new ArrayList<>();
	public void init()
	{
		model = new DefaultTableModel(COLUMN_COUNT ,COLUMN_COUNT);
		for (int i = 0; i < COLUMN_COUNT ; i++ )
		{
			for (int j = 0; j < COLUMN_COUNT ; j++ )
			{
				model.setValueAt("老儲存格值 " + i + " " + j , i , j);
			}
		}
		table = new JTable(model);
		mainWin.add(new JScrollPane(table), BorderLayout.CENTER);
		// 為視窗安裝選單
		JMenuBar menuBar = new JMenuBar();
		mainWin.setJMenuBar(menuBar);
		JMenu tableMenu = new JMenu("管理");
		menuBar.add(tableMenu);
		JMenuItem hideColumnsItem = new JMenuItem("隱藏選取欄");
		hideColumnsItem.addActionListener(event -> {
			// 獲取所有選取欄的索引
			int[] selected = table.getSelectedColumns();
			TableColumnModel columnModel = table.getColumnModel();
			// 依次把每一個選取的欄隱藏起來，並使用List存放這些欄
			for (int i = selected.length - 1; i >= 0; i--)
			{
				TableColumn column = columnModel.getColumn(selected[i]);
				// 隱藏指定欄
				table.removeColumn(column);
				// 把隱藏的欄存放起來，確保以後可以顯示出來
				hiddenColumns.add(column);
			}
		});
		tableMenu.add(hideColumnsItem);
		JMenuItem showColumnsItem = new JMenuItem("顯示隱藏欄");
		showColumnsItem.addActionListener(event -> {
			// 把所有隱藏欄依次顯示出來
			for (TableColumn tc : hiddenColumns)
			{
				// 依次把所有隱藏的欄顯示出來
				table.addColumn(tc);
			}
			// 清空存放隱藏欄的List集合
			hiddenColumns.clear();
		});
		tableMenu.add(showColumnsItem);
		JMenuItem addColumnItem = new JMenuItem("插入選取欄");
		addColumnItem.addActionListener(event -> {
			// 獲取所有選取欄的索引
			int[] selected = table.getSelectedColumns();
			TableColumnModel columnModel = table.getColumnModel();
			// 依次把選取的欄添加到JTable之後
			for (int i = selected.length - 1; i >= 0; i--)
			{
				TableColumn column = columnModel
					.getColumn(selected[i]);
				table.addColumn(column);
			}
		});
		tableMenu.add(addColumnItem);
		JMenuItem addRowItem = new JMenuItem("增加列");
		addRowItem.addActionListener(event -> {
			// 建立一個String陣列作為新增列的內容
			String[] newCells = new String[COLUMN_COUNT];
			for (int i = 0; i < newCells.length; i++)
			{
				newCells[i] = "新儲存格值 " + model.getRowCount()
					+ " " + i;
			}
			// 向TableModel中新增一列。
			model.addRow(newCells);
		});
		tableMenu.add(addRowItem);
		JMenuItem removeRowsItem = new  JMenuItem("刪除選取列");
		removeRowsItem.addActionListener(event -> {
			// 獲取所有選取列
			int[] selected = table.getSelectedRows();
			// 依次刪除所有選取列
			for (int i = selected.length - 1; i >= 0; i--)
			{
				model.removeRow(selected[i]);
			}
		});
		tableMenu.add(removeRowsItem);
		mainWin.pack();
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
	}
	public static void main(String[] args)
	{
		new DefaultTableModelTest().init();
	}
}
