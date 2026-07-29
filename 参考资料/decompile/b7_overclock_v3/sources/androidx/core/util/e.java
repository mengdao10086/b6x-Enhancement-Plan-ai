package androidx.core.util;

import g.v0;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
@v0(24)
public final class e {
    @yt.k
    @v0(24)
    public static final <T> Consumer<T> a(@yt.k kotlin.coroutines.c<? super T> cVar) {
        kotlin.jvm.internal.f0.p(cVar, "<this>");
        return new ContinuationConsumer(cVar);
    }
}
