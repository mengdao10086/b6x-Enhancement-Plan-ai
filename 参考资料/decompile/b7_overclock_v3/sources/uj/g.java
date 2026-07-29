package uj;

import ik.p;
import java.util.Comparator;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
public class g {

    @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, Comparable<?>> f52138a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ik.l<? super T, ? extends Comparable<?>> lVar) {
            this.f52138a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            ik.l<T, Comparable<?>> lVar = this.f52138a;
            return g.l(lVar.i(t10), lVar.i(t11));
        }
    }

    @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$3\n*L\n1#1,328:1\n*E\n"})
    public static final class b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f52139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, K> f52140b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Comparator<? super K> comparator, ik.l<? super T, ? extends K> lVar) {
            this.f52139a = comparator;
            this.f52140b = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            Comparator<? super K> comparator = this.f52139a;
            ik.l<T, K> lVar = this.f52140b;
            return comparator.compare((Object) lVar.i(t10), (Object) lVar.i(t11));
        }
    }

    @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1\n*L\n1#1,328:1\n*E\n"})
    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, Comparable<?>> f52141a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(ik.l<? super T, ? extends Comparable<?>> lVar) {
            this.f52141a = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            ik.l<T, Comparable<?>> lVar = this.f52141a;
            return g.l(lVar.i(t11), lVar.i(t10));
        }
    }

    @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$2\n*L\n1#1,328:1\n*E\n"})
    public static final class d<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f52142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, K> f52143b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Comparator<? super K> comparator, ik.l<? super T, ? extends K> lVar) {
            this.f52142a = comparator;
            this.f52143b = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            Comparator<? super K> comparator = this.f52142a;
            ik.l<T, K> lVar = this.f52143b;
            return comparator.compare((Object) lVar.i(t11), (Object) lVar.i(t10));
        }
    }

    @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1\n*L\n1#1,328:1\n*E\n"})
    public static final class e<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f52144a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, Comparable<?>> f52145b;

        /* JADX WARN: Multi-variable type inference failed */
        public e(Comparator<T> comparator, ik.l<? super T, ? extends Comparable<?>> lVar) {
            this.f52144a = comparator;
            this.f52145b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f52144a.compare(t10, t11);
            if (iCompare != 0) {
                return iCompare;
            }
            ik.l<T, Comparable<?>> lVar = this.f52145b;
            return g.l(lVar.i(t10), lVar.i(t11));
        }
    }

    @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$2\n*L\n1#1,328:1\n*E\n"})
    public static final class f<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f52146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f52147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, K> f52148c;

        /* JADX WARN: Multi-variable type inference failed */
        public f(Comparator<T> comparator, Comparator<? super K> comparator2, ik.l<? super T, ? extends K> lVar) {
            this.f52146a = comparator;
            this.f52147b = comparator2;
            this.f52148c = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f52146a.compare(t10, t11);
            if (iCompare != 0) {
                return iCompare;
            }
            Comparator<? super K> comparator = this.f52147b;
            ik.l<T, K> lVar = this.f52148c;
            return comparator.compare((Object) lVar.i(t10), (Object) lVar.i(t11));
        }
    }

    /* JADX INFO: renamed from: uj.g$g, reason: collision with other inner class name */
    @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1\n*L\n1#1,328:1\n*E\n"})
    public static final class C0602g<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f52149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, Comparable<?>> f52150b;

        /* JADX WARN: Multi-variable type inference failed */
        public C0602g(Comparator<T> comparator, ik.l<? super T, ? extends Comparable<?>> lVar) {
            this.f52149a = comparator;
            this.f52150b = lVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f52149a.compare(t10, t11);
            if (iCompare != 0) {
                return iCompare;
            }
            ik.l<T, Comparable<?>> lVar = this.f52150b;
            return g.l(lVar.i(t11), lVar.i(t10));
        }
    }

    @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$2\n*L\n1#1,328:1\n*E\n"})
    public static final class h<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f52151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Comparator<? super K> f52152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ik.l<T, K> f52153c;

        /* JADX WARN: Multi-variable type inference failed */
        public h(Comparator<T> comparator, Comparator<? super K> comparator2, ik.l<? super T, ? extends K> lVar) {
            this.f52151a = comparator;
            this.f52152b = comparator2;
            this.f52153c = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f52151a.compare(t10, t11);
            if (iCompare != 0) {
                return iCompare;
            }
            Comparator<? super K> comparator = this.f52152b;
            ik.l<T, K> lVar = this.f52153c;
            return comparator.compare((Object) lVar.i(t11), (Object) lVar.i(t10));
        }
    }

    @t0({"SMAP\nComparisons.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Comparisons.kt\nkotlin/comparisons/ComparisonsKt__ComparisonsKt$thenComparator$1\n*L\n1#1,328:1\n*E\n"})
    public static final class i<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator<T> f52154a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ p<T, T, Integer> f52155b;

        /* JADX WARN: Multi-variable type inference failed */
        public i(Comparator<T> comparator, p<? super T, ? super T, Integer> pVar) {
            this.f52154a = comparator;
            this.f52155b = pVar;
        }

        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int iCompare = this.f52154a.compare(t10, t11);
            return iCompare != 0 ? iCompare : this.f52155b.r0(t10, t11).intValue();
        }
    }

    public static final int A(Comparator this_then, Comparator comparator, Object obj, Object obj2) {
        f0.p(this_then, "$this_then");
        f0.p(comparator, "$comparator");
        int iCompare = this_then.compare(obj, obj2);
        return iCompare != 0 ? iCompare : comparator.compare(obj, obj2);
    }

    @bk.f
    public static final <T> Comparator<T> B(Comparator<T> comparator, ik.l<? super T, ? extends Comparable<?>> selector) {
        f0.p(comparator, "<this>");
        f0.p(selector, "selector");
        return new e(comparator, selector);
    }

    @bk.f
    public static final <T, K> Comparator<T> C(Comparator<T> comparator, Comparator<? super K> comparator2, ik.l<? super T, ? extends K> selector) {
        f0.p(comparator, "<this>");
        f0.p(comparator2, "comparator");
        f0.p(selector, "selector");
        return new f(comparator, comparator2, selector);
    }

    @bk.f
    public static final <T> Comparator<T> D(Comparator<T> comparator, ik.l<? super T, ? extends Comparable<?>> selector) {
        f0.p(comparator, "<this>");
        f0.p(selector, "selector");
        return new C0602g(comparator, selector);
    }

    @bk.f
    public static final <T, K> Comparator<T> E(Comparator<T> comparator, Comparator<? super K> comparator2, ik.l<? super T, ? extends K> selector) {
        f0.p(comparator, "<this>");
        f0.p(comparator2, "comparator");
        f0.p(selector, "selector");
        return new h(comparator, comparator2, selector);
    }

    @bk.f
    public static final <T> Comparator<T> F(Comparator<T> comparator, p<? super T, ? super T, Integer> comparison) {
        f0.p(comparator, "<this>");
        f0.p(comparison, "comparison");
        return new i(comparator, comparison);
    }

    @yt.k
    public static final <T> Comparator<T> G(@yt.k final Comparator<T> comparator, @yt.k final Comparator<? super T> comparator2) {
        f0.p(comparator, "<this>");
        f0.p(comparator2, "comparator");
        return new Comparator() { // from class: uj.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return g.H(comparator, comparator2, obj, obj2);
            }
        };
    }

    public static final int H(Comparator this_thenDescending, Comparator comparator, Object obj, Object obj2) {
        f0.p(this_thenDescending, "$this_thenDescending");
        f0.p(comparator, "$comparator");
        int iCompare = this_thenDescending.compare(obj, obj2);
        return iCompare != 0 ? iCompare : comparator.compare(obj2, obj);
    }

    @bk.f
    public static final <T> Comparator<T> f(ik.l<? super T, ? extends Comparable<?>> selector) {
        f0.p(selector, "selector");
        return new a(selector);
    }

    @bk.f
    public static final <T, K> Comparator<T> g(Comparator<? super K> comparator, ik.l<? super T, ? extends K> selector) {
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        return new b(comparator, selector);
    }

    @yt.k
    public static final <T> Comparator<T> h(@yt.k final ik.l<? super T, ? extends Comparable<?>>... selectors) {
        f0.p(selectors, "selectors");
        if (selectors.length > 0) {
            return new Comparator() { // from class: uj.f
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return g.i(selectors, obj, obj2);
                }
            };
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final int i(ik.l[] selectors, Object obj, Object obj2) {
        f0.p(selectors, "$selectors");
        return p(obj, obj2, selectors);
    }

    @bk.f
    public static final <T> Comparator<T> j(ik.l<? super T, ? extends Comparable<?>> selector) {
        f0.p(selector, "selector");
        return new c(selector);
    }

    @bk.f
    public static final <T, K> Comparator<T> k(Comparator<? super K> comparator, ik.l<? super T, ? extends K> selector) {
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        return new d(comparator, selector);
    }

    public static final <T extends Comparable<?>> int l(@yt.l T t10, @yt.l T t11) {
        if (t10 == t11) {
            return 0;
        }
        if (t10 == null) {
            return -1;
        }
        if (t11 == null) {
            return 1;
        }
        return t10.compareTo(t11);
    }

    @bk.f
    public static final <T> int m(T t10, T t11, ik.l<? super T, ? extends Comparable<?>> selector) {
        f0.p(selector, "selector");
        return l(selector.i(t10), selector.i(t11));
    }

    @bk.f
    public static final <T, K> int n(T t10, T t11, Comparator<? super K> comparator, ik.l<? super T, ? extends K> selector) {
        f0.p(comparator, "comparator");
        f0.p(selector, "selector");
        return comparator.compare(selector.i(t10), selector.i(t11));
    }

    public static final <T> int o(T t10, T t11, @yt.k ik.l<? super T, ? extends Comparable<?>>... selectors) {
        f0.p(selectors, "selectors");
        if (selectors.length > 0) {
            return p(t10, t11, selectors);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final <T> int p(T t10, T t11, ik.l<? super T, ? extends Comparable<?>>[] lVarArr) {
        for (ik.l<? super T, ? extends Comparable<?>> lVar : lVarArr) {
            int iL = l(lVar.i(t10), lVar.i(t11));
            if (iL != 0) {
                return iL;
            }
        }
        return 0;
    }

    @yt.k
    public static final <T extends Comparable<? super T>> Comparator<T> q() {
        j jVar = j.f52156a;
        f0.n(jVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return jVar;
    }

    @bk.f
    public static final <T extends Comparable<? super T>> Comparator<T> r() {
        return s(q());
    }

    @yt.k
    public static final <T> Comparator<T> s(@yt.k final Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return new Comparator() { // from class: uj.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return g.t(comparator, obj, obj2);
            }
        };
    }

    public static final int t(Comparator comparator, Object obj, Object obj2) {
        f0.p(comparator, "$comparator");
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return comparator.compare(obj, obj2);
    }

    @bk.f
    public static final <T extends Comparable<? super T>> Comparator<T> u() {
        return v(q());
    }

    @yt.k
    public static final <T> Comparator<T> v(@yt.k final Comparator<? super T> comparator) {
        f0.p(comparator, "comparator");
        return new Comparator() { // from class: uj.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return g.w(comparator, obj, obj2);
            }
        };
    }

    public static final int w(Comparator comparator, Object obj, Object obj2) {
        f0.p(comparator, "$comparator");
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return comparator.compare(obj, obj2);
    }

    @yt.k
    public static final <T extends Comparable<? super T>> Comparator<T> x() {
        k kVar = k.f52157a;
        f0.n(kVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reverseOrder> }");
        return kVar;
    }

    @yt.k
    public static final <T> Comparator<T> y(@yt.k Comparator<T> comparator) {
        f0.p(comparator, "<this>");
        if (comparator instanceof l) {
            return ((l) comparator).a();
        }
        Comparator<T> lVar = j.f52156a;
        if (f0.g(comparator, lVar)) {
            k kVar = k.f52157a;
            f0.n(kVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
            return kVar;
        }
        if (f0.g(comparator, k.f52157a)) {
            f0.n(lVar, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.reversed> }");
        } else {
            lVar = new l<>(comparator);
        }
        return lVar;
    }

    @yt.k
    public static final <T> Comparator<T> z(@yt.k final Comparator<T> comparator, @yt.k final Comparator<? super T> comparator2) {
        f0.p(comparator, "<this>");
        f0.p(comparator2, "comparator");
        return new Comparator() { // from class: uj.e
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return g.A(comparator, comparator2, obj, obj2);
            }
        };
    }
}
