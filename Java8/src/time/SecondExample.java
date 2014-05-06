package time;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SecondExample {
	
	public boolean isTodayAfterTommorow(){
		
		LocalDate today=LocalDate.now();
		LocalDate tomorrow=today.plusDays(1);
		return tomorrow.isAfter(today);
	}
	
	public DayOfWeek getLastDayOfMonth(){
		
		return LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
	}

	public int howManyDaysUntilLongestDayOfYear(){
		LocalDate today=LocalDate.now();
		LocalDate longestDayOfYear=today.with(Month.JUNE).withDayOfMonth(21);
		
		return Period.between(today,longestDayOfYear).getDays();
		
	}
	
	public Duration howLongUntilNewYear(){
		ZonedDateTime today=ZonedDateTime.now(ZoneId.of("Europe/Kiev"));
		ZonedDateTime newYear=ZonedDateTime.of(2014,12,31,23,59,59,0,ZoneId.of("Europe/Kiev"));
		
		return Duration.between(today,newYear);
		
	}
	public LocalDate createDateFromJavaUtilDate(){
		
		return new Date().toInstant().atZone(ZoneId.of("Europe/Kiev")).toLocalDate();
	}
	
	public List<DayOfWeek> lastDayOfMonthInYear(int year){
		List<DayOfWeek> list=Stream.of(Month.values())
				.map(month->LocalDate.now()
				.withYear(year)
				.with(month)
				.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek())
				.collect(Collectors.toList());

		return list;
		
	}
	
	public static void main(String[] args) {
		SecondExample se=new SecondExample();
		System.out.println(se.isTodayAfterTommorow());
		System.out.println(se.getLastDayOfMonth());
		System.out.println(se.howManyDaysUntilLongestDayOfYear());
		System.out.println(se.howLongUntilNewYear());
		System.out.println(se.createDateFromJavaUtilDate());
		System.out.println(se.lastDayOfMonthInYear(2014));
		
	}


}
