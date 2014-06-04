package com.gridpoint.energy.domainmodel;

import static com.gridpoint.energy.util.function.Option.none;
import static com.gridpoint.energy.util.function.Option.option;

import org.apache.commons.lang.StringUtils;

import com.gridpoint.energy.util.function.Option;

public enum AlarmStateFilterType {
    OPEN("OPEN"), CLOSED("CLOSED"), ALL("ALL");

    public final String value;

    private AlarmStateFilterType(String value) {
        this.value = value;
    }

    public boolean hasValue(String str) {
        return this.value.equals(str);
    }

    public static Option<AlarmStateFilterType> parse(String str) {
        str = StringUtils.trimToEmpty(str);
        for (AlarmStateFilterType asft : AlarmStateFilterType.values()) {
            if (asft.hasValue(str)) {
                return option(asft);
            }
        }
        return none();
    }
}
