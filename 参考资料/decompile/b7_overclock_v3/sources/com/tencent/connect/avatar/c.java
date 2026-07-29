package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes5.dex */
public class c extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Matrix f22493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Matrix f22494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f22495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f22496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f22497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Bitmap f22498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f22499i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f22500j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f22501k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private PointF f22502l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private PointF f22503m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f22504n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f22505o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Rect f22506p;

    public c(Context context) {
        super(context);
        this.f22493c = new Matrix();
        this.f22494d = new Matrix();
        this.f22495e = 0;
        this.f22496f = 1.0f;
        this.f22497g = 1.0f;
        this.f22499i = false;
        this.f22491a = "TouchView";
        this.f22502l = new PointF();
        this.f22503m = new PointF();
        this.f22504n = 1.0f;
        this.f22505o = 0.0f;
        this.f22492b = false;
        Rect rect = new Rect();
        this.f22506p = rect;
        getDrawingRect(rect);
        a();
    }

    private void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        boolean z10;
        Animation translateAnimation;
        if (this.f22498h == null) {
            return;
        }
        float fWidth = this.f22506p.width();
        float fHeight = this.f22506p.height();
        float[] fArr = new float[9];
        this.f22493c.getValues(fArr);
        float f10 = fArr[2];
        float f11 = fArr[5];
        float f12 = fArr[0];
        float f13 = this.f22496f;
        if (f12 > f13) {
            float f14 = f13 / f12;
            this.f22505o = f14;
            Matrix matrix = this.f22493c;
            PointF pointF = this.f22503m;
            matrix.postScale(f14, f14, pointF.x, pointF.y);
            setImageMatrix(this.f22493c);
            float f15 = this.f22505o;
            float f16 = 1.0f / f15;
            float f17 = 1.0f / f15;
            PointF pointF2 = this.f22503m;
            translateAnimation = new ScaleAnimation(f16, 1.0f, f17, 1.0f, pointF2.x, pointF2.y);
        } else {
            float f18 = this.f22497g;
            if (f12 < f18) {
                float f19 = f18 / f12;
                this.f22505o = f19;
                Matrix matrix2 = this.f22493c;
                PointF pointF3 = this.f22503m;
                matrix2.postScale(f19, f19, pointF3.x, pointF3.y);
                float f20 = this.f22505o;
                PointF pointF4 = this.f22503m;
                translateAnimation = new ScaleAnimation(1.0f, f20, 1.0f, f20, pointF4.x, pointF4.y);
            } else {
                float width = this.f22498h.getWidth() * f12;
                float height = this.f22498h.getHeight() * f12;
                Rect rect = this.f22506p;
                int i10 = rect.left;
                float f21 = i10 - f10;
                int i11 = rect.top;
                float f22 = i11 - f11;
                if (f21 < 0.0f) {
                    f10 = i10;
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (f22 < 0.0f) {
                    f11 = i11;
                    z10 = true;
                }
                float f23 = height - f22;
                if (width - f21 < fWidth) {
                    f10 = i10 - (width - fWidth);
                    z10 = true;
                }
                if (f23 < fHeight) {
                    f11 = i11 - (height - fHeight);
                    z10 = true;
                }
                if (z10) {
                    float f24 = fArr[2] - f10;
                    float f25 = fArr[5] - f11;
                    fArr[2] = f10;
                    fArr[5] = f11;
                    this.f22493c.setValues(fArr);
                    setImageMatrix(this.f22493c);
                    translateAnimation = new TranslateAnimation(f24, 0.0f, f25, 0.0f);
                } else {
                    setImageMatrix(this.f22493c);
                    translateAnimation = null;
                }
            }
        }
        if (translateAnimation != null) {
            this.f22499i = true;
            translateAnimation.setDuration(300L);
            startAnimation(translateAnimation);
            new Thread(new Runnable() { // from class: com.tencent.connect.avatar.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Thread.sleep(300L);
                    } catch (InterruptedException e10) {
                        e10.printStackTrace();
                    }
                    c.this.post(new Runnable() { // from class: com.tencent.connect.avatar.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.clearAnimation();
                            c.this.b();
                        }
                    });
                    c.this.f22499i = false;
                }
            }).start();
        }
    }

    private void c() {
        if (this.f22498h == null) {
            return;
        }
        float[] fArr = {fMax, 0.0f, this.f22500j, 0.0f, fMax, height, 0.0f, 0.0f, 0.0f};
        this.f22493c.getValues(fArr);
        float fMax = Math.max(this.f22506p.width() / this.f22498h.getWidth(), this.f22506p.height() / this.f22498h.getHeight());
        this.f22500j = this.f22506p.left - (((this.f22498h.getWidth() * fMax) - this.f22506p.width()) / 2.0f);
        float height = this.f22506p.top - (((this.f22498h.getHeight() * fMax) - this.f22506p.height()) / 2.0f);
        this.f22501k = height;
        this.f22493c.setValues(fArr);
        float fMin = Math.min(2048.0f / this.f22498h.getWidth(), 2048.0f / this.f22498h.getHeight());
        this.f22496f = fMin;
        this.f22497g = fMax;
        if (fMin < fMax) {
            this.f22496f = fMax;
        }
        setImageMatrix(this.f22493c);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0089  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f22499i
            r1 = 1
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r6.getAction()
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r0 == 0) goto L90
            if (r0 == r1) goto L89
            r2 = 1092616192(0x41200000, float:10.0)
            r3 = 2
            if (r0 == r3) goto L37
            r4 = 5
            if (r0 == r4) goto L1d
            r6 = 6
            if (r0 == r6) goto L89
            goto Laf
        L1d:
            float r6 = r5.a(r6)
            r5.f22504n = r6
            int r6 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r6 <= 0) goto Laf
            android.graphics.Matrix r6 = r5.f22494d
            android.graphics.Matrix r0 = r5.f22493c
            r6.set(r0)
            android.graphics.PointF r6 = r5.f22503m
            r5.a(r6)
            r5.f22495e = r3
            goto Laf
        L37:
            int r0 = r5.f22495e
            if (r0 != r1) goto L5f
            android.graphics.Matrix r0 = r5.f22493c
            android.graphics.Matrix r2 = r5.f22494d
            r0.set(r2)
            float r0 = r6.getX()
            android.graphics.PointF r2 = r5.f22502l
            float r2 = r2.x
            float r0 = r0 - r2
            float r6 = r6.getY()
            android.graphics.PointF r2 = r5.f22502l
            float r2 = r2.y
            float r6 = r6 - r2
            android.graphics.Matrix r2 = r5.f22493c
            r2.postTranslate(r0, r6)
            android.graphics.Matrix r6 = r5.f22493c
            r5.setImageMatrix(r6)
            goto Laf
        L5f:
            if (r0 != r3) goto Laf
            android.graphics.Matrix r0 = r5.f22493c
            r0.set(r0)
            float r6 = r5.a(r6)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 <= 0) goto L83
            android.graphics.Matrix r0 = r5.f22493c
            android.graphics.Matrix r2 = r5.f22494d
            r0.set(r2)
            float r0 = r5.f22504n
            float r6 = r6 / r0
            android.graphics.Matrix r0 = r5.f22493c
            android.graphics.PointF r2 = r5.f22503m
            float r3 = r2.x
            float r2 = r2.y
            r0.postScale(r6, r6, r3, r2)
        L83:
            android.graphics.Matrix r6 = r5.f22493c
            r5.setImageMatrix(r6)
            goto Laf
        L89:
            r5.b()
            r6 = 0
            r5.f22495e = r6
            goto Laf
        L90:
            android.graphics.Matrix r0 = r5.f22493c
            android.graphics.Matrix r2 = r5.getImageMatrix()
            r0.set(r2)
            android.graphics.Matrix r0 = r5.f22494d
            android.graphics.Matrix r2 = r5.f22493c
            r0.set(r2)
            android.graphics.PointF r0 = r5.f22502l
            float r2 = r6.getX()
            float r6 = r6.getY()
            r0.set(r2, r6)
            r5.f22495e = r1
        Laf:
            r5.f22492b = r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.connect.avatar.c.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f22498h = bitmap;
        if (bitmap != null) {
            this.f22498h = bitmap;
        }
    }

    private float a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x10 = motionEvent.getX(0) - motionEvent.getX(1);
        float y10 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x10 * x10) + (y10 * y10));
    }

    public void a(Rect rect) {
        this.f22506p = rect;
        if (this.f22498h != null) {
            c();
        }
    }

    private void a(PointF pointF) {
        if (this.f22498h == null) {
            return;
        }
        float[] fArr = new float[9];
        this.f22493c.getValues(fArr);
        float f10 = fArr[2];
        float f11 = fArr[5];
        float f12 = fArr[0];
        float width = this.f22498h.getWidth() * f12;
        float height = this.f22498h.getHeight() * f12;
        Rect rect = this.f22506p;
        float f13 = rect.left - f10;
        if (f13 <= 1.0f) {
            f13 = 1.0f;
        }
        float f14 = (f10 + width) - rect.right;
        if (f14 <= 1.0f) {
            f14 = 1.0f;
        }
        float fWidth = (rect.width() * f13) / (f14 + f13);
        Rect rect2 = this.f22506p;
        float f15 = fWidth + rect2.left;
        float f16 = rect2.top - f11;
        float f17 = (f11 + height) - rect2.bottom;
        if (f16 <= 1.0f) {
            f16 = 1.0f;
        }
        pointF.set(f15, ((rect2.height() * f16) / ((f17 > 1.0f ? f17 : 1.0f) + f16)) + this.f22506p.top);
    }
}
