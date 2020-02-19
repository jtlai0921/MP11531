
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
public class SimpleMenu
{
	private Frame f = new Frame("測試");
	private MenuBar mb = new MenuBar();
	Menu file = new Menu("檔案");
	Menu edit = new Menu("編輯");
	MenuItem newItem = new MenuItem("新增");
	MenuItem saveItem = new MenuItem("儲存");
	// 建立exitItem選單項目，指定使用 Ctrl+X 快捷鍵
	MenuItem exitItem = new MenuItem("結束"
		, new MenuShortcut(KeyEvent.VK_X));
	CheckboxMenuItem autoWrap = new CheckboxMenuItem("自動換行");
	MenuItem copyItem = new MenuItem("複製");
	MenuItem pasteItem = new MenuItem("貼上");
	Menu format = new Menu("格式");
	// 建立commentItem選單項目，指定使用 Ctrl+Shift+/ 快捷鍵
	MenuItem commentItem = new MenuItem("註解" ,
		new MenuShortcut(KeyEvent.VK_SLASH , true));
	MenuItem cancelItem = new MenuItem("取消註解");
	private TextArea ta = new TextArea(6 , 40);
	public void init()
	{
		// 以Lambda運算式建立選單事件監聽器
		ActionListener menuListener = e ->
		{
			String cmd = e.getActionCommand();
			ta.append("單擊「" + cmd + "」選單" + "\n");
			if (cmd.equals("結束"))
			{
				System.exit(0);
			}
		};
		// 為commentItem選單項目添加事件監聽器
		commentItem.addActionListener(menuListener);
		exitItem.addActionListener(menuListener);
		// 為file選單添加選單項目
		file.add(newItem);
		file.add(saveItem);
		file.add(exitItem);
		// 為edit選單添加選單項目
		edit.add(autoWrap);
		// 使用addSeparator方法來添加選單分隔線
		edit.addSeparator();
		edit.add(copyItem);
		edit.add(pasteItem);
		// 為format選單添加選單項目
		format.add(commentItem);
		format.add(cancelItem);
		// 使用添加new MenuItem("-")的方式添加選單分隔線
		edit.add(new MenuItem("-"));
		// 將format選單組合到edit選單中，從而形成二級選單
		edit.add(format);
		// 將file、edit選單添加到mb選單列中
		mb.add(file);
		mb.add(edit);
		// 為f視窗設置選單列
		f.setMenuBar(mb);
		// 以匿名內部類別的形式來建立事件監聽器物件
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f.add(ta);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SimpleMenu().init();
	}
}
