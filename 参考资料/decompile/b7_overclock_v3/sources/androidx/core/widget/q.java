package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OverScroller f5261a;

    public q(Context context, Interpolator interpolator) {
        this.f5261a = interpolator != null ? new OverScroller(context, interpolator) : new OverScroller(context);
    }

    @Deprecated
    public static q c(Context context) {
        return d(context, null);
    }

    @Deprecated
    public static q d(Context context, Interpolator interpolator) {
        return new q(context, interpolator);
    }

    @Deprecated
    public void a() {
        this.f5261a.abortAnimation();
    }

    @Deprecated
    public boolean b() {
        return this.f5261a.computeScrollOffset();
    }

    @Deprecated
    public void e(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.f5261a.fling(i10, i11, i12, i13, i14, i15, i16, i17);
    }

    @Deprecated
    public void f(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        this.f5261a.fling(i10, i11, i12, i13, i14, i15, i16, i17, i18, i19);
    }

    @Deprecated
    public float g() {
        return this.f5261a.getCurrVelocity();
    }

    @Deprecated
    public int h() {
        return this.f5261a.getCurrX();
    }

    @Deprecated
    public int i() {
        return this.f5261a.getCurrY();
    }

    @Deprecated
    public int j() {
        return this.f5261a.getFinalX();
    }

    @Deprecated
    public int k() {
        return this.f5261a.getFinalY();
    }

    @Deprecated
    public boolean l() {
        return this.f5261a.isFinished();
    }

    @Deprecated
    public boolean m() {
        return this.f5261a.isOverScrolled();
    }

    @Deprecated
    public void n(int i10, int i11, int i12) {
        this.f5261a.notifyHorizontalEdgeReached(i10, i11, i12);
    }

    @Deprecated
    public void o(int i10, int i11, int i12) {
        this.f5261a.notifyVerticalEdgeReached(i10, i11, i12);
    }

    @Deprecated
    public boolean p(int i10, int i11, int i12, int i13, int i14, int i15) {
        return this.f5261a.springBack(i10, i11, i12, i13, i14, i15);
    }

    @Deprecated
    public void q(int i10, int i11, int i12, int i13) {
        this.f5261a.startScroll(i10, i11, i12, i13);
    }

    @Deprecated
    public void r(int i10, int i11, int i12, int i13, int i14) {
        this.f5261a.startScroll(i10, i11, i12, i13, i14);
    }
}
