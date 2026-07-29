package kotlin.collections;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class SlidingWindowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @kotlin.jvm.internal.t0({"SMAP\nSequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Sequences.kt\nkotlin/sequences/SequencesKt__SequencesKt$Sequence$1\n+ 2 SlidingWindow.kt\nkotlin/collections/SlidingWindowKt\n*L\n1#1,680:1\n19#2:681\n*E\n"})
    public static final class a<T> implements kotlin.sequences.m<List<? extends T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlin.sequences.m f37670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f37671b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f37672c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f37673d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f37674e;

        public a(kotlin.sequences.m mVar, int i10, int i11, boolean z10, boolean z11) {
            this.f37670a = mVar;
            this.f37671b = i10;
            this.f37672c = i11;
            this.f37673d = z10;
            this.f37674e = z11;
        }

        @Override // kotlin.sequences.m
        @yt.k
        public Iterator<List<? extends T>> iterator() {
            return SlidingWindowKt.b(this.f37670a.iterator(), this.f37671b, this.f37672c, this.f37673d, this.f37674e);
        }
    }

    public static final void a(int i10, int i11) {
        String str;
        if (i10 > 0 && i11 > 0) {
            return;
        }
        if (i10 != i11) {
            str = "Both size " + i10 + " and step " + i11 + " must be greater than zero.";
        } else {
            str = "size " + i10 + " must be greater than zero.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @yt.k
    public static final <T> Iterator<List<T>> b(@yt.k Iterator<? extends T> iterator, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.f0.p(iterator, "iterator");
        return !iterator.hasNext() ? b0.f37692a : kotlin.sequences.q.a(new SlidingWindowKt$windowedIterator$1(i10, i11, iterator, z11, z10, null));
    }

    @yt.k
    public static final <T> kotlin.sequences.m<List<T>> c(@yt.k kotlin.sequences.m<? extends T> mVar, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.f0.p(mVar, "<this>");
        a(i10, i11);
        return new a(mVar, i10, i11, z10, z11);
    }
}
