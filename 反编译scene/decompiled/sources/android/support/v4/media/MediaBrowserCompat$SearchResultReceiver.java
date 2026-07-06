package android.support.v4.media;

import a.d;
import a.o;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class MediaBrowserCompat$SearchResultReceiver extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f8117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Bundle f3926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3927a;

    @Override // a.o
    public void q(int i, Bundle bundle) {
        MediaSessionCompat.a(bundle);
        if (i != 0 || bundle == null || !bundle.containsKey("search_results")) {
            this.f8117a.a(this.f3927a, this.f3926a);
            return;
        }
        Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
        ArrayList arrayList = null;
        if (parcelableArray != null) {
            arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaBrowserCompat$MediaItem) parcelable);
            }
        }
        this.f8117a.b(this.f3927a, this.f3926a, arrayList);
    }
}
