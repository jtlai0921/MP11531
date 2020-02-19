
import java.util.*;
import java.text.*;
import java.net.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.*;
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
public class JFormattedTextFieldTest
{
	private JFrame mainWin = new JFrame("測試格式化文字方塊");
	private JButton okButton = new JButton("確定");
	// 定義用於添加格式化文字方塊的容器
	private JPanel mainPanel = new JPanel();
	JFormattedTextField[] fields = new JFormattedTextField[6];
	String[] behaviorLabels = new String[]
	{
		"COMMIT",
		"COMMIT_OR_REVERT",
		"PERSIST",
		"REVERT"
	};
	int[] behaviors = new int[]
	{
		JFormattedTextField.COMMIT,
		JFormattedTextField.COMMIT_OR_REVERT,
		JFormattedTextField.PERSIST,
		JFormattedTextField.REVERT
	};
	ButtonGroup bg = new ButtonGroup();
	public void init()
	{
		// 添加按鈕
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		mainPanel.setLayout(new GridLayout(0, 3));
		mainWin.add(mainPanel, BorderLayout.CENTER);
		// 使用NumberFormat的integerInstance建立一個JFormattedTextField
		fields[0] = new JFormattedTextField(NumberFormat
			.getIntegerInstance());
		// 設置初始值
		fields[0].setValue(100);
		addRow("整數格式文字方塊 :", fields[0]);
		// 使用NumberFormat的currencyInstance建立一個JFormattedTextField
		fields[1] = new JFormattedTextField(NumberFormat
			.getCurrencyInstance());
		fields[1].setValue(100.0);
		addRow("貨幣格式文字方塊:", fields[1]);
		// 使用預設的日期格式建立一個JFormattedTextField物件
		fields[2] = new JFormattedTextField(DateFormat.getDateInstance());
		fields[2].setValue(new Date());
		addRow("預設的日期格式器:", fields[2]);
		// 使用SHORT類型的日期格式建立一個JFormattedTextField物件，
		// 且要求採用嚴格日期格式
		DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT);
		// 要求採用嚴格的日期格式語法
		format.setLenient(false);
		fields[3] = new JFormattedTextField(format);
		fields[3].setValue(new Date());
		addRow("SHORT類型的日期格式器（語法嚴格）:", fields[3]);
		try
		{
			// 建立預設的DefaultFormatter物件
			DefaultFormatter formatter = new DefaultFormatter();
			// 關閉overwrite狀態
			formatter.setOverwriteMode(false);
			fields[4] = new JFormattedTextField(formatter);
			// 使用DefaultFormatter來格式化URL
			fields[4].setValue(new URL("http://www.crazyit.org"));
			addRow("URL:", fields[4]);
		}
		catch (MalformedURLException e)
		{
			e.printStackTrace();
		}
		try
		{
			MaskFormatter formatter = new MaskFormatter("020-########");
			// 設置佔位符
			formatter.setPlaceholderCharacter('□');
			fields[5] = new JFormattedTextField(formatter);
			// 設置初始值
			fields[5].setValue("020-28309378");
			addRow("電話號碼：", fields[5]);
		}
		catch (ParseException ex)
		{
			ex.printStackTrace();
		}

		JPanel focusLostPanel = new JPanel();
		// 採用迴圈方式加入失去焦點行為的單選按鈕
		for (int i = 0; i < behaviorLabels.length ; i++ )
		{
			final int index = i;
			final JRadioButton radio = new JRadioButton(behaviorLabels[i]);
			// 預設選取第二個單選按鈕
			if (i == 1)
			{
				radio.setSelected(true);
			}
			focusLostPanel.add(radio);
			bg.add(radio);
			// 為所有單選按鈕添加事件監聽器
			radio.addActionListener(e -> {
				// 如果當前該單選按鈕處於選取狀態，
				if (radio.isSelected())
				{
					// 設置所有的格式化文字方塊的失去焦點的行為
					for (int j = 0 ; j < fields.length ; j++)
					{
						fields[j].setFocusLostBehavior(behaviors[index]);
					}
				}
			});
		}
		focusLostPanel.setBorder(new TitledBorder(new EtchedBorder(),
			"請選擇焦點失去後的行為"));
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add(focusLostPanel , BorderLayout.NORTH);
		p.add(buttonPanel , BorderLayout.SOUTH);

		mainWin.add(p , BorderLayout.SOUTH);
		mainWin.pack();
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
	}
	// 定義添加一行格式化文字方塊的方法
	private void addRow(String labelText, final JFormattedTextField field)
	{
		mainPanel.add(new JLabel(labelText));
		mainPanel.add(field);
		final JLabel valueLabel = new JLabel();
		mainPanel.add(valueLabel);
		// 為"確定"按鈕添加事件監聽器
		// 當使用者單擊「確定」按鈕時，文字方塊後
		okButton.addActionListener(event -> {
			Object value = field.getValue();
			// 輸出格式化文字方塊的值
			valueLabel.setText(value.toString());
		});
	}
	public static void main(String[] args)
	{
		new JFormattedTextFieldTest().init();
	}
}
