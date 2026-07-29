package ob;

import hd.c0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f43270b = 1751476579;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f43271c = 4096;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43269a = 1903435808;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f43272d = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, a.f43047h, a.f43056k, a.f43059l, a.f43074q, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, f43269a, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean a(int i10, boolean z10) {
        if ((i10 >>> 8) == 3368816) {
            return true;
        }
        if (i10 == 1751476579 && z10) {
            return true;
        }
        for (int i11 : f43272d) {
            if (i11 == i10) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(hb.l lVar) throws IOException {
        return c(lVar, true, false);
    }

    public static boolean c(hb.l lVar, boolean z10, boolean z11) throws IOException {
        boolean z12;
        long length = lVar.getLength();
        long j10 = 4096;
        long j11 = -1;
        if (length != -1 && length <= 4096) {
            j10 = length;
        }
        int i10 = (int) j10;
        c0 c0Var = new c0(64);
        boolean z13 = false;
        int i11 = 0;
        boolean z14 = false;
        while (i11 < i10) {
            c0Var.O(8);
            if (!lVar.h(c0Var.d(), z13 ? 1 : 0, 8, true)) {
                break;
            }
            long jI = c0Var.I();
            int iO = c0Var.o();
            int i12 = 16;
            if (jI == 1) {
                lVar.t(c0Var.d(), 8, 8);
                c0Var.R(16);
                jI = c0Var.z();
            } else {
                if (jI == 0) {
                    long length2 = lVar.getLength();
                    if (length2 != j11) {
                        jI = (length2 - lVar.i()) + ((long) 8);
                    }
                }
                i12 = 8;
            }
            long j12 = i12;
            if (jI < j12) {
                return z13;
            }
            i11 += i12;
            if (iO == 1836019574) {
                i10 += (int) jI;
                if (length != -1 && i10 > length) {
                    i10 = (int) length;
                }
                j11 = -1;
            } else {
                if (iO == 1836019558 || iO == 1836475768) {
                    z12 = true;
                    break;
                }
                long j13 = length;
                if ((((long) i11) + jI) - j12 >= i10) {
                    break;
                }
                int i13 = (int) (jI - j12);
                i11 += i13;
                if (iO == 1718909296) {
                    if (i13 < 8) {
                        return false;
                    }
                    c0Var.O(i13);
                    lVar.t(c0Var.d(), 0, i13);
                    int i14 = i13 / 4;
                    int i15 = 0;
                    while (true) {
                        if (i15 >= i14) {
                            break;
                        }
                        if (i15 == 1) {
                            c0Var.T(4);
                        } else if (a(c0Var.o(), z11)) {
                            z14 = true;
                            break;
                        }
                        i15++;
                    }
                    if (!z14) {
                        return false;
                    }
                } else if (i13 != 0) {
                    lVar.j(i13);
                }
                length = j13;
                j11 = -1;
                z13 = false;
            }
        }
        z12 = false;
        return z14 && z10 == z12;
    }

    public static boolean d(hb.l lVar) throws IOException {
        return c(lVar, false, false);
    }

    public static boolean e(hb.l lVar, boolean z10) throws IOException {
        return c(lVar, false, z10);
    }
}
