package kotlinx.coroutines.internal;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.c3;

/* JADX INFO: loaded from: classes5.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final CoroutineContext f38868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final Object[] f38869b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final c3<Object>[] f38870c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f38871d;

    public z0(@yt.k CoroutineContext coroutineContext, int i10) {
        this.f38868a = coroutineContext;
        this.f38869b = new Object[i10];
        this.f38870c = new c3[i10];
    }

    public final void a(@yt.k c3<?> c3Var, @yt.l Object obj) {
        Object[] objArr = this.f38869b;
        int i10 = this.f38871d;
        objArr[i10] = obj;
        c3<Object>[] c3VarArr = this.f38870c;
        this.f38871d = i10 + 1;
        kotlin.jvm.internal.f0.n(c3Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        c3VarArr[i10] = c3Var;
    }

    public final void b(@yt.k CoroutineContext coroutineContext) {
        int length = this.f38870c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            c3<Object> c3Var = this.f38870c[length];
            kotlin.jvm.internal.f0.m(c3Var);
            c3Var.p1(coroutineContext, this.f38869b[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }
}
