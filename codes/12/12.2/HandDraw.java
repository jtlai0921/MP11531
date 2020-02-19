
import java.awt.*;
import java.awt.image.*;
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
public class HandDraw
{
	// 畫圖區的寬度
	private final int AREA_WIDTH = 500;
	// 畫圖區的高度
	private final int AREA_HEIGHT = 400;
	// 下面的preX、preY存放了上一次滑鼠拖動事件的滑鼠座標
	private int preX = -1;
	private int preY = -1;
	// 定義一個右鍵選單用於設置畫筆顏色
	JPopupMenu pop = new JPopupMenu();
	JMenuItem chooseColor = new JMenuItem("選擇顏色");
	// 定義一個BufferedImage物件
	BufferedImage image = new BufferedImage(AREA_WIDTH
		, AREA_HEIGHT , BufferedImage.TYPE_INT_RGB);
	// 獲取image物件的Graphics
	Graphics g = image.getGraphics();
	private JFrame f = new JFrame("簡單手繪程式");
	private DrawCanvas drawArea = new DrawCanvas();
	// 用於存放畫筆顏色
	private Color foreColor = new Color(255, 0 ,0);
	public void init()
	{
		chooseColor.addActionListener(ae -> {
			// 下面程式碼直接彈出一個模式的顏色選擇對話方塊，並返回使用者選擇的顏色
			// foreColor = JColorChooser.showDialog(f
			// 	, "選擇畫筆顏色" , foreColor);   // ①
			// 下面程式碼則彈出一個非模式的顏色選擇對話方塊，
			// 並可以分別為「確定」按鈕、「取消」按鈕指定事件監聽器
			final JColorChooser colorPane = new JColorChooser(foreColor);
			JDialog jd = JColorChooser.createDialog(f , "選擇畫筆顏色"
				, false, colorPane, e -> foreColor = colorPane.getColor(), null);
			jd.setVisible(true);
		});
		// 將選單項目組合成右鍵選單
		pop.add(chooseColor);
		// 將右鍵選單添加到drawArea物件中
		drawArea.setComponentPopupMenu(pop);
		// 將image物件的背景色填充成白色
		g.fillRect(0 , 0 ,AREA_WIDTH , AREA_HEIGHT);
		drawArea.setPreferredSize(new Dimension(AREA_WIDTH , AREA_HEIGHT));
		// 監聽滑鼠移動動作
		drawArea.addMouseMotionListener(new MouseMotionAdapter()
		{
			// 實作按下滑鼠鍵並拖動的事件處理器
			public void mouseDragged(MouseEvent e)
			{
				// 如果preX和preY大於0
				if (preX > 0 && preY > 0)
				{
					// 設置當前顏色
					g.setColor(foreColor);
					// 繪製從上一次滑鼠拖動事件點到本次滑鼠拖動事件點的線段
					g.drawLine(preX , preY , e.getX() , e.getY());
				}
				// 將當前滑鼠事件點的X、Y座標存放起來
				preX = e.getX();
				preY = e.getY();
				// 重繪drawArea物件
				drawArea.repaint();
			}
		});
		// 監聽滑鼠事件
		drawArea.addMouseListener(new MouseAdapter()
		{
			// 實作滑鼠鬆開的事件處理器
			public void mouseReleased(MouseEvent e)
			{
				// 鬆開滑鼠鍵時，把上一次滑鼠拖動事件的X、Y座標設為-1。
				preX = -1;
				preY = -1;
			}
		});
		f.add(drawArea);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new HandDraw().init();
	}
	// 讓畫圖區域繼承JPanel類別
	class DrawCanvas extends JPanel
	{
		// 覆寫JPanel的paint方法，實作繪畫
		public void paint(Graphics g)
		{
			// 將image繪製到該元件上
			g.drawImage(image , 0 , 0 , null);
		}
	}
}