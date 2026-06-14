package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class bc2 extends ac2 {
    public static final boolean n(String str, String str2, boolean z) {
        f92.d(str, "$this$endsWith");
        f92.d(str2, "suffix");
        return !z ? str.endsWith(str2) : q(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static /* synthetic */ boolean o(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return n(str, str2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean p(java.lang.CharSequence r4) {
        /*
            java.lang.String r0 = "$this$isBlank"
            a.f92.d(r4, r0)
            int r0 = r4.length()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L3e
            a.ea2 r0 = a.ec2.G(r4)
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L20
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L20
        L1e:
            r4 = r2
            goto L3c
        L20:
            java.util.Iterator r0 = r0.iterator()
        L24:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L1e
            r3 = r0
            a.q52 r3 = (a.q52) r3
            int r3 = r3.b()
            char r3 = r4.charAt(r3)
            boolean r3 = a.za2.c(r3)
            if (r3 != 0) goto L24
            r4 = r1
        L3c:
            if (r4 == 0) goto L3f
        L3e:
            r1 = r2
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: a.bc2.p(java.lang.CharSequence):boolean");
    }

    public static final boolean q(String str, int i, String str2, int i2, int i3, boolean z) {
        f92.d(str, "$this$regionMatches");
        f92.d(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static final String r(CharSequence charSequence, int i) {
        f92.d(charSequence, "$this$repeat");
        int i2 = 1;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        }
        if (i == 0) {
            return "";
        }
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i3 = 0; i3 < i; i3++) {
                cArr[i3] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i);
        if (1 <= i) {
            while (true) {
                sb.append(charSequence);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        String string = sb.toString();
        f92.c(string, "sb.toString()");
        return string;
    }

    public static final String s(String str, String str2, String str3, boolean z) {
        f92.d(str, "$this$replace");
        f92.d(str2, "oldValue");
        f92.d(str3, "newValue");
        int i = 0;
        int iJ = ec2.J(str, str2, 0, z);
        if (iJ < 0) {
            return str;
        }
        int length = str2.length();
        int iB = ga2.b(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i, iJ);
            sb.append(str3);
            i = iJ + length;
            if (iJ >= str.length()) {
                break;
            }
            iJ = ec2.J(str, str2, iJ + iB, z);
        } while (iJ > 0);
        sb.append((CharSequence) str, i, str.length());
        String string = sb.toString();
        f92.c(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static /* synthetic */ String t(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return s(str, str2, str3, z);
    }

    public static final boolean u(String str, String str2, int i, boolean z) {
        f92.d(str, "$this$startsWith");
        f92.d(str2, "prefix");
        return !z ? str.startsWith(str2, i) : q(str, i, str2, 0, str2.length(), z);
    }

    public static final boolean v(String str, String str2, boolean z) {
        f92.d(str, "$this$startsWith");
        f92.d(str2, "prefix");
        return !z ? str.startsWith(str2) : q(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean w(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return u(str, str2, i, z);
    }

    public static /* synthetic */ boolean x(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return v(str, str2, z);
    }
}
