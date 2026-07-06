package a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class bd extends id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f5694a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Constructor<?> f259a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Method f260a;
    public static final Method b;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        f259a = constructor;
        f5694a = cls;
        f260a = method2;
        b = method;
    }

    public static boolean k(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f260a.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public static Typeface l(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(f5694a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) b.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public static boolean m() {
        if (f260a == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f260a != null;
    }

    public static Object n() {
        try {
            return f259a.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Override // a.id
    public Typeface b(Context context, ec ecVar, Resources resources, int i) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        for (fc fcVar : ecVar.a()) {
            ByteBuffer byteBufferB = jd.b(context, resources, fcVar.b());
            if (byteBufferB == null || !k(objN, byteBufferB, fcVar.c(), fcVar.e(), fcVar.f())) {
                return null;
            }
        }
        return l(objN);
    }

    @Override // a.id
    public Typeface c(Context context, CancellationSignal cancellationSignal, je[] jeVarArr, int i) {
        Object objN = n();
        if (objN == null) {
            return null;
        }
        ia iaVar = new ia();
        for (je jeVar : jeVarArr) {
            Uri uriD = jeVar.d();
            ByteBuffer byteBufferF = (ByteBuffer) iaVar.get(uriD);
            if (byteBufferF == null) {
                byteBufferF = jd.f(context, cancellationSignal, uriD);
                iaVar.put(uriD, byteBufferF);
            }
            if (byteBufferF == null || !k(objN, byteBufferF, jeVar.c(), jeVar.e(), jeVar.f())) {
                return null;
            }
        }
        Typeface typefaceL = l(objN);
        if (typefaceL == null) {
            return null;
        }
        return Typeface.create(typefaceL, i);
    }
}
