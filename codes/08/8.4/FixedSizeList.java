
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
public class FixedSizeList
{
	public static void main(String[] args)
	{
		List fixedList = Arrays.asList("瘋狂Java講義"
			, "輕量級Java EE企業應用實戰");
		// 獲取fixedList的實作類別，將輸出Arrays$ArrayList
		System.out.println(fixedList.getClass());
		// 使用方法參照遍歷集合元素
		fixedList.forEach(System.out::println);
		// 試圖增加、刪除元素都會引發UnsupportedOperationException異常
		fixedList.add("瘋狂Android講義");
		fixedList.remove("瘋狂Java講義");
	}
}
