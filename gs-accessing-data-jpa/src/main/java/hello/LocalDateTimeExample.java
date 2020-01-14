package hello;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeExample {

	
	public static void main(String s[]) {
		LocalDate scheduledDate = LocalDate.of(2018, 12, 3);
		LocalTime schedulTIme = LocalTime.of(11, 28, 59);
		System.out.println("scheduledDate -->"+scheduledDate +"<-- schedulTIme --> "+schedulTIme);
		LocalDateTime scheduleDateTime = LocalDateTime.of(scheduledDate, schedulTIme);
		System.out.println(" Test-->"+scheduleDateTime.isAfter(LocalDateTime.now()));
	}
}
