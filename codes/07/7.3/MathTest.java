

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
public class MathTest
{
	public static void main(String[] args)
	{
		/*---------下面是三角運算---------*/
		// 將弧度轉換角度
		System.out.println("Math.toDegrees(1.57)："
			+ Math.toDegrees(1.57));
		// 將角度轉換為弧度
		System.out.println("Math.toRadians(90)："
			+ Math.toRadians(90));
		// 運算反餘弦，返回的角度範圍在 0.0 到 pi 之間。
		System.out.println("Math.acos(1.2)：" + Math.acos(1.2));
		// 運算反正弦；返回的角度範圍在 -pi/2 到 pi/2 之間。
		System.out.println("Math.asin(0.8)：" + Math.asin(0.8));
		// 運算反正切；返回的角度範圍在 -pi/2 到 pi/2 之間。
		System.out.println("Math.atan(2.3)：" + Math.atan(2.3));
		// 運算三角餘弦。
		System.out.println("Math.cos(1.57)：" + Math.cos(1.57));
		// 運算值的雙曲餘弦。
		System.out.println("Math.cosh(1.2 )：" + Math.cosh(1.2 ));
		// 運算正弦
		System.out.println("Math.sin(1.57 )：" + Math.sin(1.57 ));
		// 運算雙曲正弦
		System.out.println("Math.sinh(1.2 )：" + Math.sinh(1.2 ));
		// 運算三角正切
		System.out.println("Math.tan(0.8 )：" + Math.tan(0.8 ));
		// 運算雙曲正切
		System.out.println("Math.tanh(2.1 )：" + Math.tanh(2.1 ));
		// 將矩形座標 (x, y) 轉換成極座標 (r, thet));
		System.out.println("Math.atan2(0.1, 0.2)：" + Math.atan2(0.1, 0.2));
		/*---------下面是取整運算---------*/
		// 取整，返回小於目標數的最大整數。
		System.out.println("Math.floor(-1.2 )：" + Math.floor(-1.2 ));
		// 取整，返回大於目標數的最小整數。
		System.out.println("Math.ceil(1.2)：" + Math.ceil(1.2));
		// 四捨五入取整
		System.out.println("Math.round(2.3 )：" + Math.round(2.3 ));
		/*---------下面是乘方、開方、指數運算---------*/
		// 運算平方根。
		System.out.println("Math.sqrt(2.3 )：" + Math.sqrt(2.3 ));
		// 運算立方根。
		System.out.println("Math.cbrt(9)：" + Math.cbrt(9));
		// 返回歐拉數 e 的n次冪。
		System.out.println("Math.exp(2)：" + Math.exp(2));
		// 返回 sqrt(x2 +y2)
		System.out.println("Math.hypot(4 , 4)：" + Math.hypot(4 , 4));
		// 按照 IEEE 754 標準的規定，對兩個參數進行餘數運算。
		System.out.println("Math.IEEEremainder(5 , 2)："
			+ Math.IEEEremainder(5 , 2));
		// 運算乘方
		System.out.println("Math.pow(3, 2)：" + Math.pow(3, 2));
		// 運算自然對數
		System.out.println("Math.log(12)：" + Math.log(12));
		// 運算底數為 10 的對數。
		System.out.println("Math.log10(9)：" + Math.log10(9));
		// 返回參數與 1 之和的自然對數。
		System.out.println("Math.log1p(9)：" + Math.log1p(9));
		/*---------下面是符號相關的運算---------*/
		// 運算絕對值。
		System.out.println("Math.abs(-4.5)：" + Math.abs(-4.5));
		// 符號賦值，返迴帶有第二個浮點數符號的第一個浮點參數。
		System.out.println("Math.copySign(1.2, -1.0)："
			+ Math.copySign(1.2, -1.0));
		// 符號函數；如果參數為 0，則返回 0；如果參數大於 0，
		// 則返回 1.0；如果參數小於 0，則返回 -1.0。
		System.out.println("Math.signum(2.3)：" + Math.signum(2.3));
		/*---------下面是大小相關的運算---------*/
		// 找出最大值
		System.out.println("Math.max(2.3 , 4.5)：" + Math.max(2.3 , 4.5));
		// 運算最小值
		System.out.println("Math.min(1.2 , 3.4)：" + Math.min(1.2 , 3.4));
		// 返回第一個參數和第二個參數之間與第一個參數相鄰的浮點數。
		System.out.println("Math.nextAfter(1.2, 1.0)："
			+ Math.nextAfter(1.2, 1.0));
		// 返回比目標數略大的浮點數
		System.out.println("Math.nextUp(1.2 )：" + Math.nextUp(1.2 ));
		// 返回一個偽隨機數，該值大於等於 0.0 且小於 1.0。
		System.out.println("Math.random()：" + Math.random());
	}
}
