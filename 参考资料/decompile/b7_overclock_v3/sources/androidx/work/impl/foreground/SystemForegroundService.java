package androidx.work.impl.foreground;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.d0;
import androidx.work.impl.foreground.a;
import androidx.work.l;
import g.k0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemForegroundService extends d0 implements a.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f8478f = l.f("SystemFgService");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public static SystemForegroundService f8479g = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f8480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.work.impl.foreground.a f8482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public NotificationManager f8483e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8484a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Notification f8485b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f8486c;

        public a(final int val$notificationId, final Notification val$notification, final int val$notificationType) {
            this.f8484a = val$notificationId;
            this.f8485b = val$notification;
            this.f8486c = val$notificationType;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 29) {
                SystemForegroundService.this.startForeground(this.f8484a, this.f8485b, this.f8486c);
            } else {
                SystemForegroundService.this.startForeground(this.f8484a, this.f8485b);
            }
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8488a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Notification f8489b;

        public b(final int val$notificationId, final Notification val$notification) {
            this.f8488a = val$notificationId;
            this.f8489b = val$notification;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f8483e.notify(this.f8488a, this.f8489b);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8491a;

        public c(final int val$notificationId) {
            this.f8491a = val$notificationId;
        }

        @Override // java.lang.Runnable
        public void run() {
            SystemForegroundService.this.f8483e.cancel(this.f8491a);
        }
    }

    @p0
    public static SystemForegroundService G() {
        return f8479g;
    }

    @Override // androidx.work.impl.foreground.a.b
    public void C(final int notificationId) {
        this.f8480b.post(new c(notificationId));
    }

    @k0
    public final void H() {
        this.f8480b = new Handler(Looper.getMainLooper());
        this.f8483e = (NotificationManager) getApplicationContext().getSystemService("notification");
        androidx.work.impl.foreground.a aVar = new androidx.work.impl.foreground.a(getApplicationContext());
        this.f8482d = aVar;
        aVar.o(this);
    }

    @Override // androidx.lifecycle.d0, android.app.Service
    public void onCreate() {
        super.onCreate();
        f8479g = this;
        H();
    }

    @Override // androidx.lifecycle.d0, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f8482d.m();
    }

    @Override // androidx.lifecycle.d0, android.app.Service
    public int onStartCommand(@p0 Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if (this.f8481c) {
            l.c().d(f8478f, "Re-initializing SystemForegroundService after a request to shut-down.", new Throwable[0]);
            this.f8482d.m();
            H();
            this.f8481c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f8482d.n(intent);
        return 3;
    }

    @Override // androidx.work.impl.foreground.a.b
    public void p(final int notificationId, final int notificationType, @n0 final Notification notification) {
        this.f8480b.post(new a(notificationId, notification, notificationType));
    }

    @Override // androidx.work.impl.foreground.a.b
    public void s(final int notificationId, @n0 final Notification notification) {
        this.f8480b.post(new b(notificationId, notification));
    }

    @Override // androidx.work.impl.foreground.a.b
    @k0
    public void stop() {
        this.f8481c = true;
        l.c().a(f8478f, "All commands completed.", new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 26) {
            stopForeground(true);
        }
        f8479g = null;
        stopSelf();
    }
}
