package kotlinx.coroutines;

import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1451:1\n341#2,6:1452\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n*L\n957#1:1452,6\n*E\n"})
@zj.d(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", i = {1, 1, 1}, l = {955, 957}, m = "invokeSuspend", n = {"$this$sequence", "this_$iv", "cur$iv"}, s = {"L$0", "L$1", "L$2"})
public final class JobSupport$children$1 extends RestrictedSuspendLambda implements ik.p<kotlin.sequences.o<? super c2>, kotlin.coroutines.c<? super kotlin.z1>, Object> {
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    public final /* synthetic */ JobSupport this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, kotlin.coroutines.c<? super JobSupport$children$1> cVar) {
        super(2, cVar);
        this.this$0 = jobSupport;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<kotlin.z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.this$0, cVar);
        jobSupport$children$1.L$0 = obj;
        return jobSupport$children$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:27:0x0083). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0080 -> B:27:0x0083). Please report as a decompilation issue!!! */
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
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r1 = r7.L$2
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r1
            java.lang.Object r3 = r7.L$1
            kotlinx.coroutines.internal.u r3 = (kotlinx.coroutines.internal.u) r3
            java.lang.Object r4 = r7.L$0
            kotlin.sequences.o r4 = (kotlin.sequences.o) r4
            kotlin.u0.n(r8)
            r8 = r7
            goto L83
        L1f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L27:
            kotlin.u0.n(r8)
            goto L88
        L2b:
            kotlin.u0.n(r8)
            java.lang.Object r8 = r7.L$0
            kotlin.sequences.o r8 = (kotlin.sequences.o) r8
            kotlinx.coroutines.JobSupport r1 = r7.this$0
            java.lang.Object r1 = r1.K0()
            boolean r4 = r1 instanceof kotlinx.coroutines.v
            if (r4 == 0) goto L49
            kotlinx.coroutines.v r1 = (kotlinx.coroutines.v) r1
            kotlinx.coroutines.w r1 = r1.f39076e
            r7.label = r3
            java.lang.Object r8 = r8.a(r1, r7)
            if (r8 != r0) goto L88
            return r0
        L49:
            boolean r3 = r1 instanceof kotlinx.coroutines.w1
            if (r3 == 0) goto L88
            kotlinx.coroutines.w1 r1 = (kotlinx.coroutines.w1) r1
            kotlinx.coroutines.n2 r1 = r1.b()
            if (r1 == 0) goto L88
            java.lang.Object r3 = r1.w()
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.f0.n(r3, r4)
            kotlinx.coroutines.internal.LockFreeLinkedListNode r3 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r3
            r4 = r8
            r8 = r7
            r6 = r3
            r3 = r1
            r1 = r6
        L65:
            boolean r5 = kotlin.jvm.internal.f0.g(r1, r3)
            if (r5 != 0) goto L88
            boolean r5 = r1 instanceof kotlinx.coroutines.v
            if (r5 == 0) goto L83
            r5 = r1
            kotlinx.coroutines.v r5 = (kotlinx.coroutines.v) r5
            kotlinx.coroutines.w r5 = r5.f39076e
            r8.L$0 = r4
            r8.L$1 = r3
            r8.L$2 = r1
            r8.label = r2
            java.lang.Object r5 = r4.a(r5, r8)
            if (r5 != r0) goto L83
            return r0
        L83:
            kotlinx.coroutines.internal.LockFreeLinkedListNode r1 = r1.x()
            goto L65
        L88:
            kotlin.z1 r8 = kotlin.z1.f38230a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobSupport$children$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlin.sequences.o<? super c2> oVar, @yt.l kotlin.coroutines.c<? super kotlin.z1> cVar) {
        return ((JobSupport$children$1) M(oVar, cVar)).q0(kotlin.z1.f38230a);
    }
}
