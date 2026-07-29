package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {

    @NullableDecl
    private T nextOrNull;

    public AbstractSequentialIterator(@NullableDecl T t10) {
        this.nextOrNull = t10;
    }

    @NullableDecl
    public abstract T computeNext(T t10);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.nextOrNull != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            T t10 = this.nextOrNull;
            this.nextOrNull = computeNext(t10);
            return t10;
        } catch (Throwable th2) {
            this.nextOrNull = computeNext(this.nextOrNull);
            throw th2;
        }
    }
}
