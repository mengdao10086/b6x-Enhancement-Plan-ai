package v2;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f52585a = androidx.work.l.f("ProcessUtils");

    @p0
    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    public static String a(@n0 Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, g.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, new Object[0]);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (Throwable th2) {
            androidx.work.l.c().a(f52585a, "Unable to check ActivityThread for processName", th2);
        }
        int iMyPid = Process.myPid();
        ActivityManager activityManager = (ActivityManager) context.getSystemService(androidx.appcompat.widget.c.f2369r);
        if (activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null && !runningAppProcesses.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == iMyPid) {
                    return runningAppProcessInfo.processName;
                }
            }
        }
        return null;
    }

    public static boolean b(@n0 Context context, @n0 androidx.work.a configuration) {
        String strA = a(context);
        return !TextUtils.isEmpty(configuration.c()) ? TextUtils.equals(strA, configuration.c()) : TextUtils.equals(strA, context.getApplicationInfo().processName);
    }
}
