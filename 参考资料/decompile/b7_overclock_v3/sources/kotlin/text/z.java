package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.b2;
import kotlin.c2;
import kotlin.f1;
import kotlin.g1;
import kotlin.h1;
import kotlin.jvm.internal.f0;
import kotlin.l1;
import kotlin.p1;
import kotlin.v0;
import kotlin.v1;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "UStringsKt")
public final class z {
    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final String a(long j10, int i10) {
        return b2.l(j10, b.a(i10));
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final String b(byte b10, int i10) {
        String string = Integer.toString(b10 & 255, b.a(i10));
        f0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final String c(int i10, int i11) {
        String string = Long.toString(((long) i10) & 4294967295L, b.a(i11));
        f0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final String d(short s10, int i10) {
        String string = Integer.toString(s10 & v1.f38215d, b.a(i10));
        f0.o(string, "toString(this, checkRadix(radix))");
        return string;
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final byte e(@yt.k String str) {
        f0.p(str, "<this>");
        h1 h1VarG = g(str);
        if (h1VarG != null) {
            return h1VarG.j0();
        }
        t.V0(str);
        throw new KotlinNothingValueException();
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final byte f(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        h1 h1VarH = h(str, i10);
        if (h1VarH != null) {
            return h1VarH.j0();
        }
        t.V0(str);
        throw new KotlinNothingValueException();
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.l
    public static final h1 g(@yt.k String str) {
        f0.p(str, "<this>");
        return h(str, 10);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.l
    public static final h1 h(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        l1 l1VarL = l(str, i10);
        if (l1VarL == null) {
            return null;
        }
        int iL0 = l1VarL.l0();
        if (Integer.compare(iL0 ^ Integer.MIN_VALUE, l1.j(255) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return h1.d(h1.j((byte) iL0));
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final int i(@yt.k String str) {
        f0.p(str, "<this>");
        l1 l1VarK = k(str);
        if (l1VarK != null) {
            return l1VarK.l0();
        }
        t.V0(str);
        throw new KotlinNothingValueException();
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final int j(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        l1 l1VarL = l(str, i10);
        if (l1VarL != null) {
            return l1VarL.l0();
        }
        t.V0(str);
        throw new KotlinNothingValueException();
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.l
    public static final l1 k(@yt.k String str) {
        f0.p(str, "<this>");
        return l(str, 10);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.l
    public static final l1 l(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        b.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        int i12 = 1;
        if (f0.t(cCharAt, 48) >= 0) {
            i12 = 0;
        } else if (length == 1 || cCharAt != '+') {
            return null;
        }
        int iJ = l1.j(i10);
        int iA = 119304647;
        while (i12 < length) {
            int iB = b.b(str.charAt(i12), i10);
            if (iB < 0) {
                return null;
            }
            if (Integer.compare(i11 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                if (iA == 119304647) {
                    iA = f1.a(-1, iJ);
                    if (Integer.compare(i11 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int iJ2 = l1.j(i11 * iJ);
            int iJ3 = l1.j(l1.j(iB) + iJ2);
            if (Integer.compare(iJ3 ^ Integer.MIN_VALUE, iJ2 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i12++;
            i11 = iJ3;
        }
        return l1.d(i11);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final long m(@yt.k String str) {
        f0.p(str, "<this>");
        p1 p1VarO = o(str);
        if (p1VarO != null) {
            return p1VarO.l0();
        }
        t.V0(str);
        throw new KotlinNothingValueException();
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final long n(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        p1 p1VarP = p(str, i10);
        if (p1VarP != null) {
            return p1VarP.l0();
        }
        t.V0(str);
        throw new KotlinNothingValueException();
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.l
    public static final p1 o(@yt.k String str) {
        f0.p(str, "<this>");
        return p(str, 10);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.l
    public static final p1 p(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        b.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        long j10 = -1;
        int i11 = 0;
        char cCharAt = str.charAt(0);
        if (f0.t(cCharAt, 48) < 0) {
            if (length == 1 || cCharAt != '+') {
                return null;
            }
            i11 = 1;
        }
        long j11 = p1.j(i10);
        long j12 = 0;
        long jA = 512409557603043100L;
        while (i11 < length) {
            int iB = b.b(str.charAt(i11), i10);
            if (iB < 0) {
                return null;
            }
            if (Long.compare(j12 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                if (jA == 512409557603043100L) {
                    jA = g1.a(j10, j11);
                    if (Long.compare(j12 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long j13 = p1.j(j12 * j11);
            long j14 = p1.j(p1.j(((long) l1.j(iB)) & 4294967295L) + j13);
            if (Long.compare(j14 ^ Long.MIN_VALUE, j13 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i11++;
            j12 = j14;
            j10 = -1;
        }
        return p1.d(j12);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final short q(@yt.k String str) {
        f0.p(str, "<this>");
        v1 v1VarS = s(str);
        if (v1VarS != null) {
            return v1VarS.j0();
        }
        t.V0(str);
        throw new KotlinNothingValueException();
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final short r(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        v1 v1VarT = t(str, i10);
        if (v1VarT != null) {
            return v1VarT.j0();
        }
        t.V0(str);
        throw new KotlinNothingValueException();
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.l
    public static final v1 s(@yt.k String str) {
        f0.p(str, "<this>");
        return t(str, 10);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.l
    public static final v1 t(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        l1 l1VarL = l(str, i10);
        if (l1VarL == null) {
            return null;
        }
        int iL0 = l1VarL.l0();
        if (Integer.compare(iL0 ^ Integer.MIN_VALUE, l1.j(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return v1.d(v1.j((short) iL0));
    }
}
