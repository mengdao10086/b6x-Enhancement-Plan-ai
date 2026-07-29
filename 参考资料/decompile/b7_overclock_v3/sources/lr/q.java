package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class q extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40331h = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f40332g;

    public q() {
        this.f40332g = rr.g.j();
    }

    public q(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f40331h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        }
        this.f40332g = p.d(bigInteger);
    }

    public q(int[] iArr) {
        this.f40332g = iArr;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        int[] iArrJ = rr.g.j();
        p.a(this.f40332g, ((q) fVar).f40332g, iArrJ);
        return new q(iArrJ);
    }

    @Override // ir.f
    public ir.f b() {
        int[] iArrJ = rr.g.j();
        p.c(this.f40332g, iArrJ);
        return new q(iArrJ);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        int[] iArrJ = rr.g.j();
        p.f(((q) fVar).f40332g, iArrJ);
        p.h(iArrJ, this.f40332g, iArrJ);
        return new q(iArrJ);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof q) {
            return rr.g.o(this.f40332g, ((q) obj).f40332g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecP192K1Field";
    }

    @Override // ir.f
    public int g() {
        return f40331h.bitLength();
    }

    @Override // ir.f
    public ir.f h() {
        int[] iArrJ = rr.g.j();
        p.f(this.f40332g, iArrJ);
        return new q(iArrJ);
    }

    public int hashCode() {
        return f40331h.hashCode() ^ org.bouncycastle.util.a.w0(this.f40332g, 0, 6);
    }

    @Override // ir.f
    public boolean i() {
        return rr.g.v(this.f40332g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.g.x(this.f40332g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        int[] iArrJ = rr.g.j();
        p.h(this.f40332g, ((q) fVar).f40332g, iArrJ);
        return new q(iArrJ);
    }

    @Override // ir.f
    public ir.f n() {
        int[] iArrJ = rr.g.j();
        p.j(this.f40332g, iArrJ);
        return new q(iArrJ);
    }

    @Override // ir.f
    public ir.f o() {
        int[] iArr = this.f40332g;
        if (rr.g.x(iArr) || rr.g.v(iArr)) {
            return this;
        }
        int[] iArrJ = rr.g.j();
        p.o(iArr, iArrJ);
        p.h(iArrJ, iArr, iArrJ);
        int[] iArrJ2 = rr.g.j();
        p.o(iArrJ, iArrJ2);
        p.h(iArrJ2, iArr, iArrJ2);
        int[] iArrJ3 = rr.g.j();
        p.p(iArrJ2, 3, iArrJ3);
        p.h(iArrJ3, iArrJ2, iArrJ3);
        p.p(iArrJ3, 2, iArrJ3);
        p.h(iArrJ3, iArrJ, iArrJ3);
        p.p(iArrJ3, 8, iArrJ);
        p.h(iArrJ, iArrJ3, iArrJ);
        p.p(iArrJ, 3, iArrJ3);
        p.h(iArrJ3, iArrJ2, iArrJ3);
        int[] iArrJ4 = rr.g.j();
        p.p(iArrJ3, 16, iArrJ4);
        p.h(iArrJ4, iArrJ, iArrJ4);
        p.p(iArrJ4, 35, iArrJ);
        p.h(iArrJ, iArrJ4, iArrJ);
        p.p(iArrJ, 70, iArrJ4);
        p.h(iArrJ4, iArrJ, iArrJ4);
        p.p(iArrJ4, 19, iArrJ);
        p.h(iArrJ, iArrJ3, iArrJ);
        p.p(iArrJ, 20, iArrJ);
        p.h(iArrJ, iArrJ3, iArrJ);
        p.p(iArrJ, 4, iArrJ);
        p.h(iArrJ, iArrJ2, iArrJ);
        p.p(iArrJ, 6, iArrJ);
        p.h(iArrJ, iArrJ2, iArrJ);
        p.o(iArrJ, iArrJ);
        p.o(iArrJ, iArrJ2);
        if (rr.g.o(iArr, iArrJ2)) {
            return new q(iArrJ);
        }
        return null;
    }

    @Override // ir.f
    public ir.f p() {
        int[] iArrJ = rr.g.j();
        p.o(this.f40332g, iArrJ);
        return new q(iArrJ);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        int[] iArrJ = rr.g.j();
        p.q(this.f40332g, ((q) fVar).f40332g, iArrJ);
        return new q(iArrJ);
    }

    @Override // ir.f
    public boolean u() {
        return rr.g.s(this.f40332g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.g.Q(this.f40332g);
    }
}
