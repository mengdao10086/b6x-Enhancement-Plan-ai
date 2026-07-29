package te;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public final class o extends r<d> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float f51203d = 0.8f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f51204e = 0.3f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.f
    public static final int f51205f = R.attr.motionDurationMedium4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @g.f
    public static final int f51206g = R.attr.motionDurationShort3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.f
    public static final int f51207h = R.attr.motionEasingEmphasizedDecelerateInterpolator;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.f
    public static final int f51208i = R.attr.motionEasingEmphasizedAccelerateInterpolator;

    public o() {
        super(m(), n());
    }

    public static d m() {
        d dVar = new d();
        dVar.e(0.3f);
        return dVar;
    }

    public static w n() {
        s sVar = new s();
        sVar.o(false);
        sVar.l(0.8f);
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
    @n0
    public TimeInterpolator e(boolean z10) {
        return kd.a.f37166a;
    }

    @Override // te.r
    @g.f
    public int f(boolean z10) {
        return z10 ? f51205f : f51206g;
    }

    @Override // te.r
    @g.f
    public int g(boolean z10) {
        return z10 ? f51207h : f51208i;
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
