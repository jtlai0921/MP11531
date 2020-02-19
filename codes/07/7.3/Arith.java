
import java.math.*;
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
public class Arith
{
	// 預設除法運算精度
	private static final int DEF_DIV_SCALE = 10;
	// 建構子私有，讓這個類別不能實例化
	private Arith()	{}
	// 提供精確的加法運算。
	public static double add(double v1,double v2)
	{
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.add(b2).doubleValue();
	}
	// 提供精確的減法運算。
	public static double sub(double v1,double v2)
	{
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.subtract(b2).doubleValue();
	}
	// 提供精確的乘法運算。
	public static double mul(double v1,double v2)
	{
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.multiply(b2).doubleValue();
	}
	// 提供（相對）精確的除法運算，當發生除不盡的情況時.
	// 精確到小數點以後10位的數字四捨五入。
	public static double div(double v1,double v2)
	{
		BigDecimal b1 = BigDecimal.valueOf(v1);
		BigDecimal b2 = BigDecimal.valueOf(v2);
		return b1.divide(b2 , DEF_DIV_SCALE
			, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	public static void main(String[] args)
	{
		System.out.println("0.05 + 0.01 = "
			+ Arith.add(0.05 , 0.01));
		System.out.println("1.0 - 0.42 = "
			+ Arith.sub(1.0 , 0.42));
		System.out.println("4.015 * 100 = "
			+ Arith.mul(4.015 , 100));
		System.out.println("123.3 / 100 = "
			+ Arith.div(123.3 , 100));
	}
}
