package km;

import gm.f2;
import gm.j2;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class e0 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gm.t f37456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zn.b f37457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gm.f0 f37458c;

    public e0(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37456a = gm.t.I(f0Var.K(0));
        this.f37457b = zn.b.z(f0Var.K(1));
        this.f37458c = gm.f0.J(f0Var.K(2));
    }

    public e0(BigInteger bigInteger, zn.b bVar, byte[][] bArr) {
        this.f37456a = new gm.t(bigInteger);
        this.f37457b = bVar;
        gm.i iVar = new gm.i(bArr.length);
        for (int i10 = 0; i10 != bArr.length; i10++) {
            iVar.a(new f2(org.bouncycastle.util.a.p(bArr[i10])));
        }
        this.f37458c = new j2(iVar);
    }

    public static e0 z(Object obj) {
        if (obj instanceof e0) {
            return (e0) obj;
        }
        if (obj != null) {
            return new e0(gm.f0.J(obj));
        }
        return null;
    }

    public BigInteger A() {
        return this.f37456a.K();
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f37456a);
        iVar.a(this.f37457b);
        iVar.a(this.f37458c);
        return new j2(iVar);
    }

    public byte[][] x() {
        int size = this.f37458c.size();
        byte[][] bArr = new byte[size][];
        for (int i10 = 0; i10 != size; i10++) {
            bArr[i10] = org.bouncycastle.util.a.p(gm.z.I(this.f37458c.K(i10)).J());
        }
        return bArr;
    }

    public zn.b y() {
        return this.f37457b;
    }
}
