
import java.beans.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
import java.awt.geom.Point2D;
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
class FirstLayerUI extends LayerUI<JComponent>
{
	public void paint(Graphics g, JComponent c)
	{
		super.paint(g, c);
		Graphics2D g2 = (Graphics2D) g.create();
		// 設置透明效果
		g2.setComposite(AlphaComposite.getInstance(
			AlphaComposite.SRC_OVER, .5f));
		// 使用漸變畫筆繪圖
		g2.setPaint(new GradientPaint(0 , 0 , Color.RED
			, 0 , c.getHeight() , Color.BLUE));
		// 繪製一個與被裝飾元件相同大小的矩形
		g2.fillRect(0, 0, c.getWidth(), c.getHeight());    // ①
		g2.dispose();
	}
}
class BlurLayerUI extends LayerUI<JComponent>
{
	private BufferedImage screenBlurImage;
	private BufferedImageOp operation;
	public BlurLayerUI()
	{
		float ninth = 1.0f / 9.0f;
		// 定義模糊參數
		float[] blurKernel = {
			ninth, ninth, ninth,
			ninth, ninth, ninth,
			ninth, ninth, ninth
		};
		// ConvolveOp代表一個模糊處理，它將原圖片的每一個像素與周圍
		// 像素的顏色進行混合，從而運算出當前像素的顏色值，
		operation = new ConvolveOp(
			new Kernel(3, 3, blurKernel),
			ConvolveOp.EDGE_NO_OP, null);
	}
	public void paint(Graphics g, JComponent c)
	{
		int w = c.getWidth();
		int h = c.getHeight();
		// 如果被裝飾視窗大小為0X0,直接返回
		if (w == 0 || h == 0)
			return;
		// 如果screenBlurImage沒有初始化，或它的尺寸不對。
		if (screenBlurImage == null
			|| screenBlurImage.getWidth() != w
			|| screenBlurImage.getHeight() != h)
		{
			// 重新增立新的BufferdImage
			screenBlurImage = new BufferedImage(w
				, h , BufferedImage.TYPE_INT_RGB);
		}
		Graphics2D ig2 = screenBlurImage.createGraphics();
		// 把被裝飾元件的介面繪製到當前screenBlurImage上
		ig2.setClip(g.getClip());
		super.paint(ig2, c);
		ig2.dispose();
		Graphics2D g2 = (Graphics2D)g;
		// 對JLayer裝飾的元件進行模糊處理
		g2.drawImage(screenBlurImage, operation, 0, 0);
	}
}
class SpotlightLayerUI extends LayerUI<JComponent>
{
	private boolean active;
	private int cx, cy;

	public void installUI(JComponent c)
	{
		super.installUI(c);
		JLayer layer = (JLayer)c;
		// 設置JLayer可以回應滑鼠、滑鼠動作事件
		layer.setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK
			| AWTEvent.MOUSE_MOTION_EVENT_MASK);
	}
	public void uninstallUI(JComponent c)
	{
		JLayer layer = (JLayer)c;
		// 設置JLayer不回應任何事件
		layer.setLayerEventMask(0);
		super.uninstallUI(c);
	}
	public void paint(Graphics g, JComponent c)
	{
		Graphics2D g2 = (Graphics2D)g.create();
		super.paint (g2, c);
		// 如果處於啟動狀態
		if (active)
		{
			// 定義一個cx、cy位置的點
			Point2D center = new Point2D.Float(cx, cy);
			float radius = 72;
			float[] dist = {0.0f, 1.0f};
			Color[] colors = {Color.YELLOW , Color.BLACK};
			// 以center為中心、colors為顏色陣列建立環形漸變
			RadialGradientPaint p = new RadialGradientPaint(center
				, radius , dist , colors);
			g2.setPaint(p);
			// 設置漸變效果
			g2.setComposite(AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER, .6f));
			// 繪製矩形
			g2.fillRect(0, 0, c.getWidth(), c.getHeight());
		}
		g2.dispose();
	}

	// 處理滑鼠事件的方法
	public void processMouseEvent(MouseEvent e, JLayer layer)
	{
		if (e.getID() == MouseEvent.MOUSE_ENTERED)
			active = true;
		if (e.getID() == MouseEvent.MOUSE_EXITED)
			active = false;
		layer.repaint();
	}
	// 處理滑鼠動作事件的方法
	public void processMouseMotionEvent(MouseEvent e, JLayer layer)
	{
		Point p = SwingUtilities.convertPoint(
			e.getComponent(), e.getPoint(), layer);
		// 獲取滑鼠動作事件的發生點的座標
		cx = p.x;
		cy = p.y;
		layer.repaint();
	}
}
public class JLayerTest
{
	public void init()
	{
		JFrame f = new JFrame("JLayer測試");
		JPanel p = new JPanel();
		ButtonGroup group = new ButtonGroup();
		JRadioButton radioButton;
		// 建立3個RadioButton，並將它們添加成一組
		p.add(radioButton = new JRadioButton("網購購買", true));
		group.add(radioButton);
		p.add(radioButton = new JRadioButton("書店購買"));
		group.add(radioButton);
		p.add(radioButton = new JRadioButton("圖書館借閱"));
		group.add(radioButton);
		// 添加3個JCheckBox
		p.add(new JCheckBox("瘋狂Java講義"));
		p.add(new JCheckBox("瘋狂Android講義"));
		p.add(new JCheckBox("瘋狂Ajax講義"));
		p.add(new JCheckBox("輕量級Java EE企業應用"));
		JButton orderButton = new JButton("投票");
		p.add(orderButton);
		// 建立LayerUI物件
		LayerUI<JComponent> layerUI = new SpotlightLayerUI();     // ②
		// 使用layerUI來裝飾指定的JPanel元件
		JLayer<JComponent> layer = new JLayer<JComponent>(p, layerUI);
		// 將裝飾後的JPanel元件添加到容器中
		f.add(layer);
		f.setSize(300, 170);
		f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		f.setVisible (true);
	}
	public static void main(String[] args)
	{
		new JLayerTest().init();
	}
}