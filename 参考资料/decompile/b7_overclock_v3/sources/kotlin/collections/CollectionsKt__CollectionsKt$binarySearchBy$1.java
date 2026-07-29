package kotlin.collections;

import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nCollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collections.kt\nkotlin/collections/CollectionsKt__CollectionsKt$binarySearchBy$1\n*L\n1#1,471:1\n*E\n"})
public final class CollectionsKt__CollectionsKt$binarySearchBy$1<T> extends Lambda implements ik.l<T, Integer> {

    /* JADX INFO: Incorrect field signature: TK; */
    public final /* synthetic */ Comparable $key;
    public final /* synthetic */ ik.l<T, K> $selector;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lik/l<-TT;+TK;>;TK;)V */
    public CollectionsKt__CollectionsKt$binarySearchBy$1(ik.l lVar, Comparable comparable) {
        super(1);
        this.$selector = lVar;
        this.$key = comparable;
    }

    @Override // ik.l
    @yt.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Integer i(T t10) {
        return Integer.valueOf(uj.g.l((Comparable) this.$selector.i(t10), this.$key));
    }
}
