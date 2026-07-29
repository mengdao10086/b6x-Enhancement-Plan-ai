package km;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class c0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f37433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.o f37434b;

    public c0(gm.f0 f0Var) {
        if (f0Var.size() != 2) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37433a = org.bouncycastle.util.a.p(gm.z.I(f0Var.K(0)).J());
        this.f37434b = gm.o.M(f0Var.K(1));
    }

    public c0(byte[] bArr, gm.o oVar) {
        this.f37433a = org.bouncycastle.util.a.p(bArr);
        this.f37434b = oVar;
    }

    public static c0 x(Object obj) {
        if (obj instanceof c0) {
            return (c0) obj;
        }
        if (obj != null) {
            return new c0(gm.f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(new f2(this.f37433a));
        iVar.a(this.f37434b);
        return new j2(iVar);
    }

    public gm.o y() {
        return this.f37434b;
    }

    public byte[] z() {
        return org.bouncycastle.util.a.p(this.f37433a);
    }
}
