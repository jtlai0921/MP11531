
import java.awt.*;
import javax.swing.*;
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
public class JLayeredPaneTest
{
	JFrame jf = new JFrame("測試JLayeredPane");
	JLayeredPane layeredPane = new JLayeredPane();
	public void init()
	{
		// 向layeredPane中添加3個元件
		layeredPane.add(new ContentPanel(10 , 20 , "瘋狂Java講義"
			, "ico/java.png"), JLayeredPane.MODAL_LAYER);
		layeredPane.add(new ContentPanel(100 , 60 , "瘋狂Android講義"
			, "ico/android.png"), JLayeredPane.DEFAULT_LAYER);
		layeredPane.add(new ContentPanel(190 , 100
			, "輕量級Java EE企業應用實戰", "ico/ee.png"), 4);
		layeredPane.setPreferredSize(new Dimension(400, 300));
		layeredPane.setVisible(true);
		jf.add(layeredPane);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new JLayeredPaneTest().init();
	}
}
// 擴展了JPanel類別，可以直接建立一個放在指定位置，
// 且有指定標題、放置指定圖示的JPanel物件
class ContentPanel extends JPanel
{
	public ContentPanel(int xPos , int yPos
		, String title , String ico)
	{
		setBorder(BorderFactory.createTitledBorder(
			BorderFactory.createEtchedBorder(), title));
		JLabel label = new JLabel(new ImageIcon(ico));
		add(label);
		setBounds(xPos , yPos , 160, 220);    // ①
	}
}

