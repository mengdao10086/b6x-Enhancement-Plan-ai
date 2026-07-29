package androidx.work.impl.background.systemalarm;

import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.d0;
import androidx.work.impl.background.systemalarm.d;
import androidx.work.l;
import g.k0;
import v2.o;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SystemAlarmService extends d0 implements d.c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8421d = l.f("SystemAlarmService");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f8422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8423c;

    @k0
    public final void G() {
        d dVar = new d(this);
        this.f8422b = dVar;
        dVar.m(this);
    }

    @Override // androidx.work.impl.background.systemalarm.d.c
    @k0
    public void h() {
        this.f8423c = true;
        l.c().a(f8421d, "All commands completed in dispatcher", new Throwable[0]);
        o.a();
        stopSelf();
    }

    @Override // androidx.lifecycle.d0, android.app.Service
    public void onCreate() {
        super.onCreate();
        G();
        this.f8423c = false;
    }

    @Override // androidx.lifecycle.d0, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.f8423c = true;
        this.f8422b.j();
    }

    @Override // androidx.lifecycle.d0, android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        if (this.f8423c) {
            l.c().d(f8421d, "Re-initializing SystemAlarmDispatcher after a request to shut-down.", new Throwable[0]);
            this.f8422b.j();
            G();
            this.f8423c = false;
        }
        if (intent == null) {
            return 3;
        }
        this.f8422b.a(intent, startId);
        return 3;
    }
}
