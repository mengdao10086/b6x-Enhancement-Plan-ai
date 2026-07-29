package lr;

import ir.f;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes6.dex */
public class c0 extends f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final BigInteger f40160h = new BigInteger(1, jt.h.d("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f40161g;

    public c0() {
        this.f40161g = rr.h.j();
    }

    public c0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f40160h) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        this.f40161g = b0.e(bigInteger);
    }

    public c0(int[] iArr) {
        this.f40161g = iArr;
    }

    public static boolean A(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrJ = rr.h.j();
        rr.h.i(iArr2, iArrJ);
        int[] iArrJ2 = rr.h.j();
        iArrJ2[0] = 1;
        int[] iArrJ3 = rr.h.j();
        x(iArr, iArrJ, iArrJ2, iArrJ3, iArr3);
        int[] iArrJ4 = rr.h.j();
        int[] iArrJ5 = rr.h.j();
        for (int i10 = 1; i10 < 96; i10++) {
            rr.h.i(iArrJ, iArrJ4);
            rr.h.i(iArrJ2, iArrJ5);
            y(iArrJ, iArrJ2, iArrJ3, iArr3);
            if (rr.h.s(iArrJ)) {
                b0.g(iArrJ5, iArr3);
                b0.i(iArr3, iArrJ4, iArr3);
                return true;
            }
        }
        return false;
    }

    public static void w(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7) {
        b0.i(iArr5, iArr3, iArr7);
        b0.i(iArr7, iArr, iArr7);
        b0.i(iArr4, iArr2, iArr6);
        b0.a(iArr6, iArr7, iArr6);
        b0.i(iArr4, iArr3, iArr7);
        rr.h.i(iArr6, iArr4);
        b0.i(iArr5, iArr2, iArr5);
        b0.a(iArr5, iArr7, iArr5);
        b0.p(iArr5, iArr6);
        b0.i(iArr6, iArr, iArr6);
    }

    public static void x(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        rr.h.i(iArr, iArr4);
        int[] iArrJ = rr.h.j();
        int[] iArrJ2 = rr.h.j();
        for (int i10 = 0; i10 < 7; i10++) {
            rr.h.i(iArr2, iArrJ);
            rr.h.i(iArr3, iArrJ2);
            int i11 = 1 << i10;
            while (true) {
                i11--;
                if (i11 >= 0) {
                    y(iArr2, iArr3, iArr4, iArr5);
                }
            }
            w(iArr, iArrJ, iArrJ2, iArr2, iArr3, iArr4, iArr5);
        }
    }

    public static void y(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        b0.i(iArr2, iArr, iArr2);
        b0.u(iArr2, iArr2);
        b0.p(iArr, iArr4);
        b0.a(iArr3, iArr4, iArr);
        b0.i(iArr3, iArr4, iArr3);
        b0.o(rr.o.E0(7, iArr3, 2, 0), iArr3);
    }

    public static boolean z(int[] iArr) {
        int[] iArrJ = rr.h.j();
        int[] iArrJ2 = rr.h.j();
        rr.h.i(iArr, iArrJ);
        for (int i10 = 0; i10 < 7; i10++) {
            rr.h.i(iArrJ, iArrJ2);
            b0.q(iArrJ, 1 << i10, iArrJ);
            b0.i(iArrJ, iArrJ2, iArrJ);
        }
        b0.q(iArrJ, 95, iArrJ);
        return rr.h.r(iArrJ);
    }

    @Override // ir.f
    public ir.f a(ir.f fVar) {
        int[] iArrJ = rr.h.j();
        b0.a(this.f40161g, ((c0) fVar).f40161g, iArrJ);
        return new c0(iArrJ);
    }

    @Override // ir.f
    public ir.f b() {
        int[] iArrJ = rr.h.j();
        b0.c(this.f40161g, iArrJ);
        return new c0(iArrJ);
    }

    @Override // ir.f
    public ir.f d(ir.f fVar) {
        int[] iArrJ = rr.h.j();
        b0.g(((c0) fVar).f40161g, iArrJ);
        b0.i(iArrJ, this.f40161g, iArrJ);
        return new c0(iArrJ);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c0) {
            return rr.h.m(this.f40161g, ((c0) obj).f40161g);
        }
        return false;
    }

    @Override // ir.f
    public String f() {
        return "SecP224R1Field";
    }

    @Override // ir.f
    public int g() {
        return f40160h.bitLength();
    }

    @Override // ir.f
    public ir.f h() {
        int[] iArrJ = rr.h.j();
        b0.g(this.f40161g, iArrJ);
        return new c0(iArrJ);
    }

    public int hashCode() {
        return f40160h.hashCode() ^ org.bouncycastle.util.a.w0(this.f40161g, 0, 7);
    }

    @Override // ir.f
    public boolean i() {
        return rr.h.r(this.f40161g);
    }

    @Override // ir.f
    public boolean j() {
        return rr.h.s(this.f40161g);
    }

    @Override // ir.f
    public ir.f k(ir.f fVar) {
        int[] iArrJ = rr.h.j();
        b0.i(this.f40161g, ((c0) fVar).f40161g, iArrJ);
        return new c0(iArrJ);
    }

    @Override // ir.f
    public ir.f n() {
        int[] iArrJ = rr.h.j();
        b0.k(this.f40161g, iArrJ);
        return new c0(iArrJ);
    }

    @Override // ir.f
    public ir.f o() {
        int[] iArr = this.f40161g;
        if (rr.h.s(iArr) || rr.h.r(iArr)) {
            return this;
        }
        int[] iArrJ = rr.h.j();
        b0.k(iArr, iArrJ);
        int[] iArrO = rr.c.o(b0.f40151b);
        int[] iArrJ2 = rr.h.j();
        if (!z(iArr)) {
            return null;
        }
        while (!A(iArrJ, iArrO, iArrJ2)) {
            b0.c(iArrO, iArrO);
        }
        b0.p(iArrJ2, iArrO);
        if (rr.h.m(iArr, iArrO)) {
            return new c0(iArrJ2);
        }
        return null;
    }

    @Override // ir.f
    public ir.f p() {
        int[] iArrJ = rr.h.j();
        b0.p(this.f40161g, iArrJ);
        return new c0(iArrJ);
    }

    @Override // ir.f
    public ir.f t(ir.f fVar) {
        int[] iArrJ = rr.h.j();
        b0.s(this.f40161g, ((c0) fVar).f40161g, iArrJ);
        return new c0(iArrJ);
    }

    @Override // ir.f
    public boolean u() {
        return rr.h.o(this.f40161g, 0) == 1;
    }

    @Override // ir.f
    public BigInteger v() {
        return rr.h.M(this.f40161g);
    }
}
