package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2348, 2351}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class SequencesKt___SequencesKt$runningReduce$1<S> extends RestrictedSuspendLambda implements ik.p<o<? super S>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.p<S, T, S> $operation;
    public final /* synthetic */ m<T> $this_runningReduce;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningReduce$1(m<? extends T> mVar, ik.p<? super S, ? super T, ? extends S> pVar, kotlin.coroutines.c<? super SequencesKt___SequencesKt$runningReduce$1> cVar) {
        super(2, cVar);
        this.$this_runningReduce = mVar;
        this.$operation = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, cVar);
        sequencesKt___SequencesKt$runningReduce$1.L$0 = obj;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        o oVar;
        Object next;
        Iterator it2;
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            oVar = (o) this.L$0;
            Iterator it3 = this.$this_runningReduce.iterator();
            if (it3.hasNext()) {
                next = it3.next();
                this.L$0 = oVar;
                this.L$1 = it3;
                this.L$2 = next;
                this.label = 1;
                if (oVar.a(next, this) == objH) {
                    return objH;
                }
                it2 = it3;
            }
            return z1.f38230a;
        }
        if (i10 != 1 && i10 != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        next = this.L$2;
        it2 = (Iterator) this.L$1;
        oVar = (o) this.L$0;
        u0.n(obj);
        while (it2.hasNext()) {
            next = this.$operation.r0((S) next, (T) it2.next());
            this.L$0 = oVar;
            this.L$1 = it2;
            this.L$2 = next;
            this.label = 2;
            if (oVar.a(next, this) == objH) {
                return objH;
            }
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o<? super S> oVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((SequencesKt___SequencesKt$runningReduce$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
