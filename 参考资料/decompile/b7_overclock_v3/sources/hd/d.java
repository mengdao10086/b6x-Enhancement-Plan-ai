package hd;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f30969a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f30970b = {"", i1.a.W4, "B", "C"};

    public static String a(int i10, int i11, int i12) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12));
    }

    public static List<byte[]> b(boolean z10) {
        return Collections.singletonList(z10 ? new byte[]{1} : new byte[]{0});
    }

    public static String c(d0 d0Var) {
        d0Var.l(24);
        int iE = d0Var.e(2);
        boolean zD = d0Var.d();
        int iE2 = d0Var.e(5);
        int i10 = 0;
        for (int i11 = 0; i11 < 32; i11++) {
            if (d0Var.d()) {
                i10 |= 1 << i11;
            }
        }
        int i12 = 6;
        int[] iArr = new int[6];
        for (int i13 = 0; i13 < 6; i13++) {
            iArr[i13] = d0Var.e(8);
        }
        int iE3 = d0Var.e(8);
        Object[] objArr = new Object[5];
        objArr[0] = f30970b[iE];
        objArr[1] = Integer.valueOf(iE2);
        objArr[2] = Integer.valueOf(i10);
        objArr[3] = Character.valueOf(zD ? 'H' : ft.w.f28816e);
        objArr[4] = Integer.valueOf(iE3);
        StringBuilder sb2 = new StringBuilder(u0.I("hvc1.%s%d.%X.%c%d", objArr));
        while (i12 > 0 && iArr[i12 - 1] == 0) {
            i12--;
        }
        for (int i14 = 0; i14 < i12; i14++) {
            sb2.append(String.format(".%02X", Integer.valueOf(iArr[i14])));
        }
        return sb2.toString();
    }

    public static byte[] d(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = f30969a;
        byte[] bArr3 = new byte[bArr2.length + i11];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i10, bArr3, bArr2.length, i11);
        return bArr3;
    }

    public static int e(byte[] bArr, int i10) {
        int length = bArr.length - f30969a.length;
        while (i10 <= length) {
            if (f(bArr, i10)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static boolean f(byte[] bArr, int i10) {
        if (bArr.length - i10 <= f30969a.length) {
            return false;
        }
        int i11 = 0;
        while (true) {
            byte[] bArr2 = f30969a;
            if (i11 >= bArr2.length) {
                return true;
            }
            if (bArr[i10 + i11] != bArr2[i11]) {
                return false;
            }
            i11++;
        }
    }

    public static Pair<Integer, Integer> g(byte[] bArr) {
        c0 c0Var = new c0(bArr);
        c0Var.S(9);
        int iG = c0Var.G();
        c0Var.S(20);
        return Pair.create(Integer.valueOf(c0Var.K()), Integer.valueOf(iG));
    }

    public static boolean h(List<byte[]> list) {
        return list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1;
    }

    @g.p0
    public static byte[][] i(byte[] bArr) {
        if (!f(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iE = 0;
        do {
            arrayList.add(Integer.valueOf(iE));
            iE = e(bArr, iE + f30969a.length);
        } while (iE != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i10 = 0;
        while (i10 < arrayList.size()) {
            int iIntValue = ((Integer) arrayList.get(i10)).intValue();
            int iIntValue2 = (i10 < arrayList.size() + (-1) ? ((Integer) arrayList.get(i10 + 1)).intValue() : bArr.length) - iIntValue;
            byte[] bArr3 = new byte[iIntValue2];
            System.arraycopy(bArr, iIntValue, bArr3, 0, iIntValue2);
            bArr2[i10] = bArr3;
            i10++;
        }
        return bArr2;
    }
}
