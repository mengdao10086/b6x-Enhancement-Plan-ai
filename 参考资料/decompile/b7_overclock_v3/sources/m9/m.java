package m9;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes3.dex */
public final class m {
    public static final int A = 27;
    public static final int B = 28;
    public static final int C = 29;
    public static final int D = 30;
    public static final int E = 31;
    public static final int F = 32;
    public static final int G = 33;
    public static final int H = 34;
    public static final int I = 35;
    public static final int J = 36;
    public static final int K = 37;
    public static final int L = 38;
    public static final int M = 39;
    public static final int N = 40;
    public static final int O = 41;
    public static final int P = 42;
    public static final int Q = 43;
    public static final int R = 44;
    public static final int S = 45;
    public static final int T = 46;
    public static final int U = 47;
    public static final int V = 48;
    public static final int W = 49;
    public static final int X = 50;
    public static final int Y = 51;
    public static final int Z = 52;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final m f40845a = new m();

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final int f40846a0 = 53;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f40847b = 0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final int f40848b0 = 54;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f40849c = 1;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final int f40850c0 = 240;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f40851d = 2;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int f40852d0 = 241;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f40853e = 3;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int f40854e0 = 242;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f40855f = 4;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final int f40856f0 = 255;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f40857g = 5;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final int f40858g0 = 256;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f40859h = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f40860i = 7;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f40861j = 8;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f40862k = 9;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f40863l = 10;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f40864m = 11;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f40865n = 12;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f40866o = 13;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f40867p = 14;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f40868q = 15;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f40869r = 18;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f40870s = 19;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f40871t = 20;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f40872u = 21;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f40873v = 22;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f40874w = 23;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f40875x = 24;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f40876y = 25;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f40877z = 26;

    @sj.c(AnnotationRetention.SOURCE)
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @hk.m
    public static final boolean a(int i10) {
        return b(i10, -1, -1);
    }

    @hk.m
    public static final boolean b(int i10, int i11, int i12) {
        if (21 <= i10 && i10 < 37) {
            return true;
        }
        if ((44 <= i10 && i10 < 52) || i10 == 256) {
            return true;
        }
        return (i11 == -1 || i12 == -1) ? false : true;
    }

    @hk.m
    public static final int c(int i10) {
        switch (i10) {
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
                return 12;
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
                return 10;
            default:
                switch (i10) {
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                        return 39;
                    case 48:
                    case 49:
                    case 50:
                    case 51:
                        return 40;
                    default:
                        return -1;
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0019 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001b A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0014 A[RETURN, SYNTHETIC] */
    @hk.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int d(int r0) {
        /*
            switch(r0) {
                case 21: goto L1b;
                case 22: goto L19;
                case 23: goto L17;
                case 24: goto L14;
                case 25: goto L11;
                case 26: goto Le;
                case 27: goto Lb;
                case 28: goto L8;
                case 29: goto L1b;
                case 30: goto L19;
                case 31: goto L17;
                case 32: goto L14;
                case 33: goto L11;
                case 34: goto Le;
                case 35: goto Lb;
                case 36: goto L8;
                default: goto L3;
            }
        L3:
            switch(r0) {
                case 44: goto L1b;
                case 45: goto L19;
                case 46: goto L17;
                case 47: goto L14;
                case 48: goto L1b;
                case 49: goto L19;
                case 50: goto L17;
                case 51: goto L14;
                default: goto L6;
            }
        L6:
            r0 = -1
            goto L1c
        L8:
            r0 = 38
            goto L1c
        Lb:
            r0 = 37
            goto L1c
        Le:
            r0 = 13
            goto L1c
        L11:
            r0 = 11
            goto L1c
        L14:
            r0 = 8
            goto L1c
        L17:
            r0 = 7
            goto L1c
        L19:
            r0 = 5
            goto L1c
        L1b:
            r0 = 4
        L1c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m9.m.d(int):int");
    }
}
