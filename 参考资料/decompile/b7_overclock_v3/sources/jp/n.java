package jp;

import np.n1;
import np.v1;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;

/* JADX INFO: loaded from: classes5.dex */
public class n implements a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f36663y = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.bouncycastle.crypto.f f36664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public kp.d f36665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kp.c f36666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f36667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f36668e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f36669f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f36670g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f36671h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public byte[] f36672i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f36673j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public byte[] f36674k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public byte[] f36675l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f36676m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f36677n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public byte[] f36678o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public byte[] f36679p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public byte[] f36680q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f36681r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f36682s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f36683t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public byte[] f36684u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f36685v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f36686w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f36687x;

    public n(org.bouncycastle.crypto.f fVar) {
        this(fVar, null);
    }

    public n(org.bouncycastle.crypto.f fVar, kp.d dVar) {
        if (fVar.c() != 16) {
            throw new IllegalArgumentException("cipher required with a block size of 16.");
        }
        dVar = dVar == null ? new kp.g() : dVar;
        this.f36664a = fVar;
        this.f36665b = dVar;
    }

    @Override // jp.b
    public void a(boolean z10, org.bouncycastle.crypto.k kVar) throws IllegalArgumentException {
        byte[] bArrA;
        n1 n1VarB;
        byte[] bArr;
        this.f36667d = z10;
        this.f36676m = null;
        this.f36668e = true;
        if (kVar instanceof np.a) {
            np.a aVar = (np.a) kVar;
            bArrA = aVar.d();
            this.f36672i = aVar.a();
            int iC = aVar.c();
            if (iC < 32 || iC > 128 || iC % 8 != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + iC);
            }
            this.f36669f = iC / 8;
            n1VarB = aVar.b();
        } else {
            if (!(kVar instanceof v1)) {
                throw new IllegalArgumentException("invalid parameters passed to GCM");
            }
            v1 v1Var = (v1) kVar;
            bArrA = v1Var.a();
            this.f36672i = null;
            this.f36669f = 16;
            n1VarB = (n1) v1Var.b();
        }
        this.f36675l = new byte[z10 ? 16 : this.f36669f + 16];
        if (bArrA == null || bArrA.length < 1) {
            throw new IllegalArgumentException("IV must be at least 1 byte");
        }
        if (z10 && (bArr = this.f36671h) != null && org.bouncycastle.util.a.g(bArr, bArrA)) {
            if (n1VarB == null) {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
            byte[] bArr2 = this.f36670g;
            if (bArr2 != null && org.bouncycastle.util.a.g(bArr2, n1VarB.a())) {
                throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
        }
        this.f36671h = bArrA;
        if (n1VarB != null) {
            this.f36670g = n1VarB.a();
        }
        if (n1VarB != null) {
            this.f36664a.a(true, n1VarB);
            byte[] bArr3 = new byte[16];
            this.f36673j = bArr3;
            this.f36664a.d(bArr3, 0, bArr3, 0);
            this.f36665b.a(this.f36673j);
            this.f36666c = null;
        } else if (this.f36673j == null) {
            throw new IllegalArgumentException("Key must be specified in initial init");
        }
        byte[] bArr4 = new byte[16];
        this.f36674k = bArr4;
        byte[] bArr5 = this.f36671h;
        if (bArr5.length == 12) {
            System.arraycopy(bArr5, 0, bArr4, 0, bArr5.length);
            this.f36674k[15] = 1;
        } else {
            m(bArr4, bArr5, bArr5.length);
            byte[] bArr6 = new byte[16];
            org.bouncycastle.util.o.z(((long) this.f36671h.length) * 8, bArr6, 8);
            n(this.f36674k, bArr6);
        }
        this.f36677n = new byte[16];
        this.f36678o = new byte[16];
        this.f36679p = new byte[16];
        this.f36684u = new byte[16];
        this.f36685v = 0;
        this.f36686w = 0L;
        this.f36687x = 0L;
        this.f36680q = org.bouncycastle.util.a.p(this.f36674k);
        this.f36681r = -2;
        this.f36682s = 0;
        this.f36683t = 0L;
        byte[] bArr7 = this.f36672i;
        if (bArr7 != null) {
            k(bArr7, 0, bArr7.length);
        }
    }

    @Override // jp.b
    public String b() {
        return this.f36664a.b() + "/GCM";
    }

    @Override // jp.b
    public int c(byte[] bArr, int i10) throws InvalidCipherTextException, IllegalStateException {
        l();
        if (this.f36683t == 0) {
            r();
        }
        int i11 = this.f36682s;
        if (!this.f36667d) {
            int i12 = this.f36669f;
            if (i11 < i12) {
                throw new InvalidCipherTextException("data too short");
            }
            i11 -= i12;
            if (bArr.length - i10 < i11) {
                throw new OutputLengthException("Output buffer too short");
            }
        } else if (bArr.length - i10 < this.f36669f + i11) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (i11 > 0) {
            t(this.f36675l, 0, i11, bArr, i10);
        }
        long j10 = this.f36686w;
        int i13 = this.f36685v;
        long j11 = j10 + ((long) i13);
        this.f36686w = j11;
        if (j11 > this.f36687x) {
            if (i13 > 0) {
                p(this.f36678o, this.f36684u, 0, i13);
            }
            if (this.f36687x > 0) {
                kp.e.L(this.f36678o, this.f36679p);
            }
            long j12 = ((this.f36683t * 8) + 127) >>> 7;
            byte[] bArr2 = new byte[16];
            if (this.f36666c == null) {
                kp.a aVar = new kp.a();
                this.f36666c = aVar;
                aVar.a(this.f36673j);
            }
            this.f36666c.b(j12, bArr2);
            kp.e.q(this.f36678o, bArr2);
            kp.e.L(this.f36677n, this.f36678o);
        }
        byte[] bArr3 = new byte[16];
        org.bouncycastle.util.o.z(this.f36686w * 8, bArr3, 0);
        org.bouncycastle.util.o.z(this.f36683t * 8, bArr3, 8);
        n(this.f36677n, bArr3);
        byte[] bArr4 = new byte[16];
        this.f36664a.d(this.f36674k, 0, bArr4, 0);
        kp.e.L(bArr4, this.f36677n);
        int i14 = this.f36669f;
        byte[] bArr5 = new byte[i14];
        this.f36676m = bArr5;
        System.arraycopy(bArr4, 0, bArr5, 0, i14);
        if (this.f36667d) {
            System.arraycopy(this.f36676m, 0, bArr, i10 + this.f36682s, this.f36669f);
            i11 += this.f36669f;
        } else {
            int i15 = this.f36669f;
            byte[] bArr6 = new byte[i15];
            System.arraycopy(this.f36675l, i11, bArr6, 0, i15);
            if (!org.bouncycastle.util.a.I(this.f36676m, bArr6)) {
                throw new InvalidCipherTextException("mac check in GCM failed");
            }
        }
        u(false);
        return i11;
    }

    @Override // jp.b
    public byte[] d() {
        byte[] bArr = this.f36676m;
        return bArr == null ? new byte[this.f36669f] : org.bouncycastle.util.a.p(bArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034 A[LOOP:1: B:14:0x0032->B:15:0x0034, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    @Override // jp.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int e(byte[] r8, int r9, int r10, byte[] r11, int r12) throws org.bouncycastle.crypto.DataLengthException {
        /*
            r7 = this;
            r7.l()
            int r0 = r8.length
            int r0 = r0 - r9
            if (r0 < r10) goto L75
            boolean r0 = r7.f36667d
            r1 = 16
            r2 = 0
            if (r0 == 0) goto L4a
            int r0 = r7.f36682s
            if (r0 == 0) goto L31
        L12:
            if (r10 <= 0) goto L31
            int r10 = r10 + (-1)
            byte[] r0 = r7.f36675l
            int r3 = r7.f36682s
            int r4 = r9 + 1
            r9 = r8[r9]
            r0[r3] = r9
            int r3 = r3 + 1
            r7.f36682s = r3
            if (r3 != r1) goto L2f
            r7.s(r0, r2, r11, r12)
            r7.f36682s = r2
            r9 = r4
            r0 = 16
            goto L32
        L2f:
            r9 = r4
            goto L12
        L31:
            r0 = 0
        L32:
            if (r10 < r1) goto L40
            int r3 = r12 + r0
            r7.s(r8, r9, r11, r3)
            int r9 = r9 + 16
            int r10 = r10 + (-16)
            int r0 = r0 + 16
            goto L32
        L40:
            if (r10 <= 0) goto L74
            byte[] r11 = r7.f36675l
            java.lang.System.arraycopy(r8, r9, r11, r2, r10)
            r7.f36682s = r10
            goto L74
        L4a:
            r0 = 0
            r3 = 0
        L4c:
            if (r3 >= r10) goto L74
            byte[] r4 = r7.f36675l
            int r5 = r7.f36682s
            int r6 = r9 + r3
            r6 = r8[r6]
            r4[r5] = r6
            int r5 = r5 + 1
            r7.f36682s = r5
            int r6 = r4.length
            if (r5 != r6) goto L71
            int r5 = r12 + r0
            r7.s(r4, r2, r11, r5)
            byte[] r4 = r7.f36675l
            int r5 = r7.f36669f
            java.lang.System.arraycopy(r4, r1, r4, r2, r5)
            int r4 = r7.f36669f
            r7.f36682s = r4
            int r0 = r0 + 16
        L71:
            int r3 = r3 + 1
            goto L4c
        L74:
            return r0
        L75:
            org.bouncycastle.crypto.DataLengthException r8 = new org.bouncycastle.crypto.DataLengthException
            java.lang.String r9 = "Input buffer too short"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: jp.n.e(byte[], int, int, byte[], int):int");
    }

    @Override // jp.a
    public org.bouncycastle.crypto.f f() {
        return this.f36664a;
    }

    @Override // jp.b
    public int g(int i10) {
        int i11 = i10 + this.f36682s;
        if (!this.f36667d) {
            int i12 = this.f36669f;
            if (i11 < i12) {
                return 0;
            }
            i11 -= i12;
        }
        return i11 - (i11 % 16);
    }

    @Override // jp.b
    public int h(int i10) {
        int i11 = i10 + this.f36682s;
        if (this.f36667d) {
            return i11 + this.f36669f;
        }
        int i12 = this.f36669f;
        if (i11 < i12) {
            return 0;
        }
        return i11 - i12;
    }

    @Override // jp.b
    public int i(byte b10, byte[] bArr, int i10) throws DataLengthException {
        l();
        byte[] bArr2 = this.f36675l;
        int i11 = this.f36682s;
        bArr2[i11] = b10;
        int i12 = i11 + 1;
        this.f36682s = i12;
        if (i12 != bArr2.length) {
            return 0;
        }
        s(bArr2, 0, bArr, i10);
        if (this.f36667d) {
            this.f36682s = 0;
        } else {
            byte[] bArr3 = this.f36675l;
            System.arraycopy(bArr3, 16, bArr3, 0, this.f36669f);
            this.f36682s = this.f36669f;
        }
        return 16;
    }

    @Override // jp.b
    public void j(byte b10) {
        l();
        byte[] bArr = this.f36684u;
        int i10 = this.f36685v;
        bArr[i10] = b10;
        int i11 = i10 + 1;
        this.f36685v = i11;
        if (i11 == 16) {
            n(this.f36678o, bArr);
            this.f36685v = 0;
            this.f36686w += 16;
        }
    }

    @Override // jp.b
    public void k(byte[] bArr, int i10, int i11) {
        l();
        for (int i12 = 0; i12 < i11; i12++) {
            byte[] bArr2 = this.f36684u;
            int i13 = this.f36685v;
            bArr2[i13] = bArr[i10 + i12];
            int i14 = i13 + 1;
            this.f36685v = i14;
            if (i14 == 16) {
                n(this.f36678o, bArr2);
                this.f36685v = 0;
                this.f36686w += 16;
            }
        }
    }

    public final void l() {
        if (this.f36668e) {
            return;
        }
        if (!this.f36667d) {
            throw new IllegalStateException("GCM cipher needs to be initialised");
        }
        throw new IllegalStateException("GCM cipher cannot be reused for encryption");
    }

    public final void m(byte[] bArr, byte[] bArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11 += 16) {
            p(bArr, bArr2, i11, Math.min(i10 - i11, 16));
        }
    }

    public final void n(byte[] bArr, byte[] bArr2) {
        kp.e.L(bArr, bArr2);
        this.f36665b.b(bArr);
    }

    public final void o(byte[] bArr, byte[] bArr2, int i10) {
        kp.e.M(bArr, bArr2, i10);
        this.f36665b.b(bArr);
    }

    public final void p(byte[] bArr, byte[] bArr2, int i10, int i11) {
        kp.e.N(bArr, bArr2, i10, i11);
        this.f36665b.b(bArr);
    }

    public final void q(byte[] bArr) {
        int i10 = this.f36681r;
        if (i10 == 0) {
            throw new IllegalStateException("Attempt to process too many blocks");
        }
        this.f36681r = i10 - 1;
        byte[] bArr2 = this.f36680q;
        int i11 = (bArr2[15] & 255) + 1;
        bArr2[15] = (byte) i11;
        int i12 = (i11 >>> 8) + (bArr2[14] & 255);
        bArr2[14] = (byte) i12;
        int i13 = (i12 >>> 8) + (bArr2[13] & 255);
        bArr2[13] = (byte) i13;
        bArr2[12] = (byte) ((i13 >>> 8) + (bArr2[12] & 255));
        this.f36664a.d(bArr2, 0, bArr, 0);
    }

    public final void r() {
        if (this.f36686w > 0) {
            System.arraycopy(this.f36678o, 0, this.f36679p, 0, 16);
            this.f36687x = this.f36686w;
        }
        int i10 = this.f36685v;
        if (i10 > 0) {
            p(this.f36679p, this.f36684u, 0, i10);
            this.f36687x += (long) this.f36685v;
        }
        if (this.f36687x > 0) {
            System.arraycopy(this.f36679p, 0, this.f36677n, 0, 16);
        }
    }

    @Override // jp.b
    public void reset() {
        u(true);
    }

    public final void s(byte[] bArr, int i10, byte[] bArr2, int i11) {
        if (bArr2.length - i11 < 16) {
            throw new OutputLengthException("Output buffer too short");
        }
        if (this.f36683t == 0) {
            r();
        }
        byte[] bArr3 = new byte[16];
        q(bArr3);
        if (this.f36667d) {
            kp.e.M(bArr3, bArr, i10);
            n(this.f36677n, bArr3);
            System.arraycopy(bArr3, 0, bArr2, i11, 16);
        } else {
            o(this.f36677n, bArr, i10);
            kp.e.K(bArr3, 0, bArr, i10, bArr2, i11);
        }
        this.f36683t += 16;
    }

    public final void t(byte[] bArr, int i10, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = new byte[16];
        q(bArr3);
        if (this.f36667d) {
            kp.e.J(bArr, i10, bArr3, 0, i11);
            p(this.f36677n, bArr, i10, i11);
        } else {
            p(this.f36677n, bArr, i10, i11);
            kp.e.J(bArr, i10, bArr3, 0, i11);
        }
        System.arraycopy(bArr, i10, bArr2, i12, i11);
        this.f36683t += (long) i11;
    }

    public final void u(boolean z10) {
        this.f36664a.reset();
        this.f36677n = new byte[16];
        this.f36678o = new byte[16];
        this.f36679p = new byte[16];
        this.f36684u = new byte[16];
        this.f36685v = 0;
        this.f36686w = 0L;
        this.f36687x = 0L;
        this.f36680q = org.bouncycastle.util.a.p(this.f36674k);
        this.f36681r = -2;
        this.f36682s = 0;
        this.f36683t = 0L;
        byte[] bArr = this.f36675l;
        if (bArr != null) {
            org.bouncycastle.util.a.d0(bArr, (byte) 0);
        }
        if (z10) {
            this.f36676m = null;
        }
        if (this.f36667d) {
            this.f36668e = false;
            return;
        }
        byte[] bArr2 = this.f36672i;
        if (bArr2 != null) {
            k(bArr2, 0, bArr2.length);
        }
    }
}
