package qm;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.w;
import gm.y;
import gm.z;
import zn.c1;

/* JADX INFO: loaded from: classes5.dex */
public class k extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f47508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c1 f47509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f47510c;

    public k(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f47508a = y.N(f0Var.K(0));
            this.f47510c = z.I(f0Var.K(1)).J();
            this.f47509b = null;
        } else if (f0Var.size() == 3) {
            this.f47508a = y.N(f0Var.K(0));
            this.f47509b = c1.z(n0.T(f0Var.K(1)), false);
            this.f47510c = z.I(f0Var.K(2)).J();
        } else {
            throw new IllegalArgumentException("unknown sequence length: " + f0Var.size());
        }
    }

    public k(y yVar, c1 c1Var, byte[] bArr) {
        this.f47508a = yVar;
        this.f47509b = c1Var;
        this.f47510c = org.bouncycastle.util.a.p(bArr);
    }

    public static k A(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(f0.J(obj));
        }
        return null;
    }

    public static k z(n0 n0Var, boolean z10) {
        return new k(f0.I(n0Var, z10));
    }

    public byte[] B() {
        return org.bouncycastle.util.a.p(this.f47510c);
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f47508a);
        c1 c1Var = this.f47509b;
        if (c1Var != null) {
            iVar.a(new n2(false, 0, (gm.h) c1Var));
        }
        iVar.a(new f2(this.f47510c));
        return new j2(iVar);
    }

    public y x() {
        return this.f47508a;
    }

    public c1 y() {
        return this.f47509b;
    }
}
