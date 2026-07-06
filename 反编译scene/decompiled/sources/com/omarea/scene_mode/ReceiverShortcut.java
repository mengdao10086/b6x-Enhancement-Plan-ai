package com.omarea.scene_mode;

import a.hz0;
import a.tw0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ReceiverShortcut extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra;
        if (intent == null || !intent.hasExtra("packageName") || (stringExtra = intent.getStringExtra("packageName")) == null || stringExtra.equals(context.getPackageName())) {
            return;
        }
        if (Scene.f4798a.b(hz0.O, Build.VERSION.SDK_INT >= 28)) {
            tw0.f3070a.e(stringExtra);
        } else {
            tw0.f3070a.a(stringExtra);
        }
    }
}
