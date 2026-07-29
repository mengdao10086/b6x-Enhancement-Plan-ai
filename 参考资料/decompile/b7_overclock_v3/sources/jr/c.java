package jr;

import ir.f;
import java.math.BigInteger;
import rr.i;

/* JADX INFO: loaded from: classes6.dex */
public class c extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f36904h = i.U(b.f36900b);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int[] f36905i = {1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f36906g;

    public c() {
        this.f36906g = i.l();
    }

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f36904h) >= 0) {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }
        this.f36906g = b.f(bigInteger);
    }

    public c(int[] iArr) {
        this.f36906g = iArr;
    }

    @Override // ir.f
    public f a(f fVar) {
        int[] iArrL = i.l();
        b.a(this.f36906g, ((c) fVar).f36906g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public f b() {
        int[] iArrL = i.l();
        b.c(this.f36906g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public f d(f fVar) {
        int[] iArrL = i.l();
        b.h(((c) fVar).f36906g, iArrL);
        b.j(iArrL, this.f36906g, iArrL);
        return new c(iArrL);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return i.q(this.f36906g, ((c) obj).f36906g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "Curve25519Field";
    }

    @Override // ir.f
    public int g() {
        return f36904h.bitLength();
    }

    @Override // ir.f
    public f h() {
        int[] iArrL = i.l();
        b.h(this.f36906g, iArrL);
        return new c(iArrL);
    }

    public int hashCode() {
        return f36904h.hashCode() ^ org.bouncycastle.util.a.w0(this.f36906g, 0, 8);
    }

    @Override // ir.f
    public boolean i() {
        return i.x(this.f36906g);
    }

    @Override // ir.f
    public boolean j() {
        return i.z(this.f36906g);
    }

    @Override // ir.f
    public f k(f fVar) {
        int[] iArrL = i.l();
        b.j(this.f36906g, ((c) fVar).f36906g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public f n() {
        int[] iArrL = i.l();
        b.l(this.f36906g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public f o() {
        int[] iArr = this.f36906g;
        if (i.z(iArr) || i.x(iArr)) {
            return this;
        }
        int[] iArrL = i.l();
        b.q(iArr, iArrL);
        b.j(iArrL, iArr, iArrL);
        b.q(iArrL, iArrL);
        b.j(iArrL, iArr, iArrL);
        int[] iArrL2 = i.l();
        b.q(iArrL, iArrL2);
        b.j(iArrL2, iArr, iArrL2);
        int[] iArrL3 = i.l();
        b.r(iArrL2, 3, iArrL3);
        b.j(iArrL3, iArrL, iArrL3);
        b.r(iArrL3, 4, iArrL);
        b.j(iArrL, iArrL2, iArrL);
        b.r(iArrL, 4, iArrL3);
        b.j(iArrL3, iArrL2, iArrL3);
        b.r(iArrL3, 15, iArrL2);
        b.j(iArrL2, iArrL3, iArrL2);
        b.r(iArrL2, 30, iArrL3);
        b.j(iArrL3, iArrL2, iArrL3);
        b.r(iArrL3, 60, iArrL2);
        b.j(iArrL2, iArrL3, iArrL2);
        b.r(iArrL2, 11, iArrL3);
        b.j(iArrL3, iArrL, iArrL3);
        b.r(iArrL3, 120, iArrL);
        b.j(iArrL, iArrL2, iArrL);
        b.q(iArrL, iArrL);
        b.q(iArrL, iArrL2);
        if (i.q(iArr, iArrL2)) {
            return new c(iArrL);
        }
        b.j(iArrL, f36905i, iArrL);
        b.q(iArrL, iArrL2);
        if (i.q(iArr, iArrL2)) {
            return new c(iArrL);
        }
        return null;
    }

    @Override // ir.f
    public f p() {
        int[] iArrL = i.l();
        b.q(this.f36906g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public f t(f fVar) {
        int[] iArrL = i.l();
        b.u(this.f36906g, ((c) fVar).f36906g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public boolean u() {
        return i.u(this.f36906g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return i.U(this.f36906g);
    }
}
