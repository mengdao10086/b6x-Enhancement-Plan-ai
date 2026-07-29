package it.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes5.dex */
public class ImageViewTouch extends ImageViewTouchBase {
    public static final float G7 = 1.0f;
    public GestureDetector.OnGestureListener C1;
    public boolean C2;
    public ScaleGestureDetector D;
    public b E7;
    public c F7;
    public int K0;
    public ScaleGestureDetector.OnScaleGestureListener K1;
    public boolean K2;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public GestureDetector f35885k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public float f35886k1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f35887v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f35888v2;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onDoubleTap. double tap enabled? ");
            sb2.append(ImageViewTouch.this.f35888v2);
            ImageViewTouch imageViewTouch = ImageViewTouch.this;
            if (imageViewTouch.f35888v2) {
                imageViewTouch.f35899g = true;
                float scale = imageViewTouch.getScale();
                ImageViewTouch imageViewTouch2 = ImageViewTouch.this;
                ImageViewTouch.this.J(Math.min(ImageViewTouch.this.getMaxScale(), Math.max(imageViewTouch2.N(scale, imageViewTouch2.getMaxScale()), ImageViewTouch.this.getMinScale())), motionEvent.getX(), motionEvent.getY(), 200.0f);
                ImageViewTouch.this.invalidate();
            }
            if (ImageViewTouch.this.E7 != null) {
                ImageViewTouch.this.E7.g();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return ImageViewTouch.this.O(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            if (ImageViewTouch.this.K2 && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1 && !ImageViewTouch.this.D.isInProgress() && ImageViewTouch.this.getScale() != 1.0f) {
                return ImageViewTouch.this.P(motionEvent, motionEvent2, f10, f11);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (!ImageViewTouch.this.isLongClickable() || ImageViewTouch.this.D.isInProgress()) {
                return;
            }
            ImageViewTouch.this.setPressed(true);
            ImageViewTouch.this.performLongClick();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            if (ImageViewTouch.this.K2 && motionEvent != null && motionEvent2 != null && motionEvent.getPointerCount() <= 1 && motionEvent2.getPointerCount() <= 1 && !ImageViewTouch.this.D.isInProgress()) {
                return ImageViewTouch.this.Q(motionEvent, motionEvent2, f10, f11);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (ImageViewTouch.this.F7 != null) {
                ImageViewTouch.this.F7.a();
            }
            return ImageViewTouch.this.R(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return ImageViewTouch.this.S(motionEvent);
        }
    }

    public interface b {
        void g();
    }

    public interface c {
        void a();
    }

    public class d extends ScaleGestureDetector.SimpleOnScaleGestureListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f35890a = false;

        public d() {
        }

        @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float currentSpan = scaleGestureDetector.getCurrentSpan() - scaleGestureDetector.getPreviousSpan();
            float scale = ImageViewTouch.this.getScale() * scaleGestureDetector.getScaleFactor();
            ImageViewTouch imageViewTouch = ImageViewTouch.this;
            if (imageViewTouch.C2) {
                boolean z10 = this.f35890a;
                if (z10 && currentSpan != 0.0f) {
                    imageViewTouch.f35899g = true;
                    ImageViewTouch.this.I(Math.min(imageViewTouch.getMaxScale(), Math.max(scale, ImageViewTouch.this.getMinScale() - 0.1f)), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                    ImageViewTouch imageViewTouch2 = ImageViewTouch.this;
                    imageViewTouch2.f35887v1 = 1;
                    imageViewTouch2.invalidate();
                    return true;
                }
                if (!z10) {
                    this.f35890a = true;
                }
            }
            return true;
        }
    }

    public ImageViewTouch(Context context) {
        super(context);
        this.f35888v2 = true;
        this.C2 = true;
        this.K2 = true;
    }

    public boolean M(int i10) {
        RectF bitmapRect = getBitmapRect();
        F(bitmapRect, this.f35915w);
        Rect rect = new Rect();
        getGlobalVisibleRect(rect);
        if (bitmapRect == null) {
            return false;
        }
        float f10 = bitmapRect.right;
        int i11 = rect.right;
        return (f10 < ((float) i11) || i10 >= 0) ? ((double) Math.abs(bitmapRect.left - this.f35915w.left)) > 1.0d : Math.abs(f10 - ((float) i11)) > 1.0f;
    }

    public float N(float f10, float f11) {
        if (this.f35887v1 != 1) {
            this.f35887v1 = 1;
            return 1.0f;
        }
        float f12 = this.f35886k1;
        if ((2.0f * f12) + f10 <= f11) {
            return f10 + f12;
        }
        this.f35887v1 = -1;
        return f11;
    }

    public boolean O(MotionEvent motionEvent) {
        return true;
    }

    public boolean P(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        float x10 = motionEvent2.getX() - motionEvent.getX();
        float y10 = motionEvent2.getY() - motionEvent.getY();
        if (Math.abs(f10) <= 800.0f && Math.abs(f11) <= 800.0f) {
            return false;
        }
        this.f35899g = true;
        C(x10 / 2.0f, y10 / 2.0f, 300.0d);
        invalidate();
        return true;
    }

    public boolean Q(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        if (getScale() == 1.0f) {
            return false;
        }
        this.f35899g = true;
        B(-f10, -f11);
        invalidate();
        return true;
    }

    public boolean R(MotionEvent motionEvent) {
        return true;
    }

    public boolean S(MotionEvent motionEvent) {
        return true;
    }

    public boolean T(MotionEvent motionEvent) {
        if (getScale() >= getMinScale()) {
            return true;
        }
        H(getMinScale(), 50.0f);
        return true;
    }

    @Override // it.sephiroth.android.library.imagezoom.ImageViewTouchBase
    public void a(Drawable drawable, Matrix matrix, float f10, float f11) {
        super.a(drawable, matrix, f10, f11);
        this.f35886k1 = getMaxScale() / 3.0f;
    }

    public boolean getDoubleTapEnabled() {
        return this.f35888v2;
    }

    public GestureDetector.OnGestureListener getGestureListener() {
        return new a();
    }

    public ScaleGestureDetector.OnScaleGestureListener getScaleListener() {
        return new d();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.D.onTouchEvent(motionEvent);
        if (!this.D.isInProgress()) {
            this.f35885k0.onTouchEvent(motionEvent);
        }
        if ((motionEvent.getAction() & 255) != 1) {
            return true;
        }
        return T(motionEvent);
    }

    @Override // it.sephiroth.android.library.imagezoom.ImageViewTouchBase
    public void p(Context context, AttributeSet attributeSet, int i10) {
        super.p(context, attributeSet, i10);
        this.K0 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.C1 = getGestureListener();
        this.K1 = getScaleListener();
        this.D = new ScaleGestureDetector(getContext(), this.K1);
        this.f35885k0 = new GestureDetector(getContext(), this.C1, null, true);
        this.f35887v1 = 1;
    }

    public void setDoubleTapEnabled(boolean z10) {
        this.f35888v2 = z10;
    }

    public void setDoubleTapListener(b bVar) {
        this.E7 = bVar;
    }

    public void setScaleEnabled(boolean z10) {
        this.C2 = z10;
    }

    public void setScrollEnabled(boolean z10) {
        this.K2 = z10;
    }

    public void setSingleTapListener(c cVar) {
        this.F7 = cVar;
    }

    @Override // it.sephiroth.android.library.imagezoom.ImageViewTouchBase
    public void u(float f10) {
        if (f10 < getMinScale()) {
            H(getMinScale(), 50.0f);
        }
    }

    public ImageViewTouch(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ImageViewTouch(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f35888v2 = true;
        this.C2 = true;
        this.K2 = true;
    }
}
