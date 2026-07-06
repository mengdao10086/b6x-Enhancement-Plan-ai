package a;

import android.app.Notification;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class lb {
    public static Notification.BubbleMetadata a(mb mbVar) {
        if (mbVar == null) {
            return null;
        }
        Notification.BubbleMetadata.Builder builder = mbVar.g() != null ? new Notification.BubbleMetadata.Builder(mbVar.g()) : new Notification.BubbleMetadata.Builder(mbVar.f(), mbVar.e().k());
        builder.setDeleteIntent(mbVar.b()).setAutoExpandBubble(mbVar.a()).setSuppressNotification(mbVar.h());
        if (mbVar.c() != 0) {
            builder.setDesiredHeight(mbVar.c());
        }
        if (mbVar.d() != 0) {
            builder.setDesiredHeightResId(mbVar.d());
        }
        return builder.build();
    }
}
