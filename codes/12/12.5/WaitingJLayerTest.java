
import java.beans.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.plaf.LayerUI;
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
class WaitingLayerUI extends LayerUI<JComponent>
{
	private boolean isRunning;
	private Timer timer;
	// 記錄轉過的角度
	private int angle;      // ①
	public void paint(Graphics g, JComponent c)
	{
		super.paint(g, c);
		int w = c.getWidth();
		int h = c.getHeight();
		// 已經停止運行，直接返回
		if (!isRunning)
			return;
		Graphics2D g2 = (Graphics2D)g.create();
		Composite urComposite = g2.getComposite();
		g2.setComposite(AlphaComposite.getInstance(
			AlphaComposite.SRC_OVER, .5f));
		// 填充矩形
		g2.fillRect(0, 0, w, h);
		g2.setComposite(urComposite);
		// -----下面程式碼開始繪製轉動中的「齒輪」----
		// 運算得到寬、高中較小值的1/5
		int s = Math.min(w , h) / 5;
		int cx = w / 2;
		int cy = h / 2;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING
			, RenderingHints.VALUE_ANTIALIAS_ON);
		// 設置筆觸
		g2.setStroke( new BasicStroke(s / 2
			, BasicStroke.CAP_ROUND , BasicStroke.JOIN_ROUND));
		g2.setPaint(Color.BLUE);
		// 畫筆繞被裝飾元件的中心轉過angle度
		g2.rotate(Math.PI * angle / 180, cx, cy);
		// 迴圈繪製12條線條，形成「齒輪」
		for (int i = 0; i < 12; i++)
		{
			float scale = (11.0f - (float)i) / 11.0f;
			g2.drawLine(cx + s, cy, cx + s * 2, cy);
			g2.rotate(-Math.PI / 6, cx, cy);
			g2.setComposite(AlphaComposite.getInstance(
				AlphaComposite.SRC_OVER, scale));
		}
		g2.dispose();
	}
	// 控制等待（齒輪開始轉動）的方法
	public void start()
	{
		// 如果已經在運行中，直接返回
		if (isRunning)
			return;
		isRunning = true;
		// 每隔0.1秒重繪一次
		timer = new Timer(100, e -> {
			if (isRunning)
			{
				// 觸發applyPropertyChange()方法，讓JLayer重繪。
				// 在這行程式碼中，後面兩個參數沒有意義。
				firePropertyChange("crazyitFlag", 0 , 1);
				// 角度加6
				angle += 6;      // ②
				// 到達360後再從0開始
				if (angle >= 360)
					angle = 0;
			}
		});
		timer.start();
	}
	// 控制停止等待（齒輪停止轉動）的方法
	public void stop()
	{
		isRunning = false;
		// 最後通知JLayer重繪一次，清除曾經繪製的圖形
		firePropertyChange("crazyitFlag", 0 , 1);
		timer.stop();
	}
	public void applyPropertyChange(PropertyChangeEvent pce
		, JLayer layer)
	{
		// 控制JLayer重繪
		if (pce.getPropertyName().equals("crazyitFlag"))
		{
			layer.repaint();
		}
	}
}
public class WaitingJLayerTest
{
	public void init()
	{
		JFrame f = new JFrame("轉動的「齒輪」");
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
		final WaitingLayerUI layerUI = new WaitingLayerUI();
		// 使用layerUI來裝飾指定JPanel元件
		JLayer<JComponent> layer = new JLayer<JComponent>(p, layerUI);
		// 設置4秒之後執行指定動作：呼叫layerUI的stop()方法
		final Timer stopper = new Timer(4000, ae -> layerUI.stop());
		// 設置stopper定時器只觸發一次。
		stopper.setRepeats(false);
		// 為orderButton綁定事件監聽器：單擊該按鈕時:呼叫layerUI的start()方法
		orderButton.addActionListener(ae -> {
			layerUI.start();
			// 如果stopper定時器已停止，啟動它
			if (!stopper.isRunning())
			{
				stopper.start();
			}
		});
		// 將裝飾後的JPanel元件添加到容器中
		f.add(layer);
		f.setSize(300, 170);
		f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		f.setVisible (true);
	}
	public static void main(String[] args)
	{
		new WaitingJLayerTest().init();
	}
}