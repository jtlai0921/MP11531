

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
public class AuctionException extends Exception
{
	// 無參數的建構子
	public AuctionException(){}       //①
	// 帶一個字串參數的建構子
	public AuctionException(String msg)    //②
	{
		super(msg);
	}
}
