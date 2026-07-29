package t1;

import android.content.Context;
import android.media.session.MediaSessionManager;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.v0;
import t1.g;
import t1.h;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f50828b = "MediaSessionManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f50829c = Log.isLoggable("MediaSessionManager", 3);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f50830d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile e f50831e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f50832a;

    public interface a {
        boolean a(c cVar);

        Context b();
    }

    public interface c {
        int a();

        int b();

        String m();
    }

    public e(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f50832a = new g(context);
        } else {
            this.f50832a = new f(context);
        }
    }

    @n0
    public static e b(@n0 Context context) {
        e eVar;
        if (context == null) {
            throw new IllegalArgumentException("context cannot be null");
        }
        synchronized (f50830d) {
            if (f50831e == null) {
                f50831e = new e(context.getApplicationContext());
            }
            eVar = f50831e;
        }
        return eVar;
    }

    public Context a() {
        return this.f50832a.b();
    }

    public boolean c(@n0 b bVar) {
        if (bVar != null) {
            return this.f50832a.a(bVar.f50836a);
        }
        throw new IllegalArgumentException("userInfo should not be null");
    }

    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f50833b = "android.media.session.MediaController";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final int f50834c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public static final int f50835d = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f50836a;

        public b(@n0 String str, int i10, int i11) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f50836a = new g.a(str, i10, i11);
            } else {
                this.f50836a = new h.a(str, i10, i11);
            }
        }

        @n0
        public String a() {
            return this.f50836a.m();
        }

        public int b() {
            return this.f50836a.b();
        }

        public int c() {
            return this.f50836a.a();
        }

        public boolean equals(@p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f50836a.equals(((b) obj).f50836a);
            }
            return false;
        }

        public int hashCode() {
            return this.f50836a.hashCode();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @v0(28)
        public b(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
            this.f50836a = new g.a(remoteUserInfo);
        }
    }
}
