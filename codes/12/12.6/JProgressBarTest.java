
import java.awt.*;
import java.awt.event.*;
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
public class JProgressBarTest
{
	JFrame frame = new JFrame("測試進度條");
	// 建立一條垂直進度條
	JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL );
	JCheckBox indeterminate = new JCheckBox("不確定進度");
	JCheckBox noBorder = new JCheckBox("不繪製邊框");
	public void init()
	{
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(indeterminate);
		box.add(noBorder);
		frame.setLayout(new FlowLayout());
		frame.add(box);
		// 把進度條添加到JFrame視窗中
		frame.add(bar);
		// 設置進度條的最大值和最小值
		bar.setMinimum(0);
		bar.setMaximum(100);
		// 設置在進度條中繪製完成百分比
		bar.setStringPainted(true);
		// 根據該選擇框決定是否繪製進度條的邊框
		noBorder.addActionListener(event ->
			bar.setBorderPainted(!noBorder.isSelected()));
		indeterminate.addActionListener(event -> {
			// 設置該進度條的進度是否確定
			bar.setIndeterminate(indeterminate.isSelected());
			bar.setStringPainted(!indeterminate.isSelected());
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		// 採用迴圈方式來不斷改變進度條的完成進度
		for (int i = 0 ; i <= 100 ; i++)
		{
			// 改變進度條的完成進度
			bar.setValue(i);
			try
			{
				// 程式暫停0.1秒
				Thread.sleep(100);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args)
	{
		new JProgressBarTest().init();
	}
}

