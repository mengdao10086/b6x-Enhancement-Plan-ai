package pn;

import gm.f0;
import gm.f2;
import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class r extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f46786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.z f46787b;

    public r(f0 f0Var) {
        this.f46787b = (gm.z) f0Var.K(0);
        this.f46786a = gm.t.I(f0Var.K(1));
    }

    public r(byte[] bArr, int i10) {
        this.f46787b = new f2(bArr);
        this.f46786a = new gm.t(i10);
    }

    public static r y(Object obj) {
        if (obj instanceof r) {
            return (r) obj;
        }
        if (obj != null) {
            return new r(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f46787b);
        iVar.a(this.f46786a);
        return new j2(iVar);
    }

    public byte[] x() {
        return this.f46787b.J();
    }

    public BigInteger z() {
        return this.f46786a.K();
    }
}
