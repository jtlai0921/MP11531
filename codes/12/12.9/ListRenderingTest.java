
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
public class ListRenderingTest
{
	private JFrame mainWin = new JFrame("好友列表");
	private String[] friends = new String[]
	{
		"李清照",
		"蘇格拉底",
		"李白",
		"弄玉",
		"虎頭"
	};
	// 定義一個JList物件
	private JList<String> friendsList = new JList<>(friends);
	public void init()
	{
		// 設置該JList使用ImageCellRenderer作為列表項目繪製器
		friendsList.setCellRenderer(new ImageCellRenderer());
		mainWin.add(new JScrollPane(friendsList));
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public static void main(String[] args)
	{
		new ListRenderingTest().init();
	}
}
class ImageCellRenderer extends JPanel
	implements ListCellRenderer<String>
{
	private ImageIcon icon;
	private String name;
	// 定義繪製儲存格時的背景色
	private Color background;
	// 定義繪製儲存格時的前景色
	private Color foreground;
	public Component getListCellRendererComponent(JList list
		, String value , int index
		, boolean isSelected , boolean cellHasFocus)
	{
		icon = new ImageIcon("ico/" + value + ".gif");
		name = value;
		background = isSelected ? list.getSelectionBackground()
			: list.getBackground();
		foreground = isSelected ? list.getSelectionForeground()
			: list.getForeground();
		// 返回該JPanel物件作為列表項目繪製器
		return this;
	}
	// 覆寫paintComponent方法，改變JPanel的外觀
	public void paintComponent(Graphics g)
	{
		int imageWidth = icon.getImage().getWidth(null);
		int imageHeight = icon.getImage().getHeight(null);
		g.setColor(background);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(foreground);
		// 繪製好友圖示
		g.drawImage(icon.getImage() , getWidth() / 2
			- imageWidth / 2 , 10 , null);
		g.setFont(new Font("SansSerif" , Font.BOLD , 18));
		// 繪製好友使用者名稱
		g.drawString(name, getWidth() / 2
			- name.length() * 10 , imageHeight + 30 );
	}
	// 通過該方法來設置該ImageCellRenderer的最佳大小
	public Dimension getPreferredSize()
	{
		return new Dimension(60, 80);
	}
}

