package rs;

/* JADX INFO: loaded from: classes6.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f49176a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f49177b = 16;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f49178c = 64;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f49179d = 67;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f49180e = 7;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f49181f = 2144;

    public static void a(byte[] bArr, int i10, int i11) {
        for (int i12 = 0; i12 != i11; i12++) {
            bArr[i12 + i10] = 0;
        }
    }

    public static void b(byte[] bArr, int i10, byte[] bArr2, int i11) {
        a(bArr, i10, f49181f);
        k.b(bArr, i10, 2144L, bArr2, i11);
    }

    public static void c(a aVar, byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12, int i13) {
        for (int i14 = 0; i14 < 32; i14++) {
            bArr[i14 + i10] = bArr2[i14 + i11];
        }
        for (int i15 = 0; i15 < i13 && i15 < 16; i15++) {
            aVar.e(bArr, i10, bArr, i10, bArr3, i12 + (i15 * 32));
        }
    }

    public void d(a aVar, byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        b(bArr, i10, bArr2, i11);
        for (int i13 = 0; i13 < 67; i13++) {
            int i14 = i10 + (i13 * 32);
            c(aVar, bArr, i14, bArr, i14, bArr3, i12, 15);
        }
    }

    public void e(a aVar, byte[] bArr, int i10, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        int[] iArr = new int[67];
        int i11 = 0;
        int i12 = 0;
        while (i11 < 64) {
            int i13 = i11 / 2;
            iArr[i11] = bArr2[i13] & 15;
            int i14 = i11 + 1;
            iArr[i14] = (bArr2[i13] & 255) >>> 4;
            i12 = i12 + (15 - iArr[i11]) + (15 - iArr[i14]);
            i11 += 2;
        }
        while (i11 < 67) {
            iArr[i11] = i12 & 15;
            i12 >>>= 4;
            i11++;
        }
        b(bArr, i10, bArr3, 0);
        for (int i15 = 0; i15 < 67; i15++) {
            int i16 = i10 + (i15 * 32);
            c(aVar, bArr, i16, bArr, i16, bArr4, 0, iArr[i15]);
        }
    }

    public void f(a aVar, byte[] bArr, byte[] bArr2, int i10, byte[] bArr3, byte[] bArr4) {
        int[] iArr = new int[67];
        int i11 = 0;
        int i12 = 0;
        while (i11 < 64) {
            int i13 = i11 / 2;
            iArr[i11] = bArr3[i13] & 15;
            int i14 = i11 + 1;
            iArr[i14] = (bArr3[i13] & 255) >>> 4;
            i12 = i12 + (15 - iArr[i11]) + (15 - iArr[i14]);
            i11 += 2;
        }
        while (i11 < 67) {
            iArr[i11] = i12 & 15;
            i12 >>>= 4;
            i11++;
        }
        for (int i15 = 0; i15 < 67; i15++) {
            int i16 = i15 * 32;
            c(aVar, bArr, i16, bArr2, i10 + i16, bArr4, iArr[i15] * 32, 15 - iArr[i15]);
        }
    }
}
