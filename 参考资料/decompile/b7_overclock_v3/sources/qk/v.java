package qk;

import java.util.NoSuchElementException;
import kotlin.c2;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.random.Random;
import kotlin.v0;
import qk.a;
import qk.k;
import qk.n;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\n_Ranges.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Ranges.kt\nkotlin/ranges/RangesKt___RangesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,1537:1\n1#2:1538\n*E\n"})
public class v extends u {
    public static final float A(float f10, float f11) {
        return f10 > f11 ? f11 : f10;
    }

    @v0(version = "1.7")
    @yt.l
    public static final Integer A0(@yt.k k kVar) {
        f0.p(kVar, "<this>");
        if (kVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(kVar.g());
    }

    @yt.k
    public static final a A1(@yt.k a aVar, int i10) {
        f0.p(aVar, "<this>");
        u.a(i10 > 0, Integer.valueOf(i10));
        a.C0546a c0546a = a.f47381d;
        char cG = aVar.g();
        char cJ = aVar.j();
        if (aVar.l() <= 0) {
            i10 = -i10;
        }
        return c0546a.a(cG, cJ, i10);
    }

    public static final int B(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    @v0(version = "1.7")
    @yt.l
    public static final Long B0(@yt.k n nVar) {
        f0.p(nVar, "<this>");
        if (nVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(nVar.g());
    }

    @yt.k
    public static final k B1(@yt.k k kVar, int i10) {
        f0.p(kVar, "<this>");
        u.a(i10 > 0, Integer.valueOf(i10));
        k.a aVar = k.f47405d;
        int iG = kVar.g();
        int iJ = kVar.j();
        if (kVar.l() <= 0) {
            i10 = -i10;
        }
        return aVar.a(iG, iJ, i10);
    }

    public static final long C(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    @hk.h(name = "floatRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean C0(h hVar, byte b10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Float.valueOf(b10));
    }

    @yt.k
    public static final n C1(@yt.k n nVar, long j10) {
        f0.p(nVar, "<this>");
        u.a(j10 > 0, Long.valueOf(j10));
        n.a aVar = n.f47415d;
        long jG = nVar.g();
        long j11 = nVar.j();
        if (nVar.l() <= 0) {
            j10 = -j10;
        }
        return aVar.a(jG, j11, j10);
    }

    @yt.k
    public static final <T extends Comparable<? super T>> T D(@yt.k T t10, @yt.k T maximumValue) {
        f0.p(t10, "<this>");
        f0.p(maximumValue, "maximumValue");
        return t10.compareTo(maximumValue) > 0 ? maximumValue : t10;
    }

    @hk.h(name = "floatRangeContains")
    public static final boolean D0(@yt.k h<Float> hVar, double d10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Float.valueOf((float) d10));
    }

    @yt.l
    public static final Byte D1(double d10) {
        boolean z10 = false;
        if (-128.0d <= d10 && d10 <= 127.0d) {
            z10 = true;
        }
        if (z10) {
            return Byte.valueOf((byte) d10);
        }
        return null;
    }

    public static final short E(short s10, short s11) {
        return s10 > s11 ? s11 : s10;
    }

    @hk.h(name = "floatRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean E0(h hVar, int i10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Float.valueOf(i10));
    }

    @yt.l
    public static final Byte E1(float f10) {
        boolean z10 = false;
        if (-128.0f <= f10 && f10 <= 127.0f) {
            z10 = true;
        }
        if (z10) {
            return Byte.valueOf((byte) f10);
        }
        return null;
    }

    public static final byte F(byte b10, byte b11, byte b12) {
        if (b11 <= b12) {
            return b10 < b11 ? b11 : b10 > b12 ? b12 : b10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) b12) + " is less than minimum " + ((int) b11) + '.');
    }

    @hk.h(name = "floatRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean F0(h hVar, long j10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Float.valueOf(j10));
    }

    @yt.l
    public static final Byte F1(int i10) {
        if (new m(-128, 127).p(i10)) {
            return Byte.valueOf((byte) i10);
        }
        return null;
    }

    public static final double G(double d10, double d11, double d12) {
        if (d11 <= d12) {
            return d10 < d11 ? d11 : d10 > d12 ? d12 : d10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + d12 + " is less than minimum " + d11 + '.');
    }

    @hk.h(name = "floatRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean G0(h hVar, short s10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Float.valueOf(s10));
    }

    @yt.l
    public static final Byte G1(long j10) {
        if (new p(-128L, 127L).p(j10)) {
            return Byte.valueOf((byte) j10);
        }
        return null;
    }

    public static final float H(float f10, float f11, float f12) {
        if (f11 <= f12) {
            return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f12 + " is less than minimum " + f11 + '.');
    }

    @hk.h(name = "intRangeContains")
    public static final boolean H0(@yt.k h<Integer> hVar, byte b10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Integer.valueOf(b10));
    }

    @yt.l
    public static final Byte H1(short s10) {
        if (L0(new m(-128, 127), s10)) {
            return Byte.valueOf((byte) s10);
        }
        return null;
    }

    public static final int I(int i10, int i11, int i12) {
        if (i11 <= i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + '.');
    }

    @hk.h(name = "intRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean I0(h hVar, double d10) {
        f0.p(hVar, "<this>");
        Integer numI1 = I1(d10);
        if (numI1 != null) {
            return hVar.contains(numI1);
        }
        return false;
    }

    @yt.l
    public static final Integer I1(double d10) {
        boolean z10 = false;
        if (-2.147483648E9d <= d10 && d10 <= 2.147483647E9d) {
            z10 = true;
        }
        if (z10) {
            return Integer.valueOf((int) d10);
        }
        return null;
    }

    public static final int J(int i10, @yt.k h<Integer> range) {
        f0.p(range, "range");
        if (range instanceof g) {
            return ((Number) N(Integer.valueOf(i10), (g) range)).intValue();
        }
        if (!range.isEmpty()) {
            return i10 < ((Number) range.a()).intValue() ? ((Number) range.a()).intValue() : i10 > ((Number) range.e()).intValue() ? ((Number) range.e()).intValue() : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @hk.h(name = "intRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean J0(h hVar, float f10) {
        f0.p(hVar, "<this>");
        Integer numJ1 = J1(f10);
        if (numJ1 != null) {
            return hVar.contains(numJ1);
        }
        return false;
    }

    @yt.l
    public static final Integer J1(float f10) {
        boolean z10 = false;
        if (-2.1474836E9f <= f10 && f10 <= 2.1474836E9f) {
            z10 = true;
        }
        if (z10) {
            return Integer.valueOf((int) f10);
        }
        return null;
    }

    public static final long K(long j10, long j11, long j12) {
        if (j11 <= j12) {
            return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j12 + " is less than minimum " + j11 + '.');
    }

    @hk.h(name = "intRangeContains")
    public static final boolean K0(@yt.k h<Integer> hVar, long j10) {
        f0.p(hVar, "<this>");
        Integer numK1 = K1(j10);
        if (numK1 != null) {
            return hVar.contains(numK1);
        }
        return false;
    }

    @yt.l
    public static final Integer K1(long j10) {
        if (new p(-2147483648L, 2147483647L).p(j10)) {
            return Integer.valueOf((int) j10);
        }
        return null;
    }

    public static final long L(long j10, @yt.k h<Long> range) {
        f0.p(range, "range");
        if (range instanceof g) {
            return ((Number) N(Long.valueOf(j10), (g) range)).longValue();
        }
        if (!range.isEmpty()) {
            return j10 < ((Number) range.a()).longValue() ? ((Number) range.a()).longValue() : j10 > ((Number) range.e()).longValue() ? ((Number) range.e()).longValue() : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @hk.h(name = "intRangeContains")
    public static final boolean L0(@yt.k h<Integer> hVar, short s10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Integer.valueOf(s10));
    }

    @yt.l
    public static final Long L1(double d10) {
        boolean z10 = false;
        if (-9.223372036854776E18d <= d10 && d10 <= 9.223372036854776E18d) {
            z10 = true;
        }
        if (z10) {
            return Long.valueOf((long) d10);
        }
        return null;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> T M(@yt.k T t10, @yt.l T t11, @yt.l T t12) {
        f0.p(t10, "<this>");
        if (t11 == null || t12 == null) {
            if (t11 != null && t10.compareTo(t11) < 0) {
                return t11;
            }
            if (t12 != null && t10.compareTo(t12) > 0) {
                return t12;
            }
        } else {
            if (t11.compareTo(t12) > 0) {
                throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + t12 + " is less than minimum " + t11 + '.');
            }
            if (t10.compareTo(t11) < 0) {
                return t11;
            }
            if (t10.compareTo(t12) > 0) {
                return t12;
            }
        }
        return t10;
    }

    @hk.h(name = "intRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean M0(@yt.k s<Integer> sVar, byte b10) {
        f0.p(sVar, "<this>");
        return sVar.contains(Integer.valueOf(b10));
    }

    @yt.l
    public static final Long M1(float f10) {
        boolean z10 = false;
        if (-9.223372E18f <= f10 && f10 <= 9.223372E18f) {
            z10 = true;
        }
        if (z10) {
            return Long.valueOf((long) f10);
        }
        return null;
    }

    @v0(version = "1.1")
    @yt.k
    public static final <T extends Comparable<? super T>> T N(@yt.k T t10, @yt.k g<T> range) {
        f0.p(t10, "<this>");
        f0.p(range, "range");
        if (!range.isEmpty()) {
            return (!range.b(t10, range.a()) || range.b(range.a(), t10)) ? (!range.b(range.e(), t10) || range.b(t10, range.e())) ? t10 : range.e() : range.a();
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @hk.h(name = "intRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean N0(@yt.k s<Integer> sVar, long j10) {
        f0.p(sVar, "<this>");
        Integer numK1 = K1(j10);
        if (numK1 != null) {
            return sVar.contains(numK1);
        }
        return false;
    }

    @yt.l
    public static final Short N1(double d10) {
        boolean z10 = false;
        if (-32768.0d <= d10 && d10 <= 32767.0d) {
            z10 = true;
        }
        if (z10) {
            return Short.valueOf((short) d10);
        }
        return null;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> T O(@yt.k T t10, @yt.k h<T> range) {
        f0.p(t10, "<this>");
        f0.p(range, "range");
        if (range instanceof g) {
            return (T) N(t10, (g) range);
        }
        if (!range.isEmpty()) {
            return t10.compareTo(range.a()) < 0 ? (T) range.a() : t10.compareTo(range.e()) > 0 ? (T) range.e() : t10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + '.');
    }

    @hk.h(name = "intRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean O0(@yt.k s<Integer> sVar, short s10) {
        f0.p(sVar, "<this>");
        return sVar.contains(Integer.valueOf(s10));
    }

    @yt.l
    public static final Short O1(float f10) {
        boolean z10 = false;
        if (-32768.0f <= f10 && f10 <= 32767.0f) {
            z10 = true;
        }
        if (z10) {
            return Short.valueOf((short) f10);
        }
        return null;
    }

    public static final short P(short s10, short s11, short s12) {
        if (s11 <= s12) {
            return s10 < s11 ? s11 : s10 > s12 ? s12 : s10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((int) s12) + " is less than minimum " + ((int) s11) + '.');
    }

    @v0(version = "1.7")
    public static final char P0(@yt.k a aVar) {
        f0.p(aVar, "<this>");
        if (!aVar.isEmpty()) {
            return aVar.j();
        }
        throw new NoSuchElementException("Progression " + aVar + " is empty.");
    }

    @yt.l
    public static final Short P1(int i10) {
        if (new m(-32768, gg.b.f29413a).p(i10)) {
            return Short.valueOf((short) i10);
        }
        return null;
    }

    @bk.f
    @v0(version = "1.3")
    public static final boolean Q(c cVar, Character ch2) {
        f0.p(cVar, "<this>");
        return ch2 != null && cVar.p(ch2.charValue());
    }

    @v0(version = "1.7")
    public static final int Q0(@yt.k k kVar) {
        f0.p(kVar, "<this>");
        if (!kVar.isEmpty()) {
            return kVar.j();
        }
        throw new NoSuchElementException("Progression " + kVar + " is empty.");
    }

    @yt.l
    public static final Short Q1(long j10) {
        if (new p(-32768L, 32767L).p(j10)) {
            return Short.valueOf((short) j10);
        }
        return null;
    }

    @bk.f
    public static final boolean R(m mVar, byte b10) {
        f0.p(mVar, "<this>");
        return H0(mVar, b10);
    }

    @v0(version = "1.7")
    public static final long R0(@yt.k n nVar) {
        f0.p(nVar, "<this>");
        if (!nVar.isEmpty()) {
            return nVar.j();
        }
        throw new NoSuchElementException("Progression " + nVar + " is empty.");
    }

    @yt.k
    public static final c R1(char c10, char c11) {
        return f0.t(c11, 0) <= 0 ? c.f47395e.a() : new c(c10, (char) (c11 - 1));
    }

    @bk.f
    public static final boolean S(m mVar, long j10) {
        f0.p(mVar, "<this>");
        return K0(mVar, j10);
    }

    @v0(version = "1.7")
    @yt.l
    public static final Character S0(@yt.k a aVar) {
        f0.p(aVar, "<this>");
        if (aVar.isEmpty()) {
            return null;
        }
        return Character.valueOf(aVar.j());
    }

    @yt.k
    public static final m S1(byte b10, byte b11) {
        return new m(b10, b11 - 1);
    }

    @bk.f
    @v0(version = "1.3")
    public static final boolean T(m mVar, Integer num) {
        f0.p(mVar, "<this>");
        return num != null && mVar.p(num.intValue());
    }

    @v0(version = "1.7")
    @yt.l
    public static final Integer T0(@yt.k k kVar) {
        f0.p(kVar, "<this>");
        if (kVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(kVar.j());
    }

    @yt.k
    public static final m T1(byte b10, int i10) {
        return i10 <= Integer.MIN_VALUE ? m.f47413e.a() : new m(b10, i10 - 1);
    }

    @bk.f
    public static final boolean U(m mVar, short s10) {
        f0.p(mVar, "<this>");
        return L0(mVar, s10);
    }

    @v0(version = "1.7")
    @yt.l
    public static final Long U0(@yt.k n nVar) {
        f0.p(nVar, "<this>");
        if (nVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(nVar.j());
    }

    @yt.k
    public static final m U1(byte b10, short s10) {
        return new m(b10, s10 - 1);
    }

    @bk.f
    public static final boolean V(p pVar, byte b10) {
        f0.p(pVar, "<this>");
        return V0(pVar, b10);
    }

    @hk.h(name = "longRangeContains")
    public static final boolean V0(@yt.k h<Long> hVar, byte b10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Long.valueOf(b10));
    }

    @yt.k
    public static final m V1(int i10, byte b10) {
        return new m(i10, b10 - 1);
    }

    @bk.f
    public static final boolean W(p pVar, int i10) {
        f0.p(pVar, "<this>");
        return Y0(pVar, i10);
    }

    @hk.h(name = "longRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean W0(h hVar, double d10) {
        f0.p(hVar, "<this>");
        Long lL1 = L1(d10);
        if (lL1 != null) {
            return hVar.contains(lL1);
        }
        return false;
    }

    @yt.k
    public static final m W1(int i10, int i11) {
        return i11 <= Integer.MIN_VALUE ? m.f47413e.a() : new m(i10, i11 - 1);
    }

    @bk.f
    @v0(version = "1.3")
    public static final boolean X(p pVar, Long l10) {
        f0.p(pVar, "<this>");
        return l10 != null && pVar.p(l10.longValue());
    }

    @hk.h(name = "longRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean X0(h hVar, float f10) {
        f0.p(hVar, "<this>");
        Long lM1 = M1(f10);
        if (lM1 != null) {
            return hVar.contains(lM1);
        }
        return false;
    }

    @yt.k
    public static final m X1(int i10, short s10) {
        return new m(i10, s10 - 1);
    }

    @bk.f
    public static final boolean Y(p pVar, short s10) {
        f0.p(pVar, "<this>");
        return Z0(pVar, s10);
    }

    @hk.h(name = "longRangeContains")
    public static final boolean Y0(@yt.k h<Long> hVar, int i10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Long.valueOf(i10));
    }

    @yt.k
    public static final m Y1(short s10, byte b10) {
        return new m(s10, b10 - 1);
    }

    @hk.h(name = "doubleRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean Z(h hVar, byte b10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Double.valueOf(b10));
    }

    @hk.h(name = "longRangeContains")
    public static final boolean Z0(@yt.k h<Long> hVar, short s10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Long.valueOf(s10));
    }

    @yt.k
    public static final m Z1(short s10, int i10) {
        return i10 <= Integer.MIN_VALUE ? m.f47413e.a() : new m(s10, i10 - 1);
    }

    @hk.h(name = "doubleRangeContains")
    public static final boolean a0(@yt.k h<Double> hVar, float f10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Double.valueOf(f10));
    }

    @hk.h(name = "longRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean a1(@yt.k s<Long> sVar, byte b10) {
        f0.p(sVar, "<this>");
        return sVar.contains(Long.valueOf(b10));
    }

    @yt.k
    public static final m a2(short s10, short s11) {
        return new m(s10, s11 - 1);
    }

    @hk.h(name = "doubleRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean b0(h hVar, int i10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Double.valueOf(i10));
    }

    @hk.h(name = "longRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean b1(@yt.k s<Long> sVar, int i10) {
        f0.p(sVar, "<this>");
        return sVar.contains(Long.valueOf(i10));
    }

    @yt.k
    public static final p b2(byte b10, long j10) {
        return j10 <= Long.MIN_VALUE ? p.f47423e.a() : new p(b10, j10 - 1);
    }

    @hk.h(name = "doubleRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean c0(h hVar, long j10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Double.valueOf(j10));
    }

    @hk.h(name = "longRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean c1(@yt.k s<Long> sVar, short s10) {
        f0.p(sVar, "<this>");
        return sVar.contains(Long.valueOf(s10));
    }

    @yt.k
    public static final p c2(int i10, long j10) {
        return j10 <= Long.MIN_VALUE ? p.f47423e.a() : new p(i10, j10 - 1);
    }

    @hk.h(name = "doubleRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean d0(h hVar, short s10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Double.valueOf(s10));
    }

    @bk.f
    @v0(version = "1.3")
    public static final char d1(c cVar) {
        f0.p(cVar, "<this>");
        return e1(cVar, Random.f38003a);
    }

    @yt.k
    public static final p d2(long j10, byte b10) {
        return new p(j10, ((long) b10) - 1);
    }

    @hk.h(name = "doubleRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean e0(@yt.k s<Double> sVar, float f10) {
        f0.p(sVar, "<this>");
        return sVar.contains(Double.valueOf(f10));
    }

    @v0(version = "1.3")
    public static final char e1(@yt.k c cVar, @yt.k Random random) {
        f0.p(cVar, "<this>");
        f0.p(random, "random");
        try {
            return (char) random.q(cVar.g(), cVar.j() + 1);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @yt.k
    public static final p e2(long j10, int i10) {
        return new p(j10, ((long) i10) - 1);
    }

    @yt.k
    public static final a f0(char c10, char c11) {
        return a.f47381d.a(c10, c11, -1);
    }

    @bk.f
    @v0(version = "1.3")
    public static final int f1(m mVar) {
        f0.p(mVar, "<this>");
        return g1(mVar, Random.f38003a);
    }

    @yt.k
    public static final p f2(long j10, long j11) {
        return j11 <= Long.MIN_VALUE ? p.f47423e.a() : new p(j10, j11 - 1);
    }

    @yt.k
    public static final k g0(byte b10, byte b11) {
        return k.f47405d.a(b10, b11, -1);
    }

    @v0(version = "1.3")
    public static final int g1(@yt.k m mVar, @yt.k Random random) {
        f0.p(mVar, "<this>");
        f0.p(random, "random");
        try {
            return kotlin.random.d.h(random, mVar);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @yt.k
    public static final p g2(long j10, short s10) {
        return new p(j10, ((long) s10) - 1);
    }

    @yt.k
    public static final k h0(byte b10, int i10) {
        return k.f47405d.a(b10, i10, -1);
    }

    @bk.f
    @v0(version = "1.3")
    public static final long h1(p pVar) {
        f0.p(pVar, "<this>");
        return i1(pVar, Random.f38003a);
    }

    @yt.k
    public static final p h2(short s10, long j10) {
        return j10 <= Long.MIN_VALUE ? p.f47423e.a() : new p(s10, j10 - 1);
    }

    @yt.k
    public static final k i0(byte b10, short s10) {
        return k.f47405d.a(b10, s10, -1);
    }

    @v0(version = "1.3")
    public static final long i1(@yt.k p pVar, @yt.k Random random) {
        f0.p(pVar, "<this>");
        f0.p(random, "random");
        try {
            return kotlin.random.d.i(random, pVar);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @hk.h(name = "byteRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean j(h hVar, double d10) {
        f0.p(hVar, "<this>");
        Byte bD1 = D1(d10);
        if (bD1 != null) {
            return hVar.contains(bD1);
        }
        return false;
    }

    @yt.k
    public static final k j0(int i10, byte b10) {
        return k.f47405d.a(i10, b10, -1);
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @v0(version = "1.4")
    public static final Character j1(c cVar) {
        f0.p(cVar, "<this>");
        return k1(cVar, Random.f38003a);
    }

    @hk.h(name = "byteRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean k(h hVar, float f10) {
        f0.p(hVar, "<this>");
        Byte bE1 = E1(f10);
        if (bE1 != null) {
            return hVar.contains(bE1);
        }
        return false;
    }

    @yt.k
    public static final k k0(int i10, int i11) {
        return k.f47405d.a(i10, i11, -1);
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.l
    public static final Character k1(@yt.k c cVar, @yt.k Random random) {
        f0.p(cVar, "<this>");
        f0.p(random, "random");
        if (cVar.isEmpty()) {
            return null;
        }
        return Character.valueOf((char) random.q(cVar.g(), cVar.j() + 1));
    }

    @hk.h(name = "byteRangeContains")
    public static final boolean l(@yt.k h<Byte> hVar, int i10) {
        f0.p(hVar, "<this>");
        Byte bF1 = F1(i10);
        if (bF1 != null) {
            return hVar.contains(bF1);
        }
        return false;
    }

    @yt.k
    public static final k l0(int i10, short s10) {
        return k.f47405d.a(i10, s10, -1);
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @v0(version = "1.4")
    public static final Integer l1(m mVar) {
        f0.p(mVar, "<this>");
        return m1(mVar, Random.f38003a);
    }

    @hk.h(name = "byteRangeContains")
    public static final boolean m(@yt.k h<Byte> hVar, long j10) {
        f0.p(hVar, "<this>");
        Byte bG1 = G1(j10);
        if (bG1 != null) {
            return hVar.contains(bG1);
        }
        return false;
    }

    @yt.k
    public static final k m0(short s10, byte b10) {
        return k.f47405d.a(s10, b10, -1);
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.l
    public static final Integer m1(@yt.k m mVar, @yt.k Random random) {
        f0.p(mVar, "<this>");
        f0.p(random, "random");
        if (mVar.isEmpty()) {
            return null;
        }
        return Integer.valueOf(kotlin.random.d.h(random, mVar));
    }

    @hk.h(name = "byteRangeContains")
    public static final boolean n(@yt.k h<Byte> hVar, short s10) {
        f0.p(hVar, "<this>");
        Byte bH1 = H1(s10);
        if (bH1 != null) {
            return hVar.contains(bH1);
        }
        return false;
    }

    @yt.k
    public static final k n0(short s10, int i10) {
        return k.f47405d.a(s10, i10, -1);
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @v0(version = "1.4")
    public static final Long n1(p pVar) {
        f0.p(pVar, "<this>");
        return o1(pVar, Random.f38003a);
    }

    @hk.h(name = "byteRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean o(@yt.k s<Byte> sVar, int i10) {
        f0.p(sVar, "<this>");
        Byte bF1 = F1(i10);
        if (bF1 != null) {
            return sVar.contains(bF1);
        }
        return false;
    }

    @yt.k
    public static final k o0(short s10, short s11) {
        return k.f47405d.a(s10, s11, -1);
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.l
    public static final Long o1(@yt.k p pVar, @yt.k Random random) {
        f0.p(pVar, "<this>");
        f0.p(random, "random");
        if (pVar.isEmpty()) {
            return null;
        }
        return Long.valueOf(kotlin.random.d.i(random, pVar));
    }

    @hk.h(name = "byteRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean p(@yt.k s<Byte> sVar, long j10) {
        f0.p(sVar, "<this>");
        Byte bG1 = G1(j10);
        if (bG1 != null) {
            return sVar.contains(bG1);
        }
        return false;
    }

    @yt.k
    public static final n p0(byte b10, long j10) {
        return n.f47415d.a(b10, j10, -1L);
    }

    @yt.k
    public static final a p1(@yt.k a aVar) {
        f0.p(aVar, "<this>");
        return a.f47381d.a(aVar.j(), aVar.g(), -aVar.l());
    }

    @hk.h(name = "byteRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean q(@yt.k s<Byte> sVar, short s10) {
        f0.p(sVar, "<this>");
        Byte bH1 = H1(s10);
        if (bH1 != null) {
            return sVar.contains(bH1);
        }
        return false;
    }

    @yt.k
    public static final n q0(int i10, long j10) {
        return n.f47415d.a(i10, j10, -1L);
    }

    @yt.k
    public static final k q1(@yt.k k kVar) {
        f0.p(kVar, "<this>");
        return k.f47405d.a(kVar.j(), kVar.g(), -kVar.l());
    }

    public static final byte r(byte b10, byte b11) {
        return b10 < b11 ? b11 : b10;
    }

    @yt.k
    public static final n r0(long j10, byte b10) {
        return n.f47415d.a(j10, b10, -1L);
    }

    @yt.k
    public static final n r1(@yt.k n nVar) {
        f0.p(nVar, "<this>");
        return n.f47415d.a(nVar.j(), nVar.g(), -nVar.l());
    }

    public static final double s(double d10, double d11) {
        return d10 < d11 ? d11 : d10;
    }

    @yt.k
    public static final n s0(long j10, int i10) {
        return n.f47415d.a(j10, i10, -1L);
    }

    @hk.h(name = "shortRangeContains")
    public static final boolean s1(@yt.k h<Short> hVar, byte b10) {
        f0.p(hVar, "<this>");
        return hVar.contains(Short.valueOf(b10));
    }

    public static final float t(float f10, float f11) {
        return f10 < f11 ? f11 : f10;
    }

    @yt.k
    public static final n t0(long j10, long j11) {
        return n.f47415d.a(j10, j11, -1L);
    }

    @hk.h(name = "shortRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean t1(h hVar, double d10) {
        f0.p(hVar, "<this>");
        Short shN1 = N1(d10);
        if (shN1 != null) {
            return hVar.contains(shN1);
        }
        return false;
    }

    public static final int u(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    @yt.k
    public static final n u0(long j10, short s10) {
        return n.f47415d.a(j10, s10, -1L);
    }

    @hk.h(name = "shortRangeContains")
    @kotlin.k(message = "This `contains` operation mixing integer and floating point arguments has ambiguous semantics and is going to be removed.")
    @kotlin.l(errorSince = "1.4", hiddenSince = "1.5", warningSince = "1.3")
    public static final /* synthetic */ boolean u1(h hVar, float f10) {
        f0.p(hVar, "<this>");
        Short shO1 = O1(f10);
        if (shO1 != null) {
            return hVar.contains(shO1);
        }
        return false;
    }

    public static final long v(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    @yt.k
    public static final n v0(short s10, long j10) {
        return n.f47415d.a(s10, j10, -1L);
    }

    @hk.h(name = "shortRangeContains")
    public static final boolean v1(@yt.k h<Short> hVar, int i10) {
        f0.p(hVar, "<this>");
        Short shP1 = P1(i10);
        if (shP1 != null) {
            return hVar.contains(shP1);
        }
        return false;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> T w(@yt.k T t10, @yt.k T minimumValue) {
        f0.p(t10, "<this>");
        f0.p(minimumValue, "minimumValue");
        return t10.compareTo(minimumValue) < 0 ? minimumValue : t10;
    }

    @v0(version = "1.7")
    public static final char w0(@yt.k a aVar) {
        f0.p(aVar, "<this>");
        if (!aVar.isEmpty()) {
            return aVar.g();
        }
        throw new NoSuchElementException("Progression " + aVar + " is empty.");
    }

    @hk.h(name = "shortRangeContains")
    public static final boolean w1(@yt.k h<Short> hVar, long j10) {
        f0.p(hVar, "<this>");
        Short shQ1 = Q1(j10);
        if (shQ1 != null) {
            return hVar.contains(shQ1);
        }
        return false;
    }

    public static final short x(short s10, short s11) {
        return s10 < s11 ? s11 : s10;
    }

    @v0(version = "1.7")
    public static final int x0(@yt.k k kVar) {
        f0.p(kVar, "<this>");
        if (!kVar.isEmpty()) {
            return kVar.g();
        }
        throw new NoSuchElementException("Progression " + kVar + " is empty.");
    }

    @hk.h(name = "shortRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean x1(@yt.k s<Short> sVar, byte b10) {
        f0.p(sVar, "<this>");
        return sVar.contains(Short.valueOf(b10));
    }

    public static final byte y(byte b10, byte b11) {
        return b10 > b11 ? b11 : b10;
    }

    @v0(version = "1.7")
    public static final long y0(@yt.k n nVar) {
        f0.p(nVar, "<this>");
        if (!nVar.isEmpty()) {
            return nVar.g();
        }
        throw new NoSuchElementException("Progression " + nVar + " is empty.");
    }

    @hk.h(name = "shortRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean y1(@yt.k s<Short> sVar, int i10) {
        f0.p(sVar, "<this>");
        Short shP1 = P1(i10);
        if (shP1 != null) {
            return sVar.contains(shP1);
        }
        return false;
    }

    public static final double z(double d10, double d11) {
        return d10 > d11 ? d11 : d10;
    }

    @v0(version = "1.7")
    @yt.l
    public static final Character z0(@yt.k a aVar) {
        f0.p(aVar, "<this>");
        if (aVar.isEmpty()) {
            return null;
        }
        return Character.valueOf(aVar.g());
    }

    @hk.h(name = "shortRangeContains")
    @v0(version = "1.7")
    @kotlin.q
    public static final boolean z1(@yt.k s<Short> sVar, long j10) {
        f0.p(sVar, "<this>");
        Short shQ1 = Q1(j10);
        if (shQ1 != null) {
            return sVar.contains(shQ1);
        }
        return false;
    }
}
