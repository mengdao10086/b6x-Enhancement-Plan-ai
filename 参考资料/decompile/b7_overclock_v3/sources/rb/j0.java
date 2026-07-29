package rb;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {
    public static int a(byte[] bArr, int i10, int i11) {
        while (i10 < i11 && bArr[i10] != 71) {
            i10++;
        }
        return i10;
    }

    public static long b(hd.c0 c0Var, int i10, int i11) {
        c0Var.S(i10);
        if (c0Var.a() < 5) {
            return ya.g.f56663b;
        }
        int iO = c0Var.o();
        if ((8388608 & iO) != 0 || ((2096896 & iO) >> 8) != i11) {
            return ya.g.f56663b;
        }
        if (((iO & 32) != 0) && c0Var.G() >= 7 && c0Var.a() >= 7) {
            if ((c0Var.G() & 16) == 16) {
                byte[] bArr = new byte[6];
                c0Var.k(bArr, 0, 6);
                return c(bArr);
            }
        }
        return ya.g.f56663b;
    }

    public static long c(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
