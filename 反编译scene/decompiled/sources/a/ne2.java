package a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ne2<T> extends ji2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f6907a = AtomicIntegerFieldUpdater.newUpdater(ne2.class, "_decision");
    public volatile int _decision;

    public ne2(l62 l62Var, b62<? super T> b62Var) {
        super(l62Var, b62Var);
        this._decision = 0;
    }

    @Override // a.ji2, a.hc2
    public void D0(Object obj) {
        if (K0()) {
            return;
        }
        me2.b(q62.b(((ji2) this).f6514a), hd2.a(obj, ((ji2) this).f6514a));
    }

    @Override // a.ji2, a.bg2
    public void E(Object obj) {
        D0(obj);
    }

    public final Object J0() {
        if (L0()) {
            return r62.c();
        }
        Object objH = cg2.h(a0());
        if (objH instanceof gd2) {
            throw ((gd2) objH).f999a;
        }
        return objH;
    }

    public final boolean K0() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!f6907a.compareAndSet(this, 0, 2));
        return true;
    }

    public final boolean L0() {
        do {
            int i = this._decision;
            if (i != 0) {
                if (i == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!f6907a.compareAndSet(this, 0, 1));
        return true;
    }
}
