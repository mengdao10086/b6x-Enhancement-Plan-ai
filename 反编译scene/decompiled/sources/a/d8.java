package a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static d8 f5870a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b8 f506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ia<String, a8> f507a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ja<String> f508a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TypedValue f509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakHashMap<Context, ja<ColorStateList>> f510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f511a;
    public final WeakHashMap<Context, fa<WeakReference<Drawable.ConstantState>>> b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final PorterDuff.Mode f505a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final z7 f504a = new z7(6);

    public static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    public static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized d8 h() {
        if (f5870a == null) {
            d8 d8Var = new d8();
            f5870a = d8Var;
            p(d8Var);
        }
        return f5870a;
    }

    public static synchronized PorterDuffColorFilter l(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterI;
        porterDuffColorFilterI = f504a.i(i, mode);
        if (porterDuffColorFilterI == null) {
            porterDuffColorFilterI = new PorterDuffColorFilter(i, mode);
            f504a.j(i, mode, porterDuffColorFilterI);
        }
        return porterDuffColorFilterI;
    }

    public static void p(d8 d8Var) {
        if (Build.VERSION.SDK_INT < 24) {
            d8Var.a("vector", new c8());
            d8Var.a("animated-vector", new y7());
            d8Var.a("animated-selector", new x7());
        }
    }

    public static boolean q(Drawable drawable) {
        return (drawable instanceof gu) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void w(Drawable drawable, m8 m8Var, int[] iArr) {
        if (e7.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (m8Var.b || m8Var.f1905a) {
            drawable.setColorFilter(g(m8Var.b ? m8Var.f6781a : null, m8Var.f1905a ? m8Var.f1904a : f505a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final void a(String str, a8 a8Var) {
        if (this.f507a == null) {
            this.f507a = new ia<>();
        }
        this.f507a.put(str, a8Var);
    }

    public final synchronized boolean b(Context context, long j, Drawable drawable) {
        boolean z;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            fa<WeakReference<Drawable.ConstantState>> faVar = this.b.get(context);
            if (faVar == null) {
                faVar = new fa<>();
                this.b.put(context, faVar);
            }
            faVar.i(j, new WeakReference<>(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final void c(Context context, int i, ColorStateList colorStateList) {
        if (this.f510a == null) {
            this.f510a = new WeakHashMap<>();
        }
        ja<ColorStateList> jaVar = this.f510a.get(context);
        if (jaVar == null) {
            jaVar = new ja<>();
            this.f510a.put(context, jaVar);
        }
        jaVar.a(i, colorStateList);
    }

    public final void d(Context context) {
        if (this.f511a) {
            return;
        }
        this.f511a = true;
        Drawable drawableJ = j(context, h3.abc_vector_test);
        if (drawableJ == null || !q(drawableJ)) {
            this.f511a = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public final Drawable f(Context context, int i) {
        if (this.f509a == null) {
            this.f509a = new TypedValue();
        }
        TypedValue typedValue = this.f509a;
        context.getResources().getValue(i, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        b8 b8Var = this.f506a;
        Drawable drawableE = b8Var == null ? null : b8Var.e(this, context, i);
        if (drawableE != null) {
            drawableE.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, jE, drawableE);
        }
        return drawableE;
    }

    public final synchronized Drawable i(Context context, long j) {
        fa<WeakReference<Drawable.ConstantState>> faVar = this.b.get(context);
        if (faVar == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> weakReferenceE = faVar.e(j);
        if (weakReferenceE != null) {
            Drawable.ConstantState constantState = weakReferenceE.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            faVar.j(j);
        }
        return null;
    }

    public synchronized Drawable j(Context context, int i) {
        return k(context, i, false);
    }

    public synchronized Drawable k(Context context, int i, boolean z) {
        Drawable drawableR;
        d(context);
        drawableR = r(context, i);
        if (drawableR == null) {
            drawableR = f(context, i);
        }
        if (drawableR == null) {
            drawableR = yb.d(context, i);
        }
        if (drawableR != null) {
            drawableR = v(context, i, z, drawableR);
        }
        if (drawableR != null) {
            e7.b(drawableR);
        }
        return drawableR;
    }

    public synchronized ColorStateList m(Context context, int i) {
        ColorStateList colorStateListN;
        colorStateListN = n(context, i);
        if (colorStateListN == null) {
            colorStateListN = this.f506a == null ? null : this.f506a.d(context, i);
            if (colorStateListN != null) {
                c(context, i, colorStateListN);
            }
        }
        return colorStateListN;
    }

    public final ColorStateList n(Context context, int i) {
        ja<ColorStateList> jaVar;
        WeakHashMap<Context, ja<ColorStateList>> weakHashMap = this.f510a;
        if (weakHashMap == null || (jaVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return jaVar.e(i);
    }

    public PorterDuff.Mode o(int i) {
        b8 b8Var = this.f506a;
        if (b8Var == null) {
            return null;
        }
        return b8Var.b(i);
    }

    public final Drawable r(Context context, int i) {
        int next;
        ia<String, a8> iaVar = this.f507a;
        if (iaVar == null || iaVar.isEmpty()) {
            return null;
        }
        ja<String> jaVar = this.f508a;
        if (jaVar != null) {
            String strE = jaVar.e(i);
            if ("appcompat_skip_skip".equals(strE) || (strE != null && this.f507a.get(strE) == null)) {
                return null;
            }
        } else {
            this.f508a = new ja<>();
        }
        if (this.f509a == null) {
            this.f509a = new TypedValue();
        }
        TypedValue typedValue = this.f509a;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long jE = e(typedValue);
        Drawable drawableI = i(context, jE);
        if (drawableI != null) {
            return drawableI;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
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
                this.f508a.a(i, name);
                a8 a8Var = this.f507a.get(name);
                if (a8Var != null) {
                    drawableI = a8Var.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableI != null) {
                    drawableI.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, jE, drawableI);
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (drawableI == null) {
            this.f508a.a(i, "appcompat_skip_skip");
        }
        return drawableI;
    }

    public synchronized void s(Context context) {
        fa<WeakReference<Drawable.ConstantState>> faVar = this.b.get(context);
        if (faVar != null) {
            faVar.b();
        }
    }

    public synchronized Drawable t(Context context, y8 y8Var, int i) {
        Drawable drawableR = r(context, i);
        if (drawableR == null) {
            drawableR = y8Var.c(i);
        }
        if (drawableR == null) {
            return null;
        }
        return v(context, i, false, drawableR);
    }

    public synchronized void u(b8 b8Var) {
        this.f506a = b8Var;
    }

    public final Drawable v(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList colorStateListM = m(context, i);
        if (colorStateListM == null) {
            b8 b8Var = this.f506a;
            if ((b8Var == null || !b8Var.a(context, i, drawable)) && !x(context, i, drawable) && z) {
                return null;
            }
            return drawable;
        }
        if (e7.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableR = kd.r(drawable);
        kd.o(drawableR, colorStateListM);
        PorterDuff.Mode modeO = o(i);
        if (modeO == null) {
            return drawableR;
        }
        kd.p(drawableR, modeO);
        return drawableR;
    }

    public boolean x(Context context, int i, Drawable drawable) {
        b8 b8Var = this.f506a;
        return b8Var != null && b8Var.c(context, i, drawable);
    }
}
