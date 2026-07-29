package h0;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import g.i1;
import g0.a;
import g0.b;

/* JADX INFO: loaded from: classes2.dex */
public class n0 implements ServiceConnection {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public androidx.concurrent.futures.a<Integer> f30171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f30172c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @i1
    @g.p0
    public g0.b f30170a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f30173d = false;

    public class a extends a.b {
        public a() {
        }

        @Override // g0.a
        public void A0(boolean z10, boolean z11) throws RemoteException {
            if (!z10) {
                n0.this.f30171b.p(0);
            } else if (z11) {
                n0.this.f30171b.p(3);
            } else {
                n0.this.f30171b.p(2);
            }
        }
    }

    public n0(@g.n0 Context context) {
        this.f30172c = context;
    }

    public void a(@g.n0 androidx.concurrent.futures.a<Integer> aVar) {
        if (this.f30173d) {
            throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
        }
        this.f30173d = true;
        this.f30171b = aVar;
        this.f30172c.bindService(new Intent(m0.f30166b).setPackage(h0.b(this.f30172c.getPackageManager())), this, 1);
    }

    public void b() {
        if (!this.f30173d) {
            throw new IllegalStateException("bindService must be called before unbind");
        }
        this.f30173d = false;
        this.f30172c.unbindService(this);
    }

    public final g0.a c() {
        return new a();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        g0.b bVarQ0 = b.AbstractBinderC0340b.Q0(iBinder);
        this.f30170a = bVarQ0;
        try {
            bVarQ0.t0(c());
        } catch (RemoteException unused) {
            this.f30171b.p(0);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f30170a = null;
    }
}
