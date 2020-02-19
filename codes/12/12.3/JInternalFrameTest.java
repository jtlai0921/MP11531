
import java.beans.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
public class JInternalFrameTest
{
	final int DESKTOP_WIDTH = 480;
	final int DESKTOP_HEIGHT = 360;
	final int FRAME_DISTANCE = 30;
	JFrame jf = new JFrame("MDI介面");
	// 定義一個虛擬桌面
	private MyJDesktopPane desktop = new MyJDesktopPane();
	// 存放下一個內部視窗的座標點
	private int nextFrameX;
	private int nextFrameY;
	// 定義內部視窗為虛擬桌面的1/2大小
	private int width = DESKTOP_WIDTH / 2;
	private int height = DESKTOP_HEIGHT / 2;
	// 為主視窗定義兩個選單
	JMenu fileMenu = new JMenu("檔案");
	JMenu windowMenu = new JMenu("視窗");
	// 定義newAction用於建立選單和工具按鈕
	Action newAction = new AbstractAction("新增"
		, new ImageIcon("ico/new.png"))
	{
		public void actionPerformed(ActionEvent event)
		{
			// 建立內部視窗
			final JInternalFrame iframe = new JInternalFrame("新文件",
				true, // 可改變大小
				true, // 可關閉
				true, // 可最大化
				true); // 可最小化
			iframe.add(new JScrollPane(new JTextArea(8, 40)));
			// 將內部視窗添加到虛擬桌面中
			desktop.add(iframe);
			// 設置內部視窗的原始位置（內部視窗預設大小是0X0，放在0,0位置）
			iframe.reshape(nextFrameX, nextFrameY, width, height);
			// 使該視窗可見，並嘗試選取它
			iframe.show();
			// 運算下一個內部視窗的位置
			nextFrameX += FRAME_DISTANCE;
			nextFrameY += FRAME_DISTANCE;
			if (nextFrameX + width > desktop.getWidth()) nextFrameX = 0;
			if (nextFrameY + height > desktop.getHeight()) nextFrameY = 0;
		}
	};
	// 定義exitAction用於建立選單和工具按鈕
	Action exitAction = new AbstractAction("結束"
		, new ImageIcon("ico/exit.png"))
	{
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
	};
	public void init()
	{
		// 為視窗安裝選單列和工具列
		JMenuBar menuBar = new JMenuBar();
		JToolBar toolBar = new JToolBar();
		jf.setJMenuBar(menuBar);
		menuBar.add(fileMenu);
		fileMenu.add(newAction);
		fileMenu.add(exitAction);
		toolBar.add(newAction);
		toolBar.add(exitAction);
		menuBar.add(windowMenu);
		JMenuItem nextItem = new JMenuItem("下一個");
		nextItem.addActionListener(event -> desktop.selectNextWindow());
		windowMenu.add(nextItem);
		JMenuItem cascadeItem = new JMenuItem("級聯");
		cascadeItem.addActionListener(event ->
			// 級聯顯示視窗，內部視窗的大小是外部視窗的0.75
			desktop.cascadeWindows(FRAME_DISTANCE , 0.75));
		windowMenu.add(cascadeItem);
		JMenuItem tileItem = new JMenuItem("平鋪");
		// 平鋪顯示所有內部視窗
		tileItem.addActionListener(event -> desktop.tileWindows());
		windowMenu.add(tileItem);
		final JCheckBoxMenuItem dragOutlineItem = new
			JCheckBoxMenuItem("僅顯示拖動視窗的輪廓");
		dragOutlineItem.addActionListener(event ->
			// 根據該選單項是否選擇來決定採用哪種拖動模式
			desktop.setDragMode(dragOutlineItem.isSelected()
				? JDesktopPane.OUTLINE_DRAG_MODE
				: JDesktopPane.LIVE_DRAG_MODE));    // ①
		windowMenu.add(dragOutlineItem);
		desktop.setPreferredSize(new Dimension(480, 360));
		// 將虛擬桌面添加到頂級JFrame容器中
		jf.add(desktop);
		jf.add(toolBar , BorderLayout.NORTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new JInternalFrameTest().init();
	}
}
class MyJDesktopPane extends JDesktopPane
{
	// 將所有視窗以級聯方式顯示,
	// 其中offset是兩個視窗的位移距離, s
	// cale是內部視窗與JDesktopPane的大小比例
	public void cascadeWindows(int offset , double scale)
	{
		// 定義級聯顯示視窗時內部視窗的大小
		int width = (int)(getWidth() * scale);
		int height = (int)(getHeight() * scale);
		// 用於存放級聯視窗時每個視窗的位置
		int x = 0;
		int y = 0;
		for (JInternalFrame frame : getAllFrames())
		{
			try
			{
				// 取消內部視窗的最大化,最小化
				frame.setMaximum(false);
				frame.setIcon(false);
				// 把視窗重新放置在指定位置
				frame.reshape(x, y, width, height);
				x += offset;
				y += offset;
				// 如果到了虛擬桌面邊界
				if (x + width > getWidth()) x = 0;
				if (y + height > getHeight()) y = 0;
			}
			catch (PropertyVetoException e)
			{}
		}
	}
	// 將所有視窗以平鋪方式顯示
	public void tileWindows()
	{
		// 統計所有視窗
		int frameCount = 0;
		for (JInternalFrame frame : getAllFrames())
		{
			frameCount++;
		}
		// 運算需要多少行、多少列才可以平鋪所有視窗
		int rows = (int) Math.sqrt(frameCount);
		int cols = frameCount / rows;
		// 需要額外增加到其他列中的視窗
		int extra = frameCount % rows;
		// 運算平鋪時內部視窗的大小
		int width = getWidth() / cols;
		int height = getHeight() / rows;
		// 用於存放平鋪視窗時每個視窗在橫向、縱向上的索引
		int x = 0;
		int y = 0;
		for (JInternalFrame frame : getAllFrames())
		{
			try
			{
				// 取消內部視窗的最大化,最小化
				frame.setMaximum(false);
				frame.setIcon(false);
				// 將視窗放在指定位置
				frame.reshape(x * width, y * height, width, height);
				y++;
				// 每排完一列視窗
				if (y == rows)
				{
					// 開始排放下一列視窗
					y = 0;
					x++;
					// 如果額外多出的視窗與剩下的列數相等，
					// 則後面所有列都需要多排列一個視窗
					if (extra == cols - x)
					{
						rows++;
						height = getHeight() / rows;
					}
				}
			}
			catch (PropertyVetoException e)
			{}
		}
	}
	// 選取下一個非圖示視窗
	public void selectNextWindow()
	{
		JInternalFrame[] frames = getAllFrames();
		for (int i = 0; i < frames.length; i++)
		{
			if (frames[i].isSelected())
			{
				//  找出下一個非最小化的視窗，嘗試選取它，
				// 如果選取失敗，則繼續嘗試選取下一個視窗
				int next = (i + 1) % frames.length;
				while (next != i)
				{
					// 如果該視窗不是處於最小化狀態
					if (!frames[next].isIcon())
					{
						try
						{
							frames[next].setSelected(true);
							frames[next].toFront();
							frames[i].toBack();
							return;
						}
						catch (PropertyVetoException e)
						{}
					}
					next = (next + 1) % frames.length;
				}
			}
		}
	}
}