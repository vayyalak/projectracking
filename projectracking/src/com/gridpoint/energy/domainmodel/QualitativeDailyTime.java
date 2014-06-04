package com.gridpoint.energy.domainmodel;

/**
 * @author dhorlick
 */
public enum QualitativeDailyTime {
    SUNRISE("Sunrise"), OPENING_TIME("Store Open"), SUNSET("Sunset"), CLOSING_TIME("Store Close"), SPECIFIC_TIME("Specific Time");

    private String suffix;

    private QualitativeDailyTime(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String format(final boolean after) {
        if (SPECIFIC_TIME == this) {
            return suffix;
        }
        return (!after ? "Before " : "After ") + suffix;
    }

    public static QualitativeDailyTime parse(final String string) {
        for (QualitativeDailyTime time : values()) {
            if (string.endsWith(time.getSuffix())) {
                return time;
            }
        }

        return null;
    }

    public static boolean afterNotBefore(final String string) {
        final int firstSpaceIndex = string.indexOf(" ");
        if (firstSpaceIndex == -1)
            throw new IllegalArgumentException("Could not find a space in " + string);

        final String prefix = string.substring(0, firstSpaceIndex);
        if ("Before".equals(prefix)) {
            return false;
        } else if ("After".equals(prefix)) {
            return true;
        } else {
            throw new IllegalArgumentException("Illegal prefix " + prefix);
        }
    }
}
