
import java.util.*;
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
public class RandomTest
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		System.out.println("rand.nextBoolean()："
			+ rand.nextBoolean());
		byte[] buffer = new byte[16];
		rand.nextBytes(buffer);
		System.out.println(Arrays.toString(buffer));
		// 產生0.0~1.0之間的偽隨機double數
		System.out.println("rand.nextDouble()："
			+ rand.nextDouble());
		// 產生0.0~1.0之間的偽隨機float數
		System.out.println("rand.nextFloat()："
			+ rand.nextFloat());
		// 產生平均值是 0.0，標準差是 1.0的偽高斯數
		System.out.println("rand.nextGaussian()："
			+ rand.nextGaussian());
		// 產生一個處於int整數取值範圍的偽隨機整數
		System.out.println("rand.nextInt()：" + rand.nextInt());
		// 產生0~26之間的偽隨機整數
		System.out.println("rand.nextInt(26)：" + rand.nextInt(26));
		// 產生一個處於long整數取值範圍的偽隨機整數
		System.out.println("rand.nextLong()：" +  rand.nextLong());
	}
}
