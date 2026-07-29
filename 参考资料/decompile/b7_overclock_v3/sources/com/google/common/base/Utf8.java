package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import pq.b;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtCompatible(emulated = true)
public final class Utf8 {
    private Utf8() {
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length && charSequence.charAt(i10) < 128) {
            i10++;
        }
        int iEncodedLengthGeneral = length;
        while (true) {
            if (i10 < length) {
                char cCharAt = charSequence.charAt(i10);
                if (cCharAt >= 2048) {
                    iEncodedLengthGeneral += encodedLengthGeneral(charSequence, i10);
                    break;
                }
                iEncodedLengthGeneral += (127 - cCharAt) >>> 31;
                i10++;
            } else {
                break;
            }
        }
        if (iEncodedLengthGeneral >= length) {
            return iEncodedLengthGeneral;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) iEncodedLengthGeneral) + 4294967296L));
    }

    private static int encodedLengthGeneral(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        while (i10 < length) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt < 2048) {
                i11 += (127 - cCharAt) >>> 31;
            } else {
                i11 += 2;
                if (55296 <= cCharAt && cCharAt <= 57343) {
                    if (Character.codePointAt(charSequence, i10) == cCharAt) {
                        throw new IllegalArgumentException(unpairedSurrogateMsg(i10));
                    }
                    i10++;
                }
            }
            i10++;
        }
        return i11;
    }

    public static boolean isWellFormed(byte[] bArr) {
        return isWellFormed(bArr, 0, bArr.length);
    }

    private static boolean isWellFormedSlowPath(byte[] bArr, int i10, int i11) {
        byte b10;
        while (i10 < i11) {
            int i12 = i10 + 1;
            byte b11 = bArr[i10];
            if (b11 < 0) {
                if (b11 < -32) {
                    if (i12 != i11 && b11 >= -62) {
                        i10 = i12 + 1;
                        if (bArr[i12] > -65) {
                        }
                    }
                    return false;
                }
                if (b11 < -16) {
                    int i13 = i12 + 1;
                    if (i13 < i11 && (b10 = bArr[i12]) <= -65 && ((b11 != -32 || b10 >= -96) && (b11 != -19 || -96 > b10))) {
                        i10 = i13 + 1;
                        if (bArr[i13] > -65) {
                        }
                    }
                    return false;
                }
                if (i12 + 2 >= i11) {
                    return false;
                }
                int i14 = i12 + 1;
                byte b12 = bArr[i12];
                if (b12 <= -65 && (((b11 << 28) + (b12 + b.f46994k)) >> 30) == 0) {
                    int i15 = i14 + 1;
                    if (bArr[i14] <= -65) {
                        i12 = i15 + 1;
                        if (bArr[i15] > -65) {
                        }
                    }
                }
                return false;
            }
            i10 = i12;
        }
        return true;
    }

    private static String unpairedSurrogateMsg(int i10) {
        return "Unpaired surrogate at index " + i10;
    }

    public static boolean isWellFormed(byte[] bArr, int i10, int i11) {
        int i12 = i11 + i10;
        Preconditions.checkPositionIndexes(i10, i12, bArr.length);
        while (i10 < i12) {
            if (bArr[i10] < 0) {
                return isWellFormedSlowPath(bArr, i10, i12);
            }
            i10++;
        }
        return true;
    }
}
