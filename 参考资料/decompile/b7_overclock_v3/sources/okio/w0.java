package okio;

import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "Utf8")
@kotlin.d0(bv = {}, d1 = {"\u0000<\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\f\n\u0002\b\u0010\u001a'\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0001H\u0080\b\u001a\u0011\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0080\b\u001a4\u0010\u0010\u001a\u00020\u000e*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000e0\rH\u0080\bø\u0001\u0000\u001a4\u0010\u0012\u001a\u00020\u000e*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\rH\u0080\bø\u0001\u0000\u001a4\u0010\u0014\u001a\u00020\u000e*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000e0\rH\u0080\bø\u0001\u0000\u001a4\u0010\u0015\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\rH\u0080\bø\u0001\u0000\u001a4\u0010\u0016\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\rH\u0080\bø\u0001\u0000\u001a4\u0010\u0017\u001a\u00020\u0001*\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\rH\u0080\bø\u0001\u0000\"\u0014\u0010\u0019\u001a\u00020\n8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\t\u0010\u0018\"\u0014\u0010\u001b\u001a\u00020\u00138\u0000X\u0080T¢\u0006\u0006\n\u0004\b\f\u0010\u001a\"\u0014\u0010\u001d\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u001c\"\u0014\u0010\u001e\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0016\u0010\u001c\"\u0014\u0010\u001f\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0017\u0010\u001c\"\u0014\u0010 \u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0014\u0010\u001c\"\u0014\u0010!\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0010\u0010\u001c\"\u0014\u0010\"\u001a\u00020\u00018\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0012\u0010\u001c\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"", "", "beginIndex", "endIndex", "", "k", "(Ljava/lang/String;II)J", "codePoint", "", "a", "", "byte", "b", "Lkotlin/Function1;", "Lkotlin/z1;", "yield", "g", "", "h", "", "f", "c", "d", "e", "B", "REPLACEMENT_BYTE", "C", "REPLACEMENT_CHARACTER", "I", "REPLACEMENT_CODE_POINT", "HIGH_SURROGATE_HEADER", "LOG_SURROGATE_HEADER", "MASK_2BYTES", "MASK_3BYTES", "MASK_4BYTES", "okio"}, k = 2, mv = {1, 5, 1})
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f44229a = 63;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char f44230b = 65533;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f44231c = 65533;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f44232d = 55232;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f44233e = 56320;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f44234f = 3968;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f44235g = -123008;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f44236h = 3678080;

    public static final boolean a(int i10) {
        if (i10 >= 0 && i10 <= 31) {
            return true;
        }
        return 127 <= i10 && i10 <= 159;
    }

    public static final boolean b(byte b10) {
        return (b10 & i1.a.f31667o7) == 128;
    }

    public static final int c(@yt.k byte[] bArr, int i10, int i11, @yt.k ik.l<? super Integer, z1> yield) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(yield, "yield");
        int i12 = i10 + 1;
        Integer numValueOf = Integer.valueOf(f44231c);
        if (i11 <= i12) {
            yield.i(numValueOf);
            return 1;
        }
        byte b10 = bArr[i10];
        byte b11 = bArr[i12];
        if (!((b11 & i1.a.f31667o7) == 128)) {
            yield.i(numValueOf);
            return 1;
        }
        int i13 = (b11 ^ 3968) ^ (b10 << 6);
        if (i13 < 128) {
            yield.i(numValueOf);
            return 2;
        }
        yield.i(Integer.valueOf(i13));
        return 2;
    }

    public static final int d(@yt.k byte[] bArr, int i10, int i11, @yt.k ik.l<? super Integer, z1> yield) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(yield, "yield");
        int i12 = i10 + 2;
        Integer numValueOf = Integer.valueOf(f44231c);
        if (i11 <= i12) {
            yield.i(numValueOf);
            int i13 = i10 + 1;
            if (i11 > i13) {
                if ((bArr[i13] & i1.a.f31667o7) == 128) {
                    return 2;
                }
            }
            return 1;
        }
        byte b10 = bArr[i10];
        byte b11 = bArr[i10 + 1];
        if (!((b11 & i1.a.f31667o7) == 128)) {
            yield.i(numValueOf);
            return 1;
        }
        byte b12 = bArr[i12];
        if (!((b12 & i1.a.f31667o7) == 128)) {
            yield.i(numValueOf);
            return 2;
        }
        int i14 = ((b12 ^ (-123008)) ^ (b11 << 6)) ^ (b10 << 12);
        if (i14 < 2048) {
            yield.i(numValueOf);
            return 3;
        }
        if (55296 <= i14 && i14 <= 57343) {
            z = true;
        }
        if (z) {
            yield.i(numValueOf);
            return 3;
        }
        yield.i(Integer.valueOf(i14));
        return 3;
    }

    public static final int e(@yt.k byte[] bArr, int i10, int i11, @yt.k ik.l<? super Integer, z1> yield) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(yield, "yield");
        int i12 = i10 + 3;
        Integer numValueOf = Integer.valueOf(f44231c);
        if (i11 <= i12) {
            yield.i(numValueOf);
            int i13 = i10 + 1;
            if (i11 > i13) {
                if ((bArr[i13] & i1.a.f31667o7) == 128) {
                    int i14 = i10 + 2;
                    if (i11 > i14) {
                        if ((bArr[i14] & i1.a.f31667o7) == 128) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b10 = bArr[i10];
        byte b11 = bArr[i10 + 1];
        if (!((b11 & i1.a.f31667o7) == 128)) {
            yield.i(numValueOf);
            return 1;
        }
        byte b12 = bArr[i10 + 2];
        if (!((b12 & i1.a.f31667o7) == 128)) {
            yield.i(numValueOf);
            return 2;
        }
        byte b13 = bArr[i12];
        if (!((b13 & i1.a.f31667o7) == 128)) {
            yield.i(numValueOf);
            return 3;
        }
        int i15 = (((b13 ^ 3678080) ^ (b12 << 6)) ^ (b11 << 12)) ^ (b10 << 18);
        if (i15 > 1114111) {
            yield.i(numValueOf);
            return 4;
        }
        if (55296 <= i15 && i15 <= 57343) {
            z = true;
        }
        if (z) {
            yield.i(numValueOf);
            return 4;
        }
        if (i15 < 65536) {
            yield.i(numValueOf);
            return 4;
        }
        yield.i(Integer.valueOf(i15));
        return 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(@yt.k byte[] r16, int r17, int r18, @yt.k ik.l<? super java.lang.Character, kotlin.z1> r19) {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.w0.f(byte[], int, int, ik.l):void");
    }

    public static final void g(@yt.k String str, int i10, int i11, @yt.k ik.l<? super Byte, z1> yield) {
        int i12;
        kotlin.jvm.internal.f0.p(str, "<this>");
        kotlin.jvm.internal.f0.p(yield, "yield");
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (kotlin.jvm.internal.f0.t(cCharAt, 128) < 0) {
                yield.i(Byte.valueOf((byte) cCharAt));
                i10++;
                while (i10 < i11 && kotlin.jvm.internal.f0.t(str.charAt(i10), 128) < 0) {
                    yield.i(Byte.valueOf((byte) str.charAt(i10)));
                    i10++;
                }
            } else {
                if (kotlin.jvm.internal.f0.t(cCharAt, 2048) < 0) {
                    yield.i(Byte.valueOf((byte) ((cCharAt >> 6) | 192)));
                    yield.i(Byte.valueOf((byte) ((cCharAt & '?') | 128)));
                } else {
                    boolean z10 = false;
                    if (55296 <= cCharAt && cCharAt <= 57343) {
                        if (kotlin.jvm.internal.f0.t(cCharAt, 56319) <= 0 && i11 > (i12 = i10 + 1)) {
                            char cCharAt2 = str.charAt(i12);
                            if (56320 <= cCharAt2 && cCharAt2 <= 57343) {
                                z10 = true;
                            }
                            if (z10) {
                                int iCharAt = ((cCharAt << '\n') + str.charAt(i12)) - 56613888;
                                yield.i(Byte.valueOf((byte) ((iCharAt >> 18) | 240)));
                                yield.i(Byte.valueOf((byte) (((iCharAt >> 12) & 63) | 128)));
                                yield.i(Byte.valueOf((byte) (((iCharAt >> 6) & 63) | 128)));
                                yield.i(Byte.valueOf((byte) ((iCharAt & 63) | 128)));
                                i10 += 2;
                            }
                        }
                        yield.i(Byte.valueOf(f44229a));
                    } else {
                        yield.i(Byte.valueOf((byte) ((cCharAt >> '\f') | 224)));
                        yield.i(Byte.valueOf((byte) (((cCharAt >> 6) & 63) | 128)));
                        yield.i(Byte.valueOf((byte) ((cCharAt & '?') | 128)));
                    }
                }
                i10++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void h(@yt.k byte[] r16, int r17, int r18, @yt.k ik.l<? super java.lang.Integer, kotlin.z1> r19) {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.w0.h(byte[], int, int, ik.l):void");
    }

    @hk.h(name = "size")
    @hk.i
    public static final long i(@yt.k String str) {
        kotlin.jvm.internal.f0.p(str, "<this>");
        return l(str, 0, 0, 3, null);
    }

    @hk.h(name = "size")
    @hk.i
    public static final long j(@yt.k String str, int i10) {
        kotlin.jvm.internal.f0.p(str, "<this>");
        return l(str, i10, 0, 2, null);
    }

    @hk.h(name = "size")
    @hk.i
    public static final long k(@yt.k String str, int i10, int i11) {
        int i12;
        kotlin.jvm.internal.f0.p(str, "<this>");
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("beginIndex < 0: ", Integer.valueOf(i10)).toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i11 + " < " + i10).toString());
        }
        if (!(i11 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i11 + " > " + str.length()).toString());
        }
        long j10 = 0;
        while (i10 < i11) {
            char cCharAt = str.charAt(i10);
            if (cCharAt < 128) {
                j10++;
            } else {
                if (cCharAt < 2048) {
                    i12 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i12 = 3;
                } else {
                    int i13 = i10 + 1;
                    char cCharAt2 = i13 < i11 ? str.charAt(i13) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j10++;
                        i10 = i13;
                    } else {
                        j10 += (long) 4;
                        i10 += 2;
                    }
                }
                j10 += (long) i12;
            }
            i10++;
        }
        return j10;
    }

    public static /* synthetic */ long l(String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = str.length();
        }
        return k(str, i10, i11);
    }
}
