
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
public class JProgressBarTest2
{
	JFrame frame = new JFrame("測試進度條");
	// 建立一條垂直進度條
	JProgressBar bar = new JProgressBar(JProgressBar.VERTICAL);
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
		// 設置在進度條中繪製完成百分比
		bar.setStringPainted(true);
		// 根據該選擇框決定是否繪製進度條的邊框
		noBorder.addActionListener(event ->
			bar.setBorderPainted(!noBorder.isSelected()));
		final SimulatedActivity target = new SimulatedActivity(1000);
		// 以啟動一條執行緒的方式來執行一個耗時的任務
		new Thread(target).start();
		// 設置進度條的最大值和最小值,
		bar.setMinimum(0);
		// 以總任務量作為進度條的最大值
		bar.setMaximum(target.getAmount());
		// 以任務的當前完成量設置進度條的value
		Timer timer = new Timer(300 , e -> bar.setValue(target.getCurrent()));
		timer.start();
		indeterminate.addActionListener(event ->
		{
			// 設置該進度條的進度是否確定
			bar.setIndeterminate(indeterminate.isSelected());
			bar.setStringPainted(!indeterminate.isSelected());
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		new JProgressBarTest2().init();
	}
}
// 模擬一個耗時的任務
class SimulatedActivity implements Runnable
{
	// 任務的當前完成量
	private volatile int current;
	// 總任務量
	private int amount;
	public SimulatedActivity(int amount)
	{
		current = 0;
		this.amount = amount;
	}
	public int getAmount()
	{
		return amount;
	}
	public int getCurrent()
	{
		return current;
	}
	// run方法代表不斷完成任務的過程
	public void run()
	{
		while (current < amount)
		{
			try
			{
				Thread.sleep(50);
			}
			catch(InterruptedException e)
			{
			}
			current++;
		}
	}
}
