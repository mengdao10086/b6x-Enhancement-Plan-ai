package mm;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class z extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.z f41435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.o f41436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0 f41437c;

    public z(gm.f0 f0Var) {
        gm.h hVarK;
        this.f41435a = (gm.z) f0Var.K(0);
        int size = f0Var.size();
        if (size != 1) {
            if (size == 2) {
                boolean z10 = f0Var.K(1) instanceof gm.o;
                hVarK = f0Var.K(1);
                if (z10) {
                    this.f41436b = (gm.o) hVarK;
                    return;
                }
            } else {
                if (size != 3) {
                    throw new IllegalArgumentException("Invalid KEKIdentifier");
                }
                this.f41436b = (gm.o) f0Var.K(1);
                hVarK = f0Var.K(2);
            }
            this.f41437c = i0.x(hVarK);
        }
    }

    public z(byte[] bArr, gm.o oVar, i0 i0Var) {
        this.f41435a = new f2(bArr);
        this.f41436b = oVar;
        this.f41437c = i0Var;
    }

    public static z y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static z z(Object obj) {
        if (obj == null || (obj instanceof z)) {
            return (z) obj;
        }
        if (obj instanceof gm.f0) {
            return new z((gm.f0) obj);
        }
        throw new IllegalArgumentException("Invalid KEKIdentifier: " + obj.getClass().getName());
    }

    public gm.z A() {
        return this.f41435a;
    }

    public i0 B() {
        return this.f41437c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f41435a);
        gm.o oVar = this.f41436b;
        if (oVar != null) {
            iVar.a(oVar);
        }
        i0 i0Var = this.f41437c;
        if (i0Var != null) {
            iVar.a(i0Var);
        }
        return new j2(iVar);
    }

    public gm.o x() {
        return this.f41436b;
    }
}
