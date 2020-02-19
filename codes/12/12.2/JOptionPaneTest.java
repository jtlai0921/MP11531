
import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
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
public class JOptionPaneTest
{
	JFrame jf = new JFrame("測試JOptionPane");
	// 分別定義6個面板用於定義對話方塊的幾種選項
	private ButtonPanel messagePanel;
	private ButtonPanel messageTypePanel;
	private ButtonPanel msgPanel;
	private ButtonPanel confirmPanel;
	private ButtonPanel optionsPanel;
	private ButtonPanel inputPanel;
	private String messageString = "訊息區內容";
	private Icon messageIcon = new ImageIcon("ico/heart.png");
	private Object messageObject = new Date();
	private Component messageComponent = new JButton("元件訊息");
	private JButton msgBn = new JButton("訊息對話方塊");
	private JButton confrimBn = new JButton("確認對話方塊");
	private JButton inputBn = new JButton("輸入對話方塊");
	private JButton optionBn = new JButton("選項對話方塊");
	public void init()
	{
		JPanel top = new JPanel();
		top.setBorder(new TitledBorder(new EtchedBorder()
			, "對話方塊的通用選項" , TitledBorder.CENTER ,TitledBorder.TOP));
		top.setLayout(new GridLayout(1 , 2));
		// 訊息類型Panel，該Panel中的選項決定對話方塊的圖示
		messageTypePanel = new ButtonPanel("選擇訊息的類型",
		new String[]{"ERROR_MESSAGE", "INFORMATION_MESSAGE"
			, "WARNING_MESSAGE", "QUESTION_MESSAGE",	"PLAIN_MESSAGE" });
		// 訊息內容類型的Panel，該Panel中的選項決定對話方塊的訊息區的內容
		messagePanel = new ButtonPanel("選擇訊息內容的類型",
			new String[]{"字串訊息", "圖示訊息", "元件訊息"
				, "普通物件訊息" , "Object[]訊息"});
		top.add(messageTypePanel);
		top.add(messagePanel);
		JPanel bottom = new JPanel();
		bottom.setBorder(new TitledBorder(new EtchedBorder()
			, "彈出不同的對話方塊" , TitledBorder.CENTER ,TitledBorder.TOP));
		bottom.setLayout(new GridLayout(1 , 4));
		// 建立用於彈出訊息對話方塊的Panel
		msgPanel = new ButtonPanel("訊息對話方塊", null);
		msgBn.addActionListener(new ShowAction());
		msgPanel.add(msgBn);
		// 建立用於彈出確認對話方塊的Panel
		confirmPanel = new ButtonPanel("確認對話方塊",
			new String[]{"DEFAULT_OPTION", "YES_NO_OPTION"
				, "YES_NO_CANCEL_OPTION","OK_CANCEL_OPTION"});
		confrimBn.addActionListener(new ShowAction());
		confirmPanel.add(confrimBn);
		// 建立用於彈出輸入對話方塊的Panel
		inputPanel = new ButtonPanel("輸入對話方塊"
			, new String[]{"單行文字方塊","下拉列表選擇框"});
		inputBn.addActionListener(new ShowAction());
		inputPanel.add(inputBn);
		// 建立用於彈出選項對話方塊的Panel
		optionsPanel = new ButtonPanel("選項對話方塊"
			, new String[]{"字串選項", "圖示選項", "物件選項"});
		optionBn.addActionListener(new ShowAction());
		optionsPanel.add(optionBn);
		bottom.add(msgPanel);
		bottom.add(confirmPanel);
		bottom.add(inputPanel);
		bottom.add(optionsPanel);
		Box box = new Box(BoxLayout.Y_AXIS);
		box.add(top);
		box.add(bottom);
		jf.add(box);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.pack();
		jf.setVisible(true);
	}
	// 根據使用者選擇返回選項類型
	private int getOptionType()
	{
		switch(confirmPanel.getSelection())
		{
			case "DEFAULT_OPTION":
				return JOptionPane.DEFAULT_OPTION;
			case "YES_NO_OPTION":
				return JOptionPane.YES_NO_OPTION;
			case "YES_NO_CANCEL_OPTION":
				return JOptionPane.YES_NO_CANCEL_OPTION;
			default:
				return JOptionPane.OK_CANCEL_OPTION;
		}
	}
	// 根據使用者選擇返回訊息
	private Object getMessage()
	{
		switch(messagePanel.getSelection())
		{
			case "字串訊息":
				return messageString;
			case "圖示訊息":
				return messageIcon;
			case "元件訊息":
				return messageComponent;
			case "普通物件訊息":
				return messageObject;
			default:
				return new Object[]{messageString , messageIcon
					, messageObject , messageComponent};
		}
	}
	// 根據使用者選擇返回訊息類型（決定圖示區的圖示）
	private int getDialogType()
	{
		switch(messageTypePanel.getSelection())
		{
			case "ERROR_MESSAGE":
				return JOptionPane.ERROR_MESSAGE;
			case "INFORMATION_MESSAGE":
				return JOptionPane.INFORMATION_MESSAGE;
			case "WARNING_MESSAGE":
				return JOptionPane.WARNING_MESSAGE;
			case "QUESTION_MESSAGE":
				return JOptionPane.QUESTION_MESSAGE;
			default:
				return JOptionPane.PLAIN_MESSAGE;
		}
	}
	private Object[] getOptions()
	{
		switch(optionsPanel.getSelection())
		{
			case "字串選項":
				return new String[]{"a" , "b" , "c" , "d"};
			case "圖示選項":
				return new Icon[]{new ImageIcon("ico/1.gif")
					, new ImageIcon("ico/2.gif")
					, new ImageIcon("ico/3.gif")
					, new ImageIcon("ico/4.gif")};
			default:
				return new Object[]{new Date() ,new Date() , new Date()};
		}
	}
	// 為各按鈕定義事件監聽器
	private class ShowAction implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			switch(event.getActionCommand())
			{
				case "確認對話方塊":
					JOptionPane.showConfirmDialog(jf , getMessage()
						,"確認對話方塊", getOptionType(), getDialogType());
					break;
				case "輸入對話方塊":
					if (inputPanel.getSelection().equals("單行文字方塊"))
					{
						JOptionPane.showInputDialog(jf, getMessage()
							, "輸入對話方塊", getDialogType());
					}
					else
					{
						JOptionPane.showInputDialog(jf, getMessage()
							, "輸入對話方塊", getDialogType() , null
							, new String[]{"輕量級Java EE企業應用實戰"
							, "瘋狂Java講義"}, "瘋狂Java講義");
					}
					break;
				case "訊息對話方塊":
					JOptionPane.showMessageDialog(jf,getMessage()
						,"訊息對話方塊", getDialogType());
					break;
				case "選項對話方塊":
					JOptionPane.showOptionDialog(jf , getMessage()
						, "選項對話方塊", getOptionType() , getDialogType()
						, null,getOptions(), "a");
					break;
			}
		}
	}
	public static void main(String[] args)
	{
		new JOptionPaneTest().init();
	}
}

// 定義一個JPanel類別擴展類別，該類別的物件包含多個縱向排列的
// JRadioButton控制項,且Panel擴展類別可以指定一個字串作為TitledBorder
class ButtonPanel extends JPanel
{
	private ButtonGroup group;
	public ButtonPanel(String title, String[] options)
	{
		setBorder(BorderFactory.createTitledBorder(BorderFactory
			.createEtchedBorder(), title));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		group = new ButtonGroup();
		for (int i = 0; options!= null && i < options.length; i++)
		{
			JRadioButton b = new JRadioButton(options[i]);
			b.setActionCommand(options[i]);
			add(b);
			group.add(b);
			b.setSelected(i == 0);
		}
	}
	// 定義一個方法，用於返回使用者選擇的選項
	public String getSelection()
	{
		return group.getSelection().getActionCommand();
	}
}
