package androidx.activity;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nActivityViewModelLazy.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ActivityViewModelLazy.kt\nandroidx/activity/ActivityViewModelLazyKt$viewModels$4\n*L\n1#1,90:1\n*E\n"})
public final class ActivityViewModelLazyKt$viewModels$4 extends Lambda implements ik.a<p1.a> {
    public final /* synthetic */ ik.a<p1.a> $extrasProducer;
    public final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ActivityViewModelLazyKt$viewModels$4(ik.a<? extends p1.a> aVar, ComponentActivity componentActivity) {
        super(0);
        this.$extrasProducer = aVar;
        this.$this_viewModels = componentActivity;
    }

    @Override // ik.a
    @yt.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final p1.a o() {
        p1.a aVarO;
        ik.a<p1.a> aVar = this.$extrasProducer;
        if (aVar != null && (aVarO = aVar.o()) != null) {
            return aVarO;
        }
        p1.a aVarJ0 = this.$this_viewModels.j0();
        f0.o(aVarJ0, "this.defaultViewModelCreationExtras");
        return aVarJ0;
    }
}
