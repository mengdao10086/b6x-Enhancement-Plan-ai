package eu;

import android.content.Context;
import du.b;

/* JADX INFO: loaded from: classes6.dex */
public class a {
    public static void a(Context context) {
        du.a.f26530b = b.C0303b.f26537a.b(context.getApplicationContext());
        du.a.f26529a = true;
    }

    public static boolean b() {
        if (du.a.f26529a) {
            return du.a.f26530b;
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String c(Context context) {
        if (du.a.f26529a) {
            return b.C0303b.f26537a.a(context.getApplicationContext(), "GUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String d(Context context) {
        if (du.a.f26529a) {
            return b.C0303b.f26537a.a(context.getApplicationContext(), "OUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String e(Context context) {
        if (du.a.f26529a) {
            return b.C0303b.f26537a.a(context.getApplicationContext(), "DUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }

    public static String f(Context context) {
        if (du.a.f26529a) {
            return b.C0303b.f26537a.a(context.getApplicationContext(), "AUID");
        }
        throw new RuntimeException("SDK Need Init First!");
    }
}
