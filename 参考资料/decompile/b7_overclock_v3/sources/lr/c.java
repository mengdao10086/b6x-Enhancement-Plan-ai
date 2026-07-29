package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class c extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40158h = new BigInteger(1, jt.h.d("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f40159g;

    public c() {
        this.f40159g = rr.e.j();
    }

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f40158h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        }
        this.f40159g = b.e(bigInteger);
    }

    public c(int[] iArr) {
        this.f40159g = iArr;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        int[] iArrJ = rr.e.j();
        b.a(this.f40159g, ((c) fVar).f40159g, iArrJ);
        return new c(iArrJ);
    }

    @Override // ir.f
    public ir.f b() {
        int[] iArrJ = rr.e.j();
        b.c(this.f40159g, iArrJ);
        return new c(iArrJ);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        int[] iArrJ = rr.e.j();
        b.g(((c) fVar).f40159g, iArrJ);
        b.i(iArrJ, this.f40159g, iArrJ);
        return new c(iArrJ);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return rr.e.o(this.f40159g, ((c) obj).f40159g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecP128R1Field";
    }

    @Override // ir.f
    public int g() {
        return f40158h.bitLength();
    }

    @Override // ir.f
    public ir.f h() {
        int[] iArrJ = rr.e.j();
        b.g(this.f40159g, iArrJ);
        return new c(iArrJ);
    }

    public int hashCode() {
        return f40158h.hashCode() ^ org.bouncycastle.util.a.w0(this.f40159g, 0, 4);
    }

    @Override // ir.f
    public boolean i() {
        return rr.e.v(this.f40159g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.e.x(this.f40159g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        int[] iArrJ = rr.e.j();
        b.i(this.f40159g, ((c) fVar).f40159g, iArrJ);
        return new c(iArrJ);
    }

    @Override // ir.f
    public ir.f n() {
        int[] iArrJ = rr.e.j();
        b.k(this.f40159g, iArrJ);
        return new c(iArrJ);
    }

    @Override // ir.f
    public ir.f o() {
        int[] iArr = this.f40159g;
        if (rr.e.x(iArr) || rr.e.v(iArr)) {
            return this;
        }
        int[] iArrJ = rr.e.j();
        b.p(iArr, iArrJ);
        b.i(iArrJ, iArr, iArrJ);
        int[] iArrJ2 = rr.e.j();
        b.q(iArrJ, 2, iArrJ2);
        b.i(iArrJ2, iArrJ, iArrJ2);
        int[] iArrJ3 = rr.e.j();
        b.q(iArrJ2, 4, iArrJ3);
        b.i(iArrJ3, iArrJ2, iArrJ3);
        b.q(iArrJ3, 2, iArrJ2);
        b.i(iArrJ2, iArrJ, iArrJ2);
        b.q(iArrJ2, 10, iArrJ);
        b.i(iArrJ, iArrJ2, iArrJ);
        b.q(iArrJ, 10, iArrJ3);
        b.i(iArrJ3, iArrJ2, iArrJ3);
        b.p(iArrJ3, iArrJ2);
        b.i(iArrJ2, iArr, iArrJ2);
        b.q(iArrJ2, 95, iArrJ2);
        b.p(iArrJ2, iArrJ3);
        if (rr.e.o(iArr, iArrJ3)) {
            return new c(iArrJ2);
        }
        return null;
    }

    @Override // ir.f
    public ir.f p() {
        int[] iArrJ = rr.e.j();
        b.p(this.f40159g, iArrJ);
        return new c(iArrJ);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        int[] iArrJ = rr.e.j();
        b.s(this.f40159g, ((c) fVar).f40159g, iArrJ);
        return new c(iArrJ);
    }

    @Override // ir.f
    public boolean u() {
        return rr.e.s(this.f40159g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.e.R(this.f40159g);
    }
}
