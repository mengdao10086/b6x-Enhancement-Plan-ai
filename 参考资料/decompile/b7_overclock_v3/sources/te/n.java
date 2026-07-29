package te;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public final class n extends r<s> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f51201e = 0.85f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f51202d;

    public n(boolean z10) {
        super(m(z10), n());
        this.f51202d = z10;
    }

    public static s m(boolean z10) {
        s sVar = new s(z10);
        sVar.m(0.85f);
        sVar.l(0.85f);
        return sVar;
    }

    public static w n() {
        return new d();
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

    public boolean o() {
        return this.f51202d;
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
