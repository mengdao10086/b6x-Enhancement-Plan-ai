package androidx.core.app;

import a.hu;
import android.app.PendingIntent;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(hu huVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f4174a = (IconCompat) huVar.v(remoteActionCompat.f4174a, 1);
        remoteActionCompat.f4175a = huVar.l(remoteActionCompat.f4175a, 2);
        remoteActionCompat.b = huVar.l(remoteActionCompat.b, 3);
        remoteActionCompat.f8189a = (PendingIntent) huVar.r(remoteActionCompat.f8189a, 4);
        remoteActionCompat.f4176a = huVar.h(remoteActionCompat.f4176a, 5);
        remoteActionCompat.f4177b = huVar.h(remoteActionCompat.f4177b, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, hu huVar) {
        huVar.x(false, false);
        huVar.M(remoteActionCompat.f4174a, 1);
        huVar.D(remoteActionCompat.f4175a, 2);
        huVar.D(remoteActionCompat.b, 3);
        huVar.H(remoteActionCompat.f8189a, 4);
        huVar.z(remoteActionCompat.f4176a, 5);
        huVar.z(remoteActionCompat.f4177b, 6);
    }
}
