package com.gridpoint.energy.domainmodel;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * An auditable event describing a meaningful change to the persistent state of a business entity / domain object.
 */
public class Event implements Serializable
{
    private static final long serialVersionUID = 42L;

    private CrudOperation operation;
    private Long actorEnduserId;
    private Serializable oldDomainObject;
    private Serializable newDomainObject;

    public CrudOperation getOperation()
    {
        return operation;
    }

    public void setOperation(final CrudOperation operation)
    {
        this.operation = operation;
    }

    public Long getActorEnduserId()
    {
        return actorEnduserId;
    }

    public void setActorEnduserId(final Long actorEnduserId)
    {
        this.actorEnduserId = actorEnduserId;
    }

    public Serializable getOldDomainObject()
    {
        return oldDomainObject;
    }

    public void setOldDomainObject(final Serializable designatedOldDomainObject)
    {
        if (designatedOldDomainObject!=null)
        {
            if (designatedOldDomainObject.getClass().getSimpleName().endsWith("Entity"))
                throw new IllegalArgumentException("Must provide a non-entity, non-JPA bound class: "+designatedOldDomainObject+". Consider obtaining one from EntityConverter.");

            if (newDomainObject!=null)
            {
                if (!newDomainObject.getClass().equals(designatedOldDomainObject.getClass()))
                {
                    throw new IllegalArgumentException("Proprosed old and new domain types conflict: "+designatedOldDomainObject.getClass()
                            + " vs. "+newDomainObject.getClass());
                }

                try
                {
                    final Long newId = readIdProperty(newDomainObject);
                    final Long oldId = readIdProperty(designatedOldDomainObject);

                    if (!EqualsBuilder.reflectionEquals(newId, oldId))
                        throw new IllegalArgumentException("Proposed old and new domain types have different ID's: "
                                +oldId+" vs. "+newId);
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
        }

        oldDomainObject = designatedOldDomainObject;
    }

    public Serializable getNewDomainObject()
    {
        return newDomainObject;
    }

    public void setNewDomainObject(final Serializable designatedNewDomainObject)
    {
        if (designatedNewDomainObject!=null)
        {
            if (designatedNewDomainObject.getClass().getSimpleName().endsWith("Entity"))
                throw new IllegalArgumentException("Must provide a non-entity, non-JPA bound class: "+designatedNewDomainObject+". Consider obtaining one from EntityConverter.");

            if (oldDomainObject!=null)
            {
                if (!oldDomainObject.getClass().equals(designatedNewDomainObject.getClass()))
                {
                    throw new IllegalArgumentException("Old and proposed new domain types conflict: "
                            +oldDomainObject.getClass()+" vs. "+designatedNewDomainObject.getClass());
                }

                try
                {
                    final Long newId = readIdProperty(designatedNewDomainObject);
                    final Long oldId = readIdProperty(oldDomainObject);

                    if (!EqualsBuilder.reflectionEquals(newId, oldId))
                        throw new IllegalArgumentException("Old and proposed new domain types have different ID's: "
                                +oldId+" vs. "+newId);
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
        }

        newDomainObject = designatedNewDomainObject;
    }

    /**
     * @return The type of the domain object affected by this event.
     */
    public Class domainType()
    {
        if (newDomainObject!=null)
            return newDomainObject.getClass();
        else if (oldDomainObject!=null)
            return oldDomainObject.getClass();

        return null;
    }

    public Long domainId()
    {
        try
        {
            if (newDomainObject!=null)
                return readIdProperty(newDomainObject);
            else if (oldDomainObject!=null)
                return readIdProperty(oldDomainObject);

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

    public static Long readIdProperty(final Serializable domainObject) throws IntrospectionException, IllegalAccessException,
            InvocationTargetException
    {
        if (domainObject==null)
            return null;

        final String typeName = domainObject.getClass().getSimpleName();
        final StringBuilder iDPropertyNameStringBuilder = new StringBuilder();
        iDPropertyNameStringBuilder.append(Character.toLowerCase(typeName.charAt(0)));
        if (typeName.length()>1)
            iDPropertyNameStringBuilder.append(typeName.substring(1));
        iDPropertyNameStringBuilder.append("Id");
        final String iDPropertyName = iDPropertyNameStringBuilder.toString();

        final BeanInfo beanInfo = Introspector.getBeanInfo(domainObject.getClass());
        final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        for (int i=0; i<propertyDescriptors.length; i++)
        {
            final PropertyDescriptor propertyDescriptor = propertyDescriptors[i];

            if (iDPropertyName.equals(propertyDescriptor.getName()) || "id".equals(propertyDescriptor.getName()))
            {
                final Object result = propertyDescriptor.getReadMethod().invoke(domainObject, new Object[] {});
                return (Long) result;
            }
        }

        return null;
    }

    @Override
    public String toString()
    {
        return ReflectionToStringBuilder.reflectionToString(this);
    }
}
