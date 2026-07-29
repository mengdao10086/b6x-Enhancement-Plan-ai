package v2;

import android.content.ComponentName;
import android.content.Context;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f52579a = androidx.work.l.f("PackageManagerHelper");

    public static boolean a(Context context, Class<?> klazz) {
        return b(context, klazz.getName());
    }

    public static boolean b(Context context, String className) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, className)) == 1;
    }

    public static void c(@n0 Context context, @n0 Class<?> klazz, boolean enabled) {
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, klazz.getName()), enabled ? 1 : 2, 1);
            androidx.work.l lVarC = androidx.work.l.c();
            String str = f52579a;
            Object[] objArr = new Object[2];
            objArr[0] = klazz.getName();
            objArr[1] = enabled ? "enabled" : "disabled";
            lVarC.a(str, String.format("%s %s", objArr), new Throwable[0]);
        } catch (Exception e10) {
            androidx.work.l lVarC2 = androidx.work.l.c();
            String str2 = f52579a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = klazz.getName();
            objArr2[1] = enabled ? "enabled" : "disabled";
            lVarC2.a(str2, String.format("%s could not be %s", objArr2), e10);
        }
    }
}
