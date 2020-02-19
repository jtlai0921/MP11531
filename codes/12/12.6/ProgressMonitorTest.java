
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
public class ProgressMonitorTest
{
	Timer timer;
	public void init()
	{
		final SimulatedActivity target = new SimulatedActivity(1000);
		// 以啟動一條執行緒的方式來執行一個耗時的任務
		final Thread targetThread = new Thread(target);
		targetThread.start();
		final ProgressMonitor dialog = new ProgressMonitor(null
			, "等待任務完成" , "已完成：" , 0 , target.getAmount());
		timer = new Timer(300 , e -> {
			// 以任務的當前完成量設置進度對話方塊的完成比例
			dialog.setProgress(target.getCurrent());
			// 如果使用者單擊了進度對話方塊的"取消"按鈕
			if (dialog.isCanceled())
			{
				// 停止計時器
				timer.stop();
				// 中斷任務的執行執行緒
				targetThread.interrupt();    // ①
				// 系統結束
				System.exit(0);
			}
		});
		timer.start();
	}
	public static void main(String[] args)
	{
		new ProgressMonitorTest().init();
	}
}
