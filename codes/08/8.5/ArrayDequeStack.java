
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
public class ArrayDequeStack
{
	public static void main(String[] args)
	{
		ArrayDeque stack = new ArrayDeque();
		// 依次將三個元素push入"堆疊"
		stack.push("瘋狂Java講義");
		stack.push("輕量級Java EE企業應用實戰");
		stack.push("瘋狂Android講義");
		// 輸出：[瘋狂Android講義, 輕量級Java EE企業應用實戰, 瘋狂Java講義]
		System.out.println(stack);
		// 存取第一個元素，但並不將其pop出"堆疊"，輸出：瘋狂Android講義
		System.out.println(stack.peek());
		// 依然輸出：[瘋狂Android講義, 瘋狂Java講義, 輕量級Java EE企業應用實戰]
		System.out.println(stack);
		// pop出第一個元素，輸出：瘋狂Android講義
		System.out.println(stack.pop());
		// 輸出：[輕量級Java EE企業應用實戰, 瘋狂Java講義]
		System.out.println(stack);
	}
}
