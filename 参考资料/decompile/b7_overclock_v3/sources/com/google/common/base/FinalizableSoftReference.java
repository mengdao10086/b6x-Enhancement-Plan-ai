package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
public abstract class FinalizableSoftReference<T> extends SoftReference<T> implements FinalizableReference {
    public FinalizableSoftReference(T t10, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t10, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
