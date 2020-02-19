

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
// 定義Apple類別時使用了泛型宣告
public class Apple<T>
{
	// 使用T類型形式參數定義實例變數
	private T info;
	public Apple(){}
	// 下面方法中使用T類型形式參數來定義建構子
	public Apple(T info)
	{
		this.info = info;
	}
	public void setInfo(T info)
	{
		this.info = info;
	}
	public T getInfo()
	{
		return this.info;
	}
	public static void main(String[] args)
	{
		// 由於傳給T形式參數的是String，所以建構子參數只能是String
		Apple<String> a1 = new Apple<>("蘋果");
		System.out.println(a1.getInfo());
		// 由於傳給T形式參數的是Double，所以建構子參數只能是Double或double
		Apple<Double> a2 = new Apple<>(5.67);
		System.out.println(a2.getInfo());
	}
}

