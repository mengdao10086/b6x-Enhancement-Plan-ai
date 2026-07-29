package te;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import g.n0;
import g.p0;
import g.v0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import te.w;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public abstract class r<P extends w> extends Visibility {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P f51219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public w f51220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<w> f51221c = new ArrayList();

    public r(P p10, @p0 w wVar) {
        this.f51219a = p10;
        this.f51220b = wVar;
    }

    public static void b(List<Animator> list, @p0 w wVar, ViewGroup viewGroup, View view, boolean z10) {
        if (wVar == null) {
            return;
        }
        Animator animatorA = z10 ? wVar.a(viewGroup, view) : wVar.b(viewGroup, view);
        if (animatorA != null) {
            list.add(animatorA);
        }
    }

    public void a(@n0 w wVar) {
        this.f51221c.add(wVar);
    }

    public void c() {
        this.f51221c.clear();
    }

    public final Animator d(@n0 ViewGroup viewGroup, @n0 View view, boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        b(arrayList, this.f51219a, viewGroup, view, z10);
        b(arrayList, this.f51220b, viewGroup, view, z10);
        Iterator<w> it2 = this.f51221c.iterator();
        while (it2.hasNext()) {
            b(arrayList, it2.next(), viewGroup, view, z10);
        }
        j(viewGroup.getContext(), z10);
        kd.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @n0
    public TimeInterpolator e(boolean z10) {
        return kd.a.f37167b;
    }

    @g.f
    public int f(boolean z10) {
        return 0;
    }

    @g.f
    public int g(boolean z10) {
        return 0;
    }

    @n0
    public P h() {
        return this.f51219a;
    }

    @p0
    public w i() {
        return this.f51220b;
    }

    public final void j(@n0 Context context, boolean z10) {
        v.q(this, context, f(z10));
        v.r(this, context, g(z10), e(z10));
    }

    public boolean k(@n0 w wVar) {
        return this.f51221c.remove(wVar);
    }

    public void l(@p0 w wVar) {
        this.f51220b = wVar;
    }

    @Override // android.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return d(viewGroup, view, true);
    }

    @Override // android.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return d(viewGroup, view, false);
    }
}
