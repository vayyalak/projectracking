package com.gridpoint.energy.util.function;

import java.util.Collections;
import java.util.Iterator;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public abstract class Option<E> implements Iterable<E> {

    public static <E> Option<E> option(E e) {
        return e == null ? new None<E>() : new Some<E>(e);
    }

    public static <E> None<E> none() {
        return new None<E>();
    }

    /**
     * Returns true if this object represents an undefined value.
     * 
     * @return whether a call to {@link #or} will return the alternative value.
     */
    public abstract boolean isEmpty();

    /**
     * Returns true if this object represents a defined value.
     * 
     * @return whether a call to {@link #or} will not return the alternative value.
     */
    public boolean isDefined() {
        return !isEmpty();
    }

    /**
     * If this <code>Option</code> is defined, return it. Otherwise, return an alternative value.
     * 
     * @param alternative
     *            - a default value
     * @return the value of this or an alternative
     */
    public abstract E getOrElse(E alternative);

    /**
     * If this object is defined, return it. Otherwise, return the result of evaluating <code>alternative</code>.
     * 
     * @param alternative
     *            - a computation whose result is to be returned if this is undefined
     * @return the value of this or the the result of evaluating <code>alternative</code>
     */
    public abstract E getOrElse(Func0<E> alternative);

    /**
     * If this object is defined, return it. Otherwise, throw a {@link NullPointerException}.
     * 
     * @return the value of this
     * @throws NullPointerException
     *             - if this is undefined
     */
    public abstract E get() throws NullPointerException;

    /**
     * If this object is defined, return the <code>Option</code>-wrapped version. Otherwise, return the result of
     * {@link #option(Object)} for <code>alternative</code>
     * 
     * @param alternative
     *            - maybe an <code>E</code>
     * @return this or the <code>alternative</code>
     */
    public abstract Option<E> orElse(Option<E> alternative);

    /**
     * If this object is defined, return the <code>Option</code>-wrapped version.  Otherwise, return the result of evaluating <code>alternative</code>.
     * @param alternative
     *              - a computation whose result is to be returned if this is undefined
     * @return this or the result of evaluating <code>alternative</code>
     */
    public abstract Option<E> orElse(Func0<Option<E>> alternative);

    /**
     * If this object is defined, return it.  Otherwise, throw the exception
     * @param t
     * @return the value of this or throws an exception
     */
    public abstract <T extends Exception> E getOrThrow(T t) throws T;

    /**
     * If this object is defined, run a {@link Func1} and return its value. Otherwise, return a default value.
     * 
     * @param <V>
     *            - the type to be returned
     * @param then
     *            - the function to be run if this value is defined.
     * @param otherwise
     *            - a default return value
     * @return the result of running <code>then</code> or <code>otherwise</code>
     */
    public abstract <V> V and(Func1<E, V> then, V otherwise);

    /**
     * If this object is defined, run a {@link Func1} and return the <code>Some</code>-wrapped value. Otherwise, return
     * <code>None</code>.
     * 
     * @param <V>
     *            - the result type of the function to be run
     * @param then
     *            - the function to run
     * @return the wrapped result of <code>then</code> or <code>None</code>
     * 
     */
    public abstract <V> Option<V> map(Func1<E, V> then);

    public static class None<E> extends Option<E> {
        private None() {
        }

        @Override
        public E getOrElse(E alternative) {
            return alternative;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public E getOrElse(Func0<E> alternative) {
            return alternative.apply();
        }

        @Override
        public E get() throws NullPointerException {
            throw new NullPointerException();
        }

        @Override
        public <V> V and(Func1<E, V> then, V otherwise) {
            return otherwise;
        }

        @Override
        public Option<E> orElse(Option<E> alternative) {
            return alternative;
        }

        @Override
        public Option<E> orElse(Func0<Option<E>> alternative) {
            return alternative.apply();
        }

        @Override
        public <T extends Exception> E getOrThrow(T t) throws T{
            throw t;
        }

        @Override
        public <V> Option<V> map(Func1<E, V> then) {
            return new None<V>();
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !getClass().isAssignableFrom(o.getClass())) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            return 0;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).toString();
        }

        @Override
        public Iterator<E> iterator() {
            return Collections.<E> emptyList().iterator();
        }
    }

    public static class Some<E> extends Option<E> {

        private E e;

        private Some(E e) {
            this.e = e;
        }

        @Override
        public E getOrElse(E alternative) {
            return e;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public E getOrElse(Func0<E> alternative) {
            return e;
        }

        @Override
        public E get() {
            return e;
        }

        @Override
        public <V> V and(Func1<E, V> then, V otherwise) {
            return then.apply(e);
        }

        @Override
        public Option<E> orElse(Option<E> alternative) {
            return this;
        }

        @Override
        public Option<E> orElse(Func0<Option<E>> alternative) {
            return this;
        }

        @Override
        public <T extends Exception> E getOrThrow(T t) throws T{
            return e;
        }

        @Override
        public <V> Option<V> map(Func1<E, V> then) {
            return option(then.apply(e));
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !getClass().isAssignableFrom(o.getClass())) {
                return false;
            }
            Some<?> rhs = (Some<?>) o;
            return new EqualsBuilder().append(this.e, rhs.e).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(this.e).toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this, ToStringStyle.DEFAULT_STYLE).append(this.e).toString();
        }

        @Override
        public Iterator<E> iterator() {
            return Collections.singleton(e).iterator();
        }
    }

}
