package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import androidx.media.AudioAttributesCompat;
import androidx.media.R;
import f0.k;
import g.b0;
import g.n0;
import g.p0;
import g.v0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaControllerCompat {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f1002d = "MediaControllerCompat";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1003e = "android.support.v4.media.session.command.GET_EXTRA_BINDER";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1004f = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1005g = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1006h = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1007i = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1008j = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1009k = "android.support.v4.media.session.command.ARGUMENT_INDEX";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaSessionCompat.Token f1011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<a, Boolean> f1012c = new ConcurrentHashMap<>();

    @v0(21)
    public static class MediaControllerImplApi21 implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaController f1013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1014b = new Object();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @b0("mLock")
        public final List<a> f1015c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public HashMap<a, a> f1016d = new HashMap<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Bundle f1017e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final MediaSessionCompat.Token f1018f;

        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public WeakReference<MediaControllerImplApi21> f1019a;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.f1019a = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i10, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f1019a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                synchronized (mediaControllerImplApi21.f1014b) {
                    mediaControllerImplApi21.f1018f.z(b.AbstractBinderC0023b.Q0(k.a(bundle, MediaSessionCompat.K)));
                    mediaControllerImplApi21.f1018f.C(i2.c.c(bundle, MediaSessionCompat.L));
                    mediaControllerImplApi21.z();
                }
            }
        }

        public static class a extends a.c {
            public a(a aVar) {
                super(aVar);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void N(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void O0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void Q(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void i0(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void m0() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void o0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f1018f = token;
            this.f1013a = new MediaController(context, (MediaSession.Token) token.s());
            if (token.g() == null) {
                A();
            }
        }

        public final void A() {
            i(MediaControllerCompat.f1003e, null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public d a() {
            MediaController.PlaybackInfo playbackInfo = this.f1013a.getPlaybackInfo();
            if (playbackInfo != null) {
                return new d(playbackInfo.getPlaybackType(), AudioAttributesCompat.l(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void b(int i10, int i11) {
            this.f1013a.adjustVolume(i10, i11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public final void c(a aVar) {
            this.f1013a.unregisterCallback(aVar.f1020a);
            synchronized (this.f1014b) {
                if (this.f1018f.g() != null) {
                    try {
                        a aVarRemove = this.f1016d.remove(aVar);
                        if (aVarRemove != null) {
                            aVar.f1022c = null;
                            this.f1018f.g().U(aVarRemove);
                        }
                    } catch (RemoteException unused) {
                    }
                } else {
                    this.f1015c.remove(aVar);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public PlaybackStateCompat d() {
            if (this.f1018f.g() != null) {
                try {
                    return this.f1018f.g().d();
                } catch (RemoteException unused) {
                }
            }
            PlaybackState playbackState = this.f1013a.getPlaybackState();
            if (playbackState != null) {
                return PlaybackStateCompat.a(playbackState);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public long e() {
            return this.f1013a.getFlags();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean f(KeyEvent keyEvent) {
            return this.f1013a.dispatchMediaButtonEvent(keyEvent);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void g(int i10, int i11) {
            this.f1013a.setVolumeTo(i10, i11);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public Bundle getExtras() {
            return this.f1013a.getExtras();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void h(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
            if ((e() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.f1008j, mediaDescriptionCompat);
            bundle.putInt(MediaControllerCompat.f1009k, i10);
            i(MediaControllerCompat.f1005g, bundle, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void i(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.f1013a.sendCommand(str, bundle, resultReceiver);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean j() {
            return this.f1018f.g() != null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public int k() {
            if (this.f1018f.g() == null) {
                return -1;
            }
            try {
                return this.f1018f.g().k();
            } catch (RemoteException unused) {
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public PendingIntent l() {
            return this.f1013a.getSessionActivity();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public String m() {
            return this.f1013a.getPackageName();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public e n() {
            return new f(this.f1013a.getTransportControls());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void o(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((e() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.f1008j, mediaDescriptionCompat);
            i(MediaControllerCompat.f1006h, bundle, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void p(MediaDescriptionCompat mediaDescriptionCompat) {
            if ((e() & 4) == 0) {
                throw new UnsupportedOperationException("This session doesn't support queue management operations");
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaControllerCompat.f1008j, mediaDescriptionCompat);
            i(MediaControllerCompat.f1004f, bundle, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public int q() {
            if (Build.VERSION.SDK_INT < 22 && this.f1018f.g() != null) {
                try {
                    return this.f1018f.g().q();
                } catch (RemoteException unused) {
                }
            }
            return this.f1013a.getRatingType();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public CharSequence r() {
            return this.f1013a.getQueueTitle();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public MediaMetadataCompat s() {
            MediaMetadata metadata = this.f1013a.getMetadata();
            if (metadata != null) {
                return MediaMetadataCompat.b(metadata);
            }
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public Bundle t() {
            if (this.f1017e != null) {
                return new Bundle(this.f1017e);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.f1017e = this.f1013a.getSessionInfo();
            } else if (this.f1018f.g() != null) {
                try {
                    this.f1017e = this.f1018f.g().t();
                } catch (RemoteException unused) {
                    this.f1017e = Bundle.EMPTY;
                }
            }
            Bundle bundleG = MediaSessionCompat.G(this.f1017e);
            this.f1017e = bundleG;
            return bundleG == null ? Bundle.EMPTY : new Bundle(this.f1017e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public Object u() {
            return this.f1013a;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public final void v(a aVar, Handler handler) {
            this.f1013a.registerCallback(aVar.f1020a, handler);
            synchronized (this.f1014b) {
                if (this.f1018f.g() != null) {
                    a aVar2 = new a(aVar);
                    this.f1016d.put(aVar, aVar2);
                    aVar.f1022c = aVar2;
                    try {
                        this.f1018f.g().C(aVar2);
                        aVar.n(13, null, null);
                    } catch (RemoteException unused) {
                    }
                } else {
                    aVar.f1022c = null;
                    this.f1015c.add(aVar);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public int w() {
            if (this.f1018f.g() == null) {
                return -1;
            }
            try {
                return this.f1018f.g().w();
            } catch (RemoteException unused) {
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean x() {
            if (this.f1018f.g() == null) {
                return false;
            }
            try {
                return this.f1018f.g().x();
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public List<MediaSessionCompat.QueueItem> y() {
            List<MediaSession.QueueItem> queue = this.f1013a.getQueue();
            if (queue != null) {
                return MediaSessionCompat.QueueItem.b(queue);
            }
            return null;
        }

        @b0("mLock")
        public void z() {
            if (this.f1018f.g() == null) {
                return;
            }
            for (a aVar : this.f1015c) {
                a aVar2 = new a(aVar);
                this.f1016d.put(aVar, aVar2);
                aVar.f1022c = aVar2;
                try {
                    this.f1018f.g().C(aVar2);
                    aVar.n(13, null, null);
                } catch (RemoteException unused) {
                }
            }
            this.f1015c.clear();
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaController.Callback f1020a = new C0019a(this);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f1021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public android.support.v4.media.session.a f1022c;

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaControllerCompat$a$a, reason: collision with other inner class name */
        @v0(21)
        public static class C0019a extends MediaController.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final WeakReference<a> f1023a;

            public C0019a(a aVar) {
                this.f1023a = new WeakReference<>(aVar);
            }

            @Override // android.media.session.MediaController.Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                a aVar = this.f1023a.get();
                if (aVar != null) {
                    aVar.b(new d(playbackInfo.getPlaybackType(), AudioAttributesCompat.l(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onExtrasChanged(Bundle bundle) {
                MediaSessionCompat.c(bundle);
                a aVar = this.f1023a.get();
                if (aVar != null) {
                    aVar.d(bundle);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata mediaMetadata) {
                a aVar = this.f1023a.get();
                if (aVar != null) {
                    aVar.e(MediaMetadataCompat.b(mediaMetadata));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState playbackState) {
                a aVar = this.f1023a.get();
                if (aVar == null || aVar.f1022c != null) {
                    return;
                }
                aVar.f(PlaybackStateCompat.a(playbackState));
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueChanged(List<MediaSession.QueueItem> list) {
                a aVar = this.f1023a.get();
                if (aVar != null) {
                    aVar.g(MediaSessionCompat.QueueItem.b(list));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                a aVar = this.f1023a.get();
                if (aVar != null) {
                    aVar.h(charSequence);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionDestroyed() {
                a aVar = this.f1023a.get();
                if (aVar != null) {
                    aVar.j();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                MediaSessionCompat.c(bundle);
                a aVar = this.f1023a.get();
                if (aVar != null) {
                    if (aVar.f1022c == null || Build.VERSION.SDK_INT >= 23) {
                        aVar.k(str, bundle);
                    }
                }
            }
        }

        public class b extends Handler {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f1024c = 1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f1025d = 2;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final int f1026e = 3;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f1027f = 4;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final int f1028g = 5;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final int f1029h = 6;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final int f1030i = 7;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final int f1031j = 8;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public static final int f1032k = 9;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public static final int f1033l = 11;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final int f1034m = 12;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final int f1035n = 13;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f1036a;

            public b(Looper looper) {
                super(looper);
                this.f1036a = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (this.f1036a) {
                    switch (message.what) {
                        case 1:
                            Bundle data = message.getData();
                            MediaSessionCompat.c(data);
                            a.this.k((String) message.obj, data);
                            break;
                        case 2:
                            a.this.f((PlaybackStateCompat) message.obj);
                            break;
                        case 3:
                            a.this.e((MediaMetadataCompat) message.obj);
                            break;
                        case 4:
                            a.this.b((d) message.obj);
                            break;
                        case 5:
                            a.this.g((List) message.obj);
                            break;
                        case 6:
                            a.this.h((CharSequence) message.obj);
                            break;
                        case 7:
                            Bundle bundle = (Bundle) message.obj;
                            MediaSessionCompat.c(bundle);
                            a.this.d(bundle);
                            break;
                        case 8:
                            a.this.j();
                            break;
                        case 9:
                            a.this.i(((Integer) message.obj).intValue());
                            break;
                        case 11:
                            a.this.c(((Boolean) message.obj).booleanValue());
                            break;
                        case 12:
                            a.this.m(((Integer) message.obj).intValue());
                            break;
                        case 13:
                            a.this.l();
                            break;
                    }
                }
            }
        }

        public static class c extends a.b {

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public final WeakReference<a> f1038t;

            public c(a aVar) {
                this.f1038t = new WeakReference<>(aVar);
            }

            @Override // android.support.v4.media.session.a
            public void L0(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void M() throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(13, null, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void M0(String str, Bundle bundle) throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(1, str, bundle);
                }
            }

            public void N(Bundle bundle) throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(7, bundle, null);
                }
            }

            public void O0(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(4, parcelableVolumeInfo != null ? new d(parcelableVolumeInfo.f1171a, parcelableVolumeInfo.f1172b, parcelableVolumeInfo.f1173c, parcelableVolumeInfo.f1174d, parcelableVolumeInfo.f1175e) : null, null);
                }
            }

            public void Q(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(5, list, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void c0(boolean z10) throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(11, Boolean.valueOf(z10), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void h0(boolean z10) throws RemoteException {
            }

            public void i0(CharSequence charSequence) throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(6, charSequence, null);
                }
            }

            public void m0() throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(8, null, null);
                }
            }

            public void o0(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(3, mediaMetadataCompat, null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void u0(int i10) throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(12, Integer.valueOf(i10), null);
                }
            }

            @Override // android.support.v4.media.session.a
            public void v(int i10) throws RemoteException {
                a aVar = this.f1038t.get();
                if (aVar != null) {
                    aVar.n(9, Integer.valueOf(i10), null);
                }
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public android.support.v4.media.session.a a() {
            return this.f1022c;
        }

        public void b(d dVar) {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            n(8, null, null);
        }

        public void c(boolean z10) {
        }

        public void d(Bundle bundle) {
        }

        public void e(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void f(PlaybackStateCompat playbackStateCompat) {
        }

        public void g(List<MediaSessionCompat.QueueItem> list) {
        }

        public void h(CharSequence charSequence) {
        }

        public void i(int i10) {
        }

        public void j() {
        }

        public void k(String str, Bundle bundle) {
        }

        public void l() {
        }

        public void m(int i10) {
        }

        public void n(int i10, Object obj, Bundle bundle) {
            b bVar = this.f1021b;
            if (bVar != null) {
                Message messageObtainMessage = bVar.obtainMessage(i10, obj);
                messageObtainMessage.setData(bundle);
                messageObtainMessage.sendToTarget();
            }
        }

        public void o(Handler handler) {
            if (handler != null) {
                b bVar = new b(handler.getLooper());
                this.f1021b = bVar;
                bVar.f1036a = true;
            } else {
                b bVar2 = this.f1021b;
                if (bVar2 != null) {
                    bVar2.f1036a = false;
                    bVar2.removeCallbacksAndMessages(null);
                    this.f1021b = null;
                }
            }
        }
    }

    public interface b {
        d a();

        void b(int i10, int i11);

        void c(a aVar);

        PlaybackStateCompat d();

        long e();

        boolean f(KeyEvent keyEvent);

        void g(int i10, int i11);

        Bundle getExtras();

        void h(MediaDescriptionCompat mediaDescriptionCompat, int i10);

        void i(String str, Bundle bundle, ResultReceiver resultReceiver);

        boolean j();

        int k();

        PendingIntent l();

        String m();

        e n();

        void o(MediaDescriptionCompat mediaDescriptionCompat);

        void p(MediaDescriptionCompat mediaDescriptionCompat);

        int q();

        CharSequence r();

        MediaMetadataCompat s();

        Bundle t();

        Object u();

        void v(a aVar, Handler handler);

        int w();

        boolean x();

        List<MediaSessionCompat.QueueItem> y();
    }

    public static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public android.support.v4.media.session.b f1039a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f1040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Bundle f1041c;

        public c(MediaSessionCompat.Token token) {
            this.f1039a = b.AbstractBinderC0023b.Q0((IBinder) token.s());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public d a() {
            try {
                ParcelableVolumeInfo parcelableVolumeInfoD0 = this.f1039a.D0();
                return new d(parcelableVolumeInfoD0.f1171a, parcelableVolumeInfoD0.f1172b, parcelableVolumeInfoD0.f1173c, parcelableVolumeInfoD0.f1174d, parcelableVolumeInfoD0.f1175e);
            } catch (RemoteException unused) {
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void b(int i10, int i11) {
            try {
                this.f1039a.j0(i10, i11, null);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void c(a aVar) {
            if (aVar == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.f1039a.U(aVar.f1022c);
                this.f1039a.asBinder().unlinkToDeath(aVar, 0);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public PlaybackStateCompat d() {
            try {
                return this.f1039a.d();
            } catch (RemoteException unused) {
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public long e() {
            try {
                return this.f1039a.e();
            } catch (RemoteException unused) {
                return 0L;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean f(KeyEvent keyEvent) {
            if (keyEvent == null) {
                throw new IllegalArgumentException("event may not be null.");
            }
            try {
                this.f1039a.g0(keyEvent);
                return false;
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void g(int i10, int i11) {
            try {
                this.f1039a.F(i10, i11, null);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public Bundle getExtras() {
            try {
                return this.f1039a.getExtras();
            } catch (RemoteException unused) {
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void h(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
            try {
                if ((this.f1039a.e() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.f1039a.n0(mediaDescriptionCompat, i10);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void i(String str, Bundle bundle, ResultReceiver resultReceiver) {
            try {
                this.f1039a.w0(str, bundle, resultReceiver == null ? null : new MediaSessionCompat.ResultReceiverWrapper(resultReceiver));
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean j() {
            return true;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public int k() {
            try {
                return this.f1039a.k();
            } catch (RemoteException unused) {
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public PendingIntent l() {
            try {
                return this.f1039a.I();
            } catch (RemoteException unused) {
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public String m() {
            try {
                return this.f1039a.m();
            } catch (RemoteException unused) {
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public e n() {
            if (this.f1040b == null) {
                this.f1040b = new g(this.f1039a);
            }
            return this.f1040b;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void o(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.f1039a.e() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.f1039a.o(mediaDescriptionCompat);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void p(MediaDescriptionCompat mediaDescriptionCompat) {
            try {
                if ((this.f1039a.e() & 4) == 0) {
                    throw new UnsupportedOperationException("This session doesn't support queue management operations");
                }
                this.f1039a.p(mediaDescriptionCompat);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public int q() {
            try {
                return this.f1039a.q();
            } catch (RemoteException unused) {
                return 0;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public CharSequence r() {
            try {
                return this.f1039a.r();
            } catch (RemoteException unused) {
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public MediaMetadataCompat s() {
            try {
                return this.f1039a.s();
            } catch (RemoteException unused) {
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public Bundle t() {
            try {
                this.f1041c = this.f1039a.t();
            } catch (RemoteException unused) {
            }
            Bundle bundleG = MediaSessionCompat.G(this.f1041c);
            this.f1041c = bundleG;
            return bundleG == null ? Bundle.EMPTY : new Bundle(this.f1041c);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public Object u() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public void v(a aVar, Handler handler) {
            if (aVar == null) {
                throw new IllegalArgumentException("callback may not be null.");
            }
            try {
                this.f1039a.asBinder().linkToDeath(aVar, 0);
                this.f1039a.C(aVar.f1022c);
                aVar.n(13, null, null);
            } catch (RemoteException unused) {
                aVar.n(8, null, null);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public int w() {
            try {
                return this.f1039a.w();
            } catch (RemoteException unused) {
                return -1;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean x() {
            try {
                return this.f1039a.x();
            } catch (RemoteException unused) {
                return false;
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public List<MediaSessionCompat.QueueItem> y() {
            try {
                return this.f1039a.y();
            } catch (RemoteException unused) {
                return null;
            }
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f1042f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f1043g = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AudioAttributesCompat f1045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1046c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f1047d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1048e;

        public d(int i10, int i11, int i12, int i13, int i14) {
            this(i10, new AudioAttributesCompat.d().d(i11).a(), i12, i13, i14);
        }

        @n0
        public AudioAttributesCompat a() {
            return this.f1045b;
        }

        @Deprecated
        public int b() {
            return this.f1045b.c();
        }

        public int c() {
            return this.f1048e;
        }

        public int d() {
            return this.f1047d;
        }

        public int e() {
            return this.f1044a;
        }

        public int f() {
            return this.f1046c;
        }

        public d(int i10, @n0 AudioAttributesCompat audioAttributesCompat, int i11, int i12, int i13) {
            this.f1044a = i10;
            this.f1045b = audioAttributesCompat;
            this.f1046c = i11;
            this.f1047d = i12;
            this.f1048e = i13;
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f1049a = "android.media.session.extra.LEGACY_STREAM_TYPE";

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d(String str, Bundle bundle);

        public abstract void e(String str, Bundle bundle);

        public abstract void f(Uri uri, Bundle bundle);

        public abstract void g();

        public abstract void h(String str, Bundle bundle);

        public abstract void i(String str, Bundle bundle);

        public abstract void j(Uri uri, Bundle bundle);

        public abstract void k();

        public abstract void l(long j10);

        public abstract void m(PlaybackStateCompat.CustomAction customAction, Bundle bundle);

        public abstract void n(String str, Bundle bundle);

        public abstract void o(boolean z10);

        public void p(float f10) {
        }

        public abstract void q(RatingCompat ratingCompat);

        public abstract void r(RatingCompat ratingCompat, Bundle bundle);

        public abstract void s(int i10);

        public abstract void t(int i10);

        public abstract void u();

        public abstract void v();

        public abstract void w(long j10);

        public abstract void x();
    }

    @v0(21)
    public static class f extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaController.TransportControls f1050b;

        public f(MediaController.TransportControls transportControls) {
            this.f1050b = transportControls;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void a() {
            this.f1050b.fastForward();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void b() {
            this.f1050b.pause();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void c() {
            this.f1050b.play();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void d(String str, Bundle bundle) {
            this.f1050b.playFromMediaId(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void e(String str, Bundle bundle) {
            this.f1050b.playFromSearch(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void f(Uri uri, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f1050b.playFromUri(uri, bundle);
                return;
            }
            if (uri == null || Uri.EMPTY.equals(uri)) {
                throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.C, uri);
            bundle2.putBundle(MediaSessionCompat.F, bundle);
            n(MediaSessionCompat.f1065q, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void g() {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f1050b.prepare();
            } else {
                n(MediaSessionCompat.f1066r, null);
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void h(String str, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f1050b.prepareFromMediaId(str, bundle);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.A, str);
            bundle2.putBundle(MediaSessionCompat.F, bundle);
            n(MediaSessionCompat.f1067s, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void i(String str, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f1050b.prepareFromSearch(str, bundle);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaSessionCompat.B, str);
            bundle2.putBundle(MediaSessionCompat.F, bundle);
            n(MediaSessionCompat.f1068t, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void j(Uri uri, Bundle bundle) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f1050b.prepareFromUri(uri, bundle);
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.C, uri);
            bundle2.putBundle(MediaSessionCompat.F, bundle);
            n(MediaSessionCompat.f1069u, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void k() {
            this.f1050b.rewind();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void l(long j10) {
            this.f1050b.seekTo(j10);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void m(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            MediaControllerCompat.G(customAction.b(), bundle);
            this.f1050b.sendCustomAction(customAction.b(), bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void n(String str, Bundle bundle) {
            MediaControllerCompat.G(str, bundle);
            this.f1050b.sendCustomAction(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void o(boolean z10) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(MediaSessionCompat.G, z10);
            n(MediaSessionCompat.f1070v, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void p(float f10) {
            if (f10 == 0.0f) {
                throw new IllegalArgumentException("speed must not be zero");
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.f1050b.setPlaybackSpeed(f10);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat(MediaSessionCompat.E, f10);
            n(MediaSessionCompat.f1074z, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void q(RatingCompat ratingCompat) {
            this.f1050b.setRating(ratingCompat != null ? (Rating) ratingCompat.e() : null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void r(RatingCompat ratingCompat, Bundle bundle) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable(MediaSessionCompat.D, ratingCompat);
            bundle2.putBundle(MediaSessionCompat.F, bundle);
            n(MediaSessionCompat.f1073y, bundle2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void s(int i10) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.H, i10);
            n(MediaSessionCompat.f1071w, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void t(int i10) {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaSessionCompat.I, i10);
            n(MediaSessionCompat.f1072x, bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void u() {
            this.f1050b.skipToNext();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void v() {
            this.f1050b.skipToPrevious();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void w(long j10) {
            this.f1050b.skipToQueueItem(j10);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void x() {
            this.f1050b.stop();
        }
    }

    public static class g extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public android.support.v4.media.session.b f1051b;

        public g(android.support.v4.media.session.b bVar) {
            this.f1051b = bVar;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void a() {
            try {
                this.f1051b.Z();
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void b() {
            try {
                this.f1051b.pause();
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void c() {
            try {
                this.f1051b.i();
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void d(String str, Bundle bundle) {
            try {
                this.f1051b.V(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void e(String str, Bundle bundle) {
            try {
                this.f1051b.X(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void f(Uri uri, Bundle bundle) {
            try {
                this.f1051b.a0(uri, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void g() {
            try {
                this.f1051b.f();
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void h(String str, Bundle bundle) {
            try {
                this.f1051b.T(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void i(String str, Bundle bundle) {
            try {
                this.f1051b.K(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void j(Uri uri, Bundle bundle) {
            try {
                this.f1051b.G(uri, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void k() {
            try {
                this.f1051b.y0();
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void l(long j10) {
            try {
                this.f1051b.g(j10);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void m(PlaybackStateCompat.CustomAction customAction, Bundle bundle) {
            n(customAction.b(), bundle);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void n(String str, Bundle bundle) {
            MediaControllerCompat.G(str, bundle);
            try {
                this.f1051b.B(str, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void o(boolean z10) {
            try {
                this.f1051b.u(z10);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void p(float f10) {
            if (f10 == 0.0f) {
                throw new IllegalArgumentException("speed must not be zero");
            }
            try {
                this.f1051b.f0(f10);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void q(RatingCompat ratingCompat) {
            try {
                this.f1051b.E(ratingCompat);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void r(RatingCompat ratingCompat, Bundle bundle) {
            try {
                this.f1051b.l0(ratingCompat, bundle);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void s(int i10) {
            try {
                this.f1051b.j(i10);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void t(int i10) {
            try {
                this.f1051b.z(i10);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void u() {
            try {
                this.f1051b.next();
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void v() {
            try {
                this.f1051b.previous();
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void w(long j10) {
            try {
                this.f1051b.B0(j10);
            } catch (RemoteException unused) {
            }
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.e
        public void x() {
            try {
                this.f1051b.stop();
            } catch (RemoteException unused) {
            }
        }
    }

    public MediaControllerCompat(Context context, @n0 MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat == null) {
            throw new IllegalArgumentException("session must not be null");
        }
        MediaSessionCompat.Token tokenJ = mediaSessionCompat.j();
        this.f1011b = tokenJ;
        this.f1010a = new MediaControllerImplApi21(context, tokenJ);
    }

    public static void D(@n0 Activity activity, MediaControllerCompat mediaControllerCompat) {
        activity.getWindow().getDecorView().setTag(R.id.media_controller_compat_view_tag, mediaControllerCompat);
        activity.setMediaController(mediaControllerCompat != null ? new MediaController(activity, (MediaSession.Token) mediaControllerCompat.t().s()) : null);
    }

    public static void G(String str, Bundle bundle) {
        if (str == null) {
            return;
        }
        if (str.equals(MediaSessionCompat.f1058j) || str.equals(MediaSessionCompat.f1059k)) {
            if (bundle == null || !bundle.containsKey(MediaSessionCompat.f1060l)) {
                throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + str + j3.b.f36044h);
            }
        }
    }

    public static MediaControllerCompat g(@n0 Activity activity) {
        Object tag = activity.getWindow().getDecorView().getTag(R.id.media_controller_compat_view_tag);
        if (tag instanceof MediaControllerCompat) {
            return (MediaControllerCompat) tag;
        }
        MediaController mediaController = activity.getMediaController();
        if (mediaController == null) {
            return null;
        }
        return new MediaControllerCompat(activity, MediaSessionCompat.Token.b(mediaController.getSessionToken()));
    }

    public void A(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f1010a.o(mediaDescriptionCompat);
    }

    @Deprecated
    public void B(int i10) {
        MediaSessionCompat.QueueItem queueItem;
        List<MediaSessionCompat.QueueItem> listM = m();
        if (listM == null || i10 < 0 || i10 >= listM.size() || (queueItem = listM.get(i10)) == null) {
            return;
        }
        A(queueItem.e());
    }

    public void C(@n0 String str, @p0 Bundle bundle, @p0 ResultReceiver resultReceiver) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command must neither be null nor empty");
        }
        this.f1010a.i(str, bundle, resultReceiver);
    }

    public void E(int i10, int i11) {
        this.f1010a.g(i10, i11);
    }

    public void F(@n0 a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (this.f1012c.remove(aVar) == null) {
            return;
        }
        try {
            this.f1010a.c(aVar);
        } finally {
            aVar.o(null);
        }
    }

    public void a(MediaDescriptionCompat mediaDescriptionCompat) {
        this.f1010a.p(mediaDescriptionCompat);
    }

    public void b(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        this.f1010a.h(mediaDescriptionCompat, i10);
    }

    public void c(int i10, int i11) {
        this.f1010a.b(i10, i11);
    }

    public boolean d(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.f1010a.f(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public Bundle e() {
        return this.f1010a.getExtras();
    }

    public long f() {
        return this.f1010a.e();
    }

    public Object h() {
        return this.f1010a.u();
    }

    public MediaMetadataCompat i() {
        return this.f1010a.s();
    }

    public String j() {
        return this.f1010a.m();
    }

    public d k() {
        return this.f1010a.a();
    }

    public PlaybackStateCompat l() {
        return this.f1010a.d();
    }

    public List<MediaSessionCompat.QueueItem> m() {
        return this.f1010a.y();
    }

    public CharSequence n() {
        return this.f1010a.r();
    }

    public int o() {
        return this.f1010a.q();
    }

    public int p() {
        return this.f1010a.k();
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public i2.e q() {
        return this.f1011b.j();
    }

    public PendingIntent r() {
        return this.f1010a.l();
    }

    @n0
    public Bundle s() {
        return this.f1010a.t();
    }

    public MediaSessionCompat.Token t() {
        return this.f1011b;
    }

    public int u() {
        return this.f1010a.w();
    }

    public e v() {
        return this.f1010a.n();
    }

    public boolean w() {
        return this.f1010a.x();
    }

    public boolean x() {
        return this.f1010a.j();
    }

    public void y(@n0 a aVar) {
        z(aVar, null);
    }

    public void z(@n0 a aVar, Handler handler) {
        if (aVar == null) {
            throw new IllegalArgumentException("callback must not be null");
        }
        if (this.f1012c.putIfAbsent(aVar, Boolean.TRUE) != null) {
            return;
        }
        if (handler == null) {
            handler = new Handler();
        }
        aVar.o(handler);
        this.f1010a.v(aVar, handler);
    }

    public MediaControllerCompat(Context context, @n0 MediaSessionCompat.Token token) {
        if (token != null) {
            this.f1011b = token;
            this.f1010a = new MediaControllerImplApi21(context, token);
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }
}
