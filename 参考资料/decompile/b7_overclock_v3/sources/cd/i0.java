package cd;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import g.p0;
import hd.u0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: classes3.dex */
public final class i0 {
    public static final String K = "SubtitlePainter";
    public static final float L = 0.125f;
    public int A;
    public int B;
    public int C;
    public int D;
    public StaticLayout E;
    public StaticLayout F;
    public int G;
    public int H;
    public int I;
    public Rect J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f10877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f10878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f10879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f10880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f10881e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextPaint f10882f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Paint f10883g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Paint f10884h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public CharSequence f10885i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public Layout.Alignment f10886j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public Bitmap f10887k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f10888l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10889m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10890n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f10891o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f10892p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f10893q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f10894r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f10895s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f10896t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f10897u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f10898v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f10899w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f10900x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f10901y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f10902z;

    public i0(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f10881e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f10880d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f10877a = fRound;
        this.f10878b = fRound;
        this.f10879c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f10882f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f10883g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f10884h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    public static boolean a(@p0 CharSequence charSequence, @p0 CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    public void b(qc.b bVar, qc.a aVar, float f10, float f11, float f12, Canvas canvas, int i10, int i11, int i12, int i13) {
        boolean z10 = bVar.f47234c == null;
        int i14 = -16777216;
        if (z10) {
            if (TextUtils.isEmpty(bVar.f47232a)) {
                return;
            } else {
                i14 = bVar.f47242k ? bVar.f47243l : aVar.f47218c;
            }
        }
        if (a(this.f10885i, bVar.f47232a) && u0.c(this.f10886j, bVar.f47233b) && this.f10887k == bVar.f47234c && this.f10888l == bVar.f47235d && this.f10889m == bVar.f47236e && u0.c(Integer.valueOf(this.f10890n), Integer.valueOf(bVar.f47237f)) && this.f10891o == bVar.f47238g && u0.c(Integer.valueOf(this.f10892p), Integer.valueOf(bVar.f47239h)) && this.f10893q == bVar.f47240i && this.f10894r == bVar.f47241j && this.f10895s == aVar.f47216a && this.f10896t == aVar.f47217b && this.f10897u == i14 && this.f10899w == aVar.f47219d && this.f10898v == aVar.f47220e && u0.c(this.f10882f.getTypeface(), aVar.f47221f) && this.f10900x == f10 && this.f10901y == f11 && this.f10902z == f12 && this.A == i10 && this.B == i11 && this.C == i12 && this.D == i13) {
            d(canvas, z10);
            return;
        }
        this.f10885i = bVar.f47232a;
        this.f10886j = bVar.f47233b;
        this.f10887k = bVar.f47234c;
        this.f10888l = bVar.f47235d;
        this.f10889m = bVar.f47236e;
        this.f10890n = bVar.f47237f;
        this.f10891o = bVar.f47238g;
        this.f10892p = bVar.f47239h;
        this.f10893q = bVar.f47240i;
        this.f10894r = bVar.f47241j;
        this.f10895s = aVar.f47216a;
        this.f10896t = aVar.f47217b;
        this.f10897u = i14;
        this.f10899w = aVar.f47219d;
        this.f10898v = aVar.f47220e;
        this.f10882f.setTypeface(aVar.f47221f);
        this.f10900x = f10;
        this.f10901y = f11;
        this.f10902z = f12;
        this.A = i10;
        this.B = i11;
        this.C = i12;
        this.D = i13;
        if (z10) {
            hd.a.g(this.f10885i);
            g();
        } else {
            hd.a.g(this.f10887k);
            f();
        }
        d(canvas, z10);
    }

    @RequiresNonNull({"cueBitmap", "bitmapRect"})
    public final void c(Canvas canvas) {
        canvas.drawBitmap(this.f10887k, (Rect) null, this.J, this.f10884h);
    }

    public final void d(Canvas canvas, boolean z10) {
        if (z10) {
            e(canvas);
            return;
        }
        hd.a.g(this.J);
        hd.a.g(this.f10887k);
        c(canvas);
    }

    public final void e(Canvas canvas) {
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f10897u) > 0) {
            this.f10883g.setColor(this.f10897u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.f10883g);
        }
        int i10 = this.f10899w;
        if (i10 == 1) {
            this.f10882f.setStrokeJoin(Paint.Join.ROUND);
            this.f10882f.setStrokeWidth(this.f10877a);
            this.f10882f.setColor(this.f10898v);
            this.f10882f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i10 == 2) {
            TextPaint textPaint = this.f10882f;
            float f10 = this.f10878b;
            float f11 = this.f10879c;
            textPaint.setShadowLayer(f10, f11, f11, this.f10898v);
        } else if (i10 == 3 || i10 == 4) {
            boolean z10 = i10 == 3;
            int i11 = z10 ? -1 : this.f10898v;
            int i12 = z10 ? this.f10898v : -1;
            float f12 = this.f10878b / 2.0f;
            this.f10882f.setColor(this.f10895s);
            this.f10882f.setStyle(Paint.Style.FILL);
            float f13 = -f12;
            this.f10882f.setShadowLayer(this.f10878b, f13, f13, i11);
            staticLayout2.draw(canvas);
            this.f10882f.setShadowLayer(this.f10878b, f12, f12, i12);
        }
        this.f10882f.setColor(this.f10895s);
        this.f10882f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f10882f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(iSave);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueBitmap"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.f10887k
            int r1 = r7.C
            int r2 = r7.A
            int r1 = r1 - r2
            int r3 = r7.D
            int r4 = r7.B
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.f10891o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f10888l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.f10893q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.f10894r
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L32
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            goto L44
        L32:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
        L44:
            int r3 = r7.f10892p
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L4d
            float r3 = (float) r1
        L4b:
            float r2 = r2 - r3
            goto L53
        L4d:
            if (r3 != r5) goto L53
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L4b
        L53:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.f10890n
            if (r3 != r6) goto L5e
            float r3 = (float) r0
        L5c:
            float r4 = r4 - r3
            goto L64
        L5e:
            if (r3 != r5) goto L64
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L5c
        L64:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.J = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cd.i0.f():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01a8  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"cueText"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g() {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cd.i0.g():void");
    }
}
