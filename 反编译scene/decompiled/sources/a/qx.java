package a;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class qx {
    public static final Paint b;
    public static final boolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f7247a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ly f2619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TimeInterpolator f2620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ColorStateList f2621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Bitmap f2622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f2623a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Typeface f2626a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StaticLayout f2627a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f2629a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f2630a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2631a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f2632a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ly f2635b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public TimeInterpolator f2636b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ColorStateList f2637b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Typeface f2639b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f2641b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2642b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ColorStateList f2644c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Typeface f2645c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f2646c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2647c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ColorStateList f2648d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2649d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public float f2650e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2618a = 16;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f2634b = 16;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float f2633b = 15.0f;
    public float c = 15.0f;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f2643c = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextPaint f2628a = new TextPaint(129);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final TextPaint f2640b = new TextPaint(this.f2628a);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Rect f2638b = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Rect f2624a = new Rect();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RectF f2625a = new RectF();

    static {
        e = Build.VERSION.SDK_INT < 18;
        Paint paint = null;
        b = null;
        if (0 != 0) {
            paint.setAntiAlias(true);
            b.setColor(-65281);
        }
    }

    public qx(View view) {
        this.f2629a = view;
    }

    public static float C(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return kv.a(f, f2, f3);
    }

    public static boolean F(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }

    public static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    public static boolean z(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    public final boolean A() {
        return eh.y(this.f2629a) == 1;
    }

    public final boolean B() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f2637b;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f2621a) != null && colorStateList.isStateful());
    }

    public void D() {
        this.f2631a = this.f2638b.width() > 0 && this.f2638b.height() > 0 && this.f2624a.width() > 0 && this.f2624a.height() > 0;
    }

    public void E() {
        if (this.f2629a.getHeight() <= 0 || this.f2629a.getWidth() <= 0) {
            return;
        }
        b();
        d();
    }

    public void G(int i, int i2, int i3, int i4) {
        if (F(this.f2638b, i, i2, i3, i4)) {
            return;
        }
        this.f2638b.set(i, i2, i3, i4);
        this.f2649d = true;
        D();
    }

    public void H(Rect rect) {
        G(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void I(int i) {
        qy qyVar = new qy(this.f2629a.getContext(), i);
        ColorStateList colorStateList = qyVar.f2653a;
        if (colorStateList != null) {
            this.f2637b = colorStateList;
        }
        float f = qyVar.f7250a;
        if (f != 0.0f) {
            this.c = f;
        }
        ColorStateList colorStateList2 = qyVar.f2658b;
        if (colorStateList2 != null) {
            this.f2644c = colorStateList2;
        }
        this.m = qyVar.b;
        this.n = qyVar.c;
        this.l = qyVar.d;
        ly lyVar = this.f2635b;
        if (lyVar != null) {
            lyVar.c();
        }
        this.f2635b = new ly(new px(this), qyVar.e());
        qyVar.h(this.f2629a.getContext(), this.f2635b);
        E();
    }

    public final void J(float f) {
        this.r = f;
        eh.b0(this.f2629a);
    }

    public void K(ColorStateList colorStateList) {
        if (this.f2637b != colorStateList) {
            this.f2637b = colorStateList;
            E();
        }
    }

    public void L(int i) {
        if (this.f2634b != i) {
            this.f2634b = i;
            E();
        }
    }

    public void M(Typeface typeface) {
        if (N(typeface)) {
            E();
        }
    }

    public final boolean N(Typeface typeface) {
        ly lyVar = this.f2635b;
        if (lyVar != null) {
            lyVar.c();
        }
        if (this.f2626a == typeface) {
            return false;
        }
        this.f2626a = typeface;
        return true;
    }

    public void O(int i, int i2, int i3, int i4) {
        if (F(this.f2624a, i, i2, i3, i4)) {
            return;
        }
        this.f2624a.set(i, i2, i3, i4);
        this.f2649d = true;
        D();
    }

    public void P(Rect rect) {
        O(rect.left, rect.top, rect.right, rect.bottom);
    }

    public final void Q(float f) {
        this.s = f;
        eh.b0(this.f2629a);
    }

    public void R(ColorStateList colorStateList) {
        if (this.f2621a != colorStateList) {
            this.f2621a = colorStateList;
            E();
        }
    }

    public void S(int i) {
        if (this.f2618a != i) {
            this.f2618a = i;
            E();
        }
    }

    public void T(float f) {
        if (this.f2633b != f) {
            this.f2633b = f;
            E();
        }
    }

    public final boolean U(Typeface typeface) {
        ly lyVar = this.f2619a;
        if (lyVar != null) {
            lyVar.c();
        }
        if (this.f2639b == typeface) {
            return false;
        }
        this.f2639b = typeface;
        return true;
    }

    public void V(float f) {
        float fA = sd.a(f, 0.0f, 1.0f);
        if (fA != this.f7247a) {
            this.f7247a = fA;
            d();
        }
    }

    public final void W(float f) {
        g(f);
        boolean z = e && this.j != 1.0f;
        this.f2647c = z;
        if (z) {
            l();
        }
        eh.b0(this.f2629a);
    }

    public void X(TimeInterpolator timeInterpolator) {
        this.f2620a = timeInterpolator;
        E();
    }

    public final boolean Y(int[] iArr) {
        this.f2632a = iArr;
        if (!B()) {
            return false;
        }
        E();
        return true;
    }

    public void Z(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.f2630a, charSequence)) {
            this.f2630a = charSequence;
            this.f2641b = null;
            h();
            E();
        }
    }

    public void a0(TimeInterpolator timeInterpolator) {
        this.f2636b = timeInterpolator;
        E();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.qx.b():void");
    }

    public void b0(Typeface typeface) {
        boolean zN = N(typeface);
        boolean zU = U(typeface);
        if (zN || zU) {
            E();
        }
    }

    public float c() {
        if (this.f2630a == null) {
            return 0.0f;
        }
        w(this.f2640b);
        TextPaint textPaint = this.f2640b;
        CharSequence charSequence = this.f2630a;
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    public final boolean c0() {
        return (this.f2643c <= 1 || this.f2642b || this.f2647c) ? false : true;
    }

    public final void d() {
        f(this.f7247a);
    }

    public final boolean e(CharSequence charSequence) {
        return (A() ? ff.d : ff.c).a(charSequence, 0, charSequence.length());
    }

    public final void f(float f) {
        TextPaint textPaint;
        int iR;
        y(f);
        this.h = C(this.f, this.g, f, this.f2620a);
        this.i = C(this.d, this.f2650e, f, this.f2620a);
        W(C(this.f2633b, this.c, f, this.f2636b));
        J(1.0f - C(0.0f, 1.0f, 1.0f - f, kv.b));
        Q(C(1.0f, 0.0f, f, kv.b));
        if (this.f2637b != this.f2621a) {
            textPaint = this.f2628a;
            iR = a(t(), r(), f);
        } else {
            textPaint = this.f2628a;
            iR = r();
        }
        textPaint.setColor(iR);
        this.f2628a.setShadowLayer(C(this.o, this.l, f, null), C(this.p, this.m, f, null), C(this.q, this.n, f, null), a(s(this.f2648d), s(this.f2644c), f));
        eh.b0(this.f2629a);
    }

    public final void g(float f) {
        boolean z;
        float f2;
        boolean z2;
        if (this.f2630a == null) {
            return;
        }
        float fWidth = this.f2638b.width();
        float fWidth2 = this.f2624a.width();
        if (z(f, this.c)) {
            f2 = this.c;
            this.j = 1.0f;
            Typeface typeface = this.f2645c;
            Typeface typeface2 = this.f2626a;
            if (typeface != typeface2) {
                this.f2645c = typeface2;
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            float f3 = this.f2633b;
            Typeface typeface3 = this.f2645c;
            Typeface typeface4 = this.f2639b;
            if (typeface3 != typeface4) {
                this.f2645c = typeface4;
                z = true;
            } else {
                z = false;
            }
            if (z(f, this.f2633b)) {
                this.j = 1.0f;
            } else {
                this.j = f / this.f2633b;
            }
            float f4 = this.c / this.f2633b;
            fWidth = fWidth2 * f4 > fWidth ? Math.min(fWidth / f4, fWidth2) : fWidth2;
            f2 = f3;
            z2 = z;
        }
        if (fWidth > 0.0f) {
            z2 = this.k != f2 || this.f2649d || z2;
            this.k = f2;
            this.f2649d = false;
        }
        if (this.f2641b == null || z2) {
            this.f2628a.setTextSize(this.k);
            this.f2628a.setTypeface(this.f2645c);
            this.f2628a.setLinearText(this.j != 1.0f);
            this.f2642b = e(this.f2630a);
            StaticLayout staticLayoutI = i(c0() ? this.f2643c : 1, fWidth, this.f2642b);
            this.f2627a = staticLayoutI;
            this.f2641b = staticLayoutI.getText();
        }
    }

    public final void h() {
        Bitmap bitmap = this.f2622a;
        if (bitmap != null) {
            bitmap.recycle();
            this.f2622a = null;
        }
    }

    public final StaticLayout i(int i, float f, boolean z) {
        StaticLayout staticLayoutA;
        try {
            zx zxVarC = zx.c(this.f2630a, this.f2628a, (int) f);
            zxVarC.e(TextUtils.TruncateAt.END);
            zxVarC.g(z);
            zxVarC.d(Layout.Alignment.ALIGN_NORMAL);
            zxVarC.f(false);
            zxVarC.h(i);
            staticLayoutA = zxVarC.a();
        } catch (yx e2) {
            Log.e("CollapsingTextHelper", e2.getCause().getMessage(), e2);
            staticLayoutA = null;
        }
        pf.b(staticLayoutA);
        return staticLayoutA;
    }

    public void j(Canvas canvas) {
        int iSave = canvas.save();
        if (this.f2641b == null || !this.f2631a) {
            return;
        }
        boolean z = false;
        float lineLeft = (this.h + this.f2627a.getLineLeft(0)) - (this.t * 2.0f);
        this.f2628a.setTextSize(this.k);
        float f = this.h;
        float f2 = this.i;
        if (this.f2647c && this.f2622a != null) {
            z = true;
        }
        float f3 = this.j;
        if (f3 != 1.0f) {
            canvas.scale(f3, f3, f, f2);
        }
        if (z) {
            canvas.drawBitmap(this.f2622a, f, f2, this.f2623a);
            canvas.restoreToCount(iSave);
            return;
        }
        if (c0()) {
            k(canvas, lineLeft, f2);
        } else {
            canvas.translate(f, f2);
            this.f2627a.draw(canvas);
        }
        canvas.restoreToCount(iSave);
    }

    public final void k(Canvas canvas, float f, float f2) {
        int alpha = this.f2628a.getAlpha();
        canvas.translate(f, f2);
        float f3 = alpha;
        this.f2628a.setAlpha((int) (this.s * f3));
        this.f2627a.draw(canvas);
        this.f2628a.setAlpha((int) (this.r * f3));
        int lineBaseline = this.f2627a.getLineBaseline(0);
        CharSequence charSequence = this.f2646c;
        float f4 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f4, this.f2628a);
        String strTrim = this.f2646c.toString().trim();
        if (strTrim.endsWith("…")) {
            strTrim = strTrim.substring(0, strTrim.length() - 1);
        }
        String str = strTrim;
        this.f2628a.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f2627a.getLineEnd(0), str.length()), 0.0f, f4, (Paint) this.f2628a);
    }

    public final void l() {
        if (this.f2622a != null || this.f2624a.isEmpty() || TextUtils.isEmpty(this.f2641b)) {
            return;
        }
        f(0.0f);
        int width = this.f2627a.getWidth();
        int height = this.f2627a.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.f2622a = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f2627a.draw(new Canvas(this.f2622a));
        if (this.f2623a == null) {
            this.f2623a = new Paint(3);
        }
    }

    public void m(RectF rectF, int i, int i2) {
        this.f2642b = e(this.f2630a);
        rectF.left = p(i, i2);
        rectF.top = this.f2638b.top;
        rectF.right = q(rectF, i, i2);
        rectF.bottom = this.f2638b.top + o();
    }

    public ColorStateList n() {
        return this.f2637b;
    }

    public float o() {
        w(this.f2640b);
        return -this.f2640b.ascent();
    }

    public final float p(int i, int i2) {
        return (i2 == 17 || (i2 & 7) == 1) ? (i / 2.0f) - (c() / 2.0f) : ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) ? this.f2642b ? this.f2638b.left : this.f2638b.right - c() : this.f2642b ? this.f2638b.right - c() : this.f2638b.left;
    }

    public final float q(RectF rectF, int i, int i2) {
        return (i2 == 17 || (i2 & 7) == 1) ? (i / 2.0f) + (c() / 2.0f) : ((i2 & 8388613) == 8388613 || (i2 & 5) == 5) ? this.f2642b ? rectF.left + c() : this.f2638b.right : this.f2642b ? this.f2638b.right : rectF.left + c();
    }

    public int r() {
        return s(this.f2637b);
    }

    public final int s(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.f2632a;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    public final int t() {
        return s(this.f2621a);
    }

    public float u() {
        x(this.f2640b);
        return -this.f2640b.ascent();
    }

    public float v() {
        return this.f7247a;
    }

    public final void w(TextPaint textPaint) {
        textPaint.setTextSize(this.c);
        textPaint.setTypeface(this.f2626a);
    }

    public final void x(TextPaint textPaint) {
        textPaint.setTextSize(this.f2633b);
        textPaint.setTypeface(this.f2639b);
    }

    public final void y(float f) {
        this.f2625a.left = C(this.f2624a.left, this.f2638b.left, f, this.f2620a);
        this.f2625a.top = C(this.d, this.f2650e, f, this.f2620a);
        this.f2625a.right = C(this.f2624a.right, this.f2638b.right, f, this.f2620a);
        this.f2625a.bottom = C(this.f2624a.bottom, this.f2638b.bottom, f, this.f2620a);
    }
}
