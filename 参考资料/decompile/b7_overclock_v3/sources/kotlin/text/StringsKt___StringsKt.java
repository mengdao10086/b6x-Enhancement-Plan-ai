package kotlin.text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Pair;
import kotlin.c2;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.collections.c1;
import kotlin.collections.d0;
import kotlin.collections.d1;
import kotlin.collections.h0;
import kotlin.collections.i0;
import kotlin.collections.k0;
import kotlin.collections.r0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.l1;
import kotlin.m0;
import kotlin.p1;
import kotlin.random.Random;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.v0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\n_Strings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,2486:1\n126#1,2:2487\n214#1,5:2489\n502#1,5:2495\n502#1,5:2500\n462#1:2505\n1183#1,2:2506\n463#1,2:2508\n1185#1:2510\n465#1:2511\n462#1:2512\n1183#1,2:2513\n463#1,2:2515\n1185#1:2517\n465#1:2518\n1183#1,3:2519\n492#1,2:2522\n492#1,2:2524\n750#1,4:2526\n719#1,4:2530\n735#1,4:2534\n782#1,4:2538\n882#1,5:2542\n923#1,3:2547\n926#1,3:2557\n941#1,3:2560\n944#1,3:2570\n1041#1,3:2587\n1011#1,4:2590\n1000#1:2594\n1183#1,2:2595\n1185#1:2598\n1001#1:2599\n1183#1,3:2600\n1032#1:2603\n1174#1:2604\n1175#1:2606\n1033#1:2607\n1174#1,2:2608\n1183#1,3:2610\n1982#1,2:2613\n1984#1,6:2616\n2006#1,2:2622\n2008#1,6:2625\n2431#1,6:2631\n2461#1,7:2637\n1#2:2494\n1#2:2597\n1#2:2605\n1#2:2615\n1#2:2624\n361#3,7:2550\n361#3,7:2563\n361#3,7:2573\n361#3,7:2580\n*S KotlinDebug\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n52#1:2487,2\n62#1:2489,5\n420#1:2495,5\n429#1:2500,5\n440#1:2505\n440#1:2506,2\n440#1:2508,2\n440#1:2510\n440#1:2511\n451#1:2512\n451#1:2513,2\n451#1:2515,2\n451#1:2517\n451#1:2518\n462#1:2519,3\n474#1:2522,2\n483#1:2524,2\n677#1:2526,4\n692#1:2530,4\n706#1:2534,4\n769#1:2538,4\n842#1:2542,5\n898#1:2547,3\n898#1:2557,3\n911#1:2560,3\n911#1:2570,3\n970#1:2587,3\n980#1:2590,4\n990#1:2594\n990#1:2595,2\n990#1:2598\n990#1:2599\n1000#1:2600,3\n1024#1:2603\n1024#1:2604\n1024#1:2606\n1024#1:2607\n1032#1:2608,2\n1786#1:2610,3\n2077#1:2613,2\n2077#1:2616,6\n2095#1:2622,2\n2095#1:2625,6\n2420#1:2631,6\n2448#1:2637,7\n990#1:2597\n1024#1:2605\n2077#1:2615\n2095#1:2624\n898#1:2550,7\n911#1:2563,7\n925#1:2573,7\n943#1:2580,7\n*E\n"})
public class StringsKt___StringsKt extends v {

    @t0({"SMAP\nIterables.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Iterables.kt\nkotlin/collections/CollectionsKt__IterablesKt$Iterable$1\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,70:1\n2475#2:71\n*E\n"})
    public static final class a implements Iterable<Character>, jk.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f38153a;

        public a(CharSequence charSequence) {
            this.f38153a = charSequence;
        }

        @Override // java.lang.Iterable
        @yt.k
        public Iterator<Character> iterator() {
            return StringsKt__StringsKt.C3(this.f38153a);
        }
    }

    @t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 _Strings.kt\nkotlin/text/StringsKt___StringsKt\n*L\n1#1,680:1\n2483#2:681\n*E\n"})
    public static final class b implements kotlin.sequences.m<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f38154a;

        public b(CharSequence charSequence) {
            this.f38154a = charSequence;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<Character> iterator() {
            return StringsKt__StringsKt.C3(this.f38154a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [K] */
    @t0({"SMAP\n_Strings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Strings.kt\nkotlin/text/StringsKt___StringsKt$groupingBy$1\n*L\n1#1,2486:1\n*E\n"})
    public static final class c<K> implements d0<Character, K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f38155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.l<Character, K> f38156b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(CharSequence charSequence, ik.l<? super Character, ? extends K> lVar) {
            this.f38155a = charSequence;
            this.f38156b = lVar;
        }

        @Override // kotlin.collections.d0
        public /* bridge */ /* synthetic */ Object a(Character ch2) {
            return c(ch2.charValue());
        }

        @Override // kotlin.collections.d0
        @yt.k
        public Iterator<Character> b() {
            return StringsKt__StringsKt.C3(this.f38155a);
        }

        public K c(char c10) {
            return this.f38156b.i(Character.valueOf(c10));
        }
    }

    @yt.k
    public static final CharSequence A6(@yt.k CharSequence charSequence, int i10) {
        f0.p(charSequence, "<this>");
        if (i10 >= 0) {
            return charSequence.subSequence(qk.v.B(i10, charSequence.length()), charSequence.length());
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R> List<R> A7(@yt.k CharSequence charSequence, @yt.k ik.p<? super Integer, ? super Character, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            int i12 = i11 + 1;
            R rR0 = transform.r0(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10)));
            if (rR0 != null) {
                arrayList.add(rR0);
            }
            i10++;
            i11 = i12;
        }
        return arrayList;
    }

    @yt.k
    public static final CharSequence A8(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        StringBuilder sbReverse = new StringBuilder(charSequence).reverse();
        f0.o(sbReverse, "StringBuilder(this).reverse()");
        return sbReverse;
    }

    @yt.k
    public static final String B6(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(qk.v.B(i10, str.length()));
            f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C B7(@yt.k CharSequence charSequence, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Character, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            int i12 = i11 + 1;
            R rR0 = transform.r0(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10)));
            if (rR0 != null) {
                destination.add(rR0);
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @bk.f
    public static final String B8(String str) {
        f0.p(str, "<this>");
        return A8(str).toString();
    }

    @yt.k
    public static final CharSequence C6(@yt.k CharSequence charSequence, int i10) {
        f0.p(charSequence, "<this>");
        if (i10 >= 0) {
            return X8(charSequence, qk.v.u(charSequence.length() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C C7(@yt.k CharSequence charSequence, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Character, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            destination.add(transform.r0(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10))));
            i10++;
            i11++;
        }
        return destination;
    }

    @v0(version = "1.4")
    @yt.k
    public static final <R> List<R> C8(@yt.k CharSequence charSequence, R r10, @yt.k ik.p<? super R, ? super Character, ? extends R> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r10);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            r10 = operation.r0(r10, Character.valueOf(charSequence.charAt(i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.k
    public static final String D6(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        if (i10 >= 0) {
            return Y8(str, qk.v.u(str.length() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R> List<R> D7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            R rI = transform.i(Character.valueOf(charSequence.charAt(i10)));
            if (rI != null) {
                arrayList.add(rI);
            }
        }
        return arrayList;
    }

    @v0(version = "1.4")
    @yt.k
    public static final <R> List<R> D8(@yt.k CharSequence charSequence, R r10, @yt.k ik.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r10);
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Character.valueOf(charSequence.charAt(i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.k
    public static final CharSequence E6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        for (int iJ3 = StringsKt__StringsKt.j3(charSequence); -1 < iJ3; iJ3--) {
            if (!predicate.i(Character.valueOf(charSequence.charAt(iJ3))).booleanValue()) {
                return charSequence.subSequence(0, iJ3 + 1);
            }
        }
        return "";
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C E7(@yt.k CharSequence charSequence, @yt.k C destination, @yt.k ik.l<? super Character, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            R rI = transform.i(Character.valueOf(charSequence.charAt(i10)));
            if (rI != null) {
                destination.add(rI);
            }
        }
        return destination;
    }

    @v0(version = "1.4")
    @yt.k
    public static final List<Character> E8(@yt.k CharSequence charSequence, @yt.k ik.p<? super Character, ? super Character, Character> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        for (int i10 = 1; i10 < length; i10++) {
            cCharAt = operation.r0(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i10))).charValue();
            arrayList.add(Character.valueOf(cCharAt));
        }
        return arrayList;
    }

    @yt.k
    public static final String F6(@yt.k String str, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        for (int iJ3 = StringsKt__StringsKt.j3(str); -1 < iJ3; iJ3--) {
            if (!predicate.i(Character.valueOf(str.charAt(iJ3))).booleanValue()) {
                String strSubstring = str.substring(0, iJ3 + 1);
                f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring;
            }
        }
        return "";
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C F7(@yt.k CharSequence charSequence, @yt.k C destination, @yt.k ik.l<? super Character, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            destination.add(transform.i(Character.valueOf(charSequence.charAt(i10))));
        }
        return destination;
    }

    @v0(version = "1.4")
    @yt.k
    public static final List<Character> F8(@yt.k CharSequence charSequence, @yt.k ik.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return CollectionsKt__CollectionsKt.E();
        }
        char cCharAt = charSequence.charAt(0);
        ArrayList arrayList = new ArrayList(charSequence.length());
        arrayList.add(Character.valueOf(cCharAt));
        int length = charSequence.length();
        for (int i10 = 1; i10 < length; i10++) {
            cCharAt = operation.A(Integer.valueOf(i10), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i10))).charValue();
            arrayList.add(Character.valueOf(cCharAt));
        }
        return arrayList;
    }

    @yt.k
    public static final CharSequence G6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!predicate.i(Character.valueOf(charSequence.charAt(i10))).booleanValue()) {
                return charSequence.subSequence(i10, charSequence.length());
            }
        }
        return "";
    }

    @v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Character G7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends R> selector) {
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

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.k
    public static final <R> List<R> G8(@yt.k CharSequence charSequence, R r10, @yt.k ik.p<? super R, ? super Character, ? extends R> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r10);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            r10 = operation.r0(r10, Character.valueOf(charSequence.charAt(i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @yt.k
    public static final String H6(@yt.k String str, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!predicate.i(Character.valueOf(str.charAt(i10))).booleanValue()) {
                String strSubstring = str.substring(i10);
                f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        }
        return "";
    }

    @hk.h(name = "maxByOrThrow")
    @v0(version = "1.7")
    public static final <R extends Comparable<? super R>> char H7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int iJ3 = StringsKt__StringsKt.j3(charSequence);
        if (iJ3 == 0) {
            return cCharAt;
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
        return cCharAt;
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.k
    public static final <R> List<R> H8(@yt.k CharSequence charSequence, R r10, @yt.k ik.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return kotlin.collections.s.k(r10);
        }
        ArrayList arrayList = new ArrayList(charSequence.length() + 1);
        arrayList.add(r10);
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            r10 = operation.A(Integer.valueOf(i10), r10, Character.valueOf(charSequence.charAt(i10)));
            arrayList.add(r10);
        }
        return arrayList;
    }

    @bk.f
    public static final char I6(CharSequence charSequence, int i10, ik.l<? super Integer, Character> defaultValue) {
        f0.p(charSequence, "<this>");
        f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > StringsKt__StringsKt.j3(charSequence)) ? defaultValue.i(Integer.valueOf(i10)).charValue() : charSequence.charAt(i10);
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final double I7(CharSequence charSequence, ik.l<? super Character, Double> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Character.valueOf(charSequence.charAt(0))).doubleValue();
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Character.valueOf(charSequence.charAt(it2.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    public static final char I8(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    @bk.f
    public static final Character J6(CharSequence charSequence, int i10) {
        f0.p(charSequence, "<this>");
        return m7(charSequence, i10);
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final float J7(CharSequence charSequence, ik.l<? super Character, Float> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Character.valueOf(charSequence.charAt(0))).floatValue();
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Character.valueOf(charSequence.charAt(it2.b()))).floatValue());
        }
        return fFloatValue;
    }

    public static final char J8(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        Character chValueOf = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                if (z10) {
                    throw new IllegalArgumentException("Char sequence contains more than one matching element.");
                }
                chValueOf = Character.valueOf(cCharAt);
                z10 = true;
            }
        }
        if (!z10) {
            throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
        }
        f0.n(chValueOf, "null cannot be cast to non-null type kotlin.Char");
        return chValueOf.charValue();
    }

    @yt.k
    public static final CharSequence K6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) throws IOException {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        StringBuilder sb2 = new StringBuilder();
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
        }
        return sb2;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R K7(CharSequence charSequence, ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Character.valueOf(charSequence.charAt(0)));
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(charSequence.charAt(it2.b())));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @yt.l
    public static final Character K8(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        if (charSequence.length() == 1) {
            return Character.valueOf(charSequence.charAt(0));
        }
        return null;
    }

    @yt.k
    public static final String L6(@yt.k String str, @yt.k ik.l<? super Character, Boolean> predicate) throws IOException {
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        f0.o(string, "filterTo(StringBuilder(), predicate).toString()");
        return string;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R L7(CharSequence charSequence, ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R rI = selector.i(Character.valueOf(charSequence.charAt(0)));
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(charSequence.charAt(it2.b())));
            if (rI.compareTo(rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @yt.l
    public static final Character L8(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        Character chValueOf = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                if (z10) {
                    return null;
                }
                chValueOf = Character.valueOf(cCharAt);
                z10 = true;
            }
        }
        if (z10) {
            return chValueOf;
        }
        return null;
    }

    @yt.k
    public static final CharSequence M6(@yt.k CharSequence charSequence, @yt.k ik.p<? super Integer, ? super Character, Boolean> predicate) throws IOException {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i10);
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
            i10++;
            i11 = i12;
        }
        return sb2;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final Double M7(CharSequence charSequence, ik.l<? super Character, Double> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Character.valueOf(charSequence.charAt(0))).doubleValue();
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.max(dDoubleValue, selector.i(Character.valueOf(charSequence.charAt(it2.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @yt.k
    public static final CharSequence M8(@yt.k CharSequence charSequence, @yt.k Iterable<Integer> indices) {
        f0.p(charSequence, "<this>");
        f0.p(indices, "indices");
        int iY = kotlin.collections.t.Y(indices, 10);
        if (iY == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(iY);
        Iterator<Integer> it2 = indices.iterator();
        while (it2.hasNext()) {
            sb2.append(charSequence.charAt(it2.next().intValue()));
        }
        return sb2;
    }

    @yt.k
    public static final String N6(@yt.k String str, @yt.k ik.p<? super Integer, ? super Character, Boolean> predicate) throws IOException {
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        int i11 = 0;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
            i10++;
            i11 = i12;
        }
        String string = sb2.toString();
        f0.o(string, "filterIndexedTo(StringBu…(), predicate).toString()");
        return string;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final Float N7(CharSequence charSequence, ik.l<? super Character, Float> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        float fFloatValue = selector.i(Character.valueOf(charSequence.charAt(0))).floatValue();
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.max(fFloatValue, selector.i(Character.valueOf(charSequence.charAt(it2.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @yt.k
    public static final CharSequence N8(@yt.k CharSequence charSequence, @yt.k qk.m indices) {
        f0.p(charSequence, "<this>");
        f0.p(indices, "indices");
        return indices.isEmpty() ? "" : StringsKt__StringsKt.h5(charSequence, indices);
    }

    @yt.k
    public static final <C extends Appendable> C O6(@yt.k CharSequence charSequence, @yt.k C destination, @yt.k ik.p<? super Integer, ? super Character, Boolean> predicate) throws IOException {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            char cCharAt = charSequence.charAt(i10);
            int i12 = i11 + 1;
            if (predicate.r0(Integer.valueOf(i11), Character.valueOf(cCharAt)).booleanValue()) {
                destination.append(cCharAt);
            }
            i10++;
            i11 = i12;
        }
        return destination;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <R> R O7(CharSequence charSequence, Comparator<? super R> comparator, ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Character.valueOf(charSequence.charAt(0)));
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(charSequence.charAt(it2.b())));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @bk.f
    public static final String O8(String str, Iterable<Integer> indices) {
        f0.p(str, "<this>");
        f0.p(indices, "indices");
        return M8(str, indices).toString();
    }

    @yt.k
    public static final CharSequence P6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) throws IOException {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (!predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
        }
        return sb2;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <R> R P7(CharSequence charSequence, Comparator<? super R> comparator, ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R rI = selector.i(Character.valueOf(charSequence.charAt(0)));
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(charSequence.charAt(it2.b())));
            if (comparator.compare(rI, rI2) < 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @yt.k
    public static final String P8(@yt.k String str, @yt.k qk.m indices) {
        f0.p(str, "<this>");
        f0.p(indices, "indices");
        return indices.isEmpty() ? "" : StringsKt__StringsKt.l5(str, indices);
    }

    @yt.k
    public static final String Q6(@yt.k String str, @yt.k ik.l<? super Character, Boolean> predicate) throws IOException {
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char cCharAt = str.charAt(i10);
            if (!predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            }
        }
        String string = sb2.toString();
        f0.o(string, "filterNotTo(StringBuilder(), predicate).toString()");
        return string;
    }

    @v0(version = "1.4")
    @yt.l
    public static final Character Q7(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            char cCharAt2 = charSequence.charAt(it2.b());
            if (f0.t(cCharAt, cCharAt2) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final int Q8(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Integer> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        int iIntValue = 0;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            iIntValue += selector.i(Character.valueOf(charSequence.charAt(i10))).intValue();
        }
        return iIntValue;
    }

    @yt.k
    public static final <C extends Appendable> C R6(@yt.k CharSequence charSequence, @yt.k C destination, @yt.k ik.l<? super Character, Boolean> predicate) throws IOException {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (!predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                destination.append(cCharAt);
            }
        }
        return destination;
    }

    @hk.h(name = "maxOrThrow")
    @v0(version = "1.7")
    public static final char R7(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            char cCharAt2 = charSequence.charAt(it2.b());
            if (f0.t(cCharAt, cCharAt2) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @kotlin.k(message = "Use sumOf instead.", replaceWith = @kotlin.t0(expression = "this.sumOf(selector)", imports = {}))
    @kotlin.l(warningSince = "1.5")
    public static final double R8(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Double> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            dDoubleValue += selector.i(Character.valueOf(charSequence.charAt(i10))).doubleValue();
        }
        return dDoubleValue;
    }

    @yt.k
    public static final <C extends Appendable> C S6(@yt.k CharSequence charSequence, @yt.k C destination, @yt.k ik.l<? super Character, Boolean> predicate) throws IOException {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                destination.append(cCharAt);
            }
        }
        return destination;
    }

    @v0(version = "1.4")
    @yt.l
    public static final Character S7(@yt.k CharSequence charSequence, @yt.k Comparator<? super Character> comparator) {
        f0.p(charSequence, "<this>");
        f0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            char cCharAt2 = charSequence.charAt(it2.b());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @hk.h(name = "sumOfDouble")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final double S8(CharSequence charSequence, ik.l<? super Character, Double> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        double dDoubleValue = 0.0d;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            dDoubleValue += selector.i(Character.valueOf(charSequence.charAt(i10))).doubleValue();
        }
        return dDoubleValue;
    }

    @bk.f
    public static final Character T6(CharSequence charSequence, ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
        }
        return null;
    }

    @hk.h(name = "maxWithOrThrow")
    @v0(version = "1.7")
    public static final char T7(@yt.k CharSequence charSequence, @yt.k Comparator<? super Character> comparator) {
        f0.p(charSequence, "<this>");
        f0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            char cCharAt2 = charSequence.charAt(it2.b());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) < 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @hk.h(name = "sumOfInt")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final int T8(CharSequence charSequence, ik.l<? super Character, Integer> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        int iIntValue = 0;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            iIntValue += selector.i(Character.valueOf(charSequence.charAt(i10))).intValue();
        }
        return iIntValue;
    }

    @bk.f
    public static final Character U6(CharSequence charSequence, ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                char cCharAt = charSequence.charAt(length);
                if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                    return Character.valueOf(cCharAt);
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return null;
    }

    @v0(version = "1.4")
    @yt.l
    public static final <R extends Comparable<? super R>> Character U7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends R> selector) {
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

    @hk.h(name = "sumOfLong")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final long U8(CharSequence charSequence, ik.l<? super Character, Long> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        long jLongValue = 0;
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            jLongValue += selector.i(Character.valueOf(charSequence.charAt(i10))).longValue();
        }
        return jLongValue;
    }

    public static final char V6(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(0);
    }

    @hk.h(name = "minByOrThrow")
    @v0(version = "1.7")
    public static final <R extends Comparable<? super R>> char V7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        int iJ3 = StringsKt__StringsKt.j3(charSequence);
        if (iJ3 == 0) {
            return cCharAt;
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
        return cCharAt;
    }

    @hk.h(name = "sumOfUInt")
    @m0
    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final int V8(CharSequence charSequence, ik.l<? super Character, l1> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        int iJ = l1.j(0);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            iJ = l1.j(iJ + selector.i(Character.valueOf(charSequence.charAt(i10))).l0());
        }
        return iJ;
    }

    public static final char W6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                return cCharAt;
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final double W7(CharSequence charSequence, ik.l<? super Character, Double> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        double dDoubleValue = selector.i(Character.valueOf(charSequence.charAt(0))).doubleValue();
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Character.valueOf(charSequence.charAt(it2.b()))).doubleValue());
        }
        return dDoubleValue;
    }

    @hk.h(name = "sumOfULong")
    @m0
    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {kotlin.s.class})
    public static final long W8(CharSequence charSequence, ik.l<? super Character, p1> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        long j10 = p1.j(0L);
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            j10 = p1.j(j10 + selector.i(Character.valueOf(charSequence.charAt(i10))).l0());
        }
        return j10;
    }

    @bk.f
    @v0(version = "1.5")
    public static final <R> R X6(CharSequence charSequence, ik.l<? super Character, ? extends R> transform) {
        R rI;
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        int i10 = 0;
        while (true) {
            if (i10 >= charSequence.length()) {
                rI = null;
                break;
            }
            rI = transform.i(Character.valueOf(charSequence.charAt(i10)));
            if (rI != null) {
                break;
            }
            i10++;
        }
        if (rI != null) {
            return rI;
        }
        throw new NoSuchElementException("No element of the char sequence was transformed to a non-null value.");
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final float X7(CharSequence charSequence, ik.l<? super Character, Float> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        float fFloatValue = selector.i(Character.valueOf(charSequence.charAt(0))).floatValue();
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Character.valueOf(charSequence.charAt(it2.b()))).floatValue());
        }
        return fFloatValue;
    }

    @yt.k
    public static final CharSequence X8(@yt.k CharSequence charSequence, int i10) {
        f0.p(charSequence, "<this>");
        if (i10 >= 0) {
            return charSequence.subSequence(0, qk.v.B(i10, charSequence.length()));
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    @bk.f
    @v0(version = "1.5")
    public static final <R> R Y6(CharSequence charSequence, ik.l<? super Character, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            R rI = transform.i(Character.valueOf(charSequence.charAt(i10)));
            if (rI != null) {
                return rI;
            }
        }
        return null;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Y7(CharSequence charSequence, ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Character.valueOf(charSequence.charAt(0)));
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(charSequence.charAt(it2.b())));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @yt.k
    public static final String Y8(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(0, qk.v.B(i10, str.length()));
            f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    @yt.l
    public static final Character Z6(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(0));
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <R extends Comparable<? super R>> R Z7(CharSequence charSequence, ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R rI = selector.i(Character.valueOf(charSequence.charAt(0)));
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(charSequence.charAt(it2.b())));
            if (rI.compareTo(rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @yt.k
    public static final CharSequence Z8(@yt.k CharSequence charSequence, int i10) {
        f0.p(charSequence, "<this>");
        if (i10 >= 0) {
            int length = charSequence.length();
            return charSequence.subSequence(length - qk.v.B(i10, length), length);
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    @yt.l
    public static final Character a7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
        }
        return null;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final Double a8(CharSequence charSequence, ik.l<? super Character, Double> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        double dDoubleValue = selector.i(Character.valueOf(charSequence.charAt(0))).doubleValue();
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            dDoubleValue = Math.min(dDoubleValue, selector.i(Character.valueOf(charSequence.charAt(it2.b()))).doubleValue());
        }
        return Double.valueOf(dDoubleValue);
    }

    @yt.k
    public static final String a9(@yt.k String str, int i10) {
        f0.p(str, "<this>");
        if (i10 >= 0) {
            int length = str.length();
            String strSubstring = str.substring(length - qk.v.B(i10, length));
            f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    @yt.k
    public static final <R> List<R> b7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends Iterable<? extends R>> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            kotlin.collections.x.n0(arrayList, transform.i(Character.valueOf(charSequence.charAt(i10))));
        }
        return arrayList;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final Float b8(CharSequence charSequence, ik.l<? super Character, Float> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        float fFloatValue = selector.i(Character.valueOf(charSequence.charAt(0))).floatValue();
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            fFloatValue = Math.min(fFloatValue, selector.i(Character.valueOf(charSequence.charAt(it2.b()))).floatValue());
        }
        return Float.valueOf(fFloatValue);
    }

    @yt.k
    public static final CharSequence b9(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        for (int iJ3 = StringsKt__StringsKt.j3(charSequence); -1 < iJ3; iJ3--) {
            if (!predicate.i(Character.valueOf(charSequence.charAt(iJ3))).booleanValue()) {
                return charSequence.subSequence(iJ3 + 1, charSequence.length());
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @hk.h(name = "flatMapIndexedIterable")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <R> List<R> c7(CharSequence charSequence, ik.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            kotlin.collections.x.n0(arrayList, transform.r0(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <R> R c8(CharSequence charSequence, Comparator<? super R> comparator, ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        R rI = selector.i(Character.valueOf(charSequence.charAt(0)));
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(charSequence.charAt(it2.b())));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @yt.k
    public static final String c9(@yt.k String str, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        for (int iJ3 = StringsKt__StringsKt.j3(str); -1 < iJ3; iJ3--) {
            if (!predicate.i(Character.valueOf(str.charAt(iJ3))).booleanValue()) {
                String strSubstring = str.substring(iJ3 + 1);
                f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                return strSubstring;
            }
        }
        return str;
    }

    @hk.h(name = "flatMapIndexedIterableTo")
    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <R, C extends Collection<? super R>> C d7(CharSequence charSequence, C destination, ik.p<? super Integer, ? super Character, ? extends Iterable<? extends R>> transform) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            kotlin.collections.x.n0(destination, transform.r0(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10))));
            i10++;
            i11++;
        }
        return destination;
    }

    @m0
    @bk.f
    @v0(version = "1.4")
    public static final <R> R d8(CharSequence charSequence, Comparator<? super R> comparator, ik.l<? super Character, ? extends R> selector) {
        f0.p(charSequence, "<this>");
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        if (charSequence.length() == 0) {
            return null;
        }
        R rI = selector.i(Character.valueOf(charSequence.charAt(0)));
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            R rI2 = selector.i(Character.valueOf(charSequence.charAt(it2.b())));
            if (comparator.compare(rI, rI2) > 0) {
                rI = rI2;
            }
        }
        return rI;
    }

    @yt.k
    public static final CharSequence d9(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!predicate.i(Character.valueOf(charSequence.charAt(i10))).booleanValue()) {
                return charSequence.subSequence(0, i10);
            }
        }
        return charSequence.subSequence(0, charSequence.length());
    }

    @yt.k
    public static final <R, C extends Collection<? super R>> C e7(@yt.k CharSequence charSequence, @yt.k C destination, @yt.k ik.l<? super Character, ? extends Iterable<? extends R>> transform) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            kotlin.collections.x.n0(destination, transform.i(Character.valueOf(charSequence.charAt(i10))));
        }
        return destination;
    }

    @v0(version = "1.4")
    @yt.l
    public static final Character e8(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            char cCharAt2 = charSequence.charAt(it2.b());
            if (f0.t(cCharAt, cCharAt2) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @yt.k
    public static final String e9(@yt.k String str, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (!predicate.i(Character.valueOf(str.charAt(i10))).booleanValue()) {
                String strSubstring = str.substring(0, i10);
                f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                return strSubstring;
            }
        }
        return str;
    }

    public static final <R> R f7(@yt.k CharSequence charSequence, R r10, @yt.k ik.p<? super R, ? super Character, ? extends R> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            r10 = operation.r0(r10, Character.valueOf(charSequence.charAt(i10)));
        }
        return r10;
    }

    @hk.h(name = "minOrThrow")
    @v0(version = "1.7")
    public static final char f8(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            char cCharAt2 = charSequence.charAt(it2.b());
            if (f0.t(cCharAt, cCharAt2) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @yt.k
    public static final <C extends Collection<? super Character>> C f9(@yt.k CharSequence charSequence, @yt.k C destination) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            destination.add(Character.valueOf(charSequence.charAt(i10)));
        }
        return destination;
    }

    public static final <R> R g7(@yt.k CharSequence charSequence, R r10, @yt.k ik.q<? super Integer, ? super R, ? super Character, ? extends R> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            R r11 = r10;
            r10 = operation.A(Integer.valueOf(i11), r11, Character.valueOf(charSequence.charAt(i10)));
            i10++;
            i11++;
        }
        return r10;
    }

    @v0(version = "1.4")
    @yt.l
    public static final Character g8(@yt.k CharSequence charSequence, @yt.k Comparator<? super Character> comparator) {
        f0.p(charSequence, "<this>");
        f0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            char cCharAt2 = charSequence.charAt(it2.b());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return Character.valueOf(cCharAt);
    }

    @yt.k
    public static final HashSet<Character> g9(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return (HashSet) f9(charSequence, new HashSet(r0.j(qk.v.B(charSequence.length(), 128))));
    }

    public static final boolean h6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!predicate.i(Character.valueOf(charSequence.charAt(i10))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <R> R h7(@yt.k CharSequence charSequence, R r10, @yt.k ik.p<? super Character, ? super R, ? extends R> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        for (int iJ3 = StringsKt__StringsKt.j3(charSequence); iJ3 >= 0; iJ3--) {
            r10 = operation.r0(Character.valueOf(charSequence.charAt(iJ3)), r10);
        }
        return r10;
    }

    @hk.h(name = "minWithOrThrow")
    @v0(version = "1.7")
    public static final char h8(@yt.k CharSequence charSequence, @yt.k Comparator<? super Character> comparator) {
        f0.p(charSequence, "<this>");
        f0.p(comparator, "comparator");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException();
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            char cCharAt2 = charSequence.charAt(it2.b());
            if (comparator.compare(Character.valueOf(cCharAt), Character.valueOf(cCharAt2)) > 0) {
                cCharAt = cCharAt2;
            }
        }
        return cCharAt;
    }

    @yt.k
    public static final List<Character> h9(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        int length = charSequence.length();
        return length != 0 ? length != 1 ? i9(charSequence) : kotlin.collections.s.k(Character.valueOf(charSequence.charAt(0))) : CollectionsKt__CollectionsKt.E();
    }

    public static final boolean i6(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return !(charSequence.length() == 0);
    }

    public static final <R> R i7(@yt.k CharSequence charSequence, R r10, @yt.k ik.q<? super Integer, ? super Character, ? super R, ? extends R> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        for (int iJ3 = StringsKt__StringsKt.j3(charSequence); iJ3 >= 0; iJ3--) {
            r10 = operation.A(Integer.valueOf(iJ3), Character.valueOf(charSequence.charAt(iJ3)), r10);
        }
        return r10;
    }

    public static final boolean i8(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return charSequence.length() == 0;
    }

    @yt.k
    public static final List<Character> i9(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return (List) f9(charSequence, new ArrayList(charSequence.length()));
    }

    public static final boolean j6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (predicate.i(Character.valueOf(charSequence.charAt(i10))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public static final void j7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, z1> action) {
        f0.p(charSequence, "<this>");
        f0.p(action, "action");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            action.i(Character.valueOf(charSequence.charAt(i10)));
        }
    }

    public static final boolean j8(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (predicate.i(Character.valueOf(charSequence.charAt(i10))).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    @yt.k
    public static final Set<Character> j9(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        int length = charSequence.length();
        return length != 0 ? length != 1 ? (Set) f9(charSequence, new LinkedHashSet(r0.j(qk.v.B(charSequence.length(), 128)))) : c1.f(Character.valueOf(charSequence.charAt(0))) : d1.k();
    }

    @yt.k
    public static final Iterable<Character> k6(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return CollectionsKt__CollectionsKt.E();
            }
        }
        return new a(charSequence);
    }

    public static final void k7(@yt.k CharSequence charSequence, @yt.k ik.p<? super Integer, ? super Character, z1> action) {
        f0.p(charSequence, "<this>");
        f0.p(action, "action");
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            action.r0(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10)));
            i10++;
            i11++;
        }
    }

    @v0(version = "1.1")
    @yt.k
    public static final <S extends CharSequence> S k8(@yt.k S s10, @yt.k ik.l<? super Character, z1> action) {
        f0.p(s10, "<this>");
        f0.p(action, "action");
        for (int i10 = 0; i10 < s10.length(); i10++) {
            action.i(Character.valueOf(s10.charAt(i10)));
        }
        return s10;
    }

    @v0(version = "1.2")
    @yt.k
    public static final List<String> k9(@yt.k CharSequence charSequence, int i10, int i11, boolean z10) {
        f0.p(charSequence, "<this>");
        return l9(charSequence, i10, i11, z10, new ik.l<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt$windowed$1
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k CharSequence it2) {
                f0.p(it2, "it");
                return it2.toString();
            }
        });
    }

    @yt.k
    public static final kotlin.sequences.m<Character> l6(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        if (charSequence instanceof String) {
            if (charSequence.length() == 0) {
                return SequencesKt__SequencesKt.g();
            }
        }
        return new b(charSequence);
    }

    @bk.f
    public static final char l7(CharSequence charSequence, int i10, ik.l<? super Integer, Character> defaultValue) {
        f0.p(charSequence, "<this>");
        f0.p(defaultValue, "defaultValue");
        return (i10 < 0 || i10 > StringsKt__StringsKt.j3(charSequence)) ? defaultValue.i(Integer.valueOf(i10)).charValue() : charSequence.charAt(i10);
    }

    @v0(version = "1.4")
    @yt.k
    public static final <S extends CharSequence> S l8(@yt.k S s10, @yt.k ik.p<? super Integer, ? super Character, z1> action) {
        f0.p(s10, "<this>");
        f0.p(action, "action");
        int i10 = 0;
        int i11 = 0;
        while (i10 < s10.length()) {
            action.r0(Integer.valueOf(i11), Character.valueOf(s10.charAt(i10)));
            i10++;
            i11++;
        }
        return s10;
    }

    @v0(version = "1.2")
    @yt.k
    public static final <R> List<R> l9(@yt.k CharSequence charSequence, int i10, int i11, boolean z10, @yt.k ik.l<? super CharSequence, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        SlidingWindowKt.a(i10, i11);
        int length = charSequence.length();
        ArrayList arrayList = new ArrayList((length / i11) + (length % i11 == 0 ? 0 : 1));
        int i12 = 0;
        while (true) {
            if (!(i12 >= 0 && i12 < length)) {
                break;
            }
            int i13 = i12 + i10;
            if (i13 < 0 || i13 > length) {
                if (!z10) {
                    break;
                }
                i13 = length;
            }
            arrayList.add(transform.i(charSequence.subSequence(i12, i13)));
            i12 += i11;
        }
        return arrayList;
    }

    @yt.k
    public static final <K, V> Map<K, V> m6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(charSequence.length()), 16));
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            Pair<? extends K, ? extends V> pairI = transform.i(Character.valueOf(charSequence.charAt(i10)));
            linkedHashMap.put(pairI.f(), pairI.h());
        }
        return linkedHashMap;
    }

    @yt.l
    public static final Character m7(@yt.k CharSequence charSequence, int i10) {
        f0.p(charSequence, "<this>");
        if (i10 < 0 || i10 > StringsKt__StringsKt.j3(charSequence)) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(i10));
    }

    @yt.k
    public static final Pair<CharSequence, CharSequence> m8(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            } else {
                sb3.append(cCharAt);
            }
        }
        return new Pair<>(sb2, sb3);
    }

    public static /* synthetic */ List m9(CharSequence charSequence, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return k9(charSequence, i10, i11, z10);
    }

    @yt.k
    public static final <K> Map<K, Character> n6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends K> keySelector) {
        f0.p(charSequence, "<this>");
        f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(charSequence.length()), 16));
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            linkedHashMap.put(keySelector.i(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    @yt.k
    public static final <K> Map<K, List<Character>> n7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends K> keySelector) {
        f0.p(charSequence, "<this>");
        f0.p(keySelector, "keySelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            K kI = keySelector.i(Character.valueOf(cCharAt));
            Object arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(kI, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(cCharAt));
        }
        return linkedHashMap;
    }

    @yt.k
    public static final Pair<String, String> n8(@yt.k String str, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(str, "<this>");
        f0.p(predicate, "predicate");
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                sb2.append(cCharAt);
            } else {
                sb3.append(cCharAt);
            }
        }
        String string = sb2.toString();
        f0.o(string, "first.toString()");
        String string2 = sb3.toString();
        f0.o(string2, "second.toString()");
        return new Pair<>(string, string2);
    }

    public static /* synthetic */ List n9(CharSequence charSequence, int i10, int i11, boolean z10, ik.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return l9(charSequence, i10, i11, z10, lVar);
    }

    @yt.k
    public static final <K, V> Map<K, V> o6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends K> keySelector, @yt.k ik.l<? super Character, ? extends V> valueTransform) {
        f0.p(charSequence, "<this>");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(charSequence.length()), 16));
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            linkedHashMap.put(keySelector.i(Character.valueOf(cCharAt)), valueTransform.i(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    @yt.k
    public static final <K, V> Map<K, List<V>> o7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends K> keySelector, @yt.k ik.l<? super Character, ? extends V> valueTransform) {
        f0.p(charSequence, "<this>");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            K kI = keySelector.i(Character.valueOf(cCharAt));
            List<V> arrayList = linkedHashMap.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(kI, arrayList);
            }
            arrayList.add(valueTransform.i(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    @bk.f
    @v0(version = "1.3")
    public static final char o8(CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return p8(charSequence, Random.f38003a);
    }

    @v0(version = "1.2")
    @yt.k
    public static final kotlin.sequences.m<String> o9(@yt.k CharSequence charSequence, int i10, int i11, boolean z10) {
        f0.p(charSequence, "<this>");
        return p9(charSequence, i10, i11, z10, new ik.l<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt$windowedSequence$1
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k CharSequence it2) {
                f0.p(it2, "it");
                return it2.toString();
            }
        });
    }

    @yt.k
    public static final <K, M extends Map<? super K, ? super Character>> M p6(@yt.k CharSequence charSequence, @yt.k M destination, @yt.k ik.l<? super Character, ? extends K> keySelector) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            destination.put(keySelector.i(Character.valueOf(cCharAt)), Character.valueOf(cCharAt));
        }
        return destination;
    }

    @yt.k
    public static final <K, M extends Map<? super K, List<Character>>> M p7(@yt.k CharSequence charSequence, @yt.k M destination, @yt.k ik.l<? super Character, ? extends K> keySelector) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            K kI = keySelector.i(Character.valueOf(cCharAt));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(Character.valueOf(cCharAt));
        }
        return destination;
    }

    @v0(version = "1.3")
    public static final char p8(@yt.k CharSequence charSequence, @yt.k Random random) {
        f0.p(charSequence, "<this>");
        f0.p(random, "random");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(random.p(charSequence.length()));
    }

    @v0(version = "1.2")
    @yt.k
    public static final <R> kotlin.sequences.m<R> p9(@yt.k final CharSequence charSequence, final int i10, int i11, boolean z10, @yt.k final ik.l<? super CharSequence, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        SlidingWindowKt.a(i10, i11);
        return SequencesKt___SequencesKt.k1(CollectionsKt___CollectionsKt.v1(qk.v.B1(z10 ? StringsKt__StringsKt.i3(charSequence) : qk.v.W1(0, (charSequence.length() - i10) + 1), i11)), new ik.l<Integer, R>() { // from class: kotlin.text.StringsKt___StringsKt$windowedSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final R b(int i12) {
                int length = i10 + i12;
                if (length < 0 || length > charSequence.length()) {
                    length = charSequence.length();
                }
                return transform.i(charSequence.subSequence(i12, length));
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ Object i(Integer num) {
                return b(num.intValue());
            }
        });
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M q6(@yt.k CharSequence charSequence, @yt.k M destination, @yt.k ik.l<? super Character, ? extends K> keySelector, @yt.k ik.l<? super Character, ? extends V> valueTransform) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            destination.put(keySelector.i(Character.valueOf(cCharAt)), valueTransform.i(Character.valueOf(cCharAt)));
        }
        return destination;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <K, V, M extends Map<? super K, List<V>>> M q7(@yt.k CharSequence charSequence, @yt.k M destination, @yt.k ik.l<? super Character, ? extends K> keySelector, @yt.k ik.l<? super Character, ? extends V> valueTransform) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(keySelector, "keySelector");
        f0.p(valueTransform, "valueTransform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            K kI = keySelector.i(Character.valueOf(cCharAt));
            Object arrayList = destination.get(kI);
            if (arrayList == null) {
                arrayList = new ArrayList();
                destination.put(kI, arrayList);
            }
            ((List) arrayList).add(valueTransform.i(Character.valueOf(cCharAt)));
        }
        return destination;
    }

    @c2(markerClass = {kotlin.q.class})
    @bk.f
    @v0(version = "1.4")
    public static final Character q8(CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return r8(charSequence, Random.f38003a);
    }

    public static /* synthetic */ kotlin.sequences.m q9(CharSequence charSequence, int i10, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return o9(charSequence, i10, i11, z10);
    }

    @yt.k
    public static final <K, V, M extends Map<? super K, ? super V>> M r6(@yt.k CharSequence charSequence, @yt.k M destination, @yt.k ik.l<? super Character, ? extends Pair<? extends K, ? extends V>> transform) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(transform, "transform");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            Pair<? extends K, ? extends V> pairI = transform.i(Character.valueOf(charSequence.charAt(i10)));
            destination.put(pairI.f(), pairI.h());
        }
        return destination;
    }

    @v0(version = "1.1")
    @yt.k
    public static final <K> d0<Character, K> r7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends K> keySelector) {
        f0.p(charSequence, "<this>");
        f0.p(keySelector, "keySelector");
        return new c(charSequence, keySelector);
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.l
    public static final Character r8(@yt.k CharSequence charSequence, @yt.k Random random) {
        f0.p(charSequence, "<this>");
        f0.p(random, "random");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(random.p(charSequence.length())));
    }

    public static /* synthetic */ kotlin.sequences.m r9(CharSequence charSequence, int i10, int i11, boolean z10, ik.l lVar, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 1;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        return p9(charSequence, i10, i11, z10, lVar);
    }

    @v0(version = "1.3")
    @yt.k
    public static final <V> Map<Character, V> s6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends V> valueSelector) {
        f0.p(charSequence, "<this>");
        f0.p(valueSelector, "valueSelector");
        LinkedHashMap linkedHashMap = new LinkedHashMap(qk.v.u(r0.j(qk.v.B(charSequence.length(), 128)), 16));
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            linkedHashMap.put(Character.valueOf(cCharAt), valueSelector.i(Character.valueOf(cCharAt)));
        }
        return linkedHashMap;
    }

    public static final int s7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (predicate.i(Character.valueOf(charSequence.charAt(i10))).booleanValue()) {
                return i10;
            }
        }
        return -1;
    }

    public static final char s8(@yt.k CharSequence charSequence, @yt.k ik.p<? super Character, ? super Character, Character> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            cCharAt = operation.r0(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(it2.b()))).charValue();
        }
        return cCharAt;
    }

    @yt.k
    public static final Iterable<h0<Character>> s9(@yt.k final CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return new i0(new ik.a<Iterator<? extends Character>>() { // from class: kotlin.text.StringsKt___StringsKt$withIndex$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<Character> o() {
                return StringsKt__StringsKt.C3(charSequence);
            }
        });
    }

    @v0(version = "1.3")
    @yt.k
    public static final <V, M extends Map<? super Character, ? super V>> M t6(@yt.k CharSequence charSequence, @yt.k M destination, @yt.k ik.l<? super Character, ? extends V> valueSelector) {
        f0.p(charSequence, "<this>");
        f0.p(destination, "destination");
        f0.p(valueSelector, "valueSelector");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            char cCharAt = charSequence.charAt(i10);
            destination.put(Character.valueOf(cCharAt), valueSelector.i(Character.valueOf(cCharAt)));
        }
        return destination;
    }

    public static final int t7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                if (predicate.i(Character.valueOf(charSequence.charAt(length))).booleanValue()) {
                    return length;
                }
                if (i10 < 0) {
                    break;
                }
                length = i10;
            }
        }
        return -1;
    }

    public static final char t8(@yt.k CharSequence charSequence, @yt.k ik.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        if (charSequence.length() == 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            cCharAt = operation.A(Integer.valueOf(iB), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(iB))).charValue();
        }
        return cCharAt;
    }

    @yt.k
    public static final List<Pair<Character, Character>> t9(@yt.k CharSequence charSequence, @yt.k CharSequence other) {
        f0.p(charSequence, "<this>");
        f0.p(other, "other");
        int iMin = Math.min(charSequence.length(), other.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(kotlin.d1.a(Character.valueOf(charSequence.charAt(i10)), Character.valueOf(other.charAt(i10))));
        }
        return arrayList;
    }

    @v0(version = "1.2")
    @yt.k
    public static final List<String> u6(@yt.k CharSequence charSequence, int i10) {
        f0.p(charSequence, "<this>");
        return k9(charSequence, i10, i10, true);
    }

    public static final char u7(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        return charSequence.charAt(StringsKt__StringsKt.j3(charSequence));
    }

    @v0(version = "1.4")
    @yt.l
    public static final Character u8(@yt.k CharSequence charSequence, @yt.k ik.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            int iB = it2.b();
            cCharAt = operation.A(Integer.valueOf(iB), Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(iB))).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    @yt.k
    public static final <V> List<V> u9(@yt.k CharSequence charSequence, @yt.k CharSequence other, @yt.k ik.p<? super Character, ? super Character, ? extends V> transform) {
        f0.p(charSequence, "<this>");
        f0.p(other, "other");
        f0.p(transform, "transform");
        int iMin = Math.min(charSequence.length(), other.length());
        ArrayList arrayList = new ArrayList(iMin);
        for (int i10 = 0; i10 < iMin; i10++) {
            arrayList.add(transform.r0(Character.valueOf(charSequence.charAt(i10)), Character.valueOf(other.charAt(i10))));
        }
        return arrayList;
    }

    @v0(version = "1.2")
    @yt.k
    public static final <R> List<R> v6(@yt.k CharSequence charSequence, int i10, @yt.k ik.l<? super CharSequence, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        return l9(charSequence, i10, i10, true, transform);
    }

    public static final char v7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length >= 0) {
            while (true) {
                int i10 = length - 1;
                char cCharAt = charSequence.charAt(length);
                if (!predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                    if (i10 < 0) {
                        break;
                    }
                    length = i10;
                } else {
                    return cCharAt;
                }
            }
        }
        throw new NoSuchElementException("Char sequence contains no character matching the predicate.");
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.l
    public static final Character v8(@yt.k CharSequence charSequence, @yt.k ik.p<? super Character, ? super Character, Character> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        if (charSequence.length() == 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(0);
        k0 it2 = new qk.m(1, StringsKt__StringsKt.j3(charSequence)).iterator();
        while (it2.hasNext()) {
            cCharAt = operation.r0(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(it2.b()))).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    @v0(version = "1.2")
    @yt.k
    public static final List<Pair<Character, Character>> v9(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(length);
        int i10 = 0;
        while (i10 < length) {
            char cCharAt = charSequence.charAt(i10);
            i10++;
            arrayList.add(kotlin.d1.a(Character.valueOf(cCharAt), Character.valueOf(charSequence.charAt(i10))));
        }
        return arrayList;
    }

    @v0(version = "1.2")
    @yt.k
    public static final kotlin.sequences.m<String> w6(@yt.k CharSequence charSequence, int i10) {
        f0.p(charSequence, "<this>");
        return x6(charSequence, i10, new ik.l<CharSequence, String>() { // from class: kotlin.text.StringsKt___StringsKt$chunkedSequence$1
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String i(@yt.k CharSequence it2) {
                f0.p(it2, "it");
                return it2.toString();
            }
        });
    }

    @yt.l
    public static final Character w7(@yt.k CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        if (charSequence.length() == 0) {
            return null;
        }
        return Character.valueOf(charSequence.charAt(charSequence.length() - 1));
    }

    public static final char w8(@yt.k CharSequence charSequence, @yt.k ik.p<? super Character, ? super Character, Character> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        int iJ3 = StringsKt__StringsKt.j3(charSequence);
        if (iJ3 < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(iJ3);
        for (int i10 = iJ3 - 1; i10 >= 0; i10--) {
            cCharAt = operation.r0(Character.valueOf(charSequence.charAt(i10)), Character.valueOf(cCharAt)).charValue();
        }
        return cCharAt;
    }

    @v0(version = "1.2")
    @yt.k
    public static final <R> List<R> w9(@yt.k CharSequence charSequence, @yt.k ik.p<? super Character, ? super Character, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        int length = charSequence.length() - 1;
        if (length < 1) {
            return CollectionsKt__CollectionsKt.E();
        }
        ArrayList arrayList = new ArrayList(length);
        int i10 = 0;
        while (i10 < length) {
            Character chValueOf = Character.valueOf(charSequence.charAt(i10));
            i10++;
            arrayList.add(transform.r0(chValueOf, Character.valueOf(charSequence.charAt(i10))));
        }
        return arrayList;
    }

    @v0(version = "1.2")
    @yt.k
    public static final <R> kotlin.sequences.m<R> x6(@yt.k CharSequence charSequence, int i10, @yt.k ik.l<? super CharSequence, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        return p9(charSequence, i10, i10, true, transform);
    }

    @yt.l
    public static final Character x7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int length = charSequence.length() - 1;
        if (length < 0) {
            return null;
        }
        while (true) {
            int i10 = length - 1;
            char cCharAt = charSequence.charAt(length);
            if (predicate.i(Character.valueOf(cCharAt)).booleanValue()) {
                return Character.valueOf(cCharAt);
            }
            if (i10 < 0) {
                return null;
            }
            length = i10;
        }
    }

    public static final char x8(@yt.k CharSequence charSequence, @yt.k ik.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        int iJ3 = StringsKt__StringsKt.j3(charSequence);
        if (iJ3 < 0) {
            throw new UnsupportedOperationException("Empty char sequence can't be reduced.");
        }
        char cCharAt = charSequence.charAt(iJ3);
        for (int i10 = iJ3 - 1; i10 >= 0; i10--) {
            cCharAt = operation.A(Integer.valueOf(i10), Character.valueOf(charSequence.charAt(i10)), Character.valueOf(cCharAt)).charValue();
        }
        return cCharAt;
    }

    @bk.f
    public static final int y6(CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return charSequence.length();
    }

    @yt.k
    public static final <R> List<R> y7(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            arrayList.add(transform.i(Character.valueOf(charSequence.charAt(i10))));
        }
        return arrayList;
    }

    @v0(version = "1.4")
    @yt.l
    public static final Character y8(@yt.k CharSequence charSequence, @yt.k ik.q<? super Integer, ? super Character, ? super Character, Character> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        int iJ3 = StringsKt__StringsKt.j3(charSequence);
        if (iJ3 < 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(iJ3);
        for (int i10 = iJ3 - 1; i10 >= 0; i10--) {
            cCharAt = operation.A(Integer.valueOf(i10), Character.valueOf(charSequence.charAt(i10)), Character.valueOf(cCharAt)).charValue();
        }
        return Character.valueOf(cCharAt);
    }

    public static final int z6(@yt.k CharSequence charSequence, @yt.k ik.l<? super Character, Boolean> predicate) {
        f0.p(charSequence, "<this>");
        f0.p(predicate, "predicate");
        int i10 = 0;
        for (int i11 = 0; i11 < charSequence.length(); i11++) {
            if (predicate.i(Character.valueOf(charSequence.charAt(i11))).booleanValue()) {
                i10++;
            }
        }
        return i10;
    }

    @yt.k
    public static final <R> List<R> z7(@yt.k CharSequence charSequence, @yt.k ik.p<? super Integer, ? super Character, ? extends R> transform) {
        f0.p(charSequence, "<this>");
        f0.p(transform, "transform");
        ArrayList arrayList = new ArrayList(charSequence.length());
        int i10 = 0;
        int i11 = 0;
        while (i10 < charSequence.length()) {
            arrayList.add(transform.r0(Integer.valueOf(i11), Character.valueOf(charSequence.charAt(i10))));
            i10++;
            i11++;
        }
        return arrayList;
    }

    @c2(markerClass = {kotlin.q.class})
    @v0(version = "1.4")
    @yt.l
    public static final Character z8(@yt.k CharSequence charSequence, @yt.k ik.p<? super Character, ? super Character, Character> operation) {
        f0.p(charSequence, "<this>");
        f0.p(operation, "operation");
        int iJ3 = StringsKt__StringsKt.j3(charSequence);
        if (iJ3 < 0) {
            return null;
        }
        char cCharAt = charSequence.charAt(iJ3);
        for (int i10 = iJ3 - 1; i10 >= 0; i10--) {
            cCharAt = operation.r0(Character.valueOf(charSequence.charAt(i10)), Character.valueOf(cCharAt)).charValue();
        }
        return Character.valueOf(cCharAt);
    }
}
