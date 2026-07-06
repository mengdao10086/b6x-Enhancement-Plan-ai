package a;

import android.content.Context;
import android.content.Intent;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yk0 {
    public final boolean a(Context context) {
        f92.d(context, "context");
        Set<String> setA = sb.a(context);
        f92.c(setA, "NotificationManagerCompa…ListenerPackages(context)");
        return setA.contains(context.getPackageName());
    }

    public final void b(Context context) {
        f92.d(context, "context");
        try {
            context.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
        } catch (Exception unused) {
        }
    }
}
