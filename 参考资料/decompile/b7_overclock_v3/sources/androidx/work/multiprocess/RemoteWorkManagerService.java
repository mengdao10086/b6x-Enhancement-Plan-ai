package androidx.work.multiprocess;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RemoteWorkManagerService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8628b = androidx.work.l.f("RemoteWorkManagerService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public IBinder f8629a;

    @Override // android.app.Service
    @p0
    public IBinder onBind(@n0 Intent intent) {
        androidx.work.l.c().d(f8628b, "Binding to RemoteWorkManager", new Throwable[0]);
        return this.f8629a;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f8629a = new m(this);
    }
}
