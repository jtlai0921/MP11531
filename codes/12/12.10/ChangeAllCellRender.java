
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
public class ChangeAllCellRender
{
	JFrame jf = new JFrame("改變所有節點的外觀");
	JTree tree;
	// 定義幾個初始節點
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("中國");
	DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("廣東");
	DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("廣西");
	DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
	DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕頭");
	DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
	DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南寧");
	public void init()
	{
		// 通過add()方法建立樹節點之間的父子關係
		guangdong.add(foshan);
		guangdong.add(shantou);
		guangxi.add(guilin);
		guangxi.add(nanning);
		root.add(guangdong);
		root.add(guangxi);
		// 以根節點建立樹
		tree = new JTree(root);
		// 建立一個DefaultTreeCellRender物件
		DefaultTreeCellRenderer cellRender = new DefaultTreeCellRenderer();
		// 設置非選定節點的背景色。
		cellRender.setBackgroundNonSelectionColor(new
			Color(220 , 220 , 220));
		// 設置節點在選取狀態下的背景顏色。
		cellRender.setBackgroundSelectionColor(new Color(140 , 140, 140));
		// 設置選取狀態下節點的邊框顏色。
		cellRender.setBorderSelectionColor(Color.BLACK);
		// 設置處於摺疊狀態下非葉子節點的圖示。
		cellRender.setClosedIcon(new ImageIcon("icon/close.gif"));
		// 設置節點文字的字型。
		cellRender.setFont(new Font("SansSerif" , Font.BOLD , 16));
		// 設置葉子節點的圖示。
		cellRender.setLeafIcon(new ImageIcon("icon/leaf.png"));
		// 設置處於展開狀態下非葉子節點的圖示。
		cellRender.setOpenIcon(new ImageIcon("icon/open.gif"));
		// 設置繪製非選取狀態下節點文字的顏色。
		cellRender.setTextNonSelectionColor(new Color(255 , 0 , 0));
		// 設置繪製選取狀態下節點文字的顏色。
		cellRender.setTextSelectionColor(new Color(0 , 0 , 255));
		tree.setCellRenderer(cellRender);
		// 設置是否顯示根節點的「展開/摺疊」圖示,預設是false
		tree.setShowsRootHandles(true);
		// 設置節點是否可見,預設是true
		tree.setRootVisible(true);
		jf.add(new JScrollPane(tree));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new ChangeAllCellRender().init();
	}
}
