package kotlin.collections.unsigned;

import bk.f;
import hk.h;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.b2;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.k0;
import kotlin.h1;
import kotlin.i1;
import kotlin.jvm.internal.f0;
import kotlin.k;
import kotlin.l;
import kotlin.l1;
import kotlin.m0;
import kotlin.m1;
import kotlin.p1;
import kotlin.q1;
import kotlin.s;
import kotlin.t0;
import kotlin.v0;
import kotlin.v1;
import kotlin.w1;
import qk.m;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    public static final class a extends kotlin.collections.b<l1> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f37741b;

        public a(int[] iArr) {
            this.f37741b = iArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return m1.r(this.f37741b);
        }

        public boolean b(int i10) {
            return m1.j(this.f37741b, i10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof l1) {
                return b(((l1) obj).l0());
            }
            return false;
        }

        public int d(int i10) {
            return m1.p(this.f37741b, i10);
        }

        @Override // kotlin.collections.b, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i10) {
            return l1.d(d(i10));
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof l1) {
                return l(((l1) obj).l0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return m1.u(this.f37741b);
        }

        public int l(int i10) {
            return ArraysKt___ArraysKt.hg(this.f37741b, i10);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof l1) {
                return m(((l1) obj).l0());
            }
            return -1;
        }

        public int m(int i10) {
            return ArraysKt___ArraysKt.li(this.f37741b, i10);
        }
    }

    /* JADX INFO: renamed from: kotlin.collections.unsigned.b$b, reason: collision with other inner class name */
    public static final class C0430b extends kotlin.collections.b<p1> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f37742b;

        public C0430b(long[] jArr) {
            this.f37742b = jArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return q1.r(this.f37742b);
        }

        public boolean b(long j10) {
            return q1.j(this.f37742b, j10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof p1) {
                return b(((p1) obj).l0());
            }
            return false;
        }

        public long d(int i10) {
            return q1.p(this.f37742b, i10);
        }

        @Override // kotlin.collections.b, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i10) {
            return p1.d(d(i10));
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof p1) {
                return l(((p1) obj).l0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return q1.u(this.f37742b);
        }

        public int l(long j10) {
            return ArraysKt___ArraysKt.ig(this.f37742b, j10);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof p1) {
                return m(((p1) obj).l0());
            }
            return -1;
        }

        public int m(long j10) {
            return ArraysKt___ArraysKt.mi(this.f37742b, j10);
        }
    }

    public static final class c extends kotlin.collections.b<h1> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f37743b;

        public c(byte[] bArr) {
            this.f37743b = bArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return i1.r(this.f37743b);
        }

        public boolean b(byte b10) {
            return i1.j(this.f37743b, b10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof h1) {
                return b(((h1) obj).j0());
            }
            return false;
        }

        public byte d(int i10) {
            return i1.p(this.f37743b, i10);
        }

        @Override // kotlin.collections.b, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i10) {
            return h1.d(d(i10));
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof h1) {
                return l(((h1) obj).j0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return i1.u(this.f37743b);
        }

        public int l(byte b10) {
            return ArraysKt___ArraysKt.dg(this.f37743b, b10);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof h1) {
                return m(((h1) obj).j0());
            }
            return -1;
        }

        public int m(byte b10) {
            return ArraysKt___ArraysKt.hi(this.f37743b, b10);
        }
    }

    public static final class d extends kotlin.collections.b<v1> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ short[] f37744b;

        public d(short[] sArr) {
            this.f37744b = sArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return w1.r(this.f37744b);
        }

        public boolean b(short s10) {
            return w1.j(this.f37744b, s10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof v1) {
                return b(((v1) obj).j0());
            }
            return false;
        }

        public short d(int i10) {
            return w1.p(this.f37744b, i10);
        }

        @Override // kotlin.collections.b, java.util.List
        public /* bridge */ /* synthetic */ Object get(int i10) {
            return v1.d(d(i10));
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof v1) {
                return l(((v1) obj).j0());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return w1.u(this.f37744b);
        }

        public int l(short s10) {
            return ArraysKt___ArraysKt.kg(this.f37744b, s10);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof v1) {
                return m(((v1) obj).j0());
            }
            return -1;
        }

        public int m(short s10) {
            return ArraysKt___ArraysKt.oi(this.f37744b, s10);
        }
    }

    @k(message = "Use maxWithOrNull instead.", replaceWith = @t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ v1 A(short[] maxWith, Comparator comparator) {
        f0.p(maxWith, "$this$maxWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.M6(maxWith, comparator);
    }

    @k(message = "Use maxWithOrNull instead.", replaceWith = @t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ p1 B(long[] maxWith, Comparator comparator) {
        f0.p(maxWith, "$this$maxWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.N6(maxWith, comparator);
    }

    @k(message = "Use minOrNull instead.", replaceWith = @t0(expression = "this.minOrNull()", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ l1 C(int[] min) {
        f0.p(min, "$this$min");
        return UArraysKt___UArraysKt.G7(min);
    }

    @k(message = "Use minOrNull instead.", replaceWith = @t0(expression = "this.minOrNull()", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ h1 D(byte[] min) {
        f0.p(min, "$this$min");
        return UArraysKt___UArraysKt.H7(min);
    }

    @k(message = "Use minOrNull instead.", replaceWith = @t0(expression = "this.minOrNull()", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ p1 E(long[] min) {
        f0.p(min, "$this$min");
        return UArraysKt___UArraysKt.I7(min);
    }

    @k(message = "Use minOrNull instead.", replaceWith = @t0(expression = "this.minOrNull()", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ v1 F(short[] min) {
        f0.p(min, "$this$min");
        return UArraysKt___UArraysKt.J7(min);
    }

    @f
    @k(message = "Use minByOrNull instead.", replaceWith = @t0(expression = "this.minByOrNull(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> h1 G(byte[] minBy, ik.l<? super h1, ? extends R> selector) {
        f0.p(minBy, "$this$minBy");
        f0.p(selector, "selector");
        if (i1.u(minBy)) {
            return null;
        }
        byte bP = i1.p(minBy, 0);
        int iRe = ArraysKt___ArraysKt.Re(minBy);
        if (iRe != 0) {
            R rI = selector.i(h1.d(bP));
            k0 it2 = new m(1, iRe).iterator();
            while (it2.hasNext()) {
                byte bP2 = i1.p(minBy, it2.b());
                R rI2 = selector.i(h1.d(bP2));
                if (rI.compareTo(rI2) > 0) {
                    bP = bP2;
                    rI = rI2;
                }
            }
        }
        return h1.d(bP);
    }

    @f
    @k(message = "Use minByOrNull instead.", replaceWith = @t0(expression = "this.minByOrNull(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> p1 H(long[] minBy, ik.l<? super p1, ? extends R> selector) {
        f0.p(minBy, "$this$minBy");
        f0.p(selector, "selector");
        if (q1.u(minBy)) {
            return null;
        }
        long jP = q1.p(minBy, 0);
        int iWe = ArraysKt___ArraysKt.We(minBy);
        if (iWe != 0) {
            R rI = selector.i(p1.d(jP));
            k0 it2 = new m(1, iWe).iterator();
            while (it2.hasNext()) {
                long jP2 = q1.p(minBy, it2.b());
                R rI2 = selector.i(p1.d(jP2));
                if (rI.compareTo(rI2) > 0) {
                    jP = jP2;
                    rI = rI2;
                }
            }
        }
        return p1.d(jP);
    }

    @f
    @k(message = "Use minByOrNull instead.", replaceWith = @t0(expression = "this.minByOrNull(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> l1 I(int[] minBy, ik.l<? super l1, ? extends R> selector) {
        f0.p(minBy, "$this$minBy");
        f0.p(selector, "selector");
        if (m1.u(minBy)) {
            return null;
        }
        int iP = m1.p(minBy, 0);
        int iVe = ArraysKt___ArraysKt.Ve(minBy);
        if (iVe != 0) {
            R rI = selector.i(l1.d(iP));
            k0 it2 = new m(1, iVe).iterator();
            while (it2.hasNext()) {
                int iP2 = m1.p(minBy, it2.b());
                R rI2 = selector.i(l1.d(iP2));
                if (rI.compareTo(rI2) > 0) {
                    iP = iP2;
                    rI = rI2;
                }
            }
        }
        return l1.d(iP);
    }

    @f
    @k(message = "Use minByOrNull instead.", replaceWith = @t0(expression = "this.minByOrNull(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> v1 J(short[] minBy, ik.l<? super v1, ? extends R> selector) {
        f0.p(minBy, "$this$minBy");
        f0.p(selector, "selector");
        if (w1.u(minBy)) {
            return null;
        }
        short sP = w1.p(minBy, 0);
        int iYe = ArraysKt___ArraysKt.Ye(minBy);
        if (iYe != 0) {
            R rI = selector.i(v1.d(sP));
            k0 it2 = new m(1, iYe).iterator();
            while (it2.hasNext()) {
                short sP2 = w1.p(minBy, it2.b());
                R rI2 = selector.i(v1.d(sP2));
                if (rI.compareTo(rI2) > 0) {
                    sP = sP2;
                    rI = rI2;
                }
            }
        }
        return v1.d(sP);
    }

    @k(message = "Use minWithOrNull instead.", replaceWith = @t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ h1 K(byte[] minWith, Comparator comparator) {
        f0.p(minWith, "$this$minWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.O7(minWith, comparator);
    }

    @k(message = "Use minWithOrNull instead.", replaceWith = @t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ l1 L(int[] minWith, Comparator comparator) {
        f0.p(minWith, "$this$minWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.P7(minWith, comparator);
    }

    @k(message = "Use minWithOrNull instead.", replaceWith = @t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ v1 M(short[] minWith, Comparator comparator) {
        f0.p(minWith, "$this$minWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.Q7(minWith, comparator);
    }

    @k(message = "Use minWithOrNull instead.", replaceWith = @t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ p1 N(long[] minWith, Comparator comparator) {
        f0.p(minWith, "$this$minWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.R7(minWith, comparator);
    }

    @h(name = "sumOfBigDecimal")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final BigDecimal O(byte[] sumOf, ik.l<? super h1, ? extends BigDecimal> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        int iR = i1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(h1.d(i1.p(sumOf, i10))));
            f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @h(name = "sumOfBigDecimal")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final BigDecimal P(int[] sumOf, ik.l<? super l1, ? extends BigDecimal> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        int iR = m1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(l1.d(m1.p(sumOf, i10))));
            f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @h(name = "sumOfBigDecimal")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final BigDecimal Q(long[] sumOf, ik.l<? super p1, ? extends BigDecimal> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        int iR = q1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(p1.d(q1.p(sumOf, i10))));
            f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @h(name = "sumOfBigDecimal")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final BigDecimal R(short[] sumOf, ik.l<? super v1, ? extends BigDecimal> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        int iR = w1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(v1.d(w1.p(sumOf, i10))));
            f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @h(name = "sumOfBigInteger")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final BigInteger S(byte[] sumOf, ik.l<? super h1, ? extends BigInteger> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        int iR = i1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(h1.d(i1.p(sumOf, i10))));
            f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @h(name = "sumOfBigInteger")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final BigInteger T(int[] sumOf, ik.l<? super l1, ? extends BigInteger> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        int iR = m1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(l1.d(m1.p(sumOf, i10))));
            f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @h(name = "sumOfBigInteger")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final BigInteger U(long[] sumOf, ik.l<? super p1, ? extends BigInteger> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        int iR = q1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(p1.d(q1.p(sumOf, i10))));
            f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @h(name = "sumOfBigInteger")
    @m0
    @f
    @s
    @v0(version = "1.4")
    public static final BigInteger V(short[] sumOf, ik.l<? super v1, ? extends BigInteger> selector) {
        f0.p(sumOf, "$this$sumOf");
        f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        int iR = w1.r(sumOf);
        for (int i10 = 0; i10 < iR; i10++) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(v1.d(w1.p(sumOf, i10))));
            f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @s
    @v0(version = "1.3")
    @yt.k
    public static final List<l1> a(@yt.k int[] asList) {
        f0.p(asList, "$this$asList");
        return new a(asList);
    }

    @s
    @v0(version = "1.3")
    @yt.k
    public static final List<h1> b(@yt.k byte[] asList) {
        f0.p(asList, "$this$asList");
        return new c(asList);
    }

    @s
    @v0(version = "1.3")
    @yt.k
    public static final List<p1> c(@yt.k long[] asList) {
        f0.p(asList, "$this$asList");
        return new C0430b(asList);
    }

    @s
    @v0(version = "1.3")
    @yt.k
    public static final List<v1> d(@yt.k short[] asList) {
        f0.p(asList, "$this$asList");
        return new d(asList);
    }

    @s
    @v0(version = "1.3")
    public static final int e(@yt.k int[] binarySearch, int i10, int i11, int i12) {
        f0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.b.f37685a.d(i11, i12, m1.r(binarySearch));
        int i13 = i12 - 1;
        while (i11 <= i13) {
            int i14 = (i11 + i13) >>> 1;
            int iC = b2.c(binarySearch[i14], i10);
            if (iC < 0) {
                i11 = i14 + 1;
            } else {
                if (iC <= 0) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return -(i11 + 1);
    }

    public static /* synthetic */ int f(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = m1.r(iArr);
        }
        return e(iArr, i10, i11, i12);
    }

    @s
    @v0(version = "1.3")
    public static final int g(@yt.k short[] binarySearch, short s10, int i10, int i11) {
        f0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.b.f37685a.d(i10, i11, w1.r(binarySearch));
        int i12 = s10 & v1.f38215d;
        int i13 = i11 - 1;
        while (i10 <= i13) {
            int i14 = (i10 + i13) >>> 1;
            int iC = b2.c(binarySearch[i14], i12);
            if (iC < 0) {
                i10 = i14 + 1;
            } else {
                if (iC <= 0) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int h(short[] sArr, short s10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = w1.r(sArr);
        }
        return g(sArr, s10, i10, i11);
    }

    @s
    @v0(version = "1.3")
    public static final int i(@yt.k long[] binarySearch, long j10, int i10, int i11) {
        f0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.b.f37685a.d(i10, i11, q1.r(binarySearch));
        int i12 = i11 - 1;
        while (i10 <= i12) {
            int i13 = (i10 + i12) >>> 1;
            int iG = b2.g(binarySearch[i13], j10);
            if (iG < 0) {
                i10 = i13 + 1;
            } else {
                if (iG <= 0) {
                    return i13;
                }
                i12 = i13 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int j(long[] jArr, long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = q1.r(jArr);
        }
        return i(jArr, j10, i10, i11);
    }

    @s
    @v0(version = "1.3")
    public static final int k(@yt.k byte[] binarySearch, byte b10, int i10, int i11) {
        f0.p(binarySearch, "$this$binarySearch");
        kotlin.collections.b.f37685a.d(i10, i11, i1.r(binarySearch));
        int i12 = b10 & 255;
        int i13 = i11 - 1;
        while (i10 <= i13) {
            int i14 = (i10 + i13) >>> 1;
            int iC = b2.c(binarySearch[i14], i12);
            if (iC < 0) {
                i10 = i14 + 1;
            } else {
                if (iC <= 0) {
                    return i14;
                }
                i13 = i14 - 1;
            }
        }
        return -(i10 + 1);
    }

    public static /* synthetic */ int l(byte[] bArr, byte b10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = i1.r(bArr);
        }
        return k(bArr, b10, i10, i11);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final byte m(byte[] elementAt, int i10) {
        f0.p(elementAt, "$this$elementAt");
        return i1.p(elementAt, i10);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final short n(short[] elementAt, int i10) {
        f0.p(elementAt, "$this$elementAt");
        return w1.p(elementAt, i10);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final int o(int[] elementAt, int i10) {
        f0.p(elementAt, "$this$elementAt");
        return m1.p(elementAt, i10);
    }

    @f
    @s
    @v0(version = "1.3")
    public static final long p(long[] elementAt, int i10) {
        f0.p(elementAt, "$this$elementAt");
        return q1.p(elementAt, i10);
    }

    @k(message = "Use maxOrNull instead.", replaceWith = @t0(expression = "this.maxOrNull()", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ l1 q(int[] max) {
        f0.p(max, "$this$max");
        return UArraysKt___UArraysKt.C6(max);
    }

    @k(message = "Use maxOrNull instead.", replaceWith = @t0(expression = "this.maxOrNull()", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ h1 r(byte[] max) {
        f0.p(max, "$this$max");
        return UArraysKt___UArraysKt.D6(max);
    }

    @k(message = "Use maxOrNull instead.", replaceWith = @t0(expression = "this.maxOrNull()", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ p1 s(long[] max) {
        f0.p(max, "$this$max");
        return UArraysKt___UArraysKt.E6(max);
    }

    @k(message = "Use maxOrNull instead.", replaceWith = @t0(expression = "this.maxOrNull()", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ v1 t(short[] max) {
        f0.p(max, "$this$max");
        return UArraysKt___UArraysKt.F6(max);
    }

    @f
    @k(message = "Use maxByOrNull instead.", replaceWith = @t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> h1 u(byte[] maxBy, ik.l<? super h1, ? extends R> selector) {
        f0.p(maxBy, "$this$maxBy");
        f0.p(selector, "selector");
        if (i1.u(maxBy)) {
            return null;
        }
        byte bP = i1.p(maxBy, 0);
        int iRe = ArraysKt___ArraysKt.Re(maxBy);
        if (iRe != 0) {
            R rI = selector.i(h1.d(bP));
            k0 it2 = new m(1, iRe).iterator();
            while (it2.hasNext()) {
                byte bP2 = i1.p(maxBy, it2.b());
                R rI2 = selector.i(h1.d(bP2));
                if (rI.compareTo(rI2) < 0) {
                    bP = bP2;
                    rI = rI2;
                }
            }
        }
        return h1.d(bP);
    }

    @f
    @k(message = "Use maxByOrNull instead.", replaceWith = @t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> p1 v(long[] maxBy, ik.l<? super p1, ? extends R> selector) {
        f0.p(maxBy, "$this$maxBy");
        f0.p(selector, "selector");
        if (q1.u(maxBy)) {
            return null;
        }
        long jP = q1.p(maxBy, 0);
        int iWe = ArraysKt___ArraysKt.We(maxBy);
        if (iWe != 0) {
            R rI = selector.i(p1.d(jP));
            k0 it2 = new m(1, iWe).iterator();
            while (it2.hasNext()) {
                long jP2 = q1.p(maxBy, it2.b());
                R rI2 = selector.i(p1.d(jP2));
                if (rI.compareTo(rI2) < 0) {
                    jP = jP2;
                    rI = rI2;
                }
            }
        }
        return p1.d(jP);
    }

    @f
    @k(message = "Use maxByOrNull instead.", replaceWith = @t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> l1 w(int[] maxBy, ik.l<? super l1, ? extends R> selector) {
        f0.p(maxBy, "$this$maxBy");
        f0.p(selector, "selector");
        if (m1.u(maxBy)) {
            return null;
        }
        int iP = m1.p(maxBy, 0);
        int iVe = ArraysKt___ArraysKt.Ve(maxBy);
        if (iVe != 0) {
            R rI = selector.i(l1.d(iP));
            k0 it2 = new m(1, iVe).iterator();
            while (it2.hasNext()) {
                int iP2 = m1.p(maxBy, it2.b());
                R rI2 = selector.i(l1.d(iP2));
                if (rI.compareTo(rI2) < 0) {
                    iP = iP2;
                    rI = rI2;
                }
            }
        }
        return l1.d(iP);
    }

    @f
    @k(message = "Use maxByOrNull instead.", replaceWith = @t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> v1 x(short[] maxBy, ik.l<? super v1, ? extends R> selector) {
        f0.p(maxBy, "$this$maxBy");
        f0.p(selector, "selector");
        if (w1.u(maxBy)) {
            return null;
        }
        short sP = w1.p(maxBy, 0);
        int iYe = ArraysKt___ArraysKt.Ye(maxBy);
        if (iYe != 0) {
            R rI = selector.i(v1.d(sP));
            k0 it2 = new m(1, iYe).iterator();
            while (it2.hasNext()) {
                short sP2 = w1.p(maxBy, it2.b());
                R rI2 = selector.i(v1.d(sP2));
                if (rI.compareTo(rI2) < 0) {
                    sP = sP2;
                    rI = rI2;
                }
            }
        }
        return v1.d(sP);
    }

    @k(message = "Use maxWithOrNull instead.", replaceWith = @t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ h1 y(byte[] maxWith, Comparator comparator) {
        f0.p(maxWith, "$this$maxWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.K6(maxWith, comparator);
    }

    @k(message = "Use maxWithOrNull instead.", replaceWith = @t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @s
    @v0(version = "1.3")
    @l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ l1 z(int[] maxWith, Comparator comparator) {
        f0.p(maxWith, "$this$maxWith");
        f0.p(comparator, "comparator");
        return UArraysKt___UArraysKt.L6(maxWith, comparator);
    }
}
