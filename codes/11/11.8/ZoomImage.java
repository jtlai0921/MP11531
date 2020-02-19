
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
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
public class ZoomImage
{
	// 下面兩個常數設置縮小後圖片的大小
	private final int WIDTH = 80;
	private final int HEIGHT = 60;
	// 定義個BuffedImage物件，用於存放縮小後的點陣圖
	BufferedImage image = new BufferedImage(WIDTH , HEIGHT
		, BufferedImage. TYPE_INT_RGB);
	Graphics g = image.getGraphics();
	public void zoom()throws Exception
	{
		// 讀取原始點陣圖
		Image srcImage = ImageIO.read(new File("image/board.jpg"));
		// 將原始點陣圖縮小後繪製到image圖像中
		g.drawImage(srcImage , 0 , 0 , WIDTH , HEIGHT , null);
		// 將image圖像檔案輸出到磁碟檔案中。
		ImageIO.write(image , "jpeg"
			, new File(System.currentTimeMillis() + ".jpg"));
	}
	public static void main(String[] args)throws Exception
	{
		new ZoomImage().zoom();
	}
}
