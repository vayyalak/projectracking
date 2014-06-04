package com.gridpoint.energy.util.spring;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.apache.log4j.Logger;
import java.util.Properties;


/**
 * This class extends Spring's PropertyPlaceHolderConfigurer to add embedded defaults into the Spring .xml
 * Example:
 *  ${somePlaceHolderName$[DEFAULT_VALUE]}
 *  If 'somePlaceHolderName' can not be found in any of the property locations, then it will get set to the DEFAULT_VALUE.
 *  Otherwise this acts exactly like the Spring PropertyPlaceholderConfigurer.
 */
public class PropertyMangler
    extends PropertyPlaceholderConfigurer
{
    private static final Logger logger = Logger.getLogger( PropertyMangler.class );

    public static final String DEFAULT_PREFIX = "$[";
    public static final String DEFAULT_SUFFIX = "]";
    /**
     *
     * @param placeholder
     * @param props
     * @param systemPropertiesMode
     * @return
     */
    protected String resolvePlaceholder(String placeholder, Properties props, int systemPropertiesMode) {
        String propVal      = null;
        String defaultVal   = extractDefaultPlaceholder( placeholder );
        String baseval      = extractBasePlaceholder( placeholder );

        if (systemPropertiesMode == SYSTEM_PROPERTIES_MODE_OVERRIDE)
        {
            propVal = resolveSystemProperty(baseval);
            if( propVal != null )
            {
                logger.info("resolvePlaceholder. placeholder:" + baseval + "  Replaced with System Property:" + propVal );
            }
        }
        if (propVal == null)
        {
            propVal = resolvePlaceholder(baseval, props);
            if( propVal != null )
            {
                logger.info("resolvePlaceholder. placeholder:" + baseval + "  Replaced with Property:" + propVal );
            }
        }
        if (propVal == null && systemPropertiesMode == SYSTEM_PROPERTIES_MODE_FALLBACK)
        {
            propVal = resolveSystemProperty(baseval);
            if( propVal != null )
            {
                logger.info("resolvePlaceholder. placeholder:" + baseval + "  Replaced with SystemProp:" + propVal );
            }
        }
        if( propVal == null )
        {
            propVal = defaultVal;
            if( propVal != null )
            {
                logger.info("resolvePlaceholder. placeholder:" + baseval + "  Replaced with Default:" + propVal );
            }
        }
        if( propVal == null )
        {
            logger.info("resolvePlaceholder. placeholder:" + baseval + " no value. " );
        }

        return propVal;
    }

    /**
     * Get the default value, or null.
     * @param placeholder
     * @return
     */
    private String extractDefaultPlaceholder( String placeholder )
    {
        int startIndex = placeholder.indexOf( DEFAULT_PREFIX );
        if( startIndex != -1 )
        {
            return( placeholder.substring( startIndex + DEFAULT_PREFIX.length(),
                                           placeholder.length() - DEFAULT_SUFFIX.length() ) );
        }
        return( null );
    }

    /**
     * extract the base property name.
     * @param placeholder
     * @return
     */
    private String extractBasePlaceholder( String placeholder )
    {
        int startIndex = placeholder.indexOf( DEFAULT_PREFIX );
        if( startIndex != -1 )
        {
            return( placeholder.substring(0, startIndex ) );
        }
        else
        {
            return( placeholder );
        }
    }
}
