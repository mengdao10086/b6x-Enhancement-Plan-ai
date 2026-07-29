package com.flydigi.base.widget.recyclerview.layoutmanager;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
public class ScaleLayoutManager extends ViewPagerLayoutManager {

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public int f13612k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public float f13613l8;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public float f13614m8;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public float f13615n8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public float f13616o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public final int f13617p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public final float f13618q8;

    public static class a {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final float f13619l = 0.8f;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final float f13620m = 1.0f;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final float f13621n = 1.0f;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final float f13622o = 1.0f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f13623a;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Context f13630h;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13624b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f13625c = 0.8f;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f13626d = 1.0f;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f13627e = 1.0f;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f13628f = 1.0f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f13633k = 17;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f13629g = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f13632j = Integer.MAX_VALUE;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f13631i = -1;

        public a(Context context, int i10) {
            this.f13623a = i10;
            this.f13630h = context;
        }

        public ScaleLayoutManager l() {
            return new ScaleLayoutManager(this);
        }

        public a m(int i10) {
            this.f13632j = i10;
            return this;
        }

        public a n(int i10) {
            this.f13633k = i10;
            return this;
        }

        public a o(float f10) {
            if (f10 > 1.0f) {
                f10 = 1.0f;
            }
            this.f13627e = f10;
            return this;
        }

        public a p(int i10) {
            this.f13631i = i10;
            return this;
        }

        public a q(float f10) {
            if (f10 < 0.0f) {
                f10 = 0.0f;
            }
            this.f13628f = f10;
            return this;
        }

        public a r(float f10) {
            this.f13625c = f10;
            return this;
        }

        public a s(float f10) {
            this.f13626d = f10;
            return this;
        }

        public a t(int i10) {
            this.f13624b = i10;
            return this;
        }

        public a u(boolean z10) {
            this.f13629g = z10;
            return this;
        }
    }

    public ScaleLayoutManager(Context context, int i10) {
        this(new a(context, i10));
    }

    @Override // com.flydigi.base.widget.recyclerview.layoutmanager.ViewPagerLayoutManager
    public float E3() {
        float f10 = this.f13614m8;
        if (f10 == 0.0f) {
            return Float.MAX_VALUE;
        }
        return 1.0f / f10;
    }

    @Override // com.flydigi.base.widget.recyclerview.layoutmanager.ViewPagerLayoutManager
    public float b4() {
        return this.f13612k8 + this.G7;
    }

    @Override // com.flydigi.base.widget.recyclerview.layoutmanager.ViewPagerLayoutManager
    public void c4(View view, float f10) {
        float fK4 = k4(this.J7 + f10);
        view.setScaleX(fK4);
        view.setScaleY(fK4);
        view.setAlpha(j4(f10));
    }

    @Override // com.flydigi.base.widget.recyclerview.layoutmanager.ViewPagerLayoutManager
    public void g4() {
        int i10 = this.f13617p8;
        if (i10 == 3 || i10 == 8388611) {
            this.J7 = this.M7.m();
        } else {
            this.J7 = (this.M7.n() - this.G7) / 2;
        }
    }

    public final float j4(float f10) {
        float fAbs = Math.abs(f10);
        float f11 = this.f13616o8;
        float f12 = this.f13615n8;
        float f13 = this.S7;
        return fAbs >= f13 ? f11 : (((f11 - f12) / f13) * fAbs) + f12;
    }

    public final float k4(float f10) {
        float fAbs = Math.abs(f10 - this.J7);
        int i10 = this.G7;
        if (fAbs - i10 > 0.0f) {
            fAbs = i10;
        }
        return 1.0f - ((fAbs / i10) * (1.0f - this.f13613l8));
    }

    public int l4() {
        return this.f13612k8;
    }

    public float m4() {
        return this.f13615n8;
    }

    public float n4() {
        return this.f13616o8;
    }

    public float o4() {
        return this.f13613l8;
    }

    public float p4() {
        return this.f13614m8;
    }

    public void q4(int i10) {
        q(null);
        if (this.f13612k8 == i10) {
            return;
        }
        this.f13612k8 = i10;
        removeAllViews();
    }

    public void r4(float f10) {
        q(null);
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        if (this.f13615n8 == f10) {
            return;
        }
        this.f13615n8 = f10;
        N1();
    }

    public void s4(float f10) {
        q(null);
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (this.f13616o8 == f10) {
            return;
        }
        this.f13616o8 = f10;
        N1();
    }

    public void t4(float f10) {
        q(null);
        if (this.f13613l8 == f10) {
            return;
        }
        this.f13613l8 = f10;
        removeAllViews();
    }

    public void u4(float f10) {
        q(null);
        if (this.f13614m8 == f10) {
            return;
        }
        this.f13614m8 = f10;
    }

    public ScaleLayoutManager(Context context, int i10, int i11) {
        this(new a(context, i10).t(i11));
    }

    public ScaleLayoutManager(Context context, int i10, int i11, boolean z10) {
        this(new a(context, i10).t(i11).u(z10));
    }

    public ScaleLayoutManager(a aVar) {
        this(aVar.f13630h, aVar.f13623a, aVar.f13625c, aVar.f13627e, aVar.f13628f, aVar.f13624b, aVar.f13626d, aVar.f13631i, aVar.f13632j, aVar.f13629g, aVar.f13633k);
    }

    public ScaleLayoutManager(Context context, int i10, float f10, float f11, float f12, int i11, float f13, int i12, int i13, boolean z10, int i14) {
        super(context, i11, z10);
        this.f13618q8 = 1.0f;
        Y3(i13);
        d4(i12);
        this.f13612k8 = i10;
        this.f13613l8 = f10;
        this.f13614m8 = f13;
        this.f13615n8 = f11;
        this.f13616o8 = f12;
        this.f13617p8 = i14;
    }
}
