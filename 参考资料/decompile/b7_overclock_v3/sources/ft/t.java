package ft;

import com.blankj.utilcode.util.i0;

/* JADX INFO: loaded from: classes6.dex */
public final class t {
    public static int[] a(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static boolean b(int[] iArr, int[] iArr2) {
        if (iArr.length != iArr2.length) {
            return false;
        }
        boolean z10 = true;
        for (int length = iArr.length - 1; length >= 0; length--) {
            z10 &= iArr[length] == iArr2[length];
        }
        return z10;
    }

    public static void c(int[] iArr, int i10) {
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr[length] = i10;
        }
    }

    public static int d(int[] iArr, int i10, int i11, int i12) {
        int i13 = iArr[i12];
        iArr[i12] = iArr[i11];
        iArr[i11] = i13;
        int i14 = i10;
        while (i10 < i11) {
            if (iArr[i10] <= i13) {
                int i15 = iArr[i14];
                iArr[i14] = iArr[i10];
                iArr[i10] = i15;
                i14++;
            }
            i10++;
        }
        int i16 = iArr[i14];
        iArr[i14] = iArr[i11];
        iArr[i11] = i16;
        return i14;
    }

    public static void e(int[] iArr) {
        f(iArr, 0, iArr.length - 1);
    }

    public static void f(int[] iArr, int i10, int i11) {
        if (i11 > i10) {
            int iD = d(iArr, i10, i11, i11);
            f(iArr, i10, iD - 1);
            f(iArr, iD + 1, i11);
        }
    }

    public static int[] g(int[] iArr, int i10, int i11) {
        int i12 = i11 - i10;
        int[] iArr2 = new int[i12];
        System.arraycopy(iArr, i10, iArr2, 0, i12);
        return iArr2;
    }

    public static String h(int[] iArr) {
        return c.p(a.k(iArr));
    }

    public static String i(int[] iArr) {
        String str = "";
        for (int i10 : iArr) {
            str = str + i10 + i0.f11861z;
        }
        return str;
    }
}
