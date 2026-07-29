package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class m extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40280h = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f40281g;

    public m() {
        this.f40281g = rr.f.h();
    }

    public m(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f40280h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
        }
        this.f40281g = l.d(bigInteger);
    }

    public m(int[] iArr) {
        this.f40281g = iArr;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        int[] iArrH = rr.f.h();
        l.a(this.f40281g, ((m) fVar).f40281g, iArrH);
        return new m(iArrH);
    }

    @Override // ir.f
    public ir.f b() {
        int[] iArrH = rr.f.h();
        l.c(this.f40281g, iArrH);
        return new m(iArrH);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        int[] iArrH = rr.f.h();
        l.f(((m) fVar).f40281g, iArrH);
        l.h(iArrH, this.f40281g, iArrH);
        return new m(iArrH);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            return rr.f.k(this.f40281g, ((m) obj).f40281g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecP160R2Field";
    }

    @Override // ir.f
    public int g() {
        return f40280h.bitLength();
    }

    @Override // ir.f
    public ir.f h() {
        int[] iArrH = rr.f.h();
        l.f(this.f40281g, iArrH);
        return new m(iArrH);
    }

    public int hashCode() {
        return f40280h.hashCode() ^ org.bouncycastle.util.a.w0(this.f40281g, 0, 5);
    }

    @Override // ir.f
    public boolean i() {
        return rr.f.p(this.f40281g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.f.q(this.f40281g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        int[] iArrH = rr.f.h();
        l.h(this.f40281g, ((m) fVar).f40281g, iArrH);
        return new m(iArrH);
    }

    @Override // ir.f
    public ir.f n() {
        int[] iArrH = rr.f.h();
        l.j(this.f40281g, iArrH);
        return new m(iArrH);
    }

    @Override // ir.f
    public ir.f o() {
        int[] iArr = this.f40281g;
        if (rr.f.q(iArr) || rr.f.p(iArr)) {
            return this;
        }
        int[] iArrH = rr.f.h();
        l.o(iArr, iArrH);
        l.h(iArrH, iArr, iArrH);
        int[] iArrH2 = rr.f.h();
        l.o(iArrH, iArrH2);
        l.h(iArrH2, iArr, iArrH2);
        int[] iArrH3 = rr.f.h();
        l.o(iArrH2, iArrH3);
        l.h(iArrH3, iArr, iArrH3);
        int[] iArrH4 = rr.f.h();
        l.p(iArrH3, 3, iArrH4);
        l.h(iArrH4, iArrH2, iArrH4);
        l.p(iArrH4, 7, iArrH3);
        l.h(iArrH3, iArrH4, iArrH3);
        l.p(iArrH3, 3, iArrH4);
        l.h(iArrH4, iArrH2, iArrH4);
        int[] iArrH5 = rr.f.h();
        l.p(iArrH4, 14, iArrH5);
        l.h(iArrH5, iArrH3, iArrH5);
        l.p(iArrH5, 31, iArrH3);
        l.h(iArrH3, iArrH5, iArrH3);
        l.p(iArrH3, 62, iArrH5);
        l.h(iArrH5, iArrH3, iArrH5);
        l.p(iArrH5, 3, iArrH3);
        l.h(iArrH3, iArrH2, iArrH3);
        l.p(iArrH3, 18, iArrH3);
        l.h(iArrH3, iArrH4, iArrH3);
        l.p(iArrH3, 2, iArrH3);
        l.h(iArrH3, iArr, iArrH3);
        l.p(iArrH3, 3, iArrH3);
        l.h(iArrH3, iArrH, iArrH3);
        l.p(iArrH3, 6, iArrH3);
        l.h(iArrH3, iArrH2, iArrH3);
        l.p(iArrH3, 2, iArrH3);
        l.h(iArrH3, iArr, iArrH3);
        l.o(iArrH3, iArrH);
        if (rr.f.k(iArr, iArrH)) {
            return new m(iArrH3);
        }
        return null;
    }

    @Override // ir.f
    public ir.f p() {
        int[] iArrH = rr.f.h();
        l.o(this.f40281g, iArrH);
        return new m(iArrH);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        int[] iArrH = rr.f.h();
        l.q(this.f40281g, ((m) fVar).f40281g, iArrH);
        return new m(iArrH);
    }

    @Override // ir.f
    public boolean u() {
        return rr.f.m(this.f40281g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.f.J(this.f40281g);
    }
}
