
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
public class ShowHand
{
	// 定義該遊戲最多支援多少個玩家
	private final int PLAY_NUM = 5;
	// 定義撲克牌的所有花色和數值.
	private String[] types = {"方塊" , "梅花" ,"紅心"  , "黑桃"};
	private String[] values = {"2" , "3" , "4" , "5"
		, "6" , "7" , "8" , "9", "10"
		, "J" , "Q" , "K" , "A"};
	// cards是一局遊戲中剩下的撲克牌
	private List<String> cards = new LinkedList<String>();
	// 定義所有的玩家
	private String[] players = new String[PLAY_NUM];
	// 所有玩家手上的撲克牌
	private List<String>[] playersCards = new List[PLAY_NUM];
	/**
	 * 初始化撲克牌，放入52張撲克牌，
	 * 並且使用shuffle方法將它們按隨機順序排列
	 */
	public void initCards()
	{
		for (int i = 0 ; i < types.length ; i++ )
		{
			for (int j = 0; j < values.length ; j++ )
			{
				cards.add(types[i] + values[j]);
			}
		}
		// 隨機排列
		Collections.shuffle(cards);
	}
	/**
	 * 初始化玩家，為每個玩家分派使用者名稱。
	 */
	public void initPlayer(String... names)
	{
		if (names.length > PLAY_NUM || names.length < 2)
		{
			// 校驗玩家數量，此處使用異常機制更合理
			System.out.println("玩家數量不對");
			return ;
		}
		else
		{
			// 初始化玩家使用者名稱
			for (int i = 0; i < names.length ; i++ )
			{
				players[i] = names[i];
			}
		}
	}
	/**
	 * 初始化玩家手上的撲克牌，開始遊戲時每個玩家手上的撲克牌為空，
	 * 程式使用一個長度為0的LinkedList來表示。
	 */
	public void initPlayerCards()
	{
		for (int i = 0; i < players.length ; i++ )
		{
			if (players[i] != null && !players[i].equals(""))
			{
				playersCards[i] = new LinkedList<String>();
			}
		}
	}
	/**
	 * 輸出全部撲克牌，該方法沒有實際作用，僅用作測試
	 */
	public void showAllCards()
	{
		for (String card : cards )
		{
			System.out.println(card);
		}
	}
	/**
	 * 派撲克牌
	 * @param first 最先派給誰
	 */
	public void deliverCard(String first)
	{
		// 呼叫ArrayUtils工具類別的search方法，
		// 查詢出指定元素在陣列中的索引
		int firstPos = ArrayUtils.search(players , first);
		// 依次給位於該指定玩家之後的每個玩家派撲克牌
		for (int i = firstPos; i < PLAY_NUM ; i ++)
		{
			if (players[i] != null)
			{
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
		// 依次給位於該指定玩家之前的每個玩家派撲克牌
		for (int i = 0; i < firstPos ; i ++)
		{
			if (players[i] != null)
			{
				playersCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
	}
	/**
	 * 輸出玩家手上的撲克牌
	 * 實作該方法時，應該控制每個玩家看不到別人的第一張牌，但此處沒有增加該功能
	 */
	public void showPlayerCards()
	{
		for (int i = 0; i < PLAY_NUM ; i++ )
		{
			// 當該玩家不為空時
			if (players[i] != null)
			{
				// 輸出玩家
				System.out.print(players[i] + " ： " );
				// 遍歷輸出玩家手上的撲克牌
				for (String card : playersCards[i])
				{
					System.out.print(card + "\t");
				}
			}
			System.out.print("\n");
		}
	}
	public static void main(String[] args)
	{
		ShowHand sh = new ShowHand();
		sh.initPlayer("電腦玩家" , "孫悟空");
		sh.initCards();
		sh.initPlayerCards();
		// 下面測試所有撲克牌，沒有實際作用
		sh.showAllCards();
		System.out.println("---------------");
		// 下面從"孫悟空"開始派牌
		sh.deliverCard("孫悟空");
		sh.showPlayerCards();
		/*
		這個地方需要增加處理:
		1.牌面最大的玩家下注.
		2.其他玩家是否跟注?
		3.遊戲是否只剩一個玩家?如果是，則他勝利了。
		4.如果已經是最後一張撲克牌，則需要比較剩下玩家的牌面大小.
		*/
		// 再次從"電腦玩家"開始派牌
		sh.deliverCard("電腦玩家");
		sh.showPlayerCards();
	}
}
