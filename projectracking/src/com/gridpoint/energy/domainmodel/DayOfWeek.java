package com.gridpoint.energy.domainmodel;

/**
 * Represents a day of a week according to an ordinal
 * that satisfies converting from ADM domain and GPUP "configuration_store_hours" table. 
 */
public enum DayOfWeek {
    SUNDAY(0, "Sunday"),
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday");
    
    private int numericDay;
    private String name;
    
    public static DayOfWeek newInstance(int numericDay) {
        switch(numericDay) {
            case 0: return SUNDAY;
            case 1: return MONDAY;
            case 2: return TUESDAY;
            case 3: return WEDNESDAY;
            case 4: return THURSDAY;
            case 5: return FRIDAY;
            case 6: return SATURDAY;
        }
        throw new NoSuchFieldError("Cannot construct DayOfWeek with numeric day of: " + numericDay);
    }
    
    public static boolean isDayOfWeek(String dayOfWeek) {
        try {
            newInstance(dayOfWeek);
        } catch(NoSuchFieldError ex) {
            return false;
        }
        return true;
    }

    public static DayOfWeek newInstance(String stringDay) {
        if (stringDay == null || stringDay.trim().isEmpty()) {
            throw new IllegalArgumentException("Cannot construct DayOfWeek with empty or null string");
        }
        if (stringDay.equalsIgnoreCase(SUNDAY.stringDayOfWeek())) { return SUNDAY;
        } else if (stringDay.equalsIgnoreCase(MONDAY.stringDayOfWeek())) {
            return MONDAY;
        } else if (stringDay.equalsIgnoreCase(TUESDAY.stringDayOfWeek())) {
            return TUESDAY;
        } else if (stringDay.equalsIgnoreCase(WEDNESDAY.stringDayOfWeek())) {
            return WEDNESDAY;
        } else if (stringDay.equalsIgnoreCase(THURSDAY.stringDayOfWeek())) {
            return THURSDAY;
        } else if (stringDay.equalsIgnoreCase(FRIDAY.stringDayOfWeek())) {
            return FRIDAY;
        } else if (stringDay.equalsIgnoreCase(SATURDAY.stringDayOfWeek())) {
            return SATURDAY;
        }
        throw new NoSuchFieldError("Cannot construct DayOfWeek with String day of: " + stringDay);
    }
    
    private DayOfWeek(int numericDay, String name) {
        this.numericDay = numericDay;
        this.name = name;
    }
    
    public int numericDay() {
        return numericDay;
    }
    
    public String stringDayOfWeek() {
        return name;
    }
    
    public String shortDayOfWeek() {
        if(null != name && name.length() >= 3) {
            return name.substring(0,3);
        }
        return name;
    }
}
