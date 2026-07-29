package ks;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import np.w1;
import org.bouncycastle.crypto.s;

/* JADX INFO: loaded from: classes6.dex */
public class k implements js.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ls.b f39209a = new ls.b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f39210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s f39211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f39212d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f39213e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public s f39214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ls.d f39215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f39216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f39217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[][][] f39218j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[][] f39219k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f39220l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ls.a f39221m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public d f39222n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public SecureRandom f39223o;

    public k(a aVar) {
        this.f39216h = aVar;
        s sVar = aVar.get();
        this.f39211c = sVar;
        this.f39214f = sVar;
        this.f39212d = sVar.h();
        this.f39221m = new ls.a(this.f39211c);
    }

    @Override // js.f
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) {
        if (!z10) {
            this.f39222n = (h) kVar;
            f();
            return;
        }
        if (kVar instanceof w1) {
            w1 w1Var = (w1) kVar;
            this.f39223o = w1Var.b();
            this.f39222n = (g) w1Var.a();
        } else {
            this.f39223o = org.bouncycastle.crypto.n.f();
            this.f39222n = (g) kVar;
        }
        e();
    }

    @Override // js.f
    public byte[] b(byte[] bArr) {
        byte[] bArr2 = new byte[this.f39212d];
        byte[] bArrD = this.f39215g.d(bArr);
        byte[] bArrC = this.f39209a.c(this.f39218j[this.f39213e - 1]);
        byte[] bArrE = this.f39209a.e(this.f39217i[this.f39213e - 1]);
        int length = bArrE.length + bArrD.length + bArrC.length;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArrE, 0, bArr3, 0, bArrE.length);
        System.arraycopy(bArrD, 0, bArr3, bArrE.length, bArrD.length);
        System.arraycopy(bArrC, 0, bArr3, bArrE.length + bArrD.length, bArrC.length);
        byte[] bArr4 = new byte[0];
        for (int i10 = (this.f39213e - 1) - 1; i10 >= 0; i10--) {
            byte[] bArrC2 = this.f39209a.c(this.f39218j[i10]);
            byte[] bArrE2 = this.f39209a.e(this.f39217i[i10]);
            int length2 = bArr4.length;
            byte[] bArr5 = new byte[length2];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length);
            bArr4 = new byte[bArrE2.length + length2 + this.f39219k[i10].length + bArrC2.length];
            System.arraycopy(bArr5, 0, bArr4, 0, length2);
            System.arraycopy(bArrE2, 0, bArr4, length2, bArrE2.length);
            byte[][] bArr6 = this.f39219k;
            System.arraycopy(bArr6[i10], 0, bArr4, bArrE2.length + length2, bArr6[i10].length);
            System.arraycopy(bArrC2, 0, bArr4, length2 + bArrE2.length + this.f39219k[i10].length, bArrC2.length);
        }
        byte[] bArr7 = new byte[bArr4.length + length];
        System.arraycopy(bArr3, 0, bArr7, 0, length);
        System.arraycopy(bArr4, 0, bArr7, length, bArr4.length);
        return bArr7;
    }

    @Override // js.f
    public boolean d(byte[] bArr, byte[] bArr2) {
        this.f39214f.reset();
        int i10 = 0;
        for (int i11 = this.f39213e - 1; i11 >= 0; i11--) {
            ls.c cVar = new ls.c(this.f39216h.get(), this.f39220l.d()[i11]);
            int iC = cVar.c();
            int iB = this.f39209a.b(bArr2, i10);
            int i12 = i10 + 4;
            byte[] bArr3 = new byte[iC];
            System.arraycopy(bArr2, i12, bArr3, 0, iC);
            i10 = i12 + iC;
            bArr = cVar.a(bArr, bArr3);
            if (bArr == null) {
                System.err.println("OTS Public Key is null in GMSSSignature.verify");
                return false;
            }
            byte[][] bArr4 = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f39220l.a()[i11], this.f39212d);
            for (byte[] bArr5 : bArr4) {
                System.arraycopy(bArr2, i10, bArr5, 0, this.f39212d);
                i10 += this.f39212d;
            }
            byte[] bArr6 = new byte[this.f39212d];
            int length = (1 << bArr4.length) + iB;
            for (int i13 = 0; i13 < bArr4.length; i13++) {
                int i14 = this.f39212d;
                int i15 = i14 << 1;
                byte[] bArr7 = new byte[i15];
                if (length % 2 == 0) {
                    System.arraycopy(bArr, 0, bArr7, 0, i14);
                    byte[] bArr8 = bArr4[i13];
                    int i16 = this.f39212d;
                    System.arraycopy(bArr8, 0, bArr7, i16, i16);
                    length /= 2;
                } else {
                    System.arraycopy(bArr4[i13], 0, bArr7, 0, i14);
                    System.arraycopy(bArr, 0, bArr7, this.f39212d, bArr.length);
                    length = (length - 1) / 2;
                }
                this.f39211c.update(bArr7, 0, i15);
                bArr = new byte[this.f39211c.h()];
                this.f39211c.c(bArr, 0);
            }
        }
        return org.bouncycastle.util.a.g(this.f39210b, bArr);
    }

    public final void e() {
        int i10;
        this.f39211c.reset();
        g gVar = (g) this.f39222n;
        if (gVar.o()) {
            throw new IllegalStateException("Private key already used");
        }
        if (gVar.h(0) >= gVar.l(0)) {
            throw new IllegalStateException("No more signatures can be generated");
        }
        f fVarD = gVar.d();
        this.f39220l = fVarD;
        this.f39213e = fVarD.c();
        byte[] bArr = gVar.g()[this.f39213e - 1];
        int i11 = this.f39212d;
        byte[] bArr2 = new byte[i11];
        byte[] bArr3 = new byte[i11];
        System.arraycopy(bArr, 0, bArr3, 0, i11);
        this.f39215g = new ls.d(this.f39221m.c(bArr3), this.f39216h.get(), this.f39220l.d()[this.f39213e - 1]);
        byte[][][] bArrF = gVar.f();
        this.f39218j = new byte[this.f39213e][][];
        int i12 = 0;
        while (true) {
            i10 = this.f39213e;
            if (i12 >= i10) {
                break;
            }
            this.f39218j[i12] = (byte[][]) Array.newInstance((Class<?>) byte.class, bArrF[i12].length, this.f39212d);
            for (int i13 = 0; i13 < bArrF[i12].length; i13++) {
                System.arraycopy(bArrF[i12][i13], 0, this.f39218j[i12][i13], 0, this.f39212d);
            }
            i12++;
        }
        this.f39217i = new int[i10];
        System.arraycopy(gVar.i(), 0, this.f39217i, 0, this.f39213e);
        this.f39219k = new byte[this.f39213e - 1][];
        for (int i14 = 0; i14 < this.f39213e - 1; i14++) {
            byte[] bArrM = gVar.m(i14);
            byte[][] bArr4 = this.f39219k;
            bArr4[i14] = new byte[bArrM.length];
            System.arraycopy(bArrM, 0, bArr4[i14], 0, bArrM.length);
        }
        gVar.p();
    }

    public final void f() {
        this.f39211c.reset();
        h hVar = (h) this.f39222n;
        this.f39210b = hVar.e();
        f fVarD = hVar.d();
        this.f39220l = fVarD;
        this.f39213e = fVarD.c();
    }
}
