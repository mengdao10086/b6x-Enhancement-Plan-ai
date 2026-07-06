package android.support.v4.media;

import a.b;
import a.o;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class MediaBrowserCompat$CustomActionResultReceiver extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f8114a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bundle f3922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3923a;

    @Override // a.o
    public void q(int i, Bundle bundle) {
        if (this.f8114a == null) {
            return;
        }
        MediaSessionCompat.a(bundle);
        if (i == -1) {
            this.f8114a.a(this.f3923a, this.f3922a, bundle);
            return;
        }
        if (i == 0) {
            this.f8114a.c(this.f3923a, this.f3922a, bundle);
            return;
        }
        if (i == 1) {
            this.f8114a.b(this.f3923a, this.f3922a, bundle);
            return;
        }
        Log.w("MediaBrowserCompat", "Unknown result code: " + i + " (extras=" + this.f3922a + ", resultData=" + bundle + ")");
    }
}
