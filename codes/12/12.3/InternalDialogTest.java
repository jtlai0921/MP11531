
import java.awt.*;
import java.awt.event.*;
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
public class InternalDialogTest
{
	private JFrame jf = new JFrame("測試內部對話方塊");
	private JDesktopPane desktop = new JDesktopPane();
	private JButton internalBn = new JButton("內部視窗的對話方塊");
	private JButton deskBn = new JButton("虛擬桌面的對話方塊");
	// 定義一個內部視窗，該視窗可拖動，但不可最大化、最小化、關閉
	private JInternalFrame iframe = new JInternalFrame("內部視窗");
	public void init()
	{
		// 向內部視窗中添加元件
		iframe.add(new JScrollPane(new JTextArea(8, 40)));
		desktop.setPreferredSize(new Dimension(400, 300));
		// 把虛擬桌面添加到JFrame視窗中
		jf.add(desktop);
		// 設置內部視窗的大小、位置
		iframe.reshape(0 , 0 , 300 , 200);
		// 顯示並選取內部視窗
		iframe.show();
		desktop.add(iframe);
		JPanel jp = new JPanel();
		deskBn.addActionListener(event ->
			// 彈出內部對話方塊，以虛擬桌面作為父元件
			JOptionPane.showInternalMessageDialog(desktop
				, "屬於虛擬桌面的對話方塊"));
		internalBn.addActionListener(event ->
			// 彈出內部對話方塊，以內部視窗作為父元件
			JOptionPane.showInternalMessageDialog(iframe
				, "屬於內部視窗的對話方塊"));
		jp.add(deskBn);
		jp.add(internalBn);
		jf.add(jp , BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new InternalDialogTest().init();
	}
}
