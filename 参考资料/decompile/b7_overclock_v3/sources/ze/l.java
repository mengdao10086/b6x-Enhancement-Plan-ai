package ze;

/* JADX INFO: loaded from: classes7.dex */
public final class l extends t {
    public static String q(int i10, String str) {
        if (str.charAt(i10) != '(') {
            return null;
        }
        String strSubstring = str.substring(i10 + 1);
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < strSubstring.length(); i11++) {
            char cCharAt = strSubstring.charAt(i11);
            if (cCharAt == ')') {
                return sb2.toString();
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            sb2.append(cCharAt);
        }
        return sb2.toString();
    }

    public static String r(int i10, String str) {
        StringBuilder sb2 = new StringBuilder();
        String strSubstring = str.substring(i10);
        for (int i11 = 0; i11 < strSubstring.length(); i11++) {
            char cCharAt = strSubstring.charAt(i11);
            if (cCharAt != '(') {
                sb2.append(cCharAt);
            } else {
                if (q(i11, strSubstring) != null) {
                    break;
                }
                sb2.append('(');
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004f  */
    @Override // ze.t
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ze.k k(ve.k r24) {
        /*
            Method dump skipped, instruction units count: 866
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ze.l.k(ve.k):ze.k");
    }
}
