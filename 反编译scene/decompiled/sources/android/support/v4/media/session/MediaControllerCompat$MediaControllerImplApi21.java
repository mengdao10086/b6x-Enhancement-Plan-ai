package android.support.v4.media.session;

import a.fb;
import a.h;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaSessionCompat;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class MediaControllerCompat$MediaControllerImplApi21 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaSessionCompat.Token f8122a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f3941a;

    public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public WeakReference<MediaControllerCompat$MediaControllerImplApi21> f8123a;

        @Override // android.os.ResultReceiver
        public void onReceiveResult(int i, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.f8123a.get();
            if (mediaControllerCompat$MediaControllerImplApi21 == null || bundle == null) {
                return;
            }
            synchronized (mediaControllerCompat$MediaControllerImplApi21.f3941a) {
                mediaControllerCompat$MediaControllerImplApi21.f8122a.q(h.a.f(fb.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                mediaControllerCompat$MediaControllerImplApi21.f8122a.r(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                mediaControllerCompat$MediaControllerImplApi21.a();
            }
        }
    }

    public abstract void a();
}
