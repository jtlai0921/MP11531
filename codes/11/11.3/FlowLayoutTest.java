
import java.awt.*;
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
public class FlowLayoutTest
{
	public static void main(String[] args)
	{
		Frame f = new Frame("測試視窗");
		// 設置Frame容器使用FlowLayout佈局管理器
		f.setLayout(new FlowLayout(FlowLayout.LEFT , 20, 5));
		// 向視窗中添加10個按鈕
		for (int i = 0; i < 10 ; i++ )
		{
			f.add(new Button("按鈕" + i));
		}
		// 設置視窗為最佳大小
		f.pack();
		// 將視窗顯示出來（Frame物件預設處於隱藏狀態）
		f.setVisible(true);
	}
}

