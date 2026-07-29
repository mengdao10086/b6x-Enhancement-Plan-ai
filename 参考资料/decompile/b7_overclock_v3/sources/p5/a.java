package p5;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Scroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f46418a;

    public a(Context context) {
        super(context);
        this.f46418a = 1000;
    }

    public void a(int i10) {
        this.f46418a = i10;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i10, int i11, int i12, int i13, int i14) {
        super.startScroll(i10, i11, i12, i13, this.f46418a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i10, int i11, int i12, int i13) {
        super.startScroll(i10, i11, i12, i13, this.f46418a);
    }

    public a(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f46418a = 1000;
    }

    public a(Context context, Interpolator interpolator, boolean z10) {
        super(context, interpolator, z10);
        this.f46418a = 1000;
    }
}
