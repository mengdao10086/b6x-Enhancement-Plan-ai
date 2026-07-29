package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.ui.l;
import g.p0;
import g.v0;
import hd.u0;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public class b extends View implements l {
    public static final int G7 = 4;
    public static final int H7 = 26;
    public static final int I7 = 4;
    public static final int J7 = 12;
    public static final int K7 = 0;
    public static final int L7 = 16;
    public static final int M7 = -1;
    public static final int N7 = 872415231;
    public static final int O7 = -855638017;
    public static final int P7 = -1;
    public static final int Q7 = -1291845888;
    public static final int R7 = 872414976;
    public static final int S7 = 0;
    public static final int T7 = 1;
    public static final int U7 = -50;
    public static final int V7 = 3;
    public static final long W7 = 1000;
    public static final int X7 = 20;
    public static final float Y7 = 1.0f;
    public static final float Z7 = 0.0f;

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final String f18697a8 = "android.widget.SeekBar";
    public int A;
    public long B;
    public int C;
    public long C1;
    public long C2;
    public Rect D;

    @p0
    public long[] E7;

    @p0
    public boolean[] F7;
    public float K0;
    public long K1;
    public int K2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f18698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f18699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f18700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f18701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f18702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Paint f18703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f18704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f18705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Paint f18706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Paint f18707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public final Drawable f18708k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public ValueAnimator f18709k0;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f18710k1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f18711l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f18712m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f18713n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f18714o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f18715p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f18716q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f18717r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f18718s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f18719t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final StringBuilder f18720u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Formatter f18721v;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public boolean f18722v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public long f18723v2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Runnable f18724w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CopyOnWriteArraySet<l.a> f18725x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Point f18726y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final float f18727z;

    public b(Context context) {
        this(context, null);
    }

    public static int f(float f10, int i10) {
        return (int) ((i10 * f10) + 0.5f);
    }

    private long getPositionIncrement() {
        long j10 = this.B;
        if (j10 != ya.g.f56663b) {
            return j10;
        }
        long j11 = this.K1;
        if (j11 == ya.g.f56663b) {
            return 0L;
        }
        return j11 / ((long) this.A);
    }

    private String getProgressText() {
        return u0.p0(this.f18720u, this.f18721v, this.f18723v2);
    }

    private long getScrubberPosition() {
        if (this.f18699b.width() <= 0 || this.K1 == ya.g.f56663b) {
            return 0L;
        }
        return (((long) this.f18701d.width()) * this.K1) / ((long) this.f18699b.width());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        x(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(ValueAnimator valueAnimator) {
        this.K0 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f18698a);
    }

    public static int o(float f10, int i10) {
        return (int) (i10 / f10);
    }

    public static boolean s(Drawable drawable, int i10) {
        return u0.f31154a >= 23 && drawable.setLayoutDirection(i10);
    }

    public final void A(long j10) {
        if (this.C1 == j10) {
            return;
        }
        this.C1 = j10;
        Iterator<l.a> it2 = this.f18725x.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, j10);
        }
    }

    @Override // com.google.android.exoplayer2.ui.l
    public void a(@p0 long[] jArr, @p0 boolean[] zArr, int i10) {
        hd.a.a(i10 == 0 || !(jArr == null || zArr == null));
        this.K2 = i10;
        this.E7 = jArr;
        this.F7 = zArr;
        y();
    }

    @Override // com.google.android.exoplayer2.ui.l
    public void b(l.a aVar) {
        this.f18725x.remove(aVar);
    }

    @Override // com.google.android.exoplayer2.ui.l
    public void c(l.a aVar) {
        hd.a.g(aVar);
        this.f18725x.add(aVar);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        z();
    }

    public final void g(Canvas canvas) {
        if (this.K1 <= 0) {
            return;
        }
        Rect rect = this.f18701d;
        int iT = u0.t(rect.right, rect.left, this.f18699b.right);
        int iCenterY = this.f18701d.centerY();
        if (this.f18708k == null) {
            canvas.drawCircle(iT, iCenterY, (int) ((((this.f18722v1 || isFocused()) ? this.f18717r : isEnabled() ? this.f18715p : this.f18716q) * this.K0) / 2.0f), this.f18707j);
            return;
        }
        int intrinsicWidth = ((int) (r2.getIntrinsicWidth() * this.K0)) / 2;
        int intrinsicHeight = ((int) (this.f18708k.getIntrinsicHeight() * this.K0)) / 2;
        this.f18708k.setBounds(iT - intrinsicWidth, iCenterY - intrinsicHeight, iT + intrinsicWidth, iCenterY + intrinsicHeight);
        this.f18708k.draw(canvas);
    }

    @Override // com.google.android.exoplayer2.ui.l
    public long getPreferredUpdateDelay() {
        int iO = o(this.f18727z, this.f18699b.width());
        if (iO != 0) {
            long j10 = this.K1;
            if (j10 != 0 && j10 != ya.g.f56663b) {
                return j10 / ((long) iO);
            }
        }
        return Long.MAX_VALUE;
    }

    public final void h(Canvas canvas) {
        int iHeight = this.f18699b.height();
        int iCenterY = this.f18699b.centerY() - (iHeight / 2);
        int i10 = iHeight + iCenterY;
        if (this.K1 <= 0) {
            Rect rect = this.f18699b;
            canvas.drawRect(rect.left, iCenterY, rect.right, i10, this.f18704g);
            return;
        }
        Rect rect2 = this.f18700c;
        int i11 = rect2.left;
        int i12 = rect2.right;
        int iMax = Math.max(Math.max(this.f18699b.left, i12), this.f18701d.right);
        int i13 = this.f18699b.right;
        if (iMax < i13) {
            canvas.drawRect(iMax, iCenterY, i13, i10, this.f18704g);
        }
        int iMax2 = Math.max(i11, this.f18701d.right);
        if (i12 > iMax2) {
            canvas.drawRect(iMax2, iCenterY, i12, i10, this.f18703f);
        }
        if (this.f18701d.width() > 0) {
            Rect rect3 = this.f18701d;
            canvas.drawRect(rect3.left, iCenterY, rect3.right, i10, this.f18702e);
        }
        if (this.K2 == 0) {
            return;
        }
        long[] jArr = (long[]) hd.a.g(this.E7);
        boolean[] zArr = (boolean[]) hd.a.g(this.F7);
        int i14 = this.f18714o / 2;
        for (int i15 = 0; i15 < this.K2; i15++) {
            int iWidth = ((int) ((((long) this.f18699b.width()) * u0.u(jArr[i15], 0L, this.K1)) / this.K1)) - i14;
            Rect rect4 = this.f18699b;
            canvas.drawRect(rect4.left + Math.min(rect4.width() - this.f18714o, Math.max(0, iWidth)), iCenterY, r10 + this.f18714o, i10, zArr[i15] ? this.f18706i : this.f18705h);
        }
    }

    public void i(long j10) {
        if (this.f18709k0.isStarted()) {
            this.f18709k0.cancel();
        }
        this.f18709k0.setFloatValues(this.K0, 0.0f);
        this.f18709k0.setDuration(j10);
        this.f18709k0.start();
    }

    public void j(boolean z10) {
        if (this.f18709k0.isStarted()) {
            this.f18709k0.cancel();
        }
        this.f18710k1 = z10;
        this.K0 = 0.0f;
        invalidate(this.f18698a);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f18708k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    public final boolean k(float f10, float f11) {
        return this.f18698a.contains((int) f10, (int) f11);
    }

    public final void n(float f10) {
        Rect rect = this.f18701d;
        Rect rect2 = this.f18699b;
        rect.right = u0.t((int) f10, rect2.left, rect2.right);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        h(canvas);
        g(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z10, int i10, @p0 Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (!this.f18722v1 || z10) {
            return;
        }
        x(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName(f18697a8);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(f18697a8);
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.K1 <= 0) {
            return;
        }
        if (u0.f31154a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(8192);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L30
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L27
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L27;
                default: goto L12;
            }
        L12:
            goto L30
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.q(r0)
            if (r0 == 0) goto L30
            java.lang.Runnable r5 = r4.f18724w
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.f18724w
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L27:
            boolean r0 = r4.f18722v1
            if (r0 == 0) goto L30
            r5 = 0
            r4.x(r5)
            return r3
        L30:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int paddingBottom;
        int iMax;
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i14 - getPaddingRight();
        int i16 = this.f18710k1 ? 0 : this.f18718s;
        if (this.f18713n == 1) {
            paddingBottom = (i15 - getPaddingBottom()) - this.f18712m;
            int paddingBottom2 = i15 - getPaddingBottom();
            int i17 = this.f18711l;
            iMax = (paddingBottom2 - i17) - Math.max(i16 - (i17 / 2), 0);
        } else {
            paddingBottom = (i15 - this.f18712m) / 2;
            iMax = (i15 - this.f18711l) / 2;
        }
        this.f18698a.set(paddingLeft, paddingBottom, paddingRight, this.f18712m + paddingBottom);
        Rect rect = this.f18699b;
        Rect rect2 = this.f18698a;
        rect.set(rect2.left + i16, iMax, rect2.right - i16, this.f18711l + iMax);
        if (u0.f31154a >= 29) {
            t(i14, i15);
        }
        y();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == 0) {
            size = this.f18712m;
        } else if (mode != 1073741824) {
            size = Math.min(this.f18712m, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i10), size);
        z();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        Drawable drawable = this.f18708k;
        if (drawable == null || !s(drawable, i10)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L76
            long r2 = r7.K1
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L10
            goto L76
        L10:
            android.graphics.Point r0 = r7.p(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L5d
            r5 = 3
            if (r3 == r4) goto L4e
            r6 = 2
            if (r3 == r6) goto L28
            if (r3 == r5) goto L4e
            goto L76
        L28:
            boolean r8 = r7.f18722v1
            if (r8 == 0) goto L76
            int r8 = r7.f18719t
            if (r0 >= r8) goto L3a
            int r8 = r7.C
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.n(r8)
            goto L40
        L3a:
            r7.C = r2
            float r8 = (float) r2
            r7.n(r8)
        L40:
            long r0 = r7.getScrubberPosition()
            r7.A(r0)
            r7.y()
            r7.invalidate()
            return r4
        L4e:
            boolean r0 = r7.f18722v1
            if (r0 == 0) goto L76
            int r8 = r8.getAction()
            if (r8 != r5) goto L59
            r1 = 1
        L59:
            r7.x(r1)
            return r4
        L5d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.k(r8, r0)
            if (r0 == 0) goto L76
            r7.n(r8)
            long r0 = r7.getScrubberPosition()
            r7.w(r0)
            r7.y()
            r7.invalidate()
            return r4
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.b.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final Point p(MotionEvent motionEvent) {
        this.f18726y.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f18726y;
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i10, @p0 Bundle bundle) {
        if (super.performAccessibilityAction(i10, bundle)) {
            return true;
        }
        if (this.K1 <= 0) {
            return false;
        }
        if (i10 == 8192) {
            if (q(-getPositionIncrement())) {
                x(false);
            }
        } else {
            if (i10 != 4096) {
                return false;
            }
            if (q(getPositionIncrement())) {
                x(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public final boolean q(long j10) {
        long j11 = this.K1;
        if (j11 <= 0) {
            return false;
        }
        long j12 = this.f18722v1 ? this.C1 : this.f18723v2;
        long jU = u0.u(j12 + j10, 0L, j11);
        if (jU == j12) {
            return false;
        }
        if (this.f18722v1) {
            A(jU);
        } else {
            w(jU);
        }
        y();
        return true;
    }

    public final boolean r(Drawable drawable) {
        return u0.f31154a >= 23 && s(drawable, getLayoutDirection());
    }

    public void setAdMarkerColor(@g.l int i10) {
        this.f18705h.setColor(i10);
        invalidate(this.f18698a);
    }

    public void setBufferedColor(@g.l int i10) {
        this.f18703f.setColor(i10);
        invalidate(this.f18698a);
    }

    @Override // com.google.android.exoplayer2.ui.l
    public void setBufferedPosition(long j10) {
        this.C2 = j10;
        y();
    }

    @Override // com.google.android.exoplayer2.ui.l
    public void setDuration(long j10) {
        this.K1 = j10;
        if (this.f18722v1 && j10 == ya.g.f56663b) {
            x(true);
        }
        y();
    }

    @Override // android.view.View, com.google.android.exoplayer2.ui.l
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (!this.f18722v1 || z10) {
            return;
        }
        x(true);
    }

    @Override // com.google.android.exoplayer2.ui.l
    public void setKeyCountIncrement(int i10) {
        hd.a.a(i10 > 0);
        this.A = i10;
        this.B = ya.g.f56663b;
    }

    @Override // com.google.android.exoplayer2.ui.l
    public void setKeyTimeIncrement(long j10) {
        hd.a.a(j10 > 0);
        this.A = -1;
        this.B = j10;
    }

    public void setPlayedAdMarkerColor(@g.l int i10) {
        this.f18706i.setColor(i10);
        invalidate(this.f18698a);
    }

    public void setPlayedColor(@g.l int i10) {
        this.f18702e.setColor(i10);
        invalidate(this.f18698a);
    }

    @Override // com.google.android.exoplayer2.ui.l
    public void setPosition(long j10) {
        this.f18723v2 = j10;
        setContentDescription(getProgressText());
        y();
    }

    public void setScrubberColor(@g.l int i10) {
        this.f18707j.setColor(i10);
        invalidate(this.f18698a);
    }

    public void setUnplayedColor(@g.l int i10) {
        this.f18704g.setColor(i10);
        invalidate(this.f18698a);
    }

    @v0(29)
    public final void t(int i10, int i11) {
        Rect rect = this.D;
        if (rect != null && rect.width() == i10 && this.D.height() == i11) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i10, i11);
        this.D = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    public void u() {
        if (this.f18709k0.isStarted()) {
            this.f18709k0.cancel();
        }
        this.f18710k1 = false;
        this.K0 = 1.0f;
        invalidate(this.f18698a);
    }

    public void v(long j10) {
        if (this.f18709k0.isStarted()) {
            this.f18709k0.cancel();
        }
        this.f18710k1 = false;
        this.f18709k0.setFloatValues(this.K0, 1.0f);
        this.f18709k0.setDuration(j10);
        this.f18709k0.start();
    }

    public final void w(long j10) {
        this.C1 = j10;
        this.f18722v1 = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator<l.a> it2 = this.f18725x.iterator();
        while (it2.hasNext()) {
            it2.next().d(this, j10);
        }
    }

    public final void x(boolean z10) {
        removeCallbacks(this.f18724w);
        this.f18722v1 = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator<l.a> it2 = this.f18725x.iterator();
        while (it2.hasNext()) {
            it2.next().c(this, this.C1, z10);
        }
    }

    public final void y() {
        this.f18700c.set(this.f18699b);
        this.f18701d.set(this.f18699b);
        long j10 = this.f18722v1 ? this.C1 : this.f18723v2;
        if (this.K1 > 0) {
            int iWidth = (int) ((((long) this.f18699b.width()) * this.C2) / this.K1);
            Rect rect = this.f18700c;
            Rect rect2 = this.f18699b;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((((long) this.f18699b.width()) * j10) / this.K1);
            Rect rect3 = this.f18701d;
            Rect rect4 = this.f18699b;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.f18700c;
            int i10 = this.f18699b.left;
            rect5.right = i10;
            this.f18701d.right = i10;
        }
        invalidate(this.f18698a);
    }

    public final void z() {
        Drawable drawable = this.f18708k;
        if (drawable != null && drawable.isStateful() && this.f18708k.setState(getDrawableState())) {
            invalidate();
        }
    }

    public b(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @p0 AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, attributeSet);
    }

    public b(Context context, @p0 AttributeSet attributeSet, int i10, @p0 AttributeSet attributeSet2) {
        this(context, attributeSet, i10, attributeSet2, 0);
    }

    public b(Context context, @p0 AttributeSet attributeSet, int i10, @p0 AttributeSet attributeSet2, int i11) {
        super(context, attributeSet, i10);
        this.f18698a = new Rect();
        this.f18699b = new Rect();
        this.f18700c = new Rect();
        this.f18701d = new Rect();
        Paint paint = new Paint();
        this.f18702e = paint;
        Paint paint2 = new Paint();
        this.f18703f = paint2;
        Paint paint3 = new Paint();
        this.f18704g = paint3;
        Paint paint4 = new Paint();
        this.f18705h = paint4;
        Paint paint5 = new Paint();
        this.f18706i = paint5;
        Paint paint6 = new Paint();
        this.f18707j = paint6;
        paint6.setAntiAlias(true);
        this.f18725x = new CopyOnWriteArraySet<>();
        this.f18726y = new Point();
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f18727z = f10;
        this.f18719t = f(f10, -50);
        int iF = f(f10, 4);
        int iF2 = f(f10, 26);
        int iF3 = f(f10, 4);
        int iF4 = f(f10, 12);
        int iF5 = f(f10, 0);
        int iF6 = f(f10, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.DefaultTimeBar, i10, i11);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.DefaultTimeBar_scrubber_drawable);
                this.f18708k = drawable;
                if (drawable != null) {
                    r(drawable);
                    iF2 = Math.max(drawable.getMinimumHeight(), iF2);
                }
                this.f18711l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_bar_height, iF);
                this.f18712m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_touch_target_height, iF2);
                this.f18713n = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_bar_gravity, 0);
                this.f18714o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_ad_marker_width, iF3);
                this.f18715p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_enabled_size, iF4);
                this.f18716q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_disabled_size, iF5);
                this.f18717r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_dragged_size, iF6);
                int i12 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_color, -1);
                int i13 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_scrubber_color, -1);
                int i14 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_buffered_color, O7);
                int i15 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_unplayed_color, N7);
                int i16 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_ad_marker_color, Q7);
                int i17 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_ad_marker_color, R7);
                paint.setColor(i12);
                paint6.setColor(i13);
                paint2.setColor(i14);
                paint3.setColor(i15);
                paint4.setColor(i16);
                paint5.setColor(i17);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        } else {
            this.f18711l = iF;
            this.f18712m = iF2;
            this.f18713n = 0;
            this.f18714o = iF3;
            this.f18715p = iF4;
            this.f18716q = iF5;
            this.f18717r = iF6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(O7);
            paint3.setColor(N7);
            paint4.setColor(Q7);
            paint5.setColor(R7);
            this.f18708k = null;
        }
        StringBuilder sb2 = new StringBuilder();
        this.f18720u = sb2;
        this.f18721v = new Formatter(sb2, Locale.getDefault());
        this.f18724w = new Runnable() { // from class: cd.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f10868a.l();
            }
        };
        Drawable drawable2 = this.f18708k;
        if (drawable2 != null) {
            this.f18718s = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f18718s = (Math.max(this.f18716q, Math.max(this.f18715p, this.f18717r)) + 1) / 2;
        }
        this.K0 = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f18709k0 = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cd.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f10866a.m(valueAnimator2);
            }
        });
        this.K1 = ya.g.f56663b;
        this.B = ya.g.f56663b;
        this.A = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
