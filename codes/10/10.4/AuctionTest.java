

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
public class AuctionTest
{
	private double initPrice = 30.0;
	// 因為該方法中顯式拋出了AuctionException異常，
	// 所以此處需要宣告拋出AuctionException異常
	public void bid(String bidPrice)
		throws AuctionException
	{
		double d = 0.0;
		try
		{
			d = Double.parseDouble(bidPrice);
		}
		catch (Exception e)
		{
			// 此處完成本方法中可以對異常執行的修復處理，
			// 此處僅僅是在主控台列印異常追蹤堆疊資訊。
			e.printStackTrace();
			// 再次拋出自訂異常
			throw new AuctionException("競拍價必須是數值，"
				+ "不能包含其他字元！");
		}
		if (initPrice > d)
		{
			throw new AuctionException("競拍價比起拍價低，"
				+ "不允許競拍！");
		}
		initPrice = d;
	}
	public static void main(String[] args)
	{
		AuctionTest at = new AuctionTest();
		try
		{
			at.bid("df");
		}
		catch (AuctionException ae)
		{
			// 再次捕捉到bid方法中的異常。並對該異常進行處理
			System.err.println(ae.getMessage());
		}
	}
}
