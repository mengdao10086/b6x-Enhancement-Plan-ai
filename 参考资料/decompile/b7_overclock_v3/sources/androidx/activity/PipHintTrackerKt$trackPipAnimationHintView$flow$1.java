package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.f0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.channels.ProduceKt;

/* JADX INFO: loaded from: classes2.dex */
@zj.d(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements ik.p<kotlinx.coroutines.channels.q<? super Rect>, kotlin.coroutines.c<? super z1>, Object> {
    public final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    public int label;

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.channels.q<Rect> f1349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f1350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewTreeObserver.OnScrollChangedListener f1351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ View.OnLayoutChangeListener f1352d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(kotlinx.coroutines.channels.q<? super Rect> qVar, View view, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener, View.OnLayoutChangeListener onLayoutChangeListener) {
            this.f1349a = qVar;
            this.f1350b = view;
            this.f1351c = onScrollChangedListener;
            this.f1352d = onLayoutChangeListener;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@yt.k View v10) {
            f0.p(v10, "v");
            this.f1349a.F(PipHintTrackerKt.c(this.f1350b));
            this.f1350b.getViewTreeObserver().addOnScrollChangedListener(this.f1351c);
            this.f1350b.addOnLayoutChangeListener(this.f1352d);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(@yt.k View v10) {
            f0.p(v10, "v");
            v10.getViewTreeObserver().removeOnScrollChangedListener(this.f1351c);
            v10.removeOnLayoutChangeListener(this.f1352d);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View view, kotlin.coroutines.c<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> cVar) {
        super(2, cVar);
        this.$view = view;
    }

    public static final void M0(kotlinx.coroutines.channels.q qVar, View v10, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i10 == i14 && i12 == i16 && i11 == i15 && i13 == i17) {
            return;
        }
        f0.o(v10, "v");
        qVar.F(PipHintTrackerKt.c(v10));
    }

    public static final void O0(kotlinx.coroutines.channels.q qVar, View view) {
        qVar.F(PipHintTrackerKt.c(view));
    }

    @Override // ik.p
    @yt.l
    /* JADX INFO: renamed from: K0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@yt.k kotlinx.coroutines.channels.q<? super Rect> qVar, @yt.l kotlin.coroutines.c<? super z1> cVar) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) M(qVar, cVar)).q0(z1.f38230a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.k
    public final kotlin.coroutines.c<z1> M(@yt.l Object obj, @yt.k kotlin.coroutines.c<?> cVar) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 pipHintTrackerKt$trackPipAnimationHintView$flow$1 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, cVar);
        pipHintTrackerKt$trackPipAnimationHintView$flow$1.L$0 = obj;
        return pipHintTrackerKt$trackPipAnimationHintView$flow$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    public final Object q0(@yt.k Object obj) throws Throwable {
        Object objH = yj.b.h();
        int i10 = this.label;
        if (i10 == 0) {
            u0.n(obj);
            final kotlinx.coroutines.channels.q qVar = (kotlinx.coroutines.channels.q) this.L$0;
            final View.OnLayoutChangeListener onLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: androidx.activity.s
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.M0(qVar, view, i11, i12, i13, i14, i15, i16, i17, i18);
                }
            };
            final View view = this.$view;
            final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.activity.t
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    PipHintTrackerKt$trackPipAnimationHintView$flow$1.O0(qVar, view);
                }
            };
            final a aVar = new a(qVar, this.$view, onScrollChangedListener, onLayoutChangeListener);
            if (androidx.activity.a.f1357a.a(this.$view)) {
                qVar.F(PipHintTrackerKt.c(this.$view));
                this.$view.getViewTreeObserver().addOnScrollChangedListener(onScrollChangedListener);
                this.$view.addOnLayoutChangeListener(onLayoutChangeListener);
            }
            this.$view.addOnAttachStateChangeListener(aVar);
            final View view2 = this.$view;
            ik.a<z1> aVar2 = new ik.a<z1>() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                public final void b() {
                    view2.getViewTreeObserver().removeOnScrollChangedListener(onScrollChangedListener);
                    view2.removeOnLayoutChangeListener(onLayoutChangeListener);
                    view2.removeOnAttachStateChangeListener(aVar);
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            };
            this.label = 1;
            if (ProduceKt.a(qVar, aVar2, this) == objH) {
                return objH;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u0.n(obj);
        }
        return z1.f38230a;
    }
}
