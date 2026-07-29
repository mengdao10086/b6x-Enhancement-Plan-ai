package vn;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.h;
import gm.i;
import gm.j2;
import gm.w;
import gm.y;
import gm.z;

/* JADX INFO: loaded from: classes5.dex */
public class d extends w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f53262d = {-87, -42, -21, 69, -15, 60, pq.b.f46994k, -126, -128, -60, -106, 123, 35, 31, 94, -83, -10, o5.b.f42741j, -21, -92, i1.a.f31667o7, 55, rc.a.f48409a0, 29, 56, i1.a.E7, 107, -16, rc.a.X, i1.a.f31732w7, 78, 23, -8, -23, 114, 13, i1.a.f31707t7, 21, -76, 58, 40, -105, 95, 11, i1.a.f31675p7, -34, -93, 100, 56, -75, 100, -22, rc.a.f48412d0, 23, -97, -48, 18, 62, 109, -72, -6, i1.a.f31699s7, 121, 4};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y f53263a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f53264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f53265c;

    public d(y yVar) {
        this.f53265c = f53262d;
        this.f53263a = yVar;
    }

    public d(y yVar, byte[] bArr) {
        this.f53265c = f53262d;
        this.f53263a = yVar;
        this.f53265c = org.bouncycastle.util.a.p(bArr);
    }

    public d(b bVar) {
        this.f53265c = f53262d;
        this.f53264b = bVar;
    }

    public static d A(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj == null) {
            throw new IllegalArgumentException("object parse error");
        }
        f0 f0VarJ = f0.J(obj);
        d dVar = f0VarJ.K(0) instanceof y ? new d(y.N(f0VarJ.K(0))) : new d(b.B(f0VarJ.K(0)));
        if (f0VarJ.size() == 2) {
            byte[] bArrJ = z.I(f0VarJ.K(1)).J();
            dVar.f53265c = bArrJ;
            if (bArrJ.length != f53262d.length) {
                throw new IllegalArgumentException("object parse error");
            }
        }
        return dVar;
    }

    public static byte[] y() {
        return org.bouncycastle.util.a.p(f53262d);
    }

    public y B() {
        return this.f53263a;
    }

    public boolean C() {
        return this.f53263a != null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(2);
        h hVar = this.f53263a;
        if (hVar == null) {
            hVar = this.f53264b;
        }
        iVar.a(hVar);
        if (!org.bouncycastle.util.a.g(this.f53265c, f53262d)) {
            iVar.a(new f2(this.f53265c));
        }
        return new j2(iVar);
    }

    public byte[] x() {
        return org.bouncycastle.util.a.p(this.f53265c);
    }

    public b z() {
        return this.f53264b;
    }
}
