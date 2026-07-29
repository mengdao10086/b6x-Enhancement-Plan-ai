package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class g0 extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40211h = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f40212g;

    public g0() {
        this.f40212g = rr.i.l();
    }

    public g0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f40211h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
        }
        this.f40212g = f0.d(bigInteger);
    }

    public g0(int[] iArr) {
        this.f40212g = iArr;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        int[] iArrL = rr.i.l();
        f0.a(this.f40212g, ((g0) fVar).f40212g, iArrL);
        return new g0(iArrL);
    }

    @Override // ir.f
    public ir.f b() {
        int[] iArrL = rr.i.l();
        f0.c(this.f40212g, iArrL);
        return new g0(iArrL);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        int[] iArrL = rr.i.l();
        f0.f(((g0) fVar).f40212g, iArrL);
        f0.h(iArrL, this.f40212g, iArrL);
        return new g0(iArrL);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g0) {
            return rr.i.q(this.f40212g, ((g0) obj).f40212g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecP256K1Field";
    }

    @Override // ir.f
    public int g() {
        return f40211h.bitLength();
    }

    @Override // ir.f
    public ir.f h() {
        int[] iArrL = rr.i.l();
        f0.f(this.f40212g, iArrL);
        return new g0(iArrL);
    }

    public int hashCode() {
        return f40211h.hashCode() ^ org.bouncycastle.util.a.w0(this.f40212g, 0, 8);
    }

    @Override // ir.f
    public boolean i() {
        return rr.i.x(this.f40212g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.i.z(this.f40212g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        int[] iArrL = rr.i.l();
        f0.h(this.f40212g, ((g0) fVar).f40212g, iArrL);
        return new g0(iArrL);
    }

    @Override // ir.f
    public ir.f n() {
        int[] iArrL = rr.i.l();
        f0.j(this.f40212g, iArrL);
        return new g0(iArrL);
    }

    @Override // ir.f
    public ir.f o() {
        int[] iArr = this.f40212g;
        if (rr.i.z(iArr) || rr.i.x(iArr)) {
            return this;
        }
        int[] iArrL = rr.i.l();
        f0.o(iArr, iArrL);
        f0.h(iArrL, iArr, iArrL);
        int[] iArrL2 = rr.i.l();
        f0.o(iArrL, iArrL2);
        f0.h(iArrL2, iArr, iArrL2);
        int[] iArrL3 = rr.i.l();
        f0.p(iArrL2, 3, iArrL3);
        f0.h(iArrL3, iArrL2, iArrL3);
        f0.p(iArrL3, 3, iArrL3);
        f0.h(iArrL3, iArrL2, iArrL3);
        f0.p(iArrL3, 2, iArrL3);
        f0.h(iArrL3, iArrL, iArrL3);
        int[] iArrL4 = rr.i.l();
        f0.p(iArrL3, 11, iArrL4);
        f0.h(iArrL4, iArrL3, iArrL4);
        f0.p(iArrL4, 22, iArrL3);
        f0.h(iArrL3, iArrL4, iArrL3);
        int[] iArrL5 = rr.i.l();
        f0.p(iArrL3, 44, iArrL5);
        f0.h(iArrL5, iArrL3, iArrL5);
        int[] iArrL6 = rr.i.l();
        f0.p(iArrL5, 88, iArrL6);
        f0.h(iArrL6, iArrL5, iArrL6);
        f0.p(iArrL6, 44, iArrL5);
        f0.h(iArrL5, iArrL3, iArrL5);
        f0.p(iArrL5, 3, iArrL3);
        f0.h(iArrL3, iArrL2, iArrL3);
        f0.p(iArrL3, 23, iArrL3);
        f0.h(iArrL3, iArrL4, iArrL3);
        f0.p(iArrL3, 6, iArrL3);
        f0.h(iArrL3, iArrL, iArrL3);
        f0.p(iArrL3, 2, iArrL3);
        f0.o(iArrL3, iArrL);
        if (rr.i.q(iArr, iArrL)) {
            return new g0(iArrL3);
        }
        return null;
    }

    @Override // ir.f
    public ir.f p() {
        int[] iArrL = rr.i.l();
        f0.o(this.f40212g, iArrL);
        return new g0(iArrL);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        int[] iArrL = rr.i.l();
        f0.q(this.f40212g, ((g0) fVar).f40212g, iArrL);
        return new g0(iArrL);
    }

    @Override // ir.f
    public boolean u() {
        return rr.i.u(this.f40212g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.i.U(this.f40212g);
    }
}
