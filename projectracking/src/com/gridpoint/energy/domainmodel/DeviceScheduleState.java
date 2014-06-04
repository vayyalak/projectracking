package com.gridpoint.energy.domainmodel;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

/**
 * @author dhorlick
 */
public interface DeviceScheduleState
{
    List<Element> toGpecConfigElements(Document doc);
}
