
import java.util.Random;
import java.awt.*;
import javax.swing.*;
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
public class PinBall
{
	// 桌面的寬度
	private final int TABLE_WIDTH = 300;
	// 桌面的高度
	private final int TABLE_HEIGHT = 400;
	// 球拍的垂直位置
	private final int RACKET_Y = 340;
	// 下面定義球拍的高度和寬度
	private final int RACKET_HEIGHT = 20;
	private final int RACKET_WIDTH = 60;
	// 小球的大小
	private final int BALL_SIZE = 16;
	private Frame f = new Frame("彈珠遊戲");
	Random rand = new Random();
	// 小球縱向的運行速度
	private int ySpeed = 10;
	// 返回一個-0.5~0.5的比率，用於控制小球的運行方向。
	private double xyRate = rand.nextDouble() - 0.5;
	// 小球橫向的運行速度
	private int xSpeed = (int)(ySpeed * xyRate * 2);
	// ballX和ballY代表小球的座標
	private int ballX = rand.nextInt(200) + 20;
	private int ballY = rand.nextInt(10) + 20;
	// racketX代表球拍的水平位置
	private int racketX = rand.nextInt(200);
	private MyCanvas tableArea = new MyCanvas();
	Timer timer;
	// 遊戲是否結束的旗標
	private boolean isLose = false;
	public void init()
	{
		// 設置桌面區域的最佳大小
		tableArea.setPreferredSize(
			new Dimension(TABLE_WIDTH , TABLE_HEIGHT));
		f.add(tableArea);
		// 定義鍵盤監聽器
		KeyAdapter keyProcessor = new KeyAdapter()
		{
			public void keyPressed(KeyEvent ke)
			{
				// 按下向左、向右鍵時，球拍水平座標分別減少、增加
				if (ke.getKeyCode() == KeyEvent.VK_LEFT)
				{
					if (racketX > 0)
					racketX -= 10;
				}
				if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					if (racketX < TABLE_WIDTH - RACKET_WIDTH)
					racketX += 10;
				}
			}
		};
		// 為視窗和tableArea物件分別添加鍵盤監聽器
		f.addKeyListener(keyProcessor);
		tableArea.addKeyListener(keyProcessor);
		// 定義每0.1秒執行一次的事件監聽器。
		ActionListener taskPerformer = evt ->
		{
			// 如果小球碰到左邊邊框
			if (ballX  <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE)
			{
				xSpeed = -xSpeed;
			}
			// 如果小球高度超出了球拍位置，且橫向不在球拍範圍之內，遊戲結束。
			if (ballY >= RACKET_Y - BALL_SIZE &&
				(ballX < racketX || ballX > racketX + RACKET_WIDTH))
			{
				timer.stop();
				// 設置遊戲是否結束的旗標為true。
				isLose = true;
				tableArea.repaint();
			}
			// 如果小球位於球拍之內，且到達球拍位置，小球反彈
			else if (ballY  <= 0 ||
				(ballY >= RACKET_Y - BALL_SIZE
					&& ballX > racketX && ballX <= racketX + RACKET_WIDTH))
			{
				ySpeed = -ySpeed;
			}
			// 小球座標增加
			ballY += ySpeed;
			ballX += xSpeed;
			tableArea.repaint();
		};
		timer = new Timer(100, taskPerformer);
		timer.start();
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new PinBall().init();
	}
	class MyCanvas extends Canvas
	{
		// 覆寫Canvas的paint方法，實作繪畫
		public void paint(Graphics g)
		{
			// 如果遊戲已經結束
			if (isLose)
			{
				g.setColor(new Color(255, 0, 0));
				g.setFont(new Font("Times" , Font.BOLD, 30));
				g.drawString("遊戲已結束！" , 50 ,200);
			}
			// 如果遊戲還未結束
			else
			{
				// 設置顏色，並繪製小球
				g.setColor(new Color(240, 240, 80));
				g.fillOval(ballX , ballY , BALL_SIZE, BALL_SIZE);
				// 設置顏色，並繪製球拍
				g.setColor(new Color(80, 80, 200));
				g.fillRect(racketX , RACKET_Y
					, RACKET_WIDTH , RACKET_HEIGHT);
			}
		}
	}
}