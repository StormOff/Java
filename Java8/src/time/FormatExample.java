package time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatExample {
	
	public String formatSimpleDate(){
		return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
		
	}
	
	public String formatDayMonthYear(){
		return LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
	}

		public LocalDate parseLocalDate(String dateString){
			return LocalDate.parse(dateString);
			
		}
		
	public static void main(String[] args) {
		FormatExample fe=new FormatExample();
		System.out.println(fe.formatSimpleDate());
		System.out.println(fe.formatDayMonthYear());
		System.out.println(fe.parseLocalDate("2014-04-25"));

	}

}
