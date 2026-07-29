package ns;

import java.security.SecureRandom;
import zo.g0;

/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f42659a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f42660b = 32;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f42661c = 1024;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f42662d = 1824;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f42663e = 2048;

    public static void a(short[] sArr, byte[] bArr, byte[] bArr2) {
        m.b(sArr, bArr2);
        System.arraycopy(bArr2, 1792, bArr, 0, 32);
    }

    public static void b(short[] sArr, short[] sArr2, byte[] bArr) {
        m.b(sArr, bArr);
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = i10 * 4;
            int i12 = bArr[i10 + 1792] & 255;
            sArr2[i11 + 0] = (short) (i12 & 3);
            sArr2[i11 + 1] = (short) ((i12 >>> 2) & 3);
            sArr2[i11 + 2] = (short) ((i12 >>> 4) & 3);
            sArr2[i11 + 3] = (short) (i12 >>> 6);
        }
    }

    public static void c(byte[] bArr, short[] sArr, byte[] bArr2) {
        m.g(bArr, sArr);
        System.arraycopy(bArr2, 0, bArr, 1792, 32);
    }

    public static void d(byte[] bArr, short[] sArr, short[] sArr2) {
        m.g(bArr, sArr);
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = i10 * 4;
            bArr[i10 + 1792] = (byte) ((sArr2[i11 + 3] << 6) | sArr2[i11] | (sArr2[i11 + 1] << 2) | (sArr2[i11 + 2] << 4));
        }
    }

    public static void e(short[] sArr, byte[] bArr) {
        m.i(sArr, bArr);
    }

    public static void f(SecureRandom secureRandom, byte[] bArr, short[] sArr) {
        byte[] bArr2 = new byte[32];
        secureRandom.nextBytes(bArr2);
        g(bArr2);
        short[] sArr2 = new short[1024];
        e(sArr2, bArr2);
        byte[] bArr3 = new byte[32];
        secureRandom.nextBytes(bArr3);
        m.d(sArr, bArr3, (byte) 0);
        m.h(sArr);
        short[] sArr3 = new short[1024];
        m.d(sArr3, bArr3, (byte) 1);
        m.h(sArr3);
        short[] sArr4 = new short[1024];
        m.f(sArr2, sArr, sArr4);
        short[] sArr5 = new short[1024];
        m.a(sArr4, sArr3, sArr5);
        c(bArr, sArr5, bArr2);
    }

    public static void g(byte[] bArr) {
        g0 g0Var = new g0(256);
        g0Var.update(bArr, 0, 32);
        g0Var.c(bArr, 0);
    }

    public static void h(byte[] bArr, short[] sArr, byte[] bArr2) {
        short[] sArr2 = new short[1024];
        short[] sArr3 = new short[1024];
        b(sArr2, sArr3, bArr2);
        short[] sArr4 = new short[1024];
        m.f(sArr, sArr2, sArr4);
        m.c(sArr4);
        b.f(bArr, sArr4, sArr3);
        g(bArr);
    }

    public static void i(SecureRandom secureRandom, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        short[] sArr = new short[1024];
        byte[] bArr4 = new byte[32];
        a(sArr, bArr4, bArr3);
        short[] sArr2 = new short[1024];
        e(sArr2, bArr4);
        byte[] bArr5 = new byte[32];
        secureRandom.nextBytes(bArr5);
        short[] sArr3 = new short[1024];
        m.d(sArr3, bArr5, (byte) 0);
        m.h(sArr3);
        short[] sArr4 = new short[1024];
        m.d(sArr4, bArr5, (byte) 1);
        m.h(sArr4);
        short[] sArr5 = new short[1024];
        m.f(sArr2, sArr3, sArr5);
        m.a(sArr5, sArr4, sArr5);
        short[] sArr6 = new short[1024];
        m.f(sArr, sArr3, sArr6);
        m.c(sArr6);
        short[] sArr7 = new short[1024];
        m.d(sArr7, bArr5, (byte) 2);
        m.a(sArr6, sArr7, sArr6);
        short[] sArr8 = new short[1024];
        b.e(sArr8, sArr6, bArr5, (byte) 3);
        d(bArr2, sArr5, sArr8);
        b.f(bArr, sArr6, sArr8);
        g(bArr);
    }
}
