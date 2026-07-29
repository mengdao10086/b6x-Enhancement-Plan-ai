package androidx.core.util;

import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    @yt.k
    public static final Runnable a(@yt.k kotlin.coroutines.c<? super z1> cVar) {
        kotlin.jvm.internal.f0.p(cVar, "<this>");
        return new ContinuationRunnable(cVar);
    }
}
