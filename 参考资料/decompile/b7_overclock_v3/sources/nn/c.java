package nn;

import gm.c0;
import gm.d2;
import gm.n0;
import gm.n2;
import gm.u;
import gm.v0;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class c extends w implements gm.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.h f42252b;

    public c() {
        this.f42251a = 0;
        this.f42252b = d2.f29657b;
    }

    public c(int i10, gm.h hVar) {
        this.f42251a = i10;
        this.f42252b = hVar;
    }

    public c(n0 n0Var) {
        gm.h hVarH;
        int iQ = n0Var.q();
        if (iQ == 0) {
            hVarH = u.H(n0Var, false);
        } else if (iQ != 1) {
            if (iQ != 2) {
                throw new IllegalArgumentException("Unknown tag encountered: " + v0.m(n0Var));
            }
            hVarH = u.H(n0Var, false);
        } else {
            hVarH = m.x(n0Var, false);
        }
        this.f42252b = hVarH;
        this.f42251a = iQ;
    }

    public c(m mVar) {
        this.f42251a = 1;
        this.f42252b = mVar;
    }

    public static c x(n0 n0Var, boolean z10) {
        return y(n0Var.U());
    }

    public static c y(Object obj) {
        if (obj == null || (obj instanceof c)) {
            return (c) obj;
        }
        if (obj instanceof n0) {
            return new c((n0) obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return new n2(false, this.f42251a, this.f42252b);
    }

    public int q() {
        return this.f42251a;
    }

    public gm.h z() {
        return this.f42252b;
    }
}
