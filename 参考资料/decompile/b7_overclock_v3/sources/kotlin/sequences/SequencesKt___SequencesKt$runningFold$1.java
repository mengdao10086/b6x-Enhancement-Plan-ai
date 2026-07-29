package kotlin.sequences;

import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1}, l = {2290, 2294}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator"}, s = {"L$0", "L$0", "L$1"})
public final class SequencesKt___SequencesKt$runningFold$1<R> extends RestrictedSuspendLambda implements ik.p<o<? super R>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ R $initial;
    public final /* synthetic */ ik.p<R, T, R> $operation;
    public final /* synthetic */ m<T> $this_runningFold;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningFold$1(R r10, m<? extends T> mVar, ik.p<? super R, ? super T, ? extends R> pVar, kotlin.coroutines.c<? super SequencesKt___SequencesKt$runningFold$1> cVar) {
        super(2, cVar);
        this.$initial = r10;
        this.$this_runningFold = mVar;
        this.$operation = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1 = new SequencesKt___SequencesKt$runningFold$1(this.$initial, this.$this_runningFold, this.$operation, cVar);
        sequencesKt___SequencesKt$runningFold$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFold$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2d
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r1 = r7.L$2
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r7.L$1
            java.lang.Object r4 = r7.L$0
            kotlin.sequences.o r4 = (kotlin.sequences.o) r4
            kotlin.u0.n(r8)
            r8 = r3
            goto L4c
        L1d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L25:
            java.lang.Object r1 = r7.L$0
            kotlin.sequences.o r1 = (kotlin.sequences.o) r1
            kotlin.u0.n(r8)
            goto L42
        L2d:
            kotlin.u0.n(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlin.sequences.o r1 = (kotlin.sequences.o) r1
            R r8 = r7.$initial
            r7.L$0 = r1
            r7.label = r3
            java.lang.Object r8 = r1.a(r8, r7)
            if (r8 != r0) goto L42
            return r0
        L42:
            R r8 = r7.$initial
            kotlin.sequences.m<T> r3 = r7.$this_runningFold
            java.util.Iterator r3 = r3.iterator()
            r4 = r1
            r1 = r3
        L4c:
            r3 = r7
        L4d:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L6c
            java.lang.Object r5 = r1.next()
            ik.p<R, T, R> r6 = r3.$operation
            java.lang.Object r8 = r6.r0(r8, r5)
            r3.L$0 = r4
            r3.L$1 = r8
            r3.L$2 = r1
            r3.label = r2
            java.lang.Object r5 = r4.a(r8, r3)
            if (r5 != r0) goto L4d
            return r0
        L6c:
            kotlin.z1 r8 = kotlin.z1.f38230a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFold$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o<? super R> oVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((SequencesKt___SequencesKt$runningFold$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
