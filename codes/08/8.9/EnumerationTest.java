
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
public class EnumerationTest
{
	public static void main(String[] args)
	{
		Vector v = new Vector();
		v.add("瘋狂Java講義");
		v.add("輕量級Java EE企業應用實戰");
		Hashtable scores = new Hashtable();
		scores.put("語文" , 78);
		scores.put("數學" , 88);
		Enumeration em = v.elements();
		while (em.hasMoreElements())
		{
			System.out.println(em.nextElement());
		}
		Enumeration keyEm = scores.keys();
		while (keyEm.hasMoreElements())
		{
			Object key = keyEm.nextElement();
			System.out.println(key + "--->"
				+ scores.get(key));
		}
	}
}
