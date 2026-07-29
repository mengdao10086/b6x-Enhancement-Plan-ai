package com.flydigi.device_manager.ui.detail.waspwing.led;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import kotlin.z1;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nColorCircleView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ColorCircleView.kt\ncom/flydigi/device_manager/ui/detail/waspwing/led/ColorCircleView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,52:1\n1#2:53\n*E\n"})
public final class a extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f14779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public Paint f14780b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public Paint f14781c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public a(@yt.k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public a(@yt.k Context context, @yt.l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ a(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public final int getCurrentColor$device_manager_officialRelease() {
        return this.f14779a;
    }

    @Override // android.view.View
    public void onDraw(@yt.k Canvas canvas) {
        f0.p(canvas, "canvas");
        Paint paint = this.f14780b;
        paint.setColor(this.f14779a);
        z1 z1Var = z1.f38230a;
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - 2, paint);
        float width = getWidth() / 2;
        float height = getHeight() / 2;
        float width2 = (getWidth() / 2) - 1;
        Paint paint2 = this.f14781c;
        paint2.setColor(isSelected() ? -12303292 : -3355444);
        paint2.setStrokeWidth(isSelected() ? 2.0f : 1.0f);
        canvas.drawCircle(width, height, width2, paint2);
    }

    public final void setCurrentColor$device_manager_officialRelease(int i10) {
        this.f14779a = i10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @hk.i
    public a(@yt.k Context context, @yt.l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.FILL);
        this.f14780b = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.STROKE);
        this.f14781c = paint2;
    }
}
