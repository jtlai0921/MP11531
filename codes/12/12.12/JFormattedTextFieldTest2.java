
import java.text.*;

import java.lang.reflect.Array;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
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
public class JFormattedTextFieldTest2
{
	private JFrame mainWin = new JFrame("測試格式化文字方塊");
	private JButton okButton = new JButton("確定");
	// 定義用於添加格式化文字方塊的容器
	private JPanel mainPanel = new JPanel();
	public void init()
	{
		// 添加按鈕
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		mainPanel.setLayout(new GridLayout(0, 3));
		mainWin.add(mainPanel, BorderLayout.CENTER);
		JFormattedTextField intField0 = new JFormattedTextField(
			new InternationalFormatter(NumberFormat.getIntegerInstance())
			{
				protected DocumentFilter getDocumentFilter()
				{
					return new NumberFilter();
				}
			});
		intField0.setValue(100);
		addRow("只接受數字的文字方塊", intField0);
		JFormattedTextField intField1 = new JFormattedTextField
			(NumberFormat.getIntegerInstance());
		intField1.setValue(100);
		// 添加輸入校驗器
		intField1.setInputVerifier(new FormattedTextFieldVerifier());
		addRow("帶輸入校驗器的文字方塊", intField1);
		// 建立自訂格式器物件
		IPAddressFormatter ipFormatter = new IPAddressFormatter();
		ipFormatter.setOverwriteMode(false);
		// 以自訂格式器物件建立格式化文字方塊
		JFormattedTextField ipField = new JFormattedTextField(ipFormatter);
		ipField.setValue(new byte[]{(byte)192, (byte)168, 4, 1});
		addRow("IP位址格式", ipField);
		mainWin.add(buttonPanel , BorderLayout.SOUTH);
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
		// 當使用者單擊「確定」按鈕時，文字方塊後顯示文字方塊內的值
		okButton.addActionListener(event -> {
			Object value = field.getValue();
			// 如果該值是陣列，使用Arrays的toString方法輸出陣列
			if (value.getClass().isArray())
			{
				StringBuilder builder = new StringBuilder();
				builder.append('{');
				for (int i = 0; i < Array.getLength(value); i++)
				{
					if (i > 0)
						builder.append(',');
					builder.append(Array.get(value, i).toString());
				}
				builder.append('}');
				valueLabel.setText(builder.toString());
			}
			else
			{
				// 輸出格式化文字方塊的值
				valueLabel.setText(value.toString());
			}
		});
	}
	public static void main(String[] args)
	{
		new JFormattedTextFieldTest2().init();
	}
}
// 輸入校驗器
class FormattedTextFieldVerifier extends InputVerifier
{
	// 當輸入元件失去焦點時，該方法被觸發
	public boolean verify(JComponent component)
	{
		JFormattedTextField field = (JFormattedTextField)component;
		// 返回使用者輸入是否有效
		return field.isEditValid();
	}
}
// 數字過濾器
class NumberFilter extends DocumentFilter
{
	public void insertString(FilterBypass fb , int offset
		, String string , AttributeSet attr)throws BadLocationException
	{
		StringBuilder builder = new StringBuilder(string);
		// 過濾使用者輸入的所有字元
		filterInt(builder);
		super.insertString(fb, offset, builder.toString(), attr);
	}
	public void replace(FilterBypass fb , int offset , int length
		, String string , AttributeSet attr)throws BadLocationException
	{
		if (string != null)
		{
			StringBuilder builder = new StringBuilder(string);
			// 過濾使用者替換的所有字元
			filterInt(builder);
			string = builder.toString();
		}
		super.replace(fb, offset, length, string, attr);
	}
	// 過濾整數字元，把所有非0～9的字元全部刪除
	private void filterInt(StringBuilder builder)
	{
		for (int i = builder.length() - 1; i >= 0; i--)
		{
			int cp = builder.codePointAt(i);
			if (cp > '9' || cp < '0')
			{
				builder.deleteCharAt(i);
			}
		}
	}
}
class IPAddressFormatter extends DefaultFormatter
{
	public String valueToString(Object value)
		throws ParseException
	{
		if (!(value instanceof byte[]))
		{
			throw new ParseException("該IP位址的值只能是位元組陣列", 0);
		}
		byte[] a = (byte[])value;
		if (a.length != 4)
		{
			throw new ParseException("IP位址必須是四個整數", 0);
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < 4; i++)
		{
			int b = a[i];
			if (b < 0) b += 256;
				builder.append(String.valueOf(b));
			if (i < 3) builder.append('.');
		}
		return builder.toString();
	}
	public Object stringToValue(String text) throws ParseException
	{
		// 將格式化文字方塊內的字串以點號（.）分成四節。
		String[] nums = text.split("\\.");
		if (nums.length != 4)
		{
			throw new ParseException("IP位址必須是四個整數", 0);
		}
		byte[] a = new byte[4];
		for (int i = 0; i < 4; i++)
		{
			int b = 0;
			try
			{
				b = Integer.parseInt(nums[i]);
			}
			catch (NumberFormatException e)
			{
				throw new ParseException("IP位址必須是整數", 0);
			}
			if (b < 0 || b >= 256)
			{
				throw new ParseException("IP位址值只能在0~255之間", 0);
			}
			a[i] = (byte) b;
		}
		return a;
	}
}
