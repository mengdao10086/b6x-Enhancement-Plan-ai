package zd;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.internal.b0;
import g.l;
import g.n0;
import ie.b;
import m0.g;
import vd.m;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final float f58433f = 4.5f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f58434g = 2.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f58435h = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f58436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f58437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f58438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f58439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f58440e;

    public a(@n0 Context context) {
        this(b.b(context, R.attr.elevationOverlayEnabled, false), m.b(context, R.attr.elevationOverlayColor, 0), m.b(context, R.attr.elevationOverlayAccentColor, 0), m.b(context, R.attr.colorSurface, 0), context.getResources().getDisplayMetrics().density);
    }

    public int a(float f10) {
        return Math.round(b(f10) * 255.0f);
    }

    public float b(float f10) {
        if (this.f58440e <= 0.0f || f10 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f10 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    @l
    public int c(@l int i10, float f10) {
        int i11;
        float fB = b(f10);
        int iAlpha = Color.alpha(i10);
        int iN = m.n(g.B(i10, 255), this.f58437b, fB);
        if (fB > 0.0f && (i11 = this.f58438c) != 0) {
            iN = m.m(iN, g.B(i11, f58435h));
        }
        return g.B(iN, iAlpha);
    }

    @l
    public int d(@l int i10, float f10, @n0 View view) {
        return c(i10, f10 + i(view));
    }

    @l
    public int e(@l int i10, float f10) {
        return (this.f58436a && m(i10)) ? c(i10, f10) : i10;
    }

    @l
    public int f(@l int i10, float f10, @n0 View view) {
        return e(i10, f10 + i(view));
    }

    @l
    public int g(float f10) {
        return e(this.f58439d, f10);
    }

    @l
    public int h(float f10, @n0 View view) {
        return g(f10 + i(view));
    }

    public float i(@n0 View view) {
        return b0.j(view);
    }

    @l
    public int j() {
        return this.f58437b;
    }

    @l
    public int k() {
        return this.f58439d;
    }

    public boolean l() {
        return this.f58436a;
    }

    public final boolean m(@l int i10) {
        return g.B(i10, 255) == this.f58439d;
    }

    public a(boolean z10, @l int i10, @l int i11, @l int i12, float f10) {
        this.f58436a = z10;
        this.f58437b = i10;
        this.f58438c = i11;
        this.f58439d = i12;
        this.f58440e = f10;
    }
}
