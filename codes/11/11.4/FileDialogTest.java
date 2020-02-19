
import java.awt.*;
import java.awt.event.*;
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
public class FileDialogTest
{
	Frame f = new Frame("測試");
	// 建立兩個檔案對話方塊
	FileDialog d1 = new FileDialog(f
		, "選擇需要開啟檔案" , FileDialog.LOAD);
	FileDialog d2 = new FileDialog(f
		, "選擇儲存檔案的路徑" , FileDialog.SAVE);
	Button b1 = new Button("開啟檔案");
	Button b2 = new Button("儲存檔案");
	public void init()
	{
		b1.addActionListener(e ->
		{
			d1.setVisible(true);
			// 列印出使用者選擇的檔案路徑和檔名
			System.out.println(d1.getDirectory()
				+ d1.getFile());
		});
		b2.addActionListener(e ->
		{
			d2.setVisible(true);
			// 列印出使用者選擇的檔案路徑和檔名
			System.out.println(d2.getDirectory()
				+ d2.getFile());
		});
		f.add(b1);
		f.add(b2 , BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new FileDialogTest().init();
	}
}

