package f0;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f27486a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f27487b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f27488c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f27489d = 3;

    @v0(19)
    public static class a {
        @g.u
        public static int a(AppOpsManager appOpsManager, String str, int i10, String str2) {
            return appOpsManager.noteOp(str, i10, str2);
        }

        @g.u
        public static int b(AppOpsManager appOpsManager, String str, int i10, String str2) {
            return appOpsManager.noteOpNoThrow(str, i10, str2);
        }
    }

    @v0(23)
    public static class b {
        @g.u
        public static <T> T a(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        @g.u
        public static int b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        @g.u
        public static int c(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        @g.u
        public static String d(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    @v0(29)
    public static class c {
        @g.u
        public static int a(@p0 AppOpsManager appOpsManager, @n0 String str, int i10, @n0 String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i10, str2);
        }

        @g.u
        @n0
        public static String b(@n0 Context context) {
            return context.getOpPackageName();
        }

        @g.u
        @p0
        public static AppOpsManager c(@n0 Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    public static int a(@n0 Context context, int i10, @n0 String str, @n0 String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return e(context, str, str2);
        }
        AppOpsManager appOpsManagerC = c.c(context);
        int iA = c.a(appOpsManagerC, str, Binder.getCallingUid(), str2);
        return iA != 0 ? iA : c.a(appOpsManagerC, str, i10, c.b(context));
    }

    public static int b(@n0 Context context, @n0 String str, int i10, @n0 String str2) {
        return a.a((AppOpsManager) context.getSystemService("appops"), str, i10, str2);
    }

    public static int c(@n0 Context context, @n0 String str, int i10, @n0 String str2) {
        return a.b((AppOpsManager) context.getSystemService("appops"), str, i10, str2);
    }

    public static int d(@n0 Context context, @n0 String str, @n0 String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.b((AppOpsManager) b.a(context, AppOpsManager.class), str, str2);
        }
        return 1;
    }

    public static int e(@n0 Context context, @n0 String str, @n0 String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.c((AppOpsManager) b.a(context, AppOpsManager.class), str, str2);
        }
        return 1;
    }

    @p0
    public static String f(@n0 String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return b.d(str);
        }
        return null;
    }
}
