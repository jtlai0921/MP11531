
import java.util.List;
import java.io.*;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.*;
import java.awt.dnd.*;
import javax.imageio.*;
import java.awt.datatransfer.*;
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
public class DropTargetTest
{
	final int DESKTOP_WIDTH = 480;
	final int DESKTOP_HEIGHT = 360;
	final int FRAME_DISTANCE = 30;
	JFrame jf = new JFrame("測試拖放目標――把圖片檔拖入該視窗");
	// 定義一個虛擬桌面
	private JDesktopPane desktop = new JDesktopPane();
	// 存放下一個內部視窗的座標點
	private int nextFrameX;
	private int nextFrameY;
	// 定義內部視窗為虛擬桌面的1/2大小
	private int width = DESKTOP_WIDTH / 2;
	private int height = DESKTOP_HEIGHT / 2;
	public void init()
	{
		desktop.setPreferredSize(new Dimension(DESKTOP_WIDTH
			, DESKTOP_HEIGHT));
		// 將當前視窗建立成拖放目標
		new DropTarget(jf, DnDConstants.ACTION_COPY
			, new ImageDropTargetListener());
		jf.add(desktop);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	class ImageDropTargetListener extends DropTargetAdapter
	{
		public void drop(DropTargetDropEvent event)
		{
			// 接受複製操作
			event.acceptDrop(DnDConstants.ACTION_COPY);
			// 獲取拖放的內容
			Transferable transferable = event.getTransferable();
			DataFlavor[] flavors = transferable.getTransferDataFlavors();
			// 遍歷拖放內容裡的所有資料格式
			for (int i = 0; i < flavors.length; i++)
			{
				DataFlavor d = flavors[i];
				try
				{
					// 如果拖放內容的資料格式是檔案列表
					if (d.equals(DataFlavor.javaFileListFlavor))
					{
						// 取出拖放操作裡的檔案列表
						List fileList = (List)transferable
							.getTransferData(d);
						for (Object f : fileList)
						{
							// 顯示每個檔案
							showImage((File)f , event);
						}
					}
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
				// 強制拖放操作結束，停止阻擋拖放目標
				event.dropComplete(true);    // ①
			}
		}
		// 顯示每個檔案的工具方法
		private void showImage(File f , DropTargetDropEvent event)
			throws IOException
		{
			Image image = ImageIO.read(f);
			if (image == null)
			{
				// 強制拖放操作結束，停止阻擋拖放目標
				event.dropComplete(true);     // ②
				JOptionPane.showInternalMessageDialog(desktop
					, "系統不支援這種類型的檔案");
				// 方法返回，不會繼續操作
				return;
			}
			ImageIcon icon = new ImageIcon(image);
			// 建立內部視窗顯示該圖片
			JInternalFrame iframe = new JInternalFrame(f.getName()
				, true , true , true , true);
			JLabel imageLabel = new JLabel(icon);
			iframe.add(new JScrollPane(imageLabel));
			desktop.add(iframe);
			// 設置內部視窗的原始位置（內部視窗預設大小是0X0，放在0,0位置）
			iframe.reshape(nextFrameX, nextFrameY, width, height);
			// 使該視窗可見，並嘗試選取它
			iframe.show();
			// 運算下一個內部視窗的位置
			nextFrameX += FRAME_DISTANCE;
			nextFrameY += FRAME_DISTANCE;
			if (nextFrameX + width > desktop.getWidth())
				nextFrameX = 0;
			if (nextFrameY + height > desktop.getHeight())
				nextFrameY = 0;
		}
	}
	public static void main(String[] args)
	{
		new DropTargetTest().init();
	}
}
