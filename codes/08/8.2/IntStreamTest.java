
import java.util.stream.*;
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
public class IntStreamTest
{
	public static void main(String[] args)
	{
		IntStream is = IntStream.builder()
			.add(20)
			.add(13)
			.add(-2)
			.add(18)
			.build();
		// 下面呼叫聚集方法的程式碼每次只能執行一個
		System.out.println("is所有元素的最大值：" + is.max().getAsInt());
		System.out.println("is所有元素的最小值：" + is.min().getAsInt());
		System.out.println("is所有元素的總和：" + is.sum());
		System.out.println("is所有元素的總數：" + is.count());
		System.out.println("is所有元素的平均值：" + is.average());
		System.out.println("is所有元素的平方是否都大於20:"
			+ is.allMatch(ele -> ele * ele > 20));
		System.out.println("is是否包含任何元素的平方大於20:"
			+ is.anyMatch(ele -> ele * ele > 20));
		// 將is對應成一個新Stream，新Stream的每個元素是原Stream元素的2倍+1
		IntStream newIs = is.map(ele -> ele * 2 + 1);
		// 使用方法參照的方式來遍歷集合元素
		newIs.forEach(System.out::println); // 輸出41 27 -3 37
	}
}
