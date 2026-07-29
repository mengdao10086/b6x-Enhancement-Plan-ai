package kr;

import ir.f;
import java.math.BigInteger;
import jt.h;
import rr.i;

/* JADX INFO: loaded from: classes6.dex */
public class c extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f39110h = new BigInteger(1, h.d("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f39111g;

    public c() {
        this.f39111g = i.l();
    }

    public c(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f39110h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
        }
        this.f39111g = b.e(bigInteger);
    }

    public c(int[] iArr) {
        this.f39111g = iArr;
    }

    @Override // ir.f
    public f a(f fVar) {
        int[] iArrL = i.l();
        b.a(this.f39111g, ((c) fVar).f39111g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public f b() {
        int[] iArrL = i.l();
        b.c(this.f39111g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public f d(f fVar) {
        int[] iArrL = i.l();
        b.g(((c) fVar).f39111g, iArrL);
        b.i(iArrL, this.f39111g, iArrL);
        return new c(iArrL);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            return i.q(this.f39111g, ((c) obj).f39111g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SM2P256V1Field";
    }

    @Override // ir.f
    public int g() {
        return f39110h.bitLength();
    }

    @Override // ir.f
    public f h() {
        int[] iArrL = i.l();
        b.g(this.f39111g, iArrL);
        return new c(iArrL);
    }

    public int hashCode() {
        return f39110h.hashCode() ^ org.bouncycastle.util.a.w0(this.f39111g, 0, 8);
    }

    @Override // ir.f
    public boolean i() {
        return i.x(this.f39111g);
    }

    @Override // ir.f
    public boolean j() {
        return i.z(this.f39111g);
    }

    @Override // ir.f
    public f k(f fVar) {
        int[] iArrL = i.l();
        b.i(this.f39111g, ((c) fVar).f39111g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public f n() {
        int[] iArrL = i.l();
        b.k(this.f39111g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public f o() {
        int[] iArr = this.f39111g;
        if (i.z(iArr) || i.x(iArr)) {
            return this;
        }
        int[] iArrL = i.l();
        b.p(iArr, iArrL);
        b.i(iArrL, iArr, iArrL);
        int[] iArrL2 = i.l();
        b.q(iArrL, 2, iArrL2);
        b.i(iArrL2, iArrL, iArrL2);
        int[] iArrL3 = i.l();
        b.q(iArrL2, 2, iArrL3);
        b.i(iArrL3, iArrL, iArrL3);
        b.q(iArrL3, 6, iArrL);
        b.i(iArrL, iArrL3, iArrL);
        int[] iArrL4 = i.l();
        b.q(iArrL, 12, iArrL4);
        b.i(iArrL4, iArrL, iArrL4);
        b.q(iArrL4, 6, iArrL);
        b.i(iArrL, iArrL3, iArrL);
        b.p(iArrL, iArrL3);
        b.i(iArrL3, iArr, iArrL3);
        b.q(iArrL3, 31, iArrL4);
        b.i(iArrL4, iArrL3, iArrL);
        b.q(iArrL4, 32, iArrL4);
        b.i(iArrL4, iArrL, iArrL4);
        b.q(iArrL4, 62, iArrL4);
        b.i(iArrL4, iArrL, iArrL4);
        b.q(iArrL4, 4, iArrL4);
        b.i(iArrL4, iArrL2, iArrL4);
        b.q(iArrL4, 32, iArrL4);
        b.i(iArrL4, iArr, iArrL4);
        b.q(iArrL4, 62, iArrL4);
        b.p(iArrL4, iArrL2);
        if (i.q(iArr, iArrL2)) {
            return new c(iArrL4);
        }
        return null;
    }

    @Override // ir.f
    public f p() {
        int[] iArrL = i.l();
        b.p(this.f39111g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public f t(f fVar) {
        int[] iArrL = i.l();
        b.s(this.f39111g, ((c) fVar).f39111g, iArrL);
        return new c(iArrL);
    }

    @Override // ir.f
    public boolean u() {
        return i.u(this.f39111g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return i.U(this.f39111g);
    }
}
