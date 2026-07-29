package kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3420:1\n14166#2,14:3421\n14189#2,14:3435\n14212#2,14:3449\n14235#2,14:3463\n14258#2,14:3477\n14281#2,14:3491\n14304#2,14:3505\n14327#2,14:3519\n14350#2,14:3533\n16752#2,14:3547\n16775#2,14:3561\n16798#2,14:3575\n16821#2,14:3589\n16844#2,14:3603\n16867#2,14:3617\n16890#2,14:3631\n16913#2,14:3645\n16936#2,14:3659\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt\n*L\n2812#1:3421,14\n2819#1:3435,14\n2826#1:3449,14\n2833#1:3463,14\n2840#1:3477,14\n2847#1:3491,14\n2854#1:3505,14\n2861#1:3519,14\n2868#1:3533,14\n3010#1:3547,14\n3017#1:3561,14\n3024#1:3575,14\n3031#1:3589,14\n3038#1:3603,14\n3045#1:3617,14\n3052#1:3631,14\n3059#1:3645,14\n3066#1:3659,14\n*E\n"})
public class m extends l {

    public static final class a extends kotlin.collections.b<Byte> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f37728b;

        public a(byte[] bArr) {
            this.f37728b = bArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return this.f37728b.length;
        }

        public boolean b(byte b10) {
            return ArraysKt___ArraysKt.N8(this.f37728b, b10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Byte) {
                return b(((Number) obj).byteValue());
            }
            return false;
        }

        @Override // kotlin.collections.b, java.util.List
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Byte get(int i10) {
            return Byte.valueOf(this.f37728b[i10]);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Byte) {
                return l(((Number) obj).byteValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f37728b.length == 0;
        }

        public int l(byte b10) {
            return ArraysKt___ArraysKt.dg(this.f37728b, b10);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Byte) {
                return m(((Number) obj).byteValue());
            }
            return -1;
        }

        public int m(byte b10) {
            return ArraysKt___ArraysKt.hi(this.f37728b, b10);
        }
    }

    public static final class b extends kotlin.collections.b<Short> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ short[] f37729b;

        public b(short[] sArr) {
            this.f37729b = sArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return this.f37729b.length;
        }

        public boolean b(short s10) {
            return ArraysKt___ArraysKt.U8(this.f37729b, s10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Short) {
                return b(((Number) obj).shortValue());
            }
            return false;
        }

        @Override // kotlin.collections.b, java.util.List
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Short get(int i10) {
            return Short.valueOf(this.f37729b[i10]);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Short) {
                return l(((Number) obj).shortValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f37729b.length == 0;
        }

        public int l(short s10) {
            return ArraysKt___ArraysKt.kg(this.f37729b, s10);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Short) {
                return m(((Number) obj).shortValue());
            }
            return -1;
        }

        public int m(short s10) {
            return ArraysKt___ArraysKt.oi(this.f37729b, s10);
        }
    }

    public static final class c extends kotlin.collections.b<Integer> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f37730b;

        public c(int[] iArr) {
            this.f37730b = iArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return this.f37730b.length;
        }

        public boolean b(int i10) {
            return ArraysKt___ArraysKt.R8(this.f37730b, i10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Integer) {
                return b(((Number) obj).intValue());
            }
            return false;
        }

        @Override // kotlin.collections.b, java.util.List
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Integer get(int i10) {
            return Integer.valueOf(this.f37730b[i10]);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Integer) {
                return l(((Number) obj).intValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f37730b.length == 0;
        }

        public int l(int i10) {
            return ArraysKt___ArraysKt.hg(this.f37730b, i10);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Integer) {
                return m(((Number) obj).intValue());
            }
            return -1;
        }

        public int m(int i10) {
            return ArraysKt___ArraysKt.li(this.f37730b, i10);
        }
    }

    public static final class d extends kotlin.collections.b<Long> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long[] f37731b;

        public d(long[] jArr) {
            this.f37731b = jArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return this.f37731b.length;
        }

        public boolean b(long j10) {
            return ArraysKt___ArraysKt.S8(this.f37731b, j10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Long) {
                return b(((Number) obj).longValue());
            }
            return false;
        }

        @Override // kotlin.collections.b, java.util.List
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Long get(int i10) {
            return Long.valueOf(this.f37731b[i10]);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Long) {
                return l(((Number) obj).longValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f37731b.length == 0;
        }

        public int l(long j10) {
            return ArraysKt___ArraysKt.ig(this.f37731b, j10);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Long) {
                return m(((Number) obj).longValue());
            }
            return -1;
        }

        public int m(long j10) {
            return ArraysKt___ArraysKt.mi(this.f37731b, j10);
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3420:1\n12794#2,2:3421\n1687#2,6:3423\n1795#2,6:3429\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$5\n*L\n199#1:3421,2\n201#1:3423,6\n202#1:3429,6\n*E\n"})
    public static final class e extends kotlin.collections.b<Float> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float[] f37732b;

        public e(float[] fArr) {
            this.f37732b = fArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return this.f37732b.length;
        }

        public boolean b(float f10) {
            for (float f11 : this.f37732b) {
                if (Float.floatToIntBits(f11) == Float.floatToIntBits(f10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Float) {
                return b(((Number) obj).floatValue());
            }
            return false;
        }

        @Override // kotlin.collections.b, java.util.List
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Float get(int i10) {
            return Float.valueOf(this.f37732b[i10]);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Float) {
                return l(((Number) obj).floatValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f37732b.length == 0;
        }

        public int l(float f10) {
            float[] fArr = this.f37732b;
            int length = fArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (Float.floatToIntBits(fArr[i10]) == Float.floatToIntBits(f10)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Float) {
                return m(((Number) obj).floatValue());
            }
            return -1;
        }

        public int m(float f10) {
            float[] fArr = this.f37732b;
            int length = fArr.length - 1;
            if (length < 0) {
                return -1;
            }
            while (true) {
                int i10 = length - 1;
                if (Float.floatToIntBits(fArr[length]) == Float.floatToIntBits(f10)) {
                    return length;
                }
                if (i10 < 0) {
                    return -1;
                }
                length = i10;
            }
        }
    }

    @kotlin.jvm.internal.t0({"SMAP\n_ArraysJvm.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$6\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,3420:1\n12804#2,2:3421\n1699#2,6:3423\n1807#2,6:3429\n*S KotlinDebug\n*F\n+ 1 _ArraysJvm.kt\nkotlin/collections/ArraysKt___ArraysJvmKt$asList$6\n*L\n213#1:3421,2\n215#1:3423,6\n216#1:3429,6\n*E\n"})
    public static final class f extends kotlin.collections.b<Double> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ double[] f37733b;

        public f(double[] dArr) {
            this.f37733b = dArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return this.f37733b.length;
        }

        public boolean b(double d10) {
            for (double d11 : this.f37733b) {
                if (Double.doubleToLongBits(d11) == Double.doubleToLongBits(d10)) {
                    return true;
                }
            }
            return false;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Double) {
                return b(((Number) obj).doubleValue());
            }
            return false;
        }

        @Override // kotlin.collections.b, java.util.List
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Double get(int i10) {
            return Double.valueOf(this.f37733b[i10]);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Double) {
                return l(((Number) obj).doubleValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f37733b.length == 0;
        }

        public int l(double d10) {
            double[] dArr = this.f37733b;
            int length = dArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                if (Double.doubleToLongBits(dArr[i10]) == Double.doubleToLongBits(d10)) {
                    return i10;
                }
            }
            return -1;
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Double) {
                return m(((Number) obj).doubleValue());
            }
            return -1;
        }

        public int m(double d10) {
            double[] dArr = this.f37733b;
            int length = dArr.length - 1;
            if (length < 0) {
                return -1;
            }
            while (true) {
                int i10 = length - 1;
                if (Double.doubleToLongBits(dArr[length]) == Double.doubleToLongBits(d10)) {
                    return length;
                }
                if (i10 < 0) {
                    return -1;
                }
                length = i10;
            }
        }
    }

    public static final class g extends kotlin.collections.b<Boolean> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean[] f37734b;

        public g(boolean[] zArr) {
            this.f37734b = zArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return this.f37734b.length;
        }

        public boolean b(boolean z10) {
            return ArraysKt___ArraysKt.V8(this.f37734b, z10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Boolean) {
                return b(((Boolean) obj).booleanValue());
            }
            return false;
        }

        @Override // kotlin.collections.b, java.util.List
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Boolean get(int i10) {
            return Boolean.valueOf(this.f37734b[i10]);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Boolean) {
                return l(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f37734b.length == 0;
        }

        public int l(boolean z10) {
            return ArraysKt___ArraysKt.lg(this.f37734b, z10);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Boolean) {
                return m(((Boolean) obj).booleanValue());
            }
            return -1;
        }

        public int m(boolean z10) {
            return ArraysKt___ArraysKt.pi(this.f37734b, z10);
        }
    }

    public static final class h extends kotlin.collections.b<Character> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ char[] f37735b;

        public h(char[] cArr) {
            this.f37735b = cArr;
        }

        @Override // kotlin.collections.b, kotlin.collections.AbstractCollection
        public int a() {
            return this.f37735b.length;
        }

        public boolean b(char c10) {
            return ArraysKt___ArraysKt.O8(this.f37735b, c10);
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Character) {
                return b(((Character) obj).charValue());
            }
            return false;
        }

        @Override // kotlin.collections.b, java.util.List
        @yt.k
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Character get(int i10) {
            return Character.valueOf(this.f37735b[i10]);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Character) {
                return l(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // kotlin.collections.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f37735b.length == 0;
        }

        public int l(char c10) {
            return ArraysKt___ArraysKt.eg(this.f37735b, c10);
        }

        @Override // kotlin.collections.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return m(((Character) obj).charValue());
            }
            return -1;
        }

        public int m(char c10) {
            return ArraysKt___ArraysKt.ii(this.f37735b, c10);
        }
    }

    public static final int A(@yt.k int[] iArr, int i10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return Arrays.binarySearch(iArr, i11, i12, i10);
    }

    @hk.h(name = "contentHashCodeNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int A0(long[] jArr) {
        return Arrays.hashCode(jArr);
    }

    @bk.f
    public static final <T> T[] A1(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length);
        kotlin.jvm.internal.f0.o(tArr2, "copyOf(this, size)");
        return tArr2;
    }

    @yt.k
    public static final <C extends Collection<? super R>, R> C A2(@yt.k Object[] objArr, @yt.k C destination, @yt.k Class<R> klass) {
        kotlin.jvm.internal.f0.p(objArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        kotlin.jvm.internal.f0.p(klass, "klass");
        for (Object obj : objArr) {
            if (klass.isInstance(obj)) {
                destination.add(obj);
            }
        }
        return destination;
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float A3(float[] fArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.eo(fArr, comparator);
    }

    public static /* synthetic */ void A4(char[] cArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = cArr.length;
        }
        k4(cArr, i10, i11);
    }

    public static final int B(@yt.k long[] jArr, long j10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return Arrays.binarySearch(jArr, i10, i11, j10);
    }

    @hk.h(name = "contentHashCodeNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> int B0(T[] tArr) {
        return Arrays.hashCode(tArr);
    }

    @bk.f
    public static final <T> T[] B1(T[] tArr, int i10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i10);
        kotlin.jvm.internal.f0.o(tArr2, "copyOf(this, newSize)");
        return tArr2;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Byte B2(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return ArraysKt___ArraysKt.il(bArr);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Integer B3(int[] iArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.fo(iArr, comparator);
    }

    public static /* synthetic */ void B4(double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = dArr.length;
        }
        m4(dArr, i10, i11);
    }

    public static final <T> int C(@yt.k T[] tArr, T t10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return Arrays.binarySearch(tArr, i10, i11, t10);
    }

    @hk.h(name = "contentHashCodeNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int C0(short[] sArr) {
        return Arrays.hashCode(sArr);
    }

    @bk.f
    public static final short[] C1(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, sArr.length);
        kotlin.jvm.internal.f0.o(sArrCopyOf, "copyOf(this, size)");
        return sArrCopyOf;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character C2(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return ArraysKt___ArraysKt.jl(cArr);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Long C3(long[] jArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.go(jArr, comparator);
    }

    public static /* synthetic */ void C4(float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = fArr.length;
        }
        o4(fArr, i10, i11);
    }

    public static final <T> int D(@yt.k T[] tArr, T t10, @yt.k Comparator<? super T> comparator, int i10, int i11) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return Arrays.binarySearch(tArr, i10, i11, t10, comparator);
    }

    @hk.h(name = "contentHashCodeNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int D0(boolean[] zArr) {
        return Arrays.hashCode(zArr);
    }

    @bk.f
    public static final short[] D1(short[] sArr, int i10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        short[] sArrCopyOf = Arrays.copyOf(sArr, i10);
        kotlin.jvm.internal.f0.o(sArrCopyOf, "copyOf(this, newSize)");
        return sArrCopyOf;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable D2(Comparable[] comparableArr) {
        kotlin.jvm.internal.f0.p(comparableArr, "<this>");
        return ArraysKt___ArraysKt.kl(comparableArr);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object D3(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(objArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.ho(objArr, comparator);
    }

    public static /* synthetic */ void D4(int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = iArr.length;
        }
        q4(iArr, i10, i11);
    }

    public static final int E(@yt.k short[] sArr, short s10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return Arrays.binarySearch(sArr, i10, i11, s10);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String E0(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        String string = Arrays.toString(bArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @bk.f
    public static final boolean[] E1(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, zArr.length);
        kotlin.jvm.internal.f0.o(zArrCopyOf, "copyOf(this, size)");
        return zArrCopyOf;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double E2(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return ArraysKt___ArraysKt.ll(dArr);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Short E3(short[] sArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.io(sArr, comparator);
    }

    public static /* synthetic */ void E4(long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = jArr.length;
        }
        s4(jArr, i10, i11);
    }

    public static /* synthetic */ int F(byte[] bArr, byte b10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return w(bArr, b10, i10, i11);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String F0(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        String string = Arrays.toString(cArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @bk.f
    public static final boolean[] F1(boolean[] zArr, int i10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        boolean[] zArrCopyOf = Arrays.copyOf(zArr, i10);
        kotlin.jvm.internal.f0.o(zArrCopyOf, "copyOf(this, newSize)");
        return zArrCopyOf;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double F2(Double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return ArraysKt___ArraysKt.ml(dArr);
    }

    @yt.k
    public static final byte[] F3(@yt.k byte[] bArr, byte b10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        int length = bArr.length;
        byte[] result = Arrays.copyOf(bArr, length + 1);
        result[length] = b10;
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    public static /* synthetic */ void F4(Comparable[] comparableArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = comparableArr.length;
        }
        u4(comparableArr, i10, i11);
    }

    public static /* synthetic */ int G(char[] cArr, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        return x(cArr, c10, i10, i11);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String G0(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        String string = Arrays.toString(dArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRange")
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final byte[] G1(@yt.k byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        k.c(i11, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
        kotlin.jvm.internal.f0.o(bArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float G2(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return ArraysKt___ArraysKt.nl(fArr);
    }

    @yt.k
    public static final byte[] G3(@yt.k byte[] bArr, @yt.k Collection<Byte> elements) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = bArr.length;
        byte[] result = Arrays.copyOf(bArr, elements.size() + length);
        Iterator<Byte> it2 = elements.iterator();
        while (it2.hasNext()) {
            result[length] = it2.next().byteValue();
            length++;
        }
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    public static /* synthetic */ void G4(Object[] objArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = objArr.length;
        }
        w4(objArr, i10, i11);
    }

    public static /* synthetic */ int H(double[] dArr, double d10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length;
        }
        return y(dArr, d10, i10, i11);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String H0(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        String string = Arrays.toString(fArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRange")
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final char[] H1(@yt.k char[] cArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        k.c(i11, cArr.length);
        char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i10, i11);
        kotlin.jvm.internal.f0.o(cArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return cArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float H2(Float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return ArraysKt___ArraysKt.ol(fArr);
    }

    @yt.k
    public static final byte[] H3(@yt.k byte[] bArr, @yt.k byte[] elements) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = bArr.length;
        int length2 = elements.length;
        byte[] result = Arrays.copyOf(bArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    public static /* synthetic */ void H4(short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = sArr.length;
        }
        y4(sArr, i10, i11);
    }

    public static /* synthetic */ int I(float[] fArr, float f10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length;
        }
        return z(fArr, f10, i10, i11);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String I0(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        String string = Arrays.toString(iArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRange")
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final double[] I1(@yt.k double[] dArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        k.c(i11, dArr.length);
        double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i10, i11);
        kotlin.jvm.internal.f0.o(dArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return dArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Integer I2(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return ArraysKt___ArraysKt.pl(iArr);
    }

    @yt.k
    public static final char[] I3(@yt.k char[] cArr, char c10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        int length = cArr.length;
        char[] result = Arrays.copyOf(cArr, length + 1);
        result[length] = c10;
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    public static final <T> void I4(@yt.k T[] tArr, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        if (tArr.length > 1) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static /* synthetic */ int J(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = iArr.length;
        }
        return A(iArr, i10, i11, i12);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String J0(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        String string = Arrays.toString(jArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRange")
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final float[] J1(@yt.k float[] fArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        k.c(i11, fArr.length);
        float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i10, i11);
        kotlin.jvm.internal.f0.o(fArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return fArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Long J2(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return ArraysKt___ArraysKt.ql(jArr);
    }

    @yt.k
    public static final char[] J3(@yt.k char[] cArr, @yt.k Collection<Character> elements) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = cArr.length;
        char[] result = Arrays.copyOf(cArr, elements.size() + length);
        Iterator<Character> it2 = elements.iterator();
        while (it2.hasNext()) {
            result[length] = it2.next().charValue();
            length++;
        }
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    public static final <T> void J4(@yt.k T[] tArr, @yt.k Comparator<? super T> comparator, int i10, int i11) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        Arrays.sort(tArr, i10, i11, comparator);
    }

    public static /* synthetic */ int K(long[] jArr, long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length;
        }
        return B(jArr, j10, i10, i11);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ <T> String K0(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        String string = Arrays.toString(tArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRange")
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final int[] K1(@yt.k int[] iArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        k.c(i11, iArr.length);
        int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i10, i11);
        kotlin.jvm.internal.f0.o(iArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return iArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Short K2(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return ArraysKt___ArraysKt.rl(sArr);
    }

    @yt.k
    public static final char[] K3(@yt.k char[] cArr, @yt.k char[] elements) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = cArr.length;
        int length2 = elements.length;
        char[] result = Arrays.copyOf(cArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    public static /* synthetic */ void K4(Object[] objArr, Comparator comparator, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        J4(objArr, comparator, i10, i11);
    }

    public static /* synthetic */ int L(Object[] objArr, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        return C(objArr, obj, i10, i11);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String L0(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        String string = Arrays.toString(sArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRange")
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final long[] L1(@yt.k long[] jArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        k.c(i11, jArr.length);
        long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i10, i11);
        kotlin.jvm.internal.f0.o(jArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return jArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean L2(boolean[] zArr, ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        int iZe = ArraysKt___ArraysKt.Ze(zArr);
        if (iZe == 0) {
            return Boolean.valueOf(z10);
        }
        R rI = selector.i(Boolean.valueOf(z10));
        k0 k0VarM = new qk.m(1, iZe).iterator();
        while (k0VarM.hasNext()) {
            boolean z11 = zArr[k0VarM.b()];
            R rI2 = selector.i(Boolean.valueOf(z11));
            if (rI.compareTo(rI2) < 0) {
                z10 = z11;
                rI = rI2;
            }
        }
        return Boolean.valueOf(z10);
    }

    @yt.k
    public static final double[] L3(@yt.k double[] dArr, double d10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        int length = dArr.length;
        double[] result = Arrays.copyOf(dArr, length + 1);
        result[length] = d10;
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigDecimal")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigDecimal L4(byte[] bArr, ik.l<? super Byte, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (byte b10 : bArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(Byte.valueOf(b10)));
            kotlin.jvm.internal.f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    public static /* synthetic */ int M(Object[] objArr, Object obj, Comparator comparator, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = objArr.length;
        }
        return D(objArr, obj, comparator, i10, i11);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ String M0(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        String string = Arrays.toString(zArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRange")
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final <T> T[] M1(@yt.k T[] tArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        k.c(i11, tArr.length);
        T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i10, i11);
        kotlin.jvm.internal.f0.o(tArr2, "copyOfRange(this, fromIndex, toIndex)");
        return tArr2;
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte M2(byte[] bArr, ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        int iRe = ArraysKt___ArraysKt.Re(bArr);
        if (iRe == 0) {
            return Byte.valueOf(b10);
        }
        R rI = selector.i(Byte.valueOf(b10));
        k0 k0VarM = new qk.m(1, iRe).iterator();
        while (k0VarM.hasNext()) {
            byte b11 = bArr[k0VarM.b()];
            R rI2 = selector.i(Byte.valueOf(b11));
            if (rI.compareTo(rI2) < 0) {
                b10 = b11;
                rI = rI2;
            }
        }
        return Byte.valueOf(b10);
    }

    @yt.k
    public static final double[] M3(@yt.k double[] dArr, @yt.k Collection<Double> elements) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = dArr.length;
        double[] result = Arrays.copyOf(dArr, elements.size() + length);
        Iterator<Double> it2 = elements.iterator();
        while (it2.hasNext()) {
            result[length] = it2.next().doubleValue();
            length++;
        }
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigDecimal")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigDecimal M4(char[] cArr, ik.l<? super Character, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (char c10 : cArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(Character.valueOf(c10)));
            kotlin.jvm.internal.f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    public static /* synthetic */ int N(short[] sArr, short s10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length;
        }
        return E(sArr, s10, i10, i11);
    }

    @hk.h(name = "contentToStringNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final String N0(byte[] bArr) {
        String string = Arrays.toString(bArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRange")
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final short[] N1(@yt.k short[] sArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        k.c(i11, sArr.length);
        short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i10, i11);
        kotlin.jvm.internal.f0.o(sArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return sArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character N2(char[] cArr, ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        int iSe = ArraysKt___ArraysKt.Se(cArr);
        if (iSe == 0) {
            return Character.valueOf(c10);
        }
        R rI = selector.i(Character.valueOf(c10));
        k0 k0VarM = new qk.m(1, iSe).iterator();
        while (k0VarM.hasNext()) {
            char c11 = cArr[k0VarM.b()];
            R rI2 = selector.i(Character.valueOf(c11));
            if (rI.compareTo(rI2) < 0) {
                c10 = c11;
                rI = rI2;
            }
        }
        return Character.valueOf(c10);
    }

    @yt.k
    public static final double[] N3(@yt.k double[] dArr, @yt.k double[] elements) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = dArr.length;
        int length2 = elements.length;
        double[] result = Arrays.copyOf(dArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigDecimal")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigDecimal N4(double[] dArr, ik.l<? super Double, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (double d10 : dArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(Double.valueOf(d10)));
            kotlin.jvm.internal.f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @hk.h(name = "contentDeepEqualsInline")
    @bk.f
    @kotlin.v0(version = "1.1")
    @bk.h
    public static final <T> boolean O(T[] tArr, T[] other) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        return l.g(tArr, other);
    }

    @hk.h(name = "contentToStringNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final String O0(char[] cArr) {
        String string = Arrays.toString(cArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRange")
    @kotlin.v0(version = "1.3")
    @kotlin.s0
    @yt.k
    public static final boolean[] O1(@yt.k boolean[] zArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        k.c(i11, zArr.length);
        boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i10, i11);
        kotlin.jvm.internal.f0.o(zArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return zArrCopyOfRange;
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Double O2(double[] dArr, ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        int iTe = ArraysKt___ArraysKt.Te(dArr);
        if (iTe == 0) {
            return Double.valueOf(d10);
        }
        R rI = selector.i(Double.valueOf(d10));
        k0 k0VarM = new qk.m(1, iTe).iterator();
        while (k0VarM.hasNext()) {
            double d11 = dArr[k0VarM.b()];
            R rI2 = selector.i(Double.valueOf(d11));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
                d10 = d11;
            }
        }
        return Double.valueOf(d10);
    }

    @yt.k
    public static final float[] O3(@yt.k float[] fArr, float f10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        int length = fArr.length;
        float[] result = Arrays.copyOf(fArr, length + 1);
        result[length] = f10;
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigDecimal")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigDecimal O4(float[] fArr, ik.l<? super Float, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (float f10 : fArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(Float.valueOf(f10)));
            kotlin.jvm.internal.f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @hk.h(name = "contentDeepEqualsNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> boolean P(T[] tArr, T[] tArr2) {
        return bk.m.a(1, 3, 0) ? l.g(tArr, tArr2) : Arrays.deepEquals(tArr, tArr2);
    }

    @hk.h(name = "contentToStringNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final String P0(double[] dArr) {
        String string = Arrays.toString(dArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRangeInline")
    @bk.f
    public static final byte[] P1(byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bk.m.a(1, 3, 0)) {
            return G1(bArr, i10, i11);
        }
        if (i11 <= bArr.length) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i10, i11);
            kotlin.jvm.internal.f0.o(bArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return bArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i11 + ", size: " + bArr.length);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Float P2(float[] fArr, ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        int iUe = ArraysKt___ArraysKt.Ue(fArr);
        if (iUe == 0) {
            return Float.valueOf(f10);
        }
        R rI = selector.i(Float.valueOf(f10));
        k0 k0VarM = new qk.m(1, iUe).iterator();
        while (k0VarM.hasNext()) {
            float f11 = fArr[k0VarM.b()];
            R rI2 = selector.i(Float.valueOf(f11));
            if (rI.compareTo(rI2) < 0) {
                f10 = f11;
                rI = rI2;
            }
        }
        return Float.valueOf(f10);
    }

    @yt.k
    public static final float[] P3(@yt.k float[] fArr, @yt.k Collection<Float> elements) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = fArr.length;
        float[] result = Arrays.copyOf(fArr, elements.size() + length);
        Iterator<Float> it2 = elements.iterator();
        while (it2.hasNext()) {
            result[length] = it2.next().floatValue();
            length++;
        }
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigDecimal")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigDecimal P4(int[] iArr, ik.l<? super Integer, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (int i10 : iArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(Integer.valueOf(i10)));
            kotlin.jvm.internal.f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @hk.h(name = "contentDeepHashCodeInline")
    @bk.f
    @kotlin.v0(version = "1.1")
    @bk.h
    public static final <T> int Q(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return k.b(tArr);
    }

    @hk.h(name = "contentToStringNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final String Q0(float[] fArr) {
        String string = Arrays.toString(fArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRangeInline")
    @bk.f
    public static final char[] Q1(char[] cArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (bk.m.a(1, 3, 0)) {
            return H1(cArr, i10, i11);
        }
        if (i11 <= cArr.length) {
            char[] cArrCopyOfRange = Arrays.copyOfRange(cArr, i10, i11);
            kotlin.jvm.internal.f0.o(cArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return cArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i11 + ", size: " + cArr.length);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer Q2(int[] iArr, ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        int iVe = ArraysKt___ArraysKt.Ve(iArr);
        if (iVe == 0) {
            return Integer.valueOf(i10);
        }
        R rI = selector.i(Integer.valueOf(i10));
        k0 k0VarM = new qk.m(1, iVe).iterator();
        while (k0VarM.hasNext()) {
            int i11 = iArr[k0VarM.b()];
            R rI2 = selector.i(Integer.valueOf(i11));
            if (rI.compareTo(rI2) < 0) {
                i10 = i11;
                rI = rI2;
            }
        }
        return Integer.valueOf(i10);
    }

    @yt.k
    public static final float[] Q3(@yt.k float[] fArr, @yt.k float[] elements) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = fArr.length;
        int length2 = elements.length;
        float[] result = Arrays.copyOf(fArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigDecimal")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigDecimal Q4(long[] jArr, ik.l<? super Long, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (long j10 : jArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(Long.valueOf(j10)));
            kotlin.jvm.internal.f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @hk.h(name = "contentDeepHashCodeNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> int R(T[] tArr) {
        return bk.m.a(1, 3, 0) ? k.b(tArr) : Arrays.deepHashCode(tArr);
    }

    @hk.h(name = "contentToStringNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final String R0(int[] iArr) {
        String string = Arrays.toString(iArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRangeInline")
    @bk.f
    public static final double[] R1(double[] dArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (bk.m.a(1, 3, 0)) {
            return I1(dArr, i10, i11);
        }
        if (i11 <= dArr.length) {
            double[] dArrCopyOfRange = Arrays.copyOfRange(dArr, i10, i11);
            kotlin.jvm.internal.f0.o(dArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return dArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i11 + ", size: " + dArr.length);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Long R2(long[] jArr, ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        int iWe = ArraysKt___ArraysKt.We(jArr);
        if (iWe == 0) {
            return Long.valueOf(j10);
        }
        R rI = selector.i(Long.valueOf(j10));
        k0 k0VarM = new qk.m(1, iWe).iterator();
        while (k0VarM.hasNext()) {
            long j11 = jArr[k0VarM.b()];
            R rI2 = selector.i(Long.valueOf(j11));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @yt.k
    public static final int[] R3(@yt.k int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        int length = iArr.length;
        int[] result = Arrays.copyOf(iArr, length + 1);
        result[length] = i10;
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigDecimal")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> BigDecimal R4(T[] tArr, ik.l<? super T, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (T t10 : tArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(t10));
            kotlin.jvm.internal.f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @hk.h(name = "contentDeepToStringInline")
    @bk.f
    @kotlin.v0(version = "1.1")
    @bk.h
    public static final <T> String S(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return l.h(tArr);
    }

    @hk.h(name = "contentToStringNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final String S0(long[] jArr) {
        String string = Arrays.toString(jArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRangeInline")
    @bk.f
    public static final float[] S1(float[] fArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (bk.m.a(1, 3, 0)) {
            return J1(fArr, i10, i11);
        }
        if (i11 <= fArr.length) {
            float[] fArrCopyOfRange = Arrays.copyOfRange(fArr, i10, i11);
            kotlin.jvm.internal.f0.o(fArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return fArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i11 + ", size: " + fArr.length);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T S2(T[] tArr, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        int iXe = ArraysKt___ArraysKt.Xe(tArr);
        if (iXe != 0) {
            R rI = selector.i(t10);
            k0 k0VarM = new qk.m(1, iXe).iterator();
            while (k0VarM.hasNext()) {
                T t11 = tArr[k0VarM.b()];
                R rI2 = selector.i(t11);
                if (rI.compareTo(rI2) < 0) {
                    t10 = t11;
                    rI = rI2;
                }
            }
        }
        return t10;
    }

    @yt.k
    public static final int[] S3(@yt.k int[] iArr, @yt.k Collection<Integer> elements) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = iArr.length;
        int[] result = Arrays.copyOf(iArr, elements.size() + length);
        Iterator<Integer> it2 = elements.iterator();
        while (it2.hasNext()) {
            result[length] = it2.next().intValue();
            length++;
        }
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigDecimal")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigDecimal S4(short[] sArr, ik.l<? super Short, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (short s10 : sArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(Short.valueOf(s10)));
            kotlin.jvm.internal.f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @hk.h(name = "contentDeepToStringNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> String T(T[] tArr) {
        if (bk.m.a(1, 3, 0)) {
            return l.h(tArr);
        }
        String strDeepToString = Arrays.deepToString(tArr);
        kotlin.jvm.internal.f0.o(strDeepToString, "deepToString(this)");
        return strDeepToString;
    }

    @hk.h(name = "contentToStringNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> String T0(T[] tArr) {
        String string = Arrays.toString(tArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRangeInline")
    @bk.f
    public static final int[] T1(int[] iArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (bk.m.a(1, 3, 0)) {
            return K1(iArr, i10, i11);
        }
        if (i11 <= iArr.length) {
            int[] iArrCopyOfRange = Arrays.copyOfRange(iArr, i10, i11);
            kotlin.jvm.internal.f0.o(iArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return iArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i11 + ", size: " + iArr.length);
    }

    @kotlin.k(message = "Use maxByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Short T2(short[] sArr, ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        int iYe = ArraysKt___ArraysKt.Ye(sArr);
        if (iYe == 0) {
            return Short.valueOf(s10);
        }
        R rI = selector.i(Short.valueOf(s10));
        k0 k0VarM = new qk.m(1, iYe).iterator();
        while (k0VarM.hasNext()) {
            short s11 = sArr[k0VarM.b()];
            R rI2 = selector.i(Short.valueOf(s11));
            if (rI.compareTo(rI2) < 0) {
                s10 = s11;
                rI = rI2;
            }
        }
        return Short.valueOf(s10);
    }

    @yt.k
    public static final int[] T3(@yt.k int[] iArr, @yt.k int[] elements) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = iArr.length;
        int length2 = elements.length;
        int[] result = Arrays.copyOf(iArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigDecimal")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigDecimal T4(boolean[] zArr, ik.l<? super Boolean, ? extends BigDecimal> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigDecimalValueOf, "valueOf(this.toLong())");
        for (boolean z10 : zArr) {
            bigDecimalValueOf = bigDecimalValueOf.add(selector.i(Boolean.valueOf(z10)));
            kotlin.jvm.internal.f0.o(bigDecimalValueOf, "this.add(other)");
        }
        return bigDecimalValueOf;
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean U(byte[] bArr, byte[] other) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        return Arrays.equals(bArr, other);
    }

    @hk.h(name = "contentToStringNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final String U0(short[] sArr) {
        String string = Arrays.toString(sArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRangeInline")
    @bk.f
    public static final long[] U1(long[] jArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (bk.m.a(1, 3, 0)) {
            return L1(jArr, i10, i11);
        }
        if (i11 <= jArr.length) {
            long[] jArrCopyOfRange = Arrays.copyOfRange(jArr, i10, i11);
            kotlin.jvm.internal.f0.o(jArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return jArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i11 + ", size: " + jArr.length);
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Boolean U2(boolean[] zArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Cl(zArr, comparator);
    }

    @yt.k
    public static final long[] U3(@yt.k long[] jArr, long j10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        int length = jArr.length;
        long[] result = Arrays.copyOf(jArr, length + 1);
        result[length] = j10;
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigInteger")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigInteger U4(byte[] bArr, ik.l<? super Byte, ? extends BigInteger> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (byte b10 : bArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(Byte.valueOf(b10)));
            kotlin.jvm.internal.f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean V(char[] cArr, char[] other) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        return Arrays.equals(cArr, other);
    }

    @hk.h(name = "contentToStringNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final String V0(boolean[] zArr) {
        String string = Arrays.toString(zArr);
        kotlin.jvm.internal.f0.o(string, "toString(this)");
        return string;
    }

    @hk.h(name = "copyOfRangeInline")
    @bk.f
    public static final <T> T[] V1(T[] tArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (bk.m.a(1, 3, 0)) {
            return (T[]) M1(tArr, i10, i11);
        }
        if (i11 <= tArr.length) {
            T[] tArr2 = (T[]) Arrays.copyOfRange(tArr, i10, i11);
            kotlin.jvm.internal.f0.o(tArr2, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return tArr2;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i11 + ", size: " + tArr.length);
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Byte V2(byte[] bArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Dl(bArr, comparator);
    }

    @yt.k
    public static final long[] V3(@yt.k long[] jArr, @yt.k Collection<Long> elements) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = jArr.length;
        long[] result = Arrays.copyOf(jArr, elements.size() + length);
        Iterator<Long> it2 = elements.iterator();
        while (it2.hasNext()) {
            result[length] = it2.next().longValue();
            length++;
        }
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigInteger")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigInteger V4(char[] cArr, ik.l<? super Character, ? extends BigInteger> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (char c10 : cArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(Character.valueOf(c10)));
            kotlin.jvm.internal.f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean W(double[] dArr, double[] other) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        return Arrays.equals(dArr, other);
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final byte[] W0(@yt.k byte[] bArr, @yt.k byte[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        System.arraycopy(bArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    @hk.h(name = "copyOfRangeInline")
    @bk.f
    public static final short[] W1(short[] sArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (bk.m.a(1, 3, 0)) {
            return N1(sArr, i10, i11);
        }
        if (i11 <= sArr.length) {
            short[] sArrCopyOfRange = Arrays.copyOfRange(sArr, i10, i11);
            kotlin.jvm.internal.f0.o(sArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return sArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i11 + ", size: " + sArr.length);
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character W2(char[] cArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.El(cArr, comparator);
    }

    @yt.k
    public static final long[] W3(@yt.k long[] jArr, @yt.k long[] elements) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = jArr.length;
        int length2 = elements.length;
        long[] result = Arrays.copyOf(jArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigInteger")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigInteger W4(double[] dArr, ik.l<? super Double, ? extends BigInteger> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (double d10 : dArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(Double.valueOf(d10)));
            kotlin.jvm.internal.f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean X(float[] fArr, float[] other) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        return Arrays.equals(fArr, other);
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final char[] X0(@yt.k char[] cArr, @yt.k char[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        System.arraycopy(cArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    @hk.h(name = "copyOfRangeInline")
    @bk.f
    public static final boolean[] X1(boolean[] zArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        if (bk.m.a(1, 3, 0)) {
            return O1(zArr, i10, i11);
        }
        if (i11 <= zArr.length) {
            boolean[] zArrCopyOfRange = Arrays.copyOfRange(zArr, i10, i11);
            kotlin.jvm.internal.f0.o(zArrCopyOfRange, "{\n        if (toIndex > …fromIndex, toIndex)\n    }");
            return zArrCopyOfRange;
        }
        throw new IndexOutOfBoundsException("toIndex: " + i11 + ", size: " + zArr.length);
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double X2(double[] dArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Fl(dArr, comparator);
    }

    @yt.k
    public static final <T> T[] X3(@yt.k T[] tArr, T t10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        int length = tArr.length;
        T[] result = (T[]) Arrays.copyOf(tArr, length + 1);
        result[length] = t10;
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigInteger")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigInteger X4(float[] fArr, ik.l<? super Float, ? extends BigInteger> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (float f10 : fArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(Float.valueOf(f10)));
            kotlin.jvm.internal.f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean Y(int[] iArr, int[] other) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        return Arrays.equals(iArr, other);
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final double[] Y0(@yt.k double[] dArr, @yt.k double[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        System.arraycopy(dArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    @bk.f
    public static final byte Y1(byte[] bArr, int i10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return bArr[i10];
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float Y2(float[] fArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Gl(fArr, comparator);
    }

    @yt.k
    public static final <T> T[] Y3(@yt.k T[] tArr, @yt.k Collection<? extends T> elements) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = tArr.length;
        T[] result = (T[]) Arrays.copyOf(tArr, elements.size() + length);
        Iterator<? extends T> it2 = elements.iterator();
        while (it2.hasNext()) {
            result[length] = it2.next();
            length++;
        }
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigInteger")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigInteger Y4(int[] iArr, ik.l<? super Integer, ? extends BigInteger> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (int i10 : iArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(Integer.valueOf(i10)));
            kotlin.jvm.internal.f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean Z(long[] jArr, long[] other) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        return Arrays.equals(jArr, other);
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final float[] Z0(@yt.k float[] fArr, @yt.k float[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        System.arraycopy(fArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    @bk.f
    public static final char Z1(char[] cArr, int i10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return cArr[i10];
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Integer Z2(int[] iArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Hl(iArr, comparator);
    }

    @yt.k
    public static final <T> T[] Z3(@yt.k T[] tArr, @yt.k T[] elements) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = tArr.length;
        int length2 = elements.length;
        T[] result = (T[]) Arrays.copyOf(tArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigInteger")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigInteger Z4(long[] jArr, ik.l<? super Long, ? extends BigInteger> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (long j10 : jArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(Long.valueOf(j10)));
            kotlin.jvm.internal.f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ <T> boolean a0(T[] tArr, T[] other) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        return Arrays.equals(tArr, other);
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final int[] a1(@yt.k int[] iArr, @yt.k int[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        System.arraycopy(iArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    @bk.f
    public static final double a2(double[] dArr, int i10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return dArr[i10];
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Long a3(long[] jArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Il(jArr, comparator);
    }

    @yt.k
    public static final short[] a4(@yt.k short[] sArr, @yt.k Collection<Short> elements) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = sArr.length;
        short[] result = Arrays.copyOf(sArr, elements.size() + length);
        Iterator<Short> it2 = elements.iterator();
        while (it2.hasNext()) {
            result[length] = it2.next().shortValue();
            length++;
        }
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigInteger")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> BigInteger a5(T[] tArr, ik.l<? super T, ? extends BigInteger> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (T t10 : tArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(t10));
            kotlin.jvm.internal.f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean b0(short[] sArr, short[] other) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        return Arrays.equals(sArr, other);
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final long[] b1(@yt.k long[] jArr, @yt.k long[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        System.arraycopy(jArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    @bk.f
    public static final float b2(float[] fArr, int i10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return fArr[i10];
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Object b3(Object[] objArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(objArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Jl(objArr, comparator);
    }

    @yt.k
    public static final short[] b4(@yt.k short[] sArr, short s10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        int length = sArr.length;
        short[] result = Arrays.copyOf(sArr, length + 1);
        result[length] = s10;
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigInteger")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigInteger b5(short[] sArr, ik.l<? super Short, ? extends BigInteger> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (short s10 : sArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(Short.valueOf(s10)));
            kotlin.jvm.internal.f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ boolean c0(boolean[] zArr, boolean[] other) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        return Arrays.equals(zArr, other);
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final <T> T[] c1(@yt.k T[] tArr, @yt.k T[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        System.arraycopy(tArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    @bk.f
    public static final int c2(int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return iArr[i10];
    }

    @kotlin.k(message = "Use maxWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Short c3(short[] sArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.Kl(sArr, comparator);
    }

    @yt.k
    public static final short[] c4(@yt.k short[] sArr, @yt.k short[] elements) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = sArr.length;
        int length2 = elements.length;
        short[] result = Arrays.copyOf(sArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @hk.h(name = "sumOfBigInteger")
    @kotlin.m0
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final BigInteger c5(boolean[] zArr, ik.l<? super Boolean, ? extends BigInteger> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        kotlin.jvm.internal.f0.o(bigIntegerValueOf, "valueOf(this.toLong())");
        for (boolean z10 : zArr) {
            bigIntegerValueOf = bigIntegerValueOf.add(selector.i(Boolean.valueOf(z10)));
            kotlin.jvm.internal.f0.o(bigIntegerValueOf, "this.add(other)");
        }
        return bigIntegerValueOf;
    }

    @hk.h(name = "contentEqualsNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final boolean d0(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final short[] d1(@yt.k short[] sArr, @yt.k short[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        System.arraycopy(sArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    @bk.f
    public static final long d2(long[] jArr, int i10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return jArr[i10];
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Byte d3(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return ArraysKt___ArraysKt.Gn(bArr);
    }

    @yt.k
    public static final boolean[] d4(@yt.k boolean[] zArr, @yt.k Collection<Boolean> elements) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = zArr.length;
        boolean[] result = Arrays.copyOf(zArr, elements.size() + length);
        Iterator<Boolean> it2 = elements.iterator();
        while (it2.hasNext()) {
            result[length] = it2.next().booleanValue();
            length++;
        }
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @yt.k
    public static final SortedSet<Byte> d5(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.Hy(bArr, new TreeSet());
    }

    @hk.h(name = "contentEqualsNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final boolean e0(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    @kotlin.v0(version = "1.3")
    @yt.k
    public static final boolean[] e1(@yt.k boolean[] zArr, @yt.k boolean[] destination, int i10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(destination, "destination");
        System.arraycopy(zArr, i11, destination, i10, i12 - i11);
        return destination;
    }

    @bk.f
    public static final <T> T e2(T[] tArr, int i10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return tArr[i10];
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character e3(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return ArraysKt___ArraysKt.Hn(cArr);
    }

    @yt.k
    public static final boolean[] e4(@yt.k boolean[] zArr, boolean z10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        int length = zArr.length;
        boolean[] result = Arrays.copyOf(zArr, length + 1);
        result[length] = z10;
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @yt.k
    public static final SortedSet<Character> e5(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.Iy(cArr, new TreeSet());
    }

    @hk.h(name = "contentEqualsNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final boolean f0(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    public static /* synthetic */ byte[] f1(byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = bArr.length;
        }
        return W0(bArr, bArr2, i10, i11, i12);
    }

    @bk.f
    public static final short f2(short[] sArr, int i10) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return sArr[i10];
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Comparable f3(Comparable[] comparableArr) {
        kotlin.jvm.internal.f0.p(comparableArr, "<this>");
        return ArraysKt___ArraysKt.In(comparableArr);
    }

    @yt.k
    public static final boolean[] f4(@yt.k boolean[] zArr, @yt.k boolean[] elements) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(elements, "elements");
        int length = zArr.length;
        int length2 = elements.length;
        boolean[] result = Arrays.copyOf(zArr, length + length2);
        System.arraycopy(elements, 0, result, length, length2);
        kotlin.jvm.internal.f0.o(result, "result");
        return result;
    }

    @yt.k
    public static final SortedSet<Double> f5(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.Jy(dArr, new TreeSet());
    }

    @hk.h(name = "contentEqualsNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final boolean g0(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    public static /* synthetic */ char[] g1(char[] cArr, char[] cArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = cArr.length;
        }
        return X0(cArr, cArr2, i10, i11, i12);
    }

    @bk.f
    public static final boolean g2(boolean[] zArr, int i10) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return zArr[i10];
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double g3(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return ArraysKt___ArraysKt.Jn(dArr);
    }

    @bk.f
    public static final <T> T[] g4(T[] tArr, T t10) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return (T[]) X3(tArr, t10);
    }

    @yt.k
    public static final SortedSet<Float> g5(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.Ky(fArr, new TreeSet());
    }

    @hk.h(name = "contentEqualsNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final boolean h0(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    public static /* synthetic */ double[] h1(double[] dArr, double[] dArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = dArr.length;
        }
        return Y0(dArr, dArr2, i10, i11, i12);
    }

    public static final void h2(@yt.k byte[] bArr, byte b10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        Arrays.fill(bArr, i10, i11, b10);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double h3(Double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return ArraysKt___ArraysKt.Kn(dArr);
    }

    public static final void h4(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        if (bArr.length > 1) {
            Arrays.sort(bArr);
        }
    }

    @yt.k
    public static final SortedSet<Integer> h5(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.Ly(iArr, new TreeSet());
    }

    @hk.h(name = "contentEqualsNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final boolean i0(long[] jArr, long[] jArr2) {
        return Arrays.equals(jArr, jArr2);
    }

    public static /* synthetic */ float[] i1(float[] fArr, float[] fArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = fArr.length;
        }
        return Z0(fArr, fArr2, i10, i11, i12);
    }

    public static final void i2(@yt.k char[] cArr, char c10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        Arrays.fill(cArr, i10, i11, c10);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float i3(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return ArraysKt___ArraysKt.Ln(fArr);
    }

    public static final void i4(@yt.k byte[] bArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        Arrays.sort(bArr, i10, i11);
    }

    @yt.k
    public static final SortedSet<Long> i5(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.My(jArr, new TreeSet());
    }

    @hk.h(name = "contentEqualsNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final <T> boolean j0(T[] tArr, T[] tArr2) {
        return Arrays.equals(tArr, tArr2);
    }

    public static /* synthetic */ int[] j1(int[] iArr, int[] iArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = iArr.length;
        }
        return a1(iArr, iArr2, i10, i11, i12);
    }

    public static final void j2(@yt.k double[] dArr, double d10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        Arrays.fill(dArr, i10, i11, d10);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.v0(version = "1.1")
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Float j3(Float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return ArraysKt___ArraysKt.Mn(fArr);
    }

    public static final void j4(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        if (cArr.length > 1) {
            Arrays.sort(cArr);
        }
    }

    @yt.k
    public static final <T extends Comparable<? super T>> SortedSet<T> j5(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.Ny(tArr, new TreeSet());
    }

    @hk.h(name = "contentEqualsNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final boolean k0(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    public static /* synthetic */ long[] k1(long[] jArr, long[] jArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = jArr.length;
        }
        return b1(jArr, jArr2, i10, i11, i12);
    }

    public static final void k2(@yt.k float[] fArr, float f10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        Arrays.fill(fArr, i10, i11, f10);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Integer k3(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return ArraysKt___ArraysKt.Nn(iArr);
    }

    public static final void k4(@yt.k char[] cArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        Arrays.sort(cArr, i10, i11);
    }

    @yt.k
    public static final <T> SortedSet<T> k5(@yt.k T[] tArr, @yt.k Comparator<? super T> comparator) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return (SortedSet) ArraysKt___ArraysKt.Ny(tArr, new TreeSet(comparator));
    }

    @hk.h(name = "contentEqualsNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final boolean l0(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    public static /* synthetic */ Object[] l1(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return c1(objArr, objArr2, i10, i11, i12);
    }

    public static final void l2(@yt.k int[] iArr, int i10, int i11, int i12) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        Arrays.fill(iArr, i11, i12, i10);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Long l3(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return ArraysKt___ArraysKt.On(jArr);
    }

    public static final void l4(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        if (dArr.length > 1) {
            Arrays.sort(dArr);
        }
    }

    @yt.k
    public static final SortedSet<Short> l5(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.Oy(sArr, new TreeSet());
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int m0(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return Arrays.hashCode(bArr);
    }

    public static /* synthetic */ short[] m1(short[] sArr, short[] sArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = sArr.length;
        }
        return d1(sArr, sArr2, i10, i11, i12);
    }

    public static final void m2(@yt.k long[] jArr, long j10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        Arrays.fill(jArr, i10, i11, j10);
    }

    @kotlin.k(message = "Use minOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minOrNull()", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Short m3(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return ArraysKt___ArraysKt.Pn(sArr);
    }

    public static final void m4(@yt.k double[] dArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        Arrays.sort(dArr, i10, i11);
    }

    @yt.k
    public static final SortedSet<Boolean> m5(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return (SortedSet) ArraysKt___ArraysKt.Py(zArr, new TreeSet());
    }

    @yt.k
    public static final List<Byte> n(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return new a(bArr);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int n0(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return Arrays.hashCode(cArr);
    }

    public static /* synthetic */ boolean[] n1(boolean[] zArr, boolean[] zArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = zArr.length;
        }
        return e1(zArr, zArr2, i10, i11, i12);
    }

    public static final <T> void n2(@yt.k T[] tArr, T t10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        Arrays.fill(tArr, i10, i11, t10);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Boolean n3(boolean[] zArr, ik.l<? super Boolean, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (zArr.length == 0) {
            return null;
        }
        boolean z10 = zArr[0];
        int iZe = ArraysKt___ArraysKt.Ze(zArr);
        if (iZe == 0) {
            return Boolean.valueOf(z10);
        }
        R rI = selector.i(Boolean.valueOf(z10));
        k0 k0VarM = new qk.m(1, iZe).iterator();
        while (k0VarM.hasNext()) {
            boolean z11 = zArr[k0VarM.b()];
            R rI2 = selector.i(Boolean.valueOf(z11));
            if (rI.compareTo(rI2) > 0) {
                z10 = z11;
                rI = rI2;
            }
        }
        return Boolean.valueOf(z10);
    }

    public static final void n4(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        if (fArr.length > 1) {
            Arrays.sort(fArr);
        }
    }

    @yt.k
    public static final Boolean[] n5(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        Boolean[] boolArr = new Boolean[zArr.length];
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            boolArr[i10] = Boolean.valueOf(zArr[i10]);
        }
        return boolArr;
    }

    @yt.k
    public static final List<Character> o(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return new h(cArr);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int o0(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return Arrays.hashCode(dArr);
    }

    @bk.f
    public static final byte[] o1(byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.f0.o(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public static final void o2(@yt.k short[] sArr, short s10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        Arrays.fill(sArr, i10, i11, s10);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Byte o3(byte[] bArr, ik.l<? super Byte, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (bArr.length == 0) {
            return null;
        }
        byte b10 = bArr[0];
        int iRe = ArraysKt___ArraysKt.Re(bArr);
        if (iRe == 0) {
            return Byte.valueOf(b10);
        }
        R rI = selector.i(Byte.valueOf(b10));
        k0 k0VarM = new qk.m(1, iRe).iterator();
        while (k0VarM.hasNext()) {
            byte b11 = bArr[k0VarM.b()];
            R rI2 = selector.i(Byte.valueOf(b11));
            if (rI.compareTo(rI2) > 0) {
                b10 = b11;
                rI = rI2;
            }
        }
        return Byte.valueOf(b10);
    }

    public static final void o4(@yt.k float[] fArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        Arrays.sort(fArr, i10, i11);
    }

    @yt.k
    public static final Byte[] o5(@yt.k byte[] bArr) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        Byte[] bArr2 = new Byte[bArr.length];
        int length = bArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            bArr2[i10] = Byte.valueOf(bArr[i10]);
        }
        return bArr2;
    }

    @yt.k
    public static final List<Double> p(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return new f(dArr);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int p0(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return Arrays.hashCode(fArr);
    }

    @bk.f
    public static final byte[] p1(byte[] bArr, int i10) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i10);
        kotlin.jvm.internal.f0.o(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }

    public static final void p2(@yt.k boolean[] zArr, boolean z10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        Arrays.fill(zArr, i10, i11, z10);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Character p3(char[] cArr, ik.l<? super Character, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (cArr.length == 0) {
            return null;
        }
        char c10 = cArr[0];
        int iSe = ArraysKt___ArraysKt.Se(cArr);
        if (iSe == 0) {
            return Character.valueOf(c10);
        }
        R rI = selector.i(Character.valueOf(c10));
        k0 k0VarM = new qk.m(1, iSe).iterator();
        while (k0VarM.hasNext()) {
            char c11 = cArr[k0VarM.b()];
            R rI2 = selector.i(Character.valueOf(c11));
            if (rI.compareTo(rI2) > 0) {
                c10 = c11;
                rI = rI2;
            }
        }
        return Character.valueOf(c10);
    }

    public static final void p4(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        if (iArr.length > 1) {
            Arrays.sort(iArr);
        }
    }

    @yt.k
    public static final Character[] p5(@yt.k char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        Character[] chArr = new Character[cArr.length];
        int length = cArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            chArr[i10] = Character.valueOf(cArr[i10]);
        }
        return chArr;
    }

    @yt.k
    public static final List<Float> q(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return new e(fArr);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int q0(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return Arrays.hashCode(iArr);
    }

    @bk.f
    public static final char[] q1(char[] cArr) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, cArr.length);
        kotlin.jvm.internal.f0.o(cArrCopyOf, "copyOf(this, size)");
        return cArrCopyOf;
    }

    public static /* synthetic */ void q2(byte[] bArr, byte b10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        h2(bArr, b10, i10, i11);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Double q3(double[] dArr, ik.l<? super Double, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (dArr.length == 0) {
            return null;
        }
        double d10 = dArr[0];
        int iTe = ArraysKt___ArraysKt.Te(dArr);
        if (iTe == 0) {
            return Double.valueOf(d10);
        }
        R rI = selector.i(Double.valueOf(d10));
        k0 k0VarM = new qk.m(1, iTe).iterator();
        while (k0VarM.hasNext()) {
            double d11 = dArr[k0VarM.b()];
            R rI2 = selector.i(Double.valueOf(d11));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
                d10 = d11;
            }
        }
        return Double.valueOf(d10);
    }

    public static final void q4(@yt.k int[] iArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        Arrays.sort(iArr, i10, i11);
    }

    @yt.k
    public static final Double[] q5(@yt.k double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        Double[] dArr2 = new Double[dArr.length];
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            dArr2[i10] = Double.valueOf(dArr[i10]);
        }
        return dArr2;
    }

    @yt.k
    public static final List<Integer> r(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        return new c(iArr);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int r0(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return Arrays.hashCode(jArr);
    }

    @bk.f
    public static final char[] r1(char[] cArr, int i10) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        char[] cArrCopyOf = Arrays.copyOf(cArr, i10);
        kotlin.jvm.internal.f0.o(cArrCopyOf, "copyOf(this, newSize)");
        return cArrCopyOf;
    }

    public static /* synthetic */ void r2(char[] cArr, char c10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        i2(cArr, c10, i10, i11);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Float r3(float[] fArr, ik.l<? super Float, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (fArr.length == 0) {
            return null;
        }
        float f10 = fArr[0];
        int iUe = ArraysKt___ArraysKt.Ue(fArr);
        if (iUe == 0) {
            return Float.valueOf(f10);
        }
        R rI = selector.i(Float.valueOf(f10));
        k0 k0VarM = new qk.m(1, iUe).iterator();
        while (k0VarM.hasNext()) {
            float f11 = fArr[k0VarM.b()];
            R rI2 = selector.i(Float.valueOf(f11));
            if (rI.compareTo(rI2) > 0) {
                f10 = f11;
                rI = rI2;
            }
        }
        return Float.valueOf(f10);
    }

    public static final void r4(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        if (jArr.length > 1) {
            Arrays.sort(jArr);
        }
    }

    @yt.k
    public static final Float[] r5(@yt.k float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        Float[] fArr2 = new Float[fArr.length];
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            fArr2[i10] = Float.valueOf(fArr[i10]);
        }
        return fArr2;
    }

    @yt.k
    public static final List<Long> s(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        return new d(jArr);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ <T> int s0(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        return Arrays.hashCode(tArr);
    }

    @bk.f
    public static final double[] s1(double[] dArr) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, dArr.length);
        kotlin.jvm.internal.f0.o(dArrCopyOf, "copyOf(this, size)");
        return dArrCopyOf;
    }

    public static /* synthetic */ void s2(double[] dArr, double d10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length;
        }
        j2(dArr, d10, i10, i11);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Integer s3(int[] iArr, ik.l<? super Integer, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (iArr.length == 0) {
            return null;
        }
        int i10 = iArr[0];
        int iVe = ArraysKt___ArraysKt.Ve(iArr);
        if (iVe == 0) {
            return Integer.valueOf(i10);
        }
        R rI = selector.i(Integer.valueOf(i10));
        k0 k0VarM = new qk.m(1, iVe).iterator();
        while (k0VarM.hasNext()) {
            int i11 = iArr[k0VarM.b()];
            R rI2 = selector.i(Integer.valueOf(i11));
            if (rI.compareTo(rI2) > 0) {
                i10 = i11;
                rI = rI2;
            }
        }
        return Integer.valueOf(i10);
    }

    public static final void s4(@yt.k long[] jArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        Arrays.sort(jArr, i10, i11);
    }

    @yt.k
    public static final Integer[] s5(@yt.k int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        Integer[] numArr = new Integer[iArr.length];
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            numArr[i10] = Integer.valueOf(iArr[i10]);
        }
        return numArr;
    }

    @yt.k
    public static final <T> List<T> t(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        List<T> listA = n.a(tArr);
        kotlin.jvm.internal.f0.o(listA, "asList(this)");
        return listA;
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int t0(short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return Arrays.hashCode(sArr);
    }

    @bk.f
    public static final double[] t1(double[] dArr, int i10) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        double[] dArrCopyOf = Arrays.copyOf(dArr, i10);
        kotlin.jvm.internal.f0.o(dArrCopyOf, "copyOf(this, newSize)");
        return dArrCopyOf;
    }

    public static /* synthetic */ void t2(float[] fArr, float f10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length;
        }
        k2(fArr, f10, i10, i11);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Long t3(long[] jArr, ik.l<? super Long, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (jArr.length == 0) {
            return null;
        }
        long j10 = jArr[0];
        int iWe = ArraysKt___ArraysKt.We(jArr);
        if (iWe == 0) {
            return Long.valueOf(j10);
        }
        R rI = selector.i(Long.valueOf(j10));
        k0 k0VarM = new qk.m(1, iWe).iterator();
        while (k0VarM.hasNext()) {
            long j11 = jArr[k0VarM.b()];
            R rI2 = selector.i(Long.valueOf(j11));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
                j10 = j11;
            }
        }
        return Long.valueOf(j10);
    }

    @bk.f
    public static final <T extends Comparable<? super T>> void t4(T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        v4(tArr);
    }

    @yt.k
    public static final Long[] t5(@yt.k long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        Long[] lArr = new Long[jArr.length];
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            lArr[i10] = Long.valueOf(jArr[i10]);
        }
        return lArr;
    }

    @yt.k
    public static final List<Short> u(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        return new b(sArr);
    }

    @bk.f
    @kotlin.k(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @kotlin.v0(version = "1.1")
    @kotlin.l(hiddenSince = "1.4")
    public static final /* synthetic */ int u0(boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return Arrays.hashCode(zArr);
    }

    @bk.f
    public static final float[] u1(float[] fArr) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, fArr.length);
        kotlin.jvm.internal.f0.o(fArrCopyOf, "copyOf(this, size)");
        return fArrCopyOf;
    }

    public static /* synthetic */ void u2(int[] iArr, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = iArr.length;
        }
        l2(iArr, i10, i11, i12);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <T, R extends Comparable<? super R>> T u3(T[] tArr, ik.l<? super T, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (tArr.length == 0) {
            return null;
        }
        T t10 = tArr[0];
        int iXe = ArraysKt___ArraysKt.Xe(tArr);
        if (iXe != 0) {
            R rI = selector.i(t10);
            k0 k0VarM = new qk.m(1, iXe).iterator();
            while (k0VarM.hasNext()) {
                T t11 = tArr[k0VarM.b()];
                R rI2 = selector.i(t11);
                if (rI.compareTo(rI2) > 0) {
                    t10 = t11;
                    rI = rI2;
                }
            }
        }
        return t10;
    }

    @kotlin.v0(version = "1.4")
    public static final <T extends Comparable<? super T>> void u4(@yt.k T[] tArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        Arrays.sort(tArr, i10, i11);
    }

    @yt.k
    public static final Short[] u5(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        Short[] shArr = new Short[sArr.length];
        int length = sArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            shArr[i10] = Short.valueOf(sArr[i10]);
        }
        return shArr;
    }

    @yt.k
    public static final List<Boolean> v(@yt.k boolean[] zArr) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        return new g(zArr);
    }

    @hk.h(name = "contentHashCodeNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int v0(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    @bk.f
    public static final float[] v1(float[] fArr, int i10) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        float[] fArrCopyOf = Arrays.copyOf(fArr, i10);
        kotlin.jvm.internal.f0.o(fArrCopyOf, "copyOf(this, newSize)");
        return fArrCopyOf;
    }

    public static /* synthetic */ void v2(long[] jArr, long j10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length;
        }
        m2(jArr, j10, i10, i11);
    }

    @kotlin.k(message = "Use minByOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minByOrNull(selector)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ <R extends Comparable<? super R>> Short v3(short[] sArr, ik.l<? super Short, ? extends R> selector) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        kotlin.jvm.internal.f0.p(selector, "selector");
        if (sArr.length == 0) {
            return null;
        }
        short s10 = sArr[0];
        int iYe = ArraysKt___ArraysKt.Ye(sArr);
        if (iYe == 0) {
            return Short.valueOf(s10);
        }
        R rI = selector.i(Short.valueOf(s10));
        k0 k0VarM = new qk.m(1, iYe).iterator();
        while (k0VarM.hasNext()) {
            short s11 = sArr[k0VarM.b()];
            R rI2 = selector.i(Short.valueOf(s11));
            if (rI.compareTo(rI2) > 0) {
                s10 = s11;
                rI = rI2;
            }
        }
        return Short.valueOf(s10);
    }

    public static final <T> void v4(@yt.k T[] tArr) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        if (tArr.length > 1) {
            Arrays.sort(tArr);
        }
    }

    public static final int w(@yt.k byte[] bArr, byte b10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        return Arrays.binarySearch(bArr, i10, i11, b10);
    }

    @hk.h(name = "contentHashCodeNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int w0(char[] cArr) {
        return Arrays.hashCode(cArr);
    }

    @bk.f
    public static final int[] w1(int[] iArr) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length);
        kotlin.jvm.internal.f0.o(iArrCopyOf, "copyOf(this, size)");
        return iArrCopyOf;
    }

    public static /* synthetic */ void w2(Object[] objArr, Object obj, int i10, int i11, int i12, Object obj2) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = objArr.length;
        }
        n2(objArr, obj, i10, i11);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Boolean w3(boolean[] zArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(zArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.ao(zArr, comparator);
    }

    public static final <T> void w4(@yt.k T[] tArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(tArr, "<this>");
        Arrays.sort(tArr, i10, i11);
    }

    public static final int x(@yt.k char[] cArr, char c10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        return Arrays.binarySearch(cArr, i10, i11, c10);
    }

    @hk.h(name = "contentHashCodeNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int x0(double[] dArr) {
        return Arrays.hashCode(dArr);
    }

    @bk.f
    public static final int[] x1(int[] iArr, int i10) {
        kotlin.jvm.internal.f0.p(iArr, "<this>");
        int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
        kotlin.jvm.internal.f0.o(iArrCopyOf, "copyOf(this, newSize)");
        return iArrCopyOf;
    }

    public static /* synthetic */ void x2(short[] sArr, short s10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length;
        }
        o2(sArr, s10, i10, i11);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Byte x3(byte[] bArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(bArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.bo(bArr, comparator);
    }

    public static final void x4(@yt.k short[] sArr) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        if (sArr.length > 1) {
            Arrays.sort(sArr);
        }
    }

    public static final int y(@yt.k double[] dArr, double d10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        return Arrays.binarySearch(dArr, i10, i11, d10);
    }

    @hk.h(name = "contentHashCodeNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int y0(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    @bk.f
    public static final long[] y1(long[] jArr) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, jArr.length);
        kotlin.jvm.internal.f0.o(jArrCopyOf, "copyOf(this, size)");
        return jArrCopyOf;
    }

    public static /* synthetic */ void y2(boolean[] zArr, boolean z10, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = zArr.length;
        }
        p2(zArr, z10, i10, i11);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Character y3(char[] cArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(cArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.co(cArr, comparator);
    }

    public static final void y4(@yt.k short[] sArr, int i10, int i11) {
        kotlin.jvm.internal.f0.p(sArr, "<this>");
        Arrays.sort(sArr, i10, i11);
    }

    public static final int z(@yt.k float[] fArr, float f10, int i10, int i11) {
        kotlin.jvm.internal.f0.p(fArr, "<this>");
        return Arrays.binarySearch(fArr, i10, i11, f10);
    }

    @hk.h(name = "contentHashCodeNullable")
    @bk.f
    @kotlin.v0(version = "1.4")
    public static final int z0(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    @bk.f
    public static final long[] z1(long[] jArr, int i10) {
        kotlin.jvm.internal.f0.p(jArr, "<this>");
        long[] jArrCopyOf = Arrays.copyOf(jArr, i10);
        kotlin.jvm.internal.f0.o(jArrCopyOf, "copyOf(this, newSize)");
        return jArrCopyOf;
    }

    @yt.k
    public static final <R> List<R> z2(@yt.k Object[] objArr, @yt.k Class<R> klass) {
        kotlin.jvm.internal.f0.p(objArr, "<this>");
        kotlin.jvm.internal.f0.p(klass, "klass");
        return (List) A2(objArr, new ArrayList(), klass);
    }

    @kotlin.k(message = "Use minWithOrNull instead.", replaceWith = @kotlin.t0(expression = "this.minWithOrNull(comparator)", imports = {}))
    @kotlin.l(errorSince = "1.5", hiddenSince = "1.6", warningSince = "1.4")
    public static final /* synthetic */ Double z3(double[] dArr, Comparator comparator) {
        kotlin.jvm.internal.f0.p(dArr, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        return ArraysKt___ArraysKt.m8do(dArr, comparator);
    }

    public static /* synthetic */ void z4(byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        i4(bArr, i10, i11);
    }
}
