
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;
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

class Person
{
	private String name;
	private int age;

	public Person(){}

	public Person(String name , int age)
	{
		this.name = name;
		this.age = age;
	}
	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		 return this.name;
	}

	// age的setter和getter方法
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		 return this.age;
	}
	public String toString()
	{
		return "Person[ name=" + name + " , age=" + age + " ]";
	}
}
public class CopyPerson
{
	Frame f = new Frame("複製物件");
	Button copy = new Button("複製");
	Button paste = new Button("貼上");
	TextField name = new TextField(15);
	TextField age = new TextField(15);
	TextArea ta = new TextArea(3 , 30);
	// 建立本地的剪貼簿
	Clipboard clipboard = new Clipboard("cp");
	public void init()
	{
		Panel p = new Panel();
		p.add(new Label("姓名"));
		p.add(name);
		p.add(new Label("年齡"));
		p.add(age);
		f.add(p , BorderLayout.NORTH);
		f.add(ta);
		Panel bp = new Panel();
		// 為「複製」按鈕添加事件監聽器
		copy.addActionListener(e -> copyPerson());
		// 為「貼上」按鈕添加事件監聽器
		paste.addActionListener(e ->
		{
			try
			{
				readPerson();
			}
			catch (Exception ee)
			{
				ee.printStackTrace();
			}
		});
		bp.add(copy);
		bp.add(paste);
		f.add(bp , BorderLayout.SOUTH);
		f.pack();
		f.setVisible(true);
	}
	public void copyPerson()
	{
		// 以name,age文字方塊的內容建立Person物件
		Person p = new Person(name.getText()
			, Integer.parseInt(age.getText()));
		// 將Person物件封裝成LocalObjectSelection物件
		LocalObjectSelection ls = new LocalObjectSelection(p);
		// 將LocalObjectSelection物件放入本地剪貼簿
		clipboard.setContents(ls , null);
	}
	public void readPerson()throws Exception
	{
		// 建立存放Person物件參照的DataFlavor物件
		DataFlavor peronFlavor = new DataFlavor(
			"application/x-java-jvm-local-objectref;class=Person");
		// 取出本地剪貼簿內的內容
		if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor))
		{
			Person p = (Person)clipboard.getData(peronFlavor);
			ta.setText(p.toString());
		}
	}
	public static void main(String[] args)
	{
		new CopyPerson().init();
	}
}

