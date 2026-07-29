package ft;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes6.dex */
public final class z {
    public static int a(int i10, int i11) {
        return i10 ^ i11;
    }

    public static int b(int i10) {
        int i11 = -1;
        while (i10 != 0) {
            i11++;
            i10 >>>= 1;
        }
        return i11;
    }

    public static int c(long j10) {
        int i10 = 0;
        while (j10 != 0) {
            i10++;
            j10 >>>= 1;
        }
        return i10 - 1;
    }

    public static int d(int i10, int i11) {
        while (true) {
            int i12 = i11;
            int i13 = i10;
            i10 = i12;
            if (i10 == 0) {
                return i13;
            }
            i11 = i(i13, i10);
        }
    }

    public static int e(int i10) {
        PrintStream printStream;
        String str;
        if (i10 < 0) {
            printStream = System.err;
            str = "The Degree is negative";
        } else {
            if (i10 <= 31) {
                if (i10 == 0) {
                    return 1;
                }
                int i11 = 1 << (i10 + 1);
                for (int i12 = (1 << i10) + 1; i12 < i11; i12 += 2) {
                    if (f(i12)) {
                        return i12;
                    }
                }
                return 0;
            }
            printStream = System.err;
            str = "The Degree is more then 31";
        }
        printStream.println(str);
        return 0;
    }

    public static boolean f(int i10) {
        if (i10 == 0) {
            return false;
        }
        int iB = b(i10) >>> 1;
        int iG = 2;
        for (int i11 = 0; i11 < iB; i11++) {
            iG = g(iG, iG, i10);
            if (d(iG ^ 2, i10) != 1) {
                return false;
            }
        }
        return true;
    }

    public static int g(int i10, int i11, int i12) {
        int i13 = i(i10, i12);
        int i14 = i(i11, i12);
        int i15 = 0;
        if (i14 != 0) {
            int iB = 1 << b(i12);
            while (i13 != 0) {
                if (((byte) (i13 & 1)) == 1) {
                    i15 ^= i14;
                }
                i13 >>>= 1;
                i14 <<= 1;
                if (i14 >= iB) {
                    i14 ^= i12;
                }
            }
        }
        return i15;
    }

    public static long h(int i10, int i11) {
        long j10 = 0;
        if (i11 != 0) {
            long j11 = ((long) i11) & 4294967295L;
            while (i10 != 0) {
                if (((byte) (i10 & 1)) == 1) {
                    j10 ^= j11;
                }
                i10 >>>= 1;
                j11 <<= 1;
            }
        }
        return j10;
    }

    public static int i(int i10, int i11) {
        if (i11 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (b(i10) >= b(i11)) {
            i10 ^= i11 << (b(i10) - b(i11));
        }
        return i10;
    }

    public static int j(long j10, int i10) {
        if (i10 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        long j11 = ((long) i10) & 4294967295L;
        while ((j10 >>> 32) != 0) {
            j10 ^= j11 << (c(j10) - c(j11));
        }
        int iB = (int) (j10 & (-1));
        while (b(iB) >= b(i10)) {
            iB ^= i10 << (b(iB) - b(i10));
        }
        return iB;
    }
}
