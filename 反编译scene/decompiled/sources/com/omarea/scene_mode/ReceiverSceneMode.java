package com.omarea.scene_mode;

import a.a12;
import a.e50;
import a.f92;
import a.l02;
import a.u61;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ReceiverSceneMode extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f92.d(context, "context");
        f92.d(intent, "intent");
        if (!Settings.canDrawOverlays(context)) {
            Intent intentAddFlags = new Intent().addFlags(268435456);
            f92.c(intentAddFlags, "Intent().addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)");
            intentAddFlags.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intentAddFlags.setData(Uri.fromParts("package", context.getPackageName(), null));
            Toast.makeText(context, context.getString(u61.permission_float), 0).show();
            return;
        }
        if (f92.a(e50.f677a.y0(), "root")) {
            Context applicationContext = context.getApplicationContext();
            f92.c(applicationContext, "context.applicationContext");
            new l02(applicationContext).r();
        } else {
            Context applicationContext2 = context.getApplicationContext();
            f92.c(applicationContext2, "context.applicationContext");
            new a12(applicationContext2).d();
        }
    }
}
