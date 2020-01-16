package com.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author huazhen.he
 * @apiNote
 * @date 2018/8/29
 */
public class DateUtil {

    public static final String FORMATE = "yyyy-MM-dd HH:mm:ss";

    public static final String S_FORMATE = "yyyyMMddHHmmss";


    public static final String API_FORMATE = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static String formateApi(final Date date) {
        return new SimpleDateFormat(API_FORMATE).format(date);
    }

    public static String formatDate(final Long dateLong) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(dateLong));
    }

    public static String formatDate(final Date date) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static String formatDate(final Date date, final String format) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String formatNew(final Date date) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return simpleDateFormat.format(date);
    }

    public static String formatDateNew(final String date) {
        final SimpleDateFormat s2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            final Date date1 = DateUtils.parseDate(date, "yyyy-MM-dd'T'HH:mm:ssZZ");
            return s2.format(date1);
        } catch (final ParseException e) {
        }
        return "";
    }

    public static Date getDateByString(final String dateStr) {
        if (StringUtils.isBlank(dateStr)) {
            return null;
        }
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return df.parse(dateStr);
        } catch (final ParseException e) {
            return null;
        }
    }

    public static boolean equalSettlementTime(final Date date) {
        if (Objects.isNull(date)) {
            return false;
        }
        final Date curDate = new Date();
        final long diff = curDate.getTime() - date.getTime();
        //60秒
        final long buff = 1000 * 60;
        return diff >= 0 && diff <= buff;
    }

    /**
     * 获取今天的开始时间
     */
    public static Date getStartOfDay() {
        final LocalDate localDate = LocalDate.now();
        final ZoneId zone = ZoneId.systemDefault();
        final Instant instant = localDate.atStartOfDay().atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 计算两个日期相差月份数
     */
    public static int getMonthSpace(final Date start, final Date end) {
        int iMonth = 0;
        try {
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(start);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(end);

            if (cal2.equals(cal1)) {
                return 0;
            }
            if (cal1.after(cal2)) {
                final Calendar temp = cal1;
                cal1 = cal2;
                cal2 = temp;
            }
            if (cal2.get(Calendar.YEAR) > cal1.get(Calendar.YEAR)) {
                iMonth = ((cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR)) * 12 + cal2.get(Calendar.MONTH))
                        - cal1.get(Calendar.MONTH);
            } else {
                iMonth = cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return iMonth;
    }

    /**
     * 获取7天前开始时间
     */
    public static Date getSevenDaysAgo() {
        final LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        final LocalDateTime seven = localDateTime.minusDays(7);
        final ZoneId zone = ZoneId.systemDefault();
        final Instant instant = seven.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取7天的日期
     */
    public static List<Date> getBeforeSevenDay() {
        final List<Date> days = new ArrayList<>();
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = null;
        for (int i = 0; i < 7; i++) {
            c = Calendar.getInstance();
            c.add(Calendar.DAY_OF_MONTH, -i);
            try {
                days.add(DateUtils.parseDate(sdf.format(c.getTime()), "yyyy-MM-dd"));
            } catch (final Exception e) {
            }

        }
        return days;
    }

    /**
     * 获取n天前开始时间
     */
    public static Date getNDaysAgo(final int n) {
        final LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        final LocalDateTime seven = localDateTime.minusDays(n);
        final ZoneId zone = ZoneId.systemDefault();
        final Instant instant = seven.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取n天前开始时间
     */
    public static Date getDaysAgo(final Date date, final int n) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        final LocalDateTime seven = localDateTime.minusDays(n);
        final Instant instant = seven.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取n月前开始时间
     */
    public static Date getNMonthsAgo(final int n) {
        final LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        final LocalDateTime seven = localDateTime.minusMonths(n);
        final ZoneId zone = ZoneId.systemDefault();
        final Instant instant = seven.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取n月前开始时间
     */
    public static Date getNMonthsAgo(final Date date, final int n) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        final LocalDateTime seven = localDateTime.minusMonths(n);
        final Instant instant = seven.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取15天前开始时间
     */
    public static Date getFifteenDaysAgo() {
        final LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        final LocalDateTime seven = localDateTime.minusDays(15);
        final ZoneId zone = ZoneId.systemDefault();
        final Instant instant = seven.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取90天前开始时间
     */
    public static Date getNinetyDaysAgo() {
        final LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        final LocalDateTime nine = localDateTime.minusDays(90);
        final ZoneId zone = ZoneId.systemDefault();
        final Instant instant = nine.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取3个月前开始时间
     */
    public static Date getThreeMonthsAgo() {
        final LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        final LocalDateTime nine = localDateTime.minusMonths(3);
        final ZoneId zone = ZoneId.systemDefault();
        final Instant instant = nine.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取下一次小时
     */
    public static Date getNextHours(final Date date, final Integer hour) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        final LocalDateTime nine = localDateTime.plusHours(hour);
        final Instant instant = nine.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取上一次小时
     */
    public static Date getBeforeHours(final Date date, final Integer hours) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        final LocalDateTime nine = localDateTime.minusHours(hours);
        final Instant instant = nine.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取下一次分钟
     */
    public static Date getNextMinutes(final Date date, final Integer minute) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        final LocalDateTime nine = localDateTime.plusMinutes(minute);
        final Instant instant = nine.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取下一次秒钟
     */
    public static Date getNextSeconds(final Date date, final Integer second) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        final LocalDateTime nine = localDateTime.plusSeconds(second);
        final Instant instant = nine.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取上一次分钟
     *
     * @para
     */
    public static Date getMinutesAgo(final Date date, final Integer minute) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        final LocalDateTime nine = localDateTime.minusMinutes(minute);
        final Instant instant = nine.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取下一次月份
     */
    public static Date getAgoMonths(final Date date, final Integer month) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        final LocalDateTime nine = localDateTime.minusMonths(month);
        final Instant instant = nine.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取上一次小时
     */
    public static Date getHoursAgo(final Date date, final Integer hour) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        final LocalDateTime nine = localDateTime.minusHours(hour);
        final Instant instant = nine.atZone(zone).toInstant();
        return Date.from(instant);
    }

    /**
     * 获取两个时间相差秒数
     */
    public static long getIntervalSeconds(final Date date1, final Date date2) {
        return (date2.getTime() - date1.getTime()) / 1000;
    }

    /**
     * 获取两个时间相差秒数
     */
    public static int getIntervalMinutes(final Date date1, final Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / 60000);
    }

    public static String formatYYYYMMDD(final Date date) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(date);
    }

    public static String utcDateToLocalTime(final String utfDate) {
        final Instant timestamp = Instant.parse(utfDate);
        final ZonedDateTime localTime = timestamp.atZone(ZoneId.systemDefault());
        return formatDate(localTime.toEpochSecond() * 1000);
    }

    public static Date utcToLocalTime(final String utfDate) {
        final Instant timestamp = Instant.parse(utfDate);
        final ZonedDateTime localTime = timestamp.atZone(ZoneId.systemDefault());
        return new Date(localTime.toEpochSecond() * 1000);
    }

    public static String getTimeFormat(final Long time) {
        //return Instant.ofEpochMilli(date.getTime()).toString();
        final Instant i = Instant.ofEpochMilli(time);
        final LocalDateTime datetime = LocalDateTime.ofInstant(i, ZoneOffset.UTC);
        final String formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(datetime);
        return formatted;
    }

    //本地时间转utc
    public static String formatISO8601(final Date date) {
        final Instant i = Instant.ofEpochMilli(date.getTime());
        final LocalDateTime datetime = LocalDateTime.ofInstant(i, ZoneOffset.UTC);
        final String formatted = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(datetime);
        return formatted;
    }

    public static Boolean isHourPoint(final Date date) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        return localDateTime.getMinute() < 1;
    }

    public static Boolean isDayPoint(final Date date) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        return localDateTime.getHour() < 1 && localDateTime.getMinute() < 1;
    }

    public static Boolean isFiveMinutesPoint(final Date date) {
        final ZoneId zone = ZoneId.systemDefault();
        final LocalDateTime localDateTime = LocalDateTime.ofInstant(date.toInstant(), zone);
        return localDateTime.getMinute() % 5 == 0;
    }



    public static void main(final String[] args) {
    }

}
