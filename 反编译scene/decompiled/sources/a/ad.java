package a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ad extends id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f5593a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Constructor<?> f58a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Method f59a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f60a = false;
    public static Method b;

    public static boolean k(Object obj, String str, int i, boolean z) throws NoSuchMethodException {
        n();
        try {
            return ((Boolean) f59a.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static Typeface l(Object obj) throws NoSuchMethodException {
        n();
        try {
            Object objNewInstance = Array.newInstance(f5593a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) b.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void n() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f60a) {
            return;
        }
        f60a = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        f58a = constructor;
        f5593a = cls;
        f59a = method2;
        b = method;
    }

    public static Object o() throws NoSuchMethodException {
        n();
        try {
            return f58a.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // a.id
    public Typeface b(Context context, ec ecVar, Resources resources, int i) throws NoSuchMethodException {
        Object objO = o();
        for (fc fcVar : ecVar.a()) {
            File fileE = jd.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!jd.c(fileE, resources, fcVar.b())) {
                    return null;
                }
                if (!k(objO, fileE.getPath(), fcVar.e(), fcVar.f())) {
                    return null;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileE.delete();
            }
        }
        return l(objO);
    }

    @Override // a.id
    public Typeface c(Context context, CancellationSignal cancellationSignal, je[] jeVarArr, int i) {
        if (jeVarArr.length < 1) {
            return null;
        }
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
                File fileM = m(parcelFileDescriptorOpenFileDescriptor);
                if (fileM != null && fileM.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileM);
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceD = super.d(context, fileInputStream);
                    fileInputStream.close();
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return typefaceD;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public final File m(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }
}
