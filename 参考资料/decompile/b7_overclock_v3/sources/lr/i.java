package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class i extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40230h = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f40231g;

    public i() {
        this.f40231g = rr.f.h();
    }

    public i(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f40230h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
        }
        this.f40231g = h.d(bigInteger);
    }

    public i(int[] iArr) {
        this.f40231g = iArr;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        int[] iArrH = rr.f.h();
        h.a(this.f40231g, ((i) fVar).f40231g, iArrH);
        return new i(iArrH);
    }

    @Override // ir.f
    public ir.f b() {
        int[] iArrH = rr.f.h();
        h.c(this.f40231g, iArrH);
        return new i(iArrH);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        int[] iArrH = rr.f.h();
        h.f(((i) fVar).f40231g, iArrH);
        h.h(iArrH, this.f40231g, iArrH);
        return new i(iArrH);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            return rr.f.k(this.f40231g, ((i) obj).f40231g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecP160R1Field";
    }

    @Override // ir.f
    public int g() {
        return f40230h.bitLength();
    }

    @Override // ir.f
    public ir.f h() {
        int[] iArrH = rr.f.h();
        h.f(this.f40231g, iArrH);
        return new i(iArrH);
    }

    public int hashCode() {
        return f40230h.hashCode() ^ org.bouncycastle.util.a.w0(this.f40231g, 0, 5);
    }

    @Override // ir.f
    public boolean i() {
        return rr.f.p(this.f40231g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.f.q(this.f40231g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        int[] iArrH = rr.f.h();
        h.h(this.f40231g, ((i) fVar).f40231g, iArrH);
        return new i(iArrH);
    }

    @Override // ir.f
    public ir.f n() {
        int[] iArrH = rr.f.h();
        h.j(this.f40231g, iArrH);
        return new i(iArrH);
    }

    @Override // ir.f
    public ir.f o() {
        int[] iArr = this.f40231g;
        if (rr.f.q(iArr) || rr.f.p(iArr)) {
            return this;
        }
        int[] iArrH = rr.f.h();
        h.o(iArr, iArrH);
        h.h(iArrH, iArr, iArrH);
        int[] iArrH2 = rr.f.h();
        h.p(iArrH, 2, iArrH2);
        h.h(iArrH2, iArrH, iArrH2);
        h.p(iArrH2, 4, iArrH);
        h.h(iArrH, iArrH2, iArrH);
        h.p(iArrH, 8, iArrH2);
        h.h(iArrH2, iArrH, iArrH2);
        h.p(iArrH2, 16, iArrH);
        h.h(iArrH, iArrH2, iArrH);
        h.p(iArrH, 32, iArrH2);
        h.h(iArrH2, iArrH, iArrH2);
        h.p(iArrH2, 64, iArrH);
        h.h(iArrH, iArrH2, iArrH);
        h.o(iArrH, iArrH2);
        h.h(iArrH2, iArr, iArrH2);
        h.p(iArrH2, 29, iArrH2);
        h.o(iArrH2, iArrH);
        if (rr.f.k(iArr, iArrH)) {
            return new i(iArrH2);
        }
        return null;
    }

    @Override // ir.f
    public ir.f p() {
        int[] iArrH = rr.f.h();
        h.o(this.f40231g, iArrH);
        return new i(iArrH);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        int[] iArrH = rr.f.h();
        h.q(this.f40231g, ((i) fVar).f40231g, iArrH);
        return new i(iArrH);
    }

    @Override // ir.f
    public boolean u() {
        return rr.f.m(this.f40231g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.f.J(this.f40231g);
    }
}
