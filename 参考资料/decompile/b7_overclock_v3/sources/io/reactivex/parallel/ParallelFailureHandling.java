package io.reactivex.parallel;

import dj.c;

/* JADX INFO: loaded from: classes5.dex */
public enum ParallelFailureHandling implements c<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // dj.c
    public ParallelFailureHandling apply(Long l10, Throwable th2) {
        return this;
    }
}
