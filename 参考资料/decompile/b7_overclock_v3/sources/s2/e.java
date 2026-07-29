package s2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.work.l;
import g.i1;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class e extends d<q2.b> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f49433j = l.f("NetworkStateTracker");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ConnectivityManager f49434g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @v0(24)
    public b f49435h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f49436i;

    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || intent.getAction() == null || !intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                return;
            }
            l.c().a(e.f49433j, "Network broadcast received", new Throwable[0]);
            e eVar = e.this;
            eVar.d(eVar.g());
        }
    }

    @v0(24)
    public class b extends ConnectivityManager.NetworkCallback {
        public b() {
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(@n0 Network network, @n0 NetworkCapabilities capabilities) {
            l.c().a(e.f49433j, String.format("Network capabilities changed: %s", capabilities), new Throwable[0]);
            e eVar = e.this;
            eVar.d(eVar.g());
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@n0 Network network) {
            l.c().a(e.f49433j, "Network connection lost", new Throwable[0]);
            e eVar = e.this;
            eVar.d(eVar.g());
        }
    }

    public e(@n0 Context context, @n0 w2.a taskExecutor) {
        super(context, taskExecutor);
        this.f49434g = (ConnectivityManager) this.f49427b.getSystemService("connectivity");
        if (j()) {
            this.f49435h = new b();
        } else {
            this.f49436i = new a();
        }
    }

    public static boolean j() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @Override // s2.d
    public void e() {
        if (!j()) {
            l.c().a(f49433j, "Registering broadcast receiver", new Throwable[0]);
            this.f49427b.registerReceiver(this.f49436i, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            return;
        }
        try {
            l.c().a(f49433j, "Registering network callback", new Throwable[0]);
            this.f49434g.registerDefaultNetworkCallback(this.f49435h);
        } catch (IllegalArgumentException | SecurityException e10) {
            l.c().b(f49433j, "Received exception while registering network callback", e10);
        }
    }

    @Override // s2.d
    public void f() {
        if (!j()) {
            l.c().a(f49433j, "Unregistering broadcast receiver", new Throwable[0]);
            this.f49427b.unregisterReceiver(this.f49436i);
            return;
        }
        try {
            l.c().a(f49433j, "Unregistering network callback", new Throwable[0]);
            this.f49434g.unregisterNetworkCallback(this.f49435h);
        } catch (IllegalArgumentException | SecurityException e10) {
            l.c().b(f49433j, "Received exception while unregistering network callback", e10);
        }
    }

    public q2.b g() {
        NetworkInfo activeNetworkInfo = this.f49434g.getActiveNetworkInfo();
        return new q2.b(activeNetworkInfo != null && activeNetworkInfo.isConnected(), i(), u0.a.c(this.f49434g), (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) ? false : true);
    }

    @Override // s2.d
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public q2.b b() {
        return g();
    }

    @i1
    public boolean i() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = this.f49434g.getNetworkCapabilities(this.f49434g.getActiveNetwork());
            if (networkCapabilities != null) {
                return networkCapabilities.hasCapability(16);
            }
            return false;
        } catch (SecurityException e10) {
            l.c().b(f49433j, "Unable to validate active network", e10);
            return false;
        }
    }
}
