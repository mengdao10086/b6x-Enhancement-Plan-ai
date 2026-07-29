package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bp;

/* JADX INFO: loaded from: classes5.dex */
public class by {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f23445a = Integer.MAX_VALUE;

    public static void a(int i10) {
        f23445a = i10;
    }

    public static void a(bv bvVar, byte b10) throws bc {
        a(bvVar, b10, f23445a);
    }

    public static void a(bv bvVar, byte b10, int i10) throws bc {
        if (i10 > 0) {
            int i11 = 0;
            switch (b10) {
                case 2:
                    bvVar.t();
                    return;
                case 3:
                    bvVar.u();
                    return;
                case 4:
                    bvVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    bvVar.v();
                    return;
                case 8:
                    bvVar.w();
                    return;
                case 10:
                    bvVar.x();
                    return;
                case 11:
                    bvVar.A();
                    return;
                case 12:
                    bvVar.j();
                    while (true) {
                        byte b11 = bvVar.l().f23422b;
                        if (b11 == 0) {
                            bvVar.k();
                            return;
                        } else {
                            a(bvVar, b11, i10 - 1);
                            bvVar.m();
                        }
                    }
                    break;
                case 13:
                    bs bsVarN = bvVar.n();
                    while (i11 < bsVarN.f23428c) {
                        int i12 = i10 - 1;
                        a(bvVar, bsVarN.f23426a, i12);
                        a(bvVar, bsVarN.f23427b, i12);
                        i11++;
                    }
                    bvVar.o();
                    return;
                case 14:
                    bz bzVarR = bvVar.r();
                    while (i11 < bzVarR.f23447b) {
                        a(bvVar, bzVarR.f23446a, i10 - 1);
                        i11++;
                    }
                    bvVar.s();
                    return;
                case 15:
                    br brVarP = bvVar.p();
                    while (i11 < brVarP.f23425b) {
                        a(bvVar, brVarP.f23424a, i10 - 1);
                        i11++;
                    }
                    bvVar.q();
                    return;
            }
        } else {
            throw new bc("Maximum skip depth exceeded");
        }
    }

    public static bx a(byte[] bArr, bx bxVar) {
        if (bArr[0] > 16) {
            return new bp.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? bxVar : new bp.a();
    }
}
