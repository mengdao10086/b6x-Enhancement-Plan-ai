package kotlin.sequences;

import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes5.dex */
@zj.d(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
public final class SequencesKt__SequencesKt$flatMapIndexed$1<R> extends RestrictedSuspendLambda implements ik.p<o<? super R>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ ik.l<C, Iterator<R>> $iterator;
    public final /* synthetic */ m<T> $source;
    public final /* synthetic */ ik.p<Integer, T, C> $transform;
    public int I$0;
    private /* synthetic */ Object L$0;
    public Object L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt__SequencesKt$flatMapIndexed$1(m<? extends T> mVar, ik.p<? super Integer, ? super T, ? extends C> pVar, ik.l<? super C, ? extends Iterator<? extends R>> lVar, kotlin.coroutines.c<? super SequencesKt__SequencesKt$flatMapIndexed$1> cVar) {
        super(2, cVar);
        this.$source = mVar;
        this.$transform = pVar;
        this.$iterator = lVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(this.$source, this.$transform, this.$iterator, cVar);
        sequencesKt__SequencesKt$flatMapIndexed$1.L$0 = obj;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        int i10;
        Iterator it2;
        o oVar;
        Object objH = yj.b.h();
        int i11 = this.label;
        if (i11 == 0) {
            u0.n(obj);
            o oVar2 = (o) this.L$0;
            i10 = 0;
            it2 = this.$source.iterator();
            oVar = oVar2;
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i10 = this.I$0;
            it2 = (Iterator) this.L$1;
            oVar = (o) this.L$0;
            u0.n(obj);
        }
        while (it2.hasNext()) {
            Object next = it2.next();
            ik.p<Integer, T, C> pVar = this.$transform;
            int i12 = i10 + 1;
            if (i10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            Iterator<R> itI = this.$iterator.i((C) pVar.r0(zj.a.f(i10), (T) next));
            this.L$0 = oVar;
            this.L$1 = it2;
            this.I$0 = i12;
            this.label = 1;
            if (oVar.g(itI, this) == objH) {
                return objH;
            }
            i10 = i12;
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k o<? super R> oVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((SequencesKt__SequencesKt$flatMapIndexed$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
