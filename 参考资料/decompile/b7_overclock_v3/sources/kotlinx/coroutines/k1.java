package kotlinx.coroutines;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nEventLoop.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventLoop.common.kt\nkotlinx/coroutines/EventLoop\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,543:1\n1#2:544\n*E\n"})
public abstract class k1 extends CoroutineDispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f38890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f38891d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public kotlin.collections.i<a1<?>> f38892e;

    public static /* synthetic */ void n2(k1 k1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        k1Var.m2(z10);
    }

    public static /* synthetic */ void s2(k1 k1Var, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        }
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        k1Var.r2(z10);
    }

    public final boolean isActive() {
        return this.f38890c > 0;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    public final CoroutineDispatcher k2(int i10) {
        kotlinx.coroutines.internal.r.a(i10);
        return this;
    }

    public final void m2(boolean z10) {
        long jO2 = this.f38890c - o2(z10);
        this.f38890c = jO2;
        if (jO2 <= 0 && this.f38891d) {
            shutdown();
        }
    }

    public final long o2(boolean z10) {
        return z10 ? 4294967296L : 1L;
    }

    public final void p2(@yt.k a1<?> a1Var) {
        kotlin.collections.i<a1<?>> iVar = this.f38892e;
        if (iVar == null) {
            iVar = new kotlin.collections.i<>();
            this.f38892e = iVar;
        }
        iVar.addLast(a1Var);
    }

    public long q2() {
        kotlin.collections.i<a1<?>> iVar = this.f38892e;
        return (iVar == null || iVar.isEmpty()) ? Long.MAX_VALUE : 0L;
    }

    public final void r2(boolean z10) {
        this.f38890c += o2(z10);
        if (z10) {
            return;
        }
        this.f38891d = true;
    }

    public void shutdown() {
    }

    public boolean t2() {
        return v2();
    }

    public final boolean u2() {
        return this.f38890c >= o2(true);
    }

    public final boolean v2() {
        kotlin.collections.i<a1<?>> iVar = this.f38892e;
        if (iVar != null) {
            return iVar.isEmpty();
        }
        return true;
    }

    public long w2() {
        return !x2() ? Long.MAX_VALUE : 0L;
    }

    public final boolean x2() throws IllegalAccessException, InvocationTargetException {
        a1<?> a1VarZ;
        kotlin.collections.i<a1<?>> iVar = this.f38892e;
        if (iVar == null || (a1VarZ = iVar.z()) == null) {
            return false;
        }
        a1VarZ.run();
        return true;
    }

    public boolean y2() {
        return false;
    }
}
