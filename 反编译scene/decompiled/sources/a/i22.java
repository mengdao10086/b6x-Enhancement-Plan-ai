package a;

import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import de.robv.android.xposed.XC_MethodHook;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class i22 extends XC_MethodHook {
    public i22(j22 j22Var) {
    }

    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        ActivityManager activityManager;
        super.afterHookedMethod(methodHookParam);
        Activity activity = (Activity) methodHookParam.thisObject;
        if (activity == null || (activityManager = (ActivityManager) activity.getSystemService("activity")) == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        for (ActivityManager.AppTask appTask : activityManager.getAppTasks()) {
            if (appTask.getTaskInfo().id == activity.getTaskId()) {
                appTask.setExcludeFromRecents(true);
            }
        }
    }
}
