package ll;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes5.dex */
public class a extends View implements il.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f39824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f39825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f39826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f39827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f39828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Paint f39829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Rect f39830g;

    public a(Context context) {
        super(context);
        this.f39830g = new Rect();
        e(context);
    }

    @Override // il.d
    public void a(int i10, int i11) {
    }

    @Override // il.d
    public void b(int i10, int i11, float f10, boolean z10) {
        this.f39827d = z10;
        this.f39828e = f10;
        invalidate();
    }

    @Override // il.d
    public void c(int i10, int i11) {
    }

    @Override // il.d
    public void d(int i10, int i11, float f10, boolean z10) {
        this.f39827d = !z10;
        this.f39828e = 1.0f - f10;
        invalidate();
    }

    public final void e(Context context) {
        int iA = fl.b.a(context, 16.0d);
        Paint paint = new Paint(1);
        this.f39829f = paint;
        paint.setTextSize(iA);
        int iA2 = fl.b.a(context, 10.0d);
        setPadding(iA2, 0, iA2, 0);
    }

    public final int f(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : this.f39830g.height() + getPaddingTop() + getPaddingBottom() : Math.min(this.f39830g.height() + getPaddingTop() + getPaddingBottom(), size);
    }

    public final void g() {
        Paint paint = this.f39829f;
        String str = this.f39824a;
        paint.getTextBounds(str, 0, str == null ? 0 : str.length(), this.f39830g);
    }

    public int getClipColor() {
        return this.f39826c;
    }

    @Override // il.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.f39829f.getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // il.b
    public int getContentLeft() {
        return (getLeft() + (getWidth() / 2)) - (this.f39830g.width() / 2);
    }

    @Override // il.b
    public int getContentRight() {
        return getLeft() + (getWidth() / 2) + (this.f39830g.width() / 2);
    }

    @Override // il.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.f39829f.getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public String getText() {
        return this.f39824a;
    }

    public int getTextColor() {
        return this.f39825b;
    }

    public float getTextSize() {
        return this.f39829f.getTextSize();
    }

    public final int h(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        return mode != Integer.MIN_VALUE ? mode != 0 ? size : this.f39830g.width() + getPaddingLeft() + getPaddingRight() : Math.min(this.f39830g.width() + getPaddingLeft() + getPaddingRight(), size);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int width = (getWidth() - this.f39830g.width()) / 2;
        Paint.FontMetrics fontMetrics = this.f39829f.getFontMetrics();
        int height = (int) (((getHeight() - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        this.f39829f.setColor(this.f39825b);
        float f10 = width;
        float f11 = height;
        canvas.drawText(this.f39824a, f10, f11, this.f39829f);
        canvas.save();
        if (this.f39827d) {
            canvas.clipRect(0.0f, 0.0f, getWidth() * this.f39828e, getHeight());
        } else {
            canvas.clipRect(getWidth() * (1.0f - this.f39828e), 0.0f, getWidth(), getHeight());
        }
        this.f39829f.setColor(this.f39826c);
        canvas.drawText(this.f39824a, f10, f11, this.f39829f);
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        g();
        setMeasuredDimension(h(i10), f(i11));
    }

    public void setClipColor(int i10) {
        this.f39826c = i10;
        invalidate();
    }

    public void setText(String str) {
        this.f39824a = str;
        requestLayout();
    }

    public void setTextColor(int i10) {
        this.f39825b = i10;
        invalidate();
    }

    public void setTextSize(float f10) {
        this.f39829f.setTextSize(f10);
        requestLayout();
    }
}
