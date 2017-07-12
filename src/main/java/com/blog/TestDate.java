package com.blog;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class TestDate {

    public static void main(String[] args) {
        System.out.println(new Date());
        System.out.println(LocalDate.of(2017, 6, 29));
        System.out.println(LocalDate.now());
        System.out.println(LocalDateTime.now());
        System.out.println(LocalTime.now());
        //System.out.println(ChronoField.YEAR);
        //LocalDate localDate = LocalDate.now();
        //System.out.println(localDate.with(TemporalAdjusters.firstDayOfMonth()));

        LocalDate nowDate = LocalDate.now();
        LocalDateTime nowDateTime = LocalDateTime.now();
        int year = nowDate.getYear();
        System.out.println(year);
        LocalDate localDate = nowDateTime.toLocalDate();
        System.out.println(localDate);

        int dayOfMonth = nowDateTime.getDayOfMonth();
        System.out.println(dayOfMonth);

        LocalDateTime with = nowDateTime.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(with);

        LocalDate firstDayOfMonth = nowDate.with(TemporalAdjusters.firstDayOfMonth());
        LocalDate parse = LocalDate.parse("2017-07-11");

        String format = nowDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        //String format = nowDateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG));
        System.out.println(format);
    }
}
