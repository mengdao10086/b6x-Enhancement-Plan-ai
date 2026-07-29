package se;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import g.n0;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes7.dex */
public final class p extends q<v> {
    public static final int Y7 = 0;
    public static final int Z7 = 1;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final int f49796a8 = 2;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    @g.f
    public static final int f49797b8 = R.attr.motionDurationLong1;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    @g.f
    public static final int f49798c8 = R.attr.motionEasingEmphasizedInterpolator;
    public final int W7;
    public final boolean X7;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface a {
    }

    public p(int i10, boolean z10) {
        super(c1(i10, z10), d1());
        this.W7 = i10;
        this.X7 = z10;
    }

    public static v c1(int i10, boolean z10) {
        if (i10 == 0) {
            return new s(z10 ? 8388613 : androidx.core.view.m.f5025b);
        }
        if (i10 == 1) {
            return new s(z10 ? 80 : 48);
        }
        if (i10 == 2) {
            return new r(z10);
        }
        throw new IllegalArgumentException("Invalid axis: " + i10);
    }

    public static v d1() {
        return new e();
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
        return f49797b8;
    }

    @Override // se.q
    @g.f
    public int W0(boolean z10) {
        return f49798c8;
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

    public int e1() {
        return this.W7;
    }

    public boolean f1() {
        return this.X7;
    }
}
