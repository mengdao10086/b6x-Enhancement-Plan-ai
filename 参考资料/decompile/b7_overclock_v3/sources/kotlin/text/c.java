package kotlin.text;

import kotlin.c2;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nChar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Char.kt\nkotlin/text/CharsKt__CharKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,344:1\n1#2:345\n*E\n"})
public class c extends b {
    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.5")
    public static final char D(int i10) {
        if (new qk.m(0, 9).p(i10)) {
            return (char) (i10 + 48);
        }
        throw new IllegalArgumentException("Int " + i10 + " is not a decimal digit");
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.5")
    public static final char E(int i10, int i11) {
        if (!new qk.m(2, 36).p(i11)) {
            throw new IllegalArgumentException("Invalid radix: " + i11 + ". Valid radix values are in range 2..36");
        }
        if (i10 >= 0 && i10 < i11) {
            return (char) (i10 < 10 ? i10 + 48 : ((char) (i10 + 65)) - '\n');
        }
        throw new IllegalArgumentException("Digit " + i10 + " does not represent a valid digit in radix " + i11);
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.5")
    public static final int F(char c10) {
        int iB = b.b(c10, 10);
        if (iB >= 0) {
            return iB;
        }
        throw new IllegalArgumentException("Char " + c10 + " is not a decimal digit");
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.5")
    public static final int G(char c10, int i10) {
        Integer numI = I(c10, i10);
        if (numI != null) {
            return numI.intValue();
        }
        throw new IllegalArgumentException("Char " + c10 + " is not a digit in the given radix=" + i10);
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.5")
    @yt.l
    public static final Integer H(char c10) {
        Integer numValueOf = Integer.valueOf(b.b(c10, 10));
        if (numValueOf.intValue() >= 0) {
            return numValueOf;
        }
        return null;
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.5")
    @yt.l
    public static final Integer I(char c10, int i10) {
        b.a(i10);
        Integer numValueOf = Integer.valueOf(b.b(c10, i10));
        if (numValueOf.intValue() >= 0) {
            return numValueOf;
        }
        return null;
    }

    public static final boolean J(char c10, char c11, boolean z10) {
        if (c10 == c11) {
            return true;
        }
        if (!z10) {
            return false;
        }
        char upperCase = Character.toUpperCase(c10);
        char upperCase2 = Character.toUpperCase(c11);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    public static /* synthetic */ boolean K(char c10, char c11, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return J(c10, c11, z10);
    }

    public static final boolean L(char c10) {
        return new qk.c((char) 55296, (char) 57343).p(c10);
    }

    @bk.f
    public static final String M(char c10, String other) {
        f0.p(other, "other");
        return c10 + other;
    }

    @v0(version = "1.5")
    @yt.k
    public static final String N(char c10) {
        return a0.a(c10);
    }
}
