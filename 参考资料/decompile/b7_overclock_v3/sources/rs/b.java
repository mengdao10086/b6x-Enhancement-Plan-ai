package rs;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f49145a = 16;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f49146b = 65536;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f49147c = 32;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f49148d = 32;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f49149e = 13312;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f49150f = 32;

    public static void a(byte[] bArr, byte[] bArr2) {
        k.b(bArr, 0, 2097152L, bArr2, 0);
    }

    public static int b(a aVar, byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        byte[] bArr6 = new byte[2097152];
        byte[] bArr7 = new byte[4194272];
        a(bArr6, bArr3);
        for (int i11 = 0; i11 < 65536; i11++) {
            aVar.d(bArr7, (65535 + i11) * 32, bArr6, i11 * 32);
        }
        for (int i12 = 0; i12 < 16; i12++) {
            int i13 = 16 - i12;
            long j10 = (1 << i13) - 1;
            int i14 = 1 << (i13 - 1);
            long j11 = i14 - 1;
            int i15 = 0;
            while (i15 < i14) {
                aVar.c(bArr7, (int) ((((long) i15) + j11) * 32), bArr7, (int) ((((long) (i15 * 2)) + j10) * 32), bArr4, i12 * 2 * 32);
                i15++;
                i14 = i14;
                j11 = j11;
            }
        }
        int i16 = i10;
        int i17 = 2016;
        while (i17 < 4064) {
            bArr[i16] = bArr7[i17];
            i17++;
            i16++;
        }
        for (int i18 = 0; i18 < 32; i18++) {
            int i19 = i18 * 2;
            int i20 = (bArr5[i19] & 255) + ((bArr5[i19 + 1] & 255) << 8);
            int i21 = 0;
            while (i21 < 32) {
                bArr[i16] = bArr6[(i20 * 32) + i21];
                i21++;
                i16++;
            }
            int i22 = i20 + 65535;
            for (int i23 = 0; i23 < 10; i23++) {
                int i24 = (i22 & 1) != 0 ? i22 + 1 : i22 - 1;
                int i25 = 0;
                while (i25 < 32) {
                    bArr[i16] = bArr7[(i24 * 32) + i25];
                    i25++;
                    i16++;
                }
                i22 = (i24 - 1) / 2;
            }
        }
        for (int i26 = 0; i26 < 32; i26++) {
            bArr2[i26] = bArr7[i26];
        }
        return f49149e;
    }

    public static int c(a aVar, byte[] bArr, byte[] bArr2, int i10, byte[] bArr3, byte[] bArr4) {
        int i11;
        byte[] bArr5 = new byte[1024];
        int i12 = i10 + 2048;
        int i13 = 0;
        while (i13 < 32) {
            int i14 = i13 * 2;
            int i15 = (bArr4[i14] & 255) + ((bArr4[i14 + 1] & 255) << 8);
            if ((i15 & 1) == 0) {
                aVar.d(bArr5, 0, bArr2, i12);
                for (int i16 = 0; i16 < 32; i16++) {
                    bArr5[i16 + 32] = bArr2[i12 + 32 + i16];
                }
            } else {
                aVar.d(bArr5, 32, bArr2, i12);
                for (int i17 = 0; i17 < 32; i17++) {
                    bArr5[i17] = bArr2[i12 + 32 + i17];
                }
            }
            int i18 = i12 + 64;
            int i19 = 1;
            while (i19 < 10) {
                int i20 = i15 >>> 1;
                if ((i20 & 1) == 0) {
                    i11 = i19;
                    aVar.c(bArr5, 0, bArr5, 0, bArr3, (i19 - 1) * 2 * 32);
                    for (int i21 = 0; i21 < 32; i21++) {
                        bArr5[i21 + 32] = bArr2[i18 + i21];
                    }
                } else {
                    i11 = i19;
                    aVar.c(bArr5, 32, bArr5, 0, bArr3, (i11 - 1) * 2 * 32);
                    for (int i22 = 0; i22 < 32; i22++) {
                        bArr5[i22] = bArr2[i18 + i22];
                    }
                }
                i18 += 32;
                i19 = i11 + 1;
                i15 = i20;
            }
            int i23 = i15 >>> 1;
            aVar.c(bArr5, 0, bArr5, 0, bArr3, 576);
            for (int i24 = 0; i24 < 32; i24++) {
                if (bArr2[(i23 * 32) + i10 + i24] != bArr5[i24]) {
                    for (int i25 = 0; i25 < 32; i25++) {
                        bArr[i25] = 0;
                    }
                    return -1;
                }
            }
            i13++;
            i12 = i18;
        }
        for (int i26 = 0; i26 < 32; i26++) {
            aVar.c(bArr5, i26 * 32, bArr2, i10 + (i26 * 2 * 32), bArr3, 640);
        }
        for (int i27 = 0; i27 < 16; i27++) {
            aVar.c(bArr5, i27 * 32, bArr5, i27 * 2 * 32, bArr3, 704);
        }
        for (int i28 = 0; i28 < 8; i28++) {
            aVar.c(bArr5, i28 * 32, bArr5, i28 * 2 * 32, bArr3, 768);
        }
        for (int i29 = 0; i29 < 4; i29++) {
            aVar.c(bArr5, i29 * 32, bArr5, i29 * 2 * 32, bArr3, 832);
        }
        for (int i30 = 0; i30 < 2; i30++) {
            aVar.c(bArr5, i30 * 32, bArr5, i30 * 2 * 32, bArr3, 896);
        }
        aVar.c(bArr, 0, bArr5, 0, bArr3, 960);
        return 0;
    }
}
