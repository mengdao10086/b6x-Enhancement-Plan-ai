package j0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.RestrictTo;
import g.b0;
import g.n0;
import g.p0;
import g.q;
import g.u;
import g.v;
import g.v0;
import g.y;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f35989a = "ResourcesCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f35990b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b0("sColorStateCacheLock")
    public static final WeakHashMap<f, SparseArray<e>> f35991c = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f35992d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.c
    public static final int f35993e = 0;

    @v0(15)
    public static class a {
        @u
        public static Drawable a(Resources resources, int i10, int i11) {
            return resources.getDrawableForDensity(i10, i11);
        }
    }

    @v0(21)
    public static class b {
        @u
        public static Drawable a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getDrawable(i10, theme);
        }

        @u
        public static Drawable b(Resources resources, int i10, int i11, Resources.Theme theme) {
            return resources.getDrawableForDensity(i10, i11, theme);
        }
    }

    @v0(23)
    public static class c {
        @u
        public static int a(Resources resources, int i10, Resources.Theme theme) {
            return resources.getColor(i10, theme);
        }

        @u
        @n0
        public static ColorStateList b(@n0 Resources resources, @g.n int i10, @p0 Resources.Theme theme) {
            return resources.getColorStateList(i10, theme);
        }
    }

    @v0(29)
    public static class d {
        @u
        public static float a(@n0 Resources resources, @q int i10) {
            return resources.getFloat(i10);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ColorStateList f35994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Configuration f35995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35996c;

        public e(@n0 ColorStateList colorStateList, @n0 Configuration configuration, @p0 Resources.Theme theme) {
            this.f35994a = colorStateList;
            this.f35995b = configuration;
            this.f35996c = theme == null ? 0 : theme.hashCode();
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Resources f35997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Resources.Theme f35998b;

        public f(@n0 Resources resources, @p0 Resources.Theme theme) {
            this.f35997a = resources;
            this.f35998b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.f35997a.equals(fVar.f35997a) && androidx.core.util.j.a(this.f35998b, fVar.f35998b);
        }

        public int hashCode() {
            return androidx.core.util.j.b(this.f35997a, this.f35998b);
        }
    }

    public static abstract class g {
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @n0
        public static Handler e(@p0 Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void c(final int i10, @p0 Handler handler) {
            e(handler).post(new Runnable() { // from class: j0.j
                @Override // java.lang.Runnable
                public final void run() {
                    this.f36002a.f(i10);
                }
            });
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void d(@n0 final Typeface typeface, @p0 Handler handler) {
            e(handler).post(new Runnable() { // from class: j0.k
                @Override // java.lang.Runnable
                public final void run() {
                    this.f36004a.g(typeface);
                }
            });
        }

        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public abstract void f(int i10);

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public abstract void g(@n0 Typeface typeface);
    }

    public static final class h {

        @v0(23)
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Object f35999a = new Object();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static Method f36000b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static boolean f36001c;

            @SuppressLint({"BanUncheckedReflection"})
            public static void a(@n0 Resources.Theme theme) {
                synchronized (f35999a) {
                    if (!f36001c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f36000b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException unused) {
                        }
                        f36001c = true;
                    }
                    Method method = f36000b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException unused2) {
                            f36000b = null;
                        }
                    }
                }
            }
        }

        @v0(29)
        public static class b {
            @u
            public static void a(@n0 Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(@n0 Resources.Theme theme) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 29) {
                b.a(theme);
            } else if (i10 >= 23) {
                a.a(theme);
            }
        }
    }

    public static void a(@n0 f fVar, @g.n int i10, @n0 ColorStateList colorStateList, @p0 Resources.Theme theme) {
        synchronized (f35992d) {
            WeakHashMap<f, SparseArray<e>> weakHashMap = f35991c;
            SparseArray<e> sparseArray = weakHashMap.get(fVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(fVar, sparseArray);
            }
            sparseArray.append(i10, new e(colorStateList, fVar.f35997a.getConfiguration(), theme));
        }
    }

    public static void b(@n0 Resources.Theme theme) {
        synchronized (f35992d) {
            Iterator<f> it2 = f35991c.keySet().iterator();
            while (it2.hasNext()) {
                f next = it2.next();
                if (next != null && theme.equals(next.f35998b)) {
                    it2.remove();
                }
            }
        }
    }

    @p0
    public static ColorStateList c(@n0 f fVar, @g.n int i10) {
        e eVar;
        Resources.Theme theme;
        synchronized (f35992d) {
            SparseArray<e> sparseArray = f35991c.get(fVar);
            if (sparseArray != null && sparseArray.size() > 0 && (eVar = sparseArray.get(i10)) != null) {
                if (eVar.f35995b.equals(fVar.f35997a.getConfiguration()) && (((theme = fVar.f35998b) == null && eVar.f35996c == 0) || (theme != null && eVar.f35996c == theme.hashCode()))) {
                    return eVar.f35994a;
                }
                sparseArray.remove(i10);
            }
            return null;
        }
    }

    @p0
    public static Typeface d(@n0 Context context, @y int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return p(context, i10, new TypedValue(), 0, null, null, false, true);
    }

    @g.l
    public static int e(@n0 Resources resources, @g.n int i10, @p0 Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 23 ? c.a(resources, i10, theme) : resources.getColor(i10);
    }

    @p0
    public static ColorStateList f(@n0 Resources resources, @g.n int i10, @p0 Resources.Theme theme) throws Resources.NotFoundException {
        f fVar = new f(resources, theme);
        ColorStateList colorStateListC = c(fVar, i10);
        if (colorStateListC != null) {
            return colorStateListC;
        }
        ColorStateList colorStateListN = n(resources, i10, theme);
        if (colorStateListN == null) {
            return Build.VERSION.SDK_INT >= 23 ? c.b(resources, i10, theme) : resources.getColorStateList(i10);
        }
        a(fVar, i10, colorStateListN, theme);
        return colorStateListN;
    }

    @p0
    public static Drawable g(@n0 Resources resources, @v int i10, @p0 Resources.Theme theme) throws Resources.NotFoundException {
        return b.a(resources, i10, theme);
    }

    @p0
    public static Drawable h(@n0 Resources resources, @v int i10, int i11, @p0 Resources.Theme theme) throws Resources.NotFoundException {
        return b.b(resources, i10, i11, theme);
    }

    public static float i(@n0 Resources resources, @q int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            return d.a(resources, i10);
        }
        TypedValue typedValueM = m();
        resources.getValue(i10, typedValueM, true);
        if (typedValueM.type == 4) {
            return typedValueM.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i10) + " type #0x" + Integer.toHexString(typedValueM.type) + " is not valid");
    }

    @p0
    public static Typeface j(@n0 Context context, @y int i10) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return p(context, i10, new TypedValue(), 0, null, null, false, false);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface k(@n0 Context context, @y int i10, @n0 TypedValue typedValue, int i11, @p0 g gVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return p(context, i10, typedValue, i11, gVar, null, true, false);
    }

    public static void l(@n0 Context context, @y int i10, @n0 g gVar, @p0 Handler handler) throws Resources.NotFoundException {
        androidx.core.util.o.l(gVar);
        if (context.isRestricted()) {
            gVar.c(-4, handler);
        } else {
            p(context, i10, new TypedValue(), 0, gVar, handler, false, false);
        }
    }

    @n0
    public static TypedValue m() {
        ThreadLocal<TypedValue> threadLocal = f35990b;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @p0
    public static ColorStateList n(Resources resources, int i10, @p0 Resources.Theme theme) {
        if (o(resources, i10)) {
            return null;
        }
        try {
            return j0.c.a(resources, resources.getXml(i10), theme);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean o(@n0 Resources resources, @g.n int i10) {
        TypedValue typedValueM = m();
        resources.getValue(i10, typedValueM, true);
        int i11 = typedValueM.type;
        return i11 >= 28 && i11 <= 31;
    }

    public static Typeface p(@n0 Context context, int i10, @n0 TypedValue typedValue, int i11, @p0 g gVar, @p0 Handler handler, boolean z10, boolean z11) {
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        Typeface typefaceQ = q(context, resources, typedValue, i10, i11, gVar, handler, z10, z11);
        if (typefaceQ != null || gVar != null || z11) {
            return typefaceQ;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i10) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface q(@g.n0 android.content.Context r15, android.content.res.Resources r16, @g.n0 android.util.TypedValue r17, int r18, int r19, @g.p0 j0.i.g r20, @g.p0 android.os.Handler r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.i.q(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, j0.i$g, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
