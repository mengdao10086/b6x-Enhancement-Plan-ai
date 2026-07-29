package m0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.v0;
import j0.f;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import v0.h;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@v0(24)
public class y extends c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f40590d = "TypefaceCompatApi24Impl";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f40591e = "android.graphics.FontFamily";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f40592f = "addFontWeightStyle";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f40593g = "createFromFamiliesWithDefault";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Class<?> f40594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Constructor<?> f40595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Method f40596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Method f40597k;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            Class<?> cls2 = Integer.TYPE;
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, cls2, List.class, cls2, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            cls = null;
            method = null;
            method2 = null;
        }
        f40595i = constructor;
        f40594h = cls;
        f40596j = method2;
        f40597k = method;
    }

    public static boolean o(Object obj, ByteBuffer byteBuffer, int i10, int i11, boolean z10) {
        try {
            return ((Boolean) f40596j.invoke(obj, byteBuffer, Integer.valueOf(i10), null, Integer.valueOf(i11), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface p(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(f40594h, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f40597k.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean q() {
        return f40596j != null;
    }

    public static Object r() {
        try {
            return f40595i.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // m0.c0
    @p0
    public Typeface b(Context context, f.d dVar, Resources resources, int i10) {
        Object objR = r();
        if (objR == null) {
            return null;
        }
        for (f.e eVar : dVar.a()) {
            ByteBuffer byteBufferB = d0.b(context, resources, eVar.b());
            if (byteBufferB == null || !o(objR, byteBufferB, eVar.c(), eVar.e(), eVar.f())) {
                return null;
            }
        }
        return p(objR);
    }

    @Override // m0.c0
    @p0
    public Typeface d(Context context, @p0 CancellationSignal cancellationSignal, @n0 h.c[] cVarArr, int i10) {
        Object objR = r();
        if (objR == null) {
            return null;
        }
        androidx.collection.l lVar = new androidx.collection.l();
        for (h.c cVar : cVarArr) {
            Uri uriD = cVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) lVar.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = d0.f(context, cancellationSignal, uriD);
                lVar.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !o(objR, byteBufferF, cVar.c(), cVar.e(), cVar.f())) {
                return null;
            }
        }
        Typeface typefaceP = p(objR);
        if (typefaceP == null) {
            return null;
        }
        return Typeface.create(typefaceP, i10);
    }

    @Override // m0.c0
    @n0
    public Typeface g(@n0 Context context, @n0 Typeface typeface, int i10, boolean z10) {
        Typeface typefaceB;
        try {
            typefaceB = f0.b(typeface, i10, z10);
        } catch (RuntimeException unused) {
            typefaceB = null;
        }
        return typefaceB == null ? super.g(context, typeface, i10, z10) : typefaceB;
    }
}
