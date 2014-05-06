package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FirstExample {
	
	//Создание дня рождения Генри VIII 20.06.1491
	public LocalDate getHenryBirthday(){
		return LocalDate.of(1491, Month.JUNE,20);
	}
	
	public LocalTime getSampleTime(){
		return LocalTime.of(13, 59);
	}
	
	public LocalDateTime getSampleDateTime(){
		return LocalDateTime.of(1491, Month.JUNE,20,13,59);
	}
	
	public LocalDateTime getComponentDateTime(){
		return LocalDateTime.of(getHenryBirthday(),getSampleTime());
	}
	
	public LocalDate getTodayFromLocalDateTime(){
		return LocalDateTime.now().toLocalDate();
	}
	
	public int getDifferenceBetweenParisAndLondon(){
		ZonedDateTime paris=ZonedDateTime.now(ZoneId.of("Europe/Paris"));
		ZonedDateTime london=ZonedDateTime.now(ZoneId.of("Europe/London"));
		return paris.getHour()-london.getHour();
		
	}
	
	public static void main(String[] args) {
		
		FirstExample ex=new FirstExample();
		System.out.println(ex.getHenryBirthday());
		System.out.println(ex.getSampleTime());
		System.out.println(ex.getComponentDateTime());
		System.out.println(ex.getSampleDateTime());
		System.out.println(ex.getTodayFromLocalDateTime());
		System.out.println(ex.getDifferenceBetweenParisAndLondon());
	}

}
