package xa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DisplayMetrics f55009a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f55010b = 50;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f55011c = 8000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final double f55012d = 0.017453292519943295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final float f55013e = 0.017453292f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final double f55014f = Double.longBitsToDouble(1);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final float f55015g = Float.intBitsToFloat(1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Rect f55016h = new Rect();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Paint.FontMetrics f55017i = new Paint.FontMetrics();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Rect f55018j = new Rect();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f55019k = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static na.l f55020l = q();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static Rect f55021m = new Rect();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static Rect f55022n = new Rect();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static Paint.FontMetrics f55023o = new Paint.FontMetrics();

    public static g A(g gVar, float f10, float f11) {
        g gVarC = g.c(0.0f, 0.0f);
        B(gVar, f10, f11, gVarC);
        return gVarC;
    }

    public static void B(g gVar, float f10, float f11, g gVar2) {
        double d10 = f10;
        double d11 = f11;
        gVar2.f54987c = (float) (((double) gVar.f54987c) + (Math.cos(Math.toRadians(d11)) * d10));
        gVar2.f54988d = (float) (((double) gVar.f54988d) + (d10 * Math.sin(Math.toRadians(d11))));
    }

    public static int C() {
        return Build.VERSION.SDK_INT;
    }

    public static c D(float f10, float f11, float f12) {
        return F(f10, f11, f12 * 0.017453292f);
    }

    public static c E(c cVar, float f10) {
        return F(cVar.f54979c, cVar.f54980d, f10 * 0.017453292f);
    }

    public static c F(float f10, float f11, float f12) {
        double d10 = f12;
        return c.b(Math.abs(((float) Math.cos(d10)) * f10) + Math.abs(((float) Math.sin(d10)) * f11), Math.abs(f10 * ((float) Math.sin(d10))) + Math.abs(f11 * ((float) Math.cos(d10))));
    }

    public static c G(c cVar, float f10) {
        return F(cVar.f54979c, cVar.f54980d, f10);
    }

    public static void H(Context context) {
        if (context == null) {
            f55010b = ViewConfiguration.getMinimumFlingVelocity();
            f55011c = ViewConfiguration.getMaximumFlingVelocity();
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            f55010b = viewConfiguration.getScaledMinimumFlingVelocity();
            f55011c = viewConfiguration.getScaledMaximumFlingVelocity();
            f55009a = context.getResources().getDisplayMetrics();
        }
    }

    @Deprecated
    public static void I(Resources resources) {
        f55009a = resources.getDisplayMetrics();
        f55010b = ViewConfiguration.getMinimumFlingVelocity();
        f55011c = ViewConfiguration.getMaximumFlingVelocity();
    }

    public static double J(double d10) {
        if (d10 == Double.POSITIVE_INFINITY) {
            return d10;
        }
        double d11 = d10 + 0.0d;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d11) + (d11 >= 0.0d ? 1L : -1L));
    }

    @SuppressLint({"NewApi"})
    public static void K(View view) {
        view.postInvalidateOnAnimation();
    }

    public static float L(double d10) {
        if (Double.isInfinite(d10) || Double.isNaN(d10) || d10 == 0.0d) {
            return 0.0f;
        }
        return Math.round(d10 * ((double) r0)) / ((float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d10 < 0.0d ? -d10 : d10)))));
    }

    public static void M(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, f55011c);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            if (i10 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i10);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    public static int a(Paint paint, String str) {
        Rect rect = f55016h;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static c b(Paint paint, String str) {
        c cVarB = c.b(0.0f, 0.0f);
        c(paint, str, cVarB);
        return cVarB;
    }

    public static void c(Paint paint, String str, c cVar) {
        Rect rect = f55018j;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        cVar.f54979c = rect.width();
        cVar.f54980d = rect.height();
    }

    public static int d(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static float e(float f10) {
        DisplayMetrics displayMetrics = f55009a;
        return displayMetrics == null ? f10 : f10 * displayMetrics.density;
    }

    public static int[] f(List<Integer> list) {
        int[] iArr = new int[list.size()];
        i(list, iArr);
        return iArr;
    }

    public static float g(float f10) {
        DisplayMetrics displayMetrics = f55009a;
        return displayMetrics == null ? f10 : f10 / displayMetrics.density;
    }

    public static String[] h(List<String> list) {
        int size = list.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = list.get(i10);
        }
        return strArr;
    }

    public static void i(List<Integer> list, int[] iArr) {
        int length = iArr.length < list.size() ? iArr.length : list.size();
        for (int i10 = 0; i10 < length; i10++) {
            iArr[i10] = list.get(i10).intValue();
        }
    }

    public static void j(List<String> list, String[] strArr) {
        int length = strArr.length < list.size() ? strArr.length : list.size();
        for (int i10 = 0; i10 < length; i10++) {
            strArr[i10] = list.get(i10);
        }
    }

    public static void k(Canvas canvas, Drawable drawable, int i10, int i11, int i12, int i13) {
        g gVarB = g.b();
        gVarB.f54987c = i10 - (i12 / 2);
        gVarB.f54988d = i11 - (i13 / 2);
        drawable.copyBounds(f55021m);
        Rect rect = f55021m;
        int i14 = rect.left;
        int i15 = rect.top;
        drawable.setBounds(i14, i15, i14 + i12, i12 + i15);
        int iSave = canvas.save();
        canvas.translate(gVarB.f54987c, gVarB.f54988d);
        drawable.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    public static void l(Canvas canvas, StaticLayout staticLayout, float f10, float f11, TextPaint textPaint, g gVar, float f12) {
        float fontMetrics = textPaint.getFontMetrics(f55023o);
        float width = staticLayout.getWidth();
        float lineCount = staticLayout.getLineCount() * fontMetrics;
        float f13 = 0.0f - f55022n.left;
        float f14 = lineCount + 0.0f;
        Paint.Align textAlign = textPaint.getTextAlign();
        textPaint.setTextAlign(Paint.Align.LEFT);
        if (f12 != 0.0f) {
            float f15 = f13 - (width * 0.5f);
            float f16 = f14 - (lineCount * 0.5f);
            if (gVar.f54987c != 0.5f || gVar.f54988d != 0.5f) {
                c cVarD = D(width, lineCount, f12);
                f10 -= cVarD.f54979c * (gVar.f54987c - 0.5f);
                f11 -= cVarD.f54980d * (gVar.f54988d - 0.5f);
                c.c(cVarD);
            }
            canvas.save();
            canvas.translate(f10, f11);
            canvas.rotate(f12);
            canvas.translate(f15, f16);
            staticLayout.draw(canvas);
            canvas.restore();
        } else {
            float f17 = gVar.f54987c;
            if (f17 != 0.0f || gVar.f54988d != 0.0f) {
                f13 -= width * f17;
                f14 -= lineCount * gVar.f54988d;
            }
            canvas.save();
            canvas.translate(f13 + f10, f14 + f11);
            staticLayout.draw(canvas);
            canvas.restore();
        }
        textPaint.setTextAlign(textAlign);
    }

    public static void m(Canvas canvas, String str, float f10, float f11, TextPaint textPaint, c cVar, g gVar, float f12) {
        l(canvas, new StaticLayout(str, 0, str.length(), textPaint, (int) Math.max(Math.ceil(cVar.f54979c), 1.0d), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false), f10, f11, textPaint, gVar, f12);
    }

    public static void n(Canvas canvas, String str, float f10, float f11, Paint paint, g gVar, float f12) {
        float fontMetrics = paint.getFontMetrics(f55023o);
        paint.getTextBounds(str, 0, str.length(), f55022n);
        float fWidth = 0.0f - f55022n.left;
        float f13 = (-f55023o.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f12 != 0.0f) {
            float fWidth2 = fWidth - (f55022n.width() * 0.5f);
            float f14 = f13 - (fontMetrics * 0.5f);
            if (gVar.f54987c != 0.5f || gVar.f54988d != 0.5f) {
                c cVarD = D(f55022n.width(), fontMetrics, f12);
                f10 -= cVarD.f54979c * (gVar.f54987c - 0.5f);
                f11 -= cVarD.f54980d * (gVar.f54988d - 0.5f);
                c.c(cVarD);
            }
            canvas.save();
            canvas.translate(f10, f11);
            canvas.rotate(f12);
            canvas.drawText(str, fWidth2, f14, paint);
            canvas.restore();
        } else {
            if (gVar.f54987c != 0.0f || gVar.f54988d != 0.0f) {
                fWidth -= f55022n.width() * gVar.f54987c;
                f13 -= fontMetrics * gVar.f54988d;
            }
            canvas.drawText(str, fWidth + f10, f13 + f11, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static String o(float f10, int i10, boolean z10) {
        return p(f10, i10, z10, '.');
    }

    public static String p(float f10, int i10, boolean z10, char c10) {
        boolean z11;
        float f11 = f10;
        char[] cArr = new char[35];
        if (f11 == 0.0f) {
            return "0";
        }
        int i11 = 0;
        boolean z12 = f11 < 1.0f && f11 > -1.0f;
        if (f11 < 0.0f) {
            f11 = -f11;
            z11 = true;
        } else {
            z11 = false;
        }
        int[] iArr = f55019k;
        int length = i10 > iArr.length ? iArr.length - 1 : i10;
        long jRound = Math.round(f11 * iArr[length]);
        int i12 = 34;
        boolean z13 = false;
        while (true) {
            if (jRound == 0 && i11 >= length + 1) {
                break;
            }
            boolean z14 = z13;
            int i13 = (int) (jRound % 10);
            jRound /= 10;
            int i14 = i12 - 1;
            cArr[i12] = (char) (i13 + 48);
            i11++;
            if (i11 == length) {
                i12 = i14 - 1;
                cArr[i14] = ',';
                i11++;
                z13 = true;
            } else if (!z10 || jRound == 0 || i11 <= length) {
                z13 = z14;
                i12 = i14;
            } else if (z14) {
                if ((i11 - length) % 4 == 0) {
                    i12 = i14 - 1;
                    cArr[i14] = c10;
                    i11++;
                    z13 = z14;
                }
                z13 = z14;
                i12 = i14;
            } else {
                if ((i11 - length) % 4 == 3) {
                    i12 = i14 - 1;
                    cArr[i14] = c10;
                    i11++;
                    z13 = z14;
                }
                z13 = z14;
                i12 = i14;
            }
        }
        if (z12) {
            cArr[i12] = '0';
            i11++;
            i12--;
        }
        if (z11) {
            cArr[i12] = '-';
            i11++;
        }
        int i15 = 35 - i11;
        return String.valueOf(cArr, i15, 35 - i15);
    }

    public static na.l q() {
        return new na.d(1);
    }

    public static int r(float f10) {
        float fL = L(f10);
        if (Float.isInfinite(fL)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10(fL))) + 2;
    }

    public static na.l s() {
        return f55020l;
    }

    public static float t(Paint paint) {
        return u(paint, f55017i);
    }

    public static float u(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float v(Paint paint) {
        return w(paint, f55017i);
    }

    public static float w(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static int x() {
        return f55011c;
    }

    public static int y() {
        return f55010b;
    }

    public static float z(float f10) {
        while (f10 < 0.0f) {
            f10 += 360.0f;
        }
        return f10 % 360.0f;
    }
}
