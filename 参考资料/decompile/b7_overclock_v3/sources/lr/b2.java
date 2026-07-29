package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class b2 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f40157g;

    public b2() {
        this.f40157g = rr.i.m();
    }

    public b2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        this.f40157g = a2.e(bigInteger);
    }

    public b2(long[] jArr) {
        this.f40157g = jArr;
    }

    public int A() {
        return 0;
    }

    public int B() {
        return 0;
    }

    public int C() {
        return 239;
    }

    public int D() {
        return 2;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        long[] jArrM = rr.i.m();
        a2.a(this.f40157g, ((b2) fVar).f40157g, jArrM);
        return new b2(jArrM);
    }

    @Override // ir.f
    public ir.f b() {
        long[] jArrM = rr.i.m();
        a2.c(this.f40157g, jArrM);
        return new b2(jArrM);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        return k(fVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b2) {
            return rr.i.r(this.f40157g, ((b2) obj).f40157g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecT239Field";
    }

    @Override // ir.f
    public int g() {
        return 239;
    }

    @Override // ir.f
    public ir.f h() {
        long[] jArrM = rr.i.m();
        a2.l(this.f40157g, jArrM);
        return new b2(jArrM);
    }

    public int hashCode() {
        return org.bouncycastle.util.a.y0(this.f40157g, 0, 4) ^ 23900158;
    }

    @Override // ir.f
    public boolean i() {
        return rr.i.y(this.f40157g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.i.A(this.f40157g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        long[] jArrM = rr.i.m();
        a2.m(this.f40157g, ((b2) fVar).f40157g, jArrM);
        return new b2(jArrM);
    }

    @Override // ir.f
    public ir.f l(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        return m(fVar, fVar2, fVar3);
    }

    @Override // ir.f
    public ir.f m(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        long[] jArr = this.f40157g;
        long[] jArr2 = ((b2) fVar).f40157g;
        long[] jArr3 = ((b2) fVar2).f40157g;
        long[] jArr4 = ((b2) fVar3).f40157g;
        long[] jArrO = rr.i.o();
        a2.n(jArr, jArr2, jArrO);
        a2.n(jArr3, jArr4, jArrO);
        long[] jArrM = rr.i.m();
        a2.o(jArrO, jArrM);
        return new b2(jArrM);
    }

    @Override // ir.f
    public ir.f n() {
        return this;
    }

    @Override // ir.f
    public ir.f o() {
        long[] jArrM = rr.i.m();
        a2.q(this.f40157g, jArrM);
        return new b2(jArrM);
    }

    @Override // ir.f
    public ir.f p() {
        long[] jArrM = rr.i.m();
        a2.r(this.f40157g, jArrM);
        return new b2(jArrM);
    }

    @Override // ir.f
    public ir.f q(ir.f fVar, ir.f fVar2) {
        return r(fVar, fVar2);
    }

    @Override // ir.f
    public ir.f r(ir.f fVar, ir.f fVar2) {
        long[] jArr = this.f40157g;
        long[] jArr2 = ((b2) fVar).f40157g;
        long[] jArr3 = ((b2) fVar2).f40157g;
        long[] jArrO = rr.i.o();
        a2.s(jArr, jArrO);
        a2.n(jArr2, jArr3, jArrO);
        long[] jArrM = rr.i.m();
        a2.o(jArrO, jArrM);
        return new b2(jArrM);
    }

    @Override // ir.f
    public ir.f s(int i10) {
        if (i10 < 1) {
            return this;
        }
        long[] jArrM = rr.i.m();
        a2.t(this.f40157g, i10, jArrM);
        return new b2(jArrM);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        return a(fVar);
    }

    @Override // ir.f
    public boolean u() {
        return (this.f40157g[0] & 1) != 0;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.i.V(this.f40157g);
    }

    @Override // ir.f.a
    public ir.f w() {
        long[] jArrM = rr.i.m();
        a2.f(this.f40157g, jArrM);
        return new b2(jArrM);
    }

    @Override // ir.f.a
    public boolean x() {
        return true;
    }

    @Override // ir.f.a
    public int y() {
        return a2.u(this.f40157g);
    }

    public int z() {
        return 158;
    }
}
