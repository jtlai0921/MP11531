
import java.util.Objects;
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
public class ObjectsTest
{
	// 定義一個obj變數，它的預設值是null
	static ObjectsTest obj;
	public static void main(String[] args)
	{
		// 輸出一個null物件的hashCode值，輸出0
		System.out.println(Objects.hashCode(obj));
		// 輸出一個null物件的toString，輸出null
		System.out.println(Objects.toString(obj));
		// 要求obj不能為null，如果obj為null則引發異常
		System.out.println(Objects.requireNonNull(obj
			, "obj參數不能是null！"));
	}
}
