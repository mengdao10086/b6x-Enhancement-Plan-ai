package kotlin.sequences;

import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2377, 2381}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
public final class SequencesKt___SequencesKt$runningReduceIndexed$1<S> extends RestrictedSuspendLambda implements ik.p<o<? super S>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.q<Integer, S, T, S> $operation;
    public final /* synthetic */ m<T> $this_runningReduceIndexed;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningReduceIndexed$1(m<? extends T> mVar, ik.q<? super Integer, ? super S, ? super T, ? extends S> qVar, kotlin.coroutines.c<? super SequencesKt___SequencesKt$runningReduceIndexed$1> cVar) {
        super(2, cVar);
        this.$this_runningReduceIndexed = mVar;
        this.$operation = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, cVar);
        sequencesKt___SequencesKt$runningReduceIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 == r3) goto L2a
            if (r1 != r2) goto L22
            int r1 = r10.I$0
            java.lang.Object r3 = r10.L$2
            java.lang.Object r4 = r10.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r10.L$0
            kotlin.sequences.o r5 = (kotlin.sequences.o) r5
            kotlin.u0.n(r11)
            r11 = r10
            r9 = r3
            r3 = r1
            r1 = r9
            goto L60
        L22:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L2a:
            java.lang.Object r1 = r10.L$2
            java.lang.Object r4 = r10.L$1
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r10.L$0
            kotlin.sequences.o r5 = (kotlin.sequences.o) r5
            kotlin.u0.n(r11)
            goto L5f
        L38:
            kotlin.u0.n(r11)
            java.lang.Object r11 = r10.L$0
            r5 = r11
            kotlin.sequences.o r5 = (kotlin.sequences.o) r5
            kotlin.sequences.m<T> r11 = r10.$this_runningReduceIndexed
            java.util.Iterator r4 = r11.iterator()
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L8f
            java.lang.Object r1 = r4.next()
            r10.L$0 = r5
            r10.L$1 = r4
            r10.L$2 = r1
            r10.label = r3
            java.lang.Object r11 = r5.a(r1, r10)
            if (r11 != r0) goto L5f
            return r0
        L5f:
            r11 = r10
        L60:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L8f
            ik.q<java.lang.Integer, S, T, S> r6 = r11.$operation
            int r7 = r3 + 1
            if (r3 >= 0) goto L6f
            kotlin.collections.CollectionsKt__CollectionsKt.W()
        L6f:
            java.lang.Integer r3 = zj.a.f(r3)
            java.lang.Object r8 = r4.next()
            java.lang.Object r3 = r6.A(r3, r1, r8)
            r11.L$0 = r5
            r11.L$1 = r4
            r11.L$2 = r3
            r11.I$0 = r7
            r11.label = r2
            java.lang.Object r1 = r5.a(r3, r11)
            if (r1 != r0) goto L8c
            return r0
        L8c:
            r1 = r3
            r3 = r7
            goto L60
        L8f:
            kotlin.z1 r11 = kotlin.z1.f38230a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o<? super S> oVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
