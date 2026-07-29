package om;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.r0;
import zn.b0;

/* JADX INFO: loaded from: classes5.dex */
public class k extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pn.u f44306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.h f44307b;

    public k(f0 f0Var) {
        gm.h hVarK;
        this.f44306a = pn.u.z(f0Var.K(0));
        if (f0Var.size() > 1) {
            boolean z10 = f0Var.K(1) instanceof r0;
            hVarK = f0Var.K(1);
            if (!z10) {
                hVarK = b0.z(hVarK);
            }
        } else {
            hVarK = null;
        }
        this.f44307b = hVarK;
    }

    public k(pn.u uVar) {
        this.f44306a = uVar;
        this.f44307b = null;
    }

    public k(pn.u uVar, r0 r0Var) {
        this.f44306a = uVar;
        this.f44307b = r0Var;
    }

    public k(pn.u uVar, b0 b0Var) {
        this.f44306a = uVar;
        this.f44307b = b0Var;
    }

    public static k y(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(f0.J(obj));
        }
        return null;
    }

    public boolean A() {
        return this.f44307b != null;
    }

    public boolean B() {
        return this.f44307b instanceof r0;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f44306a);
        gm.h hVar = this.f44307b;
        if (hVar != null) {
            iVar.a(hVar);
        }
        return new j2(iVar);
    }

    public gm.h x() {
        return this.f44307b;
    }

    public pn.u z() {
        return this.f44306a;
    }
}
