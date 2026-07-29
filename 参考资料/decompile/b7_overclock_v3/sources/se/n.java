package se;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class n extends q<d> {
    public static final float W7 = 0.8f;
    public static final float X7 = 0.3f;

    @g.f
    public static final int Y7 = R.attr.motionDurationMedium4;

    @g.f
    public static final int Z7 = R.attr.motionDurationShort3;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    @g.f
    public static final int f49794a8 = R.attr.motionEasingEmphasizedDecelerateInterpolator;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    @g.f
    public static final int f49795b8 = R.attr.motionEasingEmphasizedAccelerateInterpolator;

    public n() {
        super(c1(), d1());
    }

    public static d c1() {
        d dVar = new d();
        dVar.e(0.3f);
        return dVar;
    }

    public static v d1() {
        r rVar = new r();
        rVar.o(false);
        rVar.l(0.8f);
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
    @n0
    public TimeInterpolator U0(boolean z10) {
        return kd.a.f37166a;
    }

    @Override // se.q
    @g.f
    public int V0(boolean z10) {
        return z10 ? Y7 : Z7;
    }

    @Override // se.q
    @g.f
    public int W0(boolean z10) {
        return z10 ? f49794a8 : f49795b8;
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
