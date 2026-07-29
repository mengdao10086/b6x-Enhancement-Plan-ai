package kotlin.sequences;

import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2318, 2323}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
public final class SequencesKt___SequencesKt$runningFoldIndexed$1<R> extends RestrictedSuspendLambda implements ik.p<o<? super R>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ R $initial;
    public final /* synthetic */ ik.q<Integer, R, T, R> $operation;
    public final /* synthetic */ m<T> $this_runningFoldIndexed;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningFoldIndexed$1(R r10, m<? extends T> mVar, ik.q<? super Integer, ? super R, ? super T, ? extends R> qVar, kotlin.coroutines.c<? super SequencesKt___SequencesKt$runningFoldIndexed$1> cVar) {
        super(2, cVar);
        this.$initial = r10;
        this.$this_runningFoldIndexed = mVar;
        this.$operation = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, cVar);
        sequencesKt___SequencesKt$runningFoldIndexed$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = yj.b.h()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 == r3) goto L28
            if (r1 != r2) goto L20
            int r1 = r9.I$0
            java.lang.Object r3 = r9.L$2
            java.util.Iterator r3 = (java.util.Iterator) r3
            java.lang.Object r4 = r9.L$1
            java.lang.Object r5 = r9.L$0
            kotlin.sequences.o r5 = (kotlin.sequences.o) r5
            kotlin.u0.n(r10)
            r10 = r1
            r1 = r4
            goto L51
        L20:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L28:
            java.lang.Object r1 = r9.L$0
            kotlin.sequences.o r1 = (kotlin.sequences.o) r1
            kotlin.u0.n(r10)
            goto L45
        L30:
            kotlin.u0.n(r10)
            java.lang.Object r10 = r9.L$0
            r1 = r10
            kotlin.sequences.o r1 = (kotlin.sequences.o) r1
            R r10 = r9.$initial
            r9.L$0 = r1
            r9.label = r3
            java.lang.Object r10 = r1.a(r10, r9)
            if (r10 != r0) goto L45
            return r0
        L45:
            r10 = 0
            R r3 = r9.$initial
            kotlin.sequences.m<T> r4 = r9.$this_runningFoldIndexed
            java.util.Iterator r4 = r4.iterator()
            r5 = r1
            r1 = r3
            r3 = r4
        L51:
            r4 = r9
        L52:
            boolean r6 = r3.hasNext()
            if (r6 == 0) goto L81
            java.lang.Object r6 = r3.next()
            ik.q<java.lang.Integer, R, T, R> r7 = r4.$operation
            int r8 = r10 + 1
            if (r10 >= 0) goto L65
            kotlin.collections.CollectionsKt__CollectionsKt.W()
        L65:
            java.lang.Integer r10 = zj.a.f(r10)
            java.lang.Object r10 = r7.A(r10, r1, r6)
            r4.L$0 = r5
            r4.L$1 = r10
            r4.L$2 = r3
            r4.I$0 = r8
            r4.label = r2
            java.lang.Object r1 = r5.a(r10, r4)
            if (r1 != r0) goto L7e
            return r0
        L7e:
            r1 = r10
            r10 = r8
            goto L52
        L81:
            kotlin.z1 r10 = kotlin.z1.f38230a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o<? super R> oVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
