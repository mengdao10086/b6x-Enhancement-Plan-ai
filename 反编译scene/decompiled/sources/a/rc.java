package a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.TypedValue;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class rc {
    public static Drawable a(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }

    public static Typeface b(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return e(context, i, new TypedValue(), 0, null, null, false, false);
    }

    public static Typeface c(Context context, int i, TypedValue typedValue, int i2, nc ncVar) {
        if (context.isRestricted()) {
            return null;
        }
        return e(context, i, typedValue, i2, ncVar, null, true, false);
    }

    public static void d(Context context, int i, nc ncVar, Handler handler) {
        pf.b(ncVar);
        if (context.isRestricted()) {
            ncVar.a(-4, handler);
        } else {
            e(context, i, new TypedValue(), 0, ncVar, handler, false, false);
        }
    }

    public static Typeface e(Context context, int i, TypedValue typedValue, int i2, nc ncVar, Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface typefaceF = f(context, resources, typedValue, i, i2, ncVar, handler, z, z2);
        if (typefaceF != null || ncVar != null || z2) {
            return typefaceF;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface f(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, a.nc r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.rc.f(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, a.nc, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
