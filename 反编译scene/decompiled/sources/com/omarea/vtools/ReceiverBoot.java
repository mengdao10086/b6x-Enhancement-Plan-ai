package com.omarea.vtools;

import a.f92;
import a.w20;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.omarea.vtools.services.BootService;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ReceiverBoot extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f8459a;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f92.d(context, "context");
        f92.d(intent, "intent");
        if (f8459a) {
            return;
        }
        f8459a = true;
        if (new w20(context).b()) {
            return;
        }
        try {
            context.startService(new Intent(context, (Class<?>) BootService.class));
        } catch (Exception unused) {
        }
    }
}
