package okio;

import java.io.Closeable;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u001a\u000f\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001aC\u0010\u000e\u001a\u00028\u0001\"\u0010\b\u0000\u0010\n*\n\u0018\u00010\bj\u0004\u0018\u0001`\t\"\u0004\b\u0001\u0010\u000b*\u00028\u00002\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\fH\u0086\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"Lokio/t0;", "Lokio/l;", "c", "Lokio/r0;", "Lokio/k;", "b", "a", "()Lokio/r0;", "Ljava/io/Closeable;", "Lokio/Closeable;", i1.a.f31577d5, "R", "Lkotlin/Function1;", "block", "d", "(Ljava/io/Closeable;Lik/l;)Ljava/lang/Object;", "okio"}, k = 5, mv = {1, 5, 1}, xs = "okio/Okio")
public final /* synthetic */ class h0 {
    @hk.h(name = "blackhole")
    @yt.k
    public static final r0 a() {
        return new i();
    }

    @yt.k
    public static final k b(@yt.k r0 r0Var) {
        kotlin.jvm.internal.f0.p(r0Var, "<this>");
        return new n0(r0Var);
    }

    @yt.k
    public static final l c(@yt.k t0 t0Var) {
        kotlin.jvm.internal.f0.p(t0Var, "<this>");
        return new o0(t0Var);
    }

    public static final <T extends Closeable, R> R d(T t10, @yt.k ik.l<? super T, ? extends R> block) throws Throwable {
        R rI;
        kotlin.jvm.internal.f0.p(block, "block");
        Throwable th2 = null;
        try {
            rI = block.i(t10);
        } catch (Throwable th3) {
            th2 = th3;
            rI = null;
        }
        if (t10 != null) {
            try {
                t10.close();
            } catch (Throwable th4) {
                if (th2 == null) {
                    th2 = th4;
                } else {
                    kotlin.o.a(th2, th4);
                }
            }
        }
        if (th2 != null) {
            throw th2;
        }
        kotlin.jvm.internal.f0.m(rI);
        return rI;
    }
}
