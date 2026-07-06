package a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class nz {
    public static final bz e = new kz(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bz f6959a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public cz f2163a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ez f2164a;
    public bz b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public cz f2165b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ez f2166b;
    public bz c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public cz f2167c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ez f2168c;
    public bz d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public cz f2169d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ez f2170d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public bz f6960a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public cz f2171a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ez f2172a;
        public bz b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public cz f2173b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public ez f2174b;
        public bz c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public cz f2175c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public ez f2176c;
        public bz d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public cz f2177d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public ez f2178d;

        public a() {
            this.f2171a = jz.b();
            this.f2173b = jz.b();
            this.f2175c = jz.b();
            this.f2177d = jz.b();
            this.f6960a = new zy(0.0f);
            this.b = new zy(0.0f);
            this.c = new zy(0.0f);
            this.d = new zy(0.0f);
            this.f2172a = jz.c();
            this.f2174b = jz.c();
            this.f2176c = jz.c();
            this.f2178d = jz.c();
        }

        public a(nz nzVar) {
            this.f2171a = jz.b();
            this.f2173b = jz.b();
            this.f2175c = jz.b();
            this.f2177d = jz.b();
            this.f6960a = new zy(0.0f);
            this.b = new zy(0.0f);
            this.c = new zy(0.0f);
            this.d = new zy(0.0f);
            this.f2172a = jz.c();
            this.f2174b = jz.c();
            this.f2176c = jz.c();
            this.f2178d = jz.c();
            this.f2171a = nzVar.f2163a;
            this.f2173b = nzVar.f2165b;
            this.f2175c = nzVar.f2167c;
            this.f2177d = nzVar.f2169d;
            this.f6960a = nzVar.f6959a;
            this.b = nzVar.b;
            this.c = nzVar.c;
            this.d = nzVar.d;
            this.f2172a = nzVar.f2164a;
            this.f2174b = nzVar.f2166b;
            this.f2176c = nzVar.f2168c;
            this.f2178d = nzVar.f2170d;
        }

        public static float n(cz czVar) {
            if (czVar instanceof lz) {
                return ((lz) czVar).f6749a;
            }
            if (czVar instanceof dz) {
                return ((dz) czVar).f5949a;
            }
            return -1.0f;
        }

        public a A(bz bzVar) {
            this.f6960a = bzVar;
            return this;
        }

        public a B(int i, bz bzVar) {
            C(jz.a(i));
            E(bzVar);
            return this;
        }

        public a C(cz czVar) {
            this.f2173b = czVar;
            float fN = n(czVar);
            if (fN != -1.0f) {
                D(fN);
            }
            return this;
        }

        public a D(float f) {
            this.b = new zy(f);
            return this;
        }

        public a E(bz bzVar) {
            this.b = bzVar;
            return this;
        }

        public nz m() {
            return new nz(this);
        }

        public a o(float f) {
            z(f);
            D(f);
            v(f);
            r(f);
            return this;
        }

        public a p(int i, bz bzVar) {
            q(jz.a(i));
            s(bzVar);
            return this;
        }

        public a q(cz czVar) {
            this.f2177d = czVar;
            float fN = n(czVar);
            if (fN != -1.0f) {
                r(fN);
            }
            return this;
        }

        public a r(float f) {
            this.d = new zy(f);
            return this;
        }

        public a s(bz bzVar) {
            this.d = bzVar;
            return this;
        }

        public a t(int i, bz bzVar) {
            u(jz.a(i));
            w(bzVar);
            return this;
        }

        public a u(cz czVar) {
            this.f2175c = czVar;
            float fN = n(czVar);
            if (fN != -1.0f) {
                v(fN);
            }
            return this;
        }

        public a v(float f) {
            this.c = new zy(f);
            return this;
        }

        public a w(bz bzVar) {
            this.c = bzVar;
            return this;
        }

        public a x(int i, bz bzVar) {
            y(jz.a(i));
            A(bzVar);
            return this;
        }

        public a y(cz czVar) {
            this.f2171a = czVar;
            float fN = n(czVar);
            if (fN != -1.0f) {
                z(fN);
            }
            return this;
        }

        public a z(float f) {
            this.f6960a = new zy(f);
            return this;
        }
    }

    public nz() {
        this.f2163a = jz.b();
        this.f2165b = jz.b();
        this.f2167c = jz.b();
        this.f2169d = jz.b();
        this.f6959a = new zy(0.0f);
        this.b = new zy(0.0f);
        this.c = new zy(0.0f);
        this.d = new zy(0.0f);
        this.f2164a = jz.c();
        this.f2166b = jz.c();
        this.f2168c = jz.c();
        this.f2170d = jz.c();
    }

    public nz(a aVar) {
        this.f2163a = aVar.f2171a;
        this.f2165b = aVar.f2173b;
        this.f2167c = aVar.f2175c;
        this.f2169d = aVar.f2177d;
        this.f6959a = aVar.f6960a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.f2164a = aVar.f2172a;
        this.f2166b = aVar.f2174b;
        this.f2168c = aVar.f2176c;
        this.f2170d = aVar.f2178d;
    }

    public static a a() {
        return new a();
    }

    public static a b(Context context, int i, int i2, bz bzVar) {
        if (i2 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
            i = i2;
            context = contextThemeWrapper;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i, jv.ShapeAppearance);
        try {
            int i3 = typedArrayObtainStyledAttributes.getInt(jv.ShapeAppearance_cornerFamily, 0);
            int i4 = typedArrayObtainStyledAttributes.getInt(jv.ShapeAppearance_cornerFamilyTopLeft, i3);
            int i5 = typedArrayObtainStyledAttributes.getInt(jv.ShapeAppearance_cornerFamilyTopRight, i3);
            int i6 = typedArrayObtainStyledAttributes.getInt(jv.ShapeAppearance_cornerFamilyBottomRight, i3);
            int i7 = typedArrayObtainStyledAttributes.getInt(jv.ShapeAppearance_cornerFamilyBottomLeft, i3);
            bz bzVarK = k(typedArrayObtainStyledAttributes, jv.ShapeAppearance_cornerSize, bzVar);
            bz bzVarK2 = k(typedArrayObtainStyledAttributes, jv.ShapeAppearance_cornerSizeTopLeft, bzVarK);
            bz bzVarK3 = k(typedArrayObtainStyledAttributes, jv.ShapeAppearance_cornerSizeTopRight, bzVarK);
            bz bzVarK4 = k(typedArrayObtainStyledAttributes, jv.ShapeAppearance_cornerSizeBottomRight, bzVarK);
            bz bzVarK5 = k(typedArrayObtainStyledAttributes, jv.ShapeAppearance_cornerSizeBottomLeft, bzVarK);
            a aVar = new a();
            aVar.x(i4, bzVarK2);
            aVar.B(i5, bzVarK3);
            aVar.t(i6, bzVarK4);
            aVar.p(i7, bzVarK5);
            return aVar;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static a c(Context context, AttributeSet attributeSet, int i, int i2) {
        return d(context, attributeSet, i, i2, 0);
    }

    public static a d(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        return e(context, attributeSet, i, i2, new zy(i3));
    }

    public static a e(Context context, AttributeSet attributeSet, int i, int i2, bz bzVar) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jv.MaterialShape, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(jv.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(jv.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        return b(context, resourceId, resourceId2, bzVar);
    }

    public static bz k(TypedArray typedArray, int i, bz bzVar) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        if (typedValuePeekValue == null) {
            return bzVar;
        }
        int i2 = typedValuePeekValue.type;
        return i2 == 5 ? new zy(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics())) : i2 == 6 ? new kz(typedValuePeekValue.getFraction(1.0f, 1.0f)) : bzVar;
    }

    public ez f() {
        return this.f2168c;
    }

    public cz g() {
        return this.f2169d;
    }

    public bz h() {
        return this.d;
    }

    public cz i() {
        return this.f2167c;
    }

    public bz j() {
        return this.c;
    }

    public ez l() {
        return this.f2170d;
    }

    public ez m() {
        return this.f2166b;
    }

    public ez n() {
        return this.f2164a;
    }

    public cz o() {
        return this.f2163a;
    }

    public bz p() {
        return this.f6959a;
    }

    public cz q() {
        return this.f2165b;
    }

    public bz r() {
        return this.b;
    }

    public boolean s(RectF rectF) {
        boolean z = this.f2170d.getClass().equals(ez.class) && this.f2166b.getClass().equals(ez.class) && this.f2164a.getClass().equals(ez.class) && this.f2168c.getClass().equals(ez.class);
        float fA = this.f6959a.a(rectF);
        return z && ((this.b.a(rectF) > fA ? 1 : (this.b.a(rectF) == fA ? 0 : -1)) == 0 && (this.d.a(rectF) > fA ? 1 : (this.d.a(rectF) == fA ? 0 : -1)) == 0 && (this.c.a(rectF) > fA ? 1 : (this.c.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f2165b instanceof lz) && (this.f2163a instanceof lz) && (this.f2167c instanceof lz) && (this.f2169d instanceof lz));
    }

    public a t() {
        return new a(this);
    }

    public nz u(float f) {
        a aVarT = t();
        aVarT.o(f);
        return aVarT.m();
    }

    public nz v(oz ozVar) {
        a aVarT = t();
        aVarT.A(ozVar.a(p()));
        aVarT.E(ozVar.a(r()));
        aVarT.s(ozVar.a(h()));
        aVarT.w(ozVar.a(j()));
        return aVarT.m();
    }
}
