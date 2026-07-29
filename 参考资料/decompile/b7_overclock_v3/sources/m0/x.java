package m0;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import androidx.annotation.RestrictTo;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import g.n0;
import g.v0;
import j0.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import v0.h;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@v0(21)
public class x extends c0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f40581d = "TypefaceCompatApi21Impl";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f40582e = "android.graphics.FontFamily";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f40583f = "addFontWeightStyle";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f40584g = "createFromFamiliesWithDefault";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Class<?> f40585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Constructor<?> f40586i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Method f40587j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Method f40588k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static boolean f40589l;

    public static boolean o(Object obj, String str, int i10, boolean z10) throws NoSuchMethodException {
        r();
        try {
            return ((Boolean) f40587j.invoke(obj, str, Integer.valueOf(i10), Boolean.valueOf(z10))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static Typeface p(Object obj) throws NoSuchMethodException {
        r();
        try {
            Object objNewInstance = Array.newInstance(f40585h, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f40588k.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    public static void r() throws NoSuchMethodException {
        Method method;
        Class<?> cls;
        Method method2;
        if (f40589l) {
            return;
        }
        f40589l = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            method = null;
            cls = null;
            method2 = null;
        }
        f40586i = constructor;
        f40585h = cls;
        f40587j = method2;
        f40588k = method;
    }

    public static Object s() throws NoSuchMethodException {
        r();
        try {
            return f40586i.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e10) {
            throw new RuntimeException(e10);
        }
    }

    @Override // m0.c0
    public Typeface b(Context context, f.d dVar, Resources resources, int i10) throws NoSuchMethodException {
        Object objS = s();
        for (f.e eVar : dVar.a()) {
            File fileE = d0.e(context);
            if (fileE == null) {
                return null;
            }
            try {
                if (!d0.c(fileE, resources, eVar.b())) {
                    return null;
                }
                if (!o(objS, fileE.getPath(), eVar.e(), eVar.f())) {
                    return null;
                }
                fileE.delete();
            } catch (RuntimeException unused) {
                return null;
            } finally {
                fileE.delete();
            }
        }
        return p(objS);
    }

    @Override // m0.c0
    public Typeface d(Context context, CancellationSignal cancellationSignal, @n0 h.c[] cVarArr, int i10) {
        if (cVarArr.length < 1) {
            return null;
        }
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
                File fileQ = q(parcelFileDescriptorOpenFileDescriptor);
                if (fileQ != null && fileQ.canRead()) {
                    Typeface typefaceCreateFromFile = Typeface.createFromFile(fileQ);
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceCreateFromFile;
                }
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                try {
                    Typeface typefaceE = super.e(context, fileInputStream);
                    fileInputStream.close();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceE;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
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

    public final File q(@n0 ParcelFileDescriptor parcelFileDescriptor) {
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
