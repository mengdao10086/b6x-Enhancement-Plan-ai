package a;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ah0 {
    public final boolean a(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "serviceName");
        Object systemService = context.getSystemService("accessibility");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) systemService).getEnabledAccessibilityServiceList(-1)) {
            f92.c(accessibilityServiceInfo, "serviceInfo");
            String id = accessibilityServiceInfo.getId();
            f92.c(id, "serviceInfo.id");
            if (bc2.o(id, str, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(Context context, String str) {
        f92.d(context, "context");
        f92.d(str, "serviceName");
        Object systemService = context.getSystemService("accessibility");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : ((AccessibilityManager) systemService).getEnabledAccessibilityServiceList(-1)) {
            f92.c(accessibilityServiceInfo, "serviceInfo");
            String id = accessibilityServiceInfo.getId();
            f92.c(id, "serviceInfo.id");
            if (bc2.o(id, str, false, 2, null)) {
                ServiceInfo serviceInfo = accessibilityServiceInfo.getResolveInfo().serviceInfo;
                Intent intent = new Intent();
                intent.setComponent(new ComponentName(serviceInfo.packageName, serviceInfo.name));
                context.stopService(intent);
                return true;
            }
        }
        return false;
    }
}
