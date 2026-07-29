package androidx.core.os;

import android.os.OutcomeReceiver;
import g.v0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes2.dex */
@v0(31)
public final class q {
    @yt.k
    @v0(31)
    public static final <R, E extends Throwable> OutcomeReceiver<R, E> a(@yt.k kotlin.coroutines.c<? super R> cVar) {
        f0.p(cVar, "<this>");
        return new ContinuationOutcomeReceiver(cVar);
    }
}
