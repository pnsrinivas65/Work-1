package hello;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.IsoChronology;
import java.time.chrono.IsoEra;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.util.Arrays;

import com.annotations.TestAnnot;

public class LocalDateExample {

	private static final String DATE_FORMAT_MMDDYY = "MMddyy";
	private static final String TIME_FORMAT_HH_MM_SS = "HHmmss";
		

	@TestAnnot(enabled=false)
	public static void main(String s[]) {

		/*
		 * System.out.println(LocalDate.parse("023119",
		 * DateTimeFormatter.ofPattern(DATE_FORMAT_MMDDYY)));
		 * 
		 * //String dateFormat = "MMddyy"; String dateString = "022819";
		 * DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder()
		 * .parseCaseInsensitive() .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
		 * .optionalStart() .appendOffsetId() .optionalEnd()
		 * .toFormatter().withZone(ZoneId.of("UTC")); try {
		 * 
		 * LocalDateTime date = LocalDateTime.parse(dateString, dateTimeFormatter);
		 * System.out.println(date); } catch (DateTimeParseException e) { // Throw
		 * invalid date message e.printStackTrace();
		 * //System.out.println("Exception was thrown"); }
		 * 
		 * 
		 * //Create formatter DateTimeFormatter FOMATTER = new
		 * DateTimeFormatterBuilder() // case insensitive to parse JAN and FEB
		 * .parseCaseInsensitive() // add pattern .appendPattern(DATE_FORMAT_MMDDYY) //
		 * create formatter (use English Locale to parse month names)
		 * .toFormatter(Locale.ENGLISH) .withResolverStyle(ResolverStyle.LENIENT);
		 * 
		 * //DateTimeFormatter FOMATTER =
		 * DateTimeFormatter.ofPattern(DATE_FORMAT_MMDDYY);
		 * 
		 * //Local date instance LocalDate localDate = LocalDate.parse("022819",
		 * FOMATTER);
		 * 
		 * //Get formatted String //String dateString = FOMATTER.format(localDate);
		 * 
		 * System.out.println(localDate); //07/15/2018
		 */

		/*
		 * DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME; LocalTime
		 * time = LocalTime.parse("00:00",formatter); LocalDate date =
		 * LocalDate.of(2019, 1, 31); LocalDateTime dateTime = date.atTime(time);
		 * System.out.println(dateTime); // 2000-01-01T00:00
		 */		
		
		LocalDate.parse("013119", DATE_STRICT_FORMATTER_YYYYMMDD);
		
		//System.out.println("-->"+LocalTime.parse("240101", TIME_STRICT_FORMATTER_TIME_FORMATTER_HH_MM_SS));
		
		// Get DayOfWeek enums value
        DayOfWeek[] dayOfWeeks = DayOfWeek.values();
        Arrays.stream(dayOfWeeks).forEach(dayOfWeeks1 -> System.out.println(dayOfWeeks1));
        for (int i = 0; i < dayOfWeeks.length; i++) {
            DayOfWeek dayOfWeek = dayOfWeeks[i];
            System.out.println("dayOfWeek[" + i + "] = " + dayOfWeek + "; value = " + 
                    dayOfWeek.getValue());
        }
		
		
	}

	public static final DateTimeFormatter DATE_STRICT_FORMATTER_YYYYMMDD = new DateTimeFormatterBuilder()
	        .parseCaseInsensitive()
	        .append(DateTimeFormatter.ofPattern(DATE_FORMAT_MMDDYY))
	        .parseDefaulting(ChronoField.ERA, IsoEra.CE.getValue())
	        .toFormatter()
	        .withZone(ZoneId.of("UTC"))
	        .withResolverStyle(ResolverStyle.STRICT)
	        .withChronology(IsoChronology.INSTANCE);
	
	  public static final DateTimeFormatter
	  TIME_STRICT_FORMATTER_TIME_FORMATTER_HH_MM_SS = new DateTimeFormatterBuilder() 
		  	.parseCaseInsensitive()
	  		.append(DateTimeFormatter
	  		.ofPattern(TIME_FORMAT_HH_MM_SS))
	  		.parseDefaulting(ChronoField.ERA, IsoEra.CE.getValue()) .toFormatter()
	  		.withZone(ZoneId.of("UTC")) 
	  		.withResolverStyle(ResolverStyle.STRICT)
	  		.withChronology(IsoChronology.INSTANCE);
	 
	//public static final DateTimeFormatter TIME_STRICT_FORMATTER_TIME_FORMATTER_HH_MM_SS = DateTimeFormatter.ofPattern(TIME_FORMAT_HH_MM_SS)
	  //      .withZone(ZoneId.of("UTC"));
	    
	
}
