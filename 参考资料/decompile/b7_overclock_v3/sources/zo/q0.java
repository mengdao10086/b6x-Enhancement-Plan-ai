package zo;

import com.arialyy.aria.core.command.NormalCmdFactory;
import com.arialyy.aria.core.listener.ISchedulers;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.math.DoubleMath;
import v7.a;

/* JADX INFO: loaded from: classes5.dex */
public final class q0 implements org.bouncycastle.crypto.v, org.bouncycastle.util.m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f59437j = 64;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f59438k = 64;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f59439l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f59440m = 285;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f59441n = {24, 35, 198, 232, 135, 184, 1, 79, 54, 166, ISchedulers.IS_M3U8_PEER, 245, 121, 111, 145, 82, 96, 188, 155, 142, 163, 12, 123, 53, 29, 224, mb.e.f41076x1, 194, 46, 75, 254, 87, 21, 119, 55, 229, 159, 240, 74, 218, 88, 201, 41, 10, 177, 160, 107, 133, rb.a0.f47918w, 93, 16, 244, a.c.f52773i, 62, 5, 103, 228, 39, 65, 139, 167, 125, WaspWingInfo.COLD_LEVEL_STANDARD_B7, 216, mb.e.f41067u1, mb.e.f41061s1, 124, 102, 221, 23, 71, 158, a.c.f52772h, 45, 191, 7, WaspWingInfo.DEFAULT_COLD_LEVEL_OVERCLOCK_MIN, 90, 131, 51, 99, 2, DoubleMath.MAX_FACTORIAL, 113, 200, 25, 73, 217, m9.m.f40854e0, 227, 91, 136, 154, 38, 50, 176, 233, 15, 213, 128, 190, 205, 52, 72, 255, 122, 144, 95, 32, 104, 26, mb.e.f41073w1, 180, 84, uf.c.Ya, 34, 100, 241, 115, 18, 64, 8, 195, 236, 219, 161, 141, 61, rc.c.f48463k0, 0, a.c.f52776l, 43, 118, 130, 214, 27, 181, HideBottomViewOnScrollBehavior.f19616g, 106, 80, 69, 243, 48, 239, 63, 85, 162, 234, 101, 186, 47, 192, 222, 28, 253, 77, 146, 117, 6, 138, 178, WaspWingInfo.EXPERIMENTAL_RUN_MODE_COLD_LEVEL, 14, 31, 98, 212, os.a.f46207a, 150, a4.d.f205j, 197, 37, 89, 132, 114, 57, 76, 94, 120, 56, 140, 209, 165, 226, 97, 179, 33, 156, 30, 67, 199, 252, 4, 81, 153, 109, 13, 250, 223, 126, 36, 59, 171, a.c.f52775k, 17, 143, 78, 183, 235, 60, 129, com.google.zxing.oned.d.f21430g, 247, NormalCmdFactory.TASK_CANCEL_ALL, 19, 44, hr.a.f31427a, mb.e.f41040l1, 110, 196, 3, 86, 68, 127, ob.h.H, 42, mb.e.f41031i2, s0.c.f49294u, 83, 220, 11, 157, 108, 49, 116, 246, 70, rb.h0.K, 137, 20, 225, 22, 58, 105, 9, 112, 182, 208, 237, a.c.f52774j, 66, rc.c.f48464l0, ISchedulers.SUB_CANCEL, 40, 92, 248, 134};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long[] f59442o = new long[256];

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final long[] f59443p = new long[256];

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final long[] f59444q = new long[256];

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final long[] f59445r = new long[256];

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final long[] f59446s = new long[256];

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final long[] f59447t = new long[256];

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final long[] f59448u = new long[256];

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final long[] f59449v = new long[256];

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f59450w = 32;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final short[] f59451x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f59452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f59453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f59454c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public short[] f59455d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long[] f59456e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long[] f59457f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long[] f59458g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long[] f59459h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long[] f59460i;

    static {
        short[] sArr = new short[32];
        f59451x = sArr;
        sArr[31] = 8;
    }

    public q0() {
        this.f59452a = new long[11];
        this.f59453b = new byte[64];
        this.f59454c = 0;
        this.f59455d = new short[32];
        this.f59456e = new long[8];
        this.f59457f = new long[8];
        this.f59458g = new long[8];
        this.f59459h = new long[8];
        this.f59460i = new long[8];
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = f59441n[i10];
            int iO = o(i11 << 1);
            int iO2 = o(iO << 1);
            int i12 = iO2 ^ i11;
            int iO3 = o(iO2 << 1);
            int i13 = iO3 ^ i11;
            f59442o[i10] = p(i11, i11, iO2, i11, iO3, i12, iO, i13);
            f59443p[i10] = p(i13, i11, i11, iO2, i11, iO3, i12, iO);
            f59444q[i10] = p(iO, i13, i11, i11, iO2, i11, iO3, i12);
            f59445r[i10] = p(i12, iO, i13, i11, i11, iO2, i11, iO3);
            f59446s[i10] = p(iO3, i12, iO, i13, i11, i11, iO2, i11);
            f59447t[i10] = p(i11, iO3, i12, iO, i13, i11, i11, iO2);
            f59448u[i10] = p(iO2, i11, iO3, i12, iO, i13, i11, i11);
            f59449v[i10] = p(i11, iO2, i11, iO3, i12, iO, i13, i11);
        }
        this.f59452a[0] = 0;
        for (int i14 = 1; i14 <= 10; i14++) {
            int i15 = (i14 - 1) * 8;
            this.f59452a[i14] = (((((((f59442o[i15] & (-72057594037927936L)) ^ (f59443p[i15 + 1] & 71776119061217280L)) ^ (f59444q[i15 + 2] & 280375465082880L)) ^ (f59445r[i15 + 3] & 1095216660480L)) ^ (f59446s[i15 + 4] & 4278190080L)) ^ (f59447t[i15 + 5] & 16711680)) ^ (f59448u[i15 + 6] & 65280)) ^ (f59449v[i15 + 7] & 255);
        }
    }

    public q0(q0 q0Var) {
        this.f59452a = new long[11];
        this.f59453b = new byte[64];
        this.f59454c = 0;
        this.f59455d = new short[32];
        this.f59456e = new long[8];
        this.f59457f = new long[8];
        this.f59458g = new long[8];
        this.f59459h = new long[8];
        this.f59460i = new long[8];
        i(q0Var);
    }

    public final long a(byte[] bArr, int i10) {
        return (((long) bArr[i10 + 7]) & 255) | ((((long) bArr[i10 + 0]) & 255) << 56) | ((((long) bArr[i10 + 1]) & 255) << 48) | ((((long) bArr[i10 + 2]) & 255) << 40) | ((((long) bArr[i10 + 3]) & 255) << 32) | ((((long) bArr[i10 + 4]) & 255) << 24) | ((((long) bArr[i10 + 5]) & 255) << 16) | ((((long) bArr[i10 + 6]) & 255) << 8);
    }

    @Override // org.bouncycastle.crypto.s
    public String b() {
        return "Whirlpool";
    }

    @Override // org.bouncycastle.crypto.s
    public int c(byte[] bArr, int i10) {
        m();
        for (int i11 = 0; i11 < 8; i11++) {
            k(this.f59456e[i11], bArr, (i11 * 8) + i10);
        }
        reset();
        return h();
    }

    @Override // org.bouncycastle.util.m
    public org.bouncycastle.util.m d() {
        return new q0(this);
    }

    @Override // org.bouncycastle.crypto.v
    public int g() {
        return 64;
    }

    @Override // org.bouncycastle.crypto.s
    public int h() {
        return 64;
    }

    @Override // org.bouncycastle.util.m
    public void i(org.bouncycastle.util.m mVar) {
        q0 q0Var = (q0) mVar;
        long[] jArr = q0Var.f59452a;
        long[] jArr2 = this.f59452a;
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        byte[] bArr = q0Var.f59453b;
        byte[] bArr2 = this.f59453b;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f59454c = q0Var.f59454c;
        short[] sArr = q0Var.f59455d;
        short[] sArr2 = this.f59455d;
        System.arraycopy(sArr, 0, sArr2, 0, sArr2.length);
        long[] jArr3 = q0Var.f59456e;
        long[] jArr4 = this.f59456e;
        System.arraycopy(jArr3, 0, jArr4, 0, jArr4.length);
        long[] jArr5 = q0Var.f59457f;
        long[] jArr6 = this.f59457f;
        System.arraycopy(jArr5, 0, jArr6, 0, jArr6.length);
        long[] jArr7 = q0Var.f59458g;
        long[] jArr8 = this.f59458g;
        System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
        long[] jArr9 = q0Var.f59459h;
        long[] jArr10 = this.f59459h;
        System.arraycopy(jArr9, 0, jArr10, 0, jArr10.length);
        long[] jArr11 = q0Var.f59460i;
        long[] jArr12 = this.f59460i;
        System.arraycopy(jArr11, 0, jArr12, 0, jArr12.length);
    }

    public final void k(long j10, byte[] bArr, int i10) {
        for (int i11 = 0; i11 < 8; i11++) {
            bArr[i10 + i11] = (byte) ((j10 >> (56 - (i11 * 8))) & 255);
        }
    }

    public final byte[] l() {
        byte[] bArr = new byte[32];
        for (int i10 = 0; i10 < 32; i10++) {
            bArr[i10] = (byte) (this.f59455d[i10] & 255);
        }
        return bArr;
    }

    public final void m() {
        byte[] bArrL = l();
        byte[] bArr = this.f59453b;
        int i10 = this.f59454c;
        int i11 = i10 + 1;
        this.f59454c = i11;
        bArr[i10] = (byte) (bArr[i10] | 128);
        if (i11 == bArr.length) {
            r(bArr, 0);
        }
        if (this.f59454c > 32) {
            while (this.f59454c != 0) {
                update((byte) 0);
            }
        }
        while (this.f59454c <= 32) {
            update((byte) 0);
        }
        System.arraycopy(bArrL, 0, this.f59453b, 32, bArrL.length);
        r(this.f59453b, 0);
    }

    public final void n() {
        int i10 = 0;
        for (int length = this.f59455d.length - 1; length >= 0; length--) {
            short[] sArr = this.f59455d;
            int i11 = (sArr[length] & 255) + f59451x[length] + i10;
            i10 = i11 >>> 8;
            sArr[length] = (short) (i11 & 255);
        }
    }

    public final int o(int i10) {
        return ((long) i10) >= 256 ? i10 ^ f59440m : i10;
    }

    public final long p(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        return (((((((((long) i11) << 48) ^ (((long) i10) << 56)) ^ (((long) i12) << 40)) ^ (((long) i13) << 32)) ^ (((long) i14) << 24)) ^ (((long) i15) << 16)) ^ (((long) i16) << 8)) ^ ((long) i17);
    }

    public void q() {
        long[] jArr;
        for (int i10 = 0; i10 < 8; i10++) {
            long[] jArr2 = this.f59460i;
            long j10 = this.f59459h[i10];
            long[] jArr3 = this.f59457f;
            long j11 = this.f59456e[i10];
            jArr3[i10] = j11;
            jArr2[i10] = j10 ^ j11;
        }
        int i11 = 1;
        while (i11 <= 10) {
            int i12 = 0;
            while (i12 < 8) {
                long[] jArr4 = this.f59458g;
                jArr4[i12] = 0;
                long j12 = jArr4[i12];
                long[] jArr5 = f59442o;
                long[] jArr6 = this.f59457f;
                jArr4[i12] = jArr5[((int) (jArr6[(i12 + 0) & 7] >>> 56)) & 255] ^ j12;
                jArr4[i12] = jArr4[i12] ^ f59443p[((int) (jArr6[(i12 - 1) & 7] >>> 48)) & 255];
                jArr4[i12] = jArr4[i12] ^ f59444q[((int) (jArr6[(i12 - 2) & 7] >>> 40)) & 255];
                jArr4[i12] = jArr4[i12] ^ f59445r[((int) (jArr6[(i12 - 3) & 7] >>> 32)) & 255];
                jArr4[i12] = jArr4[i12] ^ f59446s[((int) (jArr6[(i12 - 4) & 7] >>> 24)) & 255];
                jArr4[i12] = jArr4[i12] ^ f59447t[((int) (jArr6[(i12 - 5) & 7] >>> 16)) & 255];
                jArr4[i12] = jArr4[i12] ^ f59448u[((int) (jArr6[(i12 - 6) & 7] >>> 8)) & 255];
                jArr4[i12] = jArr4[i12] ^ f59449v[((int) jArr6[(i12 - 7) & 7]) & 255];
                i12++;
                i11 = i11;
            }
            int i13 = i11;
            long[] jArr7 = this.f59458g;
            long[] jArr8 = this.f59457f;
            System.arraycopy(jArr7, 0, jArr8, 0, jArr8.length);
            long[] jArr9 = this.f59457f;
            jArr9[0] = jArr9[0] ^ this.f59452a[i13];
            int i14 = 0;
            while (true) {
                jArr = this.f59458g;
                if (i14 < 8) {
                    jArr[i14] = this.f59457f[i14];
                    long j13 = jArr[i14];
                    long[] jArr10 = f59442o;
                    long[] jArr11 = this.f59460i;
                    jArr[i14] = j13 ^ jArr10[((int) (jArr11[(i14 + 0) & 7] >>> 56)) & 255];
                    jArr[i14] = jArr[i14] ^ f59443p[((int) (jArr11[(i14 - 1) & 7] >>> 48)) & 255];
                    jArr[i14] = jArr[i14] ^ f59444q[((int) (jArr11[(i14 - 2) & 7] >>> 40)) & 255];
                    jArr[i14] = jArr[i14] ^ f59445r[((int) (jArr11[(i14 - 3) & 7] >>> 32)) & 255];
                    jArr[i14] = jArr[i14] ^ f59446s[((int) (jArr11[(i14 - 4) & 7] >>> 24)) & 255];
                    jArr[i14] = jArr[i14] ^ f59447t[((int) (jArr11[(i14 - 5) & 7] >>> 16)) & 255];
                    jArr[i14] = jArr[i14] ^ f59448u[((int) (jArr11[(i14 - 6) & 7] >>> 8)) & 255];
                    jArr[i14] = jArr[i14] ^ f59449v[((int) jArr11[(i14 - 7) & 7]) & 255];
                    i14++;
                }
            }
            long[] jArr12 = this.f59460i;
            System.arraycopy(jArr, 0, jArr12, 0, jArr12.length);
            i11 = i13 + 1;
        }
        for (int i15 = 0; i15 < 8; i15++) {
            long[] jArr13 = this.f59456e;
            jArr13[i15] = jArr13[i15] ^ (this.f59460i[i15] ^ this.f59459h[i15]);
        }
    }

    public final void r(byte[] bArr, int i10) {
        for (int i11 = 0; i11 < this.f59460i.length; i11++) {
            this.f59459h[i11] = a(this.f59453b, i11 * 8);
        }
        q();
        this.f59454c = 0;
        org.bouncycastle.util.a.d0(this.f59453b, (byte) 0);
    }

    @Override // org.bouncycastle.crypto.s
    public void reset() {
        this.f59454c = 0;
        org.bouncycastle.util.a.o0(this.f59455d, (short) 0);
        org.bouncycastle.util.a.d0(this.f59453b, (byte) 0);
        org.bouncycastle.util.a.k0(this.f59456e, 0L);
        org.bouncycastle.util.a.k0(this.f59457f, 0L);
        org.bouncycastle.util.a.k0(this.f59458g, 0L);
        org.bouncycastle.util.a.k0(this.f59459h, 0L);
        org.bouncycastle.util.a.k0(this.f59460i, 0L);
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte b10) {
        byte[] bArr = this.f59453b;
        int i10 = this.f59454c;
        bArr[i10] = b10;
        int i11 = i10 + 1;
        this.f59454c = i11;
        if (i11 == bArr.length) {
            r(bArr, 0);
        }
        n();
    }

    @Override // org.bouncycastle.crypto.s
    public void update(byte[] bArr, int i10, int i11) {
        while (i11 > 0) {
            update(bArr[i10]);
            i10++;
            i11--;
        }
    }
}
