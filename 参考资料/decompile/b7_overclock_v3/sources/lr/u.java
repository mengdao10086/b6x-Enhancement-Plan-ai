package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class u extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40378h = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f40379g;

    public u() {
        this.f40379g = rr.g.j();
    }

    public u(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f40378h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        this.f40379g = t.e(bigInteger);
    }

    public u(int[] iArr) {
        this.f40379g = iArr;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        int[] iArrJ = rr.g.j();
        t.a(this.f40379g, ((u) fVar).f40379g, iArrJ);
        return new u(iArrJ);
    }

    @Override // ir.f
    public ir.f b() {
        int[] iArrJ = rr.g.j();
        t.c(this.f40379g, iArrJ);
        return new u(iArrJ);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        int[] iArrJ = rr.g.j();
        t.g(((u) fVar).f40379g, iArrJ);
        t.i(iArrJ, this.f40379g, iArrJ);
        return new u(iArrJ);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            return rr.g.o(this.f40379g, ((u) obj).f40379g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecP192R1Field";
    }

    @Override // ir.f
    public int g() {
        return f40378h.bitLength();
    }

    @Override // ir.f
    public ir.f h() {
        int[] iArrJ = rr.g.j();
        t.g(this.f40379g, iArrJ);
        return new u(iArrJ);
    }

    public int hashCode() {
        return f40378h.hashCode() ^ org.bouncycastle.util.a.w0(this.f40379g, 0, 6);
    }

    @Override // ir.f
    public boolean i() {
        return rr.g.v(this.f40379g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.g.x(this.f40379g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        int[] iArrJ = rr.g.j();
        t.i(this.f40379g, ((u) fVar).f40379g, iArrJ);
        return new u(iArrJ);
    }

    @Override // ir.f
    public ir.f n() {
        int[] iArrJ = rr.g.j();
        t.k(this.f40379g, iArrJ);
        return new u(iArrJ);
    }

    @Override // ir.f
    public ir.f o() {
        int[] iArr = this.f40379g;
        if (rr.g.x(iArr) || rr.g.v(iArr)) {
            return this;
        }
        int[] iArrJ = rr.g.j();
        int[] iArrJ2 = rr.g.j();
        t.p(iArr, iArrJ);
        t.i(iArrJ, iArr, iArrJ);
        t.q(iArrJ, 2, iArrJ2);
        t.i(iArrJ2, iArrJ, iArrJ2);
        t.q(iArrJ2, 4, iArrJ);
        t.i(iArrJ, iArrJ2, iArrJ);
        t.q(iArrJ, 8, iArrJ2);
        t.i(iArrJ2, iArrJ, iArrJ2);
        t.q(iArrJ2, 16, iArrJ);
        t.i(iArrJ, iArrJ2, iArrJ);
        t.q(iArrJ, 32, iArrJ2);
        t.i(iArrJ2, iArrJ, iArrJ2);
        t.q(iArrJ2, 64, iArrJ);
        t.i(iArrJ, iArrJ2, iArrJ);
        t.q(iArrJ, 62, iArrJ);
        t.p(iArrJ, iArrJ2);
        if (rr.g.o(iArr, iArrJ2)) {
            return new u(iArrJ);
        }
        return null;
    }

    @Override // ir.f
    public ir.f p() {
        int[] iArrJ = rr.g.j();
        t.p(this.f40379g, iArrJ);
        return new u(iArrJ);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        int[] iArrJ = rr.g.j();
        t.s(this.f40379g, ((u) fVar).f40379g, iArrJ);
        return new u(iArrJ);
    }

    @Override // ir.f
    public boolean u() {
        return rr.g.s(this.f40379g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.g.Q(this.f40379g);
    }
}
