package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class v1 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f40393g;

    public v1() {
        this.f40393g = rr.i.m();
    }

    public v1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        this.f40393g = u1.e(bigInteger);
    }

    public v1(long[] jArr) {
        this.f40393g = jArr;
    }

    public int A() {
        return 0;
    }

    public int B() {
        return 0;
    }

    public int C() {
        return 233;
    }

    public int D() {
        return 2;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        long[] jArrM = rr.i.m();
        u1.a(this.f40393g, ((v1) fVar).f40393g, jArrM);
        return new v1(jArrM);
    }

    @Override // ir.f
    public ir.f b() {
        long[] jArrM = rr.i.m();
        u1.c(this.f40393g, jArrM);
        return new v1(jArrM);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        return k(fVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v1) {
            return rr.i.r(this.f40393g, ((v1) obj).f40393g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecT233Field";
    }

    @Override // ir.f
    public int g() {
        return 233;
    }

    @Override // ir.f
    public ir.f h() {
        long[] jArrM = rr.i.m();
        u1.l(this.f40393g, jArrM);
        return new v1(jArrM);
    }

    public int hashCode() {
        return org.bouncycastle.util.a.y0(this.f40393g, 0, 4) ^ 2330074;
    }

    @Override // ir.f
    public boolean i() {
        return rr.i.y(this.f40393g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.i.A(this.f40393g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        long[] jArrM = rr.i.m();
        u1.m(this.f40393g, ((v1) fVar).f40393g, jArrM);
        return new v1(jArrM);
    }

    @Override // ir.f
    public ir.f l(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        return m(fVar, fVar2, fVar3);
    }

    @Override // ir.f
    public ir.f m(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        long[] jArr = this.f40393g;
        long[] jArr2 = ((v1) fVar).f40393g;
        long[] jArr3 = ((v1) fVar2).f40393g;
        long[] jArr4 = ((v1) fVar3).f40393g;
        long[] jArrO = rr.i.o();
        u1.n(jArr, jArr2, jArrO);
        u1.n(jArr3, jArr4, jArrO);
        long[] jArrM = rr.i.m();
        u1.o(jArrO, jArrM);
        return new v1(jArrM);
    }

    @Override // ir.f
    public ir.f n() {
        return this;
    }

    @Override // ir.f
    public ir.f o() {
        long[] jArrM = rr.i.m();
        u1.q(this.f40393g, jArrM);
        return new v1(jArrM);
    }

    @Override // ir.f
    public ir.f p() {
        long[] jArrM = rr.i.m();
        u1.r(this.f40393g, jArrM);
        return new v1(jArrM);
    }

    @Override // ir.f
    public ir.f q(ir.f fVar, ir.f fVar2) {
        return r(fVar, fVar2);
    }

    @Override // ir.f
    public ir.f r(ir.f fVar, ir.f fVar2) {
        long[] jArr = this.f40393g;
        long[] jArr2 = ((v1) fVar).f40393g;
        long[] jArr3 = ((v1) fVar2).f40393g;
        long[] jArrO = rr.i.o();
        u1.s(jArr, jArrO);
        u1.n(jArr2, jArr3, jArrO);
        long[] jArrM = rr.i.m();
        u1.o(jArrO, jArrM);
        return new v1(jArrM);
    }

    @Override // ir.f
    public ir.f s(int i10) {
        if (i10 < 1) {
            return this;
        }
        long[] jArrM = rr.i.m();
        u1.t(this.f40393g, i10, jArrM);
        return new v1(jArrM);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        return a(fVar);
    }

    @Override // ir.f
    public boolean u() {
        return (this.f40393g[0] & 1) != 0;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.i.V(this.f40393g);
    }

    @Override // ir.f.a
    public ir.f w() {
        long[] jArrM = rr.i.m();
        u1.f(this.f40393g, jArrM);
        return new v1(jArrM);
    }

    @Override // ir.f.a
    public boolean x() {
        return true;
    }

    @Override // ir.f.a
    public int y() {
        return u1.u(this.f40393g);
    }

    public int z() {
        return 74;
    }
}
