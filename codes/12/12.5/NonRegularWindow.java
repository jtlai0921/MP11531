
import java.io.*;

import java.awt.*;
import javax.imageio.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;
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
public class NonRegularWindow extends JFrame
	implements ActionListener
{
	// 定義3個視窗
	JFrame transWin = new JFrame("透明視窗");
	JFrame gradientWin = new JFrame("漸變透明視窗");
	JFrame bgWin = new JFrame("背景圖片視窗");
	JFrame shapeWin = new JFrame("橢圓視窗");
	public NonRegularWindow()
	{
		super("不規則視窗測試");
		setLayout(new FlowLayout());
		JButton transBn = new JButton("透明視窗");
		JButton gradientBn = new JButton("漸變透明視窗");
		JButton bgBn = new JButton("背景圖片視窗");
		JButton shapeBn = new JButton("橢圓視窗");
		// 為3個按鈕添加事件監聽器
		transBn.addActionListener(this);
		gradientBn.addActionListener(this);
		bgBn.addActionListener(this);
		shapeBn.addActionListener(this);
		add(transBn);
		add(gradientBn);
		add(bgBn);
		add(shapeBn);
		//-------設置透明視窗-------
		transWin.setLayout(new GridBagLayout());
		transWin.setSize(300,200);
		transWin.add(new JButton("透明視窗裡的簡單按鈕"));
		// 設置透明度為0.65f，透明度為1時完全不透明。
		transWin.setOpacity(0.65f);
		//-------設置漸變透明的視窗-------
		gradientWin.setBackground(new Color(0,0,0,0));
		gradientWin.setSize(new Dimension(300,200));
		// 使用一個JPanel物件作為漸變透明的背景
		JPanel panel = new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				if (g instanceof Graphics2D)
				{
					final int R = 240;
					final int G = 240;
					final int B = 240;
					// 建立一個漸變畫筆
					Paint p = new GradientPaint(0.0f, 0.0f
						, new Color(R, G, B, 0)
						, 0.0f, getHeight()
						, new Color(R, G, B, 255) , true);
					Graphics2D g2d = (Graphics2D)g;
					g2d.setPaint(p);
					g2d.fillRect(0, 0, getWidth(), getHeight());
				}
			}
		};
		// 使用JPanel物件作為JFrame的contentPane
		gradientWin.setContentPane(panel);
		panel.setLayout(new GridBagLayout());
		gradientWin.add(new JButton("漸變透明視窗裡的簡單按鈕"));
		//-------設置有背景圖片的視窗-------
		bgWin.setBackground(new Color(0,0,0,0));
		bgWin.setSize(new Dimension(300,200));
		// 使用一個JPanel物件作為背景圖片
		JPanel bgPanel = new JPanel()
		{
			protected void paintComponent(Graphics g)
			{
				try
				{
					Image bg = ImageIO.read(new File("images/java.png"));
					// 繪製一張圖片作為背景
					g.drawImage(bg , 0 , 0 , getWidth() , getHeight() ,  null);
				}
				catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		};
		// 使用JPanel物件作為JFrame的contentPane
		bgWin.setContentPane(bgPanel);
		bgPanel.setLayout(new GridBagLayout());
		bgWin.add(new JButton("有背景圖片視窗裡的簡單按鈕"));
		//-------設置橢圓形視窗-------
		shapeWin.setLayout(new GridBagLayout());
		shapeWin.setUndecorated(true);
		shapeWin.setOpacity(0.7f);
		// 通過為shapeWin添加監聽器來設置視窗的形狀。
		// 當shapeWin視窗的大小被改變時，程式動態設置該視窗的形狀
		shapeWin.addComponentListener(new ComponentAdapter()
		{
			// 當視窗大小被改變時，橢圓的大小也會相應地改變
			public void componentResized(ComponentEvent e)
			{
				// 設置視窗的形狀
				shapeWin.setShape(new Ellipse2D.Double(0 , 0
					, shapeWin.getWidth() , shapeWin.getHeight()));  // ①
			}
		});
		shapeWin.setSize(300,200);
		shapeWin.add(new JButton("橢圓形視窗裡的簡單按鈕"));
		//-------設置主程式的視窗-------
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	public void actionPerformed(ActionEvent event)
	{
		switch(event.getActionCommand())
		{
			case "透明視窗":
				transWin.setVisible(true);
				break;
			case "漸變透明視窗":
				gradientWin.setVisible(true);
				break;
			case "背景圖片視窗":
				bgWin.setVisible(true);
				break;
			case "橢圓視窗":
				shapeWin.setVisible(true);
				break;
		}
	}
	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);
		new NonRegularWindow();
	}
}
