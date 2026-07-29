package zn;

import gm.f2;

/* JADX INFO: loaded from: classes5.dex */
public class b1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f58679a;

    public b1(gm.z zVar) {
        this(zVar.J());
    }

    public b1(byte[] bArr) {
        this.f58679a = org.bouncycastle.util.a.p(bArr);
    }

    public static b1 x(z zVar) {
        return z(z.E(zVar, y.f59058e));
    }

    public static b1 y(gm.n0 n0Var, boolean z10) {
        return z(gm.z.H(n0Var, z10));
    }

    public static b1 z(Object obj) {
        if (obj instanceof b1) {
            return (b1) obj;
        }
        if (obj != null) {
            return new b1(gm.z.I(obj));
        }
        return null;
    }

    public byte[] A() {
        return org.bouncycastle.util.a.p(this.f58679a);
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        return new f2(A());
    }
}
