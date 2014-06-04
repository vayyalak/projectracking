package com.gridpoint.energy.domainmodel;

import java.util.Iterator;
import java.util.Map;

import com.gridpoint.energy.domainmodel.datetime.DateTZ;

public interface GraphEntryIterator extends Iterator<Map.Entry<DateTZ, Map<Long, DataTuple>>> {
}
