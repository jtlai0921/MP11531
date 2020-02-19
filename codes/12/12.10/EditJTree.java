
import java.awt.BorderLayout;
import java.awt.event.*;
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
public class EditJTree
{
	JFrame jf;
	JTree tree;
	// 上面JTree物件對應的model
	DefaultTreeModel model;
	// 定義幾個初始節點
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("中國");
	DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("廣東");
	DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("廣西");
	DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
	DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕頭");
	DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
	DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南寧");
	// 定義需要被拖動的TreePath
	TreePath movePath;
	JButton addSiblingButton = new JButton("添加兄弟節點");
	JButton addChildButton = new JButton("添加子節點");
	JButton deleteButton = new JButton("刪除節點");
	JButton editButton = new JButton("編輯當前節點");
	public void init()
	{
		guangdong.add(foshan);
		guangdong.add(shantou);
		guangxi.add(guilin);
		guangxi.add(nanning);
		root.add(guangdong);
		root.add(guangxi);
		jf = new JFrame("可編輯節點的樹");
		tree = new JTree(root);
		// 獲取JTree對應的TreeModel物件
		model = (DefaultTreeModel)tree.getModel();
		// 設置JTree可編輯
		tree.setEditable(true);
		MouseListener ml = new MouseAdapter()
		{
			// 按下滑鼠時獲得被拖動的節點
			public void mousePressed(MouseEvent e)
			{
				// 如果需要唯一確定某個節點，必須通過TreePath來獲取。
				TreePath tp = tree.getPathForLocation(
					e.getX() , e.getY());
				if (tp != null)
				{
					movePath = tp;
				}
			}
			// 滑鼠鬆開時獲得需要拖到哪個父節點
			public void mouseReleased(MouseEvent e)
			{
				// 根據滑鼠鬆開時的TreePath來獲取TreePath
				TreePath tp = tree.getPathForLocation(
					e.getX(), e.getY());
				if (tp != null && movePath != null)
				{
					// 阻止向子節點拖動
					if (movePath.isDescendant(tp) && movePath != tp)
					{
						JOptionPane.showMessageDialog(jf,
							"目標節點是被移動節點的子節點，無法移動！",
							"非法操作", JOptionPane.ERROR_MESSAGE );
						return;
					}
					// 既不是向子節點移動，而且滑鼠按下、鬆開的不是同一個節點
					else if (movePath != tp)
					{
						// add方法先將該節點從原父節下刪除，再添加到新父節點下
						((DefaultMutableTreeNode)tp.getLastPathComponent())
							.add((DefaultMutableTreeNode)movePath
							.getLastPathComponent());
						movePath = null;
						tree.updateUI();
					}
				}
			}
		};
		// 為JTree添加滑鼠監聽器
		tree.addMouseListener(ml);
		JPanel panel = new JPanel();
		// 實作添加兄弟節點的監聽器
		addSiblingButton.addActionListener(event -> {
			// 獲取選取節點
			DefaultMutableTreeNode selectedNode	= (DefaultMutableTreeNode)
				tree.getLastSelectedPathComponent();
			// 如果節點為空，直接返回
			if (selectedNode == null) return;
			// 獲取該選取節點的父節點
			DefaultMutableTreeNode parent = (DefaultMutableTreeNode)
				selectedNode.getParent();
			// 如果父節點為空，直接返回
			if (parent == null) return;
			// 建立一個新節點
			DefaultMutableTreeNode newNode = new
				DefaultMutableTreeNode("新節點");
			// 獲取選取節點的選取索引
			int selectedIndex = parent.getIndex(selectedNode);
			// 在選取位置插入新節點
			model.insertNodeInto(newNode, parent, selectedIndex + 1);
			// --------下面程式碼實作顯示新節點（自動展開父節點）-------
			// 獲取從根節點到新節點的所有節點
			TreeNode[] nodes = model.getPathToRoot(newNode);
			// 使用指定的節點陣列來建立TreePath
			TreePath path = new TreePath(nodes);
			// 顯示指定TreePath
			tree.scrollPathToVisible(path);
		});
		panel.add(addSiblingButton);
		// 實作添加子節點的監聽器
		addChildButton.addActionListener(event -> {
			// 獲取選取節點
			DefaultMutableTreeNode selectedNode	= (DefaultMutableTreeNode)
				tree.getLastSelectedPathComponent();
			// 如果節點為空，直接返回
			if (selectedNode == null) return;
			// 建立一個新節點
			DefaultMutableTreeNode newNode = new
				DefaultMutableTreeNode("新節點");
			// 通過model來添加新節點，則無須通過呼叫JTree的updateUI方法
			// model.insertNodeInto(newNode, selectedNode
			// 	, selectedNode.getChildCount());
			// 通過節點添加新節點，則需要呼叫tree的updateUI方法
			selectedNode.add(newNode);
			// --------下面程式碼實作顯示新節點（自動展開父節點）-------
			TreeNode[] nodes = model.getPathToRoot(newNode);
			TreePath path = new TreePath(nodes);
			tree.scrollPathToVisible(path);
			tree.updateUI();
		});
		panel.add(addChildButton);
		// 實作刪除節點的監聽器
		deleteButton.addActionListener(event ->	{
			DefaultMutableTreeNode selectedNode	= (DefaultMutableTreeNode)
				tree.getLastSelectedPathComponent();
			if (selectedNode != null && selectedNode.getParent() != null)
			{
				// 刪除指定節點
				model.removeNodeFromParent(selectedNode);
			}
		});
		panel.add(deleteButton);
		// 實作編輯節點的監聽器
		editButton.addActionListener(event -> {
			TreePath selectedPath = tree.getSelectionPath();
			if (selectedPath != null)
			{
				// 編輯選取節點
				tree.startEditingAtPath(selectedPath);
			}
		});
		panel.add(editButton);
		jf.add(new JScrollPane(tree));
		jf.add(panel , BorderLayout.SOUTH);
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new EditJTree().init();
	}
}
