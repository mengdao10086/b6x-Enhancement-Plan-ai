package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.f92;
import a.fg2;
import a.h42;
import a.i52;
import a.k82;
import a.l51;
import a.m42;
import a.m51;
import a.oc2;
import a.py0;
import a.qc2;
import a.qe2;
import a.r62;
import a.u42;
import a.vj0;
import a.wd2;
import a.x62;
import a.xd2;
import a.y42;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class FpsDataView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8431a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f4976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f4977a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f4978a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4979a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f4981a;

    public enum a {
        TEMPERATURE,
        LOAD,
        CAPACITY
    }

    @x62(c = "com.omarea.ui.fps.FpsDataView$render$1", f = "FpsDataView.kt", l = {575}, m = "invokeSuspend")
    public static final class b extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8433a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4984a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public Object f4985b;
        public int c;

        public b(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            b bVar = FpsDataView.this.new b(b62Var);
            bVar.f8433a = (wd2) obj;
            return bVar;
        }

        @Override // a.k82
        public final Object d(wd2 wd2Var, b62<? super m42> b62Var) {
            return ((b) a(wd2Var, b62Var)).j(m42.f6769a);
        }

        @Override // a.s62
        public final Object j(Object obj) {
            Object objC = r62.c();
            int i = this.c;
            if (i == 0) {
                h42.b(obj);
                wd2 wd2Var = this.f8433a;
                FpsDataView fpsDataView = FpsDataView.this;
                fpsDataView.f4978a = Bitmap.createBitmap(fpsDataView.getWidth(), FpsDataView.this.getHeight(), Bitmap.Config.ARGB_8888);
                Bitmap bitmap = FpsDataView.this.f4978a;
                f92.b(bitmap);
                Canvas canvas = new Canvas(bitmap);
                int i2 = FpsDataView.this.i(canvas);
                FpsDataView.this.j(canvas, i2);
                fg2 fg2VarC = qe2.c();
                m51 m51Var = new m51(this, null);
                this.f4984a = wd2Var;
                this.f4985b = canvas;
                this.b = i2;
                this.c = 1;
                if (oc2.g(fg2VarC, m51Var, this) == objC) {
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
    public FpsDataView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4977a = new vj0();
        this.f4980a = new Paint();
        this.f4979a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f4981a = (a) u42.n(a.values());
        k(attributeSet, 0);
    }

    public final int e(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.graphics.Canvas r28, int r29) {
        /*
            Method dump skipped, instruction units count: 482
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.fps.FpsDataView.f(android.graphics.Canvas, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0141  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(android.graphics.Canvas r32) {
        /*
            Method dump skipped, instruction units count: 623
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.fps.FpsDataView.g(android.graphics.Canvas):void");
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final a getRightDimension() {
        return this.f4981a;
    }

    public final long getSessionId() {
        return this.f8431a;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x01ce A[LOOP:0: B:26:0x0120->B:43:0x01ce, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01dd A[EDGE_INSN: B:51:0x01dd->B:44:0x01dd BREAK  A[LOOP:0: B:26:0x0120->B:43:0x01ce], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(android.graphics.Canvas r32, int r33) {
        /*
            Method dump skipped, instruction units count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.omarea.ui.fps.FpsDataView.h(android.graphics.Canvas, int):void");
    }

    public final int i(Canvas canvas) {
        int i;
        ArrayList arrayList;
        int i2;
        py0 py0Var = this.f4976a;
        if (py0Var == null) {
            f92.m("storage");
            throw null;
        }
        ArrayList<Float> arrayListM = py0Var.M(this.f8431a);
        if (arrayListM.size() < 1) {
            return 5;
        }
        this.f4980a.reset();
        int size = arrayListM.size();
        float f = size >= 1800 ? 2.0f : size >= 900 ? 4.0f : 8.0f;
        Context context = getContext();
        f92.c(context, "this.context");
        float fE = e(context, 1.0f);
        float f2 = fE * 18.0f;
        float f3 = fE * 4.0f;
        double d = ((double) (size - 1)) / 60.0d;
        Float fN = i52.N(arrayListM);
        f92.b(fN);
        float fFloatValue = fN.floatValue();
        int i3 = ((int) fFloatValue) + (fFloatValue % ((float) 1) == 0.0f ? 1 : 0);
        int i4 = i3 > 167 ? i3 : i3 > 146 ? 165 : i3 > 122 ? 144 : i3 > 92 ? 120 : i3 > 62 ? 90 : 60;
        float f4 = f;
        double width = (((double) ((getWidth() - f2) - f2)) * 1.0d) / d;
        ArrayList arrayListC = i3 > 167 ? y42.c(0, 30, 60, 90, 120, 144, Integer.valueOf(i3)) : i3 > 146 ? y42.c(0, 30, 60, 90, 120, 165) : i3 > 122 ? y42.c(0, 30, 60, 90, 120, 144) : i3 > 92 ? y42.c(0, 30, 60, 90, 120) : i3 > 62 ? y42.c(0, 30, 60, 90) : y42.c(0, 15, 30, 45, 60);
        float height = (float) ((((double) ((getHeight() - f2) - f3)) * 1.0d) / ((double) i4));
        float height2 = getHeight() - f2;
        float f5 = fE * 8.5f;
        this.f4980a.setTextSize(f5);
        this.f4980a.setTextAlign(Paint.Align.CENTER);
        double d2 = d / ((double) 5);
        this.f4980a.setStrokeWidth(1.0f);
        this.f4980a.setStyle(Paint.Style.FILL);
        int i5 = 0;
        while (true) {
            float f6 = ((int) (r2 * width)) + f2;
            this.f4980a.setColor(Color.parseColor("#888888"));
            canvas.drawText(this.f4977a.c(((double) i5) * d2), f6, (getHeight() - f2) + f5 + (r15 * 2), this.f4980a);
            this.f4980a.setColor(Color.parseColor("#40888888"));
            i = i4;
            canvas.drawLine(f6, f3, f6, getHeight() - f2, this.f4980a);
            if (i5 == 5) {
                break;
            }
            i5++;
            i4 = i;
        }
        float f7 = 2.0f;
        this.f4980a.setStrokeWidth(2.0f);
        this.f4980a.setPathEffect(this.f4979a);
        this.f4980a.setTextAlign(Paint.Align.RIGHT);
        if (i >= 0) {
            int i6 = 0;
            while (true) {
                this.f4980a.setColor(Color.parseColor("#888888"));
                ArrayList arrayList2 = arrayListC;
                if (arrayList2.contains(Integer.valueOf(i6))) {
                    if (i6 > 0) {
                        canvas.drawText(String.valueOf(i6), f2 - (r15 * 4), f3 + ((int) ((i - i6) * height)) + (f5 / 2.2f), this.f4980a);
                    }
                    this.f4980a.setStrokeWidth(i6 == 0 ? 4.0f : f7);
                    this.f4980a.setColor(i6 == 0 ? Color.parseColor("#888888") : Color.parseColor("#aa888888"));
                    float f8 = f3 + ((int) ((i - i6) * height));
                    arrayList = arrayList2;
                    i2 = i6;
                    canvas.drawLine(f2, f8, getWidth() - f2, f8, this.f4980a);
                } else {
                    arrayList = arrayList2;
                    i2 = i6;
                }
                if (i2 == i) {
                    break;
                }
                i6 = i2 + 1;
                arrayListC = arrayList;
                f7 = 2.0f;
            }
        } else {
            arrayList = arrayListC;
        }
        this.f4980a.reset();
        this.f4980a.setColor(getColorAccent());
        ((Number) i52.J(arrayListM)).floatValue();
        float fFloatValue2 = ((Number) i52.A(arrayListM)).floatValue();
        arrayListM.size();
        this.f4980a.setAntiAlias(true);
        this.f4980a.setStrokeWidth(f4);
        this.f4980a.setStyle(Paint.Style.FILL);
        this.f4980a.setPathEffect(null);
        this.f4980a.setColor(Color.parseColor("#80808080"));
        Iterator<Float> it = arrayListM.iterator();
        float f9 = height2 - (fFloatValue2 * height);
        float f10 = f2;
        int i7 = 0;
        while (it.hasNext()) {
            float f11 = ((float) (((double) (i7 / 60.0f)) * width)) + f2;
            float fFloatValue3 = height2 - (it.next().floatValue() * height);
            canvas.drawLine(f10, f9, f11, fFloatValue3, this.f4980a);
            i7++;
            f10 = f11;
            f9 = fFloatValue3;
        }
        return arrayList.size();
    }

    public final void j(Canvas canvas, int i) {
        int i2 = l51.f6675a[this.f4981a.ordinal()];
        if (i2 == 1) {
            h(canvas, i);
        } else if (i2 == 2) {
            f(canvas, i);
        } else {
            if (i2 != 3) {
                return;
            }
            g(canvas);
        }
    }

    public final void k(AttributeSet attributeSet, int i) {
        l();
        this.f4976a = new py0(getContext());
    }

    public final void l() {
    }

    public final void m() {
        if (this.f8431a < 1) {
            return;
        }
        qc2.d(xd2.a(qe2.a()), null, null, new b(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f4978a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f4978a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        m();
    }

    public final void setRightDimension(a aVar) {
        f92.d(aVar, "rightDIMENSION");
        if (this.f4981a != aVar) {
            this.f4981a = aVar;
            this.f4978a = null;
            invalidate();
        }
    }

    public final void setSessionId(long j) {
        if (this.f8431a != j) {
            this.f8431a = j;
            this.f4978a = null;
            invalidate();
        }
    }
}
