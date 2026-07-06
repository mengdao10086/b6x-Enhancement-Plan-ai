package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xl0 {
    public final int a(String str) {
        int iN = ec2.N(str, ":", 0, false, 6, null) + 1;
        int iS = ec2.S(str, " ", 0, false, 6, null);
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iN, iS);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        int length = strSubstring.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = f92.e(strSubstring.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return Integer.parseInt(strSubstring.subSequence(i, length + 1).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(a.b62<? super a.vl0> r10) throws javax.crypto.NoSuchPaddingException, java.security.NoSuchAlgorithmException, java.security.InvalidKeyException, java.security.InvalidAlgorithmParameterException {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.xl0.b(a.b62):java.lang.Object");
    }
}
