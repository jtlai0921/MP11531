
import java.awt.*;
import static java.awt.BorderLayout.*;
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
public class BorderLayoutTest2
{
	public static void main(String[] args)
	{
		Frame f = new Frame("測試視窗");
		// 設置Frame容器使用BorderLayout佈局管理器
		f.setLayout(new BorderLayout(30, 5));
		f.add(new Button("南") , SOUTH);
		f.add(new Button("北") , NORTH);
		// 建立一個Panel物件
		Panel p = new Panel();
		// 向Panel物件中添加兩個元件
		p.add(new TextField(20));
		p.add(new Button("單擊我"));
		// 預設添加到中間，向中間添加一個Panel容器
		f.add(p);
		f.add(new Button("東") , EAST);
		// 設置視窗為最佳大小
		f.pack();
		// 將視窗顯示出來（Frame物件預設處於隱藏狀態）
		f.setVisible(true);
	}
}
