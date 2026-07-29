package com.github.dhaval2404.colorpicker;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import f0.v;
import hk.i;
import ik.p;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.z1;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes3.dex */
@d0(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u0001\u001eB'\b\u0017\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u0012\b\b\u0002\u0010.\u001a\u00020\u0002¢\u0006\u0004\b/\u00100B+\b\u0017\u0012\u0006\u0010+\u001a\u00020*\u0012\b\u0010-\u001a\u0004\u0018\u00010,\u0012\u0006\u0010.\u001a\u00020\u0002\u0012\u0006\u00101\u001a\u00020\u0002¢\u0006\u0004\b/\u00102J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0014J(\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0017J\u0006\u0010\u0010\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002J \u0010\u0016\u001a\u00020\u00052\u0018\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00050\u0013J\u0010\u0010\u0017\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0002H\u0002R\u0016\u0010 \u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001fR\u0016\u0010#\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u00064"}, d2 = {"Lcom/github/dhaval2404/colorpicker/ColorPickerView;", "Landroid/widget/FrameLayout;", "", "widthMeasureSpec", "heightMeasureSpec", "Lkotlin/z1;", "onMeasure", "w", "h", "oldw", "oldh", "onSizeChanged", "Landroid/view/MotionEvent;", v.I0, "", "onTouchEvent", "getColor", "color", "setColor", "Lkotlin/Function2;", "", "listener", "setColorListener", "d", "", "eventX", "eventY", "b", "e", "c", "a", "F", "radius", "centerX", "centerY", "pointerRadiusPx", "I", "currentColor", "Landroid/graphics/PointF;", "f", "Landroid/graphics/PointF;", "currentPoint", "Landroid/content/Context;", com.umeng.analytics.pro.d.R, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "i", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
public final class ColorPickerView extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @k
    public static final a f16465i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f16466j = 8.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f16467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f16468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f16469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f16470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f16471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final PointF f16472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public da.b f16473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @l
    public ba.a f16474h;

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/github/dhaval2404/colorpicker/ColorPickerView$a;", "", "", "COLOR_POINTER_RADIUS_DP", "F", "<init>", "()V", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @d0(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\b"}, d2 = {"com/github/dhaval2404/colorpicker/ColorPickerView$b", "Lba/a;", "", "color", "", "colorHex", "Lkotlin/z1;", "a", "colorpicker_release"}, k = 1, mv = {1, 5, 1})
    public static final class b implements ba.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p<Integer, String, z1> f16475a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(p<? super Integer, ? super String, z1> pVar) {
            this.f16475a = pVar;
        }

        @Override // ba.a
        public void a(int i10, @k String colorHex) {
            f0.p(colorHex, "colorHex");
            this.f16475a.r0(Integer.valueOf(i10), colorHex);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public ColorPickerView(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public ColorPickerView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ ColorPickerView(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public void a() {
    }

    public final int b(float f10, float f11) {
        float f12 = f10 - this.f16468b;
        double d10 = f11 - this.f16469c;
        double dSqrt = Math.sqrt(((double) (f12 * f12)) + (d10 * d10));
        float[] fArr = {0.0f, 0.0f, 1.0f};
        fArr[0] = ((float) ((Math.atan2(d10, -f12) / 3.141592653589793d) * ((double) 180.0f))) + 180;
        fArr[1] = qk.v.t(0.0f, qk.v.A(1.0f, (float) (dSqrt / ((double) this.f16467a))));
        return Color.HSVToColor(fArr);
    }

    public final void c(int i10) {
        ba.a aVar = this.f16474h;
        if (aVar == null) {
            return;
        }
        ca.b bVar = ca.b.f10676a;
        aVar.a(i10, ca.b.a(i10));
    }

    public final void d(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        int iB = b(x10, y10);
        this.f16471e = iB;
        c(iB);
        e(x10, y10);
    }

    public final void e(float f10, float f11) {
        float f12 = f10 - this.f16468b;
        float f13 = f11 - this.f16469c;
        double d10 = f13;
        double dSqrt = Math.sqrt(((double) (f12 * f12)) + (d10 * d10));
        float f14 = this.f16467a;
        if (dSqrt > f14) {
            float f15 = (float) dSqrt;
            f12 *= f14 / f15;
            f13 *= f14 / f15;
        }
        PointF pointF = this.f16472f;
        pointF.x = f12 + this.f16468b;
        pointF.y = f13 + this.f16469c;
        this.f16473g.setCurrentPoint(pointF);
    }

    public final int getColor() {
        return this.f16471e;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        int iB = qk.v.B(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(iB, 1073741824), View.MeasureSpec.makeMeasureSpec(iB, 1073741824));
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        int paddingLeft = (i10 - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (i11 - getPaddingTop()) - getPaddingBottom();
        float fB = (qk.v.B(paddingLeft, paddingTop) * 0.5f) - this.f16470d;
        this.f16467a = fB;
        if (fB < 0.0f) {
            return;
        }
        this.f16468b = paddingLeft * 0.5f;
        this.f16469c = paddingTop * 0.5f;
        setColor(this.f16471e);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@k MotionEvent event) {
        f0.p(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0 && actionMasked != 1 && actionMasked != 2) {
            return super.onTouchEvent(event);
        }
        d(event);
        return true;
    }

    public final void setColor(int i10) {
        float[] fArr = new float[3];
        Color.colorToHSV(i10, fArr);
        float f10 = fArr[1] * this.f16467a;
        double d10 = (float) (((double) (fArr[0] / 180.0f)) * 3.141592653589793d);
        e((float) ((((double) f10) * Math.cos(d10)) + ((double) this.f16468b)), (float) ((((double) (-f10)) * Math.sin(d10)) + ((double) this.f16469c)));
        this.f16471e = i10;
    }

    public final void setColorListener(@k p<? super Integer, ? super String, z1> listener) {
        f0.p(listener, "listener");
        this.f16474h = new b(listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public ColorPickerView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        this.f16470d = getResources().getDisplayMetrics().density * 8.0f;
        this.f16471e = -65281;
        this.f16472f = new PointF();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        Context context2 = getContext();
        f0.o(context2, "context");
        da.a aVar = new da.a(context2, null, 0, 0, 14, null);
        int i11 = (int) this.f16470d;
        aVar.setPadding(i11, i11, i11, i11);
        addView(aVar, layoutParams);
        Context context3 = getContext();
        f0.o(context3, "context");
        da.b bVar = new da.b(context3, null, 0, 0, 14, null);
        this.f16473g = bVar;
        bVar.setPointerRadius(this.f16470d);
        addView(this.f16473g, layoutParams);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @TargetApi(21)
    public ColorPickerView(@k Context context, @l AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        f0.p(context, "context");
        this.f16470d = getResources().getDisplayMetrics().density * 8.0f;
        this.f16471e = -65281;
        this.f16472f = new PointF();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        Context context2 = getContext();
        f0.o(context2, "context");
        da.a aVar = new da.a(context2, null, 0, 0, 14, null);
        int i12 = (int) this.f16470d;
        aVar.setPadding(i12, i12, i12, i12);
        addView(aVar, layoutParams);
        Context context3 = getContext();
        f0.o(context3, "context");
        da.b bVar = new da.b(context3, null, 0, 0, 14, null);
        this.f16473g = bVar;
        bVar.setPointerRadius(this.f16470d);
        addView(this.f16473g, layoutParams);
    }
}
