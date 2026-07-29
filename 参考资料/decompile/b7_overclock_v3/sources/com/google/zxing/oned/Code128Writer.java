package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
public final class Code128Writer extends r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f21373b = 103;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f21374c = 104;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f21375d = 105;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f21376e = 101;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f21377f = 100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f21378g = 99;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f21379h = 106;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final char f21380i = 241;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char f21381j = 242;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char f21382k = 243;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final char f21383l = 244;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f21384m = 102;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f21385n = 97;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f21386o = 96;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f21387p = 101;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f21388q = 100;

    public enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static final class MinimalEncoder {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f21389c = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001fÿ";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f21390d = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\u007fÿ";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f21391e = 98;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ boolean f21392f = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[][] f21393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Latch[][] f21394b;

        public enum Charset {
            A,
            B,
            C,
            NONE
        }

        public enum Latch {
            A,
            B,
            C,
            SHIFT,
            NONE
        }

        public MinimalEncoder() {
        }

        public static void b(Collection<int[]> collection, int i10, int[] iArr, int[] iArr2, int i11) {
            collection.add(c.f21412a[i10]);
            if (i11 != 0) {
                iArr2[0] = iArr2[0] + 1;
            }
            iArr[0] = iArr[0] + (i10 * iArr2[0]);
        }

        public static boolean f(char c10) {
            return c10 >= '0' && c10 <= '9';
        }

        public final boolean c(CharSequence charSequence, Charset charset, int i10) {
            int i11;
            char cCharAt = charSequence.charAt(i10);
            int i12 = a.f21396b[charset.ordinal()];
            if (i12 == 1) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || f21389c.indexOf(cCharAt) >= 0;
            }
            if (i12 == 2) {
                return cCharAt == 241 || cCharAt == 242 || cCharAt == 243 || cCharAt == 244 || f21390d.indexOf(cCharAt) >= 0;
            }
            if (i12 != 3) {
                return false;
            }
            return cCharAt == 241 || ((i11 = i10 + 1) < charSequence.length() && f(cCharAt) && f(charSequence.charAt(i11)));
        }

        public final int d(CharSequence charSequence, Charset charset, int i10) {
            int iD;
            int iD2;
            int i11 = this.f21393a[charset.ordinal()][i10];
            if (i11 > 0) {
                return i11;
            }
            Latch latch = Latch.NONE;
            int i12 = i10 + 1;
            boolean z10 = i12 >= charSequence.length();
            Charset[] charsetArr = {Charset.A, Charset.B};
            int i13 = Integer.MAX_VALUE;
            for (int i14 = 0; i14 <= 1; i14++) {
                if (c(charSequence, charsetArr[i14], i10)) {
                    Latch latchValueOf = Latch.NONE;
                    if (charset != charsetArr[i14]) {
                        latchValueOf = Latch.valueOf(charsetArr[i14].toString());
                        iD2 = 2;
                    } else {
                        iD2 = 1;
                    }
                    if (!z10) {
                        iD2 += d(charSequence, charsetArr[i14], i12);
                    }
                    if (iD2 < i13) {
                        latch = latchValueOf;
                        i13 = iD2;
                    }
                    if (charset == charsetArr[(i14 + 1) % 2]) {
                        Latch latch2 = Latch.SHIFT;
                        int iD3 = !z10 ? d(charSequence, charset, i12) + 2 : 2;
                        if (iD3 < i13) {
                            latch = latch2;
                            i13 = iD3;
                        }
                    }
                }
            }
            Charset charset2 = Charset.C;
            if (c(charSequence, charset2, i10)) {
                Latch latch3 = Latch.NONE;
                if (charset != charset2) {
                    latch3 = Latch.C;
                    iD = 2;
                } else {
                    iD = 1;
                }
                int i15 = (charSequence.charAt(i10) != 241 ? 2 : 1) + i10;
                if (i15 < charSequence.length()) {
                    iD += d(charSequence, charset2, i15);
                }
                if (iD < i13) {
                    latch = latch3;
                    i13 = iD;
                }
            }
            if (i13 != Integer.MAX_VALUE) {
                this.f21393a[charset.ordinal()][i10] = i13;
                this.f21394b[charset.ordinal()][i10] = latch;
                return i13;
            }
            throw new IllegalArgumentException("Bad character in input: ASCII value=" + ((int) charSequence.charAt(i10)));
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x009c  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean[] e(java.lang.String r17) {
            /*
                Method dump skipped, instruction units count: 280
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.MinimalEncoder.e(java.lang.String):boolean[]");
        }

        public /* synthetic */ MinimalEncoder(a aVar) {
            this();
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f21396b;

        static {
            int[] iArr = new int[MinimalEncoder.Charset.values().length];
            f21396b = iArr;
            try {
                iArr[MinimalEncoder.Charset.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21396b[MinimalEncoder.Charset.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21396b[MinimalEncoder.Charset.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[MinimalEncoder.Latch.values().length];
            f21395a = iArr2;
            try {
                iArr2[MinimalEncoder.Latch.A.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21395a[MinimalEncoder.Latch.B.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21395a[MinimalEncoder.Latch.C.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21395a[MinimalEncoder.Latch.SHIFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int j(java.lang.String r6, java.util.Map<com.google.zxing.EncodeHintType, ?> r7) {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.j(java.lang.String, java.util.Map):int");
    }

    public static int k(CharSequence charSequence, int i10, int i11) {
        CType cTypeM;
        CType cTypeM2;
        char cCharAt;
        CType cTypeM3 = m(charSequence, i10);
        CType cType = CType.ONE_DIGIT;
        if (cTypeM3 == cType) {
            return i11 == 101 ? 101 : 100;
        }
        CType cType2 = CType.UNCODABLE;
        if (cTypeM3 == cType2) {
            return (i10 >= charSequence.length() || ((cCharAt = charSequence.charAt(i10)) >= ' ' && (i11 != 101 || (cCharAt >= '`' && (cCharAt < 241 || cCharAt > 244))))) ? 100 : 101;
        }
        if (i11 == 101 && cTypeM3 == CType.FNC_1) {
            return 101;
        }
        if (i11 == 99) {
            return 99;
        }
        if (i11 != 100) {
            if (cTypeM3 == CType.FNC_1) {
                cTypeM3 = m(charSequence, i10 + 1);
            }
            return cTypeM3 == CType.TWO_DIGITS ? 99 : 100;
        }
        CType cType3 = CType.FNC_1;
        if (cTypeM3 == cType3 || (cTypeM = m(charSequence, i10 + 2)) == cType2 || cTypeM == cType) {
            return 100;
        }
        if (cTypeM == cType3) {
            return m(charSequence, i10 + 3) == CType.TWO_DIGITS ? 99 : 100;
        }
        int i12 = i10 + 4;
        while (true) {
            cTypeM2 = m(charSequence, i12);
            if (cTypeM2 != CType.TWO_DIGITS) {
                break;
            }
            i12 += 2;
        }
        return cTypeM2 == CType.ONE_DIGIT ? 100 : 99;
    }

    public static boolean[] l(String str, int i10) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 1;
        while (i11 < length) {
            int iK = i10 == -1 ? k(str, i11, i13) : i10;
            int iCharAt = 100;
            if (iK == i13) {
                switch (str.charAt(i11)) {
                    case 241:
                        iCharAt = 102;
                        break;
                    case m9.m.f40854e0 /* 242 */:
                        iCharAt = 97;
                        break;
                    case 243:
                        iCharAt = 96;
                        break;
                    case 244:
                        if (i13 == 101) {
                            iCharAt = 101;
                        }
                        break;
                    default:
                        if (i13 == 100) {
                            iCharAt = str.charAt(i11) - ' ';
                        } else if (i13 == 101) {
                            iCharAt = str.charAt(i11) - ' ';
                            if (iCharAt < 0) {
                                iCharAt += 96;
                            }
                        } else {
                            int i15 = i11 + 1;
                            if (i15 == length) {
                                throw new IllegalArgumentException("Bad number of characters for digit only encoding.");
                            }
                            iCharAt = Integer.parseInt(str.substring(i11, i11 + 2));
                            i11 = i15;
                        }
                        break;
                }
                i11++;
            } else {
                iCharAt = i13 == 0 ? iK != 100 ? iK != 101 ? 105 : 103 : 104 : iK;
                i13 = iK;
            }
            arrayList.add(c.f21412a[iCharAt]);
            i12 += iCharAt * i14;
            if (i11 != 0) {
                i14++;
            }
        }
        return n(arrayList, i12);
    }

    public static CType m(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        if (i10 >= length) {
            return CType.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i10);
        if (cCharAt == 241) {
            return CType.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return CType.UNCODABLE;
        }
        int i11 = i10 + 1;
        if (i11 >= length) {
            return CType.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i11);
        return (cCharAt2 < '0' || cCharAt2 > '9') ? CType.ONE_DIGIT : CType.TWO_DIGITS;
    }

    public static boolean[] n(Collection<int[]> collection, int i10) {
        int[][] iArr = c.f21412a;
        collection.add(iArr[i10 % 103]);
        collection.add(iArr[106]);
        int iC = 0;
        int i11 = 0;
        for (int[] iArr2 : collection) {
            for (int i12 : iArr2) {
                i11 += i12;
            }
        }
        boolean[] zArr = new boolean[i11];
        Iterator<int[]> it2 = collection.iterator();
        while (it2.hasNext()) {
            iC += r.c(zArr, iC, it2.next(), true);
        }
        return zArr;
    }

    @Override // com.google.zxing.oned.r
    public boolean[] e(String str) {
        return f(str, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001e  */
    @Override // com.google.zxing.oned.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean[] f(java.lang.String r4, java.util.Map<com.google.zxing.EncodeHintType, ?> r5) {
        /*
            r3 = this;
            int r0 = j(r4, r5)
            if (r5 == 0) goto L1e
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.CODE128_COMPACT
            boolean r2 = r5.containsKey(r1)
            if (r2 == 0) goto L1e
            java.lang.Object r5 = r5.get(r1)
            java.lang.String r5 = r5.toString()
            boolean r5 = java.lang.Boolean.parseBoolean(r5)
            if (r5 == 0) goto L1e
            r5 = 1
            goto L1f
        L1e:
            r5 = 0
        L1f:
            if (r5 == 0) goto L2c
            com.google.zxing.oned.Code128Writer$MinimalEncoder r5 = new com.google.zxing.oned.Code128Writer$MinimalEncoder
            r0 = 0
            r5.<init>(r0)
            boolean[] r4 = com.google.zxing.oned.Code128Writer.MinimalEncoder.a(r5, r4)
            goto L30
        L2c:
            boolean[] r4 = l(r4, r0)
        L30:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.Code128Writer.f(java.lang.String, java.util.Map):boolean[]");
    }

    @Override // com.google.zxing.oned.r
    public Collection<BarcodeFormat> h() {
        return Collections.singleton(BarcodeFormat.CODE_128);
    }
}
