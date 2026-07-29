package ps;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.n;
import org.bouncycastle.crypto.y;

/* JADX INFO: loaded from: classes6.dex */
public class c implements org.bouncycastle.crypto.d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f47022g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SecureRandom f47023h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f47024i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public short[][] f47025j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public short[][] f47026k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public short[] f47027l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public short[][] f47028m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public short[][] f47029n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public short[] f47030o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f47031p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public a[] f47032q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int[] f47033r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public short[][] f47034s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public short[][] f47035t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public short[] f47036u;

    @Override // org.bouncycastle.crypto.d
    public void a(y yVar) {
        i(yVar);
    }

    @Override // org.bouncycastle.crypto.d
    public org.bouncycastle.crypto.c b() {
        return e();
    }

    public final void c(short[][][] sArr) {
        int length = sArr.length;
        int length2 = sArr[0].length;
        this.f47034s = (short[][]) Array.newInstance((Class<?>) short.class, length, ((length2 + 1) * length2) / 2);
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = 0;
            for (int i12 = 0; i12 < length2; i12++) {
                for (int i13 = i12; i13 < length2; i13++) {
                    short[][] sArr2 = this.f47034s;
                    if (i13 == i12) {
                        sArr2[i10][i11] = sArr[i10][i12][i13];
                    } else {
                        sArr2[i10][i11] = qs.b.a(sArr[i10][i12][i13], sArr[i10][i13][i12]);
                    }
                    i11++;
                }
            }
        }
    }

    public final void d() {
        Class<short> cls;
        Class<short> cls2 = short.class;
        qs.a aVar = new qs.a();
        int[] iArr = this.f47033r;
        int i10 = 0;
        int i11 = iArr[iArr.length - 1] - iArr[0];
        int i12 = iArr[iArr.length - 1];
        short[][][] sArr = (short[][][]) Array.newInstance((Class<?>) cls2, i11, i12, i12);
        this.f47035t = (short[][]) Array.newInstance((Class<?>) cls2, i11, i12);
        this.f47036u = new short[i11];
        short[] sArr2 = new short[i12];
        int i13 = 0;
        int i14 = 0;
        while (true) {
            a[] aVarArr = this.f47032q;
            if (i13 >= aVarArr.length) {
                break;
            }
            short[][][] sArrA = aVarArr[i13].a();
            short[][][] sArrB = this.f47032q[i13].b();
            short[][] sArrD = this.f47032q[i13].d();
            short[] sArrC = this.f47032q[i13].c();
            int length = sArrA[i10].length;
            int length2 = sArrB[i10].length;
            while (i10 < length) {
                int i15 = 0;
                while (true) {
                    cls = cls2;
                    if (i15 >= length) {
                        break;
                    }
                    int i16 = 0;
                    while (i16 < length2) {
                        int i17 = i11;
                        int i18 = i12;
                        int i19 = i15 + length2;
                        short[] sArrG = aVar.g(sArrA[i10][i15][i16], this.f47028m[i19]);
                        int i20 = i14 + i10;
                        int i21 = i13;
                        sArr[i20] = aVar.a(sArr[i20], aVar.h(sArrG, this.f47028m[i16]));
                        short[] sArrG2 = aVar.g(this.f47030o[i16], sArrG);
                        short[][] sArr3 = this.f47035t;
                        sArr3[i20] = aVar.b(sArrG2, sArr3[i20]);
                        short[] sArrG3 = aVar.g(this.f47030o[i19], aVar.g(sArrA[i10][i15][i16], this.f47028m[i16]));
                        short[][] sArr4 = this.f47035t;
                        sArr4[i20] = aVar.b(sArrG3, sArr4[i20]);
                        short sE = qs.b.e(sArrA[i10][i15][i16], this.f47030o[i19]);
                        short[] sArr5 = this.f47036u;
                        sArr5[i20] = qs.b.a(sArr5[i20], qs.b.e(sE, this.f47030o[i16]));
                        i16++;
                        i12 = i18;
                        i11 = i17;
                        sArrA = sArrA;
                        i13 = i21;
                        sArrC = sArrC;
                    }
                    i15++;
                    cls2 = cls;
                }
                int i22 = i12;
                int i23 = i11;
                int i24 = i13;
                short[][][] sArr6 = sArrA;
                short[] sArr7 = sArrC;
                for (int i25 = 0; i25 < length2; i25++) {
                    for (int i26 = 0; i26 < length2; i26++) {
                        short[] sArrG4 = aVar.g(sArrB[i10][i25][i26], this.f47028m[i25]);
                        int i27 = i14 + i10;
                        sArr[i27] = aVar.a(sArr[i27], aVar.h(sArrG4, this.f47028m[i26]));
                        short[] sArrG5 = aVar.g(this.f47030o[i26], sArrG4);
                        short[][] sArr8 = this.f47035t;
                        sArr8[i27] = aVar.b(sArrG5, sArr8[i27]);
                        short[] sArrG6 = aVar.g(this.f47030o[i25], aVar.g(sArrB[i10][i25][i26], this.f47028m[i26]));
                        short[][] sArr9 = this.f47035t;
                        sArr9[i27] = aVar.b(sArrG6, sArr9[i27]);
                        short sE2 = qs.b.e(sArrB[i10][i25][i26], this.f47030o[i25]);
                        short[] sArr10 = this.f47036u;
                        sArr10[i27] = qs.b.a(sArr10[i27], qs.b.e(sE2, this.f47030o[i26]));
                    }
                }
                for (int i28 = 0; i28 < length2 + length; i28++) {
                    short[] sArrG7 = aVar.g(sArrD[i10][i28], this.f47028m[i28]);
                    short[][] sArr11 = this.f47035t;
                    int i29 = i14 + i10;
                    sArr11[i29] = aVar.b(sArrG7, sArr11[i29]);
                    short[] sArr12 = this.f47036u;
                    sArr12[i29] = qs.b.a(sArr12[i29], qs.b.e(sArrD[i10][i28], this.f47030o[i28]));
                }
                short[] sArr13 = this.f47036u;
                int i30 = i14 + i10;
                sArr13[i30] = qs.b.a(sArr13[i30], sArr7[i10]);
                i10++;
                cls2 = cls;
                i12 = i22;
                i11 = i23;
                sArrA = sArr6;
                i13 = i24;
                sArrC = sArr7;
            }
            i14 += length;
            i13++;
            i10 = 0;
        }
        Class<short> cls3 = cls2;
        int i31 = i12;
        int i32 = i11;
        short[][][] sArr14 = (short[][][]) Array.newInstance((Class<?>) cls3, i32, i31, i31);
        short[][] sArr15 = (short[][]) Array.newInstance((Class<?>) cls3, i32, i31);
        short[] sArr16 = new short[i32];
        for (int i33 = 0; i33 < i32; i33++) {
            int i34 = 0;
            while (true) {
                short[][] sArr17 = this.f47025j;
                if (i34 < sArr17.length) {
                    sArr14[i33] = aVar.a(sArr14[i33], aVar.f(sArr17[i33][i34], sArr[i34]));
                    sArr15[i33] = aVar.b(sArr15[i33], aVar.g(this.f47025j[i33][i34], this.f47035t[i34]));
                    sArr16[i33] = qs.b.a(sArr16[i33], qs.b.e(this.f47025j[i33][i34], this.f47036u[i34]));
                    i34++;
                }
            }
            sArr16[i33] = qs.b.a(sArr16[i33], this.f47027l[i33]);
        }
        this.f47035t = sArr15;
        this.f47036u = sArr16;
        c(sArr14);
    }

    public org.bouncycastle.crypto.c e() {
        if (!this.f47022g) {
            j();
        }
        k();
        f fVar = new f(this.f47026k, this.f47027l, this.f47029n, this.f47030o, this.f47033r, this.f47032q);
        int[] iArr = this.f47033r;
        return new org.bouncycastle.crypto.c((np.c) new g(iArr[iArr.length - 1] - iArr[0], this.f47034s, this.f47035t, this.f47036u), (np.c) fVar);
    }

    public final void f() {
        this.f47032q = new a[this.f47031p];
        int i10 = 0;
        while (i10 < this.f47031p) {
            a[] aVarArr = this.f47032q;
            int[] iArr = this.f47033r;
            int i11 = i10 + 1;
            aVarArr[i10] = new a(iArr[i10], iArr[i11], this.f47023h);
            i10 = i11;
        }
    }

    public final void g() {
        int[] iArr = this.f47033r;
        int i10 = iArr[iArr.length - 1] - iArr[0];
        this.f47025j = (short[][]) Array.newInstance((Class<?>) short.class, i10, i10);
        this.f47026k = null;
        qs.a aVar = new qs.a();
        while (this.f47026k == null) {
            for (int i11 = 0; i11 < i10; i11++) {
                for (int i12 = 0; i12 < i10; i12++) {
                    this.f47025j[i11][i12] = (short) (this.f47023h.nextInt() & 255);
                }
            }
            this.f47026k = aVar.e(this.f47025j);
        }
        this.f47027l = new short[i10];
        for (int i13 = 0; i13 < i10; i13++) {
            this.f47027l[i13] = (short) (this.f47023h.nextInt() & 255);
        }
    }

    public final void h() {
        int[] iArr = this.f47033r;
        int i10 = iArr[iArr.length - 1];
        this.f47028m = (short[][]) Array.newInstance((Class<?>) short.class, i10, i10);
        this.f47029n = null;
        qs.a aVar = new qs.a();
        while (this.f47029n == null) {
            for (int i11 = 0; i11 < i10; i11++) {
                for (int i12 = 0; i12 < i10; i12++) {
                    this.f47028m[i11][i12] = (short) (this.f47023h.nextInt() & 255);
                }
            }
            this.f47029n = aVar.e(this.f47028m);
        }
        this.f47030o = new short[i10];
        for (int i13 = 0; i13 < i10; i13++) {
            this.f47030o[i13] = (short) (this.f47023h.nextInt() & 255);
        }
    }

    public void i(y yVar) {
        b bVar = (b) yVar;
        this.f47024i = bVar;
        this.f47023h = bVar.a();
        this.f47033r = this.f47024i.c().d();
        this.f47031p = this.f47024i.c().c();
        this.f47022g = true;
    }

    public final void j() {
        i(new b(n.f(), new e()));
    }

    public final void k() {
        g();
        h();
        f();
        d();
    }
}
