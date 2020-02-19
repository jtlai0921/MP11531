
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
enum Season
{
	SPRING,SUMMER,FALL,WINTER
}
public class EnumSetTest
{
	public static void main(String[] args)
	{
		// 建立一個EnumSet集合，集合元素就是Season列舉類別的全部列舉值
		EnumSet es1 = EnumSet.allOf(Season.class);
		System.out.println(es1); // 輸出[SPRING,SUMMER,FALL,WINTER]
		// 建立一個EnumSet空集合，指定其集合元素是Season類別的列舉值。
		EnumSet es2 = EnumSet.noneOf(Season.class);
		System.out.println(es2); // 輸出[]
		// 手動添加兩個元素
		es2.add(Season.WINTER);
		es2.add(Season.SPRING);
		System.out.println(es2); // 輸出[SPRING,WINTER]
		// 以指定列舉值建立EnumSet集合
		EnumSet es3 = EnumSet.of(Season.SUMMER , Season.WINTER);
		System.out.println(es3); // 輸出[SUMMER,WINTER]
		EnumSet es4 = EnumSet.range(Season.SUMMER , Season.WINTER);
		System.out.println(es4); // 輸出[SUMMER,FALL,WINTER]
		// 新增立的EnumSet集合的元素和es4集合的元素有相同類型，
		// es5的集合元素 + es4集合元素 = Season列舉類別的全部列舉值
		EnumSet es5 = EnumSet.complementOf(es4);
		System.out.println(es5); // 輸出[SPRING]
	}
}
