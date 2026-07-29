package kotlinx.coroutines.flow.internal;

import ik.p;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.c2;
import kotlinx.coroutines.channels.q;
import kotlinx.coroutines.o0;

/* JADX INFO: loaded from: classes5.dex */
public final class ChannelFlowMerge$collectTo$2<T> implements kotlinx.coroutines.flow.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c2 f38679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlinx.coroutines.sync.b f38680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q<T> f38681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ m<T> f38682d;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1, reason: invalid class name */
    @zj.d(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements p<o0, kotlin.coroutines.c<? super z1>, Object> {
        public final /* synthetic */ m<T> $collector;
        public final /* synthetic */ kotlinx.coroutines.flow.e<T> $inner;
        public final /* synthetic */ kotlinx.coroutines.sync.b $semaphore;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(kotlinx.coroutines.flow.e<? extends T> eVar, m<T> mVar, kotlinx.coroutines.sync.b bVar, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$inner = eVar;
            this.$collector = mVar;
            this.$semaphore = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.k
        public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$inner, this.$collector, this.$semaphore, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @yt.l
        public final Object q0(@yt.k Object obj) throws Throwable {
            Object objH = yj.b.h();
            int i10 = this.label;
            try {
                if (i10 == 0) {
                    u0.n(obj);
                    kotlinx.coroutines.flow.e<T> eVar = this.$inner;
                    m<T> mVar = this.$collector;
                    this.label = 1;
                    if (eVar.a(mVar, this) == objH) {
                        return objH;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u0.n(obj);
                }
                this.$semaphore.release();
                return z1.f38230a;
            } catch (Throwable th2) {
                this.$semaphore.release();
                throw th2;
            }
        }

        @Override // ik.p
        @yt.l
        /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
        public final Object r0(@yt.k o0 o0Var, @yt.l kotlin.coroutines.c<? super z1> cVar) {
            return ((AnonymousClass1) M(o0Var, cVar)).q0(z1.f38230a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge$collectTo$2(c2 c2Var, kotlinx.coroutines.sync.b bVar, q<? super T> qVar, m<T> mVar) {
        this.f38679a = c2Var;
        this.f38680b = bVar;
        this.f38681c = qVar;
        this.f38682d = mVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.f
    @yt.l
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(@yt.k kotlinx.coroutines.flow.e<? extends T> r8, @yt.k kotlin.coroutines.c<? super kotlin.z1> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1 r0 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$emit$1
            r0.<init>(r7, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.e r8 = (kotlinx.coroutines.flow.e) r8
            java.lang.Object r0 = r0.L$0
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2 r0 = (kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2) r0
            kotlin.u0.n(r9)
            goto L53
        L31:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L39:
            kotlin.u0.n(r9)
            kotlinx.coroutines.c2 r9 = r7.f38679a
            if (r9 == 0) goto L43
            kotlinx.coroutines.f2.A(r9)
        L43:
            kotlinx.coroutines.sync.b r9 = r7.f38680b
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r9 = r9.d(r0)
            if (r9 != r1) goto L52
            return r1
        L52:
            r0 = r7
        L53:
            kotlinx.coroutines.channels.q<T> r1 = r0.f38681c
            r2 = 0
            r3 = 0
            kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1 r4 = new kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1
            kotlinx.coroutines.flow.internal.m<T> r9 = r0.f38682d
            kotlinx.coroutines.sync.b r0 = r0.f38680b
            r5 = 0
            r4.<init>(r8, r9, r0, r5)
            r5 = 3
            r6 = 0
            kotlinx.coroutines.h.e(r1, r2, r3, r4, r5, r6)
            kotlin.z1 r8 = kotlin.z1.f38230a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2.f(kotlinx.coroutines.flow.e, kotlin.coroutines.c):java.lang.Object");
    }
}
