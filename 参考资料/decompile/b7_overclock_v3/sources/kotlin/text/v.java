package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.collections.k0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.m0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\n_StringsJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,108:1\n1239#2,14:109\n1521#2,14:123\n*S KotlinDebug\n*F\n+ 1 _StringsJvm.kt\nkotlin/text/StringsKt___StringsJvmKt\n*L\n45#1:109,14\n66#1:123,14\n*E\n"})
public class v extends StringsKt__StringsKt {
    @bk.f
    public static final char X5(CharSequence charSequence, int i10) {
        f0.p(charSequence, "<this>");
        return charSequence.charAt(i10);
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character Y5(CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return StringsKt___StringsKt.Q7(charSequence);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character Z5(CharSequence charSequence, ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iJ3 = StringsKt__StringsKt.j3(charSequence);
        if (iJ3 == 0) {
            return Character.valueOf(cCharAt);
        }
        R rI = selector.i(Character.valueOf(cCharAt));
        k0 it2 = new qk.m(1, iJ3).iterator();
        while (it2.hasNext()) {
            char cCharAt2 = charSequence.charAt(it2.b());
            R rI2 = selector.i(Character.valueOf(cCharAt2));
            if (rI.compareTo(rI2) < 0) {
                cCharAt = cCharAt2;
                rI = rI2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character a6(CharSequence charSequence, Comparator comparator) {
        f0.p(charSequence, "<this>");
        f0.p(comparator, "comparator");
        return StringsKt___StringsKt.S7(charSequence, comparator);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character b6(CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return StringsKt___StringsKt.e8(charSequence);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character c6(CharSequence charSequence, ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        int iJ3 = StringsKt__StringsKt.j3(charSequence);
        if (iJ3 == 0) {
            return Character.valueOf(cCharAt);
        }
        R rI = selector.i(Character.valueOf(cCharAt));
        k0 it2 = new qk.m(1, iJ3).iterator();
        while (it2.hasNext()) {
            char cCharAt2 = charSequence.charAt(it2.b());
            R rI2 = selector.i(Character.valueOf(cCharAt2));
            if (rI.compareTo(rI2) > 0) {
                cCharAt = cCharAt2;
                rI = rI2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character d6(CharSequence charSequence, Comparator comparator) {
        f0.p(charSequence, "<this>");
        f0.p(comparator, "comparator");
        return StringsKt___StringsKt.g8(charSequence, comparator);
    }

    @hk.h(name = "sumOfBigDecimal")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final BigDecimal e6(CharSequence charSequence, ik.l<? super Character, ? extends BigDecimal> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(Character.valueOf(charSequence.charAt(i10))));
            f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @hk.h(name = "sumOfBigInteger")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final BigInteger f6(CharSequence charSequence, ik.l<? super Character, ? extends BigInteger> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(Character.valueOf(charSequence.charAt(i10))));
            f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @yt.k
    public static final SortedSet<Character> g6(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return (SortedSet) StringsKt___StringsKt.f9(charSequence, new TreeSet());
    }
}
