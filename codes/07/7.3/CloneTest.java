

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

class Address
{
	String detail;
	public Address(String detail)
	{
		this.detail = detail;
	}
}
// 實作Cloneable介面
class User implements Cloneable
{
	int age;
	Address address;
	public User(int age)
	{
		this.age = age;
		address = new Address("廣州天河");
	}
	// 通過呼叫super.clone()來實作clone()方法
	public User clone()
		throws CloneNotSupportedException
	{
		return (User)super.clone();
	}
}
public class CloneTest
{
	public static void main(String[] args)
		throws CloneNotSupportedException
	{
		User u1 = new User(29);
		// clone得到u1物件的副本。
		User u2 = u1.clone();
		// 判斷u1、u2是否相同
		System.out.println(u1 == u2);      //①
		// 判斷u1、u2的address是否相同
		System.out.println(u1.address == u2.address);     //②
	}
}
