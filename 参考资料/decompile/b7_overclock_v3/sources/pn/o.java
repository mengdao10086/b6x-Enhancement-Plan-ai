package pn;

import gm.f0;
import gm.f2;
import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class o extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gm.t f46777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public gm.z f46778b;

    public o(f0 f0Var) {
        this.f46778b = (gm.z) f0Var.K(0);
        this.f46777a = (gm.t) f0Var.K(1);
    }

    public o(byte[] bArr, int i10) {
        if (bArr.length != 8) {
            throw new IllegalArgumentException("salt length must be 8");
        }
        this.f46778b = new f2(bArr);
        this.f46777a = new gm.t(i10);
    }

    public static o x(Object obj) {
        if (obj instanceof o) {
            return (o) obj;
        }
        if (obj != null) {
            return new o(f0.J(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        iVar.a(this.f46778b);
        iVar.a(this.f46777a);
        return new j2(iVar);
    }

    public BigInteger y() {
        return this.f46777a.K();
    }

    public byte[] z() {
        return this.f46778b.J();
    }
}
