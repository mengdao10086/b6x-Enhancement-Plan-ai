package androidx.lifecycle;

import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nWithLifecycleState.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WithLifecycleState.kt\nandroidx/lifecycle/WithLifecycleStateKt$withStateAtLeastUnchecked$2\n*L\n1#1,206:1\n*E\n"})
public final class WithLifecycleStateKt$withStateAtLeastUnchecked$2<R> extends Lambda implements ik.a<R> {
    public final /* synthetic */ ik.a<R> $block;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WithLifecycleStateKt$withStateAtLeastUnchecked$2(ik.a<? extends R> aVar) {
        super(0);
        this.$block = aVar;
    }

    @Override // ik.a
    public final R o() {
        return this.$block.o();
    }
}
