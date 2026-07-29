package h2;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.RestrictTo;
import com.blankj.utilcode.util.i0;
import g.l;
import g.n0;
import g.p0;
import g.v;
import g.v0;
import j0.n;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import m0.n;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class i extends h2.h {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f30314k = "VectorDrawableCompat";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final PorterDuff.Mode f30315l = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f30316m = "clip-path";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f30317n = "group";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f30318o = "path";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f30319p = "vector";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f30320q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f30321r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f30322s = 2;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f30323t = 0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f30324u = 1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f30325v = 2;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f30326w = 2048;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final boolean f30327x = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f30328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PorterDuffColorFilter f30329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ColorFilter f30330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f30331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f30332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable.ConstantState f30333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f30334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Matrix f30335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f30336j;

    public static class b extends f {
        public b() {
        }

        @Override // h2.i.f
        public boolean e() {
            return true;
        }

        public void i(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (n.r(xmlPullParser, "pathData")) {
                TypedArray typedArrayS = n.s(resources, theme, attributeSet, h2.a.I);
                j(typedArrayS, xmlPullParser);
                typedArrayS.recycle();
            }
        }

        public final void j(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f30364b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f30363a = m0.n.d(string2);
            }
            this.f30365c = n.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public b(b bVar) {
            super(bVar);
        }
    }

    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    public static class h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public g f30385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorStateList f30386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public PorterDuff.Mode f30387d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f30388e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Bitmap f30389f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int[] f30390g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ColorStateList f30391h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public PorterDuff.Mode f30392i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f30393j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f30394k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f30395l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Paint f30396m;

        public h(h hVar) {
            this.f30386c = null;
            this.f30387d = i.f30315l;
            if (hVar != null) {
                this.f30384a = hVar.f30384a;
                g gVar = new g(hVar.f30385b);
                this.f30385b = gVar;
                if (hVar.f30385b.f30372e != null) {
                    gVar.f30372e = new Paint(hVar.f30385b.f30372e);
                }
                if (hVar.f30385b.f30371d != null) {
                    this.f30385b.f30371d = new Paint(hVar.f30385b.f30371d);
                }
                this.f30386c = hVar.f30386c;
                this.f30387d = hVar.f30387d;
                this.f30388e = hVar.f30388e;
            }
        }

        public boolean a(int i10, int i11) {
            return i10 == this.f30389f.getWidth() && i11 == this.f30389f.getHeight();
        }

        public boolean b() {
            return !this.f30395l && this.f30391h == this.f30386c && this.f30392i == this.f30387d && this.f30394k == this.f30388e && this.f30393j == this.f30385b.getRootAlpha();
        }

        public void c(int i10, int i11) {
            if (this.f30389f == null || !a(i10, i11)) {
                this.f30389f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f30395l = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f30389f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f30396m == null) {
                Paint paint = new Paint();
                this.f30396m = paint;
                paint.setFilterBitmap(true);
            }
            this.f30396m.setAlpha(this.f30385b.getRootAlpha());
            this.f30396m.setColorFilter(colorFilter);
            return this.f30396m;
        }

        public boolean f() {
            return this.f30385b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f30385b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f30384a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f30385b.g(iArr);
            this.f30395l |= zG;
            return zG;
        }

        public void i() {
            this.f30391h = this.f30386c;
            this.f30392i = this.f30387d;
            this.f30393j = this.f30385b.getRootAlpha();
            this.f30394k = this.f30388e;
            this.f30395l = false;
        }

        public void j(int i10, int i11) {
            this.f30389f.eraseColor(0);
            this.f30385b.b(new Canvas(this.f30389f), i10, i11, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable() {
            return new i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @n0
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public h() {
            this.f30386c = null;
            this.f30387d = i.f30315l;
            this.f30385b = new g();
        }
    }

    public i() {
        this.f30332f = true;
        this.f30334h = new float[9];
        this.f30335i = new Matrix();
        this.f30336j = new Rect();
        this.f30328b = new h();
    }

    public static int a(int i10, float f10) {
        return (i10 & 16777215) | (((int) (Color.alpha(i10) * f10)) << 24);
    }

    @p0
    public static i e(@n0 Resources resources, @v int i10, @p0 Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.f30313a = j0.i.g(resources, i10, theme);
            iVar.f30333g = new C0359i(iVar.f30313a.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i10);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return f(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException unused) {
            return null;
        }
    }

    public static i f(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    public static PorterDuff.Mode k(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f30313a;
        if (drawable == null) {
            return false;
        }
        n0.c.b(drawable);
        return false;
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f30336j);
        if (this.f30336j.width() <= 0 || this.f30336j.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f30330d;
        if (colorFilter == null) {
            colorFilter = this.f30329c;
        }
        canvas.getMatrix(this.f30335i);
        this.f30335i.getValues(this.f30334h);
        float fAbs = Math.abs(this.f30334h[0]);
        float fAbs2 = Math.abs(this.f30334h[4]);
        float fAbs3 = Math.abs(this.f30334h[1]);
        float fAbs4 = Math.abs(this.f30334h[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(2048, (int) (this.f30336j.width() * fAbs));
        int iMin2 = Math.min(2048, (int) (this.f30336j.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f30336j;
        canvas.translate(rect.left, rect.top);
        if (j()) {
            canvas.translate(this.f30336j.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f30336j.offsetTo(0, 0);
        this.f30328b.c(iMin, iMin2);
        if (!this.f30332f) {
            this.f30328b.j(iMin, iMin2);
        } else if (!this.f30328b.b()) {
            this.f30328b.j(iMin, iMin2);
            this.f30328b.i();
        }
        this.f30328b.d(canvas, colorFilter, this.f30336j);
        canvas.restoreToCount(iSave);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float g() {
        g gVar;
        h hVar = this.f30328b;
        if (hVar == null || (gVar = hVar.f30385b) == null) {
            return 1.0f;
        }
        float f10 = gVar.f30376i;
        if (f10 == 0.0f) {
            return 1.0f;
        }
        float f11 = gVar.f30377j;
        if (f11 == 0.0f) {
            return 1.0f;
        }
        float f12 = gVar.f30379l;
        if (f12 == 0.0f) {
            return 1.0f;
        }
        float f13 = gVar.f30378k;
        if (f13 == 0.0f) {
            return 1.0f;
        }
        return Math.min(f13 / f10, f12 / f11);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f30313a;
        return drawable != null ? n0.c.d(drawable) : this.f30328b.f30385b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f30328b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f30313a;
        return drawable != null ? n0.c.e(drawable) : this.f30330d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f30313a != null && Build.VERSION.SDK_INT >= 24) {
            return new C0359i(this.f30313a.getConstantState());
        }
        this.f30328b.f30384a = getChangingConfigurations();
        return this.f30328b;
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f30328b.f30385b.f30377j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f30328b.f30385b.f30376i;
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public Object h(String str) {
        return this.f30328b.f30385b.f30383p.get(str);
    }

    public final void i(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f30328b;
        g gVar = hVar.f30385b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f30375h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.k(resources, attributeSet, theme, xmlPullParser);
                    dVar.f30350b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f30383p.put(cVar.getPathName(), cVar);
                    }
                    z10 = false;
                    hVar.f30384a = cVar.f30366d | hVar.f30384a;
                } else if (f30316m.equals(name)) {
                    b bVar = new b();
                    bVar.i(resources, attributeSet, theme, xmlPullParser);
                    dVar.f30350b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f30383p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f30384a = bVar.f30366d | hVar.f30384a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f30350b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f30383p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f30384a = dVar2.f30359k | hVar.f30384a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z10) {
            throw new XmlPullParserException("no path defined");
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f30313a;
        return drawable != null ? n0.c.h(drawable) : this.f30328b.f30388e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((hVar = this.f30328b) != null && (hVar.g() || ((colorStateList = this.f30328b.f30386c) != null && colorStateList.isStateful())));
    }

    public final boolean j() {
        return isAutoMirrored() && n0.c.f(this) == 1;
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public final void l(d dVar, int i10) {
        String str = "";
        for (int i11 = 0; i11 < i10; i11++) {
            str = str + wn.a.f54751a;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("current group is :");
        sb2.append(dVar.getGroupName());
        sb2.append(" rotation is ");
        sb2.append(dVar.f30351c);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("matrix is :");
        sb3.append(dVar.getLocalMatrix().toString());
        for (int i12 = 0; i12 < dVar.f30350b.size(); i12++) {
            e eVar = dVar.f30350b.get(i12);
            if (eVar instanceof d) {
                l((d) eVar, i10 + 1);
            } else {
                ((f) eVar).g(i10 + 1);
            }
        }
    }

    public void m(boolean z10) {
        this.f30332f = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f30331e && super.mutate() == this) {
            this.f30328b = new h(this.f30328b);
            this.f30331e = true;
        }
        return this;
    }

    public final void n(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f30328b;
        g gVar = hVar.f30385b;
        hVar.f30387d = k(n.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListG = n.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListG != null) {
            hVar.f30386c = colorStateListG;
        }
        hVar.f30388e = n.e(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f30388e);
        gVar.f30378k = n.j(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f30378k);
        float fJ = n.j(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f30379l);
        gVar.f30379l = fJ;
        if (gVar.f30378k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fJ <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f30376i = typedArray.getDimension(3, gVar.f30376i);
        float dimension = typedArray.getDimension(2, gVar.f30377j);
        gVar.f30377j = dimension;
        if (gVar.f30376i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(n.j(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f30381n = string;
            gVar.f30383p.put(string, gVar);
        }
    }

    public PorterDuffColorFilter o(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z10 = false;
        h hVar = this.f30328b;
        ColorStateList colorStateList = hVar.f30386c;
        if (colorStateList != null && (mode = hVar.f30387d) != null) {
            this.f30329c = o(this.f30329c, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f30328b.f30385b.getRootAlpha() != i10) {
            this.f30328b.f30385b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            n0.c.j(drawable, z10);
        } else {
            this.f30328b.f30388e = z10;
        }
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // h2.h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTint(int i10) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            n0.c.n(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            n0.c.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f30328b;
        if (hVar.f30386c != colorStateList) {
            hVar.f30386c = colorStateList;
            this.f30329c = o(this.f30329c, colorStateList, hVar.f30387d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, n0.i
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            n0.c.p(drawable, mode);
            return;
        }
        h hVar = this.f30328b;
        if (hVar.f30387d != mode) {
            hVar.f30387d = mode;
            this.f30329c = o(this.f30329c, hVar.f30386c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f30313a;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: renamed from: h2.i$i, reason: collision with other inner class name */
    @v0(24)
    public static class C0359i extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Drawable.ConstantState f30397a;

        public C0359i(Drawable.ConstantState constantState) {
            this.f30397a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f30397a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f30397a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f30313a = (VectorDrawable) this.f30397a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f30313a = (VectorDrawable) this.f30397a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f30313a = (VectorDrawable) this.f30397a.newDrawable(resources, theme);
            return iVar;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f30330d = colorFilter;
            invalidateSelf();
        }
    }

    public static abstract class f extends e {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f30362e = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public n.b[] f30363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f30364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f30365c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f30366d;

        public f() {
            super();
            this.f30363a = null;
            this.f30365c = 0;
        }

        public void c(Resources.Theme theme) {
        }

        public boolean d() {
            return false;
        }

        public boolean e() {
            return false;
        }

        public String f(n.b[] bVarArr) {
            String str = i0.f11861z;
            for (int i10 = 0; i10 < bVarArr.length; i10++) {
                str = str + bVarArr[i10].f40569a + ":";
                for (float f10 : bVarArr[i10].f40570b) {
                    str = str + f10 + ag.c.f654g;
                }
            }
            return str;
        }

        public void g(int i10) {
            String str = "";
            for (int i11 = 0; i11 < i10; i11++) {
                str = str + wn.a.f54751a;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("current path is :");
            sb2.append(this.f30364b);
            sb2.append(" pathData is ");
            sb2.append(f(this.f30363a));
        }

        public n.b[] getPathData() {
            return this.f30363a;
        }

        public String getPathName() {
            return this.f30364b;
        }

        public void h(Path path) {
            path.reset();
            n.b[] bVarArr = this.f30363a;
            if (bVarArr != null) {
                n.b.e(bVarArr, path);
            }
        }

        public void setPathData(n.b[] bVarArr) {
            if (m0.n.b(this.f30363a, bVarArr)) {
                m0.n.k(this.f30363a, bVarArr);
            } else {
                this.f30363a = m0.n.f(bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f30363a = null;
            this.f30365c = 0;
            this.f30364b = fVar.f30364b;
            this.f30366d = fVar.f30366d;
            this.f30363a = m0.n.f(fVar.f30363a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f30313a;
        if (drawable != null) {
            n0.c.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f30328b;
        hVar.f30385b = new g();
        TypedArray typedArrayS = j0.n.s(resources, theme, attributeSet, h2.a.f30224a);
        n(typedArrayS, xmlPullParser, theme);
        typedArrayS.recycle();
        hVar.f30384a = getChangingConfigurations();
        hVar.f30395l = true;
        i(resources, xmlPullParser, attributeSet, theme);
        this.f30329c = o(this.f30329c, hVar.f30386c, hVar.f30387d);
    }

    public i(@n0 h hVar) {
        this.f30332f = true;
        this.f30334h = new float[9];
        this.f30335i = new Matrix();
        this.f30336j = new Rect();
        this.f30328b = hVar;
        this.f30329c = o(this.f30329c, hVar.f30386c, hVar.f30387d);
    }

    public static class c extends f {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int[] f30337f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public j0.d f30338g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f30339h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public j0.d f30340i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f30341j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f30342k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f30343l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f30344m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f30345n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Paint.Cap f30346o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public Paint.Join f30347p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public float f30348q;

        public c() {
            this.f30339h = 0.0f;
            this.f30341j = 1.0f;
            this.f30342k = 1.0f;
            this.f30343l = 0.0f;
            this.f30344m = 1.0f;
            this.f30345n = 0.0f;
            this.f30346o = Paint.Cap.BUTT;
            this.f30347p = Paint.Join.MITER;
            this.f30348q = 4.0f;
        }

        @Override // h2.i.e
        public boolean a() {
            return this.f30340i.i() || this.f30338g.i();
        }

        @Override // h2.i.e
        public boolean b(int[] iArr) {
            return this.f30338g.j(iArr) | this.f30340i.j(iArr);
        }

        @Override // h2.i.f
        public void c(Resources.Theme theme) {
        }

        @Override // h2.i.f
        public boolean d() {
            return this.f30337f != null;
        }

        public float getFillAlpha() {
            return this.f30342k;
        }

        @l
        public int getFillColor() {
            return this.f30340i.e();
        }

        public float getStrokeAlpha() {
            return this.f30341j;
        }

        @l
        public int getStrokeColor() {
            return this.f30338g.e();
        }

        public float getStrokeWidth() {
            return this.f30339h;
        }

        public float getTrimPathEnd() {
            return this.f30344m;
        }

        public float getTrimPathOffset() {
            return this.f30345n;
        }

        public float getTrimPathStart() {
            return this.f30343l;
        }

        public final Paint.Cap i(int i10, Paint.Cap cap) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        public final Paint.Join j(int i10, Paint.Join join) {
            return i10 != 0 ? i10 != 1 ? i10 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        public void k(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayS = j0.n.s(resources, theme, attributeSet, h2.a.f30262t);
            l(typedArrayS, xmlPullParser, theme);
            typedArrayS.recycle();
        }

        public final void l(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f30337f = null;
            if (j0.n.r(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f30364b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f30363a = m0.n.d(string2);
                }
                this.f30340i = j0.n.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f30342k = j0.n.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f30342k);
                this.f30346o = i(j0.n.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f30346o);
                this.f30347p = j(j0.n.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f30347p);
                this.f30348q = j0.n.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f30348q);
                this.f30338g = j0.n.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f30341j = j0.n.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f30341j);
                this.f30339h = j0.n.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f30339h);
                this.f30344m = j0.n.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f30344m);
                this.f30345n = j0.n.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f30345n);
                this.f30343l = j0.n.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f30343l);
                this.f30365c = j0.n.k(typedArray, xmlPullParser, "fillType", 13, this.f30365c);
            }
        }

        public void setFillAlpha(float f10) {
            this.f30342k = f10;
        }

        public void setFillColor(int i10) {
            this.f30340i.k(i10);
        }

        public void setStrokeAlpha(float f10) {
            this.f30341j = f10;
        }

        public void setStrokeColor(int i10) {
            this.f30338g.k(i10);
        }

        public void setStrokeWidth(float f10) {
            this.f30339h = f10;
        }

        public void setTrimPathEnd(float f10) {
            this.f30344m = f10;
        }

        public void setTrimPathOffset(float f10) {
            this.f30345n = f10;
        }

        public void setTrimPathStart(float f10) {
            this.f30343l = f10;
        }

        public c(c cVar) {
            super(cVar);
            this.f30339h = 0.0f;
            this.f30341j = 1.0f;
            this.f30342k = 1.0f;
            this.f30343l = 0.0f;
            this.f30344m = 1.0f;
            this.f30345n = 0.0f;
            this.f30346o = Paint.Cap.BUTT;
            this.f30347p = Paint.Join.MITER;
            this.f30348q = 4.0f;
            this.f30337f = cVar.f30337f;
            this.f30338g = cVar.f30338g;
            this.f30339h = cVar.f30339h;
            this.f30341j = cVar.f30341j;
            this.f30340i = cVar.f30340i;
            this.f30365c = cVar.f30365c;
            this.f30342k = cVar.f30342k;
            this.f30343l = cVar.f30343l;
            this.f30344m = cVar.f30344m;
            this.f30345n = cVar.f30345n;
            this.f30346o = cVar.f30346o;
            this.f30347p = cVar.f30347p;
            this.f30348q = cVar.f30348q;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final Matrix f30367q = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Path f30368a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Path f30369b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Matrix f30370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Paint f30371d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Paint f30372e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public PathMeasure f30373f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f30374g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final d f30375h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f30376i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f30377j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f30378k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f30379l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f30380m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f30381n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Boolean f30382o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final androidx.collection.a<String, Object> f30383p;

        public g() {
            this.f30370c = new Matrix();
            this.f30376i = 0.0f;
            this.f30377j = 0.0f;
            this.f30378k = 0.0f;
            this.f30379l = 0.0f;
            this.f30380m = 255;
            this.f30381n = null;
            this.f30382o = null;
            this.f30383p = new androidx.collection.a<>();
            this.f30375h = new d();
            this.f30368a = new Path();
            this.f30369b = new Path();
        }

        public static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f30375h, f30367q, canvas, i10, i11, colorFilter);
        }

        public final void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            dVar.f30349a.set(matrix);
            dVar.f30349a.preConcat(dVar.f30358j);
            canvas.save();
            for (int i12 = 0; i12 < dVar.f30350b.size(); i12++) {
                e eVar = dVar.f30350b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f30349a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i10, i11, colorFilter);
                }
            }
            canvas.restore();
        }

        public final void d(d dVar, f fVar, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            float f10 = i10 / this.f30378k;
            float f11 = i11 / this.f30379l;
            float fMin = Math.min(f10, f11);
            Matrix matrix = dVar.f30349a;
            this.f30370c.set(matrix);
            this.f30370c.postScale(f10, f11);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            fVar.h(this.f30368a);
            Path path = this.f30368a;
            this.f30369b.reset();
            if (fVar.e()) {
                this.f30369b.setFillType(fVar.f30365c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f30369b.addPath(path, this.f30370c);
                canvas.clipPath(this.f30369b);
                return;
            }
            c cVar = (c) fVar;
            float f12 = cVar.f30343l;
            if (f12 != 0.0f || cVar.f30344m != 1.0f) {
                float f13 = cVar.f30345n;
                float f14 = (f12 + f13) % 1.0f;
                float f15 = (cVar.f30344m + f13) % 1.0f;
                if (this.f30373f == null) {
                    this.f30373f = new PathMeasure();
                }
                this.f30373f.setPath(this.f30368a, false);
                float length = this.f30373f.getLength();
                float f16 = f14 * length;
                float f17 = f15 * length;
                path.reset();
                if (f16 > f17) {
                    this.f30373f.getSegment(f16, length, path, true);
                    this.f30373f.getSegment(0.0f, f17, path, true);
                } else {
                    this.f30373f.getSegment(f16, f17, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f30369b.addPath(path, this.f30370c);
            if (cVar.f30340i.l()) {
                j0.d dVar2 = cVar.f30340i;
                if (this.f30372e == null) {
                    Paint paint = new Paint(1);
                    this.f30372e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f30372e;
                if (dVar2.h()) {
                    Shader shaderF = dVar2.f();
                    shaderF.setLocalMatrix(this.f30370c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(cVar.f30342k * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(i.a(dVar2.e(), cVar.f30342k));
                }
                paint2.setColorFilter(colorFilter);
                this.f30369b.setFillType(cVar.f30365c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f30369b, paint2);
            }
            if (cVar.f30338g.l()) {
                j0.d dVar3 = cVar.f30338g;
                if (this.f30371d == null) {
                    Paint paint3 = new Paint(1);
                    this.f30371d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f30371d;
                Paint.Join join = cVar.f30347p;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f30346o;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f30348q);
                if (dVar3.h()) {
                    Shader shaderF2 = dVar3.f();
                    shaderF2.setLocalMatrix(this.f30370c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(cVar.f30341j * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(i.a(dVar3.e(), cVar.f30341j));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f30339h * fMin * fE);
                canvas.drawPath(this.f30369b, paint4);
            }
        }

        public final float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public boolean f() {
            if (this.f30382o == null) {
                this.f30382o = Boolean.valueOf(this.f30375h.a());
            }
            return this.f30382o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f30375h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f30380m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f30380m = i10;
        }

        public g(g gVar) {
            this.f30370c = new Matrix();
            this.f30376i = 0.0f;
            this.f30377j = 0.0f;
            this.f30378k = 0.0f;
            this.f30379l = 0.0f;
            this.f30380m = 255;
            this.f30381n = null;
            this.f30382o = null;
            androidx.collection.a<String, Object> aVar = new androidx.collection.a<>();
            this.f30383p = aVar;
            this.f30375h = new d(gVar.f30375h, aVar);
            this.f30368a = new Path(gVar.f30368a);
            this.f30369b = new Path(gVar.f30369b);
            this.f30376i = gVar.f30376i;
            this.f30377j = gVar.f30377j;
            this.f30378k = gVar.f30378k;
            this.f30379l = gVar.f30379l;
            this.f30374g = gVar.f30374g;
            this.f30380m = gVar.f30380m;
            this.f30381n = gVar.f30381n;
            String str = gVar.f30381n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f30382o = gVar.f30382o;
        }
    }

    public static class d extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Matrix f30349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<e> f30350b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f30351c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f30352d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f30353e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f30354f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f30355g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f30356h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f30357i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Matrix f30358j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f30359k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int[] f30360l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public String f30361m;

        public d(d dVar, androidx.collection.a<String, Object> aVar) {
            f bVar;
            super();
            this.f30349a = new Matrix();
            this.f30350b = new ArrayList<>();
            this.f30351c = 0.0f;
            this.f30352d = 0.0f;
            this.f30353e = 0.0f;
            this.f30354f = 1.0f;
            this.f30355g = 1.0f;
            this.f30356h = 0.0f;
            this.f30357i = 0.0f;
            Matrix matrix = new Matrix();
            this.f30358j = matrix;
            this.f30361m = null;
            this.f30351c = dVar.f30351c;
            this.f30352d = dVar.f30352d;
            this.f30353e = dVar.f30353e;
            this.f30354f = dVar.f30354f;
            this.f30355g = dVar.f30355g;
            this.f30356h = dVar.f30356h;
            this.f30357i = dVar.f30357i;
            this.f30360l = dVar.f30360l;
            String str = dVar.f30361m;
            this.f30361m = str;
            this.f30359k = dVar.f30359k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f30358j);
            ArrayList<e> arrayList = dVar.f30350b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                e eVar = arrayList.get(i10);
                if (eVar instanceof d) {
                    this.f30350b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else {
                        if (!(eVar instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) eVar);
                    }
                    this.f30350b.add(bVar);
                    String str2 = bVar.f30364b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        @Override // h2.i.e
        public boolean a() {
            for (int i10 = 0; i10 < this.f30350b.size(); i10++) {
                if (this.f30350b.get(i10).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // h2.i.e
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i10 = 0; i10 < this.f30350b.size(); i10++) {
                zB |= this.f30350b.get(i10).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayS = j0.n.s(resources, theme, attributeSet, h2.a.f30244k);
            e(typedArrayS, xmlPullParser);
            typedArrayS.recycle();
        }

        public final void d() {
            this.f30358j.reset();
            this.f30358j.postTranslate(-this.f30352d, -this.f30353e);
            this.f30358j.postScale(this.f30354f, this.f30355g);
            this.f30358j.postRotate(this.f30351c, 0.0f, 0.0f);
            this.f30358j.postTranslate(this.f30356h + this.f30352d, this.f30357i + this.f30353e);
        }

        public final void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f30360l = null;
            this.f30351c = j0.n.j(typedArray, xmlPullParser, androidx.constraintlayout.motion.widget.f.f3647i, 5, this.f30351c);
            this.f30352d = typedArray.getFloat(1, this.f30352d);
            this.f30353e = typedArray.getFloat(2, this.f30353e);
            this.f30354f = j0.n.j(typedArray, xmlPullParser, "scaleX", 3, this.f30354f);
            this.f30355g = j0.n.j(typedArray, xmlPullParser, "scaleY", 4, this.f30355g);
            this.f30356h = j0.n.j(typedArray, xmlPullParser, "translateX", 6, this.f30356h);
            this.f30357i = j0.n.j(typedArray, xmlPullParser, "translateY", 7, this.f30357i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f30361m = string;
            }
            d();
        }

        public String getGroupName() {
            return this.f30361m;
        }

        public Matrix getLocalMatrix() {
            return this.f30358j;
        }

        public float getPivotX() {
            return this.f30352d;
        }

        public float getPivotY() {
            return this.f30353e;
        }

        public float getRotation() {
            return this.f30351c;
        }

        public float getScaleX() {
            return this.f30354f;
        }

        public float getScaleY() {
            return this.f30355g;
        }

        public float getTranslateX() {
            return this.f30356h;
        }

        public float getTranslateY() {
            return this.f30357i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f30352d) {
                this.f30352d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f30353e) {
                this.f30353e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f30351c) {
                this.f30351c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f30354f) {
                this.f30354f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f30355g) {
                this.f30355g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f30356h) {
                this.f30356h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f30357i) {
                this.f30357i = f10;
                d();
            }
        }

        public d() {
            super();
            this.f30349a = new Matrix();
            this.f30350b = new ArrayList<>();
            this.f30351c = 0.0f;
            this.f30352d = 0.0f;
            this.f30353e = 0.0f;
            this.f30354f = 1.0f;
            this.f30355g = 1.0f;
            this.f30356h = 0.0f;
            this.f30357i = 0.0f;
            this.f30358j = new Matrix();
            this.f30361m = null;
        }
    }
}
