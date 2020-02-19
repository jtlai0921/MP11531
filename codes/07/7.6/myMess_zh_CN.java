
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
public class myMess_zh_CN extends ListResourceBundle
{
	// 定義資源
	private final Object myData[][]=
	{
		{"msg","{0}，你好！今天的日期是{1}"}
	};
	// 覆寫方法getContents()
	public Object[][] getContents()
	{
		// 該方法返回資源的key-value對
		return myData;
	}
}
