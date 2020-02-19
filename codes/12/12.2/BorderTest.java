
import javax.swing.*;
import javax.swing.border.*;
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
public class BorderTest
{
	private JFrame jf = new JFrame("測試邊框");
	public void init()
	{
		jf.setLayout(new GridLayout(2, 4));
		// 使用靜態工廠方法建立BevelBorder
		Border bb = BorderFactory.createBevelBorder(
			BevelBorder.RAISED , Color.RED, Color.GREEN
			, Color.BLUE, Color.GRAY);
		jf.add(getPanelWithBorder(bb , "BevelBorder"));
		// 使用靜態工廠方法建立LineBorder
		Border lb = BorderFactory.createLineBorder(Color.ORANGE, 10);
		jf.add(getPanelWithBorder(lb , "LineBorder"));
		// 使用靜態工廠方法建立EmptyBorder，EmptyBorder就是在元件四周留空
		Border eb = BorderFactory.createEmptyBorder(20, 5, 10, 30);
		jf.add(getPanelWithBorder(eb , "EmptyBorder"));
		// 使用靜態工廠方法建立EtchedBorder
		Border etb = BorderFactory.createEtchedBorder(EtchedBorder.RAISED,
		Color.RED, Color.GREEN);
		jf.add(getPanelWithBorder(etb , "EtchedBorder"));
		// 直接建立TitledBorder，TitledBorder邊框就是為原有的邊框增加標題
		TitledBorder tb = new TitledBorder(lb , "測試標題"
			, TitledBorder.LEFT , TitledBorder.BOTTOM
			, new Font("StSong" , Font.BOLD , 18), Color.BLUE);
		jf.add(getPanelWithBorder(tb , "TitledBorder"));
		// 直接建立MatteBorder，MatteBorder邊框是EmptyBorder的子類別，
		// 它可以指定留空區域的顏色或背景，此處是指定顏色
		MatteBorder mb = new MatteBorder(20, 5, 10, 30, Color.GREEN);
		jf.add(getPanelWithBorder(mb , "MatteBorder"));
		// 直接建立CompoundBorder，CompoundBorder邊框將兩個邊框組合成新邊框
		CompoundBorder cb = new CompoundBorder(new LineBorder(
			Color.RED, 8) , tb);
		jf.add(getPanelWithBorder(cb , "CompoundBorder"));
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new BorderTest().init();
	}
	public JPanel getPanelWithBorder(Border b , String BorderName)
	{
		JPanel p = new JPanel();
		p.add(new JLabel(BorderName));
		// 為Panel元件設置邊框
		p.setBorder(b);
		return p;
	}
}
