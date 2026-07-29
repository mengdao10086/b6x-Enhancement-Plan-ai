package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class r2 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f40350g;

    public r2() {
        this.f40350g = rr.n.c();
    }

    public r2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 571) {
            throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
        }
        this.f40350g = q2.h(bigInteger);
    }

    public r2(long[] jArr) {
        this.f40350g = jArr;
    }

    public int A() {
        return 5;
    }

    public int B() {
        return 10;
    }

    public int C() {
        return 571;
    }

    public int D() {
        return 3;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        long[] jArrC = rr.n.c();
        q2.b(this.f40350g, ((r2) fVar).f40350g, jArrC);
        return new r2(jArrC);
    }

    @Override // ir.f
    public ir.f b() {
        long[] jArrC = rr.n.c();
        q2.f(this.f40350g, jArrC);
        return new r2(jArrC);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        return k(fVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r2) {
            return rr.n.e(this.f40350g, ((r2) obj).f40350g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecT571Field";
    }

    @Override // ir.f
    public int g() {
        return 571;
    }

    @Override // ir.f
    public ir.f h() {
        long[] jArrC = rr.n.c();
        q2.n(this.f40350g, jArrC);
        return new r2(jArrC);
    }

    public int hashCode() {
        return org.bouncycastle.util.a.y0(this.f40350g, 0, 9) ^ 5711052;
    }

    @Override // ir.f
    public boolean i() {
        return rr.n.g(this.f40350g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.n.h(this.f40350g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        long[] jArrC = rr.n.c();
        q2.o(this.f40350g, ((r2) fVar).f40350g, jArrC);
        return new r2(jArrC);
    }

    @Override // ir.f
    public ir.f l(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        return m(fVar, fVar2, fVar3);
    }

    @Override // ir.f
    public ir.f m(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        long[] jArr = this.f40350g;
        long[] jArr2 = ((r2) fVar).f40350g;
        long[] jArr3 = ((r2) fVar2).f40350g;
        long[] jArr4 = ((r2) fVar3).f40350g;
        long[] jArrD = rr.n.d();
        q2.p(jArr, jArr2, jArrD);
        q2.p(jArr3, jArr4, jArrD);
        long[] jArrC = rr.n.c();
        q2.t(jArrD, jArrC);
        return new r2(jArrC);
    }

    @Override // ir.f
    public ir.f n() {
        return this;
    }

    @Override // ir.f
    public ir.f o() {
        long[] jArrC = rr.n.c();
        q2.v(this.f40350g, jArrC);
        return new r2(jArrC);
    }

    @Override // ir.f
    public ir.f p() {
        long[] jArrC = rr.n.c();
        q2.w(this.f40350g, jArrC);
        return new r2(jArrC);
    }

    @Override // ir.f
    public ir.f q(ir.f fVar, ir.f fVar2) {
        return r(fVar, fVar2);
    }

    @Override // ir.f
    public ir.f r(ir.f fVar, ir.f fVar2) {
        long[] jArr = this.f40350g;
        long[] jArr2 = ((r2) fVar).f40350g;
        long[] jArr3 = ((r2) fVar2).f40350g;
        long[] jArrD = rr.n.d();
        q2.x(jArr, jArrD);
        q2.p(jArr2, jArr3, jArrD);
        long[] jArrC = rr.n.c();
        q2.t(jArrD, jArrC);
        return new r2(jArrC);
    }

    @Override // ir.f
    public ir.f s(int i10) {
        if (i10 < 1) {
            return this;
        }
        long[] jArrC = rr.n.c();
        q2.y(this.f40350g, i10, jArrC);
        return new r2(jArrC);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        return a(fVar);
    }

    @Override // ir.f
    public boolean u() {
        return (this.f40350g[0] & 1) != 0;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.n.i(this.f40350g);
    }

    @Override // ir.f.a
    public ir.f w() {
        long[] jArrC = rr.n.c();
        q2.i(this.f40350g, jArrC);
        return new r2(jArrC);
    }

    @Override // ir.f.a
    public boolean x() {
        return true;
    }

    @Override // ir.f.a
    public int y() {
        return q2.z(this.f40350g);
    }

    public int z() {
        return 2;
    }
}
