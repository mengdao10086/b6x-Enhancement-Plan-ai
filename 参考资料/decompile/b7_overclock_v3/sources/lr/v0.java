package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class v0 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f40392g;

    public v0() {
        this.f40392g = rr.e.k();
    }

    public v0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        }
        this.f40392g = u0.e(bigInteger);
    }

    public v0(long[] jArr) {
        this.f40392g = jArr;
    }

    public int A() {
        return 0;
    }

    public int B() {
        return 0;
    }

    public int C() {
        return 113;
    }

    public int D() {
        return 2;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        long[] jArrK = rr.e.k();
        u0.a(this.f40392g, ((v0) fVar).f40392g, jArrK);
        return new v0(jArrK);
    }

    @Override // ir.f
    public ir.f b() {
        long[] jArrK = rr.e.k();
        u0.c(this.f40392g, jArrK);
        return new v0(jArrK);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        return k(fVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v0) {
            return rr.e.p(this.f40392g, ((v0) obj).f40392g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecT113Field";
    }

    @Override // ir.f
    public int g() {
        return 113;
    }

    @Override // ir.f
    public ir.f h() {
        long[] jArrK = rr.e.k();
        u0.j(this.f40392g, jArrK);
        return new v0(jArrK);
    }

    public int hashCode() {
        return org.bouncycastle.util.a.y0(this.f40392g, 0, 2) ^ 113009;
    }

    @Override // ir.f
    public boolean i() {
        return rr.e.w(this.f40392g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.e.y(this.f40392g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        long[] jArrK = rr.e.k();
        u0.k(this.f40392g, ((v0) fVar).f40392g, jArrK);
        return new v0(jArrK);
    }

    @Override // ir.f
    public ir.f l(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        return m(fVar, fVar2, fVar3);
    }

    @Override // ir.f
    public ir.f m(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        long[] jArr = this.f40392g;
        long[] jArr2 = ((v0) fVar).f40392g;
        long[] jArr3 = ((v0) fVar2).f40392g;
        long[] jArr4 = ((v0) fVar3).f40392g;
        long[] jArrM = rr.e.m();
        u0.l(jArr, jArr2, jArrM);
        u0.l(jArr3, jArr4, jArrM);
        long[] jArrK = rr.e.k();
        u0.m(jArrM, jArrK);
        return new v0(jArrK);
    }

    @Override // ir.f
    public ir.f n() {
        return this;
    }

    @Override // ir.f
    public ir.f o() {
        long[] jArrK = rr.e.k();
        u0.o(this.f40392g, jArrK);
        return new v0(jArrK);
    }

    @Override // ir.f
    public ir.f p() {
        long[] jArrK = rr.e.k();
        u0.p(this.f40392g, jArrK);
        return new v0(jArrK);
    }

    @Override // ir.f
    public ir.f q(ir.f fVar, ir.f fVar2) {
        return r(fVar, fVar2);
    }

    @Override // ir.f
    public ir.f r(ir.f fVar, ir.f fVar2) {
        long[] jArr = this.f40392g;
        long[] jArr2 = ((v0) fVar).f40392g;
        long[] jArr3 = ((v0) fVar2).f40392g;
        long[] jArrM = rr.e.m();
        u0.q(jArr, jArrM);
        u0.l(jArr2, jArr3, jArrM);
        long[] jArrK = rr.e.k();
        u0.m(jArrM, jArrK);
        return new v0(jArrK);
    }

    @Override // ir.f
    public ir.f s(int i10) {
        if (i10 < 1) {
            return this;
        }
        long[] jArrK = rr.e.k();
        u0.r(this.f40392g, i10, jArrK);
        return new v0(jArrK);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        return a(fVar);
    }

    @Override // ir.f
    public boolean u() {
        return (this.f40392g[0] & 1) != 0;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.e.S(this.f40392g);
    }

    @Override // ir.f.a
    public ir.f w() {
        long[] jArrK = rr.e.k();
        u0.f(this.f40392g, jArrK);
        return new v0(jArrK);
    }

    @Override // ir.f.a
    public boolean x() {
        return true;
    }

    @Override // ir.f.a
    public int y() {
        return u0.s(this.f40392g);
    }

    public int z() {
        return 9;
    }
}
