package a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class cd extends ad {
    public final Class<?> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Constructor<?> f382b;
    public final Method c;
    public final Method d;
    public final Method e;
    public final Method f;
    public final Method g;

    public cd() throws NoSuchMethodException {
        Method methodX;
        Constructor<?> constructorZ;
        Method methodV;
        Method methodW;
        Method methodA;
        Method methodU;
        Class<?> cls = null;
        try {
            Class<?> clsY = y();
            constructorZ = z(clsY);
            methodV = v(clsY);
            methodW = w(clsY);
            methodA = A(clsY);
            methodU = u(clsY);
            methodX = x(clsY);
            cls = clsY;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            methodX = null;
            constructorZ = null;
            methodV = null;
            methodW = null;
            methodA = null;
            methodU = null;
        }
        this.b = cls;
        this.f382b = constructorZ;
        this.c = methodV;
        this.d = methodW;
        this.e = methodA;
        this.f = methodU;
        this.g = methodX;
    }

    private Object o() {
        try {
            return this.f382b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method A(Class<?> cls) {
        return cls.getMethod("freeze", new Class[0]);
    }

    @Override // a.ad, a.id
    public Typeface b(Context context, ec ecVar, Resources resources, int i) {
        if (!t()) {
            return super.b(context, ecVar, resources, i);
        }
        Object objO = o();
        if (objO == null) {
            return null;
        }
        for (fc fcVar : ecVar.a()) {
            if (!q(context, objO, fcVar.a(), fcVar.c(), fcVar.e(), fcVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fcVar.d()))) {
                p(objO);
                return null;
            }
        }
        if (s(objO)) {
            return l(objO);
        }
        return null;
    }

    @Override // a.ad, a.id
    public Typeface c(Context context, CancellationSignal cancellationSignal, je[] jeVarArr, int i) {
        Typeface typefaceL;
        if (jeVarArr.length < 1) {
            return null;
        }
        if (!t()) {
            je jeVarH = h(jeVarArr, i);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(jeVarH.d(), "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(jeVarH.e()).setItalic(jeVarH.f()).build();
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceBuild;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map<Uri, ByteBuffer> mapH = jd.h(context, jeVarArr, cancellationSignal);
        Object objO = o();
        if (objO == null) {
            return null;
        }
        boolean z = false;
        for (je jeVar : jeVarArr) {
            ByteBuffer byteBuffer = mapH.get(jeVar.d());
            if (byteBuffer != null) {
                if (!r(objO, byteBuffer, jeVar.c(), jeVar.e(), jeVar.f() ? 1 : 0)) {
                    p(objO);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            p(objO);
            return null;
        }
        if (s(objO) && (typefaceL = l(objO)) != null) {
            return Typeface.create(typefaceL, i);
        }
        return null;
    }

    @Override // a.id
    public Typeface e(Context context, Resources resources, int i, String str, int i2) {
        if (!t()) {
            return super.e(context, resources, i, str, i2);
        }
        Object objO = o();
        if (objO == null) {
            return null;
        }
        if (!q(context, objO, str, 0, -1, -1, null)) {
            p(objO);
            return null;
        }
        if (s(objO)) {
            return l(objO);
        }
        return null;
    }

    public Typeface l(Object obj) {
        try {
            Object objNewInstance = Array.newInstance(this.b, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.g.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final void p(Object obj) {
        try {
            this.f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean q(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.c.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean r(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean s(Object obj) {
        try {
            return ((Boolean) this.e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean t() {
        if (this.c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.c != null;
    }

    public Method u(Class<?> cls) {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    public Method v(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    public Method w(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public Method x(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public Class<?> y() {
        return Class.forName("android.graphics.FontFamily");
    }

    public Constructor<?> z(Class<?> cls) {
        return cls.getConstructor(new Class[0]);
    }
}
