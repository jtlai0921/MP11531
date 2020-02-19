
import java.awt.*;
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
public class GridBagTest
{
	private Frame f = new Frame("測試視窗");
	private GridBagLayout gb = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private Button[] bs = new Button[10];
	public void init()
	{
		f.setLayout(gb);
		for (int i = 0; i < bs.length ; i++ )
		{
			bs[i] = new Button("按鈕" + i);
		}
		// 所有元件都可以橫向、縱向上擴大
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1;
		addButton(bs[0]);
		addButton(bs[1]);
		addButton(bs[2]);
		// 該GridBagConstraints控制的GUI元件將會成為橫向最後一個元素
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		addButton(bs[3]);
		// 該GridBagConstraints控制的GUI元件將橫向上不會擴大
		gbc.weightx = 0;
		addButton(bs[4]);
		// 該GridBagConstraints控制的GUI元件將橫跨兩個網格
		gbc.gridwidth = 2;
		addButton(bs[5]);
		// 該GridBagConstraints控制的GUI元件將橫跨一個網格
		gbc.gridwidth = 1;
		// 該GridBagConstraints控制的GUI元件將縱向跨兩個網格
		gbc.gridheight = 2;
		// 該GridBagConstraints控制的GUI元件將會成為橫向最後一個元素
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		addButton(bs[6]);
		// 該GridBagConstraints控制的GUI元件將橫向跨越一個網格，縱向跨越2個網格。
		gbc.gridwidth = 1;
		gbc.gridheight = 2;
		// 該GridBagConstraints控制的GUI元件縱向擴大的權重是1
		gbc.weighty = 1;
		addButton(bs[7]);
		// 設置下面的按鈕在縱向上不會擴大
		gbc.weighty = 0;
		// 該GridBagConstraints控制的GUI元件將會成為橫向最後一個元素
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		// 該GridBagConstraints控制的GUI元件將縱向上橫跨一個網格
		gbc.gridheight = 1;
		addButton(bs[8]);
		addButton(bs[9]);
		f.pack();
		f.setVisible(true);
	}
	private void addButton(Button button)
	{
		gb.setConstraints(button, gbc);
		f.add(button);
	}
	public static void main(String[] args)
	{
		new GridBagTest().init();
	}
}
