package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.RestrictTo;
import androidx.appcompat.resources.R;
import j.a;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class n0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f2599h = "ResourceManagerInternal";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f2600i = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f2602k = "appcompat_skip_skip";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f2603l = "android.graphics.drawable.VectorDrawable";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static n0 f2604m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap<Context, androidx.collection.m<ColorStateList>> f2606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public androidx.collection.l<String, e> f2607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.collection.m<String> f2608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap<Context, androidx.collection.h<WeakReference<Drawable.ConstantState>>> f2609d = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f2610e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f2611f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f2612g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final PorterDuff.Mode f2601j = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f2605n = new c(6);

    public static class a implements e {
        @Override // androidx.appcompat.widget.n0.e
        public Drawable a(@g.n0 Context context, @g.n0 XmlPullParser xmlPullParser, @g.n0 AttributeSet attributeSet, @g.p0 Resources.Theme theme) {
            try {
                return androidx.appcompat.graphics.drawable.a.C(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class b implements e {
        @Override // androidx.appcompat.widget.n0.e
        public Drawable a(@g.n0 Context context, @g.n0 XmlPullParser xmlPullParser, @g.n0 AttributeSet attributeSet, @g.p0 Resources.Theme theme) {
            try {
                return h2.c.f(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static class c extends androidx.collection.j<Integer, PorterDuffColorFilter> {
        public c(int i10) {
            super(i10);
        }

        public static int s(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter t(int i10, PorterDuff.Mode mode) {
            return f(Integer.valueOf(s(i10, mode)));
        }

        public PorterDuffColorFilter u(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return j(Integer.valueOf(s(i10, mode)), porterDuffColorFilter);
        }
    }

    public static class d implements e {
        @Override // androidx.appcompat.widget.n0.e
        public Drawable a(@g.n0 Context context, @g.n0 XmlPullParser xmlPullParser, @g.n0 AttributeSet attributeSet, @g.p0 Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    a.c.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception unused) {
                }
            }
            return null;
        }
    }

    public interface e {
        Drawable a(@g.n0 Context context, @g.n0 XmlPullParser xmlPullParser, @g.n0 AttributeSet attributeSet, @g.p0 Resources.Theme theme);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface f {
        boolean a(@g.n0 Context context, @g.v int i10, @g.n0 Drawable drawable);

        @g.p0
        PorterDuff.Mode b(int i10);

        @g.p0
        Drawable c(@g.n0 n0 n0Var, @g.n0 Context context, @g.v int i10);

        @g.p0
        ColorStateList d(@g.n0 Context context, @g.v int i10);

        boolean e(@g.n0 Context context, @g.v int i10, @g.n0 Drawable drawable);
    }

    public static class g implements e {
        @Override // androidx.appcompat.widget.n0.e
        public Drawable a(@g.n0 Context context, @g.n0 XmlPullParser xmlPullParser, @g.n0 AttributeSet attributeSet, @g.p0 Resources.Theme theme) {
            try {
                return h2.i.f(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    public static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized n0 h() {
        if (f2604m == null) {
            n0 n0Var = new n0();
            f2604m = n0Var;
            p(n0Var);
        }
        return f2604m;
    }

    public static synchronized PorterDuffColorFilter l(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterT;
        c cVar = f2605n;
        porterDuffColorFilterT = cVar.t(i10, mode);
        if (porterDuffColorFilterT == null) {
            porterDuffColorFilterT = new PorterDuffColorFilter(i10, mode);
            cVar.u(i10, mode, porterDuffColorFilterT);
        }
        return porterDuffColorFilterT;
    }

    public static void p(@g.n0 n0 n0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            n0Var.a(h2.i.f30319p, new g());
            n0Var.a(h2.c.f30279j, new b());
            n0Var.a("animated-selector", new a());
            n0Var.a("drawable", new d());
        }
    }

    public static boolean q(@g.n0 Drawable drawable) {
        return (drawable instanceof h2.i) || f2603l.equals(drawable.getClass().getName());
    }

    public static void w(Drawable drawable, w0 w0Var, int[] iArr) {
        int[] state = drawable.getState();
        if (d0.a(drawable)) {
            if (!(drawable.mutate() == drawable)) {
                return;
            }
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z10 = w0Var.f2729d;
        if (z10 || w0Var.f2728c) {
            drawable.setColorFilter(g(z10 ? w0Var.f2726a : null, w0Var.f2728c ? w0Var.f2727b : f2601j, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final void a(@g.n0 String str, @g.n0 e eVar) {
        if (this.f2607b == null) {
            this.f2607b = new androidx.collection.l<>();
        }
        this.f2607b.put(str, eVar);
    }

    public final synchronized boolean b(@g.n0 Context context, long j10, @g.n0 Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        androidx.collection.h<WeakReference<Drawable.ConstantState>> hVar = this.f2609d.get(context);
        if (hVar == null) {
            hVar = new androidx.collection.h<>();
            this.f2609d.put(context, hVar);
        }
        hVar.n(j10, new WeakReference<>(constantState));
        return true;
    }

    public final void c(@g.n0 Context context, @g.v int i10, @g.n0 ColorStateList colorStateList) {
        if (this.f2606a == null) {
            this.f2606a = new WeakHashMap<>();
        }
        androidx.collection.m<ColorStateList> mVar = this.f2606a.get(context);
        if (mVar == null) {
            mVar = new androidx.collection.m<>();
            this.f2606a.put(context, mVar);
        }
        mVar.a(i10, colorStateList);
    }

    public final void d(@g.n0 Context context) {
        if (this.f2611f) {
            return;
        }
        this.f2611f = true;
        Drawable drawableJ = j(context, R.drawable.abc_vector_test);
        if (drawableJ == null || !q(drawableJ)) {
            this.f2611f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public final Drawable f(@g.n0 Context context, @g.v int i10) {
        if (this.f2610e == null) {
            this.f2610e = new TypedValue();
        }
        TypedValue typedValue = this.f2610e;
        context.getResources().getValue(i10, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        f fVar = this.f2612g;
        Drawable drawableC = fVar == null ? null : fVar.c(this, context, i10);
        if (drawableC != null) {
            drawableC.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jE, drawableC);
        }
        return drawableC;
    }

    public final synchronized Drawable i(@g.n0 Context context, long j10) {
        androidx.collection.h<WeakReference<Drawable.ConstantState>> hVar = this.f2609d.get(context);
        if (hVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceH = hVar.h(j10);
        if (weakReferenceH != null) {
            Drawable.ConstantState constantState = weakReferenceH.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            hVar.q(j10);
        }
        return null;
    }

    public synchronized Drawable j(@g.n0 Context context, @g.v int i10) {
        return k(context, i10, false);
    }

    public synchronized Drawable k(@g.n0 Context context, @g.v int i10, boolean z10) {
        Drawable drawableR;
        d(context);
        drawableR = r(context, i10);
        if (drawableR == null) {
            drawableR = f(context, i10);
        }
        if (drawableR == null) {
            drawableR = h0.d.i(context, i10);
        }
        if (drawableR != null) {
            drawableR = v(context, i10, z10, drawableR);
        }
        if (drawableR != null) {
            d0.b(drawableR);
        }
        return drawableR;
    }

    public synchronized ColorStateList m(@g.n0 Context context, @g.v int i10) {
        ColorStateList colorStateListN;
        colorStateListN = n(context, i10);
        if (colorStateListN == null) {
            f fVar = this.f2612g;
            colorStateListN = fVar == null ? null : fVar.d(context, i10);
            if (colorStateListN != null) {
                c(context, i10, colorStateListN);
            }
        }
        return colorStateListN;
    }

    public final ColorStateList n(@g.n0 Context context, @g.v int i10) {
        androidx.collection.m<ColorStateList> mVar;
        WeakHashMap<Context, androidx.collection.m<ColorStateList>> weakHashMap = this.f2606a;
        if (weakHashMap == null || (mVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return mVar.h(i10);
    }

    public PorterDuff.Mode o(int i10) {
        f fVar = this.f2612g;
        if (fVar == null) {
            return null;
        }
        return fVar.b(i10);
    }

    public final Drawable r(@g.n0 Context context, @g.v int i10) {
        int next;
        androidx.collection.l<String, e> lVar = this.f2607b;
        if (lVar == null || lVar.isEmpty()) {
            return null;
        }
        androidx.collection.m<String> mVar = this.f2608c;
        if (mVar != null) {
            String strH = mVar.h(i10);
            if (f2602k.equals(strH) || (strH != null && this.f2607b.get(strH) == null)) {
                return null;
            }
        } else {
            this.f2608c = new androidx.collection.m<>();
        }
        if (this.f2610e == null) {
            this.f2610e = new TypedValue();
        }
        TypedValue typedValue = this.f2610e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(androidx.appcompat.widget.c.f2376y)) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f2608c.a(i10, name);
                e eVar = this.f2607b.get(name);
                if (eVar != null) {
                    drawableI = eVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableI != null) {
                    drawableI.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jE, drawableI);
                }
            } catch (Exception unused) {
            }
        }
        if (drawableI == null) {
            this.f2608c.a(i10, f2602k);
        }
        return drawableI;
    }

    public synchronized void s(@g.n0 Context context) {
        androidx.collection.h<WeakReference<Drawable.ConstantState>> hVar = this.f2609d.get(context);
        if (hVar != null) {
            hVar.b();
        }
    }

    public synchronized Drawable t(@g.n0 Context context, @g.n0 g1 g1Var, @g.v int i10) {
        Drawable drawableR = r(context, i10);
        if (drawableR == null) {
            drawableR = g1Var.a(i10);
        }
        if (drawableR == null) {
            return null;
        }
        return v(context, i10, false, drawableR);
    }

    public synchronized void u(f fVar) {
        this.f2612g = fVar;
    }

    public final Drawable v(@g.n0 Context context, @g.v int i10, boolean z10, @g.n0 Drawable drawable) {
        ColorStateList colorStateListM = m(context, i10);
        if (colorStateListM == null) {
            f fVar = this.f2612g;
            if ((fVar == null || !fVar.e(context, i10, drawable)) && !x(context, i10, drawable) && z10) {
                return null;
            }
            return drawable;
        }
        if (d0.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableR = n0.c.r(drawable);
        n0.c.o(drawableR, colorStateListM);
        PorterDuff.Mode modeO = o(i10);
        if (modeO == null) {
            return drawableR;
        }
        n0.c.p(drawableR, modeO);
        return drawableR;
    }

    public boolean x(@g.n0 Context context, @g.v int i10, @g.n0 Drawable drawable) {
        f fVar = this.f2612g;
        return fVar != null && fVar.a(context, i10, drawable);
    }
}
