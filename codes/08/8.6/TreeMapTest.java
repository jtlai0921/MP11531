
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
	// 根據count來判斷兩個物件是否相等。
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj != null	&& obj.getClass() == R.class)
		{
			R r = (R)obj;
			return r.count == this.count;
		}
		return false;
	}
	// 根據count屬性值來判斷兩個物件的大小。
	public int compareTo(Object obj)
	{
		R r = (R)obj;
		return count > r.count ? 1 :
			count < r.count ? -1 : 0;
	}
}
public class TreeMapTest
{
	public static void main(String[] args)
	{
		TreeMap tm = new TreeMap();
		tm.put(new R(3) , "輕量級Java EE企業應用實戰");
		tm.put(new R(-5) , "瘋狂Java講義");
		tm.put(new R(9) , "瘋狂Android講義");
		System.out.println(tm);
		// 返回該TreeMap的第一個Entry物件
		System.out.println(tm.firstEntry());
		// 返回該TreeMap的最後一個key值
		System.out.println(tm.lastKey());
		// 返回該TreeMap的比new R(2)大的最小key值。
		System.out.println(tm.higherKey(new R(2)));
		// 返回該TreeMap的比new R(2)小的最大的key-value對。
		System.out.println(tm.lowerEntry(new R(2)));
		// 返回該TreeMap的子TreeMap
		System.out.println(tm.subMap(new R(-1) , new R(4)));
	}
}
