package com.gridpoint.energy.util.timing;

import java.util.Date;

import org.apache.commons.lang.time.DurationFormatUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.lang.time.StopWatch;

import com.gridpoint.energy.util.DateFormats;
import com.gridpoint.energy.util.date.TimeZones;

public class MeasurementFormatter {
    private static final String LABEL_VALUE_FORMAT_STRING = "%1$s:%2$s ";
    private static final String AVERAGE_FORMAT_STRING = "%1$.2f";
    private static final String DURATION_FORMAT_STRING = "[%1$s]%2$d";
    private static final String DURATION_WITH_TOTAL_FORMAT_STRING = "(%1$.0f%%)[%2$s]%3$d";
    private static final FastDateFormat UTC_DATE_TIME_FORMAT = FastDateFormat.getInstance(DateFormats.DATE_FORMAT_LOCALDATETIME, TimeZones.UTC);

    public static String formatUtcInstant(String label, long instant){
        String result = formatLabelValue(label, formatUtcInstant(instant));
        return result;
    }

    public static String formatUtcInstant(Long instant){
        return (null == instant) ? "null" : formatUtcInstant(new Date(instant));
    }

    public static String formatUtcInstant(String label, Date instant){
        String result = formatLabelValue(label, formatUtcInstant(instant));
        return result;
    }

    public static String formatUtcInstant(Date instant){
        String result = (null == instant) ? "null" : UTC_DATE_TIME_FORMAT.format(instant);
        return result;
    }

    public static String formatLabelValue(String label, Object value) {
        String result = String.format(LABEL_VALUE_FORMAT_STRING, label, value);
        return result;
    }

    public static String durationString(long durationMillis) {
        String result = DurationFormatUtils.formatDurationHMS(durationMillis);
        return result;
    }

    public static String formatAverage(String label, double average){
        String result = formatLabelValue(label, formatAverage(average));
        return result;
    }

    public static String formatAverage(double average){
        String result = String.format(AVERAGE_FORMAT_STRING, average);
        return result;
    }

    public static String formatDuration(StopWatch duration) {
        String result = formatDuration(duration.getTime());
        return result;
    }

    public static String formatDuration(long durationMillis) {
        String durationStr = durationString(durationMillis);
        String result = String.format(DURATION_FORMAT_STRING, durationStr, durationMillis);
        return result;
    }

    public static String formatDuration(long subDurationMillis, StopWatch totalDuration) {
        String result = formatDuration(subDurationMillis, totalDuration.getTime());
        return result;
    }

    public static String formatDuration(long subDurationMillis, Long totalDurationMillis) {
        double durationRatio = 0;
        if (null != totalDurationMillis && 0 != totalDurationMillis) {
            durationRatio = subDurationMillis / (double) totalDurationMillis;
        }
        String subDurationStr = durationString(subDurationMillis);
        String result = String.format(DURATION_WITH_TOTAL_FORMAT_STRING, 100 * durationRatio, subDurationStr, subDurationMillis);
        return result;
    }

    public static String formatDuration(String durationLabel, StopWatch duration) {
        String result = formatLabelValue(durationLabel, formatDuration(duration.getTime()));
        return result;
    }

    public static String formatDuration(String durationLabel, long durationMillis) {
        String result = formatLabelValue(durationLabel, formatDuration(durationMillis));
        return result;
    }

    public static String formatDuration(String subDurationLabel, StopWatch subDuration, StopWatch totalDuration) {
        String result = formatDuration(subDurationLabel, subDuration.getTime(), totalDuration.getTime());
        return result;
    }

    public static String formatDuration(String subDurationLabel, long subDurationMillis, StopWatch totalDuration) {
        String result = formatDuration(subDurationLabel, subDurationMillis, totalDuration.getTime());
        return result;
    }

    public static String formatDuration(String subDurationLabel, long subDurationMillis, long totalDurationMillis) {
        String result = formatLabelValue(subDurationLabel, formatDuration(subDurationMillis, totalDurationMillis));
        return result;
    }
}
