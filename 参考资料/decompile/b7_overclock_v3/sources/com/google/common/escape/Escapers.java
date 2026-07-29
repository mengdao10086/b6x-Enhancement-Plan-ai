package com.google.common.escape;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.p;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Beta
@GwtCompatible
public final class Escapers {
    private static final Escaper NULL_ESCAPER = new CharEscaper() { // from class: com.google.common.escape.Escapers.1
        @Override // com.google.common.escape.CharEscaper, com.google.common.escape.Escaper
        public String escape(String str) {
            return (String) Preconditions.checkNotNull(str);
        }

        @Override // com.google.common.escape.CharEscaper
        public char[] escape(char c10) {
            return null;
        }
    };

    @Beta
    public static final class Builder {
        private final Map<Character, String> replacementMap;
        private char safeMax;
        private char safeMin;
        private String unsafeReplacement;

        @CanIgnoreReturnValue
        public Builder addEscape(char c10, String str) {
            Preconditions.checkNotNull(str);
            this.replacementMap.put(Character.valueOf(c10), str);
            return this;
        }

        public Escaper build() {
            return new ArrayBasedCharEscaper(this.replacementMap, this.safeMin, this.safeMax) { // from class: com.google.common.escape.Escapers.Builder.1
                private final char[] replacementChars;

                {
                    this.replacementChars = Builder.this.unsafeReplacement != null ? Builder.this.unsafeReplacement.toCharArray() : null;
                }

                @Override // com.google.common.escape.ArrayBasedCharEscaper
                public char[] escapeUnsafe(char c10) {
                    return this.replacementChars;
                }
            };
        }

        @CanIgnoreReturnValue
        public Builder setSafeRange(char c10, char c11) {
            this.safeMin = c10;
            this.safeMax = c11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setUnsafeReplacement(@NullableDecl String str) {
            this.unsafeReplacement = str;
            return this;
        }

        private Builder() {
            this.replacementMap = new HashMap();
            this.safeMin = (char) 0;
            this.safeMax = p.f37930c;
            this.unsafeReplacement = null;
        }
    }

    private Escapers() {
    }

    public static UnicodeEscaper asUnicodeEscaper(Escaper escaper) {
        Preconditions.checkNotNull(escaper);
        if (escaper instanceof UnicodeEscaper) {
            return (UnicodeEscaper) escaper;
        }
        if (escaper instanceof CharEscaper) {
            return wrap((CharEscaper) escaper);
        }
        throw new IllegalArgumentException("Cannot create a UnicodeEscaper from: " + escaper.getClass().getName());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static String computeReplacement(CharEscaper charEscaper, char c10) {
        return stringOrNull(charEscaper.escape(c10));
    }

    public static Escaper nullEscaper() {
        return NULL_ESCAPER;
    }

    private static String stringOrNull(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    private static UnicodeEscaper wrap(final CharEscaper charEscaper) {
        return new UnicodeEscaper() { // from class: com.google.common.escape.Escapers.2
            @Override // com.google.common.escape.UnicodeEscaper
            public char[] escape(int i10) {
                if (i10 < 65536) {
                    return charEscaper.escape((char) i10);
                }
                char[] cArr = new char[2];
                Character.toChars(i10, cArr, 0);
                char[] cArrEscape = charEscaper.escape(cArr[0]);
                char[] cArrEscape2 = charEscaper.escape(cArr[1]);
                if (cArrEscape == null && cArrEscape2 == null) {
                    return null;
                }
                int length = cArrEscape != null ? cArrEscape.length : 1;
                char[] cArr2 = new char[(cArrEscape2 != null ? cArrEscape2.length : 1) + length];
                if (cArrEscape != null) {
                    for (int i11 = 0; i11 < cArrEscape.length; i11++) {
                        cArr2[i11] = cArrEscape[i11];
                    }
                } else {
                    cArr2[0] = cArr[0];
                }
                if (cArrEscape2 != null) {
                    for (int i12 = 0; i12 < cArrEscape2.length; i12++) {
                        cArr2[length + i12] = cArrEscape2[i12];
                    }
                } else {
                    cArr2[length] = cArr[1];
                }
                return cArr2;
            }
        };
    }

    public static String computeReplacement(UnicodeEscaper unicodeEscaper, int i10) {
        return stringOrNull(unicodeEscaper.escape(i10));
    }
}
