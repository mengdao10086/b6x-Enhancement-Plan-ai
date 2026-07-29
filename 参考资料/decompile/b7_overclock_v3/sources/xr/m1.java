package xr;

/* JADX INFO: loaded from: classes6.dex */
public class m1 extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[][] f55974a;

    public m1(gm.f0 f0Var) {
        this.f55974a = y(f0Var);
    }

    public static m1 x(Object obj) {
        if (obj instanceof m1) {
            return (m1) obj;
        }
        if (obj != null) {
            return new m1(gm.f0.J(obj));
        }
        return null;
    }

    public static byte[][] y(gm.f0 f0Var) {
        byte[][] bArr = new byte[f0Var.size()][];
        for (int i10 = 0; i10 != f0Var.size(); i10++) {
            bArr[i10] = gm.z.I(f0Var.K(i10)).J();
        }
        return bArr;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i();
        for (int i10 = 0; i10 != this.f55974a.length; i10++) {
            iVar.a(new gm.f2(org.bouncycastle.util.a.p(this.f55974a[i10])));
        }
        return new gm.j2(iVar);
    }

    public int size() {
        return this.f55974a.length;
    }
}
