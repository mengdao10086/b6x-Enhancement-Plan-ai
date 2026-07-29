package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public interface FutureCallback<V> {
    void onFailure(Throwable th2);

    void onSuccess(@NullableDecl V v10);
}
