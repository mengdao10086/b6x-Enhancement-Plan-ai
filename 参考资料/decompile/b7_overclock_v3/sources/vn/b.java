package vn;

import gm.c0;
import gm.f0;
import gm.f2;
import gm.h;
import gm.i;
import gm.j2;
import gm.n0;
import gm.n2;
import gm.t;
import gm.w;
import gm.z;
import java.math.BigInteger;
import np.g0;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BigInteger f53251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f53252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f53253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public z f53254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t f53255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public z f53256f;

    public b(f0 f0Var) {
        this.f53251a = BigInteger.valueOf(0L);
        int i10 = 0;
        if (f0Var.K(0) instanceof n0) {
            n0 n0Var = (n0) f0Var.K(0);
            if (!n0Var.W() || n0Var.q() != 0) {
                throw new IllegalArgumentException("object parse error");
            }
            this.f53251a = t.I(n0Var.o()).K();
            i10 = 1;
        }
        this.f53252b = a.x(f0Var.K(i10));
        int i11 = i10 + 1;
        this.f53253c = t.I(f0Var.K(i11));
        int i12 = i11 + 1;
        this.f53254d = z.I(f0Var.K(i12));
        int i13 = i12 + 1;
        this.f53255e = t.I(f0Var.K(i13));
        this.f53256f = z.I(f0Var.K(i13 + 1));
    }

    public b(g0 g0Var) {
        a aVar;
        this.f53251a = BigInteger.valueOf(0L);
        ir.e eVarA = g0Var.a();
        if (!ir.c.m(eVarA)) {
            throw new IllegalArgumentException("only binary domain is possible");
        }
        int[] iArrB = ((qr.g) eVarA.u()).c().b();
        if (iArrB.length == 3) {
            aVar = new a(iArrB[2], iArrB[1]);
        } else {
            if (iArrB.length != 5) {
                throw new IllegalArgumentException("curve must have a trinomial or pentanomial basis");
            }
            aVar = new a(iArrB[4], iArrB[1], iArrB[2], iArrB[3]);
        }
        this.f53252b = aVar;
        this.f53253c = new t(eVarA.o().v());
        this.f53254d = new f2(eVarA.q().e());
        this.f53255e = new t(g0Var.e());
        this.f53256f = new f2(e.b(g0Var.b()));
    }

    public static b B(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    public byte[] A() {
        return org.bouncycastle.util.a.p(this.f53256f.J());
    }

    public BigInteger C() {
        return this.f53255e.K();
    }

    @Override // gm.w, gm.h
    public c0 b() {
        i iVar = new i(6);
        if (this.f53251a.compareTo(BigInteger.valueOf(0L)) != 0) {
            iVar.a(new n2(true, 0, (h) new t(this.f53251a)));
        }
        iVar.a(this.f53252b);
        iVar.a(this.f53253c);
        iVar.a(this.f53254d);
        iVar.a(this.f53255e);
        iVar.a(this.f53256f);
        return new j2(iVar);
    }

    public BigInteger x() {
        return this.f53253c.K();
    }

    public byte[] y() {
        return org.bouncycastle.util.a.p(this.f53254d.J());
    }

    public a z() {
        return this.f53252b;
    }
}
