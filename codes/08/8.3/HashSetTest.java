
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

// 類別A的equals方法總是返回true，但沒有覆寫其hashCode()方法
class A
{
	public boolean equals(Object obj)
	{
		return true;
	}
}
// 類別B的hashCode()方法總是返回1，但沒有覆寫其equals()方法
class B
{
	public int hashCode()
	{
		return 1;
	}
}
// 類別C的hashCode()方法總是返回2，且覆寫其equals()方法總是返回true
class C
{
	public int hashCode()
	{
		return 2;
	}
	public boolean equals(Object obj)
	{
		return true;
	}
}
public class HashSetTest
{
	public static void main(String[] args)
	{
		HashSet books = new HashSet();
		// 分別向books集合中添加兩個A物件，兩個B物件，兩個C物件
		books.add(new A());
		books.add(new A());
		books.add(new B());
		books.add(new B());
		books.add(new C());
		books.add(new C());
		System.out.println(books);
	}
}
