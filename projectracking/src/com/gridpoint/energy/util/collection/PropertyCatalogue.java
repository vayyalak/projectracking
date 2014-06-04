package com.gridpoint.energy.util.collection;

import java.util.Map;

/**
 * Basically a tagging interface, so that we can have an object graph of Property Catalogues and distinct
 * Map<String, ?>'s, and keep them distinct.
 *
 * @author dhorlick
 */
public interface PropertyCatalogue extends Map<String, Object>
{
}
