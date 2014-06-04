package com.gridpoint.energy.util.collection;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.joda.time.LocalTime;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Immutably presents a JavaBean's properties as though they were elements of a Map keyed on String property names.
 *
 * Changes can be made to the underlying JavaBean property values without compromising this class.
 *
 * Nested list properties will be externalized as ordered lists with mapped items.
 *
 * Nested set properties will be externalized as ordered sets with mapped items.
 *
 * Nested map properties will be externalized as ordered maps, with mapped entry values and unchanged mapped entry keys,
 * with the same Object references as in the original.
 *
 * @author dhorlick
 */
public class JavaBeanToMapAdapter<T> implements PropertyCatalogue
{
    private final T javaBean;
    private BeanInfoCatalog beanInfoCatalog;

    private final static String IMMUTABLE_MESSAGE = "This object is immutable. You can obtain a mutable copy from freeze().";

    public JavaBeanToMapAdapter(final T designatedJavaBean)
    {
        if (designatedJavaBean==null)
            throw new IllegalArgumentException("No JavaBean supplied.");

        javaBean = designatedJavaBean;
        beanInfoCatalog = new BeanInfoCatalog();
    }

    private JavaBeanToMapAdapter(final T designatedJavaBean, final BeanInfoCatalog designatedBeanInfoCatalog)
    {
        javaBean = designatedJavaBean;
        beanInfoCatalog = designatedBeanInfoCatalog;
    }

    public int size()
    {
        try
        {
            return beanInfoCatalog.retrieveBeanInfoFor(javaBean.getClass()).getPropertyDescriptors().length;
        }
        catch (IntrospectionException e)
        {
            throw new IllegalStateException(e);
        }
    }

    public boolean isEmpty()
    {
        if (size()==0)
            return true;
        else
            return false;

    }

    public boolean containsKey(Object o)
    {
        try
        {
            final BeanInfo beanInfo = beanInfoCatalog.retrieveBeanInfoFor(javaBean.getClass());
            for (final PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors())
            {
                if (descriptor.getName().equals(o))
                {
                    return true;
                }
            }

            return false;
        }
        catch (IntrospectionException e)
        {
            throw new IllegalStateException(e);
        }
    }

    public boolean containsValue(Object o)
    {
        try
        {
            final BeanInfo beanInfo = beanInfoCatalog.retrieveBeanInfoFor(javaBean.getClass());
            for (final PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors())
            {
                final Object value = descriptor.getReadMethod().invoke(o, new Object [] {});

                if (EqualsBuilder.reflectionEquals(o, value))
                {
                    return true;
                }
            }

            return false;
        }
        catch (IntrospectionException e)
        {
            throw new IllegalStateException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new IllegalStateException(e);
        }
        catch (InvocationTargetException e)
        {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Object get(Object o)
    {
        try
        {
            final BeanInfo beanInfo = beanInfoCatalog.retrieveBeanInfoFor(javaBean.getClass());
            for (final PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors())
            {
                if (descriptor.getName().equals(o))
                {
                    return descriptor.getReadMethod().invoke(javaBean, new Object [] {});
                }
            }

            return null;
        }
        catch (IntrospectionException e)
        {
            throw new IllegalStateException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new IllegalStateException(e);
        }
        catch (InvocationTargetException e)
        {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Object put(String s, Object o)
    {
        throw new UnsupportedOperationException(IMMUTABLE_MESSAGE);
    }

    @Override
    public Object remove(Object o)
    {
        throw new UnsupportedOperationException(IMMUTABLE_MESSAGE);
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> map)
    {
        throw new UnsupportedOperationException(IMMUTABLE_MESSAGE);
    }

    @Override
    public void clear()
    {
        throw new UnsupportedOperationException(IMMUTABLE_MESSAGE);
    }

    public Set<String> keySet()
    {
        try
        {
            final Set<String> keys = new HashSet<String>();

            final BeanInfo beanInfo = beanInfoCatalog.retrieveBeanInfoFor(javaBean.getClass());
            for (final PropertyDescriptor descriptor : beanInfo.getPropertyDescriptors())
            {
                keys.add(descriptor.getName());
            }

            return keys;
        }
        catch (IntrospectionException e)
        {
            throw new IllegalStateException(e);
        }
    }

    public Collection<Object> values()
    {
        return freeze().values();
    }

    /**
     * @return a mutable copy of this map, sorted alphabetically on property name.
     *
     * Changes to the result will have no affect on the wrapped JavaBean.
     */
    public Map<String, Object> freeze()
    {
        try
        {
            return buildPropertyMap(javaBean, beanInfoCatalog);
        }
        catch (IntrospectionException e)
        {
            throw new IllegalStateException(e);
        }
    }

    /**
     * @return a {@link Set} view of the mappings contained in this map. Note please that any adapted, contained
     * JavaBeans associated with properties of the root JavaBean will be represented as {@link Map}s, <em>not</em>
     * {@link Set}s.
     *
     * See also {@link java.util.Map#entrySet()}.
     */
    public Set<Entry<String, Object>> entrySet()
    {
        try
        {
            return buildPropertyMap(javaBean, beanInfoCatalog).entrySet();
        }
        catch (IntrospectionException e)
        {
            throw new IllegalStateException(e);
        }
    }

    private static PropertyCatalogue buildPropertyMap(
            final Object designatedJavaBean, final BeanInfoCatalog designatedBeanInfoCatalog) throws IntrospectionException
    {
        if (designatedJavaBean==null)
            return null;

        final PropertyCatalogue propertyMap = new ConcretePropertyCatalogue();

        try
        {
            final BeanInfo beanInfo = designatedBeanInfoCatalog.retrieveBeanInfoFor(designatedJavaBean.getClass());

            for (final PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors())
            {
                if (!propertyDescriptor.isHidden() && !"class".equals(propertyDescriptor.getName()))
                {
                    final Method readMethod = propertyDescriptor.getReadMethod();

                    if (readMethod==null)
                    {
                        throw new IllegalStateException("Could not find read method for property \""
                                +propertyDescriptor.getName()+"\" in "
                                +designatedJavaBean.getClass().getSimpleName()+".");
                    }

                    final Object value = readMethod.invoke(designatedJavaBean, new Object[0]);
                    propertyMap.put(propertyDescriptor.getName(), prepForPropertyCatalogue(value, designatedBeanInfoCatalog));
                }
            }

            return propertyMap;
        }
        catch (InvocationTargetException e)
        {
            throw new IllegalStateException(e);
        }
        catch (IllegalAccessException e)
        {
            throw new IllegalStateException(e);
        }
    }

    private static Object prepForPropertyCatalogue(final Object value, final BeanInfoCatalog designatedBeanInfoCatalog) throws IntrospectionException
    {
        if (value==null
                || value instanceof Long || value instanceof  Integer || value instanceof Double || value instanceof Float
                || value instanceof String || value instanceof Date
                || value instanceof Boolean || value instanceof PropertyCatalogue
                || value instanceof LocalTime || value instanceof Enum || value instanceof Class
                || countJavaBeanProperties(designatedBeanInfoCatalog, value)==0)
        {
            return value;
        }
        else if (value instanceof List)
        {
            final List valueList = (List) value;
            final List replacementList = new ArrayList();

            for (final Object valueListItem : valueList)
            {
                replacementList.add(prepForPropertyCatalogue(valueListItem, designatedBeanInfoCatalog));
            }

            return replacementList;
        }
        else if (value instanceof Set)
        {
            final Set valueSet = (Set) value;
            final Set replacementSet = new LinkedHashSet();

            for (final Object valueSetItem : valueSet)
            {
                replacementSet.add(prepForPropertyCatalogue(valueSetItem, designatedBeanInfoCatalog));
            }

            return replacementSet;
        }
        else if (value instanceof Map)
        {
            final Map<?, ?> valueMap = (Map<?, ?>) value;
            final Map replacementMap = new LinkedHashMap();

            for (final Entry<?, ?> mapEntry : valueMap.entrySet())
            {
                replacementMap.put(mapEntry.getKey(), prepForPropertyCatalogue(mapEntry.getValue(), designatedBeanInfoCatalog));
            }

            return replacementMap;
        }
        else if (value instanceof Collection)
        {
            throw new UnsupportedOperationException("Unsupported Collection type: "+value.getClass().getSimpleName());
        }
        else
        {
            return buildPropertyMap(value, designatedBeanInfoCatalog);
        }
    }

    public static int countJavaBeanProperties(final BeanInfoCatalog designatedBeanInfoCatalog, final Object potentialJavaBean) throws IntrospectionException
    {
        if (potentialJavaBean==null)
            return 0;

        final BeanInfo beanInfo = designatedBeanInfoCatalog.retrieveBeanInfoFor(potentialJavaBean.getClass());

        int count = 0;
        for (final PropertyDescriptor propertyDescriptor : beanInfo.getPropertyDescriptors())
        {
            if (!"class".equalsIgnoreCase(propertyDescriptor.getName()))
                count++;
        }

        return count;
    }

    /**
     * Builds a series of Mapped Objects. This method outperforms serial constructor calls, because it can
     * exploit property description synergy between objects of the same class.
     */
    public static <T> List<JavaBeanToMapAdapter<T>> build(T ... javaBeans) throws IntrospectionException
    {
        final List<JavaBeanToMapAdapter<T>> mappedObjects = new ArrayList<JavaBeanToMapAdapter<T>> ();

        final JavaBeanToMapAdapter<T> firstMappedObject = new JavaBeanToMapAdapter<T> (javaBeans[0]);
        mappedObjects.add(firstMappedObject);

        for (int i=1; i<javaBeans.length; i++)
        {
            final T javaBean = javaBeans[i];
            if (!javaBean.getClass().isAssignableFrom(firstMappedObject.javaBean.getClass()))
            {
                throw new IllegalArgumentException("Parameters classes differ: "
                        +firstMappedObject.javaBean.getClass()+" != "+javaBean.getClass());
            }

            final JavaBeanToMapAdapter<T> mappedObject = new JavaBeanToMapAdapter<T> (javaBean, firstMappedObject.beanInfoCatalog);
            mappedObjects.add(mappedObject);
        }

        return mappedObjects;
    }

    /**
     * Caches bean infos so they don't have to be wastefully regenerated.
     */
    public final static class BeanInfoCatalog
    {
        @SuppressWarnings("rawtypes")
        private Map<Class, BeanInfo> catalog = new HashMap<Class, BeanInfo> ();

        @SuppressWarnings("rawtypes")
        public BeanInfo retrieveBeanInfoFor(final Class klass) throws IntrospectionException
        {
            if (catalog.containsKey(klass))
                return catalog.get(klass);

            final BeanInfo beanInfo = Introspector.getBeanInfo(klass);

            catalog.put(klass, beanInfo);

            return beanInfo;
        }
    }

    @Override
    public String toString()
    {
        return "JavaBeanToMapAdapter "+this.hashCode()+" "+entrySet();
    }
}
