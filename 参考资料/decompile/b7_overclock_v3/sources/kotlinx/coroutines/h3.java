package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.KotlinNothingValueException;

/* JADX INFO: loaded from: classes5.dex */
public final class h3 implements ik.l<Throwable, kotlin.z1> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final AtomicIntegerFieldUpdater f38750d = AtomicIntegerFieldUpdater.newUpdater(h3.class, "_state");

    @hk.v
    private volatile int _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final c2 f38751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread f38752b = Thread.currentThread();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public g1 f38753c;

    public h3(@yt.k c2 c2Var) {
        this.f38751a = c2Var;
    }

    public final void b() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38750d;
        while (true) {
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 != 2) {
                    if (i10 == 3) {
                        Thread.interrupted();
                        return;
                    } else {
                        d(i10);
                        throw new KotlinNothingValueException();
                    }
                }
            } else if (f38750d.compareAndSet(this, i10, 1)) {
                g1 g1Var = this.f38753c;
                if (g1Var != null) {
                    g1Var.dispose();
                    return;
                }
                return;
            }
        }
    }

    public final Void d(int i10) {
        throw new IllegalStateException(("Illegal state " + i10).toString());
    }

    public void e(@yt.l Throwable th2) {
        int i10;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater2 = f38750d;
        do {
            i10 = atomicIntegerFieldUpdater2.get(this);
            if (i10 != 0) {
                if (i10 == 1 || i10 == 2 || i10 == 3) {
                    return;
                }
                d(i10);
                throw new KotlinNothingValueException();
            }
            atomicIntegerFieldUpdater = f38750d;
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, 2));
        this.f38752b.interrupt();
        atomicIntegerFieldUpdater.set(this, 3);
    }

    public final void f(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, ik.l<? super Integer, kotlin.z1> lVar, Object obj) {
        while (true) {
            lVar.i(Integer.valueOf(atomicIntegerFieldUpdater.get(obj)));
        }
    }

    public final void g() {
        int i10;
        this.f38753c = this.f38751a.F0(true, true, this);
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f38750d;
        do {
            i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 != 0) {
                if (i10 == 2 || i10 == 3) {
                    return;
                }
                d(i10);
                throw new KotlinNothingValueException();
            }
        } while (!f38750d.compareAndSet(this, i10, 0));
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ kotlin.z1 i(Throwable th2) {
        e(th2);
        return kotlin.z1.f38230a;
    }
}
