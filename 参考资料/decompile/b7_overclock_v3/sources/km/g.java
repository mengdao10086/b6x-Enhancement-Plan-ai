package km;

import gm.f2;
import gm.j2;

/* JADX INFO: loaded from: classes5.dex */
public class g extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zn.b f37491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gm.f0 f37492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final om.p f37493c;

    public g(gm.f0 f0Var) {
        if (f0Var.size() != 3) {
            throw new IllegalArgumentException("incorrect sequence size");
        }
        this.f37491a = zn.b.z(f0Var.K(0));
        this.f37492b = gm.f0.J(f0Var.K(1));
        this.f37493c = om.p.y(f0Var.K(2));
    }

    public g(zn.b bVar, byte[][] bArr, om.p pVar) {
        this.f37491a = bVar;
        gm.i iVar = new gm.i(bArr.length);
        for (int i10 = 0; i10 != bArr.length; i10++) {
            iVar.a(new f2(org.bouncycastle.util.a.p(bArr[i10])));
        }
        this.f37492b = new j2(iVar);
        this.f37493c = pVar;
    }

    public static g z(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(gm.f0.J(obj));
        }
        return null;
    }

    public om.p A() {
        return this.f37493c;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(3);
        iVar.a(this.f37491a);
        iVar.a(this.f37492b);
        iVar.a(this.f37493c);
        return new j2(iVar);
    }

    public byte[][] x() {
        int size = this.f37492b.size();
        byte[][] bArr = new byte[size][];
        for (int i10 = 0; i10 != size; i10++) {
            bArr[i10] = org.bouncycastle.util.a.p(gm.z.I(this.f37492b.K(i10)).J());
        }
        return bArr;
    }

    public zn.b y() {
        return this.f37491a;
    }
}
