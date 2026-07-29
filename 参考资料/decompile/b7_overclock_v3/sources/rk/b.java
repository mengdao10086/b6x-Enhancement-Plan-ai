package rk;

import hk.h;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.sequences.m;
import kotlin.v0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@h(name = "StreamsKt")
public final class b {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n31#2:681\n*E\n"})
    public static final class a<T> implements m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Stream f48789a;

        public a(Stream stream) {
            this.f48789a = stream;
        }

        @Override // kotlin.sequences.m
        @k
        public Iterator<T> iterator() {
            Iterator<T> it2 = this.f48789a.iterator();
            f0.o(it2, "iterator()");
            return it2;
        }
    }

    /* JADX INFO: renamed from: rk.b$b, reason: collision with other inner class name */
    @t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n39#2:681\n*E\n"})
    public static final class C0560b implements m<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IntStream f48790a;

        public C0560b(IntStream intStream) {
            this.f48790a = intStream;
        }

        @Override // kotlin.sequences.m
        @k
        public Iterator<Integer> iterator() {
            Iterator<Integer> it2 = this.f48790a.iterator();
            f0.o(it2, "iterator()");
            return it2;
        }
    }

    @t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n47#2:681\n*E\n"})
    public static final class c implements m<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LongStream f48791a;

        public c(LongStream longStream) {
            this.f48791a = longStream;
        }

        @Override // kotlin.sequences.m
        @k
        public Iterator<Long> iterator() {
            Iterator<Long> it2 = this.f48791a.iterator();
            f0.o(it2, "iterator()");
            return it2;
        }
    }

    @t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 Streams.kt\nkotlin/streams/jdk8/StreamsKt\n*L\n1#1,680:1\n55#2:681\n*E\n"})
    public static final class d implements m<Double> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleStream f48792a;

        public d(DoubleStream doubleStream) {
            this.f48792a = doubleStream;
        }

        @Override // kotlin.sequences.m
        @k
        public Iterator<Double> iterator() {
            Iterator<Double> it2 = this.f48792a.iterator();
            f0.o(it2, "iterator()");
            return it2;
        }
    }

    @v0(version = "1.2")
    @k
    public static final m<Double> b(@k DoubleStream doubleStream) {
        f0.p(doubleStream, "<this>");
        return new d(doubleStream);
    }

    @v0(version = "1.2")
    @k
    public static final m<Integer> c(@k IntStream intStream) {
        f0.p(intStream, "<this>");
        return new C0560b(intStream);
    }

    @v0(version = "1.2")
    @k
    public static final m<Long> d(@k LongStream longStream) {
        f0.p(longStream, "<this>");
        return new c(longStream);
    }

    @v0(version = "1.2")
    @k
    public static final <T> m<T> e(@k Stream<T> stream) {
        f0.p(stream, "<this>");
        return new a(stream);
    }

    @v0(version = "1.2")
    @k
    public static final <T> Stream<T> f(@k final m<? extends T> mVar) {
        f0.p(mVar, "<this>");
        Stream<T> stream = StreamSupport.stream(new Supplier() { // from class: rk.a
            @Override // java.util.function.Supplier
            public final Object get() {
                return b.g(mVar);
            }
        }, 16, false);
        f0.o(stream, "stream({ Spliterators.sp…literator.ORDERED, false)");
        return stream;
    }

    public static final Spliterator g(m this_asStream) {
        f0.p(this_asStream, "$this_asStream");
        return Spliterators.spliteratorUnknownSize(this_asStream.iterator(), 16);
    }

    @v0(version = "1.2")
    @k
    public static final List<Double> h(@k DoubleStream doubleStream) {
        f0.p(doubleStream, "<this>");
        double[] array = doubleStream.toArray();
        f0.o(array, "toArray()");
        return kotlin.collections.m.p(array);
    }

    @v0(version = "1.2")
    @k
    public static final List<Integer> i(@k IntStream intStream) {
        f0.p(intStream, "<this>");
        int[] array = intStream.toArray();
        f0.o(array, "toArray()");
        return kotlin.collections.m.r(array);
    }

    @v0(version = "1.2")
    @k
    public static final List<Long> j(@k LongStream longStream) {
        f0.p(longStream, "<this>");
        long[] array = longStream.toArray();
        f0.o(array, "toArray()");
        return kotlin.collections.m.s(array);
    }

    @v0(version = "1.2")
    @k
    public static final <T> List<T> k(@k Stream<T> stream) {
        f0.p(stream, "<this>");
        Object objCollect = stream.collect(Collectors.toList());
        f0.o(objCollect, "collect(Collectors.toList<T>())");
        return (List) objCollect;
    }
}
