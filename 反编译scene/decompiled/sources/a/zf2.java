package a;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zf2 implements jf2 {
    public volatile Object _exceptionsHolder = null;
    public volatile int _isCompleting;
    public volatile Object _rootCause;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gg2 f8069a;

    public zf2(gg2 gg2Var, boolean z, Throwable th) {
        this.f8069a = gg2Var;
        this._isCompleting = z ? 1 : 0;
        this._rootCause = th;
    }

    @Override // a.jf2
    public boolean a() {
        return f() == null;
    }

    public final void b(Throwable th) {
        Throwable thF = f();
        if (thF == null) {
            m(th);
            return;
        }
        if (th == thF) {
            return;
        }
        Object objE = e();
        if (objE == null) {
            l(th);
            return;
        }
        if (!(objE instanceof Throwable)) {
            if (objE instanceof ArrayList) {
                ((ArrayList) objE).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + objE).toString());
        }
        if (th == objE) {
            return;
        }
        ArrayList<Throwable> arrayListD = d();
        arrayListD.add(objE);
        arrayListD.add(th);
        m42 m42Var = m42.f6769a;
        l(arrayListD);
    }

    @Override // a.jf2
    public gg2 c() {
        return this.f8069a;
    }

    public final ArrayList<Throwable> d() {
        return new ArrayList<>(4);
    }

    public final Object e() {
        return this._exceptionsHolder;
    }

    public final Throwable f() {
        return (Throwable) this._rootCause;
    }

    public final boolean g() {
        return f() != null;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean h() {
        return this._isCompleting;
    }

    public final boolean i() {
        return e() == cg2.e;
    }

    public final List<Throwable> j(Throwable th) {
        ArrayList<Throwable> arrayListD;
        Object objE = e();
        if (objE == null) {
            arrayListD = d();
        } else if (objE instanceof Throwable) {
            ArrayList<Throwable> arrayListD2 = d();
            arrayListD2.add(objE);
            arrayListD = arrayListD2;
        } else {
            if (!(objE instanceof ArrayList)) {
                throw new IllegalStateException(("State is " + objE).toString());
            }
            arrayListD = (ArrayList) objE;
        }
        Throwable thF = f();
        if (thF != null) {
            arrayListD.add(0, thF);
        }
        if (th != null && (!f92.a(th, thF))) {
            arrayListD.add(th);
        }
        l(cg2.e);
        return arrayListD;
    }

    public final void k(boolean z) {
        this._isCompleting = z ? 1 : 0;
    }

    public final void l(Object obj) {
        this._exceptionsHolder = obj;
    }

    public final void m(Throwable th) {
        this._rootCause = th;
    }

    public String toString() {
        return "Finishing[cancelling=" + g() + ", completing=" + h() + ", rootCause=" + f() + ", exceptions=" + e() + ", list=" + c() + ']';
    }
}
