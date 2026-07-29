package y4;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.daasuu.bl.ArrowDirection;

/* JADX INFO: loaded from: classes2.dex */
public class a extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RectF f56227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Path f56228b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f56229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Path f56230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint f56231e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f56232f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f56233g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f56234h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f56235i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f56236j;

    /* JADX INFO: renamed from: y4.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0664a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f56237a;

        static {
            int[] iArr = new int[ArrowDirection.values().length];
            f56237a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f56237a[ArrowDirection.LEFT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f56237a[ArrowDirection.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f56237a[ArrowDirection.TOP_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f56237a[ArrowDirection.TOP_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f56237a[ArrowDirection.RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f56237a[ArrowDirection.RIGHT_CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f56237a[ArrowDirection.BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f56237a[ArrowDirection.BOTTOM_CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f56237a[ArrowDirection.BOTTOM_RIGHT.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public a(RectF rect, float arrowWidth, float cornersRadius, float arrowHeight, float arrowPosition, float strokeWidth, int strokeColor, int bubbleColor, ArrowDirection arrowDirection) {
        Paint paint = new Paint(1);
        this.f56229c = paint;
        this.f56227a = rect;
        this.f56232f = arrowWidth;
        this.f56233g = cornersRadius;
        this.f56234h = arrowHeight;
        this.f56235i = arrowPosition;
        this.f56236j = strokeWidth;
        paint.setColor(bubbleColor);
        if (strokeWidth <= 0.0f) {
            e(arrowDirection, this.f56228b, 0.0f);
            return;
        }
        Paint paint2 = new Paint(1);
        this.f56231e = paint2;
        paint2.setColor(strokeColor);
        this.f56230d = new Path();
        e(arrowDirection, this.f56228b, strokeWidth);
        e(arrowDirection, this.f56230d, 0.0f);
    }

    public final void a(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + this.f56233g + strokeWidth, rect.top + strokeWidth);
        path.lineTo((rect.width() - this.f56233g) - strokeWidth, rect.top + strokeWidth);
        float f10 = rect.right;
        float f11 = this.f56233g;
        float f12 = rect.top;
        path.arcTo(new RectF(f10 - f11, f12 + strokeWidth, f10 - strokeWidth, f11 + f12), 270.0f, 90.0f);
        path.lineTo(rect.right - strokeWidth, ((rect.bottom - this.f56234h) - this.f56233g) - strokeWidth);
        float f13 = rect.right;
        float f14 = this.f56233g;
        float f15 = rect.bottom;
        float f16 = this.f56234h;
        path.arcTo(new RectF(f13 - f14, (f15 - f14) - f16, f13 - strokeWidth, (f15 - f16) - strokeWidth), 0.0f, 90.0f);
        float f17 = strokeWidth / 2.0f;
        path.lineTo(((rect.left + this.f56232f) + this.f56235i) - f17, (rect.bottom - this.f56234h) - strokeWidth);
        path.lineTo(rect.left + this.f56235i + (this.f56232f / 2.0f), (rect.bottom - strokeWidth) - strokeWidth);
        path.lineTo(rect.left + this.f56235i + f17, (rect.bottom - this.f56234h) - strokeWidth);
        path.lineTo(rect.left + Math.min(this.f56233g, this.f56235i) + strokeWidth, (rect.bottom - this.f56234h) - strokeWidth);
        float f18 = rect.left;
        float f19 = rect.bottom;
        float f20 = this.f56233g;
        float f21 = this.f56234h;
        path.arcTo(new RectF(f18 + strokeWidth, (f19 - f20) - f21, f20 + f18, (f19 - f21) - strokeWidth), 90.0f, 90.0f);
        path.lineTo(rect.left + strokeWidth, rect.top + this.f56233g + strokeWidth);
        float f22 = rect.left;
        float f23 = rect.top;
        float f24 = this.f56233g;
        path.arcTo(new RectF(f22 + strokeWidth, strokeWidth + f23, f22 + f24, f24 + f23), 180.0f, 90.0f);
        path.close();
    }

    public final void b(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.right - strokeWidth, (rect.bottom - this.f56234h) - strokeWidth);
        float f10 = strokeWidth / 2.0f;
        path.lineTo(((rect.left + this.f56232f) + this.f56235i) - f10, (rect.bottom - this.f56234h) - strokeWidth);
        path.lineTo(rect.left + this.f56235i + (this.f56232f / 2.0f), (rect.bottom - strokeWidth) - strokeWidth);
        path.lineTo(rect.left + this.f56235i + f10, (rect.bottom - this.f56234h) - strokeWidth);
        path.lineTo(rect.left + this.f56235i + strokeWidth, (rect.bottom - this.f56234h) - strokeWidth);
        path.lineTo(rect.left + strokeWidth, (rect.bottom - this.f56234h) - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.close();
    }

    public final void c(RectF rect, Path path, float strokeWidth) {
        path.moveTo(this.f56232f + rect.left + this.f56233g + strokeWidth, rect.top + strokeWidth);
        path.lineTo((rect.width() - this.f56233g) - strokeWidth, rect.top + strokeWidth);
        float f10 = rect.right;
        float f11 = this.f56233g;
        float f12 = rect.top;
        path.arcTo(new RectF(f10 - f11, f12 + strokeWidth, f10 - strokeWidth, f11 + f12), 270.0f, 90.0f);
        path.lineTo(rect.right - strokeWidth, (rect.bottom - this.f56233g) - strokeWidth);
        float f13 = rect.right;
        float f14 = this.f56233g;
        float f15 = rect.bottom;
        path.arcTo(new RectF(f13 - f14, f15 - f14, f13 - strokeWidth, f15 - strokeWidth), 0.0f, 90.0f);
        path.lineTo(rect.left + this.f56232f + this.f56233g + strokeWidth, rect.bottom - strokeWidth);
        float f16 = rect.left;
        float f17 = this.f56232f;
        float f18 = rect.bottom;
        float f19 = this.f56233g;
        path.arcTo(new RectF(f16 + f17 + strokeWidth, f18 - f19, f19 + f16 + f17, f18 - strokeWidth), 90.0f, 90.0f);
        float f20 = strokeWidth / 2.0f;
        path.lineTo(rect.left + this.f56232f + strokeWidth, (this.f56234h + this.f56235i) - f20);
        path.lineTo(rect.left + strokeWidth + strokeWidth, this.f56235i + (this.f56234h / 2.0f));
        path.lineTo(rect.left + this.f56232f + strokeWidth, this.f56235i + f20);
        path.lineTo(rect.left + this.f56232f + strokeWidth, rect.top + this.f56233g + strokeWidth);
        float f21 = rect.left;
        float f22 = this.f56232f;
        float f23 = rect.top;
        float f24 = this.f56233g;
        path.arcTo(new RectF(f21 + f22 + strokeWidth, strokeWidth + f23, f21 + f24 + f22, f24 + f23), 180.0f, 90.0f);
        path.close();
    }

    public final void d(RectF rect, Path path, float strokeWidth) {
        path.moveTo(this.f56232f + rect.left + strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.width() - strokeWidth, rect.top + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + this.f56232f + strokeWidth, rect.bottom - strokeWidth);
        float f10 = strokeWidth / 2.0f;
        path.lineTo(rect.left + this.f56232f + strokeWidth, (this.f56234h + this.f56235i) - f10);
        path.lineTo(rect.left + strokeWidth + strokeWidth, this.f56235i + (this.f56234h / 2.0f));
        path.lineTo(rect.left + this.f56232f + strokeWidth, this.f56235i + f10);
        path.lineTo(rect.left + this.f56232f + strokeWidth, rect.top + strokeWidth);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f56236j > 0.0f) {
            canvas.drawPath(this.f56230d, this.f56231e);
        }
        canvas.drawPath(this.f56228b, this.f56229c);
    }

    public final void e(ArrowDirection arrowDirection, Path path, float strokeWidth) {
        switch (C0664a.f56237a[arrowDirection.ordinal()]) {
            case 1:
            case 2:
                float f10 = this.f56233g;
                if (f10 <= 0.0f) {
                    d(this.f56227a, path, strokeWidth);
                } else if (strokeWidth > 0.0f && strokeWidth > f10) {
                    d(this.f56227a, path, strokeWidth);
                } else {
                    c(this.f56227a, path, strokeWidth);
                }
                break;
            case 3:
            case 4:
            case 5:
                float f11 = this.f56233g;
                if (f11 <= 0.0f) {
                    i(this.f56227a, path, strokeWidth);
                } else if (strokeWidth > 0.0f && strokeWidth > f11) {
                    i(this.f56227a, path, strokeWidth);
                } else {
                    h(this.f56227a, path, strokeWidth);
                }
                break;
            case 6:
            case 7:
                float f12 = this.f56233g;
                if (f12 <= 0.0f) {
                    g(this.f56227a, path, strokeWidth);
                } else if (strokeWidth > 0.0f && strokeWidth > f12) {
                    g(this.f56227a, path, strokeWidth);
                } else {
                    f(this.f56227a, path, strokeWidth);
                }
                break;
            case 8:
            case 9:
            case 10:
                float f13 = this.f56233g;
                if (f13 <= 0.0f) {
                    b(this.f56227a, path, strokeWidth);
                } else if (strokeWidth > 0.0f && strokeWidth > f13) {
                    b(this.f56227a, path, strokeWidth);
                } else {
                    a(this.f56227a, path, strokeWidth);
                }
                break;
        }
    }

    public final void f(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + this.f56233g + strokeWidth, rect.top + strokeWidth);
        path.lineTo(((rect.width() - this.f56233g) - this.f56232f) - strokeWidth, rect.top + strokeWidth);
        float f10 = rect.right;
        float f11 = this.f56233g;
        float f12 = this.f56232f;
        float f13 = rect.top;
        path.arcTo(new RectF((f10 - f11) - f12, f13 + strokeWidth, (f10 - f12) - strokeWidth, f11 + f13), 270.0f, 90.0f);
        float f14 = strokeWidth / 2.0f;
        path.lineTo((rect.right - this.f56232f) - strokeWidth, this.f56235i + f14);
        path.lineTo((rect.right - strokeWidth) - strokeWidth, this.f56235i + (this.f56234h / 2.0f));
        path.lineTo((rect.right - this.f56232f) - strokeWidth, (this.f56235i + this.f56234h) - f14);
        path.lineTo((rect.right - this.f56232f) - strokeWidth, (rect.bottom - this.f56233g) - strokeWidth);
        float f15 = rect.right;
        float f16 = this.f56233g;
        float f17 = this.f56232f;
        float f18 = rect.bottom;
        path.arcTo(new RectF((f15 - f16) - f17, f18 - f16, (f15 - f17) - strokeWidth, f18 - strokeWidth), 0.0f, 90.0f);
        path.lineTo(rect.left + this.f56232f + strokeWidth, rect.bottom - strokeWidth);
        float f19 = rect.left;
        float f20 = rect.bottom;
        float f21 = this.f56233g;
        path.arcTo(new RectF(f19 + strokeWidth, f20 - f21, f21 + f19, f20 - strokeWidth), 90.0f, 90.0f);
        float f22 = rect.left;
        float f23 = rect.top;
        float f24 = this.f56233g;
        path.arcTo(new RectF(f22 + strokeWidth, strokeWidth + f23, f22 + f24, f24 + f23), 180.0f, 90.0f);
        path.close();
    }

    public final void g(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.lineTo((rect.width() - this.f56232f) - strokeWidth, rect.top + strokeWidth);
        float f10 = strokeWidth / 2.0f;
        path.lineTo((rect.right - this.f56232f) - strokeWidth, this.f56235i + f10);
        path.lineTo((rect.right - strokeWidth) - strokeWidth, this.f56235i + (this.f56234h / 2.0f));
        path.lineTo((rect.right - this.f56232f) - strokeWidth, (this.f56235i + this.f56234h) - f10);
        path.lineTo((rect.right - this.f56232f) - strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.top + strokeWidth);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f56227a.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f56227a.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + Math.min(this.f56235i, this.f56233g) + strokeWidth, rect.top + this.f56234h + strokeWidth);
        float f10 = strokeWidth / 2.0f;
        path.lineTo(rect.left + this.f56235i + f10, rect.top + this.f56234h + strokeWidth);
        path.lineTo(rect.left + (this.f56232f / 2.0f) + this.f56235i, rect.top + strokeWidth + strokeWidth);
        path.lineTo(((rect.left + this.f56232f) + this.f56235i) - f10, rect.top + this.f56234h + strokeWidth);
        path.lineTo((rect.right - this.f56233g) - strokeWidth, rect.top + this.f56234h + strokeWidth);
        float f11 = rect.right;
        float f12 = this.f56233g;
        float f13 = rect.top;
        float f14 = this.f56234h;
        path.arcTo(new RectF(f11 - f12, f13 + f14 + strokeWidth, f11 - strokeWidth, f12 + f13 + f14), 270.0f, 90.0f);
        path.lineTo(rect.right - strokeWidth, (rect.bottom - this.f56233g) - strokeWidth);
        float f15 = rect.right;
        float f16 = this.f56233g;
        float f17 = rect.bottom;
        path.arcTo(new RectF(f15 - f16, f17 - f16, f15 - strokeWidth, f17 - strokeWidth), 0.0f, 90.0f);
        path.lineTo(rect.left + this.f56233g + strokeWidth, rect.bottom - strokeWidth);
        float f18 = rect.left;
        float f19 = rect.bottom;
        float f20 = this.f56233g;
        path.arcTo(new RectF(f18 + strokeWidth, f19 - f20, f20 + f18, f19 - strokeWidth), 90.0f, 90.0f);
        path.lineTo(rect.left + strokeWidth, rect.top + this.f56234h + this.f56233g + strokeWidth);
        float f21 = rect.left;
        float f22 = f21 + strokeWidth;
        float f23 = rect.top;
        float f24 = this.f56234h;
        float f25 = f23 + f24 + strokeWidth;
        float f26 = this.f56233g;
        path.arcTo(new RectF(f22, f25, f21 + f26, f26 + f23 + f24), 180.0f, 90.0f);
        path.close();
    }

    public final void i(RectF rect, Path path, float strokeWidth) {
        path.moveTo(rect.left + this.f56235i + strokeWidth, rect.top + this.f56234h + strokeWidth);
        float f10 = strokeWidth / 2.0f;
        path.lineTo(rect.left + this.f56235i + f10, rect.top + this.f56234h + strokeWidth);
        path.lineTo(rect.left + (this.f56232f / 2.0f) + this.f56235i, rect.top + strokeWidth + strokeWidth);
        path.lineTo(((rect.left + this.f56232f) + this.f56235i) - f10, rect.top + this.f56234h + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.top + this.f56234h + strokeWidth);
        path.lineTo(rect.right - strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.bottom - strokeWidth);
        path.lineTo(rect.left + strokeWidth, rect.top + this.f56234h + strokeWidth);
        path.lineTo(rect.left + this.f56235i + strokeWidth, rect.top + this.f56234h + strokeWidth);
        path.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.f56229c.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf2) {
        this.f56229c.setColorFilter(cf2);
    }
}
