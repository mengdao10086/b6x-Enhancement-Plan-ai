package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class p1 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f40330g;

    public p1() {
        this.f40330g = rr.i.m();
    }

    public p1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 193) {
            throw new IllegalArgumentException("x value invalid for SecT193FieldElement");
        }
        this.f40330g = o1.e(bigInteger);
    }

    public p1(long[] jArr) {
        this.f40330g = jArr;
    }

    public int A() {
        return 0;
    }

    public int B() {
        return 0;
    }

    public int C() {
        return s0.c.f49294u;
    }

    public int D() {
        return 2;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        long[] jArrM = rr.i.m();
        o1.a(this.f40330g, ((p1) fVar).f40330g, jArrM);
        return new p1(jArrM);
    }

    @Override // ir.f
    public ir.f b() {
        long[] jArrM = rr.i.m();
        o1.c(this.f40330g, jArrM);
        return new p1(jArrM);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        return k(fVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p1) {
            return rr.i.r(this.f40330g, ((p1) obj).f40330g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecT193Field";
    }

    @Override // ir.f
    public int g() {
        return s0.c.f49294u;
    }

    @Override // ir.f
    public ir.f h() {
        long[] jArrM = rr.i.m();
        o1.l(this.f40330g, jArrM);
        return new p1(jArrM);
    }

    public int hashCode() {
        return org.bouncycastle.util.a.y0(this.f40330g, 0, 4) ^ 1930015;
    }

    @Override // ir.f
    public boolean i() {
        return rr.i.y(this.f40330g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.i.A(this.f40330g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        long[] jArrM = rr.i.m();
        o1.m(this.f40330g, ((p1) fVar).f40330g, jArrM);
        return new p1(jArrM);
    }

    @Override // ir.f
    public ir.f l(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        return m(fVar, fVar2, fVar3);
    }

    @Override // ir.f
    public ir.f m(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        long[] jArr = this.f40330g;
        long[] jArr2 = ((p1) fVar).f40330g;
        long[] jArr3 = ((p1) fVar2).f40330g;
        long[] jArr4 = ((p1) fVar3).f40330g;
        long[] jArrO = rr.i.o();
        o1.n(jArr, jArr2, jArrO);
        o1.n(jArr3, jArr4, jArrO);
        long[] jArrM = rr.i.m();
        o1.o(jArrO, jArrM);
        return new p1(jArrM);
    }

    @Override // ir.f
    public ir.f n() {
        return this;
    }

    @Override // ir.f
    public ir.f o() {
        long[] jArrM = rr.i.m();
        o1.q(this.f40330g, jArrM);
        return new p1(jArrM);
    }

    @Override // ir.f
    public ir.f p() {
        long[] jArrM = rr.i.m();
        o1.r(this.f40330g, jArrM);
        return new p1(jArrM);
    }

    @Override // ir.f
    public ir.f q(ir.f fVar, ir.f fVar2) {
        return r(fVar, fVar2);
    }

    @Override // ir.f
    public ir.f r(ir.f fVar, ir.f fVar2) {
        long[] jArr = this.f40330g;
        long[] jArr2 = ((p1) fVar).f40330g;
        long[] jArr3 = ((p1) fVar2).f40330g;
        long[] jArrO = rr.i.o();
        o1.s(jArr, jArrO);
        o1.n(jArr2, jArr3, jArrO);
        long[] jArrM = rr.i.m();
        o1.o(jArrO, jArrM);
        return new p1(jArrM);
    }

    @Override // ir.f
    public ir.f s(int i10) {
        if (i10 < 1) {
            return this;
        }
        long[] jArrM = rr.i.m();
        o1.t(this.f40330g, i10, jArrM);
        return new p1(jArrM);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        return a(fVar);
    }

    @Override // ir.f
    public boolean u() {
        return (this.f40330g[0] & 1) != 0;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.i.V(this.f40330g);
    }

    @Override // ir.f.a
    public ir.f w() {
        long[] jArrM = rr.i.m();
        o1.f(this.f40330g, jArrM);
        return new p1(jArrM);
    }

    @Override // ir.f.a
    public boolean x() {
        return true;
    }

    @Override // ir.f.a
    public int y() {
        return o1.u(this.f40330g);
    }

    public int z() {
        return 15;
    }
}
