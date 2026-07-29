package jl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class c extends View implements il.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f36464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f36465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f36466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RectF f36467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF f36468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<kl.a> f36469f;

    public c(Context context) {
        super(context);
        this.f36467d = new RectF();
        this.f36468e = new RectF();
        b(context);
    }

    @Override // il.c
    public void a(List<kl.a> list) {
        this.f36469f = list;
    }

    public final void b(Context context) {
        Paint paint = new Paint(1);
        this.f36464a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f36465b = -65536;
        this.f36466c = -16711936;
    }

    public int getInnerRectColor() {
        return this.f36466c;
    }

    public int getOutRectColor() {
        return this.f36465b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f36464a.setColor(this.f36465b);
        canvas.drawRect(this.f36467d, this.f36464a);
        this.f36464a.setColor(this.f36466c);
        canvas.drawRect(this.f36468e, this.f36464a);
    }

    @Override // il.c
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // il.c
    public void onPageScrolled(int i10, float f10, int i11) {
        List<kl.a> list = this.f36469f;
        if (list == null || list.isEmpty()) {
            return;
        }
        kl.a aVarH = dl.b.h(this.f36469f, i10);
        kl.a aVarH2 = dl.b.h(this.f36469f, i10 + 1);
        RectF rectF = this.f36467d;
        rectF.left = aVarH.f37414a + ((aVarH2.f37414a - r1) * f10);
        rectF.top = aVarH.f37415b + ((aVarH2.f37415b - r1) * f10);
        rectF.right = aVarH.f37416c + ((aVarH2.f37416c - r1) * f10);
        rectF.bottom = aVarH.f37417d + ((aVarH2.f37417d - r1) * f10);
        RectF rectF2 = this.f36468e;
        rectF2.left = aVarH.f37418e + ((aVarH2.f37418e - r1) * f10);
        rectF2.top = aVarH.f37419f + ((aVarH2.f37419f - r1) * f10);
        rectF2.right = aVarH.f37420g + ((aVarH2.f37420g - r1) * f10);
        rectF2.bottom = aVarH.f37421h + ((aVarH2.f37421h - r7) * f10);
        invalidate();
    }

    @Override // il.c
    public void onPageSelected(int i10) {
    }

    public void setInnerRectColor(int i10) {
        this.f36466c = i10;
    }

    public void setOutRectColor(int i10) {
        this.f36465b = i10;
    }
}
