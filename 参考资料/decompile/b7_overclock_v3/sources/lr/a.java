package lr;

import ir.e;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes6.dex */
public class a extends e.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40126s = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f40128q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f40125r = c.f40158h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ir.f[] f40127t = {new c(ir.d.f35647b)};

    /* JADX INFO: renamed from: lr.a$a, reason: collision with other inner class name */
    public class C0446a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f40129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f40130b;

        public C0446a(int i10, int[] iArr) {
            this.f40129a = i10;
            this.f40130b = iArr;
        }

        @Override // ir.g
        public ir.i a(int i10) {
            int[] iArrJ = rr.e.j();
            int[] iArrJ2 = rr.e.j();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f40129a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 4; i14++) {
                    int i15 = iArrJ[i14];
                    int[] iArr = this.f40130b;
                    iArrJ[i14] = i15 ^ (iArr[i11 + i14] & i13);
                    iArrJ2[i14] = iArrJ2[i14] ^ (iArr[(i11 + 4) + i14] & i13);
                }
                i11 += 8;
            }
            return d(iArrJ, iArrJ2);
        }

        @Override // ir.a, ir.g
        public ir.i b(int i10) {
            int[] iArrJ = rr.e.j();
            int[] iArrJ2 = rr.e.j();
            int i11 = i10 * 4 * 2;
            for (int i12 = 0; i12 < 4; i12++) {
                int[] iArr = this.f40130b;
                iArrJ[i12] = iArr[i11 + i12];
                iArrJ2[i12] = iArr[i11 + 4 + i12];
            }
            return d(iArrJ, iArrJ2);
        }

        @Override // ir.g
        public int c() {
            return this.f40129a;
        }

        public final ir.i d(int[] iArr, int[] iArr2) {
            return a.this.j(new c(iArr), new c(iArr2), a.f40127t);
        }
    }

    public a() {
        super(f40125r);
        this.f40128q = new d(this, null, null);
        this.f35662b = n(new BigInteger(1, jt.h.d("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f35663c = n(new BigInteger(1, jt.h.d("E87579C11079F43DD824993C2CEE5ED3")));
        this.f35664d = new BigInteger(1, jt.h.d("FFFFFFFE0000000075A30D1B9038A115"));
        this.f35665e = BigInteger.valueOf(1L);
        this.f35666f = 2;
    }

    @Override // ir.e.c, ir.e
    public ir.f F(SecureRandom secureRandom) {
        int[] iArrJ = rr.e.j();
        b.l(secureRandom, iArrJ);
        return new c(iArrJ);
    }

    @Override // ir.e.c, ir.e
    public ir.f G(SecureRandom secureRandom) {
        int[] iArrJ = rr.e.j();
        b.m(secureRandom, iArrJ);
        return new c(iArrJ);
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 2;
    }

    public BigInteger M() {
        return f40125r;
    }

    @Override // ir.e
    public ir.e d() {
        return new a();
    }

    @Override // ir.e
    public ir.g f(ir.i[] iVarArr, int i10, int i11) {
        int[] iArr = new int[i11 * 4 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            ir.i iVar = iVarArr[i10 + i13];
            rr.e.f(((c) iVar.n()).f40159g, 0, iArr, i12);
            int i14 = i12 + 4;
            rr.e.f(((c) iVar.o()).f40159g, 0, iArr, i14);
            i12 = i14 + 4;
        }
        return new C0446a(i11, iArr);
    }

    @Override // ir.e
    public ir.i i(ir.f fVar, ir.f fVar2) {
        return new d(this, fVar, fVar2);
    }

    @Override // ir.e
    public ir.i j(ir.f fVar, ir.f fVar2, ir.f[] fVarArr) {
        return new d(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public ir.f n(BigInteger bigInteger) {
        return new c(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return f40125r.bitLength();
    }

    @Override // ir.e
    public ir.i w() {
        return this.f40128q;
    }
}
