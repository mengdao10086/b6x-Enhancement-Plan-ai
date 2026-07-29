package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import java.math.BigInteger;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
public final class DecodedBitStreamParser {
    public static final char[] A = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    public static final char[] B = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    public static final BigInteger[] C;
    public static final int D = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f21530a = 900;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21531b = 901;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21532c = 902;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21533d = 924;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f21534e = 925;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21535f = 926;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f21536g = 927;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f21537h = 928;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f21538i = 923;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f21539j = 922;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f21540k = 913;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f21541l = 15;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f21542m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f21543n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f21544o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f21545p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f21546q = 4;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f21547r = 5;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f21548s = 6;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f21549t = 25;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f21550u = 27;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f21551v = 27;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f21552w = 28;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f21553x = 28;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f21554y = 29;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f21555z = 29;

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21556a;

        static {
            int[] iArr = new int[Mode.values().length];
            f21556a = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21556a[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21556a[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21556a[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21556a[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21556a[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        C = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i10 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = C;
            if (i10 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i10] = bigIntegerArr2[i10 - 1].multiply(bigIntegerValueOf);
            i10++;
        }
    }

    public static int a(int i10, int[] iArr, int i11, af.i iVar) throws FormatException {
        int i12;
        boolean z10 = false;
        while (i11 < iArr[0] && !z10) {
            while (i11 < iArr[0] && iArr[i11] == 927) {
                int i13 = i11 + 1;
                iVar.f(iArr[i13]);
                i11 = i13 + 1;
            }
            if (i11 >= iArr[0] || iArr[i11] >= 900) {
                z10 = true;
            } else {
                long j10 = 0;
                int i14 = 0;
                while (true) {
                    i12 = i11 + 1;
                    j10 = (j10 * 900) + ((long) iArr[i11]);
                    i14++;
                    if (i14 >= 5 || i12 >= iArr[0] || iArr[i12] >= 900) {
                        break;
                    }
                    i11 = i12;
                }
                if (i14 != 5 || (i10 != 924 && (i12 >= iArr[0] || iArr[i12] >= 900))) {
                    i12 -= i14;
                    while (i12 < iArr[0] && !z10) {
                        int i15 = i12 + 1;
                        int i16 = iArr[i12];
                        if (i16 < 900) {
                            iVar.a((byte) i16);
                            i12 = i15;
                        } else if (i16 == 927) {
                            iVar.f(iArr[i15]);
                            i12 = i15 + 1;
                        } else {
                            i12 = i15 - 1;
                            z10 = true;
                        }
                    }
                } else {
                    for (int i17 = 0; i17 < 6; i17++) {
                        iVar.a((byte) (j10 >> ((5 - i17) * 8)));
                    }
                }
                i11 = i12;
            }
        }
        return i11;
    }

    public static af.d b(int[] iArr, String str) throws FormatException {
        int i10;
        af.i iVar = new af.i(iArr.length * 2);
        int iG = g(iArr, 1, iVar);
        kf.c cVar = new kf.c();
        while (iG < iArr[0]) {
            int i11 = iG + 1;
            int i12 = iArr[iG];
            if (i12 != 913) {
                switch (i12) {
                    case 900:
                        iG = g(iArr, i11, iVar);
                        continue;
                    case 901:
                        break;
                    case 902:
                        iG = f(iArr, i11, iVar);
                        continue;
                    default:
                        switch (i12) {
                            case f21539j /* 922 */:
                            case f21538i /* 923 */:
                                throw FormatException.b();
                            case 924:
                                break;
                            case 925:
                                i10 = i11 + 1;
                                iG = i10;
                                break;
                            case 926:
                                i10 = i11 + 2;
                                iG = i10;
                                break;
                            case 927:
                                iG = i11 + 1;
                                iVar.f(iArr[i11]);
                                break;
                            case 928:
                                iG = d(iArr, i11, cVar);
                                break;
                            default:
                                iG = g(iArr, i11 - 1, iVar);
                                break;
                        }
                        break;
                }
                iG = a(i12, iArr, i11, iVar);
            } else {
                iG = i11 + 1;
                iVar.b((char) iArr[i11]);
            }
        }
        if (iVar.h() && cVar.c() == null) {
            throw FormatException.b();
        }
        af.d dVar = new af.d(null, iVar.toString(), null, str);
        dVar.p(cVar);
        return dVar;
    }

    public static String c(int[] iArr, int i10) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i11 = 0; i11 < i10; i11++) {
            bigIntegerAdd = bigIntegerAdd.add(C[(i10 - i11) - 1].multiply(BigInteger.valueOf(iArr[i11])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw FormatException.b();
    }

    public static int d(int[] iArr, int i10, kf.c cVar) throws FormatException {
        if (i10 + 2 > iArr[0]) {
            throw FormatException.b();
        }
        int[] iArr2 = new int[2];
        int i11 = 0;
        while (i11 < 2) {
            iArr2[i11] = iArr[i10];
            i11++;
            i10++;
        }
        String strC = c(iArr2, 2);
        if (strC.isEmpty()) {
            cVar.t(0);
        } else {
            try {
                cVar.t(Integer.parseInt(strC));
            } catch (NumberFormatException unused) {
                throw FormatException.b();
            }
        }
        StringBuilder sb2 = new StringBuilder();
        while (i10 < iArr[0] && i10 < iArr.length && iArr[i10] != 922 && iArr[i10] != 923) {
            sb2.append(String.format("%03d", Integer.valueOf(iArr[i10])));
            i10++;
        }
        if (sb2.length() == 0) {
            throw FormatException.b();
        }
        cVar.n(sb2.toString());
        int i12 = iArr[i10] == 923 ? i10 + 1 : -1;
        while (i10 < iArr[0]) {
            int i13 = iArr[i10];
            if (i13 == 922) {
                i10++;
                cVar.q(true);
            } else {
                if (i13 != 923) {
                    throw FormatException.b();
                }
                int i14 = i10 + 1;
                switch (iArr[i14]) {
                    case 0:
                        af.i iVar = new af.i();
                        i10 = g(iArr, i14 + 1, iVar);
                        cVar.o(iVar.toString());
                        break;
                    case 1:
                        af.i iVar2 = new af.i();
                        i10 = f(iArr, i14 + 1, iVar2);
                        try {
                            cVar.s(Integer.parseInt(iVar2.toString()));
                        } catch (NumberFormatException unused2) {
                            throw FormatException.b();
                        }
                        break;
                    case 2:
                        af.i iVar3 = new af.i();
                        i10 = f(iArr, i14 + 1, iVar3);
                        try {
                            cVar.v(Long.parseLong(iVar3.toString()));
                        } catch (NumberFormatException unused3) {
                            throw FormatException.b();
                        }
                        break;
                    case 3:
                        af.i iVar4 = new af.i();
                        i10 = g(iArr, i14 + 1, iVar4);
                        cVar.u(iVar4.toString());
                        break;
                    case 4:
                        af.i iVar5 = new af.i();
                        i10 = g(iArr, i14 + 1, iVar5);
                        cVar.l(iVar5.toString());
                        break;
                    case 5:
                        af.i iVar6 = new af.i();
                        i10 = f(iArr, i14 + 1, iVar6);
                        try {
                            cVar.p(Long.parseLong(iVar6.toString()));
                        } catch (NumberFormatException unused4) {
                            throw FormatException.b();
                        }
                        break;
                    case 6:
                        af.i iVar7 = new af.i();
                        i10 = f(iArr, i14 + 1, iVar7);
                        try {
                            cVar.m(Integer.parseInt(iVar7.toString()));
                        } catch (NumberFormatException unused5) {
                            throw FormatException.b();
                        }
                        break;
                    default:
                        throw FormatException.b();
                }
            }
        }
        if (i12 != -1) {
            int i15 = i10 - i12;
            if (cVar.k()) {
                i15--;
            }
            if (i15 > 0) {
                cVar.r(Arrays.copyOfRange(iArr, i12, i15 + i12));
            }
        }
        return i10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0020. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode e(int[] r15, int[] r16, int r17, af.i r18, com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode r19) {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.e(int[], int[], int, af.i, com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode):com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int f(int[] r7, int r8, af.i r9) throws com.google.zxing.FormatException {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = 0
            r3 = 0
        L7:
            r4 = r7[r1]
            if (r8 >= r4) goto L4b
            if (r2 != 0) goto L4b
            int r4 = r8 + 1
            r8 = r7[r8]
            r5 = r7[r1]
            r6 = 1
            if (r4 != r5) goto L17
            r2 = 1
        L17:
            r5 = 900(0x384, float:1.261E-42)
            if (r8 >= r5) goto L20
            r0[r3] = r8
            int r3 = r3 + 1
            goto L35
        L20:
            if (r8 == r5) goto L32
            r5 = 901(0x385, float:1.263E-42)
            if (r8 == r5) goto L32
            r5 = 927(0x39f, float:1.299E-42)
            if (r8 == r5) goto L32
            r5 = 928(0x3a0, float:1.3E-42)
            if (r8 == r5) goto L32
            switch(r8) {
                case 922: goto L32;
                case 923: goto L32;
                case 924: goto L32;
                default: goto L31;
            }
        L31:
            goto L35
        L32:
            int r4 = r4 + (-1)
            r2 = 1
        L35:
            int r5 = r3 % 15
            if (r5 == 0) goto L3f
            r5 = 902(0x386, float:1.264E-42)
            if (r8 == r5) goto L3f
            if (r2 == 0) goto L49
        L3f:
            if (r3 <= 0) goto L49
            java.lang.String r8 = c(r0, r3)
            r9.d(r8)
            r3 = 0
        L49:
            r8 = r4
            goto L7
        L4b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.f(int[], int, af.i):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048 A[FALL_THROUGH] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int g(int[] r10, int r11, af.i r12) throws com.google.zxing.FormatException {
        /*
            r0 = 0
            r1 = r10[r0]
            int r1 = r1 - r11
            int r1 = r1 * 2
            int[] r1 = new int[r1]
            r2 = r10[r0]
            int r2 = r2 - r11
            int r2 = r2 * 2
            int[] r2 = new int[r2]
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r3 = com.google.zxing.pdf417.decoder.DecodedBitStreamParser.Mode.ALPHA
            r4 = 0
            r5 = 0
        L13:
            r6 = r10[r0]
            if (r11 >= r6) goto L80
            if (r4 != 0) goto L80
            int r6 = r11 + 1
            r11 = r10[r11]
            r7 = 900(0x384, float:1.261E-42)
            if (r11 >= r7) goto L2e
            int r7 = r11 / 30
            r1[r5] = r7
            int r7 = r5 + 1
            int r11 = r11 % 30
            r1[r7] = r11
            int r5 = r5 + 2
            goto L40
        L2e:
            r8 = 913(0x391, float:1.28E-42)
            if (r11 == r8) goto L75
            r8 = 927(0x39f, float:1.299E-42)
            if (r11 == r8) goto L4c
            r8 = 928(0x3a0, float:1.3E-42)
            if (r11 == r8) goto L48
            switch(r11) {
                case 900: goto L42;
                case 901: goto L48;
                case 902: goto L48;
                default: goto L3d;
            }
        L3d:
            switch(r11) {
                case 922: goto L48;
                case 923: goto L48;
                case 924: goto L48;
                default: goto L40;
            }
        L40:
            r11 = r6
            goto L13
        L42:
            int r11 = r5 + 1
            r1[r5] = r7
            r5 = r11
            goto L40
        L48:
            int r6 = r6 + (-1)
            r4 = 1
            goto L40
        L4c:
            com.google.zxing.pdf417.decoder.DecodedBitStreamParser$Mode r11 = e(r1, r2, r5, r12, r3)
            int r1 = r6 + 1
            r2 = r10[r6]
            r12.f(r2)
            r2 = r10[r0]
            if (r1 > r2) goto L70
            r2 = r10[r0]
            int r2 = r2 - r1
            int r2 = r2 * 2
            int[] r2 = new int[r2]
            r3 = r10[r0]
            int r3 = r3 - r1
            int r3 = r3 * 2
            int[] r3 = new int[r3]
            r5 = 0
            r9 = r3
            r3 = r11
            r11 = r1
            r1 = r2
            r2 = r9
            goto L13
        L70:
            com.google.zxing.FormatException r10 = com.google.zxing.FormatException.b()
            throw r10
        L75:
            r1[r5] = r8
            int r11 = r6 + 1
            r6 = r10[r6]
            r2[r5] = r6
            int r5 = r5 + 1
            goto L13
        L80:
            e(r1, r2, r5, r12, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.g(int[], int, af.i):int");
    }
}
