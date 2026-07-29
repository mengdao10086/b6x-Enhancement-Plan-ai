package kotlinx.coroutines.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public class w<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final AtomicReferenceFieldUpdater f38841a = AtomicReferenceFieldUpdater.newUpdater(w.class, Object.class, "_cur");

    @yt.l
    @hk.v
    private volatile Object _cur;

    public w(boolean z10) {
        this._cur = new x(8, z10);
    }

    public final boolean a(@yt.k E e10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38841a;
        while (true) {
            x xVar = (x) atomicReferenceFieldUpdater.get(this);
            int iA = xVar.a(e10);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                al.o.a(f38841a, this, xVar, xVar.m());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38841a;
        while (true) {
            x xVar = (x) atomicReferenceFieldUpdater.get(this);
            if (xVar.d()) {
                return;
            } else {
                al.o.a(f38841a, this, xVar, xVar.m());
            }
        }
    }

    public final int c() {
        return ((x) f38841a.get(this)).f();
    }

    public final boolean d() {
        return ((x) f38841a.get(this)).g();
    }

    public final boolean e() {
        return ((x) f38841a.get(this)).h();
    }

    public final void f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, ik.l<Object, z1> lVar, Object obj) {
        while (true) {
            lVar.i(atomicReferenceFieldUpdater.get(obj));
        }
    }

    @yt.k
    public final <R> List<R> g(@yt.k ik.l<? super E, ? extends R> lVar) {
        return ((x) f38841a.get(this)).k(lVar);
    }

    @yt.l
    public final E h() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f38841a;
        while (true) {
            x xVar = (x) atomicReferenceFieldUpdater.get(this);
            E e10 = (E) xVar.n();
            if (e10 != x.f38857t) {
                return e10;
            }
            al.o.a(f38841a, this, xVar, xVar.m());
        }
    }
}
