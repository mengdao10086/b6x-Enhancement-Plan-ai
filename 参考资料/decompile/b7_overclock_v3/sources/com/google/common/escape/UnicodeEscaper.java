package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtCompatible
public abstract class UnicodeEscaper extends Escaper {
    private static final int DEST_PAD = 32;

    public static int codePointAt(CharSequence charSequence, int i10, int i11) {
        Preconditions.checkNotNull(charSequence);
        if (i10 >= i11) {
            throw new IndexOutOfBoundsException("Index exceeds specified range");
        }
        int i12 = i10 + 1;
        char cCharAt = charSequence.charAt(i10);
        if (cCharAt < 55296 || cCharAt > 57343) {
            return cCharAt;
        }
        if (cCharAt > 56319) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected low surrogate character '");
            sb2.append(cCharAt);
            sb2.append("' with value ");
            sb2.append((int) cCharAt);
            sb2.append(" at index ");
            sb2.append(i12 - 1);
            sb2.append(" in '");
            sb2.append((Object) charSequence);
            sb2.append("'");
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i12 == i11) {
            return -cCharAt;
        }
        char cCharAt2 = charSequence.charAt(i12);
        if (Character.isLowSurrogate(cCharAt2)) {
            return Character.toCodePoint(cCharAt, cCharAt2);
        }
        throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + i12 + " in '" + ((Object) charSequence) + "'");
    }

    private static char[] growBuffer(char[] cArr, int i10, int i11) {
        if (i11 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i11];
        if (i10 > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i10);
        }
        return cArr2;
    }

    @Override // com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        int iNextEscapeIndex = nextEscapeIndex(str, 0, length);
        return iNextEscapeIndex == length ? str : escapeSlow(str, iNextEscapeIndex);
    }

    public abstract char[] escape(int i10);

    public final String escapeSlow(String str, int i10) {
        int length = str.length();
        char[] cArrCharBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int i11 = 0;
        int length2 = 0;
        while (i10 < length) {
            int iCodePointAt = codePointAt(str, i10, length);
            if (iCodePointAt < 0) {
                throw new IllegalArgumentException("Trailing high surrogate at end of input");
            }
            char[] cArrEscape = escape(iCodePointAt);
            int i12 = (Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1) + i10;
            if (cArrEscape != null) {
                int i13 = i10 - i11;
                int i14 = length2 + i13;
                int length3 = cArrEscape.length + i14;
                if (cArrCharBufferFromThreadLocal.length < length3) {
                    cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, length2, length3 + (length - i10) + 32);
                }
                if (i13 > 0) {
                    str.getChars(i11, i10, cArrCharBufferFromThreadLocal, length2);
                    length2 = i14;
                }
                if (cArrEscape.length > 0) {
                    System.arraycopy(cArrEscape, 0, cArrCharBufferFromThreadLocal, length2, cArrEscape.length);
                    length2 += cArrEscape.length;
                }
                i11 = i12;
            }
            i10 = nextEscapeIndex(str, i12, length);
        }
        int i15 = length - i11;
        if (i15 > 0) {
            int i16 = i15 + length2;
            if (cArrCharBufferFromThreadLocal.length < i16) {
                cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, length2, i16);
            }
            str.getChars(i11, length, cArrCharBufferFromThreadLocal, length2);
            length2 = i16;
        }
        return new String(cArrCharBufferFromThreadLocal, 0, length2);
    }

    public int nextEscapeIndex(CharSequence charSequence, int i10, int i11) {
        while (i10 < i11) {
            int iCodePointAt = codePointAt(charSequence, i10, i11);
            if (iCodePointAt < 0 || escape(iCodePointAt) != null) {
                break;
            }
            i10 += Character.isSupplementaryCodePoint(iCodePointAt) ? 2 : 1;
        }
        return i10;
    }
}
