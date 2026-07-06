package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ac2 extends zb2 {
    public static final Integer j(String str) {
        f92.d(str, "$this$toIntOrNull");
        return k(str, 10);
    }

    public static final Integer k(String str, int i) {
        boolean z;
        int i2;
        f92.d(str, "$this$toIntOrNull");
        za2.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char cCharAt = str.charAt(0);
        int i4 = -2147483647;
        int i5 = 1;
        if (f92.e(cCharAt, 48) >= 0) {
            z = false;
            i5 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i4 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z = false;
            }
        }
        int i6 = -59652323;
        while (i5 < length) {
            int iB = za2.b(str.charAt(i5), i);
            if (iB < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i4 / i))) || (i2 = i3 * i) < i4 + iB) {
                return null;
            }
            i3 = i2 - iB;
            i5++;
        }
        return z ? Integer.valueOf(i3) : Integer.valueOf(-i3);
    }

    public static final Long l(String str) {
        f92.d(str, "$this$toLongOrNull");
        return m(str, 10);
    }

    public static final Long m(String str, int i) {
        f92.d(str, "$this$toLongOrNull");
        za2.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        long j = -9223372036854775807L;
        boolean z = true;
        if (f92.e(cCharAt, 48) >= 0) {
            z = false;
        } else {
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j = Long.MIN_VALUE;
                i2 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z = false;
                i2 = 1;
            }
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i2 < length) {
            int iB = za2.b(str.charAt(i2), i);
            if (iB < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 == j2) {
                    j4 = j / ((long) i);
                    if (j3 < j4) {
                    }
                }
                return null;
            }
            long j5 = j3 * ((long) i);
            long j6 = iB;
            if (j5 < j + j6) {
                return null;
            }
            j3 = j5 - j6;
            i2++;
            j2 = -256204778801521550L;
        }
        return z ? Long.valueOf(j3) : Long.valueOf(-j3);
    }
}
