
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
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
public class Gobang
{
	// 下面三個點陣圖分別代表棋盤、黑子、白子
	BufferedImage table;
	BufferedImage black;
	BufferedImage white;
	// 當滑鼠移動時候的選擇框
	BufferedImage selected;
	// 定義棋盤的大小
	private static int BOARD_SIZE = 15;
	// 定義棋盤寬、高多少個像素
	private final int TABLE_WIDTH = 535;
	private final int TABLE_HETGHT = 536;
	// 定義棋盤座標的像素值和棋盤陣列之間的比率。
	private final int RATE = TABLE_WIDTH / BOARD_SIZE;
	// 定義棋盤座標的像素值和棋盤陣列之間的偏移距。
	private final int X_OFFSET = 5;
	private final int Y_OFFSET = 6;
	// 定義一個二維陣列來充當棋盤
	private String[][] board = new String[BOARD_SIZE][BOARD_SIZE];
	// 五子棋遊戲的視窗
	JFrame f = new JFrame("五子棋遊戲");
	// 五子棋遊戲棋盤對應的Canvas元件
	ChessBoard chessBoard = new ChessBoard();
	// 當前選取點的座標
	private int selectedX = -1;
	private int selectedY = -1;
	public void init()throws Exception
	{
		table = ImageIO.read(new File("image/board.jpg"));
		black = ImageIO.read(new File("image/black.gif"));
		white = ImageIO.read(new File("image/white.gif"));
		selected = ImageIO.read(new File("image/selected.gif"));
		// 把每個元素賦為"╋"，"╋"代表沒有棋子
		for (int i = 0 ; i < BOARD_SIZE ; i++)
		{
			for ( int j = 0 ; j < BOARD_SIZE ; j++)
			{
				board[i][j] = "╋";
			}
		}
		chessBoard.setPreferredSize(new Dimension(
			TABLE_WIDTH , TABLE_HETGHT));
		chessBoard.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// 將使用者滑鼠事件的座標轉換成棋子陣列的座標。
				int xPos = (int)((e.getX() - X_OFFSET) / RATE);
				int yPos = (int)((e.getY() - Y_OFFSET ) / RATE);
				board[xPos][yPos] = "●";
				/*
				電腦隨機產生兩個整數，作為電腦下棋的座標，賦給board陣列。
				還涉及:
				1.如果下棋的點已經有棋子，不能重複下棋。
				2.每次下棋後，需要掃描誰贏了
				*/
				chessBoard.repaint();
			}
			// 當滑鼠結束棋盤區後，重設選取點座標
			public void mouseExited(MouseEvent e)
			{
				selectedX = -1;
				selectedY = -1;
				chessBoard.repaint();
			}
		});
		chessBoard.addMouseMotionListener(new MouseMotionAdapter()
		{
			// 當滑鼠移動時，改變選取點的座標
			public void mouseMoved(MouseEvent e)
			{
				selectedX = (e.getX() - X_OFFSET) / RATE;
				selectedY = (e.getY() - Y_OFFSET) / RATE;
				chessBoard.repaint();
			}
		});
		f.add(chessBoard);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)throws Exception
	{
		Gobang gb = new Gobang();
		gb.init();
	}
	class ChessBoard extends JPanel
	{
		// 覆寫JPanel的paint方法，實作繪畫
		public void paint(Graphics g)
		{
			// 將繪製五子棋棋盤
			g.drawImage(table , 0 , 0 , null);
			// 繪製選取點的紅框
			if (selectedX >= 0 && selectedY >= 0)
				g.drawImage(selected , selectedX * RATE + X_OFFSET ,
			selectedY * RATE + Y_OFFSET, null);
			// 遍歷陣列，繪製棋子。
			for (int i = 0 ; i < BOARD_SIZE ; i++)
			{
				for ( int j = 0 ; j < BOARD_SIZE ; j++)
				{
					// 繪製黑棋
					if (board[i][j].equals("●"))
					{
						g.drawImage(black , i * RATE + X_OFFSET
							, j * RATE + Y_OFFSET, null);
					}
					// 繪製白棋
					if (board[i][j].equals("○"))
					{
						g.drawImage(white, i * RATE  + X_OFFSET
							, j * RATE  + Y_OFFSET, null);
					}
				}
			}
		}
	}
}
