
import java.io.File;
import java.beans.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
public class ImageViewer
{
	// 定義圖片預覽元件的大小
	final int PREVIEW_SIZE = 100;
	JFrame jf = new JFrame("簡單圖片檢視器");
	JMenuBar menuBar = new JMenuBar();
	// 該label用於顯示圖片
	JLabel label = new JLabel();
	// 以當前路徑建立檔案選擇器
	JFileChooser chooser = new JFileChooser(".");
	JLabel accessory = new JLabel();
	// 定義檔案過濾器
	ExtensionFileFilter filter = new ExtensionFileFilter();
	public void init()
	{
		// --------下面開始初始化JFileChooser的相關屬性--------
		//  建立一個FileFilter
		filter.addExtension("jpg");
		filter.addExtension("jpeg");
		filter.addExtension("gif");
		filter.addExtension("png");
		filter.setDescription("圖片檔(*.jpg,*.jpeg,*.gif,*.png)");
		chooser.addChoosableFileFilter(filter);
		// 禁止「檔案類型」下拉列表中顯示「所有檔案」選項。
		chooser.setAcceptAllFileFilterUsed(false);   // ①
		// 為檔案選擇器指定自訂的FileView物件
		chooser.setFileView(new FileIconView(filter));
		// 為檔案選擇器指定一個預覽圖片的附件
		chooser.setAccessory(accessory);     // ②
		// 設置預覽圖片元件的大小和邊框
		accessory.setPreferredSize(new Dimension(PREVIEW_SIZE, PREVIEW_SIZE));
		accessory.setBorder(BorderFactory.createEtchedBorder());
		// 用於檢測被選擇檔案的改變事件
		chooser.addPropertyChangeListener(event -> {
			// JFileChooser的被選檔案已經發生了改變
			if (event.getPropertyName() ==
				JFileChooser.SELECTED_FILE_CHANGED_PROPERTY)
			{
				// 獲取使用者選擇的新檔案
				File f = (File) event.getNewValue();
				if (f == null)
				{
					accessory.setIcon(null);
					return;
				}
				// 將所選檔案讀入ImageIcon物件中
				ImageIcon icon = new ImageIcon(f.getPath());
				// 如果圖像太大，則縮小它
				if(icon.getIconWidth() > PREVIEW_SIZE)
				{
					icon = new ImageIcon(icon.getImage().getScaledInstance
						(PREVIEW_SIZE, -1, Image.SCALE_DEFAULT));
				}
				// 改變accessory Label的圖示
				accessory.setIcon(icon);
			}
		});
		// ------下面程式碼開始為該視窗安裝選單------
		JMenu menu = new JMenu("檔案");
		menuBar.add(menu);
		JMenuItem openItem = new JMenuItem("開啟");
		menu.add(openItem);
		// 單擊openItem選單項顯示「開啟檔案」的對話方塊
		openItem.addActionListener(event -> {
			// 設置檔案對話方塊的當前路徑
			// chooser.setCurrentDirectory(new File("."));
			// 顯示檔案對話方塊
			int result = chooser.showDialog(jf , "開啟圖片檔");
			// 如果使用者選擇了APPROVE（同意）按鈕，即開啟，存放的等效按鈕
			if(result == JFileChooser.APPROVE_OPTION)
			{
				String name = chooser.getSelectedFile().getPath();
				// 顯示指定圖片
				label.setIcon(new ImageIcon(name));
			}
		});
		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		// 為結束選單綁定事件監聽器
		exitItem.addActionListener(event -> System.exit(0));
		jf.setJMenuBar(menuBar);
		// 添加用於顯示圖片的JLabel元件。
		jf.add(new JScrollPane(label));
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new ImageViewer().init();
	}
}
// 建立FileFilter的子類別，用以實作檔案過濾功能
class ExtensionFileFilter extends FileFilter
{
	private String description;
	private ArrayList<String> extensions = new ArrayList<>();
	// 自訂方法，用於添加檔案副檔名
	public void addExtension(String extension)
	{
		if (!extension.startsWith("."))
		{
			extension = "." + extension;
			extensions.add(extension.toLowerCase());
		}
	}
	// 用於設置該檔案過濾器的描述文字
	public void setDescription(String aDescription)
	{
		description = aDescription;
	}
	// 繼承FileFilter類別必須實作的抽象方法，返回該檔案過濾器的描述文字
	public String getDescription()
	{
		return description;
	}
	// 繼承FileFilter類別必須實作的抽象方法，判斷該檔案過濾器是否接受該檔案
	public boolean accept(File f)
	{
		// 如果該檔案是路徑，接受該檔案
		if (f.isDirectory()) return true;
		// 將檔案名轉為小寫（全部轉為小寫後比較，用於忽略檔案名大小寫）
		String name = f.getName().toLowerCase();
		// 遍歷所有可接受的副檔名，如果副檔名相同，該檔案就可接受。
		for (String extension : extensions)
		{
			if (name.endsWith(extension))
			{
				return true;
			}
		}
		return false;
	}
}
// 自訂一個FileView類別，用於為指定類型的檔案或資料夾設置圖示
class FileIconView extends FileView
{
	private FileFilter filter;
	public FileIconView(FileFilter filter)
	{
		this.filter = filter;
	}
	// 覆寫該方法，為資料夾、檔案設置圖示
	public Icon getIcon(File f)
	{
		if (!f.isDirectory() && filter.accept(f))
		{
			return new ImageIcon("ico/pict.png");
		}
		else if (f.isDirectory())
		{
			// 獲取所有根路徑
			File[] fList = File.listRoots();
			for (File tmp : fList)
			{
				// 如果該路徑是根路徑
				if (tmp.equals(f))
				{
					return  new ImageIcon("ico/dsk.png");
				}
			}
			return new ImageIcon("ico/folder.png");
		}
		// 使用預設圖示
		else
		{
			return null;
		}
	}
}
