package te;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public final class p extends r<e> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f51209d = 0.92f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.f
    public static final int f51210e = R.attr.motionDurationLong1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.f
    public static final int f51211f = R.attr.motionEasingEmphasizedInterpolator;

    public p() {
        super(m(), n());
    }

    public static e m() {
        return new e();
    }

    public static w n() {
        s sVar = new s();
        sVar.o(false);
        sVar.l(0.92f);
        return sVar;
    }

    @Override // te.r
    public /* bridge */ /* synthetic */ void a(@n0 w wVar) {
        super.a(wVar);
    }

    @Override // te.r
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // te.r
    @g.f
    public int f(boolean z10) {
        return f51210e;
    }

    @Override // te.r
    @g.f
    public int g(boolean z10) {
        return f51211f;
    }

    @Override // te.r
    @n0
    public /* bridge */ /* synthetic */ w h() {
        return super.h();
    }

    @Override // te.r
    @p0
    public /* bridge */ /* synthetic */ w i() {
        return super.i();
    }

    @Override // te.r
    public /* bridge */ /* synthetic */ boolean k(@n0 w wVar) {
        return super.k(wVar);
    }

    @Override // te.r
    public /* bridge */ /* synthetic */ void l(@p0 w wVar) {
        super.l(wVar);
    }

    @Override // te.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // te.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }
}
