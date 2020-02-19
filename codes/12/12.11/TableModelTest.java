
import java.sql.*;
import java.io.*;
import java.util.*;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
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
public class TableModelTest
{
	JFrame jf = new JFrame("資料表管理工具");
	private JScrollPane scrollPane;
	private ResultSetTableModel model;
	// 用於裝載資料表的JComboBox
	private JComboBox<String> tableNames = new JComboBox<>();
	private JTextArea changeMsg = new JTextArea(4, 80);
	private ResultSet rs;
	private Connection conn;
	private Statement stmt;
	public void init()
	{
		// 為JComboBox添加事件監聽器，當使用者選擇某個資料表時，觸發該方法
		tableNames.addActionListener(event -> {
			try
			{
				// 如果裝載JTable的JScrollPane不為空
				if (scrollPane != null)
				{
					// 從主視窗中刪除表格
					jf.remove(scrollPane);
				}
				// 從JComboBox中取出使用者試圖管理的資料表的表名
				String tableName = (String) tableNames.getSelectedItem();
				// 如果結果集不為空，則關閉結果集
				if (rs != null)
				{
					rs.close();
				}
				String query = "select * from " + tableName;
				// 查詢使用者選擇的資料表
				rs = stmt.executeQuery(query);
				// 使用查詢到的ResultSet建立TableModel物件
				model = new ResultSetTableModel(rs);
				// 為TableModel添加監聽器，監聽使用者的修改
				model.addTableModelListener(evt -> {
					int row = evt.getFirstRow();
					int column = evt.getColumn();
					changeMsg.append("修改的欄:" + column
						+ ",修改的列:" + row + "修改後的值:"
						+ model.getValueAt(row , column));
				});
				// 使用TableModel建立JTable，並將對應表格添加到視窗中
				JTable table = new JTable(model);
				scrollPane = new JScrollPane(table);
				jf.add(scrollPane, BorderLayout.CENTER);
				jf.validate();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		});
		JPanel p = new JPanel();
		p.add(tableNames);
		jf.add(p, BorderLayout.NORTH);
		jf.add(new JScrollPane(changeMsg), BorderLayout.SOUTH);
		try
		{
			// 獲取資料庫連接
			conn = getConnection();
			// 獲取資料庫的MetaData物件
			DatabaseMetaData meta = conn.getMetaData();
			// 建立Statement
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE
				, ResultSet.CONCUR_UPDATABLE);
			// 查詢當前資料庫的全部資料表
			ResultSet tables = meta.getTables(null, null, null
				, new String[] { "TABLE" });
			// 將全部資料表添加到JComboBox中
			while (tables.next())
			{
				tableNames.addItem(tables.getString(3));
			}
			tables.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		jf.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent event)
			{
				try
				{
					if (conn != null) conn.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		});
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	private static Connection getConnection()
		throws SQLException, IOException , ClassNotFoundException
	{
		// 通過載入conn.ini檔案來獲取資料庫連接的詳細資訊
		Properties props = new Properties();
		FileInputStream in = new FileInputStream("conn.ini");
		props.load(in);
		in.close();
		String drivers = props.getProperty("jdbc.drivers");
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		// 載入資料庫驅動
		Class.forName(drivers);
		// 取得資料庫連接
		return DriverManager.getConnection(url, username, password);
	}
	public static void main(String[] args)
	{
		new TableModelTest().init();
	}
}
// 擴展AbstractTableModel，用於將一個ResultSet包裝成TableModel
class ResultSetTableModel extends AbstractTableModel   // ①
{
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	// 建構子，初始化rs和rsmd兩個屬性
	public ResultSetTableModel(ResultSet aResultSet)
	{
		rs = aResultSet;
		try
		{
			rsmd = rs.getMetaData();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	// 覆寫getColumnName方法，用於為該TableModel設置欄名
	public String getColumnName(int c)
	{
		try
		{
			return rsmd.getColumnName(c + 1);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return "";
		}
	}
	// 覆寫getColumnCount方法，用於設置該TableModel的欄數
	public int getColumnCount()
	{
		try
		{
			return rsmd.getColumnCount();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	// 覆寫getValueAt方法，用於設置該TableModel指定儲存格的值
	public Object getValueAt(int r, int c)
	{
		try
		{
			rs.absolute(r + 1);
			return rs.getObject(c + 1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	// 覆寫getColumnCount方法，用於設置該TableModel的列數
	public int getRowCount()
	{
		try
		{
			rs.last();
			return rs.getRow();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	// 覆寫isCellEditable返回true，讓每個儲存格可編輯
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return true;
	}
	// 覆寫setValueAt()方法，當使用者編輯儲存格時，將會觸發該方法
	public void setValueAt(Object aValue , int row,int column)
	{
		try
		{
			// 結果集定位到對應的列數
			rs.absolute(row + 1);
			// 修改儲存格對應的值
			rs.updateObject(column + 1 , aValue);
			// 提交修改
			rs.updateRow();
			// 觸發儲存格的修改事件
			fireTableCellUpdated(row, column);
		}
		catch (SQLException evt)
		{
			evt.printStackTrace();
		}
	}
}

