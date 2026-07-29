package kr;

import ir.e;
import ir.f;
import ir.g;
import ir.i;
import java.math.BigInteger;
import java.security.SecureRandom;
import jt.h;

/* JADX INFO: loaded from: classes6.dex */
public class a extends e.c {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f39099s = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public d f39101q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final BigInteger f39098r = c.f39110h;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final f[] f39100t = {new c(ir.d.f35647b)};

    /* JADX INFO: renamed from: kr.a$a, reason: collision with other inner class name */
    public class C0439a extends ir.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f39102a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f39103b;

        public C0439a(int i10, int[] iArr) {
            this.f39102a = i10;
            this.f39103b = iArr;
        }

        @Override // ir.g
        public i a(int i10) {
            int[] iArrL = rr.i.l();
            int[] iArrL2 = rr.i.l();
            int i11 = 0;
            for (int i12 = 0; i12 < this.f39102a; i12++) {
                int i13 = ((i12 ^ i10) - 1) >> 31;
                for (int i14 = 0; i14 < 8; i14++) {
                    int i15 = iArrL[i14];
                    int[] iArr = this.f39103b;
                    iArrL[i14] = i15 ^ (iArr[i11 + i14] & i13);
                    iArrL2[i14] = iArrL2[i14] ^ (iArr[(i11 + 8) + i14] & i13);
                }
                i11 += 16;
            }
            return d(iArrL, iArrL2);
        }

        @Override // ir.a, ir.g
        public i b(int i10) {
            int[] iArrL = rr.i.l();
            int[] iArrL2 = rr.i.l();
            int i11 = i10 * 8 * 2;
            for (int i12 = 0; i12 < 8; i12++) {
                int[] iArr = this.f39103b;
                iArrL[i12] = iArr[i11 + i12];
                iArrL2[i12] = iArr[i11 + 8 + i12];
            }
            return d(iArrL, iArrL2);
        }

        @Override // ir.g
        public int c() {
            return this.f39102a;
        }

        public final i d(int[] iArr, int[] iArr2) {
            return a.this.j(new c(iArr), new c(iArr2), a.f39100t);
        }
    }

    public a() {
        super(f39098r);
        this.f39101q = new d(this, null, null);
        this.f35662b = n(new BigInteger(1, h.d("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.f35663c = n(new BigInteger(1, h.d("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.f35664d = new BigInteger(1, h.d("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.f35665e = BigInteger.valueOf(1L);
        this.f35666f = 2;
    }

    @Override // ir.e.c, ir.e
    public f F(SecureRandom secureRandom) {
        int[] iArrL = rr.i.l();
        b.l(secureRandom, iArrL);
        return new c(iArrL);
    }

    @Override // ir.e.c, ir.e
    public f G(SecureRandom secureRandom) {
        int[] iArrL = rr.i.l();
        b.m(secureRandom, iArrL);
        return new c(iArrL);
    }

    @Override // ir.e
    public boolean H(int i10) {
        return i10 == 2;
    }

    public BigInteger M() {
        return f39098r;
    }

    @Override // ir.e
    public e d() {
        return new a();
    }

    @Override // ir.e
    public g f(i[] iVarArr, int i10, int i11) {
        int[] iArr = new int[i11 * 8 * 2];
        int i12 = 0;
        for (int i13 = 0; i13 < i11; i13++) {
            i iVar = iVarArr[i10 + i13];
            rr.i.h(((c) iVar.n()).f39111g, 0, iArr, i12);
            int i14 = i12 + 8;
            rr.i.h(((c) iVar.o()).f39111g, 0, iArr, i14);
            i12 = i14 + 8;
        }
        return new C0439a(i11, iArr);
    }

    @Override // ir.e
    public i i(f fVar, f fVar2) {
        return new d(this, fVar, fVar2);
    }

    @Override // ir.e
    public i j(f fVar, f fVar2, f[] fVarArr) {
        return new d(this, fVar, fVar2, fVarArr);
    }

    @Override // ir.e
    public f n(BigInteger bigInteger) {
        return new c(bigInteger);
    }

    @Override // ir.e
    public int v() {
        return f39098r.bitLength();
    }

    @Override // ir.e
    public i w() {
        return this.f39101q;
    }
}
