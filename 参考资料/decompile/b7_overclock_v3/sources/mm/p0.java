package mm;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class p0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.z f41372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.o f41373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i0 f41374c;

    public p0(gm.f0 f0Var) {
        this.f41372a = gm.z.I(f0Var.K(0));
        int size = f0Var.size();
        if (size != 1) {
            if (size != 2) {
                if (size != 3) {
                    throw new IllegalArgumentException("Invalid RecipientKeyIdentifier");
                }
                this.f41373b = gm.o.M(f0Var.K(1));
            } else if (f0Var.K(1) instanceof gm.o) {
                this.f41373b = gm.o.M(f0Var.K(1));
                return;
            }
            this.f41374c = i0.x(f0Var.K(2));
        }
    }

    public p0(gm.z zVar, gm.o oVar, i0 i0Var) {
        this.f41372a = zVar;
        this.f41373b = oVar;
        this.f41374c = i0Var;
    }

    public p0(byte[] bArr) {
        this(bArr, (gm.o) null, (i0) null);
    }

    public p0(byte[] bArr, gm.o oVar, i0 i0Var) {
        this.f41372a = new f2(bArr);
        this.f41373b = oVar;
        this.f41374c = i0Var;
    }

    public static p0 y(gm.n0 n0Var, boolean z10) {
        return z(gm.f0.I(n0Var, z10));
    }

    public static p0 z(Object obj) {
        if (obj instanceof p0) {
            return (p0) obj;
        }
        if (obj != null) {
            return new p0(gm.f0.J(obj));
        }
        return null;
    }

    public i0 A() {
        return this.f41374c;
    }

    public gm.z B() {
        return this.f41372a;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f41372a);
        gm.o oVar = this.f41373b;
        if (oVar != null) {
            iVar.a(oVar);
        }
        i0 i0Var = this.f41374c;
        if (i0Var != null) {
            iVar.a(i0Var);
        }
        return new j2(iVar);
    }

    public gm.o x() {
        return this.f41373b;
    }
}
