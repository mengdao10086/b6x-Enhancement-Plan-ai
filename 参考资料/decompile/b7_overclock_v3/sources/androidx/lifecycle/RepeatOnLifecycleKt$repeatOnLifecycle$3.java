package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;
import kotlinx.coroutines.m2;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> $block;
    public final /* synthetic */ Lifecycle.State $state;
    public final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    @kotlin.jvm.internal.t0({"SMAP\nRepeatOnLifecycle.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,165:1\n314#2,11:166\n*S KotlinDebug\n*F\n+ 1 RepeatOnLifecycle.kt\nandroidx/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1\n*L\n97#1:166,11\n*E\n"})
    @zj.d(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {166}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> {
        public final /* synthetic */ kotlinx.coroutines.o0 $$this$coroutineScope;
        public final /* synthetic */ ik.p<kotlinx.coroutines.o0, kotlin.coroutines.c<? super z1>, Object> $block;
        public final /* synthetic */ Lifecycle.State $state;
        public final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public Object L$4;
        public Object L$5;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, kotlinx.coroutines.o0 o0Var, ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$$this$coroutineScope = o0Var;
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.k
        public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, cVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00cd  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00d7  */
        /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object q0(@yt.k java.lang.Object r17) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 221
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1.q0(java.lang.Object):java.lang.Object");
        }

        @Override // ik.p
        @yt.l
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
            return ((AnonymousClass1) M(o0Var, cVar)).q0(z1.f38230a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, ik.p<? super kotlinx.coroutines.o0, ? super kotlin.coroutines.c<? super z1>, ? extends Object> pVar, kotlin.coroutines.c<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> cVar) {
        super(2, cVar);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, cVar);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.u0.n(obj);
            kotlinx.coroutines.o0 o0Var = (kotlinx.coroutines.o0) this.L$0;
            m2 m2VarO2 = kotlinx.coroutines.d1.e().o2();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, o0Var, this.$block, null);
            this.label = 1;
            if (kotlinx.coroutines.h.h(m2VarO2, anonymousClass1, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.u0.n(obj);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
