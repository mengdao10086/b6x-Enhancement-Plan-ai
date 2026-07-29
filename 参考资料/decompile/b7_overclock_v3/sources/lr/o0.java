package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class o0 extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40314h = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f40315g;

    public o0() {
        this.f40315g = rr.o.D(12);
    }

    public o0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f40314h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.f40315g = n0.e(bigInteger);
    }

    public o0(int[] iArr) {
        this.f40315g = iArr;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        int[] iArrD = rr.o.D(12);
        n0.a(this.f40315g, ((o0) fVar).f40315g, iArrD);
        return new o0(iArrD);
    }

    @Override // ir.f
    public ir.f b() {
        int[] iArrD = rr.o.D(12);
        n0.c(this.f40315g, iArrD);
        return new o0(iArrD);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        int[] iArrD = rr.o.D(12);
        n0.g(((o0) fVar).f40315g, iArrD);
        n0.i(iArrD, this.f40315g, iArrD);
        return new o0(iArrD);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o0) {
            return rr.o.M(12, this.f40315g, ((o0) obj).f40315g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecP384R1Field";
    }

    @Override // ir.f
    public int g() {
        return f40314h.bitLength();
    }

    @Override // ir.f
    public ir.f h() {
        int[] iArrD = rr.o.D(12);
        n0.g(this.f40315g, iArrD);
        return new o0(iArrD);
    }

    public int hashCode() {
        return f40314h.hashCode() ^ org.bouncycastle.util.a.w0(this.f40315g, 0, 12);
    }

    @Override // ir.f
    public boolean i() {
        return rr.o.c0(12, this.f40315g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.o.d0(12, this.f40315g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        int[] iArrD = rr.o.D(12);
        n0.i(this.f40315g, ((o0) fVar).f40315g, iArrD);
        return new o0(iArrD);
    }

    @Override // ir.f
    public ir.f n() {
        int[] iArrD = rr.o.D(12);
        n0.j(this.f40315g, iArrD);
        return new o0(iArrD);
    }

    @Override // ir.f
    public ir.f o() {
        int[] iArr = this.f40315g;
        if (rr.o.d0(12, iArr) || rr.o.c0(12, iArr)) {
            return this;
        }
        int[] iArrD = rr.o.D(12);
        int[] iArrD2 = rr.o.D(12);
        int[] iArrD3 = rr.o.D(12);
        int[] iArrD4 = rr.o.D(12);
        n0.o(iArr, iArrD);
        n0.i(iArrD, iArr, iArrD);
        n0.p(iArrD, 2, iArrD2);
        n0.i(iArrD2, iArrD, iArrD2);
        n0.o(iArrD2, iArrD2);
        n0.i(iArrD2, iArr, iArrD2);
        n0.p(iArrD2, 5, iArrD3);
        n0.i(iArrD3, iArrD2, iArrD3);
        n0.p(iArrD3, 5, iArrD4);
        n0.i(iArrD4, iArrD2, iArrD4);
        n0.p(iArrD4, 15, iArrD2);
        n0.i(iArrD2, iArrD4, iArrD2);
        n0.p(iArrD2, 2, iArrD3);
        n0.i(iArrD, iArrD3, iArrD);
        n0.p(iArrD3, 28, iArrD3);
        n0.i(iArrD2, iArrD3, iArrD2);
        n0.p(iArrD2, 60, iArrD3);
        n0.i(iArrD3, iArrD2, iArrD3);
        n0.p(iArrD3, 120, iArrD2);
        n0.i(iArrD2, iArrD3, iArrD2);
        n0.p(iArrD2, 15, iArrD2);
        n0.i(iArrD2, iArrD4, iArrD2);
        n0.p(iArrD2, 33, iArrD2);
        n0.i(iArrD2, iArrD, iArrD2);
        n0.p(iArrD2, 64, iArrD2);
        n0.i(iArrD2, iArr, iArrD2);
        n0.p(iArrD2, 30, iArrD);
        n0.o(iArrD, iArrD2);
        if (rr.o.M(12, iArr, iArrD2)) {
            return new o0(iArrD);
        }
        return null;
    }

    @Override // ir.f
    public ir.f p() {
        int[] iArrD = rr.o.D(12);
        n0.o(this.f40315g, iArrD);
        return new o0(iArrD);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        int[] iArrD = rr.o.D(12);
        n0.r(this.f40315g, ((o0) fVar).f40315g, iArrD);
        return new o0(iArrD);
    }

    @Override // ir.f
    public boolean u() {
        return rr.o.V(this.f40315g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.o.g1(12, this.f40315g);
    }
}
