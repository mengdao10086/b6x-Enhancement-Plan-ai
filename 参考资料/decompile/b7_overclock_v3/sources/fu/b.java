package fu;

import android.content.Context;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28830a = "OpenIdHelper";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f28831b;

    public static String a(Context context) {
        f fVarB = f.b();
        return fVarB.c(context.getApplicationContext(), fVarB.f28839a);
    }

    public static void b(boolean z10) {
        f.b();
        f.f(z10);
    }

    public static final boolean c() {
        Context context = null;
        try {
            if (f28831b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                f28831b = method;
                method.setAccessible(true);
            }
            context = (Context) f28831b.invoke(null, new Object[0]);
        } catch (Exception e10) {
            new StringBuilder("ActivityThread:currentApplication --> ").append(e10.toString());
        }
        if (context == null) {
            return false;
        }
        return f.b().h(context, false);
    }

    public static String d(Context context) {
        f fVarB = f.b();
        return fVarB.c(context.getApplicationContext(), fVarB.f28840b);
    }

    public static String e(Context context) {
        f fVarB = f.b();
        return fVarB.c(context.getApplicationContext(), fVarB.f28842d);
    }

    public static String f(Context context) {
        f fVarB = f.b();
        return fVarB.c(context.getApplicationContext(), fVarB.f28841c);
    }
}
