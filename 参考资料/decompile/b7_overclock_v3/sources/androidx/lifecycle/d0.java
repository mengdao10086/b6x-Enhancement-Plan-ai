package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: loaded from: classes2.dex */
public class d0 extends Service implements y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final v0 f6186a = new v0(this);

    @Override // androidx.lifecycle.y
    @yt.k
    public Lifecycle e() {
        return this.f6186a.a();
    }

    @Override // android.app.Service
    @g.i
    @yt.l
    public IBinder onBind(@yt.k Intent intent) {
        kotlin.jvm.internal.f0.p(intent, "intent");
        this.f6186a.b();
        return null;
    }

    @Override // android.app.Service
    @g.i
    public void onCreate() {
        this.f6186a.c();
        super.onCreate();
    }

    @Override // android.app.Service
    @g.i
    public void onDestroy() {
        this.f6186a.d();
        super.onDestroy();
    }

    @Override // android.app.Service
    @g.i
    @kotlin.k(message = "Deprecated in Java")
    public void onStart(@yt.l Intent intent, int i10) {
        this.f6186a.e();
        super.onStart(intent, i10);
    }

    @Override // android.app.Service
    @g.i
    public int onStartCommand(@yt.l Intent intent, int i10, int i11) {
        return super.onStartCommand(intent, i10, i11);
    }
}
