
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
public class SimpleJTree
{
	JFrame jf = new JFrame("簡單樹");
	JTree tree;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode guangdong;
	DefaultMutableTreeNode guangxi;
	DefaultMutableTreeNode foshan;
	DefaultMutableTreeNode shantou;
	DefaultMutableTreeNode guilin;
	DefaultMutableTreeNode nanning;
	public void init()
	{
		// 依次建立樹中所有節點
		root = new DefaultMutableTreeNode("中國");
		guangdong = new DefaultMutableTreeNode("廣東");
		guangxi = new DefaultMutableTreeNode("廣西");
		foshan = new DefaultMutableTreeNode("佛山");
		shantou = new DefaultMutableTreeNode("汕頭");
		guilin = new DefaultMutableTreeNode("桂林");
		nanning = new DefaultMutableTreeNode("南寧");
		// 通過add()方法建立樹節點之間的父子關係
		guangdong.add(foshan);
		guangdong.add(shantou);
		guangxi.add(guilin);
		guangxi.add(nanning);
		root.add(guangdong);
		root.add(guangxi);
		// 以根節點建立樹
		tree = new JTree(root);   // ①
		jf.add(new JScrollPane(tree));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SimpleJTree().init();
	}
}
