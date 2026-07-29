package ab;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import g.p0;
import hd.c0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f405a = 44096;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f406b = 44097;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f407c = 336000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f408d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f409e = 7;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f410f = 16;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f411g = {2002, 2000, 1920, gg.b.Z1, 1600, 1001, 1000, 960, gg.b.f29491t1, gg.b.f29491t1, 480, 400, 400, 2048};

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f415d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f416e;

        public b(int i10, int i11, int i12, int i13, int i14) {
            this.f412a = i10;
            this.f414c = i11;
            this.f413b = i12;
            this.f415d = i13;
            this.f416e = i14;
        }
    }

    public static void a(int i10, c0 c0Var) {
        c0Var.O(7);
        byte[] bArrD = c0Var.d();
        bArrD[0] = -84;
        bArrD[1] = 64;
        bArrD[2] = -1;
        bArrD[3] = -1;
        bArrD[4] = (byte) ((i10 >> 16) & 255);
        bArrD[5] = (byte) ((i10 >> 8) & 255);
        bArrD[6] = (byte) (i10 & 255);
    }

    public static Format b(c0 c0Var, String str, String str2, @p0 DrmInitData drmInitData) {
        c0Var.T(1);
        return new Format.b().S(str).e0(hd.w.M).H(2).f0(((c0Var.G() & 32) >> 5) == 1 ? y.f524a : com.google.android.exoplayer2.source.u.f18441j).L(drmInitData).V(str2).E();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        int iPosition = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(iPosition);
        return d(new hd.b0(bArr)).f416e;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static ab.c.b d(hd.b0 r10) {
        /*
            r0 = 16
            int r1 = r10.h(r0)
            int r0 = r10.h(r0)
            r2 = 4
            r3 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r3) goto L18
            r0 = 24
            int r0 = r10.h(r0)
            r3 = 7
            goto L19
        L18:
            r3 = 4
        L19:
            int r0 = r0 + r3
            r3 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r3) goto L21
            int r0 = r0 + 2
        L21:
            r7 = r0
            r0 = 2
            int r1 = r10.h(r0)
            r3 = 3
            if (r1 != r3) goto L2f
            int r4 = f(r10, r0)
            int r1 = r1 + r4
        L2f:
            r4 = r1
            r1 = 10
            int r1 = r10.h(r1)
            boolean r5 = r10.g()
            if (r5 == 0) goto L45
            int r5 = r10.h(r3)
            if (r5 <= 0) goto L45
            r10.s(r0)
        L45:
            boolean r5 = r10.g()
            r6 = 48000(0xbb80, float:6.7262E-41)
            r8 = 44100(0xac44, float:6.1797E-41)
            if (r5 == 0) goto L55
            r9 = 48000(0xbb80, float:6.7262E-41)
            goto L58
        L55:
            r9 = 44100(0xac44, float:6.1797E-41)
        L58:
            int r10 = r10.h(r2)
            r5 = 0
            if (r9 != r8) goto L69
            r8 = 13
            if (r10 != r8) goto L69
            int[] r0 = ab.c.f411g
            r10 = r0[r10]
            r8 = r10
            goto L99
        L69:
            if (r9 != r6) goto L98
            int[] r6 = ab.c.f411g
            int r8 = r6.length
            if (r10 >= r8) goto L98
            r5 = r6[r10]
            int r1 = r1 % 5
            r6 = 8
            r8 = 1
            if (r1 == r8) goto L8e
            r8 = 11
            if (r1 == r0) goto L89
            if (r1 == r3) goto L8e
            if (r1 == r2) goto L82
            goto L93
        L82:
            if (r10 == r3) goto L95
            if (r10 == r6) goto L95
            if (r10 != r8) goto L93
            goto L95
        L89:
            if (r10 == r6) goto L95
            if (r10 != r8) goto L93
            goto L95
        L8e:
            if (r10 == r3) goto L95
            if (r10 != r6) goto L93
            goto L95
        L93:
            r8 = r5
            goto L99
        L95:
            int r5 = r5 + 1
            goto L93
        L98:
            r8 = 0
        L99:
            ab.c$b r10 = new ab.c$b
            r5 = 2
            r0 = 0
            r3 = r10
            r6 = r9
            r9 = r0
            r3.<init>(r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: ab.c.d(hd.b0):ab.c$b");
    }

    public static int e(byte[] bArr, int i10) {
        int i11 = 7;
        if (bArr.length < 7) {
            return -1;
        }
        int i12 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        if (i12 == 65535) {
            i12 = ((bArr[4] & 255) << 16) | ((bArr[5] & 255) << 8) | (bArr[6] & 255);
        } else {
            i11 = 4;
        }
        if (i10 == 44097) {
            i11 += 2;
        }
        return i12 + i11;
    }

    public static int f(hd.b0 b0Var, int i10) {
        int i11 = 0;
        while (true) {
            int iH = i11 + b0Var.h(i10);
            if (!b0Var.g()) {
                return iH;
            }
            i11 = (iH + 1) << i10;
        }
    }
}
