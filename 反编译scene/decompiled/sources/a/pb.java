package a;

import android.app.Notification;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class pb {
    public static Bundle a(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return rb.c(notification);
        }
        return null;
    }
}
