package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"BanConcurrentHashMap"})
    public ConcurrentHashMap<Long, ec> f6400a = new ConcurrentHashMap<>();

    public static <T> T g(T[] tArr, int i, hd<T> hdVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int iAbs = (Math.abs(hdVar.a(t2) - i2) * 2) + (hdVar.b(t2) == z ? 0 : 1);
            if (t == null || i3 > iAbs) {
                t = t2;
                i3 = iAbs;
            }
        }
        return t;
    }

    public static long j(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    public final void a(Typeface typeface, ec ecVar) {
        long j = j(typeface);
        if (j != 0) {
            this.f6400a.put(Long.valueOf(j), ecVar);
        }
    }

    public Typeface b(Context context, ec ecVar, Resources resources, int i) {
        fc fcVarF = f(ecVar, i);
        if (fcVarF == null) {
            return null;
        }
        Typeface typefaceD = zc.d(context, resources, fcVarF.b(), fcVarF.a(), i);
        a(typefaceD, ecVar);
        return typefaceD;
    }

    public Typeface c(Context context, CancellationSignal cancellationSignal, je[] jeVarArr, int i) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (jeVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(h(jeVarArr, i).d());
        } catch (IOException unused) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface typefaceD = d(context, inputStreamOpenInputStream);
            jd.a(inputStreamOpenInputStream);
            return typefaceD;
        } catch (IOException unused2) {
            jd.a(inputStreamOpenInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStreamOpenInputStream;
            jd.a(inputStream);
            throw th;
        }
    }

    public Typeface d(Context context, InputStream inputStream) {
        File fileE = jd.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (jd.d(fileE, inputStream)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public Typeface e(Context context, Resources resources, int i, String str, int i2) {
        File fileE = jd.e(context);
        if (fileE == null) {
            return null;
        }
        try {
            if (jd.c(fileE, resources, i)) {
                return Typeface.createFromFile(fileE.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileE.delete();
        }
    }

    public final fc f(ec ecVar, int i) {
        return (fc) g(ecVar.a(), i, new gd(this));
    }

    public je h(je[] jeVarArr, int i) {
        return (je) g(jeVarArr, i, new fd(this));
    }

    public ec i(Typeface typeface) {
        long j = j(typeface);
        if (j == 0) {
            return null;
        }
        return this.f6400a.get(Long.valueOf(j));
    }
}
