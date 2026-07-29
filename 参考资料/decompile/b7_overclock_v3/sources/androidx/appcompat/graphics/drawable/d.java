package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import com.google.common.collect.LinkedHashMultimap;
import g.l;
import g.x;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes2.dex */
public class d extends Drawable {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f1812m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f1813n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f1814o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f1815p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final float f1816q = (float) Math.toRadians(45.0d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f1817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f1818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f1819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f1820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f1821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f1823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f1824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f1825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f1826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f1827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1828l;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface a {
    }

    public d(Context context) {
        Paint paint = new Paint();
        this.f1817a = paint;
        this.f1823g = new Path();
        this.f1825i = false;
        this.f1828l = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, R.attr.drawerArrowStyle, R.style.Base_Widget_AppCompat_DrawerArrowToggle);
        p(typedArrayObtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        o(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        t(typedArrayObtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        r(Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.f1824h = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.f1819c = Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.f1818b = Math.round(typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.f1820d = typedArrayObtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static float k(float f10, float f11, float f12) {
        return f10 + ((f11 - f10) * f12);
    }

    public float a() {
        return this.f1818b;
    }

    public float b() {
        return this.f1820d;
    }

    public float c() {
        return this.f1819c;
    }

    public float d() {
        return this.f1817a.getStrokeWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int i10 = this.f1828l;
        boolean z10 = false;
        if (i10 != 0 && (i10 == 1 || (i10 == 3 ? n0.c.f(this) == 0 : n0.c.f(this) == 1))) {
            z10 = true;
        }
        float f10 = this.f1818b;
        float fK = k(this.f1819c, (float) Math.sqrt(f10 * f10 * 2.0f), this.f1826j);
        float fK2 = k(this.f1819c, this.f1820d, this.f1826j);
        float fRound = Math.round(k(0.0f, this.f1827k, this.f1826j));
        float fK3 = k(0.0f, f1816q, this.f1826j);
        float fK4 = k(z10 ? 0.0f : -180.0f, z10 ? 180.0f : 0.0f, this.f1826j);
        double d10 = fK;
        double d11 = fK3;
        boolean z11 = z10;
        float fRound2 = Math.round(Math.cos(d11) * d10);
        float fRound3 = Math.round(d10 * Math.sin(d11));
        this.f1823g.rewind();
        float fK5 = k(this.f1821e + this.f1817a.getStrokeWidth(), -this.f1827k, this.f1826j);
        float f11 = (-fK2) / 2.0f;
        this.f1823g.moveTo(f11 + fRound, 0.0f);
        this.f1823g.rLineTo(fK2 - (fRound * 2.0f), 0.0f);
        this.f1823g.moveTo(f11, fK5);
        this.f1823g.rLineTo(fRound2, fRound3);
        this.f1823g.moveTo(f11, -fK5);
        this.f1823g.rLineTo(fRound2, -fRound3);
        this.f1823g.close();
        canvas.save();
        float strokeWidth = this.f1817a.getStrokeWidth();
        float fHeight = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (fHeight - (2.0f * r5))) / 4) * 2) + (strokeWidth * 1.5f) + this.f1821e);
        if (this.f1822f) {
            canvas.rotate(fK4 * (this.f1825i ^ z11 ? -1 : 1));
        } else if (z11) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.f1823g, this.f1817a);
        canvas.restore();
    }

    @l
    public int e() {
        return this.f1817a.getColor();
    }

    public int f() {
        return this.f1828l;
    }

    public float g() {
        return this.f1821e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f1824h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f1824h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final Paint h() {
        return this.f1817a;
    }

    @x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float i() {
        return this.f1826j;
    }

    public boolean j() {
        return this.f1822f;
    }

    public void l(float f10) {
        if (this.f1818b != f10) {
            this.f1818b = f10;
            invalidateSelf();
        }
    }

    public void m(float f10) {
        if (this.f1820d != f10) {
            this.f1820d = f10;
            invalidateSelf();
        }
    }

    public void n(float f10) {
        if (this.f1819c != f10) {
            this.f1819c = f10;
            invalidateSelf();
        }
    }

    public void o(float f10) {
        if (this.f1817a.getStrokeWidth() != f10) {
            this.f1817a.setStrokeWidth(f10);
            this.f1827k = (float) (((double) (f10 / 2.0f)) * Math.cos(f1816q));
            invalidateSelf();
        }
    }

    public void p(@l int i10) {
        if (i10 != this.f1817a.getColor()) {
            this.f1817a.setColor(i10);
            invalidateSelf();
        }
    }

    public void q(int i10) {
        if (i10 != this.f1828l) {
            this.f1828l = i10;
            invalidateSelf();
        }
    }

    public void r(float f10) {
        if (f10 != this.f1821e) {
            this.f1821e = f10;
            invalidateSelf();
        }
    }

    public void s(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        if (this.f1826j != f10) {
            this.f1826j = f10;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        if (i10 != this.f1817a.getAlpha()) {
            this.f1817a.setAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1817a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void t(boolean z10) {
        if (this.f1822f != z10) {
            this.f1822f = z10;
            invalidateSelf();
        }
    }

    public void u(boolean z10) {
        if (this.f1825i != z10) {
            this.f1825i = z10;
            invalidateSelf();
        }
    }
}
