package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes7.dex */
@GwtIncompatible
public abstract class FinalizableWeakReference<T> extends WeakReference<T> implements FinalizableReference {
    public FinalizableWeakReference(T t10, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t10, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
