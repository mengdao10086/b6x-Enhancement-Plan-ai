package ab;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.uc.crashsdk.export.LogType;
import g.p0;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f491a = 192000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f492b = 2250000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f493c = 2147385345;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f494d = 536864768;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f495e = -25230976;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f496f = -14745368;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte f497g = 127;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f498h = 31;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte f499i = -2;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte f500j = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f501k = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int[] f502l = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, com.google.android.exoplayer2.source.u.f18441j, -1, -1, 12000, 24000, y.f524a, -1, -1};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int[] f503m = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, LogType.UNEXP_LOW_MEMORY, 2560, 2688, ob.m.f43252i, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    /* JADX WARN: Removed duplicated region for block: B:15:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(byte[] r7) {
        /*
            r0 = 0
            r1 = r7[r0]
            r2 = -2
            r3 = 6
            r4 = 7
            r5 = 1
            r6 = 4
            if (r1 == r2) goto L4a
            r2 = -1
            if (r1 == r2) goto L32
            r2 = 31
            if (r1 == r2) goto L21
            r1 = 5
            r1 = r7[r1]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r4]
            goto L58
        L21:
            r0 = r7[r3]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 8
            r7 = r7[r1]
            goto L42
        L32:
            r0 = r7[r4]
            r0 = r0 & 3
            int r0 = r0 << 12
            r1 = r7[r3]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << r6
            r0 = r0 | r1
            r1 = 9
            r7 = r7[r1]
        L42:
            r7 = r7 & 60
            int r7 = r7 >> 2
            r7 = r7 | r0
            int r7 = r7 + r5
            r0 = 1
            goto L5d
        L4a:
            r1 = r7[r6]
            r1 = r1 & 3
            int r1 = r1 << 12
            r2 = r7[r4]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r6
            r1 = r1 | r2
            r7 = r7[r3]
        L58:
            r7 = r7 & 240(0xf0, float:3.36E-43)
            int r7 = r7 >> r6
            r7 = r7 | r1
            int r7 = r7 + r5
        L5d:
            if (r0 == 0) goto L63
            int r7 = r7 * 16
            int r7 = r7 / 14
        L63:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ab.w.a(byte[]):int");
    }

    public static hd.b0 b(byte[] bArr) {
        if (bArr[0] == 127) {
            return new hd.b0(bArr);
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        if (c(bArrCopyOf)) {
            for (int i10 = 0; i10 < bArrCopyOf.length - 1; i10 += 2) {
                byte b10 = bArrCopyOf[i10];
                int i11 = i10 + 1;
                bArrCopyOf[i10] = bArrCopyOf[i11];
                bArrCopyOf[i11] = b10;
            }
        }
        hd.b0 b0Var = new hd.b0(bArrCopyOf);
        if (bArrCopyOf[0] == 31) {
            hd.b0 b0Var2 = new hd.b0(bArrCopyOf);
            while (b0Var2.b() >= 16) {
                b0Var2.s(2);
                b0Var.f(b0Var2.h(14), 14);
            }
        }
        b0Var.o(bArrCopyOf);
        return b0Var;
    }

    public static boolean c(byte[] bArr) {
        return bArr[0] == -2 || bArr[0] == -1;
    }

    public static boolean d(int i10) {
        return i10 == 2147385345 || i10 == -25230976 || i10 == 536864768 || i10 == -14745368;
    }

    public static int e(ByteBuffer byteBuffer) {
        int i10;
        byte b10;
        int i11;
        byte b11;
        int iPosition = byteBuffer.position();
        byte b12 = byteBuffer.get(iPosition);
        if (b12 != -2) {
            if (b12 == -1) {
                i10 = (byteBuffer.get(iPosition + 4) & 7) << 4;
                b11 = byteBuffer.get(iPosition + 7);
            } else if (b12 != 31) {
                i10 = (byteBuffer.get(iPosition + 4) & 1) << 6;
                b10 = byteBuffer.get(iPosition + 5);
            } else {
                i10 = (byteBuffer.get(iPosition + 5) & 7) << 4;
                b11 = byteBuffer.get(iPosition + 6);
            }
            i11 = b11 & 60;
            return (((i11 >> 2) | i10) + 1) * 32;
        }
        i10 = (byteBuffer.get(iPosition + 5) & 1) << 6;
        b10 = byteBuffer.get(iPosition + 4);
        i11 = b10 & 252;
        return (((i11 >> 2) | i10) + 1) * 32;
    }

    public static int f(byte[] bArr) {
        int i10;
        byte b10;
        int i11;
        byte b11;
        byte b12 = bArr[0];
        if (b12 != -2) {
            if (b12 == -1) {
                i10 = (bArr[4] & 7) << 4;
                b11 = bArr[7];
            } else if (b12 != 31) {
                i10 = (bArr[4] & 1) << 6;
                b10 = bArr[5];
            } else {
                i10 = (bArr[5] & 7) << 4;
                b11 = bArr[6];
            }
            i11 = b11 & 60;
            return (((i11 >> 2) | i10) + 1) * 32;
        }
        i10 = (bArr[5] & 1) << 6;
        b10 = bArr[4];
        i11 = b10 & 252;
        return (((i11 >> 2) | i10) + 1) * 32;
    }

    public static Format g(byte[] bArr, @p0 String str, @p0 String str2, @p0 DrmInitData drmInitData) {
        hd.b0 b0VarB = b(bArr);
        b0VarB.s(60);
        int i10 = f501k[b0VarB.h(6)];
        int i11 = f502l[b0VarB.h(4)];
        int iH = b0VarB.h(5);
        int[] iArr = f503m;
        int i12 = iH >= iArr.length ? -1 : (iArr[iH] * 1000) / 2;
        b0VarB.s(10);
        return new Format.b().S(str).e0(hd.w.O).G(i12).H(i10 + (b0VarB.h(2) > 0 ? 1 : 0)).f0(i11).L(drmInitData).V(str2).E();
    }
}
