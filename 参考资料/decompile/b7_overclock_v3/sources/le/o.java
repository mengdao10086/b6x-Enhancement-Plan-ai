package le;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.RestrictTo;
import com.google.android.material.R;
import g.d1;
import g.n0;

/* JADX INFO: loaded from: classes3.dex */
public class o {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d f39664m = new m(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f39665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f39666b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f39667c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f39668d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f39669e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f39670f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d f39671g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public d f39672h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f39673i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public g f39674j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f39675k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f39676l;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public interface c {
        @n0
        d a(@n0 d dVar);
    }

    @n0
    public static b a() {
        return new b();
    }

    @n0
    public static b b(Context context, @d1 int i10, @d1 int i11) {
        return c(context, i10, i11, 0);
    }

    @n0
    public static b c(Context context, @d1 int i10, @d1 int i11, int i12) {
        return d(context, i10, i11, new le.a(i12));
    }

    @n0
    public static b d(Context context, @d1 int i10, @d1 int i11, @n0 d dVar) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i10);
        if (i11 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i11);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.ShapeAppearance);
        try {
            int i12 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i13 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i12);
            int i14 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i12);
            int i15 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i12);
            int i16 = typedArrayObtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i12);
            d dVarM = m(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, dVar);
            d dVarM2 = m(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, dVarM);
            d dVarM3 = m(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, dVarM);
            d dVarM4 = m(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, dVarM);
            return new b().I(i13, dVarM2).N(i14, dVarM3).A(i15, dVarM4).v(i16, m(typedArrayObtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, dVarM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @n0
    public static b e(@n0 Context context, AttributeSet attributeSet, @g.f int i10, @d1 int i11) {
        return f(context, attributeSet, i10, i11, 0);
    }

    @n0
    public static b f(@n0 Context context, AttributeSet attributeSet, @g.f int i10, @d1 int i11, int i12) {
        return g(context, attributeSet, i10, i11, new le.a(i12));
    }

    @n0
    public static b g(@n0 Context context, AttributeSet attributeSet, @g.f int i10, @d1 int i11, @n0 d dVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i10, i11);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, dVar);
    }

    @n0
    public static d m(TypedArray typedArray, int i10, @n0 d dVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i10);
        if (typedValuePeekValue == null) {
            return dVar;
        }
        int i11 = typedValuePeekValue.type;
        return i11 == 5 ? new le.a(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i11 == 6 ? new m(typedValuePeekValue.getFraction(1.0f, 1.0f)) : dVar;
    }

    @n0
    public g h() {
        return this.f39675k;
    }

    @n0
    public e i() {
        return this.f39668d;
    }

    @n0
    public d j() {
        return this.f39672h;
    }

    @n0
    public e k() {
        return this.f39667c;
    }

    @n0
    public d l() {
        return this.f39671g;
    }

    @n0
    public g n() {
        return this.f39676l;
    }

    @n0
    public g o() {
        return this.f39674j;
    }

    @n0
    public g p() {
        return this.f39673i;
    }

    @n0
    public e q() {
        return this.f39665a;
    }

    @n0
    public d r() {
        return this.f39669e;
    }

    @n0
    public e s() {
        return this.f39666b;
    }

    @n0
    public d t() {
        return this.f39670f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean u(@n0 RectF rectF) {
        boolean z10 = this.f39676l.getClass().equals(g.class) && this.f39674j.getClass().equals(g.class) && this.f39673i.getClass().equals(g.class) && this.f39675k.getClass().equals(g.class);
        float fA = this.f39669e.a(rectF);
        return z10 && ((this.f39670f.a(rectF) > fA ? 1 : (this.f39670f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f39672h.a(rectF) > fA ? 1 : (this.f39672h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f39671g.a(rectF) > fA ? 1 : (this.f39671g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f39666b instanceof n) && (this.f39665a instanceof n) && (this.f39667c instanceof n) && (this.f39668d instanceof n));
    }

    @n0
    public b v() {
        return new b(this);
    }

    @n0
    public o w(float f10) {
        return v().o(f10).m();
    }

    @n0
    public o x(@n0 d dVar) {
        return v().p(dVar).m();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public o y(@n0 c cVar) {
        return v().L(cVar.a(r())).Q(cVar.a(t())).y(cVar.a(j())).D(cVar.a(l())).m();
    }

    public o(@n0 b bVar) {
        this.f39665a = bVar.f39677a;
        this.f39666b = bVar.f39678b;
        this.f39667c = bVar.f39679c;
        this.f39668d = bVar.f39680d;
        this.f39669e = bVar.f39681e;
        this.f39670f = bVar.f39682f;
        this.f39671g = bVar.f39683g;
        this.f39672h = bVar.f39684h;
        this.f39673i = bVar.f39685i;
        this.f39674j = bVar.f39686j;
        this.f39675k = bVar.f39687k;
        this.f39676l = bVar.f39688l;
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public e f39677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public e f39678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public e f39679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @n0
        public e f39680d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @n0
        public d f39681e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @n0
        public d f39682f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @n0
        public d f39683g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @n0
        public d f39684h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @n0
        public g f39685i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @n0
        public g f39686j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        @n0
        public g f39687k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        @n0
        public g f39688l;

        public b() {
            this.f39677a = k.b();
            this.f39678b = k.b();
            this.f39679c = k.b();
            this.f39680d = k.b();
            this.f39681e = new le.a(0.0f);
            this.f39682f = new le.a(0.0f);
            this.f39683g = new le.a(0.0f);
            this.f39684h = new le.a(0.0f);
            this.f39685i = k.c();
            this.f39686j = k.c();
            this.f39687k = k.c();
            this.f39688l = k.c();
        }

        public static float n(e eVar) {
            if (eVar instanceof n) {
                return ((n) eVar).f39663a;
            }
            if (eVar instanceof f) {
                return ((f) eVar).f39600a;
            }
            return -1.0f;
        }

        @n0
        public b A(int i10, @n0 d dVar) {
            return B(k.a(i10)).D(dVar);
        }

        @n0
        public b B(@n0 e eVar) {
            this.f39679c = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                C(fN);
            }
            return this;
        }

        @n0
        public b C(@g.r float f10) {
            this.f39683g = new le.a(f10);
            return this;
        }

        @n0
        public b D(@n0 d dVar) {
            this.f39683g = dVar;
            return this;
        }

        @n0
        public b E(@n0 g gVar) {
            this.f39688l = gVar;
            return this;
        }

        @n0
        public b F(@n0 g gVar) {
            this.f39686j = gVar;
            return this;
        }

        @n0
        public b G(@n0 g gVar) {
            this.f39685i = gVar;
            return this;
        }

        @n0
        public b H(int i10, @g.r float f10) {
            return J(k.a(i10)).K(f10);
        }

        @n0
        public b I(int i10, @n0 d dVar) {
            return J(k.a(i10)).L(dVar);
        }

        @n0
        public b J(@n0 e eVar) {
            this.f39677a = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                K(fN);
            }
            return this;
        }

        @n0
        public b K(@g.r float f10) {
            this.f39681e = new le.a(f10);
            return this;
        }

        @n0
        public b L(@n0 d dVar) {
            this.f39681e = dVar;
            return this;
        }

        @n0
        public b M(int i10, @g.r float f10) {
            return O(k.a(i10)).P(f10);
        }

        @n0
        public b N(int i10, @n0 d dVar) {
            return O(k.a(i10)).Q(dVar);
        }

        @n0
        public b O(@n0 e eVar) {
            this.f39678b = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                P(fN);
            }
            return this;
        }

        @n0
        public b P(@g.r float f10) {
            this.f39682f = new le.a(f10);
            return this;
        }

        @n0
        public b Q(@n0 d dVar) {
            this.f39682f = dVar;
            return this;
        }

        @n0
        public o m() {
            return new o(this);
        }

        @n0
        public b o(@g.r float f10) {
            return K(f10).P(f10).C(f10).x(f10);
        }

        @n0
        public b p(@n0 d dVar) {
            return L(dVar).Q(dVar).D(dVar).y(dVar);
        }

        @n0
        public b q(int i10, @g.r float f10) {
            return r(k.a(i10)).o(f10);
        }

        @n0
        public b r(@n0 e eVar) {
            return J(eVar).O(eVar).B(eVar).w(eVar);
        }

        @n0
        public b s(@n0 g gVar) {
            return E(gVar).G(gVar).F(gVar).t(gVar);
        }

        @n0
        public b t(@n0 g gVar) {
            this.f39687k = gVar;
            return this;
        }

        @n0
        public b u(int i10, @g.r float f10) {
            return w(k.a(i10)).x(f10);
        }

        @n0
        public b v(int i10, @n0 d dVar) {
            return w(k.a(i10)).y(dVar);
        }

        @n0
        public b w(@n0 e eVar) {
            this.f39680d = eVar;
            float fN = n(eVar);
            if (fN != -1.0f) {
                x(fN);
            }
            return this;
        }

        @n0
        public b x(@g.r float f10) {
            this.f39684h = new le.a(f10);
            return this;
        }

        @n0
        public b y(@n0 d dVar) {
            this.f39684h = dVar;
            return this;
        }

        @n0
        public b z(int i10, @g.r float f10) {
            return B(k.a(i10)).C(f10);
        }

        public b(@n0 o oVar) {
            this.f39677a = k.b();
            this.f39678b = k.b();
            this.f39679c = k.b();
            this.f39680d = k.b();
            this.f39681e = new le.a(0.0f);
            this.f39682f = new le.a(0.0f);
            this.f39683g = new le.a(0.0f);
            this.f39684h = new le.a(0.0f);
            this.f39685i = k.c();
            this.f39686j = k.c();
            this.f39687k = k.c();
            this.f39688l = k.c();
            this.f39677a = oVar.f39665a;
            this.f39678b = oVar.f39666b;
            this.f39679c = oVar.f39667c;
            this.f39680d = oVar.f39668d;
            this.f39681e = oVar.f39669e;
            this.f39682f = oVar.f39670f;
            this.f39683g = oVar.f39671g;
            this.f39684h = oVar.f39672h;
            this.f39685i = oVar.f39673i;
            this.f39686j = oVar.f39674j;
            this.f39687k = oVar.f39675k;
            this.f39688l = oVar.f39676l;
        }
    }

    public o() {
        this.f39665a = k.b();
        this.f39666b = k.b();
        this.f39667c = k.b();
        this.f39668d = k.b();
        this.f39669e = new le.a(0.0f);
        this.f39670f = new le.a(0.0f);
        this.f39671g = new le.a(0.0f);
        this.f39672h = new le.a(0.0f);
        this.f39673i = k.c();
        this.f39674j = k.c();
        this.f39675k = k.c();
        this.f39676l = k.c();
    }
}
