package com.gridpoint.energy.util.jndi;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

/**
 * This is rediculous
 */
public class MapCombiner
{
    @SuppressWarnings ({"unchecked"})
    public static Map combineMaps( List<Map> listOfMaps )
    {
        HashMap result = new HashMap();

        for( Map map : listOfMaps )
        {
            result.putAll( map );
        }
        return( result );
    }
}
