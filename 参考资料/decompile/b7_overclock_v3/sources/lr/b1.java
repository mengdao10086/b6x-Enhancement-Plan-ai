package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class b1 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f40156g;

    public b1() {
        this.f40156g = rr.g.k();
    }

    public b1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        this.f40156g = a1.e(bigInteger);
    }

    public b1(long[] jArr) {
        this.f40156g = jArr;
    }

    public int A() {
        return 3;
    }

    public int B() {
        return 8;
    }

    public int C() {
        return 131;
    }

    public int D() {
        return 3;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        long[] jArrK = rr.g.k();
        a1.a(this.f40156g, ((b1) fVar).f40156g, jArrK);
        return new b1(jArrK);
    }

    @Override // ir.f
    public ir.f b() {
        long[] jArrK = rr.g.k();
        a1.c(this.f40156g, jArrK);
        return new b1(jArrK);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        return k(fVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b1) {
            return rr.g.p(this.f40156g, ((b1) obj).f40156g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecT131Field";
    }

    @Override // ir.f
    public int g() {
        return 131;
    }

    @Override // ir.f
    public ir.f h() {
        long[] jArrK = rr.g.k();
        a1.k(this.f40156g, jArrK);
        return new b1(jArrK);
    }

    public int hashCode() {
        return org.bouncycastle.util.a.y0(this.f40156g, 0, 3) ^ 131832;
    }

    @Override // ir.f
    public boolean i() {
        return rr.g.w(this.f40156g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.g.y(this.f40156g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        long[] jArrK = rr.g.k();
        a1.l(this.f40156g, ((b1) fVar).f40156g, jArrK);
        return new b1(jArrK);
    }

    @Override // ir.f
    public ir.f l(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        return m(fVar, fVar2, fVar3);
    }

    @Override // ir.f
    public ir.f m(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        long[] jArr = this.f40156g;
        long[] jArr2 = ((b1) fVar).f40156g;
        long[] jArr3 = ((b1) fVar2).f40156g;
        long[] jArr4 = ((b1) fVar3).f40156g;
        long[] jArrE = rr.o.E(5);
        a1.m(jArr, jArr2, jArrE);
        a1.m(jArr3, jArr4, jArrE);
        long[] jArrK = rr.g.k();
        a1.n(jArrE, jArrK);
        return new b1(jArrK);
    }

    @Override // ir.f
    public ir.f n() {
        return this;
    }

    @Override // ir.f
    public ir.f o() {
        long[] jArrK = rr.g.k();
        a1.p(this.f40156g, jArrK);
        return new b1(jArrK);
    }

    @Override // ir.f
    public ir.f p() {
        long[] jArrK = rr.g.k();
        a1.q(this.f40156g, jArrK);
        return new b1(jArrK);
    }

    @Override // ir.f
    public ir.f q(ir.f fVar, ir.f fVar2) {
        return r(fVar, fVar2);
    }

    @Override // ir.f
    public ir.f r(ir.f fVar, ir.f fVar2) {
        long[] jArr = this.f40156g;
        long[] jArr2 = ((b1) fVar).f40156g;
        long[] jArr3 = ((b1) fVar2).f40156g;
        long[] jArrE = rr.o.E(5);
        a1.r(jArr, jArrE);
        a1.m(jArr2, jArr3, jArrE);
        long[] jArrK = rr.g.k();
        a1.n(jArrE, jArrK);
        return new b1(jArrK);
    }

    @Override // ir.f
    public ir.f s(int i10) {
        if (i10 < 1) {
            return this;
        }
        long[] jArrK = rr.g.k();
        a1.s(this.f40156g, i10, jArrK);
        return new b1(jArrK);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        return a(fVar);
    }

    @Override // ir.f
    public boolean u() {
        return (this.f40156g[0] & 1) != 0;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.g.R(this.f40156g);
    }

    @Override // ir.f.a
    public ir.f w() {
        long[] jArrK = rr.g.k();
        a1.f(this.f40156g, jArrK);
        return new b1(jArrK);
    }

    @Override // ir.f.a
    public boolean x() {
        return true;
    }

    @Override // ir.f.a
    public int y() {
        return a1.t(this.f40156g);
    }

    public int z() {
        return 2;
    }
}
