package f0;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f27587a = "NavUtils";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f27588b = "android.support.PARENT_ACTIVITY";

    @v0(16)
    public static class a {
        @g.u
        public static Intent a(Activity activity) {
            return activity.getParentActivityIntent();
        }

        @g.u
        public static boolean b(Activity activity, Intent intent) {
            return activity.navigateUpTo(intent);
        }

        @g.u
        public static boolean c(Activity activity, Intent intent) {
            return activity.shouldUpRecreateTask(intent);
        }
    }

    @p0
    public static Intent a(@n0 Activity activity) {
        Intent intentA = a.a(activity);
        if (intentA != null) {
            return intentA;
        }
        String strD = d(activity);
        if (strD == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, strD);
        try {
            return e(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getParentActivityIntent: bad parentActivityName '");
            sb2.append(strD);
            sb2.append("' in manifest");
            return null;
        }
    }

    @p0
    public static Intent b(@n0 Context context, @n0 ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strE = e(context, componentName);
        if (strE == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strE);
        return e(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    @p0
    public static Intent c(@n0 Context context, @n0 Class<?> cls) throws PackageManager.NameNotFoundException {
        String strE = e(context, new ComponentName(context, cls));
        if (strE == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(context, strE);
        return e(context, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
    }

    @p0
    public static String d(@n0 Activity activity) {
        try {
            return e(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @p0
    public static String e(@n0 Context context, @n0 ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i10 = Build.VERSION.SDK_INT;
        int i11 = 640;
        if (i10 >= 29) {
            i11 = 269222528;
        } else if (i10 >= 24) {
            i11 = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i11);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString(f27588b)) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static void f(@n0 Activity activity) {
        Intent intentA = a(activity);
        if (intentA != null) {
            g(activity, intentA);
            return;
        }
        throw new IllegalArgumentException("Activity " + activity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }

    public static void g(@n0 Activity activity, @n0 Intent intent) {
        a.b(activity, intent);
    }

    public static boolean h(@n0 Activity activity, @n0 Intent intent) {
        return a.c(activity, intent);
    }
}
