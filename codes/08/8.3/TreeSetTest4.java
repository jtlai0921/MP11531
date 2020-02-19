
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
class M
{
	int age;
	public M(int age)
	{
		this.age = age;
	}
	public String toString()
	{
		return "M[age:" + age + "]";
	}
}
public class TreeSetTest4
{
	public static void main(String[] args)
	{
		// 此處Lambda運算式的目標類型是Comparator
		TreeSet ts = new TreeSet((o1 , o2) ->
		{
			M m1 = (M)o1;
			M m2 = (M)o2;
			// 根據M物件的age屬性來決定大小，age越大，M物件反而越小
			return m1.age > m2.age ? -1
				: m1.age < m2.age ? 1 : 0;
		});
		ts.add(new M(5));
		ts.add(new M(-3));
		ts.add(new M(9));
		System.out.println(ts);
	}
}

