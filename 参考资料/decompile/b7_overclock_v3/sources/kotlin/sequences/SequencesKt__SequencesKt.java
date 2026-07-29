package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.d1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.random.Random;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public class SequencesKt__SequencesKt extends r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n*L\n1#1,680:1\n*E\n"})
    public static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.a<Iterator<T>> f38030a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(ik.a<? extends Iterator<? extends T>> aVar) {
            this.f38030a = aVar;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<T> iterator() {
            return this.f38030a.o();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt\n*L\n1#1,680:1\n30#2:681\n*E\n"})
    public static final class b<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f38031a;

        public b(Iterator it2) {
            this.f38031a = it2;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<T> iterator() {
            return this.f38031a;
        }
    }

    @bk.f
    public static final <T> m<T> d(ik.a<? extends Iterator<? extends T>> iterator) {
        f0.p(iterator, "iterator");
        return new a(iterator);
    }

    @yt.k
    public static final <T> m<T> e(@yt.k Iterator<? extends T> it2) {
        f0.p(it2, "<this>");
        return f(new b(it2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @yt.k
    public static final <T> m<T> f(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return mVar instanceof kotlin.sequences.a ? mVar : new kotlin.sequences.a(mVar);
    }

    @yt.k
    public static final <T> m<T> g() {
        return g.f38075a;
    }

    @yt.k
    public static final <T, C, R> m<R> h(@yt.k m<? extends T> source, @yt.k ik.p<? super Integer, ? super T, ? extends C> transform, @yt.k ik.l<? super C, ? extends Iterator<? extends R>> iterator) {
        f0.p(source, "source");
        f0.p(transform, "transform");
        f0.p(iterator, "iterator");
        return q.b(new SequencesKt__SequencesKt$flatMapIndexed$1(source, transform, iterator, null));
    }

    @yt.k
    public static final <T> m<T> i(@yt.k m<? extends m<? extends T>> mVar) {
        f0.p(mVar, "<this>");
        return j(mVar, new ik.l<m<? extends T>, Iterator<? extends T>>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$1
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<T> i(@yt.k m<? extends T> it2) {
                f0.p(it2, "it");
                return it2.iterator();
            }
        });
    }

    public static final <T, R> m<R> j(m<? extends T> mVar, ik.l<? super T, ? extends Iterator<? extends R>> lVar) {
        return mVar instanceof w ? ((w) mVar).e(lVar) : new i(mVar, new ik.l<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$3
            @Override // ik.l
            public final T i(T t10) {
                return t10;
            }
        }, lVar);
    }

    @hk.h(name = "flattenSequenceOfIterable")
    @yt.k
    public static final <T> m<T> k(@yt.k m<? extends Iterable<? extends T>> mVar) {
        f0.p(mVar, "<this>");
        return j(mVar, new ik.l<Iterable<? extends T>, Iterator<? extends T>>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$flatten$2
            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Iterator<T> i(@yt.k Iterable<? extends T> it2) {
                f0.p(it2, "it");
                return it2.iterator();
            }
        });
    }

    @yt.k
    public static final <T> m<T> l(@yt.k final ik.a<? extends T> nextFunction) {
        f0.p(nextFunction, "nextFunction");
        return f(new j(nextFunction, new ik.l<T, T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // ik.l
            @yt.l
            public final T i(@yt.k T it2) {
                f0.p(it2, "it");
                return nextFunction.o();
            }
        }));
    }

    @yt.k
    public static final <T> m<T> m(@yt.k ik.a<? extends T> seedFunction, @yt.k ik.l<? super T, ? extends T> nextFunction) {
        f0.p(seedFunction, "seedFunction");
        f0.p(nextFunction, "nextFunction");
        return new j(seedFunction, nextFunction);
    }

    @yt.k
    @bk.h
    public static final <T> m<T> n(@yt.l final T t10, @yt.k ik.l<? super T, ? extends T> nextFunction) {
        f0.p(nextFunction, "nextFunction");
        return t10 == null ? g.f38075a : new j(new ik.a<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // ik.a
            @yt.l
            public final T o() {
                return t10;
            }
        }, nextFunction);
    }

    @v0(version = "1.3")
    @yt.k
    public static final <T> m<T> o(@yt.k m<? extends T> mVar, @yt.k ik.a<? extends m<? extends T>> defaultValue) {
        f0.p(mVar, "<this>");
        f0.p(defaultValue, "defaultValue");
        return q.b(new SequencesKt__SequencesKt$ifEmpty$1(mVar, defaultValue, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @bk.f
    @v0(version = "1.3")
    public static final <T> m<T> p(m<? extends T> mVar) {
        return mVar == 0 ? g() : mVar;
    }

    @yt.k
    public static final <T> m<T> q(@yt.k T... elements) {
        f0.p(elements, "elements");
        return elements.length == 0 ? g() : ArraysKt___ArraysKt.l6(elements);
    }

    @v0(version = "1.4")
    @yt.k
    public static final <T> m<T> r(@yt.k m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        return s(mVar, Random.f38003a);
    }

    @v0(version = "1.4")
    @yt.k
    public static final <T> m<T> s(@yt.k m<? extends T> mVar, @yt.k Random random) {
        f0.p(mVar, "<this>");
        f0.p(random, "random");
        return q.b(new SequencesKt__SequencesKt$shuffled$1(mVar, random, null));
    }

    @yt.k
    public static final <T, R> Pair<List<T>, List<R>> t(@yt.k m<? extends Pair<? extends T, ? extends R>> mVar) {
        f0.p(mVar, "<this>");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Pair<? extends T, ? extends R> pair : mVar) {
            arrayList.add(pair.f());
            arrayList2.add(pair.h());
        }
        return d1.a(arrayList, arrayList2);
    }
}
