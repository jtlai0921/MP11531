
import java.util.*;
import java.io.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
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
public class MyTextPane extends JTextPane
{
	protected StyledDocument doc;
	protected SyntaxFormatter formatter = new SyntaxFormatter("my.stx");
	// 定義該文件的普通文字的外觀屬性
	private SimpleAttributeSet normalAttr =
		formatter.getNormalAttributeSet();
	private SimpleAttributeSet quotAttr = new SimpleAttributeSet();
	// 存放文件改變的開始位置
	private int docChangeStart = 0;
	// 存放文件改變的長度
	private int docChangeLength = 0;
	public MyTextPane()
	{
		StyleConstants.setForeground(quotAttr
			, new Color(255, 0 , 255));
		StyleConstants.setFontSize(quotAttr, 16);
		this.doc = super.getStyledDocument();
		// 設置該文件的頁邊距
		this.setMargin(new Insets(3, 40, 0, 0));
		// 添加按鍵監聽器，當按鍵鬆開時進行語法分析
		this.addKeyListener(new KeyAdapter()
		{
			public void keyReleased(KeyEvent ke)
			{
				syntaxParse();
			}
		});
		// 添加文件監聽器
		doc.addDocumentListener(new DocumentListener()
		{
			// 當Document的屬性或屬性集發生了改變時觸發該方法
			public void changedUpdate(DocumentEvent e){}
			// 當向Document中插入文字時觸發該方法
			public void insertUpdate(DocumentEvent e)
			{
				docChangeStart = e.getOffset();
				docChangeLength = e.getLength();
			}
			// 當從Document中刪除文字時觸發該方法
			public void removeUpdate(DocumentEvent e){}
		});
	}
	public void syntaxParse()
	{
		try
		{
			// 獲取文件的根元素，即文件內的全部內容
			Element root = doc.getDefaultRootElement();
			// 獲取文件中游標插入符的位置
			int cursorPos = this.getCaretPosition();
			int line = root.getElementIndex(cursorPos);
			// 獲取游標所在位置的行
			Element para = root.getElement(line);
			// 定義游標所在行的行頭在文件中位置
			int start = para.getStartOffset();
			// 讓start等於start與docChangeStart中較小值。
			start = start > docChangeStart ? docChangeStart :start;
			// 定義被修改部分的長度
			int length = para.getEndOffset() - start;
			length = length < docChangeLength ? docChangeLength + 1
				: length;
			// 取出所有可能被修改的字串
			String s = doc.getText(start, length);
			// 以空格、點號等作為分隔符
			String[] tokens = s.split("\\s+|\\.|\\(|\\)|\\{|\\}|\\[|\\]");
			// 定義當前分析單詞的在s字串中的開始位置
			int curStart = 0;
			// 定義單詞是否處於引號以內
			boolean isQuot = false;
			for (String token : tokens)
			{
				// 找出當前分析單詞在s字串中的位置
				int tokenPos = s.indexOf(token , curStart);
				if (isQuot && (token.endsWith("\"") || token.endsWith("\'")))
				{
					doc.setCharacterAttributes(start + tokenPos
						, token.length(), quotAttr, false);
					isQuot = false;
				}
				else if (isQuot && !(token.endsWith("\"")
					|| token.endsWith("\'")))
				{
					doc.setCharacterAttributes(start + tokenPos
						, token.length(), quotAttr, false);
				}
				else if ((token.startsWith("\"") || token.startsWith("\'"))
					&& (token.endsWith("\"") || token.endsWith("\'")))
				{
					doc.setCharacterAttributes(start + tokenPos
						, token.length(), quotAttr, false);
				}
				else if ((token.startsWith("\"") || token.startsWith("\'"))
					&& !(token.endsWith("\"") || token.endsWith("\'")))
				{
					doc.setCharacterAttributes(start + tokenPos
						, token.length(), quotAttr, false);
					isQuot = true;
				}
				else
				{
					// 使用格式器對當前單詞設置顏色
					formatter.setHighLight(doc , token , start + tokenPos
						, token.length());
				}
				// 開始分析下一個單詞
				curStart = tokenPos + token.length();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	// 重畫該元件，設置行號
	public void paint(Graphics g)
	{
		super.paint(g);
		Element root = doc.getDefaultRootElement();
		// 獲得行號
		int line = root.getElementIndex(doc.getLength());
		// 設置顏色
		g.setColor(new Color(230, 230, 230));
		// 繪製顯示行數的矩形框
		g.fillRect(0 , 0 , this.getMargin().left - 10 , getSize().height);
		// 設置行號的顏色
		g.setColor(new Color(40, 40, 40));
		// 每行繪製一個行號
		for (int count = 0, j = 1; count <= line; count++, j++)
		{
			g.drawString(String.valueOf(j), 3, (int)((count + 1)
				* 1.535 * StyleConstants.getFontSize(normalAttr)));
		}
	}
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("文字編輯器");
		// 使用MyTextPane
		frame.getContentPane().add(new JScrollPane(new MyTextPane()));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(inset, inset, screenSize.width - inset*2
			, screenSize.height - inset * 2);
		frame.setVisible(true);
	}
}
// 定義語法格式器
class SyntaxFormatter
{
	// 以一個Map存放關鍵字和顏色的對應關係
	private Map<SimpleAttributeSet , ArrayList<String>> attMap
		= new HashMap<>();
	// 定義文件的正常文字的外觀屬性
	SimpleAttributeSet normalAttr = new SimpleAttributeSet();
	public SyntaxFormatter(String syntaxFile)
	{
		// 設置正常文字的顏色、大小
		StyleConstants.setForeground(normalAttr, Color.BLACK);
		StyleConstants.setFontSize(normalAttr, 16);
		// 建立一個Scanner物件，負責根據語法檔載入顏色資訊
		Scanner scaner = null;
		try
		{
			scaner = new Scanner(new File(syntaxFile));
		}
		catch (FileNotFoundException e)
		{
			throw new RuntimeException("遺失語法檔："
				+ e.getMessage());
		}
		int color = -1;
		ArrayList<String> keywords = new ArrayList<>();
		// 不斷讀取語法檔的內容行
		while(scaner.hasNextLine())
		{
			String line = scaner.nextLine();
			// 如果當前行以#開頭
			if (line.startsWith("#"))
			{
				if (keywords.size() > 0 && color > -1)
				{
					// 取出當前行的顏色值，並封裝成SimpleAttributeSet物件
					SimpleAttributeSet att = new SimpleAttributeSet();
					StyleConstants.setForeground(att, new Color(color));
					StyleConstants.setFontSize(att, 16);
					// 將當前顏色和關鍵字List對應起來
					attMap.put(att , keywords);
				}
				// 重新增立新的關鍵字List，為下一個語法格式準備
				keywords = new ArrayList<>();
				color = Integer.parseInt(line.substring(1) , 16);
			}
			else
			{
				// 對於普通行，每行內容添加到關鍵字List裡
				if (line.trim().length() > 0)
				{
					keywords.add(line.trim());
				}
			}
		}
		// 把所有關鍵字和顏色對應起來
		if (keywords.size() > 0 && color > -1)
		{
			SimpleAttributeSet att = new SimpleAttributeSet();
			StyleConstants.setForeground(att, new Color(color));
			StyleConstants.setFontSize(att, 16);
			attMap.put(att , keywords);
		}
	}
	// 返回該格式器里正常文字的外觀屬性
	public SimpleAttributeSet getNormalAttributeSet()
	{
		return normalAttr;
	}
	// 設置語法醒目提示
	public void setHighLight(StyledDocument doc , String token
		, int start , int length)
	{
		// 存放需要對當前單詞對應的外觀屬性
		SimpleAttributeSet currentAttributeSet = null;
		outer :
		for (SimpleAttributeSet att : attMap.keySet())
		{
			// 取出當前顏色對應的所有關鍵字
			ArrayList<String> keywords = attMap.get(att);
			// 遍歷所有關鍵字
			for (String keyword : keywords)
			{
				// 如果該關鍵字與當前單詞相同
				if (keyword.equals(token))
				{
					// 跳出迴圈，並設置當前單詞對應的外觀屬性
					currentAttributeSet = att;
					break outer;
				}
			}
		}
		// 如果當前單詞對應的外觀屬性不為空
		if (currentAttributeSet != null)
		{
			// 設置當前單詞的顏色
			doc.setCharacterAttributes(start , length
				, currentAttributeSet , false);
		}
		// 否則使用普通外觀來設置該單詞
		else
		{
			doc.setCharacterAttributes(start , length , normalAttr , false);
		}
	}
}
