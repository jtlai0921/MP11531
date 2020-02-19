
import java.awt.datatransfer.*;
import java.io.*;
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
public class SerialSelection implements Transferable
{
	// 持有一個可序列化的物件
	private Serializable obj;
	// 建立該類別的物件時傳入被持有的物件
	public SerialSelection(Serializable obj)
	{
		this.obj = obj;
	}
	public DataFlavor[] getTransferDataFlavors()
	{
		DataFlavor[] flavors = new DataFlavor[2];
		// 獲取被封裝物件的類型
		Class clazz = obj.getClass();
		try
		{
			flavors[0] = new DataFlavor(DataFlavor.javaSerializedObjectMimeType
				+ ";class=" + clazz.getName());
			flavors[1] = DataFlavor.stringFlavor;
			return flavors;
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
			return null;
		}
	}
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
			&& flavor.getSubType().equals("x-java-serialized-object")
			&& flavor.getRepresentationClass().isAssignableFrom(obj.getClass());
	}
}
