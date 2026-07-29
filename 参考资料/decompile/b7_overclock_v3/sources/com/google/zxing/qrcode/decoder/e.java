package com.google.zxing.qrcode.decoder;

import os.j;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21602c = 21522;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[][] f21603d = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{j.f46278x, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ErrorCorrectionLevel f21604a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte f21605b;

    public e(int i10) {
        this.f21604a = ErrorCorrectionLevel.forBits((i10 >> 3) & 3);
        this.f21605b = (byte) (i10 & 7);
    }

    public static e a(int i10, int i11) {
        e eVarB = b(i10, i11);
        return eVarB != null ? eVarB : b(i10 ^ 21522, i11 ^ 21522);
    }

    public static e b(int i10, int i11) {
        int iE;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        for (int[] iArr : f21603d) {
            int i14 = iArr[0];
            if (i14 == i10 || i14 == i11) {
                return new e(iArr[1]);
            }
            int iE2 = e(i10, i14);
            if (iE2 < i12) {
                i13 = iArr[1];
                i12 = iE2;
            }
            if (i10 != i11 && (iE = e(i11, i14)) < i12) {
                i13 = iArr[1];
                i12 = iE;
            }
        }
        if (i12 <= 3) {
            return new e(i13);
        }
        return null;
    }

    public static int e(int i10, int i11) {
        return Integer.bitCount(i10 ^ i11);
    }

    public byte c() {
        return this.f21605b;
    }

    public ErrorCorrectionLevel d() {
        return this.f21604a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f21604a == eVar.f21604a && this.f21605b == eVar.f21605b;
    }

    public int hashCode() {
        return (this.f21604a.ordinal() << 3) | this.f21605b;
    }
}
