package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes3.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f18642e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f18643f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f18644g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f18645h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f18646i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f18647j = 0.01f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f18648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public b f18649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f18650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18651d;

    public interface b {
        void a(float f10, float f11, boolean z10);
    }

    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f18652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f18653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f18654c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f18655d;

        public c() {
        }

        public void a(float f10, float f11, boolean z10) {
            this.f18652a = f10;
            this.f18653b = f11;
            this.f18654c = z10;
            if (this.f18655d) {
                return;
            }
            this.f18655d = true;
            AspectRatioFrameLayout.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18655d = false;
            if (AspectRatioFrameLayout.this.f18649b == null) {
                return;
            }
            AspectRatioFrameLayout.this.f18649b.a(this.f18652a, this.f18653b, this.f18654c);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    public int getResizeMode() {
        return this.f18651d;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        float f10;
        float f11;
        super.onMeasure(i10, i11);
        if (this.f18650c <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f12 = measuredWidth;
        float f13 = measuredHeight;
        float f14 = f12 / f13;
        float f15 = (this.f18650c / f14) - 1.0f;
        if (Math.abs(f15) <= 0.01f) {
            this.f18648a.a(this.f18650c, f14, false);
            return;
        }
        int i12 = this.f18651d;
        if (i12 != 0) {
            if (i12 != 1) {
                if (i12 == 2) {
                    f10 = this.f18650c;
                } else if (i12 == 4) {
                    if (f15 > 0.0f) {
                        f10 = this.f18650c;
                    } else {
                        f11 = this.f18650c;
                    }
                }
                measuredWidth = (int) (f13 * f10);
            } else {
                f11 = this.f18650c;
            }
            measuredHeight = (int) (f12 / f11);
        } else if (f15 > 0.0f) {
            f11 = this.f18650c;
            measuredHeight = (int) (f12 / f11);
        } else {
            f10 = this.f18650c;
            measuredWidth = (int) (f13 * f10);
        }
        this.f18648a.a(this.f18650c, f14, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f10) {
        if (this.f18650c != f10) {
            this.f18650c = f10;
            requestLayout();
        }
    }

    public void setAspectRatioListener(@p0 b bVar) {
        this.f18649b = bVar;
    }

    public void setResizeMode(int i10) {
        if (this.f18651d != i10) {
            this.f18651d = i10;
            requestLayout();
        }
    }

    public AspectRatioFrameLayout(Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f18651d = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.f18651d = typedArrayObtainStyledAttributes.getInt(R.styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f18648a = new c();
    }
}
