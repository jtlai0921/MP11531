
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
class R
{
	int count;
	public R(int count)
	{
		this.count = count;
	}
	public String toString()
	{
		return "R[count:" + count + "]";
	}
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if (obj != null && obj.getClass() == R.class)
		{
			R r = (R)obj;
			return this.count == r.count;
		}
		return false;
	}
	public int hashCode()
	{
		return this.count;
	}
}
public class HashSetTest2
{
	public static void main(String[] args)
	{
		HashSet hs = new HashSet();
		hs.add(new R(5));
		hs.add(new R(-3));
		hs.add(new R(9));
		hs.add(new R(-2));
		// 列印HashSet集合，集合元素沒有重複
		System.out.println(hs);
		// 取出第一個元素
		Iterator it = hs.iterator();
		R first = (R)it.next();
		// 為第一個元素的count實例變數賦值
		first.count = -3;     // ①
		// 再次輸出HashSet集合，集合元素有重復元素
		System.out.println(hs);
		// 刪除count為-3的R物件
		hs.remove(new R(-3));    // ②
		// 可以看到被刪除了一個R元素
		System.out.println(hs);
		System.out.println("hs是否包含count為-3的R物件？"
			+ hs.contains(new R(-3))); // 輸出false
		System.out.println("hs是否包含count為-2的R物件？"
			+ hs.contains(new R(-2))); // 輸出false
	}
}