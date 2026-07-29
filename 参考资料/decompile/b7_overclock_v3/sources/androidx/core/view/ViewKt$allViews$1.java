package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", i = {0}, l = {414, 416}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
public final class ViewKt$allViews$1 extends RestrictedSuspendLambda implements ik.p<kotlin.sequences.o<? super View>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewKt$allViews$1(View view, kotlin.coroutines.c<? super ViewKt$allViews$1> cVar) {
        super(2, cVar);
        this.$this_allViews = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, cVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        kotlin.sequences.o oVar;
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            kotlin.u0.n(obj);
            oVar = (kotlin.sequences.o) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = oVar;
            this.label = 1;
            if (oVar.a(view, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.u0.n(obj);
                return z1.f38230a;
            }
            oVar = (kotlin.sequences.o) this.L$0;
            kotlin.u0.n(obj);
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            kotlin.sequences.m<View> mVarF = ViewGroupKt.f((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (oVar.h(mVarF, this) == objH) {
                return objH;
            }
        }
        return z1.f38230a;
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlin.sequences.o<? super View> oVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((ViewKt$allViews$1) M(oVar, cVar)).q0(z1.f38230a);
    }
}
