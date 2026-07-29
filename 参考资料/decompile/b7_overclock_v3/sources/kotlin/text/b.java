package kotlin.text;

import java.util.Locale;
import kotlin.c2;
import kotlin.jvm.internal.f0;
import kotlin.s0;
import kotlin.t0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public class b {
    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @v0(version = "1.5")
    public static final String A(char c10) {
        String strValueOf = String.valueOf(c10);
        f0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(Locale.ROOT);
        f0.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.5")
    @yt.k
    public static final String B(char c10, @yt.k Locale locale) {
        f0.p(locale, "locale");
        String strValueOf = String.valueOf(c10);
        f0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = strValueOf.toUpperCase(locale);
        f0.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @v0(version = "1.5")
    public static final char C(char c10) {
        return Character.toUpperCase(c10);
    }

    @s0
    public static final int a(int i10) {
        if (new qk.m(2, 36).p(i10)) {
            return i10;
        }
        throw new IllegalArgumentException("radix " + i10 + " was not in valid range " + new qk.m(2, 36));
    }

    public static final int b(char c10, int i10) {
        return Character.digit((int) c10, i10);
    }

    @yt.k
    public static final CharCategory c(char c10) {
        return CharCategory.Companion.a(Character.getType(c10));
    }

    @yt.k
    public static final CharDirectionality d(char c10) {
        return CharDirectionality.Companion.b(Character.getDirectionality(c10));
    }

    @bk.f
    public static final boolean e(char c10) {
        return Character.isDefined(c10);
    }

    @bk.f
    public static final boolean f(char c10) {
        return Character.isDigit(c10);
    }

    @bk.f
    public static final boolean g(char c10) {
        return Character.isHighSurrogate(c10);
    }

    @bk.f
    public static final boolean h(char c10) {
        return Character.isISOControl(c10);
    }

    @bk.f
    public static final boolean i(char c10) {
        return Character.isIdentifierIgnorable(c10);
    }

    @bk.f
    public static final boolean j(char c10) {
        return Character.isJavaIdentifierPart(c10);
    }

    @bk.f
    public static final boolean k(char c10) {
        return Character.isJavaIdentifierStart(c10);
    }

    @bk.f
    public static final boolean l(char c10) {
        return Character.isLetter(c10);
    }

    @bk.f
    public static final boolean m(char c10) {
        return Character.isLetterOrDigit(c10);
    }

    @bk.f
    public static final boolean n(char c10) {
        return Character.isLowSurrogate(c10);
    }

    @bk.f
    public static final boolean o(char c10) {
        return Character.isLowerCase(c10);
    }

    @bk.f
    public static final boolean p(char c10) {
        return Character.isTitleCase(c10);
    }

    @bk.f
    public static final boolean q(char c10) {
        return Character.isUpperCase(c10);
    }

    public static final boolean r(char c10) {
        return Character.isWhitespace(c10) || Character.isSpaceChar(c10);
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @v0(version = "1.5")
    public static final String s(char c10) {
        String strValueOf = String.valueOf(c10);
        f0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(Locale.ROOT);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.5")
    @yt.k
    public static final String t(char c10, @yt.k Locale locale) {
        f0.p(locale, "locale");
        String strValueOf = String.valueOf(c10);
        f0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strValueOf.toLowerCase(locale);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @v0(version = "1.5")
    public static final char u(char c10) {
        return Character.toLowerCase(c10);
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.5")
    @yt.k
    public static final String v(char c10, @yt.k Locale locale) {
        f0.p(locale, "locale");
        String strB = B(c10, locale);
        if (strB.length() <= 1) {
            String strValueOf = String.valueOf(c10);
            f0.n(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            f0.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return !f0.g(strB, upperCase) ? strB : String.valueOf(Character.toTitleCase(c10));
        }
        if (c10 == 329) {
            return strB;
        }
        char cCharAt = strB.charAt(0);
        f0.n(strB, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strB.substring(1);
        f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
        f0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(Locale.ROOT);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return cCharAt + lowerCase;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @v0(version = "1.5")
    public static final char w(char c10) {
        return Character.toTitleCase(c10);
    }

    @bk.f
    @kotlin.k(message = "Use lowercaseChar() instead.", replaceWith = @t0(expression = "lowercaseChar()", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final char x(char c10) {
        return Character.toLowerCase(c10);
    }

    @bk.f
    @kotlin.k(message = "Use titlecaseChar() instead.", replaceWith = @t0(expression = "titlecaseChar()", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final char y(char c10) {
        return Character.toTitleCase(c10);
    }

    @bk.f
    @kotlin.k(message = "Use uppercaseChar() instead.", replaceWith = @t0(expression = "uppercaseChar()", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final char z(char c10) {
        return Character.toUpperCase(c10);
    }
}
