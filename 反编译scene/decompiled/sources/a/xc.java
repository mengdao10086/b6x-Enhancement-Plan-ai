package a;

import android.graphics.Path;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class xc {
    public static void a(ArrayList<wc> arrayList, char c, float[] fArr) {
        arrayList.add(new wc(c, fArr));
    }

    public static boolean b(wc[] wcVarArr, wc[] wcVarArr2) {
        if (wcVarArr == null || wcVarArr2 == null || wcVarArr.length != wcVarArr2.length) {
            return false;
        }
        for (int i = 0; i < wcVarArr.length; i++) {
            if (wcVarArr[i].f7773a != wcVarArr2[i].f7773a || wcVarArr[i].f3420a.length != wcVarArr2[i].f3420a.length) {
                return false;
            }
        }
        return true;
    }

    public static float[] c(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int iMin = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    public static wc[] d(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i(str, i);
            String strTrim = str.substring(i2, i3).trim();
            if (strTrim.length() > 0) {
                a(arrayList, strTrim.charAt(0), h(strTrim));
            }
            i2 = i3;
            i = i3 + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            a(arrayList, str.charAt(i2), new float[0]);
        }
        return (wc[]) arrayList.toArray(new wc[arrayList.size()]);
    }

    public static Path e(String str) {
        Path path = new Path();
        wc[] wcVarArrD = d(str);
        if (wcVarArrD == null) {
            return null;
        }
        try {
            wc.e(wcVarArrD, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    public static wc[] f(wc[] wcVarArr) {
        if (wcVarArr == null) {
            return null;
        }
        wc[] wcVarArr2 = new wc[wcVarArr.length];
        for (int i = 0; i < wcVarArr.length; i++) {
            wcVarArr2[i] = new wc(wcVarArr[i]);
        }
        return wcVarArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0038 A[LOOP:0: B:3:0x0007->B:24:0x0038, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(java.lang.String r8, int r9, a.vc r10) {
        /*
            r0 = 0
            r10.f3264a = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3b
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L33
            r6 = 69
            if (r5 == r6) goto L31
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L31
            switch(r5) {
                case 44: goto L33;
                case 45: goto L2a;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L2f
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L35
        L27:
            r10.f3264a = r7
            goto L33
        L2a:
            if (r1 == r9) goto L2f
            if (r2 != 0) goto L2f
            goto L27
        L2f:
            r2 = r0
            goto L35
        L31:
            r2 = r7
            goto L35
        L33:
            r2 = r0
            r4 = r7
        L35:
            if (r4 == 0) goto L38
            goto L3b
        L38:
            int r1 = r1 + 1
            goto L7
        L3b:
            r10.f7677a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.xc.g(java.lang.String, int, a.vc):void");
    }

    public static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            vc vcVar = new vc();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                g(str, i, vcVar);
                int i3 = vcVar.f7677a;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = vcVar.f3264a ? i3 : i3 + 1;
            }
            return c(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }

    public static int i(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    public static void j(wc[] wcVarArr, wc[] wcVarArr2) {
        for (int i = 0; i < wcVarArr2.length; i++) {
            wcVarArr[i].f7773a = wcVarArr2[i].f7773a;
            for (int i2 = 0; i2 < wcVarArr2[i].f3420a.length; i2++) {
                wcVarArr[i].f3420a[i2] = wcVarArr2[i].f3420a[i2];
            }
        }
    }
}
