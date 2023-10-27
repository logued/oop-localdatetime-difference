package org.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Calculate difference between two LocalDateTimes
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Difference between LocalDateTime objects" );

        LocalDateTime start = LocalDateTime.parse("2020-11-01T12:30:00"); // yyyy-MM-ddTHH:mm:ss
        LocalDateTime end   = LocalDateTime.parse("2020-11-02T12:35:01");

        String str = "31-12-1999 00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        System.out.println(dateTime.format(formatter));


//        String str = "1986-04-08 12:30";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

        long difference = Duration.between(start, end).toMillis();

        long millisInDay = 1000 * 60 * 60 * 24;
        long millisInHour = 1000 * 60 * 60;
        long millisInMinute = 1000 * 60;
        long millisInSecond = 1000;

        long days = difference / millisInDay;   // integer division
        long daysDivisionResidueMillis = difference - (days * millisInDay); // subtract days to get remaining hours

        long hours = daysDivisionResidueMillis / millisInHour;
        long hoursDivisionResidueMillis = daysDivisionResidueMillis - (hours * millisInHour);

        long minutes = hoursDivisionResidueMillis / millisInMinute;
        long minutesDivisionResidueMillis = hoursDivisionResidueMillis - (minutes * millisInMinute);

        long seconds = minutesDivisionResidueMillis / millisInSecond;
        long secondsDivisionResidueMillis = minutesDivisionResidueMillis - (seconds * millisInSecond);

        System.out.println(
                        + difference
                        + " millis ("
                        + days
                        + " d. "
                        + hours
                        + " h. "
                        + minutes
                        + " min. "
                        + seconds
                        + " sec."
                        + secondsDivisionResidueMillis
                        + " millis).");
    }
}
