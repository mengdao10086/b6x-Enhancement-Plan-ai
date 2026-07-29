package com.yalantis.ucrop.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import mh.h;

/* JADX INFO: loaded from: classes5.dex */
public class GestureCropImageView extends nh.a {
    public static final int P7 = 200;
    public ScaleGestureDetector G7;
    public h H7;
    public GestureDetector I7;
    public float J7;
    public float K7;
    public boolean L7;
    public boolean M7;
    public boolean N7;
    public int O7;

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            GestureCropImageView gestureCropImageView = GestureCropImageView.this;
            gestureCropImageView.E(gestureCropImageView.getDoubleTapTargetScale(), motionEvent.getX(), motionEvent.getY(), 200L);
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            GestureCropImageView.this.o(-f10, -f11);
            return true;
        }
    }

    public class c extends h.b {
        public c() {
        }

        @Override // mh.h.b, mh.h.a
        public boolean a(h hVar) {
            GestureCropImageView.this.m(hVar.c(), GestureCropImageView.this.J7, GestureCropImageView.this.K7);
            return true;
        }
    }

    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        public d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            GestureCropImageView.this.n(scaleGestureDetector.getScaleFactor(), GestureCropImageView.this.J7, GestureCropImageView.this.K7);
            return true;
        }
    }

    public GestureCropImageView(Context context) {
        super(context);
        this.L7 = true;
        this.M7 = true;
        this.N7 = true;
        this.O7 = 5;
    }

    public boolean L() {
        return this.N7;
    }

    public boolean M() {
        return this.L7;
    }

    public boolean N() {
        return this.M7;
    }

    public final void O() {
        this.I7 = new GestureDetector(getContext(), new b(), null, true);
        this.G7 = new ScaleGestureDetector(getContext(), new d());
        this.H7 = new h(new c());
    }

    public int getDoubleTapScaleSteps() {
        return this.O7;
    }

    public float getDoubleTapTargetScale() {
        return getCurrentScale() * ((float) Math.pow(getMaxScale() / getMinScale(), 1.0f / this.O7));
    }

    @Override // nh.b
    public void k() {
        super.k();
        O();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0) {
            w();
        }
        if (motionEvent.getPointerCount() > 1) {
            this.J7 = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
            this.K7 = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
        }
        if (this.N7) {
            this.I7.onTouchEvent(motionEvent);
        }
        if (this.M7) {
            this.G7.onTouchEvent(motionEvent);
        }
        if (this.L7) {
            this.H7.d(motionEvent);
        }
        if ((motionEvent.getAction() & 255) == 1) {
            C();
        }
        return true;
    }

    public void setDoubleTapScaleSteps(int i10) {
        this.O7 = i10;
    }

    public void setGestureEnabled(boolean z10) {
        this.N7 = z10;
    }

    public void setRotateEnabled(boolean z10) {
        this.L7 = z10;
    }

    public void setScaleEnabled(boolean z10) {
        this.M7 = z10;
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GestureCropImageView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.L7 = true;
        this.M7 = true;
        this.N7 = true;
        this.O7 = 5;
    }
}
