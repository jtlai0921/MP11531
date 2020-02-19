
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
public class IdentityHashMapTest
{
	public static void main(String[] args)
	{
		IdentityHashMap ihm = new IdentityHashMap();
		// 下面兩行程式碼將會向IdentityHashMap物件中添加兩個key-value對
		ihm.put(new String("語文") , 89);
		ihm.put(new String("語文") , 78);
		// 下面兩行程式碼只會向IdentityHashMap物件中添加一個key-value對
		ihm.put("java" , 93);
		ihm.put("java" , 98);
		System.out.println(ihm);
	}
}
