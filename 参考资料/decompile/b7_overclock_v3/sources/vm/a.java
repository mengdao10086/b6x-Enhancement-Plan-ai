package vm;

import gm.c0;
import gm.f0;
import gm.i;
import gm.j2;
import gm.p2;
import gm.r0;
import gm.w;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public class a extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r0 f53230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f53231b;

    public a(f0 f0Var) {
        int i10 = 0;
        gm.h hVarK = f0Var.K(0);
        if (hVarK.b() instanceof r0) {
            this.f53230a = r0.I(hVarK);
            i10 = 1;
        }
        this.f53231b = y.N(f0Var.K(i10));
    }

    public a(y yVar) {
        this.f53231b = yVar;
        this.f53230a = null;
    }

    public a(y yVar, r0 r0Var) {
        this.f53231b = yVar;
        this.f53230a = r0Var;
    }

    public static a A(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        r0 r0Var = this.f53230a;
        if (r0Var != null) {
            iVar.a(r0Var);
        }
        iVar.a(this.f53231b);
        return new j2(iVar);
    }

    public p2 x() {
        r0 r0Var = this.f53230a;
        return (r0Var == null || (r0Var instanceof p2)) ? (p2) r0Var : new p2(this.f53230a.d());
    }

    public r0 y() {
        return this.f53230a;
    }

    public y z() {
        return this.f53231b;
    }
}
