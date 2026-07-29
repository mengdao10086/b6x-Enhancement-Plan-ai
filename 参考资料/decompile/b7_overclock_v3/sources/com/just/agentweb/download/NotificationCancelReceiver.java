package com.just.agentweb.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import xf.c0;

/* JADX INFO: loaded from: classes7.dex */
public class NotificationCancelReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f21939a = "com.agentweb.cancelled";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(f21939a)) {
            try {
                b.c().b(intent.getStringExtra("TAG"));
            } catch (Throwable th2) {
                if (c0.d()) {
                    th2.printStackTrace();
                }
            }
        }
    }
}
