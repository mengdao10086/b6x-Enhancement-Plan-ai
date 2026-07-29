package kotlinx.coroutines.flow;

import androidx.lifecycle.r0;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import kotlinx.coroutines.o0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n+ 2 Symbol.kt\nkotlinx/coroutines/internal/Symbol\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,405:1\n18#2:406\n18#2:408\n1#3:407\n55#4,8:409\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$debounceInternal$1\n*L\n218#1:406\n221#1:408\n228#1:409,8\n*E\n"})
@zj.d(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1", f = "Delay.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {221, 416}, m = "invokeSuspend", n = {"downstream", r0.f6236g, "lastValue", "timeoutMillis", "downstream", r0.f6236g, "lastValue"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
public final class FlowKt__DelayKt$debounceInternal$1<T> extends SuspendLambda implements ik.q<o0, f<? super T>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ e<T> $this_debounceInternal;
    public final /* synthetic */ ik.l<T, Long> $timeoutMillisSelector;
    private /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$debounceInternal$1(ik.l<? super T, Long> lVar, e<? extends T> eVar, kotlin.coroutines.c<? super FlowKt__DelayKt$debounceInternal$1> cVar) {
        super(3, cVar);
        this.$timeoutMillisSelector = lVar;
        this.$this_debounceInternal = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fa  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00fa -> B:11:0x006b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.q
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object A(@yt.k o0 o0Var, @yt.k f<? super T> fVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        FlowKt__DelayKt$debounceInternal$1 flowKt__DelayKt$debounceInternal$1 = new FlowKt__DelayKt$debounceInternal$1(this.$timeoutMillisSelector, this.$this_debounceInternal, cVar);
        flowKt__DelayKt$debounceInternal$1.L$0 = o0Var;
        flowKt__DelayKt$debounceInternal$1.L$1 = fVar;
        return flowKt__DelayKt$debounceInternal$1.q0(z1.f38230a);
    }
}
