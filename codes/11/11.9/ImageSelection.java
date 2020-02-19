
import java.awt.*;
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
public class ImageSelection implements Transferable
{
	private Image image;
	// 建構子，負責持有一個Image物件
	public ImageSelection(Image image)
	{
		this.image = image;
	}
	// 返回該Transferable物件所支援的所有DataFlavor
	public DataFlavor[] getTransferDataFlavors()
	{
		return new DataFlavor[]{DataFlavor.imageFlavor};
	}
	// 取出該Transferable物件裡實際的資料
	public Object getTransferData(DataFlavor flavor)
		throws UnsupportedFlavorException
	{
		if(flavor.equals(DataFlavor.imageFlavor))
		{
			return image;
		}
		else
		{
			throw new UnsupportedFlavorException(flavor);
		}
	}
	// 返回該Transferable物件是否支援指定的DataFlavor
	public boolean isDataFlavorSupported(DataFlavor flavor)
	{
		return flavor.equals(DataFlavor.imageFlavor);
	}
}
