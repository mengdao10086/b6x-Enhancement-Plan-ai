package p4;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Log;
import g.b0;
import g.i1;
import g.n0;
import g.v0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import p4.c;
import v4.h;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile s f46396d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f46397e = "ConnectivityMonitor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f46398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b0("this")
    public final Set<c.a> f46399b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b0("this")
    public boolean f46400c;

    public class a implements h.b<ConnectivityManager> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f46401a;

        public a(Context context) {
            this.f46401a = context;
        }

        @Override // v4.h.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectivityManager get() {
            return (ConnectivityManager) this.f46401a.getSystemService("connectivity");
        }
    }

    public class b implements c.a {
        public b() {
        }

        @Override // p4.c.a
        public void a(boolean z10) {
            ArrayList arrayList;
            synchronized (s.this) {
                arrayList = new ArrayList(s.this.f46399b);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((c.a) it2.next()).a(z10);
            }
        }
    }

    public interface c {
        void a();

        boolean register();
    }

    @v0(24)
    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f46404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c.a f46405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h.b<ConnectivityManager> f46406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ConnectivityManager.NetworkCallback f46407d = new a();

        public class a extends ConnectivityManager.NetworkCallback {

            /* JADX INFO: renamed from: p4.s$d$a$a, reason: collision with other inner class name */
            public class RunnableC0523a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ boolean f46409a;

                public RunnableC0523a(boolean z10) {
                    this.f46409a = z10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(this.f46409a);
                }
            }

            public a() {
            }

            public void a(boolean z10) {
                v4.o.b();
                d dVar = d.this;
                boolean z11 = dVar.f46404a;
                dVar.f46404a = z10;
                if (z11 != z10) {
                    dVar.f46405b.a(z10);
                }
            }

            public final void b(boolean z10) {
                v4.o.x(new RunnableC0523a(z10));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(@n0 Network network) {
                b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(@n0 Network network) {
                b(false);
            }
        }

        public d(h.b<ConnectivityManager> bVar, c.a aVar) {
            this.f46406c = bVar;
            this.f46405b = aVar;
        }

        @Override // p4.s.c
        public void a() {
            this.f46406c.get().unregisterNetworkCallback(this.f46407d);
        }

        @Override // p4.s.c
        @SuppressLint({"MissingPermission"})
        public boolean register() {
            this.f46404a = this.f46406c.get().getActiveNetwork() != null;
            try {
                this.f46406c.get().registerDefaultNetworkCallback(this.f46407d);
                return true;
            } catch (RuntimeException unused) {
                return false;
            }
        }
    }

    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f46411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c.a f46412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final h.b<ConnectivityManager> f46413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f46414d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final BroadcastReceiver f46415e = new a();

        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@n0 Context context, Intent intent) {
                e eVar = e.this;
                boolean z10 = eVar.f46414d;
                eVar.f46414d = eVar.b();
                if (z10 != e.this.f46414d) {
                    if (Log.isLoggable("ConnectivityMonitor", 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("connectivity changed, isConnected: ");
                        sb2.append(e.this.f46414d);
                    }
                    e eVar2 = e.this;
                    eVar2.f46412b.a(eVar2.f46414d);
                }
            }
        }

        public e(Context context, h.b<ConnectivityManager> bVar, c.a aVar) {
            this.f46411a = context.getApplicationContext();
            this.f46413c = bVar;
            this.f46412b = aVar;
        }

        @Override // p4.s.c
        public void a() {
            this.f46411a.unregisterReceiver(this.f46415e);
        }

        @SuppressLint({"MissingPermission"})
        public boolean b() {
            try {
                NetworkInfo activeNetworkInfo = this.f46413c.get().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException unused) {
                return true;
            }
        }

        @Override // p4.s.c
        public boolean register() {
            this.f46414d = b();
            try {
                this.f46411a.registerReceiver(this.f46415e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
    }

    public s(@n0 Context context) {
        h.b bVarA = v4.h.a(new a(context));
        b bVar = new b();
        this.f46398a = Build.VERSION.SDK_INT >= 24 ? new d(bVarA, bVar) : new e(context, bVarA, bVar);
    }

    public static s a(@n0 Context context) {
        if (f46396d == null) {
            synchronized (s.class) {
                if (f46396d == null) {
                    f46396d = new s(context.getApplicationContext());
                }
            }
        }
        return f46396d;
    }

    @i1
    public static void e() {
        f46396d = null;
    }

    @b0("this")
    public final void b() {
        if (this.f46400c || this.f46399b.isEmpty()) {
            return;
        }
        this.f46400c = this.f46398a.register();
    }

    @b0("this")
    public final void c() {
        if (this.f46400c && this.f46399b.isEmpty()) {
            this.f46398a.a();
            this.f46400c = false;
        }
    }

    public synchronized void d(c.a aVar) {
        this.f46399b.add(aVar);
        b();
    }

    public synchronized void f(c.a aVar) {
        this.f46399b.remove(aVar);
        c();
    }
}
