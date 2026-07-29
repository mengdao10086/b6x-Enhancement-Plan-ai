package rs;

/* JADX INFO: loaded from: classes6.dex */
public class l {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f49173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f49174b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f49175c;

        public a() {
        }

        public a(a aVar) {
            this.f49173a = aVar.f49173a;
            this.f49174b = aVar.f49174b;
            this.f49175c = aVar.f49175c;
        }
    }

    public static void a(rs.a aVar, byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, a aVar2) {
        byte[] bArr4 = new byte[32];
        byte[] bArr5 = new byte[m.f49181f];
        m mVar = new m();
        k.a(aVar, bArr4, 0, bArr3, aVar2);
        mVar.d(aVar, bArr5, 0, bArr4, 0, bArr2, i11);
        b(aVar, bArr, i10, bArr5, 0, bArr2, i11);
    }

    public static void b(rs.a aVar, byte[] bArr, int i10, byte[] bArr2, int i11, byte[] bArr3, int i12) {
        int i13;
        int i14 = 67;
        for (int i15 = 0; i15 < 7; i15++) {
            int i16 = 0;
            while (true) {
                i13 = i14 >>> 1;
                if (i16 >= i13) {
                    break;
                }
                aVar.c(bArr2, i11 + (i16 * 32), bArr2, i11 + (i16 * 2 * 32), bArr3, i12 + (i15 * 2 * 32));
                i16++;
            }
            if ((i14 & 1) != 0) {
                System.arraycopy(bArr2, i11 + ((i14 - 1) * 32), bArr2, (i13 * 32) + i11, 32);
                i13++;
            }
            i14 = i13;
        }
        System.arraycopy(bArr2, i11, bArr, i10, 32);
    }

    public static void c(rs.a aVar, byte[] bArr, int i10, int i11, byte[] bArr2, a aVar2, byte[] bArr3, int i12) {
        a aVar3 = new a(aVar2);
        int i13 = i11 + 1;
        byte[] bArr4 = new byte[i13 * 32];
        int[] iArr = new int[i13];
        int i14 = 1;
        int i15 = (int) (aVar3.f49175c + ((long) (1 << i11)));
        int i16 = 0;
        while (aVar3.f49175c < i15) {
            a(aVar, bArr4, i16 * 32, bArr3, i12, bArr2, aVar3);
            iArr[i16] = 0;
            int i17 = i16 + i14;
            while (i17 > i14) {
                int i18 = i17 - 1;
                int i19 = i17 - 2;
                if (iArr[i18] == iArr[i19]) {
                    int i20 = i19 * 32;
                    int[] iArr2 = iArr;
                    aVar.c(bArr4, i20, bArr4, i20, bArr3, i12 + ((iArr[i18] + 7) * 2 * 32));
                    iArr2[i19] = iArr2[i19] + 1;
                    i17--;
                    i15 = i15;
                    iArr = iArr2;
                    i14 = 1;
                }
            }
            aVar3.f49175c++;
            i16 = i17;
            i15 = i15;
            iArr = iArr;
            i14 = 1;
        }
        for (int i21 = 0; i21 < 32; i21++) {
            bArr[i10 + i21] = bArr4[i21];
        }
    }
}
