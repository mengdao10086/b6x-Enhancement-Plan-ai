package com.google.zxing.oned.rss.expanded.decoders;

/* JADX INFO: loaded from: classes7.dex */
public abstract class h extends j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21483c = 40;

    public h(af.a aVar) {
        super(aVar);
    }

    public static void e(StringBuilder sb2, int i10) {
        int i11 = 0;
        for (int i12 = 0; i12 < 13; i12++) {
            int iCharAt = sb2.charAt(i12 + i10) - '0';
            if ((i12 & 1) == 0) {
                iCharAt *= 3;
            }
            i11 += iCharAt;
        }
        int i13 = 10 - (i11 % 10);
        sb2.append(i13 != 10 ? i13 : 0);
    }

    public final void f(StringBuilder sb2, int i10) {
        sb2.append("(01)");
        int length = sb2.length();
        sb2.append('9');
        g(sb2, i10, length);
    }

    public final void g(StringBuilder sb2, int i10, int i11) {
        for (int i12 = 0; i12 < 4; i12++) {
            int iF = b().f((i12 * 10) + i10, 10);
            if (iF / 100 == 0) {
                sb2.append('0');
            }
            if (iF / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(iF);
        }
        e(sb2, i11);
    }
}
