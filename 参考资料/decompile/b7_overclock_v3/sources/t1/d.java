package t1;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.v0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import t1.e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends Service {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f50696h = "MBServiceCompat";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f50697i = Log.isLoggable(f50696h, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final float f50698j = 1.0E-5f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f50699k = "android.media.browse.MediaBrowserService";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f50700l = "media_item";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f50701m = "search_results";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f50702n = 1;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f50703o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f50704p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int f50705q = -1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int f50706r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final int f50707s = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f50708a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f f50712e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MediaSessionCompat.Token f50714g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f50709b = new f(e.b.f50833b, -1, -1, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<f> f50710c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.collection.a<IBinder, f> f50711d = new androidx.collection.a<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f50713f = new r();

    public class a extends m<List<MediaBrowserCompat.MediaItem>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f f50715f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f50716g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Bundle f50717h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ Bundle f50718i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, f fVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f50715f = fVar;
            this.f50716g = str;
            this.f50717h = bundle;
            this.f50718i = bundle2;
        }

        @Override // t1.d.m
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void g(List<MediaBrowserCompat.MediaItem> list) {
            if (d.this.f50711d.get(this.f50715f.f50737f.asBinder()) != this.f50715f) {
                if (d.f50697i) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Not sending onLoadChildren result for connection that has been disconnected. pkg=");
                    sb2.append(this.f50715f.f50732a);
                    sb2.append(" id=");
                    sb2.append(this.f50716g);
                    return;
                }
                return;
            }
            if ((c() & 1) != 0) {
                list = d.this.b(list, this.f50717h);
            }
            try {
                this.f50715f.f50737f.a(this.f50716g, list, this.f50717h, this.f50718i);
            } catch (RemoteException unused) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Calling onLoadChildren() failed for id=");
                sb3.append(this.f50716g);
                sb3.append(" package=");
                sb3.append(this.f50715f.f50732a);
            }
        }
    }

    public class b extends m<MediaBrowserCompat.MediaItem> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f50720f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f50720f = resultReceiver;
        }

        @Override // t1.d.m
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void g(MediaBrowserCompat.MediaItem mediaItem) {
            if ((c() & 2) != 0) {
                this.f50720f.b(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(d.f50700l, mediaItem);
            this.f50720f.b(0, bundle);
        }
    }

    public class c extends m<List<MediaBrowserCompat.MediaItem>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f50722f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f50722f = resultReceiver;
        }

        @Override // t1.d.m
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void g(List<MediaBrowserCompat.MediaItem> list) {
            if ((c() & 4) != 0 || list == null) {
                this.f50722f.b(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray(d.f50701m, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.f50722f.b(0, bundle);
        }
    }

    /* JADX INFO: renamed from: t1.d$d, reason: collision with other inner class name */
    public class C0574d extends m<Bundle> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ ResultReceiver f50724f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0574d(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.f50724f = resultReceiver;
        }

        @Override // t1.d.m
        public void e(Bundle bundle) {
            this.f50724f.b(-1, bundle);
        }

        @Override // t1.d.m
        public void f(Bundle bundle) {
            this.f50724f.b(1, bundle);
        }

        @Override // t1.d.m
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public void g(Bundle bundle) {
            this.f50724f.b(0, bundle);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f50726c = "android.service.media.extra.RECENT";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f50727d = "android.service.media.extra.OFFLINE";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f50728e = "android.service.media.extra.SUGGESTED";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Deprecated
        public static final String f50729f = "android.service.media.extra.SUGGESTION_KEYWORDS";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f50730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bundle f50731b;

        public e(@n0 String str, @p0 Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
            }
            this.f50730a = str;
            this.f50731b = bundle;
        }

        public Bundle c() {
            return this.f50731b;
        }

        public String d() {
            return this.f50730a;
        }
    }

    public class f implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f50732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f50733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f50734c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final e.b f50735d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Bundle f50736e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final p f50737f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final HashMap<String, List<androidx.core.util.k<IBinder, Bundle>>> f50738g = new HashMap<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public e f50739h;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                d.this.f50711d.remove(fVar.f50737f.asBinder());
            }
        }

        public f(String str, int i10, int i11, Bundle bundle, p pVar) {
            this.f50732a = str;
            this.f50733b = i10;
            this.f50734c = i11;
            this.f50735d = new e.b(str, i10, i11);
            this.f50736e = bundle;
            this.f50737f = pVar;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            d.this.f50713f.post(new a());
        }
    }

    public interface g {
        Bundle a();

        e.b b();

        void c();

        IBinder d(Intent intent);

        void e(e.b bVar, String str, Bundle bundle);

        void f(String str, Bundle bundle);

        void g(MediaSessionCompat.Token token);
    }

    @v0(21)
    public class h implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Bundle> f50742a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaBrowserService f50743b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Messenger f50744c;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MediaSessionCompat.Token f50746a;

            public a(MediaSessionCompat.Token token) {
                this.f50746a = token;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!h.this.f50742a.isEmpty()) {
                    android.support.v4.media.session.b bVarG = this.f50746a.g();
                    if (bVarG != null) {
                        Iterator<Bundle> it2 = h.this.f50742a.iterator();
                        while (it2.hasNext()) {
                            f0.k.b(it2.next(), t1.c.f50689t, bVarG.asBinder());
                        }
                    }
                    h.this.f50742a.clear();
                }
                h.this.f50743b.setSessionToken((MediaSession.Token) this.f50746a.s());
            }
        }

        public class b extends m<List<MediaBrowserCompat.MediaItem>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ n f50748f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Object obj, n nVar) {
                super(obj);
                this.f50748f = nVar;
            }

            @Override // t1.d.m
            public void b() {
                this.f50748f.a();
            }

            @Override // t1.d.m
            /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
            public void g(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                } else {
                    arrayList = null;
                }
                this.f50748f.c(arrayList);
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f50750a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Bundle f50751b;

            public c(String str, Bundle bundle) {
                this.f50750a = str;
                this.f50751b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<IBinder> it2 = d.this.f50711d.keySet().iterator();
                while (it2.hasNext()) {
                    h.this.j(d.this.f50711d.get(it2.next()), this.f50750a, this.f50751b);
                }
            }
        }

        /* JADX INFO: renamed from: t1.d$h$d, reason: collision with other inner class name */
        public class RunnableC0575d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e.b f50753a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f50754b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f50755c;

            public RunnableC0575d(e.b bVar, String str, Bundle bundle) {
                this.f50753a = bVar;
                this.f50754b = str;
                this.f50755c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i10 = 0; i10 < d.this.f50711d.size(); i10++) {
                    f fVarO = d.this.f50711d.o(i10);
                    if (fVarO.f50735d.equals(this.f50753a)) {
                        h.this.j(fVarO, this.f50754b, this.f50755c);
                    }
                }
            }
        }

        public class e extends MediaBrowserService {
            public e(Context context) {
                attachBaseContext(context);
            }

            @Override // android.service.media.MediaBrowserService
            @SuppressLint({"SyntheticAccessor"})
            public MediaBrowserService.BrowserRoot onGetRoot(String str, int i10, Bundle bundle) {
                MediaSessionCompat.c(bundle);
                e eVarL = h.this.l(str, i10, bundle == null ? null : new Bundle(bundle));
                if (eVarL == null) {
                    return null;
                }
                return new MediaBrowserService.BrowserRoot(eVarL.f50730a, eVarL.f50731b);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result) {
                h.this.m(str, new n<>(result));
            }
        }

        public h() {
        }

        @Override // t1.d.g
        public Bundle a() {
            if (this.f50744c == null) {
                return null;
            }
            f fVar = d.this.f50712e;
            if (fVar == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (fVar.f50736e == null) {
                return null;
            }
            return new Bundle(d.this.f50712e.f50736e);
        }

        @Override // t1.d.g
        public e.b b() {
            f fVar = d.this.f50712e;
            if (fVar != null) {
                return fVar.f50735d;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // t1.d.g
        public void c() {
            e eVar = new e(d.this);
            this.f50743b = eVar;
            eVar.onCreate();
        }

        @Override // t1.d.g
        public IBinder d(Intent intent) {
            return this.f50743b.onBind(intent);
        }

        @Override // t1.d.g
        public void e(e.b bVar, String str, Bundle bundle) {
            i(bVar, str, bundle);
        }

        @Override // t1.d.g
        public void f(String str, Bundle bundle) {
            k(str, bundle);
            h(str, bundle);
        }

        @Override // t1.d.g
        public void g(MediaSessionCompat.Token token) {
            d.this.f50713f.a(new a(token));
        }

        public void h(String str, Bundle bundle) {
            d.this.f50713f.post(new c(str, bundle));
        }

        public void i(e.b bVar, String str, Bundle bundle) {
            d.this.f50713f.post(new RunnableC0575d(bVar, str, bundle));
        }

        public void j(f fVar, String str, Bundle bundle) {
            List<androidx.core.util.k<IBinder, Bundle>> list = fVar.f50738g.get(str);
            if (list != null) {
                for (androidx.core.util.k<IBinder, Bundle> kVar : list) {
                    if (t1.b.b(bundle, kVar.f4742b)) {
                        d.this.t(str, fVar, kVar.f4742b, bundle);
                    }
                }
            }
        }

        public void k(String str, Bundle bundle) {
            this.f50743b.notifyChildrenChanged(str);
        }

        public e l(String str, int i10, Bundle bundle) {
            Bundle bundleC;
            int i11;
            if (bundle == null || bundle.getInt(t1.c.f50685p, 0) == 0) {
                bundleC = null;
                i11 = -1;
            } else {
                bundle.remove(t1.c.f50685p);
                this.f50744c = new Messenger(d.this.f50713f);
                bundleC = new Bundle();
                bundleC.putInt(t1.c.f50687r, 2);
                f0.k.b(bundleC, t1.c.f50688s, this.f50744c.getBinder());
                MediaSessionCompat.Token token = d.this.f50714g;
                if (token != null) {
                    android.support.v4.media.session.b bVarG = token.g();
                    f0.k.b(bundleC, t1.c.f50689t, bVarG == null ? null : bVarG.asBinder());
                } else {
                    this.f50742a.add(bundleC);
                }
                int i12 = bundle.getInt(t1.c.f50686q, -1);
                bundle.remove(t1.c.f50686q);
                i11 = i12;
            }
            f fVar = d.this.new f(str, i11, i10, bundle, null);
            d dVar = d.this;
            dVar.f50712e = fVar;
            e eVarL = dVar.l(str, i10, bundle);
            d dVar2 = d.this;
            dVar2.f50712e = null;
            if (eVarL == null) {
                return null;
            }
            if (this.f50744c != null) {
                dVar2.f50710c.add(fVar);
            }
            if (bundleC == null) {
                bundleC = eVarL.c();
            } else if (eVarL.c() != null) {
                bundleC.putAll(eVarL.c());
            }
            return new e(eVarL.d(), bundleC);
        }

        public void m(String str, n<List<Parcel>> nVar) {
            b bVar = new b(str, nVar);
            d dVar = d.this;
            dVar.f50712e = dVar.f50709b;
            dVar.m(str, bVar);
            d.this.f50712e = null;
        }
    }

    @v0(23)
    public class i extends h {

        public class a extends m<MediaBrowserCompat.MediaItem> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ n f50759f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, n nVar) {
                super(obj);
                this.f50759f = nVar;
            }

            @Override // t1.d.m
            public void b() {
                this.f50759f.a();
            }

            @Override // t1.d.m
            /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
            public void g(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.f50759f.c(null);
                    return;
                }
                Parcel parcelObtain = Parcel.obtain();
                mediaItem.writeToParcel(parcelObtain, 0);
                this.f50759f.c(parcelObtain);
            }
        }

        public class b extends h.e {
            public b(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadItem(String str, MediaBrowserService.Result<MediaBrowser.MediaItem> result) {
                i.this.n(str, new n<>(result));
            }
        }

        public i() {
            super();
        }

        @Override // t1.d.h, t1.d.g
        public void c() {
            b bVar = new b(d.this);
            this.f50743b = bVar;
            bVar.onCreate();
        }

        public void n(String str, n<Parcel> nVar) {
            a aVar = new a(str, nVar);
            d dVar = d.this;
            dVar.f50712e = dVar.f50709b;
            dVar.o(str, aVar);
            d.this.f50712e = null;
        }
    }

    @v0(26)
    public class j extends i {

        public class a extends m<List<MediaBrowserCompat.MediaItem>> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ n f50763f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Bundle f50764g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, n nVar, Bundle bundle) {
                super(obj);
                this.f50763f = nVar;
                this.f50764g = bundle;
            }

            @Override // t1.d.m
            public void b() {
                this.f50763f.a();
            }

            @Override // t1.d.m
            /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
            public void g(List<MediaBrowserCompat.MediaItem> list) {
                if (list == null) {
                    this.f50763f.c(null);
                    return;
                }
                if ((c() & 1) != 0) {
                    list = d.this.b(list, this.f50764g);
                }
                ArrayList arrayList = new ArrayList();
                for (MediaBrowserCompat.MediaItem mediaItem : list) {
                    Parcel parcelObtain = Parcel.obtain();
                    mediaItem.writeToParcel(parcelObtain, 0);
                    arrayList.add(parcelObtain);
                }
                this.f50763f.c(arrayList);
            }
        }

        public class b extends i.b {
            public b(Context context) {
                super(context);
            }

            @Override // android.service.media.MediaBrowserService
            public void onLoadChildren(String str, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> result, Bundle bundle) {
                MediaSessionCompat.c(bundle);
                j jVar = j.this;
                d dVar = d.this;
                dVar.f50712e = dVar.f50709b;
                jVar.o(str, new n<>(result), bundle);
                d.this.f50712e = null;
            }
        }

        public j() {
            super();
        }

        @Override // t1.d.h, t1.d.g
        public Bundle a() {
            d dVar = d.this;
            f fVar = dVar.f50712e;
            if (fVar == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (fVar == dVar.f50709b) {
                return this.f50743b.getBrowserRootHints();
            }
            if (fVar.f50736e == null) {
                return null;
            }
            return new Bundle(d.this.f50712e.f50736e);
        }

        @Override // t1.d.i, t1.d.h, t1.d.g
        public void c() {
            b bVar = new b(d.this);
            this.f50743b = bVar;
            bVar.onCreate();
        }

        @Override // t1.d.h
        public void k(String str, Bundle bundle) {
            if (bundle != null) {
                this.f50743b.notifyChildrenChanged(str, bundle);
            } else {
                super.k(str, bundle);
            }
        }

        public void o(String str, n<List<Parcel>> nVar, Bundle bundle) {
            a aVar = new a(str, nVar, bundle);
            d dVar = d.this;
            dVar.f50712e = dVar.f50709b;
            dVar.n(str, aVar, bundle);
            d.this.f50712e = null;
        }
    }

    @v0(28)
    public class k extends j {
        public k() {
            super();
        }

        @Override // t1.d.h, t1.d.g
        public e.b b() {
            d dVar = d.this;
            f fVar = dVar.f50712e;
            if (fVar != null) {
                return fVar == dVar.f50709b ? new e.b(this.f50743b.getCurrentBrowserInfo()) : fVar.f50735d;
            }
            throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }
    }

    public class l implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Messenger f50768a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ MediaSessionCompat.Token f50770a;

            public a(MediaSessionCompat.Token token) {
                this.f50770a = token;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<f> it2 = d.this.f50711d.values().iterator();
                while (it2.hasNext()) {
                    f next = it2.next();
                    try {
                        next.f50737f.c(next.f50739h.d(), this.f50770a, next.f50739h.c());
                    } catch (RemoteException unused) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Connection for ");
                        sb2.append(next.f50732a);
                        sb2.append(" is no longer valid.");
                        it2.remove();
                    }
                }
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f50772a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Bundle f50773b;

            public b(String str, Bundle bundle) {
                this.f50772a = str;
                this.f50773b = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<IBinder> it2 = d.this.f50711d.keySet().iterator();
                while (it2.hasNext()) {
                    l.this.h(d.this.f50711d.get(it2.next()), this.f50772a, this.f50773b);
                }
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e.b f50775a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f50776b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f50777c;

            public c(e.b bVar, String str, Bundle bundle) {
                this.f50775a = bVar;
                this.f50776b = str;
                this.f50777c = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i10 = 0; i10 < d.this.f50711d.size(); i10++) {
                    f fVarO = d.this.f50711d.o(i10);
                    if (fVarO.f50735d.equals(this.f50775a)) {
                        l.this.h(fVarO, this.f50776b, this.f50777c);
                        return;
                    }
                }
            }
        }

        public l() {
        }

        @Override // t1.d.g
        public Bundle a() {
            f fVar = d.this.f50712e;
            if (fVar == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (fVar.f50736e == null) {
                return null;
            }
            return new Bundle(d.this.f50712e.f50736e);
        }

        @Override // t1.d.g
        public e.b b() {
            f fVar = d.this.f50712e;
            if (fVar != null) {
                return fVar.f50735d;
            }
            throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
        }

        @Override // t1.d.g
        public void c() {
            this.f50768a = new Messenger(d.this.f50713f);
        }

        @Override // t1.d.g
        public IBinder d(Intent intent) {
            if (d.f50699k.equals(intent.getAction())) {
                return this.f50768a.getBinder();
            }
            return null;
        }

        @Override // t1.d.g
        public void e(@n0 e.b bVar, @n0 String str, Bundle bundle) {
            d.this.f50713f.post(new c(bVar, str, bundle));
        }

        @Override // t1.d.g
        public void f(@n0 String str, Bundle bundle) {
            d.this.f50713f.post(new b(str, bundle));
        }

        @Override // t1.d.g
        public void g(MediaSessionCompat.Token token) {
            d.this.f50713f.post(new a(token));
        }

        public void h(f fVar, String str, Bundle bundle) {
            List<androidx.core.util.k<IBinder, Bundle>> list = fVar.f50738g.get(str);
            if (list != null) {
                for (androidx.core.util.k<IBinder, Bundle> kVar : list) {
                    if (t1.b.b(bundle, kVar.f4742b)) {
                        d.this.t(str, fVar, kVar.f4742b, bundle);
                    }
                }
            }
        }
    }

    public static class m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f50779a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f50780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f50781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f50782d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f50783e;

        public m(Object obj) {
            this.f50779a = obj;
        }

        public final void a(Bundle bundle) {
            if (bundle != null && bundle.containsKey(MediaBrowserCompat.f819g)) {
                float f10 = bundle.getFloat(MediaBrowserCompat.f819g);
                if (f10 < -1.0E-5f || f10 > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0]");
                }
            }
        }

        public void b() {
            if (this.f50780b) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.f50779a);
            }
            if (this.f50781c) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.f50779a);
            }
            if (!this.f50782d) {
                this.f50780b = true;
                return;
            }
            throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.f50779a);
        }

        public int c() {
            return this.f50783e;
        }

        public boolean d() {
            return this.f50780b || this.f50781c || this.f50782d;
        }

        public void e(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.f50779a);
        }

        public void f(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.f50779a);
        }

        public void g(T t10) {
        }

        public void h(Bundle bundle) {
            if (!this.f50781c && !this.f50782d) {
                this.f50782d = true;
                e(bundle);
            } else {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.f50779a);
            }
        }

        public void i(Bundle bundle) {
            if (!this.f50781c && !this.f50782d) {
                a(bundle);
                f(bundle);
            } else {
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.f50779a);
            }
        }

        public void j(T t10) {
            if (!this.f50781c && !this.f50782d) {
                this.f50781c = true;
                g(t10);
            } else {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.f50779a);
            }
        }

        public void k(int i10) {
            this.f50783e = i10;
        }
    }

    @v0(21)
    public static class n<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public MediaBrowserService.Result f50784a;

        public n(MediaBrowserService.Result result) {
            this.f50784a = result;
        }

        public void a() {
            this.f50784a.detach();
        }

        public List<MediaBrowser.MediaItem> b(List<Parcel> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcel parcel : list) {
                parcel.setDataPosition(0);
                arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void c(T t10) {
            if (t10 instanceof List) {
                this.f50784a.sendResult(b((List) t10));
                return;
            }
            if (!(t10 instanceof Parcel)) {
                this.f50784a.sendResult(null);
                return;
            }
            Parcel parcel = (Parcel) t10;
            parcel.setDataPosition(0);
            this.f50784a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
    }

    public class o {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f50786a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f50787b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f50788c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f50789d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Bundle f50790e;

            public a(p pVar, String str, int i10, int i11, Bundle bundle) {
                this.f50786a = pVar;
                this.f50787b = str;
                this.f50788c = i10;
                this.f50789d = i11;
                this.f50790e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.f50786a.asBinder();
                d.this.f50711d.remove(iBinderAsBinder);
                f fVar = d.this.new f(this.f50787b, this.f50788c, this.f50789d, this.f50790e, this.f50786a);
                d dVar = d.this;
                dVar.f50712e = fVar;
                e eVarL = dVar.l(this.f50787b, this.f50789d, this.f50790e);
                fVar.f50739h = eVarL;
                d dVar2 = d.this;
                dVar2.f50712e = null;
                if (eVarL == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("No root for client ");
                    sb2.append(this.f50787b);
                    sb2.append(" from service ");
                    sb2.append(getClass().getName());
                    try {
                        this.f50786a.b();
                        return;
                    } catch (RemoteException unused) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Calling onConnectFailed() failed. Ignoring. pkg=");
                        sb3.append(this.f50787b);
                        return;
                    }
                }
                try {
                    dVar2.f50711d.put(iBinderAsBinder, fVar);
                    iBinderAsBinder.linkToDeath(fVar, 0);
                    if (d.this.f50714g != null) {
                        this.f50786a.c(fVar.f50739h.d(), d.this.f50714g, fVar.f50739h.c());
                    }
                } catch (RemoteException unused2) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Calling onConnect() failed. Dropping client. pkg=");
                    sb4.append(this.f50787b);
                    d.this.f50711d.remove(iBinderAsBinder);
                }
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f50792a;

            public b(p pVar) {
                this.f50792a = pVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVarRemove = d.this.f50711d.remove(this.f50792a.asBinder());
                if (fVarRemove != null) {
                    fVarRemove.f50737f.asBinder().unlinkToDeath(fVarRemove, 0);
                }
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f50794a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f50795b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IBinder f50796c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Bundle f50797d;

            public c(p pVar, String str, IBinder iBinder, Bundle bundle) {
                this.f50794a = pVar;
                this.f50795b = str;
                this.f50796c = iBinder;
                this.f50797d = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = d.this.f50711d.get(this.f50794a.asBinder());
                if (fVar != null) {
                    d.this.a(this.f50795b, fVar, this.f50796c, this.f50797d);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("addSubscription for callback that isn't registered id=");
                sb2.append(this.f50795b);
            }
        }

        /* JADX INFO: renamed from: t1.d$o$d, reason: collision with other inner class name */
        public class RunnableC0576d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f50799a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f50800b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ IBinder f50801c;

            public RunnableC0576d(p pVar, String str, IBinder iBinder) {
                this.f50799a = pVar;
                this.f50800b = str;
                this.f50801c = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = d.this.f50711d.get(this.f50799a.asBinder());
                if (fVar == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("removeSubscription for callback that isn't registered id=");
                    sb2.append(this.f50800b);
                } else {
                    if (d.this.w(this.f50800b, fVar, this.f50801c)) {
                        return;
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("removeSubscription called for ");
                    sb3.append(this.f50800b);
                    sb3.append(" which is not subscribed");
                }
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f50803a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f50804b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f50805c;

            public e(p pVar, String str, ResultReceiver resultReceiver) {
                this.f50803a = pVar;
                this.f50804b = str;
                this.f50805c = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = d.this.f50711d.get(this.f50803a.asBinder());
                if (fVar != null) {
                    d.this.u(this.f50804b, fVar, this.f50805c);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getMediaItem for callback that isn't registered id=");
                sb2.append(this.f50804b);
            }
        }

        public class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f50807a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f50808b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f50809c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ int f50810d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Bundle f50811e;

            public f(p pVar, int i10, String str, int i11, Bundle bundle) {
                this.f50807a = pVar;
                this.f50808b = i10;
                this.f50809c = str;
                this.f50810d = i11;
                this.f50811e = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.f50807a.asBinder();
                d.this.f50711d.remove(iBinderAsBinder);
                Iterator<f> it2 = d.this.f50710c.iterator();
                f fVar = null;
                while (it2.hasNext()) {
                    f next = it2.next();
                    if (next.f50734c == this.f50808b) {
                        if (TextUtils.isEmpty(this.f50809c) || this.f50810d <= 0) {
                            fVar = d.this.new f(next.f50732a, next.f50733b, next.f50734c, this.f50811e, this.f50807a);
                        }
                        it2.remove();
                    }
                }
                if (fVar == null) {
                    fVar = d.this.new f(this.f50809c, this.f50810d, this.f50808b, this.f50811e, this.f50807a);
                }
                d.this.f50711d.put(iBinderAsBinder, fVar);
                try {
                    iBinderAsBinder.linkToDeath(fVar, 0);
                } catch (RemoteException unused) {
                }
            }
        }

        public class g implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f50813a;

            public g(p pVar) {
                this.f50813a = pVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.f50813a.asBinder();
                f fVarRemove = d.this.f50711d.remove(iBinderAsBinder);
                if (fVarRemove != null) {
                    iBinderAsBinder.unlinkToDeath(fVarRemove, 0);
                }
            }
        }

        public class h implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f50815a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f50816b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f50817c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f50818d;

            public h(p pVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f50815a = pVar;
                this.f50816b = str;
                this.f50817c = bundle;
                this.f50818d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = d.this.f50711d.get(this.f50815a.asBinder());
                if (fVar != null) {
                    d.this.v(this.f50816b, this.f50817c, fVar, this.f50818d);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("search for callback that isn't registered query=");
                sb2.append(this.f50816b);
            }
        }

        public class i implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p f50820a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ String f50821b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Bundle f50822c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ResultReceiver f50823d;

            public i(p pVar, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f50820a = pVar;
                this.f50821b = str;
                this.f50822c = bundle;
                this.f50823d = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                f fVar = d.this.f50711d.get(this.f50820a.asBinder());
                if (fVar != null) {
                    d.this.s(this.f50821b, this.f50822c, fVar, this.f50823d);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("sendCustomAction for callback that isn't registered action=");
                sb2.append(this.f50821b);
                sb2.append(", extras=");
                sb2.append(this.f50822c);
            }
        }

        public o() {
        }

        public void a(String str, IBinder iBinder, Bundle bundle, p pVar) {
            d.this.f50713f.a(new c(pVar, str, iBinder, bundle));
        }

        public void b(String str, int i10, int i11, Bundle bundle, p pVar) {
            if (d.this.g(str, i11)) {
                d.this.f50713f.a(new a(pVar, str, i10, i11, bundle));
                return;
            }
            throw new IllegalArgumentException("Package/uid mismatch: uid=" + i11 + " package=" + str);
        }

        public void c(p pVar) {
            d.this.f50713f.a(new b(pVar));
        }

        public void d(String str, ResultReceiver resultReceiver, p pVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            d.this.f50713f.a(new e(pVar, str, resultReceiver));
        }

        public void e(p pVar, String str, int i10, int i11, Bundle bundle) {
            d.this.f50713f.a(new f(pVar, i11, str, i10, bundle));
        }

        public void f(String str, IBinder iBinder, p pVar) {
            d.this.f50713f.a(new RunnableC0576d(pVar, str, iBinder));
        }

        public void g(String str, Bundle bundle, ResultReceiver resultReceiver, p pVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            d.this.f50713f.a(new h(pVar, str, bundle, resultReceiver));
        }

        public void h(String str, Bundle bundle, ResultReceiver resultReceiver, p pVar) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            d.this.f50713f.a(new i(pVar, str, bundle, resultReceiver));
        }

        public void i(p pVar) {
            d.this.f50713f.a(new g(pVar));
        }
    }

    public interface p {
        void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;

        IBinder asBinder();

        void b() throws RemoteException;

        void c(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;
    }

    public static class q implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Messenger f50825a;

        public q(Messenger messenger) {
            this.f50825a = messenger;
        }

        @Override // t1.d.p
        public void a(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString(t1.c.f50673d, str);
            bundle3.putBundle(t1.c.f50676g, bundle);
            bundle3.putBundle(t1.c.f50677h, bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList(t1.c.f50674e, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            d(3, bundle3);
        }

        @Override // t1.d.p
        public IBinder asBinder() {
            return this.f50825a.getBinder();
        }

        @Override // t1.d.p
        public void b() throws RemoteException {
            d(2, null);
        }

        @Override // t1.d.p
        public void c(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(t1.c.f50687r, 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString(t1.c.f50673d, str);
            bundle2.putParcelable(t1.c.f50675f, token);
            bundle2.putBundle(t1.c.f50680k, bundle);
            d(1, bundle2);
        }

        public final void d(int i10, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i10;
            messageObtain.arg1 = 2;
            messageObtain.setData(bundle);
            this.f50825a.send(messageObtain);
        }
    }

    public final class r extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f50826a;

        public r() {
            this.f50826a = d.this.new o();
        }

        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle(t1.c.f50680k);
                    MediaSessionCompat.c(bundle);
                    this.f50826a.b(data.getString(t1.c.f50678i), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle, new q(message.replyTo));
                    break;
                case 2:
                    this.f50826a.c(new q(message.replyTo));
                    break;
                case 3:
                    Bundle bundle2 = data.getBundle(t1.c.f50676g);
                    MediaSessionCompat.c(bundle2);
                    this.f50826a.a(data.getString(t1.c.f50673d), f0.k.a(data, t1.c.f50670a), bundle2, new q(message.replyTo));
                    break;
                case 4:
                    this.f50826a.f(data.getString(t1.c.f50673d), f0.k.a(data, t1.c.f50670a), new q(message.replyTo));
                    break;
                case 5:
                    this.f50826a.d(data.getString(t1.c.f50673d), (ResultReceiver) data.getParcelable(t1.c.f50679j), new q(message.replyTo));
                    break;
                case 6:
                    Bundle bundle3 = data.getBundle(t1.c.f50680k);
                    MediaSessionCompat.c(bundle3);
                    this.f50826a.e(new q(message.replyTo), data.getString(t1.c.f50678i), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), bundle3);
                    break;
                case 7:
                    this.f50826a.i(new q(message.replyTo));
                    break;
                case 8:
                    Bundle bundle4 = data.getBundle(t1.c.f50681l);
                    MediaSessionCompat.c(bundle4);
                    this.f50826a.g(data.getString(t1.c.f50682m), bundle4, (ResultReceiver) data.getParcelable(t1.c.f50679j), new q(message.replyTo));
                    break;
                case 9:
                    Bundle bundle5 = data.getBundle(t1.c.f50684o);
                    MediaSessionCompat.c(bundle5);
                    this.f50826a.h(data.getString(t1.c.f50683n), bundle5, (ResultReceiver) data.getParcelable(t1.c.f50679j), new q(message.replyTo));
                    break;
                default:
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unhandled message: ");
                    sb2.append(message);
                    sb2.append("\n  Service version: ");
                    sb2.append(2);
                    sb2.append("\n  Client version: ");
                    sb2.append(message.arg1);
                    break;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j10) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt("data_calling_uid", Binder.getCallingUid());
            int callingPid = Binder.getCallingPid();
            if (callingPid > 0) {
                data.putInt("data_calling_pid", callingPid);
            } else if (!data.containsKey("data_calling_pid")) {
                data.putInt("data_calling_pid", -1);
            }
            return super.sendMessageAtTime(message, j10);
        }
    }

    public void a(String str, f fVar, IBinder iBinder, Bundle bundle) {
        List<androidx.core.util.k<IBinder, Bundle>> arrayList = fVar.f50738g.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        for (androidx.core.util.k<IBinder, Bundle> kVar : arrayList) {
            if (iBinder == kVar.f4741a && t1.b.a(bundle, kVar.f4742b)) {
                return;
            }
        }
        arrayList.add(new androidx.core.util.k<>(iBinder, bundle));
        fVar.f50738g.put(str, arrayList);
        t(str, fVar, bundle, null);
        this.f50712e = fVar;
        q(str, bundle);
        this.f50712e = null;
    }

    public List<MediaBrowserCompat.MediaItem> b(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void c(Context context) {
        attachBaseContext(context);
    }

    public final Bundle d() {
        return this.f50708a.a();
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @n0
    public final e.b e() {
        return this.f50708a.b();
    }

    @p0
    public MediaSessionCompat.Token f() {
        return this.f50714g;
    }

    public boolean g(String str, int i10) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i10)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public void h(@n0 String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.f50708a.f(str, null);
    }

    public void i(@n0 String str, @n0 Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.f50708a.f(str, bundle);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void j(@n0 e.b bVar, @n0 String str, @n0 Bundle bundle) {
        if (bVar == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        }
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.f50708a.e(bVar, str, bundle);
    }

    public void k(@n0 String str, Bundle bundle, @n0 m<Bundle> mVar) {
        mVar.h(null);
    }

    @p0
    public abstract e l(@n0 String str, int i10, @p0 Bundle bundle);

    public abstract void m(@n0 String str, @n0 m<List<MediaBrowserCompat.MediaItem>> mVar);

    public void n(@n0 String str, @n0 m<List<MediaBrowserCompat.MediaItem>> mVar, @n0 Bundle bundle) {
        mVar.k(1);
        m(str, mVar);
    }

    public void o(String str, @n0 m<MediaBrowserCompat.MediaItem> mVar) {
        mVar.k(2);
        mVar.j(null);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f50708a.d(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            this.f50708a = new k();
        } else if (i10 >= 26) {
            this.f50708a = new j();
        } else if (i10 >= 23) {
            this.f50708a = new i();
        } else {
            this.f50708a = new h();
        }
        this.f50708a.c();
    }

    public void p(@n0 String str, Bundle bundle, @n0 m<List<MediaBrowserCompat.MediaItem>> mVar) {
        mVar.k(4);
        mVar.j(null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void q(String str, Bundle bundle) {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void r(String str) {
    }

    public void s(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        C0574d c0574d = new C0574d(str, resultReceiver);
        this.f50712e = fVar;
        k(str, bundle, c0574d);
        this.f50712e = null;
        if (c0574d.d()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    public void t(String str, f fVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, fVar, str, bundle, bundle2);
        this.f50712e = fVar;
        if (bundle == null) {
            m(str, aVar);
        } else {
            n(str, aVar, bundle);
        }
        this.f50712e = null;
        if (aVar.d()) {
            return;
        }
        throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + fVar.f50732a + " id=" + str);
    }

    public void u(String str, f fVar, ResultReceiver resultReceiver) {
        b bVar = new b(str, resultReceiver);
        this.f50712e = fVar;
        o(str, bVar);
        this.f50712e = null;
        if (bVar.d()) {
            return;
        }
        throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
    }

    public void v(String str, Bundle bundle, f fVar, ResultReceiver resultReceiver) {
        c cVar = new c(str, resultReceiver);
        this.f50712e = fVar;
        p(str, bundle, cVar);
        this.f50712e = null;
        if (cVar.d()) {
            return;
        }
        throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
    }

    public boolean w(String str, f fVar, IBinder iBinder) {
        boolean z10 = false;
        try {
            if (iBinder == null) {
                return fVar.f50738g.remove(str) != null;
            }
            List<androidx.core.util.k<IBinder, Bundle>> list = fVar.f50738g.get(str);
            if (list != null) {
                Iterator<androidx.core.util.k<IBinder, Bundle>> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (iBinder == it2.next().f4741a) {
                        it2.remove();
                        z10 = true;
                    }
                }
                if (list.size() == 0) {
                    fVar.f50738g.remove(str);
                }
            }
            return z10;
        } finally {
            this.f50712e = fVar;
            r(str);
            this.f50712e = null;
        }
    }

    public void x(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null");
        }
        if (this.f50714g != null) {
            throw new IllegalStateException("The session token has already been set");
        }
        this.f50714g = token;
        this.f50708a.g(token);
    }
}
