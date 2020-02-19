
import java.time.*;
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
public class NewDatePackageTest
{
	public static void main(String[] args)
	{
		// -----下面是關於Clock的用法-----
		// 獲取當前Clock
		Clock clock = Clock.systemUTC();
		// 通過Clock獲取當前時刻
		System.out.println("當前時刻為：" + clock.instant());
		// 獲取clock對應的毫秒數，與System.currentTimeMillis()輸出相同
		System.out.println(clock.millis());
		System.out.println(System.currentTimeMillis());
		// -----下面是關於Duration的用法-----
		Duration d = Duration.ofSeconds(6000);
		System.out.println("6000秒相當於" + d.toMinutes() + "分");
		System.out.println("6000秒相當於" + d.toHours() + "小時");
		System.out.println("6000秒相當於" + d.toDays() + "天");
		// 在clock基礎上增加6000秒，返回新的Clock
		Clock clock2 = Clock.offset(clock, d);
		// 可看到clock2與clock1相差1小時40分
		System.out.println("當前時刻加6000秒為：" +clock2.instant());
		// -----下面是關於Instant的用法-----
		// 獲取當前時間
		Instant instant = Instant.now();
		System.out.println(instant);
		// instant添加6000秒（即100分鐘），返回新的Instant
		Instant instant2 = instant.plusSeconds(6000);
		System.out.println(instant2);
		// 根據字串中解析Instant物件
		Instant instant3 = Instant.parse("2014-02-23T10:12:35.342Z");
		System.out.println(instant3);
		// 在instant3的基礎上添加5小時4分鐘
		Instant instant4 = instant3.plus(Duration
			.ofHours(5).plusMinutes(4));
		System.out.println(instant4);
		// 獲取instant4的5天以前的時刻
		Instant instant5 = instant4.minus(Duration.ofDays(5));
		System.out.println(instant5);
		// -----下面是關於LocalDate的用法-----
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		// 獲得2014年的第146天
		localDate = LocalDate.ofYearDay(2014, 146);
		System.out.println(localDate); // 2014-05-26
		// 設置為2014年5月21日
		localDate = LocalDate.of(2014, Month.MAY, 21);
		System.out.println(localDate); // 2014-05-21
		// -----下面是關於LocalTime的用法-----
		// 獲取當前時間
		LocalTime localTime = LocalTime.now();
		// 設置為22點33分
		localTime = LocalTime.of(22, 33);
		System.out.println(localTime); // 22:33
		// 返回一天中的第5503秒
		localTime = LocalTime.ofSecondOfDay(5503);
		System.out.println(localTime); // 01:31:43
		// -----下面是關於localDateTime的用法-----
		// 獲取當前日期、時間
		LocalDateTime localDateTime = LocalDateTime.now();
		// 當前日期、時間加上25小時３分鐘
		LocalDateTime future = localDateTime.plusHours(25).plusMinutes(3);
		System.out.println("當前日期、時間的25小時3分之後：" + future);
		// 下面是關於Year、YearMonth、MonthDay的用法範例-----
		Year year = Year.now(); // 獲取當前的年份
		System.out.println("當前年份：" + year); // 輸出當前年份
		year = year.plusYears(5); // 當前年份再加5年
		System.out.println("當前年份再過5年：" + year);
		// 根據指定月份獲取YearMonth
		YearMonth ym = year.atMonth(10);
		System.out.println("year年10月：" + ym); // 輸出XXXX-10，XXXX代表當前年份
		// 當前年月再加5年，減3個月
		ym = ym.plusYears(5).minusMonths(3);
		System.out.println("year年10月再加5年、減3個月：" + ym);
		MonthDay md = MonthDay.now();
		System.out.println("當前月日：" + md); // 輸出--XX-XX，代表幾月幾日
		// 設置為5月23日
		MonthDay md2 = md.with(Month.MAY).withDayOfMonth(23);
		System.out.println("5月23日為：" + md2); // 輸出--05-23
	}
}