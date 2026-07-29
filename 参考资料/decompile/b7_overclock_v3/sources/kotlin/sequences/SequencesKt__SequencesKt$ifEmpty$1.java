package kotlin.sequences;

import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
public final class SequencesKt__SequencesKt$ifEmpty$1<T> extends RestrictedSuspendLambda implements ik.p<o<? super T>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.a<m<T>> $defaultValue;
    public final /* synthetic */ m<T> $this_ifEmpty;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt__SequencesKt$ifEmpty$1(m<? extends T> mVar, ik.a<? extends m<? extends T>> aVar, kotlin.coroutines.c<? super SequencesKt__SequencesKt$ifEmpty$1> cVar) {
        super(2, cVar);
        this.$this_ifEmpty = mVar;
        this.$defaultValue = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(this.$this_ifEmpty, this.$defaultValue, cVar);
        sequencesKt__SequencesKt$ifEmpty$1.L$0 = obj;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            o oVar = (o) this.L$0;
            Iterator<? extends T> it2 = this.$this_ifEmpty.iterator();
            if (it2.hasNext()) {
                this.label = 1;
                if (oVar.g(it2, this) == objH) {
                    return objH;
                }
            } else {
                m<T> mVarO = this.$defaultValue.o();
                this.label = 2;
                if (oVar.h(mVarO, this) == objH) {
                    return objH;
                }
            }
        } else {
            if (i10 != 1 && i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o<? super T> oVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((SequencesKt__SequencesKt$ifEmpty$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
