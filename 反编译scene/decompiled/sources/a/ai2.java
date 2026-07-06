package a;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ai2<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f5611a = AtomicReferenceFieldUpdater.newUpdater(ai2.class, Object.class, "_cur");
    public volatile Object _cur;

    public ai2(boolean z) {
        this._cur = new di2(8, z);
    }

    public final boolean a(E e) {
        while (true) {
            di2 di2Var = (di2) this._cur;
            int iA = di2Var.a(e);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                f5611a.compareAndSet(this, di2Var, di2Var.i());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            di2 di2Var = (di2) this._cur;
            if (di2Var.d()) {
                return;
            } else {
                f5611a.compareAndSet(this, di2Var, di2Var.i());
            }
        }
    }

    public final int c() {
        return ((di2) this._cur).f();
    }

    public final E d() {
        while (true) {
            di2 di2Var = (di2) this._cur;
            E e = (E) di2Var.j();
            if (e != di2.f569a) {
                return e;
            }
            f5611a.compareAndSet(this, di2Var, di2Var.i());
        }
    }
}
