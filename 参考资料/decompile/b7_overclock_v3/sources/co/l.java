package co;

import gm.c0;
import gm.f0;
import gm.j2;
import gm.t;
import gm.w;
import gm.z;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes5.dex */
public class l extends w implements r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final BigInteger f11139g = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p f11140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ir.e f11141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public n f11142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BigInteger f11143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f11144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f11145f;

    public l(f0 f0Var) {
        if (!(f0Var.K(0) instanceof t) || !((t) f0Var.K(0)).L(1)) {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }
        this.f11143d = ((t) f0Var.K(4)).K();
        if (f0Var.size() == 6) {
            this.f11144e = ((t) f0Var.K(5)).K();
        }
        k kVar = new k(p.y(f0Var.K(1)), this.f11143d, this.f11144e, f0.J(f0Var.K(2)));
        this.f11141b = kVar.x();
        gm.h hVarK = f0Var.K(3);
        if (hVarK instanceof n) {
            this.f11142c = (n) hVarK;
        } else {
            this.f11142c = new n(this.f11141b, (z) hVarK);
        }
        this.f11145f = kVar.y();
    }

    public l(ir.e eVar, n nVar, BigInteger bigInteger) {
        this(eVar, nVar, bigInteger, null, null);
    }

    public l(ir.e eVar, n nVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eVar, nVar, bigInteger, bigInteger2, null);
    }

    public l(ir.e eVar, n nVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        p pVar;
        this.f11141b = eVar;
        this.f11142c = nVar;
        this.f11143d = bigInteger;
        this.f11144e = bigInteger2;
        this.f11145f = org.bouncycastle.util.a.p(bArr);
        if (ir.c.o(eVar)) {
            pVar = new p(eVar.u().e());
        } else {
            if (!ir.c.m(eVar)) {
                throw new IllegalArgumentException("'curve' is of an unsupported type");
            }
            int[] iArrB = ((qr.g) eVar.u()).c().b();
            if (iArrB.length == 3) {
                pVar = new p(iArrB[2], iArrB[1]);
            } else {
                if (iArrB.length != 5) {
                    throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
                }
                pVar = new p(iArrB[4], iArrB[1], iArrB[2], iArrB[3]);
            }
        }
        this.f11140a = pVar;
    }

    public static l D(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(f0.J(obj));
        }
        return null;
    }

    public p A() {
        return this.f11140a;
    }

    public ir.i B() {
        return this.f11142c.x();
    }

    public BigInteger C() {
        return this.f11144e;
    }

    public BigInteger E() {
        return this.f11143d;
    }

    public byte[] F() {
        return org.bouncycastle.util.a.p(this.f11145f);
    }

    public boolean G() {
        return this.f11145f != null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        gm.i iVar = new gm.i(6);
        iVar.a(new t(f11139g));
        iVar.a(this.f11140a);
        iVar.a(new k(this.f11141b, this.f11145f));
        iVar.a(this.f11142c);
        iVar.a(new t(this.f11143d));
        if (this.f11144e != null) {
            iVar.a(new t(this.f11144e));
        }
        return new j2(iVar);
    }

    public n x() {
        return this.f11142c;
    }

    public ir.e y() {
        return this.f11141b;
    }

    public k z() {
        return new k(this.f11141b, this.f11145f);
    }
}
