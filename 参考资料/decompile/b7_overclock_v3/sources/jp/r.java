package jp;

import java.io.ByteArrayOutputStream;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class r implements jp.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f36725o = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f36726p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f36727q = 512;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f36728r = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f36731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f36732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public byte[] f36733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte[] f36734f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f36735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f36736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f36737i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f36738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f36739k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a f36740l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f36741m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f36742n;

    public class a extends ByteArrayOutputStream {
        public a() {
        }

        public byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public r(org.bouncycastle.crypto.f fVar) {
        this(fVar, 4);
    }

    public r(org.bouncycastle.crypto.f fVar, int i10) {
        this.f36740l = new a();
        this.f36741m = new a();
        this.f36742n = 4;
        this.f36729a = fVar;
        this.f36730b = fVar.c();
        this.f36735g = new byte[fVar.c()];
        this.f36732d = new byte[fVar.c()];
        this.f36733e = new byte[fVar.c()];
        this.f36734f = new byte[fVar.c()];
        this.f36736h = new byte[fVar.c()];
        this.f36737i = new byte[fVar.c()];
        this.f36738j = new byte[fVar.c()];
        this.f36739k = new byte[fVar.c()];
        r(i10);
    }

    @Override // jp.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        org.bouncycastle.crypto.k kVarB;
        if (kVar instanceof np.a) {
            np.a aVar = (np.a) kVar;
            if (aVar.c() > 512 || aVar.c() < 64 || aVar.c() % 8 != 0) {
                throw new IllegalArgumentException("Invalid mac size specified");
            }
            this.f36735g = aVar.d();
            this.f36730b = aVar.c() / 8;
            this.f36732d = aVar.a();
            kVarB = aVar.b();
        } else {
            if (!(kVar instanceof v1)) {
                throw new IllegalArgumentException("Invalid parameters specified");
            }
            v1 v1Var = (v1) kVar;
            this.f36735g = v1Var.a();
            this.f36730b = this.f36729a.c();
            this.f36732d = null;
            kVarB = v1Var.b();
        }
        this.f36733e = new byte[this.f36730b];
        this.f36731c = z10;
        this.f36729a.a(true, kVarB);
        this.f36739k[0] = 1;
        byte[] bArr = this.f36732d;
        if (bArr != null) {
            k(bArr, 0, bArr.length);
        }
    }

    @Override // jp.b
    public String b() {
        return this.f36729a.b() + "/KCCM";
    }

    @Override // jp.b
    public int c(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException {
        int iQ = q(this.f36741m.a(), 0, this.f36741m.size(), bArr, i10);
        reset();
        return iQ;
    }

    @Override // jp.b
    public byte[] d() {
        return org.bouncycastle.util.a.p(this.f36733e);
    }

    @Override // jp.b
    public int e(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws IllegalStateException, DataLengthException {
        if (bArr.length < i10 + i11) {
            throw new DataLengthException("input buffer too short");
        }
        this.f36741m.write(bArr, i10, i11);
        return 0;
    }

    @Override // jp.a
    public org.bouncycastle.crypto.f f() {
        return this.f36729a;
    }

    @Override // jp.b
    public int g(int i10) {
        return i10;
    }

    @Override // jp.b
    public int h(int i10) {
        return i10 + this.f36730b;
    }

    @Override // jp.b
    public int i(byte b10, byte[] bArr, int i10) throws IllegalStateException, DataLengthException {
        this.f36741m.write(b10);
        return 0;
    }

    @Override // jp.b
    public void j(byte b10) {
        this.f36740l.write(b10);
    }

    @Override // jp.b
    public void k(byte[] bArr, int i10, int i11) {
        this.f36740l.write(bArr, i10, i11);
    }

    public final void l(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            for (int i12 = 0; i12 < this.f36729a.c(); i12++) {
                byte[] bArr2 = this.f36734f;
                bArr2[i12] = (byte) (bArr2[i12] ^ bArr[i10 + i12]);
            }
            org.bouncycastle.crypto.f fVar = this.f36729a;
            byte[] bArr3 = this.f36734f;
            fVar.d(bArr3, 0, bArr3, 0);
            i11 -= this.f36729a.c();
            i10 += this.f36729a.c();
        }
    }

    public final void m(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        int i13 = 0;
        while (true) {
            byte[] bArr3 = this.f36739k;
            if (i13 >= bArr3.length) {
                break;
            }
            byte[] bArr4 = this.f36738j;
            bArr4[i13] = (byte) (bArr4[i13] + bArr3[i13]);
            i13++;
        }
        this.f36729a.d(this.f36738j, 0, this.f36737i, 0);
        for (int i14 = 0; i14 < this.f36729a.c(); i14++) {
            bArr2[i12 + i14] = (byte) (this.f36737i[i14] ^ bArr[i10 + i14]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0047 A[LOOP:0: B:24:0x0040->B:26:0x0047, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte n(boolean r4, int r5) {
        /*
            r3 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "0"
            if (r4 == 0) goto Lf
            java.lang.String r4 = "1"
            r0.append(r4)
            goto L12
        Lf:
            r0.append(r1)
        L12:
            r4 = 8
            if (r5 == r4) goto L33
            r4 = 16
            if (r5 == r4) goto L30
            r4 = 32
            if (r5 == r4) goto L2d
            r4 = 48
            if (r5 == r4) goto L2a
            r4 = 64
            if (r5 == r4) goto L27
            goto L38
        L27:
            java.lang.String r4 = "110"
            goto L35
        L2a:
            java.lang.String r4 = "101"
            goto L35
        L2d:
            java.lang.String r4 = "100"
            goto L35
        L30:
            java.lang.String r4 = "011"
            goto L35
        L33:
            java.lang.String r4 = "010"
        L35:
            r0.append(r4)
        L38:
            int r4 = r3.f36742n
            int r4 = r4 + (-1)
            java.lang.String r4 = java.lang.Integer.toBinaryString(r4)
        L40:
            int r5 = r4.length()
            r2 = 4
            if (r5 >= r2) goto L56
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            r5.<init>(r4)
            r4 = 0
            java.lang.StringBuffer r4 = r5.insert(r4, r1)
            java.lang.String r4 = r4.toString()
            goto L40
        L56:
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5 = 2
            int r4 = java.lang.Integer.parseInt(r4, r5)
            byte r4 = (byte) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.r.n(boolean, int):byte");
    }

    public final void o(int i10, byte[] bArr, int i11) {
        bArr[i11 + 3] = (byte) (i10 >> 24);
        bArr[i11 + 2] = (byte) (i10 >> 16);
        bArr[i11 + 1] = (byte) (i10 >> 8);
        bArr[i11] = (byte) i10;
    }

    public final void p(byte[] bArr, int i10, int i11, int i12) {
        if (i11 - i10 < this.f36729a.c()) {
            throw new IllegalArgumentException("authText buffer too short");
        }
        if (i11 % this.f36729a.c() != 0) {
            throw new IllegalArgumentException("padding not supported");
        }
        byte[] bArr2 = this.f36735g;
        System.arraycopy(bArr2, 0, this.f36736h, 0, (bArr2.length - this.f36742n) - 1);
        o(i12, this.f36737i, 0);
        System.arraycopy(this.f36737i, 0, this.f36736h, (this.f36735g.length - this.f36742n) - 1, 4);
        byte[] bArr3 = this.f36736h;
        bArr3[bArr3.length - 1] = n(true, this.f36730b);
        this.f36729a.d(this.f36736h, 0, this.f36734f, 0);
        o(i11, this.f36737i, 0);
        if (i11 <= this.f36729a.c() - this.f36742n) {
            for (int i13 = 0; i13 < i11; i13++) {
                byte[] bArr4 = this.f36737i;
                int i14 = this.f36742n + i13;
                bArr4[i14] = (byte) (bArr4[i14] ^ bArr[i10 + i13]);
            }
            for (int i15 = 0; i15 < this.f36729a.c(); i15++) {
                byte[] bArr5 = this.f36734f;
                bArr5[i15] = (byte) (bArr5[i15] ^ this.f36737i[i15]);
            }
            org.bouncycastle.crypto.f fVar = this.f36729a;
            byte[] bArr6 = this.f36734f;
            fVar.d(bArr6, 0, bArr6, 0);
            return;
        }
        for (int i16 = 0; i16 < this.f36729a.c(); i16++) {
            byte[] bArr7 = this.f36734f;
            bArr7[i16] = (byte) (bArr7[i16] ^ this.f36737i[i16]);
        }
        org.bouncycastle.crypto.f fVar2 = this.f36729a;
        byte[] bArr8 = this.f36734f;
        fVar2.d(bArr8, 0, bArr8, 0);
        while (i11 != 0) {
            for (int i17 = 0; i17 < this.f36729a.c(); i17++) {
                byte[] bArr9 = this.f36734f;
                bArr9[i17] = (byte) (bArr9[i17] ^ bArr[i17 + i10]);
            }
            org.bouncycastle.crypto.f fVar3 = this.f36729a;
            byte[] bArr10 = this.f36734f;
            fVar3.d(bArr10, 0, bArr10, 0);
            i10 += this.f36729a.c();
            i11 -= this.f36729a.c();
        }
    }

    public int q(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) throws InvalidCipherTextException, IllegalStateException {
        int i13;
        if (bArr.length - i10 < i11) {
            throw new DataLengthException("input buffer too short");
        }
        if (bArr2.length - i12 < i11) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.f36740l.size() > 0) {
            if (this.f36731c) {
                p(this.f36740l.a(), 0, this.f36740l.size(), this.f36741m.size());
            } else {
                p(this.f36740l.a(), 0, this.f36740l.size(), this.f36741m.size() - this.f36730b);
            }
        }
        if (!this.f36731c) {
            if ((i11 - this.f36730b) % this.f36729a.c() != 0) {
                throw new DataLengthException("partial blocks not supported");
            }
            this.f36729a.d(this.f36735g, 0, this.f36738j, 0);
            int iC = i11 / this.f36729a.c();
            for (int i14 = 0; i14 < iC; i14++) {
                m(bArr, i10, i11, bArr2, i12);
                i10 += this.f36729a.c();
                i12 += this.f36729a.c();
            }
            if (i11 > i10) {
                int i15 = 0;
                while (true) {
                    byte[] bArr3 = this.f36739k;
                    if (i15 >= bArr3.length) {
                        break;
                    }
                    byte[] bArr4 = this.f36738j;
                    bArr4[i15] = (byte) (bArr4[i15] + bArr3[i15]);
                    i15++;
                }
                this.f36729a.d(this.f36738j, 0, this.f36737i, 0);
                int i16 = 0;
                while (true) {
                    i13 = this.f36730b;
                    if (i16 >= i13) {
                        break;
                    }
                    bArr2[i12 + i16] = (byte) (this.f36737i[i16] ^ bArr[i10 + i16]);
                    i16++;
                }
                i12 += i13;
            }
            int i17 = 0;
            while (true) {
                byte[] bArr5 = this.f36739k;
                if (i17 >= bArr5.length) {
                    break;
                }
                byte[] bArr6 = this.f36738j;
                bArr6[i17] = (byte) (bArr6[i17] + bArr5[i17]);
                i17++;
            }
            this.f36729a.d(this.f36738j, 0, this.f36737i, 0);
            int i18 = this.f36730b;
            System.arraycopy(bArr2, i12 - i18, this.f36737i, 0, i18);
            l(bArr2, 0, i12 - this.f36730b);
            System.arraycopy(this.f36734f, 0, this.f36733e, 0, this.f36730b);
            int i19 = this.f36730b;
            byte[] bArr7 = new byte[i19];
            System.arraycopy(this.f36737i, 0, bArr7, 0, i19);
            if (!org.bouncycastle.util.a.I(this.f36733e, bArr7)) {
                throw new InvalidCipherTextException("mac check failed");
            }
            reset();
            return i11 - this.f36730b;
        }
        if (i11 % this.f36729a.c() != 0) {
            throw new DataLengthException("partial blocks not supported");
        }
        l(bArr, i10, i11);
        this.f36729a.d(this.f36735g, 0, this.f36738j, 0);
        int iC2 = i11;
        while (iC2 > 0) {
            m(bArr, i10, i11, bArr2, i12);
            iC2 -= this.f36729a.c();
            i10 += this.f36729a.c();
            i12 += this.f36729a.c();
        }
        int i20 = 0;
        while (true) {
            byte[] bArr8 = this.f36739k;
            if (i20 >= bArr8.length) {
                break;
            }
            byte[] bArr9 = this.f36738j;
            bArr9[i20] = (byte) (bArr9[i20] + bArr8[i20]);
            i20++;
        }
        this.f36729a.d(this.f36738j, 0, this.f36737i, 0);
        int i21 = 0;
        while (true) {
            int i22 = this.f36730b;
            if (i21 >= i22) {
                System.arraycopy(this.f36734f, 0, this.f36733e, 0, i22);
                reset();
                return i11 + this.f36730b;
            }
            bArr2[i12 + i21] = (byte) (this.f36737i[i21] ^ this.f36734f[i21]);
            i21++;
        }
    }

    public final void r(int i10) {
        if (i10 != 4 && i10 != 6 && i10 != 8) {
            throw new IllegalArgumentException("Nb = 4 is recommended by DSTU7624 but can be changed to only 6 or 8 in this implementation");
        }
        this.f36742n = i10;
    }

    @Override // jp.b
    public void reset() {
        org.bouncycastle.util.a.d0(this.f36736h, (byte) 0);
        org.bouncycastle.util.a.d0(this.f36737i, (byte) 0);
        org.bouncycastle.util.a.d0(this.f36739k, (byte) 0);
        org.bouncycastle.util.a.d0(this.f36734f, (byte) 0);
        this.f36739k[0] = 1;
        this.f36741m.reset();
        this.f36740l.reset();
        byte[] bArr = this.f36732d;
        if (bArr != null) {
            k(bArr, 0, bArr.length);
        }
    }
}
