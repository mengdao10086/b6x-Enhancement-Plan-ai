package qk;

import java.util.NoSuchElementException;
import kotlin.c2;
import kotlin.h1;
import kotlin.jvm.internal.f0;
import kotlin.l1;
import kotlin.p1;
import kotlin.random.Random;
import kotlin.v0;
import kotlin.v1;
import qk.w;
import qk.z;

/* JADX INFO: loaded from: classes5.dex */
public class d0 {
    @v0(version = "1.7")
    public static final int A(@yt.k w wVar) {
        f0.p(wVar, "<this>");
        if (!wVar.isEmpty()) {
            return wVar.g();
        }
        throw new NoSuchElementException("Progression " + wVar + " is empty.");
    }

    @v0(version = "1.7")
    public static final long B(@yt.k z zVar) {
        f0.p(zVar, "<this>");
        if (!zVar.isEmpty()) {
            return zVar.g();
        }
        throw new NoSuchElementException("Progression " + zVar + " is empty.");
    }

    @v0(version = "1.7")
    @yt.l
    public static final l1 C(@yt.k w wVar) {
        f0.p(wVar, "<this>");
        if (wVar.isEmpty()) {
            return null;
        }
        return l1.d(wVar.g());
    }

    @v0(version = "1.7")
    @yt.l
    public static final p1 D(@yt.k z zVar) {
        f0.p(zVar, "<this>");
        if (zVar.isEmpty()) {
            return null;
        }
        return p1.d(zVar.g());
    }

    @v0(version = "1.7")
    public static final int E(@yt.k w wVar) {
        f0.p(wVar, "<this>");
        if (!wVar.isEmpty()) {
            return wVar.j();
        }
        throw new NoSuchElementException("Progression " + wVar + " is empty.");
    }

    @v0(version = "1.7")
    public static final long F(@yt.k z zVar) {
        f0.p(zVar, "<this>");
        if (!zVar.isEmpty()) {
            return zVar.j();
        }
        throw new NoSuchElementException("Progression " + zVar + " is empty.");
    }

    @v0(version = "1.7")
    @yt.l
    public static final l1 G(@yt.k w wVar) {
        f0.p(wVar, "<this>");
        if (wVar.isEmpty()) {
            return null;
        }
        return l1.d(wVar.j());
    }

    @v0(version = "1.7")
    @yt.l
    public static final p1 H(@yt.k z zVar) {
        f0.p(zVar, "<this>");
        if (zVar.isEmpty()) {
            return null;
        }
        return p1.d(zVar.j());
    }

    @c2(markerClass = {kotlin.s.class})
    @bk.f
    @v0(version = "1.5")
    public static final int I(y yVar) {
        f0.p(yVar, "<this>");
        return J(yVar, Random.f38003a);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final int J(@yt.k y yVar, @yt.k Random random) {
        f0.p(yVar, "<this>");
        f0.p(random, "random");
        try {
            return kotlin.random.e.h(random, yVar);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @c2(markerClass = {kotlin.s.class})
    @bk.f
    @v0(version = "1.5")
    public static final long K(b0 b0Var) {
        f0.p(b0Var, "<this>");
        return L(b0Var, Random.f38003a);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final long L(@yt.k b0 b0Var, @yt.k Random random) {
        f0.p(b0Var, "<this>");
        f0.p(random, "random");
        try {
            return kotlin.random.e.l(random, b0Var);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @c2(markerClass = {kotlin.q.class, kotlin.s.class})
    @bk.f
    @v0(version = "1.5")
    public static final l1 M(y yVar) {
        f0.p(yVar, "<this>");
        return N(yVar, Random.f38003a);
    }

    @c2(markerClass = {kotlin.q.class, kotlin.s.class})
    @v0(version = "1.5")
    @yt.l
    public static final l1 N(@yt.k y yVar, @yt.k Random random) {
        f0.p(yVar, "<this>");
        f0.p(random, "random");
        if (yVar.isEmpty()) {
            return null;
        }
        return l1.d(kotlin.random.e.h(random, yVar));
    }

    @c2(markerClass = {kotlin.q.class, kotlin.s.class})
    @bk.f
    @v0(version = "1.5")
    public static final p1 O(b0 b0Var) {
        f0.p(b0Var, "<this>");
        return P(b0Var, Random.f38003a);
    }

    @c2(markerClass = {kotlin.q.class, kotlin.s.class})
    @v0(version = "1.5")
    @yt.l
    public static final p1 P(@yt.k b0 b0Var, @yt.k Random random) {
        f0.p(b0Var, "<this>");
        f0.p(random, "random");
        if (b0Var.isEmpty()) {
            return null;
        }
        return p1.d(kotlin.random.e.l(random, b0Var));
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final w Q(@yt.k w wVar) {
        f0.p(wVar, "<this>");
        return w.f47429d.a(wVar.j(), wVar.g(), -wVar.l());
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final z R(@yt.k z zVar) {
        f0.p(zVar, "<this>");
        return z.f47439d.a(zVar.j(), zVar.g(), -zVar.l());
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final w S(@yt.k w wVar, int i10) {
        f0.p(wVar, "<this>");
        u.a(i10 > 0, Integer.valueOf(i10));
        w.a aVar = w.f47429d;
        int iG = wVar.g();
        int iJ = wVar.j();
        if (wVar.l() <= 0) {
            i10 = -i10;
        }
        return aVar.a(iG, iJ, i10);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final z T(@yt.k z zVar, long j10) {
        f0.p(zVar, "<this>");
        u.a(j10 > 0, Long.valueOf(j10));
        z.a aVar = z.f47439d;
        long jG = zVar.g();
        long j11 = zVar.j();
        if (zVar.l() <= 0) {
            j10 = -j10;
        }
        return aVar.a(jG, j11, j10);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final y U(short s10, short s11) {
        return f0.t(s11 & v1.f38215d, 0) <= 0 ? y.f47437e.a() : new y(l1.j(s10 & v1.f38215d), l1.j(l1.j(r3) - 1), null);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final y V(int i10, int i11) {
        return Integer.compare(i11 ^ Integer.MIN_VALUE, 0 ^ Integer.MIN_VALUE) <= 0 ? y.f47437e.a() : new y(i10, l1.j(i11 - 1), null);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final y W(byte b10, byte b11) {
        return f0.t(b11 & 255, 0) <= 0 ? y.f47437e.a() : new y(l1.j(b10 & 255), l1.j(l1.j(r3) - 1), null);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final b0 X(long j10, long j11) {
        return Long.compare(j11 ^ Long.MIN_VALUE, 0 ^ Long.MIN_VALUE) <= 0 ? b0.f47393e.a() : new b0(j10, p1.j(j11 - p1.j(((long) 1) & 4294967295L)), null);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final short a(short s10, short s11) {
        return f0.t(s10 & v1.f38215d, 65535 & s11) < 0 ? s11 : s10;
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final int b(int i10, int i11) {
        return Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) < 0 ? i11 : i10;
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final byte c(byte b10, byte b11) {
        return f0.t(b10 & 255, b11 & 255) < 0 ? b11 : b10;
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final long d(long j10, long j11) {
        return Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) < 0 ? j11 : j10;
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final short e(short s10, short s11) {
        return f0.t(s10 & v1.f38215d, 65535 & s11) > 0 ? s11 : s10;
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final int f(int i10, int i11) {
        return Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) > 0 ? i11 : i10;
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final byte g(byte b10, byte b11) {
        return f0.t(b10 & 255, b11 & 255) > 0 ? b11 : b10;
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final long h(long j10, long j11) {
        return Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) > 0 ? j11 : j10;
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final long i(long j10, @yt.k h<p1> range) {
        f0.p(range, "range");
        if (range instanceof g) {
            return ((p1) v.N(p1.d(j10), (g) range)).l0();
        }
        if (!range.isEmpty()) {
            return Long.compare(j10 ^ Long.MIN_VALUE, ((p1) range.a()).l0() ^ Long.MIN_VALUE) < 0 ? ((p1) range.a()).l0() : Long.compare(j10 ^ Long.MIN_VALUE, ((p1) range.e()).l0() ^ Long.MIN_VALUE) > 0 ? ((p1) range.e()).l0() : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final short j(short s10, short s11, short s12) {
        int i10 = s11 & v1.f38215d;
        int i11 = s12 & v1.f38215d;
        if (f0.t(i10, i11) <= 0) {
            int i12 = 65535 & s10;
            return f0.t(i12, i10) < 0 ? s11 : f0.t(i12, i11) > 0 ? s12 : s10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) v1.e0(s12)) + " is less than minimum " + ((Object) v1.e0(s11)) + '.');
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final int k(int i10, int i11, int i12) {
        if (Integer.compare(i11 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE) <= 0) {
            return Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE) < 0 ? i11 : Integer.compare(i10 ^ Integer.MIN_VALUE, i12 ^ Integer.MIN_VALUE) > 0 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) l1.g0(i12)) + " is less than minimum " + ((Object) l1.g0(i11)) + '.');
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final byte l(byte b10, byte b11, byte b12) {
        int i10 = b11 & 255;
        int i11 = b12 & 255;
        if (f0.t(i10, i11) <= 0) {
            int i12 = b10 & 255;
            return f0.t(i12, i10) < 0 ? b11 : f0.t(i12, i11) > 0 ? b12 : b10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) h1.e0(b12)) + " is less than minimum " + ((Object) h1.e0(b11)) + '.');
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final long m(long j10, long j11, long j12) {
        if (Long.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE) <= 0) {
            return Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE) < 0 ? j11 : Long.compare(j10 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE) > 0 ? j12 : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) p1.g0(j12)) + " is less than minimum " + ((Object) p1.g0(j11)) + '.');
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final int n(int i10, @yt.k h<l1> range) {
        f0.p(range, "range");
        if (range instanceof g) {
            return ((l1) v.N(l1.d(i10), (g) range)).l0();
        }
        if (!range.isEmpty()) {
            return Integer.compare(i10 ^ Integer.MIN_VALUE, ((l1) range.a()).l0() ^ Integer.MIN_VALUE) < 0 ? ((l1) range.a()).l0() : Integer.compare(i10 ^ Integer.MIN_VALUE, ((l1) range.e()).l0() ^ Integer.MIN_VALUE) > 0 ? ((l1) range.e()).l0() : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final boolean o(@yt.k y contains, byte b10) {
        f0.p(contains, "$this$contains");
        return contains.o(l1.j(b10 & 255));
    }

    @c2(markerClass = {kotlin.s.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean p(b0 contains, p1 p1Var) {
        f0.p(contains, "$this$contains");
        return p1Var != null && contains.o(p1Var.l0());
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final boolean q(@yt.k b0 contains, int i10) {
        f0.p(contains, "$this$contains");
        return contains.o(p1.j(((long) i10) & 4294967295L));
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final boolean r(@yt.k b0 contains, byte b10) {
        f0.p(contains, "$this$contains");
        return contains.o(p1.j(((long) b10) & 255));
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final boolean s(@yt.k y contains, short s10) {
        f0.p(contains, "$this$contains");
        return contains.o(l1.j(s10 & v1.f38215d));
    }

    @c2(markerClass = {kotlin.s.class})
    @bk.f
    @v0(version = "1.5")
    public static final boolean t(y contains, l1 l1Var) {
        f0.p(contains, "$this$contains");
        return l1Var != null && contains.o(l1Var.l0());
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final boolean u(@yt.k y contains, long j10) {
        f0.p(contains, "$this$contains");
        return p1.j(j10 >>> 32) == 0 && contains.o(l1.j((int) j10));
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    public static final boolean v(@yt.k b0 contains, short s10) {
        f0.p(contains, "$this$contains");
        return contains.o(p1.j(((long) s10) & dm.g.f26388t));
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final w w(short s10, short s11) {
        return w.f47429d.a(l1.j(s10 & v1.f38215d), l1.j(s11 & v1.f38215d), -1);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final w x(int i10, int i11) {
        return w.f47429d.a(i10, i11, -1);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final w y(byte b10, byte b11) {
        return w.f47429d.a(l1.j(b10 & 255), l1.j(b11 & 255), -1);
    }

    @c2(markerClass = {kotlin.s.class})
    @v0(version = "1.5")
    @yt.k
    public static final z z(long j10, long j11) {
        return z.f47439d.a(j10, j11, -1L);
    }
}
