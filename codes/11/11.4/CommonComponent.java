
import java.awt.*;
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
public class CommonComponent
{
	Frame f = new Frame("測試");
	// 定義一個按鈕
	Button ok = new Button("確認");
	CheckboxGroup cbg = new CheckboxGroup();
	// 定義一個單選框（處於cbg群組），初始處於被選取狀態
	Checkbox male = new Checkbox("男" , cbg , true);
	// 定義一個單選框（處於cbg群組），初始處於沒有選取狀態
	Checkbox female = new Checkbox("女" , cbg , false);
	// 定義一個核取方塊，初始處於沒有選取狀態
	Checkbox married = new Checkbox("是否已婚？" , false);
	// 定義一個下拉選擇框
	Choice colorChooser = new Choice();
	// 定義一個列表選擇框
	List colorList = new List(6, true);
	// 定義一個5列、20欄的多行文字區域
	TextArea ta = new TextArea(5, 20);
	// 定義一個50欄的單行文字區域
	TextField name = new TextField(50);
	public void init()
	{
		colorChooser.add("紅色");
		colorChooser.add("綠色");
		colorChooser.add("藍色");
		colorList.add("紅色");
		colorList.add("綠色");
		colorList.add("藍色");
		// 建立一個裝載了文字方塊、按鈕的Panel
		Panel bottom = new Panel();
		bottom.add(name);
		bottom.add(ok);
		f.add(bottom , BorderLayout.SOUTH);
		// 建立一個裝載了下拉選擇框、三個Checkbox的Panel
		Panel checkPanel = new Panel();
		checkPanel.add(colorChooser);
		checkPanel.add(male);
		checkPanel.add(female);
		checkPanel.add(married);
		// 建立一個垂直排列元件的Box，盛裝多行文字區域、Panel
		Box topLeft = Box.createVerticalBox();
		topLeft.add(ta);
		topLeft.add(checkPanel);
		// 建立一個水平排列元件的Box，盛裝topLeft、colorList
		Box top = Box.createHorizontalBox();
		top.add(topLeft);
		top.add(colorList);
		// 將top Box容器添加到視窗的中間
		f.add(top);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args)
	{
		new CommonComponent().init();
	}
}
