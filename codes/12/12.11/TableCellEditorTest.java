
import java.io.File;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.filechooser.*;
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
public class TableCellEditorTest
{
	JFrame jf = new JFrame("使用儲存格編輯器");
	JTable table;
	// 定義二維陣列作為表格資料
	Object[][] tableData =
	{
		new Object[]{"李清照" , 29 , "女" , new ImageIcon("icon/3.gif")
			, new ImageIcon("icon/3.gif") , true},
		new Object[]{"蘇格拉底", 56 , "男" , new ImageIcon("icon/1.gif")
			, new ImageIcon("icon/1.gif") , false},
		new Object[]{"李白", 35 , "男" , new ImageIcon("icon/4.gif")
			, new ImageIcon("icon/4.gif") , true},
		new Object[]{"弄玉", 18 , "女" , new ImageIcon("icon/2.gif")
			, new ImageIcon("icon/2.gif") , true},
		new Object[]{"虎頭" , 2 , "男" , new ImageIcon("icon/5.gif")
			, new ImageIcon("icon/5.gif") , false}
	};
	// 定義一維資料作為欄標題
	String[] columnTitle = {"姓名" , "年齡" , "性別" , "主頭像"
		, "次頭像" , "是否中國人"};
	public void init()
	{
		// 以二維陣列和一維陣列來建立一個ExtendedTableModel物件
		ExtendedTableModel model = new ExtendedTableModel(
			columnTitle , tableData);
		// 以ExtendedTableModel來建立JTable
		table = new JTable(model);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(40);
		// 為該表格指定預設的編輯器
		table.setDefaultEditor(ImageIcon.class, new ImageCellEditor());
		// 獲取第五欄
		TableColumn lastColumn = table.getColumnModel().getColumn(4);
		// 建立JComboBox物件，並添加多個圖示列表項目
		JComboBox<ImageIcon> editCombo = new JComboBox<>();
		for (int i = 1; i <= 10; i++)
		{
			editCombo.addItem(new ImageIcon("icon/" + i + ".gif"));
		}
		// 設置第五欄使用基於JComboBox的DefaultCellEditor
		lastColumn.setCellEditor(new DefaultCellEditor(editCombo));
		// 將JTable物件放在JScrollPane中，並將該JScrollPane放在視窗中顯示出來
		jf.add(new JScrollPane(table));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new TableCellEditorTest().init();
	}
}
class ExtendedTableModel extends DefaultTableModel
{
	// 重新提供一個建構子，該建構子的實作委託給DefaultTableModel父類別
	public ExtendedTableModel(String[] columnNames , Object[][] cells)
	{
		super(cells , columnNames);
	}
	// 覆寫getColumnClass方法，根據每欄的第一個值返回該欄真實的資料類型
	public Class getColumnClass(int c)
	{
		return getValueAt(0 , c).getClass();
	}
}
// 擴展DefaultCellEditor來實作TableCellEditor類別
class ImageCellEditor extends DefaultCellEditor
{
	// 定義檔案選擇器
	private JFileChooser fDialog = new JFileChooser(); ;
	private JTextField field = new JTextField(15);
	private JButton button = new JButton("...");
	public ImageCellEditor()
	{
		// 因為DefaultCellEditor沒有無參數的建構子
		// 所以這裡顯式呼叫父類別有參數的建構子。
		super(new JTextField());
		initEditor();
	}
	private void initEditor()
	{
		field.setEditable(false);
		// 為按鈕添加監聽器，當使用者單擊該按鈕時，
		// 系統將出現一個檔案選擇器讓使用者選擇圖示檔。
		button.addActionListener(e -> browse());
		// 為檔案選擇器安裝檔案過濾器
		fDialog.addChoosableFileFilter(new FileFilter()
		{
			public boolean accept(File f)
			{
				if (f.isDirectory())
				{
					return true;
				}
				String extension = Utils.getExtension(f);
				if (extension != null)
				{
					if (extension.equals(Utils.tiff)
						|| extension.equals(Utils.tif)
						|| extension.equals(Utils.gif)
						|| extension.equals(Utils.jpeg)
						|| extension.equals(Utils.jpg)
						|| extension.equals(Utils.png))
					{
						return true;
					}
					else
					{
						return false;
					}
				}
				return false;
			}
			public String getDescription()
			{
				return "有效的圖片檔";
			}
		});
		fDialog.setAcceptAllFileFilterUsed(false);
	}
	// 覆寫TableCellEditor介面的getTableCellEditorComponent方法
	// 該方法返回儲存格編輯器，該編輯器是一個JPanel，
	// 該容器包含一個文字方塊和一個按鈕
	public Component getTableCellEditorComponent(JTable table
		, Object value , boolean isSelected , int row , int column)  // ①
	{
		this.button.setPreferredSize(new Dimension(20, 20));
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		field.setText(value.toString());
		panel.add(this.field, BorderLayout.CENTER);
		panel.add(this.button, BorderLayout.EAST);
		return panel;
	}
	public Object getCellEditorValue()
	{
		return new ImageIcon(field.getText());
	}
	private void browse()
	{
		// 設置、開啟檔案選擇器
		fDialog.setCurrentDirectory(new File("icon"));
		int result = fDialog.showOpenDialog(null);
		// 如果單擊了檔案選擇器的「取消」按鈕
		if (result == JFileChooser.CANCEL_OPTION)
		{
			// 取消編輯
			super.cancelCellEditing();
			return;
		}
		// 如果單擊了檔案選擇器的「確定」按鈕
		else
		{
			// 設置field的內容
			field.setText("icon/" + fDialog.getSelectedFile().getName());
		}
	}
}
class Utils
{
	public final static String jpeg = "jpeg";
	public final static String jpg = "jpg";
	public final static String gif = "gif";
	public final static String tiff = "tiff";
	public final static String tif = "tif";
	public final static String png = "png";
	// 獲取檔案副檔名的方法
	public static String getExtension(File f)
	{
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');
		if (i > 0 &&  i < s.length() - 1)
		{
			ext = s.substring(i + 1).toLowerCase();
		}
		return ext;
	}
}
