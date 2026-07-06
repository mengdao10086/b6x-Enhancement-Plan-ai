package a;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class lj0 {
    public final boolean a(Context context, ComponentName componentName) {
        f92.d(context, "context");
        f92.d(componentName, "componentName");
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            return ((ActivityManager) systemService).getRunningServiceControlPanel(componentName) != null;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }
}
