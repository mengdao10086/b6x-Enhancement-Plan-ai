package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.f92;
import a.fg2;
import a.fy0;
import a.h42;
import a.jn0;
import a.k82;
import a.kl0;
import a.m42;
import a.oc2;
import a.py0;
import a.qc2;
import a.qe2;
import a.r62;
import a.s51;
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
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ThreadCPUView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8444a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public fy0 f5020a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public jn0 f5021a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f5022a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f5023a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f5024a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f5025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f5026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String[]> f5027a;

    @x62(c = "com.omarea.ui.fps.ThreadCPUView$render$1", f = "ThreadCPUView.kt", l = {260}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8445a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f5029a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f5030b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = ThreadCPUView.this.new a(b62Var);
            aVar.f8445a = (wd2) obj;
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
                wd2 wd2Var = this.f8445a;
                ThreadCPUView threadCPUView = ThreadCPUView.this;
                threadCPUView.f5024a = Bitmap.createBitmap(threadCPUView.getWidth(), ThreadCPUView.this.getHeight(), Bitmap.Config.ARGB_8888);
                Bitmap bitmap = ThreadCPUView.this.f5024a;
                f92.b(bitmap);
                Canvas canvas = new Canvas(bitmap);
                ThreadCPUView.this.e(canvas);
                fg2 fg2VarC = qe2.c();
                s51 s51Var = new s51(this, null);
                this.f5029a = wd2Var;
                this.f5030b = canvas;
                this.b = 1;
                if (oc2.g(fg2VarC, s51Var, this) == objC) {
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
    public ThreadCPUView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f5023a = new vj0();
        this.f5026a = new Paint();
        this.f5025a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f5021a = new jn0();
        this.f5020a = new fy0();
        this.f5027a = new kl0().f();
        f(attributeSet, 0);
    }

    public final int d(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(android.graphics.Canvas r29) {
        /*
            Method dump skipped, instruction units count: 874
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.fps.ThreadCPUView.e(android.graphics.Canvas):void");
    }

    public final void f(AttributeSet attributeSet, int i) {
        g();
        this.f5022a = new py0(getContext());
    }

    public final void g() {
    }

    public final ArrayList<String[]> getClusters() {
        return this.f5027a;
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final long getSessionId() {
        return this.f8444a;
    }

    public final void h() {
        if (this.f8444a < 1) {
            return;
        }
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    public final void i(long j, jn0 jn0Var, fy0 fy0Var) {
        f92.d(jn0Var, "thread");
        f92.d(fy0Var, "timeRange");
        this.f8444a = j;
        this.f5021a = jn0Var;
        this.f5020a = fy0Var;
        this.f5024a = null;
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f5024a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f5024a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        h();
    }
}
