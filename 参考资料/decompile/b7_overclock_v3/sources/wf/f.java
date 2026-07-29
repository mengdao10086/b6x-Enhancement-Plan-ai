package wf;

import w.w;

/* JADX INFO: loaded from: classes7.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f54668a = 4096;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f54669b = 256;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f54670c = 256;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f54671d = 660;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f54672e = 512;

    public static int a(int i10, boolean z10, int i11) {
        int i12 = i10 / 100;
        if (i10 < 256) {
            i12 = i10;
        } else {
            int i13 = i12 < 256 ? 256 - i12 : 256 - (i12 % 256);
            if (i13 != 0) {
                i12 += i13;
            }
        }
        if (i12 < 4096) {
            i12 = 4096;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("imageSize = ");
        sb2.append(i10);
        sb2.append(" onepercentBytes = ");
        sb2.append(i12);
        sb2.append(" crc total Count ");
        sb2.append(((i10 + i12) - 1) / i12);
        return i12;
    }

    public static int b(int i10, int i11, boolean z10, int i12) {
        if (i10 != 0 && i10 < i11 - 1) {
            return i10;
        }
        if (z10) {
            return i11 > 509 ? w.g.f53777p : i11 - 1;
        }
        if (i12 == 1) {
            int i13 = i11 - 1;
            if (i13 > 660) {
                return 660;
            }
            return i13;
        }
        int i14 = i11 - 1;
        if (i14 > 512) {
            return 512;
        }
        return i14;
    }

    public static int c(int i10, int i11, boolean z10, int i12) {
        int iB = ((b(i10, i11, z10, i12) + i10) - 1) / b(i10, i11, z10, i12);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("imageSize = ");
        sb2.append(i10);
        sb2.append(" mtu = ");
        sb2.append(i11);
        sb2.append(" totalCount = ");
        sb2.append(iB);
        return iB;
    }

    public static int d(int i10) {
        if (i10 >= 256) {
            i10 = 256;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("calculateSppSinglePacketLen = ");
        sb2.append(i10);
        return i10;
    }

    public static int e(int i10) {
        return ((i10 + 4096) - 1) / 4096;
    }

    public static int f(int i10) {
        return ((i10 + 256) - 1) / 256;
    }
}
