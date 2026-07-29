package gd;

import g.p0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static long a(@p0 String str) {
        long j10 = 0;
        if (str == null) {
            return 0L;
        }
        for (int i10 = 0; i10 < str.length(); i10++) {
            long jCharAt = j10 ^ ((long) str.charAt(i10));
            j10 = jCharAt + (jCharAt << 1) + (jCharAt << 4) + (jCharAt << 5) + (jCharAt << 7) + (jCharAt << 8) + (jCharAt << 40);
        }
        return j10;
    }
}
