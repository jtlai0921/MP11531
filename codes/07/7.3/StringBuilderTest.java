

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
public class StringBuilderTest
{
	public static void main(String[] args)
	{
		StringBuilder sb = new StringBuilder();
		// 附加字串
		sb.append("java");//sb = "java"
		// 插入
		sb.insert(0 , "hello "); // sb="hello java"
		// 取代
		sb.replace(5, 6, ","); // sb="hello, java"
		// 刪除
		sb.delete(5, 6); // sb="hellojava"
		System.out.println(sb);
		// 反轉
		sb.reverse(); // sb="avajolleh"
		System.out.println(sb);
		System.out.println(sb.length()); // 輸出9
		System.out.println(sb.capacity()); // 輸出16
		// 改變StringBuilder的長度，將只保留前面部分
		sb.setLength(5); // sb="avajo"
		System.out.println(sb);
	}
}
