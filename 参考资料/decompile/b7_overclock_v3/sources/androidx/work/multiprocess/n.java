package androidx.work.multiprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class n extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8704b = androidx.work.l.f("RemoteWorkerService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f8705a;

    @Override // android.app.Service
    @p0
    public IBinder onBind(@n0 Intent intent) {
        androidx.work.l.c().d(f8704b, "Binding to RemoteWorkerService", new Throwable[0]);
        return this.f8705a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f8705a = new e(this);
    }
}
