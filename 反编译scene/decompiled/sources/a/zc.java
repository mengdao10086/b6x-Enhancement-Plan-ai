package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"NewApi"})
public abstract class zc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ga<String, Typeface> f8056a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final id f3825a;

    static {
        int i = Build.VERSION.SDK_INT;
        f3825a = i >= 29 ? new ed() : i >= 28 ? new dd() : i >= 26 ? new cd() : (i < 24 || !bd.m()) ? Build.VERSION.SDK_INT >= 21 ? new ad() : new id() : new bd();
        f8056a = new ga<>(16);
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        Typeface typefaceG;
        if (context != null) {
            return (Build.VERSION.SDK_INT >= 21 || (typefaceG = g(context, typeface, i)) == null) ? Typeface.create(typeface, i) : typefaceG;
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, je[] jeVarArr, int i) {
        return f3825a.c(context, cancellationSignal, jeVarArr, i);
    }

    public static Typeface c(Context context, dc dcVar, Resources resources, int i, int i2, nc ncVar, Handler handler, boolean z) {
        Typeface typefaceB;
        if (dcVar instanceof gc) {
            gc gcVar = (gc) dcVar;
            Typeface typefaceH = h(gcVar.c());
            if (typefaceH != null) {
                if (ncVar != null) {
                    ncVar.b(typefaceH, handler);
                }
                return typefaceH;
            }
            boolean z2 = !z ? ncVar != null : gcVar.a() != 0;
            int iD = z ? gcVar.d() : -1;
            typefaceB = le.a(context, gcVar.b(), i2, z2, iD, nc.c(handler), new yc(ncVar));
        } else {
            typefaceB = f3825a.b(context, (ec) dcVar, resources, i2);
            if (ncVar != null) {
                if (typefaceB != null) {
                    ncVar.b(typefaceB, handler);
                } else {
                    ncVar.a(-3, handler);
                }
            }
        }
        if (typefaceB != null) {
            f8056a.d(e(resources, i, i2), typefaceB);
        }
        return typefaceB;
    }

    public static Typeface d(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceE = f3825a.e(context, resources, i, str, i2);
        if (typefaceE != null) {
            f8056a.d(e(resources, i, i2), typefaceE);
        }
        return typefaceE;
    }

    public static String e(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface f(Resources resources, int i, int i2) {
        return f8056a.c(e(resources, i, i2));
    }

    public static Typeface g(Context context, Typeface typeface, int i) {
        ec ecVarI = f3825a.i(typeface);
        if (ecVarI == null) {
            return null;
        }
        return f3825a.b(context, ecVarI, context.getResources(), i);
    }

    public static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
