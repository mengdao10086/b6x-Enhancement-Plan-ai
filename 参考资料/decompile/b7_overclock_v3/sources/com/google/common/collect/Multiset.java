package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import i1.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        boolean equals(Object obj);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    @CanIgnoreReturnValue
    int add(@NullableDecl E e10, int i10);

    @CanIgnoreReturnValue
    boolean add(E e10);

    boolean contains(@NullableDecl Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(@NullableDecl @CompatibleWith(a.S4) Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(@NullableDecl Object obj);

    int hashCode();

    Iterator<E> iterator();

    @CanIgnoreReturnValue
    int remove(@NullableDecl @CompatibleWith(a.S4) Object obj, int i10);

    @CanIgnoreReturnValue
    boolean remove(@NullableDecl Object obj);

    @CanIgnoreReturnValue
    boolean removeAll(Collection<?> collection);

    @CanIgnoreReturnValue
    boolean retainAll(Collection<?> collection);

    @CanIgnoreReturnValue
    int setCount(E e10, int i10);

    @CanIgnoreReturnValue
    boolean setCount(E e10, int i10, int i11);

    int size();

    String toString();
}
