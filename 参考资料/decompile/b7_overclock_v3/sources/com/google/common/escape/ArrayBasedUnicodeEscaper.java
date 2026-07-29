package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Map;
import kotlin.jvm.internal.p;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtCompatible
public abstract class ArrayBasedUnicodeEscaper extends UnicodeEscaper {
    private final char[][] replacements;
    private final int replacementsLength;
    private final int safeMax;
    private final char safeMaxChar;
    private final int safeMin;
    private final char safeMinChar;

    public ArrayBasedUnicodeEscaper(Map<Character, String> map, int i10, int i11, @NullableDecl String str) {
        this(ArrayBasedEscaperMap.create(map), i10, i11, str);
    }

    @Override // com.google.common.escape.UnicodeEscaper, com.google.common.escape.Escaper
    public final String escape(String str) {
        Preconditions.checkNotNull(str);
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if ((cCharAt < this.replacementsLength && this.replacements[cCharAt] != null) || cCharAt > this.safeMaxChar || cCharAt < this.safeMinChar) {
                return escapeSlow(str, i10);
            }
        }
        return str;
    }

    public abstract char[] escapeUnsafe(int i10);

    @Override // com.google.common.escape.UnicodeEscaper
    public final int nextEscapeIndex(CharSequence charSequence, int i10, int i11) {
        while (i10 < i11) {
            char cCharAt = charSequence.charAt(i10);
            if ((cCharAt < this.replacementsLength && this.replacements[cCharAt] != null) || cCharAt > this.safeMaxChar || cCharAt < this.safeMinChar) {
                break;
            }
            i10++;
        }
        return i10;
    }

    public ArrayBasedUnicodeEscaper(ArrayBasedEscaperMap arrayBasedEscaperMap, int i10, int i11, @NullableDecl String str) {
        Preconditions.checkNotNull(arrayBasedEscaperMap);
        char[][] replacementArray = arrayBasedEscaperMap.getReplacementArray();
        this.replacements = replacementArray;
        this.replacementsLength = replacementArray.length;
        if (i11 < i10) {
            i11 = -1;
            i10 = Integer.MAX_VALUE;
        }
        this.safeMin = i10;
        this.safeMax = i11;
        if (i10 >= 55296) {
            this.safeMinChar = p.f37930c;
            this.safeMaxChar = (char) 0;
        } else {
            this.safeMinChar = (char) i10;
            this.safeMaxChar = (char) Math.min(i11, 55295);
        }
    }

    @Override // com.google.common.escape.UnicodeEscaper
    public final char[] escape(int i10) {
        char[] cArr;
        if (i10 < this.replacementsLength && (cArr = this.replacements[i10]) != null) {
            return cArr;
        }
        if (i10 < this.safeMin || i10 > this.safeMax) {
            return escapeUnsafe(i10);
        }
        return null;
    }
}
