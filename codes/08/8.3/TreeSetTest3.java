
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

class R implements Comparable
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
	// 覆寫equals方法，根據count來判斷是否相等
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if(obj != null && obj.getClass() == R.class)
		{
			R r = (R)obj;
			return r.count == this.count;
		}
		return false;
	}
	// 覆寫compareTo方法，根據count來比較大小
	public int compareTo(Object obj)
	{
		R r = (R)obj;
		return count > r.count ? 1 :
			count < r.count ? -1 : 0;
	}
}
public class TreeSetTest3
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet();
		ts.add(new R(5));
		ts.add(new R(-3));
		ts.add(new R(9));
		ts.add(new R(-2));
		// 列印TreeSet集合，集合元素是有序排列的
		System.out.println(ts);    // ①
		// 取出第一個元素
		R first = (R)ts.first();
		// 對第一個元素的count賦值
		first.count = 20;
		// 取出最後一個元素
		R last = (R)ts.last();
		// 對最後一個元素的count賦值，與第二個元素的count相同
		last.count = -2;
		// 再次輸出將看到TreeSet裡的元素處於無序狀態，且有重復元素
		System.out.println(ts);   // ②
		// 刪除實例變數被改變的元素，刪除失敗
		System.out.println(ts.remove(new R(-2)));   // ③
		System.out.println(ts);
		// 刪除實例變數沒有被改變的元素，刪除成功
		System.out.println(ts.remove(new R(5)));    // ④
		System.out.println(ts);
	}
}
