package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class l2 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f40279g;

    public l2() {
        this.f40279g = rr.l.c();
    }

    public l2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        }
        this.f40279g = k2.e(bigInteger);
    }

    public l2(long[] jArr) {
        this.f40279g = jArr;
    }

    public int A() {
        return 0;
    }

    public int B() {
        return 0;
    }

    public int C() {
        return 409;
    }

    public int D() {
        return 2;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        long[] jArrC = rr.l.c();
        k2.a(this.f40279g, ((l2) fVar).f40279g, jArrC);
        return new l2(jArrC);
    }

    @Override // ir.f
    public ir.f b() {
        long[] jArrC = rr.l.c();
        k2.c(this.f40279g, jArrC);
        return new l2(jArrC);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        return k(fVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l2) {
            return rr.l.e(this.f40279g, ((l2) obj).f40279g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecT409Field";
    }

    @Override // ir.f
    public int g() {
        return 409;
    }

    @Override // ir.f
    public ir.f h() {
        long[] jArrC = rr.l.c();
        k2.l(this.f40279g, jArrC);
        return new l2(jArrC);
    }

    public int hashCode() {
        return org.bouncycastle.util.a.y0(this.f40279g, 0, 7) ^ 4090087;
    }

    @Override // ir.f
    public boolean i() {
        return rr.l.g(this.f40279g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.l.h(this.f40279g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        long[] jArrC = rr.l.c();
        k2.m(this.f40279g, ((l2) fVar).f40279g, jArrC);
        return new l2(jArrC);
    }

    @Override // ir.f
    public ir.f l(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        return m(fVar, fVar2, fVar3);
    }

    @Override // ir.f
    public ir.f m(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        long[] jArr = this.f40279g;
        long[] jArr2 = ((l2) fVar).f40279g;
        long[] jArr3 = ((l2) fVar2).f40279g;
        long[] jArr4 = ((l2) fVar3).f40279g;
        long[] jArrE = rr.o.E(13);
        k2.n(jArr, jArr2, jArrE);
        k2.n(jArr3, jArr4, jArrE);
        long[] jArrC = rr.l.c();
        k2.o(jArrE, jArrC);
        return new l2(jArrC);
    }

    @Override // ir.f
    public ir.f n() {
        return this;
    }

    @Override // ir.f
    public ir.f o() {
        long[] jArrC = rr.l.c();
        k2.q(this.f40279g, jArrC);
        return new l2(jArrC);
    }

    @Override // ir.f
    public ir.f p() {
        long[] jArrC = rr.l.c();
        k2.r(this.f40279g, jArrC);
        return new l2(jArrC);
    }

    @Override // ir.f
    public ir.f q(ir.f fVar, ir.f fVar2) {
        return r(fVar, fVar2);
    }

    @Override // ir.f
    public ir.f r(ir.f fVar, ir.f fVar2) {
        long[] jArr = this.f40279g;
        long[] jArr2 = ((l2) fVar).f40279g;
        long[] jArr3 = ((l2) fVar2).f40279g;
        long[] jArrE = rr.o.E(13);
        k2.s(jArr, jArrE);
        k2.n(jArr2, jArr3, jArrE);
        long[] jArrC = rr.l.c();
        k2.o(jArrE, jArrC);
        return new l2(jArrC);
    }

    @Override // ir.f
    public ir.f s(int i10) {
        if (i10 < 1) {
            return this;
        }
        long[] jArrC = rr.l.c();
        k2.t(this.f40279g, i10, jArrC);
        return new l2(jArrC);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        return a(fVar);
    }

    @Override // ir.f
    public boolean u() {
        return (this.f40279g[0] & 1) != 0;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.l.k(this.f40279g);
    }

    @Override // ir.f.a
    public ir.f w() {
        long[] jArrC = rr.l.c();
        k2.f(this.f40279g, jArrC);
        return new l2(jArrC);
    }

    @Override // ir.f.a
    public boolean x() {
        return true;
    }

    @Override // ir.f.a
    public int y() {
        return k2.u(this.f40279g);
    }

    public int z() {
        return 87;
    }
}
