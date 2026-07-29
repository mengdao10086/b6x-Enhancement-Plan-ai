package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class y extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40419h = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f40420i = {868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f40421g;

    public y() {
        this.f40421g = rr.h.j();
    }

    public y(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f40419h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        this.f40421g = x.d(bigInteger);
    }

    public y(int[] iArr) {
        this.f40421g = iArr;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        int[] iArrJ = rr.h.j();
        x.a(this.f40421g, ((y) fVar).f40421g, iArrJ);
        return new y(iArrJ);
    }

    @Override // ir.f
    public ir.f b() {
        int[] iArrJ = rr.h.j();
        x.c(this.f40421g, iArrJ);
        return new y(iArrJ);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        int[] iArrJ = rr.h.j();
        x.f(((y) fVar).f40421g, iArrJ);
        x.h(iArrJ, this.f40421g, iArrJ);
        return new y(iArrJ);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof y) {
            return rr.h.m(this.f40421g, ((y) obj).f40421g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecP224K1Field";
    }

    @Override // ir.f
    public int g() {
        return f40419h.bitLength();
    }

    @Override // ir.f
    public ir.f h() {
        int[] iArrJ = rr.h.j();
        x.f(this.f40421g, iArrJ);
        return new y(iArrJ);
    }

    public int hashCode() {
        return f40419h.hashCode() ^ org.bouncycastle.util.a.w0(this.f40421g, 0, 7);
    }

    @Override // ir.f
    public boolean i() {
        return rr.h.r(this.f40421g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.h.s(this.f40421g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        int[] iArrJ = rr.h.j();
        x.h(this.f40421g, ((y) fVar).f40421g, iArrJ);
        return new y(iArrJ);
    }

    @Override // ir.f
    public ir.f n() {
        int[] iArrJ = rr.h.j();
        x.j(this.f40421g, iArrJ);
        return new y(iArrJ);
    }

    @Override // ir.f
    public ir.f o() {
        int[] iArr = this.f40421g;
        if (rr.h.s(iArr) || rr.h.r(iArr)) {
            return this;
        }
        int[] iArrJ = rr.h.j();
        x.o(iArr, iArrJ);
        x.h(iArrJ, iArr, iArrJ);
        x.o(iArrJ, iArrJ);
        x.h(iArrJ, iArr, iArrJ);
        int[] iArrJ2 = rr.h.j();
        x.o(iArrJ, iArrJ2);
        x.h(iArrJ2, iArr, iArrJ2);
        int[] iArrJ3 = rr.h.j();
        x.p(iArrJ2, 4, iArrJ3);
        x.h(iArrJ3, iArrJ2, iArrJ3);
        int[] iArrJ4 = rr.h.j();
        x.p(iArrJ3, 3, iArrJ4);
        x.h(iArrJ4, iArrJ, iArrJ4);
        x.p(iArrJ4, 8, iArrJ4);
        x.h(iArrJ4, iArrJ3, iArrJ4);
        x.p(iArrJ4, 4, iArrJ3);
        x.h(iArrJ3, iArrJ2, iArrJ3);
        x.p(iArrJ3, 19, iArrJ2);
        x.h(iArrJ2, iArrJ4, iArrJ2);
        int[] iArrJ5 = rr.h.j();
        x.p(iArrJ2, 42, iArrJ5);
        x.h(iArrJ5, iArrJ2, iArrJ5);
        x.p(iArrJ5, 23, iArrJ2);
        x.h(iArrJ2, iArrJ3, iArrJ2);
        x.p(iArrJ2, 84, iArrJ3);
        x.h(iArrJ3, iArrJ5, iArrJ3);
        x.p(iArrJ3, 20, iArrJ3);
        x.h(iArrJ3, iArrJ4, iArrJ3);
        x.p(iArrJ3, 3, iArrJ3);
        x.h(iArrJ3, iArr, iArrJ3);
        x.p(iArrJ3, 2, iArrJ3);
        x.h(iArrJ3, iArr, iArrJ3);
        x.p(iArrJ3, 4, iArrJ3);
        x.h(iArrJ3, iArrJ, iArrJ3);
        x.o(iArrJ3, iArrJ3);
        x.o(iArrJ3, iArrJ5);
        if (rr.h.m(iArr, iArrJ5)) {
            return new y(iArrJ3);
        }
        x.h(iArrJ3, f40420i, iArrJ3);
        x.o(iArrJ3, iArrJ5);
        if (rr.h.m(iArr, iArrJ5)) {
            return new y(iArrJ3);
        }
        return null;
    }

    @Override // ir.f
    public ir.f p() {
        int[] iArrJ = rr.h.j();
        x.o(this.f40421g, iArrJ);
        return new y(iArrJ);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        int[] iArrJ = rr.h.j();
        x.q(this.f40421g, ((y) fVar).f40421g, iArrJ);
        return new y(iArrJ);
    }

    @Override // ir.f
    public boolean u() {
        return rr.h.o(this.f40421g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.h.M(this.f40421g);
    }
}
