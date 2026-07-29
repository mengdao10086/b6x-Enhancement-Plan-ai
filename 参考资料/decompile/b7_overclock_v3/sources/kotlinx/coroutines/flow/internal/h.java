package kotlinx.coroutines.flow.internal;

import kotlin.s0;

/* JADX INFO: loaded from: classes5.dex */
public final class h {
    @s0
    public static final int a(int i10) {
        if (i10 >= 0) {
            return i10;
        }
        throw new ArithmeticException("Index overflow has happened");
    }

    public static final void b(@yt.k AbortFlowException abortFlowException, @yt.k kotlinx.coroutines.flow.f<?> fVar) {
        if (abortFlowException.f38673a != fVar) {
            throw abortFlowException;
        }
    }
}
