
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
public class PopupMenuTest
{
	private TextArea ta = new TextArea(4 , 30);
	private Frame f = new Frame("測試");
	PopupMenu pop = new PopupMenu();
	CheckboxMenuItem autoWrap =
		new CheckboxMenuItem("自動換行");
	MenuItem copyItem = new MenuItem("複製");
	MenuItem pasteItem = new MenuItem("貼上");
	Menu format = new Menu("格式");
	// 建立commentItem選單項目，指定使用 Ctrl+Shift+/ 快捷鍵
	MenuItem commentItem = new MenuItem("註解" ,
		new MenuShortcut(KeyEvent.VK_SLASH , true));
	MenuItem cancelItem = new MenuItem("取消註解");
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
		// 為commentItem選單項目添加了事件監聽器。
		commentItem.addActionListener(menuListener);
		// 為pop選單添加選單項目
		pop.add(autoWrap);
		// 使用addSeparator方法來添加選單分隔線
		pop.addSeparator();
		pop.add(copyItem);
		pop.add(pasteItem);
		// 為format選單添加選單項目
		format.add(commentItem);
		format.add(cancelItem);
		// 使用添加new MenuItem("-")的方式添加選單分隔線
		pop.add(new MenuItem("-"));
		// 將format選單組合到pop選單中，從而形成二級選單
		pop.add(format);
		final Panel p = new Panel();
		p.setPreferredSize(new Dimension(300, 160));
		// 向p視窗中添加PopupMenu物件
		p.add(pop);
		// 添加滑鼠事件監聽器
		p.addMouseListener(new MouseAdapter()
		{
			public void mouseReleased(MouseEvent e)
			{
				// 如果釋放的是滑鼠右鍵
				if (e.isPopupTrigger())
				{
					pop.show(p , e.getX() , e.getY());
				}
			}
		});
		f.add(p);
		f.add(ta , BorderLayout.NORTH);
		// 以匿名內部類別的形式來建立事件監聽器物件
		f.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new PopupMenuTest().init();
	}
}
