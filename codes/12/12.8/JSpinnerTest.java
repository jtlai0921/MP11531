
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
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
public class JSpinnerTest
{
	final int SPINNER_NUM = 6;
	JFrame mainWin = new JFrame("微調控制器示範");
	Box spinnerBox = new Box(BoxLayout.Y_AXIS);
	JSpinner[] spinners = new JSpinner[SPINNER_NUM];
	JLabel[] valLabels = new JLabel[SPINNER_NUM];
	JButton okBn = new JButton("確定");
	public void init()
	{
		for (int i = 0 ; i < SPINNER_NUM ; i++ )
		{
			valLabels[i] = new JLabel();
		}
		// -----------普通JSpinner-----------
		spinners[0] = new JSpinner();
		addSpinner(spinners[0], "普通" , valLabels[0]);
		// -----------指定最小值、最大值、步長的JSpinner-----------
		// 建立一個SpinnerNumberModel物件，指定最小值、最大值和步長
		SpinnerNumberModel numModel = new SpinnerNumberModel(
			3.4 , -1.1 , 4.3 , 0.1);
		spinners[1] = new JSpinner(numModel);
		addSpinner(spinners[1], "數值範圍" , valLabels[1]);
		// -----------使用SpinnerListModel的JSpinner------------
		String[] books = new String[]
		{
			"輕量級Java EE企業應用實戰"
			, "瘋狂Java講義"
			, "瘋狂Ajax講義"
		};
		// 使用字串陣列建立SpinnerListModel物件
		SpinnerListModel bookModel = new SpinnerListModel(books);
		// 使用SpinnerListModel物件建立JSpinner物件
		spinners[2] = new JSpinner(bookModel);
		addSpinner(spinners[2], "字串序列值" , valLabels[2]);
		// -----------使用序列值是ImageIcon的JSpinner------------
		ArrayList<ImageIcon> icons = new ArrayList<>();
		icons.add(new ImageIcon("a.gif"));
		icons.add(new ImageIcon("b.gif"));
		// 使用ImageIcon陣列建立SpinnerListModel物件
		SpinnerListModel iconModel = new SpinnerListModel(icons);
		// 使用SpinnerListModel物件建立JSpinner物件
		spinners[3] = new JSpinner(iconModel);
		addSpinner(spinners[3], "圖示序列值" , valLabels[3]);
		// -----------使用SpinnerDateModel的JSpinner------------
		// 分別獲取起始時間、結束時間、初時時間
		Calendar cal = Calendar.getInstance();
		Date init = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH , -3);
		Date start = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH , 8);
		Date end = cal.getTime();
		// 建立一個SpinnerDateModel物件，指定最小時間、最大時間和初始時間
		SpinnerDateModel dateModel = new SpinnerDateModel(init
			, start , end , Calendar.HOUR_OF_DAY);
		// 以SpinnerDateModel物件建立JSpinner
		spinners[4] = new JSpinner(dateModel);
		addSpinner(spinners[4], "時間範圍" , valLabels[4]);
		// -----------使用DateEditor來格式化JSpinner------------
		dateModel = new SpinnerDateModel();
		spinners[5] = new JSpinner(dateModel);
		// 建立一個JSpinner.DateEditor物件，用於對指定Spinner進行格式化
		JSpinner.DateEditor editor = new JSpinner.DateEditor(
			spinners[5] , "西元yyyy年MM月dd日 HH時");
		// 設置使用JSpinner.DateEditor物件進行格式化
		spinners[5].setEditor(editor);
		addSpinner(spinners[5], "使用DateEditor" , valLabels[5]);
		// 為「確定」按鈕添加一個事件監聽器
		okBn.addActionListener(evt ->
		{
			// 取出每個微調控制器的值，並將該值用後面的Label標籤顯示出來。
			for (int i = 0 ; i < SPINNER_NUM ; i++)
			{
				// 將微調控制器的值通過指定的JLabel顯示出來
				valLabels[i].setText(spinners[i].getValue().toString());
			}
		});
		JPanel bnPanel = new JPanel();
		bnPanel.add(okBn);
		mainWin.add(spinnerBox, BorderLayout.CENTER);
		mainWin.add(bnPanel, BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	// 定義一個方法，用於將滑動軸添加到容器中
	public void addSpinner(JSpinner spinner
		, String description , JLabel valLabel)
	{
		Box box = new Box(BoxLayout.X_AXIS);
		JLabel desc = new JLabel(description + "：");
		desc.setPreferredSize(new Dimension(100 , 30));
		box.add(desc);
		box.add(spinner);
		valLabel.setPreferredSize(new Dimension(180 , 30));
		box.add(valLabel);
		spinnerBox.add(box);
	}
	public static void main(String[] args)
	{
		new JSpinnerTest().init();
	}
}