package com.google.zxing.datamatrix.encoder;

import com.arialyy.aria.core.command.NormalCmdFactory;
import com.arialyy.aria.core.listener.ISchedulers;
import com.flydigi.sdk.waspwing.WaspWingInfo;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.common.math.DoubleMath;
import rb.a0;
import rb.h0;
import v7.a;

/* JADX INFO: loaded from: classes7.dex */
public final class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21330c = 301;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f21328a = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[][] f21329b = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, 134, 240, 92, 254}, new int[]{28, 24, NormalCmdFactory.TASK_CANCEL_ALL, 166, 223, 248, 116, 255, 110, 61}, new int[]{HideBottomViewOnScrollBehavior.f19616g, 138, 205, 12, 194, os.a.f46207a, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, 142, 213, 97, 178, 100, m9.m.f40854e0}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, NormalCmdFactory.TASK_CANCEL_ALL}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, 241, 213, 109, 129, 94, 254, 225, 48, 90, 188}, new int[]{15, 195, 244, 9, 233, 71, os.a.f46207a, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, mb.e.f41073w1, 186, h0.K}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, 197, mb.e.f41067u1, 223, 155, 21, 5, h0.K, 254, 124, 12, 181, 184, 96, 50, s0.c.f49294u}, new int[]{hr.a.f31427a, mb.e.f41040l1, 43, 97, 71, 96, 103, mb.e.f41073w1, 37, rc.c.f48463k0, DoubleMath.MAX_FACTORIAL, 53, 75, 34, a4.d.f205j, 121, 17, 138, 110, 213, 141, 136, 120, rc.c.f48463k0, 233, os.a.f46207a, 93, 255}, new int[]{245, 127, m9.m.f40854e0, 218, 130, 250, 162, 181, 102, 120, 84, 179, 220, mb.e.f41067u1, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, HideBottomViewOnScrollBehavior.f19616g, 184, 59, 25, 225, 98, 81, 112}, new int[]{77, s0.c.f49294u, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, m9.m.f40854e0, 8, HideBottomViewOnScrollBehavior.f19616g, 95, 100, 9, 167, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, a.c.f52772h, 69, 50, 150, 177, 226, 5, 9, 5}, new int[]{245, 132, h0.K, 223, 96, 32, 117, 22, mb.e.f41061s1, 133, mb.e.f41061s1, mb.e.f41040l1, 205, 188, 237, 87, 191, 106, 16, uf.c.Ya, 118, 23, 37, 90, DoubleMath.MAX_FACTORIAL, 205, 131, 88, 120, 100, 66, 138, 186, 240, 82, 44, 176, 87, mb.e.f41031i2, uf.c.Ya, 160, HideBottomViewOnScrollBehavior.f19616g, 69, 213, 92, 253, 225, 19}, new int[]{HideBottomViewOnScrollBehavior.f19616g, 9, 223, mb.e.f41061s1, 12, 17, 220, 208, 100, 29, HideBottomViewOnScrollBehavior.f19616g, DoubleMath.MAX_FACTORIAL, WaspWingInfo.EXPERIMENTAL_RUN_MODE_COLD_LEVEL, 192, mb.e.f41076x1, 235, 150, 159, 36, 223, 38, 200, 132, 54, 228, 146, 218, 234, 117, a.c.f52773i, 29, 232, 144, mb.e.f41061s1, 22, 150, 201, 117, 62, a.c.f52776l, ISchedulers.SUB_CANCEL, 13, 137, 245, 127, 67, 247, 28, 155, 43, a.c.f52773i, 107, 233, 53, 143, 46}, new int[]{m9.m.f40854e0, 93, ob.h.H, 50, 144, ISchedulers.IS_M3U8_PEER, 39, 118, a.c.f52772h, 188, 201, a0.f47918w, 143, 108, 196, 37, NormalCmdFactory.TASK_CANCEL_ALL, 112, 134, WaspWingInfo.EXPERIMENTAL_RUN_MODE_COLD_LEVEL, 245, 63, 197, 190, 250, 106, NormalCmdFactory.TASK_CANCEL_ALL, 221, HideBottomViewOnScrollBehavior.f19616g, 64, 114, 71, 161, 44, uf.c.Ya, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, 163, 31, 176, DoubleMath.MAX_FACTORIAL, 4, 107, 232, 7, 94, 166, 224, 124, 86, 47, 11, a.c.f52774j}, new int[]{220, 228, WaspWingInfo.DEFAULT_COLD_LEVEL_OVERCLOCK_MIN, 89, mb.e.f41067u1, WaspWingInfo.COLD_LEVEL_STANDARD_B7, 159, 56, 89, 33, uf.c.Ya, 244, 154, 36, 73, 127, 213, 136, 248, 180, 234, 197, 158, 177, 68, 122, 93, 213, 15, 160, 227, 236, 66, 139, 153, NormalCmdFactory.TASK_CANCEL_ALL, a.c.f52772h, 167, 179, 25, 220, 232, 96, ISchedulers.IS_M3U8_PEER, mb.e.f41040l1, 136, 223, 239, 181, 241, 59, 52, h0.K, 25, 49, 232, hr.a.f31427a, a0.f47918w, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f21331d = new int[256];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f21332e = new int[255];

    static {
        int i10 = 1;
        for (int i11 = 0; i11 < 255; i11++) {
            f21332e[i11] = i10;
            f21331d[i10] = i11;
            i10 *= 2;
            if (i10 >= 256) {
                i10 ^= 301;
            }
        }
    }

    public static String a(CharSequence charSequence, int i10) {
        int i11 = 0;
        while (true) {
            int[] iArr = f21328a;
            if (i11 >= iArr.length) {
                i11 = -1;
                break;
            }
            if (iArr[i11] == i10) {
                break;
            }
            i11++;
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: " + i10);
        }
        int[] iArr2 = f21329b[i11];
        char[] cArr = new char[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            cArr[i12] = 0;
        }
        for (int i13 = 0; i13 < charSequence.length(); i13++) {
            int i14 = i10 - 1;
            int iCharAt = cArr[i14] ^ charSequence.charAt(i13);
            while (i14 > 0) {
                if (iCharAt == 0 || iArr2[i14] == 0) {
                    cArr[i14] = cArr[i14 - 1];
                } else {
                    char c10 = cArr[i14 - 1];
                    int[] iArr3 = f21332e;
                    int[] iArr4 = f21331d;
                    cArr[i14] = (char) (c10 ^ iArr3[(iArr4[iCharAt] + iArr4[iArr2[i14]]) % 255]);
                }
                i14--;
            }
            if (iCharAt == 0 || iArr2[0] == 0) {
                cArr[0] = 0;
            } else {
                int[] iArr5 = f21332e;
                int[] iArr6 = f21331d;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[iArr2[0]]) % 255];
            }
        }
        char[] cArr2 = new char[i10];
        for (int i15 = 0; i15 < i10; i15++) {
            cArr2[i15] = cArr[(i10 - i15) - 1];
        }
        return String.valueOf(cArr2);
    }

    public static String b(String str, k kVar) {
        if (str.length() != kVar.b()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb2 = new StringBuilder(kVar.b() + kVar.d());
        sb2.append(str);
        int iG = kVar.g();
        if (iG == 1) {
            sb2.append(a(str, kVar.d()));
        } else {
            sb2.setLength(sb2.capacity());
            int[] iArr = new int[iG];
            int[] iArr2 = new int[iG];
            int i10 = 0;
            while (i10 < iG) {
                int i11 = i10 + 1;
                iArr[i10] = kVar.c(i11);
                iArr2[i10] = kVar.e(i11);
                i10 = i11;
            }
            for (int i12 = 0; i12 < iG; i12++) {
                StringBuilder sb3 = new StringBuilder(iArr[i12]);
                for (int i13 = i12; i13 < kVar.b(); i13 += iG) {
                    sb3.append(str.charAt(i13));
                }
                String strA = a(sb3.toString(), iArr2[i12]);
                int i14 = i12;
                int i15 = 0;
                while (i14 < iArr2[i12] * iG) {
                    sb2.setCharAt(kVar.b() + i14, strA.charAt(i15));
                    i14 += iG;
                    i15++;
                }
            }
        }
        return sb2.toString();
    }
}
