package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* JADX INFO: loaded from: classes5.dex */
public final class z0<T> extends kotlinx.coroutines.internal.k0<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f39082e = AtomicIntegerFieldUpdater.newUpdater(z0.class, "_decision");

    @hk.v
    private volatile int _decision;

    public z0(@yt.k CoroutineContext coroutineContext, @yt.k kotlin.coroutines.c<? super T> cVar) {
        super(coroutineContext, cVar);
    }

    @Override // kotlinx.coroutines.internal.k0, kotlinx.coroutines.a
    public void E1(@yt.l Object obj) {
        if (M1()) {
            return;
        }
        kotlinx.coroutines.internal.l.e(IntrinsicsKt__IntrinsicsJvmKt.d(this.f38808d), h0.a(obj, this.f38808d), null, 2, null);
    }

    @yt.l
    public final Object J1() {
        if (N1()) {
            return yj.b.h();
        }
        Object objH = j2.h(K0());
        if (objH instanceof c0) {
            throw ((c0) objH).f38294a;
        }
        return objH;
    }

    public final void K1(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, ik.l<? super Integer, kotlin.z1> lVar, Object obj) {
        while (true) {
            lVar.i(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    public final boolean M1() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f39082e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f39082e.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean N1() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f39082e;
        do {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f39082e.compareAndSet(this, 0, 1));
        return true;
    }

    @Override // kotlinx.coroutines.internal.k0, kotlinx.coroutines.JobSupport
    public void e0(@yt.l Object obj) {
        E1(obj);
    }
}
