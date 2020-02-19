
import java.awt.event.*;
import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;
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
public class SelectJTree
{
	JFrame jf = new JFrame("監聽樹的選擇事件");
	JTree tree;
	// 定義幾個初始節點
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("中國");
	DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("廣東");
	DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("廣西");
	DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
	DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕頭");
	DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
	DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南寧");
	JTextArea eventTxt = new JTextArea(5 , 20);
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
		// 設置只能選擇一個TreePath
		tree.getSelectionModel().setSelectionMode(
			TreeSelectionModel.SINGLE_TREE_SELECTION);
		// 添加監聽樹節點選擇事件的監聽器
		// 當JTree中被選擇節點發生改變時，將觸發該方法
		tree.addTreeSelectionListener(e -> {
			if (e.getOldLeadSelectionPath() != null)
				eventTxt.append("原選取的節點路徑："
				+ e.getOldLeadSelectionPath().toString() + "\n");
			eventTxt.append("新選取的節點路徑："
				+ e.getNewLeadSelectionPath().toString() + "\n");
		});
		//設置是否顯示根節點的「展開/摺疊」圖示,預設是false
		tree.setShowsRootHandles(true);
		//設置根節點是否可見,預設是true
		tree.setRootVisible(true);
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JScrollPane(tree));
		box.add(new JScrollPane(eventTxt));
		jf.add(box);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new SelectJTree().init();
	}
}

