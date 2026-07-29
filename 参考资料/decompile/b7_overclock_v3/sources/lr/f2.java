package lr;

import ir.f;
import java.math.BigInteger;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes6.dex */
public class f2 extends f.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f40203g;

    public f2() {
        this.f40203g = rr.j.c();
    }

    public f2(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 283) {
            throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
        }
        this.f40203g = e2.e(bigInteger);
    }

    public f2(long[] jArr) {
        this.f40203g = jArr;
    }

    public int A() {
        return 7;
    }

    public int B() {
        return 12;
    }

    public int C() {
        return DfuBaseService.NOTIFICATION_ID;
    }

    public int D() {
        return 3;
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        long[] jArrC = rr.j.c();
        e2.a(this.f40203g, ((f2) fVar).f40203g, jArrC);
        return new f2(jArrC);
    }

    @Override // ir.f
    public ir.f b() {
        long[] jArrC = rr.j.c();
        e2.c(this.f40203g, jArrC);
        return new f2(jArrC);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        return k(fVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f2) {
            return rr.j.e(this.f40203g, ((f2) obj).f40203g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecT283Field";
    }

    @Override // ir.f
    public int g() {
        return DfuBaseService.NOTIFICATION_ID;
    }

    @Override // ir.f
    public ir.f h() {
        long[] jArrC = rr.j.c();
        e2.l(this.f40203g, jArrC);
        return new f2(jArrC);
    }

    public int hashCode() {
        return org.bouncycastle.util.a.y0(this.f40203g, 0, 5) ^ 2831275;
    }

    @Override // ir.f
    public boolean i() {
        return rr.j.g(this.f40203g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.j.h(this.f40203g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        long[] jArrC = rr.j.c();
        e2.m(this.f40203g, ((f2) fVar).f40203g, jArrC);
        return new f2(jArrC);
    }

    @Override // ir.f
    public ir.f l(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        return m(fVar, fVar2, fVar3);
    }

    @Override // ir.f
    public ir.f m(ir.f fVar, ir.f fVar2, ir.f fVar3) {
        long[] jArr = this.f40203g;
        long[] jArr2 = ((f2) fVar).f40203g;
        long[] jArr3 = ((f2) fVar2).f40203g;
        long[] jArr4 = ((f2) fVar3).f40203g;
        long[] jArrE = rr.o.E(9);
        e2.n(jArr, jArr2, jArrE);
        e2.n(jArr3, jArr4, jArrE);
        long[] jArrC = rr.j.c();
        e2.o(jArrE, jArrC);
        return new f2(jArrC);
    }

    @Override // ir.f
    public ir.f n() {
        return this;
    }

    @Override // ir.f
    public ir.f o() {
        long[] jArrC = rr.j.c();
        e2.q(this.f40203g, jArrC);
        return new f2(jArrC);
    }

    @Override // ir.f
    public ir.f p() {
        long[] jArrC = rr.j.c();
        e2.r(this.f40203g, jArrC);
        return new f2(jArrC);
    }

    @Override // ir.f
    public ir.f q(ir.f fVar, ir.f fVar2) {
        return r(fVar, fVar2);
    }

    @Override // ir.f
    public ir.f r(ir.f fVar, ir.f fVar2) {
        long[] jArr = this.f40203g;
        long[] jArr2 = ((f2) fVar).f40203g;
        long[] jArr3 = ((f2) fVar2).f40203g;
        long[] jArrE = rr.o.E(9);
        e2.s(jArr, jArrE);
        e2.n(jArr2, jArr3, jArrE);
        long[] jArrC = rr.j.c();
        e2.o(jArrE, jArrC);
        return new f2(jArrC);
    }

    @Override // ir.f
    public ir.f s(int i10) {
        if (i10 < 1) {
            return this;
        }
        long[] jArrC = rr.j.c();
        e2.t(this.f40203g, i10, jArrC);
        return new f2(jArrC);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        return a(fVar);
    }

    @Override // ir.f
    public boolean u() {
        return (this.f40203g[0] & 1) != 0;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.j.i(this.f40203g);
    }

    @Override // ir.f.a
    public ir.f w() {
        long[] jArrC = rr.j.c();
        e2.f(this.f40203g, jArrC);
        return new f2(jArrC);
    }

    @Override // ir.f.a
    public boolean x() {
        return true;
    }

    @Override // ir.f.a
    public int y() {
        return e2.u(this.f40203g);
    }

    public int z() {
        return 5;
    }
}
