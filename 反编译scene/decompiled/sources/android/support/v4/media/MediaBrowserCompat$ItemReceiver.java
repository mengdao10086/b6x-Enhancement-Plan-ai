package android.support.v4.media;

import a.c;
import a.o;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class MediaBrowserCompat$ItemReceiver extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f8115a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3924a;

    @Override // a.o
    public void q(int i, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i != 0 || bundle == null || !bundle.containsKey("media_item")) {
            this.f8115a.a(this.f3924a);
            return;
        }
        Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable == null || (parcelable instanceof MediaBrowserCompat$MediaItem)) {
            this.f8115a.b((MediaBrowserCompat$MediaItem) parcelable);
        } else {
            this.f8115a.a(this.f3924a);
        }
    }
}
