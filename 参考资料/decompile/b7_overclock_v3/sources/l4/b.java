package l4;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import g.p0;
import g.v;
import j0.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f39445a = true;

    public static Drawable a(Context context, @v int i10, @p0 Resources.Theme theme) {
        return c(context, context, i10, theme);
    }

    public static Drawable b(Context context, Context context2, @v int i10) {
        return c(context, context2, i10, null);
    }

    public static Drawable c(Context context, Context context2, @v int i10, @p0 Resources.Theme theme) {
        try {
            if (f39445a) {
                return e(context2, i10, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e10) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e10;
            }
            return h0.d.i(context2, i10);
        } catch (NoClassDefFoundError unused2) {
            f39445a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i10, theme);
    }

    public static Drawable d(Context context, @v int i10, @p0 Resources.Theme theme) {
        return i.g(context.getResources(), i10, theme);
    }

    public static Drawable e(Context context, @v int i10, @p0 Resources.Theme theme) {
        if (theme != null) {
            context = new l.d(context, theme);
        }
        return i.a.b(context, i10);
    }
}
