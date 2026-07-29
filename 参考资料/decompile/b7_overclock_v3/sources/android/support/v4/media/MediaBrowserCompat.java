package android.support.v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.b;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.v0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class MediaBrowserCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f814b = "MediaBrowserCompat";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f815c = Log.isLoggable(f814b, 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f816d = "android.media.browse.extra.PAGE";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f817e = "android.media.browse.extra.PAGE_SIZE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f818f = "android.media.browse.extra.MEDIA_ID";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f819g = "android.media.browse.extra.DOWNLOAD_PROGRESS";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f820h = "android.support.v4.media.action.DOWNLOAD";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f821i = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f822a;

    public static class CustomActionResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c f825f;

        public CustomActionResultReceiver(String str, Bundle bundle, c cVar, Handler handler) {
            super(handler);
            this.f823d = str;
            this.f824e = bundle;
            this.f825f = cVar;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void a(int i10, Bundle bundle) {
            if (this.f825f == null) {
                return;
            }
            MediaSessionCompat.c(bundle);
            if (i10 == -1) {
                this.f825f.a(this.f823d, this.f824e, bundle);
                return;
            }
            if (i10 == 0) {
                this.f825f.c(this.f823d, this.f824e, bundle);
                return;
            }
            if (i10 == 1) {
                this.f825f.b(this.f823d, this.f824e, bundle);
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unknown result code: ");
            sb2.append(i10);
            sb2.append(" (extras=");
            sb2.append(this.f824e);
            sb2.append(", resultData=");
            sb2.append(bundle);
            sb2.append(ee.a.f26979d);
        }
    }

    public static class ItemReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f826d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final d f827e;

        public ItemReceiver(String str, d dVar, Handler handler) {
            super(handler);
            this.f826d = str;
            this.f827e = dVar;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void a(int i10, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.G(bundle);
            }
            if (i10 != 0 || bundle == null || !bundle.containsKey(t1.d.f50700l)) {
                this.f827e.a(this.f826d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable(t1.d.f50700l);
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.f827e.b((MediaItem) parcelable);
            } else {
                this.f827e.a(this.f826d);
            }
        }
    }

    public static class SearchResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f832d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f833e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final k f834f;

        public SearchResultReceiver(String str, Bundle bundle, k kVar, Handler handler) {
            super(handler);
            this.f832d = str;
            this.f833e = bundle;
            this.f834f = kVar;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void a(int i10, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.G(bundle);
            }
            if (i10 != 0 || bundle == null || !bundle.containsKey(t1.d.f50701m)) {
                this.f834f.a(this.f832d, this.f833e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray(t1.d.f50701m);
            if (parcelableArray == null) {
                this.f834f.a(this.f832d, this.f833e);
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : parcelableArray) {
                arrayList.add((MediaItem) parcelable);
            }
            this.f834f.b(this.f832d, this.f833e, arrayList);
        }
    }

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<j> f835a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WeakReference<Messenger> f836b;

        public a(j jVar) {
            this.f835a = new WeakReference<>(jVar);
        }

        public void a(Messenger messenger) {
            this.f836b = new WeakReference<>(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(@n0 Message message) {
            WeakReference<Messenger> weakReference = this.f836b;
            if (weakReference == null || weakReference.get() == null || this.f835a.get() == null) {
                return;
            }
            Bundle data = message.getData();
            MediaSessionCompat.c(data);
            j jVar = this.f835a.get();
            Messenger messenger = this.f836b.get();
            try {
                int i10 = message.what;
                if (i10 == 1) {
                    Bundle bundle = data.getBundle(t1.c.f50680k);
                    MediaSessionCompat.c(bundle);
                    jVar.c(messenger, data.getString(t1.c.f50673d), (MediaSessionCompat.Token) data.getParcelable(t1.c.f50675f), bundle);
                } else if (i10 == 2) {
                    jVar.l(messenger);
                } else if (i10 != 3) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unhandled message: ");
                    sb2.append(message);
                    sb2.append("\n  Client version: ");
                    sb2.append(1);
                    sb2.append("\n  Service version: ");
                    sb2.append(message.arg1);
                } else {
                    Bundle bundle2 = data.getBundle(t1.c.f50676g);
                    MediaSessionCompat.c(bundle2);
                    Bundle bundle3 = data.getBundle(t1.c.f50677h);
                    MediaSessionCompat.c(bundle3);
                    jVar.e(messenger, data.getString(t1.c.f50673d), data.getParcelableArrayList(t1.c.f50674e), bundle2, bundle3);
                }
            } catch (BadParcelableException unused) {
                if (message.what == 1) {
                    jVar.l(messenger);
                }
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaBrowser.ConnectionCallback f837a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC0017b f838b;

        @v0(21)
        public class a extends MediaBrowser.ConnectionCallback {
            public a() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                InterfaceC0017b interfaceC0017b = b.this.f838b;
                if (interfaceC0017b != null) {
                    interfaceC0017b.m();
                }
                b.this.a();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                InterfaceC0017b interfaceC0017b = b.this.f838b;
                if (interfaceC0017b != null) {
                    interfaceC0017b.n();
                }
                b.this.b();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                InterfaceC0017b interfaceC0017b = b.this.f838b;
                if (interfaceC0017b != null) {
                    interfaceC0017b.g();
                }
                b.this.c();
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$b$b, reason: collision with other inner class name */
        public interface InterfaceC0017b {
            void g();

            void m();

            void n();
        }

        public void a() {
        }

        public void b() {
        }

        public void c() {
        }

        public void d(InterfaceC0017b interfaceC0017b) {
            this.f838b = interfaceC0017b;
        }
    }

    public static abstract class c {
        public void a(String str, Bundle bundle, Bundle bundle2) {
        }

        public void b(String str, Bundle bundle, Bundle bundle2) {
        }

        public void c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaBrowser.ItemCallback f840a;

        @v0(23)
        public class a extends MediaBrowser.ItemCallback {
            public a() {
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onError(@n0 String str) {
                d.this.a(str);
            }

            @Override // android.media.browse.MediaBrowser.ItemCallback
            public void onItemLoaded(MediaBrowser.MediaItem mediaItem) {
                d.this.b(MediaItem.a(mediaItem));
            }
        }

        public d() {
            if (Build.VERSION.SDK_INT >= 23) {
                this.f840a = new a();
            } else {
                this.f840a = null;
            }
        }

        public void a(@n0 String str) {
        }

        public void b(MediaItem mediaItem) {
        }
    }

    public interface e {
        @n0
        MediaSessionCompat.Token a();

        void b(@n0 String str, Bundle bundle, @p0 c cVar);

        ComponentName d();

        void f(@n0 String str, @n0 d dVar);

        @p0
        Bundle getExtras();

        @n0
        String getRoot();

        void h();

        void i();

        void j(@n0 String str, @p0 Bundle bundle, @n0 n nVar);

        boolean k();

        void o(@n0 String str, n nVar);

        void p(@n0 String str, Bundle bundle, @n0 k kVar);

        @p0
        Bundle q();
    }

    @v0(21)
    public static class f implements e, j, b.InterfaceC0017b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaBrowser f843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Bundle f844c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f845d = new a(this);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final androidx.collection.a<String, m> f846e = new androidx.collection.a<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f847f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public l f848g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Messenger f849h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public MediaSessionCompat.Token f850i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Bundle f851j;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f852a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f853b;

            public a(d dVar, String str) {
                this.f852a = dVar;
                this.f853b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f852a.a(this.f853b);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f855a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f856b;

            public b(d dVar, String str) {
                this.f855a = dVar;
                this.f856b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f855a.a(this.f856b);
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f858a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f859b;

            public c(d dVar, String str) {
                this.f858a = dVar;
                this.f859b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f858a.a(this.f859b);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f861a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f862b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f863c;

            public d(k kVar, String str, Bundle bundle) {
                this.f861a = kVar;
                this.f862b = str;
                this.f863c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f861a.a(this.f862b, this.f863c);
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f865a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f866b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f867c;

            public e(k kVar, String str, Bundle bundle) {
                this.f865a = kVar;
                this.f866b = str;
                this.f867c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f865a.a(this.f866b, this.f867c);
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$f$f, reason: collision with other inner class name */
        public class RunnableC0018f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f869a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f870b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f871c;

            public RunnableC0018f(c cVar, String str, Bundle bundle) {
                this.f869a = cVar;
                this.f870b = str;
                this.f871c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f869a.a(this.f870b, this.f871c, null);
            }
        }

        public class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f873a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f874b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f875c;

            public g(c cVar, String str, Bundle bundle) {
                this.f873a = cVar;
                this.f874b = str;
                this.f875c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f873a.a(this.f874b, this.f875c, null);
            }
        }

        public f(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            this.f842a = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.f844c = bundle2;
            bundle2.putInt(t1.c.f50685p, 1);
            bundle2.putInt(t1.c.f50686q, Process.myPid());
            bVar.d(this);
            this.f843b = new MediaBrowser(context, componentName, bVar.f837a, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @n0
        public MediaSessionCompat.Token a() {
            if (this.f850i == null) {
                this.f850i = MediaSessionCompat.Token.b(this.f843b.getSessionToken());
            }
            return this.f850i;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void b(@n0 String str, Bundle bundle, @p0 c cVar) {
            if (!k()) {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            if (this.f848g == null && cVar != null) {
                this.f845d.post(new RunnableC0018f(cVar, str, bundle));
            }
            try {
                this.f848g.h(str, bundle, new CustomActionResultReceiver(str, bundle, cVar, this.f845d), this.f849h);
            } catch (RemoteException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Remote error sending a custom action: action=");
                sb2.append(str);
                sb2.append(", extras=");
                sb2.append(bundle);
                if (cVar != null) {
                    this.f845d.post(new g(cVar, str, bundle));
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void c(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public ComponentName d() {
            return this.f843b.getServiceComponent();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void e(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (this.f849h != messenger) {
                return;
            }
            m mVar = this.f846e.get(str);
            if (mVar == null) {
                if (MediaBrowserCompat.f815c) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onLoadChildren for id that isn't subscribed id=");
                    sb2.append(str);
                    return;
                }
                return;
            }
            n nVarA = mVar.a(bundle);
            if (nVarA != null) {
                if (bundle == null) {
                    if (list == null) {
                        nVarA.c(str);
                        return;
                    }
                    this.f851j = bundle2;
                    nVarA.a(str, list);
                    this.f851j = null;
                    return;
                }
                if (list == null) {
                    nVarA.d(str, bundle);
                    return;
                }
                this.f851j = bundle2;
                nVarA.b(str, list, bundle);
                this.f851j = null;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void f(@n0 String str, @n0 d dVar) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (dVar == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!this.f843b.isConnected()) {
                this.f845d.post(new a(dVar, str));
                return;
            }
            if (this.f848g == null) {
                this.f845d.post(new b(dVar, str));
                return;
            }
            try {
                this.f848g.d(str, new ItemReceiver(str, dVar, this.f845d), this.f849h);
            } catch (RemoteException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Remote error getting media item: ");
                sb2.append(str);
                this.f845d.post(new c(dVar, str));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.InterfaceC0017b
        public void g() {
            this.f848g = null;
            this.f849h = null;
            this.f850i = null;
            this.f845d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @p0
        public Bundle getExtras() {
            return this.f843b.getExtras();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @n0
        public String getRoot() {
            return this.f843b.getRoot();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void h() {
            Messenger messenger;
            l lVar = this.f848g;
            if (lVar != null && (messenger = this.f849h) != null) {
                try {
                    lVar.j(messenger);
                } catch (RemoteException unused) {
                }
            }
            this.f843b.disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void i() {
            this.f843b.connect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void j(@n0 String str, Bundle bundle, @n0 n nVar) {
            m mVar = this.f846e.get(str);
            if (mVar == null) {
                mVar = new m();
                this.f846e.put(str, mVar);
            }
            nVar.e(mVar);
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            mVar.e(bundle2, nVar);
            l lVar = this.f848g;
            if (lVar == null) {
                this.f843b.subscribe(str, nVar.f922a);
                return;
            }
            try {
                lVar.a(str, nVar.f923b, bundle2, this.f849h);
            } catch (RemoteException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Remote error subscribing media item: ");
                sb2.append(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public boolean k() {
            return this.f843b.isConnected();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void l(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.InterfaceC0017b
        public void m() {
            try {
                Bundle extras = this.f843b.getExtras();
                if (extras == null) {
                    return;
                }
                this.f847f = extras.getInt(t1.c.f50687r, 0);
                IBinder iBinderA = f0.k.a(extras, t1.c.f50688s);
                if (iBinderA != null) {
                    this.f848g = new l(iBinderA, this.f844c);
                    Messenger messenger = new Messenger(this.f845d);
                    this.f849h = messenger;
                    this.f845d.a(messenger);
                    try {
                        this.f848g.e(this.f842a, this.f849h);
                    } catch (RemoteException unused) {
                    }
                }
                android.support.v4.media.session.b bVarQ0 = b.AbstractBinderC0023b.Q0(f0.k.a(extras, t1.c.f50689t));
                if (bVarQ0 != null) {
                    this.f850i = MediaSessionCompat.Token.e(this.f843b.getSessionToken(), bVarQ0);
                }
            } catch (IllegalStateException unused2) {
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.InterfaceC0017b
        public void n() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void o(@n0 String str, n nVar) {
            m mVar = this.f846e.get(str);
            if (mVar == null) {
                return;
            }
            l lVar = this.f848g;
            if (lVar != null) {
                try {
                    if (nVar == null) {
                        lVar.f(str, null, this.f849h);
                    } else {
                        List<n> listB = mVar.b();
                        List<Bundle> listC = mVar.c();
                        for (int size = listB.size() - 1; size >= 0; size--) {
                            if (listB.get(size) == nVar) {
                                this.f848g.f(str, nVar.f923b, this.f849h);
                                listB.remove(size);
                                listC.remove(size);
                            }
                        }
                    }
                } catch (RemoteException unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("removeSubscription failed with RemoteException parentId=");
                    sb2.append(str);
                }
            } else if (nVar == null) {
                this.f843b.unsubscribe(str);
            } else {
                List<n> listB2 = mVar.b();
                List<Bundle> listC2 = mVar.c();
                for (int size2 = listB2.size() - 1; size2 >= 0; size2--) {
                    if (listB2.get(size2) == nVar) {
                        listB2.remove(size2);
                        listC2.remove(size2);
                    }
                }
                if (listB2.size() == 0) {
                    this.f843b.unsubscribe(str);
                }
            }
            if (mVar.d() || nVar == null) {
                this.f846e.remove(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void p(@n0 String str, Bundle bundle, @n0 k kVar) {
            if (!k()) {
                throw new IllegalStateException("search() called while not connected");
            }
            if (this.f848g == null) {
                this.f845d.post(new d(kVar, str, bundle));
                return;
            }
            try {
                this.f848g.g(str, bundle, new SearchResultReceiver(str, bundle, kVar, this.f845d), this.f849h);
            } catch (RemoteException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Remote error searching items with query: ");
                sb2.append(str);
                this.f845d.post(new e(kVar, str, bundle));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public Bundle q() {
            return this.f851j;
        }
    }

    @v0(23)
    public static class g extends f {
        public g(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f, android.support.v4.media.MediaBrowserCompat.e
        public void f(@n0 String str, @n0 d dVar) {
            if (this.f848g == null) {
                this.f843b.getItem(str, dVar.f840a);
            } else {
                super.f(str, dVar);
            }
        }
    }

    @v0(26)
    public static class h extends g {
        public h(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f, android.support.v4.media.MediaBrowserCompat.e
        public void j(@n0 String str, @p0 Bundle bundle, @n0 n nVar) {
            if (this.f848g != null && this.f847f >= 2) {
                super.j(str, bundle, nVar);
            } else if (bundle == null) {
                this.f843b.subscribe(str, nVar.f922a);
            } else {
                this.f843b.subscribe(str, bundle, nVar.f922a);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.f, android.support.v4.media.MediaBrowserCompat.e
        public void o(@n0 String str, n nVar) {
            if (this.f848g != null && this.f847f >= 2) {
                super.o(str, nVar);
            } else if (nVar == null) {
                this.f843b.unsubscribe(str);
            } else {
                this.f843b.unsubscribe(str, nVar.f922a);
            }
        }
    }

    public static class i implements e, j {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final int f877o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final int f878p = 1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final int f879q = 2;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final int f880r = 3;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final int f881s = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ComponentName f883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final b f884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Bundle f885d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f886e = new a(this);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final androidx.collection.a<String, m> f887f = new androidx.collection.a<>();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f888g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public g f889h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public l f890i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Messenger f891j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public String f892k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public MediaSessionCompat.Token f893l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Bundle f894m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Bundle f895n;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i iVar = i.this;
                if (iVar.f888g == 0) {
                    return;
                }
                iVar.f888g = 2;
                if (MediaBrowserCompat.f815c && iVar.f889h != null) {
                    throw new RuntimeException("mServiceConnection should be null. Instead it is " + i.this.f889h);
                }
                if (iVar.f890i != null) {
                    throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + i.this.f890i);
                }
                if (iVar.f891j != null) {
                    throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + i.this.f891j);
                }
                Intent intent = new Intent(t1.d.f50699k);
                intent.setComponent(i.this.f883b);
                i iVar2 = i.this;
                iVar2.f889h = iVar2.new g();
                boolean zBindService = false;
                try {
                    i iVar3 = i.this;
                    zBindService = iVar3.f882a.bindService(intent, iVar3.f889h, 1);
                } catch (Exception unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed binding to service ");
                    sb2.append(i.this.f883b);
                }
                if (!zBindService) {
                    i.this.m();
                    i.this.f884c.b();
                }
                if (MediaBrowserCompat.f815c) {
                    i.this.g();
                }
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                i iVar = i.this;
                Messenger messenger = iVar.f891j;
                if (messenger != null) {
                    try {
                        iVar.f890i.c(messenger);
                    } catch (RemoteException unused) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("RemoteException during connect for ");
                        sb2.append(i.this.f883b);
                    }
                }
                i iVar2 = i.this;
                int i10 = iVar2.f888g;
                iVar2.m();
                if (i10 != 0) {
                    i.this.f888g = i10;
                }
                if (MediaBrowserCompat.f815c) {
                    i.this.g();
                }
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f898a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f899b;

            public c(d dVar, String str) {
                this.f898a = dVar;
                this.f899b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f898a.a(this.f899b);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f901a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f902b;

            public d(d dVar, String str) {
                this.f901a = dVar;
                this.f902b = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f901a.a(this.f902b);
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ k f904a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f905b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f906c;

            public e(k kVar, String str, Bundle bundle) {
                this.f904a = kVar;
                this.f905b = str;
                this.f906c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f904a.a(this.f905b, this.f906c);
            }
        }

        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c f908a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f909b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f910c;

            public f(c cVar, String str, Bundle bundle) {
                this.f908a = cVar;
                this.f909b = str;
                this.f910c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f908a.a(this.f909b, this.f910c, null);
            }
        }

        public class g implements ServiceConnection {

            public class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ComponentName f913a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ IBinder f914b;

                public a(ComponentName componentName, IBinder iBinder) {
                    this.f913a = componentName;
                    this.f914b = iBinder;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z10 = MediaBrowserCompat.f815c;
                    if (z10) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("MediaServiceConnection.onServiceConnected name=");
                        sb2.append(this.f913a);
                        sb2.append(" binder=");
                        sb2.append(this.f914b);
                        i.this.g();
                    }
                    if (g.this.a("onServiceConnected")) {
                        i iVar = i.this;
                        iVar.f890i = new l(this.f914b, iVar.f885d);
                        i.this.f891j = new Messenger(i.this.f886e);
                        i iVar2 = i.this;
                        iVar2.f886e.a(iVar2.f891j);
                        i.this.f888g = 2;
                        if (z10) {
                            try {
                                i.this.g();
                            } catch (RemoteException unused) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("RemoteException during connect for ");
                                sb3.append(i.this.f883b);
                                if (MediaBrowserCompat.f815c) {
                                    i.this.g();
                                    return;
                                }
                                return;
                            }
                        }
                        i iVar3 = i.this;
                        iVar3.f890i.b(iVar3.f882a, iVar3.f891j);
                    }
                }
            }

            public class b implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ ComponentName f916a;

                public b(ComponentName componentName) {
                    this.f916a = componentName;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserCompat.f815c) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("MediaServiceConnection.onServiceDisconnected name=");
                        sb2.append(this.f916a);
                        sb2.append(" this=");
                        sb2.append(this);
                        sb2.append(" mServiceConnection=");
                        sb2.append(i.this.f889h);
                        i.this.g();
                    }
                    if (g.this.a("onServiceDisconnected")) {
                        i iVar = i.this;
                        iVar.f890i = null;
                        iVar.f891j = null;
                        iVar.f886e.a(null);
                        i iVar2 = i.this;
                        iVar2.f888g = 4;
                        iVar2.f884c.c();
                    }
                }
            }

            public g() {
            }

            public boolean a(String str) {
                int i10;
                i iVar = i.this;
                if (iVar.f889h == this && (i10 = iVar.f888g) != 0 && i10 != 1) {
                    return true;
                }
                int i11 = iVar.f888g;
                if (i11 == 0 || i11 == 1) {
                    return false;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" for ");
                sb2.append(i.this.f883b);
                sb2.append(" with mServiceConnection=");
                sb2.append(i.this.f889h);
                sb2.append(" this=");
                sb2.append(this);
                return false;
            }

            public final void b(Runnable runnable) {
                if (Thread.currentThread() == i.this.f886e.getLooper().getThread()) {
                    runnable.run();
                } else {
                    i.this.f886e.post(runnable);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                b(new a(componentName, iBinder));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                b(new b(componentName));
            }
        }

        public i(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            if (context == null) {
                throw new IllegalArgumentException("context must not be null");
            }
            if (componentName == null) {
                throw new IllegalArgumentException("service component must not be null");
            }
            if (bVar == null) {
                throw new IllegalArgumentException("connection callback must not be null");
            }
            this.f882a = context;
            this.f883b = componentName;
            this.f884c = bVar;
            this.f885d = bundle == null ? null : new Bundle(bundle);
        }

        public static String n(int i10) {
            if (i10 == 0) {
                return "CONNECT_STATE_DISCONNECTING";
            }
            if (i10 == 1) {
                return "CONNECT_STATE_DISCONNECTED";
            }
            if (i10 == 2) {
                return "CONNECT_STATE_CONNECTING";
            }
            if (i10 == 3) {
                return "CONNECT_STATE_CONNECTED";
            }
            if (i10 == 4) {
                return "CONNECT_STATE_SUSPENDED";
            }
            return "UNKNOWN/" + i10;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @n0
        public MediaSessionCompat.Token a() {
            if (k()) {
                return this.f893l;
            }
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f888g + ee.a.f26979d);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void b(@n0 String str, Bundle bundle, @p0 c cVar) {
            if (!k()) {
                throw new IllegalStateException("Cannot send a custom action (" + str + ") with extras " + bundle + " because the browser is not connected to the service.");
            }
            try {
                this.f890i.h(str, bundle, new CustomActionResultReceiver(str, bundle, cVar, this.f886e), this.f891j);
            } catch (RemoteException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Remote error sending a custom action: action=");
                sb2.append(str);
                sb2.append(", extras=");
                sb2.append(bundle);
                if (cVar != null) {
                    this.f886e.post(new f(cVar, str, bundle));
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void c(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
            if (r(messenger, "onConnect")) {
                if (this.f888g != 2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onConnect from service while mState=");
                    sb2.append(n(this.f888g));
                    sb2.append("... ignoring");
                    return;
                }
                this.f892k = str;
                this.f893l = token;
                this.f894m = bundle;
                this.f888g = 3;
                if (MediaBrowserCompat.f815c) {
                    g();
                }
                this.f884c.a();
                try {
                    for (Map.Entry<String, m> entry : this.f887f.entrySet()) {
                        String key = entry.getKey();
                        m value = entry.getValue();
                        List<n> listB = value.b();
                        List<Bundle> listC = value.c();
                        for (int i10 = 0; i10 < listB.size(); i10++) {
                            this.f890i.a(key, listB.get(i10).f923b, listC.get(i10), this.f891j);
                        }
                    }
                } catch (RemoteException unused) {
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @n0
        public ComponentName d() {
            if (k()) {
                return this.f883b;
            }
            throw new IllegalStateException("getServiceComponent() called while not connected (state=" + this.f888g + ee.a.f26979d);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void e(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (r(messenger, "onLoadChildren")) {
                boolean z10 = MediaBrowserCompat.f815c;
                if (z10) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onLoadChildren for ");
                    sb2.append(this.f883b);
                    sb2.append(" id=");
                    sb2.append(str);
                }
                m mVar = this.f887f.get(str);
                if (mVar == null) {
                    if (z10) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("onLoadChildren for id that isn't subscribed id=");
                        sb3.append(str);
                        return;
                    }
                    return;
                }
                n nVarA = mVar.a(bundle);
                if (nVarA != null) {
                    if (bundle == null) {
                        if (list == null) {
                            nVarA.c(str);
                            return;
                        }
                        this.f895n = bundle2;
                        nVarA.a(str, list);
                        this.f895n = null;
                        return;
                    }
                    if (list == null) {
                        nVarA.d(str, bundle);
                        return;
                    }
                    this.f895n = bundle2;
                    nVarA.b(str, list, bundle);
                    this.f895n = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void f(@n0 String str, @n0 d dVar) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("mediaId is empty");
            }
            if (dVar == null) {
                throw new IllegalArgumentException("cb is null");
            }
            if (!k()) {
                this.f886e.post(new c(dVar, str));
                return;
            }
            try {
                this.f890i.d(str, new ItemReceiver(str, dVar, this.f886e), this.f891j);
            } catch (RemoteException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Remote error getting media item: ");
                sb2.append(str);
                this.f886e.post(new d(dVar, str));
            }
        }

        public void g() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  mServiceComponent=");
            sb2.append(this.f883b);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("  mCallback=");
            sb3.append(this.f884c);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("  mRootHints=");
            sb4.append(this.f885d);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("  mState=");
            sb5.append(n(this.f888g));
            StringBuilder sb6 = new StringBuilder();
            sb6.append("  mServiceConnection=");
            sb6.append(this.f889h);
            StringBuilder sb7 = new StringBuilder();
            sb7.append("  mServiceBinderWrapper=");
            sb7.append(this.f890i);
            StringBuilder sb8 = new StringBuilder();
            sb8.append("  mCallbacksMessenger=");
            sb8.append(this.f891j);
            StringBuilder sb9 = new StringBuilder();
            sb9.append("  mRootId=");
            sb9.append(this.f892k);
            StringBuilder sb10 = new StringBuilder();
            sb10.append("  mMediaSessionToken=");
            sb10.append(this.f893l);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @p0
        public Bundle getExtras() {
            if (k()) {
                return this.f894m;
            }
            throw new IllegalStateException("getExtras() called while not connected (state=" + n(this.f888g) + ee.a.f26979d);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @n0
        public String getRoot() {
            if (k()) {
                return this.f892k;
            }
            throw new IllegalStateException("getRoot() called while not connected(state=" + n(this.f888g) + ee.a.f26979d);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void h() {
            this.f888g = 0;
            this.f886e.post(new b());
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void i() {
            int i10 = this.f888g;
            if (i10 == 0 || i10 == 1) {
                this.f888g = 2;
                this.f886e.post(new a());
            } else {
                throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + n(this.f888g) + ee.a.f26979d);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void j(@n0 String str, Bundle bundle, @n0 n nVar) {
            m mVar = this.f887f.get(str);
            if (mVar == null) {
                mVar = new m();
                this.f887f.put(str, mVar);
            }
            Bundle bundle2 = bundle == null ? null : new Bundle(bundle);
            mVar.e(bundle2, nVar);
            if (k()) {
                try {
                    this.f890i.a(str, nVar.f923b, bundle2, this.f891j);
                } catch (RemoteException unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("addSubscription failed with RemoteException parentId=");
                    sb2.append(str);
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public boolean k() {
            return this.f888g == 3;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void l(Messenger messenger) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onConnectFailed for ");
            sb2.append(this.f883b);
            if (r(messenger, "onConnectFailed")) {
                if (this.f888g == 2) {
                    m();
                    this.f884c.b();
                } else {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onConnect from service while mState=");
                    sb3.append(n(this.f888g));
                    sb3.append("... ignoring");
                }
            }
        }

        public void m() {
            g gVar = this.f889h;
            if (gVar != null) {
                this.f882a.unbindService(gVar);
            }
            this.f888g = 1;
            this.f889h = null;
            this.f890i = null;
            this.f891j = null;
            this.f886e.a(null);
            this.f892k = null;
            this.f893l = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void o(@n0 String str, n nVar) {
            m mVar = this.f887f.get(str);
            if (mVar == null) {
                return;
            }
            try {
                if (nVar != null) {
                    List<n> listB = mVar.b();
                    List<Bundle> listC = mVar.c();
                    for (int size = listB.size() - 1; size >= 0; size--) {
                        if (listB.get(size) == nVar) {
                            if (k()) {
                                this.f890i.f(str, nVar.f923b, this.f891j);
                            }
                            listB.remove(size);
                            listC.remove(size);
                        }
                    }
                } else if (k()) {
                    this.f890i.f(str, null, this.f891j);
                }
            } catch (RemoteException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("removeSubscription failed with RemoteException parentId=");
                sb2.append(str);
            }
            if (mVar.d() || nVar == null) {
                this.f887f.remove(str);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void p(@n0 String str, Bundle bundle, @n0 k kVar) {
            if (!k()) {
                throw new IllegalStateException("search() called while not connected (state=" + n(this.f888g) + ee.a.f26979d);
            }
            try {
                this.f890i.g(str, bundle, new SearchResultReceiver(str, bundle, kVar, this.f886e), this.f891j);
            } catch (RemoteException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Remote error searching items with query: ");
                sb2.append(str);
                this.f886e.post(new e(kVar, str, bundle));
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public Bundle q() {
            return this.f895n;
        }

        public final boolean r(Messenger messenger, String str) {
            int i10;
            if (this.f891j == messenger && (i10 = this.f888g) != 0 && i10 != 1) {
                return true;
            }
            int i11 = this.f888g;
            if (i11 == 0 || i11 == 1) {
                return false;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(" for ");
            sb2.append(this.f883b);
            sb2.append(" with mCallbacksMessenger=");
            sb2.append(this.f891j);
            sb2.append(" this=");
            sb2.append(this);
            return false;
        }
    }

    public interface j {
        void c(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void e(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2);

        void l(Messenger messenger);
    }

    public static abstract class k {
        public void a(@n0 String str, Bundle bundle) {
        }

        public void b(@n0 String str, Bundle bundle, @n0 List<MediaItem> list) {
        }
    }

    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Messenger f918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Bundle f919b;

        public l(IBinder iBinder, Bundle bundle) {
            this.f918a = new Messenger(iBinder);
            this.f919b = bundle;
        }

        public void a(String str, IBinder iBinder, Bundle bundle, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(t1.c.f50673d, str);
            f0.k.b(bundle2, t1.c.f50670a, iBinder);
            bundle2.putBundle(t1.c.f50676g, bundle);
            i(3, bundle2, messenger);
        }

        public void b(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(t1.c.f50678i, context.getPackageName());
            bundle.putInt("data_calling_pid", Process.myPid());
            bundle.putBundle(t1.c.f50680k, this.f919b);
            i(1, bundle, messenger);
        }

        public void c(Messenger messenger) throws RemoteException {
            i(2, null, messenger);
        }

        public void d(String str, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(t1.c.f50673d, str);
            bundle.putParcelable(t1.c.f50679j, resultReceiver);
            i(5, bundle, messenger);
        }

        public void e(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(t1.c.f50678i, context.getPackageName());
            bundle.putInt("data_calling_pid", Process.myPid());
            bundle.putBundle(t1.c.f50680k, this.f919b);
            i(6, bundle, messenger);
        }

        public void f(String str, IBinder iBinder, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString(t1.c.f50673d, str);
            f0.k.b(bundle, t1.c.f50670a, iBinder);
            i(4, bundle, messenger);
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(t1.c.f50682m, str);
            bundle2.putBundle(t1.c.f50681l, bundle);
            bundle2.putParcelable(t1.c.f50679j, resultReceiver);
            i(8, bundle2, messenger);
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, Messenger messenger) throws RemoteException {
            Bundle bundle2 = new Bundle();
            bundle2.putString(t1.c.f50683n, str);
            bundle2.putBundle(t1.c.f50684o, bundle);
            bundle2.putParcelable(t1.c.f50679j, resultReceiver);
            i(9, bundle2, messenger);
        }

        public final void i(int i10, Bundle bundle, Messenger messenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.arg1 = 1;
            messageObtain.setData(bundle);
            messageObtain.replyTo = messenger;
            this.f918a.send(messageObtain);
        }

        public void j(Messenger messenger) throws RemoteException {
            i(7, null, messenger);
        }
    }

    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<n> f920a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<Bundle> f921b = new ArrayList();

        public n a(Bundle bundle) {
            for (int i10 = 0; i10 < this.f921b.size(); i10++) {
                if (t1.b.a(this.f921b.get(i10), bundle)) {
                    return this.f920a.get(i10);
                }
            }
            return null;
        }

        public List<n> b() {
            return this.f920a;
        }

        public List<Bundle> c() {
            return this.f921b;
        }

        public boolean d() {
            return this.f920a.isEmpty();
        }

        public void e(Bundle bundle, n nVar) {
            for (int i10 = 0; i10 < this.f921b.size(); i10++) {
                if (t1.b.a(this.f921b.get(i10), bundle)) {
                    this.f920a.set(i10, nVar);
                    return;
                }
            }
            this.f920a.add(nVar);
            this.f921b.add(bundle);
        }
    }

    public static abstract class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaBrowser.SubscriptionCallback f922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder f923b = new Binder();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WeakReference<m> f924c;

        @v0(21)
        public class a extends MediaBrowser.SubscriptionCallback {
            public a() {
            }

            public List<MediaItem> a(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i10 = bundle.getInt(MediaBrowserCompat.f816d, -1);
                int i11 = bundle.getInt(MediaBrowserCompat.f817e, -1);
                if (i10 == -1 && i11 == -1) {
                    return list;
                }
                int i12 = i11 * i10;
                int size = i12 + i11;
                if (i10 < 0 || i11 < 1 || i12 >= list.size()) {
                    return Collections.emptyList();
                }
                if (size > list.size()) {
                    size = list.size();
                }
                return list.subList(i12, size);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@n0 String str, List<MediaBrowser.MediaItem> list) {
                WeakReference<m> weakReference = n.this.f924c;
                m mVar = weakReference == null ? null : weakReference.get();
                if (mVar == null) {
                    n.this.a(str, MediaItem.b(list));
                    return;
                }
                List<MediaItem> listB = MediaItem.b(list);
                List<n> listB2 = mVar.b();
                List<Bundle> listC = mVar.c();
                for (int i10 = 0; i10 < listB2.size(); i10++) {
                    Bundle bundle = listC.get(i10);
                    if (bundle == null) {
                        n.this.a(str, listB);
                    } else {
                        n.this.b(str, a(listB, bundle), bundle);
                    }
                }
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@n0 String str) {
                n.this.c(str);
            }
        }

        @v0(26)
        public class b extends a {
            public b() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@n0 String str, @n0 List<MediaBrowser.MediaItem> list, @n0 Bundle bundle) {
                MediaSessionCompat.c(bundle);
                n.this.b(str, MediaItem.b(list), bundle);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@n0 String str, @n0 Bundle bundle) {
                MediaSessionCompat.c(bundle);
                n.this.d(str, bundle);
            }
        }

        public n() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f922a = new b();
            } else {
                this.f922a = new a();
            }
        }

        public void a(@n0 String str, @n0 List<MediaItem> list) {
        }

        public void b(@n0 String str, @n0 List<MediaItem> list, @n0 Bundle bundle) {
        }

        public void c(@n0 String str) {
        }

        public void d(@n0 String str, @n0 Bundle bundle) {
        }

        public void e(m mVar) {
            this.f924c = new WeakReference<>(mVar);
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, b bVar, Bundle bundle) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            this.f822a = new h(context, componentName, bVar, bundle);
        } else if (i10 >= 23) {
            this.f822a = new g(context, componentName, bVar, bundle);
        } else {
            this.f822a = new f(context, componentName, bVar, bundle);
        }
    }

    public void a() {
        this.f822a.i();
    }

    public void b() {
        this.f822a.h();
    }

    @p0
    public Bundle c() {
        return this.f822a.getExtras();
    }

    public void d(@n0 String str, @n0 d dVar) {
        this.f822a.f(str, dVar);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bundle e() {
        return this.f822a.q();
    }

    @n0
    public String f() {
        return this.f822a.getRoot();
    }

    @n0
    public ComponentName g() {
        return this.f822a.d();
    }

    @n0
    public MediaSessionCompat.Token h() {
        return this.f822a.a();
    }

    public boolean i() {
        return this.f822a.k();
    }

    public void j(@n0 String str, Bundle bundle, @n0 k kVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("query cannot be empty");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        this.f822a.p(str, bundle, kVar);
    }

    public void k(@n0 String str, Bundle bundle, @p0 c cVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("action cannot be empty");
        }
        this.f822a.b(str, bundle, cVar);
    }

    public void l(@n0 String str, @n0 Bundle bundle, @n0 n nVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("callback is null");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options are null");
        }
        this.f822a.j(str, bundle, nVar);
    }

    public void m(@n0 String str, @n0 n nVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.f822a.j(str, null, nVar);
    }

    public void n(@n0 String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        this.f822a.o(str, null);
    }

    public void o(@n0 String str, @n0 n nVar) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("parentId is empty");
        }
        if (nVar == null) {
            throw new IllegalArgumentException("callback is null");
        }
        this.f822a.o(str, nVar);
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f828c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f829d = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f830a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaDescriptionCompat f831b;

        public class a implements Parcelable.Creator<MediaItem> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public MediaItem[] newArray(int i10) {
                return new MediaItem[i10];
            }
        }

        public MediaItem(@n0 MediaDescriptionCompat mediaDescriptionCompat, int i10) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("description cannot be null");
            }
            if (TextUtils.isEmpty(mediaDescriptionCompat.z())) {
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            this.f830a = i10;
            this.f831b = mediaDescriptionCompat;
        }

        public static MediaItem a(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
            return new MediaItem(MediaDescriptionCompat.a(mediaItem.getDescription()), mediaItem.getFlags());
        }

        public static List<MediaItem> b(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<?> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(a(it2.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @n0
        public MediaDescriptionCompat e() {
            return this.f831b;
        }

        public int g() {
            return this.f830a;
        }

        @p0
        public String j() {
            return this.f831b.z();
        }

        public boolean s() {
            return (this.f830a & 1) != 0;
        }

        @n0
        public String toString() {
            return "MediaItem{mFlags=" + this.f830a + ", mDescription=" + this.f831b + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f830a);
            this.f831b.writeToParcel(parcel, i10);
        }

        public boolean z() {
            return (this.f830a & 2) != 0;
        }

        public MediaItem(Parcel parcel) {
            this.f830a = parcel.readInt();
            this.f831b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }
}
