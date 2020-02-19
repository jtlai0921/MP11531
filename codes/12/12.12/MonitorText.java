
import java.util.LinkedList;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.undo.*;
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
public class MonitorText
{
	JFrame mainWin = new JFrame("監聽Document物件");
	JTextArea target = new JTextArea(4, 35);
	JTextArea msg = new JTextArea(5, 35);
	JLabel label = new JLabel("文字區域的修改資訊");
	Document doc = target.getDocument();
	// 存放復原操作的List物件
	LinkedList<UndoableEdit> undoList = new LinkedList<>();
	// 最多允許復原多少次
	final int UNDO_COUNT = 20;
	public void init()
	{
		msg.setEditable(false);
		// 添加DocumentListener
		doc.addDocumentListener(new DocumentListener()
		{
			// 當Document的屬性或屬性集發生了改變時觸發該方法
			public void changedUpdate(DocumentEvent e){}
			// 當向Document中插入文字時觸發該方法
			public void insertUpdate(DocumentEvent e)
			{
				int offset = e.getOffset();
				int len = e.getLength();
				// 取得插入事件的位置
				msg.append("插入文字的長度：" + len + "\n");
				msg.append("插入文字的起始位置：" + offset + "\n");
				try
				{
					msg.append("插入文字內容："
						+ doc.getText(offset, len) + "\n");
				}
				catch (BadLocationException evt)
				{
					evt.printStackTrace();
				}
			}
			// 當從Document中刪除文字時觸發該方法
			public void removeUpdate(DocumentEvent e)
			{
				int offset = e.getOffset();
				int len = e.getLength();
				// 取得插入事件的位置
				msg.append("刪除文字的長度：" + len + "\n");
				msg.append("刪除文字的起始位置：" + offset + "\n");
			}
		});
		// 添加可復原操作的監聽器
		doc.addUndoableEditListener(e -> {
			// 每次發生可復原操作都會觸發該程式碼區塊      // ①
			UndoableEdit edit = e.getEdit();
			if (edit.canUndo() && undoList.size() < UNDO_COUNT)
			{
				// 將復原操作裝入List內
				undoList.add(edit);
			}
			// 已經達到了最大復原次數
			else if (edit.canUndo() && undoList.size() >= UNDO_COUNT)
			{
				// 彈出第一個復原操作
				undoList.pop();
				// 將復原操作裝入List內
				undoList.add(edit);
			}
		});
		// 為Ctrl+Z添加監聽器
		target.addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent e)    // ②
			{
				System.out.println(e.getKeyChar() + 0);
				// 如果按鍵是Ctrl + Z或Ctrl + z
				if (e.getKeyChar() == 26)
				{
					if (undoList.size() > 0)
					{
						// 移出最後一個可復原操作，並取消該操作
						undoList.removeLast().undo();
					}
				}
			}
		});
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(new JScrollPane(target));
		JPanel panel = new JPanel();
		panel.add(label);
		box.add(panel);
		box.add(new JScrollPane(msg));
		mainWin.add(box);
		mainWin.pack();
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
	}
	public static void main(String[] args) throws Exception
	{
		new MonitorText().init();
	}
}
