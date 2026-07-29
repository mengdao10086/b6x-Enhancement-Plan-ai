package kotlin.sequences;

import java.util.List;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.random.Random;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
public final class SequencesKt__SequencesKt$shuffled$1<T> extends RestrictedSuspendLambda implements ik.p<o<? super T>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ Random $random;
    public final /* synthetic */ m<T> $this_shuffled;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt__SequencesKt$shuffled$1(m<? extends T> mVar, Random random, kotlin.coroutines.c<? super SequencesKt__SequencesKt$shuffled$1> cVar) {
        super(2, cVar);
        this.$this_shuffled = mVar;
        this.$random = random;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(this.$this_shuffled, this.$random, cVar);
        sequencesKt__SequencesKt$shuffled$1.L$0 = obj;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        List listD3;
        o oVar;
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            o oVar2 = (o) this.L$0;
            listD3 = SequencesKt___SequencesKt.d3(this.$this_shuffled);
            oVar = oVar2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            listD3 = (List) this.L$1;
            o oVar3 = (o) this.L$0;
            u0.n(obj);
            oVar = oVar3;
        }
        while (!listD3.isEmpty()) {
            int iP = this.$random.p(listD3.size());
            Object objL0 = kotlin.collections.x.L0(listD3);
            if (iP < listD3.size()) {
                objL0 = listD3.set(iP, objL0);
            }
            this.L$0 = oVar;
            this.L$1 = listD3;
            this.label = 1;
            if (oVar.a(objL0, this) == objH) {
                return objH;
            }
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o<? super T> oVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((SequencesKt__SequencesKt$shuffled$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
