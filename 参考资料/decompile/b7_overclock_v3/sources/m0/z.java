package m0;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import androidx.annotation.RestrictTo;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import g.n0;
import g.p0;
import g.v0;
import j0.f;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import v0.h;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@v0(26)
public class z extends x {
    public static final int A = -1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f40598t = "TypefaceCompatApi26Impl";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f40599u = "android.graphics.FontFamily";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f40600v = "addFontFromAssetManager";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final String f40601w = "addFontFromBuffer";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f40602x = "createFromFamiliesWithDefault";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f40603y = "freeze";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f40604z = "abortCreation";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Class<?> f40605m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Constructor<?> f40606n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Method f40607o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Method f40608p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Method f40609q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Method f40610r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Method f40611s;

    public z() throws NoSuchMethodException {
        Method methodB;
        Constructor<?> constructorD;
        Method methodZ;
        Method methodA;
        Method methodE;
        Method methodY;
        Class<?> cls = null;
        try {
            Class<?> clsC = C();
            constructorD = D(clsC);
            methodZ = z(clsC);
            methodA = A(clsC);
            methodE = E(clsC);
            methodY = y(clsC);
            methodB = B(clsC);
            cls = clsC;
        } catch (ClassNotFoundException | NoSuchMethodException e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to collect necessary methods for class ");
            sb2.append(e10.getClass().getName());
            methodB = null;
            constructorD = null;
            methodZ = null;
            methodA = null;
            methodE = null;
            methodY = null;
        }
        this.f40605m = cls;
        this.f40606n = constructorD;
        this.f40607o = methodZ;
        this.f40608p = methodA;
        this.f40609q = methodE;
        this.f40610r = methodY;
        this.f40611s = methodB;
    }

    @p0
    private Object s() {
        try {
            return this.f40606n.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method A(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod(f40601w, ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method B(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class<?> C() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor<?> D(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    public Method E(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod(f40603y, new Class[0]);
    }

    @Override // m0.x, m0.c0
    @p0
    public Typeface b(Context context, f.d dVar, Resources resources, int i10) {
        if (!x()) {
            return super.b(context, dVar, resources, i10);
        }
        Object objS = s();
        if (objS == null) {
            return null;
        }
        for (f.e eVar : dVar.a()) {
            if (!u(context, objS, eVar.a(), eVar.c(), eVar.e(), eVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(eVar.d()))) {
                t(objS);
                return null;
            }
        }
        if (w(objS)) {
            return p(objS);
        }
        return null;
    }

    @Override // m0.x, m0.c0
    @p0
    public Typeface d(Context context, @p0 CancellationSignal cancellationSignal, @n0 h.c[] cVarArr, int i10) {
        Typeface typefaceP;
        if (cVarArr.length < 1) {
            return null;
        }
        if (!x()) {
            h.c cVarL = l(cVarArr, i10);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(cVarL.d(), SsManifestParser.e.J, cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(cVarL.e()).setItalic(cVarL.f()).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> mapH = d0.h(context, cVarArr, cancellationSignal);
        Object objS = s();
        if (objS == null) {
            return null;
        }
        boolean z10 = false;
        for (h.c cVar : cVarArr) {
            ByteBuffer byteBuffer = mapH.get(cVar.d());
            if (byteBuffer != null) {
                if (!v(objS, byteBuffer, cVar.c(), cVar.e(), cVar.f() ? 1 : 0)) {
                    t(objS);
                    return null;
                }
                z10 = true;
            }
        }
        if (!z10) {
            t(objS);
            return null;
        }
        if (w(objS) && (typefaceP = p(objS)) != null) {
            return Typeface.create(typefaceP, i10);
        }
        return null;
    }

    @Override // m0.c0
    @p0
    public Typeface f(Context context, Resources resources, int i10, String str, int i11) {
        if (!x()) {
            return super.f(context, resources, i10, str, i11);
        }
        Object objS = s();
        if (objS == null) {
            return null;
        }
        if (!u(context, objS, str, 0, -1, -1, null)) {
            t(objS);
            return null;
        }
        if (w(objS)) {
            return p(objS);
        }
        return null;
    }

    @Override // m0.x, m0.c0
    @n0
    public Typeface g(@n0 Context context, @n0 Typeface typeface, int i10, boolean z10) {
        Typeface typefaceB;
        try {
            typefaceB = g0.b(typeface, i10, z10);
        } catch (RuntimeException unused) {
            typefaceB = null;
        }
        return typefaceB == null ? super.g(context, typeface, i10, z10) : typefaceB;
    }

    @p0
    public Typeface p(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.f40605m, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f40611s.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void t(Object obj) {
        try {
            this.f40610r.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean u(Context context, Object obj, String str, int i10, int i11, int i12, @p0 FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f40607o.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean v(Object obj, ByteBuffer byteBuffer, int i10, int i11, int i12) {
        try {
            return ((Boolean) this.f40608p.invoke(obj, byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Integer.valueOf(i12))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean w(Object obj) {
        try {
            return ((Boolean) this.f40609q.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean x() {
        return this.f40607o != null;
    }

    public Method y(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod(f40604z, new Class[0]);
    }

    public Method z(Class<?> cls) throws NoSuchMethodException {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod(f40600v, AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }
}
