package qm;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.j2;
import gm.w;
import gm.y;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class i extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f47504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f47505b;

    public i(f0 f0Var) {
        if (f0Var.size() == 2) {
            this.f47504a = y.N(f0Var.K(0));
            this.f47505b = z.I(f0Var.K(1)).J();
        } else if (f0Var.size() == 1) {
            this.f47504a = y.N(f0Var.K(0));
            this.f47505b = null;
        } else {
            throw new IllegalArgumentException("unknown sequence length: " + f0Var.size());
        }
    }

    public i(y yVar) {
        this(yVar, null);
    }

    public i(y yVar, byte[] bArr) {
        this.f47504a = yVar;
        this.f47505b = org.bouncycastle.util.a.p(bArr);
    }

    public static i y(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f47504a);
        if (this.f47505b != null) {
            iVar.a(new f2(this.f47505b));
        }
        return new j2(iVar);
    }

    public y x() {
        return this.f47504a;
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f47505b);
    }
}
