
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
public class EnumSetTest2
{
	public static void main(String[] args)
	{
		Collection c = new HashSet();
		c.clear();
		c.add(Season.FALL);
		c.add(Season.SPRING);
		// 複製Collection集合中所有元素來建立EnumSet集合
		EnumSet enumSet = EnumSet.copyOf(c);   // ①
		System.out.println(enumSet); // 輸出[SPRING,FALL]
		c.add("瘋狂Java講義");
		c.add("輕量級Java EE企業應用實戰");
		// 下面程式碼出現異常：因為c集合裡的元素不是全部都為列舉值
		enumSet = EnumSet.copyOf(c);  // ②
	}
}
