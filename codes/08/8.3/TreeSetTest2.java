
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

class Z implements Comparable
{
	int age;
	public Z(int age)
	{
		this.age = age;
	}
	// 覆寫equals()方法，總是返回true
	public boolean equals(Object obj)
	{
		return true;
	}
	// 覆寫了compareTo(Object obj)方法，總是返回1
	public int compareTo(Object obj)
	{
		return 1;
	}
}
public class TreeSetTest2
{
	public static void main(String[] args)
	{
		TreeSet set = new TreeSet();
		Z z1 = new Z(6);
		set.add(z1);
		// 第二次添加同一個物件，輸出true，表明添加成功
		System.out.println(set.add(z1));    //①
		// 下面輸出set集合，將看到有兩個元素
		System.out.println(set);
		// 修改set集合的第一個元素的age變數
		 ((Z)(set.first())).age = 9;
		// 輸出set集合的最後一個元素的age變數，將看到也變成了9
		System.out.println(((Z)(set.last())).age);
	}
}
