package dc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import com.google.android.exoplayer2.scheduler.Requirements;
import g.p0;
import g.v0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f26151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f26152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Requirements f26153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f26154d = u0.B();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public C0294b f26155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public d f26157g;

    /* JADX INFO: renamed from: dc.b$b, reason: collision with other inner class name */
    public class C0294b extends BroadcastReceiver {
        public C0294b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            b.this.e();
        }
    }

    public interface c {
        void a(b bVar, int i10);
    }

    @v0(24)
    public final class d extends ConnectivityManager.NetworkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f26159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f26160b;

        public d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            if (b.this.f26157g != null) {
                b.this.e();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            if (b.this.f26157g != null) {
                b.this.g();
            }
        }

        public final void e() {
            b.this.f26154d.post(new Runnable() { // from class: dc.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f26162a.c();
                }
            });
        }

        public final void f() {
            b.this.f26154d.post(new Runnable() { // from class: dc.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f26163a.d();
                }
            });
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            e();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onBlockedStatusChanged(Network network, boolean z10) {
            if (z10) {
                return;
            }
            f();
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            boolean zHasCapability = networkCapabilities.hasCapability(16);
            if (this.f26159a && this.f26160b == zHasCapability) {
                if (zHasCapability) {
                    f();
                }
            } else {
                this.f26159a = true;
                this.f26160b = zHasCapability;
                e();
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            e();
        }
    }

    public b(Context context, c cVar, Requirements requirements) {
        this.f26151a = context.getApplicationContext();
        this.f26152b = cVar;
        this.f26153c = requirements;
    }

    public final void e() {
        int iG = this.f26153c.g(this.f26151a);
        if (this.f26156f != iG) {
            this.f26156f = iG;
            this.f26152b.a(this, iG);
        }
    }

    public Requirements f() {
        return this.f26153c;
    }

    public final void g() {
        if ((this.f26156f & 3) == 0) {
            return;
        }
        e();
    }

    @v0(24)
    public final void h() {
        ConnectivityManager connectivityManager = (ConnectivityManager) hd.a.g((ConnectivityManager) this.f26151a.getSystemService("connectivity"));
        d dVar = new d();
        this.f26157g = dVar;
        connectivityManager.registerDefaultNetworkCallback(dVar);
    }

    public int i() {
        this.f26156f = this.f26153c.g(this.f26151a);
        IntentFilter intentFilter = new IntentFilter();
        if (this.f26153c.S()) {
            if (u0.f31154a >= 24) {
                h();
            } else {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if (this.f26153c.s()) {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if (this.f26153c.F()) {
            if (u0.f31154a >= 23) {
                intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            } else {
                intentFilter.addAction("android.intent.action.SCREEN_ON");
                intentFilter.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        if (this.f26153c.U()) {
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
            intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        }
        C0294b c0294b = new C0294b();
        this.f26155e = c0294b;
        this.f26151a.registerReceiver(c0294b, intentFilter, null, this.f26154d);
        return this.f26156f;
    }

    public void j() {
        this.f26151a.unregisterReceiver((BroadcastReceiver) hd.a.g(this.f26155e));
        this.f26155e = null;
        if (u0.f31154a < 24 || this.f26157g == null) {
            return;
        }
        k();
    }

    @v0(24)
    public final void k() {
        ((ConnectivityManager) hd.a.g((ConnectivityManager) this.f26151a.getSystemService("connectivity"))).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) hd.a.g(this.f26157g));
        this.f26157g = null;
    }
}
