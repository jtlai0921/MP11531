
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
public class ScrollPaneTest
{
	public static void main(String[] args)
	{
		Frame f = new Frame("測試視窗");
		// 建立一個ScrollPane容器，指定總是具有捲軸
		ScrollPane sp = new ScrollPane(
			ScrollPane.SCROLLBARS_ALWAYS);
		// 向ScrollPane容器中添加兩個元件
		sp.add(new TextField(20));
		sp.add(new Button("單擊我"));
		// 將ScrollPane容器添加到Frame物件中
		f.add(sp);
		// 設置視窗的大小、位置
		f.setBounds(30, 30 , 250, 120);
		// 將視窗顯示出來（Frame物件預設處於隱藏狀態）
		f.setVisible(true);
	}
}

