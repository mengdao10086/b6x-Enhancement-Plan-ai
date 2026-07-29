package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nStringNumberConversionsJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n1#1,283:1\n274#1,7:284\n274#1,7:291\n274#1,7:298\n274#1,7:305\n*S KotlinDebug\n*F\n+ 1 StringNumberConversionsJVM.kt\nkotlin/text/StringsKt__StringNumberConversionsJVMKt\n*L\n151#1:284,7\n158#1:291,7\n238#1:298,7\n249#1:305,7\n*E\n"})
public class s extends r {
    @bk.f
    @v0(version = "1.2")
    public static final BigInteger A0(String str, int i10) {
        f0.p(str, "<this>");
        return new BigInteger(str, b.a(i10));
    }

    @v0(version = "1.2")
    @yt.l
    public static final BigInteger B0(@yt.k String str) {
        f0.p(str, "<this>");
        return C0(str, 10);
    }

    @v0(version = "1.2")
    @yt.l
    public static final BigInteger C0(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        b.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        if (length != 1) {
            for (int i11 = str.charAt(0) == '-' ? 1 : 0; i11 < length; i11++) {
                if (b.b(str.charAt(i11), i10) < 0) {
                    return null;
                }
            }
        } else if (b.b(str.charAt(0), i10) < 0) {
            return null;
        }
        return new BigInteger(str, b.a(i10));
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean D0(String str) {
        f0.p(str, "<this>");
        return Boolean.parseBoolean(str);
    }

    @hk.h(name = "toBooleanNullable")
    @bk.f
    @v0(version = "1.4")
    public static final boolean E0(String str) {
        return Boolean.parseBoolean(str);
    }

    @bk.f
    public static final byte F0(String str) {
        f0.p(str, "<this>");
        return Byte.parseByte(str);
    }

    @bk.f
    @v0(version = "1.1")
    public static final byte G0(String str, int i10) {
        f0.p(str, "<this>");
        return Byte.parseByte(str, b.a(i10));
    }

    @bk.f
    public static final double H0(String str) {
        f0.p(str, "<this>");
        return Double.parseDouble(str);
    }

    @v0(version = "1.1")
    @yt.l
    public static final Double I0(@yt.k String str) {
        f0.p(str, "<this>");
        try {
            if (l.f38184b.n(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @bk.f
    public static final float J0(String str) {
        f0.p(str, "<this>");
        return Float.parseFloat(str);
    }

    @v0(version = "1.1")
    @yt.l
    public static final Float K0(@yt.k String str) {
        f0.p(str, "<this>");
        try {
            if (l.f38184b.n(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @bk.f
    public static final int L0(String str) {
        f0.p(str, "<this>");
        return Integer.parseInt(str);
    }

    @bk.f
    @v0(version = "1.1")
    public static final int M0(String str, int i10) {
        f0.p(str, "<this>");
        return Integer.parseInt(str, b.a(i10));
    }

    @bk.f
    public static final long N0(String str) {
        f0.p(str, "<this>");
        return Long.parseLong(str);
    }

    @bk.f
    @v0(version = "1.1")
    public static final long O0(String str, int i10) {
        f0.p(str, "<this>");
        return Long.parseLong(str, b.a(i10));
    }

    @bk.f
    public static final short P0(String str) {
        f0.p(str, "<this>");
        return Short.parseShort(str);
    }

    @bk.f
    @v0(version = "1.1")
    public static final short Q0(String str, int i10) {
        f0.p(str, "<this>");
        return Short.parseShort(str, b.a(i10));
    }

    @bk.f
    @v0(version = "1.1")
    public static final String R0(byte b10, int i10) {
        String string = Integer.toString(b10, b.a(b.a(i10)));
        f0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @bk.f
    @v0(version = "1.1")
    public static final String S0(int i10, int i11) {
        String string = Integer.toString(i10, b.a(i11));
        f0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @bk.f
    @v0(version = "1.1")
    public static final String T0(long j10, int i10) {
        String string = Long.toString(j10, b.a(i10));
        f0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @bk.f
    @v0(version = "1.1")
    public static final String U0(short s10, int i10) {
        String string = Integer.toString(s10, b.a(b.a(i10)));
        f0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    public static final <T> T u0(String str, ik.l<? super String, ? extends T> lVar) {
        try {
            if (l.f38184b.n(str)) {
                return lVar.i(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal v0(String str) {
        f0.p(str, "<this>");
        return new BigDecimal(str);
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigDecimal w0(String str, MathContext mathContext) {
        f0.p(str, "<this>");
        f0.p(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    @v0(version = "1.2")
    @yt.l
    public static final BigDecimal x0(@yt.k String str) {
        f0.p(str, "<this>");
        try {
            if (l.f38184b.n(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @v0(version = "1.2")
    @yt.l
    public static final BigDecimal y0(@yt.k String str, @yt.k MathContext mathContext) {
        f0.p(str, "<this>");
        f0.p(mathContext, "mathContext");
        try {
            if (l.f38184b.n(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @bk.f
    @v0(version = "1.2")
    public static final BigInteger z0(String str) {
        f0.p(str, "<this>");
        return new BigInteger(str);
    }
}
