
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
public class MapTest2
{
	public static void main(String[] args)
	{
		Map map = new HashMap();
		// 成對放入多個key-value對
		map.put("瘋狂Java講義" , 109);
		map.put("瘋狂iOS講義" , 99);
		map.put("瘋狂Ajax講義" , 79);
		// 嘗試替換key為"瘋狂XML講義"的value，由於原Map中沒有對應的key，
		// 因此對Map沒有改變，不會添加新的key-value對
		map.replace("瘋狂XML講義" , 66);
		System.out.println(map);
		// 使用原value與參數運算出來的結果覆蓋原有的value
		map.merge("瘋狂iOS講義" , 10 ,
			(oldVal , param) -> (Integer)oldVal + (Integer)param);
		System.out.println(map); // "瘋狂iOS講義"的value增大了10
		// 當key為"Java"對應的value為null（或不存在時），使用運算的結果作為新value
		map.computeIfAbsent("Java" , (key)->((String)key).length());
		System.out.println(map); // map中添加了 Java=4 這組key-value對
		// 當key為"Java"對應的value存在時，使用運算的結果作為新value
		map.computeIfPresent("Java",
			(key , value) -> (Integer)value * (Integer)value);
		System.out.println(map); // map中 Java=4 變成 Java=16
	}
}
