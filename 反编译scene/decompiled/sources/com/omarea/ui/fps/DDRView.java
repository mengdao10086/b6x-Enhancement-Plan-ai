package com.omarea.ui.fps;

import a.b62;
import a.d72;
import a.f92;
import a.fg2;
import a.h42;
import a.i52;
import a.k51;
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
import a.y42;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class DDRView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f8429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public py0 f4969a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vj0 f4970a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f4971a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DashPathEffect f4972a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f4973a;

    @x62(c = "com.omarea.ui.fps.DDRView$render$1", f = "DDRView.kt", l = {92}, m = "invokeSuspend")
    public static final class a extends d72 implements k82<wd2, b62<? super m42>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public wd2 f8430a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Object f4975a;
        public int b;

        public a(b62 b62Var) {
            super(2, b62Var);
        }

        @Override // a.s62
        public final b62<m42> a(Object obj, b62<?> b62Var) {
            f92.d(b62Var, "completion");
            a aVar = DDRView.this.new a(b62Var);
            aVar.f8430a = (wd2) obj;
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
                wd2 wd2Var = this.f8430a;
                DDRView dDRView = DDRView.this;
                dDRView.f4971a = Bitmap.createBitmap(dDRView.getWidth(), DDRView.this.getHeight(), Bitmap.Config.ARGB_8888);
                DDRView dDRView2 = DDRView.this;
                Bitmap bitmap = DDRView.this.f4971a;
                f92.b(bitmap);
                dDRView2.e(new Canvas(bitmap));
                fg2 fg2VarC = qe2.c();
                k51 k51Var = new k51(this, null);
                this.f4975a = wd2Var;
                this.b = 1;
                if (oc2.g(fg2VarC, k51Var, this) == objC) {
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
    public DDRView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f92.d(context, "context");
        f92.d(attributeSet, "attrs");
        this.f4970a = new vj0();
        this.f4972a = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
        this.f4973a = new Paint();
        f(attributeSet, 0);
    }

    public final int d(Context context, float f) {
        Resources resources = context.getResources();
        f92.c(resources, "context.resources");
        return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
    }

    public final void e(Canvas canvas) {
        int i;
        float f;
        float f2;
        double d;
        Integer next;
        py0 py0Var = this.f4969a;
        if (py0Var == null) {
            f92.m("storage");
            throw null;
        }
        ArrayList<Integer> arrayListI = py0Var.I(this.f8429a);
        if (arrayListI.size() < 1) {
            return;
        }
        ArrayList arrayListC = y42.c(0);
        int iIntValue = 4266;
        Iterator<Integer> it = arrayListI.iterator();
        loop0: while (true) {
            i = iIntValue;
            while (it.hasNext()) {
                next = it.next();
                if (!arrayListC.contains(next)) {
                    arrayListC.add(next);
                }
                if (f92.e(next.intValue(), i) > 0) {
                    break;
                }
            }
            f92.c(next, "value");
            iIntValue = next.intValue();
        }
        this.f4973a.reset();
        this.f4973a.setStrokeWidth(2.0f);
        double size = ((double) (arrayListI.size() - 1)) / 60.0d;
        Context context = getContext();
        f92.c(context, "this.context");
        int iD = d(context, 1.0f);
        float f3 = iD;
        float f4 = f3 * 8.5f;
        this.f4973a.setTextSize(f4);
        StringBuilder sb = new StringBuilder();
        int length = String.valueOf(i).length();
        for (int i2 = 0; i2 < length; i2++) {
            sb.append("9");
        }
        float f5 = f3 * 4.0f;
        float fMeasureText = this.f4973a.measureText(sb.toString()) + f5;
        float f6 = f3 * 18.0f;
        double width = (((double) ((getWidth() - fMeasureText) - f6)) * 1.0d) / size;
        float height = (float) ((((double) ((getHeight() - f6) - f5)) * 1.0d) / ((double) i));
        float height2 = getHeight() - f6;
        this.f4973a.setTextAlign(Paint.Align.CENTER);
        double d2 = size / ((double) 5);
        this.f4973a.setStrokeWidth(1.0f);
        this.f4973a.setStyle(Paint.Style.FILL);
        int i3 = 0;
        while (true) {
            f = f4;
            float f7 = ((int) (r1 * width)) + fMeasureText;
            this.f4973a.setColor(Color.parseColor("#888888"));
            f2 = iD * 2;
            canvas.drawText(this.f4970a.c(((double) i3) * d2), f7, (getHeight() - f6) + f + f2, this.f4973a);
            this.f4973a.setColor(Color.parseColor("#40888888"));
            d = width;
            int i4 = i3;
            canvas.drawLine(f7, f5, f7, getHeight() - f6, this.f4973a);
            if (i4 == 5) {
                break;
            }
            i3 = i4 + 1;
            f4 = f;
            width = d;
        }
        this.f4973a.setStrokeWidth(2.0f);
        this.f4973a.setPathEffect(this.f4972a);
        this.f4973a.setTextAlign(Paint.Align.RIGHT);
        if (i >= 0) {
            int i5 = 0;
            while (true) {
                this.f4973a.setColor(Color.parseColor("#888888"));
                if (arrayListC.contains(Integer.valueOf(i5))) {
                    if (i5 > 0) {
                        canvas.drawText(String.valueOf(i5), fMeasureText - f2, ((int) ((i - i5) * height)) + f5 + (f / 2.2f), this.f4973a);
                    }
                    this.f4973a.setStrokeWidth(i5 == 0 ? 4.0f : 2.0f);
                    this.f4973a.setColor(i5 == 0 ? Color.parseColor("#888888") : Color.parseColor("#aa888888"));
                    float f8 = f5 + ((int) ((i - i5) * height));
                    canvas.drawLine(fMeasureText, f8, getWidth() - f6, f8, this.f4973a);
                }
                if (i5 == i) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        this.f4973a.reset();
        this.f4973a.setColor(Color.parseColor("#87d3ff"));
        this.f4973a.setAntiAlias(true);
        this.f4973a.setStrokeWidth(8.0f);
        this.f4973a.setStyle(Paint.Style.FILL);
        this.f4973a.setPathEffect(null);
        Integer num = (Integer) i52.C(arrayListI);
        if (num == null || num.intValue() < 0) {
            num = 0;
        }
        Path path = new Path();
        path.moveTo(fMeasureText, height2 - (num.intValue() * height));
        int i6 = 0;
        for (Integer num2 : arrayListI) {
            if (f92.e(num2.intValue(), 0) < 0) {
                num2 = 0;
            }
            f92.c(num2, "if (sample < 0) 0 else sample");
            path.lineTo(((float) (((double) (i6 / 60.0f)) * d)) + fMeasureText, height2 - (num2.intValue() * height));
            i6++;
        }
        this.f4973a.setStyle(Paint.Style.STROKE);
        this.f4973a.setStrokeWidth(4.0f);
        canvas.drawPath(path, this.f4973a);
    }

    public final void f(AttributeSet attributeSet, int i) {
        g();
        this.f4969a = new py0(getContext());
    }

    public final void g() {
    }

    public final int getColorAccent() {
        return getResources().getColor(2131099700);
    }

    public final long getSessionId() {
        return this.f8429a;
    }

    public final void h() {
        if (this.f8429a < 1) {
            return;
        }
        qc2.d(xd2.a(qe2.a()), null, null, new a(null), 3, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        f92.d(canvas, "canvas");
        super.onDraw(canvas);
        Bitmap bitmap = this.f4971a;
        if (bitmap != null) {
            f92.b(bitmap);
            if (bitmap.getWidth() == getWidth()) {
                Bitmap bitmap2 = this.f4971a;
                f92.b(bitmap2);
                canvas.drawBitmap(bitmap2, 0.0f, 0.0f, (Paint) null);
                return;
            }
        }
        h();
    }

    public final void setSessionId(long j) {
        if (this.f8429a != j) {
            this.f8429a = j;
            this.f4971a = null;
            invalidate();
        }
    }
}
