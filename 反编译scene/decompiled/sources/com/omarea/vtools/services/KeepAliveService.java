package com.omarea.vtools.services;

import a.c42;
import a.e50;
import a.f92;
import a.nb;
import a.u61;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.omarea.Scene;
import com.omarea.scene_mode.ReceiverSceneMode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class KeepAliveService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        f92.d(intent, "intent");
        throw new c42("An operation is not implemented: Return the communication channel to the service.");
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        nb nbVar;
        Object systemService = Scene.f4798a.c().getSystemService("notification");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            if (notificationManager.getNotificationChannel("keep-alive") == null) {
                notificationManager.createNotificationChannel(new NotificationChannel("keep-alive", getString(u61.keep_alive), 2));
            }
            nbVar = new nb(Scene.f4798a.c(), "keep-alive");
        } else {
            nbVar = new nb(Scene.f4798a.c());
        }
        nbVar.n(2131230926);
        nbVar.p(System.currentTimeMillis());
        nbVar.g("Keep Alive");
        nbVar.f("");
        if (f92.a(e50.f677a.y0(), "root")) {
            nbVar.e(PendingIntent.getBroadcast(Scene.f4798a.c(), 0, new Intent(Scene.f4798a.c(), (Class<?>) ReceiverSceneMode.class), 201326592));
        }
        startForeground(256, nbVar.a());
        return super.onStartCommand(intent, i, i2);
    }
}
