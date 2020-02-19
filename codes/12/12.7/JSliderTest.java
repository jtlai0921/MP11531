
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.Dictionary;
import java.util.Hashtable;
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
public class JSliderTest
{
	JFrame mainWin = new JFrame("滑動軸示範");
	Box sliderBox = new Box(BoxLayout.Y_AXIS);
	JTextField showVal = new JTextField();
	ChangeListener listener;
	public void init()
	{
		// 定義一個監聽器，用於監聽所有滑動軸
		listener = event -> {
			// 取出滑動軸的值，並在文字中顯示出來
			JSlider source = (JSlider) event.getSource();
			showVal.setText("當前滑動軸的值為："
				+ source.getValue());
		};
		// -----------添加一個普通滑動軸-----------
		JSlider slider = new JSlider();
		addSlider(slider, "普通滑動軸");
		// -----------添加保留區為30的滑動軸-----------
		slider = new JSlider();
		slider.setExtent(30);
		addSlider(slider, "保留區為30");
		// ---添加帶主、次刻度的滑動軸,並設置其最大值，最小值---
		slider = new JSlider(30 , 200);
		// 設置繪製刻度
		slider.setPaintTicks(true);
		// 設置主、次刻度的間距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "有刻度");
		// -----------添加滑桿必須停在刻度處滑動軸-----------
		slider = new JSlider();
		// 設置滑桿必須停在刻度處
		slider.setSnapToTicks(true);
		// 設置繪製刻度
		slider.setPaintTicks(true);
		// 設置主、次刻度的間距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "滑桿停在刻度處");
		// -----------添加沒有滑軌的滑動軸-----------
		slider = new JSlider();
		// 設置繪製刻度
		slider.setPaintTicks(true);
		// 設置主、次刻度的間距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// 設置不繪製滑軌
		slider.setPaintTrack(false);
		addSlider(slider, "無滑軌");
		// -----------添加方向反轉的滑動軸-----------
		slider = new JSlider();
		// 設置繪製刻度
		slider.setPaintTicks(true);
		// 設置主、次刻度的間距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// 設置方向反轉
		slider.setInverted(true);
		addSlider(slider, "方向反轉");
		// --------添加繪製預設刻度標籤的滑動軸--------
		slider = new JSlider();
		// 設置繪製刻度
		slider.setPaintTicks(true);
		// 設置主、次刻度的間距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// 設置繪製刻度標籤，預設繪製數值刻度標籤
		slider.setPaintLabels(true);
		addSlider(slider, "數值刻度標籤");
		// ------添加繪製Label類型的刻度標籤的滑動軸------
		slider = new JSlider();
		// 設置繪製刻度
		slider.setPaintTicks(true);
		// 設置主、次刻度的間距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// 設置繪製刻度標籤
		slider.setPaintLabels(true);
		Dictionary<Integer, Component> labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));
		// 指定刻度標籤，標籤是JLabel
		slider.setLabelTable(labelTable);
		addSlider(slider, "JLable標籤");
		// ------添加繪製Label類型的刻度標籤的滑動軸------
		slider = new JSlider();
		// 設置繪製刻度
		slider.setPaintTicks(true);
		// 設置主、次刻度的間距
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		// 設置繪製刻度標籤
		slider.setPaintLabels(true);
		labelTable = new Hashtable<Integer, Component>();
		labelTable.put(0, new JLabel(new ImageIcon("ico/0.GIF")));
		labelTable.put(20, new JLabel(new ImageIcon("ico/2.GIF")));
		labelTable.put(40, new JLabel(new ImageIcon("ico/4.GIF")));
		labelTable.put(60, new JLabel(new ImageIcon("ico/6.GIF")));
		labelTable.put(80, new JLabel(new ImageIcon("ico/8.GIF")));
		// 指定刻度標籤，標籤是ImageIcon
		slider.setLabelTable(labelTable);
		addSlider(slider, "Icon標籤");
		mainWin.add(sliderBox, BorderLayout.CENTER);
		mainWin.add(showVal, BorderLayout.SOUTH);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	// 定義一個方法，用於將滑動軸添加到容器中
	public void addSlider(JSlider slider, String description)
	{
		slider.addChangeListener(listener);
		Box box = new Box(BoxLayout.X_AXIS);
		box.add(new JLabel(description + "："));
		box.add(slider);
		sliderBox.add(box);
	}
	public static void main(String[] args)
	{
		new JSliderTest().init();
	}
}

