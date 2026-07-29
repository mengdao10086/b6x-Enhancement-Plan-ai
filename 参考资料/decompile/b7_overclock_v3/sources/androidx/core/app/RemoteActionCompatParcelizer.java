package androidx.core.app;

import android.app.PendingIntent;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(VersionedParcel versionedParcel) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f4589a = (IconCompat) versionedParcel.h0(remoteActionCompat.f4589a, 1);
        remoteActionCompat.f4590b = versionedParcel.w(remoteActionCompat.f4590b, 2);
        remoteActionCompat.f4591c = versionedParcel.w(remoteActionCompat.f4591c, 3);
        remoteActionCompat.f4592d = (PendingIntent) versionedParcel.W(remoteActionCompat.f4592d, 4);
        remoteActionCompat.f4593e = versionedParcel.m(remoteActionCompat.f4593e, 5);
        remoteActionCompat.f4594f = versionedParcel.m(remoteActionCompat.f4594f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, VersionedParcel versionedParcel) {
        versionedParcel.j0(false, false);
        versionedParcel.m1(remoteActionCompat.f4589a, 1);
        versionedParcel.z0(remoteActionCompat.f4590b, 2);
        versionedParcel.z0(remoteActionCompat.f4591c, 3);
        versionedParcel.X0(remoteActionCompat.f4592d, 4);
        versionedParcel.n0(remoteActionCompat.f4593e, 5);
        versionedParcel.n0(remoteActionCompat.f4594f, 6);
    }
}
