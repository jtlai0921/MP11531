
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
public class DiamondTest
{
	public static void main(String[] args)
	{
		// Java自動推斷出ArrayList的<>裡應該是String
		List<String> books = new ArrayList<>();
		books.add("瘋狂Java講義");
		books.add("瘋狂Android講義");
		// 遍歷books集合，集合元素就是String類型
		books.forEach(ele -> System.out.println(ele.length()));
		// Java自動推斷出HashMap的<>裡應該是String , List<String>
		Map<String , List<String>> schoolsInfo = new HashMap<>();
		// Java自動推斷出ArrayList的<>裡應該是String
		List<String> schools = new ArrayList<>();
		schools.add("斜月三星洞");
		schools.add("西天取經路");
		schoolsInfo.put("孫悟空" , schools);
		// 遍歷Map時，Map的key是String類型，value是List<String>類型
		schoolsInfo.forEach((key , value) -> System.out.println(key + "-->" + value));
	}
}
