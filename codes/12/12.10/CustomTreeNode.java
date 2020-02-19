
import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;
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
public class CustomTreeNode
{
	JFrame jf = new JFrame("自訂樹的節點");
	JTree tree;
	// 定義幾個初始節點
	DefaultMutableTreeNode friends = new DefaultMutableTreeNode("我的好友");
	DefaultMutableTreeNode qingzhao = new DefaultMutableTreeNode("李清照");
	DefaultMutableTreeNode suge = new DefaultMutableTreeNode("蘇格拉底");
	DefaultMutableTreeNode libai = new DefaultMutableTreeNode("李白");
	DefaultMutableTreeNode nongyu = new DefaultMutableTreeNode("弄玉");
	DefaultMutableTreeNode hutou = new DefaultMutableTreeNode("虎頭");
	public void init()
	{
		// 通過add()方法建立樹節點之間的父子關係
		friends.add(qingzhao);
		friends.add(suge);
		friends.add(libai);
		friends.add(nongyu);
		friends.add(hutou);
		// 以根節點建立樹
		tree = new JTree(friends);
		// 設置是否顯示根節點的「展開/摺疊」圖示,預設是false
		tree.setShowsRootHandles(true);
		// 設置節點是否可見,預設是true
		tree.setRootVisible(true);
		// 設置使用定製的節點繪製器
		tree.setCellRenderer(new ImageCellRenderer());
		jf.add(new JScrollPane(tree));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new CustomTreeNode().init();
	}
}
// 實作自己的節點繪製器
class ImageCellRenderer extends JPanel implements TreeCellRenderer
{
	private ImageIcon icon;
	private String name;
	// 定義繪製儲存格時的背景色
	private Color background;
	// 定義繪製儲存格時的前景色
	private Color foreground;
	public Component getTreeCellRendererComponent(JTree tree
		, Object value , boolean sel , boolean expanded
		, boolean leaf , int row , boolean hasFocus)
	{
		icon = new ImageIcon("icon/" + value + ".gif");
		name = value.toString();
		background = hasFocus ? new Color(140 , 200 ,235)
			: new Color(255 , 255 , 255);
		foreground = hasFocus ? new Color(255 , 255 ,3)
			: new Color(0 , 0 , 0);
		// 返回該JPanel物件作為儲存格繪製器
		return this;
	}
	// 覆寫paintComponent方法，改變JPanel的外觀
	public void paintComponent(Graphics g)
	{
		int imageWidth = icon.getImage().getWidth(null);
		int imageHeight = icon.getImage().getHeight(null);
		g.setColor(background);
		g.fillRect(0 , 0 , getWidth() , getHeight());
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
		return new Dimension(80, 80);
	}
}

