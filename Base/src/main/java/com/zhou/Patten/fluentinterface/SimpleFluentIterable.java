package com.zhou.Patten.fluentinterface;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Administrator on 2017/2/7.
 */
public class SimpleFluentIterable<E> implements FluentIterable<E> {

    private final Iterable<E> iterable;

    protected SimpleFluentIterable(Iterable<E> iterable){
        this.iterable = iterable;
    }
    @Override
    public FluentIterable<E> filter(Predicate<? super E> predicate) {
        Iterator<E> iterator = iterator();

        while (iterator.hasNext()){
            E nextElement = iterator.next();
            if (!predicate.test(nextElement)){
                iterator.remove();
            }
        }
        return this;
    }

    @Override
    public Optional<E> first() {
        Iterator<E> resultIterator = first(1).iterator();
        return resultIterator.hasNext()?Optional.of(resultIterator.next()):Optional.empty();
    }

    @Override
    public FluentIterable<E> first(int count) {
        Iterator<E> iterator = iterator();
        int currentCount = 0;
        while (iterator.hasNext()){
            iterator.next();
            if (currentCount>=count){
                iterator.remove();
            }

            currentCount++;
        }
        return this;
    }

    @Override
    public Optional<E> last() {
        return null;
    }

    @Override
    public FluentIterable<E> last(int count) {
        return null;
    }

    @Override
    public <T> FluentIterable<T> map(Function<? super E, T> function) {
        return null;
    }

    @Override
    public List<E> asList() {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return iterable.iterator();
    }
}
