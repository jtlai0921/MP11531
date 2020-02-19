
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
public class ExtendsDefaultTreeCellRenderer
{
	JFrame jf = new JFrame("根據節點類型定義圖示");
	JTree tree;
	// 定義幾個初始節點
	DefaultMutableTreeNode root = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.ROOT , "資料庫導覽"));
	DefaultMutableTreeNode salaryDb = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.DATABASE , "公司工資資料庫"));
	DefaultMutableTreeNode customerDb = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.DATABASE , "公司客戶資料庫"));
	// 定義salaryDb的兩個子節點
	DefaultMutableTreeNode employee = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.TABLE , "員工表"));
	DefaultMutableTreeNode attend = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.TABLE , "考勤表"));
	// 定義customerDb的一個子節點
	DefaultMutableTreeNode contact = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.TABLE , "聯繫方式表"));
	// 定義employee的三個子節點
	DefaultMutableTreeNode id = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.INDEX , "員工ID"));
	DefaultMutableTreeNode name = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.COLUMN , "姓名"));
	DefaultMutableTreeNode gender = new DefaultMutableTreeNode(
		new NodeData(DBObjectType.COLUMN , "性別"));
	public void init()
	{
		// 通過add()方法建立樹節點之間的父子關係
		root.add(salaryDb);
		root.add(customerDb);
		salaryDb.add(employee);
		salaryDb.add(attend);
		customerDb.add(contact);
		employee.add(id);
		employee.add(name);
		employee.add(gender);
		// 以根節點建立樹
		tree = new JTree(root);
		// 設置該JTree使用自訂的節點繪製器
		tree.setCellRenderer(new MyRenderer());
		// 設置是否顯示根節點的「展開/摺疊」圖示,預設是false
		tree.setShowsRootHandles(true);
		// 設置節點是否可見,預設是true
		tree.setRootVisible(true);
		try
		{
			// 設置使用Windows風格外觀
			UIManager.setLookAndFeel("com.sun.java.swing.plaf."
				+ "windows.WindowsLookAndFeel");
		}
		catch (Exception ex){}
		// 更新JTree的UI外觀
		SwingUtilities.updateComponentTreeUI(tree);
		jf.add(new JScrollPane(tree));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new ExtendsDefaultTreeCellRenderer().init();
	}
}
// 定義一個NodeData類別，用於封裝節點資料
class NodeData
{
	public int nodeType;
	public String nodeData;
	public NodeData(int nodeType , String nodeData)
	{
		this.nodeType = nodeType;
		this.nodeData = nodeData;
	}
	public String toString()
	{
		return nodeData;
	}
}
// 定義一個介面，該介面裡包含資料庫物件類型的常數
interface DBObjectType
{
	int ROOT = 0;
	int DATABASE = 1;
	int TABLE = 2;
	int COLUMN = 3;
	int INDEX = 4;
}
class MyRenderer extends DefaultTreeCellRenderer
{
	// 初始化5個圖示
	ImageIcon rootIcon = new ImageIcon("icon/root.gif");
	ImageIcon databaseIcon = new ImageIcon("icon/database.gif");
	ImageIcon tableIcon = new ImageIcon("icon/table.gif");
	ImageIcon columnIcon = new ImageIcon("icon/column.gif");
	ImageIcon indexIcon = new ImageIcon("icon/index.gif");
	public Component getTreeCellRendererComponent(JTree tree
		, Object value , boolean sel , boolean expanded
		, boolean leaf , int row , boolean hasFocus)
	{
		// 執行父類別預設的節點繪製操作
		super.getTreeCellRendererComponent(tree , value
			, sel, expanded , leaf , row , hasFocus);
		DefaultMutableTreeNode node = (DefaultMutableTreeNode)value;
		NodeData data = (NodeData)node.getUserObject();
		// 根據資料節點裡的nodeType資料決定節點圖示
		ImageIcon icon = null;
		switch(data.nodeType)
		{
			case DBObjectType.ROOT:
				icon = rootIcon;
				break;
			case DBObjectType.DATABASE:
				icon = databaseIcon;
				break;
			case DBObjectType.TABLE:
				icon = tableIcon;
				break;
			case DBObjectType.COLUMN:
				icon = columnIcon;
				break;
			case DBObjectType.INDEX:
				icon = indexIcon;
				break;
		}
		// 改變圖示
		this.setIcon(icon);
		return this;
	}
}