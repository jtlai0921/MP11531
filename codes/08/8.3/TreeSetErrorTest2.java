
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
public class TreeSetErrorTest2
{
	public static void main(String[] args)
	{
		TreeSet ts = new TreeSet();
		// 向TreeSet集合中添加兩個物件
		ts.add(new String("瘋狂Java講義"));
		ts.add(new Date());   // ①
	}
}
