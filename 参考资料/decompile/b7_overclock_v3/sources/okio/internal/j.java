package okio.internal;

import java.util.Arrays;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okio.w0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001e\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001\u001a\n\u0010\u0006\u001a\u00020\u0000*\u00020\u0004¨\u0006\u0007"}, d2 = {"", "", "beginIndex", "endIndex", "", "b", "a", "okio"}, k = 2, mv = {1, 5, 1})
public final class j {
    @k
    public static final byte[] a(@k String str) {
        int i10;
        int i11;
        f0.p(str, "<this>");
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        if (length > 0) {
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                char cCharAt = str.charAt(i12);
                if (f0.t(cCharAt, 128) >= 0) {
                    int length2 = str.length();
                    int i14 = i12;
                    while (i12 < length2) {
                        char cCharAt2 = str.charAt(i12);
                        if (f0.t(cCharAt2, 128) < 0) {
                            int i15 = i14 + 1;
                            bArr[i14] = (byte) cCharAt2;
                            i12++;
                            while (true) {
                                i14 = i15;
                                if (i12 >= length2 || f0.t(str.charAt(i12), 128) >= 0) {
                                    break;
                                }
                                i15 = i14 + 1;
                                bArr[i14] = (byte) str.charAt(i12);
                                i12++;
                            }
                        } else {
                            if (f0.t(cCharAt2, 2048) < 0) {
                                int i16 = i14 + 1;
                                bArr[i14] = (byte) ((cCharAt2 >> 6) | 192);
                                byte b10 = (byte) ((cCharAt2 & '?') | 128);
                                i10 = i16 + 1;
                                bArr[i16] = b10;
                            } else {
                                if (55296 <= cCharAt2 && cCharAt2 <= 57343) {
                                    if (f0.t(cCharAt2, 56319) <= 0 && length2 > (i11 = i12 + 1)) {
                                        char cCharAt3 = str.charAt(i11);
                                        if (56320 <= cCharAt3 && cCharAt3 <= 57343) {
                                            int iCharAt = ((cCharAt2 << '\n') + str.charAt(i11)) - 56613888;
                                            int i17 = i14 + 1;
                                            bArr[i14] = (byte) ((iCharAt >> 18) | 240);
                                            int i18 = i17 + 1;
                                            bArr[i17] = (byte) (((iCharAt >> 12) & 63) | 128);
                                            int i19 = i18 + 1;
                                            bArr[i18] = (byte) (((iCharAt >> 6) & 63) | 128);
                                            byte b11 = (byte) ((iCharAt & 63) | 128);
                                            i10 = i19 + 1;
                                            bArr[i19] = b11;
                                            i12 += 2;
                                            i14 = i10;
                                        }
                                    }
                                    i10 = i14 + 1;
                                    bArr[i14] = w0.f44229a;
                                } else {
                                    int i20 = i14 + 1;
                                    bArr[i14] = (byte) ((cCharAt2 >> '\f') | 224);
                                    int i21 = i20 + 1;
                                    bArr[i20] = (byte) (((cCharAt2 >> 6) & 63) | 128);
                                    byte b12 = (byte) ((cCharAt2 & '?') | 128);
                                    i10 = i21 + 1;
                                    bArr[i21] = b12;
                                }
                            }
                            i12++;
                            i14 = i10;
                        }
                    }
                    byte[] bArrCopyOf = Arrays.copyOf(bArr, i14);
                    f0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
                    return bArrCopyOf;
                }
                bArr[i12] = (byte) cCharAt;
                if (i13 >= length) {
                    break;
                }
                i12 = i13;
            }
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArr, str.length());
        f0.o(bArrCopyOf2, "java.util.Arrays.copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x009d, code lost:
    
        if (((r16[r5] & i1.a.f31667o7) == 128) == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0123, code lost:
    
        if (((r16[r5] & i1.a.f31667o7) == 128) == false) goto L97;
     */
    @yt.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.String b(@yt.k byte[] r16, int r17, int r18) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.j.b(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String c(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        return b(bArr, i10, i11);
    }
}
