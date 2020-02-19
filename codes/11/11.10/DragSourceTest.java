
import java.awt.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

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
public class DragSourceTest
{
	JFrame jf = new JFrame("Swing的拖放支援");
	JLabel srcLabel = new JLabel("Swing的拖放支援.\n"
		+"將該文字區域的內容拖入其他程式.\n");
	public void init()
	{
		DragSource dragSource = DragSource.getDefaultDragSource();
		// 將srcLabel轉換成拖放源，它能接受複製、移動兩種操作
		dragSource.createDefaultDragGestureRecognizer(srcLabel
			, DnDConstants.ACTION_COPY_OR_MOVE
			, event -> {
			// 將JLabel裡的文字資訊包裝成Transferable物件
			String txt = srcLabel.getText();
			Transferable transferable = new StringSelection(txt);
			// 繼續拖放操作,拖放過程中使用手狀游標
			event.startDrag(Cursor.getPredefinedCursor(Cursor
				.HAND_CURSOR), transferable);
		});
		jf.add(new JScrollPane(srcLabel));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] args)
	{
		new DragSourceTest().init();
	}
}
