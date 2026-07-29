package top.androidman.internal.superview;

import android.content.res.ColorStateList;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.b0;
import kotlin.jvm.internal.f0;
import kotlin.z;
import m0.g;
import top.androidman.internal.RoundRectDrawableWithShadow;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes6.dex */
public class Plasterer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public b f51486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public View f51487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final z f51488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @k
    public final z f51489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final z f51490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final z f51491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public final z f51492g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public final z f51493h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f51494i;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@l View view, @l Outline outline) {
            if (outline != null) {
                outline.setRoundRect(0, 0, view != null ? view.getWidth() : 0, view != null ? view.getHeight() : 0, Plasterer.this.f51486a.k());
            }
        }
    }

    public Plasterer(@k final View view, @k b valueStore) {
        f0.p(view, "view");
        f0.p(valueStore, "valueStore");
        this.f51486a = valueStore;
        this.f51487b = view;
        this.f51488c = b0.a(new ik.a<Integer>() { // from class: top.androidman.internal.superview.Plasterer$compositeNormalBackgroundColorWhenPressed$2
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer o() {
                return Integer.valueOf(g.t(top.androidman.internal.c.f51475b, this.this$0.f51486a.c()));
            }
        });
        this.f51489d = b0.a(new ik.a<Integer>() { // from class: top.androidman.internal.superview.Plasterer$compositeBackgroundStartColorWhenPressed$2
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer o() {
                return Integer.valueOf(g.t(top.androidman.internal.c.f51475b, this.this$0.f51486a.e()));
            }
        });
        this.f51490e = b0.a(new ik.a<Integer>() { // from class: top.androidman.internal.superview.Plasterer$compositeBackgroundEndColorWhenPressed$2
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer o() {
                return Integer.valueOf(g.t(top.androidman.internal.c.f51475b, this.this$0.f51486a.b()));
            }
        });
        this.f51491f = b0.a(new ik.a<Integer>() { // from class: top.androidman.internal.superview.Plasterer$compositeNormalBackgroundColorWhenUnableClick$2
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer o() {
                return Integer.valueOf(g.t(top.androidman.internal.c.f51476c, this.this$0.f51486a.c()));
            }
        });
        this.f51492g = b0.a(new ik.a<Integer>() { // from class: top.androidman.internal.superview.Plasterer$compositeBackgroundStartColorWhenUnableClick$2
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer o() {
                return Integer.valueOf(g.t(top.androidman.internal.c.f51476c, this.this$0.f51486a.e()));
            }
        });
        this.f51493h = b0.a(new ik.a<Integer>() { // from class: top.androidman.internal.superview.Plasterer$compositeBackgroundEndColorWhenUnableClick$2
            {
                super(0);
            }

            @Override // ik.a
            @k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Integer o() {
                return Integer.valueOf(g.t(top.androidman.internal.c.f51476c, this.this$0.f51486a.b()));
            }
        });
        this.f51487b.setOnTouchListener(new View.OnTouchListener() { // from class: top.androidman.internal.superview.d
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return Plasterer.b(this.f51518a, view, view2, motionEvent);
            }
        });
    }

    public static final boolean b(Plasterer this$0, View view, View view2, MotionEvent motionEvent) {
        f0.p(this$0, "this$0");
        f0.p(view, "$view");
        if (this$0.f51486a.l() != Integer.MAX_VALUE || (this$0.f51486a.l() == Integer.MAX_VALUE && !this$0.f51486a.j())) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this$0.f51494i = true;
            this$0.D();
        } else if (actionMasked == 1 || actionMasked == 3) {
            this$0.f51494i = false;
            this$0.D();
        }
        return !view.hasOnClickListeners();
    }

    @k
    public final Plasterer A(int i10, @g.l int i11, @g.l int i12) {
        this.f51486a.N(i10);
        this.f51486a.O(i11);
        this.f51486a.M(i12);
        return this;
    }

    @k
    public final Plasterer B(int i10) {
        this.f51486a.P(i10);
        return this;
    }

    @k
    public final Plasterer C(boolean z10) {
        this.f51486a.E(z10);
        return this;
    }

    public void D() {
        Drawable drawableE;
        boolean z10 = this.f51486a.d() != Integer.MAX_VALUE;
        if (((this.f51486a.e() != Integer.MAX_VALUE && this.f51486a.b() != Integer.MAX_VALUE) || this.f51486a.s() == Integer.MAX_VALUE || this.f51486a.t() == Integer.MAX_VALUE || this.f51486a.r() == Integer.MAX_VALUE) ? false : true) {
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(this.f51494i ? z10 ? this.f51486a.d() : this.f51486a.o() ? j() : this.f51486a.c() : this.f51486a.c());
            f0.o(colorStateListValueOf, "valueOf(\n               …      }\n                )");
            drawableE = new RoundRectDrawableWithShadow(colorStateListValueOf, this.f51486a.k(), this.f51486a.t(), this.f51486a.r(), this.f51486a.s());
        } else {
            if (this.f51486a.n() == 2.1474836E9f) {
                if (this.f51486a.m() == 2.1474836E9f) {
                    if (this.f51486a.q() == 2.1474836E9f) {
                        if (this.f51486a.p() == 2.1474836E9f) {
                            this.f51487b.setOutlineProvider(new a());
                            this.f51487b.setClipToOutline(true);
                        }
                    }
                }
            }
            drawableE = e(z10);
        }
        this.f51487b.setLayerType(1, null);
        this.f51487b.setBackground(drawableE);
    }

    public final float d(float f10) {
        return (f10 * this.f51487b.getContext().getResources().getDisplayMetrics().density) + 0.5f;
    }

    public final GradientDrawable e(boolean z10) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (this.f51486a.e() == Integer.MAX_VALUE || this.f51486a.b() == Integer.MAX_VALUE) {
            gradientDrawable.setColor(ColorStateList.valueOf(this.f51494i ? z10 ? this.f51486a.d() : this.f51486a.o() ? j() : this.f51486a.c() : this.f51486a.l() != Integer.MAX_VALUE ? this.f51486a.l() : this.f51486a.j() ? this.f51486a.c() : k()));
        } else {
            int iD = this.f51494i ? z10 ? this.f51486a.d() : this.f51486a.o() ? h() : this.f51486a.e() : this.f51486a.l() != Integer.MAX_VALUE ? this.f51486a.l() : this.f51486a.j() ? this.f51486a.e() : i();
            int iD2 = this.f51494i ? z10 ? this.f51486a.d() : this.f51486a.o() ? f() : this.f51486a.b() : this.f51486a.l() != Integer.MAX_VALUE ? this.f51486a.l() : this.f51486a.j() ? this.f51486a.b() : g();
            gradientDrawable.setOrientation(this.f51486a.a());
            gradientDrawable.setColors(new int[]{iD, iD2});
        }
        float[] fArr = new float[8];
        fArr[0] = !((this.f51486a.n() > 2.1474836E9f ? 1 : (this.f51486a.n() == 2.1474836E9f ? 0 : -1)) == 0) ? this.f51486a.n() : this.f51486a.k();
        fArr[1] = !((this.f51486a.n() > 2.1474836E9f ? 1 : (this.f51486a.n() == 2.1474836E9f ? 0 : -1)) == 0) ? this.f51486a.n() : this.f51486a.k();
        fArr[2] = !((this.f51486a.q() > 2.1474836E9f ? 1 : (this.f51486a.q() == 2.1474836E9f ? 0 : -1)) == 0) ? this.f51486a.q() : this.f51486a.k();
        fArr[3] = !((this.f51486a.q() > 2.1474836E9f ? 1 : (this.f51486a.q() == 2.1474836E9f ? 0 : -1)) == 0) ? this.f51486a.q() : this.f51486a.k();
        fArr[4] = !((this.f51486a.p() > 2.1474836E9f ? 1 : (this.f51486a.p() == 2.1474836E9f ? 0 : -1)) == 0) ? this.f51486a.p() : this.f51486a.k();
        fArr[5] = !((this.f51486a.p() > 2.1474836E9f ? 1 : (this.f51486a.p() == 2.1474836E9f ? 0 : -1)) == 0) ? this.f51486a.p() : this.f51486a.k();
        fArr[6] = !((this.f51486a.m() > 2.1474836E9f ? 1 : (this.f51486a.m() == 2.1474836E9f ? 0 : -1)) == 0) ? this.f51486a.m() : this.f51486a.k();
        fArr[7] = !((this.f51486a.m() > 2.1474836E9f ? 1 : (this.f51486a.m() == 2.1474836E9f ? 0 : -1)) == 0) ? this.f51486a.m() : this.f51486a.k();
        gradientDrawable.setCornerRadii(fArr);
        if (this.f51486a.i() != Integer.MAX_VALUE && this.f51486a.f() != Integer.MAX_VALUE) {
            gradientDrawable.setStroke(this.f51486a.i(), this.f51486a.f(), this.f51486a.h(), this.f51486a.g());
        }
        gradientDrawable.setShape(this.f51486a.u() == 1 ? 1 : 0);
        return gradientDrawable;
    }

    public final int f() {
        return ((Number) this.f51490e.getValue()).intValue();
    }

    public final int g() {
        return ((Number) this.f51493h.getValue()).intValue();
    }

    public final int h() {
        return ((Number) this.f51489d.getValue()).intValue();
    }

    public final int i() {
        return ((Number) this.f51492g.getValue()).intValue();
    }

    public final int j() {
        return ((Number) this.f51488c.getValue()).intValue();
    }

    public final int k() {
        return ((Number) this.f51491f.getValue()).intValue();
    }

    @k
    public final Plasterer l(@g.l int i10, int i11, float f10, float f11) {
        this.f51486a.A(i10);
        this.f51486a.D(i11);
        this.f51486a.C(f10);
        this.f51486a.B(f11);
        return this;
    }

    @k
    public final Plasterer m(@g.l int i10) {
        this.f51486a.A(i10);
        return this;
    }

    @k
    public final Plasterer n(float f10, float f11) {
        this.f51486a.C(f10);
        this.f51486a.B(f11);
        return this;
    }

    @k
    public final Plasterer o(int i10) {
        this.f51486a.D(i10);
        return this;
    }

    @k
    public final Plasterer p(int i10, @g.l int i11, @g.l int i12) {
        this.f51486a.v(top.androidman.internal.g.a(i10));
        this.f51486a.z(i11);
        this.f51486a.w(i12);
        return this;
    }

    @k
    public final Plasterer q(float f10) {
        this.f51486a.F(d(f10));
        return this;
    }

    @k
    public final Plasterer r(float f10, float f11, float f12, float f13) {
        this.f51486a.I(d(f10));
        this.f51486a.H(d(f13));
        this.f51486a.L(d(f11));
        this.f51486a.K(d(f12));
        return this;
    }

    @k
    public final Plasterer s(@g.l int i10) {
        this.f51486a.G(i10);
        return this;
    }

    @k
    public final Plasterer t(float f10) {
        this.f51486a.H(d(f10));
        return this;
    }

    @k
    public final Plasterer u(float f10) {
        this.f51486a.I(d(f10));
        return this;
    }

    @k
    public final Plasterer v(@g.l int i10) {
        this.f51486a.x(i10);
        return this;
    }

    @k
    public final Plasterer w(boolean z10) {
        this.f51486a.J(z10);
        return this;
    }

    @k
    public final Plasterer x(@g.l int i10) {
        this.f51486a.y(i10);
        return this;
    }

    @k
    public final Plasterer y(float f10) {
        this.f51486a.K(d(f10));
        return this;
    }

    @k
    public final Plasterer z(float f10) {
        this.f51486a.L(d(f10));
        return this;
    }
}
