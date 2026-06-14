package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.f92;
import a.fg2;
import a.h42;
import a.k82;
import a.m42;
import a.oc2;
import a.py0;
import a.q51;
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
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class GpuLoadView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8440a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f5005a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f5006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f5007a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f5008a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f5009a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f5010a;
    public final int b;

    @x62(c = "com.omarea.ui.fps.GpuLoadView$render$1", f = "GpuLoadView.kt", l = {313}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8441a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5012a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = GpuLoadView.this.new a(b62Var);
            aVar.f8441a = (wd2) obj;
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
                wd2 wd2Var = this.f8441a;
                GpuLoadView gpuLoadView = GpuLoadView.this;
                gpuLoadView.f5008a = Bitmap.createBitmap(gpuLoadView.getWidth(), GpuLoadView.this.getHeight(), Bitmap.Config.ARGB_8888);
                GpuLoadView gpuLoadView2 = GpuLoadView.this;
                Bitmap bitmap = GpuLoadView.this.f5008a;
                f92.b(bitmap);
                gpuLoadView2.f(new Canvas(bitmap));
                fg2 fg2VarC = qe2.c();
                q51 q51Var = new q51(this, null);
                this.f5012a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, q51Var, this) == objC) {
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
    public GpuLoadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f5007a = new vj0();
        this.f5010a = new Paint();
        this.f5009a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f8440a = Color.parseColor("#87d3ff");
        this.b = Color.parseColor("#1474e4");
        g(attributeSet, 0);
    }

    public final int d(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0138 A[LOOP:0: B:8:0x00ba->B:23:0x0138, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0145 A[EDGE_INSN: B:31:0x0145->B:24:0x0145 BREAK  A[LOOP:0: B:8:0x00ba->B:23:0x0138], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(android.graphics.Canvas r29, float r30) {
        /*
            Method dump skipped, instruction units count: 455
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.fps.GpuLoadView.e(android.graphics.Canvas, float):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0308 A[LOOP:2: B:31:0x028c->B:52:0x0308, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0356 A[LOOP:3: B:54:0x0350->B:56:0x0356, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x030b A[EDGE_INSN: B:63:0x030b->B:53:0x030b BREAK  A[LOOP:2: B:31:0x028c->B:52:0x0308], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.graphics.Canvas r34) {
        /*
            Method dump skipped, instruction units count: 913
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.fps.GpuLoadView.f(android.graphics.Canvas):void");
    }

    public final void g(AttributeSet attributeSet, int i) {
        h();
        this.f5006a = new py0(getContext());
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final long getSessionId() {
        return this.f5005a;
    }

    public final void h() {
    }

    public final void i() {
        if (this.f5005a < 1) {
            return;
        }
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f5008a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f5008a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        i();
    }

    public final void setSessionId(long j) {
        if (this.f5005a != j) {
            this.f5005a = j;
            this.f5008a = null;
            invalidate();
        }
    }
}
