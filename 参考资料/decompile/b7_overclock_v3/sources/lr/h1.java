package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class h1 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f40229g;

    public h1() {
        this.f40229g = rr.g.k();
    }

    public h1(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 163) {
            throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
        }
        this.f40229g = g1.e(bigInteger);
    }

    public h1(long[] jArr) {
        this.f40229g = jArr;
    }

    public int A() {
        return 6;
    }

    public int B() {
        return 7;
    }

    public int C() {
        return 163;
    }

    public int D() {
        return 3;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        long[] jArrK = rr.g.k();
        g1.a(this.f40229g, ((h1) fVar).f40229g, jArrK);
        return new h1(jArrK);
    }

    @Override // ir.f
    public ir.f b() {
        long[] jArrK = rr.g.k();
        g1.c(this.f40229g, jArrK);
        return new h1(jArrK);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        return k(fVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h1) {
            return rr.g.p(this.f40229g, ((h1) obj).f40229g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecT163Field";
    }

    @Override // ir.f
    public int g() {
        return 163;
    }

    @Override // ir.f
    public ir.f h() {
        long[] jArrK = rr.g.k();
        g1.k(this.f40229g, jArrK);
        return new h1(jArrK);
    }

    public int hashCode() {
        return org.bouncycastle.util.a.y0(this.f40229g, 0, 3) ^ 163763;
    }

    @Override // ir.f
    public boolean i() {
        return rr.g.w(this.f40229g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.g.y(this.f40229g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        long[] jArrK = rr.g.k();
        g1.l(this.f40229g, ((h1) fVar).f40229g, jArrK);
        return new h1(jArrK);
    }

    @Override // ir.f
    public ir.f l(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        return m(fVar, fVar2, fVar3);
    }

    @Override // ir.f
    public ir.f m(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        long[] jArr = this.f40229g;
        long[] jArr2 = ((h1) fVar).f40229g;
        long[] jArr3 = ((h1) fVar2).f40229g;
        long[] jArr4 = ((h1) fVar3).f40229g;
        long[] jArrM = rr.g.m();
        g1.m(jArr, jArr2, jArrM);
        g1.m(jArr3, jArr4, jArrM);
        long[] jArrK = rr.g.k();
        g1.n(jArrM, jArrK);
        return new h1(jArrK);
    }

    @Override // ir.f
    public ir.f n() {
        return this;
    }

    @Override // ir.f
    public ir.f o() {
        long[] jArrK = rr.g.k();
        g1.p(this.f40229g, jArrK);
        return new h1(jArrK);
    }

    @Override // ir.f
    public ir.f p() {
        long[] jArrK = rr.g.k();
        g1.q(this.f40229g, jArrK);
        return new h1(jArrK);
    }

    @Override // ir.f
    public ir.f q(ir.f fVar, ir.f fVar2) {
        return r(fVar, fVar2);
    }

    @Override // ir.f
    public ir.f r(ir.f fVar, ir.f fVar2) {
        long[] jArr = this.f40229g;
        long[] jArr2 = ((h1) fVar).f40229g;
        long[] jArr3 = ((h1) fVar2).f40229g;
        long[] jArrM = rr.g.m();
        g1.r(jArr, jArrM);
        g1.m(jArr2, jArr3, jArrM);
        long[] jArrK = rr.g.k();
        g1.n(jArrM, jArrK);
        return new h1(jArrK);
    }

    @Override // ir.f
    public ir.f s(int i10) {
        if (i10 < 1) {
            return this;
        }
        long[] jArrK = rr.g.k();
        g1.s(this.f40229g, i10, jArrK);
        return new h1(jArrK);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        return a(fVar);
    }

    @Override // ir.f
    public boolean u() {
        return (this.f40229g[0] & 1) != 0;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.g.R(this.f40229g);
    }

    @Override // ir.f.a
    public ir.f w() {
        long[] jArrK = rr.g.k();
        g1.f(this.f40229g, jArrK);
        return new h1(jArrK);
    }

    @Override // ir.f.a
    public boolean x() {
        return true;
    }

    @Override // ir.f.a
    public int y() {
        return g1.t(this.f40229g);
    }

    public int z() {
        return 3;
    }
}
