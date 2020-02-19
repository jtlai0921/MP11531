
import java.math.BigDecimal;
import java.util.*;

import java.awt.BorderLayout;
import java.awt.event.*;
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
public class ListModelTest
{
	private JFrame mainWin = new JFrame("測試ListModel");
	// 根據NumberListModel物件來建立一個JList物件
	private JList<BigDecimal> numScopeList = new JList<>(
		new NumberListModel(1 , 21 , 2));
	// 根據NumberComboBoxModel物件來建立JComboBox物件
	private JComboBox<BigDecimal> numScopeSelector = new JComboBox<>(
		new NumberComboBoxModel(0.1 , 1.2 , 0.1));
	private JTextField showVal = new JTextField(10);
	public void init()
	{
		// JList的可視高度可同時顯示4個列表項目
		numScopeList.setVisibleRowCount(4);
		// 預設選取第三項到第五項（第一項的索引是0）
		numScopeList.setSelectionInterval(2, 4);
		// 設置每個列表項目具有指定的高度和寬度。
		numScopeList.setFixedCellHeight(30);
		numScopeList.setFixedCellWidth(90);
		// 為numScopeList添加監聽器
		numScopeList.addListSelectionListener(e ->
		{
			// 獲取使用者所選取的所有數字
			List<BigDecimal> nums = numScopeList.getSelectedValuesList();
			showVal.setText("");
			// 把使用者選取的數字添加到單行文字方塊中
			for (BigDecimal num : nums )
			{
				showVal.setText(showVal.getText()
					+ num.toString() + ", ");
			}
		});
		// 設置列表項目的可視高度可顯示5個列表項目
		numScopeSelector.setMaximumRowCount(5);
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JScrollPane(numScopeList));
		JPanel p = new JPanel();
		p.add(numScopeSelector);
		box.add(p);
		// 為numScopeSelector添加監聽器
		numScopeSelector.addItemListener(e -> {
			// 獲取JComboBox中選取的數字
			Object num = numScopeSelector.getSelectedItem();
			showVal.setText(num.toString());
		});
		JPanel bottom = new JPanel();
		bottom.add(new JLabel("您選擇的值是："));
		bottom.add(showVal);
		mainWin.add(box);
		mainWin.add(bottom , BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public static void main(String[] args)
	{
		new ListModelTest().init();
	}
}
class NumberListModel extends AbstractListModel<BigDecimal>
{
	protected BigDecimal start;
	protected BigDecimal end;
	protected BigDecimal step;
	public NumberListModel(double start
		, double end , double step)
	{
		this.start = BigDecimal.valueOf(start);
		this.end = BigDecimal.valueOf(end);
		this.step = BigDecimal.valueOf(step);
	}
	// 返回列表項目的個數
	public int getSize()
	{
		return (int)Math.floor(end.subtract(start)
			.divide(step).doubleValue()) + 1;
	}
	// 返回指定索引處的列表項目
	public BigDecimal getElementAt(int index)
	{
		return BigDecimal.valueOf(index)
			.multiply(step).add(start);
	}
}
class NumberComboBoxModel extends NumberListModel
	implements ComboBoxModel<BigDecimal>
{
	// 用於存放使用者選取項目的索引
	private int selectId = 0;
	public NumberComboBoxModel(double start
		, double end , double step)
	{
		super(start , end , step);
	}
	// 設置選取「選擇項目」
	public void setSelectedItem(Object anItem)
	{
		if (anItem instanceof BigDecimal)
		{
			BigDecimal target = (BigDecimal)anItem;
			// 根據選取的值來修改選取項目的索引
			selectId = target.subtract(super.start)
				.divide(step).intValue();
		}
	}
	// 獲取「選擇項目」的值
	public BigDecimal getSelectedItem()
	{
		// 根據選取項目的索引來取得選取項目
		return BigDecimal.valueOf(selectId)
			.multiply(step).add(start);
	}
}
