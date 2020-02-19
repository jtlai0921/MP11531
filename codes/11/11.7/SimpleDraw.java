
import java.awt.*;
import java.awt.event.*;
import java.util.*;
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
public class SimpleDraw
{
	private final String RECT_SHAPE = "rect";
	private final String OVAL_SHAPE = "oval";
	private Frame f = new Frame("簡單繪圖");
	private Button rect = new Button("繪製矩形");
	private Button oval = new Button("繪製圓形");
	private MyCanvas drawArea = new MyCanvas();
	// 用於存放需要繪製什麼圖形的變數
	private String shape = "";
	public void init()
	{
		Panel p = new Panel();
		rect.addActionListener(e ->
		{
			// 設置shape變數為RECT_SHAPE
			shape = RECT_SHAPE;
			// 重畫MyCanvas物件，即呼叫它的repaint()方法
			drawArea.repaint();
		});
		oval.addActionListener(e ->
		{
			// 設置shape變數為OVAL_SHAPE
			shape = OVAL_SHAPE;
			// 重畫MyCanvas物件，即呼叫它的repaint()方法
			drawArea.repaint();
		});
		p.add(rect);
		p.add(oval);
		drawArea.setPreferredSize(new Dimension(250 , 180));
		f.add(drawArea);
		f.add(p , BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SimpleDraw().init();
	}
	class MyCanvas extends Canvas
	{
		// 覆寫Canvas的paint方法，實作繪畫
		public void paint(Graphics g)
		{
			Random rand = new Random();
			if (shape.equals(RECT_SHAPE))
			{
				// 設置畫筆顏色
				g.setColor(new Color(220, 100, 80));
				// 隨機地繪製一個矩形框
				g.drawRect( rand.nextInt(200)
					, rand.nextInt(120) , 40 , 60);
			}
			if (shape.equals(OVAL_SHAPE))
			{
				// 設置畫筆顏色
				g.setColor(new Color(80, 100, 200));
				// 隨機地填充一個實心圓形
				g.fillOval( rand.nextInt(200)
					, rand.nextInt(120) , 50 , 40);
			}
		}
	}
}
