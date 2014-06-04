package com.gridpoint.energy.domainmodel;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Models part of an order by clause in a JPA or SQL query.
 *
 * Useful for handling odata-like queries.
 */
public class Ordering
{
    private String fieldName;
    private boolean descending;

    public Ordering()
    {
    }

    public Ordering(final String designatedOrderBy)
    {
        setOrderBy(designatedOrderBy);
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public boolean isDescending()
    {
        return descending;
    }

    /**
     * a String determining which audit property to sort on. May be suffixed with " DESC" to indicate
     * descending-order.
     */
    public String getOrderBy()
    {
        if (fieldName ==null)
            return null;

        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(fieldName);

        if (descending)
            stringBuilder.append(" DESC");

        return stringBuilder.toString();
    }

    public void setOrderBy(final String designatedOrderBy)
    {
        if (designatedOrderBy!=null)
        {
            String orderByString = designatedOrderBy;

            final String lowerCasedOrderByString = orderByString.toLowerCase();
            if (lowerCasedOrderByString.endsWith(" desc"))
            {
                if (orderByString.indexOf(' ')!=orderByString.lastIndexOf(' '))
                {
                    throw new IllegalArgumentException("orderByString should have zero or 1 space character: "+orderByString);
                }

                fieldName = orderByString.substring(0, orderByString.indexOf(' '));
                descending = true;
            }
            else if (lowerCasedOrderByString.endsWith("asc"))
            {
                if (orderByString.indexOf(' ')!=orderByString.lastIndexOf(' '))
                {
                    throw new IllegalArgumentException("orderByString should have zero or 1 space character: "+orderByString);
                }

                fieldName = orderByString.substring(0, orderByString.indexOf(' '));
                descending = false;
            }
            else
            {
                if (orderByString.indexOf(' ')!=-1)
                    throw new IllegalArgumentException("orderByString may only contain a space if it ends with the suffix DESC: "+orderByString);

                fieldName = orderByString;
                descending = false;
            }
        }
    }

    /**
     * @return The path that was used for sorting.
     */
    @SuppressWarnings("unchecked")
    public Path<Object> applySortTo(final CriteriaQuery query, final JpaPathRetrievalStrategy pathRetrievalStrategy, final CriteriaBuilder criteriaBuilder,
                            final String optionalDefaultSortFieldName, final Boolean optionalDefaultSortAscending)
    {
        final boolean descendingLocal;
        final String fieldNameLocal;

        if (fieldName==null && optionalDefaultSortFieldName !=null)
        {
            fieldNameLocal = optionalDefaultSortFieldName;

            if (optionalDefaultSortAscending==Boolean.FALSE)
                descendingLocal = true;
            else
                descendingLocal = false;
        }
        else
        {
            descendingLocal = descending;
            fieldNameLocal = fieldName;
        }

        final Path<Object> sortable = pathRetrievalStrategy.retrieveJpaPathForFieldName(fieldNameLocal); // unchecked

        if (descendingLocal)
            query.orderBy(criteriaBuilder.desc(sortable));
        else
            query.orderBy(criteriaBuilder.asc(sortable));

        return sortable;
    }

    public static List<Ordering> parseOrderByClause(final String orderByClause)
    {
        final StringTokenizer stringTokenizer = new StringTokenizer(orderByClause, ",");

        final List<Ordering> orderings = new ArrayList<Ordering>();

        while (stringTokenizer.hasMoreElements())
        {
            final String orderByString = stringTokenizer.nextToken();
            orderings.add(new Ordering(orderByString.trim()));
        }

        return orderings;
    }

    public static interface JpaPathRetrievalStrategy {

        public Path<Object> retrieveJpaPathForFieldName(String fieldName);
    }

    public static class SimpleJpaPathRetrievalStrategy implements Ordering.JpaPathRetrievalStrategy {
        private Root root;

        public SimpleJpaPathRetrievalStrategy(final Root designatedRoot)
        {
            setRoot(designatedRoot);
        }

        private void setRoot(final Root designatedRoot)
        {
            root = designatedRoot;
        }

        public Root getRoot()
        {
            return root;
        }

        @SuppressWarnings("unchecked")
        public Path<Object> retrieveJpaPathForFieldName(final String fieldName)
        {
            return (Path<Object>) root.get(fieldName); // unchecked cast
        }
    }
}
