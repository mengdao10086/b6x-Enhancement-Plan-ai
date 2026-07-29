package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.room.b1;
import androidx.room.c1;
import androidx.room.h1;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h1 f7450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h1.c f7451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.p0
    public c1 f7452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Executor f7453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b1 f7454h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f7455i = new AtomicBoolean(false);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ServiceConnection f7456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Runnable f7457k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Runnable f7458l;

    public class a extends b1.b {

        /* JADX INFO: renamed from: androidx.room.k1$a$a, reason: collision with other inner class name */
        public class RunnableC0068a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String[] f7460a;

            public RunnableC0068a(String[] strArr) {
                this.f7460a = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                k1.this.f7450d.i(this.f7460a);
            }
        }

        public a() {
        }

        @Override // androidx.room.b1
        public void J(String[] strArr) {
            k1.this.f7453g.execute(new RunnableC0068a(strArr));
        }
    }

    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            k1.this.f7452f = c1.b.Q0(iBinder);
            k1 k1Var = k1.this;
            k1Var.f7453g.execute(k1Var.f7457k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            k1 k1Var = k1.this;
            k1Var.f7453g.execute(k1Var.f7458l);
            k1.this.f7452f = null;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                k1 k1Var = k1.this;
                c1 c1Var = k1Var.f7452f;
                if (c1Var != null) {
                    k1Var.f7449c = c1Var.R(k1Var.f7454h, k1Var.f7448b);
                    k1 k1Var2 = k1.this;
                    k1Var2.f7450d.a(k1Var2.f7451e);
                }
            } catch (RemoteException unused) {
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k1 k1Var = k1.this;
            k1Var.f7450d.m(k1Var.f7451e);
        }
    }

    public class e extends h1.c {
        public e(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.h1.c
        public boolean a() {
            return true;
        }

        @Override // androidx.room.h1.c
        public void b(@g.n0 Set<String> set) {
            if (k1.this.f7455i.get()) {
                return;
            }
            try {
                k1 k1Var = k1.this;
                c1 c1Var = k1Var.f7452f;
                if (c1Var != null) {
                    c1Var.G0(k1Var.f7449c, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException unused) {
            }
        }
    }

    public k1(Context context, String str, Intent intent, h1 h1Var, Executor executor) {
        b bVar = new b();
        this.f7456j = bVar;
        this.f7457k = new c();
        this.f7458l = new d();
        Context applicationContext = context.getApplicationContext();
        this.f7447a = applicationContext;
        this.f7448b = str;
        this.f7450d = h1Var;
        this.f7453g = executor;
        this.f7451e = new e((String[]) h1Var.f7399a.keySet().toArray(new String[0]));
        applicationContext.bindService(intent, bVar, 1);
    }

    public void a() {
        if (this.f7455i.compareAndSet(false, true)) {
            this.f7450d.m(this.f7451e);
            try {
                c1 c1Var = this.f7452f;
                if (c1Var != null) {
                    c1Var.K0(this.f7454h, this.f7449c);
                }
            } catch (RemoteException unused) {
            }
            this.f7447a.unbindService(this.f7456j);
        }
    }
}
