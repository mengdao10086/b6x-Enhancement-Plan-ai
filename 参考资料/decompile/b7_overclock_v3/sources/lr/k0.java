package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class k0 extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40263h = new BigInteger(1, jt.h.d("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f40264g;

    public k0() {
        this.f40264g = rr.i.l();
    }

    public k0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f40263h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        this.f40264g = j0.e(bigInteger);
    }

    public k0(int[] iArr) {
        this.f40264g = iArr;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        int[] iArrL = rr.i.l();
        j0.a(this.f40264g, ((k0) fVar).f40264g, iArrL);
        return new k0(iArrL);
    }

    @Override // ir.f
    public ir.f b() {
        int[] iArrL = rr.i.l();
        j0.c(this.f40264g, iArrL);
        return new k0(iArrL);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        int[] iArrL = rr.i.l();
        j0.g(((k0) fVar).f40264g, iArrL);
        j0.i(iArrL, this.f40264g, iArrL);
        return new k0(iArrL);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k0) {
            return rr.i.q(this.f40264g, ((k0) obj).f40264g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecP256R1Field";
    }

    @Override // ir.f
    public int g() {
        return f40263h.bitLength();
    }

    @Override // ir.f
    public ir.f h() {
        int[] iArrL = rr.i.l();
        j0.g(this.f40264g, iArrL);
        return new k0(iArrL);
    }

    public int hashCode() {
        return f40263h.hashCode() ^ org.bouncycastle.util.a.w0(this.f40264g, 0, 8);
    }

    @Override // ir.f
    public boolean i() {
        return rr.i.x(this.f40264g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.i.z(this.f40264g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        int[] iArrL = rr.i.l();
        j0.i(this.f40264g, ((k0) fVar).f40264g, iArrL);
        return new k0(iArrL);
    }

    @Override // ir.f
    public ir.f n() {
        int[] iArrL = rr.i.l();
        j0.k(this.f40264g, iArrL);
        return new k0(iArrL);
    }

    @Override // ir.f
    public ir.f o() {
        int[] iArr = this.f40264g;
        if (rr.i.z(iArr) || rr.i.x(iArr)) {
            return this;
        }
        int[] iArrL = rr.i.l();
        int[] iArrL2 = rr.i.l();
        j0.p(iArr, iArrL);
        j0.i(iArrL, iArr, iArrL);
        j0.q(iArrL, 2, iArrL2);
        j0.i(iArrL2, iArrL, iArrL2);
        j0.q(iArrL2, 4, iArrL);
        j0.i(iArrL, iArrL2, iArrL);
        j0.q(iArrL, 8, iArrL2);
        j0.i(iArrL2, iArrL, iArrL2);
        j0.q(iArrL2, 16, iArrL);
        j0.i(iArrL, iArrL2, iArrL);
        j0.q(iArrL, 32, iArrL);
        j0.i(iArrL, iArr, iArrL);
        j0.q(iArrL, 96, iArrL);
        j0.i(iArrL, iArr, iArrL);
        j0.q(iArrL, 94, iArrL);
        j0.p(iArrL, iArrL2);
        if (rr.i.q(iArr, iArrL2)) {
            return new k0(iArrL);
        }
        return null;
    }

    @Override // ir.f
    public ir.f p() {
        int[] iArrL = rr.i.l();
        j0.p(this.f40264g, iArrL);
        return new k0(iArrL);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        int[] iArrL = rr.i.l();
        j0.s(this.f40264g, ((k0) fVar).f40264g, iArrL);
        return new k0(iArrL);
    }

    @Override // ir.f
    public boolean u() {
        return rr.i.u(this.f40264g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.i.U(this.f40264g);
    }
}
