
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
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
public class JEditorPaneTest
{
	JFrame mainWin = new JFrame("測試JEditorPane");
	LinkedList<String> urls = new LinkedList<String>();
	JEditorPane editorPane = new JEditorPane();
	JTextField url = new JTextField(30);
	JCheckBox editable = new JCheckBox();
	JButton backButton = new JButton("後退");

	public void init()
	{
		// 預設設置不允許編輯
		editorPane.setEditable(false);
		editorPane.addHyperlinkListener(event -> {
			if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
			{
				try
				{
					// 將使用者瀏覽過的URL
					urls.push(event.getURL().toString());
					// 在文字方塊內輸入URL字串
					url.setText(event.getURL().toString());
					// 讓JEditorPane裝載新的頁面
					editorPane.setPage(event.getURL());
				}
				catch (IOException e)
				{
					editorPane.setText("出現異常: " + e);
				}
			}
		});

		// 為可編輯的核取方塊添加事件監聽器。
		// 如果該核取方塊處於選取狀態，則該編輯器可編輯
		editable.addActionListener(event ->
			editorPane.setEditable(editable.isSelected()));

		// 載入URL指定頁面的監聽器
		ActionListener listener = event -> {
			try
			{
				// 將使用者瀏覽後的URL添加到URL堆疊中
				urls.push(url.getText());
				editorPane.setPage(url.getText());
			}
			catch (IOException e)
			{
				editorPane.setText("頁面: " + e);
			}
		};

		JButton loadButton = new JButton("載入");
		loadButton.addActionListener(listener);
		url.addActionListener(listener);

		// 為返回按鈕添加監聽器
		backButton.addActionListener(event -> {
			// 如果還沒有已經瀏覽過的URL
			if (urls.size() <= 1) return;
			try
			{
				// 取出、並獲取最後一個URL
				String urlString = urls.pop();
				url.setText(urlString);
				// 重新載入新的URL
				editorPane.setPage(urlString);
			}
			catch (IOException e)
			{
				editorPane.setText("出現異常: " + e);
			}
		});

		mainWin.add(new JScrollPane(editorPane), BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.add(new JLabel("輸入網址："));
		panel.add(url);
		panel.add(loadButton);
		panel.add(backButton);
		panel.add(new JLabel("是否可編輯"));
		panel.add(editable);

		mainWin.add(panel, BorderLayout.NORTH);
		mainWin.pack();
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
   }

	public static void main(String[] args)
	{
		new JEditorPaneTest().init();
	}
}


