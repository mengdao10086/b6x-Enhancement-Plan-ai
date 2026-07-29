package se;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.a0;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import se.v;

/* JADX INFO: loaded from: classes7.dex */
public abstract class q<P extends v> extends a0 {
    public final P T7;

    @p0
    public v U7;
    public final List<v> V7 = new ArrayList();

    public q(P p10, @p0 v vVar) {
        this.T7 = p10;
        this.U7 = vVar;
    }

    public static void R0(List<Animator> list, @p0 v vVar, ViewGroup viewGroup, View view, boolean z10) {
        if (vVar == null) {
            return;
        }
        Animator animatorA = z10 ? vVar.a(viewGroup, view) : vVar.b(viewGroup, view);
        if (animatorA != null) {
            list.add(animatorA);
        }
    }

    @Override // androidx.transition.a0
    public Animator L0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        return T0(viewGroup, view, true);
    }

    @Override // androidx.transition.a0
    public Animator N0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        return T0(viewGroup, view, false);
    }

    public void Q0(@n0 v vVar) {
        this.V7.add(vVar);
    }

    public void S0() {
        this.V7.clear();
    }

    public final Animator T0(@n0 ViewGroup viewGroup, @n0 View view, boolean z10) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        R0(arrayList, this.T7, viewGroup, view, z10);
        R0(arrayList, this.U7, viewGroup, view, z10);
        Iterator<v> it2 = this.V7.iterator();
        while (it2.hasNext()) {
            R0(arrayList, it2.next(), viewGroup, view, z10);
        }
        Z0(viewGroup.getContext(), z10);
        kd.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    @n0
    public TimeInterpolator U0(boolean z10) {
        return kd.a.f37167b;
    }

    @g.f
    public int V0(boolean z10) {
        return 0;
    }

    @g.f
    public int W0(boolean z10) {
        return 0;
    }

    @n0
    public P X0() {
        return this.T7;
    }

    @p0
    public v Y0() {
        return this.U7;
    }

    public final void Z0(@n0 Context context, boolean z10) {
        u.q(this, context, V0(z10));
        u.r(this, context, W0(z10), U0(z10));
    }

    public boolean a1(@n0 v vVar) {
        return this.V7.remove(vVar);
    }

    public void b1(@p0 v vVar) {
        this.U7 = vVar;
    }
}
