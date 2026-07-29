package gl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import fl.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class a extends View implements el.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f29617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29618c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f29619d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f29620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f29621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Interpolator f29622g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f29623h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<PointF> f29624i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f29625j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f29626k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public InterfaceC0350a f29627l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f29628m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f29629n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f29630o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f29631p;

    /* JADX INFO: renamed from: gl.a$a, reason: collision with other inner class name */
    public interface InterfaceC0350a {
        void a(int i10);
    }

    public a(Context context) {
        super(context);
        this.f29622g = new LinearInterpolator();
        this.f29623h = new Paint(1);
        this.f29624i = new ArrayList();
        this.f29631p = true;
        c(context);
    }

    public final void a(Canvas canvas) {
        this.f29623h.setStyle(Paint.Style.STROKE);
        this.f29623h.setStrokeWidth(this.f29618c);
        int size = this.f29624i.size();
        for (int i10 = 0; i10 < size; i10++) {
            PointF pointF = this.f29624i.get(i10);
            canvas.drawCircle(pointF.x, pointF.y, this.f29616a, this.f29623h);
        }
    }

    public final void b(Canvas canvas) {
        this.f29623h.setStyle(Paint.Style.FILL);
        if (this.f29624i.size() > 0) {
            canvas.drawCircle(this.f29625j, (int) ((getHeight() / 2.0f) + 0.5f), this.f29616a, this.f29623h);
        }
    }

    public final void c(Context context) {
        this.f29630o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f29616a = b.a(context, 3.0d);
        this.f29619d = b.a(context, 8.0d);
        this.f29618c = b.a(context, 1.0d);
    }

    public boolean d() {
        return this.f29631p;
    }

    @Override // el.a
    public void e() {
        k();
        invalidate();
    }

    @Override // el.a
    public void f() {
    }

    @Override // el.a
    public void g() {
    }

    public InterfaceC0350a getCircleClickListener() {
        return this.f29627l;
    }

    public int getCircleColor() {
        return this.f29617b;
    }

    public int getCircleCount() {
        return this.f29621f;
    }

    public int getCircleSpacing() {
        return this.f29619d;
    }

    public int getRadius() {
        return this.f29616a;
    }

    public Interpolator getStartInterpolator() {
        return this.f29622g;
    }

    public int getStrokeWidth() {
        return this.f29618c;
    }

    public boolean h() {
        return this.f29626k;
    }

    public final int i(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (this.f29616a * 2) + (this.f29618c * 2) + getPaddingTop() + getPaddingBottom();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    public final int j(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i11 = this.f29621f;
            return (this.f29618c * 2) + (this.f29616a * i11 * 2) + ((i11 - 1) * this.f29619d) + getPaddingLeft() + getPaddingRight();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    public final void k() {
        this.f29624i.clear();
        if (this.f29621f > 0) {
            int height = (int) ((getHeight() / 2.0f) + 0.5f);
            int i10 = this.f29616a;
            int i11 = (i10 * 2) + this.f29619d;
            int paddingLeft = i10 + ((int) ((this.f29618c / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i12 = 0; i12 < this.f29621f; i12++) {
                this.f29624i.add(new PointF(paddingLeft, height));
                paddingLeft += i11;
            }
            this.f29625j = this.f29624i.get(this.f29620e).x;
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f29623h.setColor(this.f29617b);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        k();
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        setMeasuredDimension(j(i10), i(i11));
    }

    @Override // el.a
    public void onPageScrollStateChanged(int i10) {
    }

    @Override // el.a
    public void onPageScrolled(int i10, float f10, int i11) {
        if (!this.f29631p || this.f29624i.isEmpty()) {
            return;
        }
        int iMin = Math.min(this.f29624i.size() - 1, i10);
        int iMin2 = Math.min(this.f29624i.size() - 1, i10 + 1);
        PointF pointF = this.f29624i.get(iMin);
        PointF pointF2 = this.f29624i.get(iMin2);
        float f11 = pointF.x;
        this.f29625j = f11 + ((pointF2.x - f11) * this.f29622g.getInterpolation(f10));
        invalidate();
    }

    @Override // el.a
    public void onPageSelected(int i10) {
        this.f29620e = i10;
        if (this.f29631p) {
            return;
        }
        this.f29625j = this.f29624i.get(i10).x;
        invalidate();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.f29627l != null && Math.abs(x10 - this.f29628m) <= this.f29630o && Math.abs(y10 - this.f29629n) <= this.f29630o) {
                float f10 = Float.MAX_VALUE;
                int i10 = 0;
                for (int i11 = 0; i11 < this.f29624i.size(); i11++) {
                    float fAbs = Math.abs(this.f29624i.get(i11).x - x10);
                    if (fAbs < f10) {
                        i10 = i11;
                        f10 = fAbs;
                    }
                }
                this.f29627l.a(i10);
            }
        } else if (this.f29626k) {
            this.f29628m = x10;
            this.f29629n = y10;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCircleClickListener(InterfaceC0350a interfaceC0350a) {
        if (!this.f29626k) {
            this.f29626k = true;
        }
        this.f29627l = interfaceC0350a;
    }

    public void setCircleColor(int i10) {
        this.f29617b = i10;
        invalidate();
    }

    public void setCircleCount(int i10) {
        this.f29621f = i10;
    }

    public void setCircleSpacing(int i10) {
        this.f29619d = i10;
        k();
        invalidate();
    }

    public void setFollowTouch(boolean z10) {
        this.f29631p = z10;
    }

    public void setRadius(int i10) {
        this.f29616a = i10;
        k();
        invalidate();
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f29622g = interpolator;
        if (interpolator == null) {
            this.f29622g = new LinearInterpolator();
        }
    }

    public void setStrokeWidth(int i10) {
        this.f29618c = i10;
        invalidate();
    }

    public void setTouchable(boolean z10) {
        this.f29626k = z10;
    }
}
