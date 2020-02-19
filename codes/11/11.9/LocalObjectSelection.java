
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
public class LocalObjectSelection implements Transferable
{
	// 持有一個物件的參照
	private Object obj;
	public LocalObjectSelection(Object obj)
	{
		this.obj = obj;
	}
	// 返回該Transferable物件支援的DataFlavor
	public DataFlavor[] getTransferDataFlavors()
	{
		DataFlavor[] flavors = new DataFlavor[2];
		//獲取被封裝物件的類型
		Class clazz = obj.getClass();
		String mimeType = "application/x-java-jvm-local-objectref;"
			+ "class=" + clazz.getName();
		try
		{
			flavors[0] = new DataFlavor(mimeType);
			flavors[1] = DataFlavor.stringFlavor;
			return flavors;
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
	}
	// 取出該Transferable物件封裝的資料
	public Object getTransferData(DataFlavor flavor)
		throws UnsupportedFlavorException
	{
		if(!isDataFlavorSupported(flavor))
		{
			throw new UnsupportedFlavorException(flavor);
		}
		if (flavor.equals(DataFlavor.stringFlavor))
		{
			return obj.toString();
		}
		return obj;
	}
	public boolean isDataFlavorSupported(DataFlavor flavor)
	{
		return flavor.equals(DataFlavor.stringFlavor) ||
			flavor.getPrimaryType().equals("application")
			&& flavor.getSubType().equals("x-java-jvm-local-objectref")
			&& flavor.getRepresentationClass().isAssignableFrom(obj.getClass());
	}
}

