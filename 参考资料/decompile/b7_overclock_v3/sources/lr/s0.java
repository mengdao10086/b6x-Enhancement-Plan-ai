package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class s0 extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40358h = new BigInteger(1, jt.h.d("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f40359g;

    public s0() {
        this.f40359g = rr.o.D(17);
    }

    public s0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f40358h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        this.f40359g = r0.c(bigInteger);
    }

    public s0(int[] iArr) {
        this.f40359g = iArr;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        int[] iArrD = rr.o.D(17);
        r0.a(this.f40359g, ((s0) fVar).f40359g, iArrD);
        return new s0(iArrD);
    }

    @Override // ir.f
    public ir.f b() {
        int[] iArrD = rr.o.D(17);
        r0.b(this.f40359g, iArrD);
        return new s0(iArrD);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        int[] iArrD = rr.o.D(17);
        r0.g(((s0) fVar).f40359g, iArrD);
        r0.i(iArrD, this.f40359g, iArrD);
        return new s0(iArrD);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof s0) {
            return rr.o.M(17, this.f40359g, ((s0) obj).f40359g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecP521R1Field";
    }

    @Override // ir.f
    public int g() {
        return f40358h.bitLength();
    }

    @Override // ir.f
    public ir.f h() {
        int[] iArrD = rr.o.D(17);
        r0.g(this.f40359g, iArrD);
        return new s0(iArrD);
    }

    public int hashCode() {
        return f40358h.hashCode() ^ org.bouncycastle.util.a.w0(this.f40359g, 0, 17);
    }

    @Override // ir.f
    public boolean i() {
        return rr.o.c0(17, this.f40359g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.o.d0(17, this.f40359g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        int[] iArrD = rr.o.D(17);
        r0.i(this.f40359g, ((s0) fVar).f40359g, iArrD);
        return new s0(iArrD);
    }

    @Override // ir.f
    public ir.f n() {
        int[] iArrD = rr.o.D(17);
        r0.j(this.f40359g, iArrD);
        return new s0(iArrD);
    }

    @Override // ir.f
    public ir.f o() {
        int[] iArr = this.f40359g;
        if (rr.o.d0(17, iArr) || rr.o.c0(17, iArr)) {
            return this;
        }
        int[] iArrD = rr.o.D(17);
        int[] iArrD2 = rr.o.D(17);
        r0.p(iArr, gg.b.f29438g0, iArrD);
        r0.o(iArrD, iArrD2);
        if (rr.o.M(17, iArr, iArrD2)) {
            return new s0(iArrD);
        }
        return null;
    }

    @Override // ir.f
    public ir.f p() {
        int[] iArrD = rr.o.D(17);
        r0.o(this.f40359g, iArrD);
        return new s0(iArrD);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        int[] iArrD = rr.o.D(17);
        r0.q(this.f40359g, ((s0) fVar).f40359g, iArrD);
        return new s0(iArrD);
    }

    @Override // ir.f
    public boolean u() {
        return rr.o.V(this.f40359g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.o.g1(17, this.f40359g);
    }
}
