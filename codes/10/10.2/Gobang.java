
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
	// 定義一個二維陣列來充當棋盤
	private String[][] board;
	// 定義棋盤的大小
	private static int BOARD_SIZE = 15;
	public void initBoard()
	{
		// 初始化棋盤陣列
		board = new String[BOARD_SIZE][BOARD_SIZE];
		// 把每個元素賦為"╋"，用於在主控台畫出棋盤
		for (int i = 0 ; i < BOARD_SIZE ; i++)
		{
			for ( int j = 0 ; j < BOARD_SIZE ; j++)
			{
				board[i][j] = "╋";
			}
		}
	}
	// 在主控台輸出棋盤的方法
	public void printBoard()
	{
		// 列印每個陣列元素
		for (int i = 0 ; i < BOARD_SIZE ; i++)
		{
			for ( int j = 0 ; j < BOARD_SIZE ; j++)
			{
				// 列印陣列元素後不換行
				System.out.print(board[i][j]);
			}
			// 每列印完一行陣列元素後輸出一個換行字元
			System.out.print("\n");
		}
	}
    public static void main(String[] args)throws Exception
    {
        Gobang gb = new Gobang();
		gb.initBoard();
		gb.printBoard();
		// 這是用於獲取鍵盤輸入的方法
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));
		String inputStr = null;
		// br.readLine()：每當在鍵盤上輸入一行內容按Enter，
		// 使用者剛剛輸入的內容將被br讀取到。
		while ((inputStr = br.readLine()) != null)
		{
			try
			{
				// 將使用者輸入的字串以逗號作為分隔符，分解成2個字串
				String[] posStrArr = inputStr.split(",");
				// 將2個字串轉換成使用者下棋的座標
				int xPos = Integer.parseInt(posStrArr[0]);
				int yPos = Integer.parseInt(posStrArr[1]);
				// 把對應的陣列元素賦為"●"。
				if (!gb.board[xPos - 1][yPos - 1].equals("╋"))
				{
					System.out.println("您輸入的座標點已有棋子了，"
						+ "請重新輸入");
					continue;
				}
				gb.board[xPos - 1][yPos - 1] = "●";
			}
			catch (Exception e)
			{
				System.out.println("您輸入的座標不合法，請重新輸入，"
					+ "下棋座標應以x,y的格式");
				continue;
			}

			gb.printBoard();
			System.out.println("請輸入您下棋的座標，應以x,y的格式：");
		}
    }
}
