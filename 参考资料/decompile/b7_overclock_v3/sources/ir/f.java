package ir;

import java.math.BigInteger;
import java.util.Random;

/* JADX INFO: loaded from: classes6.dex */
public abstract class f implements ir.d {

    public static abstract class a extends f {
        public f w() {
            int iG = g();
            if ((iG & 1) == 0) {
                throw new IllegalStateException("Half-trace only defined for odd m");
            }
            int i10 = (iG + 1) >>> 1;
            int iA = 31 - org.bouncycastle.util.j.a(i10);
            int i11 = 1;
            f fVarA = this;
            while (iA > 0) {
                fVarA = fVarA.s(i11 << 1).a(fVarA);
                iA--;
                i11 = i10 >>> iA;
                if ((i11 & 1) != 0) {
                    fVarA = fVarA.s(2).a(this);
                }
            }
            return fVarA;
        }

        public boolean x() {
            return false;
        }

        public int y() {
            int iG = g();
            int iA = 31 - org.bouncycastle.util.j.a(iG);
            int i10 = 1;
            f fVarA = this;
            while (iA > 0) {
                fVarA = fVarA.s(i10).a(fVarA);
                iA--;
                i10 = iG >>> iA;
                if ((i10 & 1) != 0) {
                    fVarA = fVarA.p().a(this);
                }
            }
            if (fVarA.j()) {
                return 0;
            }
            if (fVarA.i()) {
                return 1;
            }
            throw new IllegalStateException("Internal error in trace calculation");
        }
    }

    public static abstract class b extends f {
    }

    public static class c extends a {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f35695k = 1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f35696l = 2;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f35697m = 3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f35698g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f35699h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int[] f35700i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public o f35701j;

        public c(int i10, int i11, int i12, int i13, BigInteger bigInteger) {
            if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > i10) {
                throw new IllegalArgumentException("x value invalid in F2m field element");
            }
            if (i12 == 0 && i13 == 0) {
                this.f35698g = 2;
                this.f35700i = new int[]{i11};
            } else {
                if (i12 >= i13) {
                    throw new IllegalArgumentException("k2 must be smaller than k3");
                }
                if (i12 <= 0) {
                    throw new IllegalArgumentException("k2 must be larger than 0");
                }
                this.f35698g = 3;
                this.f35700i = new int[]{i11, i12, i13};
            }
            this.f35699h = i10;
            this.f35701j = new o(bigInteger);
        }

        public c(int i10, int[] iArr, o oVar) {
            this.f35699h = i10;
            this.f35698g = iArr.length == 1 ? 2 : 3;
            this.f35700i = iArr;
            this.f35701j = oVar;
        }

        public int A() {
            int[] iArr = this.f35700i;
            if (iArr.length >= 2) {
                return iArr[1];
            }
            return 0;
        }

        public int B() {
            int[] iArr = this.f35700i;
            if (iArr.length >= 3) {
                return iArr[2];
            }
            return 0;
        }

        public int C() {
            return this.f35699h;
        }

        public int D() {
            return this.f35698g;
        }

        @Override // ir.f
        public f a(f fVar) {
            o oVar = (o) this.f35701j.clone();
            oVar.f(((c) fVar).f35701j, 0);
            return new c(this.f35699h, this.f35700i, oVar);
        }

        @Override // ir.f
        public f b() {
            return new c(this.f35699h, this.f35700i, this.f35701j.d());
        }

        @Override // ir.f
        public int c() {
            return this.f35701j.k();
        }

        @Override // ir.f
        public f d(f fVar) {
            return k(fVar.h());
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f35699h == cVar.f35699h && this.f35698g == cVar.f35698g && org.bouncycastle.util.a.i(this.f35700i, cVar.f35700i) && this.f35701j.equals(cVar.f35701j);
        }

        @Override // ir.f
        public String f() {
            return "F2m";
        }

        @Override // ir.f
        public int g() {
            return this.f35699h;
        }

        @Override // ir.f
        public f h() {
            int i10 = this.f35699h;
            int[] iArr = this.f35700i;
            return new c(i10, iArr, this.f35701j.J(i10, iArr));
        }

        public int hashCode() {
            return (this.f35701j.hashCode() ^ this.f35699h) ^ org.bouncycastle.util.a.v0(this.f35700i);
        }

        @Override // ir.f
        public boolean i() {
            return this.f35701j.H();
        }

        @Override // ir.f
        public boolean j() {
            return this.f35701j.I();
        }

        @Override // ir.f
        public f k(f fVar) {
            int i10 = this.f35699h;
            int[] iArr = this.f35700i;
            return new c(i10, iArr, this.f35701j.K(((c) fVar).f35701j, i10, iArr));
        }

        @Override // ir.f
        public f l(f fVar, f fVar2, f fVar3) {
            return m(fVar, fVar2, fVar3);
        }

        @Override // ir.f
        public f m(f fVar, f fVar2, f fVar3) {
            o oVar = this.f35701j;
            o oVar2 = ((c) fVar).f35701j;
            o oVar3 = ((c) fVar2).f35701j;
            o oVar4 = ((c) fVar3).f35701j;
            o oVarR = oVar.R(oVar2, this.f35699h, this.f35700i);
            o oVarR2 = oVar3.R(oVar4, this.f35699h, this.f35700i);
            if (oVarR == oVar || oVarR == oVar2) {
                oVarR = (o) oVarR.clone();
            }
            oVarR.f(oVarR2, 0);
            oVarR.V(this.f35699h, this.f35700i);
            return new c(this.f35699h, this.f35700i, oVarR);
        }

        @Override // ir.f
        public f n() {
            return this;
        }

        @Override // ir.f
        public f o() {
            return (this.f35701j.I() || this.f35701j.H()) ? this : s(this.f35699h - 1);
        }

        @Override // ir.f
        public f p() {
            int i10 = this.f35699h;
            int[] iArr = this.f35700i;
            return new c(i10, iArr, this.f35701j.P(i10, iArr));
        }

        @Override // ir.f
        public f q(f fVar, f fVar2) {
            return r(fVar, fVar2);
        }

        @Override // ir.f
        public f r(f fVar, f fVar2) {
            o oVar = this.f35701j;
            o oVar2 = ((c) fVar).f35701j;
            o oVar3 = ((c) fVar2).f35701j;
            o oVarK0 = oVar.k0(this.f35699h, this.f35700i);
            o oVarR = oVar2.R(oVar3, this.f35699h, this.f35700i);
            if (oVarK0 == oVar) {
                oVarK0 = (o) oVarK0.clone();
            }
            oVarK0.f(oVarR, 0);
            oVarK0.V(this.f35699h, this.f35700i);
            return new c(this.f35699h, this.f35700i, oVarK0);
        }

        @Override // ir.f
        public f s(int i10) {
            if (i10 < 1) {
                return this;
            }
            int i11 = this.f35699h;
            int[] iArr = this.f35700i;
            return new c(i11, iArr, this.f35701j.Q(i10, i11, iArr));
        }

        @Override // ir.f
        public f t(f fVar) {
            return a(fVar);
        }

        @Override // ir.f
        public boolean u() {
            return this.f35701j.n0();
        }

        @Override // ir.f
        public BigInteger v() {
            return this.f35701j.o0();
        }

        public int z() {
            return this.f35700i[0];
        }
    }

    public static class d extends b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public BigInteger f35702g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public BigInteger f35703h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public BigInteger f35704i;

        public d(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            if (bigInteger3 == null || bigInteger3.signum() < 0 || bigInteger3.compareTo(bigInteger) >= 0) {
                throw new IllegalArgumentException("x value invalid in Fp field element");
            }
            this.f35702g = bigInteger;
            this.f35703h = bigInteger2;
            this.f35704i = bigInteger3;
        }

        public static BigInteger w(BigInteger bigInteger) {
            int iBitLength = bigInteger.bitLength();
            if (iBitLength < 96 || bigInteger.shiftRight(iBitLength - 64).longValue() != -1) {
                return null;
            }
            return ir.d.f35647b.shiftLeft(iBitLength).subtract(bigInteger);
        }

        public BigInteger A(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger bigIntegerAdd = bigInteger.add(bigInteger2);
            return bigIntegerAdd.compareTo(this.f35702g) >= 0 ? bigIntegerAdd.subtract(this.f35702g) : bigIntegerAdd;
        }

        public BigInteger B(BigInteger bigInteger) {
            BigInteger bigIntegerShiftLeft = bigInteger.shiftLeft(1);
            return bigIntegerShiftLeft.compareTo(this.f35702g) >= 0 ? bigIntegerShiftLeft.subtract(this.f35702g) : bigIntegerShiftLeft;
        }

        public BigInteger C(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f35702g.add(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        public BigInteger D(BigInteger bigInteger) {
            if (bigInteger.testBit(0)) {
                bigInteger = this.f35702g.subtract(bigInteger);
            }
            return bigInteger.shiftRight(1);
        }

        public BigInteger E(BigInteger bigInteger) {
            return org.bouncycastle.util.b.n(this.f35702g, bigInteger);
        }

        public BigInteger F(BigInteger bigInteger, BigInteger bigInteger2) {
            return G(bigInteger.multiply(bigInteger2));
        }

        public BigInteger G(BigInteger bigInteger) {
            if (this.f35703h == null) {
                return bigInteger.mod(this.f35702g);
            }
            boolean z10 = bigInteger.signum() < 0;
            if (z10) {
                bigInteger = bigInteger.abs();
            }
            int iBitLength = this.f35702g.bitLength();
            boolean zEquals = this.f35703h.equals(ir.d.f35647b);
            while (bigInteger.bitLength() > iBitLength + 1) {
                BigInteger bigIntegerShiftRight = bigInteger.shiftRight(iBitLength);
                BigInteger bigIntegerSubtract = bigInteger.subtract(bigIntegerShiftRight.shiftLeft(iBitLength));
                if (!zEquals) {
                    bigIntegerShiftRight = bigIntegerShiftRight.multiply(this.f35703h);
                }
                bigInteger = bigIntegerShiftRight.add(bigIntegerSubtract);
            }
            while (bigInteger.compareTo(this.f35702g) >= 0) {
                bigInteger = bigInteger.subtract(this.f35702g);
            }
            return (!z10 || bigInteger.signum() == 0) ? bigInteger : this.f35702g.subtract(bigInteger);
        }

        public BigInteger H(BigInteger bigInteger, BigInteger bigInteger2) {
            BigInteger bigIntegerSubtract = bigInteger.subtract(bigInteger2);
            return bigIntegerSubtract.signum() < 0 ? bigIntegerSubtract.add(this.f35702g) : bigIntegerSubtract;
        }

        @Override // ir.f
        public f a(f fVar) {
            return new d(this.f35702g, this.f35703h, A(this.f35704i, fVar.v()));
        }

        @Override // ir.f
        public f b() {
            BigInteger bigIntegerAdd = this.f35704i.add(ir.d.f35647b);
            if (bigIntegerAdd.compareTo(this.f35702g) == 0) {
                bigIntegerAdd = ir.d.f35646a;
            }
            return new d(this.f35702g, this.f35703h, bigIntegerAdd);
        }

        @Override // ir.f
        public f d(f fVar) {
            return new d(this.f35702g, this.f35703h, F(this.f35704i, E(fVar.v())));
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f35702g.equals(dVar.f35702g) && this.f35704i.equals(dVar.f35704i);
        }

        @Override // ir.f
        public String f() {
            return "Fp";
        }

        @Override // ir.f
        public int g() {
            return this.f35702g.bitLength();
        }

        @Override // ir.f
        public f h() {
            return new d(this.f35702g, this.f35703h, E(this.f35704i));
        }

        public int hashCode() {
            return this.f35702g.hashCode() ^ this.f35704i.hashCode();
        }

        @Override // ir.f
        public f k(f fVar) {
            return new d(this.f35702g, this.f35703h, F(this.f35704i, fVar.v()));
        }

        @Override // ir.f
        public f l(f fVar, f fVar2, f fVar3) {
            BigInteger bigInteger = this.f35704i;
            BigInteger bigIntegerV = fVar.v();
            BigInteger bigIntegerV2 = fVar2.v();
            BigInteger bigIntegerV3 = fVar3.v();
            return new d(this.f35702g, this.f35703h, G(bigInteger.multiply(bigIntegerV).subtract(bigIntegerV2.multiply(bigIntegerV3))));
        }

        @Override // ir.f
        public f m(f fVar, f fVar2, f fVar3) {
            BigInteger bigInteger = this.f35704i;
            BigInteger bigIntegerV = fVar.v();
            BigInteger bigIntegerV2 = fVar2.v();
            BigInteger bigIntegerV3 = fVar3.v();
            return new d(this.f35702g, this.f35703h, G(bigInteger.multiply(bigIntegerV).add(bigIntegerV2.multiply(bigIntegerV3))));
        }

        @Override // ir.f
        public f n() {
            if (this.f35704i.signum() == 0) {
                return this;
            }
            BigInteger bigInteger = this.f35702g;
            return new d(bigInteger, this.f35703h, bigInteger.subtract(this.f35704i));
        }

        @Override // ir.f
        public f o() {
            if (j() || i()) {
                return this;
            }
            if (!this.f35702g.testBit(0)) {
                throw new RuntimeException("not done yet");
            }
            if (this.f35702g.testBit(1)) {
                BigInteger bigIntegerAdd = this.f35702g.shiftRight(2).add(ir.d.f35647b);
                BigInteger bigInteger = this.f35702g;
                return x(new d(bigInteger, this.f35703h, this.f35704i.modPow(bigIntegerAdd, bigInteger)));
            }
            if (this.f35702g.testBit(2)) {
                BigInteger bigIntegerModPow = this.f35704i.modPow(this.f35702g.shiftRight(3), this.f35702g);
                BigInteger bigIntegerF = F(bigIntegerModPow, this.f35704i);
                if (F(bigIntegerF, bigIntegerModPow).equals(ir.d.f35647b)) {
                    return x(new d(this.f35702g, this.f35703h, bigIntegerF));
                }
                return x(new d(this.f35702g, this.f35703h, F(bigIntegerF, ir.d.f35648c.modPow(this.f35702g.shiftRight(2), this.f35702g))));
            }
            BigInteger bigIntegerShiftRight = this.f35702g.shiftRight(1);
            BigInteger bigIntegerModPow2 = this.f35704i.modPow(bigIntegerShiftRight, this.f35702g);
            BigInteger bigInteger2 = ir.d.f35647b;
            if (!bigIntegerModPow2.equals(bigInteger2)) {
                return null;
            }
            BigInteger bigInteger3 = this.f35704i;
            BigInteger bigIntegerB = B(B(bigInteger3));
            BigInteger bigIntegerAdd2 = bigIntegerShiftRight.add(bigInteger2);
            BigInteger bigIntegerSubtract = this.f35702g.subtract(bigInteger2);
            Random random = new Random();
            while (true) {
                BigInteger bigInteger4 = new BigInteger(this.f35702g.bitLength(), random);
                if (bigInteger4.compareTo(this.f35702g) < 0 && G(bigInteger4.multiply(bigInteger4).subtract(bigIntegerB)).modPow(bigIntegerShiftRight, this.f35702g).equals(bigIntegerSubtract)) {
                    BigInteger[] bigIntegerArrZ = z(bigInteger4, bigInteger3, bigIntegerAdd2);
                    BigInteger bigInteger5 = bigIntegerArrZ[0];
                    BigInteger bigInteger6 = bigIntegerArrZ[1];
                    if (F(bigInteger6, bigInteger6).equals(bigIntegerB)) {
                        return new d(this.f35702g, this.f35703h, D(bigInteger6));
                    }
                    if (!bigInteger5.equals(ir.d.f35647b) && !bigInteger5.equals(bigIntegerSubtract)) {
                        return null;
                    }
                }
            }
        }

        @Override // ir.f
        public f p() {
            BigInteger bigInteger = this.f35702g;
            BigInteger bigInteger2 = this.f35703h;
            BigInteger bigInteger3 = this.f35704i;
            return new d(bigInteger, bigInteger2, F(bigInteger3, bigInteger3));
        }

        @Override // ir.f
        public f q(f fVar, f fVar2) {
            BigInteger bigInteger = this.f35704i;
            BigInteger bigIntegerV = fVar.v();
            BigInteger bigIntegerV2 = fVar2.v();
            return new d(this.f35702g, this.f35703h, G(bigInteger.multiply(bigInteger).subtract(bigIntegerV.multiply(bigIntegerV2))));
        }

        @Override // ir.f
        public f r(f fVar, f fVar2) {
            BigInteger bigInteger = this.f35704i;
            BigInteger bigIntegerV = fVar.v();
            BigInteger bigIntegerV2 = fVar2.v();
            return new d(this.f35702g, this.f35703h, G(bigInteger.multiply(bigInteger).add(bigIntegerV.multiply(bigIntegerV2))));
        }

        @Override // ir.f
        public f t(f fVar) {
            return new d(this.f35702g, this.f35703h, H(this.f35704i, fVar.v()));
        }

        @Override // ir.f
        public BigInteger v() {
            return this.f35704i;
        }

        public final f x(f fVar) {
            if (fVar.p().equals(this)) {
                return fVar;
            }
            return null;
        }

        public BigInteger y() {
            return this.f35702g;
        }

        public final BigInteger[] z(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            int iBitLength = bigInteger3.bitLength();
            int lowestSetBit = bigInteger3.getLowestSetBit();
            BigInteger bigIntegerF = ir.d.f35647b;
            BigInteger bigIntegerG = bigInteger;
            BigInteger bigIntegerF2 = bigIntegerF;
            BigInteger bigIntegerG2 = ir.d.f35648c;
            BigInteger bigIntegerF3 = bigIntegerF2;
            for (int i10 = iBitLength - 1; i10 >= lowestSetBit + 1; i10--) {
                bigIntegerF = F(bigIntegerF, bigIntegerF3);
                if (bigInteger3.testBit(i10)) {
                    bigIntegerF3 = F(bigIntegerF, bigInteger2);
                    bigIntegerF2 = F(bigIntegerF2, bigIntegerG);
                    bigIntegerG2 = G(bigIntegerG.multiply(bigIntegerG2).subtract(bigInteger.multiply(bigIntegerF)));
                    bigIntegerG = G(bigIntegerG.multiply(bigIntegerG).subtract(bigIntegerF3.shiftLeft(1)));
                } else {
                    BigInteger bigIntegerG3 = G(bigIntegerF2.multiply(bigIntegerG2).subtract(bigIntegerF));
                    BigInteger bigIntegerG4 = G(bigIntegerG.multiply(bigIntegerG2).subtract(bigInteger.multiply(bigIntegerF)));
                    bigIntegerG2 = G(bigIntegerG2.multiply(bigIntegerG2).subtract(bigIntegerF.shiftLeft(1)));
                    bigIntegerG = bigIntegerG4;
                    bigIntegerF2 = bigIntegerG3;
                    bigIntegerF3 = bigIntegerF;
                }
            }
            BigInteger bigIntegerF4 = F(bigIntegerF, bigIntegerF3);
            BigInteger bigIntegerF5 = F(bigIntegerF4, bigInteger2);
            BigInteger bigIntegerG5 = G(bigIntegerF2.multiply(bigIntegerG2).subtract(bigIntegerF4));
            BigInteger bigIntegerG6 = G(bigIntegerG.multiply(bigIntegerG2).subtract(bigInteger.multiply(bigIntegerF4)));
            BigInteger bigIntegerF6 = F(bigIntegerF4, bigIntegerF5);
            for (int i11 = 1; i11 <= lowestSetBit; i11++) {
                bigIntegerG5 = F(bigIntegerG5, bigIntegerG6);
                bigIntegerG6 = G(bigIntegerG6.multiply(bigIntegerG6).subtract(bigIntegerF6.shiftLeft(1)));
                bigIntegerF6 = F(bigIntegerF6, bigIntegerF6);
            }
            return new BigInteger[]{bigIntegerG5, bigIntegerG6};
        }
    }

    public abstract f a(f fVar);

    public abstract f b();

    public int c() {
        return v().bitLength();
    }

    public abstract f d(f fVar);

    public byte[] e() {
        return org.bouncycastle.util.b.b((g() + 7) / 8, v());
    }

    public abstract String f();

    public abstract int g();

    public abstract f h();

    public boolean i() {
        return c() == 1;
    }

    public boolean j() {
        return v().signum() == 0;
    }

    public abstract f k(f fVar);

    public f l(f fVar, f fVar2, f fVar3) {
        return k(fVar).t(fVar2.k(fVar3));
    }

    public f m(f fVar, f fVar2, f fVar3) {
        return k(fVar).a(fVar2.k(fVar3));
    }

    public abstract f n();

    public abstract f o();

    public abstract f p();

    public f q(f fVar, f fVar2) {
        return p().t(fVar.k(fVar2));
    }

    public f r(f fVar, f fVar2) {
        return p().a(fVar.k(fVar2));
    }

    public f s(int i10) {
        f fVarP = this;
        for (int i11 = 0; i11 < i10; i11++) {
            fVarP = fVarP.p();
        }
        return fVarP;
    }

    public abstract f t(f fVar);

    public String toString() {
        return v().toString(16);
    }

    public boolean u() {
        return v().testBit(0);
    }

    public abstract BigInteger v();
}
