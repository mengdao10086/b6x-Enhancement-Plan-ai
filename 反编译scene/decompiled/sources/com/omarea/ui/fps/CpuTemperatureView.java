package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.f92;
import a.fg2;
import a.h42;
import a.j51;
import a.k82;
import a.m42;
import a.oc2;
import a.py0;
import a.qc2;
import a.qe2;
import a.r62;
import a.vj0;
import a.wd2;
import a.x62;
import a.xd2;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class CpuTemperatureView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8427a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f4962a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f4963a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f4964a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4965a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4966a;

    @x62(c = "com.omarea.ui.fps.CpuTemperatureView$render$1", f = "CpuTemperatureView.kt", l = {94}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8428a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4968a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = CpuTemperatureView.this.new a(b62Var);
            aVar.f8428a = (wd2) obj;
            return aVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((a) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.b;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8428a;
                CpuTemperatureView cpuTemperatureView = CpuTemperatureView.this;
                cpuTemperatureView.f4964a = Bitmap.createBitmap(cpuTemperatureView.getWidth(), CpuTemperatureView.this.getHeight(), Bitmap.Config.ARGB_8888);
                CpuTemperatureView cpuTemperatureView2 = CpuTemperatureView.this;
                Bitmap bitmap = CpuTemperatureView.this.f4964a;
                f92.b(bitmap);
                cpuTemperatureView2.e(new Canvas(bitmap));
                fg2 fg2VarC = qe2.c();
                j51 j51Var = new j51(this, null);
                this.f4968a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, j51Var, this) == objC) {
                    return objC;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                h42.b(obj);
            }
            return m42.f6769a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpuTemperatureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4963a = new vj0();
        this.f4965a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f4966a = new Paint();
        f(attributeSet, 0);
    }

    public final int d(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x02b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(android.graphics.Canvas r31) {
        /*
            Method dump skipped, instruction units count: 792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.fps.CpuTemperatureView.e(android.graphics.Canvas):void");
    }

    public final void f(AttributeSet attributeSet, int i) {
        g();
        this.f4962a = new py0(getContext());
    }

    public final void g() {
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final long getSessionId() {
        return this.f8427a;
    }

    public final void h() {
        if (this.f8427a < 1) {
            return;
        }
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f4964a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f4964a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        h();
    }

    public final void setSessionId(long j) {
        if (this.f8427a != j) {
            this.f8427a = j;
            this.f4964a = null;
            invalidate();
        }
    }
}
