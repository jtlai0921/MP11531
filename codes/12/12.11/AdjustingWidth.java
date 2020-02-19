
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
public class AdjustingWidth
{
	JFrame jf = new JFrame("調整表格欄寬");
	JMenuBar menuBar = new JMenuBar();
	JMenu adjustModeMenu = new JMenu("調整方式");
	JMenu selectUnitMenu = new JMenu("選擇單元");
	JMenu selectModeMenu = new JMenu("選擇方式");
	// 定義5個單選框按鈕，用以控制表格的寬度調整方式
	JRadioButtonMenuItem[] adjustModesItem = new JRadioButtonMenuItem[5];
	// 定義3個單選框按鈕，用以控制表格的選擇方式
	JRadioButtonMenuItem[] selectModesItem = new JRadioButtonMenuItem[3];
	JCheckBoxMenuItem rowsItem = new JCheckBoxMenuItem("選擇列");
	JCheckBoxMenuItem columnsItem = new JCheckBoxMenuItem("選擇欄");
	JCheckBoxMenuItem cellsItem = new JCheckBoxMenuItem("選擇儲存格");
	ButtonGroup adjustBg = new ButtonGroup();
	ButtonGroup selectBg = new ButtonGroup();
	// 定義一個int類型的陣列，用於存放表格所有的寬度調整方式
	int[] adjustModes = new int[]{
		JTable.AUTO_RESIZE_OFF
		, JTable.AUTO_RESIZE_NEXT_COLUMN
		, JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS
		, JTable.AUTO_RESIZE_LAST_COLUMN
		, JTable.AUTO_RESIZE_ALL_COLUMNS
	};
	int[] selectModes = new int[]{
		ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
		, ListSelectionModel.SINGLE_INTERVAL_SELECTION
		, ListSelectionModel.SINGLE_SELECTION
	};
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
		// -----------為視窗安裝設置表格調整方式的選單-----------
		adjustModesItem[0] = new JRadioButtonMenuItem("只調整表格");
		adjustModesItem[1] = new JRadioButtonMenuItem("只調整下一欄");
		adjustModesItem[2] = new JRadioButtonMenuItem("平均調整餘下欄");
		adjustModesItem[3] = new JRadioButtonMenuItem("只調整最後一欄");
		adjustModesItem[4] = new JRadioButtonMenuItem("平均調整所有欄");
		menuBar.add(adjustModeMenu);
		for (int i = 0; i < adjustModesItem.length ; i++)
		{
			// 預設選取第三個選單項目，即對應表格預設的寬度調整方式
			if (i == 2)
			{
				adjustModesItem[i].setSelected(true);
			}
			adjustBg.add(adjustModesItem[i]);
			adjustModeMenu.add(adjustModesItem[i]);
			final int index = i;
			// 為設置調整方式的選單項目添加監聽器
			adjustModesItem[i].addActionListener(evt ->
			{
				// 如果當前選單項目處於選取狀態，表格使用對應的調整方式
				if (adjustModesItem[index].isSelected())
				{
					table.setAutoResizeMode(adjustModes[index]);   //①
				}
			});
		}
		// -----------為視窗安裝設置表格選擇方式的選單-----------
		selectModesItem[0] = new JRadioButtonMenuItem("無限制");
		selectModesItem[1] = new JRadioButtonMenuItem("單獨的連續區");
		selectModesItem[2] = new JRadioButtonMenuItem("單選");
		menuBar.add(selectModeMenu);
		for (int i = 0; i < selectModesItem.length ; i++)
		{
			// 預設選取第一個選單項目，即對應表格預設的選擇方式
			if (i == 0)
			{
			selectModesItem[i].setSelected(true);
			}
			selectBg.add(selectModesItem[i]);
			selectModeMenu.add(selectModesItem[i]);
			final int index = i;
			// 為設置選擇方式的選單項目添加監聽器
			selectModesItem[i].addActionListener(evt -> {
				// 如果當前選單項目處於選取狀態，表格使用對應的選擇方式s
				if (selectModesItem[index].isSelected())
				{
					table.getSelectionModel().setSelectionMode
						(selectModes[index]);     //②
				}
			});
		}
		menuBar.add(selectUnitMenu);
		// -----為視窗安裝設置表格選擇單元的選單-----
		rowsItem.setSelected(table.getRowSelectionAllowed());
		columnsItem.setSelected(table.getColumnSelectionAllowed());
		cellsItem.setSelected(table.getCellSelectionEnabled());
		rowsItem.addActionListener(event -> {
			table.clearSelection();
			// 如果該選單項目處於選取狀態，設置表格的選擇單元是列
			table.setRowSelectionAllowed(rowsItem.isSelected());
			// 如果選擇列、選擇欄同時被選取，其實質是選擇儲存格
			cellsItem.setSelected(table.getCellSelectionEnabled());
		});
		selectUnitMenu.add(rowsItem);
		columnsItem.addActionListener(event -> {
			table.clearSelection();
			// 如果該選單項目處於選取狀態，設置表格的選擇單元是欄
			table.setColumnSelectionAllowed(columnsItem.isSelected());
			// 如果選擇列、選擇欄同時被選取，其實質是選擇儲存格
			cellsItem.setSelected(table.getCellSelectionEnabled());
		});
		selectUnitMenu.add(columnsItem);
		cellsItem.addActionListener(event -> {
			table.clearSelection();
			// 如果該選單項目處於選取狀態，設置表格的選擇單元是儲存格
			table.setCellSelectionEnabled(cellsItem.isSelected());
			// 該選項的改變會同時影響選擇列、選擇欄兩個選單
			rowsItem.setSelected(table.getRowSelectionAllowed());
			columnsItem.setSelected(table.getColumnSelectionAllowed());
		});
		selectUnitMenu.add(cellsItem);
		jf.setJMenuBar(menuBar);
		// 分別獲取表格的三個表格列，並設置三欄的最小寬度，最佳寬度和最大寬度
		TableColumn nameColumn = table.getColumn(columnTitle[0]);
		nameColumn.setMinWidth(40);
		TableColumn ageColumn = table.getColumn(columnTitle[1]);
		ageColumn.setPreferredWidth(50);
		TableColumn genderColumn = table.getColumn(columnTitle[2]);
		genderColumn.setMaxWidth(50);
		// 將JTable物件放在JScrollPane中，並將該JScrollPane放在視窗中顯示出來
		jf.add(new JScrollPane(table));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new AdjustingWidth().init();
	}
}
