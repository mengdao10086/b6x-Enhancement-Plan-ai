package te;

import android.animation.Animator;
import android.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import g.n0;
import g.p0;
import g.v0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public final class q extends r<w> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f51212f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f51213g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f51214h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @g.f
    public static final int f51215i = R.attr.motionDurationLong1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @g.f
    public static final int f51216j = R.attr.motionEasingEmphasizedInterpolator;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f51217d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f51218e;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface a {
    }

    public q(int i10, boolean z10) {
        super(m(i10, z10), n());
        this.f51217d = i10;
        this.f51218e = z10;
    }

    public static w m(int i10, boolean z10) {
        if (i10 == 0) {
            return new t(z10 ? 8388613 : androidx.core.view.m.f5025b);
        }
        if (i10 == 1) {
            return new t(z10 ? 80 : 48);
        }
        if (i10 == 2) {
            return new s(z10);
        }
        throw new IllegalArgumentException("Invalid axis: " + i10);
    }

    public static w n() {
        return new e();
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
        return f51215i;
    }

    @Override // te.r
    @g.f
    public int g(boolean z10) {
        return f51216j;
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

    public int o() {
        return this.f51217d;
    }

    @Override // te.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onAppear(viewGroup, view, transitionValues, transitionValues2);
    }

    @Override // te.r, android.transition.Visibility
    public /* bridge */ /* synthetic */ Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return super.onDisappear(viewGroup, view, transitionValues, transitionValues2);
    }

    public boolean p() {
        return this.f51218e;
    }
}
