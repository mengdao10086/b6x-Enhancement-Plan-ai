package se;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public final class m extends q<r> {
    public static final float X7 = 0.85f;
    public final boolean W7;

    public m(boolean z10) {
        super(c1(z10), d1());
        this.W7 = z10;
    }

    public static r c1(boolean z10) {
        r rVar = new r(z10);
        rVar.m(0.85f);
        rVar.l(0.85f);
        return rVar;
    }

    public static v d1() {
        return new d();
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

    public boolean e1() {
        return this.W7;
    }
}
