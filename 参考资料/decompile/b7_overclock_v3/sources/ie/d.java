package ie;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import g.d1;
import g.i1;
import g.n0;
import g.p0;
import g.y;
import j0.i;

/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class d {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f32314r = "TextAppearance";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f32315s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f32316t = 2;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f32317u = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final ColorStateList f32318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final ColorStateList f32319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final ColorStateList f32320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final String f32321d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f32322e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f32323f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f32324g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f32325h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f32326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f32327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f32328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f32329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @p0
    public ColorStateList f32330m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f32331n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @y
    public final int f32332o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f32333p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Typeface f32334q;

    public class a extends i.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f32335a;

        public a(f fVar) {
            this.f32335a = fVar;
        }

        @Override // j0.i.g
        /* JADX INFO: renamed from: h */
        public void f(int i10) {
            d.this.f32333p = true;
            this.f32335a.a(i10);
        }

        @Override // j0.i.g
        /* JADX INFO: renamed from: i */
        public void g(@n0 Typeface typeface) {
            d dVar = d.this;
            dVar.f32334q = Typeface.create(typeface, dVar.f32322e);
            d.this.f32333p = true;
            this.f32335a.b(d.this.f32334q, false);
        }
    }

    public class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f32337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextPaint f32338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f32339c;

        public b(Context context, TextPaint textPaint, f fVar) {
            this.f32337a = context;
            this.f32338b = textPaint;
            this.f32339c = fVar;
        }

        @Override // ie.f
        public void a(int i10) {
            this.f32339c.a(i10);
        }

        @Override // ie.f
        public void b(@n0 Typeface typeface, boolean z10) {
            d.this.p(this.f32337a, this.f32338b, typeface);
            this.f32339c.b(typeface, z10);
        }
    }

    public d(@n0 Context context, @d1 int i10) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i10, R.styleable.TextAppearance);
        l(typedArrayObtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f));
        k(c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColor));
        this.f32318a = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.f32319b = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f32322e = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f32323f = typedArrayObtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int iF = c.f(typedArrayObtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.f32332o = typedArrayObtainStyledAttributes.getResourceId(iF, 0);
        this.f32321d = typedArrayObtainStyledAttributes.getString(iF);
        this.f32324g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.f32320c = c.a(context, typedArrayObtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f32325h = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f32326i = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f32327j = typedArrayObtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i10, R.styleable.MaterialTextAppearance);
        int i11 = R.styleable.MaterialTextAppearance_android_letterSpacing;
        this.f32328k = typedArrayObtainStyledAttributes2.hasValue(i11);
        this.f32329l = typedArrayObtainStyledAttributes2.getFloat(i11, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    public final void d() {
        String str;
        if (this.f32334q == null && (str = this.f32321d) != null) {
            this.f32334q = Typeface.create(str, this.f32322e);
        }
        if (this.f32334q == null) {
            int i10 = this.f32323f;
            if (i10 == 1) {
                this.f32334q = Typeface.SANS_SERIF;
            } else if (i10 == 2) {
                this.f32334q = Typeface.SERIF;
            } else if (i10 != 3) {
                this.f32334q = Typeface.DEFAULT;
            } else {
                this.f32334q = Typeface.MONOSPACE;
            }
            this.f32334q = Typeface.create(this.f32334q, this.f32322e);
        }
    }

    public Typeface e() {
        d();
        return this.f32334q;
    }

    @i1
    @n0
    public Typeface f(@n0 Context context) {
        if (this.f32333p) {
            return this.f32334q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceJ = i.j(context, this.f32332o);
                this.f32334q = typefaceJ;
                if (typefaceJ != null) {
                    this.f32334q = Typeface.create(typefaceJ, this.f32322e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception unused2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Error loading font ");
                sb2.append(this.f32321d);
            }
        }
        d();
        this.f32333p = true;
        return this.f32334q;
    }

    public void g(@n0 Context context, @n0 TextPaint textPaint, @n0 f fVar) {
        p(context, textPaint, e());
        h(context, new b(context, textPaint, fVar));
    }

    public void h(@n0 Context context, @n0 f fVar) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i10 = this.f32332o;
        if (i10 == 0) {
            this.f32333p = true;
        }
        if (this.f32333p) {
            fVar.b(this.f32334q, true);
            return;
        }
        try {
            i.l(context, i10, new a(fVar), null);
        } catch (Resources.NotFoundException unused) {
            this.f32333p = true;
            fVar.a(1);
        } catch (Exception unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Error loading font ");
            sb2.append(this.f32321d);
            this.f32333p = true;
            fVar.a(-3);
        }
    }

    @p0
    public ColorStateList i() {
        return this.f32330m;
    }

    public float j() {
        return this.f32331n;
    }

    public void k(@p0 ColorStateList colorStateList) {
        this.f32330m = colorStateList;
    }

    public void l(float f10) {
        this.f32331n = f10;
    }

    public final boolean m(Context context) {
        if (e.b()) {
            return true;
        }
        int i10 = this.f32332o;
        return (i10 != 0 ? i.d(context, i10) : null) != null;
    }

    public void n(@n0 Context context, @n0 TextPaint textPaint, @n0 f fVar) {
        o(context, textPaint, fVar);
        ColorStateList colorStateList = this.f32330m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f10 = this.f32327j;
        float f11 = this.f32325h;
        float f12 = this.f32326i;
        ColorStateList colorStateList2 = this.f32320c;
        textPaint.setShadowLayer(f10, f11, f12, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(@n0 Context context, @n0 TextPaint textPaint, @n0 f fVar) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, fVar);
        }
    }

    public void p(@n0 Context context, @n0 TextPaint textPaint, @n0 Typeface typeface) {
        Typeface typefaceA = g.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i10 = this.f32322e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i10 & 1) != 0);
        textPaint.setTextSkewX((i10 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f32331n);
        if (this.f32328k) {
            textPaint.setLetterSpacing(this.f32329l);
        }
    }
}
