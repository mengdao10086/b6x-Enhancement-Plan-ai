package a;

import android.app.Notification;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class kb {
    public static Notification.BubbleMetadata a(mb mbVar) {
        if (mbVar == null || mbVar.f() == null) {
            return null;
        }
        Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(mbVar.e().k()).setIntent(mbVar.f()).setDeleteIntent(mbVar.b()).setAutoExpandBubble(mbVar.a()).setSuppressNotification(mbVar.h());
        if (mbVar.c() != 0) {
            suppressNotification.setDesiredHeight(mbVar.c());
        }
        if (mbVar.d() != 0) {
            suppressNotification.setDesiredHeightResId(mbVar.d());
        }
        return suppressNotification.build();
    }
}
