package se;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class o extends q<e> {
    public static final float W7 = 0.92f;

    @g.f
    public static final int X7 = R.attr.motionDurationLong1;

    @g.f
    public static final int Y7 = R.attr.motionEasingEmphasizedInterpolator;

    public o() {
        super(c1(), d1());
    }

    public static e c1() {
        return new e();
    }

    public static v d1() {
        r rVar = new r();
        rVar.o(false);
        rVar.l(0.92f);
        return rVar;
    }

    @Override // se.q, androidx.transition.a0
    public /* bridge */ /* synthetic */ Animator L0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        return super.L0(viewGroup, view, qVar, qVar2);
    }

    @Override // se.q, androidx.transition.a0
    public /* bridge */ /* synthetic */ Animator N0(ViewGroup viewGroup, View view, g2.q qVar, g2.q qVar2) {
        return super.N0(viewGroup, view, qVar, qVar2);
    }

    @Override // se.q
    public /* bridge */ /* synthetic */ void Q0(@n0 v vVar) {
        super.Q0(vVar);
    }

    @Override // se.q
    public /* bridge */ /* synthetic */ void S0() {
        super.S0();
    }

    @Override // se.q
    @g.f
    public int V0(boolean z10) {
        return X7;
    }

    @Override // se.q
    @g.f
    public int W0(boolean z10) {
        return Y7;
    }

    @Override // se.q
    @n0
    public /* bridge */ /* synthetic */ v X0() {
        return super.X0();
    }

    @Override // se.q
    @p0
    public /* bridge */ /* synthetic */ v Y0() {
        return super.Y0();
    }

    @Override // se.q
    public /* bridge */ /* synthetic */ boolean a1(@n0 v vVar) {
        return super.a1(vVar);
    }

    @Override // se.q
    public /* bridge */ /* synthetic */ void b1(@p0 v vVar) {
        super.b1(vVar);
    }
}
