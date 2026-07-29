package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0}, l = {2855}, m = "invokeSuspend", n = {"$this$result", "iterator", "next"}, s = {"L$0", "L$1", "L$2"})
public final class SequencesKt___SequencesKt$zipWithNext$2<R> extends RestrictedSuspendLambda implements ik.p<o<? super R>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ m<T> $this_zipWithNext;
    public final /* synthetic */ ik.p<T, T, R> $transform;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$zipWithNext$2(m<? extends T> mVar, ik.p<? super T, ? super T, ? extends R> pVar, kotlin.coroutines.c<? super SequencesKt___SequencesKt$zipWithNext$2> cVar) {
        super(2, cVar);
        this.$this_zipWithNext = mVar;
        this.$transform = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(this.$this_zipWithNext, this.$transform, cVar);
        sequencesKt___SequencesKt$zipWithNext$2.L$0 = obj;
        return sequencesKt___SequencesKt$zipWithNext$2;
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
            o oVar2 = (o) this.L$0;
            Iterator it3 = this.$this_zipWithNext.iterator();
            if (!it3.hasNext()) {
                return z1.f38230a;
            }
            oVar = oVar2;
            next = it3.next();
            it2 = it3;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object obj2 = this.L$2;
            it2 = (Iterator) this.L$1;
            oVar = (o) this.L$0;
            u0.n(obj);
            next = obj2;
        }
        while (it2.hasNext()) {
            Object next2 = it2.next();
            R rR0 = this.$transform.r0((T) next, (T) next2);
            this.L$0 = oVar;
            this.L$1 = it2;
            this.L$2 = next2;
            this.label = 1;
            if (oVar.a(rR0, this) == objH) {
                return objH;
            }
            next = next2;
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o<? super R> oVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((SequencesKt___SequencesKt$zipWithNext$2) M(oVar, cVar)).q0(z1.f38230a);
    }
}
