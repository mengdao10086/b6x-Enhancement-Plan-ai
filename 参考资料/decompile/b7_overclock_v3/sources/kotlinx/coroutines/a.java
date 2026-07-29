package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes5.dex */
@y1
public abstract class a<T> extends JobSupport implements c2, kotlin.coroutines.c<T>, o0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final CoroutineContext f38265c;

    public a(@yt.k CoroutineContext coroutineContext, boolean z10, boolean z11) {
        super(z11);
        if (z10) {
            N0((c2) coroutineContext.c(c2.f38296x2));
        }
        this.f38265c = coroutineContext.L(this);
    }

    public static /* synthetic */ void F1() {
    }

    public void E1(@yt.l Object obj) {
        e0(obj);
    }

    public void G1(@yt.k Throwable th2, boolean z10) {
    }

    public void H1(T t10) {
    }

    public final <R> void I1(@yt.k CoroutineStart coroutineStart, R r10, @yt.k ik.p<? super R, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        coroutineStart.invoke(pVar, r10, this);
    }

    @Override // kotlinx.coroutines.JobSupport
    public final void M0(@yt.k Throwable th2) {
        l0.b(this.f38265c, th2);
    }

    @Override // kotlinx.coroutines.o0
    @yt.k
    public CoroutineContext W() {
        return this.f38265c;
    }

    @Override // kotlinx.coroutines.JobSupport
    @yt.k
    public String Z0() {
        String strB = CoroutineContextKt.b(this.f38265c);
        if (strB == null) {
            return super.Z0();
        }
        return kotlin.text.y.f38188b + strB + "\":" + super.Z0();
    }

    @Override // kotlin.coroutines.c
    @yt.k
    public final CoroutineContext b() {
        return this.f38265c;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.c2
    public boolean isActive() {
        return super.isActive();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    public final void j1(@yt.l Object obj) {
        if (!(obj instanceof c0)) {
            H1(obj);
        } else {
            c0 c0Var = (c0) obj;
            G1(c0Var.f38294a, c0Var.a());
        }
    }

    @Override // kotlinx.coroutines.JobSupport
    @yt.k
    public String n0() {
        return r0.a(this) + " was cancelled";
    }

    @Override // kotlin.coroutines.c
    public final void x(@yt.k Object obj) {
        Object objX0 = X0(h0.d(obj, null, 1, null));
        if (objX0 == j2.f38877b) {
            return;
        }
        E1(objX0);
    }
}
