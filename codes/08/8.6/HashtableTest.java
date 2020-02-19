
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

class A
{
	int count;
	public A(int count)
	{
		this.count = count;
	}
	// 根據count的值來判斷兩個物件是否相等。
	public boolean equals(Object obj)
	{
		if (obj == this)
			return true;
		if (obj != null && obj.getClass() == A.class)
		{
			A a = (A)obj;
			return this.count == a.count;
		}
		return false;
	}
	// 根據count來運算hashCode值。
	public int hashCode()
	{
		return this.count;
	}
}
class B
{
	// 覆寫equals()方法，B物件與任何物件通過equals()方法比較都返回true
	public boolean equals(Object obj)
	{
		return true;
	}
}
public class HashtableTest
{
	public static void main(String[] args)
	{
		Hashtable ht = new Hashtable();
		ht.put(new A(60000) , "瘋狂Java講義");
		ht.put(new A(87563) , "輕量級Java EE企業應用實戰");
		ht.put(new A(1232) , new B());
		System.out.println(ht);
		// 只要兩個物件通過equals比較返回true，
		// Hashtable就認為它們是相等的value。
		// 由於Hashtable中有一個B物件，
		// 它與任何物件通過equals比較都相等，所以下面輸出true。
		System.out.println(ht.containsValue("測試字串")); // ① 輸出true
		// 只要兩個A物件的count相等，它們通過equals比較返回true，且hashCode相等
		// Hashtable即認為它們是相同的key，所以下面輸出true。
		System.out.println(ht.containsKey(new A(87563)));   // ② 輸出true
		// 下面語句可以刪除最後一個key-value對
		ht.remove(new A(1232));    //③
		System.out.println(ht);
	}
}
