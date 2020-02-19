
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
public class ArrayErr
{
	public static void main(String[] args)
	{
		// 定義一個Integer陣列
		Integer[] ia = new Integer[5];
		// 可以把一個Integer[]陣列賦給Number[]變數
		Number[] na = ia;
		// 下面程式碼編譯正常，但運行時會引發ArrayStoreException異常
		// 因為0.5並不是Integer
		na[0] = 0.5;   // ①
		List<Integer> iList = new ArrayList<>();
		// 下面程式碼導致編譯錯誤
		List<Number> nList = iList;
	}
}
