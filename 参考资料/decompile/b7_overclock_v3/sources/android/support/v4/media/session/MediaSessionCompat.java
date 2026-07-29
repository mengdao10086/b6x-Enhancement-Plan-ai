package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.RemoteControlClient;
import android.media.VolumeProvider;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.b;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.RestrictTo;
import f0.k;
import g.b0;
import g.n0;
import g.p0;
import g.v0;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import t1.e;
import t1.i;

/* JADX INFO: loaded from: classes2.dex */
public class MediaSessionCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String A = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String B = "android.support.v4.media.session.action.ARGUMENT_QUERY";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String C = "android.support.v4.media.session.action.ARGUMENT_URI";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String D = "android.support.v4.media.session.action.ARGUMENT_RATING";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String E = "android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String F = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String G = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String H = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String I = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String J = "android.support.v4.media.session.TOKEN";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String K = "android.support.v4.media.session.EXTRA_BINDER";

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String L = "android.support.v4.media.session.SESSION_TOKEN2";
    public static final int M = 320;
    public static final String N = "data_calling_pkg";
    public static final String O = "data_calling_pid";
    public static final String P = "data_calling_uid";
    public static final String Q = "data_extras";
    public static int R = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f1052d = "MediaSessionCompat";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final int f1053e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final int f1054f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f1055g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f1056h = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f1057i = "android.support.v4.media.session.action.SKIP_AD";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f1058j = "android.support.v4.media.session.action.FOLLOW";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f1059k = "android.support.v4.media.session.action.UNFOLLOW";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f1060l = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f1061m = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f1062n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f1063o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f1064p = 2;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1065q = "android.support.v4.media.session.action.PLAY_FROM_URI";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1066r = "android.support.v4.media.session.action.PREPARE";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1067s = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1068t = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1069u = "android.support.v4.media.session.action.PREPARE_FROM_URI";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1070v = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1071w = "android.support.v4.media.session.action.SET_REPEAT_MODE";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1072x = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1073y = "android.support.v4.media.session.action.SET_RATING";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String f1074z = "android.support.v4.media.session.action.SET_PLAYBACK_SPEED";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f1075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaControllerCompat f1076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<j> f1077c;

    @SuppressLint({"BanParcelableUsage"})
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f1078d = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaDescriptionCompat f1079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public MediaSession.QueueItem f1081c;

        public class a implements Parcelable.Creator<QueueItem> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i10) {
                return new QueueItem[i10];
            }
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j10) {
            this(null, mediaDescriptionCompat, j10);
        }

        public static QueueItem a(Object obj) {
            if (obj == null) {
                return null;
            }
            MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
            return new QueueItem(queueItem, MediaDescriptionCompat.a(queueItem.getDescription()), queueItem.getQueueId());
        }

        public static List<QueueItem> b(List<?> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
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

        public MediaDescriptionCompat e() {
            return this.f1079a;
        }

        public long g() {
            return this.f1080b;
        }

        public Object j() {
            MediaSession.QueueItem queueItem = this.f1081c;
            if (queueItem != null) {
                return queueItem;
            }
            MediaSession.QueueItem queueItem2 = new MediaSession.QueueItem((MediaDescription) this.f1079a.s(), this.f1080b);
            this.f1081c = queueItem2;
            return queueItem2;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f1079a + ", Id=" + this.f1080b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            this.f1079a.writeToParcel(parcel, i10);
            parcel.writeLong(this.f1080b);
        }

        public QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j10) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j10 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.f1079a = mediaDescriptionCompat;
            this.f1080b = j10;
            this.f1081c = queueItem;
        }

        public QueueItem(Parcel parcel) {
            this.f1079a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f1080b = parcel.readLong();
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f1083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f1084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @b0("mLock")
        public android.support.v4.media.session.b f1085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @b0("mLock")
        public i2.e f1086d;

        public class a implements Parcelable.Creator<Token> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i10) {
                return new Token[i10];
            }
        }

        public Token(Object obj) {
            this(obj, null, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static Token a(Bundle bundle) {
            if (bundle == null) {
                return null;
            }
            android.support.v4.media.session.b bVarQ0 = b.AbstractBinderC0023b.Q0(k.a(bundle, MediaSessionCompat.K));
            i2.e eVarC = i2.c.c(bundle, MediaSessionCompat.L);
            Token token = (Token) bundle.getParcelable(MediaSessionCompat.J);
            if (token == null) {
                return null;
            }
            return new Token(token.f1084b, bVarQ0, eVarC);
        }

        public static Token b(Object obj) {
            return e(obj, null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Token e(Object obj, android.support.v4.media.session.b bVar) {
            if (obj == null) {
                return null;
            }
            if (obj instanceof MediaSession.Token) {
                return new Token(obj, bVar);
            }
            throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public void C(i2.e eVar) {
            synchronized (this.f1083a) {
                this.f1086d = eVar;
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public Bundle F() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaSessionCompat.J, this);
            synchronized (this.f1083a) {
                android.support.v4.media.session.b bVar = this.f1085c;
                if (bVar != null) {
                    k.b(bundle, MediaSessionCompat.K, bVar.asBinder());
                }
                i2.e eVar = this.f1086d;
                if (eVar != null) {
                    i2.c.e(bundle, MediaSessionCompat.L, eVar);
                }
            }
            return bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f1084b;
            if (obj2 == null) {
                return token.f1084b == null;
            }
            Object obj3 = token.f1084b;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public android.support.v4.media.session.b g() {
            android.support.v4.media.session.b bVar;
            synchronized (this.f1083a) {
                bVar = this.f1085c;
            }
            return bVar;
        }

        public int hashCode() {
            Object obj = this.f1084b;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public i2.e j() {
            i2.e eVar;
            synchronized (this.f1083a) {
                eVar = this.f1086d;
            }
            return eVar;
        }

        public Object s() {
            return this.f1084b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeParcelable((Parcelable) this.f1084b, i10);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public void z(android.support.v4.media.session.b bVar) {
            synchronized (this.f1083a) {
                this.f1085c = bVar;
            }
        }

        public Token(Object obj, android.support.v4.media.session.b bVar) {
            this(obj, bVar, null);
        }

        public Token(Object obj, android.support.v4.media.session.b bVar, i2.e eVar) {
            this.f1083a = new Object();
            this.f1084b = obj;
            this.f1085c = bVar;
            this.f1086d = eVar;
        }
    }

    public class a extends b {
        public a() {
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1090c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @b0("mLock")
        public a f1092e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f1088a = new Object();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaSession.Callback f1089b = new C0020b();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @b0("mLock")
        public WeakReference<c> f1091d = new WeakReference<>(null);

        public class a extends Handler {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f1093b = 1;

            public a(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                c cVar;
                b bVar;
                a aVar;
                if (message.what == 1) {
                    synchronized (b.this.f1088a) {
                        cVar = b.this.f1091d.get();
                        bVar = b.this;
                        aVar = bVar.f1092e;
                    }
                    if (cVar == null || bVar != cVar.k() || aVar == null) {
                        return;
                    }
                    cVar.t((e.b) message.obj);
                    b.this.a(cVar, aVar);
                    cVar.t(null);
                }
            }
        }

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$b$b, reason: collision with other inner class name */
        @v0(21)
        public class C0020b extends MediaSession.Callback {
            public C0020b() {
            }

            public final void a(c cVar) {
                cVar.t(null);
            }

            public final f b() {
                f fVar;
                synchronized (b.this.f1088a) {
                    fVar = (f) b.this.f1091d.get();
                }
                if (b.this == fVar.k()) {
                    return fVar;
                }
                return null;
            }

            public void c(Rating rating, Bundle bundle) {
            }

            public final void d(c cVar) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String strE = cVar.e();
                if (TextUtils.isEmpty(strE)) {
                    strE = e.b.f50833b;
                }
                cVar.t(new e.b(strE, -1, -1));
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                d(fVarB);
                try {
                    QueueItem queueItem = null;
                    IBinder iBinderAsBinder = null;
                    queueItem = null;
                    if (str.equals(MediaControllerCompat.f1003e)) {
                        Bundle bundle2 = new Bundle();
                        Token tokenA = fVarB.a();
                        android.support.v4.media.session.b bVarG = tokenA.g();
                        if (bVarG != null) {
                            iBinderAsBinder = bVarG.asBinder();
                        }
                        k.b(bundle2, MediaSessionCompat.K, iBinderAsBinder);
                        i2.c.e(bundle2, MediaSessionCompat.L, tokenA.j());
                        resultReceiver.send(0, bundle2);
                    } else if (str.equals(MediaControllerCompat.f1004f)) {
                        b.this.b((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.f1008j));
                    } else if (str.equals(MediaControllerCompat.f1005g)) {
                        b.this.c((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.f1008j), bundle.getInt(MediaControllerCompat.f1009k));
                    } else if (str.equals(MediaControllerCompat.f1006h)) {
                        b.this.q((MediaDescriptionCompat) bundle.getParcelable(MediaControllerCompat.f1008j));
                    } else if (!str.equals(MediaControllerCompat.f1007i)) {
                        b.this.d(str, bundle, resultReceiver);
                    } else if (fVarB.f1105h != null) {
                        int i10 = bundle.getInt(MediaControllerCompat.f1009k, -1);
                        if (i10 >= 0 && i10 < fVarB.f1105h.size()) {
                            queueItem = fVarB.f1105h.get(i10);
                        }
                        if (queueItem != null) {
                            b.this.q(queueItem.e());
                        }
                    }
                } catch (BadParcelableException unused) {
                }
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCustomAction(String str, Bundle bundle) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                d(fVarB);
                try {
                    if (str.equals(MediaSessionCompat.f1065q)) {
                        Uri uri = (Uri) bundle.getParcelable(MediaSessionCompat.C);
                        Bundle bundle2 = bundle.getBundle(MediaSessionCompat.F);
                        MediaSessionCompat.c(bundle2);
                        b.this.l(uri, bundle2);
                    } else if (str.equals(MediaSessionCompat.f1066r)) {
                        b.this.m();
                    } else if (str.equals(MediaSessionCompat.f1067s)) {
                        String string = bundle.getString(MediaSessionCompat.A);
                        Bundle bundle3 = bundle.getBundle(MediaSessionCompat.F);
                        MediaSessionCompat.c(bundle3);
                        b.this.n(string, bundle3);
                    } else if (str.equals(MediaSessionCompat.f1068t)) {
                        String string2 = bundle.getString(MediaSessionCompat.B);
                        Bundle bundle4 = bundle.getBundle(MediaSessionCompat.F);
                        MediaSessionCompat.c(bundle4);
                        b.this.o(string2, bundle4);
                    } else if (str.equals(MediaSessionCompat.f1069u)) {
                        Uri uri2 = (Uri) bundle.getParcelable(MediaSessionCompat.C);
                        Bundle bundle5 = bundle.getBundle(MediaSessionCompat.F);
                        MediaSessionCompat.c(bundle5);
                        b.this.p(uri2, bundle5);
                    } else if (str.equals(MediaSessionCompat.f1070v)) {
                        b.this.u(bundle.getBoolean(MediaSessionCompat.G));
                    } else if (str.equals(MediaSessionCompat.f1071w)) {
                        b.this.y(bundle.getInt(MediaSessionCompat.H));
                    } else if (str.equals(MediaSessionCompat.f1072x)) {
                        b.this.z(bundle.getInt(MediaSessionCompat.I));
                    } else if (str.equals(MediaSessionCompat.f1073y)) {
                        RatingCompat ratingCompat = (RatingCompat) bundle.getParcelable(MediaSessionCompat.D);
                        Bundle bundle6 = bundle.getBundle(MediaSessionCompat.F);
                        MediaSessionCompat.c(bundle6);
                        b.this.x(ratingCompat, bundle6);
                    } else if (str.equals(MediaSessionCompat.f1074z)) {
                        b.this.v(bundle.getFloat(MediaSessionCompat.E, 1.0f));
                    } else {
                        b.this.e(str, bundle);
                    }
                } catch (BadParcelableException unused) {
                }
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onFastForward() {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.f();
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                f fVarB = b();
                if (fVarB == null) {
                    return false;
                }
                d(fVarB);
                boolean zG = b.this.g(intent);
                a(fVarB);
                return zG || super.onMediaButtonEvent(intent);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPause() {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.h();
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlay() {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.i();
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromMediaId(String str, Bundle bundle) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                d(fVarB);
                b.this.j(str, bundle);
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromSearch(String str, Bundle bundle) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                d(fVarB);
                b.this.k(str, bundle);
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            @v0(23)
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                d(fVarB);
                b.this.l(uri, bundle);
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            @v0(24)
            public void onPrepare() {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.m();
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            @v0(24)
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                d(fVarB);
                b.this.n(str, bundle);
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            @v0(24)
            public void onPrepareFromSearch(String str, Bundle bundle) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                d(fVarB);
                b.this.o(str, bundle);
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            @v0(24)
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                MediaSessionCompat.c(bundle);
                d(fVarB);
                b.this.p(uri, bundle);
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onRewind() {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.s();
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSeekTo(long j10) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.t(j10);
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            @v0(29)
            public void onSetPlaybackSpeed(float f10) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.v(f10);
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetRating(Rating rating) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.w(RatingCompat.a(rating));
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToNext() {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.A();
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToPrevious() {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.B();
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToQueueItem(long j10) {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.C(j10);
                a(fVarB);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onStop() {
                f fVarB = b();
                if (fVarB == null) {
                    return;
                }
                d(fVarB);
                b.this.D();
                a(fVarB);
            }
        }

        public void A() {
        }

        public void B() {
        }

        public void C(long j10) {
        }

        public void D() {
        }

        public void E(c cVar, Handler handler) {
            synchronized (this.f1088a) {
                this.f1091d = new WeakReference<>(cVar);
                a aVar = this.f1092e;
                a aVar2 = null;
                if (aVar != null) {
                    aVar.removeCallbacksAndMessages(null);
                }
                if (cVar != null && handler != null) {
                    aVar2 = new a(handler.getLooper());
                }
                this.f1092e = aVar2;
            }
        }

        public void a(c cVar, Handler handler) {
            if (this.f1090c) {
                this.f1090c = false;
                handler.removeMessages(1);
                PlaybackStateCompat playbackStateCompatD = cVar.d();
                long jB = playbackStateCompatD == null ? 0L : playbackStateCompatD.b();
                boolean z10 = playbackStateCompatD != null && playbackStateCompatD.V() == 3;
                boolean z11 = (516 & jB) != 0;
                boolean z12 = (jB & 514) != 0;
                if (z10 && z12) {
                    h();
                } else {
                    if (z10 || !z11) {
                        return;
                    }
                    i();
                }
            }
        }

        public void b(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void c(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
        }

        public void d(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void e(String str, Bundle bundle) {
        }

        public void f() {
        }

        public boolean g(Intent intent) {
            c cVar;
            a aVar;
            KeyEvent keyEvent;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.f1088a) {
                cVar = this.f1091d.get();
                aVar = this.f1092e;
            }
            if (cVar == null || aVar == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            e.b bVarV = cVar.v();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                a(cVar, aVar);
                return false;
            }
            if (keyEvent.getRepeatCount() != 0) {
                a(cVar, aVar);
            } else if (this.f1090c) {
                aVar.removeMessages(1);
                this.f1090c = false;
                PlaybackStateCompat playbackStateCompatD = cVar.d();
                if (((playbackStateCompatD == null ? 0L : playbackStateCompatD.b()) & 32) != 0) {
                    A();
                }
            } else {
                this.f1090c = true;
                aVar.sendMessageDelayed(aVar.obtainMessage(1, bVarV), ViewConfiguration.getDoubleTapTimeout());
            }
            return true;
        }

        public void h() {
        }

        public void i() {
        }

        public void j(String str, Bundle bundle) {
        }

        public void k(String str, Bundle bundle) {
        }

        public void l(Uri uri, Bundle bundle) {
        }

        public void m() {
        }

        public void n(String str, Bundle bundle) {
        }

        public void o(String str, Bundle bundle) {
        }

        public void p(Uri uri, Bundle bundle) {
        }

        public void q(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        @Deprecated
        public void r(int i10) {
        }

        public void s() {
        }

        public void t(long j10) {
        }

        public void u(boolean z10) {
        }

        public void v(float f10) {
        }

        public void w(RatingCompat ratingCompat) {
        }

        public void x(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void y(int i10) {
        }

        public void z(int i10) {
        }
    }

    public interface c {
        Token a();

        void b(int i10);

        void c(String str, Bundle bundle);

        PlaybackStateCompat d();

        String e();

        void f(PendingIntent pendingIntent);

        void g(b bVar, Handler handler);

        void h(int i10);

        void i(CharSequence charSequence);

        boolean isActive();

        void j(int i10);

        b k();

        void l(MediaMetadataCompat mediaMetadataCompat);

        void m(PendingIntent pendingIntent);

        void n(int i10);

        void o(List<QueueItem> list);

        Object p();

        void q(boolean z10);

        void r(PlaybackStateCompat playbackStateCompat);

        void release();

        Object s();

        void setExtras(Bundle bundle);

        void t(e.b bVar);

        void u(boolean z10);

        e.b v();

        void w(t1.i iVar);

        void z(int i10);
    }

    @v0(18)
    public static class d extends i {
        public static boolean H = true;

        public class a implements RemoteControlClient.OnPlaybackPositionUpdateListener {
            public a() {
            }

            @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
            public void onPlaybackPositionUpdate(long j10) {
                d.this.D(18, -1, -1, Long.valueOf(j10), null);
            }
        }

        public d(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, i2.e eVar, Bundle bundle) {
            super(context, str, componentName, pendingIntent, eVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i
        public int C(long j10) {
            int iC = super.C(j10);
            return (j10 & 256) != 0 ? iC | 256 : iC;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i
        public void E(PendingIntent pendingIntent, ComponentName componentName) {
            if (H) {
                try {
                    this.f1122i.registerMediaButtonEventReceiver(pendingIntent);
                } catch (NullPointerException unused) {
                    H = false;
                }
            }
            if (H) {
                return;
            }
            super.E(pendingIntent, componentName);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i
        public void Q(PlaybackStateCompat playbackStateCompat) {
            long jU = playbackStateCompat.U();
            float fS = playbackStateCompat.S();
            long jM = playbackStateCompat.M();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (playbackStateCompat.V() == 3) {
                long j10 = 0;
                if (jU > 0) {
                    if (jM > 0) {
                        j10 = jElapsedRealtime - jM;
                        if (fS > 0.0f && fS != 1.0f) {
                            j10 = (long) (j10 * fS);
                        }
                    }
                    jU += j10;
                }
            }
            this.f1123j.setPlaybackState(B(playbackStateCompat.V()), jU, fS);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i
        public void S(PendingIntent pendingIntent, ComponentName componentName) {
            if (H) {
                this.f1122i.unregisterMediaButtonEventReceiver(pendingIntent);
            } else {
                super.S(pendingIntent, componentName);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i, android.support.v4.media.session.MediaSessionCompat.c
        public void g(b bVar, Handler handler) {
            super.g(bVar, handler);
            if (bVar == null) {
                this.f1123j.setPlaybackPositionUpdateListener(null);
            } else {
                this.f1123j.setPlaybackPositionUpdateListener(new a());
            }
        }
    }

    @v0(19)
    public static class e extends d {

        public class a implements RemoteControlClient.OnMetadataUpdateListener {
            public a() {
            }

            @Override // android.media.RemoteControlClient.OnMetadataUpdateListener
            public void onMetadataUpdate(int i10, Object obj) {
                if (i10 == 268435457 && (obj instanceof Rating)) {
                    e.this.D(19, -1, -1, RatingCompat.a(obj), null);
                }
            }
        }

        public e(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, i2.e eVar, Bundle bundle) {
            super(context, str, componentName, pendingIntent, eVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d, android.support.v4.media.session.MediaSessionCompat.i
        public int C(long j10) {
            int iC = super.C(j10);
            return (j10 & 128) != 0 ? iC | 512 : iC;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.d, android.support.v4.media.session.MediaSessionCompat.i, android.support.v4.media.session.MediaSessionCompat.c
        public void g(b bVar, Handler handler) {
            super.g(bVar, handler);
            if (bVar == null) {
                this.f1123j.setMetadataUpdateListener(null);
            } else {
                this.f1123j.setMetadataUpdateListener(new a());
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.i
        public RemoteControlClient.MetadataEditor y(Bundle bundle) {
            RemoteControlClient.MetadataEditor metadataEditorY = super.y(bundle);
            PlaybackStateCompat playbackStateCompat = this.f1133t;
            if (((playbackStateCompat == null ? 0L : playbackStateCompat.b()) & 128) != 0) {
                metadataEditorY.addEditableKey(268435457);
            }
            if (bundle == null) {
                return metadataEditorY;
            }
            if (bundle.containsKey(MediaMetadataCompat.f971n)) {
                metadataEditorY.putLong(8, bundle.getLong(MediaMetadataCompat.f971n));
            }
            if (bundle.containsKey(MediaMetadataCompat.f984y)) {
                metadataEditorY.putObject(101, (Object) bundle.getParcelable(MediaMetadataCompat.f984y));
            }
            if (bundle.containsKey(MediaMetadataCompat.f983x)) {
                metadataEditorY.putObject(268435457, (Object) bundle.getParcelable(MediaMetadataCompat.f983x));
            }
            return metadataEditorY;
        }
    }

    @v0(28)
    public static class g extends f {
        public g(MediaSession mediaSession, i2.e eVar, Bundle bundle) {
            super(mediaSession, eVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.f, android.support.v4.media.session.MediaSessionCompat.c
        public void t(e.b bVar) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.f, android.support.v4.media.session.MediaSessionCompat.c
        @n0
        public final e.b v() {
            return new e.b(this.f1098a.getCurrentControllerInfo());
        }

        public g(Object obj) {
            super(obj);
        }
    }

    @v0(29)
    public static class h extends g {
        public h(MediaSession mediaSession, i2.e eVar, Bundle bundle) {
            super(mediaSession, eVar, bundle);
        }

        public h(Object obj) {
            super(obj);
            this.f1101d = ((MediaSession) obj).getController().getSessionInfo();
        }
    }

    public static class i implements c {
        public static final int G = 0;
        public int A;
        public Bundle B;
        public int C;
        public int D;
        public t1.i E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f1114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ComponentName f1115b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final PendingIntent f1116c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f1117d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Token f1118e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f1119f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Bundle f1120g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f1121h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final AudioManager f1122i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final RemoteControlClient f1123j;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public d f1126m;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public volatile b f1129p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public e.b f1130q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public MediaMetadataCompat f1132s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public PlaybackStateCompat f1133t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public PendingIntent f1134u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public List<QueueItem> f1135v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public CharSequence f1136w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f1137x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public boolean f1138y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f1139z;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Object f1124k = new Object();

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final RemoteCallbackList<android.support.v4.media.session.a> f1125l = new RemoteCallbackList<>();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f1127n = false;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f1128o = false;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f1131r = 3;
        public i.c F = new a();

        public class a extends i.c {
            public a() {
            }

            @Override // t1.i.c
            public void a(t1.i iVar) {
                if (i.this.E != iVar) {
                    return;
                }
                i iVar2 = i.this;
                i.this.P(new ParcelableVolumeInfo(iVar2.C, iVar2.D, iVar.c(), iVar.b(), iVar.a()));
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f1141a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Bundle f1142b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final ResultReceiver f1143c;

            public b(String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.f1141a = str;
                this.f1142b = bundle;
                this.f1143c = resultReceiver;
            }
        }

        public class c extends b.AbstractBinderC0023b {
            public c() {
            }

            @Override // android.support.v4.media.session.b
            public void B(String str, Bundle bundle) throws RemoteException {
                X0(20, str, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void B0(long j10) {
                V0(11, Long.valueOf(j10));
            }

            @Override // android.support.v4.media.session.b
            public void C(android.support.v4.media.session.a aVar) {
                if (i.this.f1127n) {
                    try {
                        aVar.m0();
                    } catch (Exception unused) {
                    }
                } else {
                    i.this.f1125l.register(aVar, new e.b(i.this.A(Binder.getCallingUid()), Binder.getCallingPid(), Binder.getCallingUid()));
                }
            }

            @Override // android.support.v4.media.session.b
            public void C0(boolean z10) throws RemoteException {
            }

            @Override // android.support.v4.media.session.b
            public boolean D() {
                return false;
            }

            @Override // android.support.v4.media.session.b
            public ParcelableVolumeInfo D0() {
                int i10;
                int i11;
                int i12;
                int streamMaxVolume;
                int streamVolume;
                synchronized (i.this.f1124k) {
                    i iVar = i.this;
                    i10 = iVar.C;
                    i11 = iVar.D;
                    t1.i iVar2 = iVar.E;
                    i12 = 2;
                    if (i10 == 2) {
                        int iC = iVar2.c();
                        int iB = iVar2.b();
                        streamVolume = iVar2.a();
                        streamMaxVolume = iB;
                        i12 = iC;
                    } else {
                        streamMaxVolume = iVar.f1122i.getStreamMaxVolume(i11);
                        streamVolume = i.this.f1122i.getStreamVolume(i11);
                    }
                }
                return new ParcelableVolumeInfo(i10, i11, i12, streamMaxVolume, streamVolume);
            }

            @Override // android.support.v4.media.session.b
            public void E(RatingCompat ratingCompat) throws RemoteException {
                V0(19, ratingCompat);
            }

            @Override // android.support.v4.media.session.b
            public void F(int i10, int i11, String str) {
                i.this.R(i10, i11);
            }

            @Override // android.support.v4.media.session.b
            public void G(Uri uri, Bundle bundle) throws RemoteException {
                X0(6, uri, bundle);
            }

            @Override // android.support.v4.media.session.b
            public boolean H() {
                return true;
            }

            @Override // android.support.v4.media.session.b
            public PendingIntent I() {
                PendingIntent pendingIntent;
                synchronized (i.this.f1124k) {
                    pendingIntent = i.this.f1134u;
                }
                return pendingIntent;
            }

            @Override // android.support.v4.media.session.b
            public void K(String str, Bundle bundle) throws RemoteException {
                X0(5, str, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void T(String str, Bundle bundle) throws RemoteException {
                X0(4, str, bundle);
            }

            public void T0(int i10) {
                i.this.D(i10, 0, 0, null, null);
            }

            @Override // android.support.v4.media.session.b
            public void U(android.support.v4.media.session.a aVar) {
                i.this.f1125l.unregister(aVar);
            }

            public void U0(int i10, int i11) {
                i.this.D(i10, i11, 0, null, null);
            }

            @Override // android.support.v4.media.session.b
            public void V(String str, Bundle bundle) throws RemoteException {
                X0(8, str, bundle);
            }

            public void V0(int i10, Object obj) {
                i.this.D(i10, 0, 0, obj, null);
            }

            public void W0(int i10, Object obj, int i11) {
                i.this.D(i10, i11, 0, obj, null);
            }

            @Override // android.support.v4.media.session.b
            public void X(String str, Bundle bundle) throws RemoteException {
                X0(9, str, bundle);
            }

            public void X0(int i10, Object obj, Bundle bundle) {
                i.this.D(i10, 0, 0, obj, bundle);
            }

            @Override // android.support.v4.media.session.b
            public void Z() throws RemoteException {
                T0(16);
            }

            @Override // android.support.v4.media.session.b
            public void a0(Uri uri, Bundle bundle) throws RemoteException {
                X0(10, uri, bundle);
            }

            @Override // android.support.v4.media.session.b
            public PlaybackStateCompat d() {
                PlaybackStateCompat playbackStateCompat;
                MediaMetadataCompat mediaMetadataCompat;
                synchronized (i.this.f1124k) {
                    i iVar = i.this;
                    playbackStateCompat = iVar.f1133t;
                    mediaMetadataCompat = iVar.f1132s;
                }
                return MediaSessionCompat.k(playbackStateCompat, mediaMetadataCompat);
            }

            @Override // android.support.v4.media.session.b
            public long e() {
                long j10;
                synchronized (i.this.f1124k) {
                    j10 = i.this.f1131r;
                }
                return j10;
            }

            @Override // android.support.v4.media.session.b
            public void f() throws RemoteException {
                T0(3);
            }

            @Override // android.support.v4.media.session.b
            public void f0(float f10) throws RemoteException {
                V0(32, Float.valueOf(f10));
            }

            @Override // android.support.v4.media.session.b
            public void g(long j10) throws RemoteException {
                V0(18, Long.valueOf(j10));
            }

            @Override // android.support.v4.media.session.b
            public boolean g0(KeyEvent keyEvent) {
                V0(21, keyEvent);
                return true;
            }

            @Override // android.support.v4.media.session.b
            public Bundle getExtras() {
                Bundle bundle;
                synchronized (i.this.f1124k) {
                    bundle = i.this.B;
                }
                return bundle;
            }

            @Override // android.support.v4.media.session.b
            public String h() {
                return i.this.f1121h;
            }

            @Override // android.support.v4.media.session.b
            public void i() throws RemoteException {
                T0(7);
            }

            @Override // android.support.v4.media.session.b
            public void j(int i10) throws RemoteException {
                U0(23, i10);
            }

            @Override // android.support.v4.media.session.b
            public void j0(int i10, int i11, String str) {
                i.this.x(i10, i11);
            }

            @Override // android.support.v4.media.session.b
            public int k() {
                return i.this.f1139z;
            }

            @Override // android.support.v4.media.session.b
            public void l0(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                X0(31, ratingCompat, bundle);
            }

            @Override // android.support.v4.media.session.b
            public String m() {
                return i.this.f1119f;
            }

            @Override // android.support.v4.media.session.b
            public void n0(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
                W0(26, mediaDescriptionCompat, i10);
            }

            @Override // android.support.v4.media.session.b
            public void next() throws RemoteException {
                T0(14);
            }

            @Override // android.support.v4.media.session.b
            public void o(MediaDescriptionCompat mediaDescriptionCompat) {
                V0(27, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.b
            public void p(MediaDescriptionCompat mediaDescriptionCompat) {
                V0(25, mediaDescriptionCompat);
            }

            @Override // android.support.v4.media.session.b
            public void pause() throws RemoteException {
                T0(12);
            }

            @Override // android.support.v4.media.session.b
            public void previous() throws RemoteException {
                T0(15);
            }

            @Override // android.support.v4.media.session.b
            public int q() {
                return i.this.f1137x;
            }

            @Override // android.support.v4.media.session.b
            public CharSequence r() {
                return i.this.f1136w;
            }

            @Override // android.support.v4.media.session.b
            public MediaMetadataCompat s() {
                return i.this.f1132s;
            }

            @Override // android.support.v4.media.session.b
            public void s0(int i10) {
                U0(28, i10);
            }

            @Override // android.support.v4.media.session.b
            public void stop() throws RemoteException {
                T0(13);
            }

            @Override // android.support.v4.media.session.b
            public Bundle t() {
                if (i.this.f1120g == null) {
                    return null;
                }
                return new Bundle(i.this.f1120g);
            }

            @Override // android.support.v4.media.session.b
            public void u(boolean z10) throws RemoteException {
                V0(29, Boolean.valueOf(z10));
            }

            @Override // android.support.v4.media.session.b
            public int w() {
                return i.this.A;
            }

            @Override // android.support.v4.media.session.b
            public void w0(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                V0(1, new b(str, bundle, resultReceiverWrapper == null ? null : resultReceiverWrapper.f1082a));
            }

            @Override // android.support.v4.media.session.b
            public boolean x() {
                return i.this.f1138y;
            }

            @Override // android.support.v4.media.session.b
            public List<QueueItem> y() {
                List<QueueItem> list;
                synchronized (i.this.f1124k) {
                    list = i.this.f1135v;
                }
                return list;
            }

            @Override // android.support.v4.media.session.b
            public void y0() throws RemoteException {
                T0(17);
            }

            @Override // android.support.v4.media.session.b
            public void z(int i10) throws RemoteException {
                U0(30, i10);
            }
        }

        public class d extends Handler {
            public static final int A = 25;
            public static final int B = 26;
            public static final int C = 27;
            public static final int D = 28;
            public static final int E = 29;
            public static final int F = 30;
            public static final int G = 127;
            public static final int H = 126;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f1145b = 1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f1146c = 2;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f1147d = 3;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final int f1148e = 4;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final int f1149f = 5;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final int f1150g = 6;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static final int f1151h = 7;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public static final int f1152i = 8;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public static final int f1153j = 9;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public static final int f1154k = 10;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public static final int f1155l = 11;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public static final int f1156m = 12;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final int f1157n = 13;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public static final int f1158o = 14;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public static final int f1159p = 15;

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public static final int f1160q = 16;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public static final int f1161r = 17;

            /* JADX INFO: renamed from: s, reason: collision with root package name */
            public static final int f1162s = 18;

            /* JADX INFO: renamed from: t, reason: collision with root package name */
            public static final int f1163t = 19;

            /* JADX INFO: renamed from: u, reason: collision with root package name */
            public static final int f1164u = 31;

            /* JADX INFO: renamed from: v, reason: collision with root package name */
            public static final int f1165v = 32;

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public static final int f1166w = 20;

            /* JADX INFO: renamed from: x, reason: collision with root package name */
            public static final int f1167x = 21;

            /* JADX INFO: renamed from: y, reason: collision with root package name */
            public static final int f1168y = 22;

            /* JADX INFO: renamed from: z, reason: collision with root package name */
            public static final int f1169z = 23;

            public d(Looper looper) {
                super(looper);
            }

            public final void a(KeyEvent keyEvent, b bVar) {
                if (keyEvent == null || keyEvent.getAction() != 0) {
                    return;
                }
                PlaybackStateCompat playbackStateCompat = i.this.f1133t;
                long jB = playbackStateCompat == null ? 0L : playbackStateCompat.b();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 126) {
                    if ((jB & 4) != 0) {
                        bVar.i();
                    }
                    return;
                }
                if (keyCode == 127) {
                    if ((jB & 2) != 0) {
                        bVar.h();
                        return;
                    }
                    return;
                }
                switch (keyCode) {
                    case 86:
                        if ((jB & 1) != 0) {
                            bVar.D();
                        }
                        break;
                    case 87:
                        if ((jB & 32) != 0) {
                            bVar.A();
                        }
                        break;
                    case 88:
                        if ((jB & 16) != 0) {
                            bVar.B();
                        }
                        break;
                    case 89:
                        if ((jB & 8) != 0) {
                            bVar.s();
                        }
                        break;
                    case 90:
                        if ((jB & 64) != 0) {
                            bVar.f();
                        }
                        break;
                }
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar = i.this.f1129p;
                if (bVar == null) {
                    return;
                }
                Bundle data = message.getData();
                MediaSessionCompat.c(data);
                i.this.t(new e.b(data.getString(MediaSessionCompat.N), data.getInt("data_calling_pid"), data.getInt("data_calling_uid")));
                Bundle bundle = data.getBundle(MediaSessionCompat.Q);
                MediaSessionCompat.c(bundle);
                try {
                    switch (message.what) {
                        case 1:
                            b bVar2 = (b) message.obj;
                            bVar.d(bVar2.f1141a, bVar2.f1142b, bVar2.f1143c);
                            break;
                        case 2:
                            i.this.x(message.arg1, 0);
                            break;
                        case 3:
                            bVar.m();
                            break;
                        case 4:
                            bVar.n((String) message.obj, bundle);
                            break;
                        case 5:
                            bVar.o((String) message.obj, bundle);
                            break;
                        case 6:
                            bVar.p((Uri) message.obj, bundle);
                            break;
                        case 7:
                            bVar.i();
                            break;
                        case 8:
                            bVar.j((String) message.obj, bundle);
                            break;
                        case 9:
                            bVar.k((String) message.obj, bundle);
                            break;
                        case 10:
                            bVar.l((Uri) message.obj, bundle);
                            break;
                        case 11:
                            bVar.C(((Long) message.obj).longValue());
                            break;
                        case 12:
                            bVar.h();
                            break;
                        case 13:
                            bVar.D();
                            break;
                        case 14:
                            bVar.A();
                            break;
                        case 15:
                            bVar.B();
                            break;
                        case 16:
                            bVar.f();
                            break;
                        case 17:
                            bVar.s();
                            break;
                        case 18:
                            bVar.t(((Long) message.obj).longValue());
                            break;
                        case 19:
                            bVar.w((RatingCompat) message.obj);
                            break;
                        case 20:
                            bVar.e((String) message.obj, bundle);
                            break;
                        case 21:
                            KeyEvent keyEvent = (KeyEvent) message.obj;
                            Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                            intent.putExtra("android.intent.extra.KEY_EVENT", keyEvent);
                            if (!bVar.g(intent)) {
                                a(keyEvent, bVar);
                            }
                            break;
                        case 22:
                            i.this.R(message.arg1, 0);
                            break;
                        case 23:
                            bVar.y(message.arg1);
                            break;
                        case 25:
                            bVar.b((MediaDescriptionCompat) message.obj);
                            break;
                        case 26:
                            bVar.c((MediaDescriptionCompat) message.obj, message.arg1);
                            break;
                        case 27:
                            bVar.q((MediaDescriptionCompat) message.obj);
                            break;
                        case 28:
                            List<QueueItem> list = i.this.f1135v;
                            if (list != null) {
                                int i10 = message.arg1;
                                QueueItem queueItem = (i10 < 0 || i10 >= list.size()) ? null : i.this.f1135v.get(message.arg1);
                                if (queueItem != null) {
                                    bVar.q(queueItem.e());
                                }
                            }
                            break;
                        case 29:
                            bVar.u(((Boolean) message.obj).booleanValue());
                            break;
                        case 30:
                            bVar.z(message.arg1);
                            break;
                        case 31:
                            bVar.x((RatingCompat) message.obj, bundle);
                            break;
                        case 32:
                            bVar.v(((Float) message.obj).floatValue());
                            break;
                    }
                } finally {
                    i.this.t(null);
                }
            }
        }

        public i(Context context, String str, ComponentName componentName, PendingIntent pendingIntent, i2.e eVar, Bundle bundle) {
            if (componentName == null) {
                throw new IllegalArgumentException("MediaButtonReceiver component may not be null");
            }
            this.f1114a = context;
            this.f1119f = context.getPackageName();
            this.f1120g = bundle;
            this.f1122i = (AudioManager) context.getSystemService("audio");
            this.f1121h = str;
            this.f1115b = componentName;
            this.f1116c = pendingIntent;
            c cVar = new c();
            this.f1117d = cVar;
            this.f1118e = new Token(cVar, null, eVar);
            this.f1137x = 0;
            this.C = 1;
            this.D = 3;
            this.f1123j = new RemoteControlClient(pendingIntent);
        }

        public String A(int i10) {
            String nameForUid = this.f1114a.getPackageManager().getNameForUid(i10);
            return TextUtils.isEmpty(nameForUid) ? e.b.f50833b : nameForUid;
        }

        public int B(int i10) {
            switch (i10) {
                case 0:
                    return 0;
                case 1:
                    return 1;
                case 2:
                    return 2;
                case 3:
                    return 3;
                case 4:
                    return 4;
                case 5:
                    return 5;
                case 6:
                case 8:
                    return 8;
                case 7:
                    return 9;
                case 9:
                    return 7;
                case 10:
                case 11:
                    return 6;
                default:
                    return -1;
            }
        }

        public int C(long j10) {
            int i10 = (1 & j10) != 0 ? 32 : 0;
            if ((2 & j10) != 0) {
                i10 |= 16;
            }
            if ((4 & j10) != 0) {
                i10 |= 4;
            }
            if ((8 & j10) != 0) {
                i10 |= 2;
            }
            if ((16 & j10) != 0) {
                i10 |= 1;
            }
            if ((32 & j10) != 0) {
                i10 |= 128;
            }
            if ((64 & j10) != 0) {
                i10 |= 64;
            }
            return (j10 & 512) != 0 ? i10 | 8 : i10;
        }

        public void D(int i10, int i11, int i12, Object obj, Bundle bundle) {
            synchronized (this.f1124k) {
                d dVar = this.f1126m;
                if (dVar != null) {
                    Message messageObtainMessage = dVar.obtainMessage(i10, i11, i12, obj);
                    Bundle bundle2 = new Bundle();
                    int callingUid = Binder.getCallingUid();
                    bundle2.putInt("data_calling_uid", callingUid);
                    bundle2.putString(MediaSessionCompat.N, A(callingUid));
                    int callingPid = Binder.getCallingPid();
                    if (callingPid > 0) {
                        bundle2.putInt("data_calling_pid", callingPid);
                    } else {
                        bundle2.putInt("data_calling_pid", -1);
                    }
                    if (bundle != null) {
                        bundle2.putBundle(MediaSessionCompat.Q, bundle);
                    }
                    messageObtainMessage.setData(bundle2);
                    messageObtainMessage.sendToTarget();
                }
            }
        }

        public void E(PendingIntent pendingIntent, ComponentName componentName) {
            this.f1122i.registerMediaButtonEventReceiver(componentName);
        }

        public final void F(boolean z10) {
            for (int iBeginBroadcast = this.f1125l.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1125l.getBroadcastItem(iBeginBroadcast)).c0(z10);
                } catch (RemoteException unused) {
                }
            }
            this.f1125l.finishBroadcast();
        }

        public final void G(String str, Bundle bundle) {
            for (int iBeginBroadcast = this.f1125l.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1125l.getBroadcastItem(iBeginBroadcast)).M0(str, bundle);
                } catch (RemoteException unused) {
                }
            }
            this.f1125l.finishBroadcast();
        }

        public final void H(Bundle bundle) {
            for (int iBeginBroadcast = this.f1125l.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1125l.getBroadcastItem(iBeginBroadcast)).N(bundle);
                } catch (RemoteException unused) {
                }
            }
            this.f1125l.finishBroadcast();
        }

        public final void I(MediaMetadataCompat mediaMetadataCompat) {
            for (int iBeginBroadcast = this.f1125l.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1125l.getBroadcastItem(iBeginBroadcast)).o0(mediaMetadataCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f1125l.finishBroadcast();
        }

        public final void J(List<QueueItem> list) {
            for (int iBeginBroadcast = this.f1125l.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1125l.getBroadcastItem(iBeginBroadcast)).Q(list);
                } catch (RemoteException unused) {
                }
            }
            this.f1125l.finishBroadcast();
        }

        public final void K(CharSequence charSequence) {
            for (int iBeginBroadcast = this.f1125l.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1125l.getBroadcastItem(iBeginBroadcast)).i0(charSequence);
                } catch (RemoteException unused) {
                }
            }
            this.f1125l.finishBroadcast();
        }

        public final void L(int i10) {
            for (int iBeginBroadcast = this.f1125l.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1125l.getBroadcastItem(iBeginBroadcast)).v(i10);
                } catch (RemoteException unused) {
                }
            }
            this.f1125l.finishBroadcast();
        }

        public final void M() {
            for (int iBeginBroadcast = this.f1125l.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1125l.getBroadcastItem(iBeginBroadcast)).m0();
                } catch (RemoteException unused) {
                }
            }
            this.f1125l.finishBroadcast();
            this.f1125l.kill();
        }

        public final void N(int i10) {
            for (int iBeginBroadcast = this.f1125l.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1125l.getBroadcastItem(iBeginBroadcast)).u0(i10);
                } catch (RemoteException unused) {
                }
            }
            this.f1125l.finishBroadcast();
        }

        public final void O(PlaybackStateCompat playbackStateCompat) {
            for (int iBeginBroadcast = this.f1125l.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1125l.getBroadcastItem(iBeginBroadcast)).L0(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f1125l.finishBroadcast();
        }

        public void P(ParcelableVolumeInfo parcelableVolumeInfo) {
            for (int iBeginBroadcast = this.f1125l.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1125l.getBroadcastItem(iBeginBroadcast)).O0(parcelableVolumeInfo);
                } catch (RemoteException unused) {
                }
            }
            this.f1125l.finishBroadcast();
        }

        public void Q(PlaybackStateCompat playbackStateCompat) {
            this.f1123j.setPlaybackState(B(playbackStateCompat.V()));
        }

        public void R(int i10, int i11) {
            if (this.C != 2) {
                this.f1122i.setStreamVolume(this.D, i10, i11);
                return;
            }
            t1.i iVar = this.E;
            if (iVar != null) {
                iVar.g(i10);
            }
        }

        public void S(PendingIntent pendingIntent, ComponentName componentName) {
            this.f1122i.unregisterMediaButtonEventReceiver(componentName);
        }

        public void T() {
            if (!this.f1128o) {
                S(this.f1116c, this.f1115b);
                this.f1123j.setPlaybackState(0);
                this.f1122i.unregisterRemoteControlClient(this.f1123j);
            } else {
                E(this.f1116c, this.f1115b);
                this.f1122i.registerRemoteControlClient(this.f1123j);
                l(this.f1132s);
                r(this.f1133t);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Token a() {
            return this.f1118e;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void b(int i10) {
            synchronized (this.f1124k) {
                this.f1131r = i10 | 1 | 2;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void c(String str, Bundle bundle) {
            G(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public PlaybackStateCompat d() {
            PlaybackStateCompat playbackStateCompat;
            synchronized (this.f1124k) {
                playbackStateCompat = this.f1133t;
            }
            return playbackStateCompat;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public String e() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void f(PendingIntent pendingIntent) {
            synchronized (this.f1124k) {
                this.f1134u = pendingIntent;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void g(b bVar, Handler handler) {
            synchronized (this.f1124k) {
                d dVar = this.f1126m;
                if (dVar != null) {
                    dVar.removeCallbacksAndMessages(null);
                }
                this.f1126m = (bVar == null || handler == null) ? null : new d(handler.getLooper());
                if (this.f1129p != bVar && this.f1129p != null) {
                    this.f1129p.E(null, null);
                }
                this.f1129p = bVar;
                if (this.f1129p != null) {
                    this.f1129p.E(this, handler);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void h(int i10) {
            t1.i iVar = this.E;
            if (iVar != null) {
                iVar.h(null);
            }
            this.D = i10;
            this.C = 1;
            int i11 = this.C;
            int i12 = this.D;
            P(new ParcelableVolumeInfo(i11, i12, 2, this.f1122i.getStreamMaxVolume(i12), this.f1122i.getStreamVolume(this.D)));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void i(CharSequence charSequence) {
            this.f1136w = charSequence;
            K(charSequence);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public boolean isActive() {
            return this.f1128o;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void j(int i10) {
            if (this.f1139z != i10) {
                this.f1139z = i10;
                L(i10);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public b k() {
            b bVar;
            synchronized (this.f1124k) {
                bVar = this.f1129p;
            }
            return bVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void l(MediaMetadataCompat mediaMetadataCompat) {
            if (mediaMetadataCompat != null) {
                mediaMetadataCompat = new MediaMetadataCompat.b(mediaMetadataCompat, MediaSessionCompat.R).a();
            }
            synchronized (this.f1124k) {
                this.f1132s = mediaMetadataCompat;
            }
            I(mediaMetadataCompat);
            if (this.f1128o) {
                y(mediaMetadataCompat == null ? null : mediaMetadataCompat.g()).apply();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void m(PendingIntent pendingIntent) {
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void n(int i10) {
            this.f1137x = i10;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void o(List<QueueItem> list) {
            this.f1135v = list;
            J(list);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Object p() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void q(boolean z10) {
            if (z10 == this.f1128o) {
                return;
            }
            this.f1128o = z10;
            T();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void r(PlaybackStateCompat playbackStateCompat) {
            synchronized (this.f1124k) {
                this.f1133t = playbackStateCompat;
            }
            O(playbackStateCompat);
            if (this.f1128o) {
                if (playbackStateCompat == null) {
                    this.f1123j.setPlaybackState(0);
                    this.f1123j.setTransportControlFlags(0);
                } else {
                    Q(playbackStateCompat);
                    this.f1123j.setTransportControlFlags(C(playbackStateCompat.b()));
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void release() {
            this.f1128o = false;
            this.f1127n = true;
            T();
            M();
            g(null, null);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Object s() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void setExtras(Bundle bundle) {
            this.B = bundle;
            H(bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void t(e.b bVar) {
            synchronized (this.f1124k) {
                this.f1130q = bVar;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void u(boolean z10) {
            if (this.f1138y != z10) {
                this.f1138y = z10;
                F(z10);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public e.b v() {
            e.b bVar;
            synchronized (this.f1124k) {
                bVar = this.f1130q;
            }
            return bVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void w(t1.i iVar) {
            if (iVar == null) {
                throw new IllegalArgumentException("volumeProvider may not be null");
            }
            t1.i iVar2 = this.E;
            if (iVar2 != null) {
                iVar2.h(null);
            }
            this.C = 2;
            this.E = iVar;
            P(new ParcelableVolumeInfo(this.C, this.D, this.E.c(), this.E.b(), this.E.a()));
            iVar.h(this.F);
        }

        public void x(int i10, int i11) {
            if (this.C != 2) {
                this.f1122i.adjustStreamVolume(this.D, i10, i11);
                return;
            }
            t1.i iVar = this.E;
            if (iVar != null) {
                iVar.f(i10);
            }
        }

        public RemoteControlClient.MetadataEditor y(Bundle bundle) {
            RemoteControlClient.MetadataEditor metadataEditorEditMetadata = this.f1123j.editMetadata(true);
            if (bundle == null) {
                return metadataEditorEditMetadata;
            }
            if (bundle.containsKey(MediaMetadataCompat.f977t)) {
                Bitmap bitmapCopy = (Bitmap) bundle.getParcelable(MediaMetadataCompat.f977t);
                if (bitmapCopy != null) {
                    bitmapCopy = bitmapCopy.copy(bitmapCopy.getConfig(), false);
                }
                metadataEditorEditMetadata.putBitmap(100, bitmapCopy);
            } else if (bundle.containsKey(MediaMetadataCompat.f979v)) {
                Bitmap bitmapCopy2 = (Bitmap) bundle.getParcelable(MediaMetadataCompat.f979v);
                if (bitmapCopy2 != null) {
                    bitmapCopy2 = bitmapCopy2.copy(bitmapCopy2.getConfig(), false);
                }
                metadataEditorEditMetadata.putBitmap(100, bitmapCopy2);
            }
            if (bundle.containsKey(MediaMetadataCompat.f963h)) {
                metadataEditorEditMetadata.putString(1, bundle.getString(MediaMetadataCompat.f963h));
            }
            if (bundle.containsKey(MediaMetadataCompat.f976s)) {
                metadataEditorEditMetadata.putString(13, bundle.getString(MediaMetadataCompat.f976s));
            }
            if (bundle.containsKey(MediaMetadataCompat.f961f)) {
                metadataEditorEditMetadata.putString(2, bundle.getString(MediaMetadataCompat.f961f));
            }
            if (bundle.containsKey(MediaMetadataCompat.f964i)) {
                metadataEditorEditMetadata.putString(3, bundle.getString(MediaMetadataCompat.f964i));
            }
            if (bundle.containsKey(MediaMetadataCompat.f969l)) {
                metadataEditorEditMetadata.putString(15, bundle.getString(MediaMetadataCompat.f969l));
            }
            if (bundle.containsKey(MediaMetadataCompat.f966k)) {
                metadataEditorEditMetadata.putString(4, bundle.getString(MediaMetadataCompat.f966k));
            }
            if (bundle.containsKey(MediaMetadataCompat.f970m)) {
                metadataEditorEditMetadata.putString(5, bundle.getString(MediaMetadataCompat.f970m));
            }
            if (bundle.containsKey(MediaMetadataCompat.f975r)) {
                metadataEditorEditMetadata.putLong(14, bundle.getLong(MediaMetadataCompat.f975r));
            }
            if (bundle.containsKey(MediaMetadataCompat.f962g)) {
                metadataEditorEditMetadata.putLong(9, bundle.getLong(MediaMetadataCompat.f962g));
            }
            if (bundle.containsKey(MediaMetadataCompat.f972o)) {
                metadataEditorEditMetadata.putString(6, bundle.getString(MediaMetadataCompat.f972o));
            }
            if (bundle.containsKey(MediaMetadataCompat.f960e)) {
                metadataEditorEditMetadata.putString(7, bundle.getString(MediaMetadataCompat.f960e));
            }
            if (bundle.containsKey(MediaMetadataCompat.f973p)) {
                metadataEditorEditMetadata.putLong(0, bundle.getLong(MediaMetadataCompat.f973p));
            }
            if (bundle.containsKey(MediaMetadataCompat.f965j)) {
                metadataEditorEditMetadata.putString(11, bundle.getString(MediaMetadataCompat.f965j));
            }
            return metadataEditorEditMetadata;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void z(int i10) {
            if (this.A != i10) {
                this.A = i10;
                N(i10);
            }
        }
    }

    public interface j {
        void a();
    }

    public MediaSessionCompat(@n0 Context context, @n0 String str) {
        this(context, str, null, null);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static Bundle G(@p0 Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        c(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void c(@p0 Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static MediaSessionCompat d(Context context, Object obj) {
        int i10 = Build.VERSION.SDK_INT;
        if (context == null || obj == null) {
            return null;
        }
        return new MediaSessionCompat(context, i10 >= 29 ? new h(obj) : i10 >= 28 ? new g(obj) : new f(obj));
    }

    public static PlaybackStateCompat k(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        if (playbackStateCompat == null) {
            return playbackStateCompat;
        }
        long jS = -1;
        if (playbackStateCompat.U() == -1) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.V() != 3 && playbackStateCompat.V() != 4 && playbackStateCompat.V() != 5) {
            return playbackStateCompat;
        }
        if (playbackStateCompat.M() <= 0) {
            return playbackStateCompat;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long jS2 = ((long) (playbackStateCompat.S() * (jElapsedRealtime - r0))) + playbackStateCompat.U();
        if (mediaMetadataCompat != null && mediaMetadataCompat.a(MediaMetadataCompat.f962g)) {
            jS = mediaMetadataCompat.s(MediaMetadataCompat.f962g);
        }
        return new PlaybackStateCompat.c(playbackStateCompat).k(playbackStateCompat.V(), (jS < 0 || jS2 <= jS) ? jS2 < 0 ? 0L : jS2 : jS, playbackStateCompat.S(), jElapsedRealtime).c();
    }

    public void A(List<QueueItem> list) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            for (QueueItem queueItem : list) {
                if (queueItem == null) {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
                if (hashSet.contains(Long.valueOf(queueItem.g()))) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Found duplicate queue id: ");
                    sb2.append(queueItem.g());
                    new IllegalArgumentException("id of each queue item should be unique");
                }
                hashSet.add(Long.valueOf(queueItem.g()));
            }
        }
        this.f1075a.o(list);
    }

    public void B(CharSequence charSequence) {
        this.f1075a.i(charSequence);
    }

    public void C(int i10) {
        this.f1075a.n(i10);
    }

    public void D(int i10) {
        this.f1075a.j(i10);
    }

    public void E(PendingIntent pendingIntent) {
        this.f1075a.f(pendingIntent);
    }

    public void F(int i10) {
        this.f1075a.z(i10);
    }

    public void a(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.f1077c.add(jVar);
    }

    @v0(21)
    public final MediaSession b(Context context, String str, Bundle bundle) {
        return Build.VERSION.SDK_INT >= 29 ? new MediaSession(context, str, bundle) : new MediaSession(context, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String e() {
        return this.f1075a.e();
    }

    public MediaControllerCompat f() {
        return this.f1076b;
    }

    @n0
    public final e.b g() {
        return this.f1075a.v();
    }

    public Object h() {
        return this.f1075a.s();
    }

    public Object i() {
        return this.f1075a.p();
    }

    public Token j() {
        return this.f1075a.a();
    }

    public boolean l() {
        return this.f1075a.isActive();
    }

    public void m() {
        this.f1075a.release();
    }

    public void n(j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("Listener may not be null");
        }
        this.f1077c.remove(jVar);
    }

    public void o(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("event cannot be null or empty");
        }
        this.f1075a.c(str, bundle);
    }

    public void p(boolean z10) {
        this.f1075a.q(z10);
        Iterator<j> it2 = this.f1077c.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    public void q(b bVar) {
        r(bVar, null);
    }

    public void r(b bVar, Handler handler) {
        if (bVar == null) {
            this.f1075a.g(null, null);
            return;
        }
        c cVar = this.f1075a;
        if (handler == null) {
            handler = new Handler();
        }
        cVar.g(bVar, handler);
    }

    public void s(boolean z10) {
        this.f1075a.u(z10);
    }

    public void t(Bundle bundle) {
        this.f1075a.setExtras(bundle);
    }

    public void u(int i10) {
        this.f1075a.b(i10);
    }

    public void v(PendingIntent pendingIntent) {
        this.f1075a.m(pendingIntent);
    }

    public void w(MediaMetadataCompat mediaMetadataCompat) {
        this.f1075a.l(mediaMetadataCompat);
    }

    public void x(PlaybackStateCompat playbackStateCompat) {
        this.f1075a.r(playbackStateCompat);
    }

    public void y(int i10) {
        this.f1075a.h(i10);
    }

    public void z(t1.i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("volumeProvider may not be null!");
        }
        this.f1075a.w(iVar);
    }

    @SuppressLint({"BanParcelableUsage"})
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ResultReceiver f1082a;

        public class a implements Parcelable.Creator<ResultReceiverWrapper> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i10) {
                return new ResultReceiverWrapper[i10];
            }
        }

        public ResultReceiverWrapper(@n0 ResultReceiver resultReceiver) {
            this.f1082a = resultReceiver;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            this.f1082a.writeToParcel(parcel, i10);
        }

        public ResultReceiverWrapper(Parcel parcel) {
            this.f1082a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }
    }

    public MediaSessionCompat(@n0 Context context, @n0 String str, @p0 ComponentName componentName, @p0 PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    public MediaSessionCompat(@n0 Context context, @n0 String str, @p0 ComponentName componentName, @p0 PendingIntent pendingIntent, @p0 Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public MediaSessionCompat(@n0 Context context, @n0 String str, @p0 ComponentName componentName, @p0 PendingIntent pendingIntent, @p0 Bundle bundle, @p0 i2.e eVar) {
        this.f1077c = new ArrayList<>();
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                componentName = componentName == null ? v1.a.c(context) : componentName;
                if (componentName != null && pendingIntent == null) {
                    Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent.setComponent(componentName);
                    pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
                }
                int i10 = Build.VERSION.SDK_INT;
                MediaSession mediaSessionB = b(context, str, bundle);
                if (i10 >= 29) {
                    this.f1075a = new h(mediaSessionB, eVar, bundle);
                } else if (i10 >= 28) {
                    this.f1075a = new g(mediaSessionB, eVar, bundle);
                } else {
                    this.f1075a = new f(mediaSessionB, eVar, bundle);
                }
                r(new a(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
                this.f1075a.m(pendingIntent);
                this.f1076b = new MediaControllerCompat(context, this);
                if (R == 0) {
                    R = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        throw new IllegalArgumentException("context must not be null");
    }

    @v0(21)
    public static class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MediaSession f1098a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Token f1099b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Bundle f1101d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public PlaybackStateCompat f1104g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<QueueItem> f1105h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public MediaMetadataCompat f1106i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f1107j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f1108k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f1109l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1110m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @b0("mLock")
        public b f1111n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @b0("mLock")
        public e.b f1112o;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Object f1100c = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f1102e = false;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final RemoteCallbackList<android.support.v4.media.session.a> f1103f = new RemoteCallbackList<>();

        public class a extends b.AbstractBinderC0023b {
            public a() {
            }

            @Override // android.support.v4.media.session.b
            public void B(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void B0(long j10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void C(android.support.v4.media.session.a aVar) {
                if (f.this.f1102e) {
                    return;
                }
                f.this.f1103f.register(aVar, new e.b(e.b.f50833b, Binder.getCallingPid(), Binder.getCallingUid()));
            }

            @Override // android.support.v4.media.session.b
            public void C0(boolean z10) throws RemoteException {
            }

            @Override // android.support.v4.media.session.b
            public boolean D() {
                return false;
            }

            @Override // android.support.v4.media.session.b
            public ParcelableVolumeInfo D0() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void E(RatingCompat ratingCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void F(int i10, int i11, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void G(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean H() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public PendingIntent I() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void K(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void T(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void U(android.support.v4.media.session.a aVar) {
                f.this.f1103f.unregister(aVar);
            }

            @Override // android.support.v4.media.session.b
            public void V(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void X(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void Z() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void a0(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public PlaybackStateCompat d() {
                f fVar = f.this;
                return MediaSessionCompat.k(fVar.f1104g, fVar.f1106i);
            }

            @Override // android.support.v4.media.session.b
            public long e() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void f() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void f0(float f10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void g(long j10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean g0(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public String h() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void i() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void j(int i10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void j0(int i10, int i11, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int k() {
                return f.this.f1109l;
            }

            @Override // android.support.v4.media.session.b
            public void l0(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public String m() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void n0(MediaDescriptionCompat mediaDescriptionCompat, int i10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void next() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void o(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void p(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int q() {
                return f.this.f1107j;
            }

            @Override // android.support.v4.media.session.b
            public CharSequence r() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public MediaMetadataCompat s() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void s0(int i10) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public Bundle t() {
                if (f.this.f1101d == null) {
                    return null;
                }
                return new Bundle(f.this.f1101d);
            }

            @Override // android.support.v4.media.session.b
            public void u(boolean z10) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public int w() {
                return f.this.f1110m;
            }

            @Override // android.support.v4.media.session.b
            public void w0(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public boolean x() {
                return f.this.f1108k;
            }

            @Override // android.support.v4.media.session.b
            public List<QueueItem> y() {
                return null;
            }

            @Override // android.support.v4.media.session.b
            public void y0() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.b
            public void z(int i10) throws RemoteException {
                throw new AssertionError();
            }
        }

        public f(MediaSession mediaSession, i2.e eVar, Bundle bundle) {
            this.f1098a = mediaSession;
            this.f1099b = new Token(mediaSession.getSessionToken(), new a(), eVar);
            this.f1101d = bundle;
            b(3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Token a() {
            return this.f1099b;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        @SuppressLint({"WrongConstant"})
        public void b(int i10) {
            this.f1098a.setFlags(i10 | 1 | 2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void c(String str, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 23) {
                for (int iBeginBroadcast = this.f1103f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.a) this.f1103f.getBroadcastItem(iBeginBroadcast)).M0(str, bundle);
                    } catch (RemoteException unused) {
                    }
                }
                this.f1103f.finishBroadcast();
            }
            this.f1098a.sendSessionEvent(str, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public PlaybackStateCompat d() {
            return this.f1104g;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public String e() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                return (String) this.f1098a.getClass().getMethod("getCallingPackage", new Class[0]).invoke(this.f1098a, new Object[0]);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void f(PendingIntent pendingIntent) {
            this.f1098a.setSessionActivity(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void g(b bVar, Handler handler) {
            synchronized (this.f1100c) {
                this.f1111n = bVar;
                this.f1098a.setCallback(bVar == null ? null : bVar.f1089b, handler);
                if (bVar != null) {
                    bVar.E(this, handler);
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void h(int i10) {
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setLegacyStreamType(i10);
            this.f1098a.setPlaybackToLocal(builder.build());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void i(CharSequence charSequence) {
            this.f1098a.setQueueTitle(charSequence);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public boolean isActive() {
            return this.f1098a.isActive();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void j(int i10) {
            if (this.f1109l != i10) {
                this.f1109l = i10;
                for (int iBeginBroadcast = this.f1103f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.a) this.f1103f.getBroadcastItem(iBeginBroadcast)).v(i10);
                    } catch (RemoteException unused) {
                    }
                }
                this.f1103f.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public b k() {
            b bVar;
            synchronized (this.f1100c) {
                bVar = this.f1111n;
            }
            return bVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void l(MediaMetadataCompat mediaMetadataCompat) {
            this.f1106i = mediaMetadataCompat;
            this.f1098a.setMetadata(mediaMetadataCompat == null ? null : (MediaMetadata) mediaMetadataCompat.z());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void m(PendingIntent pendingIntent) {
            this.f1098a.setMediaButtonReceiver(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void n(int i10) {
            if (Build.VERSION.SDK_INT < 22) {
                this.f1107j = i10;
            } else {
                this.f1098a.setRatingType(i10);
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void o(List<QueueItem> list) {
            this.f1105h = list;
            if (list == null) {
                this.f1098a.setQueue(null);
                return;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<QueueItem> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add((MediaSession.QueueItem) it2.next().j());
            }
            this.f1098a.setQueue(arrayList);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Object p() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void q(boolean z10) {
            this.f1098a.setActive(z10);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void r(PlaybackStateCompat playbackStateCompat) {
            this.f1104g = playbackStateCompat;
            for (int iBeginBroadcast = this.f1103f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                try {
                    ((android.support.v4.media.session.a) this.f1103f.getBroadcastItem(iBeginBroadcast)).L0(playbackStateCompat);
                } catch (RemoteException unused) {
                }
            }
            this.f1103f.finishBroadcast();
            this.f1098a.setPlaybackState(playbackStateCompat == null ? null : (PlaybackState) playbackStateCompat.T());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void release() {
            this.f1102e = true;
            this.f1103f.kill();
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    Field declaredField = this.f1098a.getClass().getDeclaredField("mCallback");
                    declaredField.setAccessible(true);
                    Handler handler = (Handler) declaredField.get(this.f1098a);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                } catch (Exception unused) {
                }
            }
            this.f1098a.setCallback(null);
            this.f1098a.release();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public Object s() {
            return this.f1098a;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void setExtras(Bundle bundle) {
            this.f1098a.setExtras(bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void t(e.b bVar) {
            synchronized (this.f1100c) {
                this.f1112o = bVar;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void u(boolean z10) {
            if (this.f1108k != z10) {
                this.f1108k = z10;
                for (int iBeginBroadcast = this.f1103f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.a) this.f1103f.getBroadcastItem(iBeginBroadcast)).c0(z10);
                    } catch (RemoteException unused) {
                    }
                }
                this.f1103f.finishBroadcast();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public e.b v() {
            e.b bVar;
            synchronized (this.f1100c) {
                bVar = this.f1112o;
            }
            return bVar;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void w(t1.i iVar) {
            this.f1098a.setPlaybackToRemote((VolumeProvider) iVar.e());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.c
        public void z(int i10) {
            if (this.f1110m != i10) {
                this.f1110m = i10;
                for (int iBeginBroadcast = this.f1103f.beginBroadcast() - 1; iBeginBroadcast >= 0; iBeginBroadcast--) {
                    try {
                        ((android.support.v4.media.session.a) this.f1103f.getBroadcastItem(iBeginBroadcast)).u0(i10);
                    } catch (RemoteException unused) {
                    }
                }
                this.f1103f.finishBroadcast();
            }
        }

        public f(Object obj) {
            if (obj instanceof MediaSession) {
                MediaSession mediaSession = (MediaSession) obj;
                this.f1098a = mediaSession;
                this.f1099b = new Token(mediaSession.getSessionToken(), new a());
                this.f1101d = null;
                b(3);
                return;
            }
            throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
        }
    }

    public MediaSessionCompat(Context context, c cVar) {
        this.f1077c = new ArrayList<>();
        this.f1075a = cVar;
        this.f1076b = new MediaControllerCompat(context, this);
    }
}
