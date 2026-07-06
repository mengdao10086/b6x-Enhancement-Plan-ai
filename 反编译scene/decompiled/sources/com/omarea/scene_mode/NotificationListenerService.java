package com.omarea.scene_mode;

import a.tw0;
import android.service.notification.StatusBarNotification;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class NotificationListenerService extends android.service.notification.NotificationListenerService {
    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        tw0 tw0VarB;
        super.onNotificationPosted(statusBarNotification);
        if (statusBarNotification != null && statusBarNotification.isClearable() && (tw0VarB = tw0.f3070a.b()) != null && tw0VarB.x()) {
            try {
                int i = statusBarNotification.getNotification().flags;
                cancelNotification(statusBarNotification.getKey());
            } catch (Exception unused) {
            }
        }
    }
}
