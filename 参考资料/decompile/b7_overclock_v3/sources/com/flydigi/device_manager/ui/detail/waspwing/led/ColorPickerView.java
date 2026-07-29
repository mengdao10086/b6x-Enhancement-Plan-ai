package com.flydigi.device_manager.ui.detail.waspwing.led;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import ik.p;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import qk.v;

/* JADX INFO: loaded from: classes7.dex */
public final class ColorPickerView extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @yt.k
    public static final a f14758i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f14759j = 16.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f14760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f14761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f14762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f14763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f14764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final PointF f14765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @yt.k
    public da.b f14766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.l
    public ba.a f14767h;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public static final class b implements ba.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p<Integer, String, z1> f14768a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(p<? super Integer, ? super String, z1> pVar) {
            this.f14768a = pVar;
        }

        @Override // ba.a
        public void a(int i10, @yt.k String colorHex) {
            f0.p(colorHex, "colorHex");
            this.f14768a.r0(Integer.valueOf(i10), colorHex);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public ColorPickerView(@yt.k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public ColorPickerView(@yt.k Context context, @yt.l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ ColorPickerView(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public final int a(float f10, float f11) {
        float f12 = f10 - this.f14761b;
        double d10 = f11 - this.f14762c;
        double dSqrt = Math.sqrt(((double) (f12 * f12)) + (d10 * d10));
        float[] fArr = {0.0f, 0.0f, 1.0f};
        fArr[0] = ((float) ((Math.atan2(d10, -f12) / 3.141592653589793d) * ((double) 180.0f))) + 180;
        fArr[1] = v.t(0.0f, v.A(1.0f, (float) (dSqrt / ((double) this.f14760a))));
        return Color.HSVToColor(fArr);
    }

    public final void b(int i10) {
        ba.a aVar = this.f14767h;
        if (aVar != null) {
            aVar.a(i10, ca.b.a(i10));
        }
    }

    public final void c(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        int iA = a(x10, y10);
        this.f14764e = iA;
        b(iA);
        d(x10, y10);
    }

    public final void d(float f10, float f11) {
        float f12 = f10 - this.f14761b;
        float f13 = f11 - this.f14762c;
        double d10 = f13;
        double dSqrt = Math.sqrt(((double) (f12 * f12)) + (d10 * d10));
        float f14 = this.f14760a;
        if (dSqrt > f14) {
            float f15 = (float) dSqrt;
            f12 *= f14 / f15;
            f13 *= f14 / f15;
        }
        PointF pointF = this.f14765f;
        pointF.x = f12 + this.f14761b;
        pointF.y = f13 + this.f14762c;
        this.f14766g.setCurrentPoint(pointF);
    }

    public final int getColor() {
        return this.f14764e;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int iB = v.B(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(iB, 1073741824), View.MeasureSpec.makeMeasureSpec(iB, 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int paddingLeft = (i10 - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (i11 - getPaddingTop()) - getPaddingBottom();
        float fB = (v.B(paddingLeft, paddingTop) * 0.5f) - this.f14763d;
        this.f14760a = fB;
        if (fB < 0.0f) {
            return;
        }
        this.f14761b = paddingLeft * 0.5f;
        this.f14762c = paddingTop * 0.5f;
        setColor(this.f14764e);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@yt.k MotionEvent event) {
        f0.p(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0 && actionMasked != 1 && actionMasked != 2) {
            return super.onTouchEvent(event);
        }
        c(event);
        return true;
    }

    public final void setColor(int i10) {
        float[] fArr = new float[3];
        Color.colorToHSV(i10, fArr);
        float f10 = fArr[1] * this.f14760a;
        double d10 = (float) (((double) (fArr[0] / 180.0f)) * 3.141592653589793d);
        d((float) ((((double) f10) * Math.cos(d10)) + ((double) this.f14761b)), (float) ((((double) (-f10)) * Math.sin(d10)) + ((double) this.f14762c)));
        this.f14764e = i10;
    }

    public final void setColorListener(@yt.k p<? super Integer, ? super String, z1> listener) {
        f0.p(listener, "listener");
        this.f14767h = new b(listener);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        o5.c.b(this.f14766g, Boolean.valueOf(z10), false, 2, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @hk.i
    public ColorPickerView(@yt.k Context context, @yt.l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        this.f14763d = getResources().getDisplayMetrics().density * 16.0f;
        this.f14764e = -65281;
        this.f14765f = new PointF();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        Context context2 = getContext();
        f0.o(context2, "context");
        da.a aVar = new da.a(context2, null, 0, 0, 14, null);
        int i11 = (int) this.f14763d;
        aVar.setPadding(i11, i11, i11, i11);
        addView(aVar, layoutParams);
        Context context3 = getContext();
        f0.o(context3, "context");
        da.b bVar = new da.b(context3, null, 0, 0, 14, null);
        this.f14766g = bVar;
        bVar.setPointerRadius(this.f14763d);
        addView(this.f14766g, layoutParams);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public ColorPickerView(@yt.k Context context, @yt.l AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        f0.p(context, "context");
        this.f14763d = getResources().getDisplayMetrics().density * 16.0f;
        this.f14764e = -65281;
        this.f14765f = new PointF();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        Context context2 = getContext();
        f0.o(context2, "context");
        da.a aVar = new da.a(context2, null, 0, 0, 14, null);
        int i12 = (int) this.f14763d;
        aVar.setPadding(i12, i12, i12, i12);
        addView(aVar, layoutParams);
        Context context3 = getContext();
        f0.o(context3, "context");
        da.b bVar = new da.b(context3, null, 0, 0, 14, null);
        this.f14766g = bVar;
        bVar.setPointerRadius(this.f14763d);
        addView(this.f14766g, layoutParams);
    }
}
