package r5;

import android.graphics.Path;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f47744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f47745b;
    }

    public static void a(ArrayList<r5.a> arrayList, char c10, float[] fArr) {
        arrayList.add(new r5.a(c10, fArr));
    }

    public static boolean b(r5.a[] aVarArr, r5.a[] aVarArr2) {
        if (aVarArr == null || aVarArr2 == null || aVarArr.length != aVarArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            if (aVarArr[i10].f47742a != aVarArr2[i10].f47742a || aVarArr[i10].f47743b.length != aVarArr2[i10].f47743b.length) {
                return false;
            }
        }
        return true;
    }

    public static boolean c(r5.a[]... aVarArr) {
        for (r5.a[] aVarArr2 : aVarArr) {
            if (aVarArr2 == null) {
                return false;
            }
        }
        int i10 = 0;
        while (i10 < aVarArr.length - 1) {
            int length = aVarArr[i10].length;
            i10++;
            if (length != aVarArr[i10].length) {
                return false;
            }
        }
        for (int i11 = 0; i11 < aVarArr.length - 1; i11++) {
            for (int i12 = 0; i12 < aVarArr[i11].length; i12++) {
                int i13 = i11 + 1;
                if (aVarArr[i11][i12].f47742a != aVarArr[i13][i12].f47742a || aVarArr[i11][i12].f47743b.length != aVarArr[i13][i12].f47743b.length) {
                    return false;
                }
            }
        }
        return true;
    }

    public static float[] d(float[] fArr, int i10, int i11) {
        if (i10 > i11) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i10 < 0 || i10 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i12 = i11 - i10;
        int iMin = Math.min(i12, length - i10);
        float[] fArr2 = new float[i12];
        System.arraycopy(fArr, i10, fArr2, 0, iMin);
        return fArr2;
    }

    public static r5.a[] e(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i10 = 1;
        int i11 = 0;
        while (i10 < str.length()) {
            int iK = k(str, i10);
            String strTrim = str.substring(i11, iK).trim();
            if (strTrim.length() > 0) {
                a(arrayList, strTrim.charAt(0), j(strTrim));
            }
            i11 = iK;
            i10 = iK + 1;
        }
        if (i10 - i11 == 1 && i11 < str.length()) {
            a(arrayList, str.charAt(i11), new float[0]);
        }
        return (r5.a[]) arrayList.toArray(new r5.a[arrayList.size()]);
    }

    public static Path f(String str) {
        Path path = new Path();
        g(path, str);
        return path;
    }

    public static void g(Path path, String str) {
        r5.a[] aVarArrE = e(str);
        if (aVarArrE != null) {
            try {
                r5.a.f(aVarArrE, path);
            } catch (RuntimeException e10) {
                throw new RuntimeException("Error in parsing " + str, e10);
            }
        }
    }

    public static r5.a[] h(r5.a[] aVarArr) {
        if (aVarArr == null) {
            return null;
        }
        r5.a[] aVarArr2 = new r5.a[aVarArr.length];
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            aVarArr2[i10] = new r5.a(aVarArr[i10]);
        }
        return aVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a A[LOOP:0: B:3:0x0007->B:24:0x003a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(java.lang.String r8, int r9, r5.b.a r10) {
        /*
            r0 = 0
            r10.f47745b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3d
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L35
            r6 = 69
            if (r5 == r6) goto L33
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L33
            switch(r5) {
                case 44: goto L35;
                case 45: goto L2a;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L31
        L22:
            if (r3 != 0) goto L27
            r2 = 0
            r3 = 1
            goto L37
        L27:
            r10.f47745b = r7
            goto L35
        L2a:
            if (r1 == r9) goto L31
            if (r2 != 0) goto L31
            r10.f47745b = r7
            goto L35
        L31:
            r2 = 0
            goto L37
        L33:
            r2 = 1
            goto L37
        L35:
            r2 = 0
            r4 = 1
        L37:
            if (r4 == 0) goto L3a
            goto L3d
        L3a:
            int r1 = r1 + 1
            goto L7
        L3d:
            r10.f47744a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r5.b.i(java.lang.String, int, r5.b$a):void");
    }

    public static float[] j(String str) {
        int i10 = 1;
        if ((str.charAt(0) == 'z') || (str.charAt(0) == 'Z')) {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i11 = 0;
            while (i10 < length) {
                i(str, i10, aVar);
                int i12 = aVar.f47744a;
                if (i10 < i12) {
                    fArr[i11] = Float.parseFloat(str.substring(i10, i12));
                    i11++;
                }
                i10 = aVar.f47745b ? i12 : i12 + 1;
            }
            return d(fArr, 0, i11);
        } catch (NumberFormatException e10) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e10);
        }
    }

    public static int k(String str, int i10) {
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                return i10;
            }
            i10++;
        }
        return i10;
    }

    public static void l(r5.a[] aVarArr, r5.a[] aVarArr2) {
        for (int i10 = 0; i10 < aVarArr2.length; i10++) {
            aVarArr[i10].f47742a = aVarArr2[i10].f47742a;
            for (int i11 = 0; i11 < aVarArr2[i10].f47743b.length; i11++) {
                aVarArr[i10].f47743b[i11] = aVarArr2[i10].f47743b[i11];
            }
        }
    }
}
