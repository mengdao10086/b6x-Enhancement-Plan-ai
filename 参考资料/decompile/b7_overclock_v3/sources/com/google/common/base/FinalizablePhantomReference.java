package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.PhantomReference;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
public abstract class FinalizablePhantomReference<T> extends PhantomReference<T> implements FinalizableReference {
    public FinalizablePhantomReference(T t10, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t10, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
